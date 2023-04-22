package sevenrmartSupermarket.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class PushNotificationPage {
	public WebDriver driver;
	public PushNotificationPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Enter Title']") WebElement titleTextEnter;
	@FindBy(xpath="//input[@id='description']") WebElement descriptionTextEnter;
	@FindBy(xpath="//button[@type='submit']") WebElement sendButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement pushNotificationAlert;
	
	public PushNotificationPage enterTitleBox(String title){
		PageUtility.enterText(titleTextEnter, title);
		return this;
	}	
	public PushNotificationPage enterDescriptionBox(String description){
		PageUtility.enterText(descriptionTextEnter, description);
		return this;
	}	
	public PushNotificationPage clickSendButton(){
		PageUtility.clickOnElement(sendButton);
		return this;
	}
	public boolean alertForPushisDisplayed() {
		return PageUtility.isDisplay(pushNotificationAlert);
	}

}
