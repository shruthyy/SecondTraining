package sevenrmartSupermarket.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManagePagesPages {
	public WebDriver driver;
	public  ManagePagesPages(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath="//div[@class='small-box bg-info']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']") WebElement managePagesMoreInfoLink;
    @FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchButton;
    @FindBy(xpath="//input[@placeholder='Title']") WebElement enterTitleToSearch;
    @FindBy(xpath="//button[@name='Search']") WebElement redSearchButton;
    @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']") WebElement searchedTitleFromListPage;
    @FindBy(xpath="//a[@type='button']") WebElement resetButton;
    @FindBy(xpath="//div[@class='container-fluid']") WebElement listPageDisplayedAfterClickingResetButton;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/edit?edit=783&page_ad=1']") WebElement updateButton;
    @FindBy(xpath="//input[@id='page']") WebElement pageTextBox;
    @FindBy(xpath="//button[@name='update']") WebElement redUpdateButton;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertAfterUpdation;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/add']") WebElement newButton;
    @FindBy(xpath="//input[@id='title']") WebElement titleTextBoxToAddDuplicatePage;
    @FindBy(xpath="//input[@id='page']") WebElement pagenameTextBoxToAddDuplicatePage;
    @FindBy(xpath="//button[@type='submit']") WebElement saveButtonToAddDuplicatePage;
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alertForDuplicatePage;
    
    public ManagePagesPages enterTitleToAddDuplicatePage(String duplicatetitle) {
    	PageUtility.enterText(titleTextBoxToAddDuplicatePage, duplicatetitle);
		return this;
    }
    public ManagePagesPages enterPagenameToAddDuplicatePage(String duplicatepagename) {
    	PageUtility.enterText(pagenameTextBoxToAddDuplicatePage, duplicatepagename);
		return this;
    }
	public void selectManagePagesMoreInfoLink() {
		WaitUtility.waitForElement(driver, managePagesMoreInfoLink);
		PageUtility.clickOnElement(managePagesMoreInfoLink);
	}
	public ManagePagesPages clickSearchButton() {
		WaitUtility.waitForClickableByWebElement(driver, searchButton);
		PageUtility.clickOnElement(searchButton);
		return this;
	}
	public ManagePagesPages clickUpdateButton() {
		PageUtility.clickOnElement(updateButton);
		return this;
	}
	public ManagePagesPages clickSaveButtonToAddDuplicatePage() {
		PageUtility.clickOnElement(saveButtonToAddDuplicatePage);
		return this;
	}
	public boolean isAlertDisplayedForDuplicatePage() {
		return PageUtility.isDisplay(alertForDuplicatePage);
	}
	public ManagePagesPages makeChangesInPageTextBoxToUpdate(String updatecolor) {
		PageUtility.enterText(pageTextBox, updatecolor);
		return this;
	}
	public ManagePagesPages clickNewButton() {
		PageUtility.clickOnElement(newButton);
		return this;
	}
	public ManagePagesPages clickRedUpdateButton() {
		PageUtility.clickOnElement(redUpdateButton);
		return this;
	}
	public boolean isAlertDisplayedAfterUpdation() {
		return PageUtility.isDisplay(alertAfterUpdation);
	}
	public ManagePagesPages clickResetButton() {
		WaitUtility.waitForClickableByWebElement(driver, resetButton);
		PageUtility.clickOnElement(resetButton);
		return this;
	}
	public ManagePagesPages enterTitleToSearchInListPages(String title) {
		PageUtility.enterText(enterTitleToSearch, title);
		return this;
	}
	public ManagePagesPages enterTitleToUpdate(String update) {
		PageUtility.enterText(enterTitleToSearch, update);
		return this;
	}
	public ManagePagesPages clickRedSearchButton() {
		PageUtility.clickOnElement(redSearchButton);
		return this;
	}
	public boolean isSearchedTitleFoundFromListPagesTable() {
		return PageUtility.isDisplay(searchedTitleFromListPage);
	}
	public boolean isListPageDisplayedAfterClickingResetButton() {
		return PageUtility.isDisplay(listPageDisplayedAfterClickingResetButton);
	}
}
