package com.obsqura.TestNGNew;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MainMenu extends Base {
	@Test

	public void navigateToMainMenu() {
	    String menuToBeSelected="Progress Bars";
	    List<WebElement>mains=driver.findElements(By.xpath("//li[@class='nav-item']//a"));
	    for(WebElement maganaviMenu:mains)
	    {
	    	String menuElement=maganaviMenu.getText();
	    	if(menuElement.equalsIgnoreCase(menuToBeSelected))
	    	  {
	    	    maganaviMenu.click();
	    	    break;
	    	}
	    }
	}
}
