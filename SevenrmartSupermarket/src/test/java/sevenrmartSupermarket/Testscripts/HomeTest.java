package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import retry.Retry;
import sevenrmartSupermarket.Pages.HomePage;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class HomeTest extends Base{
	HomePage homepage;
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	
	@Test(retryAnalyzer =Retry.class)
	public void verifySiteNameDisplayedInHomePageIsSameAsExpectedByGettingSiteNameText() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
    	String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String expectedSiteName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"HomePage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		homepage=new HomePage(driver);
		assertTrue(homepage.siteNameisDisplayed(), "site name is not displayed on top");	
		String actualSiteName=homepage.verifySiteNameIsShownAtTop();
		assertEquals(actualSiteName,expectedSiteName,"Site name is given wrong");
	}
	@Test(retryAnalyzer =Retry.class)
	public void verifyCopyRightMessageDisplayedAsFooterInHomePageByGettingFooterMessage() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
    	String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
    	String expectedFooterMessage=ExcelUtility.getString(2,0,GeneralUtility.TESTDATAFILE,"HomePage");
    	loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		homepage=new HomePage(driver);
		homepage.isFooterMessageDisplayedAtBottom();
		String actualFooterMessage=homepage.verifyFooterMessage();
		assertEquals(actualFooterMessage,expectedFooterMessage,"copyright message is not displayed at bottom");		
	}
}
