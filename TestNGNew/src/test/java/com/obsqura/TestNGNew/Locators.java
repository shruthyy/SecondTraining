package com.obsqura.TestNGNew;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Locators extends Base {
	@Test
	public void locatingByID() {
		driver.findElement(By.id("twotabsearchtextbox"));
		driver.findElement(By.id("glow-ingress-line1"));
		
		
	}
	@Test
	public void locatingByClass() {
		driver.findElement(By.className("hm-icon-label"));
		driver.findElement(By.name("glow-validation-token"));
		driver.findElement(By.linkText("Gift Cards"));
		driver.findElement(By.partialLinkText("Today's "));
		driver.findElement(By.tagName("div"));
	}
	@Test
	public void locateBytagName() {
		driver.findElement(By.tagName("div"));
	}

	@Test
	public void cssLocator() {
		driver.navigate().to("https://www.flipkart.com/");
		driver.findElement(By.cssSelector("div#container")); //tag and id
		driver.findElement(By.cssSelector("button.L0Z3Pu")); //tag and class
		driver.findElement(By.cssSelector("input[name=otracker]")); //tag and  attribute
		driver.findElement(By.cssSelector("div.1oHPGm[id=twobase]]")); //tag , class and attribute
		
		
	}
	@Test
	public void xpathLocator() {
		driver.navigate().to("https://www.firstcry.com/");
		driver.findElement(By.xpath("//input[@type='search']"));
	}
	
}
