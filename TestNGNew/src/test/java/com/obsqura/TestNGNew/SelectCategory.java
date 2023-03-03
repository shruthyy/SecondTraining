package com.obsqura.TestNGNew;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SelectCategory extends Base {
	 public SelectCategory (WebDriver driver) { //parametrized constructor
		 this.driver=driver;
	
	 }
	@Test
	public void SelectElement(String input) {
		List<WebElement>categories=	driver.findElements(By.xpath("//li[@class='list-group-item']//a"));
		for(WebElement category: categories)
		{
			String categoryName=category.getText();
			if(categoryName.equals(input))
			{
				category.click();
				break;
			}
		}
	}
	
}
