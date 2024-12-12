import java.sql.*;
import java.util.ArrayList;

public class StudentTest {
    public static void queryAllStudent() throws SQLException, ClassNotFoundException {
        ArrayList<StudentEntity> studentEntities = StudentService.allStudent();
        for (StudentEntity stu : studentEntities) {
            System.out.println(stu);
        }
    }
    public static int deleteStudentById(Long id) throws SQLException, ClassNotFoundException {
        return StudentService.deleteStudentById(id);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        queryAllStudent();

//        StudentEntity studentEntity1 = StudentService.queryStudentById(1l);
//        System.out.println(studentEntity1);

//        StudentEntity newStudentEntity = new StudentEntity();
//        newStudentEntity.setId(10l);
//        newStudentEntity.setName("zsc");
//        newStudentEntity.setAge(20);
//        newStudentEntity.setAddress("501");
//        int ret = studentService.addNewStudent(newStudentEntity);
//
//        System.out.println(ret);

//        StudentEntity newStudentEntity = new StudentEntity();
//        newStudentEntity.setId(6l);
//        newStudentEntity.setName("zsc");
//        newStudentEntity.setAge(20);
//        newStudentEntity.setAddress("501");
//        int ret = studentService.updateStudentById(newStudentEntity);
//
//        System.out.println(ret);

        System.out.println(deleteStudentById(3l));
        queryAllStudent();
    }
}
