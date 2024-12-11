import com.mysql.jdbc.Driver;

import java.lang.management.ManagementFactory;
import java.sql.*;
import java.util.ArrayList;

public class StudentDao {
    /*
    * 查询所有学生信息
     */

    final String DRIVER = "com.mysql.jdbc.Driver";
    final String SQLURL = "jdbc:mysql://127.0.0.1:3306/test";
    final String SQLUSERNAME = "root";
    final String SQLPASSWORD = "123456";
    public ArrayList<StudentEntity> allStudent() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<StudentEntity> ret = new ArrayList<>();
        try {
            connection = JdbcUtils.getConnection();

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
            JdbcUtils.closeConnection(resultSet, statement, connection);

            return ret;
        }
    }

    public StudentEntity queryStudentById(Long stuId) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        StudentEntity studentEntity = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();

            String sql = "select * from student where id = " + stuId.toString();

            resultSet = statement.executeQuery(sql);

            if (!resultSet.next()) {
                return null;
            }

            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            Integer age = resultSet.getInt("age");

            studentEntity = new StudentEntity(id, name, address, age);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtils.closeConnection(resultSet, statement, connection);

            return studentEntity;
        }
    }
    public int addNewStudent(StudentEntity stu) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        int ret = 0;
        try {
            connection = JdbcUtils.getConnection();

            statement = connection.createStatement();
            String sql = "insert into student values" +
                    "(" + stu.getId() + ", '" + stu.getName() + "', '" + stu.getAddress() + "', " + stu.getAge() + ");";
            ret = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            JdbcUtils.closeConnection(statement, connection);
            return ret;
        }
    }

    public int updateStudentById(StudentEntity stu) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        StudentEntity studentEntity = null;
        int ret = 0;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();

            String sql = "update student " +
                    "set name = '" + stu.getName() + "', address = '" + stu.getAddress() + "', age = " + stu.getAge().toString() + " " +
                    "where id = " + stu.getId().toString();
            System.out.println(sql);
            ret = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            JdbcUtils.closeConnection(statement, connection);
            return ret;
        }
    }
}
