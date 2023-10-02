package main.java.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
    
    	String headless = System.getProperty("headless", "false");
    	
        
        if (driver == null) { 
        	ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications"); // Disable notifications (optional)
            options.addArguments("--disable-popup-blocking"); // Disable pop-up blocking
            options.addArguments("--disable-infobars"); // Disable info bars
            options.addArguments("start-maximized"); // Maximize the window
            options.addArguments("--lang=en-US");   
            options.addArguments("--translate-script-type=gts");
            options.addArguments("--disable-cookies");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-plugins-discovery");
            options.addArguments("--disable-plugins");            
            options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
            if (Boolean.parseBoolean(headless)) {
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
            }

            WebDriverManager.chromedriver().setup(); // Automatically downloads and sets up ChromeDriver
            driver = new ChromeDriver(options);
        }
        return driver;
    }

   
}
