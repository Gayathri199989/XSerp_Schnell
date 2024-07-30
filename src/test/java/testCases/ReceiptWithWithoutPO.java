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
public class ReceiptWithWithoutPO {

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
	public void Test012_AddGRNWOPODC_Stock() throws Exception{
		log.startTestCase("Add GRN DC without Po having only stock material");
		extentTest = extent.startTest("Test012_AddGRNWOPODC_Stock",
				"Verify if GRN DC without po no can be created with only stock material").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(11, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN DC without po no can be created with only stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN DC without po no can be created with only stock material test case is successful");
			}else{
				System.err.println("Verify if GRN DC without po no can be created with only stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test012_AddGRNWOPODC_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN DC without Po having only stock material");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test013_AddGRNWOPODC_NonStock() throws Exception{
		log.startTestCase("Add GRN DC without Po having only Non stock material");
		extentTest = extent.startTest("Test013_AddGRNWOPODC_NonStock",
				"Verify if GRN DC without po no can be created with only Non stock material").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(12, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN DC without po no can be created with Non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN DC without po no can be created with Non stock material test case is successful");
			}else{
				System.err.println("Verify if GRN DC without po no can be created with Non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test013_AddGRNWOPODC_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN DC without Po having Non stock material");
	}

	@Test   @Category(SanityTests.class)
	public void Test014_AddGRNWOPOInvoice_StockNNonStock() throws Exception{
		log.startTestCase("Add GRN Invoice without Po having Stock N Non stock material");
		extentTest = extent.startTest("Test014_AddGRNWOPOInvoice_StockNNonStock",
				"Verify if GRN Invoice without po no can be created with Stock N Non stock material").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.addGRN(13, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN Invoice without po no can be created with Stock N Non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN Invoice without po no can be created with Stock N Non stock material test case is successful");
			}else{
				System.err.println("Verify if GRN Invoice without po no can be created with Stock N Non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test014_AddGRNWOPOInvoice_StockNNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN DC without Invoice having Stock N Non stock material");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test016_AddGRNWNWOPOInvoice_Stock() throws Exception{
		log.startTestCase("Add GRN Invoice with N without Po having Stock material");
		extentTest = extent.startTest("Test016_AddGRNWNWOPOInvoice_Stock",
				"Verify if GRN Invoice with N without po no can be created with Stock material").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(15, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN Invoice with N without po no can be created with Stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN Invoice with N without po no can be created with Stock material test case is successful");
			}else{
				System.err.println("Verify if GRN Invoice with N without po no can be created with Stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test016_AddGRNWNWOPOInvoice_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN Invoice with N without Po having Stock material");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test017_AddGRNWNWOPODC_NonStock() throws Exception{
		log.startTestCase("Add GRN DC with N without Po having Non stock material");
		extentTest = extent.startTest("Test017_AddGRNWNWOPODC_NonStock",
				"Verify if GRN DC with N without po no can be created with Non stock material").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(16, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN DC with N without po no can be created with Non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN DC with N without po no can be created with Non stock material test case is successful");
			}else{
				System.err.println("Verify if GRN DC with N without po no can be created with Non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test017_AddGRNWNWOPODC_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN DC with N without po having Non stock material");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test018_AddGRNWNWOPODC_StockNNonStock() throws Exception{
		log.startTestCase("Add GRN DC with N without Po having Stock N Non stock material");
		extentTest = extent.startTest("Test018_AddGRNWNWOPODC_StockNNonStock",
				"Verify if GRN DC with N without po no can be created with Stock N Non stock material").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(17, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN DC with N without po no can be created with Stock N Non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN DC with N without po no can be created with Stock N Non stock material test case is successful");
			}else{
				System.err.println("Verify if GRN DC with N without po no can be created with Stock N Non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test018_AddGRNWNWOPODC_StockNNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN DC with N without po having Stock N Non stock material");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test035_UpdateGRNWOPO_AddPO() throws Exception{
		log.startTestCase("Update GRN without PO adding PO no");
		extentTest = extent.startTest("Test035_UpdateGRNWOPO_AddPO",
				"Verify if able to update GRN without PO by adding PO no").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			store.addGRN(14, "GRN Without Po", null);
			boolean flag = store.updateGRNByAddingJo(34, "GRN Without Po");
			if(flag){
				Constant.log.info("Verify if able to update GRN without PO by adding PO no test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if able to update GRN without PO by adding PO no test case is successful");
			}else{
				System.err.println("Verify if able to update GRN without PO by adding PO no test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test035_UpdateGRNWOPO_AddPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN without PO adding PO no");
	}

	@Test   @Category(SanityTests.class)
	public void Test044_ApproveGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Approve GRN against Po without Po with invoice toggle");
		extentTest = extent.startTest("Test044_ApproveGRNPO_WOPOInvoice",
				"Verify if GRN against Po with invoice toggle and without po no can be approved").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.approveGRN(43, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and without po no can be approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test044_ApproveGRNPO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against Po without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test045_ApproveGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Approve GRN against Po with and without Po with invoice toggle");
		extentTest = extent.startTest("Test045_ApproveGRNPO_WNWOPOInvoice",
				"Verify if GRN against Po with invoice toggle and with and without po no can be approved").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.approveGRN(44, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and with and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and with and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and with and without po no can be approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test045_ApproveGRNPO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against Po with and without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test046_DraftRejectGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Draft Reject GRN against Po without Po with invoice toggle");
		extentTest = extent.startTest("Test046_DraftRejectGRNPO_WOPOInvoice",
				"Verify if GRN against Po with invoice toggle and without po no can be rejected in draft status").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.validateDraftRejectGRN(45, "GRN Without Po");
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and without po no can be rejected in draft status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and without po no can be rejected in draft status test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and without po no can be rejected in draft status test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test046_DraftRejectGRNPO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Draft Reject GRN against Po without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test047_DraftRejectGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Draft Reject GRN against Po with and without Po with invoice toggle");
		extentTest = extent.startTest("Test047_DraftRejectGRNPO_WNWOPOInvoice",
				"Verify if GRN against Po with invoice toggle and with and without po no can be rejected in draft status").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.validateDraftRejectGRN(46, "GRN Without Po");
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and with and without po no can be rejected in draft status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and with and without po no can be rejected in draft status test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and with and without po no can be rejected in draft status test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test047_DraftRejectGRNPO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Draft Reject GRN against Po with and without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test048_RejectApprovedGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Reject Approved GRN against Po without Po with invoice toggle");
		extentTest = extent.startTest("Test048_RejectApprovedGRNPO_WOPOInvoice",
				"Verify if GRN against Po with invoice toggle and without po no can be rejected in approved status").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(47, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and without po no can be rejected in approved status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and without po no can be rejected in approved status test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and without po no can be rejected in approved status test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test048_RejectApprovedGRNPO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved GRN against Po without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test049_RejectApprovedGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Reject Approved GRN against Po with and without Po with invoice toggle");
		extentTest = extent.startTest("Test049_RejectApprovedGRNPO_WNWOPOInvoice",
				"Verify if GRN against Po with invoice toggle and with and without po no can be rejected in approved status").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(48, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and with and without po no can be rejected in approved status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and with and without po no can be rejected in approved status test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and with and without po no can be rejected in approved status test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test049_RejectApprovedGRNPO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved GRN against Po with and without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test065_AddGRNPO_WOPOGoods() throws Exception{
		log.startTestCase("Add GRN against Po without Po with Goods already received");
		extentTest = extent.startTest("Test065_AddGRNPO_WOPOGoods",
				"Verify if GRN against Po with Goods already received and without po no can be created").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.addGRN(64, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with Goods already received and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with Goods already received and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with Goods already received and without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test065_AddGRNPO_WOPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po without Po with Goods already received");
	}

	@Test    @Category(HighPriorityTestCases.class)
	public void Test066_AddGRNPO_WPOGoods() throws Exception{
		log.startTestCase("Add GRN against Po with Po with Goods already received");
		extentTest = extent.startTest("Test066_AddGRNPO_WPOGoods",
				"Verify if GRN against Po with Goods already received and with po no can be created").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(65, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with Goods already received and with po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with Goods already received and with po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with Goods already received and with po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test066_AddGRNPO_WPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po with Po with Goods already received");
	}

	@Test   @Category(SanityTests.class)
	public void Test067_AddGRNPO_WNWOPOGoods() throws Exception{
		log.startTestCase("Add GRN against Po with and without Po with Goods toggle");
		extentTest = extent.startTest("Test067_AddGRNPO_WNWOPOGoods",
				"Verify if GRN against Po with Goods toggle and with and without po no can be created").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			store.approveGRN(66, "GRN Without Po", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			//row no pointed to previous row to create goods from above created grn with dc toggle
			boolean flag = store.addGRN(65, "GRN Without Po", sGRNNo);
			if(flag){
				Constant.log.info("Verify if GRN against Po with Goods toggle and with and  without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with Goods toggle and with and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with Goods toggle and with and without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test067_AddGRNPO_WNWOPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po with and without Po with Goods toggle");
	}

	@Test    @Category(HighPriorityTestCases.class)
	public void Test079_AddGRNPO_WPOMandatory() throws Exception{
		log.startTestCase("Add GRN against Po with Po Mandatory");
		extentTest = extent.startTest("Test079_AddGRNPO_WPOMandatory",
				"Verify if GRN against Po with po Mandatory").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			setting.purchaseMandatoryChkBx_Check();
			boolean flag = store.addGRN(78, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with po Mandatory can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with po Mandatory created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with po Mandatory created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test079_AddGRNPO_WPOMandatory")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po with Po Mandatory");
	}

	@Test   @Category(SanityTests.class)
	public void Test080_ValidateItemsInvoiced_Draft() throws Exception{
		log.startTestCase("Items invoiced popup when GRN goods in draft status");
		extentTest = extent.startTest("Test080_ValidateItemsInvoiced_Draft",
				"Verify if items invoiced pop up displayed draft GRN details").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.verifyItemsInvoiced_Draft(79,  "GRN Without Po");
			if(flag){
				Constant.log.info("Verify if items invoiced pop up displayed draft GRN details test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced pop up displayed draft GRN details test case is successful");
			}else{
				System.err.println("Verify if items invoiced pop up displayed draft GRN details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test080_ValidateItemsInvoiced_Draft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced popup when GRN goods in draft status");
	}

	@Test   @Category(SanityTests.class)
	public void Test083_UpdateGRNPO_WOPOGoods() throws Exception{
		log.startTestCase("Update GRN against Po without Po with Goods already received");
		extentTest = extent.startTest("Test083_UpdateGRNPO_WOPOGoods",
				"Verify if GRN against Po with Goods already received and without po no can be updated").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.updateGRN(82, "GRN Without Po", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with Goods already received and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with Goods already received and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with Goods already received and without po no can be updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test083_UpdateGRNPO_WOPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Po without Po with Goods already received");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test100_CheckICDGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Check ICD of GRN without Po with Invoice");
		extentTest = extent.startTest("Test100_CheckICDGRNPO_WOPOInvoice",
				"Verify if ICD is checked for GRN without po with Invoice").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = audit.checkGRNPO(99, "GRN Without Po", "GRN");
			if(flag){
				Constant.log.info("Verify if ICD is checked for GRN without po with Invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is checked for GRN without po with Invoice test case is successful");
			}else{
				System.err.println("Verify if ICD is checked for GRN without po with Invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test100_CheckICDGRNPO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check ICD of GRN without Po with Invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test101_CheckICDGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Check ICD of GRN with N without Po with Invoice");
		extentTest = extent.startTest("Test101_CheckICDGRNPO_WNWOPOInvoice",
				"Verify if ICD is checked for GRN with N without po with Invoice").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = audit.checkGRNPO(100, "GRN Without Po", "GRN");
			if(flag){
				Constant.log.info("Verify if ICD is checked for GRN with N without po with Invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is checked for GRN with N without po with Invoice test case is successful");
			}else{
				System.err.println("Verify if ICD is checked for GRN with N without po with Invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test101_CheckICDGRNPO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check ICD of GRN with N without Po with Invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test102_ReturnICDToGRN_WOPOInvoice() throws Exception{
		log.startTestCase("Return ICD to GRN without po invoice");
		extentTest = extent.startTest("Test102_ReturnICDToGRN_WOPOInvoice",
				"Verify if ICD can be returned to GRN without po invoice").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = audit.returnICDToGRN(101,"GRN Without Po");
			if(flag){
				Constant.log.info("Verify if ICD can be returned to GRN without po invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD can be returned to GRN without po invoice test case is successful");
			}else{
				System.err.println("Verify if ICD can be returned to GRN without po invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test102_ReturnICDToGRN_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD to GRN without po invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test103_ReturnICDToGRN_WNWOPOInvoice() throws Exception{
		log.startTestCase("Return ICD to GRN with N without po invoice");
		extentTest = extent.startTest("Test103_ReturnICDToGRN_WNWOPOInvoice",
				"Verify if ICD can be returned to GRN with N without po invoice").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = audit.returnICDToGRN(102,"GRN Without Po");
			if(flag){
				Constant.log.info("Verify if ICD can be returned to GRN with N without po invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD can be returned to GRN with N without po invoice test case is successful");
			}else{
				System.err.println("Verify if ICD can be returned to GRN with N without po invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test103_ReturnICDToGRN_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD to GRN with N without po invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test104_ReturnICDGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Return ICD of GRN PO with Invoice");
		extentTest = extent.startTest("Test104_ReturnICDGRNPO_WOPOInvoice",
				"Verify if ICD is Returned for GRN PO with Invoice").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = audit.returnGRNPO(103, "GRN Without Po","GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Returned for GRN PO with Invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Returned for GRN PO with Invoice test case is successful");
			}else{
				System.err.println("Verify if ICD is Returned for GRN PO with Invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test104_ReturnICDGRNPO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD of GRN PO with Invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test105_ReturnICDGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Return ICD of GRN PO with N without Invoice");
		extentTest = extent.startTest("Test105_ReturnICDGRNPO_WNWOPOInvoice",
				"Verify if ICD is Returned for GRN PO with N without Invoice").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = audit.returnGRNPO(104, "GRN Without Po","GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Returned for GRN PO with N without Invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Returned for GRN PO with N without Invoice test case is successful");
			}else{
				System.err.println("Verify if ICD is Returned for GRN PO with N without Invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test105_ReturnICDGRNPO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD of GRN PO with N without Invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test106_VerifyICDGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Verify ICD of GRN Po without po with invoice");
		extentTest = extent.startTest("Test106_VerifyICDGRNPO_WOPOInvoice",
				"Verify if ICD is Verifyed for GRN po without po with invoice").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = audit.verifyGRNPO(105, "GRN Without Po","GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Verified for GRN without po with invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Verified for GRN without po with invoice test case is successful");
			}else{
				System.err.println("Verify if ICD is Verified for GRN without po with invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test106_VerifyICDGRNPO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD of GRN without po with invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test107_VerifyICDGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Verify ICD of GRN Po with N without po with invoice");
		extentTest = extent.startTest("Test107_VerifyICDGRNPO_WNWOPOInvoice",
				"Verify if ICD is Verifyed for GRN po with N without po with invoice").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			boolean flag = audit.verifyGRNPO(106, "GRN Without Po","GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Verified for GRN with N without po with invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Verified for GRN with N without po with invoice test case is successful");
			}else{
				System.err.println("Verify if ICD is Verified for GRN with N without po with invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test107_VerifyICDGRNPO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD of GRN with N without po with invoice");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test108_ApprovePurchaseVoucher_WOPO() throws Exception{
		log.startTestCase("Approve Purchase voucher wihtout po");
		extentTest = extent.startTest("Test108_ApprovePurchaseVoucher_WOPO",
				"Verify if Purchase voucher is Approved wihtout po").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			audit.verifyGRNPO(107, "GRN Without Po","GRN", "Checked");
			int i = audit.icdList.size();
			String sGRNNO = audit.grnNoList.get(i-1).getText();
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(107, "GRN Without Po", sGRNNO);
			if(flag){
				Constant.log.info("Approve Purchase voucher wihtout po is successful");
				extentTest.log(LogStatus.PASS, "Approve Purchase voucher wihtout po is successful");
			}else{
				System.err.println("Approve Purchase voucher wihtout po failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test108_ApprovePurchaseVoucher_WOPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Purchase voucher wihtout po");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test109_ApprovePurchaseVoucher_WNWOPO() throws Exception{
		log.startTestCase("Approve Purchase voucher with N wihtout po");
		extentTest = extent.startTest("Test109_ApprovePurchaseVoucher_WNWOPO",
				"Verify if Purchase voucher is Approved with N wihtout po").assignCategory("ReceiptWithWithoutPO","HighPriorityTestCases");
		try{
			audit.verifyGRNPO(108, "GRN Without Po","GRN", "Checked");
			int i = audit.icdList.size();
			String sGRNNO = audit.grnNoList.get(i-1).getText();
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(108, "GRN Without Po", sGRNNO);
			if(flag){
				Constant.log.info("Approve Purchase voucher with N wihtout po is successful");
				extentTest.log(LogStatus.PASS, "Approve Purchase voucher with N wihtout po is successful");
			}else{
				System.err.println("Approve Purchase voucher with N wihtout po failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test109_ApprovePurchaseVoucher_WNWOPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Purchase voucher with N wihtout po");
	}

	@Test   @Category(SanityTests.class)
	public void Test186_AddGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Add GRN against Po without Po with invoice toggle");
		extentTest = extent.startTest("Test186_AddGRNPO_WOPOInvoice",
				"Verify if GRN against Po with invoice toggle and without po no can be created").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.addGRN(185, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test186_AddGRNPO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test187_UpdateGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Update GRN against Po without Po with invoice toggle");
		extentTest = extent.startTest("Test187_UpdateGRNPO_WOPOInvoice",
				"Verify if GRN against Po with invoice toggle and without po no can be updated").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.updateGRN(186, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and without po no can be updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test187_UpdateGRNPO_WOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Po without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test196_AddGRNPO_WOPODC() throws Exception{
		log.startTestCase("Add GRN against Po without Po with DC toggle");
		extentTest = extent.startTest("Test196_AddGRNPO_WOPODC",
				"Verify if GRN against Po with DC toggle and without po no can be created").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.addGRN(195, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with DC toggle and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with DC toggle and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with DC toggle and without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test196_AddGRNPO_WOPODC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po without Po with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test197_UpdateGRNPO_WOPODC() throws Exception{
		log.startTestCase("Update GRN against Po without Po with DC toggle");
		extentTest = extent.startTest("Test197_UpdateGRNPO_WOPODC",
				"Verify if GRN against Po with DC toggle and without po no can be updated").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.updateGRN(196, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with DC toggle and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with DC toggle and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with DC toggle and without po no can be updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test197_UpdateGRNPO_WOPODC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Po without Po with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test198_ApproveGRNPO_WOPODC() throws Exception{
		log.startTestCase("Approve GRN against Po without Po with DC toggle");
		extentTest = extent.startTest("Test198_ApproveGRNPO_WOPODC",
				"Verify if GRN against Po with DC toggle and without po no can be approved").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.approveGRN(197, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with DC toggle and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with DC toggle and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with DC toggle and without po no can be approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test198_ApproveGRNPO_WOPODC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against Po without Po with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test206_AddGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Add GRN against Po with and without Po with invoice toggle");
		extentTest = extent.startTest("Test206_AddGRNPO_WNWOPOInvoice",
				"Verify if GRN against Po with invoice toggle and with and without po no can be created").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.addGRN(205, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and with and  without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and with and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and with and without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test206_AddGRNPO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po with and without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test207_UpdateGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Update GRN against Po with and without Po with invoice toggle");
		extentTest = extent.startTest("Test207_UpdateGRNPO_WNWOPOInvoice",
				"Verify if GRN against Po with invoice toggle and with and without po no can be updated").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.updateGRN(206, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and with and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and with and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and with and without po no can be updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test207_UpdateGRNPO_WNWOPOInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Po with and without Po with invoice toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test216_AddGRNPO_WNWOPODC() throws Exception{
		log.startTestCase("Add GRN against Po with and without Po with DC toggle");
		extentTest = extent.startTest("Test216_AddGRNPO_WNWOPODC",
				"Verify if GRN against Po with DC toggle and with and without po no can be created").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.addGRN(215, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with DC toggle and with and  without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with DC toggle and with and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with DC toggle and with and without po no can be created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test216_AddGRNPO_WNWOPODC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po with and without Po with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test217_UpdateGRNPO_WNWOPODC() throws Exception{
		log.startTestCase("Update GRN against Po with and without Po with DC toggle");
		extentTest = extent.startTest("Test217_UpdateGRNPO_WNWOPODC",
				"Verify if GRN against Po with DC toggle and with and without po no can be updated").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.updateGRN(216, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with DC toggle and with and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with DC toggle and with and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with DC toggle and with and without po no can be updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test217_UpdateGRNPO_WNWOPODC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Po with and without Po with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test218_ApproveGRNPO_WNWOPODC() throws Exception{
		log.startTestCase("Approve GRN against Po with and without Po with DC toggle");
		extentTest = extent.startTest("Test218_ApproveGRNPO_WNWOPODC",
				"Verify if GRN against Po with DC toggle and with and without po no can be approved").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.approveGRN(217, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with DC toggle and with and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with DC toggle and with and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with DC toggle and with and without po no can be approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test218_ApproveGRNPO_WNWOPODC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against Po with and without Po with DC toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test223_UpdateGRNPO_WNWOPOGoods() throws Exception{
		log.startTestCase("Update GRN against Po with and without Po with Goods toggle");
		extentTest = extent.startTest("Test223_UpdateGRNPO_WNWOPOGoods",
				"Verify if GRN against Po with Goods toggle and with and without po no can be updated").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.updateGRN(222, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with Goods toggle and with and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with Goods toggle and with and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with Goods toggle and with and without po no can be updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test223_UpdateGRNPO_WNWOPOGoods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Po with and without Po with Goods toggle");
	}

	@Test   @Category(SanityTests.class)
	public void Test255_AddGRNWOPODC_NonStock() throws Exception{
		log.startTestCase("Add GRN DC without Po having only Non stock material");
		extentTest = extent.startTest("Test255_AddGRNWOPODC_NonStock",
				"Verify if GRN DC without po no can be created with only Non stock material").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.addGRN(254, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN DC without po no can be created with only Non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN DC without po no can be created with only Non stock material test case is successful");
			}else{
				System.err.println("Verify if GRN DC without po no can be created with only Non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test255_AddGRNWOPODC_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN DC without Po having only Non stock material");
	}

	@Test   @Category(SanityTests.class)
	public void Test260_ApproveGRNWOPODC_NonStock() throws Exception{
		log.startTestCase("Approve GRN DC without Po having only Non stock material");
		extentTest = extent.startTest("Test260_ApproveGRNWOPODC_NonStock",
				"Verify if GRN DC without po no can be approved with only Non stock material").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.approveGRN(259, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN DC without po no can be created with only Non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN DC without po no can be created with only Non stock material test case is successful");
			}else{
				System.err.println("Verify if GRN DC without po no can be created with only Non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test260_ApproveGRNWOPODC_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN DC without Po having only Non stock material");
	}

	@Test   @Category(SanityTests.class)
	public void Test261_AddGRNWOPOGoods_NonStock() throws Exception{
		log.startTestCase("add GRN Goods without Po having only Non stock material");
		extentTest = extent.startTest("Test261_AddGRNWOPOGoods_NonStock",
				"Verify if GRN Goods without po no can be created with only Non stock material").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			store.approveGRN(259, "Sanity Test", null);//dont change row no
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			boolean flag = store.addGRN(260, "Sanity Test", sGRNNo);
			if(flag){
				Constant.log.info("Verify if GRN Goods without po no can be created with only Non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN DC without po no can be created with only Non stock material test case is successful");
			}else{
				System.err.println("Verify if GRN Goods without po no can be created with only Non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test261_AddGRNWOPOGoods_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("add GRN Goods without Po having only Non stock material");
	}

	@Test @Category(SanityTests.class)
	public void Test292_AddGRN_AltUnit() throws Exception{
		log.startTestCase("ADD GRN with alternate unit");
		extentTest = extent.startTest("Test292_AddGRN_AltUnit",
				"Verify if GRN with added with alternate unit").assignCategory("ReceiptWithWithoutPO","SanityTests");
		try{
			boolean flag = store.addGRN(291, "Sanity Test",null);
			if(flag){
				Constant.log.info("ADD GRN with alternate unit is successful");
				extentTest.log(LogStatus.PASS, "ADD GRN with alternate unit is successful");
			}else{
				System.err.println("ADD GRN with alternate unit failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test292_AddGRN_AltUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("ADD GRN with alternate unit");
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
