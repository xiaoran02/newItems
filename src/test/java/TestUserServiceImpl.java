import com.news.entity.User;
import com.news.service.UserService;
import com.news.service.impl.UserServiceImpl;

import java.sql.SQLException;

public class TestUserServiceImpl {
    public static void main(String[] args) {
        //创建UserServiceImpl类
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setUname("admin");
        user.setUpwd("admin");
        try {
            User user1 = userService.doLogin(user);
            System.out.println(user1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
