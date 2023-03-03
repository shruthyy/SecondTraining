package com.obsqura.TestNGNew;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchBoxlocate extends Base {
	@Test
	public void locateByID() {
		driver.findElement(By.id("cartInnerrProgressmaster"));
	}
	@Test
    public void locateByClass() {
	driver.findElement(By.className("progressbarCss"));
}
	@Test
	public void locateByTagandID() {
		driver.findElement(By.cssSelector("div#cartInnerrProgressmaster"));
	}
	@Test
	public void locateByTagandClass() {
		driver.findElement(By.cssSelector("div.progressbarCss"));
	}
	@Test
	public void locateByXpath() {
		driver.findElement(By.xpath("//div[@class='progressbarCss']"));
	}
	@Test
	public void locateBytagClassAttribute() {
		driver.findElement(By.cssSelector("div.progressbarCss[id=cartInnerrProgressmaster]"));	
	}
}
