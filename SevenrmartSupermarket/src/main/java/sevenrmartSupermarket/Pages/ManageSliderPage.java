package sevenrmartSupermarket.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageSliderPage {
	public WebDriver driver;
	public ManageSliderPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[10]/a") WebElement manageSliderMenu;
	@FindBy(xpath="//h1[text()='List Sliders']") WebElement listSlidersText;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']") WebElement newButton ;
	@FindBy(xpath="//input[@id='link']") WebElement link;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/status?id=448&st=inactive&page_ad=1']//following::span[@class='badge bg-success']") WebElement statusButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement statusChangedSuccessfullyAlert;
	@FindBy(xpath="//li[@class='breadcrumb-item']") WebElement homeButtonInListSliderPage;
	@FindBy(xpath="//div[@class='content-wrapper']") WebElement navigatedHomePage;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/slider/delete?del=469&page_ad=1']") WebElement deleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertShownAfterDelete;
	public void clickDelete() {
		WaitUtility.waitForClickableByWebElement(driver, deleteButton);
	    PageUtility.clickOnElement(deleteButton);
	}
	public ManageSliderPage clickNewButton(){
		WaitUtility.waitForClickableByWebElement(driver, newButton);
		PageUtility.clickOnElement(newButton);
		return this;
	}
	public ManageSliderPage enterLinkToLinkTextBox(String newlink) {
		WaitUtility.waitForClickableByWebElement(driver, link);
		PageUtility.enterText(link, newlink);
		return this;
	}
	public ManageSliderPage clickSaveButton() {
		WaitUtility.waitForClickableByWebElement(driver, saveButton);
		PageUtility.clickOnElement(saveButton);
		return null;
	}

	public boolean listSliderPageisDisplayed() {
		return PageUtility.isDisplay(listSlidersText);
	}

	public boolean alertisDisplayed() {
		return PageUtility.isDisplay(alert);
	}
	public boolean alertStatusChangeisDisplayed() {
		return PageUtility.isDisplay(statusChangedSuccessfullyAlert);
	}
	public void clickStatusButton() {
		WaitUtility.waitForClickableByWebElement(driver, statusButton);
		PageUtility.clickOnElement(statusButton);
	}
	public void clickHomeButtonFromListSliderPage() {
		WaitUtility.waitForClickableByWebElement(driver, homeButtonInListSliderPage);
		PageUtility.clickOnElement(homeButtonInListSliderPage);
	}
	public boolean isHomePageDisplayedAfterClickingHomeButton() {
		return PageUtility.isDisplay(homeButtonInListSliderPage);
	}
	public boolean isDeleteAlertDisplayed() {
		return PageUtility.isDisplay(alertShownAfterDelete);
	}
}

