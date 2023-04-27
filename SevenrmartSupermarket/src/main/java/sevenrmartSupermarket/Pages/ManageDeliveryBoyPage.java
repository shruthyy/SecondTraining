package sevenrmartSupermarket.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver) {
	this.driver=driver;
    PageFactory.initElements(driver,this);
    }
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add']") WebElement newButtonToAddDeliveryBoy;
	@FindBy(xpath="//input[@placeholder='Enter the Name']") WebElement enterNameTextBox;
	@FindBy(xpath="//input[@id='password']")WebElement enterPasswordTextBox;
	@FindBy(xpath="//input[@placeholder='Enter the Username']")WebElement enterUsernameTextBox;
	@FindBy(xpath="//button[@name='create']")WebElement saveButtonToAddDeliveryBoy;
	@FindBy(xpath="//a[@type='button']") WebElement cancelButton;
    @FindBy(xpath="//div[@class='content-header']") WebElement listDeliveryBoyPageAfterCancel;
    @FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchButton;
    @FindBy(xpath="//input[@placeholder='Phone Number']") WebElement phNumTextBox;
    @FindBy(xpath="//button[@name='Search']") WebElement redSearchButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']")WebElement searchWithPhoneResult;
    By TableValuesBy=By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td");
	By SearchTableBy=By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td");
    
    public ManageDeliveryBoyPage clickNewButtonToAddDeliveryBoy() {
		PageUtility.clickOnElement(newButtonToAddDeliveryBoy);
		return this;
	}
	public ManageDeliveryBoyPage enterNameToAddNewDeliveryBoy(String name) {
		PageUtility.enterText(enterNameTextBox, name);
		return this;
	}
	public ManageDeliveryBoyPage enterPasswordToAddNewDeliveryBoy(String passwordnew) {
		PageUtility.enterText(enterPasswordTextBox, passwordnew);
		return this;
	}
	public ManageDeliveryBoyPage enterUsernameToAddNewDeliveryBoy(String username) {
		PageUtility.enterText(enterUsernameTextBox, username);
		return this;
	}
	public void clickSaveButtonToAddDeliveryBoy() {
		WaitUtility.waitForClickableByWebElement(driver, saveButtonToAddDeliveryBoy);
		PageUtility.submit(saveButtonToAddDeliveryBoy);	
	}
	public void isSearchWithPhoneNumberResultDisplayed() {
		PageUtility.isDisplay(searchWithPhoneResult);
	}
	public void clickRedSearchButton() {
		PageUtility.clickOnElement(redSearchButton);
	}
	public void clickCancelButton() {
		WaitUtility.waitForClickableByWebElement(driver, cancelButton);
		PageUtility.submit(cancelButton);
	}
	public void clickSearchButton() {
		PageUtility.clickOnElement(searchButton);
	}
	public void enterPhNumbToTextBox(String phone) {
		PageUtility.enterText(phNumTextBox, phone);
	}
	public boolean isListDeliveryBoyPagDisplayedAfterCancel() {
		return PageUtility.isDisplay(listDeliveryBoyPageAfterCancel);
	}
	
	public boolean searchInTheTable(String deliveryboynew) {
		String offercodeText="";
		List<WebElement> columnElements=driver.findElements(TableValuesBy);
		for (WebElement columnElement:columnElements) {
	    offercodeText= columnElement.getText();
	    break;
		}
		if(offercodeText.equalsIgnoreCase(deliveryboynew))
			return true;
		else 

			return false;

		}		
	public boolean searchByPhoneNumber(String phone ) {
		String phoneText="";
		List<WebElement> columnElements=driver.findElements(SearchTableBy);
		for (WebElement columnElement:columnElements) {
	    phoneText= columnElement.getText();
	    break;
		}
		if(phoneText.equalsIgnoreCase(phone))
			return true;
		else 
			return false;
		}		

}
