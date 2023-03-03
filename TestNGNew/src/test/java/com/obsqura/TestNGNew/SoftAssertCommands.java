package com.obsqura.TestNGNew;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertCommands extends Base{

	@Test
	public void hardAssert()
	{
		String expectedurl="https://www.amazon.in/";
		String expectedurl1="https://www.flipkart.com/";
		driver.navigate().to("https://www.flipkart.com/");
		String actualurl1=driver.getCurrentUrl();
		assertEquals(expectedurl1,actualurl1,"Not navigated to flipkart");
		driver.navigate().back();
		String actaulurl=driver.getCurrentUrl();
		assertEquals(expectedurl,actaulurl,"Not navigated back to Amazon");
		

	}
	@Test
	public void softAssertTestCase()
	{
		
		String expectedurl="https://www.amazon.in/";
		String expectedurl1="https://www.flipkart.com.com/";
		SoftAssert softassert=new SoftAssert(); //object for SoftAssert
		driver.navigate().to("https://www.amazon.in/");
		String actualurl1=driver.getCurrentUrl();
		softassert.assertEquals(expectedurl1,actualurl1,"Not navigated to flipkart");
		driver.navigate().back();
		String actaulurl=driver.getCurrentUrl();
		softassert.assertEquals(expectedurl,actaulurl,"Not navigated back to Amazon");
		softassert.assertAll();

	}

}

