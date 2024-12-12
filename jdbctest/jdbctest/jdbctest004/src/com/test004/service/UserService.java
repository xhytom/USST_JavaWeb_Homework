import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserService {
    public static ArrayList<UserEntity> queryAllUser() {
        ArrayList<UserEntity> userEntities = UserDao.queryAllUser();
        return userEntities;
    }
    public static UserEntity queryUserByPhone(UserEntity user) {
        UserEntity userEntity = UserDao.queryUserByPhone(user);
        return userEntity;
    }

    public static int insertUser(UserEntity user) {
        int ret = UserDao.insertUser(user);
        return ret;
    }
}