package testCases;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import org.testng.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.AccountsPage;
import pages.AuditingPage;
import pages.HRPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.PurchasePage;
import pages.SalesPage;
import pages.SettingPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SanityTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	ProfilePage master = PageFactory.initElements(Constant.driver, ProfilePage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
	PurchasePage purchase = PageFactory.initElements(Constant.driver, PurchasePage.class);
	AuditingPage audit = PageFactory.initElements(Constant.driver, AuditingPage.class);
	AccountsPage accounts = PageFactory.initElements(Constant.driver, AccountsPage.class);
	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
	SettingPage setting = PageFactory.initElements(Constant.driver, SettingPage.class);
	HRPage hr = PageFactory.initElements(Constant.driver, HRPage.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);

	static ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	static String extentReportFile;
	static ExtentReports extent;
	static String extentReportImage;
	static ExtentTest extentTest;
	static String date = Constant.DateTimeFormat();
	 //define an Excel Work Book
	  static HSSFWorkbook workbook;
	  //define an Excel Work sheet
	  static HSSFSheet sheet;
	  static //define a test result data object
	Map<String, Object[]> testresultdata;

	@BeforeClass
	public static void BeforeClass() throws Exception{
		extentReportFile = property.getExtentReportFile()+"Sanity Test"+date+"."+"html";
		extentReportImage = property.getExtentReportImg()+"Sanity Test"+date+"."+"png";
		// Create object of extent report and specify the report file path.
		extent = new ExtentReports(extentReportFile, false);
		Constant.logFile("Sanity Test Cases");
		 //Browser Initialization
		 Constant.BrowserInitialization();
		 workbook = new HSSFWorkbook();
			//create a new work sheet
			sheet = workbook.createSheet("Sanity Test");
			testresultdata = new LinkedHashMap<>();
			//add test result excel file column header
			// write the header in the first row
			testresultdata.put("1", new Object[] {"S.No", "Scenario", "Expected Result","Pass/Fail"});
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test
	public void Test001_AddMaterial() throws Exception{
		log.startTestCase("AddMaterial");
		extentTest = extent.startTest("Add Material",
				"Verify if material is added");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.addMaterial(0,"Sanity Test");
			if(flag){
				Constant.log.info("Material addition test case is successful");
				extentTest.log(LogStatus.PASS, "Material addition test case is successful");
				testresultdata.put("2", new Object[] {1d, "navigate to site and login", "site opens and login success","Pass"});
			}else{
				System.err.println("Material addition test case failed ");
				Constant.captureScreen_Negative("Test001_AddMaterial");
				extentTest.log(LogStatus.FAIL, "Material addition test case failed ");
				testresultdata.put("2", new Object[] {1d, "navigate to site and login", "Login failed","Fail"});
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("AddMaterial");
	}

	@Test
	public void Test002_UpdateMaterial() throws Exception{
		log.startTestCase("Update Material");
		extentTest = extent.startTest("Update Material",
				"Verify if material is updated");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.updateMaterial(1,"Sanity Test");
			if(flag){
				Constant.log.info("Material update test case is successful");
				extentTest.log(LogStatus.PASS, "Material update test case is successful");
			}else{
				System.err.println("Material update test case failed ");
				Constant.captureScreen_Negative("Test002_UpdateMaterial");
				extentTest.log(LogStatus.FAIL, "Material update test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Update Material");
	}

	@Test
	public void Test003_DeleteMaterial() throws Exception{
		log.startTestCase("Delete Material");
		extentTest = extent.startTest("Delete Material",
				"Verify if material is updated");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.deleteMaterial(2,"Sanity Test");
			if(flag){
				Constant.log.info("Material Delete test case is successful");
				extentTest.log(LogStatus.PASS, "Material Delete test case is successful");
			}else{
				System.err.println("Material Delete test case failed ");
				Constant.captureScreen_Negative("Test003_DeleteMaterial");
				extentTest.log(LogStatus.FAIL, "Material Delete test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Delete Material");
	}

	@Test
	public void Test004_AddIndent() throws Exception{
		log.startTestCase("AddIndent");
		extentTest = extent.startTest("AddIndent",
				"Verify if indent is added");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.verifyAddIndent(3,"Sanity Test");
			if(flag){
				Constant.log.info("Add Indent test case is successful");
				extentTest.log(LogStatus.PASS, "Add Indent test case is successful");
			}else{
				System.err.println("Add Indent test case failed ");
				Constant.captureScreen_Negative("Test004_AddIndent");
				extentTest.log(LogStatus.FAIL, "Add Indent test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("AddIndent");
	}

	@Test
	public void Test005_UpdateIndent() throws Exception{
		log.startTestCase("Update Indent");
		extentTest = extent.startTest("Update Indent",
				"Validate indent update");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.updateIndent(4,"Sanity Test");
			if(flag){
				Constant.log.info("Validate whether indent update test case is successful");
				extentTest.log(LogStatus.PASS, "Validate whether indent update test case is successful");
			}else{
				System.err.println("Indent update test case failed ");
				Constant.captureScreen_Negative("Test005_UpdateIndent");
				extentTest.log(LogStatus.FAIL, "Indent update test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Indent");
	}

	@Test
	public void Test006_IndentDelete() throws Exception{
		log.startTestCase("DeleteIndent");
		extentTest = extent.startTest("DeleteIndent",
				"Verify if indent is added");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.deleteIndent(5,"Sanity Test");
			if(flag){
				Constant.log.info("Delete Indent test case is successful");
				extentTest.log(LogStatus.PASS, "Delete Indent test case is successful");
			}else{
				System.err.println("Delete Indent test case failed ");
				Constant.captureScreen_Negative("Test006_IndentDelete");
				extentTest.log(LogStatus.FAIL, "Delete Indent test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("DeleteIndent");
	}

	@Test
	public void Test007_AddPurchase() throws Exception{
		log.startTestCase("Add Purchase");
		extentTest = extent.startTest("Add Purchase",
				"Verify if Purchase is added");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.addPurchase(6, "Sanity Test");
			if(flag){
				Constant.log.info("Purchase Addition test case is successful");
				extentTest.log(LogStatus.PASS, "Purchase Addition test case is successful");
			}else{
				System.err.println("Purchase addition test case failed ");
				Constant.captureScreen_Negative("Test007_AddPurchase");
				extentTest.log(LogStatus.FAIL, "Purchase addition test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Purchase");
	}

	@Test
	public void Test008_UpdatePurchase() throws Exception{
		log.startTestCase("Update Purchase");
		extentTest = extent.startTest("Update Purchase",
				"Verify if Purchase is Update");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.validateUpdatePO(7, "Sanity Test");
			if(flag){
				Constant.log.info("Purchase Update test case is successful");
				extentTest.log(LogStatus.PASS, "Purchase Update test case is successful");
			}else{
				System.err.println("Purchase Update test case failed ");
				Constant.captureScreen_Negative("Test008_UpdatePurchase");
				extentTest.log(LogStatus.FAIL, "Purchase Update test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Purchase");
	}

	@Test
	public void Test009_ApprovePurchase() throws Exception{
		log.startTestCase("Approve Purchase");
		extentTest = extent.startTest("Approve Purchase",
				"Verify if Purchase is Approve");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.validateApprovePO(8, "Sanity Test");
			if(flag){
				Constant.log.info("Purchase Approve test case is successful");
				extentTest.log(LogStatus.PASS, "Purchase Approve test case is successful");
			}else{
				System.err.println("Purchase Approve test case failed ");
				Constant.captureScreen_Negative("Test009_ApprovePurchase");
				extentTest.log(LogStatus.FAIL, "Purchase Approve test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Purchase");
	}

	@Test
	public void Test010_RejectApprovedPurchase() throws Exception{
		log.startTestCase("Reject Approved Purchase");
		extentTest = extent.startTest("Reject Approved Purchase",
				"Verify if Approved Purchase is Reject");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.validateRejectApprovedPO(9, "Sanity Test");
			if(flag){
				Constant.log.info("Approved Purchase Reject test case is successful");
				extentTest.log(LogStatus.PASS, "Approved Purchase Reject test case is successful");
			}else{
				System.err.println("Approved Purchase Reject test case failed ");
				Constant.captureScreen_Negative("Test010_RejectApprovedPurchase");
				extentTest.log(LogStatus.FAIL, "Approved Purchase Reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject Approved Purchase");
	}

	@Test
	public void Test011_RejectDraftPurchase() throws Exception{
		log.startTestCase("Reject Draft Purchase");
		extentTest = extent.startTest("Reject Draft Purchase",
				"Verify if Draft Purchase is Reject");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.validateRejectDraftPO(10, "Sanity Test");
			if(flag){
				Constant.log.info("Draft Purchase Reject test case is successful");
				extentTest.log(LogStatus.PASS, "Draft Purchase Reject test case is successful");
			}else{
				System.err.println("Draft Purchase Reject test case failed ");
				Constant.captureScreen_Negative("Test011_RejectDraftPurchase");
				extentTest.log(LogStatus.FAIL, "Draft Purchase Reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject Draft Purchase");
	}

	@Test
	public void Test012_AmendPurchase() throws Exception{
		log.startTestCase("Amend Purchase");
		extentTest = extent.startTest("Amend Purchase",
				"Verify if Amend purchase order");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.validateAmendPO(11, "Sanity Test");
			if(flag){
				Constant.log.info("Amend purchase order test case is successful");
				extentTest.log(LogStatus.PASS, "Amend purchase order test case is successful");
			}else{
				System.err.println("Amend purchase order test case failed ");
				Constant.captureScreen_Negative("Test012_AmendPurchase");
				extentTest.log(LogStatus.FAIL, "Amend purchase order test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend Purchase");
	}

	@Test
	public void Test013_AddPOGRN_InvoiceToggle() throws Exception{
		log.startTestCase("Add PO GRN with Invoice toggle");
		extentTest = extent.startTest("Add PO GRN with Invoice toggle",
				"Verify if PO GRN is added");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(12, "Sanity Test",null);
			if(flag){
				Constant.log.info("PO GRN addition with Invoice toggle is successful");
				extentTest.log(LogStatus.PASS, "PO GRN addition with Invoice toggle is successful");
			}else{
				System.err.println("PO GRN addition with Invoice toggle failed ");
				Constant.captureScreen_Negative("Test013_AddPOGRN_InvoiceToggle");
				extentTest.log(LogStatus.FAIL, "PO GRN addition with Invoice toggle failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add PO GRN with Invoice toggle");
	}

	@Test
	public void Test014_UpdatePOGRN_InvoiceToggle() throws Exception{
		log.startTestCase("Update PO GRN with Invoice toggle");
		extentTest = extent.startTest("Update PO GRN with Invoice toggle",
				"Verify if PO GRN with Invoice toggle is Updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(13, "Sanity Test", null);
			if(flag){
				Constant.log.info("PO GRN Update with Invoice toggle is successful");
				extentTest.log(LogStatus.PASS, "PO GRN Update with Invoice toggle is successful");
			}else{
				System.err.println("PO GRN Update with Invoice toggle failed ");
				Constant.captureScreen_Negative("Test014_UpdatePOGRN_InvoiceToggle");
				extentTest.log(LogStatus.FAIL, "PO GRN Update with Invoice toggle failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update PO GRN with Invoice toggle");
	}

	@Test
	public void Test015_ApprovePOGRN_InvoiceToggle() throws Exception{
		log.startTestCase("Approve PO GRN with Invoice toggle");
		extentTest = extent.startTest("Approve PO GRN with Invoice toggle",
				"Verify if PO GRN with Invoice toggle is Approved");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(14, "Sanity Test",null);
			if(flag){
				Constant.log.info("PO GRN Approve with Invoice toggle is successful");
				extentTest.log(LogStatus.PASS, "PO GRN Approve with Invoice toggle is successful");
			}else{
				System.err.println("PO GRN Approve with Invoice toggle failed ");
				Constant.captureScreen_Negative("Test015_ApprovePOGRN_InvoiceToggle");
				extentTest.log(LogStatus.FAIL, "PO GRN Approve with Invoice toggle failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve PO GRN with Invoice toggle");
	}

	@Test
	public void Test016_DraftPOGRNReject_InvoiceToggle() throws Exception{
		log.startTestCase("Draft PO GRN Reject with Invoice toggle");
		extentTest = extent.startTest("Draft PO GRN Reject with Invoice toggle",
				"Verify if draft PO GRN with Invoice toggle is Rejected");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.validateDraftRejectGRN(15, "Sanity Test");
			if(flag){
				Constant.log.info("Draft PO GRN with Invoice toggle Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft PO GRN with Invoice toggle Reject is successful");
			}else{
				System.err.println("Draft PO GRN with Invoice toggle Reject failed ");
				Constant.captureScreen_Negative("Test016_DraftPOGRNReject_InvoiceToggle");
				extentTest.log(LogStatus.FAIL, "Draft PO GRN with Invoice toggle Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft PO GRN with Invoice toggle Reject");
	}

	@Test
	public void Test017_ApprovedPOGRNReject_InvoiceToggle() throws Exception{
		log.startTestCase("Approved PO GRN with Invoice toggle Reject");
		extentTest = extent.startTest("Approved PO GRN with Invoice toggle Reject",
				"Verify if Approved PO GRN with Invoice toggle is Rejected");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.vaildateRejectApprovedGRN(16, "Sanity Test",null);
			if(flag){
				Constant.log.info("Approved PO GRN with Invoice toggle Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved PO GRN with Invoice toggle Reject is successful");
			}else{
				System.err.println("Approved PO GRN with Invoice toggle Reject failed ");
				Constant.captureScreen_Negative("Test017_ApprovedPOGRNReject_InvoiceToggle");
				extentTest.log(LogStatus.FAIL, "Approved PO GRN with Invoice toggle Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved PO GRN with Invoice toggle Reject");
	}

	@Test
	public void Test018_CheckICD() throws Exception{
		log.startTestCase("Check ICD");
		extentTest = extent.startTest("Check ICD",
				"Verify if ICD is checked");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.checkICD(17, "Sanity Test", null, "GRN");
			if(flag){
				Constant.log.info("Checked ICD is successful");
				extentTest.log(LogStatus.PASS, "Checked ICD is successful");
			}else{
				System.err.println("ICD check failed ");
				Constant.captureScreen_Negative("Test018_CheckICD");
				extentTest.log(LogStatus.FAIL, "ICD check failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check ICD");
	}

	@Test
	public void Test019_VerifyICD() throws Exception{
		log.startTestCase("Verify ICD");
		extentTest = extent.startTest("Verify ICD",
				"Verify if ICD is verified");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.icdVerify(null, "Checked");
			if(flag){
				Constant.log.info("Icd Verify is successful");
				extentTest.log(LogStatus.PASS, "ICD Verify is successful");
			}else{
				System.err.println("ICD Verify failed ");
				Constant.captureScreen_Negative("Test019_VerifyICD");
				extentTest.log(LogStatus.FAIL, "ICD Verify failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD");
	}

	@Test
	public void Test020_CreateNote() throws Exception{
		log.startTestCase("Create Note");
		extentTest = extent.startTest("Create Note",
				"Verify if note can be created");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.createNote(19,"Sanity Test");
			if(flag){
				Constant.log.info("Note creation is successful");
				extentTest.log(LogStatus.PASS, "Note creation is successful");
			}else{
				System.err.println("Note creation failed ");
				Constant.captureScreen_Negative("Test020_CreateNote");
				extentTest.log(LogStatus.FAIL, "Note creation failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Note creation");
	}

	@Test
	public void Test021_ApproveNote() throws Exception{
		log.startTestCase("Approve Note");
		extentTest = extent.startTest("Approve Note",
				"Verify if note can be Approved");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.approveNote_Editpage(20,"Sanity Test");
			if(flag){
				Constant.log.info("Note Approve is successful");
				extentTest.log(LogStatus.PASS, "Note Approve is successful");
			}else{
				System.err.println("Note Approve failed ");
				Constant.captureScreen_Negative("Test021_ApproveNote");
				extentTest.log(LogStatus.FAIL, "Note Approve failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Note Approve");
	}

	@Test
	public void Test022_VerifyNote() throws Exception{
		log.startTestCase("Verify Note");
		extentTest = extent.startTest("Verify Note",
				"Verify if note can be Verified");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.verifyNote(20,"Sanity Test");
			if(flag){
				Constant.log.info("Note Verify is successful");
				extentTest.log(LogStatus.PASS, "Note Verify is successful");
			}else{
				System.err.println("Note Verify failed ");
				Constant.captureScreen_Negative("Test022_VerifyNote");
				extentTest.log(LogStatus.FAIL, "Note Verify failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Note Verify");
	}

	@Test
	public void Test023_SaveVoucher() throws Exception{
		log.startTestCase("Save voucher");
		extentTest = extent.startTest("Save voucher",
				"Verify if voucher is saved");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.updateVoucher_EditLedger(22,"Sanity Test");
			if(flag){
				Constant.log.info("Save voucher is successful");
				extentTest.log(LogStatus.PASS, "Save voucher is successful");
			}else{
				System.err.println("Save voucher failed ");
				Constant.captureScreen_Negative("Test023_SaveVoucher");
				extentTest.log(LogStatus.FAIL, "Save voucher failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Save voucher");
	}

	@Test
	public void Test024_ApproveVoucher() throws Exception{
		log.startTestCase("Approve voucher");
		extentTest = extent.startTest("Approve voucher",
				"Verify if voucher is Approved");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(23,"Sanity Test", null);
			if(flag){
				Constant.log.info("Approve voucher is successful");
				extentTest.log(LogStatus.PASS, "Approve voucher is successful");
			}else{
				System.err.println("Approve voucher failed ");
				Constant.captureScreen_Negative("Test024_ApproveVoucher");
				extentTest.log(LogStatus.FAIL, "Approve voucher failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve voucher");
	}

	@Test
	public void Test025_AddExpense() throws Exception{
		log.startTestCase("Add Expense");
		extentTest = extent.startTest("Add Expense",
				"Verify if Expense is added");
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
				Constant.captureScreen_Negative("Test025_AddExpense");
				extentTest.log(LogStatus.FAIL, "Expense addition failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Expense");
	}

	@Test
	public void Test026_UpdateDraftExpense() throws Exception{
		log.startTestCase("Update draft Expense");
		extentTest = extent.startTest("Update draft Expense",
				"Verify if draft Expense is updated");
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
				Constant.captureScreen_Negative("Test026_UpdateDraftExpense");
				extentTest.log(LogStatus.FAIL, "Draft Expense update failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft Expense update");
	}

	@Test
	public void Test027_ConfirmExpense() throws Exception{
		log.startTestCase("Confirm Expense");
		extentTest = extent.startTest("Confirm Expense",
				"Verify if Expense is Confirmed");
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
				Constant.captureScreen_Negative("Test027_ConfirmExpense");
				extentTest.log(LogStatus.FAIL, "Expense Confirm failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Expense Confirm");
	}

	@Test
	public void Test028_UpdateConfirmedExpense() throws Exception{
		log.startTestCase("Update Confirm Expense");
		extentTest = extent.startTest("Update Confirm Expense",
				"Verify if confirmed Expense is updated");
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
				Constant.captureScreen_Negative("Test028_UpdateConfirmedExpense");
				extentTest.log(LogStatus.FAIL, "Confirmed Expense update failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Confirmed Expense update");
	}

	@Test
	public void Test029_ApproveExpense() throws Exception{
		log.startTestCase("Approve Expense");
		extentTest = extent.startTest("Approve Expense",
				"Verify if Expense is Approved");
		try{
			login.logout();
			boolean flag = audit.ApproveExpenses(28, "Sanity Test");
			if(flag){
				Constant.log.info("Expense Approve is successful");
				extentTest.log(LogStatus.PASS, "Expense Approve is successful");
			}else{
				System.err.println("Expense Approve failed ");
				Constant.captureScreen_Negative("Test029_ApproveExpense");
				extentTest.log(LogStatus.FAIL, "Expense Approve failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Expense Approve");
	}

	@Test
	public void Test030_CheckedExpense() throws Exception{
		log.startTestCase("Check Expense");
		extentTest = extent.startTest("Check Expense",
				"Verify if Expense is Checked");
		try{
			login.logout();
			boolean flag = audit.CheckExpenses(29, "Sanity Test");
			if(flag){
				Constant.log.info("Expense Check is successful");
				extentTest.log(LogStatus.PASS, "Expense Check is successful");
			}else{
				System.err.println("Expense Check failed ");
				Constant.captureScreen_Negative("Test030_CheckedExpense");
				extentTest.log(LogStatus.FAIL, "Expense Check failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Expense Check");
	}

	@Test
	public void Test031_VerifyExpense() throws Exception{
		log.startTestCase("Verify Expense");
		extentTest = extent.startTest("Verify Expense",
				"Verify if Expense is Verified");
		try{
			login.logout();
			boolean flag = audit.verifyExpenses(30, "Sanity Test");
			if(flag){
				Constant.log.info("Expense Verify is successful");
				extentTest.log(LogStatus.PASS, "Expense Verify is successful");
			}else{
				System.err.println("Expense Verify failed ");
				Constant.captureScreen_Negative("Test031_VerifyExpense");
				extentTest.log(LogStatus.FAIL, "Expense Verify failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Expense Verify");
	}

	@Test
	public void Test032_AddIssue() throws Exception{
		log.startTestCase("Add Issue");
		extentTest = extent.startTest("Add Issue",
				"Verify if issue is added");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.addIssue(31,"Sanity Test");
			if(flag){
				Constant.log.info("Issue Addition test case is successful");
				extentTest.log(LogStatus.PASS, "Issue Addition test case is successful");
			}else{
				System.err.println("Issue addition test case failed ");
				Constant.captureScreen_Negative("Test032_AddIssue");
				extentTest.log(LogStatus.FAIL, "Issue addition test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue");
	}

	@Test
	public void Test033_UpdateIssue() throws Exception{
		log.startTestCase("IssueUpdate");
		extentTest = extent.startTest("Update Issue",
				"Verify if issue is updated");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.updateIssue(32,"Sanity Test");
			if(flag){
				Constant.log.info("Issue update test case is successful");
				extentTest.log(LogStatus.PASS, "Issue update test case is successful");
			}else{
				System.err.println("Issue update test case failed ");
				Constant.captureScreen_Negative("Test033_UpdateIssue");
				extentTest.log(LogStatus.FAIL, "Issue update test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("IssueUpdate");
	}

	@Test
	public void Test034_StockReportColumnValidation() throws Exception{
		log.startTestCase("Stock Report column validation");
		extentTest = extent.startTest("Stock Report column validation",
				"Verify Stock Report column validation");
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
				Constant.captureScreen_Negative("Test034_StockReportColumnValidation");
				extentTest.log(LogStatus.FAIL, "Stock Report column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Stock Report column validation");
	}

	@Test
	public void Test035_POPendingReportColumnValidation() throws Exception{
		log.startTestCase("PO Report column validation");
		extentTest = extent.startTest("PO Report column validation",
				"Verify PO Report column validation");
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
				Constant.captureScreen_Negative("Test035_POPendingReportColumnValidation");
				extentTest.log(LogStatus.FAIL, "PO Report column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("PO Report column validation");
	}

	@Test
	public void Test036_IndentPendingReportColumnValidation() throws Exception{
		log.startTestCase("Indent Pending Report column validation");
		extentTest = extent.startTest("Indent Pending Report column validation",
				"Verify Indent Pending Report column validation");
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
				Constant.captureScreen_Negative("Test036_IndentPendingReportColumnValidation");
				extentTest.log(LogStatus.FAIL, "Indent Pending Report column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Indent Pending Report column validation");
	}

	@Test
	public void Test037_GRNReportColumnValidationWithDraft() throws Exception{
		log.startTestCase("GRN Report Column Validation with Draft");
		extentTest = extent.startTest("GRN Report Column Validation  with Draft",
				"Verify GRN Report column validation with Draft");
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
				Constant.captureScreen_Negative("Test037_GRNReportColumnValidationWithDraft");
				extentTest.log(LogStatus.FAIL, "GRN Report column validation with Draft test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("GRN Report Column Validation with Draft");
	}

	@Test
	public void Test038_GRNReportColumnValidationWithoutDraft() throws Exception{
		log.startTestCase("GRN Report Column Validation Without Draft");
		extentTest = extent.startTest("GRN Report Column Validation Without Draft",
				"Verify GRN Report column validation Without Draft");
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
				Constant.captureScreen_Negative("Test038_GRNReportColumnValidationWithoutDraft");
				extentTest.log(LogStatus.FAIL, "GRN Report column validation Without Draft test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("GRN Report Column Validation Without Draft");
	}

	@Test
	public void Test039_DCReportColumnValidationWithDraft() throws Exception{
		log.startTestCase("DC Report Column Validation with Draft");
		extentTest = extent.startTest("DC Report Column Validation  with Draft",
				"Verify DC Report column validation with Draft");
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
				Constant.captureScreen_Negative("Test039_DCReportColumnValidationWithDraft");
				extentTest.log(LogStatus.FAIL, "DC Report column validation with Draft test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("DC Report Column Validation with Draft");
	}

	@Test
	public void Test040_DCReportColumnValidationWithoutDraft() throws Exception{
		log.startTestCase("DC Report Column Validation Without Draft");
		extentTest = extent.startTest("DC Report Column Validation Without Draft",
				"Verify DC Report column validation Without Draft");
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
				Constant.captureScreen_Negative("Test040_DCReportColumnValidationWithoutDraft");
				extentTest.log(LogStatus.FAIL, "DC Report column validation Without Draft test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("DC Report Column Validation Without Draft");
	}

	@Test
	public void Test041_MaterialReceiptReportColVerifyWithDraft() throws Exception{
		log.startTestCase("Material Receipt Report Column Validation With Draft");
		extentTest = extent.startTest("Material Receipt Report Column Validation With Draft",
				"Verify Material Receipt Report column validation With Draft");
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
				Constant.captureScreen_Negative("Test041_MaterialReceiptReportColVerifyWithDraft");
				extentTest.log(LogStatus.FAIL, "Material Receipt Report column validation With Draft test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Material Receipt Report Column Validation With Draft");
	}

	@Test
	public void Test042_MaterialReceiptReportColVerifyWithoutDraft() throws Exception{
		log.startTestCase("Material Receipt Report Column Validation Without Draft");
		extentTest = extent.startTest("Material Receipt Report Column Validation Without Draft",
				"Verify Material Receipt Report column validation Without Draft");
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
				Constant.captureScreen_Negative("Test042_MaterialReceiptReportColVerifyWithoutDraft");
				extentTest.log(LogStatus.FAIL, "Material Receipt Report column validation Without Draft test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Material Receipt Report Column Validation Without Draft");
	}

	@Test
	public void Test043_ShortageListReportColumnVerify() throws Exception{
		log.startTestCase("Shortage List Report Column Verify");
		extentTest = extent.startTest("Shortage List Report Column Verify",
				"Verify Shortage List Report column");
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
				Constant.captureScreen_Negative("Test043_ShortageListReportColumnVerify");
				extentTest.log(LogStatus.FAIL, "Shortage List Report column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Shortage List Report Column Verify");
	}

	@Test
	public void Test044_StatusReportColumnValidation() throws Exception{
		log.startTestCase("Status Report Column Verify");
		extentTest = extent.startTest("Status Report Column Verify",
				"Verify Status Report column");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToStatusReport();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.statusReportColumnValidation(43,"Sanity Test");
			if(flag){
				Constant.log.info("Status Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Status Report column validation test case is successful");
			}else{
				System.err.println("Status Report column validation test case failed ");
				Constant.captureScreen_Negative("Test044_StatusReportColumnValidation");
				extentTest.log(LogStatus.FAIL, "Status Report column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Status Report Column Verify");
	}

	@Test
	public void Test045_TaxReportColumnValidation() throws Exception{
		log.startTestCase("Tax Report Column Verify");
		extentTest = extent.startTest("Tax Report Column Verify",
				"Verify Tax Report column");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToTaxReport();
			boolean flag = sales.taxReportColumnValidation(44,"Sanity Test");
			if(flag){
				Constant.log.info("Tax Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Tax Report column validation test case is successful");
			}else{
				System.err.println("Tax Report column validation test case failed ");
				Constant.captureScreen_Negative("Test045_TaxReportColumnValidation");
				extentTest.log(LogStatus.FAIL, "Tax Report column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Tax Report Column Verify");
	}

	@Test
	public void Test046_MaterialReportColumnValidation() throws Exception{
		log.startTestCase("Material Report Column Verify");
		extentTest = extent.startTest("Material Report Column Verify",
				"Verify Material Report column");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterialReport();
			boolean flag = sales.materialReportColumnValidation(45,"Sanity Test");
			if(flag){
				Constant.log.info("Material Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Material Report column validation test case is successful");
			}else{
				System.err.println("Material Report column validation test case failed ");
				Constant.captureScreen_Negative("Test046_MaterialReportColumnValidation");
				extentTest.log(LogStatus.FAIL, "Material Report column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Material Report Column Verify");
	}

	@Test
	public void Test047_SalesReportColumnValidationWithDraft() throws Exception{
		log.startTestCase("Sales Report Column Verify with draft");
		extentTest = extent.startTest("Sales Report Column Verify with draft",
				"Verify Sales Report column with draft");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReport();
			boolean flag = sales.salesReportColumnValidationWithDraft(46,"Sanity Test");
			if(flag){
				Constant.log.info("Sales Report column validation with draft test case is successful");
				extentTest.log(LogStatus.PASS, "Sales Report column validation with draft test case is successful");
			}else{
				System.err.println("Sales Report column validation with draft test case failed ");
				Constant.captureScreen_Negative("Test047_SalesReportColumnValidationWithDraft");
				extentTest.log(LogStatus.FAIL, "Sales Report column validation with draft test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales Report Column Verify");
	}

	@Test
	public void Test048_SalesReportColumnValidationWithoutDraft() throws Exception{
		log.startTestCase("Sales Report Column Verify without draft ");
		extentTest = extent.startTest("Sales Report Column Verify without draft",
				"Verify Sales Report column without draft");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReport();
			boolean flag = sales.salesReportColumnValidationWithoutDraft(47,"Sanity Test");
			if(flag){
				Constant.log.info("Sales Report column validation without draft test case is successful");
				extentTest.log(LogStatus.PASS, "Sales Report column validation without draft test case is successful");
			}else{
				System.err.println("Sales Report column validation without draft test case failed ");
				Constant.captureScreen_Negative("Test048_SalesReportColumnValidationWithoutDraft");
				extentTest.log(LogStatus.FAIL, "Sales Report column validation without draft test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales Report Column Verify without draft");
	}

	@Test
	public void Test049_POWiseReportColumnValidation() throws Exception{
		log.startTestCase("PO Wise Report Column Verify");
		extentTest = extent.startTest("PO Wise Report Column Verify",
				"Verify PO Wise Report column");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPOWiseReports();
			boolean flag = purchase.poWiseReportColumnValidation(48,"Sanity Test");
			if(flag){
				Constant.log.info("PO Wise Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "PO Wise Report column validation test case is successful");
			}else{
				System.err.println("PO Wise Report column validation test case failed ");
				Constant.captureScreen_Negative("Test049_POWiseReportColumnValidation");
				extentTest.log(LogStatus.FAIL, "PO Wise Report column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("PO Wise Report Column Verify");
	}

	@Test
	public void Test050_MaterialWiseReportColumnValidation() throws Exception{
		log.startTestCase("Material Wise Report Column Verify");
		extentTest = extent.startTest("Material Wise Report Column Verify",
				"Verify Material Wise Report column");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterialWiseReports();
			boolean flag = purchase.materialWiseReportColumnValidation(49,"Sanity Test");
			if(flag){
				Constant.log.info("Material Wise Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Material Wise Report column validation test case is successful");
			}else{
				System.err.println("Material Wise Report column validation test case failed ");
				Constant.captureScreen_Negative("Test050_MaterialWiseReportColumnValidation");
				extentTest.log(LogStatus.FAIL, "Material Wise Report column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Material Wise Report Column Verify");
	}

	@Test
	public void Test051_CreateBankVoucher() throws Exception{
		log.startTestCase("Create Bank Voucher");
		extentTest = extent.startTest("Create Bank Voucher",
				"Verify Bank voucher creation");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(50,"Sanity Test");
			if(flag){
				Constant.log.info("Bank voucher creation validation test case is successful");
				extentTest.log(LogStatus.PASS, "Bank voucher creation validation test case is successful");
			}else{
				System.err.println("Bank voucher creation validation test case failed ");
				Constant.captureScreen_Negative("Test051_CreateBankVoucher");
				extentTest.log(LogStatus.FAIL, "Bank voucher creation validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create Bank Voucher");
	}

	@Test
	public void Test052_CreateCashVoucher() throws Exception{
		log.startTestCase("Create Cash Voucher");
		extentTest = extent.startTest("Create Cash Voucher",
				"Verify Cash voucher creation");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(51,"Sanity Test");
			if(flag){
				Constant.log.info("Cash voucher creation validation test case is successful");
				extentTest.log(LogStatus.PASS, "Cash voucher creation validation test case is successful");
			}else{
				System.err.println("Cash voucher creation validation test case failed ");
				Constant.captureScreen_Negative("Test052_CreateCashVoucher");
				extentTest.log(LogStatus.FAIL, "Cash voucher creation validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create Cash Voucher");
	}

	@Test
	public void Test053_AddUser() throws Exception{
		log.startTestCase("Add user");
		extentTest = extent.startTest("Add user",
				"Verify if user is added");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToUser();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = setting.addUser();
			if(flag){
				Constant.log.info("User creation validation test case is successful");
				extentTest.log(LogStatus.PASS, "User creation validation test case is successful");
			}else{
				System.err.println("User creation validation test case failed ");
				Constant.captureScreen_Negative("Test053_AddUser");
				extentTest.log(LogStatus.FAIL, "User creation validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add user");
	}

	@Test
	public void Test054_UserStatusChange() throws Exception{
		log.startTestCase("User Status Change");
		extentTest = extent.startTest("User Status Change",
				"Verify user status change");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToUser();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = setting.userStatusChange(53, "Sanity Test");
			if(flag){
				Constant.log.info("User Status Change validation test case is successful");
				extentTest.log(LogStatus.PASS, "User Status Change validation test case is successful");
			}else{
				System.err.println("User Status Change validation test case failed ");
				Constant.captureScreen_Negative("Test054_UserStatusChange");
				extentTest.log(LogStatus.FAIL, "User Status Change validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("User Status Change");
	}

	@Test
	public void Test055_AddBomMaterial() throws Exception{
		log.startTestCase("Add Bom Material");
		extentTest = extent.startTest("Add Bom Material",
				"Verify if Bom material is added");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.addMaterial_BOM();
			if(flag){
				Constant.log.info("Bom Material addition test case is successful");
				extentTest.log(LogStatus.PASS, "Bom Material addition test case is successful");
			}else{
				System.err.println("Bom Material addition test case failed ");
				Constant.captureScreen_Negative("Test055_AddBomMaterial");
				extentTest.log(LogStatus.FAIL, "Bom Material addition test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Add Bom Material");
	}

	@Test
	public void Test056_AddSupplierMaterial() throws Exception{
		log.startTestCase("Add Supplier for Material");
		extentTest = extent.startTest("Add Supplier for Material",
				"Verify if Supplier material is added");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.addsupplierProfile_Material(55,"Sanity Test");
			if(flag){
				Constant.log.info("Supplier addition for material test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier addition for material test case is successful");
			}else{
				System.err.println("Supplier addition for material test case failed ");
				Constant.captureScreen_Negative("Test056_AddSupplierMaterial");
				extentTest.log(LogStatus.FAIL, "Supplier addition for material test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Add Supplier for Material");
	}

	@Test
	public void Test057_AddParty() throws Exception{
		log.startTestCase("AddParty");
		extentTest = extent.startTest("Add Party",
				"Verify whether party can be added");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToParty();
			boolean flag = master.validateAddParty(56,"Sanity Test");
			if(flag){
				Constant.log.info("Party addition test case is successful");
				extentTest.log(LogStatus.PASS, "Party addition test case is successful");
			}else{
				System.err.println("Party addition test case failed ");
				Constant.captureScreen_Negative("Test057_AddParty");
				extentTest.log(LogStatus.FAIL, "Party addition test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("AddParty");
	}

	@Test
	public void Test058_UpdateParty() throws Exception{
		log.startTestCase("UpdateParty");
		extentTest = extent.startTest("Update Party",
				"Verify whether party can be updated");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToParty();
			boolean flag = master.updateParty(57,"Sanity Test");
			if(flag){
				Constant.log.info("update party test case is successful");
				extentTest.log(LogStatus.PASS, "update party test case is successful");
			}else{
				System.err.println("update party test case failed ");
				Constant.captureScreen_Negative("Test058_UpdateParty");
				extentTest.log(LogStatus.FAIL, "update party test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("UpdateParty");
	}

	@Test
	public void Test059_DeleteParty() throws Exception{
		log.startTestCase("DeleteParty");
		extentTest = extent.startTest("Delete Party",
				"Verify whether party can be deleted");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToParty();
			boolean flag = master.deleteParty(58, "Sanity Test");
			if(flag){
				Constant.log.info("Delete party test case is successful");
				extentTest.log(LogStatus.PASS, "Delete party test case is successful");
			}else{
				System.err.println("delete party test case failed ");
				Constant.captureScreen_Negative("Test059_DeleteParty");
				extentTest.log(LogStatus.FAIL, "Delete party test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("DeleteParty");
	}

	@Test
	public void Test060_AddTax() throws Exception{
		log.startTestCase("AddTax");
		extentTest = extent.startTest("Add Tax",
				"Verify whether Tax can be added");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToTax();
			boolean flag = master.addTax(59,"Sanity Test");
			if(flag){
				Constant.log.info("Tax addition test case is successful");
				extentTest.log(LogStatus.PASS, "Tax addition test case is successful");
			}else{
				System.err.println("Tax addition test case failed ");
				Constant.captureScreen_Negative("Test060_AddTax");
				extentTest.log(LogStatus.FAIL, "Tax addition test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("AddTax");
	}

	@Test
	public void Test061_UpdateTax() throws Exception{
		log.startTestCase("UpdateTax");
		extentTest = extent.startTest("Update Tax",
				"Verify whether Tax can be Updated");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToTax();
			boolean flag = master.updateTax(60,"Sanity Test");
			if(flag){
				Constant.log.info("Tax update test case is successful");
				extentTest.log(LogStatus.PASS, "Tax Update test case is successful");
			}else{
				System.err.println("Tax Update test case failed ");
				Constant.captureScreen_Negative("Test061_UpdateTax");
				extentTest.log(LogStatus.FAIL, "Tax Update test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("TaxUpdate");
	}

	@Test
	public void Test062_CreateLedger() throws Exception{
		log.startTestCase("Create Ledger");
		extentTest = extent.startTest("Create Ledger",
				"Verify whether ledger can be created ");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToLedger();
			boolean flag = accounts.addLedger(61,"Sanity Test");
			if(flag){
				Constant.log.info("Ledger creation test case is successful");
				extentTest.log(LogStatus.PASS, "Ledger creation test case is successful");
			}else{
				System.err.println("Ledger creation test case failed ");
				Constant.captureScreen_Negative("Test062_CreateLedger");
				extentTest.log(LogStatus.FAIL, "Ledger creation test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Ledger creation");
	}

	@Test
	public void Test063_UpdateLedger() throws Exception{
		log.startTestCase("Update Ledger");
		extentTest = extent.startTest("Update Ledger",
				"Verify whether ledger can be Updated ");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToLedger();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = accounts.updateLedger(62,"Sanity Test");
			if(flag){
				Constant.log.info("Ledger Update test case is successful");
				extentTest.log(LogStatus.PASS, "Ledger Update test case is successful");
			}else{
				System.err.println("Ledger Update test case failed ");
				Constant.captureScreen_Negative("Test063_UpdateLedger");
				extentTest.log(LogStatus.FAIL, "Ledger Update test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Ledger Update");
	}

	@Test
	public void Test064_AccountDashboardValidation() throws Exception{
		log.startTestCase("Account dashboard validation");
		extentTest = extent.startTest("Account dashboard validation",
				"Verify Account dashboard ");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToAccountDash();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = accounts.accountDashboardValidation();
			if(flag){
				Constant.log.info("Account dashboard validation test case is successful");
				extentTest.log(LogStatus.PASS, "Account dashboard validation test case is successful");
			}else{
				System.err.println("Account dashboard validation test case failed ");
				Constant.captureScreen_Negative("Test064_AccountDashboardValidation");
				extentTest.log(LogStatus.FAIL, "Account dashboard validation test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Account dashboard validation");
	}

	@Test
	public void Test065_AddTaxInvoiceInvoice() throws Exception{
		log.startTestCase("Add Tax Invoice Invoice");
		extentTest = extent.startTest("Add Tax Invoice Invoice",
				"Verify if Tax Invoice Invoice is added");
		try{
			boolean flag = sales.addInvoice(64,"Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Tax Invoice invoice is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Tax Invoice invoice is added test case is successful");
			}else{
				System.err.println("Tax Invoice invoice is added test case failed ");
				Constant.captureScreen_Negative("Test065_AddTaxInvoiceInvoice");
				extentTest.log(LogStatus.FAIL, "Tax Invoice invoice is added test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Tax Invoice Invoice");
	}

	@Test
	public void Test066_UpdateTaxInvoice_Material() throws Exception{
		log.startTestCase("Update Tax Invoice Invoice with Material");
		extentTest = extent.startTest("Update Tax Invoice Invoice with Material",
				"Verify if Tax Invoice Invoice is updated");
		try{
			sales.addInvoice(65, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(65, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(65, "Sanity Test");
			boolean flag2 = sales.deleteItem(65, "Sanity Test");
			if(flag && flag1 && flag2){
				Constant.log.info("Tax Invoice invoice is updated with new material test case is successful");
				extentTest.log(LogStatus.PASS, "Tax Invoice invoice is updated with new material test case is successful");
			}else{
				System.err.println("Tax Invoice invoice is updated with new material test case failed ");
				Constant.captureScreen_Negative("Test066_UpdateTaxInvoice_Material");
				extentTest.log(LogStatus.FAIL, "Tax Invoice invoice is updated with new material test case failed");
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Tax Invoice Invoice with Material");
	}

	@Test
	public void Test067_ApproveTaxInvoiceInvoice() throws Exception{
		log.startTestCase("Approve Tax Invoice Invoice");
		extentTest = extent.startTest("Approve Tax Invoice Invoice",
				"Verify if Tax Invoice Invoice is approved");
		try{
			boolean flag = sales.validateApproveInvoice(66, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Tax Invoice invoice is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Tax Invoice invoice is approved test case is successful");
			}else{
				System.err.println("Tax Invoice invoice is approved test case failed ");
				Constant.captureScreen_Negative("Test067_ApproveTaxInvoiceInvoice");
				extentTest.log(LogStatus.FAIL, "Tax Invoice invoice is approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Tax Invoice Invoice");
	}

	@Test
	public void Test068_RejectDraftTaxInvoiceInvoice() throws Exception{
		log.startTestCase("Reject Draft Tax Invoice Invoice");
		extentTest = extent.startTest("Reject Draft Tax Invoice Invoice",
				"Verify if drafted Tax Invoice Invoice is rejected");
		try{
			boolean flag = sales.validateRejectDraftInvoice(67, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if drafted Tax Invoice Invoice is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Tax Invoice Invoice is rejected test case is successful");
			}else{
				System.err.println("Drafted Tax Invoice Invoice is rejected test case failed ");
				Constant.captureScreen_Negative("Test068_RejectDraftTaxInvoiceInvoice");
				extentTest.log(LogStatus.FAIL, "Drafted Tax Invoice Invoice is rejected test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Tax Invoice Invoice");
	}

	@Test
	public void Test069_RejectApprovedTaxInvoiceInvoice() throws Exception{
		log.startTestCase("Reject Approved Tax Invoice Invoice");
		extentTest = extent.startTest("Reject Approved Tax Invoice Invoice",
				"Verify if Approved Tax Invoice Invoice is rejected");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(68, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Tax Invoice Invoice is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Tax Invoice Invoice is rejected test case is successful");
			}else{
				System.err.println("Approved Tax Invoice Invoice is rejected test case failed ");
				Constant.captureScreen_Negative("Test069_RejectApprovedTaxInvoiceInvoice");
				extentTest.log(LogStatus.FAIL, "Approved Tax Invoice Invoice is rejected test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Tax Invoice Invoice");
	}

	@Test
	public void Test070_RunTrialBalanceGenerateStatement() throws Exception{
		log.startTestCase("Run Trial Balance Generate Statement ");
		extentTest = extent.startTest("Run Trial Balance Generate Statement ",
				"Verify Run Trial Balance and Generate Statement ");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProvisionalStatements();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = accounts.runTrialBal();
			if(flag){
				Constant.log.info("Verify Run Trial Balance Generate Statement  test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Run Trial Balance Generate Statement  test case is successful");
			}else{
				System.err.println("Run Trial Balance Generate Statement  test case failed ");
				Constant.captureScreen_Negative("Test070_RunTrialBalanceGenerateStatement ");
				extentTest.log(LogStatus.FAIL, "Run Trial Balance Generate Statement  test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Run Trial Balance Generate Statement ");
	}

	@Test  @Category(SanityTestCases.class)
	public void Test071_PurchaseRegisterReportColumnValidation() throws Exception{
		log.startTestCase(" Purchase Register report column validation");
		extentTest = extent.startTest(" Purchase Register report column validation",
				"Verify Purchase Register report column validation");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchaseRegister();
			boolean flag = accounts.purchaseRegistReportColumnValidation(70,"Sanity Test");
			if(flag){
				Constant.log.info("Verify Purchase Register report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Purchase Register report column validation test case is successful");
			}else{
				System.err.println(" Purchase Register report column validation test case failed ");
				Constant.captureScreen_Negative(" Purchase Register report column validation");
				extentTest.log(LogStatus.FAIL, " Purchase Register report column validation test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase(" Purchase Register report column validation");
	}

	@Test
	public void Test072_GSTRSalesReportColumnValidation() throws Exception{
		log.startTestCase("GSTR Sales report column validation");
		extentTest = extent.startTest("GSTR Sales report column validation",
				"Verify GSTR Sales report column validation");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGSTRSalesReport();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = accounts.gstrSalesReportColumnValidation(71,"Sanity Test");
			if(flag){
				Constant.log.info("Verify GSTR Sales report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Verify GSTR Sales report column validation test case is successful");
			}else{
				System.err.println("GSTR Sales report column validation test case failed ");
				Constant.captureScreen_Negative("Test072_GSTRSalesReportColumnValidation");
				extentTest.log(LogStatus.FAIL, "GSTR Sales report column validation test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("GSTR Sales report column validation");
	}
	/*
	@Test
	public void Test073_UserWithEditAccessOnly() throws Exception{
		log.startTestCase("User with Edit access only");
		extentTest = extent.startTest("User with Edit access only",
				"validate user with only edit access");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToUser();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = setting.userWithOnlyEditAccess(72, "Sanity Test");
			if(flag == true){
				Constant.log.info("User With only edit access validation test case is successful");
				extentTest.log(LogStatus.PASS, "User With only edit access validation test case is successful");
			}else{
				System.err.println("User With only edit access validation test case failed ");
				Constant.captureScreen_Negative("User with Edit access only");
				extentTest.log(LogStatus.FAIL, "User With only edit access validation test case failed ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("User with Edit access only");
	}

	@Test
	public void Test074_UserWithViewAccessOnly() throws Exception{
		log.startTestCase("User with View access only");
		extentTest = extent.startTest("User with View access only",
				"validate user with only View access");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToUser();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = setting.userWithOnlyViewAccess(73, "Sanity Test");
			if(flag == true){
				Constant.log.info("User With only View access validation test case is successful");
				extentTest.log(LogStatus.PASS, "User With only View access validation test case is successful");
			}else{
				System.err.println("User With only View access validation test case failed ");
				Constant.captureScreen_Negative("User with View access only");
				extentTest.log(LogStatus.FAIL, "User With only View access validation test case failed ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("User with View access only");
	}
	*/
	@Test
	public void Test075_UpdateManualNote() throws Exception{
		log.startTestCase("Update Manual Note");
		extentTest = extent.startTest("Update Manual Note",
				"validate Manual note updation");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = audit.updateManualNote(74, "Sanity Test");
			if(flag){
				Constant.log.info("Manual note update test case is successful");
				extentTest.log(LogStatus.PASS, "Manual note update test case is successful");
			}else{
				System.err.println("Manual note update test case failed ");
				Constant.captureScreen_Negative("Test075_UpdateManualNote");
				extentTest.log(LogStatus.FAIL, "Manual note update test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Manual Note");
	}

	@Test
	public void Test076_AddEmployee() throws Exception{
		log.startTestCase("Add Employee");
		extentTest = extent.startTest("Add Employee",
				"validate employee addition");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.addEmployee(75, "Sanity Test");
			if(flag){
				Constant.log.info("Employee addition test case is successful");
				extentTest.log(LogStatus.PASS, "Employee addition test case is successful");
			}else{
				System.err.println("Employee addition test case failed ");
				Constant.captureScreen_Negative("Test076_AddEmployee");
				extentTest.log(LogStatus.FAIL, "Employee addition test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Employee");
	}

	@Test
	public void Test077_UpdateEmployee() throws Exception{
		log.startTestCase("Update Employee");
		extentTest = extent.startTest("Update Employee",
				"validate employee Update");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.updateEmployee(76, "Sanity Test");
			if(flag){
				Constant.log.info("Employee Update test case is successful");
				extentTest.log(LogStatus.PASS, "Employee Update test case is successful");
			}else{
				System.err.println("Employee Update test case failed ");
				Constant.captureScreen_Negative("Test077_UpdateEmployee");
				extentTest.log(LogStatus.FAIL, "Employee Update test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Employee");
	}

	@Test
	public void Test078_AddPayStruc() throws Exception{
		log.startTestCase("Add Pay Structure");
		extentTest = extent.startTest("Add Pay Structure",
				"validate Pay Struc addition");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPayStructure();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.addPayStructure();
			if(flag){
				Constant.log.info("Pay structure addition test case is successful");
				extentTest.log(LogStatus.PASS, "Pay structure addition test case is successful");
			}else{
				System.err.println("Pay structure addition test case failed ");
				Constant.captureScreen_Negative("Test078_AddPayStruc");
				extentTest.log(LogStatus.FAIL, "Pay structure addition test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Pay structure");
	}

	@Test
	public void Test079_UpdatePayStruc() throws Exception{
		log.startTestCase("Update Pay Structure");
		extentTest = extent.startTest("Update Pay Structure",
				"validate Pay Structure update");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPayStructure();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.updatePayStructure();
			if(flag){
				Constant.log.info("Pay Structure Update test case is successful");
				extentTest.log(LogStatus.PASS, "Pay Structure Update test case is successful");
			}else{
				System.err.println("Pay Structure Update test case failed ");
				Constant.captureScreen_Negative("Test079_UpdatePayStruc");
				extentTest.log(LogStatus.FAIL, "Pay Structure Update test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Pay Structure");
	}

	@Test
	public void Test080_DeletePayStruc() throws Exception{
		log.startTestCase("Delete Pay Structure");
		extentTest = extent.startTest("Delete Pay Structure",
				"validate Pay Struc delete");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPayStructure();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.deletePayStructure();
			if(flag){
				Constant.log.info("Pay Structure Delete test case is successful");
				extentTest.log(LogStatus.PASS, "Pay Structure Delete test case is successful");
			}else{
				System.err.println("Pay Structure Delete test case failed ");
				Constant.captureScreen_Negative("Test080_DeletePayStruc");
				extentTest.log(LogStatus.FAIL, "Pay Structure Delete test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Delete Pay Structure");
	}

	@Test
	public void Test081_AddJobPO_AddingMaterials() throws Exception{
		log.startTestCase("Add Job Po by adding Materials");
		extentTest = extent.startTest("Add Job Po by adding Materials",
				"validate job po addition by adding materials");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.addJobPo_Materials(80,"Sanity Test");
			if(flag){
				Constant.log.info("Job PO addition with material addition test case is successful");
				extentTest.log(LogStatus.PASS, "Job PO addition with material addition test case is successful");
			}else{
				System.err.println("Job PO addition with material addition test case failed ");
				Constant.captureScreen_Negative("Test081_AddJobPO_AddingMaterials");
				extentTest.log(LogStatus.FAIL, "Job PO addition with material addition test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Job Po by adding Materials");
	}

	@Test
	public void Test082_AddJobPO_Indent() throws Exception{
		log.startTestCase("Add Job Po by adding indent");
		extentTest = extent.startTest("Add Job Po by adding indent",
				"validate job po addition by adding indent");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.addJobPO_Indent(81,"Sanity Test");
			if(flag){
				Constant.log.info("Job PO addition with indent addition test case is successful");
				extentTest.log(LogStatus.PASS, "Job PO addition with indent addition test case is successful");
			}else{
				System.err.println("Job PO addition with indent addition test case failed ");
				Constant.captureScreen_Negative("Test082_AddJobPO_Indent");
				extentTest.log(LogStatus.FAIL, "Job PO addition with indent addition test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Job Po by adding indent");
	}

	@Test
	public void Test083_UpdateJobPO() throws Exception{
		log.startTestCase("update job Po");
		extentTest = extent.startTest("update job Po",
				"validate job po update");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.updateJobPO(82,"Sanity Test");
			if(flag){
				Constant.log.info("update job Po test case is successful");
				extentTest.log(LogStatus.PASS, "update job Po test case is successful");
			}else{
				System.err.println("update job Po test case failed ");
				Constant.captureScreen_Negative("Test083_UpdateJobPO");
				extentTest.log(LogStatus.FAIL, "update job Po test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("update job Po");
	}

	@Test
	public void Test084_ApproveJobPO() throws Exception{
		log.startTestCase("Approve job Po");
		extentTest = extent.startTest("Approve job Po",
				"validate job po Approve");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.validateApproveJobPO(83,"Sanity Test");
			if(flag){
				Constant.log.info("Approve job Po test case is successful");
				extentTest.log(LogStatus.PASS, "Approve job Po test case is successful");
			}else{
				System.err.println("Approve job Po test case failed ");
				Constant.captureScreen_Negative("Test084_ApproveJobPO");
				extentTest.log(LogStatus.FAIL, "Approve job Po test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve job Po");
	}

	@Test
	public void Test085_RejectApprovedJobPO() throws Exception{
		log.startTestCase("Reject Approved Job Purchase");
		extentTest = extent.startTest("Reject Approved Job Purchase",
				"Verify if Approved Job Purchase is Reject");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.validateRejectApprovedJobPO(84, "Sanity Test");
			if(flag){
				Constant.log.info("Approved Job Purchase Reject test case is successful");
				extentTest.log(LogStatus.PASS, "Approved Job Purchase Reject test case is successful");
			}else{
				System.err.println("Approved Job Purchase Reject test case failed ");
				Constant.captureScreen_Negative("Test085_RejectApprovedJobPO");
				extentTest.log(LogStatus.FAIL, "Approved Job Purchase Reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject Approved Job Purchase");
	}

	@Test
	public void Test086_RejectDraftJobPO() throws Exception{
		log.startTestCase("Reject Draft Job Purchase");
		extentTest = extent.startTest("Reject Draft Job Purchase",
				"Verify if Draft Job Purchase is Reject");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.validateRejectDraftJobPO(85, "Sanity Test");
			if(flag){
				Constant.log.info("Draft Job Purchase Reject test case is successful");
				extentTest.log(LogStatus.PASS, "Draft Job Purchase Reject test case is successful");
			}else{
				System.err.println("Draft Job Purchase Reject test case failed ");
				Constant.captureScreen_Negative("Test086_RejectDraftJobPO");
				extentTest.log(LogStatus.FAIL, "Draft Job Purchase Reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject Draft Job Purchase");
	}

	@Test
	public void Test087_AmendJobPO() throws Exception{
		log.startTestCase("Amend Job PO");
		extentTest = extent.startTest("Amend Job PO",
				"Verify if Amend Job PO");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.validateAmendJobPO(86, "Sanity Test");
			if(flag){
				Constant.log.info("Amend Job PO order test case is successful");
				extentTest.log(LogStatus.PASS, "Amend Job PO order test case is successful");
			}else{
				System.err.println("Amend Job PO order test case failed ");
				Constant.captureScreen_Negative("Test087_AmendJobPO");
				extentTest.log(LogStatus.FAIL, "Amend Job PO order test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend Job PO");
	}

	@Test
	public void Test088_UpdateMaterialJobSupplier() throws Exception{
		log.startTestCase("Update Supplier for Material with Job");
		extentTest = extent.startTest("Update Supplier for Material with Job",
				"Verify if Supplier material with Job is Updated");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = master.updateMaterialSupplierJob();
			if(flag){
				Constant.log.info("Supplier update for material with Job test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier update for material with Job test case is successful");
			}else{
				System.err.println("Supplier update for material with Job test case failed ");
				Constant.captureScreen_Negative("Test088_UpdateMaterialJobSupplier");
				extentTest.log(LogStatus.FAIL, "Supplier update for material with Job test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("update Supplier for Material with Job");
	}

	@Test
	public void Test089_AddDeliveryChallan() throws Exception{
		log.startTestCase("Add Delivery Challan");
		extentTest = extent.startTest("Add Delivery Challan",
				"Verify if Delivery Challan is added");
		try{
			boolean flag = sales.addInvoice(88, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Delivery Challan is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan is added test case is successful");
			}else{
				System.err.println("Delivery Challan is added test case failed ");
				Constant.captureScreen_Negative("Test089_AddDeliveryChallan");
				extentTest.log(LogStatus.FAIL, "Delivery Challan is added test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Delivery Challan");
	}

	@Test
	public void Test090_UpdateDeliveryChallan_Material() throws Exception{
		log.startTestCase("Update Delivery Challan with Material");
		extentTest = extent.startTest("Update Delivery Challan with Material",
				"Verify if Delivery Challan is updated with Material");
		try{
			sales.addInvoice(89, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(89, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(89, "Sanity Test");
			boolean flag2 = sales.deleteItem(90, "Sanity Test");
			if(flag && flag1 && flag2){
				Constant.log.info("Verify if Delivery Challan is updated with Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan is updated with Material test case is successful");
			}else{
				System.err.println("Delivery Challan is updated with Material test case failed ");
				Constant.captureScreen_Negative("Test090_UpdateDeliveryChallan_Material");
				extentTest.log(LogStatus.FAIL, "Delivery Challan is updated with Material test case failed");
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Delivery Challan with Material");
	}

	@Test
	public void Test091_ApproveDeliveryChallan() throws Exception{
		log.startTestCase("Approve Delivery Challan");
		extentTest = extent.startTest("Approve Delivery Challan",
				"Verify if Delivery Challan is approved");
		try{
			boolean flag = sales.validateApproveInvoice(90, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Delivery Challan is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan is approved test case is successful");
			}else{
				System.err.println("Delivery Challan is approved test case failed ");
				Constant.captureScreen_Negative("Test091_ApproveDeliveryChallan");
				extentTest.log(LogStatus.FAIL, "Delivery Challan is approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Delivery Challan");
	}

	@Test
	public void Test092_RejectDraftDeliveryChallan() throws Exception{
		log.startTestCase("Reject draft Delivery Challan");
		extentTest = extent.startTest("Reject draft Delivery Challan",
				"Verify if draft Delivery Challan is reject");
		try{
			boolean flag = sales.validateRejectDraftInvoice(91, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if draft Delivery Challan is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if draft Delivery Challan is reject test case is successful");
			}else{
				System.err.println("Draft Delivery Challan is reject test case failed ");
				Constant.captureScreen_Negative("Test092_RejectDraftDeliveryChallan");
				extentTest.log(LogStatus.FAIL, "Draft Delivery Challan is reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject draft Delivery Challan");
	}

	@Test
	public void Test093_RejectApprovedDeliveryChallan() throws Exception{
		log.startTestCase("Reject Approved Delivery Challan");
		extentTest = extent.startTest("Reject Approved Delivery Challan",
				"Verify if Approved Delivery Challan is reject");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(92, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Delivery Challan is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Delivery Challan is reject test case is successful");
			}else{
				System.err.println("Approved Delivery Challan is reject test case failed ");
				Constant.captureScreen_Negative("Test093_RejectApprovedDeliveryChallan");
				extentTest.log(LogStatus.FAIL, "Approved Delivery Challan is reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Delivery Challan");
	}

	@Test
	public void Test094_AddJobDc() throws Exception{
		log.startTestCase("Add Job DC");
		extentTest = extent.startTest("Add Job DC",
				"Verify if job DC is added");
		try{
			boolean flag = sales.addInvoice(93, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Job Dc is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Job Dc is added test case is successful");
			}else{
				System.err.println("Job Dc is added test case failed ");
				Constant.captureScreen_Negative("Test094_AddJobDc");
				extentTest.log(LogStatus.FAIL, "Job Dc is added test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Job DC");
	}

	@Test
	public void Test095_UpdateJobDc_Material() throws Exception{
		log.startTestCase("Update Job Dc with Material");
		extentTest = extent.startTest("Update Job Dc with Material",
				"Verify if Job Dc is updated with Material");
		try{
			sales.addInvoice(94, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(94, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(94, "Sanity Test");
			boolean flag2 = sales.deleteItem(94, "Sanity Test");
			if(flag && flag1 && flag2){
				Constant.log.info("Verify if Job Dc is updated with Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Job Dc is updated with Material test case is successful");
			}else{
				System.err.println("Job Dc is updated with Material test case failed ");
				Constant.captureScreen_Negative("Test095_UpdateJobDc_Material");
				extentTest.log(LogStatus.FAIL, "Job Dc is updated with Material test case failed");
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Job Dc with Material");
	}

	@Test
	public void Test096_ApproveJobDcInvoice() throws Exception{
		log.startTestCase("Approve Job Dc Invoice");
		extentTest = extent.startTest("Approve Job Dc Invoice",
				"Verify if Job Dc is approved");
		try{
			boolean flag = sales.validateApproveInvoice(95, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Job Dc is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Job Dc is approved test case is successful");
			}else{
				System.err.println("Job Dc is approved test case failed ");
				Constant.captureScreen_Negative("Test096_ApproveJobDcInvoice");
				extentTest.log(LogStatus.FAIL, "Job Dc is approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Job Dc");
	}

	@Test
	public void Test097_RejectDraftJobDc() throws Exception{
		log.startTestCase("Reject draft Job Dc");
		extentTest = extent.startTest("Reject draft Job Dc",
				"Verify if draft Job Dc is reject");
		try{
			boolean flag = sales.validateRejectDraftInvoice(96, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if draft Job Dc is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if draft Job Dc is reject test case is successful");
			}else{
				System.err.println("Draft Job Dc is reject test case failed ");
				Constant.captureScreen_Negative("Test097_RejectDraftJobDc");
				extentTest.log(LogStatus.FAIL, "Draft Job Dc is reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject draft Job Dc");
	}

	@Test
	public void Test098_RejectApprovedJobDc() throws Exception{
		log.startTestCase("Reject Approved Job Dc");
		extentTest = extent.startTest("Reject Approved Job Dc",
				"Verify if Approved Job Dc is reject");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(97, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Job Dc is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Job Dc is reject test case is successful");
			}else{
				System.err.println("Approved Job Dc is reject test case failed ");
				Constant.captureScreen_Negative("Test098_RejectApprovedJobDc");
				extentTest.log(LogStatus.FAIL, "Approved Job Dc is reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Job Dc");
	}

	@Test
	public void Test099_AddJobWorkGRN() throws Exception{
		log.startTestCase("Add Job work GRN");
		extentTest = extent.startTest("Add Job work GRN",
				"Verify if Job work GRN is added");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(98, "Sanity Test",null);
			if(flag){
				Constant.log.info("Job work GRN addition is successful");
				extentTest.log(LogStatus.PASS, "Job work GRN addition is successful");
			}else{
				System.err.println("Job work GRN addition failed ");
				Constant.captureScreen_Negative("Test099_AddJobWorkGRN");
				extentTest.log(LogStatus.FAIL, "Job work GRN addition failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Job work GRN");
	}

	@Test
	public void Test100_UpdateJobWorkGRN() throws Exception{
		log.startTestCase("Update Job work GRN");
		extentTest = extent.startTest("Update Job work GRN",
				"Verify if Job work GRN is Updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(99, "Sanity Test", null);
			if(flag){
				Constant.log.info("Job work GRN Update is successful");
				extentTest.log(LogStatus.PASS, "Job work GRN Update is successful");
			}else{
				System.err.println("Job work GRN Update failed ");
				Constant.captureScreen_Negative("Test100_UpdateJobWorkGRN");
				extentTest.log(LogStatus.FAIL, "Job work GRN Update failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Job work GRN");
	}

	@Test
	public void Test101_ApproveJobWorkGRN() throws Exception{
		log.startTestCase("Approve Job work GRN");
		extentTest = extent.startTest("Approve Job work GRN",
				"Verify if GRN is Approved");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(100, "Sanity Test",null);
			if(flag){
				Constant.log.info("Job work GRN Approve is successful");
				extentTest.log(LogStatus.PASS, "Job work GRN Approve is successful");
			}else{
				System.err.println("Job work GRN Approve failed ");
				Constant.captureScreen_Negative("Test101_ApproveJobWorkGRN");
				extentTest.log(LogStatus.FAIL, "Job work GRN Approve failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job work Approve GRN");
	}

	@Test
	public void Test102_DraftJobWorkGRNReject() throws Exception{
		log.startTestCase("Draft Job work GRN Reject");
		extentTest = extent.startTest("Draft Job work GRN Reject",
				"Verify if draft Job work GRN is Rejected");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.validateDraftRejectGRN(101, "Sanity Test");
			if(flag){
				Constant.log.info("Draft Job work GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft Job work GRN Reject is successful");
			}else{
				System.err.println("Draft Job work GRN Reject failed ");
				Constant.captureScreen_Negative("Test102_DraftJobWorkGRNReject");
				extentTest.log(LogStatus.FAIL, "Draft Job work GRN Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft Job work GRN Reject");
	}

	@Test
	public void Test103_ApprovedJobWorkGRNReject() throws Exception{
		log.startTestCase("Approved Job work GRN Reject");
		extentTest = extent.startTest("Approved Job work GRN Reject",
				"Verify if Approved Job work GRN is Rejected");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.vaildateRejectApprovedGRN(102, "Sanity Test",null);
			if(flag){
				Constant.log.info("Approved Job work GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved Job work GRN Reject is successful");
			}else{
				System.err.println("Approved Job work GRN Reject failed ");
				Constant.captureScreen_Negative("Test103_ApprovedJobWorkGRNReject");
				extentTest.log(LogStatus.FAIL, "Approved Job work GRN Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved Job work GRN Reject");
	}

	@Test
	public void Test104_AddJobDc_PO() throws Exception{
		log.startTestCase("Add Job DC");
		extentTest = extent.startTest("Add Job DC",
				"Verify if job DC is added");
		try{
			boolean flag = sales.addInvoice(103, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Job Dc is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Job Dc is added test case is successful");
			}else{
				System.err.println("Job Dc is added test case failed ");
				Constant.captureScreen_Negative("Test104_AddJobDc_PO");
				extentTest.log(LogStatus.FAIL, "Job Dc is added test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Job DC");
	}

	@Test
	public void Test105_UpdateJobDc_PO() throws Exception{
		log.startTestCase("Update Job Dc with Material");
		extentTest = extent.startTest("Update Job Dc with Material",
				"Verify if Job Dc is updated with Material");
		try{
			sales.addInvoice(104, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(104, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(104, "Sanity Test");
			boolean flag2 = sales.deleteItem(94, "Sanity Test");
			if(flag && flag1 && flag2){
				Constant.log.info("Verify if Job Dc is updated with Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Job Dc is updated with Material test case is successful");
			}else{
				System.err.println("Job Dc is updated with Material test case failed ");
				Constant.captureScreen_Negative("Test105_UpdateJobDc_PO");
				extentTest.log(LogStatus.FAIL, "Job Dc is updated with Material test case failed");
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Job Dc with Material");
	}

	@Test
	public void Test106_ApproveJobDc_PO() throws Exception{
		log.startTestCase("Approve Job Dc");
		extentTest = extent.startTest("Approve Job Dc ",
				"Verify if Job Dc is approved");
		try{
			boolean flag = sales.validateApproveInvoice(105, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Job Dc is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Job Dc is approved test case is successful");
			}else{
				System.err.println("Job Dc is approved test case failed ");
				Constant.captureScreen_Negative("Test106_ApproveJobDc_PO");
				extentTest.log(LogStatus.FAIL, "Job Dc is approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Job Dc");
	}

	@Test
	public void Test107_RejectDraftJobDc_PO() throws Exception{
		log.startTestCase("Reject draft Job Dc");
		extentTest = extent.startTest("Reject draft Job Dc",
				"Verify if draft Job Dc is reject");
		try{
			boolean flag = sales.validateRejectDraftInvoice(106, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if draft Job Dc is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if draft Job Dc is reject test case is successful");
			}else{
				System.err.println("Draft Job Dc is reject test case failed ");
				Constant.captureScreen_Negative("Test107_RejectDraftJobDc_PO");
				extentTest.log(LogStatus.FAIL, "Draft Job Dc is reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject draft Job Dc");
	}

	@Test
	public void Test108_RejectApprovedJobDc_PO() throws Exception{
		log.startTestCase("Reject Approved Job Dc");
		extentTest = extent.startTest("Reject Approved Job Dc",
				"Verify if Approved Job Dc is reject");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(107, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Job Dc is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Job Dc is reject test case is successful");
			}else{
				System.err.println("Approved Job Dc is reject test case failed ");
				Constant.captureScreen_Negative("Test108_RejectApprovedJobDc_PO");
				extentTest.log(LogStatus.FAIL, "Approved Job Dc is reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Job Dc");
	}

	@Test
	public void Test109_AddDeliveryChallan_WithReturn() throws Exception{
		log.startTestCase("Add Delivery Challan");
		extentTest = extent.startTest("Add Delivery Challan",
				"Verify if Delivery Challan is added");
		try{
			boolean flag = sales.addInvoice(108, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Delivery Challan is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan is added test case is successful");
			}else{
				System.err.println("Delivery Challan is added test case failed ");
				Constant.captureScreen_Negative("Test109_AddDeliveryChallan_WithReturn");
				extentTest.log(LogStatus.FAIL, "Delivery Challan is added test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Delivery Challan");
	}

	@Test
	public void Test110_UpdateDeliveryChallan_WithReturn() throws Exception{
		log.startTestCase("Update Delivery Challan with Material");
		extentTest = extent.startTest("Update Delivery Challan with Material",
				"Verify if Delivery Challan is updated with Material");
		try{
			sales.addInvoice(109, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(109, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(109, "Sanity Test");
			boolean flag2 = sales.deleteItem(109, "Sanity Test");
			if(flag && flag1 && flag2){
				Constant.log.info("Verify if Delivery Challan is updated with Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan is updated with Material test case is successful");
			}else{
				System.err.println("Delivery Challan is updated with Material test case failed ");
				Constant.captureScreen_Negative("Test110_UpdateDeliveryChallan_WithReturn");
				extentTest.log(LogStatus.FAIL, "Delivery Challan is updated with Material test case failed");
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Delivery Challan with Material");
	}

	@Test
	public void Test111_ApproveDeliveryChallan_WithReturn() throws Exception{
		log.startTestCase("Approve Delivery Challan");
		extentTest = extent.startTest("Approve Delivery Challan",
				"Verify if Delivery Challan is approved");
		try{
			boolean flag = sales.validateApproveInvoice(110, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Delivery Challan is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan is approved test case is successful");
			}else{
				System.err.println("Delivery Challan is approved test case failed ");
				Constant.captureScreen_Negative("Test111_ApproveDeliveryChallan_WithReturn");
				extentTest.log(LogStatus.FAIL, "Delivery Challan is approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Delivery Challan");
	}

	@Test
	public void Test112_RejectDraftDeliveryChallan_WithReturn() throws Exception{
		log.startTestCase("Reject draft Delivery Challan");
		extentTest = extent.startTest("Reject draft Delivery Challan",
				"Verify if draft Delivery Challan is reject");
		try{
			boolean flag = sales.validateRejectDraftInvoice(111, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if draft Delivery Challan is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if draft Delivery Challan is reject test case is successful");
			}else{
				System.err.println("Draft Delivery Challan is reject test case failed ");
				Constant.captureScreen_Negative("Test112_RejectDraftDeliveryChallan_WithReturn");
				extentTest.log(LogStatus.FAIL, "Draft Delivery Challan is reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject draft Delivery Challan");
	}

	@Test
	public void Test113_RejectApprovedDeliveryChallan_WithReturn() throws Exception{
		log.startTestCase("Reject Approved Delivery Challan");
		extentTest = extent.startTest("Reject Approved Delivery Challan",
				"Verify if Approved Delivery Challan is reject");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(112, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Delivery Challan is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Delivery Challan is reject test case is successful");
			}else{
				System.err.println("Approved Delivery Challan is reject test case failed ");
				Constant.captureScreen_Negative("Test113_RejectApprovedDeliveryChallan_WithReturn");
				extentTest.log(LogStatus.FAIL, "Approved Delivery Challan is reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Delivery Challan");
	}

	@Test
	public void Test114_AddNonStockIndent() throws Exception{
		log.startTestCase("Add Indent with non stock materials");
		extentTest = extent.startTest("Add Indent with non stock materials",
				"Verify if indent is added with only non stock materials");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.verifyAddIndent(113,"Sanity Test");
			if(flag){
				Constant.log.info("Add Indent with non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Add Indent with non stock materials test case is successful");
			}else{
				System.err.println("Add Indent with non stock materials test case failed ");
				Constant.captureScreen_Negative("Test114_AddNonStockIndent");
				extentTest.log(LogStatus.FAIL, "Add Indent with non stock materials test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Indent with non stock materials");
	}

	@Test
	public void Test115_AddStockNNonStockIndent() throws Exception{
		log.startTestCase("Add Indent with stock and non stock materials");
		extentTest = extent.startTest("Add Indent with stock and non stock materials",
				"Verify if indent is added with stock and non stock materials");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.verifyAddIndent(114,"Sanity Test");
			if(flag){
				Constant.log.info("Add Indent with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Add Indent with stock and non stock materials test case is successful");
			}else{
				System.err.println("Add Indent with stock and non stock materials test case failed ");
				Constant.captureScreen_Negative("Test115_AddStockNNonStockIndent");
				extentTest.log(LogStatus.FAIL, "Add Indent with stock and non stock materials test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Indent with stock and non stock materials");
	}

	@Test
	public void Test116_AddStockNNonStockOA() throws Exception{
		log.startTestCase("Add OA with stock and non stock materials");
		extentTest = extent.startTest("Add OA with stock and non stock materials",
				"Verify if OA is added with stock and non stock materials");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addOA(115,"Sanity Test");
			if(flag){
				Constant.log.info("Add OA with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Add OA with stock and non stock materials test case is successful");
			}else{
				System.err.println("Add OA with stock and non stock materials test case failed ");
				Constant.captureScreen_Negative("Add OA with stock and non stock materials");
				extentTest.log(LogStatus.FAIL, "Add OA with stock and non stock materials test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add OA with stock and non stock materials");
	}

	@Test
	public void Test117_UpdateStockNNonStockOA() throws Exception{
		log.startTestCase("Update OA with stock and non stock materials");
		extentTest = extent.startTest("Update OA with stock and non stock materials",
				"Verify if OA is updated with stock and non stock materials");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.updateOA(116,"Sanity Test");
			if(flag){
				Constant.log.info("Update OA with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Update OA with stock and non stock materials test case is successful");
			}else{
				System.err.println("Update OA with stock and non stock materials test case failed ");
				Constant.captureScreen_Negative("Update OA with stock and non stock materials");
				extentTest.log(LogStatus.FAIL, "Update OA with stock and non stock materials test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update OA with stock and non stock materials");
	}

	@Test
	public void Test118_ApproveStockNNonStockOA() throws Exception{
		log.startTestCase("Approve OA with stock and non stock materials");
		extentTest = extent.startTest("Approve OA with stock and non stock materials",
				"Verify if OA is Approved with stock and non stock materials");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validateApproveOA(117,"Sanity Test");
			if(flag){
				Constant.log.info("Approve OA with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Approve OA with stock and non stock materials test case is successful");
			}else{
				System.err.println("Approve OA with stock and non stock materials test case failed ");
				Constant.captureScreen_Negative("Approve OA with stock and non stock materials");
				extentTest.log(LogStatus.FAIL, "Approve OA with stock and non stock materials test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve OA with stock and non stock materials");
	}

	@Test
	public void Test119_RejectApprovedStockNNonStockOA() throws Exception{
		log.startTestCase("Reject Approved OA with stock and non stock materials");
		extentTest = extent.startTest("Reject Approved OA with stock and non stock materials",
				"Verify if Approved OA is Rejected with stock and non stock materials");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validateRejectApprovedOA(118,"Sanity Test");
			if(flag){
				Constant.log.info("Reject Approved OA with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Approved OA with stock and non stock materials test case is successful");
			}else{
				System.err.println("Reject Approved OA with stock and non stock materials test case failed ");
				Constant.captureScreen_Negative("Reject Approved OA with stock and non stock materials");
				extentTest.log(LogStatus.FAIL, "Reject Approved OA with stock and non stock materials test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved OA with stock and non stock materials");
	}

	@Test
	public void Test120_RejectDraftStockNNonStockOA() throws Exception{
		log.startTestCase("Reject Draft OA with stock and non stock materials");
		extentTest = extent.startTest("Reject Draft OA with stock and non stock materials",
				"Verify if Draft OA is Rejected with stock and non stock materials");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validateRejectDraftOA(119,"Sanity Test");
			if(flag){
				Constant.log.info("Reject Draft OA with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Draft OA with stock and non stock materials test case is successful");
			}else{
				System.err.println("Reject Draft OA with stock and non stock materials test case failed ");
				Constant.captureScreen_Negative("Reject Draft OA with stock and non stock materials");
				extentTest.log(LogStatus.FAIL, "Reject Draft OA with stock and non stock materials test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft OA with stock and non stock materials");
	}

	@Test
	public void Test121_AmendStockNNonStockOA() throws Exception{
		log.startTestCase("Amend OA with stock and non stock materials");
		extentTest = extent.startTest("Amend OA with stock and non stock materials",
				"Verify if OA is Amended with stock and non stock materials");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.amendOA(120,"Sanity Test");
			if(flag){
				Constant.log.info("Amend OA with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Amend OA with stock and non stock materials test case is successful");
			}else{
				System.err.println("Amend OA with stock and non stock materials test case failed ");
				Constant.captureScreen_Negative("Amend OA with stock and non stock materials");
				extentTest.log(LogStatus.FAIL, "Amend OA with stock and non stock materials test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Amend OA with stock and non stock materials");
	}

	@Test
	public void Test122_AddTaxInvoiceInvoice_OA() throws Exception{
		log.startTestCase("Add Tax Invoice Invoice with OA");
		extentTest = extent.startTest("Add Tax Invoice Invoice  with OA",
				"Verify if Tax Invoice Invoice is added with OA");
		try{
			boolean flag = sales.addInvoice(121,"Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Tax Invoice invoice is added with OA test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Tax Invoice invoice is added with OA test case is successful");
			}else{
				System.err.println("Tax Invoice invoice is added with OA test case failed ");
				Constant.captureScreen_Negative("Add Tax Invoice Invoice with OA");
				extentTest.log(LogStatus.FAIL, "Tax Invoice invoice is added with OA test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Tax Invoice Invoice with OA");
	}

	@Test
	public void Test123_UpdateTaxInvoice_Material_OA() throws Exception{
		log.startTestCase("Update Tax Invoice Invoice with OA");
		extentTest = extent.startTest("Update Tax Invoice Invoice with OA",
				"Verify if Tax Invoice Invoice is updated with OA");
		try{
			sales.addInvoice(122, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(122, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(122, "Sanity Test");
			boolean flag2 = sales.deleteItem(122, "Sanity Test");
			if(flag && flag1 && flag2){
				Constant.log.info("Tax Invoice invoice is updated with OA test case is successful");
				extentTest.log(LogStatus.PASS, "Tax Invoice invoice is updated with OA test case is successful");
			}else{
				System.err.println("Tax Invoice invoice is updated with OA test case failed ");
				Constant.captureScreen_Negative("Update Tax Invoice Invoice with OA");
				extentTest.log(LogStatus.FAIL, "Tax Invoice invoice is updated with OA test case failed");
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Tax Invoice Invoice with OA");
	}

	@Test
	public void Test124_ApproveTaxInvoiceInvoice_OA() throws Exception{
		log.startTestCase("Approve Tax Invoice Invoice with OA");
		extentTest = extent.startTest("Approve Tax Invoice Invoice with OA",
				"Verify if Tax Invoice Invoice with OA is approved");
		try{
			boolean flag = sales.validateApproveInvoice(123, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Tax Invoice invoice with OA is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Tax Invoice invoice with OA is approved test case is successful");
			}else{
				System.err.println("Tax Invoice invoice with OA is approved test case failed ");
				Constant.captureScreen_Negative("Approve Tax Invoice Invoice with OA");
				extentTest.log(LogStatus.FAIL, "Tax Invoice invoice with OA is approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Tax Invoice Invoice with OA");
	}

	@Test
	public void Test125_RejectDraftTaxInvoiceInvoice_OA() throws Exception{
		log.startTestCase("Reject Draft Tax Invoice Invoice with OA");
		extentTest = extent.startTest("Reject Draft Tax Invoice Invoice with OA",
				"Verify if drafted Tax Invoice Invoice with OA is rejected");
		try{
			boolean flag = sales.validateRejectDraftInvoice(124, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if drafted Tax Invoice Invoice with OA is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Tax Invoice Invoice with OA is rejected test case is successful");
			}else{
				System.err.println("Drafted Tax Invoice Invoice with OA is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Draft Tax Invoice Invoice with OA");
				extentTest.log(LogStatus.FAIL, "Drafted Tax Invoice Invoice with OA is rejected test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Tax Invoice Invoice with OA");
	}

	@Test
	public void Test126_RejectApprovedTaxInvoiceInvoice_OA() throws Exception{
		log.startTestCase("Reject Approved Tax Invoice Invoice with OA");
		extentTest = extent.startTest("Reject Approved Tax Invoice Invoice with OA",
				"Verify if Approved Tax Invoice Invoice with OA is rejected");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(125, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Tax Invoice Invoice with OA is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Tax Invoice Invoice with OA is rejected test case is successful");
			}else{
				System.err.println("Approved Tax Invoice Invoice with OA is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Approved Tax Invoice Invoice with OA");
				extentTest.log(LogStatus.FAIL, "Approved Tax Invoice Invoice with OA is rejected test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Tax Invoice Invoice with OA");
	}

	@Test
	public void Test127_AddDCGRN() throws Exception{
		log.startTestCase("Add DC GRN");
		extentTest = extent.startTest("Add DC GRN",
				"Verify if DC GRN is added");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRN();
			boolean flag = store.addGRN(126, "Sanity Test",null);
			if(flag){
				Constant.log.info("DC GRN addition is successful");
				extentTest.log(LogStatus.PASS, "DC GRN addition is successful");
			}else{
				System.err.println("DC GRN addition failed ");
				Constant.captureScreen_Negative("Add DC GRN");
				extentTest.log(LogStatus.FAIL, "DC GRN addition failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add DC GRN");
	}

	@Test
	public void Test128_UpdateDCGRN() throws Exception{
		log.startTestCase("Update DC GRN");
		extentTest = extent.startTest("Update DC GRN",
				"Verify if DC GRN is Updated");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRN();
			boolean flag = store.updateGRN(127, "Sanity Test", null);
			if(flag){
				Constant.log.info("DC GRN Update is successful");
				extentTest.log(LogStatus.PASS, "DC GRN Update is successful");
			}else{
				System.err.println("DC GRN Update failed ");
				Constant.captureScreen_Negative("Update DC GRN");
				extentTest.log(LogStatus.FAIL, "DC GRN Update failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update DC GRN");
	}

	@Test
	public void Test129_ApproveDCGRN() throws Exception{
		log.startTestCase("Approve DC GRN");
		extentTest = extent.startTest("Approve DC GRN",
				"Verify if GRN is Approved");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRN();
			boolean flag = store.approveGRN(128, "Sanity Test",null);
			if(flag){
				Constant.log.info("DC GRN Approve is successful");
				extentTest.log(LogStatus.PASS, "DC GRN Approve is successful");
			}else{
				System.err.println("DC GRN Approve failed ");
				Constant.captureScreen_Negative("DC Approve GRN");
				extentTest.log(LogStatus.FAIL, "DC GRN Approve failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("DC Approve GRN");
	}

	@Test
	public void Test130_DraftDCGRNReject() throws Exception{
		log.startTestCase("Draft DC GRN Reject");
		extentTest = extent.startTest("Draft DC GRN Reject",
				"Verify if draft DC GRN is Rejected");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRN();
			boolean flag = store.validateDraftRejectGRN(129, "Sanity Test");
			if(flag){
				Constant.log.info("Draft DC GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft DC GRN Reject is successful");
			}else{
				System.err.println("Draft DC GRN Reject failed ");
				Constant.captureScreen_Negative("Draft DC GRN Reject");
				extentTest.log(LogStatus.FAIL, "Draft DC GRN Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft DC GRN Reject");
	}

	@Test
	public void Test131_ApprovedDCGRNReject() throws Exception{
		log.startTestCase("Approved DC GRN Reject");
		extentTest = extent.startTest("Approved DC GRN Reject",
				"Verify if Approved DC GRN is Rejected");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRN();
			boolean flag = store.vaildateRejectApprovedGRN(130, "Sanity Test",null);
			if(flag){
				Constant.log.info("Approved DC GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved DC GRN Reject is successful");
			}else{
				System.err.println("Approved DC GRN Reject failed ");
				Constant.captureScreen_Negative("Approved DC GRN Reject");
				extentTest.log(LogStatus.FAIL, "Approved DC GRN Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved DC GRN Reject");
	}

	@Test
	public void Test132_AddIssueGRN() throws Exception{
		log.startTestCase("Add Issue GRN");
		extentTest = extent.startTest("Add Issue GRN",
				"Verify if Issue GRN is added");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(131, "Sanity Test",null);
			if(flag){
				Constant.log.info("Issue GRN addition is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition is successful");
			}else{
				System.err.println("Issue GRN addition failed ");
				Constant.captureScreen_Negative("Add Issue GRN");
				extentTest.log(LogStatus.FAIL, "Issue GRN addition failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN");
	}

	@Test
	public void Test133_UpdateIssueGRN() throws Exception{
		log.startTestCase("Update Issue GRN");
		extentTest = extent.startTest("Update Issue GRN",
				"Verify if Issue GRN is Updated");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.updateGRN(132, "Sanity Test", null);
			if(flag){
				Constant.log.info("Issue GRN Update is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN Update is successful");
			}else{
				System.err.println("Issue GRN Update failed ");
				Constant.captureScreen_Negative("Update Issue GRN");
				extentTest.log(LogStatus.FAIL, "Issue GRN Update failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Issue GRN");
	}

	@Test
	public void Test134_ApproveIssueGRN() throws Exception{
		log.startTestCase("Approve Issue GRN");
		extentTest = extent.startTest("Approve Issue GRN",
				"Verify if GRN is Approved");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.approveGRN(133, "Sanity Test",null);
			if(flag){
				Constant.log.info("Issue GRN Approve is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN Approve is successful");
			}else{
				System.err.println("Issue GRN Approve failed ");
				Constant.captureScreen_Negative("Issue Approve GRN");
				extentTest.log(LogStatus.FAIL, "Issue GRN Approve failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Issue Approve GRN");
	}

	@Test
	public void Test135_DraftIssueGRNReject() throws Exception{
		log.startTestCase("Draft Issue GRN Reject");
		extentTest = extent.startTest("Draft Issue GRN Reject",
				"Verify if draft Issue GRN is Rejected");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.validateDraftRejectGRN(134, "Sanity Test");
			if(flag){
				Constant.log.info("Draft Issue GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft Issue GRN Reject is successful");
			}else{
				System.err.println("Draft Issue GRN Reject failed ");
				Constant.captureScreen_Negative("Draft Issue GRN Reject");
				extentTest.log(LogStatus.FAIL, "Draft Issue GRN Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft Issue GRN Reject");
	}

	@Test
	public void Test136_ApprovedIssueGRNReject() throws Exception{
		log.startTestCase("Approved Issue GRN Reject");
		extentTest = extent.startTest("Approved Issue GRN Reject",
				"Verify if Approved Issue GRN is Rejected");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.vaildateRejectApprovedGRN(135, "Sanity Test",null);
			if(flag){
				Constant.log.info("Approved Issue GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved Issue GRN Reject is successful");
			}else{
				System.err.println("Approved Issue GRN Reject failed ");
				Constant.captureScreen_Negative("Approved Issue GRN Reject");
				extentTest.log(LogStatus.FAIL, "Approved Issue GRN Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved Issue GRN Reject");
	}

	@Test
	public void Test137_AddOthersGRN() throws Exception{
		log.startTestCase("Add Others GRN");
		extentTest = extent.startTest("Add Others GRN",
				"Verify if Others GRN is added");
		try{
			boolean flag = store.addGRN(136, "Sanity Test",null);
			if(flag){
				Constant.log.info("Others GRN addition is successful");
				extentTest.log(LogStatus.PASS, "Others GRN addition is successful");
			}else{
				System.err.println("Others GRN addition failed ");
				Constant.captureScreen_Negative("Add Others GRN");
				extentTest.log(LogStatus.FAIL, "Others GRN addition failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Others GRN");
	}

	@Test
	public void Test138_UpdateOthersGRN() throws Exception{
		log.startTestCase("Update Others GRN");
		extentTest = extent.startTest("Update Others GRN",
				"Verify if Others GRN is Updated");
		try{
			boolean flag = store.updateGRN(137, "Sanity Test", null);
			if(flag){
				Constant.log.info("Others GRN Update is successful");
				extentTest.log(LogStatus.PASS, "Others GRN Update is successful");
			}else{
				System.err.println("Others GRN Update failed ");
				Constant.captureScreen_Negative("Update Others GRN");
				extentTest.log(LogStatus.FAIL, "Others GRN Update failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Others GRN");
	}

	@Test
	public void Test139_ApproveOthersGRN() throws Exception{
		log.startTestCase("Approve Others GRN");
		extentTest = extent.startTest("Approve Others GRN",
				"Verify if GRN is Approved");
		try{
			boolean flag = store.approveGRN(138, "Sanity Test",null);
			if(flag){
				Constant.log.info("Others GRN Approve is successful");
				extentTest.log(LogStatus.PASS, "Others GRN Approve is successful");
			}else{
				System.err.println("Others GRN Approve failed ");
				Constant.captureScreen_Negative("Others Approve GRN");
				extentTest.log(LogStatus.FAIL, "Others GRN Approve failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Others Approve GRN");
	}

	@Test
	public void Test140_DraftOthersGRNReject() throws Exception{
		log.startTestCase("Draft Others GRN Reject");
		extentTest = extent.startTest("Draft Others GRN Reject",
				"Verify if draft Others GRN is Rejected");
		try{
			boolean flag = store.validateDraftRejectGRN(139, "Sanity Test");
			if(flag){
				Constant.log.info("Draft Others GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft Others GRN Reject is successful");
			}else{
				System.err.println("Draft Others GRN Reject failed ");
				Constant.captureScreen_Negative("Draft Others GRN Reject");
				extentTest.log(LogStatus.FAIL, "Draft Others GRN Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft Others GRN Reject");
	}

	@Test
	public void Test141_ApprovedOthersGRNReject() throws Exception{
		log.startTestCase("Approved Others GRN Reject");
		extentTest = extent.startTest("Approved Others GRN Reject",
				"Verify if Approved Others GRN is Rejected");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(140, "Sanity Test",null);
			if(flag){
				Constant.log.info("Approved Others GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved Others GRN Reject is successful");
			}else{
				System.err.println("Approved Others GRN Reject failed ");
				Constant.captureScreen_Negative("Approved Others GRN Reject");
				extentTest.log(LogStatus.FAIL, "Approved Others GRN Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved Others GRN Reject");
	}

	@Test
	public void Test142_SupplierPriceApproval() throws Exception{
		log.startTestCase("Supplier price Approval");
		extentTest = extent.startTest("Supplier price Approval",
				"Verify if Supplier price is approved");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = master.approveSupplierPrice(141,"Sanity Test");
			if(flag){
				Constant.log.info("Supplier price approved test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price approved test case is successful");
			}else{
				System.err.println("Supplier price approved test case failed ");
				Constant.captureScreen_Negative("Supplier price Approval");
				extentTest.log(LogStatus.FAIL, "Supplier price approved test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Supplier price Approval");
	}

	@Test
	public void Test143_SupplierPriceReject() throws Exception{
		log.startTestCase("Supplier price Reject");
		extentTest = extent.startTest("Supplier price Reject",
				"Verify if Supplier price is Rejected");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = master.rejectSupplierPrice(142,"Sanity Test");
			if(flag){
				Constant.log.info("Supplier price Rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price Rejected test case is successful");
			}else{
				System.err.println("Supplier price Rejected test case failed ");
				Constant.captureScreen_Negative("Supplier price Reject");
				extentTest.log(LogStatus.FAIL, "Supplier price Rejected test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Supplier price Reject");
	}

	@Test
	public void Test144_SupplierPriceResubmit() throws Exception{
		log.startTestCase("Supplier price Resubmit");
		extentTest = extent.startTest("Supplier price Resubmit",
				"Verify if Supplier price is Resubmited");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = master.resubmitSupplierPrice(143,"Sanity Test");
			if(flag){
				Constant.log.info("Supplier price Resubmited test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price Resubmited test case is successful");
			}else{
				System.err.println("Supplier price Resubmited test case failed ");
				Constant.captureScreen_Negative("Supplier price Resubmit");
				extentTest.log(LogStatus.FAIL, "Supplier price Resubmited test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Supplier price Resubmit");
	}

	@Test
	public void Test145_SupplierPriceRemove() throws Exception{
		log.startTestCase("Supplier price Remove");
		extentTest = extent.startTest("Supplier price Remove",
				"Verify if Supplier price is Resubmited");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = master.removeSupplierPrice(144,"Sanity Test");
			if(flag){
				Constant.log.info("Supplier price removed test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price removed test case is successful");
			}else{
				System.err.println("Supplier price removed test case failed ");
				Constant.captureScreen_Negative("Supplier price Remove");
				extentTest.log(LogStatus.FAIL, "Supplier price removed test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Supplier price Remove");
	}

	@Test
	public void Test146_ChangePassword() throws Exception{
		log.startTestCase("Change Password");
		extentTest = extent.startTest("Change Password",
				"Validate change password scenario");
		try{
			boolean flag = setting.changePwd(145,"Sanity Test");
			if(flag){
				Constant.log.info("Change password test case is successful");
				extentTest.log(LogStatus.PASS, "Change password test case is successful");
			}else{
				System.err.println("Change password removed test case failed ");
				Constant.captureScreen_Negative("Change Password");
				extentTest.log(LogStatus.FAIL, "Change password test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Change Password");
	}

	@Test
	public void Test147_ValidateBankReconciliationCol() throws Exception{
		log.startTestCase("Bank Reconciliation Column validation");
		extentTest = extent.startTest("Bank Reconciliation Column validation",
				"Validate bank reconciliation column validation");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToBankReconciliation();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = accounts.bankReconciliationColumnValidation(146,"Sanity Test");
			if(flag){
				Constant.log.info("Bank reconciliation column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Bank reconciliation column validation test case is successful");
			}else{
				System.err.println("Bank reconciliation column validation test case failed ");
				Constant.captureScreen_Negative("Bank Reconciliation Column vlaidation");
				extentTest.log(LogStatus.FAIL, "Bank reconciliation column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Bank Reconciliation Column vlaidation");
	}

	@Test
	public void Test148_PoShortClose() throws Exception{
		log.startTestCase("PO Short Close");
		extentTest = extent.startTest("PO Short Close",
				"Validate po short close link");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.validateShortClose(147, "Sanity Test");
			if(flag){
				Constant.log.info("Po short close link validation test case is successful");
				extentTest.log(LogStatus.PASS, "Po short close link validation test case is successful");
			}else{
				System.err.println("Po short close link validation test case failed ");
				Constant.captureScreen_Negative("PO Short Close");
				extentTest.log(LogStatus.FAIL, "Po short close link validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("PO Short Close");
	}

	@Test
	public void Test149_ReturnICD() throws Exception{
		log.startTestCase("Return ICD");
		extentTest = extent.startTest("Return ICD",
				"Verify if ICD is Returned");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = audit.returnICD(148, "Sanity Test",null, "Checked");
			if(flag){
				Constant.log.info("Icd Return is successful");
				extentTest.log(LogStatus.PASS, "ICD Return is successful");
			}else{
				System.err.println("ICD Return failed ");
				Constant.captureScreen_Negative("Return ICD");
				extentTest.log(LogStatus.FAIL, "ICD Return failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD");
	}

	@Test
	public void Test150_CheckReturnedICD() throws Exception{
		log.startTestCase("Check Returned ICD");
		extentTest = extent.startTest("Check Returned ICD",
				"Verify if returned ICD is checked");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = audit.checkReturnedICD(149,"Sanity Test", null);
			if(flag){
				Constant.log.info("Check returned icd test case is successful");
				extentTest.log(LogStatus.PASS, "Check returned icd test case is successful");
			}else{
				System.err.println("Check returned icd test case failed ");
				Constant.captureScreen_Negative("Check Returned ICD");
				extentTest.log(LogStatus.FAIL, "Check returned icd test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check Returned ICD");
	}

	@Test
	public void Test151_ReturnManualNote() throws Exception{
		log.startTestCase("Return Manual Note");
		extentTest = extent.startTest("Return Manual Note",
				"Verify if Manual note is returned");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = audit.returnManualNote(150, "Sanity Test");
			if(flag){
				Constant.log.info("Return manual note test case is successful");
				extentTest.log(LogStatus.PASS, "Return manual note test case is successful");
			}else{
				System.err.println("Return manual note test case failed ");
				Constant.captureScreen_Negative("Return Manual Note");
				extentTest.log(LogStatus.FAIL, "Return manual note test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return Manual Note");
	}

	@Test
	public void Test152_CheckReturnedManualNote() throws Exception{
		log.startTestCase("Check Returned Manual Note");
		extentTest = extent.startTest("Check Returned Manual Note",
				"Verify if returned Manual Note is checked");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = audit.checkReturnedNote(151,"Sanity Test");
			if(flag){
				Constant.log.info("Check returned Manual Note test case is successful");
				extentTest.log(LogStatus.PASS, "Check returned Manual Note test case is successful");
			}else{
				System.err.println("Check returned Manual Note test case failed ");
				Constant.captureScreen_Negative("Check Returned Manual Note");
				extentTest.log(LogStatus.FAIL, "Check returned Manual Note test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check Returned Manual Note");
	}

	@Test
	public void Test153_AddSalesReturn() throws Exception{
		log.startTestCase("Sales return addition");
		extentTest = extent.startTest("Sales return addition",
				"Verify if sales return can be added");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.addGRN(152,"Sanity Test",null);
			if(flag){
				Constant.log.info("Sales return addtion test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return addtion test case is successful");
			}else{
				System.err.println("Sales return addtion test case failed ");
				Constant.captureScreen_Negative("Sales return addition");
				extentTest.log(LogStatus.FAIL, "Sales return addtion test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return addition");
	}

	@Test
	public void Test154_UpdateSalesReturn() throws Exception{
		log.startTestCase("Sales return Update");
		extentTest = extent.startTest("Sales return Update",
				"Verify if sales return can be Update");
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
				Constant.captureScreen_Negative("Sales return Update");
				extentTest.log(LogStatus.FAIL, "Sales return Update test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return Update");
	}

	@Test
	public void Test155_ApproveSalesReturn() throws Exception{
		log.startTestCase("Sales return Approve");
		extentTest = extent.startTest("Sales return Approve",
				"Verify if sales return can be Approve");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.approveGRN(154,"Sanity Test",null);
			if(flag){
				Constant.log.info("Sales return Approve test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return Approve test case is successful");
			}else{
				System.err.println("Sales return Approve test case failed ");
				Constant.captureScreen_Negative("Sales return Approve");
				extentTest.log(LogStatus.FAIL, "Sales return Approve test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return Approve");
	}

	@Test
	public void Test156_RejectDraftSalesReturn() throws Exception{
		log.startTestCase("Sales return Draft Reject");
		extentTest = extent.startTest("Sales return Draft Reject",
				"Verify if draft sales return can be Reject");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.validateDraftRejectGRN(155,"Sanity Test");
			if(flag){
				Constant.log.info("Draft Sales return Reject test case is successful");
				extentTest.log(LogStatus.PASS, "Draft Sales return Reject test case is successful");
			}else{
				System.err.println("Draft Sales return Reject test case failed ");
				Constant.captureScreen_Negative("Sales return Draft Reject");
				extentTest.log(LogStatus.FAIL, "Draft Sales return Reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return Draft Reject");
	}

	@Test
	public void Test157_RejectApprovedSalesReturn() throws Exception{
		log.startTestCase("Sales return Draft Reject");
		extentTest = extent.startTest("Sales return Draft Reject",
				"Verify if draft sales return can be Reject");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.vaildateRejectApprovedGRN(156,"Sanity Test",null);
			if(flag){
				Constant.log.info("Draft Sales return Reject test case is successful");
				extentTest.log(LogStatus.PASS, "Draft Sales return Reject test case is successful");
			}else{
				System.err.println("Draft Sales return Reject test case failed ");
				Constant.captureScreen_Negative("Sales return Draft Reject");
				extentTest.log(LogStatus.FAIL, "Draft Sales return Reject test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return Draft Reject");
	}

	@Test
	public void Test158_ReturnICDToGRN() throws Exception{
		log.startTestCase("Return ICD to GRN");
		extentTest = extent.startTest("Return ICD to GRN",
				"Verify if ICD can be returned to GRN");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = audit.returnICDToGRN(157,"Sanity Test");
			if(flag){
				Constant.log.info("Verify if ICD can be returned to GRN test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD can be returned to GRN test case is successful");
			}else{
				System.err.println("Verify if ICD can be returned to GRN test case failed ");
				Constant.captureScreen_Negative("Return ICD to GRN");
				extentTest.log(LogStatus.FAIL, "Verify if ICD can be returned to GRN test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD to GRN");
	}

	@Test
	public void Test159_ApproveReturnedGRNFrmICd() throws Exception{
		log.startTestCase("Approve Returned GRN");
		extentTest = extent.startTest("Approve Returned GRN",
				"Verify if Returned GRN can be approved");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRN();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveReturnedGRN(158,"Sanity Test");
			if(flag){
				Constant.log.info("Verify if Returned GRN can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Returned GRN can be approved test case is successful");
			}else{
				System.err.println("Verify if Returned GRN can be approved test case failed ");
				Constant.captureScreen_Negative("Approve Returned GRN");
				extentTest.log(LogStatus.FAIL, "Verify if Returned GRN can be approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Returned GRN");
	}

	@Test
	public void Test160_CreatePO_IndentPOPage() throws Exception{
		log.startTestCase("Create PO from Indent PO");
		extentTest = extent.startTest("Create PO from Indent PO",
				"Verify if PO can be created from Indent po page");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.createPO_IndentPo(159,"Sanity Test");
			if(flag){
				Constant.log.info("Verify if PO can be created from Indent po page test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if PO can be created from Indent po page test case is successful");
			}else{
				System.err.println("Verify if PO can be created from Indent po page test case failed ");
				Constant.captureScreen_Negative("Create PO from Indent PO");
				extentTest.log(LogStatus.FAIL, "Verify if PO can be created from Indent po page test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create PO from Indent PO");
	}

	@Test
	public void Test161_AddGRNPO_WithDC() throws Exception{
		log.startTestCase("Add GRN with Dc toggle");
		extentTest = extent.startTest("Add GRN with Dc toggle",
				"Verify if GRN is added");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(160, "Sanity Test",null);
			if(flag){
				Constant.log.info("Verify if GRn added with dc toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRn added with dc toggle test case is successful");
			}else{
				System.err.println("Verify if GRn added with dc toggle test case failed ");
				Constant.captureScreen_Negative("Add GRN with DC toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRn added with dc toggle test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add GRN with DC toggle");
	}

	@Test
	public void Test162_UpdateGRNPO_DcToggle() throws Exception{
		log.startTestCase("Update GRN with Dc toggle");
		extentTest = extent.startTest("Update GRN with Dc toggle",
				"Verify if GRN with Dc toggle is Updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(161, "Sanity Test", null);
			if(flag){
				Constant.log.info("GRN Update with Dc toggle is successful");
				extentTest.log(LogStatus.PASS, "GRN Update with Dc toggle is successful");
			}else{
				System.err.println("GRN Update with Dc toggle failed ");
				Constant.captureScreen_Negative("Update GRN with Dc toggle");
				extentTest.log(LogStatus.FAIL, "GRN Update with Dc toggle failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update GRN with Dc toggle");
	}

	@Test
	public void Test163_ApproveGRNPO_DcToggle() throws Exception{
		log.startTestCase("Approve GRN with Dc toggle");
		extentTest = extent.startTest("Approve GRN with Dc toggle",
				"Verify if GRN with Dc toggle is Approved");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(162, "Sanity Test",null);
			if(flag){
				Constant.log.info("GRN Approve with Dc toggle is successful");
				extentTest.log(LogStatus.PASS, "GRN Approve with Dc toggle is successful");
			}else{
				System.err.println("GRN Approve with Dc toggle failed ");
				Constant.captureScreen_Negative("Approve GRN with Dc toggle");
				extentTest.log(LogStatus.FAIL, "GRN Approve with Dc toggle failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve GRN with Dc toggle");
	}

	@Test
	public void Test164_DraftGRNPoReject_DcToggle() throws Exception{
		log.startTestCase("Draft GRN Reject with Dc toggle");
		extentTest = extent.startTest("Draft GRN Reject with Dc toggle",
				"Verify if draft GRN with Dc toggle is Rejected");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.validateDraftRejectGRN(163, "Sanity Test");
			if(flag){
				Constant.log.info("Draft GRN with Dc toggle Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft GRN with Dc toggle Reject is successful");
			}else{
				System.err.println("Draft GRN with Dc toggle Reject failed ");
				Constant.captureScreen_Negative("Draft GRN with Dc toggle Reject");
				extentTest.log(LogStatus.FAIL, "Draft GRN with Dc toggle Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft GRN with Dc toggle Reject");
	}

	@Test
	public void Test165_ApprovedGRNPOReject_DcToggle() throws Exception{
		log.startTestCase("Approved GRN with Dc toggle Reject");
		extentTest = extent.startTest("Approved GRN with Dc toggle Reject",
				"Verify if Approved GRN with Dc toggle is Rejected");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.vaildateRejectApprovedGRN(164, "Sanity Test",null);
			if(flag){
				Constant.log.info("Approved GRN with Dc toggle Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved GRN with Dc toggle Reject is successful");
			}else{
				System.err.println("Approved GRN with Dc toggle Reject failed ");
				Constant.captureScreen_Negative("Approved GRN with Dc toggle Reject");
				extentTest.log(LogStatus.FAIL, "Approved GRN with Dc toggle Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved GRN with Dc toggle Reject");
	}

	@Test
	public void Test166_AddGRNPO_GoodsAlreadyReceived() throws Exception{
		log.startTestCase("Add GRN with goods already received checkbox");
		extentTest = extent.startTest("Add GRN with goods already received checkbox",
				"Verify if GRN is added");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(165, "Sanity Test",null);
			if(flag){
				Constant.log.info("Verify if GRn added with goods already received checkbox test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRn added with goods already received checkbox test case is successful");
			}else{
				System.err.println("Verify if GRn added with goods already received checkbox test case failed ");
				Constant.captureScreen_Negative("Add GRN with goods already received checkbox");
				extentTest.log(LogStatus.FAIL, "Verify if GRn added with goods already received checkbox test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add GRN with goods already received checkbox");
	}

	@Test
	public void Test167_UpdateGRNPO_GoodsAlreadyReceived() throws Exception{
		log.startTestCase("Update GRN with goods already received checkbox");
		extentTest = extent.startTest("Update GRN with goods already received checkbox",
				"Verify if GRN with goods already received checkbox is Updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(166, "Sanity Test", null);
			if(flag){
				Constant.log.info("GRN Update with goods already received checkbox is successful");
				extentTest.log(LogStatus.PASS, "GRN Update with goods already received checkbox is successful");
			}else{
				System.err.println("GRN Update with goods already received checkbox failed ");
				Constant.captureScreen_Negative("Update GRN with goods already received checkbox");
				extentTest.log(LogStatus.FAIL, "GRN Update with goods already received checkbox failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update GRN with goods already received checkbox");
	}

	@Test
	public void Test168_ApproveGRNPo_GoodsAlreadyReceived() throws Exception{
		log.startTestCase("Approve GRN with goods already received checkbox");
		extentTest = extent.startTest("Approve GRN with goods already received checkbox",
				"Verify if GRN with goods already received checkbox is Approved");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(167, "Sanity Test",null);
			if(flag){
				Constant.log.info("GRN Approve with goods already received checkbox is successful");
				extentTest.log(LogStatus.PASS, "GRN Approve with goods already received checkbox is successful");
			}else{
				System.err.println("GRN Approve with goods already received checkbox failed ");
				Constant.captureScreen_Negative("Approve GRN with goods already received checkbox");
				extentTest.log(LogStatus.FAIL, "GRN Approve with goods already received checkbox failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve GRN with goods already received checkbox");
	}

	@Test
	public void Test169_DraftGRNPOReject_GoodsAlreadyReceived() throws Exception{
		log.startTestCase("Draft GRN Reject with goods already received checkbox");
		extentTest = extent.startTest("Draft GRN Reject with goods already received checkbox",
				"Verify if draft GRN with goods already received checkbox is Rejected");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.validateDraftRejectGRN(168, "Sanity Test");
			if(flag){
				Constant.log.info("Draft GRN with goods already received checkbox Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft GRN with goods already received checkbox Reject is successful");
			}else{
				System.err.println("Draft GRN with goods already received checkbox Reject failed ");
				Constant.captureScreen_Negative("Draft GRN with goods already received checkbox Reject");
				extentTest.log(LogStatus.FAIL, "Draft GRN with goods already received checkbox Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft GRN with goods already received checkbox Reject");
	}

	@Test
	public void Test170_ApprovedGRNPoReject_GoodsAlreadyReceived() throws Exception{
		log.startTestCase("Approved GRN with goods already received checkbox Reject");
		extentTest = extent.startTest("Approved GRN with goods already received checkbox Reject",
				"Verify if Approved GRN with goods already received checkbox is Rejected");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.vaildateRejectApprovedGRN(169, "Sanity Test",null);
			if(flag){
				Constant.log.info("Approved GRN with goods already received checkbox Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved GRN with goods already received checkbox Reject is successful");
			}else{
				System.err.println("Approved GRN with goods already received checkbox Reject failed ");
				Constant.captureScreen_Negative("Approved GRN with goods already received checkbox Reject");
				extentTest.log(LogStatus.FAIL, "Approved GRN with goods already received checkbox Reject failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved GRN with goods already received checkbox Reject");
	}

	@Test
	public void Test171_AddDC_OA() throws Exception{
		log.startTestCase("ADD DC with OA");
		extentTest = extent.startTest("ADD DC with OA",
				"Verify if DC added with OA");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			boolean flag = sales.addInvoice(170, "Sanity Test",null);
			if(flag){
				Constant.log.info("ADD DC with OA is successful");
				extentTest.log(LogStatus.PASS, "ADD DC with OA is successful");
			}else{
				System.err.println("ADD DC with OA failed ");
				Constant.captureScreen_Negative("ADD DC with OA");
				extentTest.log(LogStatus.FAIL, "ADD DC with OA failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("ADD DC with OA");
	}

	@Test
	public void Test172_UpdateDC_Oa() throws Exception{
		log.startTestCase("Update Dc created with Oa");
		extentTest = extent.startTest("Update Dc created with Oa",
				"Verify if Dc created with Oa is updated");
		try{
			sales.addInvoice(171, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(171, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(171, "Sanity Test");
			boolean flag2 = sales.deleteItem(171, "Sanity Test");
			if(flag && flag1 && flag2){
				Constant.log.info("Dc created with Oa is updated with new material test case is successful");
				extentTest.log(LogStatus.PASS, "Dc created with Oa is updated with new material test case is successful");
			}else{
				System.err.println("Dc created with Oa is updated with new material test case failed ");
				Constant.captureScreen_Negative("Update Dc created with Oa");
				extentTest.log(LogStatus.FAIL, "Dc created with Oa is updated with new material test case failed");
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Dc created with Oa");
	}

	@Test
	public void Test173_ApproveDC_Oa() throws Exception{
		log.startTestCase("Approve Dc created with Oa");
		extentTest = extent.startTest("Approve Dc created with Oa",
				"Verify if Dc created with Oa is approved");
		try{
			boolean flag = sales.validateApproveInvoice(172, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Dc created with Oa is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Dc created with Oa is approved test case is successful");
			}else{
				System.err.println("Dc created with Oa is approved test case failed ");
				Constant.captureScreen_Negative("Approve Dc created with Oa");
				extentTest.log(LogStatus.FAIL, "Dc created with Oa is approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Dc created with Oa");
	}

	@Test
	public void Test174_DiscardDC_Oa() throws Exception{
		log.startTestCase("Reject Draft Dc created with Oa");
		extentTest = extent.startTest("Reject Draft Dc created with Oa",
				"Verify if drafted Dc created with Oa is rejected");
		try{
			boolean flag = sales.validateRejectDraftInvoice(173, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if drafted Dc created with Oa is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Dc created with Oa is rejected test case is successful");
			}else{
				System.err.println("Drafted Dc created with Oa is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Dc created with Oa");
				extentTest.log(LogStatus.FAIL, "Drafted Dc created with Oa is rejected test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Dc created with Oa");
	}

	@Test
	public void Test175_RejectDC_Oa() throws Exception{
		log.startTestCase("Reject Approved Dc created with Oa");
		extentTest = extent.startTest("Reject Approved Dc created with Oa",
				"Verify if Approved Dc created with Oa is rejected");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(174, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Dc created with Oa is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Dc created with Oa is rejected test case is successful");
			}else{
				System.err.println("Approved Dc created with Oa is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Approved Dc created with Oa");
				extentTest.log(LogStatus.FAIL, "Approved Dc created with Oa is rejected test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Dc created with Oa");
	}

	@Test
	public void Test176_AddInvoice_Dc() throws Exception{
		log.startTestCase("ADD Invoice with DC");
		extentTest = extent.startTest("ADD Invoice with DC",
				"Verify if Invoice with DC");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			boolean flag = sales.addInvoice(175, "Sanity Test",null);
			if(flag){
				Constant.log.info("ADD Invoice with DC is successful");
				extentTest.log(LogStatus.PASS, "ADD Invoice with DC is successful");
			}else{
				System.err.println("ADD Invoice with DC failed ");
				Constant.captureScreen_Negative("ADD Invoice with DC");
				extentTest.log(LogStatus.FAIL, "ADD Invoice with DC failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("ADD Invoice with DC");
	}

	@Test
	public void Test177_UpdateInvoice_Dc() throws Exception{
		log.startTestCase("Update Invoice created with DC");
		extentTest = extent.startTest("Update Invoice created with DC",
				"Verify if Invoice created with DC is updated");
		try{
			sales.addInvoice(176, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(176, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(176, "Sanity Test");
			if(flag && flag1){
				Constant.log.info("Invoice created with DC is updated with new material test case is successful");
				extentTest.log(LogStatus.PASS, "Invoice created with DC is updated with new material test case is successful");
			}else{
				System.err.println("Invoice created with DC is updated with new material test case failed ");
				Constant.captureScreen_Negative("Update Invoice created with DC");
				extentTest.log(LogStatus.FAIL, "Invoice created with DC is updated with new material test case failed");
			}
			Assert.assertTrue(flag && flag1);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Invoice created with DC");
	}

	@Test
	public void Test178_ApproveInvoice_Dc() throws Exception{
		log.startTestCase("Approve Invoice created with DC");
		extentTest = extent.startTest("Approve Invoice created with DC",
				"Verify if Invoice created with DC is approved");
		try{
			boolean flag = sales.validateApproveInvoice(177, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Invoice created with DC is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Invoice created with DC is approved test case is successful");
			}else{
				System.err.println("Invoice created with DC is approved test case failed ");
				Constant.captureScreen_Negative("Approve Invoice created with DC");
				extentTest.log(LogStatus.FAIL, "Invoice created with DC is approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Invoice created with DC");
	}

	@Test
	public void Test179_DiscardInvoice_Dc() throws Exception{
		log.startTestCase("Reject Draft Invoice created with DC");
		extentTest = extent.startTest("Reject Draft Invoice created with DC",
				"Verify if drafted Invoice created with DC is rejected");
		try{
			boolean flag = sales.validateRejectDraftInvoice(178, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if drafted Invoice created with DC is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Invoice created with DC is rejected test case is successful");
			}else{
				System.err.println("Drafted Invoice created with DC is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Invoice created with DC");
				extentTest.log(LogStatus.FAIL, "Drafted Invoice created with DC is rejected test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Invoice created with DC");
	}

	@Test
	public void Test180_RejectInvoice_Dc() throws Exception{
		log.startTestCase("Reject Approved Invoice created with DC");
		extentTest = extent.startTest("Reject Approved Invoice created with DC",
				"Verify if Approved Invoice created with DC is rejected");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(179, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Invoice created with DC is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Invoice created with DC is rejected test case is successful");
			}else{
				System.err.println("Approved Invoice created with DC is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Approved Invoice created with DC");
				extentTest.log(LogStatus.FAIL, "Approved Invoice created with DC is rejected test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Invoice created with DC");
	}

	@Test
	public void Test181_AddGRNJO_DCtoggle() throws Exception{
		log.startTestCase("Add GRN Jo with DC toggle");
		extentTest = extent.startTest("Add GRN Jo with DC toggle",
				"Verify if GRN Jo with dc toggle is created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(180, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN Jo with dc toggle is created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN Jo with dc toggle is created test case is successful");
			}else{
				System.err.println("Verify if GRN Jo with dc toggle is created test case failed ");
				Constant.captureScreen_Negative("Add GRN Jo with DC toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN Jo with dc toggle is created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN Jo with DC toggle");
	}

	@Test
	public void Test182_UpdateGRNJO_DCtoggle() throws Exception{
		log.startTestCase("Update GRN Jo with DC toggle");
		extentTest = extent.startTest("Update GRN Jo with DC toggle",
				"Verify if GRN Jo with dc toggle is created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(181, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN Jo with dc toggle is created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN Jo with dc toggle is created test case is successful");
			}else{
				System.err.println("Verify if GRN Jo with dc toggle is created test case failed ");
				Constant.captureScreen_Negative("Update GRN Jo with DC toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN Jo with dc toggle is created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN Jo with DC toggle");
	}

	@Test
	public void Test183_ApproveGRNJO_DCtoggle() throws Exception{
		log.startTestCase("Approve GRN Jo with DC toggle");
		extentTest = extent.startTest("Approve GRN Jo with DC toggle",
				"Verify if GRN Jo with dc toggle is created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(182, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN Jo with dc toggle is created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN Jo with dc toggle is created test case is successful");
			}else{
				System.err.println("Verify if GRN Jo with dc toggle is created test case failed ");
				Constant.captureScreen_Negative("Approve GRN Jo with DC toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN Jo with dc toggle is created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN Jo with DC toggle");
	}

	@Test
	public void Test184_AddGRNJO_goodsReceived() throws Exception{
		log.startTestCase("Add GRN against Jo with Goods checkbox");
		extentTest = extent.startTest("Add GRN against Jo with Goods checkbox",
				"Verify if GRN against JO created with goods checkbox");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(183, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO created with goods checkbox test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO created with goods checkbox test case is successful");
			}else{
				System.err.println("Verify if GRN against JO created with goods checkbox test case failed ");
				Constant.captureScreen_Negative("Add GRN against Jo with Goods checkbox");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO created with goods checkbox test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Jo with Goods checkbox");
	}

	@Test
	public void Test185_UpdateGRNJO_goodsReceived() throws Exception{
		log.startTestCase("Update GRN against Jo with Goods checkbox");
		extentTest = extent.startTest("Update GRN against Jo with Goods checkbox",
				"Verify if GRN against JO created with goods checkbox");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(184, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO created with goods checkbox test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO created with goods checkbox test case is successful");
			}else{
				System.err.println("Verify if GRN against JO created with goods checkbox test case failed ");
				Constant.captureScreen_Negative("Update GRN against Jo with Goods checkbox");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO created with goods checkbox test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Jo with Goods checkbox");
	}

	@Test
	public void Test186_AddGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Add GRN against Po without Po with invoice toggle");
		extentTest = extent.startTest("Add GRN against Po without Po with invoice toggle",
				"Verify if GRN against Po with invoice toggle and without po no can be created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(185, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and without po no can be created test case failed ");
				Constant.captureScreen_Negative("Add GRN against Po without Po with invoice toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with invoice toggle and without po no can be created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po without Po with invoice toggle");
	}

	@Test
	public void Test187_UpdateGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Update GRN against Po without Po with invoice toggle");
		extentTest = extent.startTest("Update GRN against Po without Po with invoice toggle",
				"Verify if GRN against Po with invoice toggle and without po no can be updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(186, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and without po no can be updated test case failed ");
				Constant.captureScreen_Negative("Update GRN against Po without Po with invoice toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with invoice toggle and without po no can be updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Po without Po with invoice toggle");
	}

	@Test
	public void Test188_ApproveGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Approve GRN against Po without Po with invoice toggle");
		extentTest = extent.startTest("Approve GRN against Po without Po with invoice toggle",
				"Verify if GRN against Po with invoice toggle and without po no can be approved");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(187, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and without po no can be approved test case failed ");
				Constant.captureScreen_Negative("Approve GRN against Po without Po with invoice toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with invoice toggle and without po no can be approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against Po without Po with invoice toggle");
	}

	@Test
	public void Test189_DraftRejectGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Draft Reject GRN against Po without Po with invoice toggle");
		extentTest = extent.startTest("Draft Reject GRN against Po without Po with invoice toggle",
				"Verify if GRN against Po with invoice toggle and without po no can be rejected in draft status");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.validateDraftRejectGRN(188, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and without po no can be rejected in draft status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and without po no can be rejected in draft status test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and without po no can be rejected in draft status test case failed ");
				Constant.captureScreen_Negative("Draft Reject GRN against Po without Po with invoice toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with invoice toggle and without po no can be rejected in draft status test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Draft Reject GRN against Po without Po with invoice toggle");
	}

	@Test
	public void Test190_RejectApprovedGRNPO_WOPOInvoice() throws Exception{
		log.startTestCase("Reject Approved GRN against Po without Po with invoice toggle");
		extentTest = extent.startTest("Reject Approved GRN against Po without Po with invoice toggle",
				"Verify if GRN against Po with invoice toggle and without po no can be rejected in approved status");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.vaildateRejectApprovedGRN(189, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and without po no can be rejected in approved status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and without po no can be rejected in approved status test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and without po no can be rejected in approved status test case failed ");
				Constant.captureScreen_Negative("Reject Approved GRN against Po without Po with invoice toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with invoice toggle and without po no can be rejected in approved status test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved GRN against Po without Po with invoice toggle");
	}

	@Test
	public void Test191_AddGRNJO_WOPOInvoice() throws Exception{
		log.startTestCase("Add GRN against JO without Po with invoice toggle");
		extentTest = extent.startTest("Add GRN against JO without Po with invoice toggle",
				"Verify if GRN against JO with invoice toggle and without po no can be created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(190, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and without po no can be created test case failed ");
				Constant.captureScreen_Negative("Add GRN against JO without Po with invoice toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with invoice toggle and without po no can be created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO without Po with invoice toggle");
	}

	@Test
	public void Test192_UpdateGRNJO_WOPOInvoice() throws Exception{
		log.startTestCase("Update GRN against JO without Po with invoice toggle");
		extentTest = extent.startTest("Update GRN against JO without Po with invoice toggle",
				"Verify if GRN against JO with invoice toggle and without po no can be updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(191, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and without po no can be updated test case failed ");
				Constant.captureScreen_Negative("Update GRN against JO without Po with invoice toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with invoice toggle and without po no can be updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO without Po with invoice toggle");
	}

	@Test
	public void Test193_ApproveGRNJO_WOPOInvoice() throws Exception{
		log.startTestCase("Approve GRN against JO without Po with invoice toggle");
		extentTest = extent.startTest("Approve GRN against JO without Po with invoice toggle",
				"Verify if GRN against JO with invoice toggle and without po no can be approved");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(192, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and without po no can be approved test case failed ");
				Constant.captureScreen_Negative("Approve GRN against JO without Po with invoice toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with invoice toggle and without po no can be approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against JO without Po with invoice toggle");
	}

	@Test
	public void Test194_DraftRejectGRNJO_WOPOInvoice() throws Exception{
		log.startTestCase("Draft Reject GRN against JO without Po with invoice toggle");
		extentTest = extent.startTest("Draft Reject GRN against JO without Po with invoice toggle",
				"Verify if GRN against JO with invoice toggle and without po no can be rejected in draft status");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.validateDraftRejectGRN(193, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and without po no can be rejected in draft status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and without po no can be rejected in draft status test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and without po no can be rejected in draft status test case failed ");
				Constant.captureScreen_Negative("Draft Reject GRN against JO without Po with invoice toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with invoice toggle and without po no can be rejected in draft status test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Draft Reject GRN against JO without Po with invoice toggle");
	}

	@Test
	public void Test195_RejectApprovedGRNJO_WOPOInvoice() throws Exception{
		log.startTestCase("Reject Approved GRN against JO without Po with invoice toggle");
		extentTest = extent.startTest("Reject Approved GRN against JO without Po with invoice toggle",
				"Verify if GRN against JO with invoice toggle and without po no can be rejected in approved status");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.vaildateRejectApprovedGRN(194, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and without po no can be rejected in approved status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and without po no can be rejected in approved status test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and without po no can be rejected in approved status test case failed ");
				Constant.captureScreen_Negative("Reject Approved GRN against JO without Po with invoice toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with invoice toggle and without po no can be rejected in approved status test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved GRN against JO without Po with invoice toggle");
	}

	@Test
	public void Test196_AddGRNPO_WOPODC() throws Exception{
		log.startTestCase("Add GRN against Po without Po with DC toggle");
		extentTest = extent.startTest("Add GRN against Po without Po with DC toggle",
				"Verify if GRN against Po with DC toggle and without po no can be created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(195, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with DC toggle and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with DC toggle and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with DC toggle and without po no can be created test case failed ");
				Constant.captureScreen_Negative("Add GRN against Po without Po with DC toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with DC toggle and without po no can be created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po without Po with DC toggle");
	}

	@Test
	public void Test197_UpdateGRNPO_WOPODC() throws Exception{
		log.startTestCase("Update GRN against Po without Po with DC toggle");
		extentTest = extent.startTest("Update GRN against Po without Po with DC toggle",
				"Verify if GRN against Po with DC toggle and without po no can be updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(196, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with DC toggle and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with DC toggle and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with DC toggle and without po no can be updated test case failed ");
				Constant.captureScreen_Negative("Update GRN against Po without Po with DC toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with DC toggle and without po no can be updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Po without Po with DC toggle");
	}

	@Test
	public void Test198_ApproveGRNPO_WOPODC() throws Exception{
		log.startTestCase("Approve GRN against Po without Po with DC toggle");
		extentTest = extent.startTest("Approve GRN against Po without Po with DC toggle",
				"Verify if GRN against Po with DC toggle and without po no can be approved");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(197, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with DC toggle and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with DC toggle and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with DC toggle and without po no can be approved test case failed ");
				Constant.captureScreen_Negative("Approve GRN against Po without Po with DC toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with DC toggle and without po no can be approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against Po without Po with DC toggle");
	}

	@Test
	public void Test199_AddGRNJO_WOPODC() throws Exception{
		log.startTestCase("Add GRN against JO without Po with DC toggle");
		extentTest = extent.startTest("Add GRN against JO without Po with DC toggle",
				"Verify if GRN against JO with DC toggle and without po no can be created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(198, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and without po no can be created test case failed ");
				Constant.captureScreen_Negative("Add GRN against JO without Po with DC toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with DC toggle and without po no can be created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO without Po with DC toggle");
	}

	@Test
	public void Test200_UpdateGRNJO_WOPODC() throws Exception{
		log.startTestCase("Update GRN against JO without Po with DC toggle");
		extentTest = extent.startTest("Update GRN against JO without Po with DC toggle",
				"Verify if GRN against JO with DC toggle and without po no can be updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(199, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and without po no can be updated test case failed ");
				Constant.captureScreen_Negative("Update GRN against JO without Po with DC toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with DC toggle and without po no can be updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO without Po with DC toggle");
	}

	@Test
	public void Test201_ApproveGRNJO_WOPODC() throws Exception{
		log.startTestCase("Approve GRN against JO without Po with DC toggle");
		extentTest = extent.startTest("Approve GRN against JO without Po with DC toggle",
				"Verify if GRN against JO with DC toggle and without po no can be approved");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(200, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and without po no can be approved test case failed ");
				Constant.captureScreen_Negative("Approve GRN against JO without Po with DC toggle");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with DC toggle and without po no can be approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against JO without Po with DC toggle");
	}

	@Test
	public void Test202_AddGRNPO_WOPOGoods() throws Exception{
		log.startTestCase("Add GRN against Po without Po with Goods already received");
		extentTest = extent.startTest("Add GRN against Po without Po with Goods already received",
				"Verify if GRN against Po with Goods already received and without po no can be created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(201, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with Goods already received and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with Goods already received and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with Goods already received and without po no can be created test case failed ");
				Constant.captureScreen_Negative("Test202_AddGRNPO_WOPOGoods");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with Goods already received and without po no can be created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po without Po with Goods already received");
	}

	@Test
	public void Test203_UpdateGRNPO_WOPOGoods() throws Exception{
		log.startTestCase("Update GRN against Po without Po with Goods already received");
		extentTest = extent.startTest("Update GRN against Po without Po with Goods already received",
				"Verify if GRN against Po with Goods already received and without po no can be updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(202, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with Goods already received and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with Goods already received and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with Goods already received and without po no can be updated test case failed ");
				Constant.captureScreen_Negative("Test203_UpdateGRNPO_WOPOGoods");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with Goods already received and without po no can be updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Po without Po with Goods already received");
	}

	@Test
	public void Test204_AddGRNJO_WOPOGoods() throws Exception{
		log.startTestCase("Add GRN against JO without Po with Goods already received");
		extentTest = extent.startTest("Add GRN against JO without Po with Goods already received",
				"Verify if GRN against JO with Goods already received and without po no can be created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(203, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with Goods already received and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with Goods already received and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with Goods already received and without po no can be created test case failed ");
				Constant.captureScreen_Negative("Test204_AddGRNJO_WOPOGoods");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with Goods already received and without po no can be created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO without Po with Goods already received");
	}

	@Test
	public void Test205_UpdateGRNJO_WOPOGoods() throws Exception{
		log.startTestCase("Update GRN against JO without Po with Goods already received");
		extentTest = extent.startTest("Update GRN against JO without Po with Goods already received",
				"Verify if GRN against JO with Goods already received and without po no can be updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(204, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with Goods already received and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with Goods already received and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with Goods already received and without po no can be updated test case failed ");
				Constant.captureScreen_Negative("Test205_UpdateGRNJO_WOPOGoods");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with Goods already received and without po no can be updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO without Po with Goods already received");
	}

	@Test
	public void Test206_AddGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Add GRN against Po with and without Po with invoice toggle");
		extentTest = extent.startTest("Add GRN against Po with and without Po with invoice toggle",
				"Verify if GRN against Po with invoice toggle and with and without po no can be created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(205, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and with and  without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and with and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and with and without po no can be created test case failed ");
				Constant.captureScreen_Negative("Test206_AddGRNPO_WNWOPOInvoice");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with invoice toggle and with and without po no can be created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po with and without Po with invoice toggle");
	}

	@Test
	public void Test207_UpdateGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Update GRN against Po with and without Po with invoice toggle");
		extentTest = extent.startTest("Update GRN against Po with and without Po with invoice toggle",
				"Verify if GRN against Po with invoice toggle and with and without po no can be updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(206, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and with and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and with and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and with and without po no can be updated test case failed ");
				Constant.captureScreen_Negative("Test207_UpdateGRNPO_WNWOPOInvoice");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with invoice toggle and with and without po no can be updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Po with and without Po with invoice toggle");
	}

	@Test
	public void Test208_ApproveGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Approve GRN against Po with and without Po with invoice toggle");
		extentTest = extent.startTest("Approve GRN against Po with and without Po with invoice toggle",
				"Verify if GRN against Po with invoice toggle and with and without po no can be approved");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(207, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and with and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and with and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and with and without po no can be approved test case failed ");
				Constant.captureScreen_Negative("Test208_ApproveGRNPO_WNWOPOInvoice");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with invoice toggle and with and without po no can be approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against Po with and without Po with invoice toggle");
	}

	@Test
	public void Test209_DraftRejectGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Draft Reject GRN against Po with and without Po with invoice toggle");
		extentTest = extent.startTest("Draft Reject GRN against Po with and without Po with invoice toggle",
				"Verify if GRN against Po with invoice toggle and with and without po no can be rejected in draft status");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.validateDraftRejectGRN(208, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and with and without po no can be rejected in draft status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and with and without po no can be rejected in draft status test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and with and without po no can be rejected in draft status test case failed ");
				Constant.captureScreen_Negative("Test209_DraftRejectGRNPO_WNWOPOInvoice");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with invoice toggle and with and without po no can be rejected in draft status test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Draft Reject GRN against Po with and without Po with invoice toggle");
	}

	@Test
	public void Test210_RejectApprovedGRNPO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Reject Approved GRN against Po with and without Po with invoice toggle");
		extentTest = extent.startTest("Reject Approved GRN against Po with and without Po with invoice toggle",
				"Verify if GRN against Po with invoice toggle and with and without po no can be rejected in approved status");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.vaildateRejectApprovedGRN(209, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with invoice toggle and with and without po no can be rejected in approved status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with invoice toggle and with and without po no can be rejected in approved status test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with invoice toggle and with and without po no can be rejected in approved status test case failed ");
				Constant.captureScreen_Negative("Test210_RejectApprovedGRNPO_WNWOPOInvoice");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with invoice toggle and with and without po no can be rejected in approved status test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved GRN against Po with and without Po with invoice toggle");
	}

	@Test
	public void Test211_AddGRNJO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Add GRN against JO with and without Po with invoice toggle");
		extentTest = extent.startTest("Add GRN against JO with and without Po with invoice toggle",
				"Verify if GRN against JO with invoice toggle and with and without po no can be created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(210, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and with and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and with and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and with and without po no can be created test case failed ");
				Constant.captureScreen_Negative("Test211_AddGRNJO_WNWOPOInvoice");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with invoice toggle and with and without po no can be created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO with and without Po with invoice toggle");
	}

	@Test
	public void Test212_UpdateGRNJO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Update GRN against JO with and without Po with invoice toggle");
		extentTest = extent.startTest("Update GRN against JO with and without Po with invoice toggle",
				"Verify if GRN against JO with invoice toggle and with and without po no can be updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(211, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and with and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and with and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and with and without po no can be updated test case failed ");
				Constant.captureScreen_Negative("Test212_UpdateGRNJO_WNWOPOInvoice");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with invoice toggle and with and without po no can be updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO with and without Po with invoice toggle");
	}

	@Test
	public void Test213_ApproveGRNJO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Approve GRN against JO with and without Po with invoice toggle");
		extentTest = extent.startTest("Approve GRN against JO with and without Po with invoice toggle",
				"Verify if GRN against JO with invoice toggle and with and without po no can be approved");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(212, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and with and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and with and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and with and without po no can be approved test case failed ");
				Constant.captureScreen_Negative("Test213_ApproveGRNJO_WNWOPOInvoice");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with invoice toggle and with and without po no can be approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against JO with and without Po with invoice toggle");
	}

	@Test
	public void Test214_DraftRejectGRNJO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Draft Reject GRN against JO with and without Po with invoice toggle");
		extentTest = extent.startTest("Draft Reject GRN against JO with and without Po with invoice toggle",
				"Verify if GRN against JO with invoice toggle and with and without po no can be rejected in draft status");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.validateDraftRejectGRN(213, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and with and without po no can be rejected in draft status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and with and without po no can be rejected in draft status test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and with and without po no can be rejected in draft status test case failed ");
				Constant.captureScreen_Negative("Test214_DraftRejectGRNJO_WNWOPOInvoice");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with invoice toggle and with and without po no can be rejected in draft status test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Draft Reject GRN against JO with and without Po with invoice toggle");
	}

	@Test
	public void Test215_RejectApprovedGRNJO_WNWOPOInvoice() throws Exception{
		log.startTestCase("Reject Approved GRN against JO with and without Po with invoice toggle");
		extentTest = extent.startTest("Reject Approved GRN against JO with and without Po with invoice toggle",
				"Verify if GRN against JO with invoice toggle and with and without po no can be rejected in approved status");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.vaildateRejectApprovedGRN(214, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with invoice toggle and with and without po no can be rejected in approved status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with invoice toggle and with and without po no can be rejected in approved status test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with invoice toggle and with and without po no can be rejected in approved status test case failed ");
				Constant.captureScreen_Negative("Test215_RejectApprovedGRNJO_WNWOPOInvoice");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with invoice toggle and with and without po no can be rejected in approved status test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved GRN against JO with and without Po with invoice toggle");
	}

	@Test
	public void Test216_AddGRNPO_WNWOPODC() throws Exception{
		log.startTestCase("Add GRN against Po with and without Po with DC toggle");
		extentTest = extent.startTest("Add GRN against Po with and without Po with DC toggle",
				"Verify if GRN against Po with DC toggle and with and without po no can be created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(215, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with DC toggle and with and  without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with DC toggle and with and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with DC toggle and with and without po no can be created test case failed ");
				Constant.captureScreen_Negative("Test216_AddGRNPO_WNWOPODC");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with DC toggle and with and without po no can be created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po with and without Po with DC toggle");
	}

	@Test
	public void Test217_UpdateGRNPO_WNWOPODC() throws Exception{
		log.startTestCase("Update GRN against Po with and without Po with DC toggle");
		extentTest = extent.startTest("Update GRN against Po with and without Po with DC toggle",
				"Verify if GRN against Po with DC toggle and with and without po no can be updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(216, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with DC toggle and with and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with DC toggle and with and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with DC toggle and with and without po no can be updated test case failed ");
				Constant.captureScreen_Negative("Test217_UpdateGRNPO_WNWOPODC");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with DC toggle and with and without po no can be updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Po with and without Po with DC toggle");
	}

	@Test
	public void Test218_ApproveGRNPO_WNWOPODC() throws Exception{
		log.startTestCase("Approve GRN against Po with and without Po with DC toggle");
		extentTest = extent.startTest("Approve GRN against Po with and without Po with DC toggle",
				"Verify if GRN against Po with DC toggle and with and without po no can be approved");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(217, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with DC toggle and with and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with DC toggle and with and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with DC toggle and with and without po no can be approved test case failed ");
				Constant.captureScreen_Negative("Test218_ApproveGRNPO_WNWOPODC");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with DC toggle and with and without po no can be approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against Po with and without Po with DC toggle");
	}

	@Test
	public void Test219_AddGRNJO_WNWOPODC() throws Exception{
		log.startTestCase("Add GRN against JO with and without Po with DC toggle");
		extentTest = extent.startTest("Add GRN against JO with and without Po with DC toggle",
				"Verify if GRN against JO with DC toggle and with and without po no can be created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(218, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and with and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and with and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and with and without po no can be created test case failed ");
				Constant.captureScreen_Negative("Test219_AddGRNJO_WNWOPODC");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with DC toggle and with and without po no can be created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO with and without Po with DC toggle");
	}

	@Test
	public void Test220_UpdateGRNJO_WNWOPODC() throws Exception{
		log.startTestCase("Update GRN against JO with and without Po with DC toggle");
		extentTest = extent.startTest("Update GRN against JO with and without Po with DC toggle",
				"Verify if GRN against JO with DC toggle and with and without po no can be updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(219, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and with and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and with and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and with and without po no can be updated test case failed ");
				Constant.captureScreen_Negative("Test220_UpdateGRNJO_WNWOPODC");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with DC toggle and with and without po no can be updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO with and without Po with DC toggle");
	}

	@Test
	public void Test221_ApproveGRNJO_WNWOPODC() throws Exception{
		log.startTestCase("Approve GRN against JO with and without Po with DC toggle");
		extentTest = extent.startTest("Approve GRN against JO with and without Po with DC toggle",
				"Verify if GRN against JO with DC toggle and with and without po no can be approved");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.approveGRN(220, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with DC toggle and with and without po no can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with DC toggle and with and without po no can be approved test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with DC toggle and with and without po no can be approved test case failed ");
				Constant.captureScreen_Negative("Test221_ApproveGRNJO_WNWOPODC");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with DC toggle and with and without po no can be approved test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN against JO with and without Po with DC toggle");
	}

	@Test
	public void Test222_AddGRNPO_WNWOPOGoods() throws Exception{
		log.startTestCase("Add GRN against Po with and without Po with Goods toggle");
		extentTest = extent.startTest("Add GRN against Po with and without Po with Goods toggle",
				"Verify if GRN against Po with Goods toggle and with and without po no can be created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(221, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with Goods toggle and with and  without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with Goods toggle and with and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with Goods toggle and with and without po no can be created test case failed ");
				Constant.captureScreen_Negative("Test222_AddGRNPO_WNWOPOGoods");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with Goods toggle and with and without po no can be created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against Po with and without Po with Goods toggle");
	}

	@Test
	public void Test223_UpdateGRNPO_WNWOPOGoods() throws Exception{
		log.startTestCase("Update GRN against Po with and without Po with Goods toggle");
		extentTest = extent.startTest("Update GRN against Po with and without Po with Goods toggle",
				"Verify if GRN against Po with Goods toggle and with and without po no can be updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(222, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against Po with Goods toggle and with and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against Po with Goods toggle and with and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against Po with Goods toggle and with and without po no can be updated test case failed ");
				Constant.captureScreen_Negative("Test223_UpdateGRNPO_WNWOPOGoods");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against Po with Goods toggle and with and without po no can be updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against Po with and without Po with Goods toggle");
	}

	@Test
	public void Test224_AddGRNJO_WNWOPOGoods() throws Exception{
		log.startTestCase("Add GRN against JO with and without Po with Goods toggle");
		extentTest = extent.startTest("Add GRN against JO with and without Po with Goods toggle",
				"Verify if GRN against JO with Goods toggle and with and without po no can be created");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addGRN(223, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with Goods toggle and with and without po no can be created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with Goods toggle and with and without po no can be created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with Goods toggle and with and without po no can be created test case failed ");
				Constant.captureScreen_Negative("Test224_AddGRNJO_WNWOPOGoods");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with Goods toggle and with and without po no can be created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO with and without Po with Goods toggle");
	}

	@Test
	public void Test225_UpdateGRNJO_WNWOPOGoods() throws Exception{
		log.startTestCase("Update GRN against JO with and without Po with Goods toggle");
		extentTest = extent.startTest("Update GRN against JO with and without Po with Goods toggle",
				"Verify if GRN against JO with Goods toggle and with and without po no can be updated");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.updateGRN(224, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO with Goods toggle and with and without po no can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO with Goods toggle and with and without po no can be updated test case is successful");
			}else{
				System.err.println("Verify if GRN against JO with Goods toggle and with and without po no can be updated test case failed ");
				Constant.captureScreen_Negative("Test225_UpdateGRNJO_WNWOPOGoods");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO with Goods toggle and with and without po no can be updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update GRN against JO with and without Po with Goods toggle");
	}

	@Test
	public void Test226_ValidateItemsInovicedPopup() throws Exception{
		log.startTestCase("Items invoiced popup");
		extentTest = extent.startTest("Items invoiced popup",
				"Verify if items invoiced pop up displayed GRN details");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.verifyItemsInvoiced_Draft(225, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if items invoiced pop up displayed GRN details test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced pop up displayed GRN details test case is successful");
			}else{
				System.err.println("Verify if items invoiced pop up displayed GRN details test case failed ");
				Constant.captureScreen_Negative("Test226_ValidateItemsInovicedPopup");
				extentTest.log(LogStatus.FAIL, "Verify if items invoiced pop up displayed GRN details test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced popup");
	}

	@Test
	public void Test227_AddSalesReturn_Dctoggle() throws Exception{
		log.startTestCase("Sales return addition with Dc toggle");
		extentTest = extent.startTest("Sales return addition",
				"Verify if sales return can be added");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.addGRN(226,"Sanity Test",null);
			if(flag){
				Constant.log.info("Sales return addtion with Dc toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return addtion with Dc toggle test case is successful");
			}else{
				System.err.println("Sales return addtion with Dc toggle test case failed ");
				Constant.captureScreen_Negative("Test227_AddSalesReturn_Dctoggle");
				extentTest.log(LogStatus.FAIL, "Sales return addtion with Dc toggle test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return addition with Dc toggle");
	}

	@Test
	public void Test228_UpdateSalesReturn_DcToggle() throws Exception{
		log.startTestCase("Sales return Update with Dc toggle");
		extentTest = extent.startTest("Sales return Update with Dc toggle",
				"Verify if sales return with Dc toggle can be Update");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.updateGRN(227,"Sanity Test", null);
			if(flag){
				Constant.log.info("Sales return with Dc toggle Update test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return with Dc toggle Update test case is successful");
			}else{
				System.err.println("Sales return with Dc toggle Update test case failed ");
				Constant.captureScreen_Negative("Test228_UpdateSalesReturn_DcToggle");
				extentTest.log(LogStatus.FAIL, "Sales return with Dc toggle Update test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return with Dc toggle Update");
	}

	@Test
	public void Test229_ApproveSalesReturn_DcToggle() throws Exception{
		log.startTestCase("Sales return with Dc toggle Approve");
		extentTest = extent.startTest("Sales return with Dc toggle Approve",
				"Verify if sales return with Dc toggle can be Approve");
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
				Constant.captureScreen_Negative("Test229_ApproveSalesReturn_DcToggle");
				extentTest.log(LogStatus.FAIL, "Sales return with Dc toggle Approve test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return with Dc toggle Approve");
	}

	@Test
	public void Test230_AddSalesReturn_goods() throws Exception{
		log.startTestCase("Sales return addition with Goods Received");
		extentTest = extent.startTest("Sales return addition",
				"Verify if sales return can be added");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = store.addGRN(229,"Sanity Test",null);
			if(flag){
				Constant.log.info("Sales return addtion with Goods Received test case is successful");
				extentTest.log(LogStatus.PASS, "Sales return addtion with Goods Received test case is successful");
			}else{
				System.err.println("Sales return addtion with Goods Received test case failed ");
				Constant.captureScreen_Negative("Test227_AddSalesReturn_Dctoggle");
				extentTest.log(LogStatus.FAIL, "Sales return addtion with Goods Received test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return addition with Goods Received");
	}

	@Test
	public void Test231_UpdateSalesReturn_goods() throws Exception{
		log.startTestCase("Sales return Update with Goods Received");
		extentTest = extent.startTest("Sales return Update with Goods Received",
				"Verify if sales return with Goods Received can be Update");
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
				Constant.captureScreen_Negative("Test228_UpdateSalesReturn_DcToggle");
				extentTest.log(LogStatus.FAIL, "Sales return with Goods Received Update test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales return with Goods Received Update");
	}

	@Test
	public void Test232_AddJobInGRN_OA() throws Exception{
		log.startTestCase("Job in GRN addition with OA");
		extentTest = extent.startTest("Job in GRN addition with OA",
				"Verify if grn against job in is added with oa");
		try{
			boolean flag = store.addGRN(231,"Sanity Test", null);
			if(flag){
				Constant.log.info("Job in GRN addition with OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN addition with OA test case is successful");
			}else{
				System.err.println("Job in GRN addition with OA test case failed ");
				Constant.captureScreen_Negative("Test232_AddJobInGRN_OA");
				extentTest.log(LogStatus.FAIL, "Job in GRN addition with OA test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN addition with OA");
	}

	@Test
	public void Test233_AddJobInGRN_WOOA() throws Exception{
		log.startTestCase("Job in GRN addition without OA");
		extentTest = extent.startTest("Job in GRN addition without OA",
				"Verify if grn against job in is added without oa");
		try{
			boolean flag = store.addGRN(232,"Sanity Test", null);
			if(flag){
				Constant.log.info("Job in GRN addition without OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN addition without OA test case is successful");
			}else{
				System.err.println("Job in GRN addition without OA test case failed ");
				Constant.captureScreen_Negative("Test233_AddJobInGRN_WOOA");
				extentTest.log(LogStatus.FAIL, "Job in GRN addition without OA test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN addition without OA");
	}

	@Test
	public void Test234_UpdateJobInGRN_WOOA() throws Exception{
		log.startTestCase("Job in GRN update without OA");
		extentTest = extent.startTest("Job in GRN update without OA",
				"Verify if grn against job in is updated without oa");
		try{
			boolean flag = store.updateGRN(233,"Sanity Test", null);
			if(flag){
				Constant.log.info("Job in GRN updated without OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN updated without OA test case is successful");
			}else{
				System.err.println("Job in GRN updated without OA test case failed ");
				Constant.captureScreen_Negative("Test234_UpdateJobInGRN_WOOA");
				extentTest.log(LogStatus.FAIL, "Job in GRN updated without OA test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN updated without OA");
	}

	@Test
	public void Test235_ApproveJobInGRN_WOOA() throws Exception{
		log.startTestCase("Job in GRN Approve without OA");
		extentTest = extent.startTest("Job in GRN Approve without OA",
				"Verify if grn against job in is Approved without oa");
		try{
			boolean flag = store.approveGRN(234,"Sanity Test", null);
			if(flag){
				Constant.log.info("Job in GRN Approved without OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN Approved without OA test case is successful");
			}else{
				System.err.println("Job in GRN Approved without OA test case failed ");
				Constant.captureScreen_Negative("Test234_UpdateJobInGRN_WOOA");
				extentTest.log(LogStatus.FAIL, "Job in GRN Approved without OA test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN Approved without OA");
	}

	@Test
	public void Test236_AutoCreatedOA_GRNJobin() throws Exception{
		log.startTestCase("Auto Created OA GRN JOb in");
		extentTest = extent.startTest("Auto Created OA GRN JOb in",
				"Verify if job in Return DC is created");
		boolean flag = false;
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			int sOAList = sales.oaList.size();
			if(store.addGRN(235,"Sanity Test", null)){
				int grnActCount = store.grnList.size();
				String sOANo = Constant.driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+grnActCount+"]/td[text()='"+grnActCount+".']/following::td[4]/span")).getText();
				navigate.navigateToSales();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToOA();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				int sOAActualList = sales.oaList.size();
				sOANo = sOANo.substring(0, 7)+sOANo.substring(9,10);
				JavascriptExecutor js = ((JavascriptExecutor) Constant.driver);
				js.executeScript("arguments[0].scrollIntoView(true);",Constant.driver.findElement(By.xpath(".//tr["+sOAActualList+"]/td[2]/form[@id='oa_edit']/a[contains(text(),'"+sOANo+"')]")));
				Thread.sleep(Constant.Min_Sleep);
				if(sOAActualList > sOAList && Constant.driver.findElement(By.xpath(".//tr["+sOAActualList+"]/td[2]/form[@id='oa_edit']/a[contains(text(),'"+sOANo+"')]")).isDisplayed()){
					flag = true;
				}
				if(flag){
					Constant.log.info("OA auto created from GRN Job in test case is successful");
					extentTest.log(LogStatus.PASS, "OA auto created from GRN Job in test case is successful");
				}else{
					System.err.println("OA auto created from GRN Job in test case failed ");
					Constant.captureScreen_Negative("Test236_AutoCreatedOA_GRNJobin");
					extentTest.log(LogStatus.FAIL, "OA auto created from GRN Job in test case failed");
				}
				Assert.assertTrue(flag);
			}
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Auto Created OA GRN JOb in");
	}

	@Test
	public void Test237_AddJobInReturnDC() throws Exception{
		log.startTestCase("Job in Return DC");
		extentTest = extent.startTest("Job in Return DC",
				"Verify if job in Return DC is created");
		try{
			boolean flag = sales.addInvoice(235, "Sanity Test", null);
			if(flag){
				Constant.log.info("Job in Return DC created test case is successful");
				extentTest.log(LogStatus.PASS, "Job in Return DC created test case is successful");
			}else{
				System.err.println("Job in Return DC created test case failed ");
				Constant.captureScreen_Negative("Test236_AddJobInReturnDC");
				extentTest.log(LogStatus.FAIL, "Job in Return DC created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in eturn DC");
	}

	@Test
	public void Test238_UpdateJobInReturn() throws Exception{
		log.startTestCase("Update Job in Return");
		extentTest = extent.startTest("Update Job in Return",
				"Verify if job in Return DC is updated");
		try{
			sales.addInvoice(236, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(236, "Sanity Test");
			if(flag){
				Constant.log.info("Job in Return DC updated test case is successful");
				extentTest.log(LogStatus.PASS, "Job in Return DC updated test case is successful");
			}else{
				System.err.println("Job in Return DC updated test case failed ");
				Constant.captureScreen_Negative("Test237_UpdateJobInReturn");
				extentTest.log(LogStatus.FAIL, "Job in Return DC updated test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Job in Return");
	}

	public void Test239_JobInReportColValid() throws Exception{
		log.startTestCase("Job In report column validation ");
		extentTest = extent.startTest("Job In report column validation",
				"Verify Job In report columns");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToJobInReport();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.JobInOutReportColValid(237,"Sanity Test");
			if(flag){
				Constant.log.info("Job In report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Job In report column validation test case is successful");
			}else{
				System.err.println("Job In report column validation test case failed ");
				Constant.captureScreen_Negative("Job In report column validation");
				extentTest.log(LogStatus.FAIL, "Job In report column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job In report column validation");
	}

	public void Test240_JobOutReportColValid() throws Exception{
		log.startTestCase("Job Out report column validation ");
		extentTest = extent.startTest("Job Out report column validation",
				"Verify Job In report columns");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToJobOutReport();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.JobInOutReportColValid(238,"Sanity Test");
			if(flag){
				Constant.log.info("Job Out report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Job Out report column validation test case is successful");
			}else{
				System.err.println("Job Out report column validation test case failed ");
				Constant.captureScreen_Negative("Job Out report column validation");
				extentTest.log(LogStatus.FAIL, "Job Out report column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job Out report column validation");
	}

	@Test
	public void Test241_AddSe() throws Exception{
		log.startTestCase("Add SE");
		extentTest = extent.startTest("Add SE",
				"Verify if SE is added");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addSe(239,"Sanity Test");
			if(flag){
				Constant.log.info("Add SE test case is successful");
				extentTest.log(LogStatus.PASS, "Add SE test case is successful");
			}else{
				System.err.println("Add SE test case failed ");
				Constant.captureScreen_Negative("Test240_AddSe");
				extentTest.log(LogStatus.FAIL, "Add SE test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add SE");
	}

	@Test
	public void Test242_UpdateSe() throws Exception{
		log.startTestCase("Add SE");
		extentTest = extent.startTest("Add SE",
				"Verify if SE is added");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.updateSE(241,"Sanity Test");
			if(flag){
				Constant.log.info("Add SE test case is successful");
				extentTest.log(LogStatus.PASS, "Add SE test case is successful");
			}else{
				System.err.println("Add SE test case failed ");
				Constant.captureScreen_Negative("Test240_AddSe");
				extentTest.log(LogStatus.FAIL, "Add SE test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add SE");
	}

	@Test
	public void Test243_ReviewSe() throws Exception{
		log.startTestCase("Review SE");
		extentTest = extent.startTest("Review SE",
				"Verify if SE is Reviewed");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.reviewSE(242,"Sanity Test");
			if(flag){
				Constant.log.info("Review SE test case is successful");
				extentTest.log(LogStatus.PASS, "Review SE test case is successful");
			}else{
				System.err.println("Review SE test case failed ");
				Constant.captureScreen_Negative("Test243_ReviewSe");
				extentTest.log(LogStatus.FAIL, "Review SE test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Review SE");
	}

	@Test
	public void Test244_ReSubmitSe() throws Exception{
		log.startTestCase("ReSubmit SE");
		extentTest = extent.startTest("ReSubmit SE",
				"Verify if SE is ReSubmited");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.resubmitSE_AddMat(243,"Sanity Test");
			if(flag){
				Constant.log.info("ReSubmit SE test case is successful");
				extentTest.log(LogStatus.PASS, "ReSubmit SE test case is successful");
			}else{
				System.err.println("ReSubmit SE test case failed ");
				Constant.captureScreen_Negative("Test243_ReSubmitSe");
				extentTest.log(LogStatus.FAIL, "ReSubmit SE test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("ReSubmit SE");
	}

	@Test
	public void Test245_ApproveSe() throws Exception{
		log.startTestCase("Approve SE");
		extentTest = extent.startTest("Approve SE",
				"Verify if SE is Approveed");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.approveSE(244,"Sanity Test");
			if(flag){
				Constant.log.info("Approve SE test case is successful");
				extentTest.log(LogStatus.PASS, "Approve SE test case is successful");
			}else{
				System.err.println("Approve SE test case failed ");
				Constant.captureScreen_Negative("Test243_ApproveSe");
				extentTest.log(LogStatus.FAIL, "Approve SE test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve SE");
	}

	@Test
	public void Test246_RejectDraftSe() throws Exception{
		log.startTestCase("Reject Draft SE");
		extentTest = extent.startTest("Reject Draft SE",
				"Verify if SE is Reject Drafted");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.rejectDraftSE(245,"Sanity Test");
			if(flag){
				Constant.log.info("Reject Draft SE test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Draft SE test case is successful");
			}else{
				System.err.println("Reject Draft SE test case failed ");
				Constant.captureScreen_Negative("Test243_Reject DraftSe");
				extentTest.log(LogStatus.FAIL, "Reject Draft SE test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft SE");
	}

	@Test
	public void Test247_RejectApprovedSe() throws Exception{
		log.startTestCase("Reject Approved SE");
		extentTest = extent.startTest("Reject Approved SE",
				"Verify if SE is Reject Approveded");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.rejectApprovedSE(246,"Sanity Test");
			if(flag){
				Constant.log.info("Reject Approved SE test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Approved SE test case is successful");
			}else{
				System.err.println("Reject Approved SE test case failed ");
				Constant.captureScreen_Negative("Test247_RejectApprovedSe");
				extentTest.log(LogStatus.FAIL, "Reject Approved SE test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved SE");
	}

	@Test
	public void Test248_ClientApproveSe() throws Exception{
		log.startTestCase("Client approve SE");
		extentTest = extent.startTest("Client approve SE",
				"Verify if SE is Client approveed");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.ClientApproveSE(247,"Sanity Test");
			if(flag){
				Constant.log.info("Client approve SE test case is successful");
				extentTest.log(LogStatus.PASS, "Client approve SE test case is successful");
			}else{
				System.err.println("Client approve SE test case failed ");
				Constant.captureScreen_Negative("Test248_ClientApproveSe");
				extentTest.log(LogStatus.FAIL, "Client approve SE test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Client approve SE");
	}

	@Test
	public void Test249_ClientRejectSe() throws Exception{
		log.startTestCase("Client Reject SE");
		extentTest = extent.startTest("Client Reject SE",
				"Verify if SE is Client Rejected");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.ClientRejectSE(248,"Sanity Test");
			if(flag){
				Constant.log.info("Client Reject SE test case is successful");
				extentTest.log(LogStatus.PASS, "Client Reject SE test case is successful");
			}else{
				System.err.println("Client Reject SE test case failed ");
				Constant.captureScreen_Negative("Test249_ClientRejectSe");
				extentTest.log(LogStatus.FAIL, "Client Reject SE test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Client Reject SE");
	}

	@Test
	public void Test250_AmendApprovedSe() throws Exception{
		log.startTestCase("Amend Approved SE");
		extentTest = extent.startTest("Amend Approved SE",
				"Verify if SE is Amend Approveded");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.amendClientApprovedSE(249,"Sanity Test");
			if(flag){
				Constant.log.info("Amend Approved SE test case is successful");
				extentTest.log(LogStatus.PASS, "Amend Approved SE test case is successful");
			}else{
				System.err.println("Amend Approved SE test case failed ");
				Constant.captureScreen_Negative("Test250_AmendApprovedSe");
				extentTest.log(LogStatus.FAIL, "Amend Approved SE test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Amend Approved SE");
	}

	@Test
	public void Test251_AmendClientApprovedSe() throws Exception{
		log.startTestCase("Amend Client Approved SE");
		extentTest = extent.startTest("Amend Client Approved SE",
				"Verify if SE is Amend Client  Approved");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.amendClientApprovedSE(250,"Sanity Test");
			if(flag){
				Constant.log.info("Amend Client Approved SE test case is successful");
				extentTest.log(LogStatus.PASS, "Amend Client Approved SE test case is successful");
			}else{
				System.err.println("Amend Client Approved SE test case failed ");
				Constant.captureScreen_Negative("Test251_AmendClientApprovedSe");
				extentTest.log(LogStatus.FAIL, "Amend Client Approved SE test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Amend Client Approved SE");
	}

	@Test
	public void Test252_InternalStockFlowReportColValid() throws Exception{
		log.startTestCase("Internal Stock flow report column validation ");
		extentTest = extent.startTest("Internal Stock flow report column validation",
				"Verify Job In report columns");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInternalStockFlowReport();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.InternalStockFlowColValid(251,"Sanity Test");
			if(flag){
				Constant.log.info("Internal Stock flow report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Internal Stock flow report column validation test case is successful");
			}else{
				System.err.println("Internal Stock flow report column validation test case failed ");
				Constant.captureScreen_Negative("Internal Stock flow report column validation");
				extentTest.log(LogStatus.FAIL, "Internal Stock flow report column validation test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Internal Stock flow report column validation");
	}

	@Test
	public void Test253_AddIndent_AltUnit() throws Exception{
		log.startTestCase("Add Indent with alternate unit");
		extentTest = extent.startTest("Add Indent with alternate unit",
				"Verify if indent is added with alternate unit");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.verifyAddIndent(252,"Sanity Test");
			if(flag){
				Constant.log.info("Add Indent with alternate unit test case is successful");
				extentTest.log(LogStatus.PASS, "Add Indent with alternate unit test case is successful");
			}else{
				System.err.println("Add Indent with alternate unit test case failed ");
				Constant.captureScreen_Negative("Test058_AddStockIndent");
				extentTest.log(LogStatus.FAIL, "Add Indent with alternate unit test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Indent with alternate unit");
	}

	@Test
	public void Test254_addNonStockMaterial() throws Exception{
		log.startTestCase("Add Non stock Material");
		extentTest = extent.startTest("Add Non stock Material",
				"Verify if Non stock material is added");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.addMaterial(253,"Sanity Test");
			if(flag){
				Constant.log.info("Supplier price removed test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price removed test case is successful");
			}else{
				System.err.println("Supplier price removed test case failed ");
				Constant.captureScreen_Negative("Add Non stock Material");
				extentTest.log(LogStatus.FAIL, "Supplier price removed test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Add Non stock Material");
	}

	@Test
	public void Test255_AddGRNWOPODC_NonStock() throws Exception{
		log.startTestCase("Add GRN DC without Po having only Non stock material");
		extentTest = extent.startTest("Add GRN DC without Po having only Non stock material",
				"Verify if GRN DC without po no can be created with only Non stock material");
		try{
			boolean flag = store.addGRN(254, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN DC without po no can be created with only Non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN DC without po no can be created with only Non stock material test case is successful");
			}else{
				System.err.println("Verify if GRN DC without po no can be created with only Non stock material test case failed ");
				Constant.captureScreen_Negative("Test256_AddGRNWOPODC_NonStock");
				extentTest.log(LogStatus.FAIL, "Verify if GRN DC without po no can be created with only Non stock material test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN DC without Po having only Non stock material");
	}

	@Test
	public void Test256_AddGRNJOWOPOInvoice_NonStock() throws Exception{
		log.startTestCase("Add GRN against JO without Po with Invoice toggle and non stock material");
		extentTest = extent.startTest("Add GRN against JO without Po with Invoice toggle and non stock material",
				"Verify if GRN against JO without po and with invoice and non stock material is created");
		try{
			boolean flag = store.addGRN(255, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN against JO without po and with invoice and non stock material is created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN against JO without po and with invoice and non stock material is created test case is successful");
			}else{
				System.err.println("Verify if GRN against JO without po and with invoice and non stock material is created test case failed ");
				Constant.captureScreen_Negative("Test007_AddGRNJO_WPOInvoice");
				extentTest.log(LogStatus.FAIL, "Verify if GRN against JO without po and with invoice and non stock material is created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN against JO without Po with Invoice toggle and non stock material");
	}

	@Test
	public void Test257_AddOthersGRN_NonStock() throws Exception{
		log.startTestCase("Add Others GRN with non stock");
		extentTest = extent.startTest("Add Others GRN with non stock",
				"Verify if Others GRN with non stock is added");
		try{
			boolean flag = store.addGRN(256, "Sanity Test",null);
			if(flag){
				Constant.log.info("Others GRN with non stock addition is successful");
				extentTest.log(LogStatus.PASS, "Others GRN with non stock addition is successful");
			}else{
				System.err.println("Others GRN with non stock addition failed ");
				Constant.captureScreen_Negative("Test257_AddOthersGRN_NonStock");
				extentTest.log(LogStatus.FAIL, "Others GRN with non stock addition failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Others GRN with non stock");
	}

	@Test
	public void Test258_AddIssueGRNWithNonStock() throws Exception{
		log.startTestCase("Add Issue GRN with Non Stock");
		extentTest = extent.startTest("Add Issue GRN with Non Stock",
				"Verify if Issue GRN is added with Non Stock");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(257, "Sanity Test",null);
			if(flag){
				Constant.log.info("Issue GRN addition with Non Stock is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with single Non Stock is successful");
			}else{
				System.err.println("Issue GRN addition with Non Stock failed ");
				Constant.captureScreen_Negative("Add Issue GRN with single issue no");
				extentTest.log(LogStatus.FAIL, "Issue GRN addition with Non Stock failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with Non Stock");
	}

	@Test
	public void Test259_AddIssueWithNonStock() throws Exception{
		log.startTestCase("Add Issue with NonStock");
		extentTest = extent.startTest("Add Issue with NonStock",
				"Verify if issue is added with material having NonStock");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addIssue(258,"Sanity Test");
			if(flag){
				Constant.log.info("Issue Addition having material with NonStock test case is successful");
				extentTest.log(LogStatus.PASS, "Issue Addition having material with NonStock test case is successful");
			}else{
				System.err.println("Issue Addition having material with NonStock test case failed ");
				Constant.captureScreen_Negative("Add Issue with NonStock");
				extentTest.log(LogStatus.FAIL, "Issue Addition having material with NonStock test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue with NonStock");
	}

	@Test
	public void Test260_ApproveGRNWOPODC_NonStock() throws Exception{
		log.startTestCase("Approve GRN DC without Po having only Non stock material");
		extentTest = extent.startTest("Approve GRN DC without Po having only Non stock material",
				"Verify if GRN DC without po no can be approved with only Non stock material");
		try{
			boolean flag = store.approveGRN(259, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if GRN DC without po no can be created with only Non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN DC without po no can be created with only Non stock material test case is successful");
			}else{
				System.err.println("Verify if GRN DC without po no can be created with only Non stock material test case failed ");
				Constant.captureScreen_Negative("Test260_ApproveGRNWOPODC_NonStock");
				extentTest.log(LogStatus.FAIL, "Verify if GRN DC without po no can be created with only Non stock material test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve GRN DC without Po having only Non stock material");
	}

	@Test
	public void Test261_AddGRNWOPOGoods_NonStock() throws Exception{
		log.startTestCase("add GRN Goods without Po having only Non stock material");
		extentTest = extent.startTest("add GRN Goods without Po having only Non stock material",
				"Verify if GRN Goods without po no can be created with only Non stock material");
		try{
			Test260_ApproveGRNWOPODC_NonStock();
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			boolean flag = store.addGRN(260, "Sanity Test", sGRNNo);
			if(flag){
				Constant.log.info("Verify if GRN Goods without po no can be created with only Non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GRN DC without po no can be created with only Non stock material test case is successful");
			}else{
				System.err.println("Verify if GRN Goods without po no can be created with only Non stock material test case failed ");
				Constant.captureScreen_Negative("Test261_AddGRNWOPOGoods_NonStock");
				extentTest.log(LogStatus.FAIL, "Verify if GRN Goods without po no can be created with only Non stock material test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("add GRN Goods without Po having only Non stock material");
	}

	@Test
	public void Test262_addOA_NonStock() throws Exception{
		log.startTestCase("add OA with non stock materials");
		extentTest = extent.startTest("add OA with non stock materials",
				"Verify if OA is added with non stock materials");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addOA(261,"Sanity Test");
			if(flag){
				Constant.log.info("add OA with non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "add OA with non stock materials test case is successful");
			}else{
				System.err.println("add OA with non stock materials test case failed ");
				Constant.captureScreen_Negative("add OA with non stock materials");
				extentTest.log(LogStatus.FAIL, "add OA with non stock materials test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("add OA with non stock materials");
	}

	@Test
	public void Test263_AddSe_NonStock() throws Exception{
		log.startTestCase("Add SE non stock");
		extentTest = extent.startTest("Add SE non stock",
				"Verify if SE is added with non stock");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addSe(262,"Sanity Test");
			if(flag){
				Constant.log.info("Add SE with non stock test case is successful");
				extentTest.log(LogStatus.PASS, "Add SE with non stock test case is successful");
			}else{
				System.err.println("Add SE with non stock test case failed ");
				Constant.captureScreen_Negative("Test241_AddSe");
				extentTest.log(LogStatus.FAIL, "Add SE with non stock test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add SE with non stock");
	}

	@Test
	public void Test264_AddJDCNonStock_PoPopUp() throws Exception{
		log.startTestCase("Add JDC NonStock from po popup");
		extentTest = extent.startTest("Add JDC NonStock from po popup",
				"Verify JDC NonStock added from po popup");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			purchase.ApproveQuickJO(263,"Sanity Test");
			int iPONumber = Integer.parseInt(purchase.poVisibleRecordCount.getText().substring(14).trim());
			String sPONum = Constant.driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPONumber+"]/td[4]/a")).getText();
			boolean flag = sales.addInvoice(263, "Sanity Test", sPONum);
			if(flag){
				Constant.log.info("Verify JDC NonStock added from po popup test case is successful");
				extentTest.log(LogStatus.PASS, "Verify JDC NonStock added from po popup test case is successful");
			}else{
				System.err.println("Verify JDC NonStock added from po popup test case failed ");
				Constant.captureScreen_Negative("Test150_AddJDC_PoPopUp");
				extentTest.log(LogStatus.FAIL, "Verify JDC NonStock added from po popup test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add JDC NonStock from po popup");
	}

	@Test
	public void Test265_AddJobInReturnDC_Nonstock() throws Exception{
		log.startTestCase("Job in Return DC with Non stock");
		extentTest = extent.startTest("Job in Return DC with Non stock",
				"Verify if job in Return DC with Non stock is created");
		try{
			store.approveGRN(264, "Sanity Test", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			boolean flag = sales.addInvoice(264, "Sanity Test", sGRNNo);
			if(flag){
				Constant.log.info("Job in Return DC with Non stock created test case is successful");
				extentTest.log(LogStatus.PASS, "Job in Return DC with Non stock created test case is successful");
			}else{
				System.err.println("Job in Return DC with Non stock created test case failed ");
				Constant.captureScreen_Negative("Test265_AddJobInReturnDC_Nonstock");
				extentTest.log(LogStatus.FAIL, "Job in Return DC with Non stock created test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in eturn DC with Non stock");
	}

	@Test
	public void Test266_AddIndent_NewMaterial() throws Exception{
		log.startTestCase("Add Indent with new material");
		extentTest = extent.startTest("Add Indent with new material",
				"Verify if indent is added with new material");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			int iCount = master.materialCountWithNonStock();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.verifyAddIndent(265,"Sanity Test");
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			int iAfterAddition = master.materialCountWithNonStock();
			if(iAfterAddition > iCount){
				flag = true;
			}
			if(flag){
				Constant.log.info("Add Indent with new material test case is successful");
				extentTest.log(LogStatus.PASS, "Add Indent with new material test case is successful");
			}else{
				System.err.println("Add Indent new material test case failed ");
				Constant.captureScreen_Negative("Test266_AddIndent_NewMaterial");
				extentTest.log(LogStatus.FAIL, "Add Indent new material test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Indent new material");
	}

	@Test
	public void Test267_AddPO_NewMaterial() throws Exception{
		log.startTestCase("Add PO with new material");
		extentTest = extent.startTest("Add PO with new material",
				"Verify if PO is added with new material");
		boolean flag = false;
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			int iCount = master.materialCountWithNonStock();
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			purchase.addQuickPO(266,"Sanity Test");
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			int iAfterAddition = master.materialCountWithNonStock();
			if(iAfterAddition > iCount){
				flag = true;
			}
			if(flag){
				Constant.log.info("Add PO with new material test case is successful");
				extentTest.log(LogStatus.PASS, "Add PO with new material test case is successful");
			}else{
				System.err.println("Add PO with new material test case failed ");
				Constant.captureScreen_Negative("Test266_AddPO_NewMaterial");
				extentTest.log(LogStatus.FAIL, "Add PO with new material test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add PO with new material");
	}

	@Test
	public void Test268_addindentpo_SPQPOpup() throws Exception{
		log.startTestCase("Add Indent po with spq warning");
		extentTest = extent.startTest("Add Indent po with spq warning",
				"Verify if indent po is added with spq warning");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.addindentpo_spq(267,"Sanity Test");
			if(flag){
				Constant.log.info("Add Indent po with spq warning test case is successful");
				extentTest.log(LogStatus.PASS, "Add Indent po with spq warning test case is successful");
			}else{
				System.err.println("Add Indent po with spq warning test case failed ");
				Constant.captureScreen_Negative("Test268_addindentpo_SPQPOpup");
				extentTest.log(LogStatus.FAIL, "Add Indent po with spq warning test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Indent po with spq warning");
	}

	@Test
	public void Test269_AddPO_withSPqWarn() throws Exception{
		log.startTestCase("Add PO with new material");
		extentTest = extent.startTest("Add PO with new material",
				"Verify if PO is added with new material");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.addQuickPO_SPQWarning(268,"Sanity Test");
			if(flag){
				Constant.log.info("Add PO with new material test case is successful");
				extentTest.log(LogStatus.PASS, "Add PO with new material test case is successful");
			}else{
				System.err.println("Add PO with new material test case failed ");
				Constant.captureScreen_Negative("Test266_AddPO_NewMaterial");
				extentTest.log(LogStatus.FAIL, "Add PO with new material test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add PO with new material");
	}

	@Test
	public void Test270_ValidateNotePreview_ShortNRej() throws Exception{
		log.startTestCase("Items invoiced popup when approved grn rejected ");
		extentTest = extent.startTest("Items invoiced popup when approved grn rejected",
				"Verify if items invoiced pop up does not displayed rejected approved GRN details");
		try{
			boolean flag = store.verifyNotePreviewPopup(269, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if items invoiced pop up does not displayed rejected approved GRN detailss test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if items invoiced pop up does not displayed rejected approved GRN details test case is successful");
			}else{
				System.err.println("Verify if items invoiced pop up does not displayed rejected approved GRN details test case failed ");
				Constant.captureScreen_Negative("Test360_ValidateItemsInvoiced_approved");
				extentTest.log(LogStatus.FAIL, "Verify if items invoiced pop up does not displayed rejected approved GRN details test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items invoiced popup when approved grn rejected");
	}

	@Test
	public void Test271_AddOA_PromoteToOA() throws Exception{
		log.startTestCase("Add OA by Promote to OA");
		extentTest = extent.startTest("Add OA by Promote to OA",
				"Verify if OA added by clicking promote to OA");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addOa_PromoteOA(270,"Sanity Test");
			if(flag){
				Constant.log.info("Add OA by Promote to OA test case is successful");
				extentTest.log(LogStatus.PASS, "Add OA by Promote to OA test case is successful");
			}else{
				System.err.println("Add OA by Promote to OA test case failed ");
				Constant.captureScreen_Negative("Test251_AmendClientApprovedSe");
				extentTest.log(LogStatus.FAIL, "Add OA by Promote to OA test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add OA by Promote to OA");
	}

	@Test
	public void Test272_AddInvoice_PromoteToInvoice() throws Exception{
		log.startTestCase("Add Invoice by Promote to Invoice");
		extentTest = extent.startTest("Add Invoice by Promote to Invoice",
				"Verify if Invoice added by clicking promote to Invoice");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addInvoice_PromoteInvoice(271,"Sanity Test");
			if(flag){
				Constant.log.info("Add Invoice by Promote to Invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Add Invoice by Promote to Invoice test case is successful");
			}else{
				System.err.println("Add Invoice by Promote to Invoice test case failed ");
				Constant.captureScreen_Negative("Test251_AmendClientApprovedSe");
				extentTest.log(LogStatus.FAIL, "Add Invoice by Promote to Invoice test case failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Invoice by Promote to Invoice");
	}

	@Test
	public void Test273_ValStockMat_WOAltUnit() throws Exception{
		log.startTestCase("Validate Material stock without alternate unit");
		extentTest = extent.startTest("Validate Material stock without alternate unit",
				"Verify if Supplier price is Resubmited");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			String sStock = master.fetchStock(253,"Sanity Test");
			store.addGRN(253, "Sanity Test", null);
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.validateStockWOMake(253, "Sanity Test", sStock);
			if(flag){
				Constant.log.info("Supplier price removed test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price removed test case is successful");
			}else{
				System.err.println("Supplier price removed test case failed ");
				Constant.captureScreen_Negative("Test254_ValStockMat_WOAltUnit");
				extentTest.log(LogStatus.FAIL, "Supplier price removed test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Validate Material stock without alternate unit");
	}

	@Test
	public void Test274_partyAcknowledgementPendingICD() throws Exception{
		log.startTestCase("Party Acknowledgement pending ICD");
		extentTest = extent.startTest("Party Acknowledgement pending ICD",
				"Verify if ICD is checked");
		try{
			setting.reqAckn_Check();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.checkICD(273, "Sanity Test", null, "GRN");
			if(flag){
				Constant.log.info("Checked ICD for Party acknowledgement pending is successful");
				extentTest.log(LogStatus.PASS, "Checked ICD for Party acknowledgement pending is successful");
			}else{
				System.err.println("Checked ICD for Party acknowledgement pending failed ");
				Constant.captureScreen_Negative("Test274_partyAcknowledgementPendingICD");
				extentTest.log(LogStatus.FAIL, "Checked ICD for Party acknowledgement pending failed");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Party Acknowledgement pending ICD");
	}


	@Test
	public void Test300_ImportAttendace() throws Exception{
		log.startTestCase("Import Attendance");
		extentTest = extent.startTest("Import Attendance",
				"validate Import attendance");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToAttendance();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.importAttendance();
			if(flag){
				Constant.log.info("Import attendance test case is successful");
				extentTest.log(LogStatus.PASS, "Import attendance test case is successful");
			}else{
				System.err.println("Import attendance test case failed ");
				Constant.captureScreen_Negative("Import attendance");
				extentTest.log(LogStatus.FAIL, "Import attendance test case failed ");
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Import attendance");
	}

	@After
	public void After() throws Exception{
		try{
//			Constant.analyzeLog();
			login.logout();
		}catch(Exception e){
			System.err.println("Logout unsuccessfull "+e);
			Constant.captureScreen_Negative("Logout");
		}
	}

	@AfterClass
	public static void AfterClass() throws Exception{
		Constant.closeBrowser();
		extentTest.log(LogStatus.INFO, "Browser closed");
		// close report.
		extent.endTest(extentTest);
		// writing everything to document.
    	extent.flush();
//    	Set<String> keyset = testresultdata.keySet();
//        int rownum = 0;
//        for (String key : keyset) {
//            Row row = sheet.createRow(rownum++);
//            Object [] objArr = testresultdata.get(key);
//            int cellnum = 0;
//            for (Object obj : objArr) {
//                Cell cell = row.createCell(cellnum++);
//                if(obj instanceof Date)
//                    cell.setCellValue((Date)obj);
//                else if(obj instanceof Boolean)
//                    cell.setCellValue((Boolean)obj);
//                else if(obj instanceof String)
//                    cell.setCellValue((String)obj);
//                else if(obj instanceof Double)
//                    cell.setCellValue((Double)obj);
//            }
//        }
//        try {
//            FileOutputStream out =new FileOutputStream(new File("Sanity Test.xls"));
//            workbook.write(out);
//            out.close();
//            System.out.println("Excel written successfully..");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
	}
}
