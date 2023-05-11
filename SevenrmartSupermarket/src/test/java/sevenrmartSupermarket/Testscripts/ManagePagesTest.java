package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import retry.Retry;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManagePagesPages;

public class ManagePagesTest extends Base{
	 LoginPage loginpage;
	 ManagePagesPages  managepagespages;
	 
	 @Test(retryAnalyzer =Retry.class)
	 @Parameters({"title"})
	 public void verifyCorrespondingPageTitleFromListPagesTableIsDisplayedByClickingSearchButtonAndEnteringTitleOfPage(String title) throws IOException {
		 String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
	   	 String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
	   	 loginpage=new LoginPage(driver);
		 loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		 managepagespages=new  ManagePagesPages(driver);
		 managepagespages.selectManagePagesMoreInfoLink();
		 managepagespages.clickSearchButton().enterTitleToSearchInListPages(title).clickRedSearchButton();
		 assertTrue( managepagespages.isSearchedTitleFoundFromListPagesTable(),"Searched title not found");
	 }
	 @Test(retryAnalyzer =Retry.class)
	 @Parameters({"update","updatecolor"})
	 public void verifyAlertIsDisplayed_WhenUpdateButtonIsClickedAfterEnteringTheTitleToBeUpdated(String update,String updatecolor) throws IOException {
		 String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
	   	 String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
	   	 loginpage=new LoginPage(driver);
		 loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		 managepagespages=new  ManagePagesPages(driver);
		 managepagespages.selectManagePagesMoreInfoLink();
		 managepagespages.clickSearchButton().enterTitleToUpdate(update).clickRedSearchButton().clickUpdateButton().
		 makeChangesInPageTextBoxToUpdate(updatecolor).clickRedUpdateButton();
		 assertTrue(managepagespages.isAlertDisplayedAfterUpdation(),"Updation successful alert not displayed");
	 }
	 @Test(retryAnalyzer =Retry.class)
	 public void verifyDuplicatePageAlertIsDisplayed_WhenExistingPageDetailsAreEnteredAfterClickingNewButton() throws IOException {
		 String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
	   	 String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
	     String duplicatetitle=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"ManagePages");
	   	 String duplicatepagename=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"ManagePages");
	     loginpage=new LoginPage(driver);
		 loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		 managepagespages=new  ManagePagesPages(driver);
		 managepagespages.selectManagePagesMoreInfoLink();
		 managepagespages.clickNewButton().enterTitleToAddDuplicatePage(duplicatetitle).
		 enterPagenameToAddDuplicatePage(duplicatepagename).clickSaveButtonToAddDuplicatePage();
		 assertTrue(managepagespages.isAlertDisplayedForDuplicatePage(),"Duplicate page created alert not displayed"); 
	 }
	 @Test(retryAnalyzer =Retry.class)
	 @Parameters({"title"})
	 public void verifyUserIsAbleToViewListPageByClickingSearchAndEnteringTitle_andClickResetButton(String title) throws IOException {
		 String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
	   	 String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
	   	 loginpage=new LoginPage(driver);
		 loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		 managepagespages=new  ManagePagesPages(driver);
		 managepagespages.selectManagePagesMoreInfoLink();
		 managepagespages.clickSearchButton().enterTitleToSearchInListPages(title).clickResetButton();
		 assertTrue( managepagespages.isListPageDisplayedAfterClickingResetButton(),"ListPage is not Displayed after reseting");
	 }
}
