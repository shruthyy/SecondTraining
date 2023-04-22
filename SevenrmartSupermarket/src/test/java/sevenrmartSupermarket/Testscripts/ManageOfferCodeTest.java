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
	public  ManageOfferCodePage manageOfferCodePage;

	@Test(retryAnalyzer = Retry.class)
	@Parameters({"offercode"})
	public void verify_seraching_With_Offercode_Shows_Corressponding_Details(String offercode) throws IOException {
		String userName=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
   	    String password=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"LoginPage");
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
	    manageOfferCodePage=new ManageOfferCodePage(driver);
	    manageOfferCodePage.clickOnManageOfferLink().clickonSearchButton().enterOfferCode(offercode).clickonSearchSubmitButton();
	    assertTrue(manageOfferCodePage.searchInTheTable(offercode),"Offercode is not shown in list");
		}

	}




