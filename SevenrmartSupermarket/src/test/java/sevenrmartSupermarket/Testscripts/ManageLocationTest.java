package sevenrmartSupermarket.Testscripts;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import retry.Retry;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManageLocationPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class ManageLocationTest extends Base{
	ManageLocationPage managelocationpage;
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	
	@Test(priority=1 , retryAnalyzer =Retry.class)
	public void verifyAleryIsDisplayedWhenNewButtonIsClickedToAddLocationInManageLocationListTableWithRequiredDetails() throws IOException {
		String userName=ExcelUtility.getString(0,0, GeneralUtility.TESTDATAFILE,"LoginPage");
	    String password=ExcelUtility.getString(0,1, GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"SelectCategory");
		String location=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"ManageLocation");
		String deliverycharge=ExcelUtility.getString(0,2, GeneralUtility.TESTDATAFILE,"ManageLocation");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickNewButtonToAddLocation().selectCountryFronDropDown().selectStateFromDropDown().
		enterLocation(location).enterDeliveryCharge(deliverycharge);
		managelocationpage.clickSaveButtonToAddLocation();
		assertTrue(managelocationpage.alertForAddingLocation(),"New Location not added successfully");
	}
	@Test(priority=4, retryAnalyzer =Retry.class)
	public void verifySearchedLocationIsFoundInListLocationTableWhenLocationIsSearchedWithRequiredDetails() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"SelectCategory");
		String expectedData=ExcelUtility.getString(2,0,GeneralUtility.TESTDATAFILE,"ManageLocation");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickSearchButton().selectCountryFronDropDown().enterLocation(expectedData).clickRedSearchButton();
	    assertTrue(managelocationpage.searchListLocationTable(expectedData),"search data not found in list location table");			
	}
	
	@Test(priority=3 , retryAnalyzer =Retry.class)
	public void verifyListLocationPageIsDisplayedWhenCancelButtonIsClickedAfterEnteringSearchDetails() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"SelectCategory");
		String location=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"ManageLocation");
		String deliverycharge=ExcelUtility.getString(0,2,GeneralUtility.TESTDATAFILE,"ManageLocation");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickNewButtonToAddLocation().selectCountryFronDropDown().selectStateFromDropDown().
		enterLocation(location).enterDeliveryCharge(deliverycharge).clickCancelButton();
		assertTrue(managelocationpage.listPageShownAfterCancelling(),"ListPage not displayed after cancelling");
	}
	@Test(priority=2 , retryAnalyzer =Retry.class)
	public void verifyListLocationPagesIsDisplayedWhenResetButtonIsClickedAfterEnteringSearchDetails() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"SelectCategory");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickSearchButton().selectCountryFronDropDown().clickResetButton();
		assertTrue(managelocationpage.pageShownAfterClickingResetIsDisplayed(),"List location page is not displayed after clicking Reset button");	
	}
}
