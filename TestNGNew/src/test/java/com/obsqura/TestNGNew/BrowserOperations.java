package com.obsqura.TestNGNew;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserOperations extends Base{
	
//@Test
/*public void webElementCommands() {
	WebElement searchbox=driver.findElement(By.cssSelector("input.gLFyf"));
	searchbox.sendKeys("apple iphone 13");
	searchbox.clear();
	searchbox.sendKeys("apple iphone 13");
	WebElement searchbutton=driver.findElement(By.xpath("(//input[@name='btnK'])[1]"));//indexing Only applicable for Xpath if it is not unique
	searchbutton.click();
	
	
}*/

  @Test
   public void verifySingleInputfield() {//obsqura
	WebElement enterMessage=driver.findElement(By.cssSelector("input#single-input-field"));
	boolean isTextBoxDisplayed=enterMessage.isDisplayed();
	assertTrue(isTextBoxDisplayed,"TEXtbox is not displayed");
	enterMessage.sendKeys("locators");		
	WebElement showMessageButton=driver.findElement(By.cssSelector("button#button-one"));
	boolean showMessageButtonIsEnabledOrNot=showMessageButton.isEnabled();
	assertTrue(showMessageButtonIsEnabledOrNot,"Show Message Button Is not enabled");
	showMessageButton.click();
	WebElement yourmessage=driver.findElement(By.cssSelector("div#message-one"));
	String messageWhichIsDisplayed=yourmessage.getText();
	String button1Text=enterMessage.getText();
	String showMessageButtonBackgroung=showMessageButton.getCssValue("background-color");
	//LOCATION
	Point location=showMessageButton.getLocation();
	int showMessageButtonX=location.getX();
	int showMessageButtonY=location.getY();
	int entermessageX=enterMessage.getLocation().getX();
	int entermessageY=enterMessage.getLocation().getY();
	//SIZE
	int height=showMessageButton.getSize().getHeight();		
	int width=showMessageButton.getSize().getWidth();
	
	
}
	@Test
	public void concatVerification() {//obsqura site
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		String messageToBePrinted="Hello";
		String expectedMessage="Your Message : ".concat(messageToBePrinted); 
		WebElement enterTheMessage=	driver.findElement(By.cssSelector("input#single-input-field"));
		enterTheMessage.sendKeys(messageToBePrinted);
		WebElement clickhere=driver.findElement(By.cssSelector("button#button-one"));
		clickhere.click();
		WebElement messageOutput=driver.findElement(By.cssSelector("div#message-one"));
		String actualMessage=messageOutput.getText();
		assertEquals(expectedMessage,actualMessage,"Message is not same");
	}
	
@Test
  public void getTotal() {//obsqura site

		int a = 2;
		int b = 4;
		WebElement inputA = driver.findElement(By.cssSelector("input#value-a"));//first check displayed or not,then only enter the value
		boolean enterA = inputA.isDisplayed();
		assertTrue(enterA, "input value A is not entered");
		inputA.sendKeys("a");
		WebElement inputB = driver.findElement(By.cssSelector("input#value-b"));
		boolean enterB = inputB.isDisplayed();
		assertTrue(enterB, "input value B is not entered");
		inputB.sendKeys("b");
		WebElement getTotalButton = driver.findElement(By.xpath("//button[@id='button-two']"));
		boolean getTotalButtonIsEnabledOrNot = getTotalButton.isEnabled();
		assertTrue(getTotalButtonIsEnabledOrNot, "GetTotalButton is not enabled");
		getTotalButton.click();
		WebElement showResult = driver.findElement(By.cssSelector("div#message-two"));
		boolean showResultIsDisplayedOrNot = showResult.isDisplayed();
		assertTrue(showResultIsDisplayedOrNot, "Result is not displayed");
		String outputTotal = showResult.getText();
	
	}
}
