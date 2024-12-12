import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentService {
    public static ArrayList<StudentEntity> allStudent() throws SQLException, ClassNotFoundException {
        ArrayList<StudentEntity> studentEntities = StudentDao.allStudent();
        return studentEntities;
    }
    public StudentEntity queryStudentById(Long stuId) throws SQLException, ClassNotFoundException {
        StudentEntity studentEntity = StudentDao.queryStudentById(stuId);
        return studentEntity;
    }
    public int addNewStudent(StudentEntity stu) throws SQLException, ClassNotFoundException {
        int ret = StudentDao.addNewStudent(stu);
        return ret;
    }

    public int updateStudentById(StudentEntity stu) throws SQLException, ClassNotFoundException {
        int ret = StudentDao.updateStudentById(stu);
        return ret;
    }

    public static int deleteStudentById(Long id) throws SQLException, ClassNotFoundException {
        int ret = StudentDao.deleteStudentById(id);
        return ret;
    }
}