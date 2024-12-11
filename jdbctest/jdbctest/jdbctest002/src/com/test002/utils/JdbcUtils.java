import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
    private JdbcUtils() {

    }

//    private String driverClass = "com.mysql.cj.jdbc.Driver";
//    private String url = "jdbc:mysql://127.0.0.1:3306/test";
//    private String user = "root";
//    private String password = "123456";
    private static String driverClass;
    private static String url;
    private static String user;
    private static String password;

    static {
        try {
            InputStream resourceStream = JdbcUtils.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(resourceStream);
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public static void closeConnection(Statement statement, Connection connection) {
        closeConnection(null, statement, connection);
        return;
    }

    public static void main(String[] args) {
        System.out.println(driverClass + url + user + password);
    }
}
