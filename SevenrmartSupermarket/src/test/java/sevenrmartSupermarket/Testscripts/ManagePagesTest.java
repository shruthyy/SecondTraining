package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManagePagesPages;

public class ManagePagesTest extends Base{
	 LoginPage loginpage;
	 ManagePagesPages  managepagespages;
	 
	 @Test(retryAnalyzer =Retry.class)
	 @Parameters({"title"})
	 public void searchPageUsingTitleFromListPageTable(String title) throws IOException {
		 String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
	   	 String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
	   	 loginpage=new LoginPage(driver);
		 loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		 managepagespages=new  ManagePagesPages(driver);
		 managepagespages.selectManagePagesMoreInfoLink();
		 managepagespages.clickSearchButton().enterTitleToSearchInListPages(title).clickRedSearchButton();
		 assertTrue( managepagespages.isSearchedTitleFoundFromListPagesTable(),"Searched title not found");
	 }
	 @Test(retryAnalyzer =Retry.class)
	 @Parameters({"update","updatecolor"})
	 public void updateListPageAfterSearchingFromListPageTable(String update,String updatecolor) throws IOException {
		 String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
	   	 String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
	   	 loginpage=new LoginPage(driver);
		 loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		 managepagespages=new  ManagePagesPages(driver);
		 managepagespages.selectManagePagesMoreInfoLink();
		 managepagespages.clickSearchButton().enterTitleToUpdate(update).clickRedSearchButton().clickUpdateButton().
		 makeChangesInPageTextBoxToUpdate(updatecolor).clickRedUpdateButton();
		 assertTrue(managepagespages.isAlertDisplayedAfterUpdation(),"Updation is not successful");
	 }
	 @Test(retryAnalyzer =Retry.class)
	 public void verifyDuplicatePageCreation() throws IOException {
		 String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
	   	 String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
	     String duplicatetitle=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"ManagePages");
	   	 String duplicatepagename=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"ManagePages");
	     loginpage=new LoginPage(driver);
		 loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		 managepagespages=new  ManagePagesPages(driver);
		 managepagespages.selectManagePagesMoreInfoLink();
		 managepagespages.clickNewButton().enterTitleToAddDuplicatePage(duplicatetitle).enterPagenameToAddDuplicatePage(duplicatepagename).clickSaveButtonToAddDuplicatePage();
		 assertTrue(managepagespages.isAlertDisplayedForDuplicatePage(),"Duplicate page can be added");
	 
	 }
	 @Test(retryAnalyzer =Retry.class)
	 @Parameters({"title"})
	 public void clickResetButtonToGetListPagesTablePage(String title) throws IOException {
		 String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
	   	 String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
	   	 loginpage=new LoginPage(driver);
		 loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		 managepagespages=new  ManagePagesPages(driver);
		 managepagespages.selectManagePagesMoreInfoLink();
		 managepagespages.clickSearchButton().enterTitleToSearchInListPages(title).clickResetButton();
		 assertTrue( managepagespages.isListPageDisplayedAfterClickingResetButton(),"Reset button not working");
	 }

}
