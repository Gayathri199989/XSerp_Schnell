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
import pages.AuditingPage;
import pages.LoginPage;
import pages.SettingPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExpenseTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	SettingPage setting = PageFactory.initElements(Constant.driver, SettingPage.class);
	AuditingPage audit = PageFactory.initElements(Constant.driver, AuditingPage.class);
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
		Constant.logFile("Expense");
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
	public void Test025_AddExpense() throws Exception{
		log.startTestCase("Add Expense");
		extentTest = extent.startTest("Test025_AddExpense",
				"Verify if Expense is added").assignCategory("ExpenseTestCases","SmokeTest");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToExpense();
			boolean flag = audit.addExpense(24, "Sanity Test");
			if(flag){
				Constant.log.info("Expense addition is successful");
				extentTest.log(LogStatus.PASS, "Expense addition is successful");
			}else{
				System.err.println("Expense addition failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test025_AddExpense")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Expense");
	}

	@Test  @Category(SanityTests.class)
	public void Test026_UpdateDraftExpense() throws Exception{
		log.startTestCase("Update draft Expense");
		extentTest = extent.startTest("Test026_UpdateDraftExpense",
				"Verify if draft Expense is updated").assignCategory("ExpenseTestCases","SanityTests");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToExpense();
			boolean flag = audit.updateDraftExpense(25, "Sanity Test");
			if(flag){
				Constant.log.info("Draft Expense update is successful");
				extentTest.log(LogStatus.PASS, "Draft Expense update is successful");
			}else{
				System.err.println("Draft Expense update failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test026_UpdateDraftExpense")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft Expense update");
	}

	@Test  @Category(SanityTests.class)
	public void Test027_ConfirmExpense() throws Exception{
		log.startTestCase("Confirm Expense");
		extentTest = extent.startTest("Test027_ConfirmExpense",
				"Verify if Expense is Confirmed").assignCategory("ExpenseTestCases","SanityTests");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToExpense();
			boolean flag = audit.confirmExpenses(26, "Sanity Test");
			if(flag){
				Constant.log.info("Expense Confirm is successful");
				extentTest.log(LogStatus.PASS, "Expense Confirm is successful");
			}else{
				System.err.println("Expense Confirm failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test027_ConfirmExpense")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Expense Confirm");
	}

	@Test  @Category(SanityTests.class)
	public void Test028_UpdateConfirmedExpense() throws Exception{
		log.startTestCase("Update Confirm Expense");
		extentTest = extent.startTest("Test028_UpdateConfirmedExpense",
				"Verify if confirmed Expense is updated").assignCategory("ExpenseTestCases","SanityTests");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToExpense();
			boolean flag = audit.updateConfirmedExpense(27, "Sanity Test");
			if(flag){
				Constant.log.info("Update Confirm Expense is successful");
				extentTest.log(LogStatus.PASS, "Update Confirm Expense is successful");
			}else{
				System.err.println("Confirmed Expense update failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test028_UpdateConfirmedExpense")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Confirmed Expense update");
	}

	@Test  @Category(SanityTests.class)
	public void Test029_ApproveExpense() throws Exception{
		log.startTestCase("Approve Expense");
		extentTest = extent.startTest("Test029_ApproveExpense",
				"Verify if Expense is Approved").assignCategory("ExpenseTestCases","SanityTests");
		try{
			login.logout();
			boolean flag = audit.ApproveExpenses(28, "Sanity Test");
			if(flag){
				Constant.log.info("Expense Approve is successful");
				extentTest.log(LogStatus.PASS, "Expense Approve is successful");
			}else{
				System.err.println("Expense Approve failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test029_ApproveExpense")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Expense Approve");
	}

	@Test  @Category(SanityTests.class)
	public void Test030_CheckedExpense() throws Exception{
		log.startTestCase("Check Expense");
		extentTest = extent.startTest("Test030_CheckedExpense",
				"Verify if Expense is Checked").assignCategory("ExpenseTestCases","SanityTests");
		try{
			login.logout();
			boolean flag = audit.CheckExpenses(29, "Sanity Test");
			if(flag){
				Constant.log.info("Expense Check is successful");
				extentTest.log(LogStatus.PASS, "Expense Check is successful");
			}else{
				System.err.println("Expense Check failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test030_CheckedExpense")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Expense Check");
	}

	@Test  @Category(SanityTests.class)
	public void Test031_VerifyExpense() throws Exception{
		log.startTestCase("Verify Expense");
		extentTest = extent.startTest("Test031_VerifyExpense",
				"Verify if Expense is Verified").assignCategory("ExpenseTestCases","SanityTests");
		try{
			login.logout();
			boolean flag = audit.verifyExpenses(30, "Sanity Test");
			if(flag){
				Constant.log.info("Expense Verify is successful");
				extentTest.log(LogStatus.PASS, "Expense Verify is successful");
			}else{
				System.err.println("Expense Verify failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test031_VerifyExpense")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Expense Verify");
	}

	@Test  @Category(SanityTests.class)
	public void Test296_ExpenseConfigNoChange() throws Exception{
		log.startTestCase("Expense config without Change");
		extentTest = extent.startTest("Test296_ExpenseConfigNoChange",
				"Verify invoice template saved without change").assignCategory("ExpenseTestCases","SanityTests");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToExpenseConfig();
			boolean flag = setting.expenseConfigSave();
			if(flag){
				Constant.log.info("Verify invoice template saved without change test case is successful");
				extentTest.log(LogStatus.PASS, "Verify invoice template saved without change test case is successful");
			}else{
				System.err.println("Expense config without Change test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test296_ExpenseConfigNoChange")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Expense config without Change");
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
