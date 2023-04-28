package sevenrmartSupermarket.Testscripts;



import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManageDeliveryBoyPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	ManageDeliveryBoyPage managedeliveryboypage;
	
//	@Test
	public void addNewDeliveryBoyDetails() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String input=ExcelUtility.getString(0,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageDeliveryBoy");
   	    String name=ExcelUtility.getString(0,1, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageDeliveryBoy");
   	    String passwordnew=ExcelUtility.getString(1,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageDeliveryBoy");
   	    String username=ExcelUtility.getString(0,3, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageDeliveryBoy");
   	    String deliveryboynew=ExcelUtility.getString(2,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageDeliveryBoy");
   	    loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickNewButtonToAddDeliveryBoy().enterNameToAddNewDeliveryBoy(name).enterUsernameToAddNewDeliveryBoy(username).enterPasswordToAddNewDeliveryBoy(passwordnew);
		managedeliveryboypage.clickSaveButtonToAddDeliveryBoy();
		assertTrue(managedeliveryboypage.searchInTheTable(deliveryboynew),"New Delivery Boy Details are not added successfully");	
	}
//	@Test
	@Parameters({"phone"})
	public void searchWithPhoneNumber(String phone) throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String input=ExcelUtility.getString(0,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageDeliveryBoy");
    	loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickSearchButton();
		managedeliveryboypage.enterPhNumbToTextBox(phone);
		managedeliveryboypage.clickRedSearchButton();
	//	assertTrue(managedeliveryboypage.isSearchWithPhoneNumberResultDisplayed(),"New Delivery Boy Details are not added successfully");

	}
	@Test
	public void verifyCancelButtonWorking() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String input=ExcelUtility.getString(0,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageDeliveryBoy");
   	    String name=ExcelUtility.getString(0,1, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageDeliveryBoy");
   	    loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickNewButtonToAddDeliveryBoy().enterNameToAddNewDeliveryBoy(name);
		managedeliveryboypage.clickCancelButton();
		assertTrue(managedeliveryboypage.isListDeliveryBoyPagDisplayedAfterCancel(),"Cancel button is not working");	
	}

}
