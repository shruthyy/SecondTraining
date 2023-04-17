package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.PageUtility;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManageSliderPage;

public class ManageSliderTest extends Base {
	LoginPage loginpage;
	ManageSliderPage  managesliderpage;

	@Test(priority=1)
	public void verifyListSliderPageOpens() throws IOException{
		loginpage=new LoginPage(driver);
		loginpage.signIn();
		managesliderpage=new ManageSliderPage(driver);
		managesliderpage.clickManageSliderButton();
		boolean isListSliderPageDisplayedOrNot=managesliderpage.listSliderPageisDisplayed();
		assertTrue(isListSliderPageDisplayedOrNot,"List Slider page not displayed");
	}
	
	@Test(groups= {"smoke"})
	public void addLinkToManageSlider() throws IOException {
		String newlink=ExcelUtility.getString(0,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageSlider");
		loginpage=new LoginPage(driver);
		loginpage.signIn();
		managesliderpage=new ManageSliderPage(driver);
		managesliderpage.clickManageSliderButton();	
		 managesliderpage.clickNewButton();
		boolean isLinkFieldDisplayedOrNot=managesliderpage.linkTextisDisplayed(); 
	    assertTrue(isLinkFieldDisplayedOrNot,"Link field is not displayed");
	    managesliderpage.enterLinkToLinkTextBox(newlink);
	    boolean isSaveButtonEnabledOrNot=managesliderpage.saveButtonIsEnabled();
		assertTrue(isSaveButtonEnabledOrNot, "Save button is not enabled");
		managesliderpage.clickSaveButton();
		boolean isAlertMessageDisplayedOrNot=managesliderpage.alertisDisplayed();
		assertTrue( isAlertMessageDisplayedOrNot, "Alert message is not displayed");    
	}
}
