package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import retry.Retry;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManageOfferCodePage;


public class ManageOfferCodeTest extends Base {
	LoginPage loginpage;
	public  ManageOfferCodePage manageoffercodepage;

	@Test(retryAnalyzer = Retry.class)
	@Parameters({"offercode"})
	public void verifySearchedOfferCodeIsFoundInListOffercodeTableByEnteringtheOffercodeInSearchBox(String offercode) throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferLink().clickonSearchButton().enterOfferCode(offercode).clickonSearchSubmitButton();
	    assertTrue( manageoffercodepage.searchInTheTable(offercode),"Offercode is not shown in list");
		}
	@Test(retryAnalyzer = Retry.class)
	public void verifyAlertIsDisplayedUponAddingNewOfferCodeWithRequiredDetails() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String newoffer=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"ManageOfferCode");
   	    String percentage=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"ManageOfferCode");
   	    String amount=ExcelUtility.getString(0,2,GeneralUtility.TESTDATAFILE,"ManageOfferCode");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferLink().clickAddButtonToAddNewOfferCode().enterOfferCodeToAddNewOffer(newoffer).enterPercentage(percentage).enterAmount(amount);
		manageoffercodepage.clickSaveButton();
	    assertTrue( manageoffercodepage.isAlertDisplayedWhenNewOfferCodeIsAdded(),"Alert when New Offer code is created is not displayed");
	}
	@Test(retryAnalyzer = Retry.class)
	public void verifyAlertIsDisplayedOnEnteringOffercodeAndUpdatingOffercodeImage() throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String summeroffer=ExcelUtility.getString(1,0,GeneralUtility.TESTDATAFILE,"ManageOfferCode");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferLink().clickonSearchButton().enterOffercodeToEditImage(summeroffer).clickonSearchSubmitButton().clickUpdateButton().chooseImageToUpdate();
	    assertTrue(manageoffercodepage.isAlertDisplayedWhenImageIsUpdated(),"Alert not shown after Image updation");
	}
	@Test(retryAnalyzer =Retry.class)
	@Parameters({"offercode"})
	public void verifyAlertIsDispalyedWhenResetButtonIsClickedAfterEnteringOffercodeInSearchBox(String offercode) throws IOException {
		String userName=ExcelUtility.getString(0,0,GeneralUtility.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,GeneralUtility.TESTDATAFILE,"LoginPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferLink().clickonSearchButton().enterOfferCode(offercode).clickResetButton();
		assertTrue(manageoffercodepage.isAlertDisplayedAfterClickingReset(),"Reset alert not displayed");		 
	}
}




