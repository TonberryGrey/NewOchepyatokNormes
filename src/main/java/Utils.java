import java.io.IOException;
import java.util.Properties;

public class Utils {

    public static String getProperty(String propertyName) {
        String property = null;
        try {
            Properties prop = new Properties();
            prop.load(NewOchepyatokNormes.class.getClassLoader().getResourceAsStream("config.properties"));
            property = prop.getProperty(propertyName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return property;
    }

}
