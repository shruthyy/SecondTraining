package sevenrmartSupermarket.Pages;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import Utilities.PageUtility;
	import Utilities.WaitUtility;

	public class HomePage {
		public WebDriver driver;
		public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
		@FindBy (xpath="//input[@placeholder='Username']") WebElement userNameTextBoxElement;
		@FindBy(xpath="//input[@placeholder='Password']") WebElement passwordTextBoxElement;
		@FindBy(xpath="//button[text()='Sign In']")WebElement signInButton;
		@FindBy(xpath="//span[text()='7rmart supermarket']") WebElement siteName;
		@FindBy(xpath="//li[@class='nav-item']") WebElement menuList;
		@FindBy(xpath="//div[@class='float-right d-none d-sm-inline-block']") WebElement footerMessage;
	public String verifySiteNameIsShownAtTop() {
			WaitUtility.waitForElement(driver, siteName);
			return PageUtility.getElementText(siteName);	
		}
	public boolean siteNameisDisplayed() {
			return PageUtility.isDisplay(siteName);
		}
	public boolean isFooterMessageDisplayedAtBottom() {
		return PageUtility.isDisplay(footerMessage);
	}
	public String verifyFooterMessage() {
		WaitUtility.waitForElement(driver, footerMessage);
		return PageUtility.getElementText(footerMessage);
	}
		
}
