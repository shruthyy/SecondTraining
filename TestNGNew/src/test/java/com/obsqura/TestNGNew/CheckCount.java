package com.obsqura.TestNGNew;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckCount extends Base {
	
	@Test
	public void findAmazon() {	
	String checkword="amazon";
    int count=0;
	driver.navigate().to("https://www.flipkart.com/");
	String flipkartpage=driver.getPageSource();
//	assertTrue(flipkartpage.contains(checkword));
	for(int i=0;i<flipkartpage.length();i++) {
		if(flipkartpage.contains(checkword)) {
			count++;
		}
	}
     System.out.println("Count of word Amazon in flipkart pagesource is"+count);
   //Assert.assertNull(count,"amazon word is not found");
assertNotNull(count,"Amazon word is found in Flipkart pagesource");
 
     
	}
}
