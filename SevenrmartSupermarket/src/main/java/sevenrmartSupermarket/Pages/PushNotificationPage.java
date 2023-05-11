package sevenrmartSupermarket.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class PushNotificationPage {
	PageUtility pageutility=new PageUtility();
	public WebDriver driver;
	public PushNotificationPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Enter Title']") WebElement titleTextEnter;
	@FindBy(xpath="//input[@id='description']") WebElement descriptionTextEnter;
	@FindBy(xpath="//button[@type='submit']") WebElement sendButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement pushNotificationAlert;
	@FindBy(xpath="//a[@type='button']") WebElement resetButton;
	@FindBy(xpath="//div[@class='form-group']") WebElement clearedTitleTextBox;
	public PushNotificationPage enterTitleBox(String title){
		pageutility.enterText(titleTextEnter, title);
		return this;
	}	
	public PushNotificationPage enterDescriptionBox(String description){
		pageutility.enterText(descriptionTextEnter, description);
		return this;
	}	
	public PushNotificationPage clickSendButton(){
		pageutility.clickOnElement(sendButton);
		return this;
	}
	public boolean alertForPushisDisplayed() {
		return pageutility.isDisplay(pushNotificationAlert);
	}
	public boolean isTitleBoxClearedAfterClickingResetButton() {
		return pageutility.isDisplay(clearedTitleTextBox);
	}
	public  PushNotificationPage clickResetButton() {
		WaitUtility.waitForClickableByWebElement(driver, resetButton);
		pageutility.clickOnElement(resetButton);
		return this;
	}
}
