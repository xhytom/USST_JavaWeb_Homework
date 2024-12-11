import java.sql.*;
import java.util.ArrayList;

public class StudentTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        StudentService studentService = new StudentService();
        ArrayList<StudentEntity> studentEntities = studentService.allStudent();
        for (StudentEntity stu : studentEntities) {
            System.out.println(stu);
        }

        StudentEntity studentEntity1 = studentService.queryStudentById(1l);
        System.out.println(studentEntity1);

        StudentEntity newStudentEntity = new StudentEntity();
        newStudentEntity.setId(10l);
        newStudentEntity.setName("zsc");
        newStudentEntity.setAge(20);
        newStudentEntity.setAddress("501");
        int ret = studentService.addNewStudent(newStudentEntity);

        System.out.println(ret);
    }
}
