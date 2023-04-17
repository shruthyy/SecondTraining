package sevenrmartSupermarket.Pages;

	import static org.testng.Assert.assertEquals;
	import static org.testng.Assert.assertTrue;

	import java.io.IOException;

import org.openqa.selenium.By;
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
		@FindBy(xpath="//button[text()='Sign In']") WebElement signInButton;
		@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement userImageButton;
		@FindBy (xpath="//span[text()=\"7rmart supermarket\"]//preceding::a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") WebElement LogOutButton;
		
		public void enterUserName(String username){
	         WaitUtility.waitForElement(driver, userNameTextBoxElement);
			 PageUtility.enterText(userNameTextBoxElement,username);
		}
		public boolean signInButtonisEnabled() {
			return PageUtility.isElementEnabled(signInButton);
			
		}
	    public void enterPassword(String password) {
			 WaitUtility.waitForElement(driver, passwordTextBoxElement);
			 PageUtility.enterText(passwordTextBoxElement,password);
	    }
	    public void clickSignInButton(){
			 WaitUtility.waitForClickableByWebElement(driver,signInButton);
	         PageUtility.clickOnElement(signInButton);
	      
		}
	    public boolean logOutButtonisDisplayed() {
	    	return PageUtility.isDisplay(LogOutButton);
	    }
	    public void signIn() throws IOException {
	    	String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LogInDetails");
	    	String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LogInDetails");
	    	PageUtility.enterText(userNameTextBoxElement, userName);
	    	PageUtility.enterText(passwordTextBoxElement, password);
	    	PageUtility.clickOnElement(signInButton);
	    	
	    }
		
		public void signInWithWrongUserName() throws IOException {
			String wrongUserName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidDetails");
			String passwordRight=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidDetails");
			String expectedUrl=ExcelUtility.getString(0,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidDetails");
			PageUtility.enterText(userNameTextBoxElement, wrongUserName);
			PageUtility.enterText(passwordTextBoxElement, passwordRight);
			
			 	
			}
		public void signInWithWrongPassword() throws IOException {
			String userNameRight=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidPassword");
			String wrongPassword=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"InvalidPassword");
			PageUtility.enterText(userNameTextBoxElement, userNameRight);
			PageUtility.enterText(passwordTextBoxElement, wrongPassword);
		}
		public void clickUserImageToLogOut() {
			WaitUtility.waitForClickableByWebElement(driver, userImageButton);
			PageUtility.clickOnElement(userImageButton);
		}
		public void clickLogOutButton() {
			WaitUtility.waitForClickableByWebElement(driver, LogOutButton);
			PageUtility.clickOnElement(LogOutButton);
			
		}


}
