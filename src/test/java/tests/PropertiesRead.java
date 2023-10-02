package test.java.tests;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesRead {

   private static Properties prop = new Properties();

   static {
       try (InputStream input = PropertiesRead.class.getClassLoader().getResourceAsStream("config.properties")) {
           prop.load(input);
       } catch (IOException ex) {
           ex.printStackTrace();
       }
   }

   public static String getProperty(String key) {
       return prop.getProperty(key);
   }
}
