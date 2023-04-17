package sevenrmartSupermarket.Pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.ExcelUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageSliderPage {
	public WebDriver driver;
	public ManageSliderPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[10]/a") WebElement manageSliderMenu;
	@FindBy(xpath="//h1[text()='List Sliders']") WebElement listSlidersText;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']") WebElement newButton ;
	@FindBy(xpath="//input[@id='link']") WebElement link;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	public void clickManageSliderButton(){
		boolean isManageSliderVisible=PageUtility.isElementDisplayed(manageSliderMenu);
		assertTrue(isManageSliderVisible, "Manager slider option not visible");
		PageUtility.clickOnElement(manageSliderMenu);
	}
	public void clickNewButton(){
		WaitUtility.waitForClickableByWebElement(driver, newButton);
		PageUtility.clickOnElement(newButton);
	}
	public void enterLinkToLinkTextBox(String newlink) {
		WaitUtility.waitForClickableByWebElement(driver, link);
		//PageUtility.clickOnElement(link);
		PageUtility.enterText(link, newlink);
		}
	public void clickSaveButton() {
		PageUtility.clickOnElement(saveButton);
		}
	public boolean listSliderPageisDisplayed() {
		return PageUtility.isDisplay(listSlidersText);
		    }
	public boolean linkTextisDisplayed() {
		return PageUtility.isDisplay(link);
		    }
	public boolean saveButtonIsEnabled() {
		return PageUtility.isElementEnabled(saveButton);
	}
	public boolean alertisDisplayed() {
		return PageUtility.isDisplay(alert);
		    }
	}

