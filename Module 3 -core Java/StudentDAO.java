import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
    private static final String DATABASE_URL = "jdbc:sqlite:students.db";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                + "id INTEGER PRIMARY KEY, "
                + "name TEXT NOT NULL, "
                + "age INTEGER NOT NULL)";

        try (Connection connection = getConnection();
                Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Table creation failed: " + e.getMessage());
        }
    }

    public void insertStudent(int id, String name, int age) {
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println("Student inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    public void updateStudent(int id, String name, int age) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("No student found with ID " + id + ".");
            }
        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            StudentDAO dao = new StudentDAO();

            dao.createTable();
            dao.insertStudent(3, "Neha", 21);
            dao.updateStudent(3, "Neha Sharma", 22);
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver was not found.");
        }
    }
}
