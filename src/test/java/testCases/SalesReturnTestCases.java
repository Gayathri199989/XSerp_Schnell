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
import pages.SalesPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalesReturnTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
	AuditingPage audit = PageFactory.initElements(Constant.driver, AuditingPage.class);
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
		Constant.logFile("Sales return");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test   @Category(SanityTests.class)
	public void Test023_AddSalesReturn_Dctoggle() throws Exception{
		log.startTestCase("Sales return addition with Dc toggle");
		extentTest = extent.startTest("Test023_AddSalesReturn_Dctoggle",
				"Verify if sales return can be added").assignCategory("SalesReturnTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.addGRN(22,"Sales Return",null);
			if(flag){
				Constant.log.info("Sales return addtion with Dc toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return addtion with Dc toggle test case is successful");
			}else{
				System.err.println("Sales return addtion with Dc toggle test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test023_AddSalesReturn_Dctoggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return addition with Dc toggle");
	}

	@Test  @Category(SanityTests.class)
	public void Test029_AddSalesReturn_Invoice() throws Exception{
		log.startTestCase("Sales return addition with Invoice toggle");
		extentTest = extent.startTest("Test029_AddSalesReturn_Invoice",
				"Verify if sales return with Invoice toggle can be added").assignCategory("SalesReturnTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.addGRN(28,"Sales Return",null);
			if(flag){
				Constant.log.info("Sales return with Invoice toggle addtion test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return with Invoice toggle addtion test case is successful");
			}else{
				System.err.println("Sales return with Invoice toggle addtion test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test029_AddSalesReturn_Invoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return with Invoice toggle addition");
	}

	@Test   @Category(SanityTests.class)
	public void Test030_AddSalesReturn_goods() throws Exception{
		log.startTestCase("Sales return addition with Goods Received");
		extentTest = extent.startTest("Test030_AddSalesReturn_goods",
				"Verify if sales return with Goods can be added").assignCategory("SalesReturnTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.addGRN(29,"Sales Return",null);
			if(flag){
				Constant.log.info("Sales return addtion with Goods Received test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return addtion with Goods Received test case is successful");
			}else{
				System.err.println("Sales return addtion with Goods Received test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test030_AddSalesReturn_goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return addition with Goods Received");
	}

	@Test  @Category(SanityTests.class)
	public void Test045_UpdateSalesReturn_DcToggle() throws Exception{
		log.startTestCase("Sales return Update with Dc toggle");
		extentTest = extent.startTest("Test045_UpdateSalesReturn_DcToggle",
				"Verify if sales return with Dc toggle can be Update").assignCategory("SalesReturnTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.updateGRN(44,"Sales Return", null);
			if(flag){
				Constant.log.info("Sales return with Dc toggle Update test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return with Dc toggle Update test case is successful");
			}else{
				System.err.println("Sales return with Dc toggle Update test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test045_UpdateSalesReturn_DcToggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return with Dc toggle Update");
	}

	@Test  @Category(SanityTests.class)
	public void Test061_ApproveSalesReturn_InvoiceToggle() throws Exception{
		log.startTestCase("Sales return Inovice toggle Approve");
		extentTest = extent.startTest("Test061_ApproveSalesReturn_InvoiceToggle",
				"Verify if sales return invoice toggle can be Approve").assignCategory("SalesReturnTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.approveGRN(60,"Sales Return", null);
			if(flag){
				Constant.log.info("Sales return invoice toggle Approve test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return Approve test case is successful");
			}else{
				System.err.println("Sales return invoice toggle Approve test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test061_ApproveSalesReturn_InvoiceToggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return invoice toggle Approve");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test062_ApproveSRDC_RemarksCheck() throws Exception{
		log.startTestCase("Sales return with Dc toggle Approve and Remarks");
		extentTest = extent.startTest("Test062_ApproveSRDC_RemarksCheck",
				"Verify if sales return with Dc toggle can be Approved with remarks").assignCategory("SalesReturnTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.verifyRemarks(61,"Sales Return",null);
			if(flag){
				Constant.log.info("Sales return with Dc toggle Approve and Remarks test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return with Dc toggle Approve and Remarks test case is successful");
			}else{
				System.err.println("Sales return with Dc toggle Approve and Remarks test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test062_ApproveSRDC_RemarksCheck")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return with Dc toggle Approve and Remarks");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test063_RejectDraftSalesReturn_Goods() throws Exception{
		log.startTestCase("Sales return Draft Reject with Goods toggle");
		extentTest = extent.startTest("Test063_RejectDraftSalesReturn_Goods",
				"Verify if draft sales return can be Reject with Goods toggle").assignCategory("SalesReturnTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.validateDraftRejectGRN(62,"Sales Return");
			if(flag){
				Constant.log.info("Draft Sales return Reject with Goods toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Draft Sales return Reject with Goods toggle test case is successful");
			}else{
				System.err.println("Draft Sales return Reject with Goods toggle test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test063_RejectDraftSalesReturn_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return Draft Reject with Goods toggle");
	}

	@Test  @Category(SanityTests.class)
	public void Test064_RejectApprovedSalesReturn() throws Exception{
		log.startTestCase("Sales return Draft Reject");
		extentTest = extent.startTest("Test064_RejectApprovedSalesReturn",
				"Verify if draft sales return can be Reject").assignCategory("SalesReturnTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.vaildateRejectApprovedGRN(63,"Sales Return", null);
			if(flag){
				Constant.log.info("Draft Sales return Reject test case is successful");
				extentTest.log(LogStatus.PASS, "Draft Sales return Reject test case is successful");
			}else{
				System.err.println("Draft Sales return Reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test064_RejectApprovedSalesReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return Draft Reject");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test192_CheckICDSR_Invoice() throws Exception{
		log.startTestCase("Check ICD of SR with Invoice toggle");
		extentTest = extent.startTest("Test192_CheckICDSR_Invoice",
				"Verify if ICD is checked for SR with Invoice toggle").assignCategory("SalesReturnTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = audit.checkGRNPO(191, "Sales Return", "SR");
			if(flag){
				Constant.log.info("Verify if ICD is checked for SR with Invoice toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is checked for GRN SR with Invoice toggle test case is successful");
			}else{
				System.err.println("Verify if ICD is checked for SR with Invoice toggle test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test192_CheckICDSR_Invoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check ICD of SR with Invoice toggle");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test194_VerifyICDSR_Invoice() throws Exception{
		log.startTestCase("Verify ICD of SR with Invoice toggle");
		extentTest = extent.startTest("Test194_VerifyICDSR_Invoice",
				"Verify if ICD is Verifyed for SR with Invoice toggle").assignCategory("SalesReturnTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = audit.verifyGRNPO(193, "Sales Return", "SR", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Verified for SR with Invoice toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Verified for SR with Invoice toggle test case is successful");
			}else{
				System.err.println("Verify if ICD is Verified for SR with Invoice toggle test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test194_VerifyICDSR_Invoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD of SR with Invoice toggle");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test197_ReturnICDSR_Invoice() throws Exception{
		log.startTestCase("Return ICD of SR with Invoice toggle");
		extentTest = extent.startTest("Test197_ReturnICDSR_Invoice",
				"Verify if ICD is Returned for SR with Invoice toggle").assignCategory("SalesReturnTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = audit.returnGRNPO(196, "Sales Return", "SR", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Returned for SR with Invoice toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Returned for GRN SR with Invoice toggle test case is successful");
			}else{
				System.err.println("Verify if ICD is Returned for SR with Invoice toggle test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test197_ReturnICDSR_Invoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD of SR with Invoice toggle");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test214_ApproveSalesVoucher() throws Exception{
		log.startTestCase("Approve Sales voucher");
		extentTest = extent.startTest("Test214_ApproveSalesVoucher",
				"Verify if Sales voucher is Approved").assignCategory("SalesReturnTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			audit.verifyGRNPO(213, "Sales Return","SR", "Checked");
			int i = audit.icdList.size();
			String sGRNNO = audit.grnNoList.get(i-1).getText();
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(213, "Sales Return", sGRNNO);
			if(flag){
				Constant.log.info("Approve Sales voucher is successful");
				extentTest.log(LogStatus.PASS, "Approve Sales voucher is successful");
			}else{
				System.err.println("Approve Sales voucher failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test214_ApproveSalesVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Sales voucher");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test215_ApproveNoteVoucher() throws Exception{
		log.startTestCase("Approve Note voucher");
		extentTest = extent.startTest("Test215_ApproveNoteVoucher",
				"Verify if Note voucher is Approved").assignCategory("SalesReturnTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			audit.verifyGRNPO(214, "Sales Return","SR", "Checked");
			int i = audit.icdList.size();
			String sGRNNO = audit.grnNoList.get(i-1).getText();
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(214, "Sales Return", sGRNNO);
			if(flag){
				Constant.log.info("Approve Note voucher is successful");
				extentTest.log(LogStatus.PASS, "Approve Note voucher is successful");
			}else{
				System.err.println("Approve Note voucher failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test215_ApproveNoteVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Note voucher");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test310_ValidateItemsInvoiced_Draft() throws Exception{
		log.startTestCase("Items invoiced popup when SR goods in draft status");
		extentTest = extent.startTest("Test310_ValidateItemsInvoiced_Draft",
				"Verify if items invoiced pop up displayed draft SR details").assignCategory("SalesReturnTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.verifyItemsInvoiced_Draft(309,  "Sales Return");
			if(flag){
				Constant.log.info("Verify if items invoiced pop up displayed draft SR details test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced pop up displayed draft SR details test case is successful");
			}else{
				System.err.println("Verify if items invoiced pop up displayed draft SR details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test310_ValidateItemsInvoiced_Draft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced popup when SR goods in draft status");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test311_ValidateItemsInvoiced_approved() throws Exception{
		log.startTestCase("Items invoiced popup when SR goods in approved status");
		extentTest = extent.startTest("Test311_ValidateItemsInvoiced_approved",
				"Verify if items invoiced pop up displayed approved SR details").assignCategory("SalesReturnTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.verifyItemsInvoiced_Approved(310,  "Sales Return");
			if(flag){
				Constant.log.info("Verify if items invoiced pop up displayed approved SR details test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced pop up displayed approved SR details test case is successful");
			}else{
				System.err.println("Verify if items invoiced pop up displayed approved SR details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test311_ValidateItemsInvoiced_approved")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced popup when SR goods in approved status");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test312_ValidateItemsInvoiced_approvedRejected() throws Exception{
		log.startTestCase("Items invoiced popup when approved SR rejected ");
		extentTest = extent.startTest("Test312_ValidateItemsInvoiced_approvedRejected",
				"Verify if items invoiced pop up does not displayed rejected approved SR details").assignCategory("SalesReturnTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.verifyItemsInvoiced_ApprovedRejected(311, "Sales Return");
			if(flag){
				Constant.log.info("Verify if items invoiced pop up does not displayed rejected approved SR detailss test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced pop up does not displayed rejected approved SR details test case is successful");
			}else{
				System.err.println("Verify if items invoiced pop up does not displayed rejected approved SR details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test312_ValidateItemsInvoiced_approvedRejected")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced popup when approved SR rejected");
	}


	@Test  @Category(SanityTests.class)
	public void Test154_UpdateSalesReturn() throws Exception{
		log.startTestCase("Sales return Update");
		extentTest = extent.startTest("Test154_UpdateSalesReturn",
				"Verify if sales return can be Update").assignCategory("SalesReturnTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.updateGRN(153,"Sanity Test", null);
			if(flag){
				Constant.log.info("Sales return Update test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return Update test case is successful");
			}else{
				System.err.println("Sales return Update test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test154_UpdateSalesReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return Update");
	}

	@Test  @Category(SanityTests.class)
	public void Test156_RejectDraftSalesReturn_Invoice() throws Exception{
		log.startTestCase("Sales return Draft Reject with invoice toggle");
		extentTest = extent.startTest("Test156_RejectDraftSalesReturn_Invoice",
				"Verify if draft sales return can be Reject with invoice toggle").assignCategory("SalesReturnTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.validateDraftRejectGRN(155,"Sanity Test");
			if(flag){
				Constant.log.info("Draft Sales return Reject with invoice toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Draft Sales return Reject with invoice toggle test case is successful");
			}else{
				System.err.println("Draft Sales return Reject with invoice toggle test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test156_RejectDraftSalesReturn_Invoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return Draft Reject with invoice toggle");
	}

	@Test    @Category(SanityTests.class)
	public void Test229_ApproveSalesReturn_DcToggle() throws Exception{
		log.startTestCase("Sales return with Dc toggle Approve");
		extentTest = extent.startTest("Test229_ApproveSalesReturn_DcToggle",
				"Verify if sales return with Dc toggle can be Approve").assignCategory("SalesReturnTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.approveGRN(228,"Sanity Test",null);
			if(flag){
				Constant.log.info("Sales return with Dc toggle Approve test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return with Dc toggle Approve test case is successful");
			}else{
				System.err.println("Sales return with Dc toggle Approve test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test229_ApproveSalesReturn_DcToggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return with Dc toggle Approve");
	}

	@Test  @Category(SanityTests.class)
	public void Test231_UpdateSalesReturn_goods() throws Exception{
		log.startTestCase("Sales return Update with Goods Received");
		extentTest = extent.startTest("Sales return Update with Goods Received",
				"Verify if sales return with Goods Received can be Update").assignCategory("SalesReturnTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.updateGRN(230,"Sanity Test", null);
			if(flag){
				Constant.log.info("Sales return with Goods Received Update test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return with Goods Received Update test case is successful");
			}else{
				System.err.println("Sales return with Goods Received Update test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test231_UpdateSalesReturn_goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return with Goods Received Update");
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
