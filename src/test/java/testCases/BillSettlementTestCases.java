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

import category.HighPriorityTestCases;
import category.SmokeTest;
import pages.BillSettlementPage;
import pages.LoginPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BillSettlementTestCases {

	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);
	BillSettlementPage settle = PageFactory.initElements(Constant.driver, BillSettlementPage.class);

	static ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	static String extentReportFile;
	static ExtentReports extent;
	static ExtentTest extentTest;

	@BeforeClass
	public static void BeforeClass() throws Exception{
		extentReportFile = property.getExtentReportFile()+"ExtentReport"+Constant.date+"."+"html";
		// Create object of extent report and specify the report file path.
		extent = new ExtentReports(extentReportFile, false);
		Constant.logFile("Delivery challan");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(SmokeTest.class)
	public void Test013_settle_Advance() throws Exception{
		log.startTestCase("Settle bill with advance");
		extentTest = extent.startTest("Test013_settle_Advance",
				"Verify if bill settled with advance").assignCategory("BillSettlementTestCases","SmokeTest");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToBillSettlement();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = settle.billSettlement_Advance(12, "Settlement");
			if(flag){
				Constant.log.info("Verify if bill settled with advance test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if bill settled with advance test case is successful");
			}else{
				System.err.println("Settle bill with advance test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test013_settle_Advance")));
//				int a = Constant.createBug("Accounts", "Settle bill with advance test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Settle bill with advance");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test017_CreateVoucher_Amount() throws Exception{
		log.startTestCase("Create Voucher with amount");
		extentTest = extent.startTest("Test017_CreateVoucher_Amount",
				"Verify if Create Voucher with amount").assignCategory("BillSettlementTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToBillSettlement();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = settle.CreateVoucher_Amount(16, "Settlement");
			if(flag){
				Constant.log.info("Verify if Create Voucher with amount test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Create Voucher with amount test case is successful");
			}else{
				System.err.println("Create Voucher with amount test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test017_CreateVoucher_Amount")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Create Voucher with amount");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test018_CreateVoucherNSettle_Amount() throws Exception{
		log.startTestCase("Create Voucher and settle with amount");
		extentTest = extent.startTest("Test018_CreateVoucherNSettle_Amount",
				"Verify if Create Voucher and settle with amount").assignCategory("BillSettlementTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToBillSettlement();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = settle.CreateVoucherNSettle_AmountNAdv(17, "Settlement");
			if(flag){
				Constant.log.info("Verify if Create Voucher and settle with amount test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Create Voucher and settle with amount test case is successful");
			}else{
				System.err.println("Create Voucher and settle with amount test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test018_CreateVoucherNSettle_Amount")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Create Voucher and settle with amount");
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
