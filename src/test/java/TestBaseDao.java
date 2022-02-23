import com.news.dao.BaseDao;
import com.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;

public class TestBaseDao {

    public static void main(String[] args) {
//        Connection connection = DataBaseUtil.getConnection();
//        BaseDao baseDao = new BaseDao(connection);
//        int result = baseDao.executeUpdate("insert into news_users(uname,upwd)" +
//                "values(?,?)", "teacher","123123");
//        System.out.println(result);

        //测试查询操作
        Connection connection = DataBaseUtil.getConnection();
        // 创建BaseDao对象
        BaseDao baseDao = new BaseDao(connection);

        try {

            ResultSet resultSet = baseDao.excuteQuery("select * from news_users");
            //遍历结果集
            while (resultSet.next()){
                int uid = resultSet.getInt("uid");
                String uname = resultSet.getString("uname");
                System.out.println(uid + uname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
