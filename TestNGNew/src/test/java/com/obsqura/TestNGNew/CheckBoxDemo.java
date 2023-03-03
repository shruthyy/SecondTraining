package com.obsqura.TestNGNew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckBoxDemo extends Base{
	@Test
	public void checkBox() {
		
		SelectCategory selectcategory=new SelectCategory (driver);
		selectcategory.SelectElement("Checkbox Demo");
        WebElement checkboxClick=driver.findElement(By.xpath("//input[@class='form-check-input']"));
        checkboxClick.click();
	}

}
