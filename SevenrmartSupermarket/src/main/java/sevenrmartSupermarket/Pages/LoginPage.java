package sevenrmartSupermarket.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class LoginPage {
	PageUtility pageutility=new PageUtility();;
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@placeholder='Username']")WebElement userNameTextBoxElement;
	@FindBy(xpath = "//input[@placeholder='Password']")WebElement passwordTextBoxElement;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signInButton;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")WebElement userImageButton;
	@FindBy(xpath = "//span[text()=\"7rmart supermarket\"]//preceding::a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement LogOutButton;
	@FindBy(xpath = "//div[@class='content-wrapper']")WebElement homePageFull;
	@FindBy(xpath = "//div[@class='card-body login-card-body']")WebElement signinBox;

	public LoginPage enterUserName(String username) {
		WaitUtility.waitForElement(driver, userNameTextBoxElement);
		pageutility.enterText(userNameTextBoxElement, username);
		return this;
	}
	public LoginPage enterPassword(String password) {
		WaitUtility.waitForElement(driver, passwordTextBoxElement);
		pageutility.enterText(passwordTextBoxElement, password);
		return this;
	}
	public LoginPage clickSignInButton() {
		WaitUtility.waitForClickableByWebElement(driver, signInButton);
		pageutility.clickOnElement(signInButton);
		return this;
	}
	public LoginPage clickUserImageToLogOut() {
		WaitUtility.waitForClickableByWebElement(driver, userImageButton);
		pageutility.clickOnElement(userImageButton);
		return this;
	}
	public LoginPage clickLogOutButton() {
		WaitUtility.waitForClickableByWebElement(driver, LogOutButton);
		pageutility.clickOnElement(LogOutButton);
		return this;
	}
	public boolean isHomePageDisplayed() {
		return pageutility.isDisplay(homePageFull);
	}
	public boolean isSignInBoxDisplayed() {
		return pageutility.isDisplay(signinBox);
	}
}
