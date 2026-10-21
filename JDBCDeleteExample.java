
import java.sql.*;

public class JDBCDeleteExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Charani@1";

        String query = "DELETE FROM users WHERE id = ?";

        try (
                Connection con =
                        DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt =
                        con.prepareStatement(query)
        ) {

            // User ID to delete
            pstmt.setInt(1, 2);

            // Execute DELETE query
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No rows were deleted.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
