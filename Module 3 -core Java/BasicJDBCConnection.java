import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicJDBCConnection {
    private static final String DATABASE_URL = "jdbc:sqlite:students.db";

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");

            try (Connection connection = DriverManager.getConnection(DATABASE_URL);
                    Statement statement = connection.createStatement()) {

                statement.executeUpdate("CREATE TABLE IF NOT EXISTS students ("
                        + "id INTEGER PRIMARY KEY, "
                        + "name TEXT NOT NULL, "
                        + "age INTEGER NOT NULL)");

                statement.executeUpdate("INSERT OR IGNORE INTO students VALUES (1, 'Asha', 20)");
                statement.executeUpdate("INSERT OR IGNORE INTO students VALUES (2, 'Vikram', 19)");

                ResultSet resultSet = statement.executeQuery("SELECT id, name, age FROM students");

                System.out.println("Student records:");
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id")
                            + ", Name: " + resultSet.getString("name")
                            + ", Age: " + resultSet.getInt("age"));
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver was not found.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
