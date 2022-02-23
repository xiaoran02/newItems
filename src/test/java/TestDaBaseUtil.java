import com.news.util.DataBaseUtil;

import java.sql.Connection;

public class TestDaBaseUtil {
    public static void main(String[] args) {
        Connection connection = DataBaseUtil.getConnection();
        System.out.println(connection);
    }

}
