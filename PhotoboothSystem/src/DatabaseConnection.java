import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/theme_park_db?useSSL=false";
    private static  String username = "root";
    private static String password = "123";

    private DatabaseConnection() {

    }

//    public Connection getConnection() {
//        return connection;
//    }

    public static synchronized Connection getInstance() throws SQLException {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);

            } catch (ClassNotFoundException ex) {
                System.out.println("Database Connection Creation Failed : " + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Database Connection Creation Failed : " + ex.getMessage());
            }
        }

        return connection;
    }
}