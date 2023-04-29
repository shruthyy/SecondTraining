package sevenrmartSupermarket.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import sevenrmartSupermarket.Pages.LoginPage;
import sevenrmartSupermarket.Pages.ManageCategoryPage;

public class ManageCategoryTest extends Base {
	LoginPage loginpage;
	ManageCategoryPage managecategorypage;

	@Test(retryAnalyzer =Retry.class)
	public void searchFromListCategoryTable() throws IOException {
		String userName = ExcelUtility.getString(0, 0,System.getProperty("user.dir") + constants.Constants.TESTDATAFILE, "LoginPage");
		String password = ExcelUtility.getString(0, 1,System.getProperty("user.dir") + constants.Constants.TESTDATAFILE, "LoginPage");
		String category = ExcelUtility.getString(0, 0,System.getProperty("user.dir") + constants.Constants.TESTDATAFILE, "ManageCategory");
		loginpage = new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.clickCategoryMoreInfoButton().clickSearchButton().enterCategoryToTextBoxForSearching(category).clickRedSearchButton();
		assertTrue(managecategorypage.searchInTheTable(category), "searched category not found");
	}
	@Test(retryAnalyzer =Retry.class)
	public void verifyClickingResetButtonToGoToListCategoryPage() throws IOException {
		String userName = ExcelUtility.getString(0, 0,System.getProperty("user.dir") + constants.Constants.TESTDATAFILE, "LoginPage");
		String password = ExcelUtility.getString(0, 1,System.getProperty("user.dir") + constants.Constants.TESTDATAFILE, "LoginPage");
		String category = ExcelUtility.getString(0, 0,System.getProperty("user.dir") + constants.Constants.TESTDATAFILE, "ManageCategory");
		loginpage = new LoginPage(driver);
		loginpage.enterUserName(userName).enterPassword(password).clickSignInButton();
		managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.clickCategoryMoreInfoButton().clickSearchButton().enterCategoryToTextBoxForSearching(category).clickResetButton();
		assertTrue(managecategorypage.isListCategoryPageDisplayedAfterClickingResetButton(),"List Category Page not displayed after reset");
	}

}
