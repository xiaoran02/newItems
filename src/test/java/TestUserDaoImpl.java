import com.news.dao.impl.UserDaoImpl;
import com.news.entity.User;
import com.news.util.DataBaseUtil;

import java.sql.SQLException;

public class TestUserDaoImpl {
    public static void main(String[] args) {
        //创建UserDaoImpl类
        UserDaoImpl userDao = new UserDaoImpl(DataBaseUtil.getConnection());

        try {
            User user = userDao.findUser("admin", "admin");
            System.out.println(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
