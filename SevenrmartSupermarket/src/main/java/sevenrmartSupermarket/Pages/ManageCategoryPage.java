package sevenrmartSupermarket.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

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
	@FindBy(xpath="//a[@type='button']") WebElement resetButton;
	@FindBy(xpath="//div[@class='content-header']") WebElement listCategoryDisplayAfterReset;
	
	By TableValuesBy=By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td");
	
	public ManageCategoryPage clickCategoryMoreInfoButton() {
		WaitUtility.waitForClickableByWebElement(driver, selectCategoryElement);
		PageUtility.clickOnElement(selectCategoryElement);
		return this;
	}
	public ManageCategoryPage clickSearchButton() {
		WaitUtility.waitForClickableByWebElement(driver, searchButton);
		PageUtility.clickOnElement(searchButton);
		return this;
	}
	public ManageCategoryPage enterCategoryToTextBoxForSearching(String category) {
		WaitUtility.waitForElement(driver, categoryTextBox);
		PageUtility.enterText(categoryTextBox, category);
		return this;
	}
	public ManageCategoryPage clickRedSearchButton() {
		WaitUtility.waitForClickableByWebElement(driver,redSearchButton );
		PageUtility.clickOnElement(redSearchButton);
		return this;
	}
	public ManageCategoryPage clickResetButton() {
		WaitUtility.waitForClickableByWebElement(driver,resetButton );
		PageUtility.clickOnElement(resetButton);
		return this;
	}
	public boolean isListCategoryPageDisplayedAfterClickingResetButton() {
		return PageUtility.isDisplay(listCategoryDisplayAfterReset);
	}
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
}
