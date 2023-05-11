package sevenrmartSupermarket.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageLocationPage {
	PageUtility pageutility=new PageUtility();
	public WebDriver driver;
	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@type='button']")WebElement cancelButton;
	@FindBy(xpath = "//div[@class='content-wrapper']")WebElement cancelBackPage;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement searchButton;
	@FindBy(xpath = "//button[@name='Search']")WebElement redSearchButton;
	@FindBy(xpath = "//section[@class='content']")WebElement listPageAfterReset;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newButtonLocationAdd;
	@FindBy(xpath = "//input[@id='location']")WebElement enterTheLocationTextBox;
	@FindBy(xpath = "//input[@id='delivery']")WebElement enterDeliveryChargeTextBox;
	@FindBy(xpath = "//button[@type='submit']")WebElement saveButtonToAddLocation;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")WebElement resetButton;
	@FindBy(xpath = "//input[@placeholder='Enter the Location']")WebElement enterLocationToSearch;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alertAfterCreatingAddingNewLocation;
	@FindBy(xpath = "//select[@id='country_id']")	WebElement dropDownCountry;
	@FindBy(xpath="//select[@id='st_id']") WebElement dropDownState;
	By tableValue = By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td");

	public ManageLocationPage clickNewButtonToAddLocation() {
		WaitUtility.waitForClickableByWebElement(driver, newButtonLocationAdd);
		pageutility.clickOnElement(newButtonLocationAdd);
		return this;
	}
	public ManageLocationPage selectCountryFronDropDown() {
		WaitUtility.waitForElement(driver, dropDownCountry);
		pageutility.selectDropdownbyIndex(dropDownCountry, 1);
		return this;
	}
	public ManageLocationPage selectStateFromDropDown() {
		WaitUtility.waitForElement(driver, dropDownState);
		pageutility.selectDropdownbyIndex(dropDownState, 10);
		return this;
	}
	public ManageLocationPage enterLocation(String location) {
		WaitUtility.waitForElement(driver, enterTheLocationTextBox);
		pageutility.enterText(enterTheLocationTextBox, location);
		return this;
	}
	public ManageLocationPage enterDeliveryCharge(String deliverycharge) {
		pageutility.enterText(enterDeliveryChargeTextBox, deliverycharge);
		return this;
	}
	public ManageLocationPage clickSaveButtonToAddLocation() {
		pageutility.clickOnElement(saveButtonToAddLocation);
	    return this;
	}
	public ManageLocationPage clickResetButton() {
		pageutility.clickOnElement(resetButton);
	    return this;
	}
	public boolean alertForAddingLocation() {
		return pageutility.isDisplay(alertAfterCreatingAddingNewLocation);
	}
	public ManageLocationPage clickCancelButton() {
		WaitUtility.waitForClickableByWebElement(driver, cancelButton);
		pageutility.clickOnElement(cancelButton);
		return this;
	}
	public boolean listPageShownAfterCancelling() {
		return pageutility.isDisplay(cancelBackPage);
	}
	public ManageLocationPage clickSearchButton() {
		WaitUtility.waitForClickableByWebElement(driver, searchButton);
		pageutility.clickOnElement(searchButton);
		return this;
	}
	public ManageLocationPage clickRedSearchButton() {
		WaitUtility.waitForClickableByWebElement(driver, redSearchButton);
		pageutility.clickOnElement(redSearchButton);
		return this;
	}
	public boolean pageShownAfterClickingResetIsDisplayed() {
		return pageutility.isDisplay(listPageAfterReset);
	}
	public void enterTheLocationToSearchInTable(String expectedData) {
		pageutility.enterText(enterLocationToSearch, expectedData);
	}
	public boolean searchListLocationTable(String expectedData) throws IOException {
		int flag = 0;
		String actualData = "";
		List<WebElement> tablefull = driver.findElements(tableValue);
		for (WebElement value : tablefull) {
			actualData = value.getText();
			if (actualData.equals(expectedData)) {
				flag = 1;
				break;
			}
		}
		if (flag == 1)
			return true;
		else
			return false;
	}
}
