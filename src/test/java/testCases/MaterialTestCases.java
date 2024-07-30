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
import pages.ProfilePage;
import pages.SettingPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaterialTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	ProfilePage master = PageFactory.initElements(Constant.driver, ProfilePage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);
	SettingPage setting = PageFactory.initElements(Constant.driver, SettingPage.class);

	static ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	static String extentReportFile;
	static ExtentReports extent;
	static ExtentTest extentTest;


	@BeforeClass
	public static void BeforeClass() throws Exception{
		extentReportFile = property.getExtentReportFile()+"ExtentReport"+Constant.date+"."+"html";
		// Create object of extent report and specify the report file path.
		extent = new ExtentReports(extentReportFile, false);
		Constant.logFile("Material");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Category(SmokeTest.class)
	@Test
	public void Test001_AddMaterial() throws Exception{
		log.startTestCase("AddMaterial");
		extentTest = extent.startTest("Test001_AddMaterial",
				"Verify if material is added").assignCategory("MaterialTestCases","SmokeTest");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.addMaterial(0,"Sanity Test");
			if(flag){
				Constant.log.info("Material addition test case is successful");
				extentTest.log(LogStatus.PASS, "Material addition test case is successful");
			}else{
				System.err.println("Material addition test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test001_AddMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("AddMaterial");
	}

	@Category(SanityTests.class)
	@Test
	public void Test002_UpdateMaterial() throws Exception{
		log.startTestCase("Update Material");
		extentTest = extent.startTest("Test002_UpdateMaterial",
				"Verify if material is updated").assignCategory("MaterialTestCases","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test002_UpdateMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Update Material");
	}

	@Category(SanityTests.class)
	@Test
	public void Test003_DeleteMaterial() throws Exception{
		log.startTestCase("Delete Material");
		extentTest = extent.startTest("Test003_DeleteMaterial",
				"Verify if material is updated").assignCategory("MaterialTestCases","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test003_DeleteMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Delete Material");
	}

	@Test  @Category(SanityTests.class)
	public void Test055_AddBomMaterial() throws Exception{
		log.startTestCase("Add Bom Material");
		extentTest = extent.startTest("Test055_AddBomMaterial",
				"Verify if Bom material is added").assignCategory("MaterialTestCases","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test055_AddBomMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Add Bom Material");
	}

	@Test  @Category(SanityTests.class)
	public void Test056_AddSupplierMaterial() throws Exception{
		log.startTestCase("Add Supplier for Material");
		extentTest = extent.startTest("Test056_AddSupplierMaterial",
				"Verify if Supplier material is added").assignCategory("MaterialTestCases","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test056_AddSupplierMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Add Supplier for Material");
	}

/*
	@Test
	public void test006_ImportMaterial() throws Exception{
		log.startTestCase("Import Material");
		login.login();
		try{
			boolean flag = master.importMaterial();
			if(flag == true){
				Constant.log.info("Import Material test case is successful");
			}else{
				System.err.println("Import Material test case failed ");
				Constant.captureScreen_Negative("Import Material");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Import Material");
	}

	@Test
	public void test007_CancelMaterial() throws Exception{
		log.startTestCase("Cancel Material");
		login.login();
		try{
			boolean flag = master.cancelMaterial(6,"Material");
			if(flag == true){
				Constant.log.info("Cancel Material test case is successful");
			}else{
				System.err.println("Cancel Material test case failed ");
				Constant.captureScreen_Negative("Cancel Material");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Cancel Material");
	}

	@Test
	public void test008_DeleteBOM() throws Exception{
		log.startTestCase("Delete BOM of Material");
		login.login();
		try{
			boolean flag = master.deleteBOM(7,"Material");
			if(flag == true){
				Constant.log.info("Delete BOM of Material test case is successful");
			}else{
				System.err.println("Delete BOM of Material test case failed ");
				Constant.captureScreen_Negative("Delete BOM of Material");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Delete BOM of Material");
	}

	@Test
	public void test009_DeleteSupplier() throws Exception{
		log.startTestCase("Delete Supplier of Material");
		login.login();
		try{
			boolean flag = master.deleteSupplier(8,"Material");
			if(flag == true){
				Constant.log.info("Delete Supplier of Material test case is successful");
			}else{
				System.err.println("Delete Supplier of Material test case failed ");
				Constant.captureScreen_Negative("Delete Supplier of Material");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Delete Supplier of Material");
	}

	@Test
	public void test010_Mandatoryfields() throws Exception{
		log.startTestCase("Mandatory fields of Material");
		login.login();
		try{
			boolean flag = master.materialMandatoryFields(9);
			if(flag == true){
				Constant.log.info("Mandatory fields of Material test case is successful");
			}else{
				System.err.println("Mandatory fields of Material test case failed ");
				Constant.captureScreen_Negative("Mandatory fields of Material");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Mandatory fields of Material");
	}

	@Test
	public void test011_InUse() throws Exception{
		log.startTestCase("Verify in Use checkbox");
		login.login();
		try{
			boolean flag = master.inUse(10);
			if(flag == true){
				Constant.log.info("In Use checkbox verification test case is successful");
			}else{
				System.err.println("In Use checkbox verification test case failed ");
				Constant.captureScreen_Negative("Verify in Use checkbox");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Verify in Use checkbox");
	}
	*/
	@Test  @Category(SanityTests.class)
	public void Test088_UpdateMaterialJobSupplier() throws Exception{
		log.startTestCase("Update Supplier for Material with Job");
		extentTest = extent.startTest("Test088_UpdateMaterialJobSupplier",
				"Verify if Supplier material with Job is Updated").assignCategory("MaterialTestCases","SanityTests");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.updateMaterialSupplierJob();
			if(flag){
				Constant.log.info("Supplier update for material with Job test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier update for material with Job test case is successful");
			}else{
				System.err.println("Supplier update for material with Job test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test088_UpdateMaterialJobSupplier")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("update Supplier for Material with Job");
	}

	@Test  @Category(SanityTests.class)
	public void Test142_SupplierPriceApproval() throws Exception{
		log.startTestCase("Supplier price Approval");
		extentTest = extent.startTest("Test142_SupplierPriceApproval",
				"Verify if Supplier price is approved").assignCategory("MaterialTestCases","SanityTests");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.approveSupplierPrice(141,"Sanity Test");
			if(flag){
				Constant.log.info("Supplier price approved test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price approved test case is successful");
			}else{
				System.err.println("Supplier price approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test142_SupplierPriceApproval")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Supplier price Approval");
	}

	@Test  @Category(SanityTests.class)
	public void Test143_SupplierPriceReject() throws Exception{
		log.startTestCase("Supplier price Reject");
		extentTest = extent.startTest("Test143_SupplierPriceReject",
				"Verify if Supplier price is Rejected").assignCategory("MaterialTestCases","SanityTests");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.rejectSupplierPrice(142,"Sanity Test");
			if(flag){
				Constant.log.info("Supplier price Rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price Rejected test case is successful");
			}else{
				System.err.println("Supplier price Rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test142_SupplierPriceApproval")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Supplier price Reject");
	}

	@Test  @Category(SanityTests.class)
	public void Test144_SupplierPriceResubmit() throws Exception{
		log.startTestCase("Supplier price Resubmit");
		extentTest = extent.startTest("Test144_SupplierPriceResubmit",
				"Verify if Supplier price is Resubmited").assignCategory("MaterialTestCases","SanityTests");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.resubmitSupplierPrice(143,"Sanity Test");
			if(flag){
				Constant.log.info("Supplier price Resubmited test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price Resubmited test case is successful");
			}else{
				System.err.println("Supplier price Resubmited test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test144_SupplierPriceResubmit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Supplier price Resubmit");
	}

	@Test  @Category(SanityTests.class)
	public void Test145_SupplierPriceRemove() throws Exception{
		log.startTestCase("Supplier price Remove");
		extentTest = extent.startTest("Test145_SupplierPriceRemove",
				"Verify if Supplier price is Resubmited").assignCategory("MaterialTestCases","SanityTests");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.removeSupplierPrice(144,"Sanity Test");
			if(flag){
				Constant.log.info("Supplier price removed test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price removed test case is successful");
			}else{
				System.err.println("Supplier price removed test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test145_SupplierPriceRemove")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Supplier price Remove");
	}

	@Test  @Category(SanityTests.class)
	public void Test254_addNonStockMaterial() throws Exception{
		log.startTestCase("Add Non stock Material");
		extentTest = extent.startTest("Test254_addNonStockMaterial",
				"Verify if Non stock material is added").assignCategory("MaterialTestCases","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test254_addNonStockMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Add Non stock Material");
	}

	@Test  @Category(SanityTests.class)
	public void Test273_ValStockMat_WOAltUnit() throws Exception{
		log.startTestCase("Validate Material stock without alternate unit");
		extentTest = extent.startTest("Test273_ValStockMat_WOAltUnit",
				"Verify if Supplier price is Resubmited").assignCategory("MaterialTestCases","SanityTests");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			setting.purchaseMandatoryChkBx_UnCheck();
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			String sStock = master.fetchStock(272,"Sanity Test");
			store.addGRN(272, "Sanity Test", null);
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.validateStockWOMake(272, "Sanity Test", sStock);
			if(flag){
				Constant.log.info("Supplier price removed test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price removed test case is successful");
			}else{
				System.err.println("Supplier price removed test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test273_ValStockMat_WOAltUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Validate Material stock without alternate unit");
	}

	@Test  @Category(SanityTests.class)
	public void Test293_ValStockMat_WAltUnit() throws Exception{
		log.startTestCase("Validate Material stock without alternate unit");
		extentTest = extent.startTest("Test293_ValStockMat_WAltUnit",
				"Verify if Supplier price is Resubmited").assignCategory("MaterialTestCases","SanityTests");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			String sStock = master.fetchStock(292,"Sanity Test");
			store.addGRN(292, "Sanity Test", null);
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.validateStockWOMake(292, "Sanity Test", sStock);
			if(flag){
				Constant.log.info("Supplier price removed test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price removed test case is successful");
			}else{
				System.err.println("Supplier price removed test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test293_ValStockMat_WAltUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Validate Material stock without alternate unit");
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
