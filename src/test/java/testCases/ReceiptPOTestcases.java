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
import org.openqa.selenium.By;
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
import pages.PurchasePage;
import pages.SettingPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReceiptPOTestcases {

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
		Constant.logFile("Receipt with PO");
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

	@Test @Category(SmokeTest.class)
	public void Test034_AddGRN_Stock() throws Exception{
		log.startTestCase("Add GRN with stock material");
		extentTest = extent.startTest("Test034_AddGRN_Stock",
				"Verify if GRN is added with stock material").assignCategory("ReceiptPOTestcases","SmokeTest");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			po.ApproveQuickPO(33, "Receipt PO");
			int iPoNum = Integer.parseInt(po.poVisibleRecordCount.getText().substring(14).trim());
			String sPONum = po.driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")).getText();
			boolean flag = store.addGRN(33, "Receipt PO",sPONum);
			if(flag){
				Constant.log.info("GRN addition with stock material is successful");
				extentTest.log(LogStatus.PASS, "GRN addition with stock material is successful");
			}else{
				System.err.println("GRN addition with stock material failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test034_AddGRN_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add GRN with stock material");
	}

	@Test @Category(SanityTests.class)
	public void Test036_AddGRN_NonStock() throws Exception{
		log.startTestCase("Add GRN with Non Stock material");
		extentTest = extent.startTest("Test036_AddGRN_NonStock",
				"Verify if GRN is added with Non Stock material").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			po.ApproveQuickPO(35, "Receipt PO");
			int iPoNum = Integer.parseInt(po.poVisibleRecordCount.getText().substring(14).trim());
			String sPONum = po.driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")).getText();
			boolean flag = store.addGRN(35, "Receipt PO",sPONum);
			if(flag){
				Constant.log.info("GRN addition with Non Stock material is successful");
				extentTest.log(LogStatus.PASS, "GRN addition with Non Stock material is successful");
			}else{
				System.err.println("GRN addition with Non Stock material failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test036_AddGRN_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add GRN with Non Stock material");
	}

	@Test @Category(SanityTests.class)
	public void Test039_AddGRN_StockNNonStock() throws Exception{
		log.startTestCase("Add GRN with Stock and Non Stock material");
		extentTest = extent.startTest("Test039_AddGRN_StockNNonStock",
				"Verify if GRN is added with Stock and Non Stock material").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			po.ApproveQuickPO(38, "Receipt PO");
			int iPoNum = Integer.parseInt(po.poVisibleRecordCount.getText().substring(14).trim());
			String sPONum = po.driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")).getText();
			boolean flag = store.addGRN(38, "Receipt PO",sPONum);
			if(flag){
				Constant.log.info("GRN addition with Stock and Non Stock material is successful");
				extentTest.log(LogStatus.PASS, "GRN addition with Stock and Non Stock material is successful");
			}else{
				System.err.println("GRN addition with Stock and Non Stock material failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test039_AddGRN_StockNNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add GRN with Stock and Non Stock material");
	}

	@Test  @Category(SanityTests.class)
	public void Test049_ApproveGRN() throws Exception{
		log.startTestCase("Approve GRN");
		extentTest = extent.startTest("Test049_ApproveGRN",
				"Verify if GRN is Approved").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.approveGRN(48, "Receipt PO", null);
			if(flag){
				Constant.log.info("GRN Approve is successful");
				extentTest.log(LogStatus.PASS, "GRN Approve is successful");
			}else{
				System.err.println("GRN Approve failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test049_ApproveGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve GRN");
	}

	@Test @Category(SanityTests.class)
	public void Test050_DraftGRNReject() throws Exception{
		log.startTestCase("Draft GRN Reject");
		extentTest = extent.startTest("Test050_DraftGRNReject",
				"Verify if draft GRN is Rejected").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.validateDraftRejectGRN(49, "Receipt PO");
			if(flag){
				Constant.log.info("Draft GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft GRN Reject is successful");
			}else{
				System.err.println("Draft GRN Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test050_DraftGRNReject")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft GRN Reject");
	}

	@Test @Category(SanityTests.class)
	public void Test051_ApprovedGRNReject() throws Exception{
		log.startTestCase("Approved GRN Reject");
		extentTest = extent.startTest("Test051_ApprovedGRNReject",
				"Verify if Approved GRN is Rejected").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(50, "Receipt PO", null);
			if(flag){
				Constant.log.info("Approved GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved GRN Reject is successful");
			}else{
				System.err.println("Approved GRN Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test051_ApprovedGRNReject")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved GRN Reject");
	}

	@Test  @Category(SanityTests.class)
	public void Test159_ApproveReturnedGRNFrmICd() throws Exception{
		log.startTestCase("Approve Returned GRN");
		extentTest = extent.startTest("Test159_ApproveReturnedGRNFrmICd",
				"Verify if Returned GRN can be approved").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			setting.purchaseMandatoryChkBx_UnCheck();
			setting.reqAckn_UnCheck();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRN();
			boolean flag = store.approveReturnedGRN(158, "Sanity Test");
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			setting.purchaseMandatoryChkBx_Check();
			if(flag){
				Constant.log.info("Verify if Returned GRN can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Returned GRN can be approved test case is successful");
			}else{
				System.err.println("Verify if Returned GRN can be approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test159_ApproveReturnedGRNFrmICd")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Returned GRN");
	}

	@Category(SanityTests.class)
	@Test
	public void Test056_UpdateGRN() throws Exception{
		log.startTestCase("Update GRN");
		extentTest = extent.startTest("Test056_UpdateGRN",
				"Verify if GRN is Updated").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.updateGRN(55, "Receipt PO", null);
			if(flag){
				Constant.log.info("GRN Update is successful");
				extentTest.log(LogStatus.PASS, "GRN Update is successful");
			}else{
				System.err.println("GRN Update failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test056_UpdateGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update GRN");
	}

	@Test  @Category(SanityTests.class)
	public void Test130_AddGRNPO_WithDC() throws Exception{
		log.startTestCase("Add GRN with Dc toggle");
		extentTest = extent.startTest("Test130_AddGRNPO_WithDC",
				"Verify if GRN is added").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.addGRN(129, "Receipt PO",null);
			if(flag){
				Constant.log.info("Verify if GRn added with dc toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRn added with dc toggle test case is successful");
			}else{
				System.err.println("Verify if GRn added with dc toggle test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test130_AddGRNPO_WithDC")));
			}
 		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add GRN with DC toggle");
	}

	@Test  @Category(SanityTests.class)
	public void Test134_UpdateGRNPO_DcToggle() throws Exception{
		log.startTestCase("Update GRN with Dc toggle");
		extentTest = extent.startTest("Test134_UpdateGRNPO_DcToggle",
				"Verify if GRN with Dc toggle is Updated").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.updateGRN(133, "Receipt PO", null);
			if(flag){
				Constant.log.info("GRN Update with Dc toggle is successful");
				extentTest.log(LogStatus.PASS, "GRN Update with Dc toggle is successful");
			}else{
				System.err.println("GRN Update with Dc toggle failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test134_UpdateGRNPO_DcToggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update GRN with Dc toggle");
	}

	@Test  @Category(SanityTests.class)
	public void Test137_ApproveGRNPO_DcToggle() throws Exception{
		log.startTestCase("Approve GRN with Dc toggle");
		extentTest = extent.startTest("Test137_ApproveGRNPO_DcToggle",
				"Verify if GRN with Dc toggle is Approved").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.approveGRN(136, "Receipt PO",null);
			if(flag){
				Constant.log.info("GRN Approve with Dc toggle is successful");
				extentTest.log(LogStatus.PASS, "GRN Approve with Dc toggle is successful");
			}else{
				System.err.println("GRN Approve with Dc toggle failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test137_ApproveGRNPO_DcToggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve GRN with Dc toggle");
	}

	@Test  @Category(SanityTests.class)
	public void Test138_DraftGRNPoReject_DcToggle() throws Exception{
		log.startTestCase("Draft GRN Reject with Dc toggle");
		extentTest = extent.startTest("Test138_DraftGRNPoReject_DcToggle",
				"Verify if draft GRN with Dc toggle is Rejected").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.validateDraftRejectGRN(137, "Receipt PO");
			if(flag){
				Constant.log.info("Draft GRN with Dc toggle Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft GRN with Dc toggle Reject is successful");
			}else{
				System.err.println("Draft GRN with Dc toggle Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test138_DraftGRNPoReject_DcToggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft GRN with Dc toggle Reject");
	}

	@Test  @Category(SanityTests.class)
	public void Test139_ApprovedGRNPOReject_DcToggle() throws Exception{
		log.startTestCase("Approved GRN with Dc toggle Reject");
		extentTest = extent.startTest("Test139_ApprovedGRNPOReject_DcToggle",
				"Verify if Approved GRN with Dc toggle is Rejected").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(138, "Receipt PO",null);
			if(flag){
				Constant.log.info("Approved GRN with Dc toggle Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved GRN with Dc toggle Reject is successful");
			}else{
				System.err.println("Approved GRN with Dc toggle Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test139_ApprovedGRNPOReject_DcToggle")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved GRN with Dc toggle Reject");
	}

	@Test   @Category(SanityTests.class)
	public void Test165_AddGRNPO_GoodsAlreadyReceived() throws Exception{
		log.startTestCase("Add GRN with goods already received checkbox");
		extentTest = extent.startTest("Test165_AddGRNPO_GoodsAlreadyReceived",
				"Verify if GRN is added").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.addGRN(164, "Receipt PO",null);
			if(flag){
				Constant.log.info("Verify if GRn added with goods already received checkbox test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRn added with goods already received checkbox test case is successful");
			}else{
				System.err.println("Verify if GRn added with goods already received checkbox test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test165_AddGRNPO_GoodsAlreadyReceived")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add GRN with goods already received checkbox");
	}

	@Test   @Category(SanityTests.class)
	public void Test174_ApproveGRNPo_GoodsAlreadyReceived() throws Exception{
		log.startTestCase("Approve GRN with goods already received checkbox");
		extentTest = extent.startTest("Test174_ApproveGRNPo_GoodsAlreadyReceived",
				"Verify if GRN with goods already received checkbox is Approved").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.approveGRN(173, "Receipt PO",null);
			if(flag){
				Constant.log.info("GRN Approve with goods already received checkbox is successful");
				extentTest.log(LogStatus.PASS, "GRN Approve with goods already received checkbox is successful");
			}else{
				System.err.println("GRN Approve with goods already received checkbox failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test174_ApproveGRNPo_GoodsAlreadyReceived")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve GRN with goods already received checkbox");
	}

	@Test   @Category(SanityTests.class)
	public void Test175_DraftGRNPOReject_GoodsAlreadyReceived() throws Exception{
		log.startTestCase("Draft GRN Reject with goods already received checkbox");
		extentTest = extent.startTest("Test175_DraftGRNPOReject_GoodsAlreadyReceived",
				"Verify if draft GRN with goods already received checkbox is Rejected").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.validateDraftRejectGRN(174, "Receipt PO");
			if(flag){
				Constant.log.info("Draft GRN with goods already received checkbox Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft GRN with goods already received checkbox Reject is successful");
			}else{
				System.err.println("Draft GRN with goods already received checkbox Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test175_DraftGRNPOReject_GoodsAlreadyReceived")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft GRN with goods already received checkbox Reject");
	}

	@Test   @Category(SanityTests.class)
	public void Test176_ApprovedGRNPoReject_GoodsAlreadyReceived() throws Exception{
		log.startTestCase("Approved GRN with goods already received checkbox Reject");
		extentTest = extent.startTest("Test176_ApprovedGRNPoReject_GoodsAlreadyReceived",
				"Verify if Approved GRN with goods already received checkbox is Rejected").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(175, "Receipt PO",null);
			if(flag){
				Constant.log.info("Approved GRN with goods already received checkbox Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved GRN with goods already received checkbox Reject is successful");
			}else{
				System.err.println("Approved GRN with goods already received checkbox Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test176_ApprovedGRNPoReject_GoodsAlreadyReceived")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved GRN with goods already received checkbox Reject");
	}

	@Test   @Category(SanityTests.class)
	public void Test181_UpdateGRNPO_GoodsAlreadyReceived() throws Exception{
		log.startTestCase("Update GRN with goods already received checkbox");
		extentTest = extent.startTest("Test181_UpdateGRNPO_GoodsAlreadyReceived",
				"Verify if GRN with goods already received checkbox is Updated").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.updateGRN(180, "Receipt PO", null);
			if(flag){
				Constant.log.info("GRN Update with goods already received checkbox is successful");
				extentTest.log(LogStatus.PASS, "GRN Update with goods already received checkbox is successful");
			}else{
				System.err.println("GRN Update with goods already received checkbox failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test181_UpdateGRNPO_GoodsAlreadyReceived")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update GRN with goods already received checkbox");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test220_CheckICDGRNPO_Goods() throws Exception{
		log.startTestCase("Check ICD of GRN Po with Goods already received");
		extentTest = extent.startTest("Test220_CheckICDGRNPO_Goods",
				"Verify if ICD is checked for GRN po with Goods already received").assignCategory("ReceiptPOTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			boolean flag = audit.checkGRNPO(219, "Receipt PO", "GRN");
			if(flag){
				Constant.log.info("Verify if ICD is checked for GRN po with Goods already received test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is checked for GRN po with Goods already received test case is successful");
			}else{
				System.err.println("Verify if ICD is checked for GRN po with Goods already received test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test220_CheckICDGRNPO_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check ICD of GRN Po with Goods already received");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test221_VerifyICDGRNPO_Goods() throws Exception{
		log.startTestCase("Verify ICD of GRN Po with Goods already received");
		extentTest = extent.startTest("Test221_VerifyICDGRNPO_Goods",
				"Verify if ICD is Verifyed for GRN po with Goods already received").assignCategory("ReceiptPOTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			boolean flag = audit.verifyGRNPO(220, "Receipt PO","GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Verified for GRN po with Goods already received test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Verified for GRN po with Goods already received test case is successful");
			}else{
				System.err.println("Verify if ICD is Verified for GRN po with Goods already received test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test221_VerifyICDGRNPO_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD of GRN Po with Goods already received");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test222_ReturnICDGRNPO_Goods() throws Exception{
		log.startTestCase("Return ICD of GRN PO with Goods already received");
		extentTest = extent.startTest("Test222_ReturnICDGRNPO_Goods",
				"Verify if ICD is Returned for GRN PO with Goods already received").assignCategory("ReceiptPOTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			boolean flag = audit.returnGRNPO(221, "Receipt PO","GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Returned for GRN PO with Goods already received test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Returned for GRN PO with Goods already received test case is successful");
			}else{
				System.err.println("Verify if ICD is Returned for GRN PO with Goods already received test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test222_ReturnICDGRNPO_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD of GRN PO with Goods already received");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test223_VerifyReturnICDGRN_Goods() throws Exception{
		log.startTestCase("verify returned ICD of GRN PO with Goods already received");
		extentTest = extent.startTest("Test223_VerifyReturnICDGRN_Goods",
				"Verify if ICD is Verify returneded for GRN PO with Goods already received").assignCategory("ReceiptPOTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			boolean flag = audit.verifyReturnGRNPO(222, "Receipt PO","GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if returned ICD is Verified for GRN PO with Goods already received test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if returned ICD is Verified for GRN PO with Goods already received test case is successful");
			}else{
				System.err.println("Verify if returned ICD is Verified for GRN PO with Goods already received test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test223_VerifyReturnICDGRN_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify returned ICD of GRN PO with Goods already received");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test233_ApproveNoteVoucher() throws Exception{
		log.startTestCase("Approve Note voucher");
		extentTest = extent.startTest("Test233_ApproveNoteVoucherr",
				"Verify if Note voucher is Approved").assignCategory("ReceiptPOTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			audit.verifyGRNPO(232, "Receipt PO","GRN", "Checked");
			int i = audit.icdList.size();
			String sGRNNO = audit.grnNoList.get(i-1).getText();
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(232, "Receipt PO", sGRNNO);
			if(flag){
				Constant.log.info("Approve Note voucher is successful");
				extentTest.log(LogStatus.PASS, "Approve Note voucher is successful");
			}else{
				System.err.println("Approve Note voucher failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test233_ApproveNoteVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Note voucher");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test234_ApprovePurchaseVoucher() throws Exception{
		log.startTestCase("Approve Purchase voucher");
		extentTest = extent.startTest("Test234_ApprovePurchaseVoucher",
				"Verify if Purchase voucher is Approved").assignCategory("ReceiptPOTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			audit.verifyGRNPO(233, "Receipt PO","GRN", "Checked");
			int i = audit.icdList.size();
			String sGRNNO = audit.grnNoList.get(i-1).getText();
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(233, "Receipt PO", sGRNNO);
			if(flag){
				Constant.log.info("Approve Purchase voucher is successful");
				extentTest.log(LogStatus.PASS, "Approve Purchase voucher is successful");
			}else{
				System.err.println("Approve Purchase voucher failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test234_ApprovePurchaseVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Purchase voucher");
	}

	@Test   @Category(SanityTests.class)
	public void Test359_ValidateItemsInvoiced_Draft() throws Exception{
		log.startTestCase("Items invoiced popup when GRN goods in draft status");
		extentTest = extent.startTest("Test359_ValidateItemsInvoiced_Draft",
				"Verify if items invoiced pop up displayed draft GRN details").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.verifyItemsInvoiced_Draft(358,  "Receipt PO");
			if(flag){
				Constant.log.info("Verify if items invoiced pop up displayed draft GRN details test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced pop up displayed draft GRN details test case is successful");
			}else{
				System.err.println("Verify if items invoiced pop up displayed draft GRN details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test359_ValidateItemsInvoiced_Draft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced popup when GRN goods in draft status");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test360_ValidateItemsInvoiced_approved() throws Exception{
		log.startTestCase("Items invoiced popup when GRN goods in approved status");
		extentTest = extent.startTest("Test360_ValidateItemsInvoiced_approved",
				"Verify if items invoiced pop up displayed approved GRN details").assignCategory("ReceiptPOTestcases","HighPriorityTestCases");
		try{
			boolean flag = store.verifyItemsInvoiced_Approved(359,  "Receipt PO");
			if(flag){
				Constant.log.info("Verify if items invoiced pop up displayed approved GRN details test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced pop up displayed approved GRN details test case is successful");
			}else{
				System.err.println("Verify if items invoiced pop up displayed approved GRN details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test360_ValidateItemsInvoiced_approved")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced popup when GRN goods in approved status");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test361_ValidateItemsInvoiced_draftRejected() throws Exception{
		log.startTestCase("Items invoiced popup when draft grn rejected ");
		extentTest = extent.startTest("Test361_ValidateItemsInvoiced_draftRejected",
				"Verify if items invoiced pop up does not displayed rejected draft GRN details").assignCategory("ReceiptPOTestcases","HighPriorityTestCases");
		try{
			boolean flag = store.verifyItemsInvoiced_DraftRejected(360, "Receipt PO");
			if(flag){
				Constant.log.info("Verify if items invoiced pop up does not displayed rejected draft GRN detailss test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced pop up does not displayed rejected draft GRN details test case is successful");
			}else{
				System.err.println("Verify if items invoiced pop up does not displayed rejected draft GRN details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test361_ValidateItemsInvoiced_draftRejected")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced popup when draft grn rejected");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test362_ValidateItemsInvoiced_approvedRejected() throws Exception{
		log.startTestCase("Items invoiced popup when approved grn rejected ");
		extentTest = extent.startTest("Test362_ValidateItemsInvoiced_approvedRejected",
				"Verify if items invoiced pop up does not displayed rejected approved GRN details").assignCategory("ReceiptPOTestcases","HighPriorityTestCases");
		try{
			boolean flag = store.verifyItemsInvoiced_ApprovedRejected(360, "Receipt PO");
			if(flag){
				Constant.log.info("Verify if items invoiced pop up does not displayed rejected approved GRN detailss test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced pop up does not displayed rejected approved GRN details test case is successful");
			}else{
				System.err.println("Verify if items invoiced pop up does not displayed rejected approved GRN details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test362_ValidateItemsInvoiced_approvedRejected")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced popup when approved grn rejected");
	}

	@Test  @Category(SanityTests.class)
	public void Test270_ValidateNotePreview_ShortNRej() throws Exception{
		log.startTestCase("Items invoiced popup when approved grn rejected ");
		extentTest = extent.startTest("Test270_ValidateNotePreview_ShortNRej",
				"Verify if items invoiced pop up does not displayed rejected approved GRN details").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			boolean flag = store.verifyNotePreviewPopup(269, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if items invoiced pop up does not displayed rejected approved GRN detailss test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced pop up does not displayed rejected approved GRN details test case is successful");
			}else{
				System.err.println("Verify if items invoiced pop up does not displayed rejected approved GRN details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test270_ValidateNotePreview_ShortNRej")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced popup when approved grn rejected");
	}

	@Test  @Category(SanityTests.class)
	public void Test286_addGRN_BlanketPO() throws Exception{
		log.startTestCase("Add grn with blanket PO");
		extentTest = extent.startTest("Test286_addGRN_BlanketPO",
				"Verify if grn added with blanket po").assignCategory("ReceiptPOTestcases","SanityTests");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			po.ApproveQuickPO(285, "Sanity Test");
			int iPoNum = Integer.parseInt(po.poVisibleRecordCount.getText().substring(14).trim());
			String sPONum = po.driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")).getText();
			boolean flag = store.addGRN(285, "Sanity Test",sPONum);
			if(flag){
				Constant.log.info("Verify if grn added with blanket po test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if  grn added with blanket po test case is successful");
			}else{
				System.err.println("Verify if  grn added with blanket po test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test286_addGRN_BlanketPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add grn with blanket PO");
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
