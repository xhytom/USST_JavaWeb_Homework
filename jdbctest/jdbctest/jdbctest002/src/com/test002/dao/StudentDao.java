import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao {
    /*
    * 查询所有学生信息
     */
    public ArrayList<StudentEntity> allStudent() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<StudentEntity> ret = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123456");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from student;");
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Integer age = resultSet.getInt("age");
                StudentEntity studentEntity = new StudentEntity(id, name, address, age);
                ret.add(studentEntity);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            /*
            释放jdbc资源
             */
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

            return ret;
        }
    }
}
