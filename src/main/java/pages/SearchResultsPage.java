package main.java.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SearchResultsPage extends BasePage {

    private WebDriver driver;
    private By rejectAll = By.xpath("//button/*[contains(text(),'Reject')]");
    private By searchBox = By.name("q");
    public By searchResults = By.id("search");
    public By adFreeFirstLink = By.cssSelector("#search a");
    
    public SearchResultsPage(WebDriver driver) {	
    	super(driver);

    }
     
	public void openGoogle() {
        driver.get("https://www.google.com/en");
        waitAndClickWebElement(rejectAll);    
        
    }

    public void search(String searchTerm) {
    	waitForVisibilityOfElement(searchBox);
    	enterValueAndSubmit(searchBox, searchTerm);    	
    }
    
    public void verifySearchResults() {
    	waitForVisibilityOfElement(searchResults);
    }
    
    public String getExpectedURL() {
    	return getElementAttr(adFreeFirstLink, "href");
    }
    
    public void clickFirstLinkWithoutAd() {
    	waitAndClickWebElement(adFreeFirstLink);    	
    }    
    
    
    public Boolean verifyFirstPageOpenedCorrectly(String expected_url) {   	
    	VerifyCurrentPageURL(expected_url);
    	return true;
    }
    
}
