package sevenrmartSupermarket.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageSliderPage {
	PageUtility pageutility=new PageUtility();
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
	@FindBy(xpath="//input[@id='main_img']") WebElement chooseFileImage;
	@FindBy(xpath="//a[@type='button']") WebElement cancelButton;
	@FindBy(xpath="//div[@class='container-fluid']") WebElement listSliderPageDisplayedAfterCancelling;
	
	public ManageSliderPage  uploadImageToAddSlider() {
		chooseFileImage.sendKeys("C:\\Users\\PROJECTS\\OneDrive\\Desktop\\firstcryImg.jpg");
		chooseFileImage.submit();
		return this;
	}
	public String toGetBackgroundColourOfNewButton() {
		return pageutility.getCssValue(newButton);
	}
	public ManageSliderPage clickCancelButton() {
		WaitUtility.waitForClickableByWebElement(driver, cancelButton);
		pageutility.clickOnElement(cancelButton);
		return this;
	}
	public void clickDelete() {
		WaitUtility.waitForClickableByWebElement(driver, deleteButton);
		pageutility.clickOnElement(deleteButton);
	}
	public ManageSliderPage clickNewButton(){
		WaitUtility.waitForClickableByWebElement(driver, newButton);
		pageutility.clickOnElement(newButton);
		return this;
	}
	public ManageSliderPage enterLinkToLinkTextBox(String newlink) {
		WaitUtility.waitForClickableByWebElement(driver, link);
		pageutility.enterText(link, newlink);
		return this;
	}
	public ManageSliderPage clickSaveButton() {
		WaitUtility.waitForClickableByWebElement(driver, saveButton);
		pageutility.clickOnElement(saveButton);
		return null;
	}
	public boolean listSliderPageisDisplayed() {
		return pageutility.isDisplay(listSlidersText);
	}
	public boolean isListSliderPageDisplayedAfterClickingCancelButton() {
		return pageutility.isDisplay(listSliderPageDisplayedAfterCancelling);
	}
	public boolean alertisDisplayed() {
		return pageutility.isDisplay(alert);
	}
	public boolean alertStatusChangeisDisplayed() {
		return pageutility.isDisplay(statusChangedSuccessfullyAlert);
	}
	public void clickStatusButton() {
		WaitUtility.waitForClickableByWebElement(driver, statusButton);
		pageutility.clickOnElement(statusButton);
	}
	public void clickHomeButtonFromListSliderPage() {
		WaitUtility.waitForClickableByWebElement(driver, homeButtonInListSliderPage);
		pageutility.clickOnElement(homeButtonInListSliderPage);
	}
	public boolean isHomePageDisplayedAfterClickingHomeButton() {
		return pageutility.isDisplay(homeButtonInListSliderPage);
	}
	public boolean isDeleteAlertDisplayed() {
		return pageutility.isDisplay(alertShownAfterDelete);
	}
}

