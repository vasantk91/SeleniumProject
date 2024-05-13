package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import java.util.logging.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.test.SimpleFramework.simpleFramework.Base;

import DataProvider.DataProviderHomePage;

import Pages.HomePage;
import Pages.LoginPage;

public class TestCases extends Base {

	private static final Logger logger = Logger.getLogger(TestCases.class.getName());

	HomePage homepage;
	LoginPage loginPage;

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	@Parameters({ "browser" })
	public void createBrowserObject(String browser) throws IOException {
		initialization(browser);
		loginPage = new LoginPage();
		homepage = new HomePage();

	}

	@Test(dataProvider = "getData", priority = 1, dataProviderClass = DataProviderHomePage.class, testName = "{0}", description = "reg link Test")
	public void MyAccountLink(String TCID, String Regurl,String username, String Password) {

		logger.info("Verifying MyAccount link");
		loginPage.VerifyLogin(username, Password);
		homepage.verifyMyAccountLink(TCID, Regurl);
		logger.info("Completed RegisterLink sucessfully...");

	}

//	@Test(dataProvider = "getData2", priority = 2, dataProviderClass = DataProviderHomePage.class, description = "Login into app")
//	public void LoginTest(String username, String Password) {
//		logger.info("Starting Login Test");
//		loginPage.VerifyLogin(username, Password);
//		logger.info("Completed Login test sucessful...");
//	}

	@AfterMethod
	public void TearDown() {
		tearDown();
	}

	@AfterClass
	public static void cleanup() {
		logger.info("All tests completed.");
	}
}
