package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import retry.Retry;
import sevenrmartSupermarket.Pages.LoginPage;

public class LoginTest extends Base{
	LoginPage loginpage;
	
	@Test(dataProvider = "LoginProvider")
	public void verifyHomepageIsDisplayedAfterClickingSiginButtonWithValidUsernameAndValidPassword(String datausername,String datapassword) throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(datausername).enterPassword(datapassword).clickSignInButton();
		assertTrue(loginpage.isHomePageDisplayed(),"Homepage not displayed after login with valid credentials");
		}
		@DataProvider(name="LoginProvider")
	    public Object[][] getDataFromDataprovider(){
			return new Object[][] 
	    	{
	            {"admin","admin"},
	        };
		}
	@Test(retryAnalyzer =Retry.class)
	public void verifyLogInPageIsDisplayedAfterClickingLogoutButtonFromHomePage() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		loginpage.clickUserImageToLogOut().clickLogOutButton();
		assertTrue(loginpage.isSignInBoxDisplayed(),"LogIn page not displayed after logout from homepage");	
		}
}
