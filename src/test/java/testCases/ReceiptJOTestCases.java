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
import pages.AccountsPage;
import pages.AuditingPage;
import pages.LoginPage;
import pages.SalesPage;
import pages.SettingPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReceiptJOTestCases {

	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
	AuditingPage audit = PageFactory.initElements(Constant.driver, AuditingPage.class);
	AccountsPage accounts = PageFactory.initElements(Constant.driver, AccountsPage.class);
	SettingPage setting = PageFactory.initElements(Constant.driver, SettingPage.class);
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
		Constant.logFile("Receipt JO");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
		navigate.navigateToSettings();
		Thread.sleep(Constant.Min_Sleep);
		navigate.navigateToProfile();
		Thread.sleep(Constant.Min_Sleep);
		setting.purchaseMandatoryChkBx_Check();
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test024_AddJobWorkGRN_WORet() throws Exception{
		log.startTestCase("Add Job work GRN without Returned Material");
		extentTest = extent.startTest("Test024_AddJobWorkGRN_WORet",
				"Verify if Job work GRN is added without Returned material").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(23, "Receipt JO",null);
			if(flag){
				Constant.log.info("Job work GRN addition without returned materials is successful");
				extentTest.log(LogStatus.PASS, "Job work GRN addition without returned materials is successful");
			}else{
				System.err.println("Job work GRN addition without returned materials failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test024_AddJobWorkGRN_WORet")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Job work GRN without Returned Material");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test025_AddJobWorkGRN_WORec() throws Exception{
		log.startTestCase("Add Job work GRN without Received Material");
		extentTest = extent.startTest("Test025_AddJobWorkGRN_WORec",
				"Verify if Job work GRN is added without Received material").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(24, "Receipt JO",null);
			if(flag){
				Constant.log.info("Job work GRN addition without Received materials is successful");
				extentTest.log(LogStatus.PASS, "Job work GRN addition without Received materials is successful");
			}else{
				System.err.println("Job work GRN addition without Received materials failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test025_AddJobWorkGRN_WORec")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Job work GRN without Received Material");
	}

	@Test  @Category(SmokeTest.class)
	public void Test026_AddJobWorkGRN_WRecNRet() throws Exception{
		log.startTestCase("Add Job work GRN with received and return materials");
		extentTest = extent.startTest("Test026_AddJobWorkGRN_WRecNRet",
				"Verify if Job work GRN is added with received and returned materials").assignCategory("ReceiptJOTestCases","SmokeTest");
		try{
			boolean flag = store.addGRN(25, "Receipt JO",null);
			if(flag){
				Constant.log.info("Job work GRN addition with received and returned materials is successful");
				extentTest.log(LogStatus.PASS, "Job work GRN addition with received and returned materials is successful");
			}else{
				System.err.println("Job work GRN addition with received and returned materials failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test026_AddJobWorkGRN_WRecNRet")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Job work GRN with received and return materials");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test039_UpdateAddingJO() throws Exception{
		log.startTestCase("Update adding JO");
		extentTest = extent.startTest("Test039_UpdateAddingJO",
				"Verify if Job work GRN is updated by adding JO").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			store.addGRN(38, "Receipt JO", null);
			boolean flag = store.updateGRNByAddingJo(38, "Receipt JO");
			if(flag){
				Constant.log.info("Job work GRN updation by adding Jo is successful");
				extentTest.log(LogStatus.PASS, "Job work GRN updation by adding Jo is successful");
			}else{
				System.err.println("Job work GRN updation by adding Jo failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test039_UpdateAddingJO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update adding JO");
	}

	@Test  @Category(SanityTests.class)
	public void Test065_ApproveJobWorkGRN() throws Exception{
		log.startTestCase("Approve Job work GRN");
		extentTest = extent.startTest("Test065_ApproveJobWorkGRN",
				"Verify if GRN is Approved").assignCategory("ReceiptJOTestCases","SanityTests");
		try{
			boolean flag = store.approveGRN(64, "Receipt JO",null);
			if(flag){
				Constant.log.info("Job work GRN Approve is successful");
				extentTest.log(LogStatus.PASS, "Job work GRN Approve is successful");
			}else{
				System.err.println("Job work GRN Approve failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test065_ApproveJobWorkGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job work Approve GRN");
	}

	@Test  @Category(SanityTests.class)
	public void Test071_DraftJobWorkGRNReject() throws Exception{
		log.startTestCase("Draft Job work GRN Reject");
		extentTest = extent.startTest("Test071_DraftJobWorkGRNReject",
				"Verify if draft Job work GRN is Rejected").assignCategory("ReceiptJOTestCases","SanityTests");
		try{
			boolean flag = store.validateDraftRejectGRN(70, "Receipt JO");
			if(flag){
				Constant.log.info("Draft Job work GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft Job work GRN Reject is successful");
			}else{
				System.err.println("Draft Job work GRN Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test071_DraftJobWorkGRNReject")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft Job work GRN Reject");
	}

	@Test  @Category(SanityTests.class)
	public void Test075_ApprovedJobWorkGRNReject() throws Exception{
		log.startTestCase("Approved Job work GRN Reject");
		extentTest = extent.startTest("Test075_ApprovedJobWorkGRNReject",
				"Verify if Approved Job work GRN is Rejected").assignCategory("ReceiptJOTestCases","SanityTests");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(74, "Receipt JO",null);
			if(flag){
				Constant.log.info("Approved Job work GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved Job work GRN Reject is successful");
			}else{
				System.err.println("Approved Job work GRN Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test075_ApprovedJobWorkGRNReject")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved Job work GRN Reject");
	}

	@Test   @Category(SanityTests.class)
	public void Test110_AddGRNJO_DCtoggle() throws Exception{
		log.startTestCase("Add GRN Jo with DC toggle");
		extentTest = extent.startTest("Test110_AddGRNJO_DCtoggle",
				"Verify if GRN Jo with dc toggle is created").assignCategory("ReceiptJOTestCases","SanityTests");
		try{
			boolean flag = store.addGRN(109, "Receipt JO", null);
			if(flag){
				Constant.log.info("Verify if GRN Jo with dc toggle is created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN Jo with dc toggle is created test case is successful");
			}else{
				System.err.println("Verify if GRN Jo with dc toggle is created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test110_AddGRNJO_DCtoggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN Jo with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test116_UpdateGRNJO_DCtoggle() throws Exception{
		log.startTestCase("Update GRN Jo with DC toggle");
		extentTest = extent.startTest("Test116_UpdateGRNJO_DCtoggle",
				"Verify if GRN Jo with dc toggle is created").assignCategory("ReceiptJOTestCases","SanityTests");
		try{
			boolean flag = store.updateGRN(115, "Receipt JO", null);
			if(flag){
				Constant.log.info("Verify if GRN Jo with dc toggle is created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN Jo with dc toggle is created test case is successful");
			}else{
				System.err.println("Verify if GRN Jo with dc toggle is created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test116_UpdateGRNJO_DCtoggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN Jo with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test121_ApproveGRNJO_DCtoggle() throws Exception{
		log.startTestCase("Approve GRN Jo with DC toggle");
		extentTest = extent.startTest("Test121_ApproveGRNJO_DCtoggle",
				"Verify if GRN Jo with dc toggle is created").assignCategory("ReceiptJOTestCases","SanityTests");
		try{
			boolean flag = store.approveGRN(120, "Receipt JO", null);
			if(flag){
				Constant.log.info("Verify if GRN Jo with dc toggle is created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN Jo with dc toggle is created test case is successful");
			}else{
				System.err.println("Verify if GRN Jo with dc toggle is created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test121_ApproveGRNJO_DCtoggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN Jo with DC toggle");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test124_DraftGRNReject_DCtoggle() throws Exception{
		log.startTestCase("Draft Job OUt Reject Dc toggle");
		extentTest = extent.startTest("Test124_DraftGRNReject_DCtoggle",
				"Verify if draft Job out GRN with Dc toggle is Rejected").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.validateDraftRejectGRN(123, "Receipt JO");
			if(flag){
				Constant.log.info("Draft Job out GRN with Dc toggle Rejected is successful");
				extentTest.log(LogStatus.PASS, "Draft Job out GRN with Dc toggle Rejected is successful");
			}else{
				System.err.println("Draft Job out GRN with Dc toggle Rejected failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test124_DraftGRNReject_DCtoggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft Job OUt Reject Dc toggle");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test127_ApprovedJOGRNReject_DCToggle() throws Exception{
		log.startTestCase("Approved Job OUt Reject Dc toggle");
		extentTest = extent.startTest("Test127_ApprovedJOGRNReject_DCToggle",
				"Verify if Approved Job out GRN with Dc toggle is Rejected").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(126, "Receipt JO",null);
			if(flag){
				Constant.log.info("Approved Job out GRN with Dc toggle is Rejected is successful");
				extentTest.log(LogStatus.PASS, "Approved Job out GRN with Dc toggle is Rejected is successful");
			}else{
				System.err.println("Approved Job out GRN with Dc toggle is Rejected failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test127_ApprovedJOGRNReject_DCToggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved Job OUt Reject Dc toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test168_AddGRNJO_goodsReceived() throws Exception{
		log.startTestCase("Add GRN against Jo with Goods checkbox");
		extentTest = extent.startTest("Test168_AddGRNJO_goodsReceived",
				"Verify if GRN against JO created with goods checkbox").assignCategory("ReceiptJOTestCases","SanityTests");
		try{
			boolean flag = store.addGRN(167, "Receipt JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO created with goods checkbox test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO created with goods checkbox test case is successful");
			}else{
				System.err.println("Verify if GRN against JO created with goods checkbox test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test168_AddGRNJO_goodsReceived")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Jo with Goods checkbox");
	}

	@Test   @Category(SanityTests.class)
	public void Test187_ApproveGRNJO_Goods() throws Exception{
		log.startTestCase("Approve GRN Jo with Goods");
		extentTest = extent.startTest("Test187_ApproveGRNJO_Goods",
				"Verify if GRN Jo with Goods is created").assignCategory("ReceiptJOTestCases","SanityTests");
		try{
			boolean flag = store.approveGRN(186, "Receipt JO", null);
			if(flag){
				Constant.log.info("Verify if GRN Jo with Goods is created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN Jo with Goods is created test case is successful");
			}else{
				System.err.println("Verify if GRN Jo with Goods is created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test187_ApproveGRNJO_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN Jo with Goods");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test188_DraftGRNReject_Goods() throws Exception{
		log.startTestCase("Draft Job OUt Reject Goods");
		extentTest = extent.startTest("Test188_DraftGRNReject_Goods",
				"Verify if draft Job out GRN with Goods is Rejected").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.validateDraftRejectGRN(187, "Receipt JO");
			if(flag){
				Constant.log.info("Draft Job out GRN with Goods Rejected is successful");
				extentTest.log(LogStatus.PASS, "Draft Job out GRN with Goods Rejected is successful");
			}else{
				System.err.println("Draft Job out GRN with Goods Rejected failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test188_DraftGRNReject_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft Job OUt Reject Goods");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test189_ApprovedJOGRNReject_Goods() throws Exception{
		log.startTestCase("Approved Job OUt Reject Goods");
		extentTest = extent.startTest("Test189_ApprovedJOGRNReject_Goods",
				"Verify if Approved Job out GRN with Goods is Rejected").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(188, "Receipt JO",null);
			if(flag){
				Constant.log.info("Approved Job out GRN with Goods is Rejected is successful");
				extentTest.log(LogStatus.PASS, "Approved Job out GRN with Goods is Rejected is successful");
			}else{
				System.err.println("Approved Job out GRN with Goods is Rejected failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test189_ApprovedJOGRNReject_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved Job OUt Reject Goods");
	}

	@Test   @Category(SanityTests.class)
	public void Test196_UpdateGRNJO_goodsReceived() throws Exception{
		log.startTestCase("Update GRN against Jo with Goods checkbox");
		extentTest = extent.startTest("Test196_UpdateGRNJO_goodsReceived",
				"Verify if GRN against JO created with goods checkbox").assignCategory("ReceiptJOTestCases","SanityTests");
		try{
			boolean flag = store.updateGRN(195, "Receipt JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO created with goods checkbox test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO created with goods checkbox test case is successful");
			}else{
				System.err.println("Verify if GRN against JO created with goods checkbox test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test196_UpdateGRNJO_goodsReceived")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Jo with Goods checkbox");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test276_CheckICDGRNJO_Goods() throws Exception{
		log.startTestCase("Check ICD of GRN JO with Goods already received");
		extentTest = extent.startTest("Test276_CheckICDGRNJO_Goods",
				"Verify if ICD is checked for GRN JO with Goods already received").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = audit.checkGRNPO(275, "Receipt JO","GRN");
			if(flag){
				Constant.log.info("Verify if ICD is checked for GRN JO with Goods already received test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is checked for GRN JO with Goods already received test case is successful");
			}else{
				System.err.println("Verify if ICD is checked for GRN JO with Goods already received test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test276_CheckICDGRNJO_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check ICD of GRN JO with Goods already received");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test277_VerifyICDGRNJO_Goods() throws Exception{
		log.startTestCase("Verify ICD of GRN JO with Goods already received");
		extentTest = extent.startTest("Test277_VerifyICDGRNJO_Goods",
				"Verify if ICD is Verifyed for GRN JO with Goods already received").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = audit.verifyGRNPO(276, "Receipt JO","GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Verified for GRN JO with Goods already received test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Verified for GRN JO with Goods already received test case is successful");
			}else{
				System.err.println("Verify if ICD is Verified for GRN JO with Goods already received test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test277_VerifyICDGRNJO_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD of GRN JO with Goods already received");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test278_ReturnICDGRNJO_Goods() throws Exception{
		log.startTestCase("Return ICD of GRN JO with Goods already received");
		extentTest = extent.startTest("Test278_ReturnICDGRNJO_Goods",
				"Verify if ICD is Returned for GRN JO with Goods already received").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			boolean flag = audit.returnGRNPO(277, "Receipt JO","GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Returned for GRN JO with Goods already received test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Returned for GRN JO with Goods already received test case is successful");
			}else{
				System.err.println("Verify if ICD is Returned for GRN JO with Goods already received test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test278_ReturnICDGRNJO_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD of GRN JO with Goods already received");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test279_VerifyReturnICDGRN_Goods() throws Exception{
		log.startTestCase("verify returned ICD of GRN JO with Goods already received");
		extentTest = extent.startTest("Test279_VerifyReturnICDGRN_Goods",
				"Verify if ICD is Verify returneded for GRN JO with Goods already received").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = audit.verifyReturnGRNPO(278, "Receipt JO","GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if returned ICD is Verified for GRN JO with Goods already received test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if returned ICD is Verified for GRN JO with Goods already received test case is successful");
			}else{
				System.err.println("Verify if returned ICD is Verified for GRN JO with Goods already received test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test279_VerifyReturnICDGRN_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify returned ICD of GRN JO with Goods already received");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test284_ApproveNoteVoucher() throws Exception{
		log.startTestCase("Approve Note voucher");
		extentTest = extent.startTest("Test284_ApproveNoteVoucher",
				"Verify if Note voucher is Approved").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			audit.verifyGRNPO(283, "Receipt JO","GRN", "Checked");
			int i = audit.icdList.size();
			String sGRNNO = audit.grnNoList.get(i-1).getText();
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(283, "Receipt JO", sGRNNO);
			if(flag){
				Constant.log.info("Approve Note voucher is successful");
				extentTest.log(LogStatus.PASS, "Approve Note voucher is successful");
			}else{
				System.err.println("Approve Note voucher failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test284_ApproveNoteVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Note voucher");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test285_ApprovePurchaseVoucher() throws Exception{
		log.startTestCase("Approve Purchase voucher");
		extentTest = extent.startTest("Test285_ApprovePurchaseVoucher",
				"Verify if Purchase voucher is Approved").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			audit.verifyGRNPO(284, "Receipt JO","GRN", "Checked");
			int i = audit.icdList.size();
			String sGRNNO = audit.grnNoList.get(i-1).getText();
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(284, "Receipt JO", sGRNNO);
			if(flag){
				Constant.log.info("Approve Purchase voucher is successful");
				extentTest.log(LogStatus.PASS, "Approve Purchase voucher is successful");
			}else{
				System.err.println("Approve Purchase voucher failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test285_ApprovePurchaseVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Purchase voucher");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test367_ValidateItemsInvoiced_Draft() throws Exception{
		log.startTestCase("Items invoiced popup when GRN goods in draft status");
		extentTest = extent.startTest("Test367_ValidateItemsInvoiced_Drafts",
				"Verify if items invoiced popup displayed draft GRN details").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.verifyItemsInvoiced_Draft(366,  "Receipt JO");
			if(flag){
				Constant.log.info("Verify if items invoiced popup displayed draft GRN details test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced popup displayed draft GRN details test case is successful");
			}else{
				System.err.println("Verify if items invoiced popup displayed draft GRN details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test367_ValidateItemsInvoiced_Draft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced popup when GRN goods in draft status");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test368_ValidateItemsInvoiced_approved() throws Exception{
		log.startTestCase("Items invoiced JOpup when GRN goods in approved status");
		extentTest = extent.startTest("Test368_ValidateItemsInvoiced_approved",
				"Verify if items invoiced JOp up displayed approved GRN details").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.verifyItemsInvoiced_Approved(367,  "Receipt JO");
			if(flag){
				Constant.log.info("Verify if items invoiced JOp up displayed approved GRN details test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced JOp up displayed approved GRN details test case is successful");
			}else{
				System.err.println("Verify if items invoiced JOp up displayed approved GRN details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test368_ValidateItemsInvoiced_approved")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced JOpup when GRN goods in approved status");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test369_ValidateItemsInvoiced_approvedRejected() throws Exception{
		log.startTestCase("Items invoiced JOpup when approved grn rejected ");
		extentTest = extent.startTest("Test369_ValidateItemsInvoiced_approvedRejected",
				"Verify if items invoiced JOp up does not displayed rejected approved GRN details").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.verifyItemsInvoiced_ApprovedRejected(368, "Receipt JO");
			if(flag){
				Constant.log.info("Verify if items invoiced JOp up does not displayed rejected approved GRN detailss test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced JOp up does not displayed rejected approved GRN details test case is successful");
			}else{
				System.err.println("Verify if items invoiced JOp up does not displayed rejected approved GRN details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test369_ValidateItemsInvoiced_approvedRejected")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced JOpup when approved grn rejected");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test379_ValidateItemsInvoiced_draftRejected() throws Exception{
		log.startTestCase("Items invoiced JOpup when draft grn rejected ");
		extentTest = extent.startTest("Test379_ValidateItemsInvoiced_draftRejected",
				"Verify if items invoiced JOp up does not displayed rejected draft GRN details").assignCategory("ReceiptJOTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.verifyItemsInvoiced_DraftRejected(378, "Receipt JO");
			if(flag){
				Constant.log.info("Verify if items invoiced JOp up does not displayed rejected draft GRN detailss test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced JOp up does not displayed rejected draft GRN details test case is successful");
			}else{
				System.err.println("Verify if items invoiced JOp up does not displayed rejected draft GRN details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test379_ValidateItemsInvoiced_draftRejected")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced JOpup when draft grn rejected");
	}

	@Test  @Category(SanityTests.class)
	public void Test100_UpdateJobWorkGRN() throws Exception{
		log.startTestCase("Update Job work GRN");
		extentTest = extent.startTest("Test100_UpdateJobWorkGRN",
				"Verify if Job work GRN is Updated").assignCategory("ReceiptJOTestCases","SanityTests");
		try{
			boolean flag = store.updateGRN(99, "Sanity Test", null);
			if(flag){
				Constant.log.info("Job work GRN Update is successful");
				extentTest.log(LogStatus.PASS, "Job work GRN Update is successful");
			}else{
				System.err.println("Job work GRN Update failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test100_UpdateJobWorkGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Job work GRN");
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
