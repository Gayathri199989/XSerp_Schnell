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
import pages.AuditingPage;
import pages.LoginPage;
import pages.SettingPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManualNoteTestcases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	AuditingPage audit = PageFactory.initElements(Constant.driver, AuditingPage.class);
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
		Constant.logFile("Manual Note");
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
	}

	@Category(SmokeTest.class)
	@Test
	public void Test142_CreateNote_Credit() throws Exception{
		log.startTestCase("Create Credit Note");
		extentTest = extent.startTest("Test142_CreateNote_Credit",
				"Verify if Credit note can be created").assignCategory("ManualNoteTestcases","SmokeTest");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.createNote(141,"ICD");
			if(flag){
				Constant.log.info("Credit Note creation is successful");
				extentTest.log(LogStatus.PASS, "Credit Note creation is successful");
			}else{
				System.err.println("Credit Note creation failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test142_CreateNote_Credit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Credit Note creation");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test143_CreateNote_Debit() throws Exception{
		log.startTestCase("Create Debit Note");
		extentTest = extent.startTest("Test143_CreateNote_Debit",
				"Verify if Debit note can be created").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.createNote(142,"ICD");
			if(flag){
				Constant.log.info("Debit Note creation is successful");
				extentTest.log(LogStatus.PASS, "Debit Note creation is successful");
			}else{
				System.err.println("Debit Note creation failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test143_CreateNote_Debit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Debit Note creation");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test144_CreateMultiNote() throws Exception{
		log.startTestCase("Create Multiple manual Note");
		extentTest = extent.startTest("Test144_CreateMultiNote",
				"Verify if Multiple manual note can be created").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.createNote(143,"ICD");
			if(flag){
				Constant.log.info("Multiple manual Note creation is successful");
				extentTest.log(LogStatus.PASS, "Multiple manual Note creation is successful");
			}else{
				System.err.println("Multiple manual Note creation failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test144_CreateMultiNote")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Multiple manual Note creation");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test158_UpdateCreditNote_Debit() throws Exception{
		log.startTestCase("Update Credit note to Debit");
		extentTest = extent.startTest("Test158_UpdateCreditNote_Debit",
				"Verify if Credit note can be updated to Debit").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.updateManualNote_ChangeType(157,"ICD");
			if(flag){
				Constant.log.info("Verify if Credit note can be updated to Debit test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Credit note can be updated to Debit test case is successful");
			}else{
				System.err.println("Verify if Credit note can be updated to Debit test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test158_UpdateCreditNote_Debit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Credit note to Debit");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test159_UpdateDebitNote_Credit() throws Exception{
		log.startTestCase("Update Debit note to Credit");
		extentTest = extent.startTest("Test159_UpdateDebitNote_Credit",
				"Verify if Debit note can be updated to Credit").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.updateManualNote_ChangeType(158,"ICD");
			if(flag){
				Constant.log.info("Verify if Debit note can be updated to Credit test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Debit note can be updated to Credit test case is successful");
			}else{
				System.err.println("Verify if Debit note can be updated to Credit test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test159_UpdateDebitNote_Credit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Debit note to Credit");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test160_UpdateNote_AddItem() throws Exception{
		log.startTestCase("Update note by adding item");
		extentTest = extent.startTest("Test160_UpdateNote_AddItem",
				"Verify if manual note updated by adding item").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.updateManualNote_AddItem(159,"ICD");
			if(flag){
				Constant.log.info("Verify if manual note updated by adding item test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if manual note updated by adding item test case is successful");
			}else{
				System.err.println("Verify if manual note updated by adding item test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test160_UpdateNote_AddItem")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update note by adding item");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test161_UpdateNote_DeletingItem() throws Exception{
		log.startTestCase("Update note by deleting item");
		extentTest = extent.startTest("Test161_UpdateNote_DeletingItem",
				"Verify if manual note updated by deleting item").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.updateManualNote_DeleteItem(160,"ICD");
			if(flag){
				Constant.log.info("Verify if manual note updated by deleting item test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if manual note updated by deleting item test case is successful");
			}else{
				System.err.println("Verify if manual note updated by deleting item test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test161_UpdateNote_DeletingItem")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update note by deleting item");
	}

	@Test  @Category(SanityTests.class)
	public void Test194_ApproveCreditNote_EditPAge() throws Exception{
		log.startTestCase("Approve Credit Note from edit page");
		extentTest = extent.startTest("Test194_ApproveCreditNote_EditPAge",
				"Verify if Credit note can be Approved from edit page").assignCategory("ManualNoteTestcases","SanityTests");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.approveNote_Editpage(193,"ICD");
			if(flag){
				Constant.log.info("Credit Note Approve from edit page is successful");
				extentTest.log(LogStatus.PASS, "Credit Note Approve from edit page is successful");
			}else{
				System.err.println("Credit Note Approve from edit page failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test194_ApproveCreditNote_EditPAge")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Credit Note Approve from edit page");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test195_ApproveDebitNoteEditPAge() throws Exception{
		log.startTestCase("Approve Debit Note from edit page");
		extentTest = extent.startTest("Test195_ApproveDebitNoteEditPAge",
				"Verify if Debit note can be Approved from edit page").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.approveNote_Editpage(194,"ICD");
			if(flag){
				Constant.log.info("Debit Note Approve from edit page is successful");
				extentTest.log(LogStatus.PASS, "Debit Note Approve from edit page is successful");
			}else{
				System.err.println("Debit Note Approve from edit page failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test195_ApproveDebitNoteEditPAge")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Debit Note Approve from edit page");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test196_ApproveDebitNote_addPage() throws Exception{
		log.startTestCase("Approve Debit Note from add page");
		extentTest = extent.startTest("Test196_ApproveDebitNote_addPage",
				"Verify if Debit note can be Approved from add page").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.approveNote_AddPage(195,"ICD");
			if(flag){
				Constant.log.info("Debit Note Approve from add page is successful");
				extentTest.log(LogStatus.PASS, "Debit Note Approve from add page is successful");
			}else{
				System.err.println("Debit Note Approve from add page failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test196_ApproveDebitNote_addPage")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Debit Note Approve from add page");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test197_ApproveCreditNote_addPage() throws Exception{
		log.startTestCase("Approve Credit Note from add page");
		extentTest = extent.startTest("Test197_ApproveCreditNote_addPage",
				"Verify if Credit note can be Approved from add page").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.approveNote_AddPage(196,"ICD");
			if(flag){
				Constant.log.info("Credit Note Approve from add page is successful");
				extentTest.log(LogStatus.PASS, "Credit Note Approve from add page is successful");
			}else{
				System.err.println("Credit Note Approve from add page failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test197_ApproveCreditNote_addPage")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Credit Note Approve from add page");
	}

	@Test  @Category(SanityTests.class)
	public void Test202_VerifyDebitNote() throws Exception{
		log.startTestCase("Verify Debit Note");
		extentTest = extent.startTest("Test202_VerifyDebitNote",
				"Verify if Debit note can be Verified").assignCategory("ManualNoteTestcases","SanityTests");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.verifyNote(201,"ICD");
			if(flag){
				Constant.log.info(" Debit Note Verify is successful");
				extentTest.log(LogStatus.PASS, "Debit Note Verify is successful");
			}else{
				System.err.println("Debit Note Verify failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test202_VerifyDebitNote")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Debit Note Verify");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test203_VerifyCreditNote() throws Exception{
		log.startTestCase("Verify Credit Note");
		extentTest = extent.startTest("Test203_VerifyCreditNote",
				"Verify if Credit note can be Verified").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.verifyNote(202,"ICD");
			if(flag){
				Constant.log.info(" Credit Note Verify is successful");
				extentTest.log(LogStatus.PASS, "Credit Note Verify is successful");
			}else{
				System.err.println("Credit Note Verify failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test203_VerifyCreditNote")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Credit Note Verify");
	}

	@Test  @Category(SanityTests.class)
	public void Test209_ReturnManualDebitNote() throws Exception{
		log.startTestCase("Return Manual Debit Note");
		extentTest = extent.startTest("Test209_ReturnManualDebitNote",
				"Verify if Manual Debit note is returned").assignCategory("ManualNoteTestcases","SanityTests");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.returnManualNote(208, "ICD");
			if(flag){
				Constant.log.info("Return manual Debit note test case is successful");
				extentTest.log(LogStatus.PASS, "Return manual Debit note test case is successful");
			}else{
				System.err.println("Return manual Debit note test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test209_ReturnManualDebitNote")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return Manual Debit Note");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test210_ReturnManualCreditNote() throws Exception{
		log.startTestCase("Return Manual Credit Note");
		extentTest = extent.startTest("Test210_ReturnManualCreditNote",
				"Verify if Manual Credit note is returned").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.returnManualNote(209, "ICD");
			if(flag){
				Constant.log.info("Return manual Credit note test case is successful");
				extentTest.log(LogStatus.PASS, "Return manual Credit note test case is successful");
			}else{
				System.err.println("Return manual Credit note test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test210_ReturnManualCreditNote")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return Manual Credit Note");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test215_CheckReturnedNote_AddItems() throws Exception{
		log.startTestCase("Check Returned Manual Note by adding items");
		extentTest = extent.startTest("Test215_CheckReturnedNote_AddItems",
				"Verify if returned Manual Note by adding items is checked").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.checkReturnedNote_AddItems(214,"ICD");
			if(flag){
				Constant.log.info("Check returned Manual Note by adding items test case is successful");
				extentTest.log(LogStatus.PASS, "Check returned Manual Note by adding items test case is successful");
			}else{
				System.err.println("Check returned Manual Note by adding items test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test215_CheckReturnedNote_AddItems")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check Returned Manual Note by adding items");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test216_CheckReturnedNote_DeleteItems() throws Exception{
		log.startTestCase("Check Returned Manual Note by adding items");
		extentTest = extent.startTest("Test216_CheckReturnedNote_DeleteItems",
				"Verify if returned Manual Note by adding items is checked").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.checkReturnedNote_DeleteItems(215,"ICD");
			if(flag){
				Constant.log.info("Check returned Manual Note by adding items test case is successful");
				extentTest.log(LogStatus.PASS, "Check returned Manual Note by adding items test case is successful");
			}else{
				System.err.println("Check returned Manual Note by adding items test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test216_CheckReturnedNote_DeleteItems")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check Returned Manual Note by adding items");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test217_CheckReturnedNote_AddNDeleteItems() throws Exception{
		log.startTestCase("Check Returned Manual Note by adding items");
		extentTest = extent.startTest("Test217_CheckReturnedNote_AddNDeleteItems",
				"Verify if returned Manual Note by adding items is checked").assignCategory("ManualNoteTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.checkReturnedNote_AddNDeleteItems(216,"ICD");
			if(flag){
				Constant.log.info("Check returned Manual Note by adding items test case is successful");
				extentTest.log(LogStatus.PASS, "Check returned Manual Note by adding items test case is successful");
			}else{
				System.err.println("Check returned Manual Note by adding items test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test217_CheckReturnedNote_AddNDeleteItems")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check Returned Manual Note by adding items");
	}

	@Test  @Category(SanityTests.class)
	public void Test152_CheckReturnedManualNote() throws Exception{
		log.startTestCase("Check Returned Manual Note");
		extentTest = extent.startTest("Test152_CheckReturnedManualNote",
				"Verify if returned Manual Note is checked").assignCategory("ManualNoteTestcases","SanityTests");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.checkReturnedNote(151,"Sanity Test");
			if(flag){
				Constant.log.info("Check returned Manual Note test case is successful");
				extentTest.log(LogStatus.PASS, "Check returned Manual Note test case is successful");
			}else{
				System.err.println("Check returned Manual Note test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test152_CheckReturnedManualNote")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check Returned Manual Note");
	}

	@Test  @Category(SanityTests.class)
	public void Test075_UpdateManualNote() throws Exception{
		log.startTestCase("Update Manual Note");
		extentTest = extent.startTest("Test075_UpdateManualNote",
				"validate Manual note updation").assignCategory("ManualNoteTestcases","SanityTests");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.updateManualNote(74, "Sanity Test");
			if(flag){
				Constant.log.info("Manual note update test case is successful");
				extentTest.log(LogStatus.PASS, "Manual note update test case is successful");
			}else{
				System.err.println("Manual note update test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test075_UpdateManualNote")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Manual Note");
	}

	@Test  @Category(SanityTests.class)
	public void Test280_PartyAckManualNote() throws Exception{
		log.startTestCase("Party Acknowledge Manual Note");
		extentTest = extent.startTest("Test280_PartyAckManualNote",
				"validate Manual note Party Acknowledge").assignCategory("ManualNoteTestcases","SanityTests");
		try{
			setting.reqAckn_Check();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.acknowledgePartyICD(279, "Sanity Test", null, "IAN");
			if(flag){
				Constant.log.info("Manual note Party Acknowledge test case is successful");
				extentTest.log(LogStatus.PASS, "Manual note Party Acknowledge test case is successful");
			}else{
				System.err.println("Manual note Party Acknowledge test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test280_PartyAckManualNote")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Party Acknowledge Manual Note");
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
