package testCases;


import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import category.SanityTests;
import category.SmokeTest;
import pages.AccountsPage;
import pages.LoginPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LedgerTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	AccountsPage accounts = PageFactory.initElements(Constant.driver, AccountsPage.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);

	static ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	static String extentReportFile;
	static ExtentReports extent;
	static ExtentTest extentTest;


	@BeforeClass
	public static void BeforeClass() throws Exception{
		extentReportFile = property.getExtentReportFile()+"ExtentReport"+Constant.date+"."+"html";
		// Create object of extent report and specify the report file path.
		extent = new ExtentReports(extentReportFile, false);
		Constant.logFile("Ledger");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Category(SmokeTest.class)
	@Test
	public void Test062_CreateLedger() throws Exception{
		log.startTestCase("Create Ledger");
		extentTest = extent.startTest("Test062_CreateLedger",
				"Verify whether ledger can be created ").assignCategory("LedgerTestCases","SmokeTest");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToLedger();
			boolean flag = accounts.addLedger(61,"Sanity Test");
			if(flag){
				Constant.log.info("Ledger creation test case is successful");
				extentTest.log(LogStatus.PASS, "Ledger creation test case is successful");
			}else{
				System.err.println("Ledger creation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test062_CreateLedger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Ledger creation");
	}

	@Test  @Category(SanityTests.class)
	public void Test063_UpdateLedger() throws Exception{
		log.startTestCase("Update Ledger");
		extentTest = extent.startTest("Test063_UpdateLedger",
				"Verify whether ledger can be Updated ").assignCategory("LedgerTestCases","SanityTests");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToLedger();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = accounts.updateLedger(62,"Sanity Test");
			if(flag){
				Constant.log.info("Ledger Update test case is successful");
				extentTest.log(LogStatus.PASS, "Ledger Update test case is successful");
			}else{
				System.err.println("Ledger Update test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test063_UpdateLedger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Ledger Update");
	}

	@After
	public void After() throws Exception{
		try{
			login.logout();
			// close report.
			extent.endTest(extentTest);
		}catch(Exception e){
			System.err.println("Logout unsuccessfull "+e);
			Constant.captureScreen_Negative("Logout");
		}
	}

	@AfterClass
	public static void AfterClass() throws Exception{
		Constant.closeBrowser();
		// writing everything to document.
    	extent.flush();
    	extent.close();
	}
}
