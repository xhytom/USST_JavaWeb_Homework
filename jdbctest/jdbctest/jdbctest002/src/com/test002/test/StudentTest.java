import java.sql.*;
import java.util.ArrayList;

public class StudentTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        StudentService studentService = new StudentService();
        ArrayList<StudentEntity> studentEntities = studentService.allStudent();
        for (StudentEntity stu : studentEntities) {
            System.out.println(stu);
        }
    }
}
