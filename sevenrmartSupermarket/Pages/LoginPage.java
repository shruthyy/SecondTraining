package sevenrmartSupermarket.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.ExcelUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//input[@placeholder='Username']") WebElement userNameTextBoxElement;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement passwordTextBoxElement;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signInButton;
	@FindBy(xpath="//label[@for='remember']") WebElement rememberMeCheckBox;
	@FindBy(xpath="//div[@class='wrapper']") WebElement homePageContent;
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement userImageButton;
	@FindBy (xpath="//span[text()=\"7rmart supermarket\"]//preceding::a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") WebElement LogOutButton;
	
	public void signInAccountVerification(String username,String password ) {
         WaitUtility.waitForElement(driver, userNameTextBoxElement);
		 PageUtility.enterText(userNameTextBoxElement,username);
		 WaitUtility.waitForElement(driver, passwordTextBoxElement);
		 PageUtility.enterText(passwordTextBoxElement,password);
		 WaitUtility.waitForClickableByWebElement(driver, rememberMeCheckBox);
		 PageUtility.clickOnElement(rememberMeCheckBox);
		 boolean isSignInButtonEnabled=PageUtility.isElementEnabled(signInButton);
		 Assert.assertTrue(isSignInButtonEnabled, "SignIn button is not enabled");
		 PageUtility.clickOnElement(signInButton);
		 boolean isHomePageDisplayed=PageUtility.isElementDisplayed(homePageContent);
		 assertTrue(isHomePageDisplayed, "SignIn is not successful");
	}
	
	public void signInWithWrongUserName() throws IOException {
		String wrongUserName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidDetails");
		String passwordRight=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidDetails");
		String expectedUrl=ExcelUtility.getString(0,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidDetails");
		PageUtility.enterText(userNameTextBoxElement, wrongUserName);
		PageUtility.enterText(passwordTextBoxElement, passwordRight);
		 boolean isSignInButtonEnabled=PageUtility.isElementEnabled(signInButton);
		 Assert.assertTrue(isSignInButtonEnabled, "SignIn button is not enabled");
		 PageUtility.clickOnElement(signInButton);
		 String actualUrl=driver.getCurrentUrl();
		 assertEquals(actualUrl,expectedUrl,"Not in the signIn page");	
		}
	public void signInWithWrongPassword() throws IOException {
		String userNameRight=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidPassword");
		String wrongPassword=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidPassword");
		String expectedUrl=ExcelUtility.getString(0,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidPassword");
		PageUtility.enterText(userNameTextBoxElement, userNameRight);
		PageUtility.enterText(passwordTextBoxElement, wrongPassword);
		 boolean isSignInButtonEnabled=PageUtility.isElementEnabled(signInButton);
		 Assert.assertTrue(isSignInButtonEnabled, "SignIn button is not enabled");
		 PageUtility.clickOnElement(signInButton);
		 String actualUrl=driver.getCurrentUrl();
		 assertEquals(actualUrl,expectedUrl,"Not in the signIn page");	
	}
	public void logoutVerification() throws IOException {
		String expectedUrl=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LogOutVerify");
		PageUtility.clickOnElement(userImageButton);
		boolean isLogoutButtonAvailable=PageUtility.isElementDisplayed(LogOutButton);
		assertTrue(isLogoutButtonAvailable, "Logout button is not displayed");
		boolean isLogoutButtonEnabled=PageUtility.isElementEnabled(LogOutButton);
		Assert.assertTrue(isLogoutButtonEnabled, "Logout button is not enabled");
		PageUtility.clickOnElement(LogOutButton);
		String actualUrl=driver.getCurrentUrl();
		assertEquals(actualUrl,expectedUrl,"LogOut not successful");
	}

}
