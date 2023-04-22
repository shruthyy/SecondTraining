package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import sevenrmartSupermarket.Pages.LoginPage;

public class LoginTest extends Base{
	LoginPage loginpage;
	
	@Test(dataProvider = "LoginProvider")
	public void verify_login_with_Credentials(String username,String password) throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password).clickSignInButton();
		assertTrue(loginpage.isHomePageDisplayed(),"Login not success");
		}
		@DataProvider(name="LoginProvider")
	    public Object[][] getDataFromDataprovider(){
			return new Object[][] 
	    	{
	            {"admin","admin"}
	           
	        };
		}
	@Test(retryAnalyzer =Retry.class)
	public void verifyLogout() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		loginpage.clickUserImageToLogOut().clickLogOutButton();
		assertTrue(loginpage.isSignInBoxDisplayed(),"LogOut not success");	
		}
	
}
