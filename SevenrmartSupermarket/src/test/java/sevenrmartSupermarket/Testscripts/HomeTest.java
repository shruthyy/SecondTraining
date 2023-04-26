package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;
import Utilities.ExcelUtility;
import sevenrmartSupermarket.Pages.HomePage;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;


public class HomeTest extends Base{
	HomePage homepage;
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	
	@Test(retryAnalyzer =Retry.class)
	public void checkSiteNameIsDisplayedInHomePage() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
    	String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String expectedSiteName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"HomePage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		homepage=new HomePage(driver);
		assertTrue(homepage.siteNameisDisplayed(), "site name is not displayed on top");	
		String actualSiteName=homepage.verifySiteNameIsShownAtTop();
		assertEquals(actualSiteName,expectedSiteName,"Site name is given wrong");
	}
}
