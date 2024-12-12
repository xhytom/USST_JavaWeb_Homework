import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private JdbcUtils() {

    }


    private static String driverClass = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        try {
            InputStream resourceStream = JdbcUtils.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(resourceStream);
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(ResultSet resultSet, PreparedStatement preparedstatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedstatement != null) {
                preparedstatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(PreparedStatement preparedstatement, Connection connection) {
        closeConnection(null, preparedstatement, connection);
        return;
    }
    public static void main(String[] args) {
        System.out.println(driverClass + url + username + password);
    }
}

