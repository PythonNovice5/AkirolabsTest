package test.java.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import main.java.pages.Driver;


public class BaseTest extends Driver{
	public WebDriver driver;
	
	@BeforeClass
    public void setUp() {
		driver = Driver.getDriver();
        
    }
	
	@AfterClass
	public void tearDown() {
	    if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
	
	
}
