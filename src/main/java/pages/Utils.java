package main.java.pages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	private static final Logger logger = LoggerFactory.getLogger(Utils.class);
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement elem;
    

	public Utils(WebDriver driver) {
        this.driver = driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitAndClickWebElement(By element) {    
    		elem=waitForVisibilityOfElement(element);
    		scrollToElem(elem);
        	elem.click();
        	return elem;    	
    }

    public WebElement waitForVisibilityOfElement(By element) {
    	try {
    		elem= wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    	}
    	catch (NoSuchElementException e) {
    		logger.info("Element not found: " + e.getMessage());    		    		
    	}   	
    	return elem;
    }
    
    
    public void enterValueIntoTheEditBox(By element,String valueToBeEntered) {    	
    	elem=waitForVisibilityOfElement(element);   	
    	elem.clear();
    	elem.sendKeys(valueToBeEntered);   	    	
    }
    
    public void enterValueAndSubmit(By element,String valueToBeEntered) {   	
    	elem=waitForVisibilityOfElement(element);
    	elem.clear();
    	elem.sendKeys(valueToBeEntered);
    	elem.submit();  	
    	
    }
    
    public void scrollToElem(WebElement elem) {
    	try {
    		elem= wait.until(ExpectedConditions.visibilityOf(elem));
    	}
    	catch (NoSuchElementException e) {
    		logger.info("Element not found: " + e.getMessage());    		    		
    	} 
    	Actions actions = new Actions(driver);
    	actions.moveToElement(elem);
    	actions.perform();
    }
    
    public String getPageSource() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String pageContent = (String) js.executeScript("return document.body.innerText");
        return pageContent.toLowerCase();    	
    }
    
    public String getElementAttr(By elem,String attr) {    	
    	return waitForVisibilityOfElement(elem).getAttribute(attr);
    }
    
    public Boolean VerifyCurrentPageURL(String expectedURL) {
    	String actualURL = driver.getCurrentUrl();
    	assertEquals(actualURL, expectedURL, "URLs do not match, Current URL is + "+actualURL+"Expected URL is: "+expectedURL);
    	return true;
    }
   

}
