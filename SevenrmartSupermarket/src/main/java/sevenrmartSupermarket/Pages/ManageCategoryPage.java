package sevenrmartSupermarket.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ManageCategoryPage {
	public WebDriver driver;
	public ManageCategoryPage (WebDriver driver) {
	this.driver=driver;
    PageFactory.initElements(driver,this);
    }
	@FindBy(xpath="//div[@class=\"small-box bg-info\"]//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") WebElement selectCategoryElement;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchButton;
	@FindBy(xpath="//input[@placeholder='Category']") WebElement categoryTextBox;
	@FindBy(xpath="//button[@name='Search']") WebElement redSearchButton;
	
	By TableValuesBy=By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td");
	
	public boolean searchInTheTable(String category) {
		String categoryText="";
		List<WebElement> columnElements=driver.findElements(TableValuesBy);
		for (WebElement columnElement:columnElements) {
			categoryText= columnElement.getText();
	    break;
		}
		if(categoryText.equalsIgnoreCase(category))
			return true;
		else 

			return false;

		}		
	public ManageCategoryPage clickCategoryMoreInfoButton() {
		PageUtility.clickOnElement(selectCategoryElement);
		return this;
	}
	public ManageCategoryPage clickSearchButton() {
		PageUtility.clickOnElement(searchButton);
		return this;
	}
	public ManageCategoryPage enterCategoryToTextBoxForSearching(String category) {
		PageUtility.enterText(categoryTextBox, category);
		return this;
	}
	public ManageCategoryPage clickRedSearchButton() {
		PageUtility.clickOnElement(redSearchButton);
		return this;
	}

}
