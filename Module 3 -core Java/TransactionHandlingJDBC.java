import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionHandlingJDBC {
    private static final String DATABASE_URL = "jdbc:sqlite:bank.db";

    public static void createAccountsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS accounts ("
                + "account_id INTEGER PRIMARY KEY, "
                + "holder_name TEXT NOT NULL, "
                + "balance REAL NOT NULL)";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
                Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            statement.executeUpdate("INSERT OR IGNORE INTO accounts VALUES (101, 'Asha', 5000)");
            statement.executeUpdate("INSERT OR IGNORE INTO accounts VALUES (102, 'Vikram', 3000)");
        } catch (SQLException e) {
            System.out.println("Setup failed: " + e.getMessage());
        }
    }

    public static void transfer(int fromAccount, int toAccount, double amount) {
        String debitSql = "UPDATE accounts SET balance = balance - ? "
                + "WHERE account_id = ? AND balance >= ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            connection.setAutoCommit(false);

            try (PreparedStatement debitStatement = connection.prepareStatement(debitSql);
                    PreparedStatement creditStatement = connection.prepareStatement(creditSql)) {

                debitStatement.setDouble(1, amount);
                debitStatement.setInt(2, fromAccount);
                debitStatement.setDouble(3, amount);
                int debitRows = debitStatement.executeUpdate();

                creditStatement.setDouble(1, amount);
                creditStatement.setInt(2, toAccount);
                int creditRows = creditStatement.executeUpdate();

                if (debitRows == 1 && creditRows == 1) {
                    connection.commit();
                    System.out.println("Transfer completed successfully.");
                } else {
                    connection.rollback();
                    System.out.println("Transfer failed. Transaction rolled back.");
                }
            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Transfer failed. Transaction rolled back.");
                System.out.println("Reason: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            createAccountsTable();
            transfer(101, 102, 1000);
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver was not found.");
        }
    }
}
