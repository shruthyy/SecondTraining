package sevenrmartSupermarket.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManagePagesPages {
	PageUtility pageutility=new PageUtility();
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
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/edit?edit=813&page_ad=1']") WebElement updateButton;
    
    @FindBy(xpath="//input[@id='page']") WebElement pageTextBox;
    @FindBy(xpath="//button[@name='update']") WebElement redUpdateButton;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertAfterUpdation;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/add']") WebElement newButton;
    @FindBy(xpath="//input[@id='title']") WebElement titleTextBoxToAddDuplicatePage;
    @FindBy(xpath="//input[@id='page']") WebElement pagenameTextBoxToAddDuplicatePage;
    @FindBy(xpath="//button[@type='submit']") WebElement saveButtonToAddDuplicatePage;
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alertForDuplicatePage;
    
    public ManagePagesPages enterTitleToAddDuplicatePage(String duplicatetitle) {
    	pageutility.enterText(titleTextBoxToAddDuplicatePage, duplicatetitle);
		return this;
    }
    public ManagePagesPages enterPagenameToAddDuplicatePage(String duplicatepagename) {
    	pageutility.enterText(pagenameTextBoxToAddDuplicatePage, duplicatepagename);
		return this;
    }
	public void selectManagePagesMoreInfoLink() {
		WaitUtility.waitForElement(driver, managePagesMoreInfoLink);
		pageutility.clickOnElement(managePagesMoreInfoLink);
	}
	public ManagePagesPages clickSearchButton() {
		WaitUtility.waitForClickableByWebElement(driver, searchButton);
		pageutility.clickOnElement(searchButton);
		return this;
	}
	public ManagePagesPages clickUpdateButton() {
		pageutility.clickOnElement(updateButton);
		return this;
	}
	public ManagePagesPages clickSaveButtonToAddDuplicatePage() {
		pageutility.clickOnElement(saveButtonToAddDuplicatePage);
		return this;
	}
	public boolean isAlertDisplayedForDuplicatePage() {
		return pageutility.isDisplay(alertForDuplicatePage);
	}
	public ManagePagesPages makeChangesInPageTextBoxToUpdate(String updatecolor) {
		pageutility.enterText(pageTextBox, updatecolor);
		return this;
	}
	public ManagePagesPages clickNewButton() {
		pageutility.clickOnElement(newButton);
		return this;
	}
	public ManagePagesPages clickRedUpdateButton() {
		pageutility.clickOnElement(redUpdateButton);
		return this;
	}
	public boolean isAlertDisplayedAfterUpdation() {
		return pageutility.isDisplay(alertAfterUpdation);
	}
	public ManagePagesPages clickResetButton() {
		WaitUtility.waitForClickableByWebElement(driver, resetButton);
		pageutility.clickOnElement(resetButton);
		return this;
	}
	public ManagePagesPages enterTitleToSearchInListPages(String title) {
		pageutility.enterText(enterTitleToSearch, title);
		return this;
	}
	public ManagePagesPages enterTitleToUpdate(String update) {
		pageutility.enterText(enterTitleToSearch, update);
		return this;
	}
	public ManagePagesPages clickRedSearchButton() {
		pageutility.clickOnElement(redSearchButton);
		return this;
	}
	public boolean isSearchedTitleFoundFromListPagesTable() {
		return pageutility.isDisplay(searchedTitleFromListPage);
	}
	public boolean isListPageDisplayedAfterClickingResetButton() {
		return pageutility.isDisplay(listPageDisplayedAfterClickingResetButton);
	}
}
