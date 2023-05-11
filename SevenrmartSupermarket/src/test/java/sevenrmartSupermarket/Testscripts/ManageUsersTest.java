package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import retry.Retry;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManageUsersPage;
import sevenrmartSupermarket.Pages.SelectCategoryPage;

public class ManageUsersTest extends Base{
	LoginPage loginpage;
	SelectCategoryPage selectcategorypage;
	ManageUsersPage  manageuserspage;
	
	@Test(retryAnalyzer =Retry.class)
	public void verifyUserIsAbleToGetTheSearchedUserInfoFromListUsersTable_ByClickingSearchButtonAndEnteringTheName() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0, GeneralUtility.TESTDATAFILE, "ManageUser");
		String name=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE, "ManageUser");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		manageuserspage=new  ManageUsersPage(driver);
	    manageuserspage.clickSearchButton().enterNameInTextBox(name).clickRedSearchButton();
		assertTrue( manageuserspage.searchInTheTable(name),"User name is not found in the table");
	}
	@Test(retryAnalyzer =Retry.class)
	public void verifyPasswordOfSearchedUserIsDisplayed_ByClickingPasswordViewButtonOfTheUserFromListUsersTable() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0, GeneralUtility.TESTDATAFILE, "ManageUser");
		String passwordname=ExcelUtility.getString(0,5, GeneralUtility.TESTDATAFILE, "ManageUser");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		manageuserspage=new  ManageUsersPage(driver);
		manageuserspage.clickSearchButton().enterNameInTextBox(passwordname).clickRedSearchButton();
		manageuserspage.clickPasswordArrowButton();
		assertTrue(manageuserspage.isPasswordDisplayedForSearchedUser(),"password is not displayed");
	}
	@Test(retryAnalyzer =Retry.class)
	public void verifyAlertIsDisplayed_WhenDeleteButtonIsClickedAfterSearchingAnUserFromListUsersTable() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		String input=ExcelUtility.getString(0,0, GeneralUtility.TESTDATAFILE, "ManageUser");
		String deletename=ExcelUtility.getString(0,2, GeneralUtility.TESTDATAFILE, "ManageUser");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		selectcategorypage=new SelectCategoryPage(driver);
		selectcategorypage.SelectCategoryElement(input);
		manageuserspage=new  ManageUsersPage(driver);
		manageuserspage.clickSearchButton().enterNameInTextBox(deletename).clickRedSearchButton();
		manageuserspage.clickDeleteButton();
		manageuserspage.popupSelectOk();
		assertTrue(manageuserspage.isAlertDisplayedWhenUserIsDEletedFromTable(),"Alert for delete not displayeds");		
	}
}
