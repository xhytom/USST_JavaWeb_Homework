import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentService {

    private StudentDao studentDao = new StudentDao();
    public ArrayList<StudentEntity> allStudent() throws SQLException, ClassNotFoundException {
        ArrayList<StudentEntity> studentEntities = studentDao.allStudent();
        return studentEntities;
    }
    public StudentEntity queryStudentById(Long stuId) throws SQLException, ClassNotFoundException {
        StudentEntity studentEntity = studentDao.queryStudentById(stuId);
        return studentEntity;
    }
    public int addNewStudent(StudentEntity stu) throws SQLException, ClassNotFoundException {
        int ret = studentDao.addNewStudent(stu);
        return ret;
    }
}