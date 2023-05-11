package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;
import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import retry.Retry;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManageSliderPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class ManageSliderTest extends Base {
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	ManageSliderPage  managesliderpage;
		
	@Test(groups= {"smoke"},retryAnalyzer =Retry.class)
	public void verifyAlertIsDisplayed_WhenNewButtonIsClickedAnd_linkIsEnteredAndSaved() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,1, GeneralUtility.TESTDATAFILE, "ManageSlider");
		String newlink=ExcelUtility.getString(0,0, GeneralUtility.TESTDATAFILE, "ManageSlider");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		managesliderpage=new ManageSliderPage(driver);
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);	
		managesliderpage.clickNewButton().enterLinkToLinkTextBox(newlink).clickSaveButton();
		assertTrue( managesliderpage.alertisDisplayed(), "link is not added successfully");    
	}
	@Test(retryAnalyzer =Retry.class)
	public void verifyAlertIsDisplayedByClickingNewButtonAndAddingLink_ClickChooseFileAndSaveToUploadImageInSlider() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE, "ManageSlider");
		String newlink=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE, "ManageSlider");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		managesliderpage=new ManageSliderPage(driver);
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);	
		managesliderpage.clickNewButton().enterLinkToLinkTextBox(newlink).uploadImageToAddSlider().clickSaveButton();
		assertTrue( managesliderpage.alertisDisplayed(), "Alert for adding link is not displayed");    	
	}
	@Test(groups= {"smoke"},retryAnalyzer =Retry.class)
	public void veriftHomePageIsDisplayed_ByClickingHomeButtonFromListSliderPage() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,1, GeneralUtility.TESTDATAFILE, "ManageSlider");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		managesliderpage=new ManageSliderPage(driver);
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managesliderpage=new ManageSliderPage(driver);
		managesliderpage.clickHomeButtonFromListSliderPage();
		assertTrue(managesliderpage.isHomePageDisplayedAfterClickingHomeButton(),"Home page not displayed after clicking homebutton");
	}
	@Test(retryAnalyzer =Retry.class)
	public void verifyUserIsAbleToViewListSlidersPage_WhenCancelButtonIsClickedAfterEnteringLinkInLinkTextBox() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,1, GeneralUtility.TESTDATAFILE, "ManageSlider");
		String newlink=ExcelUtility.getString(0,0, GeneralUtility.TESTDATAFILE, "ManageSlider");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		managesliderpage=new ManageSliderPage(driver);
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);	
		managesliderpage.clickNewButton().enterLinkToLinkTextBox(newlink).clickCancelButton();
		assertTrue(managesliderpage.isListSliderPageDisplayedAfterClickingCancelButton(),"List Slider page not displayed");
	}
	@Test(retryAnalyzer =Retry.class)
	public void verifyBackgroundcolorIsAsExpected_ByGettingCssValueOfNewButton() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,1, GeneralUtility.TESTDATAFILE, "ManageSlider");
		String expectedBackgroundcolor=ExcelUtility.getString(1,0, GeneralUtility.TESTDATAFILE,"ManageSlider");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);	
		managesliderpage=new ManageSliderPage(driver);
		String actualBackgroundcolor=managesliderpage.toGetBackgroundColourOfNewButton();
		assertEquals(actualBackgroundcolor,expectedBackgroundcolor,"Background color is not same");	
	}
}



