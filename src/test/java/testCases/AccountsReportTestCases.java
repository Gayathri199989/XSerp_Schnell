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
import pages.AccountsPage;
import pages.LoginPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountsReportTestCases {

	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
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
		Constant.logFile("Accounts Report");
		 //Browser Initialization
		 Constant.BrowserInitialization();

	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}


	@Test  @Category(SanityTests.class)
	public void Test071_GstrPurchaseReportColumnValidation() throws Exception{
		log.startTestCase(" gstr purchase report column validation");
		 extentTest = extent.startTest("Test071_GstrPurchaseReportColumnValidation",
					"Verify gstr purchase report column validation").assignCategory("AccountsReportTestCases","SanityTests");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGstrPurchasereport();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = accounts.gstrpurchaseReportColumnValidation(70,"Sanity Test");
			if(flag){
				Constant.log.info("Verify gstr purchase report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Verify gstr purchase report column validation test case is successful");
			}else{
				System.err.println(" gstr purchase report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test071_GstrPurchaseReportColumnValidation")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase(" gstr purchase report column validation");
	}

	@Test  @Category(SanityTests.class)
	public void Test072_GSTRSalesReportColumnValidation() throws Exception{
		log.startTestCase("GSTR Sales report column validation");
		extentTest = extent.startTest("Test072_GSTRSalesReportColumnValidation",
				"Verify GSTR Sales report column validation").assignCategory("AccountsReportTestCases","SanityTests");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGSTRSalesReport();
			boolean flag = accounts.gstrSalesReportColumnValidation(71,"Sanity Test");
			if(flag){
				Constant.log.info("Verify GSTR Sales report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Verify GSTR Sales report column validation test case is successful");
			}else{
				System.err.println("GSTR Sales report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test072_GSTRSalesReportColumnValidation")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("GSTR Sales report column validation");
	}

	@Test  @Category(SanityTests.class)
	public void Test294_PurchaseRegisterReportColumnValidation() throws Exception{
		log.startTestCase(" Purchase Register report column validation");
		extentTest = extent.startTest("Test294_PurchaseRegisterReportColumnValidation",
				"Verify SanityTests Register report column validation").assignCategory("AccountsReportTestCases","SanityTests");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchaseRegister();
			boolean flag = accounts.purchaseRegistReportColumnValidation(293,"Sanity Test");
			if(flag){
				Constant.log.info("Verify Purchase Register report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Purchase Register report column validation test case is successful");
			}else{
				System.err.println(" Purchase Register report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test294_PurchaseRegisterReportColumnValidation")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase(" Purchase Register report column validation");
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
