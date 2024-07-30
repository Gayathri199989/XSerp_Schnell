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
import category.SanityTests;
import pages.AccountsPage;
import pages.LoginPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankReconTestCases {

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
		Constant.logFile("Bank Reconcilation");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test013_BankVoucher_Receipt() throws Exception{
		log.startTestCase("Bank voucher with receipt validation");
		extentTest = extent.startTest("Test013_BankVoucher_Receipt",
				"Validate bank voucher with receipt validation").assignCategory("BankReconTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.validateBRS_AddingVoucher(12,"BRS");
			if(flag){
				Constant.log.info("Bank voucher with receipt validation test case is successful");
				extentTest.log(LogStatus.PASS, "Bank voucher with receipt validation test case is successful");
			}else{
				System.err.println("Bank voucher with receipt validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test013_BankVoucher_Receipt")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Bank voucher with receipt validation");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test014_BankVoucher_Payment() throws Exception{
		log.startTestCase("Bank voucher for payment validation");
		extentTest = extent.startTest("Test014_BankVoucher_Payment",
				"Validate bank voucher for payment validation").assignCategory("BankReconTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.validateBRS_AddingVoucher(13,"BRS");
			if(flag){
				Constant.log.info("Bank voucher for payment validation test case is successful");
				extentTest.log(LogStatus.PASS, "Bank voucher for payment validation test case is successful");
			}else{
				System.err.println("Bank voucher for payment validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test014_BankVoucher_Payment")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Bank voucher for payment validation");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test015_GeneralVoucher_BV() throws Exception{
		log.startTestCase("General voucher for BV validation");
		extentTest = extent.startTest("Test015_GeneralVoucher_BV",
				"Validate General voucher for BV validation").assignCategory("BankReconTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.validateBRS_AddingVoucher(14,"BRS");
			if(flag){
				Constant.log.info("General voucher for BV validation test case is successful");
				extentTest.log(LogStatus.PASS, "General voucher for BV validation test case is successful");
			}else{
				System.err.println("General voucher for BV validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test015_GeneralVoucher_BV")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("General voucher for BV validation");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test016_CashVoucher_BV() throws Exception{
		log.startTestCase("Cash voucher for BV validation");
		extentTest = extent.startTest("Test016_CashVoucher_BV",
				"Validate Cash voucher for BV validation").assignCategory("BankReconTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.validateBRS_AddingVoucher(15,"BRS");
			if(flag){
				Constant.log.info("Cash voucher for BV validation test case is successful");
				extentTest.log(LogStatus.PASS, "Cash voucher for BV validation test case is successful");
			}else{
				System.err.println("Cash voucher for BV validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test016_CashVoucher_BV")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Cash voucher for BV validation");
	}


	@Test  @Category(SanityTests.class)
	public void Test147_ValidateBankReconciliationCol() throws Exception{
		log.startTestCase("Bank Reconciliation Column validation");
		extentTest = extent.startTest("Test147_ValidateBankReconciliationCol",
				"Validate bank reconciliation column validation").assignCategory("BankReconTestCases","SanityTests");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToBankReconciliation();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = accounts.bankReconciliationColumnValidation(146,"Sanity Test");
			if(flag){
				Constant.log.info("Bank reconciliation column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Bank reconciliation column validation test case is successful");
			}else{
				System.err.println("Bank reconciliation column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test147_ValidateBankReconciliationCol")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Bank Reconciliation Column vlaidation");
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
