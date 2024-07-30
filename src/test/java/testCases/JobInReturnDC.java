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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import category.HighPriorityTestCases;
import category.SanityTests;
import category.SmokeTest;
import pages.LoginPage;
import pages.SalesPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobInReturnDC {
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
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
		Constant.logFile("Receipt Job in");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test004_PartyDcDropDwn_draftGRN() throws Exception{
		log.startTestCase("Validate Party Dc drop down with draft grn");
		extentTest = extent.startTest("Test004_PartyDcDropDwn_draftGRN",
				"Verify if party dc no drop down not displayed draft job in grn").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			store.addGRN(3, "Job in Return", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			boolean flag = sales.validatePartyDcno_Draft(3, "Job in Return", sGRNNo);
			if(flag){
				Constant.log.info("Validate Party Dc drop down with draft grn test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Party Dc drop down with draft grn test case is successful");
			}else{
				System.err.println("Validate Party Dc drop down with draft grn test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test004_PartyDcDropDwn_draftGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate Party Dc drop down with draft grn");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test005_PartyDcDropDwn_approvedGRN() throws Exception{
		log.startTestCase("Validate Party Dc drop down with approved grn");
		extentTest = extent.startTest("Test005_PartyDcDropDwn_approvedGRN",
				"Verify if party dc no drop down not displayed approved job in grn").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			store.approveGRN(4, "Job in Return", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			boolean flag = sales.validatePartyDcno_approved(4, "Job in Return", sGRNNo);
			if(flag){
				Constant.log.info("Validate Party Dc drop down with approved grn test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Party Dc drop down with approved grn test case is successful");
			}else{
				System.err.println("Validate Party Dc drop down with approved grn test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test005_PartyDcDropDwn_approvedGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate Party Dc drop down with approved grn");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test007_PartyDcDropDwn_rejectGRN() throws Exception{
		log.startTestCase("Validate Party Dc drop down with reject grn");
		extentTest = extent.startTest("Test007_PartyDcDropDwn_rejectGRNn",
				"Verify if party dc no drop down not displayed reject job in grn").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			store.vaildateRejectApprovedGRN(6, "Job in Return", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			boolean flag = sales.validatePartyDcno_Draft(6, "Job in Return", sGRNNo);
			if(flag){
				Constant.log.info("Validate Party Dc drop down with reject grn test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Party Dc drop down with reject grn test case is successful");
			}else{
				System.err.println("Validate Party Dc drop down with reject grn test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test007_PartyDcDropDwn_rejectGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate Party Dc drop down with reject grn");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test009_PartyDcDropDwn_approvedPOGRN() throws Exception{
		log.startTestCase("Validate Party Dc drop down with approved po grn");
		extentTest = extent.startTest("Test009_PartyDcDropDwn_approvedPOGRN",
				"Verify if party dc no drop down not displayed approved job in grn").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			store.approveGRN(8, "Job in Return", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			boolean flag = sales.validatePartyDcno_Draft(8, "Job in Return", sGRNNo);
			if(flag){
				Constant.log.info("Validate Party Dc drop down with approved po grn test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Party Dc drop down with approved po grn test case is successful");
			}else{
				System.err.println("Validate Party Dc drop down with approved po grn test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test009_PartyDcDropDwn_approvedPOGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate Party Dc drop down with approved po grn");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test027_MaterialListGridValidate_Qty() throws Exception{
		log.startTestCase("Validate Material list grid with qty");
		extentTest = extent.startTest("Test027_MaterialListGridValidate_Qty",
				"Verify if material list grid has added qty").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			store.approveGRN(26, "Job in Return", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			boolean flag = sales.validateQtyMaterialListGrid(26, "Job in Return", sGRNNo);
			if(flag){
				Constant.log.info("Validate Material list grid with qty test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Material list grid with qty test case is successful");
			}else{
				System.err.println("Validate Material list grid with qty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test027_MaterialListGridValidate_Qty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate Material list grid with qty");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test029_MatListGridValidate_MaterialAddPge() throws Exception{
		log.startTestCase("Validate Material list grid with stock n non stock in add page");
		extentTest = extent.startTest("Test029_MatListGridValidate_MaterialAddPge",
				"Verify if material list grid has added stock n non stock in add page").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			store.approveGRN(28, "Job in Return", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			boolean flag = sales.validateMaterials_MatListGridAddPge(28, "Job in Return", sGRNNo);
			if(flag){
				Constant.log.info("Validate Material list grid with stock n non stock in add page test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Material list grid with stock n non stock in add page test case is successful");
			}else{
				System.err.println("Validate Material list grid with stock n non stock in add page test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test029_MatListGridValidate_MaterialAddPge")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate Material list grid with stock n non stock in add page");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test031_PendingValueValidation_QtyWArnig() throws Exception{
		log.startTestCase("Validate pending qty warning ");
		extentTest = extent.startTest("Test031_PendingValueValidation_QtyWArnig",
				"Verify if pending qty value when qty edited in material list grid").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			store.approveGRN(30, "Job in Return", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			boolean flag = sales.validateQtywarning_MaterialListGrid(30, "Job in Return", sGRNNo);
			if(flag){
				Constant.log.info("Validate pending Qty warning in material list grid test case is successful");
				extentTest.log(LogStatus.PASS, "Validate pending Qty warning in material list grid test case is successful");
			}else{
				System.err.println("Validate pending Qty warning in material list grid test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test031_PendingValueValidation_QtyWArnig")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate pending qty warning ");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test032_ApproveJobinReturn() throws Exception{
		log.startTestCase("Approve Job in Return");
		extentTest = extent.startTest("Test032_ApproveJobinReturn",
				"Verify if Job in Return is approved").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			boolean flag = sales.validateApproveInvoice(31, "Job in Return", null);
			if(flag){
				Constant.log.info("Verify if Job in Return is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Job in Return is approved test case is successful");
			}else{
				System.err.println("Job in Return is approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test032_ApproveJobinReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Job in Return");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test033_RejectDraftJobinReturn() throws Exception{
		log.startTestCase("Reject Draft Job in Return");
		extentTest = extent.startTest("Test033_RejectDraftJobinReturn",
				"Verify if drafted Job in Return is rejected").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			boolean flag = sales.validateRejectDraftInvoice(32, "Job in Return");
			if(flag){
				Constant.log.info("Verify if drafted Job in Return is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Job in Return is rejected test case is successful");
			}else{
				System.err.println("Drafted Job in Return is rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test033_RejectDraftJobinReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Job in Return");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test034_RejectApprovedJobInReturn() throws Exception{
		log.startTestCase("Reject Approved Job in Return");
		extentTest = extent.startTest("Test034_RejectApprovedJobInReturn",
				"Verify if Approved Job in Return is rejected").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(33, "Job in Return", null);
			if(flag){
				Constant.log.info("Verify if Approved Job in Return is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Job in Return is rejected test case is successful");
			}else{
				System.err.println("Approved Job in Return is rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test034_RejectApprovedJobInReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Job in Return");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test037_JobInReturn_GRNDC() throws Exception{
		log.startTestCase("JobIn Return not available in GRN DC");
		extentTest = extent.startTest("Test037_JobInReturn_GRNDC",
				"Verify if Approved Job in Return is rejected").assignCategory("JobInReturnDC","HighPriorityTestCases");
		JavascriptExecutor js = ((JavascriptExecutor) Constant.driver);
		try{
			sales.validateApproveInvoice(36, "Job in Return", null);
			String sInvoices = Integer.toString(sales.invoices.size());
			js.executeScript("arguments[0].scrollIntoView(true);", Constant.driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/a")));
			String sInvoiceNo = Constant.driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[2]/a")).getText();
			boolean flag = store.validateDCDropDwn(36, "Job in Return", sInvoiceNo);
			if(flag){
				Constant.log.info("Verify if Approved Job in Return is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Job in Return is rejected test case is successful");
			}else{
				System.err.println("Approved Job in Return is rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test037_JobInReturn_GRNDC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("JobIn Return not available in GRN DC");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test040_ValidateItemParticulars() throws Exception{
		log.startTestCase("Items particulars not avaialble");
		extentTest = extent.startTest("Test040_ValidateItemParticulars",
				"Verify if Items particulars not available").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			boolean flag = sales.itemPart_NotAvailable(39, "Job in Return");
			if(flag){
				Constant.log.info("Verify if Items particulars not available test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Items particulars not available test case is successful");
			}else{
				System.err.println("Items particulars not available test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test040_ValidateItemParticulars")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Items particulars not avaialble");
	}

	@Test  @Category(SanityTests.class)
	public void Test041_UpdateJobInReturn_AddPartyDC() throws Exception{
		log.startTestCase("Update Job in Return adding party dc");
		extentTest = extent.startTest("Test041_UpdateJobInReturn_AddPartyDC",
				"Verify if job in Return DC is updated by  adding party dc").assignCategory("JobInReturnDC","SanityTests");
		try{
			sales.addInvoice(40, "Job in Return", null);
			boolean flag = sales.UpdateInvoiceChangingCount(40, "Job in Return");
			if(flag){
				Constant.log.info("Job in Return DC updated by adding party dc test case is successful");
				extentTest.log(LogStatus.PASS, "Job in Return DC updated by adding party dc test case is successful");
			}else{
				System.err.println("Job in Return DC updated by adding party dc test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test041_UpdateJobInReturn_AddPartyDC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Job in Return by adding party dc");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test043_UpdateJobInReturn_ChangeParty() throws Exception{
		log.startTestCase("Update Job in Return changing Party");
		extentTest = extent.startTest("Test043_UpdateJobInReturn_ChangeParty",
				"Verify if job in Return DC is updated by changing Party").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			sales.addInvoice(40,"Job in Return", null);//Don't change line number of excel
			boolean flag = sales.UpdateInvoiceChangingParty(42, "Job in Return");
			if(flag){
				Constant.log.info("Job in Return DC updated by changing Party test case is successful");
				extentTest.log(LogStatus.PASS, "Job in Return DC updated by changing Party test case is successful");
			}else{
				System.err.println("Job in Return DC updated by changing Party test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test043_UpdateJobInReturn_ChangeParty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Job in Return by changing Party");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test045_QuantityWrningValidationMatListGRid() throws Exception{
		log.startTestCase("Validate Qty warning in material list grid");
		extentTest = extent.startTest("Test045_QuantityWrningValidationMatListGRid",
				"Verify if Qty warning is displayed when qty edited in material list grid").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			store.approveGRN(44, "Job in Return", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			boolean flag = sales.validateQtywarning_MaterialListGrid(44, "Job in Return", sGRNNo);
			if(flag){
				Constant.log.info("Validate Qty warning in material list grid test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Qty warning in material list grid test case is successful");
			}else{
				System.err.println("Validate Qty warning in material list grid test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test045_QuantityWrningValidationMatListGRid")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate Qty warning in material list grid");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test052_ValidatePendingQtyEdiPge() throws Exception{
		log.startTestCase("Validate pending qty in edit page");
		extentTest = extent.startTest("Test052_ValidatePendingQtyEdiPge",
				"Verify if proper pending qty displayed in edit page").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			store.approveGRN(51, "Job in Return", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			sales.addInvoice(51,"Job in Return", sGRNNo);
			boolean flag = sales.validatePendingQty(51, "Job in Return");
			if(flag){
				Constant.log.info("Verify if proper pending qty displayed in edit page test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if proper pending qty displayed in edit page test case is successful");
			}else{
				System.err.println("Verify if proper pending qty displayed in edit page test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test052_ValidatePendingQtyEdiPge")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate pending qty in edit page");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test059_AddMultiJobinReturn_SamePartyDC() throws Exception{
		log.startTestCase("Multiple Job in return with same party dc");
		extentTest = extent.startTest("Test059_AddMultiJobinReturn_SamePartyDC",
				"Verify if proper pending qty displayed in edit page").assignCategory("JobInReturnDC","HighPriorityTestCases");
		boolean flag = false;
		try{
			store.approveGRN(58, "Job in Return", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			for(int i=0;i<3;i++){
				flag = sales.addInvoice(58,"Job in Return", sGRNNo);
			}
			if(flag){
				Constant.log.info("Verify if proper pending qty displayed in edit page test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if proper pending qty displayed in edit page test case is successful");
			}else{
				System.err.println("Verify if proper pending qty displayed in edit page test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test059_AddMultiJobinReturn_SamePartyDC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Multiple Job in return with same party dc");
	}

	@Test  @Category(SanityTests.class)
	public void Test067_AmendJobInReturn_AddPartyDC() throws Exception{
		log.startTestCase("Amend Job in Return adding party dc");
		extentTest = extent.startTest("Test067_AmendJobInReturn_AddPartyDC",
				"Verify if job in Return DC is Amendd by  adding party dc").assignCategory("JobInReturnDC","SanityTests");
		try{
			sales.validateApproveInvoice(66, "Job in Return", null);
			boolean flag = sales.UpdateInvoiceChangingCount(66, "Job in Return");
			if(flag){
				Constant.log.info("Job in Return DC Amend by adding party dc test case is successful");
				extentTest.log(LogStatus.PASS, "Job in Return DC Amend by adding party dc test case is successful");
			}else{
				System.err.println("Job in Return DC Amend by adding party dc test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test067_AmendJobInReturn_AddPartyDC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend Job in Return by adding party dc");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test068_AmendJobInReturn_ChangeParty() throws Exception{
		log.startTestCase("Amend Job in Return changing Party");
		extentTest = extent.startTest("Test068_AmendJobInReturn_ChangeParty",
				"Verify if job in Return DC is Amendd by changing Party").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			sales.validateApproveInvoice(40,"Job in Return", null);//Don't change line number of excel
			boolean flag = sales.UpdateInvoiceChangingParty(67, "Job in Return");
			if(flag){
				Constant.log.info("Job in Return DC Amendd by changing Party test case is successful");
				extentTest.log(LogStatus.PASS, "Job in Return DC Amendd by changing Party test case is successful");
			}else{
				System.err.println("Job in Return DC Amendd by changing Party test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test068_AmendJobInReturn_ChangeParty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend Job in Return by changing Party");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test069_Amend_DeleteNAddMaterials() throws Exception{
		log.startTestCase("Amend Job in Return by deleting and adding materials");
		extentTest = extent.startTest("Test069_Amend_DeleteNAddMaterials",
				"Verify if job in Return DC is Amended by deleting and adding materials").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			sales.validateApproveInvoice(68,"Job in Return", null);
			boolean flag = sales.deleteItem(68, "Job in Return");
			if(flag){
				Constant.log.info("Job in Return DC Amended by deleting and adding materials test case is successful");
				extentTest.log(LogStatus.PASS, "Job in Return DC Amendd by deleting and adding materials test case is successful");
			}else{
				System.err.println("Job in Return DC Amendd by deleting and adding materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test069_Amend_DeleteNAddMaterials")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend Job in Return by deleting and adding materials");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test072_validateDCReport() throws Exception{
		log.startTestCase("Validate DC report");
		extentTest = extent.startTest("Test072_validateDCReport",
				"Verify if DC report displayed job in return").assignCategory("JobInReturnDC","HighPriorityTestCases");
		JavascriptExecutor js = ((JavascriptExecutor) Constant.driver);
		try{
			sales.validateApproveInvoice(71,"Job in Return", null);
			navigate.showAllEntries();
			int iBeforeAdd = sales.invoices.size();
			js.executeScript("arguments[0].scrollIntoView(true);", Constant.driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/a/span")));
			String sJobInNo = Constant.driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/form/a")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDCReport();
			boolean flag = store.validateDCReport(sJobInNo);
			if(flag){
				Constant.log.info("Validate DC report displayed job in return test case is successful");
				extentTest.log(LogStatus.PASS, "Validate DC report displayed job in return test case is successful");
			}else{
				System.err.println("Validate DC report displayed job in return test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test072_validateDCReport")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate DC report");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test073_validateMaterialReceiptIssueReportReport() throws Exception{
		log.startTestCase("Validate MaterialReceiptIssueReport report");
		extentTest = extent.startTest("Test073_validateMaterialReceiptIssueReportReport",
				"Verify if MaterialReceiptIssueReport report displayed job in return").assignCategory("JobInReturnDC","HighPriorityTestCases");
		JavascriptExecutor js = ((JavascriptExecutor) Constant.driver);
		try{
			store.approveGRN(72, "Job in Return", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			sales.validateApproveInvoice(72,"Job in Return", sGRNNo);
			navigate.showAllEntries();
			int iBeforeAdd = sales.invoices.size();
			js.executeScript("arguments[0].scrollIntoView(true);", Constant.driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/a/span")));
			String sJobInNo = Constant.driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/form/a")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterialReceiptReport();
			boolean flag = store.validateMaterialIssueReport(72,  "Job in Return", sJobInNo);
			if(flag){
				Constant.log.info("Validate MaterialReceiptIssueReport report displayed job in return test case is successful");
				extentTest.log(LogStatus.PASS, "Validate MaterialReceiptIssueReport report displayed job in return test case is successful");
			}else{
				System.err.println("Validate MaterialReceiptIssueReport report displayed job in return test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test073_validateMaterialReceiptIssueReportReport")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate MaterialReceiptIssueReport report");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test075_validatePartyDCNotAvl_Fullqty() throws Exception{
		log.startTestCase("Validate Party DC not available when full qty returned");
		extentTest = extent.startTest("Test075_validatePartyDCNotAvl_Fullqty",
				"Verify if MaterialReceiptIssueReport report displayed job in return").assignCategory("JobInReturnDC","HighPriorityTestCases");
		try{
			store.approveGRN(74, "Job in Return", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			sales.validateApproveInvoice(74,"Job in Return", sGRNNo);
			boolean flag = sales.validatePartyDcno_Draft(74, "Job in Return", sGRNNo);
			if(flag){
				Constant.log.info("Validate Party DC not available when full qty returned test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Party DC not available when full qty returned test case is successful");
			}else{
				System.err.println("Validate Party DC not available when full qty returned test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test075_validatePartyDCNotAvl_Fullqty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate Party DC not available when full qty returned");
	}

	@Test  @Category(SmokeTest.class)
	public void Test237_AddJobInReturnDC() throws Exception{
		log.startTestCase("Job in Return DC");
		extentTest = extent.startTest("Test237_AddJobInReturnDC",
				"Verify if job in Return DC is created").assignCategory("JobInReturnDC","SmokeTest");
		try{
			boolean flag = sales.addInvoice(236, "Sanity Test", null);
			if(flag){
				Constant.log.info("Job in Return DC created test case is successful");
				extentTest.log(LogStatus.PASS, "Job in Return DC created test case is successful");
			}else{
				System.err.println("Job in Return DC created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test237_AddJobInReturnDC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in Return DC");
	}

	@Test  @Category(SanityTests.class)
	public void Test265_AddJobInReturnDC_Nonstock() throws Exception{
		log.startTestCase("Job in Return DC with Non stock");
		extentTest = extent.startTest("Test265_AddJobInReturnDC_Nonstock",
				"Verify if job in Return DC with Non stock is created").assignCategory("JobInReturnDC","SmokeTest");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test265_AddJobInReturnDC_Nonstock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in eturn DC with Non stock");
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
