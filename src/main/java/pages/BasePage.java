package main.java.pages;

import org.openqa.selenium.WebDriver;

public class BasePage extends Utils {
 
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
    }

}