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
import pages.PurchasePage;
import pages.SettingPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GeneralPOTestcases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	PurchasePage purchase = PageFactory.initElements(Constant.driver, PurchasePage.class);
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
		Constant.logFile("General Purchase");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
		navigate.navigateToPurchase_Header();
		Thread.sleep(Constant.Min_Sleep);
		navigate.navigateToPurchase();
	}

	@Category(SmokeTest.class)
	@Test
	public void Test007_AddPurchase() throws Exception{
		log.startTestCase("Add Purchase");
		extentTest = extent.startTest("Test007_AddPurchase",
				"Verify if Purchase is added").assignCategory("GeneralPOTestcases","SmokeTest");
		try{
			boolean flag = purchase.addPurchase(6, "Sanity Test");
			if(flag){
				Constant.log.info("Purchase Addition test case is successful");
				extentTest.log(LogStatus.PASS, "Purchase Addition test case is successful");
			}else{
				System.err.println("Purchase addition test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test007_AddPurchase")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Purchase");
	}

	@Test @Category(SanityTests.class)
	public void Test008_UpdatePurchase() throws Exception{
		log.startTestCase("Update Purchase");
		extentTest = extent.startTest("Test008_UpdatePurchase",
				"Verify if Purchase is Update").assignCategory("GeneralPOTestcases","SanityTests");
		try{
			boolean flag = purchase.validateUpdatePO(7, "Sanity Test");
			if(flag){
				Constant.log.info("Purchase Update test case is successful");
				extentTest.log(LogStatus.PASS, "Purchase Update test case is successful");
			}else{
				System.err.println("Purchase Update test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test008_UpdatePurchase")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Purchase");
	}

	@Test  @Category(SanityTests.class)
	public void Test009_ApprovePurchase() throws Exception{
		log.startTestCase("Approve Purchase");
		extentTest = extent.startTest("Test009_ApprovePurchase",
				"Verify if Purchase is Approve").assignCategory("GeneralPOTestcases","SanityTests");
		try{
			boolean flag = purchase.validateApprovePO(8, "Sanity Test");
			if(flag){
				Constant.log.info("Purchase Approve test case is successful");
				extentTest.log(LogStatus.PASS, "Purchase Approve test case is successful");
			}else{
				System.err.println("Purchase Approve test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test009_ApprovePurchase")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Purchase");
	}

	@Test  @Category(SanityTests.class)
	public void Test010_RejectApprovedPurchase() throws Exception{
		log.startTestCase("Reject Approved Purchase");
		extentTest = extent.startTest("Test010_RejectApprovedPurchase",
				"Verify if Approved Purchase is Reject").assignCategory("GeneralPOTestcases","SanityTests");
		try{
			boolean flag = purchase.validateRejectApprovedPO(9, "Sanity Test");
			if(flag){
				Constant.log.info("Approved Purchase Reject test case is successful");
				extentTest.log(LogStatus.PASS, "Approved Purchase Reject test case is successful");
			}else{
				System.err.println("Approved Purchase Reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test010_RejectApprovedPurchase")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject Approved Purchase");
	}

	@Test  @Category(SanityTests.class)
	public void Test011_RejectDraftPurchase() throws Exception{
		log.startTestCase("Reject Draft Purchase");
		extentTest = extent.startTest("Test011_RejectDraftPurchase",
				"Verify if Draft Purchase is Reject").assignCategory("GeneralPOTestcases","SanityTests");
		try{
			boolean flag = purchase.validateRejectDraftPO(10, "Sanity Test");
			if(flag){
				Constant.log.info("Draft Purchase Reject test case is successful");
				extentTest.log(LogStatus.PASS, "Draft Purchase Reject test case is successful");
			}else{
				System.err.println("Draft Purchase Reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test011_RejectDraftPurchase")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject Draft Purchase");
	}

	@Test  @Category(SanityTests.class)
	public void Test012_AmendPurchase() throws Exception{
		log.startTestCase("Amend Purchase");
		extentTest = extent.startTest("Test012_AmendPurchase",
				"Verify if Amend purchase order").assignCategory("GeneralPOTestcases","SanityTests");
		try{
			boolean flag = purchase.validateAmendPO(11, "Sanity Test");
			if(flag){
				Constant.log.info("Amend purchase order test case is successful");
				extentTest.log(LogStatus.PASS, "Amend purchase order test case is successful");
			}else{
				System.err.println("Amend purchase order test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test012_AmendPurchase")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend Purchase");
	}
	/*
	@Test
	public void Test001_NonEditableFields() throws Exception{
		log.startTestCase("Non editable fields");
		extentTest = extent.startTest("Non editable fields",
				"Verify non editable fields in PO add page");
		login.login();
		try{
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.nonEditableFields();
			if(flag == true){
				Constant.log.info("Non editable field validation is successful");
				extentTest.log(LogStatus.PASS, "Non editable field validation  is successful");
			}else{
				System.err.println("Non editable field validation failed ");
				Constant.captureScreen_Negative("Non editable fields");
				extentTest.log(LogStatus.FAIL, "Non editable field validation failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Non editable fields");
	}

	@Test
	public void Test003_ValidateDataFromIndent() throws Exception{
		log.startTestCase("Validate Data from indent");
		extentTest = extent.startTest("Validate Data from indent",
				"Verify whether data from indent is displayed");
		login.login();
		try{
			boolean flag = purchase.validateDataFromIndent();
			if(flag == true){
				Constant.log.info("Data from indent is validated successful");
				extentTest.log(LogStatus.PASS, "Data from indent is validated is successful");
			}else{
				System.err.println("Data from indent validation failed ");
				Constant.captureScreen_Negative("Validate Data from indent");
				extentTest.log(LogStatus.FAIL, "Data from indent validation failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate Data from indent");
	}

	@Test
	public void Test004_ValidateSupplierList() throws Exception{
		log.startTestCase("Validate Supplier list");
		extentTest = extent.startTest("Validate Supplier list",
				"Verify whether supplier listed has link with the material");
		login.login();
		try{
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.supplierDrpDwnValidation();
			if(flag == true){
				Constant.log.info("Supplier list validation successful");
				extentTest.log(LogStatus.PASS, "Supplier list validation successful");
			}else{
				System.err.println("Supplier list validation failed ");
				Constant.captureScreen_Negative("Validate Supplier list");
				extentTest.log(LogStatus.FAIL, "Supplier list validation failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate Supplier list");
	}

	@Test
	public void Test005_ValidateBalanceQty() throws Exception{
		log.startTestCase("Validate Indent, Order and Balance qty");
		extentTest = extent.startTest("Validate Indent, Order and Balance qty",
				"Verify Indent, Order and Balance material quantity");
		login.login();
		try{
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.validateIndentOrderBalanceQty();
			if(flag == true){
				Constant.log.info("Indent, Order and Balance material quantity validation successful");
				extentTest.log(LogStatus.PASS, "Indent, Order and Balance material quantity validation successful");
			}else{
				System.err.println("Indent, Order and Balance material quantity validation failed ");
				Constant.captureScreen_Negative("Validate Indent, Order and Balance qty");
				extentTest.log(LogStatus.FAIL, "Indent, Order and Balance material quantity validation failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate Indent, Order and Balance qty");
	}

	@Test
	public void Test006_ValidateApprovedRate() throws Exception{
		log.startTestCase("Validate Approved rate");
		extentTest = extent.startTest("Validate Approved rate",
				"Verify Approved rate displayed for material");
		login.login();
		try{
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.ValidateMaterialRate();
			if(flag == true){
				Constant.log.info("Approved rate displayed for material validation successful");
				extentTest.log(LogStatus.PASS, "Approved rate displayed for material validation successful");
			}else{
				System.err.println("Approved rate displayed for material validation failed ");
				Constant.captureScreen_Negative("Validate Approved rate");
				extentTest.log(LogStatus.FAIL, "Approved rate displayed for material validation failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate Approved rate");
	}

	@Test
	public void Test007_ValidateTaxAddition() throws Exception{
		log.startTestCase("Validate tax addition");
		extentTest = extent.startTest("Validate tax addition",
				"Verify tax addition in PO");
		login.login();
		try{
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.ValidateTaxAddition(6,"Purchase");
			if(flag == true){
				Constant.log.info("Tax addition validation is successful");
				extentTest.log(LogStatus.PASS, "Tax addition validation is successful");
			}else{
				System.err.println("Tax addition validation failed ");
				Constant.captureScreen_Negative("Validate tax addition");
				extentTest.log(LogStatus.FAIL, "Tax addition validation  failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate tax addition");
	}
	*/
	@Test  @Category(SanityTests.class)
	public void Test081_AddJobPO_AddingMaterials() throws Exception{
		log.startTestCase("Add Job Po by adding Materials");
		extentTest = extent.startTest("Test081_AddJobPO_AddingMaterials",
				"validate job po addition by adding materials").assignCategory("GeneralPOTestcases","SanityTests");
		try{
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.addJobPo_Materials(80,"Sanity Test");
			if(flag){
				Constant.log.info("Job PO addition with material addition test case is successful");
				extentTest.log(LogStatus.PASS, "Job PO addition with material addition test case is successful");
			}else{
				System.err.println("Job PO addition with material addition test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test081_AddJobPO_AddingMaterials")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Job Po by adding Materials");
	}

	@Test  @Category(SanityTests.class)
	public void Test082_AddJobPO_Indent() throws Exception{
		log.startTestCase("Add Job Po by adding indent");
		extentTest = extent.startTest("Test082_AddJobPO_Indent",
				"validate job po addition by adding indent").assignCategory("GeneralPOTestcases","SanityTests");
		try{
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.addJobPO_Indent(81,"Sanity Test");
			if(flag){
				Constant.log.info("Job PO addition with indent addition test case is successful");
				extentTest.log(LogStatus.PASS, "Job PO addition with indent addition test case is successful");
			}else{
				System.err.println("Job PO addition with indent addition test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test082_AddJobPO_Indent")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Job Po by adding indent");
	}

	@Test  @Category(SanityTests.class)
	public void Test083_UpdateJobPO() throws Exception{
		log.startTestCase("update job Po");
		extentTest = extent.startTest("Test083_UpdateJobPO",
				"validate job po update").assignCategory("GeneralPOTestcases","SanityTests");
		try{
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.updateJobPO(82,"Sanity Test");
			if(flag){
				Constant.log.info("update job Po test case is successful");
				extentTest.log(LogStatus.PASS, "update job Po test case is successful");
			}else{
				System.err.println("update job Po test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test083_UpdateJobPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("update job Po");
	}

	@Test  @Category(SanityTests.class)
	public void Test084_ApproveJobPO() throws Exception{
		log.startTestCase("Approve job Po");
		extentTest = extent.startTest("Test084_ApproveJobPO",
				"validate job po Approve").assignCategory("GeneralPOTestcases","SanityTests");
		try{
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.validateApproveJobPO(83,"Sanity Test");
			if(flag){
				Constant.log.info("Approve job Po test case is successful");
				extentTest.log(LogStatus.PASS, "Approve job Po test case is successful");
			}else{
				System.err.println("Approve job Po test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test084_ApproveJobPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve job Po");
	}

	@Test  @Category(SanityTests.class)
	public void Test085_RejectApprovedJobPO() throws Exception{
		log.startTestCase("Reject Approved Job Purchase");
		extentTest = extent.startTest("Test085_RejectApprovedJobPO",
				"Verify if Approved Job Purchase is Reject").assignCategory("GeneralPOTestcases","SanityTests");
		try{
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.validateRejectApprovedJobPO(84, "Sanity Test");
			if(flag){
				Constant.log.info("Approved Job Purchase Reject test case is successful");
				extentTest.log(LogStatus.PASS, "Approved Job Purchase Reject test case is successful");
			}else{
				System.err.println("Approved Job Purchase Reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test085_RejectApprovedJobPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject Approved Job Purchase");
	}

	@Test  @Category(SanityTests.class)
	public void Test086_RejectDraftJobPO() throws Exception{
		log.startTestCase("Reject Draft Job Purchase");
		extentTest = extent.startTest("Test086_RejectDraftJobPO",
				"Verify if Draft Job Purchase is Reject");
		try{
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.validateRejectDraftJobPO(85, "Sanity Test");
			if(flag){
				Constant.log.info("Draft Job Purchase Reject test case is successful");
				extentTest.log(LogStatus.PASS, "Draft Job Purchase Reject test case is successful");
			}else{
				System.err.println("Draft Job Purchase Reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test086_RejectDraftJobPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject Draft Job Purchase");
	}

	@Test @Category(SanityTests.class)
	public void Test087_AmendJobPO() throws Exception{
		log.startTestCase("Amend Job PO");
		extentTest = extent.startTest("Test087_AmendJobPO",
				"Verify if Amend Job PO").assignCategory("GeneralPOTestcases","SanityTests");
		try{
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.validateAmendJobPO(86, "Sanity Test");
			if(flag){
				Constant.log.info("Amend Job PO order test case is successful");
				extentTest.log(LogStatus.PASS, "Amend Job PO order test case is successful");
			}else{
				System.err.println("Amend Job PO order test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test087_AmendJobPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend Job PO");
	}

	@Test  @Category(SanityTests.class)
	public void Test297_SavePoprintconfigNoChange() throws Exception{
		log.startTestCase("Save Po print config without Change");
		extentTest = extent.startTest("Test297_SavePoprintconfigNoChange",
				"Verify invoice Po print config saved without change").assignCategory("GeneralPOTestcases","SanityTests");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPoConfig();
			boolean flag = setting.poConfigSave();
			if(flag){
				Constant.log.info("Verify invoice Po print config saved without change test case is successful");
				extentTest.log(LogStatus.PASS, "Verify invoice Po print config saved without change test case is successful");
			}else{
				System.err.println("Save Po print config without Change test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test297_SavePoprintconfigNoChange")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Save Po print config without Change");
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
