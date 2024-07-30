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
import pages.LoginPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReceiptOthersTestCases {

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
		Constant.logFile("Receipt Others");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(SmokeTest.class)
	public void Test019_AddOthersGRN() throws Exception{
		log.startTestCase("Add Others GRN");
		extentTest = extent.startTest("Test019_AddOthersGRN",
				"Verify if Others GRN is added").assignCategory("ReceiptOthersTestCases","SmokeTest");
		try{
			boolean flag = store.addGRN(18, "Receipt Others",null);
			if(flag){
				Constant.log.info("Others GRN addition is successful");
				extentTest.log(LogStatus.PASS, "Others GRN addition is successful");
			}else{
				System.err.println("Others GRN addition failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test019_AddOthersGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Others GRN");
	}



	@Test  @Category(SanityTests.class)
	public void Test027_ApproveOthersGRN() throws Exception{
		log.startTestCase("Approve Others GRN");
		extentTest = extent.startTest("Test027_ApproveOthersGRN",
				"Verify if GRN is Approved").assignCategory("ReceiptOthersTestCases","SanityTests");
		try{
			boolean flag = store.approveGRN(26, "Receipt Others",null);
			if(flag){
				Constant.log.info("Others GRN Approve is successful");
				extentTest.log(LogStatus.PASS, "Others GRN Approve is successful");
			}else{
				System.err.println("Others GRN Approve failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test027_ApproveOthersGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Others Approve GRN");
	}

	@Test  @Category(SanityTests.class)
	public void Test028_DraftOthersGRNReject() throws Exception{
		log.startTestCase("Draft Others GRN Reject");
		extentTest = extent.startTest("Test028_DraftOthersGRNReject",
				"Verify if draft Others GRN is Rejected").assignCategory("ReceiptOthersTestCases","SanityTests");
		try{
			boolean flag = store.validateDraftRejectGRN(27, "Receipt Others");
			if(flag){
				Constant.log.info("Draft Others GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft Others GRN Reject is successful");
			}else{
				System.err.println("Draft Others GRN Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test028_DraftOthersGRNReject")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft Others GRN Reject");
	}

	@Test  @Category(SanityTests.class)
	public void Test029_ApprovedOthersGRNReject() throws Exception{
		log.startTestCase("Approved Others GRN Reject");
		extentTest = extent.startTest("Test029_ApprovedOthersGRNReject",
				"Verify if Approved Others GRN is Rejected").assignCategory("ReceiptOthersTestCases","SanityTests");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(28, "Receipt Others",null);
			if(flag){
				Constant.log.info("Approved Others GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved Others GRN Reject is successful");
			}else{
				System.err.println("Approved Others GRN Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test029_ApprovedOthersGRNReject")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved Others GRN Reject");
	}

	@Test  @Category(SanityTests.class)
	public void Test031_UpdateOthersGRN() throws Exception{
		log.startTestCase("Update Others GRN");
		extentTest = extent.startTest("Test031_UpdateOthersGRN",
				"Verify if Others GRN is Updated").assignCategory("ReceiptOthersTestCases","SanityTests");
		try{
			boolean flag = store.updateGRN(30, "Receipt Others", null);
			if(flag){
				Constant.log.info("Others GRN Update is successful");
				extentTest.log(LogStatus.PASS, "Others GRN Update is successful");
			}else{
				System.err.println("Others GRN Update failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test031_UpdateOthersGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Others GRN");
	}

	@Test  @Category(SanityTests.class)
	public void Test257_AddOthersGRN_NonStock() throws Exception{
		log.startTestCase("Add Others GRN with non stock");
		extentTest = extent.startTest("Test257_AddOthersGRN_NonStock",
				"Verify if Others GRN with non stock is added").assignCategory("ReceiptOthersTestCases","SanityTests");
		try{
			boolean flag = store.addGRN(256, "Sanity Test",null);
			if(flag){
				Constant.log.info("Others GRN with non stock addition is successful");
				extentTest.log(LogStatus.PASS, "Others GRN with non stock addition is successful");
			}else{
				System.err.println("Others GRN with non stock addition failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test257_AddOthersGRN_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Others GRN with non stock");
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
