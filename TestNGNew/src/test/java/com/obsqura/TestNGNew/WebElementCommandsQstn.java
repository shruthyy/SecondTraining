package com.obsqura.TestNGNew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebElementCommandsQstn extends Base{
	@Test
	public void enterDetails() {
		/*
		 * WebElement
		 * firstname=driver.findElement(By.cssSelector("input[name=firstname]"));
		 * firstname.sendKeys("Sruthi"); WebElement
		 * lastname=driver.findElement(By.cssSelector("input[name=lastname]"));
		 * lastname.sendKeys("V"); WebElement
		 * button=driver.findElement(By.cssSelector("button[name=submit]")); //
		 * button.click(); button.submit();
		 */
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement textbox=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		String tagName=textbox.getTagName();    //to get the tagName
		String placeHolder=textbox.getAttribute("placeholder"); //to get any attribute
		String typeAttribute=textbox.getAttribute("type");
		
	}

}
