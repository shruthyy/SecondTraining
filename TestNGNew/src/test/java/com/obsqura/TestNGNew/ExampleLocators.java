package com.obsqura.TestNGNew;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ExampleLocators  extends Base{
	@Test
	public void locateById() {
		driver.navigate().to("https://www.firstcry.com/");
		driver.findElement(By.id("searchloader"));
		driver.findElement(By.id("searchnoresult"));
		driver.findElement(By.id("searchlist"));
		driver.findElement(By.id("cartprogressdiv"));
		driver.findElement(By.id("loadingmaster"));//PASS
		
	}
	@Test
	public void locateByClass() {
		driver.navigate().to("https://www.firstcry.com/");
		driver.findElement(By.className("navmore"));
	    driver.findElement(By.className("navlist"));
		driver.findElement(By.className("cartemptybig"));
		driver.findElement(By.className("headOverlay"));//PASS
	}

	@Test
	public void LocateById() {
		driver.navigate().to("https://www.google.com/search?q=meesho&source=hp&ei=ebP1Y6PXJ8jt4-EP79OnWA&iflsig=AK50M_UAAAAAY_XBiYk2tq6Gvsu78dxklpLbl-8gZ4bd&ved=0ahUKEwjj98vOvaj9AhXI9jgGHe_pCQsQ4dUDCAg&uact=5&oq=meesho&gs_lcp=Cgdnd3Mtd2l6EAMyCwgAEIAEELEDEIMBMgsIABCABBCxAxCDATILCAAQgAQQsQMQgwEyCwgAEIAEELEDEIMBMggIABCABBCxAzIFCAAQgAQyCwgAEIAEELEDEIMBMgsIABCABBCxAxCDATILCAAQgAQQsQMQgwEyCwgAEIAEELEDEIMBOg4IABCPARDqAhCMAxDlAjoOCC4QjwEQ6gIQjAMQ5QI6CwguEIAEELEDEIMBOgUILhCABDoICAAQsQMQgwE6CwguEIAEEMcBEK8BOggIABCABBDJAzoICC4QgAQQsQM6BwguEIAEEApQkiZYqTZg9EdoAXAAeACAAc4BiAHGBZIBBTIuMy4xmAEAoAEBsAEK&sclient=gws-wiz");
		driver.findElement(By.id("searchform"));
		driver.findElement(By.id("HjtPBb"));
		driver.findElement(By.id("tophf"));
		driver.findElement(By.id("pTwnEc"));
		driver.findElement(By.id("elPddd"));//PASS
	}
	@Test
	public void flipkartLocateByClass() {
		driver.navigate().to("https://www.flipkart.com/");
		driver.findElement(By.className("_2xm1JU"));
		driver.findElement(By.className("_3704LK"));
		driver.findElement(By.className("_1_3w1N"));
		driver.findElement(By.className("exehdJ"));
		driver.findElement(By.className("_3qX0zy"));//PASS
		
	}
	@Test
	public void locateByName() {
		driver.navigate().to("https://www.purplle.com/");
		driver.findElement(By.name("HandheldFriendly"));
		driver.findElement(By.name("MobileOptimized"));
		driver.findElement(By.name("theme-color"));
		driver.findElement(By.name("apple-mobile-web-app-capable"));
		driver.findElement(By.name("google-site-verification"));//PASS
	}
	@Test
	public void locateByLinktext() {
		driver.navigate().to("https://www.firstcry.com/");
		driver.findElement(By.linkText("Books & CDs"));
		driver.findElement(By.linkText("Moms & Maternity"));
		driver.findElement(By.linkText("Birthday Party Supplies"));
		driver.findElement(By.linkText("Baby Diapering"));
		driver.findElement(By.linkText("Bath & Skin Care"));//PASS
	}
	@Test
	public void locateByPartialLT() {
		driver.navigate().to("https://www.firstcry.com/");
		driver.findElement(By.partialLinkText("Moms"));
		driver.findElement(By.partialLinkText("GlobalBees"));
		driver.findElement(By.partialLinkText("Responsible"));
		driver.findElement(By.partialLinkText("Birthday Party"));
		driver.findElement(By.partialLinkText("Bath & Skin"));//PASS
	}
	@Test
	public void locateBycss() {
		driver.navigate().to("https://www.firstcry.com/");
        driver.findElement(By.cssSelector("div#searchlist"));//tag &id
        driver.findElement(By.cssSelector("div.ftb"));//tag & class
        driver.findElement(By.cssSelector("form[method=post]"));//tag & any attribute
        driver.findElement(By.cssSelector("input[autocomplete=off]"));
        driver.findElement(By.cssSelector("div.overlay-content[id=overlay-contentVat-cart]"));  //PASS   
	}
	@Test
	public void locateByXpath() {
		driver.navigate().to("https://www.firstcry.com/");
		driver.findElement(By.xpath("//span[@class='search-button']"));
		driver.findElement(By.xpath("//li[@id='geoLocation']"));
		driver.findElement(By.xpath("//input[@type='search']"));
		driver.findElement(By.xpath("//div[@id='EmptyCart']"));
		driver.findElement(By.xpath("//span[@style='cursor:pointer']"));
		driver.findElement(By.xpath("//div[@id='freeshipingmsg']"));
		driver.findElement(By.xpath("//div[@onclick='CartHideNotify(cart_notify)']"));
		driver.findElement(By.xpath("//input[@autocomplete='off']"));
		driver.findElement(By.xpath("//style[@media='screen']"));
		driver.findElement(By.xpath("//div[@id='fb-root']")); //PASS
		
	}
	
}
