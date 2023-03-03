package com.obsqura.TestNGNew;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ForGit extends Base{
	
	@Test
	public void webElementCommands1() {
		driver.get("https://www.google.com/");
		WebElement searchbox=driver.findElement(By.cssSelector("input.gLFyf"));
		searchbox.sendKeys("apple iphone 13");//sendKeys
		searchbox.clear();                   //clear
		searchbox.sendKeys("apple iphone 13");
		WebElement searchbutton=driver.findElement(By.xpath("(//input[@name='btnK'])[1]"));//indexing Only applicable for Xpath if it is not unique
		searchbutton.click();                //click
	}
	@Test
	public void webElementCommands2() {
	driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
	WebElement textbox=driver.findElement(By.xpath("//input[@id='single-input-field']"));
	String tagName=textbox.getTagName();    //to get the tagName
	String placeHolder=textbox.getAttribute("placeholder"); //to get any attribute
	String typeAttribute=textbox.getAttribute("type");
	}
	@Test
	public void webElementCommands3() {
	WebElement enterMessage=driver.findElement(By.cssSelector("input#single-input-field"));//findElement()
	boolean isTextBoxDisplayed=enterMessage.isDisplayed(); //isDisplayed()
	assertTrue(isTextBoxDisplayed,"TEXtbox is not displayed");
	enterMessage.sendKeys("locators");		
	WebElement showMessageButton=driver.findElement(By.cssSelector("button#button-one"));
	boolean showMessageButtonIsEnabledOrNot=showMessageButton.isEnabled();//isEnabled()
	assertTrue(showMessageButtonIsEnabledOrNot,"Show Message Button Is not enabled");
	showMessageButton.click();
	WebElement yourmessage=driver.findElement(By.cssSelector("div#message-one"));
	String messageWhichIsDisplayed=yourmessage.getText();
	String button1Text=enterMessage.getText(); //getText()
	String showMessageButtonBackgroung=showMessageButton.getCssValue("background-color");//getCssValue()
	//getLocation(),getX(),getY();
	Point location=showMessageButton.getLocation();
	int showMessageButtonX=location.getX();
	int showMessageButtonY=location.getY();
	int entermessageX=enterMessage.getLocation().getX();
	int entermessageY=enterMessage.getLocation().getY();
	//getsize(),getHeight(), getWidth();
	int height=showMessageButton.getSize().getHeight();		
	int width=showMessageButton.getSize().getWidth();
}
	@Test
	public void webElementCommands4() {
		 String menuToBeSelected="Date Pickers";
		    List<WebElement>mains=driver.findElements(By.xpath("//li[@class='nav-item']//a"));//findElements()
		    for(WebElement maganaviMenu:mains)
		    {
		    	String menuElement=maganaviMenu.getText();
		    	if(menuElement.equalsIgnoreCase(menuToBeSelected))
		    	  {
		    	    maganaviMenu.click();
		    	    break;
		    	}
		    }	
		}
	}



