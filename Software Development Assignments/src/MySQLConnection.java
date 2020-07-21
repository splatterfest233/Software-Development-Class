import java.sql.*;
public class MySQLConnection {

	/**
	 * Get Connection for MySQL Database
	 */
	public static Connection getConnection() throws SQLException{
		Connection conn = null;

        try {
            // assign db parameters
            String url = "jdbc:mysql://localhost:3306/mysqljdbc";
            String user = "root";
            String password = "Axqh233!";
            
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
	}
}
