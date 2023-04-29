package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utilities.ExcelUtility;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManageOfferCodePage;


public class ManageOfferCodeTest extends Base {
	LoginPage loginpage;
	public  ManageOfferCodePage manageoffercodepage;

	@Test(retryAnalyzer = Retry.class)
	@Parameters({"offercode"})
	public void verify_seraching_With_Offercode_Shows_Corressponding_Details(String offercode) throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferLink().clickonSearchButton().enterOfferCode(offercode).clickonSearchSubmitButton();
	    assertTrue( manageoffercodepage.searchInTheTable(offercode),"Offercode is not shown in list");
		}
	@Test(retryAnalyzer = Retry.class)
	public void addNewOfferCode() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String newoffer=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"ManageOfferCode");
   	    String percentage=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"ManageOfferCode");
   	    String amount=ExcelUtility.getString(0,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"ManageOfferCode");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferLink().clickAddButtonToAddNewOfferCode().enterOfferCodeToAddNewOffer(newoffer).enterPercentage(percentage).enterAmount(amount);
		manageoffercodepage.clickSaveButton();
	    assertTrue( manageoffercodepage.isAlertDisplayedWhenNewOfferCodeIsAdded(),"New Offer code is not created");
	}
//	@Test(retryAnalyzer = Retry.class)
	public void updateOfferCodeImage() throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String summeroffer=ExcelUtility.getString(1,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"ManageOfferCode");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferLink().clickonSearchButton().enterOffercodeToEditImage(summeroffer).clickonSearchSubmitButton().clickUpdateButton().chooseImageToUpdate();
	    assertTrue(manageoffercodepage.isAlertDisplayedWhenImageIsUpdated(),"Image updation not successful");
	}
	@Test(retryAnalyzer =Retry.class)
	@Parameters({"offercode"})
	public void verifyResetButtonToStartNewSearch(String offercode) throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferLink().clickonSearchButton().enterOfferCode(offercode).clickResetButton();
		assertTrue(manageoffercodepage.isAlertDisplayedAfterClickingReset(),"Reset button not working");		 
	}
}




