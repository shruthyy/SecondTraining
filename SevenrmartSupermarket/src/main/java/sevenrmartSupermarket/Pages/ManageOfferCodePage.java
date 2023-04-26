package sevenrmartSupermarket.Pages;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageOfferCodePage {
		public WebDriver driver;
		public ManageOfferCodePage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver,this);
	    }
		@FindBy (xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']") WebElement manageOfferCodeLinkElement;
		@FindBy (xpath = "//input[@placeholder='Username']") WebElement usernameTextBoxElement;
		@FindBy (xpath = "//input[@name='password']") WebElement passwordTextBoxElement;
		@FindBy (xpath = "//button[text()='Sign In']") WebElement signInButtonElement;
		@FindBy (xpath = "//a[@onclick='click_button(2)']") WebElement searchButtonElement;
		@FindBy (xpath = "//input[@placeholder='Offer Code']") WebElement offercodeTextBoxElement;
		@FindBy (xpath = "//button[@type='submit']") WebElement searchSubmitButtElement;
		@FindBy (xpath = "//tbody//child::tr") WebElement foundofferCodElement;	
        @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Offercode/add']") WebElement addButton;
        @FindBy(xpath="//input[@id='offer_code']") WebElement enterOfferCodeTextBoxToAddOffer;
        @FindBy(xpath="//input[@placeholder='Percentage']") WebElement percentageTextBox;
        @FindBy(xpath="//input[@placeholder='Amount']") WebElement amountTextBox;
        @FindBy(xpath="//button[text()='Save']") WebElement saveButton;
        @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertWhenNewOfferAdded;
        
		By TableValuesBy=By.xpath("//tbody//child::tr//child::td");

	public ManageOfferCodePage clickonSearchButton() {
			WaitUtility.waitForElementClickable(driver,searchButtonElement);
			PageUtility.clickOnElement(searchButtonElement);
			return this;
		}
	public ManageOfferCodePage clickAddButtonToAddNewOfferCode() {
		WaitUtility.waitForClickableByWebElement(driver, addButton);
		PageUtility.clickOnElement(addButton);
		return this;
	}
	public ManageOfferCodePage enterOfferCodeToAddNewOffer(String newoffer) {
		WaitUtility.waitForElement(driver, enterOfferCodeTextBoxToAddOffer);
		PageUtility.enterText(enterOfferCodeTextBoxToAddOffer, newoffer);
		return this;
	}
	public ManageOfferCodePage enterPercentage(String percentage) {
		PageUtility.enterText(percentageTextBox, percentage);
		return this;
	}
	public ManageOfferCodePage enterAmount(String amount) {
		PageUtility.enterText(amountTextBox, amount);
		return this;
	}
	public ManageOfferCodePage clickOnManageOfferLink() {
			WaitUtility.waitForElementClickable(driver,manageOfferCodeLinkElement);
			PageUtility.clickOnElement(manageOfferCodeLinkElement);
			return this;
		}
	public ManageOfferCodePage enterOfferCode(String offercode) {
			WaitUtility.waitForClickableByWebElement(driver, offercodeTextBoxElement);
			PageUtility.enterText(offercodeTextBoxElement, offercode);
			return this;
		}
	public ManageOfferCodePage clickonSearchSubmitButton() {
	        WaitUtility.waitForElementClickable(driver,searchSubmitButtElement);
			PageUtility.clickOnElement(searchSubmitButtElement);
			return this;
		}
	public void clickSaveButton() {
		WaitUtility.waitForClickableByWebElement(driver, saveButton);
		PageUtility.clickOnElement(saveButton);
		
	}
	public boolean isAlertDisplayedWhenNewOfferCodeIsAdded() {
		return PageUtility.isDisplay(alertWhenNewOfferAdded);
	}
	public boolean searchInTheTable(String offercode) {
			String offercodeText="";
			List<WebElement> columnElements=driver.findElements(TableValuesBy);
			for (WebElement columnElement:columnElements) {
		    offercodeText= columnElement.getText();
		    break;
			}
			if(offercodeText.equalsIgnoreCase(offercode))
				return true;
			else 

				return false;

			}		

		}

	


