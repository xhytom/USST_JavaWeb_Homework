import java.util.ArrayList;
import java.util.Scanner;

public class UserTest {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("1 - 注册");
            System.out.println("2 - 登录");
            System.out.println("3 - 退出");
//            System.out.println("4 - 退出");
            int op = scanner.nextInt();
            if (op == 1) {
                registerUser();
            } else if (op == 2) {
                signInUser();
            } else if (op == 3) {
                System.out.println("退出成功!");
                break;
            } else if (op == 4) {
                queryAllUser();
            }
        }
    }

    public static void queryAllUser() {
        try {
            ArrayList<UserEntity> userEntities = UserService.queryAllUser();
            for (UserEntity user : userEntities) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }
    public static void registerUser(UserEntity user) {
        try {
            UserEntity userEntity = UserService.queryUserByPhone(user);
            if (userEntity != null) {
                System.out.println("用户已存在!");
                return;
            }
            UserService.insertUser(user);
            System.out.println("注册成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void registerUser() {
        String phone, password;
        System.out.println("请输入账号");
        phone = scanner.next();
        System.out.println("请输入密码");
        password = scanner.next();
        UserEntity userEntity = new UserEntity(phone, password);
        registerUser(userEntity);
    }
    public static void signInUser(UserEntity user) {
        try {
            UserEntity userEntity = UserService.queryUserByPhone(user);
            if (userEntity == null) {
                System.out.println("登录失败!");
                return;
            }
            if (userEntity.getPassword().equals(user.getPassword())) {
                System.out.println("登录成功!");
            } else {
                System.out.println("登录失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void signInUser() {
        String phone, password;
        System.out.println("请输入账号");
        phone = scanner.next();
        System.out.println("请输入密码");
        password = scanner.next();
        UserEntity userEntity = new UserEntity(phone, password);
        signInUser(userEntity);
    }
}
