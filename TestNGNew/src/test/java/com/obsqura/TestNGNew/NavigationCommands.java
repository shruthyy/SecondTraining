package com.obsqura.TestNGNew;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class NavigationCommands extends Base {

	@Test
	public void verifyNavigateto() {
		String expectedurl="https://www.flipkart.com/";
		driver.navigate().to("https://www.flipkart.com/");
		String actualurl=driver.getCurrentUrl();
		assertEquals( expectedurl,actualurl,"url is not same");
	}
	
	@Test
	public void verifyNavigateback() {
		String expectedbackpage="https://www.amazon.in/";
		driver.navigate().to("https://www.flipkart.com/");
		driver.navigate().back();
		String actualbackpage=driver.getCurrentUrl();
		assertEquals(expectedbackpage,actualbackpage,"backpage is not same");
	}
	@Test
	public void verifyNavigateforward() {
		String expectedforwardpage="https://www.flipkart.com/";
		driver.navigate().to("https://www.flipkart.com/");
		driver.navigate().back();
		driver.navigate().forward();
		String actualforwardpage=driver.getCurrentUrl();
		assertEquals(expectedforwardpage,actualforwardpage,"forward page is not same");
	}
	
}
