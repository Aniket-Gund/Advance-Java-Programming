import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/?user=root"; // Your database URL
        String user = "root"; // Your database username
        String password = "Root"; // Your database password

        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection(url, user, password);

            // Insert data into a table
            String insertQuery = "INSERT INTO users (name, age) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, "John Doe");
            insertStatement.setInt(2, 30);
            int rowsInserted = insertStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully.");
            }

            // Display data from the table
            String selectQuery = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("name") +
                                   ", Age: " + resultSet.getInt("age"));
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
