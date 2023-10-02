package test.java.tests;

import static org.testng.AssertJUnit.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import main.java.pages.GoogleHomePage;
import main.java.pages.SearchResultsPage;

public class GoogleSearchTest extends BaseTest {

	private static final Logger logger = LoggerFactory.getLogger(GoogleSearchTest.class);
    private GoogleHomePage googleHomePage;
    private SearchResultsPage searchResultsPage;
    private String pageSource;
    private String url;

    @BeforeMethod
    public void initializeObjects() {
        googleHomePage = new GoogleHomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }
    
    @Test(description = "Searching a phrase in Google and clicking on the first ad-free link, and then verify the phrase")
    public void searchAndClickFirstOrganicResult() {    	
    	
    	url= PropertiesRead.getProperty("url");
        googleHomePage.openURL(url);
        logger.info("Opened the url: "+ url);
        
        String searchText = PropertiesRead.getProperty("searchItem");
        googleHomePage.search(searchText);
        logger.info("Searching a phrase: "+searchText);
        
        searchResultsPage.verifySearchResults();
        logger.info("Verified that the search results appeared for the searched phrase");
               
        String expected_url = searchResultsPage.getExpectedURL();
        searchResultsPage.clickFirstLinkWithoutAd();
        logger.info("Clicked on the first Ad-Free link");

        assertTrue("The page was not opened by clicking on the first link.", searchResultsPage.verifyFirstPageOpenedCorrectly(expected_url));       
        logger.info("Verified that the correct URL opened for the searched phrase ");
        
        
        pageSource= searchResultsPage.getPageSource();     
      
        String[] searchWords = searchText.toLowerCase().split("\\s+");
        for (String word : searchWords) {
            assertTrue("Search word '" + word + "' is not present on the page.", pageSource.contains(word));
        }        
        logger.info("The searched phrase " +searchText+ " was found in the webpage opened");
        
    }
}
