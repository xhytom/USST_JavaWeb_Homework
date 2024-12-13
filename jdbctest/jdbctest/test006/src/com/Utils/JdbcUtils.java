import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
    private static DataSource dataSource;
    private JdbcUtils() {

    }

    static {
        try {
            Properties properties = new Properties();
            InputStream resourceStream = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(resourceStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(PreparedStatement preparedStatement, Connection connection) {
        closeConnection(null, preparedStatement, connection);
    }

    public static void main(String[] args) {
        Connection c1 = getConnection();
        System.out.println(dataSource);
        for (int i = 1; i <= 10; i++) {
            Connection c = getConnection();
            closeConnection(null, c);
        }
        closeConnection(null, c1);
        System.out.println(dataSource);
    }
}
