package sevenrmartSupermarket.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManagePaymentPage {
	PageUtility pageutility=new PageUtility();
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
		pageutility.clickOnElement(debitUpdateButton);
		return this;
	}
	public ManagePaymentPage changeValueInDebitPayLimitTextBox(String amount) {
		WaitUtility.waitForElement(driver, debitPayLimitTextBox);
		pageutility.enterText(debitPayLimitTextBox, amount);
		return this;
	}
	public ManagePaymentPage clickUpdate() {
		WaitUtility.waitForClickableByWebElement(driver, updateButton);
		pageutility.clickOnElement(updateButton);
		return this;
	}
	public boolean isAlertShownWhenUpdationIsDone() {
		return pageutility.isDisplay(alertWhenUpdateIsDone);
	}
	public void clickDebitStatusButton() {
		WaitUtility.waitForClickableByWebElement(driver, debitStatusButton);
		pageutility.clickOnElement(debitStatusButton);
	}
	public ManagePaymentPage clickResetButton() {
		WaitUtility.waitForClickableByWebElement(driver, resetButton);
		pageutility.clickOnElement(resetButton);
		return this;
	}
	public boolean isAlertShownWhenStatusIsChanged() {
		return pageutility.isDisplay(alertWhenStatusIsChanged);
	}
	public boolean isBackPageShownAfterClickingReset() {
		return pageutility.isDisplay(afterResetPage);
	}
}
