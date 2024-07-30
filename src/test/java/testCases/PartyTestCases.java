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
import pages.ProfilePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PartyTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	ProfilePage master = PageFactory.initElements(Constant.driver, ProfilePage.class);
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
		Constant.logFile("Party");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test008_AddParty_WOSupplierNCustomer() throws Exception{
		log.startTestCase("Add Party without supplier and customer");
		extentTest = extent.startTest("Test008_AddParty_WOSupplierNCustomer",
				"Verify whether party can be added without supplier and customer").assignCategory("PartyTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToParty();
			boolean flag = master.validateAddParty(7,"Party");
			if(flag){
				Constant.log.info("Party addition without supplier and customer test case is successful");
				extentTest.log(LogStatus.PASS, "Party addition without supplier and customer test case is successful");
			}else{
				System.err.println("Party addition without supplier and customer test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test008_AddParty_WOSupplierNCustomer")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Add Party without supplier and customer");
	}

	@Category(SmokeTest.class)
	@Test
	public void Test009_AddParty_SupplierNCustomerCrDays() throws Exception{
		log.startTestCase("Add Party with supplier and customer credit days");
		extentTest = extent.startTest("Test009_AddParty_SupplierNCustomerCrDays",
				"Verify whether party can be added with supplier and customer credit days").assignCategory("PartyTestCases","SmokeTest");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToParty();
			boolean flag = master.validateAddParty(8,"Party");
			if(flag){
				Constant.log.info("Party addition with supplier and customer credit days test case is successful");
				extentTest.log(LogStatus.PASS, "Party addition with supplier and customer credit days test case is successful");
			}else{
				System.err.println("Party addition with supplier and customer credit days test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test009_AddParty_SupplierNCustomerCrDays")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Add Party with supplier and customer credit days");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test010_AddParty_WOSupplierNCustomerCrDays() throws Exception{
		log.startTestCase("Add Party without supplier and customer credit days");
		extentTest = extent.startTest("Test010_AddParty_WOSupplierNCustomerCrDays",
				"Verify whether party can be added without supplier and customer credit days").assignCategory("PartyTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToParty();
			boolean flag = master.validateAddParty(9,"Party");
			if(flag){
				Constant.log.info("Party addition without supplier and customer credit days test case is successful");
				extentTest.log(LogStatus.PASS, "Party addition without supplier and customer credit days test case is successful");
			}else{
				System.err.println("Party addition without supplier and customer credit days test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test010_AddParty_WOSupplierNCustomerCrDays")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Add Party without supplier and customer credit days");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test032_updateParty_InlineSave() throws Exception{
		log.startTestCase("Update party inline save icon");
		extentTest = extent.startTest("Test032_updateParty_InlineSave",
				"Verify whether party can be updated with inline save icon").assignCategory("PartyTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = master.verifyPartyInlineSaveIcon();
			if(flag){
				Constant.log.info("Party updated with inline save icon test case is successful");
				extentTest.log(LogStatus.PASS, "Party updated with inline save icon test case is successful");
			}else{
				System.err.println("Party updated with inline save icon test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test032_updateParty_InlineSave")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Update party inline save icon");
	}

	@Test   @Category(HighPriorityTestCases.class)
	public void Test033_updateParty_EnterKey() throws Exception{
		log.startTestCase("Update party inline save icon");
		extentTest = extent.startTest("Test033_updateParty_EnterKey",
				"Verify whether party can be updated with inline save icon").assignCategory("PartyTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = master.verifyPartyInlineSave_EnerKey();
			if(flag){
				Constant.log.info("Party updated with inline save icon test case is successful");
				extentTest.log(LogStatus.PASS, "Party updated with inline save icon test case is successful");
			}else{
				System.err.println("Party updated with inline save icon test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test033_updateParty_EnterKey")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Update party inline save icon");
	}

	@Test  @Category(SanityTests.class)
	public void Test058_UpdateParty() throws Exception{
		log.startTestCase("UpdateParty");
		extentTest = extent.startTest("Test058_UpdateParty",
				"Verify whether party can be updated").assignCategory("PartyTestCases","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test058_UpdateParty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("UpdateParty");
	}

	@Test  @Category(SanityTests.class)
	public void Test059_DeleteParty() throws Exception{
		log.startTestCase("DeleteParty");
		extentTest = extent.startTest("Test059_DeleteParty",
				"Verify whether party can be deleted").assignCategory("PartyTestCases","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test059_DeleteParty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("DeleteParty");
	}
	/*
	@Test
	public void test004_searchParty() throws Exception{
		log.startTestCase("searchParty");
		extentTest = extent.startTest("search Party",
				"Verify whether party can be serched");
		login.login();
		try{
			boolean flag = master.searchParty(3,"Party");
			if(flag == true){
				Constant.log.info("search party test case is successful");
				extentTest.log(LogStatus.PASS, "search party test case is successful");
			}else{
				System.err.println("search party test case failed ");
				Constant.captureScreen_Negative("searchParty");
				extentTest.log(LogStatus.FAIL, "search party test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("searchParty");
	}

	@Test
	public void test005_ImportParty() throws Exception{
		log.startTestCase("ImportParty");
		extentTest = extent.startTest("Import Party",
				"Verify whether party can be Imported");
		login.login();
		try{
			boolean flag = master.importParty(4);
			if(flag == true){
				Constant.log.info("import party test case is successful");
				extentTest.log(LogStatus.PASS, "import party test case is successful");
			}else{
				System.err.println("Import party test case failed ");
				Constant.captureScreen_Negative("ImportParty");
				extentTest.log(LogStatus.FAIL, "import party test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("ImportParty");
	}

	@Test
	public void test006_AddParty_LedgerUpdate() throws Exception{
		log.startTestCase("AddParty_LedgerUpdate");
		extentTest = extent.startTest("Add Party and verify in Ledger",
				"Add Party and verify whether new party is displayed in Ledger");
		login.login();
		try{
			boolean flag = master.addParty_LedgerUpdate(5);
			if(flag == true){
				Constant.log.info("Ledger update for Supplier and customer test case is successful");
				extentTest.log(LogStatus.PASS, "Ledger update for Supplier and customer test case is successful");
			}else{
				System.err.println("Ledger update for Supplier and customer test case failed ");
				Constant.captureScreen_Negative("AddParty_LedgerUpdate");
				extentTest.log(LogStatus.FAIL, "Ledger update for Supplier and customer test case failed ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("AddParty_LedgerUpdate");
	}

	@Test
	public void test007_MandatoryPartyFields() throws Exception{
		log.startTestCase("MandatoryField");
		extentTest = extent.startTest("Mandatory Field",
				"verify Mandatory field check in Party page");
		login.login();
		try{
			boolean flag = master.mandatoryField();
			if(flag == true){
				Constant.log.info("Mandatory Party field test case is successful");
				extentTest.log(LogStatus.PASS, "Mandatory Party field test case is successful");
			}else{
				System.err.println("Mandatory Party field test case failed ");
				Constant.captureScreen_Negative("MandatoryField");
				extentTest.log(LogStatus.FAIL, "Mandatory Party field test case failed ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("MandatoryField");
	}

	@Test
	public void test008_ImportCancel() throws Exception{
		log.startTestCase("ImportPartyCancel");
		extentTest = extent.startTest("Cancel in Import Party pop up",
				"verify cancel button in Import party pop up");
		login.login();
		try{
			boolean flag = master.importCancel();
			if(flag == true){
				Constant.log.info("Import Cancel button test case is successful");
				extentTest.log(LogStatus.PASS, "Import Cancel button test case is successful");
			}else{
				System.err.println("Import Cancel button test case failed ");
				Constant.captureScreen_Negative("ImportPartyCancel");
				extentTest.log(LogStatus.FAIL, "Import Cancel button test case failed ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("ImportPartyCancel");
	}

	@Test
	public void test009_ImportWithoutfile() throws Exception{
		log.startTestCase("ImportWithoutfile");
		extentTest = extent.startTest("Import without File",
				"Verify warning message when imported without file");
		login.login();
		try{
			boolean flag = master.importWithoutFile();
			if(flag == true){
				Constant.log.info("Import without file test case is successful");
				extentTest.log(LogStatus.PASS, "Import without file test case is successful");
			}else{
				System.err.println("Import without file test case failed ");
				Constant.captureScreen_Negative("ImportWithoutfile");
				extentTest.log(LogStatus.FAIL, "Import without file test case failed ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("ImportWithoutfile");
	}

	@Test
	public void test010_CancelParty() throws Exception{
		log.startTestCase("CancelParty");
		extentTest = extent.startTest("Cancel button in Party",
				"Verify Cancel button in Party page");
		login.login();
		try{
			boolean flag = master.partyCancel(9);
			if(flag == true){
				Constant.log.info("Cancel button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Cancel button validation test case is successful");
			}else{
				System.err.println("Cancel button validation test case failed ");
				Constant.captureScreen_Negative("CancelParty");
				extentTest.log(LogStatus.FAIL, "Cancel button validation test case failed ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("CancelParty");
	}

	@Test
	public void test011_CodeFieldEnabled() throws Exception{
		log.startTestCase("CodeFieldEnabled");
		extentTest = extent.startTest("Code Field Enabled",
				"Verify Code field is enabled after party is delete");
		login.login();
		try{
			boolean flag = master.codeFieldEnabled_Delete(10);
			if(flag == true){
				Constant.log.info("Verification of Code Field Enabled after party is delete test case is successful");
				extentTest.log(LogStatus.PASS, "Verification of Code Field Enabled after party is delete test case is successful");
			}else{
				System.err.println("Verification of Code Field Enabled after party is delete test case failed ");
				Constant.captureScreen_Negative("CodeFieldEnabled");
				extentTest.log(LogStatus.FAIL, "Verification of Code Field Enabled after party is delete");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("CodeFieldEnabled");
	}
	*/
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
