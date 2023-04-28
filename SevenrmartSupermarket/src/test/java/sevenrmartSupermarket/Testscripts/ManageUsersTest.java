package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManageUsersPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class ManageUsersTest extends Base{
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	ManageUsersPage  manageuserspage;
	
//	@Test
	public void searchUserFromListUsersTable() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageUser");
		String name=ExcelUtility.getString(0,1, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageUser");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		manageuserspage=new  ManageUsersPage(driver);
	    manageuserspage.clickSearchButton().enterNameInTextBox(name).clickRedSearchButton();
		assertTrue( manageuserspage.searchInTheTable(name),"User name is not found in the table");
	}
	@Test
	public void viewPasswordOfSearchedUser() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageUser");
		String passwordname=ExcelUtility.getString(0,5, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageUser");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		manageuserspage=new  ManageUsersPage(driver);
		manageuserspage.clickSearchButton().enterNameInTextBox(passwordname).clickRedSearchButton();
		manageuserspage.clickPasswordArrowButton();
		assertTrue(manageuserspage.isPasswordDisplayedForSearchedUser(),"password is not displayed");
	}
	@Test
	public void deleteAnUserFromTable() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageUser");
		String deletename=ExcelUtility.getString(0,2, System.getProperty("user.dir") +constants.Constants.TESTDATAFILE, "ManageUser");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		 manageuserspage=new  ManageUsersPage(driver);
		 manageuserspage.clickSearchButton().enterNameInTextBox(deletename).clickRedSearchButton();
		 manageuserspage.clickDeleteButton();
		 driver.switchTo().alert().accept();
		 assertTrue(manageuserspage.isAlertDisplayedWhenUserIsDEletedFromTable(),"User is not deleted from table");
		
	}

}
