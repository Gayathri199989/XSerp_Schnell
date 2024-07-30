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
import pages.LoginPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoresReportTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
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
		Constant.logFile("Stores Report");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(SanityTests.class)
	public void Test034_StockReportColumnValidation() throws Exception{
		log.startTestCase("Stock Report column validation");
		extentTest = extent.startTest("Test034_StockReportColumnValidation",
				"Verify Stock Report column validation").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToStockReport();
			boolean flag = store.closingStockColumnValidation(33, "Sanity Test");
			if(flag){
				Constant.log.info("Stock Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Stock Report column validation test case is successful");
			}else{
				System.err.println("Stock Report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test034_StockReportColumnValidation")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Stock Report column validation");
	}

	@Test  @Category(SanityTests.class)
	public void Test035_POPendingReportColumnValidation() throws Exception{
		log.startTestCase("PO Report column validation");
		extentTest = extent.startTest("Test035_POPendingReportColumnValidation",
				"Verify PO Report column validation").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToStockReport();
			boolean flag = store.poPendingColumnValidation(34,"Sanity Test");
			if(flag){
				Constant.log.info("PO Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "PO Report column validation test case is successful");
			}else{
				System.err.println("PO Report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test035_POPendingReportColumnValidation")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("PO Report column validation");
	}

	@Test  @Category(SanityTests.class)
	public void Test036_IndentPendingReportColumnValidation() throws Exception{
		log.startTestCase("Indent Pending Report column validation");
		extentTest = extent.startTest("Test036_IndentPendingReportColumnValidation",
				"Verify Indent Pending Report column validation").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToStockReport();
			boolean flag = store.indentPendingColumnValidation(35,"Sanity Test");
			if(flag){
				Constant.log.info("Indent Pending Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Indent Pending Report column validation test case is successful");
			}else{
				System.err.println("Indent Pending Report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test036_IndentPendingReportColumnValidation")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Indent Pending Report column validation");
	}

	@Test  @Category(SanityTests.class)
	public void Test037_GRNReportColumnValidationWithDraft() throws Exception{
		log.startTestCase("GRN Report Column Validation with Draft");
		extentTest = extent.startTest("Test037_GRNReportColumnValidationWithDraft",
				"Verify GRN Report column validation with Draft").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRNReport();
			boolean flag = store.grnReportColumnVerifyWithDraft(36,"Sanity Test");
			if(flag){
				Constant.log.info("GRN Report column validation with Draft test case is successful");
				extentTest.log(LogStatus.PASS, "GRN Report validation with Draft test case is successful");
			}else{
				System.err.println("GRN Report column validation with Draft test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test037_GRNReportColumnValidationWithDraft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("GRN Report Column Validation with Draft");
	}

	@Test  @Category(SanityTests.class)
	public void Test038_GRNReportColumnValidationWithoutDraft() throws Exception{
		log.startTestCase("GRN Report Column Validation Without Draft");
		extentTest = extent.startTest("Test038_GRNReportColumnValidationWithoutDraft",
				"Verify GRN Report column validation Without Draft").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRNReport();
			boolean flag = store.grnReportColumnVerifyWithoutDraft(37,"Sanity Test");
			if(flag){
				Constant.log.info("GRN Report column validation Without Draft test case is successful");
				extentTest.log(LogStatus.PASS, "GRN Report column validation Without Draft test case is successful");
			}else{
				System.err.println("GRN Report column validation Without Draft test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test038_GRNReportColumnValidationWithoutDraft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("GRN Report Column Validation Without Draft");
	}

	@Test  @Category(SanityTests.class)
	public void Test039_DCReportColumnValidationWithDraft() throws Exception{
		log.startTestCase("DC Report Column Validation with Draft");
		extentTest = extent.startTest("Test039_DCReportColumnValidationWithDraft",
				"Verify DC Report column validation with Draft").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDCReport();
			boolean flag = store.dcReportColumnVerifyWithDraft(38,"Sanity Test");
			if(flag){
				Constant.log.info("DC Report columnvalidation  with Draft test case is successful");
				extentTest.log(LogStatus.PASS, "DC Report column validation with Draft test case is successful");
			}else{
				System.err.println("DC Report column validation with Draft test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test039_DCReportColumnValidationWithDraft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("DC Report Column Validation with Draft");
	}

	@Test  @Category(SanityTests.class)
	public void Test040_DCReportColumnValidationWithoutDraft() throws Exception{
		log.startTestCase("DC Report Column Validation Without Draft");
		extentTest = extent.startTest("Test040_DCReportColumnValidationWithoutDraft",
				"Verify DC Report column validation Without Draft").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDCReport();
			boolean flag = store.dcReportColumnVerifyWithoutDraft(39,"Sanity Test");
			if(flag){
				Constant.log.info("DC Report column validation Without Draft test case is successful");
				extentTest.log(LogStatus.PASS, "DC Report column validation Without Draft test case is successful");
			}else{
				System.err.println("DC Report column validation Without Draft test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test040_DCReportColumnValidationWithoutDraft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("DC Report Column Validation Without Draft");
	}

	@Test  @Category(SanityTests.class)
	public void Test041_MaterialReceiptReportColVerifyWithDraft() throws Exception{
		log.startTestCase("Material Receipt Report Column Validation With Draft");
		extentTest = extent.startTest("Test041_MaterialReceiptReportColVerifyWithDraft",
				"Verify Material Receipt Report column validation With Draft").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterialReceiptReport();
			boolean flag = store.materialReceiptReportWithDraft(40,"Sanity Test");
			if(flag){
				Constant.log.info("Material Receipt Report column validation With Draft test case is successful");
				extentTest.log(LogStatus.PASS, "Material Receipt Report column validation With Draft test case is successful");
			}else{
				System.err.println("Material Receipt Report column validation With Draft test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test041_MaterialReceiptReportColVerifyWithDraft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Material Receipt Report Column Validation With Draft");
	}

	@Test  @Category(SanityTests.class)
	public void Test042_MaterialReceiptReportColVerifyWithoutDraft() throws Exception{
		log.startTestCase("Material Receipt Report Column Validation Without Draft");
		extentTest = extent.startTest("Test042_MaterialReceiptReportColVerifyWithoutDraft",
				"Verify Material Receipt Report column validation Without Draft").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterialReceiptReport();
			boolean flag = store.materialReceiptReportWithoutDraft(41,"Sanity Test");
			if(flag){
				Constant.log.info("Material Receipt Report column validation Without Draft test case is successful");
				extentTest.log(LogStatus.PASS, "Material Receipt Report column validation Without Draft test case is successful");
			}else{
				System.err.println("Material Receipt Report column validation Without Draft test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test042_MaterialReceiptReportColVerifyWithoutDraft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Material Receipt Report Column Validation Without Draft");
	}

	@Test  @Category(SanityTests.class)
	public void Test043_ShortageListReportColumnVerify() throws Exception{
		log.startTestCase("Shortage List Report Column Verify");
		extentTest = extent.startTest("Test043_ShortageListReportColumnVerify",
				"Verify Shortage List Report column").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToShortageListReport();
			boolean flag = store.shortageListColumnValidation(42,"Sanity Test");
			if(flag){
				Constant.log.info("Shortage List Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Shortage List Report column validation test case is successful");
			}else{
				System.err.println("Shortage List Report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test043_ShortageListReportColumnVerify")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Shortage List Report Column Verify");
	}

	@Test  @Category(SanityTests.class)
	public void Test239_JobInReportColValid() throws Exception{
		log.startTestCase("Job In report column validation ");
		extentTest = extent.startTest("Test239_JobInReportColValid",
				"Verify Job In report columns").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToJobInReport();
			boolean flag = store.JobInOutReportColValid(238,"Sanity Test");
			if(flag){
				Constant.log.info("Job In report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Job In report column validation test case is successful");
			}else{
				System.err.println("Job In report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test239_JobInReportColValid")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job In report column validation");
	}

	@Test  @Category(SanityTests.class)
	public void Test240_JobOutReportColValid() throws Exception{
		log.startTestCase("Job Out report column validation ");
		extentTest = extent.startTest("Test240_JobOutReportColValid",
				"Verify Job In report columns").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToJobOutReport();
			boolean flag = store.JobInOutReportColValid(239,"Sanity Test");
			if(flag){
				Constant.log.info("Job Out report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Job Out report column validation test case is successful");
			}else{
				System.err.println("Job Out report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test240_JobOutReportColValid")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job Out report column validation");
	}

	@Test  @Category(SanityTests.class)
	public void Test252_InternalStockFlowReportColValid() throws Exception{
		log.startTestCase("Internal Stock flow report column validation ");
		extentTest = extent.startTest("Test252_InternalStockFlowReportColValid",
				"Verify Job In report columns").assignCategory("StoresReportTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInternalStockFlowReport();
			boolean flag = store.InternalStockFlowColValid(251,"Sanity Test");
			if(flag){
				Constant.log.info("Internal Stock flow report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Internal Stock flow report column validation test case is successful");
			}else{
				System.err.println("Internal Stock flow report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test252_InternalStockFlowReportColValid")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Internal Stock flow report column validation");
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
