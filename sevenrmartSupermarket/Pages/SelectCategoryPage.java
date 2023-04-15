package sevenrmartSupermarket.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtility;

public class SelectCategoryPage {
	public WebDriver driver;
	public SelectCategoryPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li[@class='nav-item']//a") WebElement menuList;
	
	public void selectElementFromMenu(String input) {	
		WaitUtility.waitForElement(driver, menuList);
		List<WebElement>categories=driver.findElements(By.xpath("//li[@class='nav-item']"));
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
