package main.java.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.java.tests.PropertiesRead;

public class GoogleHomePage extends BasePage {
	private static final Logger logger = LoggerFactory.getLogger(GoogleHomePage.class);
	private By rejectAll = By.xpath("//button/*[contains(text(),'Reject')]");
    private By searchBox = By.name("q");
    private By searchResults = By.id("search"); 
    

    public GoogleHomePage(WebDriver driver) {
    	super(driver);
    }
     
	public void openURL(String url) {
		driver.get(url);
		try {
			waitAndClickWebElement(rejectAll);  
		}
		catch(Exception e) {
			logger.info("The cookies pop up did not appear");
		}
                    
    }

    public void search(String searchTerm) {
    	waitForVisibilityOfElement(searchBox);
    	enterValueAndSubmit(searchBox, searchTerm);    	
     	
    }
    
    public void verifySearchResults() {
    	waitForVisibilityOfElement(searchResults);    	
    }
    
}
    

