package sevenrmartSupermarket.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManagePaymentPage {
	public WebDriver driver;
	public ManagePaymentPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-payment-methods?edit=1&page_ad=1']") WebElement debitUpdateButton;
	@FindBy(xpath="//input[@id='limit']") WebElement debitPayLimitTextBox;
	@FindBy(xpath="//button[@name='Update']") WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertWhenUpdateIsDone;
	@FindBy(xpath="//span[@class='badge bg-success']") WebElement debitStatusButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertWhenStatusIsChanged;
	@FindBy(xpath="//button[@name='Update']//following::a[text()='Reset']") WebElement resetButton;
	@FindBy(xpath="//div[@class='content-header']") WebElement afterResetPage;
	public ManagePaymentPage clickDebitUpdateButton() {
		WaitUtility.waitForClickableByWebElement(driver, debitUpdateButton);
		PageUtility.clickOnElement(debitUpdateButton);
		return this;
	}
	public ManagePaymentPage changeValueInDebitPayLimitTextBox(String amount) {
		WaitUtility.waitForElement(driver, debitPayLimitTextBox);
		PageUtility.enterText(debitPayLimitTextBox, amount);
		return this;
	}
	public ManagePaymentPage clickUpdate() {
		WaitUtility.waitForClickableByWebElement(driver, updateButton);
		PageUtility.clickOnElement(updateButton);
		return this;
	}
	public boolean isAlertShownWhenUpdationIsDone() {
		return PageUtility.isDisplay(alertWhenUpdateIsDone);
	}
	public void clickDebitStatusButton() {
		WaitUtility.waitForClickableByWebElement(driver, debitStatusButton);
		PageUtility.clickOnElement(debitStatusButton);
	}
	public ManagePaymentPage clickResetButton() {
		WaitUtility.waitForClickableByWebElement(driver, resetButton);
		PageUtility.clickOnElement(resetButton);
		return this;
	}
	public boolean isAlertShownWhenStatusIsChanged() {
		return PageUtility.isDisplay(alertWhenStatusIsChanged);
	}
	public boolean isBackPageShownAfterClickingReset() {
		return PageUtility.isDisplay(afterResetPage);
	}
}
