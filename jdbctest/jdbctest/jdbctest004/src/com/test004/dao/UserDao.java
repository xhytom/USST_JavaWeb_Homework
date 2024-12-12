import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDao {
    public static ArrayList<UserEntity> queryAllUser() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<UserEntity> userEntities = new ArrayList<UserEntity>();
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            String querySql = "select * from user;";
            preparedStatement = connection.prepareStatement(querySql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserEntity retUser = new UserEntity();
                retUser.setId(resultSet.getLong("id"));
                retUser.setPhone(resultSet.getString("phone"));
                retUser.setPassword(resultSet.getString("password"));
                userEntities.add(retUser);
            }
            return userEntities;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(resultSet, preparedStatement, connection);
        }
        return null;
    }
    public static UserEntity queryUserByPhone(UserEntity user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        UserEntity retUser = new UserEntity();
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            String querySql = "select * from user where phone = ?;";
            preparedStatement = connection.prepareStatement(querySql);

            preparedStatement.setString(1, user.getPhone());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                retUser.setId(resultSet.getLong("id"));
                retUser.setPhone(resultSet.getString("phone"));
                retUser.setPassword(resultSet.getString("password"));
                return retUser;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(resultSet, preparedStatement, connection);
        }
        return null;
    }

    public static int insertUser(UserEntity user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int ret = 0;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            String insertSql = "insert into user values " +
                    "(null, ?, ?)";

            preparedStatement = connection.prepareStatement(insertSql);

            preparedStatement.setString(1, user.getPhone());
            preparedStatement.setString(2, user.getPassword());

            ret = preparedStatement.executeUpdate();
            connection.commit();
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(preparedStatement, connection);
        }
        return 0;
    }
}
