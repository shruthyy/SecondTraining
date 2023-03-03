package com.obsqura.TestNGNew;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class BrowserCommands extends Base {
	@Test
	public void verifyTitle() {
		String expectedtitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	    String actualtitle=driver.getTitle();
	    assertEquals(expectedtitle,actualtitle,"Title is not same");
	}
	@Test
	public void verifyUrl() {
		String expectedurl="https://www.amazon.in/";
		String actualurl=driver.getCurrentUrl();
		assertEquals(expectedurl,actualurl,"URL is not same");
	}

	
}
