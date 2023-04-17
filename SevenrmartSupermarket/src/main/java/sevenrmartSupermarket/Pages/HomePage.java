package sevenrmartSupermarket.Pages;



	import java.io.IOException;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.Assert;

	import Utilities.ExcelUtility;
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
		@FindBy(css="a.small-box-footer[href='https://groceryapp.uniqassosiates.com/admin/list-location']") WebElement ManageLocation;

		public String verifySiteNameIsShownAtTop() throws IOException {
			WaitUtility.waitForElement(driver, siteName);
			return PageUtility.getElementText(siteName);
			
		}
		public boolean siteNameisDisplayed() {
			return PageUtility.isDisplay(siteName);
			
		}
		public void clickManageLocation(){
			PageUtility.clickOnElement(ManageLocation);
			
		}
	
}
