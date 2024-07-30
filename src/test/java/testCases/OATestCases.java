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
import category.SmokeTest;
import pages.LoginPage;
import pages.SalesPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OATestCases {

	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
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
		Constant.logFile("OA");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
		navigate.navigateToSales();
		Thread.sleep(Constant.Min_Sleep);
		navigate.navigateToOA();
		Thread.sleep(Constant.Min_Sleep);
	}



	@Test  @Category(HighPriorityTestCases.class)
	public void Test056_AddStockOA() throws Exception{
		log.startTestCase("Add OA with stock materials");
		extentTest = extent.startTest("Test056_AddStockOA",
				"Verify if OA is added with stock materials").assignCategory("OATestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.addOA(55,"OA");
			if(flag){
				Constant.log.info("Add OA with stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Add OA with stock materials test case is successful");
			}else{
				System.err.println("Add OA with stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test056_AddStockOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add OA with stock materials");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test057_AddMultiStockOA() throws Exception{
		log.startTestCase("Add OA with multiple stock materials");
		extentTest = extent.startTest("Add OA with multiple stock materials",
				"Verify if OA is added with multiple stock materials").assignCategory("OATestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.addOA(56,"OA");
			if(flag){
				Constant.log.info("Add OA with multiple stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Add OA with multiple stock materials test case is successful");
			}else{
				System.err.println("Add OA with multiple stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test057_AddMultiStockOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add OA with multiple stock materials");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test058_AddMultiNonStockOA() throws Exception{
		log.startTestCase("Add OA with multiple non stock materials");
		extentTest = extent.startTest("Test058_AddMultiNonStockOA",
				"Verify if OA is added with multiple non stock materials").assignCategory("OATestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.addOA(57,"OA");
			if(flag){
				Constant.log.info("Add OA with multiple non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Add OA with multiple non stock materials test case is successful");
			}else{
				System.err.println("Add OA with multiple non stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test058_AddMultiNonStockOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add OA with multiple non stock materials");
	}

	@Test  @Category(SanityTests.class)
	public void Test059_AddMultiStockNNonStockOA() throws Exception{
		log.startTestCase("Add OA with multiple stock and non stock materials");
		extentTest = extent.startTest("Test059_AddMultiStockNNonStockOA",
				"Verify if OA is added with multiple stock and non stock materials").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.addOA(58,"OA");
			if(flag){
				Constant.log.info("Add OA with multiple stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Add OA with multiple stock and non stock materials test case is successful");
			}else{
				System.err.println("Add OA with multiple stock and non stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test059_AddMultiStockNNonStockOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add OA with multiple stock and non stock materials");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test060_AddLabourOA() throws Exception{
		log.startTestCase("Add Labour OA");
		extentTest = extent.startTest("Test060_AddLabourOA",
				"Verify if OA with type labour is added").assignCategory("OATestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.addOA(59,"OA");
			if(flag){
				Constant.log.info("Add OA with type labour test case is successful");
				extentTest.log(LogStatus.PASS, "Add OA with type labour test case is successful");
			}else{
				System.err.println("Add OA with type labour test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test060_AddLabourOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Labour OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test061_AddJobWorkOA() throws Exception{
		log.startTestCase("Add JobWork OA");
		extentTest = extent.startTest("Test061_AddJobWorkOA",
				"Verify if OA with type JobWork is added").assignCategory("OATestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.addOA(60,"OA");
			if(flag){
				Constant.log.info("Add OA with type JobWork test case is successful");
				extentTest.log(LogStatus.PASS, "Add OA with type JobWork test case is successful");
			}else{
				System.err.println("Add OA with type JobWork test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test061_AddJobWorkOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add JobWork OA");
	}

	@Test  @Category(SanityTests.class)
	public void Test063_ApproveOA() throws Exception{
		log.startTestCase("Approve OA");
		extentTest = extent.startTest("Test063_ApproveOA",
				"Verify if OA is Approved").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.validateApproveOA(62,"OA");
			if(flag){
				Constant.log.info("Approve OA test case is successful");
				extentTest.log(LogStatus.PASS, "Approve OA test case is successful");
			}else{
				System.err.println("Approve OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test063_ApproveOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve OA");
	}

	@Test  @Category(SanityTests.class)
	public void Test064_RejectApprovedOA() throws Exception{
		log.startTestCase("Reject Approved OA");
		extentTest = extent.startTest("Test064_RejectApprovedOA",
				"Verify if Approved OA is Rejected").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectApprovedOA(63,"OA");
			if(flag){
				Constant.log.info("Reject Approved OA test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Approved OA test case is successful");
			}else{
				System.err.println("Reject Approved OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test064_RejectApprovedOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved OA");
	}

	@Test  @Category(SanityTests.class)
	public void Test065_RejectDraftOA() throws Exception{
		log.startTestCase("Reject Draft OA");
		extentTest = extent.startTest("Test065_RejectDraftOA",
				"Verify if Draft OA is Rejected").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectDraftOA(64,"OA");
			if(flag){
				Constant.log.info("Reject Draft OA test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Draft OA test case is successful");
			}else{
				System.err.println("Reject Draft OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test065_RejectDraftOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft OA");
	}

	@Test  @Category(SanityTests.class)
	public void Test066_UpdateOAStock() throws Exception{
		log.startTestCase("Update OA with stock materials");
		extentTest = extent.startTest("Test066_UpdateOAStock",
				"Verify if OA is updated with stock materials").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.updateOA(65,"OA");
			if(flag){
				Constant.log.info("Update OA with stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Update OA with stock materials test case is successful");
			}else{
				System.err.println("Update OA with stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test066_UpdateOAStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update OA with stock materials");
	}

	@Test  @Category(SanityTests.class)
	public void Test067_UpdateNonStockOA() throws Exception{
		log.startTestCase("Update OA with non stock materials");
		extentTest = extent.startTest("Test067_UpdateNonStockOA",
				"Verify if OA is updated with non stock materials").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.updateOA(66,"OA");
			if(flag){
				Constant.log.info("Update OA with non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Update OA and non stock materials test case is successful");
			}else{
				System.err.println("Update OA with non stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test067_UpdateNonStockOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update OA with non stock materials");
	}

	@Test  @Category(SmokeTest.class)
	public void Test116_AddStockNNonStockOA() throws Exception{
		log.startTestCase("Add OA with stock and non stock materials");
		extentTest = extent.startTest("Test116_AddStockNNonStockOA",
				"Verify if OA is added with stock and non stock materials").assignCategory("OATestCases","SmokeTest");
		try{
			boolean flag = sales.addOA(115,"Sanity Test");
			if(flag){
				Constant.log.info("Add OA with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Add OA with stock and non stock materials test case is successful");
			}else{
				System.err.println("Add OA with stock and non stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test116_AddStockNNonStockOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add OA with stock and non stock materials");
	}

	@Test  @Category(SanityTests.class)
	public void Test117_UpdateStockNNonStockOA() throws Exception{
		log.startTestCase("Update OA with stock and non stock materials");
		extentTest = extent.startTest("Test117_UpdateStockNNonStockOA",
				"Verify if OA is updated with stock and non stock materials").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.updateOA(116,"Sanity Test");
			if(flag){
				Constant.log.info("Update OA with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Update OA with stock and non stock materials test case is successful");
			}else{
				System.err.println("Update OA with stock and non stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test117_UpdateStockNNonStockOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update OA with stock and non stock materials");
	}

	@Test  @Category(SanityTests.class)
	public void Test118_ApproveStockNNonStockOA() throws Exception{
		log.startTestCase("Approve OA with stock and non stock materials");
		extentTest = extent.startTest("Test118_ApproveStockNNonStockOA",
				"Verify if OA is Approved with stock and non stock materials").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.validateApproveOA(117,"Sanity Test");
			if(flag){
				Constant.log.info("Approve OA with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Approve OA with stock and non stock materials test case is successful");
			}else{
				System.err.println("Approve OA with stock and non stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test118_ApproveStockNNonStockOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve OA with stock and non stock materials");
	}

	@Test    @Category(SanityTests.class)
	public void Test119_RejectApprovedStockNNonStockOA() throws Exception{
		log.startTestCase("Reject Approved OA with stock and non stock materials");
		extentTest = extent.startTest("Test119_RejectApprovedStockNNonStockOA",
				"Verify if Approved OA is Rejected with stock and non stock materials").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectApprovedOA(118,"Sanity Test");
			if(flag){
				Constant.log.info("Reject Approved OA with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Approved OA with stock and non stock materials test case is successful");
			}else{
				System.err.println("Reject Approved OA with stock and non stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test119_RejectApprovedStockNNonStockOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved OA with stock and non stock materials");
	}

	@Test   @Category(SanityTests.class)
	public void Test120_RejectDraftStockNNonStockOA() throws Exception{
		log.startTestCase("Reject Draft OA with stock and non stock materials");
		extentTest = extent.startTest("Test120_RejectDraftStockNNonStockOA",
				"Verify if Draft OA is Rejected with stock and non stock materials").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectDraftOA(119,"Sanity Test");
			if(flag){
				Constant.log.info("Reject Draft OA with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Draft OA with stock and non stock materials test case is successful");
			}else{
				System.err.println("Reject Draft OA with stock and non stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test120_RejectDraftStockNNonStockOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft OA with stock and non stock materials");
	}

	@Test  @Category(SanityTests.class)
	public void Test121_AmendStockNNonStockOA() throws Exception{
		log.startTestCase("Amend OA with stock and non stock materials");
		extentTest = extent.startTest("Test121_AmendStockNNonStockOA",
				"Verify if OA is Amended with stock and non stock materials").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.amendOA(120,"Sanity Test");
			if(flag){
				Constant.log.info("Amend OA with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Amend OA with stock and non stock materials test case is successful");
			}else{
				System.err.println("Amend OA with stock and non stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test121_AmendStockNNonStockOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Amend OA with stock and non stock materials");
	}

	@Test  @Category(SanityTests.class)
	public void Test262_addOA_NonStock() throws Exception{
		log.startTestCase("add OA with non stock materials");
		extentTest = extent.startTest("Test262_addOA_NonStock",
				"Verify if OA is added with non stock materials").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.addOA(261,"Sanity Test");
			if(flag){
				Constant.log.info("add OA with non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "add OA with non stock materials test case is successful");
			}else{
				System.err.println("add OA with non stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test262_addOA_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("add OA with non stock materials");
	}

	@Test @Category(SanityTests.class)
	public void Test291_Addoa_AltUnit() throws Exception{
		log.startTestCase("ADD oa with alternate unit");
		extentTest = extent.startTest("Test291_Addoa_AltUnit",
				"Verify if oa with added with alternate unit").assignCategory("OATestCases","SanityTests");
		try{
			boolean flag = sales.addOA(290, "Sanity Test");
			if(flag){
				Constant.log.info("ADD oa with alternate unit is successful");
				extentTest.log(LogStatus.PASS, "ADD oa with alternate unit is successful");
			}else{
				System.err.println("ADD oa with alternate unit failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test291_Addoa_AltUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("ADD oa with alternate unit");
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
