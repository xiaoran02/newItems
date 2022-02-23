import com.news.util.configManager;

public class TestConfigManager {

    public static void main(String[] args) {
        String driver = configManager.getProperty("driver");
        System.out.println(driver);
    }
}
