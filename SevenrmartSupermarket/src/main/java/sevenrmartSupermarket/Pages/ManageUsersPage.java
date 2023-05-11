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
	PageUtility pageutility=new PageUtility();
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
		pageutility.clickOnElement(searchButton);
		return this;
	}
	public void popupSelectOk() {
		driver.switchTo().alert().accept();
	}
	public ManageUsersPage enterNameInTextBox(String name) {
		WaitUtility.waitForElement(driver, nameTextBox);
		pageutility.enterText(nameTextBox, name);
		return this;
	}
	public ManageUsersPage clickRedSearchButton() {
		WaitUtility.waitForClickableByWebElement(driver, redSearchButton);
		pageutility.clickOnElement(redSearchButton);
		return this;
	}
	public void clickDeleteButton() {
		WaitUtility.waitForClickableByWebElement(driver, deleteButton);
		pageutility.clickOnElement(deleteButton);
	}
	public void clickPasswordArrowButton() {
		WaitUtility.waitForClickableByWebElement(driver, showPasswordButton);
		pageutility.clickOnElement(showPasswordButton);
	}
	public boolean isAlertDisplayedWhenUserIsDEletedFromTable() {
		return pageutility.isDisplay(alertWhenUserIsDeleted);
	}
	public boolean isPasswordDisplayedForSearchedUser() {
		return pageutility.isDisplay(passwordDisplayBox);
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

	
	


