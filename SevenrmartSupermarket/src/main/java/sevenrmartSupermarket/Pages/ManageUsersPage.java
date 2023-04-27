package sevenrmartSupermarket.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageUsersPage {
	public WebDriver driver;
	public ManageUsersPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchButton;
	@FindBy(xpath="//input[@id='un']") WebElement nameTextBox;
	@FindBy(xpath="//i[@class='fa fa-search']") WebElement redSearchButton;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']") WebElement deleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertWhenUserIsDeleted;
	@FindBy(xpath="//i[@class='fa fa-angle-double-down']") WebElement showPasswordButton;
	@FindBy(xpath="//div[@class='profile-info-name']") WebElement passwordDisplayBox;
	By TableValuesBy=By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td");
	public ManageUsersPage clickSearchButton() {
		WaitUtility.waitForClickableByWebElement(driver, searchButton);
		PageUtility.clickOnElement(searchButton);
		return this;
	}
	public ManageUsersPage enterNameInTextBox(String name) {
		PageUtility.enterText(nameTextBox, name);
		return this;
	}
	public ManageUsersPage clickRedSearchButton() {
		WaitUtility.waitForClickableByWebElement(driver, redSearchButton);
		PageUtility.clickOnElement(redSearchButton);
		return this;
	}
	public void clickDeleteButton() {
		WaitUtility.waitForClickableByWebElement(driver, deleteButton);
		PageUtility.clickOnElement(deleteButton);
	}
	public void clickPasswordArrowButton() {
		PageUtility.clickOnElement(showPasswordButton);
	}
	public boolean isAlertDisplayedWhenUserIsDEletedFromTable() {
		return PageUtility.isDisplay(alertWhenUserIsDeleted);
	}
	public boolean isPasswordDisplayedForSearchedUser() {
		return PageUtility.isDisplay(passwordDisplayBox);
	}
	public boolean searchInTheTable(String name) {
		String offercodeText="";
		List<WebElement> columnElements=driver.findElements(TableValuesBy);
		for (WebElement columnElement:columnElements) {
	    offercodeText= columnElement.getText();
	    break;
		}
		if(offercodeText.equalsIgnoreCase(name))
			return true;
		else 

			return false;

		}		

	}

	
	


