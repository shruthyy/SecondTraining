package com.obsqura.TestNGNew;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;


public class cssLocationWebElementCommands extends Base {
	@Test
	public void cssSelectorWECommands() {
		String message="locators";
		String expectedhexValue="#007bff";
		WebElement enterTheMessage=	driver.findElement(By.cssSelector("input#single-input-field"));
		boolean isenterTheMessageBoxDisplayedOrNot=enterTheMessage.isDisplayed();
		enterTheMessage.sendKeys(message);
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		boolean isshowMessageButtonEnabledOrNot=showMessageButton.isEnabled();
		String showMessageButtonBackground=showMessageButton.getCssValue("background-color");
		Color backgroungColor=new Color(0, 123, 255, 1);
		String actualhexValue=backgroungColor.asHex();
		assertEquals(expectedhexValue,actualhexValue,"hex values are  not same");
	}
	@Test
	public void fontWeight() {
		int expectedFontWeight=400;
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		String showMessageButtonFontWeight=showMessageButton.getCssValue("font-weight");
		int actualFontWeight=Integer.parseInt(showMessageButtonFontWeight);
		assertEquals(expectedFontWeight,actualFontWeight,"Font Weight is not same");
	}
	@Test
	public void showMessageButtonAllignment() {
		String expectedAllignment="center";
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		String showMessageButtonAllignment=showMessageButton.getCssValue("text-align");
		String actualAllignment=showMessageButtonAllignment.toString();
		assertEquals(expectedAllignment,actualAllignment,"Allignment is not same");	
	}
	@Test
	public void showMessageButtonTextColour() {//rgba(255, 255, 255, 1) error
		String expectedColor="rgba(255, 255, 255, 1)";
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		String showMessageButtonTextColor=showMessageButton.getCssValue("color");
	    String actualColor=showMessageButtonTextColor.toString();
	//	Color textColor=new Color(255, 255, 255, 1);
	//	String actualColor=textColor.asHex(); //output = #ffffff
		assertEquals(expectedColor,actualColor,"Text Color is not White");	
	}
	@Test
	public void checkOval() { //4px=.25rem
		String expectedBorderRadius="4px";
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		String showMessageButtonBorderRadius=showMessageButton.getCssValue("border-radius");
		String actualBorderRadius=showMessageButtonBorderRadius.toString();
		assertEquals(expectedBorderRadius,actualBorderRadius,"Border is not oval");
		
	}
	@Test
	public void lineHeight() { //1.5rem=24px
		String expectedLineHeight="24px";//in compound line-height is given as 24px
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		boolean isShowMessageButtonDisplayed=showMessageButton.isDisplayed();
		String showMessageButtonLineHeight=showMessageButton.getCssValue("line-height");
		String actualLineHeight=showMessageButtonLineHeight.toString();
		assertEquals(expectedLineHeight,actualLineHeight,"lineheight is not same");
	}
	@Test
	public void verifySMBisbelowEnterMessage() {
		WebElement enterMessage=driver.findElement(By.cssSelector("input#single-input-field"));
		Point locationOfEnterMessage=enterMessage.getLocation();
		int enterMessageX=locationOfEnterMessage.getX();
		int enterMessageY=locationOfEnterMessage.getY();
		WebElement showMessageButton=driver.findElement(By.cssSelector("button#button-one"));
		Point locationOfshowMessageButton=showMessageButton.getLocation();
		int showMessageButtonX=locationOfshowMessageButton.getX();
		int showMessageButtonY=locationOfshowMessageButton.getY();
		assertEquals(enterMessageX, showMessageButtonX,"Both elements are not in same line");
	//  assertEquals(enterMessageY, showMessageButtonY,"Both elements are not in same line");
		if(enterMessageY>showMessageButtonY) {
			System.out.println("EnterMessageBox is below ShowMessageButton");
		}
		else {
			System.out.println("ShowMessageButton is below EnterMessageBox" );
		}
	}
	@Test 
	public void VerifygetTotalButtonBelowInputB() {
		WebElement enterInputB=driver.findElement(By.xpath("//input[@id='value-b']"));
		Point locationOfenterInputB=enterInputB.getLocation();
		int enterInputBX=locationOfenterInputB.getX();
		int enterInputBY=locationOfenterInputB.getY();
		WebElement getTotalButton=driver.findElement(By.xpath("//button[@id='button-two']"));
		Point locationOfgetTotalButton=getTotalButton.getLocation();
		int getTotalButtonX=locationOfgetTotalButton.getX();
		int getTotalButtonY=locationOfgetTotalButton.getY();
		if(enterInputBX==getTotalButtonX) {
		assertTrue(enterInputBY>getTotalButtonY,"get total button is below input B box");
		}
		
	}
	@Test
	public void verifySizeOfGetTotalButton() {
		int expectedHeight=38;
		int expectedWidth=93;
		WebElement getTotalButton=driver.findElement(By.xpath("//button[@id='button-two']"));
		int getTotalButtonHeight=getTotalButton.getSize().getHeight();
		int getTotalButtonWidth=getTotalButton.getSize().getWidth();
		assertEquals(expectedHeight,getTotalButtonHeight,"Height is not same");
		assertEquals(expectedWidth,getTotalButtonWidth,"width is not same");
	}
}
