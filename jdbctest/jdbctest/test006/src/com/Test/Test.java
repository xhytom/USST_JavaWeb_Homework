import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet;
        for (Long i = 1L; i <= 10L; i++) {
            preparedStatement.setLong(1, i);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("不存在" + i);
                continue;
            }
            Long id = resultSet.getLong("id");
            String phone = resultSet.getString("phone");
            String password = resultSet.getString("password");
            System.out.println(id + ", " + phone + ", " + password);
        }
    }
}
