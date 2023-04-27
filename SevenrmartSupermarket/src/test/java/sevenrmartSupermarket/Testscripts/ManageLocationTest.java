package sevenrmartSupermarket.Testscripts;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManageLocationPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class ManageLocationTest extends Base{
	ManageLocationPage managelocationpage;
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	
	@Test(priority=1 , retryAnalyzer =Retry.class)
	public void addNewLocationToManageLocation() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"SelectCategory");
		String location=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"ManageLocation");
		String deliverycharge=ExcelUtility.getString(0,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"ManageLocation");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickNewButtonToAddLocation();
		WebElement dropDownCountry=driver.findElement(By.xpath("//select[@id='country_id']"));
		Select selectcountry=new Select(dropDownCountry);
		selectcountry.selectByIndex(1);
		WebElement dropDownState=driver.findElement(By.xpath("//select[@id='st_id']"));
		Select selectstate=new Select(dropDownState);
		selectstate.selectByIndex(10);
		managelocationpage.enterLocation(location).enterDeliveryCharge(deliverycharge);
		managelocationpage.clickSaveButtonToAddLocation();
		assertTrue(managelocationpage.alertForAddingLocation(),"New Location not added successfully");
	}
	@Test(priority=4, retryAnalyzer =Retry.class)
	public void searchFromListLocationTableToFindLocation() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"SelectCategory");
		String expectedData=ExcelUtility.getString(2,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"ManageLocation");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickSearchButton();
		WebElement dropDowncountry=driver.findElement(By.xpath("//select[@id='country_id']"));
		Select selectcountrytosearch=new Select(dropDowncountry);
		selectcountrytosearch.selectByIndex(1);
		managelocationpage.enterTheLocationToSearchInTable(expectedData);
		managelocationpage.clickRedSearchButton();
	    assertTrue(managelocationpage.searchListLocationTable(expectedData),"search data not found in list location table");	
		
	}
	
	@Test(priority=3 , retryAnalyzer =Retry.class)
	public void cancelInManageLocation() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"SelectCategory");
		String location=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"ManageLocation");
		String deliverycharge=ExcelUtility.getString(0,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"ManageLocation");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickNewButtonToAddLocation();
		WebElement dropDownCountry=driver.findElement(By.xpath("//select[@id='country_id']"));
		Select selectCountry=new Select(dropDownCountry);
		selectCountry.selectByIndex(1);
		WebElement dropDownState=driver.findElement(By.xpath("//select[@id='st_id']"));
		Select selectState=new Select(dropDownState);
		selectState.selectByIndex(10);
		managelocationpage.enterLocation(location).enterDeliveryCharge(deliverycharge).clickCancelButton();
		assertTrue(managelocationpage.listPageShownAfterCancelling(),"Cancell button not working");
	}
	@Test(priority=2 , retryAnalyzer =Retry.class)
	public void resetInManageLocation() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"SelectCategory");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickSearchButton();
		WebElement dropDownCountrySearchPage=driver.findElement(By.xpath("//select[@id='country_id']"));
		Select selectCountry=new Select(dropDownCountrySearchPage);
		selectCountry.selectByIndex(1);
		managelocationpage.clickResetButton();
		assertTrue(managelocationpage.pageShownAfterClickingResetIsDisplayed(),"Reset button not working");	
	}

}
