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
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReceiptDCTestCases {

	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
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
		Constant.logFile("Receipt DC");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test022_AddDCGRN_DcToggle() throws Exception{
		log.startTestCase("Add DC GRN with Dc toggle");
		extentTest = extent.startTest("Test022_AddDCGRN_DcToggle",
				"Verify if DC GRN is added with Dc toggle").assignCategory("ReceiptDCTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(21, "Receipt DC",null);
			if(flag){
				Constant.log.info("DC GRN addition with Dc toggle is successful");
				extentTest.log(LogStatus.PASS, "DC GRN addition with Dc toggle is successful");
			}else{
				System.err.println("DC GRN addition with Dc toggle failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test022_AddDCGRN_DcToggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add DC GRN with Dc toggle");
	}

	@Test  @Category(SmokeTest.class)
	public void Test023_AddDCGRN_InvoiceToggle() throws Exception{
		log.startTestCase("Add DC GRN with invoice toggle");
		extentTest = extent.startTest("Test023_AddDCGRN_InvoiceToggle",
				"Verify if DC GRN is added with invoice toggle").assignCategory("ReceiptDCTestCases","SmokeTest");
		try{
			boolean flag = store.addGRN(22, "Receipt DC",null);
			if(flag){
				Constant.log.info("DC GRN addition with invoice toggle is successful");
				extentTest.log(LogStatus.PASS, "DC GRN addition with invoice toggle is successful");
			}else{
				System.err.println("DC GRN addition with invoice toggle failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test023_AddDCGRN_InvoiceToggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add DC GRN with invoice toggle");
	}

	@Test  @Category(SanityTests.class)
	public void Test041_UpdateDCGRN() throws Exception{
		log.startTestCase("Update DC GRN");
		extentTest = extent.startTest("Test041_UpdateDCGRN",
				"Verify if DC GRN is Updated").assignCategory("ReceiptDCTestCases","SanityTests");
		try{
			boolean flag = store.updateGRN(40, "Receipt DC", null);
			if(flag){
				Constant.log.info("DC GRN Update is successful");
				extentTest.log(LogStatus.PASS, "DC GRN Update is successful");
			}else{
				System.err.println("DC GRN Update failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test041_UpdateDCGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update DC GRN");
	}

	@Test  @Category(SanityTests.class)
	public void Test055_ApproveDCGRN() throws Exception{
		log.startTestCase("Approve DC GRN");
		extentTest = extent.startTest("Test055_ApproveDCGRN",
				"Verify if GRN is Approved").assignCategory("ReceiptDCTestCases","SanityTests");
		try{
			boolean flag = store.approveGRN(54, "Receipt DC",null);
			if(flag){
				Constant.log.info("DC GRN Approve is successful");
				extentTest.log(LogStatus.PASS, "DC GRN Approve is successful");
			}else{
				System.err.println("DC GRN Approve failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test055_ApproveDCGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("DC Approve GRN");
	}

	@Test  @Category(SanityTests.class)
	public void Test056_DraftDCGRNReject() throws Exception{
		log.startTestCase("Draft DC GRN Reject");
		extentTest = extent.startTest("Test056_DraftDCGRNReject",
				"Verify if draft DC GRN is Rejected").assignCategory("ReceiptDCTestCases","SanityTests");
		try{
			boolean flag = store.validateDraftRejectGRN(55, "Receipt DC");
			if(flag){
				Constant.log.info("Draft DC GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft DC GRN Reject is successful");
			}else{
				System.err.println("Draft DC GRN Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test056_DraftDCGRNReject")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft DC GRN Reject");
	}

	@Test  @Category(SanityTests.class)
	public void Test057_ApprovedDCGRNReject() throws Exception{
		log.startTestCase("Approved DC GRN Reject");
		extentTest = extent.startTest("Test057_ApprovedDCGRNReject",
				"Verify if Approved DC GRN is Rejected").assignCategory("ReceiptDCTestCases","SanityTests");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(56, "Receipt DC",null);
			if(flag){
				Constant.log.info("Approved DC GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved DC GRN Reject is successful");
			}else{
				System.err.println("Approved DC GRN Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test057_ApprovedDCGRNReject")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved DC GRN Reject");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test090_AmendDcGRN_AddingDC() throws Exception{
		log.startTestCase("Amend Dc GRN by adding Dc");
		extentTest = extent.startTest("Test090_AmendDcGRN_AddingDC",
				"Verify if GRN against DC can be amended by adding DC").assignCategory("ReceiptDCTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.amendGRNDC_addingDc(89, "Receipt DC",null);
			if(flag){
				Constant.log.info("Amend DC GRN by adding DC is successful");
				extentTest.log(LogStatus.PASS, "Amend DC GRN by adding DC is successful");
			}else{
				System.err.println("Approved DC GRN Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test090_AmendDcGRN_AddingDC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend Dc GRN by adding Dc");
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
