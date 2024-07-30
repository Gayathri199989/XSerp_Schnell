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
import pages.AuditingPage;
import pages.LoginPage;
import pages.PurchasePage;
import pages.SettingPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReceiptWithNWithoutJO {
	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
	PurchasePage po = PageFactory.initElements(Constant.driver, PurchasePage.class);
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
		Constant.logFile("Receipt With N Without po");
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
		setting.purchaseMandatoryChkBx_UnCheck();
		setting.reqAckn_UnCheck();
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test005_AddGRNJO_WOPODCStock() throws Exception{
		log.startTestCase("Add GRN against JO without Po with DC toggle having only stock material");
		extentTest = extent.startTest("Test005_AddGRNJO_WOPODCStock",
				"Verify if GRN against JO with DC toggle and without po no can be created having only stock material")
				.assignCategory("ReceiptWithNWithoutJO","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(4, "GRN without JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and without po no can be created having only stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and without po no can be created having only stock material test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and without po no can be created having only stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test005_AddGRNJO_WOPODCStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO without Po with DC toggle having only stock material");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test006_AddGRNJO_WOPODCNonStock() throws Exception{
		log.startTestCase("Add GRN against JO without Po with DC toggle having only non stock material");
		extentTest = extent.startTest("Test006_AddGRNJO_WOPODCNonStock",
				"Verify if GRN against JO with DC toggle and without po no can be created having only non stock material")
				.assignCategory("ReceiptWithNWithoutJO","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(5, "GRN without JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and without po no can be created having only non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and without po no can be created having only non stock material test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and without po no can be created having only non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test006_AddGRNJO_WOPODCNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO without Po with DC toggle having only non stock material");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test007_AddGRNJO_WPOInvoice() throws Exception{
		log.startTestCase("Add GRN against JO with Po with Invoice toggle");
		extentTest = extent.startTest("Test007_AddGRNJO_WPOInvoice",
				"Verify if GRN against JO with invoice toggle and with po no can be created")
				.assignCategory("ReceiptWithNWithoutJO","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(6, "GRN without JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and with n without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and with n without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and with n without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test007_AddGRNJO_WPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO with Po with Invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test008_AddGRNJO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Add GRN against JO with and without Po with invoice toggle");
		extentTest = extent.startTest("Test008_AddGRNJO_WNWOPOInvoice",
				"Verify if GRN against JO with invoice toggle and with and without po no can be created")
				.assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.addGRN(7, "GRN without JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and with and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and with and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and with and without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test008_AddGRNJO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO with and without Po with invoice toggle");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test019_UpdateGRNWOJO_AddJO() throws Exception{
		log.startTestCase("Update GRN against JO without Po by adding JO");
		extentTest = extent.startTest("Test019_UpdateGRNWOJO_AddJO",
				"Verify if GRN against JO without po no can be updated by adding JO")
				.assignCategory("ReceiptWithNWithoutJO","HighPriorityTestCases");
		try{
			store.addGRN(18, "GRN without JO", null);
			boolean flag = store.updateGRNByAddingJo(6, "GRN without JO");//dont change row number
			if(flag){
				Constant.log.info("Verify if GRN against JO without po no can be updated by adding JO test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO without po no can be updated by adding JO test case is successful");
			}else{
				System.err.println("Verify if GRN against JO without po no can be updated by adding JO test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test019_UpdateGRNWOJO_AddJO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO without Po by adding JO");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test020_UpdateGRNWJO_AddMaterials() throws Exception{
		log.startTestCase("Update GRN against JO with Po by adding Materials");
		extentTest = extent.startTest("Test020_UpdateGRNWJO_AddMaterials",
				"Verify if GRN against JO with po no can be updated by adding Materials")
				.assignCategory("ReceiptWithNWithoutJO","HighPriorityTestCases");
		try{
			store.addGRN(6, "GRN without JO", null);
			boolean flag = store.validateGRNUpdate(19, "GRN without JO",null);//dont change row number
			if(flag){
				Constant.log.info("Verify if  GRN against JO with po no can be updated by adding Materials test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if  GRN against JO with po no can be updated by adding Materials test case is successful");
			}else{
				System.err.println("Verify if  GRN against JO with po no can be updated by adding Materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test020_UpdateGRNWJO_AddMaterials")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO with Po by adding Materials");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test021_UpdateGRNWNWOJO_AddMaterials() throws Exception{
		log.startTestCase("Update GRN against JO with N without Po by adding Materials");
		extentTest = extent.startTest("Test021_UpdateGRNWNWOJO_AddMaterials",
				"Verify if GRN against JO with po no can be updated by adding Materials")
				.assignCategory("ReceiptWithNWithoutJO","HighPriorityTestCases");
		try{
			store.addGRN(6, "GRN without JO", null);
			boolean flag = store.validateGRNUpdate(19, "GRN without JO",null);//dont change row number
			if(flag){
				Constant.log.info("Verify if  GRN against JO with N without po no can be updated by adding Materials test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if  GRN against JO with N without po no can be updated by adding Materials test case is successful");
			}else{
				System.err.println("Verify if  GRN against JO with N without po no can be updated by adding Materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test021_UpdateGRNWNWOJO_AddMaterials")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO with N Without Po by adding Materials");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test025_AddGRNWNWO_MultipleJO() throws Exception{
		log.startTestCase("Add GRN against JO with N without Po with multiple materials");
		extentTest = extent.startTest("Test025_AddGRNWNWO_MultipleJO",
				"Verify if GRN against JO with N without multiple po no can be created")
				.assignCategory("ReceiptWithNWithoutJO","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(24, "GRN without JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with N without multiple can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with N without multiple can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with N without multiple can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test025_AddGRNWNWO_MultipleJO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO with N without Po with multiple materials");
	}

	@Test   @Category(SanityTests.class)
	public void Test027_ApproveGRNJO_WOPOInvoice() throws Exception{
		log.startTestCase("Approve GRN against JO without Po with invoice toggle");
		extentTest = extent.startTest("Test027_ApproveGRNJO_WOPOInvoice",
				"Verify if GRN against JO with invoice toggle and without po no can be approved")
				.assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.approveGRN(26, "GRN without JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and without po no can be approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test027_ApproveGRNJO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against JO without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test028_DraftRejectGRNJO_WOPOInvoice() throws Exception{
		log.startTestCase("Draft Reject GRN against JO without Po with invoice toggle");
		extentTest = extent.startTest("Test028_DraftRejectGRNJO_WOPOInvoice",
				"Verify if GRN against JO with invoice toggle and without po no can be rejected in draft status")
				.assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.validateDraftRejectGRN(27, "GRN without JO");
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and without po no can be rejected in draft status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and without po no can be rejected in draft status test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and without po no can be rejected in draft status test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test028_DraftRejectGRNJO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Draft Reject GRN against JO without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test029_RejectApprovedGRNJO_WOPOInvoice() throws Exception{
		log.startTestCase("Reject Approved GRN against JO without Po with invoice toggle");
		extentTest = extent.startTest("Test029_RejectApprovedGRNJO_WOPOInvoice",
				"Verify if GRN against JO with invoice toggle and without po no can be rejected in approved status").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(28, "GRN without JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and without po no can be rejected in approved status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and without po no can be rejected in approved status test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and without po no can be rejected in approved status test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test029_RejectApprovedGRNJO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved GRN against JO without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test040_AddGRNJO_WOPOGoods() throws Exception{
		log.startTestCase("Add GRN against JO without Po with Goods already received");
		extentTest = extent.startTest("Test040_AddGRNJO_WOPOGoods",
				"Verify if GRN against JO with Goods already received and without po no can be created").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.addGRN(39, "GRN without JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with Goods already received and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with Goods already received and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with Goods already received and without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test040_AddGRNJO_WOPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO without Po with Goods already received");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test041_AddGRNJO_WPOGoods() throws Exception{
		log.startTestCase("Add GRN against JO with Po with Goods already received");
		extentTest = extent.startTest("Test041_AddGRNJO_WPOGoods",
				"Verify if GRN against JO with Goods already received and with po no can be created").assignCategory("ReceiptWithNWithoutJO","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(40, "GRN without JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with Goods already received and with po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with Goods already received and with po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with Goods already received and with po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test041_AddGRNJO_WPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO with Po with Goods already received");
	}

	@Test   @Category(SanityTests.class)
	public void Test042_AddGRNJO_WNWOPOGoods() throws Exception{
		log.startTestCase("Add GRN against JO with N without Po with Goods toggle");
		extentTest = extent.startTest("Test042_AddGRNJO_WNWOPOGoods",
				"Verify if GRN against JO with Goods toggle and with N without po no can be created").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.addGRN(41, "GRN without JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with Goods toggle and with N without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with Goods toggle and with N without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with Goods toggle and with N without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test042_AddGRNJO_WNWOPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO with N without Po with Goods toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test044_ApproveGRNJO_WOPOGoods() throws Exception{
		log.startTestCase("Approve GRN against JO without Po with Goods toggle");
		extentTest = extent.startTest("Test044_ApproveGRNJO_WOPOGoods",
				"Verify if GRN against JO with Goods toggle and without po no can be approved").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.approveGRN(43, "GRN without JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with Goods toggle and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with Goods toggle and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with Goods toggle and without po no can be approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test044_ApproveGRNJO_WOPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against JO without Po with Goods toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test045_DraftRejectGRNJO_WOPOGoods() throws Exception{
		log.startTestCase("Draft Reject GRN against JO without Po with Goods toggle");
		extentTest = extent.startTest("Test045_DraftRejectGRNJO_WOPOGoods",
				"Verify if GRN against JO with Goods toggle and without po no can be rejected in draft status").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.validateDraftRejectGRN(44, "GRN without JO");
			if(flag){
				Constant.log.info("Verify if GRN against JO with Goods toggle and without po no can be rejected in draft status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with Goods toggle and without po no can be rejected in draft status test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with Goods toggle and without po no can be rejected in draft status test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test045_DraftRejectGRNJO_WOPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Draft Reject GRN against JO without Po with Goods toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test046_RejectApprovedGRNJO_WOPOGoods() throws Exception{
		log.startTestCase("Reject Approved GRN against JO without Po with Goods toggle");
		extentTest = extent.startTest("Test046_RejectApprovedGRNJO_WOPOGoods",
				"Verify if GRN against JO with Goods toggle and without po no can be rejected in approved status").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(45, "GRN without JO", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with Goods toggle and without po no can be rejected in approved status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with Goods toggle and without po no can be rejected in approved status test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with Goods toggle and without po no can be rejected in approved status test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test046_RejectApprovedGRNJO_WOPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved GRN against JO without Po with Goods toggle");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test079_CheckICDGRNJO_WNWOJOInvoice() throws Exception{
		log.startTestCase("Check ICD of GRN with N without JO with Invoice");
		extentTest = extent.startTest("Test079_CheckICDGRNJO_WNWOJOInvoice",
				"Verify if ICD is checked for GRN with N without JO with Invoice").assignCategory("ReceiptWithNWithoutJO","HighPriorityTestCases");
		try{
			boolean flag = audit.checkGRNPO(78, "GRN Without JO", "GRN");
			if(flag){
				Constant.log.info("Verify if ICD is checked for GRN with N without JO with Invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is checked for GRN with N without JO with Invoice test case is successful");
			}else{
				System.err.println("Verify if ICD is checked for GRN with N without JO with Invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test079_CheckICDGRNJO_WNWOJOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check ICD of GRN with N without JO with Invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test080_ReturnICDToGRN_WNWOJOInvoice() throws Exception{
		log.startTestCase("Return ICD to GRN with N without JO invoice");
		extentTest = extent.startTest("Test080_ReturnICDToGRN_WNWOJOInvoice",
				"Verify if ICD can be returned to GRN with N without JO invoice").assignCategory("ReceiptWithNWithoutJO","HighPriorityTestCases");
		try{
			boolean flag = audit.returnICDToGRN(79,"GRN Without JO");
			if(flag){
				Constant.log.info("Verify if ICD can be returned to GRN with N without JO invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD can be returned to GRN with N without JO invoice test case is successful");
			}else{
				System.err.println("Verify if ICD can be returned to GRN with N without JO invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test080_ReturnICDToGRN_WNWOJOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD to GRN with N without JO invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test081_ReturnICDGRNPO_WNWOJOInvoice() throws Exception{
		log.startTestCase("Return ICD of GRN JO with N without Invoice");
		extentTest = extent.startTest("Test081_ReturnICDGRNPO_WNWOJOInvoice",
				"Verify if ICD is Returned for GRN PO with N without Invoice").assignCategory("ReceiptWithNWithoutJO","HighPriorityTestCases");
		try{
			boolean flag = audit.returnGRNPO(80, "GRN Without JO","GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Returned for GRN JO with N without Invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Returned for GRN JO with N without Invoice test case is successful");
			}else{
				System.err.println("Verify if ICD is Returned for GRN JO with N without Invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test081_ReturnICDGRNPO_WNWOJOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD of GRN JO with N without Invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test082_VerifyICDGRNPO_WNWOJOInvoice() throws Exception{
		log.startTestCase("Verify ICD of GRN Po with N without Jo with invoice");
		extentTest = extent.startTest("Test082_VerifyICDGRNPO_WNWOJOInvoice",
				"Verify if ICD is Verifyed for GRN po with N without Jo with invoice").assignCategory("ReceiptWithNWithoutJO","HighPriorityTestCases");
		try{
			boolean flag = audit.verifyGRNPO(81, "GRN Without JO","GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Verified for GRN with N without Jo with invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Verified for GRN with N without Jo with invoice test case is successful");
			}else{
				System.err.println("Verify if ICD is Verified for GRN with N without Jo with invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test082_VerifyICDGRNPO_WNWOJOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD of GRN with N without Jo with invoice");
	}


	@Test   @Category(SanityTests.class)
	public void Test191_AddGRNJO_WOPOInvoice() throws Exception{
		log.startTestCase("Add GRN against JO without Po with invoice toggle");
		extentTest = extent.startTest("Test191_AddGRNJO_WOPOInvoice",
				"Verify if GRN against JO with invoice toggle and without po no can be created").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.addGRN(190, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test191_AddGRNJO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test192_UpdateGRNJO_WOPOInvoice() throws Exception{
		log.startTestCase("Update GRN against JO without Po with invoice toggle");
		extentTest = extent.startTest("Test192_UpdateGRNJO_WOPOInvoice",
				"Verify if GRN against JO with invoice toggle and without po no can be updated").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.updateGRN(191, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and without po no can be updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test192_UpdateGRNJO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO without Po with invoice toggle");
	}



	@Test   @Category(SanityTests.class)
	public void Test199_AddGRNJO_WOPODC() throws Exception{
		log.startTestCase("Add GRN against JO without Po with DC toggle");
		extentTest = extent.startTest("Test199_AddGRNJO_WOPODC",
				"Verify if GRN against JO with DC toggle and without po no can be created").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.addGRN(198, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test199_AddGRNJO_WOPODC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO without Po with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test200_UpdateGRNJO_WOPODC() throws Exception{
		log.startTestCase("Update GRN against JO without Po with DC toggle");
		extentTest = extent.startTest("Test200_UpdateGRNJO_WOPODC",
				"Verify if GRN against JO with DC toggle and without po no can be updated").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.updateGRN(199, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and without po no can be updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test200_UpdateGRNJO_WOPODC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO without Po with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test201_ApproveGRNJO_WOPODC() throws Exception{
		log.startTestCase("Approve GRN against JO without Po with DC toggle");
		extentTest = extent.startTest("Test201_ApproveGRNJO_WOPODC",
				"Verify if GRN against JO with DC toggle and without po no can be approved").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.approveGRN(200, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and without po no can be approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test201_ApproveGRNJO_WOPODC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against JO without Po with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test205_UpdateGRNJO_WOPOGoods() throws Exception{
		log.startTestCase("Update GRN against JO without Po with Goods already received");
		extentTest = extent.startTest("Test205_UpdateGRNJO_WOPOGoods",
				"Verify if GRN against JO with Goods already received and without po no can be updated").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.updateGRN(204, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with Goods already received and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with Goods already received and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with Goods already received and without po no can be updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test205_UpdateGRNJO_WOPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO without Po with Goods already received");
	}

	@Test   @Category(SanityTests.class)
	public void Test212_UpdateGRNJO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Update GRN against JO with and without Po with invoice toggle");
		extentTest = extent.startTest("Test212_UpdateGRNJO_WNWOPOInvoice",
				"Verify if GRN against JO with invoice toggle and with and without po no can be updated").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.updateGRN(211, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and with and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and with and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and with and without po no can be updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test212_UpdateGRNJO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO with and without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test213_ApproveGRNJO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Approve GRN against JO with and without Po with invoice toggle");
		extentTest = extent.startTest("Test213_ApproveGRNJO_WNWOPOInvoice",
				"Verify if GRN against JO with invoice toggle and with and without po no can be approved").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.approveGRN(212, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and with and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and with and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and with and without po no can be approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test213_ApproveGRNJO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against JO with and without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test214_DraftRejectGRNJO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Draft Reject GRN against JO with and without Po with invoice toggle");
		extentTest = extent.startTest("Test214_DraftRejectGRNJO_WNWOPOInvoice",
				"Verify if GRN against JO with invoice toggle and with and without po no can be rejected in draft status").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.validateDraftRejectGRN(213, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and with and without po no can be rejected in draft status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and with and without po no can be rejected in draft status test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and with and without po no can be rejected in draft status test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test214_DraftRejectGRNJO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Draft Reject GRN against JO with and without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test215_RejectApprovedGRNJO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Reject Approved GRN against JO with and without Po with invoice toggle");
		extentTest = extent.startTest("Test215_RejectApprovedGRNJO_WNWOPOInvoice",
				"Verify if GRN against JO with invoice toggle and with and without po no can be rejected in approved status").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(214, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and with and without po no can be rejected in approved status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and with and without po no can be rejected in approved status test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and with and without po no can be rejected in approved status test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test215_RejectApprovedGRNJO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved GRN against JO with and without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test219_AddGRNJO_WNWOPODC() throws Exception{
		log.startTestCase("Add GRN against JO with and without Po with DC toggle");
		extentTest = extent.startTest("Test219_AddGRNJO_WNWOPODC",
				"Verify if GRN against JO with DC toggle and with and without po no can be created").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.addGRN(218, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and with and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and with and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and with and without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test219_AddGRNJO_WNWOPODC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO with and without Po with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test220_UpdateGRNJO_WNWOPODC() throws Exception{
		log.startTestCase("Update GRN against JO with and without Po with DC toggle");
		extentTest = extent.startTest("Test220_UpdateGRNJO_WNWOPODC",
				"Verify if GRN against JO with DC toggle and with and without po no can be updated").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.updateGRN(219, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and with and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and with and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and with and without po no can be updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test220_UpdateGRNJO_WNWOPODC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO with and without Po with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test221_ApproveGRNJO_WNWOPODC() throws Exception{
		log.startTestCase("Approve GRN against JO with and without Po with DC toggle");
		extentTest = extent.startTest("Test221_ApproveGRNJO_WNWOPODC",
				"Verify if GRN against JO with DC toggle and with and without po no can be approved").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.approveGRN(220, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and with and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and with and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and with and without po no can be approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test221_ApproveGRNJO_WNWOPODC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against JO with and without Po with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test225_UpdateGRNJO_WNWOPOGoods() throws Exception{
		log.startTestCase("Update GRN against JO with and without Po with Goods toggle");
		extentTest = extent.startTest("Test225_UpdateGRNJO_WNWOPOGoods",
				"Verify if GRN against JO with Goods toggle and with and without po no can be updated").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.updateGRN(224, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with Goods toggle and with and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with Goods toggle and with and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with Goods toggle and with and without po no can be updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test225_UpdateGRNJO_WNWOPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO with and without Po with Goods toggle");
	}


	@Test   @Category(SanityTests.class)
	public void Test256_AddGRNJOWOPOInvoice_NonStock() throws Exception{
		log.startTestCase("Add GRN against JO without Po with Invoice toggle and non stock material");
		extentTest = extent.startTest("Test256_AddGRNJOWOPOInvoice_NonStock",
				"Verify if GRN against JO without po and with invoice and non stock material is created").assignCategory("ReceiptWithNWithoutJO","SanityTests");
		try{
			boolean flag = store.addGRN(255, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO without po and with invoice and non stock material is created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO without po and with invoice and non stock material is created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO without po and with invoice and non stock material is created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test256_AddGRNJOWOPOInvoice_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO without Po with Invoice toggle and non stock material");
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
