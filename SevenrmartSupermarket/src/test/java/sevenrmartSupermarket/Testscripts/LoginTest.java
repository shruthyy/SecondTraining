package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.PageUtility;
import sevenrmartSupermarket.Pages.LoginPage;

public class LoginTest extends Base{
	LoginPage loginpage;
	@Test(priority=1)
	@Parameters({"username","password"})
	public void verifyLogin( String username,String password) throws IOException {
		 String expectedUrl=ExcelUtility.getString(0,3,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LogInDetails");
		 loginpage=new LoginPage(driver);
		 loginpage.enterUserName(username);
		 loginpage.enterPassword(password);
		 boolean isSignInButtonEnabledOrNot=loginpage.signInButtonisEnabled();
		 assertTrue(isSignInButtonEnabledOrNot, "SignIn button is not enabled");
		 loginpage.clickSignInButton();
		 String actualUrl=driver.getCurrentUrl();
		 assertEquals(actualUrl,expectedUrl,"Not in the signIn page");	 
	}
	@Test(priority=3)
	public void loginWithInvalidUserName() throws IOException {
		 String expectedUrl=ExcelUtility.getString(0,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidDetails");
		 loginpage=new  LoginPage(driver);
		 boolean isSignInButtonEnabledOrNot=loginpage.signInButtonisEnabled();
		 assertTrue(isSignInButtonEnabledOrNot, "SignIn button is not enabled");
		 loginpage.signInWithWrongUserName();
		 loginpage.clickSignInButton();
		 String actualUrl=driver.getCurrentUrl();
		 assertEquals(actualUrl,expectedUrl,"Not in the signIn page");
	}
	@Test(priority=2)
	public void loginWithInvalidPassword() throws IOException {
		 String expectedUrl=ExcelUtility.getString(0,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidPassword");
		 loginpage=new LoginPage(driver);
		 boolean isSignInButtonEnabledOrNot=loginpage.signInButtonisEnabled();
		 assertTrue(isSignInButtonEnabledOrNot, "SignIn button is not enabled");
		 loginpage.signInWithWrongPassword();
		 loginpage.clickSignInButton();
		 String actualUrl=driver.getCurrentUrl();
		 assertEquals(actualUrl,expectedUrl,"Not in the signIn page");	
	}
	@Test(priority=4)
	public void verifyLogout() throws IOException {
		String expectedUrl=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LogOutVerify");
		loginpage=new LoginPage(driver);
		loginpage.signIn();
		loginpage.clickUserImageToLogOut();
		boolean isLogoutButtonDisplayedOrNot=loginpage.logOutButtonisDisplayed();
		assertTrue(isLogoutButtonDisplayedOrNot, "Logout button is not displayed");
		loginpage.clickLogOutButton();
		String actualUrl=driver.getCurrentUrl();
		assertEquals(actualUrl,expectedUrl,"LogOut not successful");
	}
	//@Test(dataProvider="LoginProvider")
	public void loginUsingDataProvider(String usernamedp,String passworddp) {
		loginpage.enterUserName(usernamedp);
		loginpage.enterPassword(passworddp);
		loginpage.clickSignInButton();
	}
	@DataProvider(name="LoginProvider")
	public Object[][] getDataFromTestData(){
		return new Object[][] 
				{
			{"admin","admin"},
			{"adssm","admin"},
			{"admin","add"},
			{"123admin","admin123"}
			};
	}
}
