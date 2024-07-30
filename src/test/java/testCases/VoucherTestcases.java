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
import category.MediumPriorityTestCases;
import category.SanityTests;
import category.SmokeTest;
import pages.AccountsPage;
import pages.AuditingPage;
import pages.LoginPage;
import pages.SalesPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VoucherTestcases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	AccountsPage accounts = PageFactory.initElements(Constant.driver, AccountsPage.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);
	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
	AuditingPage audit = PageFactory.initElements(Constant.driver, AuditingPage.class);

	static ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	static String extentReportFile;
	static ExtentReports extent;
	static ExtentTest extentTest;


	@BeforeClass
	public static void BeforeClass() throws Exception{
		extentReportFile = property.getExtentReportFile()+"ExtentReport"+Constant.date+"."+"html";
		// Create object of extent report and specify the report file path.
		extent = new ExtentReports(extentReportFile, false);
		Constant.logFile("Voucher");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test009_MandatoryFieldCheck() throws Exception{
		log.startTestCase("Mandatory Field Check");
		extentTest = extent.startTest("Test009_MandatoryFieldCheck",
				"Verify if mandatory fields warning displayed").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.mandatoryFieldsCheck();
			if(flag){
				Constant.log.info("mandatory fields warning displayed test case is successful");
				extentTest.log(LogStatus.PASS, "mandatory fields warning displayed test case is successful");
			}else{
				System.err.println("mandatory fields warning displayed test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test009_MandatoryFieldCheck")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Mandatory Field Check");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test010_VerifyAddLedgerWarning() throws Exception{
		log.startTestCase("Verify Ledger warning displayed");
		extentTest = extent.startTest("Test010_VerifyAddLedgerWarning",
				"Verify if ledger mandatory warning displayed").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.saveWOLedger(9, "Voucher");
			if(flag){
				Constant.log.info("Verify if ledger mandatory warning displayed test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ledger mandatory warning displayed test case is successful");
			}else{
				System.err.println("Verify if ledger mandatory warning displayed test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test010_VerifyAddLedgerWarning")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify Ledger warning displayed");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test011_MandatoryLedgerWarning() throws Exception{
		log.startTestCase("Verify mandatory Ledger warning displayed");
		extentTest = extent.startTest("Test011_MandatoryLedgerWarning",
				"Verify if mandatory ledger warning displayed").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.invalidLedgerWarning(10, "Voucher");
			if(flag){
				Constant.log.info("Verify if mandatory ledger warning displayed test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if mandatory ledger warning displayed test case is successful");
			}else{
				System.err.println("Verify if mandatory ledger warning displayed test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test011_MandatoryLedgerWarning")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify mandatory Ledger warning displayed");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test012_invalidLedgerWarning() throws Exception{
		log.startTestCase("Verify invalid Ledger warning displayed");
		extentTest = extent.startTest("Test012_invalidLedgerWarning",
				"Verify if invalid ledger warning displayed").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.invalidLedgerWarning(11, "Voucher");
			if(flag){
				Constant.log.info("Verify if invalid ledger warning displayed test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if invalid ledger warning displayed test case is successful");
			}else{
				System.err.println("Verify if invalid ledger warning displayed test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test012_invalidLedgerWarning")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify invalid Ledger warning displayed");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test014_DrCrValueNotEqualWarning() throws Exception{
		log.startTestCase("Debit n Credit not equal warning");
		extentTest = extent.startTest("Test014_DrCrValueNotEqualWarning",
				"Verify if Debit n Credit not equal warning displayed").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.debitCreditValueNotMatched(13, "Voucher");
			if(flag){
				Constant.log.info("Verify if Debit n Credit not equal warning test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Debit n Credit not equal warning test case is successful");
			}else{
				System.err.println("Verify if Debit n Credit not equal warning test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test014_DrCrValueNotEqualWarning")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Debit n Credit not equal warning");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test017_AddGeneralVoucher() throws Exception{
		log.startTestCase("Add General Voucher");
		extentTest = extent.startTest("Test017_AddGeneralVoucher",
				"Verify if general voucher added with narration").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(16, "Voucher");
			if(flag){
				Constant.log.info("Verify if general voucher added with narration test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if general voucher added with narration test case is successful");
			}else{
				System.err.println("Verify if general voucher added with narration test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test017_AddGeneralVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add General Voucher");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test019_mandatoryFieldsBillPopup() throws Exception{
		log.startTestCase("Mandatory fields check in Bill popup");
		extentTest = extent.startTest("Test019_mandatoryFieldsBillPopup",
				"Verify if Mandatory fields warning displayed in Bill popup").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.mandatoryFieldsBillPopup(18, "Voucher");
			if(flag){
				Constant.log.info("Verify if Mandatory fields warning displayed in Bill popup test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Mandatory fields warning displayed in Bill popup test case is successful");
			}else{
				System.err.println("Verify if Mandatory fields warning displayed in Bill popup test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test019_mandatoryFieldsBillPopup")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Mandatory fields check in Bill popup");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test022_AddGeneralVoucherWBill() throws Exception{
		log.startTestCase("Add General voucher with bill");
		extentTest = extent.startTest("Test022_AddGeneralVoucherWBill",
				"Verify if general voucher with Bill popup").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(21, "Voucher");
			if(flag){
				Constant.log.info("Verify if general voucher with Bill popup test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if general voucher with Bill popup test case is successful");
			}else{
				System.err.println("Verify if general voucher with Bill popup test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test022_AddGeneralVoucherWBill")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add General voucher with bill");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test024_VerifyWarning_BillLessThanBAl() throws Exception{
		log.startTestCase("Verify warning when bill value less than balance");
		extentTest = extent.startTest("Test024_VerifyWarning_BillLessThanAmt",
				"Verify if warning displayed when bill value less than balance").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.checkWarn_BillLessThanBal(23, "Voucher");
			if(flag){
				Constant.log.info("Verify warning when bill value less than balance test case is successful");
				extentTest.log(LogStatus.PASS, "Verify warning when bill value less than balance test case is successful");
			}else{
				System.err.println("Verify warning when bill value less than balance test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test024_VerifyWarning_BillLessThanAmt")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify warning when bill value less than balance");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test025_VerifyWarning_BillgreaterThanBAl() throws Exception{
		log.startTestCase("Verify warning when bill value greater than balance");
		extentTest = extent.startTest("Test025_VerifyWarning_BillgreaterThanBAl",
				"Verify if warning displayed when bill value greater than balance").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.checkWarn_BillGreaterThanBal(24, "Voucher");
			if(flag){
				Constant.log.info("Verify warning when bill value greater than balance test case is successful");
				extentTest.log(LogStatus.PASS, "Verify warning when bill value greater than balance test case is successful");
			}else{
				System.err.println("Verify warning when bill value greater than balance test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test025_VerifyWarning_BillgreaterThanBAl")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify warning when bill value greater than balance");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test028_VerifyBillNo_EditPgeNAcctDash() throws Exception{
		log.startTestCase("Verify Bill no in edit page and accts dashboard");
		extentTest = extent.startTest("Test028_VerifyBillNo_EditPgeNAcctDash",
				"Verify if Bill no displayed in edit page and accts dashboard").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(27, "Voucher");
			boolean flag = accounts.verifyBillNo();
			if(flag){
				Constant.log.info("Verify Bill no in edit page and accts dashboard test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Bill no in edit page and accts dashboard test case is successful");
			}else{
				System.err.println("Verify Bill no in edit page and accts dashboard test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test028_VerifyBillNo_EditPgeNAcctDash")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify Bill no in edit page and accts dashboard");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test030_VerifyMultiBillNo_EditPgeNAcctDash() throws Exception{
		log.startTestCase("Verify multiple bill no in edit page and accts dashboard");
		extentTest = extent.startTest("Test030_VerifyMultiBillNo_EditPgeNAcctDash",
				"Verify if multiple bill no displayed in edit page and accts dashboard").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(29, "Voucher");
			boolean flag = accounts.verifyBillNo();
			if(flag){
				Constant.log.info("Verify multiple bill no in edit page and accts dashboard test case is successful");
				extentTest.log(LogStatus.PASS, "Verify multiple bill no in edit page and accts dashboard test case is successful");
			}else{
				System.err.println("Verify multiple bill no in edit page and accts dashboard test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test030_VerifyMultiBillNo_EditPgeNAcctDash")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify multiple bill no in edit page and accts dashboard");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test031_VerifyBillRemoved_AfterBillDelete() throws Exception{
		log.startTestCase("Verify Bill no removed from dashboard after bill deleted in voucher");
		extentTest = extent.startTest("Test031_VerifyBillRemoved_AfterBillDelete",
				"Verify if Bill no removed from dashboard after bill deleted in voucher").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(30, "Voucher");
			boolean flag = accounts.verifyBillNo_AfterBillDelete();
			if(flag){
				Constant.log.info("Verify Bill no removed from dashboard after bill deleted in voucher test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Bill no removed from dashboard after bill deleted in voucher test case is successful");
			}else{
				System.err.println("Verify Bill no removed from dashboard after bill deleted in voucher test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test031_VerifyBillRemoved_AfterBillDelete")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify Bill no removed from dashboard after bill deleted in voucher");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test032_VerifyBillNoUpdate() throws Exception{
		log.startTestCase("Verify Bill no update in dashboard");
		extentTest = extent.startTest("Test032_VerifyBillNoUpdate",
				"Verify if Bill no updated in dashboard").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(31, "Voucher");
			boolean flag = accounts.verifyBillNo_AfterBillNoUpdate();
			if(flag){
				Constant.log.info("Verify Bill no update in dashboard test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Bill no update in dashboard test case is successful");
			}else{
				System.err.println("Verify Bill no update in dashboard test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test032_VerifyBillNoUpdate")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify Bill no update in dashboard");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test033_VerifyBillValueUpdate() throws Exception{
		log.startTestCase("Verify bill value update in dashboard");
		extentTest = extent.startTest("Test033_VerifyBillValueUpdate",
				"Verify if bill value updated in dashboard").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(31, "Voucher");
			boolean flag = accounts.verifyBillValue_AfterVoucherUpdate(32, "Voucher");
			if(flag){
				Constant.log.info("Verify bill value update in dashboard test case is successful");
				extentTest.log(LogStatus.PASS, "Verify bill value update in dashboard test case is successful");
			}else{
				System.err.println("Verify bill value update in dashboard test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test033_VerifyBillValueUpdate")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify bill value update in dashboard");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test035_UpdateVoucher_AddLedger() throws Exception{
		log.startTestCase("Update voucher by adding ledger");
		extentTest = extent.startTest("Test035_UpdateVoucher_AddLedger",
				"Verify if voucher updated by adding ledger").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(31, "Voucher");
			boolean flag = accounts.updateVoucher_AddLedger(34, "Voucher");
			if(flag){
				Constant.log.info("Update voucher by adding ledger test case is successful");
				extentTest.log(LogStatus.PASS, "Update voucher by adding ledger test case is successful");
			}else{
				System.err.println("Update voucher by adding ledger test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test035_UpdateVoucher_AddLedger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update voucher by adding ledger");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test036_UpdateVoucher_DeleteLedger() throws Exception{
		log.startTestCase("Update voucher by deleting ledger");
		extentTest = extent.startTest("Test036_UpdateVoucher_DeleteLedger",
				"Verify if voucher updated by deleting ledger").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(35, "Voucher");
			boolean flag = accounts.updateVoucher_DeleteLedger(35, "Voucher");
			if(flag){
				Constant.log.info("Update voucher by deleting ledger test case is successful");
				extentTest.log(LogStatus.PASS, "Update voucher by deleting ledger test case is successful");
			}else{
				System.err.println("Update voucher by deleting ledger test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test036_UpdateVoucher_DeleteLedger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update voucher by deleting ledger");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test037_UpdateVoucher_addLedgerValue() throws Exception{
		log.startTestCase("Update voucher by adding ledger value");
		extentTest = extent.startTest("Test037_UpdateVoucher_addLedgerValue",
				"Verify if voucher updated by adding ledger value").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(31, "Voucher");
			boolean flag = accounts.updateLedgerValues(36, "Voucher");
			if(flag){
				Constant.log.info("Update voucher by adding ledger value test case is successful");
				extentTest.log(LogStatus.PASS, "Update voucher by adding ledger value test case is successful");
			}else{
				System.err.println("Update voucher by adding ledger value test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test037_UpdateVoucher_addLedgerValue")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update voucher by adding ledger value");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test038_UpdateVoucher_addDeletedledger() throws Exception{
		log.startTestCase("Update voucher by adding deleted ledger");
		extentTest = extent.startTest("Test038_UpdateVoucher_addDeletedledger",
				"Verify if voucher updated by adding deleted ledger").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(37, "Voucher");
			boolean flag = accounts.updateVoucher_DeleteNAddLedger(37, "Voucher");
			if(flag){
				Constant.log.info("Update voucher by adding deleted ledger test case is successful");
				extentTest.log(LogStatus.PASS, "Update voucher by adding deleted ledger value test case is successful");
			}else{
				System.err.println("Update voucher by adding deleted ledger test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test038_UpdateVoucher_addDeletedledger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update voucher by adding deleted ledger");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test039_UpdateVoucher_DeleteledgerWBill() throws Exception{
		log.startTestCase("Update voucher by deleting ledger with bill");
		extentTest = extent.startTest("Test039_UpdateVoucher_DeleteledgerWBill",
				"Verify if voucher updated by deleting ledger with bill").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(38, "Voucher");
			boolean flag = accounts.updateVoucher_DeleteLedger(38, "Voucher");
			if(flag){
				Constant.log.info("Update voucher by deleting ledger with bill test case is successful");
				extentTest.log(LogStatus.PASS, "Update voucher by deleting ledger with bill test case is successful");
			}else{
				System.err.println("Update voucher by deleting ledger with bill test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test039_UpdateVoucher_DeleteledgerWBill")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update voucher by deleting ledger with bill");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test040_AddDiffLedgerDeletingExistLedger() throws Exception{
		log.startTestCase("Update voucher by adding different ledger after deleting existing ledgers");
		extentTest = extent.startTest("Test040_AddDiffLedgerDeletingExistLedger",
				"Verify if voucher updated by adding deleted ledger with bill").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(37, "Voucher");
			boolean flag = accounts.updateVoucher_DeleteNAddLedger(39, "Voucher");
			if(flag){
				Constant.log.info("Update voucher by adding different ledger after deleting existing ledgers test case is successful");
				extentTest.log(LogStatus.PASS, "Update voucher by adding different ledger after deleting existing ledgers value test case is successful");
			}else{
				System.err.println("Update voucher by adding different ledger after deleting existing ledgers test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test040_AddDiffLedgerDeletingExistLedger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update voucher by adding different ledger after deleting existing ledgers");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test041_UpdateVoucher_addDeletedledgerwBill() throws Exception{
		log.startTestCase("Update voucher by adding deleted ledger with bill");
		extentTest = extent.startTest("Test041_UpdateVoucher_addDeletedledgerwBill",
				"Verify if voucher updated by adding deleted ledger with bill").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(40, "Voucher");
			boolean flag = accounts.updateVoucher_DeleteNAddLedger(40, "Voucher");
			if(flag){
				Constant.log.info("Update voucher by adding deleted ledger with bill test case is successful");
				extentTest.log(LogStatus.PASS, "Update voucher by adding deleted ledger with bill value test case is successful");
			}else{
				System.err.println("Update voucher by adding deleted ledger with bill test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test041_UpdateVoucher_addDeletedledgerwBill")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update voucher by adding deleted ledger with bill");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test042_ValOpeningBal_DeleteNAddLedger() throws Exception{
		log.startTestCase("Validate opening balance by deleting and adding ledger");
		extentTest = extent.startTest("Test042_ValOpeningBal_DeleteNAddLedger",
				"Verify if opening balance is updated when ledger deleted and added in voucher").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		boolean flag = false;
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(40, "Voucher");
			String sOpBal = accounts.validateOpeningBal(40, "Voucher");
			String[] sOpBalList = sOpBal.split("\\s+");
			accounts.backBtn_Voucher.click();
			accounts.updateVoucher_DeleteNAddLedger(41, "Voucher");
			String sActOpBal = accounts.validateOpeningBal(40, "Voucher");
			String[] sActOpBalList = sActOpBal.split("\\s+");
			if(Double.parseDouble(sActOpBalList[0]) < Double.parseDouble(sOpBalList[0])){
				flag = true;
			}
			if(flag){
				Constant.log.info("Validate opening balance by deleting and adding ledger test case is successful");
				extentTest.log(LogStatus.PASS, "Validate opening balance by deleting and adding ledger test case is successful");
			}else{
				System.err.println("Validate opening balance by deleting and adding ledger test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test042_ValOpeningBal_DeleteNAddLedger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate opening balance by deleting and adding ledger");
	}

	@Test  @Category(SmokeTest.class)
	public void Test043_AddPurchaseVoucher() throws Exception{
		log.startTestCase("Create Purchase voucher");
		extentTest = extent.startTest("Test043_AddPurchaseVoucher",
				"Verify if purchase voucher is created").assignCategory("VoucherTestcases","SmokeTest");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(42, "Voucher");
			if(flag){
				Constant.log.info("Purchase voucher creation is successful");
				extentTest.log(LogStatus.PASS, "Purchase voucher creation is successful");
			}else{
				System.err.println("Purchase voucher creation failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test043_AddPurchaseVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create Purchase voucher");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test044_CreateSalesVoucher() throws Exception{
		log.startTestCase("Create Sales Voucher");
		extentTest = extent.startTest("Test044_CreateSalesVoucher",
				"Verify Sales voucher creation").assignCategory("VoucherTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(43,"Voucher");
			if(flag){
				Constant.log.info("Sales voucher creation validation test case is successful");
				extentTest.log(LogStatus.PASS, "Sales voucher creation validation test case is successful");
			}else{
				System.err.println("Sales voucher creation validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test044_CreateSalesVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create Sales Voucher");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test045_CreateNoteVoucher() throws Exception{
		log.startTestCase("Create Note Voucher");
		extentTest = extent.startTest("Test045_CreateNoteVoucher",
				"Verify Note voucher creation").assignCategory("VoucherTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(44,"Voucher");
			if(flag){
				Constant.log.info("Note voucher creation validation test case is successful");
				extentTest.log(LogStatus.PASS, "Note voucher creation validation test case is successful");
			}else{
				System.err.println("Note voucher creation validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test045_CreateNoteVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create Note Voucher");
	}

	@Test  @Category(SanityTests.class)
	public void Test049_CreateBankVoucher_receipt() throws Exception{
		log.startTestCase("Create Bank Voucher for receipt");
		extentTest = extent.startTest("Test049_CreateBankVoucher_receipt",
				"Verify Bank voucher creation for receipt").assignCategory("VoucherTestcases","SanityTests");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(48,"Voucher");
			if(flag){
				Constant.log.info("Bank voucher creation for receipt validation test case is successful");
				extentTest.log(LogStatus.PASS, "Bank voucher creation for receipt validation test case is successful");
			}else{
				System.err.println("Bank voucher creation for receipt validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test049_CreateBankVoucher_receipt")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create Bank Voucher for receipt");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test050_CreateBankVoucher_Payment() throws Exception{
		log.startTestCase("Create Bank Voucher for Payment");
		extentTest = extent.startTest("Test050_CreateBankVoucher_Payment",
				"Verify Bank voucher creation for Payment").assignCategory("VoucherTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(49,"Voucher");
			if(flag){
				Constant.log.info("Bank voucher creation for Payment validation test case is successful");
				extentTest.log(LogStatus.PASS, "Bank voucher creation for Payment validation test case is successful");
			}else{
				System.err.println("Bank voucher creation for Payment validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test050_CreateBankVoucher_Payment")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create Bank Voucher for Payment");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test051_CreateCashVoucher_Receipt() throws Exception{
		log.startTestCase("Create Cash Voucher for receipt");
		extentTest = extent.startTest("Test051_CreateCashVoucher_Receipt",
				"Verify Cash voucher creation for receipt").assignCategory("VoucherTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(50,"Voucher");
			if(flag){
				Constant.log.info("Cash voucher creation for receipt validation test case is successful");
				extentTest.log(LogStatus.PASS, "Cash voucher creation for receipt validation test case is successful");
			}else{
				System.err.println("Cash voucher creation for receipt validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test051_CreateCashVoucher_Receipt")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create Cash Voucher for receipt");
	}

	@Test  @Category(SanityTests.class)
	public void Test052_CreateCashVoucher_Payment() throws Exception{
		log.startTestCase("Create Cash Voucher for Payment");
		extentTest = extent.startTest("Test052_CreateCashVoucher_Payment",
				"Verify Cash voucher creation for Payment").assignCategory("VoucherTestcases","SanityTests");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(51,"Voucher");
			if(flag){
				Constant.log.info("Cash voucher creation for Payment validation test case is successful");
				extentTest.log(LogStatus.PASS, "Cash voucher creation for Payment validation test case is successful");
			}else{
				System.err.println("Cash voucher creation for Payment validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test052_CreateCashVoucher_Payment")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create Cash Voucher for Payment");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test053_UpdateBankLedger() throws Exception{
		log.startTestCase("Update BV with bank ledger");
		extentTest = extent.startTest("Test053_UpdateBankLedger",
				"Verify if BV updated with bank ledger").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(49, "Voucher");//dont change row no
			boolean flag = accounts.updateBankLedger(52, "Voucher");
			if(flag){
				Constant.log.info("Update BV with bank ledger test case is successful");
				extentTest.log(LogStatus.PASS, "Update BV with bank ledger test case is successful");
			}else{
				System.err.println("Update BV with bank ledger test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test053_UpdateBankLedger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update BV with bank ledger");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test054_UpdateTransNoNDesc_BV() throws Exception{
		log.startTestCase("Update Transaction no and Description of BV");
		extentTest = extent.startTest("Test054_UpdateTransNoNDesc_BV",
				"Verify if BV updated with transactin no and description").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(53, "Voucher");
			boolean flag = accounts.updateTransNoNDesc();
			if(flag){
				Constant.log.info("Update BV updated with transactin no and description test case is successful");
				extentTest.log(LogStatus.PASS, "Update BV updated with transactin no and description test case is successful");
			}else{
				System.err.println("Update BV updated with transactin no and description test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test054_UpdateTransNoNDesc_BV")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update BV updated with transactin no and description");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test057_UpdateBV_AddLedger() throws Exception{
		log.startTestCase("Update BV by adding Ledger");
		extentTest = extent.startTest("Test057_UpdateBV_AddLedger",
				"Verify if BV updated by adding ledger").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(53, "Voucher");
			boolean flag = accounts.updateVoucher_AddLedger(56, "Voucher");
			if(flag){
				Constant.log.info("Update BV by adding ledger test case is successful");
				extentTest.log(LogStatus.PASS, "Update BV by adding ledger test case is successful");
			}else{
				System.err.println("Update BV by adding ledger test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test057_UpdateBV_AddLedger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update BV by adding ledger");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test058_UpdateBV_DeleteLedger() throws Exception{
		log.startTestCase("Update BV by deleting ledger");
		extentTest = extent.startTest("Test058_UpdateBV_DeleteLedger",
				"Verify if BV updated by deleting ledger").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(57, "Voucher");
			boolean flag = accounts.updateVoucher_DeleteLedger(57, "Voucher");
			if(flag){
				Constant.log.info("Update BV by deleting ledger test case is successful");
				extentTest.log(LogStatus.PASS, "Update BV by deleting ledger test case is successful");
			}else{
				System.err.println("Update BV by deleting ledger test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test058_UpdateBV_DeleteLedger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update BV by deleting ledger");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test059_UpdateCashLedger() throws Exception{
		log.startTestCase("Update CV with Cash ledger");
		extentTest = extent.startTest("Test059_UpdateCashLedger",
				"Verify if CV updated with Cash ledger").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(50, "Voucher");//dont change row no
			boolean flag = accounts.updateBankLedger(58, "Voucher");
			if(flag){
				Constant.log.info("Update CV with Cash ledger test case is successful");
				extentTest.log(LogStatus.PASS, "Update CV with Cash ledger test case is successful");
			}else{
				System.err.println("Update CV with Cash ledger test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test059_UpdateCashLedger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update CV with Cash ledger");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test060_UpdateTransNoNDesc_CV() throws Exception{
		log.startTestCase("Update Transaction no and Description of CV");
		extentTest = extent.startTest("Test060_UpdateTransNoNDesc_CV",
				"Verify if CV updated with transactin no and description").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(59, "Voucher");
			boolean flag = accounts.updateTransNoNDesc();
			if(flag){
				Constant.log.info("Update CV updated with transactin no and description test case is successful");
				extentTest.log(LogStatus.PASS, "Update CV updated with transactin no and description test case is successful");
			}else{
				System.err.println("Update CV updated with transactin no and description test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test060_UpdateTransNoNDesc_CV")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update CV updated with transactin no and description");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test063_UpdateCV_AddLedger() throws Exception{
		log.startTestCase("Update CV by adding Ledger");
		extentTest = extent.startTest("Test057_UpdateCV_AddLedger",
				"Verify if CV updated by adding ledger").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(59, "Voucher");
			boolean flag = accounts.updateVoucher_AddLedger(62, "Voucher");
			if(flag){
				Constant.log.info("Update CV by adding ledger test case is successful");
				extentTest.log(LogStatus.PASS, "Update CV by adding ledger test case is successful");
			}else{
				System.err.println("Update CV by adding ledger test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test057_UpdateCV_AddLedger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update CV by adding ledger");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test064_UpdateCV_DeleteLedger() throws Exception{
		log.startTestCase("Update CV by deleting ledger");
		extentTest = extent.startTest("Test058_UpdateCV_DeleteLedger",
				"Verify if CV updated by deleting ledger").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			accounts.addVoucher(63, "Voucher");
			boolean flag = accounts.updateVoucher_DeleteLedger(63, "Voucher");
			if(flag){
				Constant.log.info("Update CV by deleting ledger test case is successful");
				extentTest.log(LogStatus.PASS, "Update CV by deleting ledger test case is successful");
			}else{
				System.err.println("Update CV by deleting ledger test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test058_UpdateCV_DeleteLedger")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update CV by deleting ledger");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test076_MismatchValueWarning() throws Exception{
		log.startTestCase("Mismatch Value Warning");
		extentTest = extent.startTest("Test076_MismatchValueWarning",
				"Verify if mismatched voucher values warning gets displayed").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.updateVoucher_MismatchValues();
			if(flag){
				Constant.log.info("Mismatched voucher values warning gets displayed test case is successful");
				extentTest.log(LogStatus.PASS, "Mismatched voucher values warning gets displayed test case is successful");
			}else{
				System.err.println("Mismatched voucher values warning gets displayed test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test076_MismatchValueWarning")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Mismatch Value Warning");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test077_UpdateOriginBillNo() throws Exception{
		log.startTestCase("Update Origin Bill No");
		extentTest = extent.startTest("Test077_UpdateOriginBillNo",
				"Verify if origin bill no is updated").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.updateOriginBillNo();
			if(flag){
				Constant.log.info("Update Origin Bill No test case is successful");
				extentTest.log(LogStatus.PASS, "Update Origin Bill No test case is successful");
			}else{
				System.err.println("Update Origin Bill No test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test077_UpdateOriginBillNo")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Origin Bill No");
	}

	@Category(SanityTests.class)
	@Test
	public void Test078_UpdateVoucher_billValue() throws Exception{
		log.startTestCase("Update voucher bill value");
		extentTest = extent.startTest("Test078_UpdateVoucher_billValue",
				"Verify bill value of voucher is updated").assignCategory("VoucherTestcases","SanityTests");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.updateVoucher_EditLedger(77, "Voucher");
			if(flag){
				Constant.log.info("Update bill value of voucher is successful");
				extentTest.log(LogStatus.PASS, "Update bill value of voucher is successful");
			}else{
				System.err.println("Update bill value of voucher failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test078_UpdateVoucher_billValue")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update bill value of voucher");
	}

	@Category(MediumPriorityTestCases.class)
	@Test
	public void Test079_UpdateVoucher_splitBillNo() throws Exception{
		log.startTestCase("Update voucher by splitting bill no");
		extentTest = extent.startTest("Test079_UpdateVoucher_splitBillNo",
				"Verify if voucher updated by splitting bill no").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.updateVoucher_SplitBillNo(78, "Voucher");
			if(flag){
				Constant.log.info("Update voucher by splitting bill no is successful");
				extentTest.log(LogStatus.PASS, "Update voucher by splitting bill no is successful");
			}else{
				System.err.println("Update voucher by splitting bill no failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test079_UpdateVoucher_splitBillNo")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update voucher by splitting bill no");
	}

	@Test @Category(SanityTests.class)
	public void Test080_ApprovePurchaseVoucher() throws Exception{
		log.startTestCase("Approve Purchase voucher");
		extentTest = extent.startTest("Test080_ApprovePurchaseVoucher",
				"Verify if Purchase voucher is Approved").assignCategory("VoucherTestcases","SanityTests");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(79, "Voucher",null);
			if(flag){
				Constant.log.info("Approve Purchase voucher is successful");
				extentTest.log(LogStatus.PASS, "Approve Purchase voucher is successful");
			}else{
				System.err.println("Approve Purchase voucher failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test080_ApprovePurchaseVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Purchase voucher");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test081_ApproveNoteVoucher() throws Exception{
		log.startTestCase("Approve Note voucher");
		extentTest = extent.startTest("Test081_ApproveNoteVoucher",
				"Verify if Note voucher is Approved").assignCategory("VoucherTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(80, "Voucher", null);
			if(flag){
				Constant.log.info("Approve Note voucher is successful");
				extentTest.log(LogStatus.PASS, "Approve Note voucher is successful");
			}else{
				System.err.println("Approve Note voucher failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test081_ApproveNoteVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Note voucher");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test082_ApproveSaleVoucher() throws Exception{
		log.startTestCase("Approve Sale voucher");
		extentTest = extent.startTest("Test082_ApproveSaleVoucher",
				"Verify if Sales voucher is Approved").assignCategory("VoucherTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(81, "Voucher", null);
			if(flag){
				Constant.log.info("Approve Sale voucher is successful");
				extentTest.log(LogStatus.PASS, "Approve Sale voucher is successful");
			}else{
				System.err.println("Approve Sale voucher failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test082_ApproveSaleVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Sale voucher");
	}

	@Test @Category(MediumPriorityTestCases.class)
	public void Test083_ApproveManualDebitnoteVoucher() throws Exception{
		log.startTestCase("Approve manual Debit note voucher");
		extentTest = extent.startTest("Test083_ApproveManualDebitnoteVoucher",
				"Verify if manual Debit note voucher is Approved").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			audit.verifyNote(82, "Voucher");
			int i = audit.grnNoList.size();
			String sIAN = audit.grnNoList.get(i-1).getText();
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(82, "Voucher", sIAN);
			if(flag){
				Constant.log.info("Approve manual Debit note voucher is successful");
				extentTest.log(LogStatus.PASS, "Approve manual Debit note voucher is successful");
			}else{
				System.err.println("Approve manual Debit note voucher failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test083_ApproveManualDebitnoteVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve manual Debit note voucher");
	}

	@Test @Category(MediumPriorityTestCases.class)
	public void Test084_ApproveManualCreditnoteVoucher() throws Exception{
		log.startTestCase("Approve manual Credit note voucher");
		extentTest = extent.startTest("Test084_ApproveManualCreditnoteVoucher",
				"Verify if manual Credit note voucher is Approved").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			audit.verifyNote(83, "Voucher");
			int i = audit.grnNoList.size();
			String sIAN = audit.grnNoList.get(i-1).getText();
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.approveVoucher(83, "Voucher", sIAN);
			if(flag){
				Constant.log.info("Approve manual Credit note voucher is successful");
				extentTest.log(LogStatus.PASS, "Approve manual Credit note voucher is successful");
			}else{
				System.err.println("Approve manual Credit note voucher failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test084_ApproveManualCreditnoteVoucher")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve manual Credit note voucher");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test086_SettleFullAmt_PurchaseBV() throws Exception{
		log.startTestCase("Settle full amount for Purchase bill");
		extentTest = extent.startTest("Test086_SettleFullAmt_PurchaseBV",
				"Verify purchase bill settled for full amount").assignCategory("VoucherTestcases","HighPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(85,"Voucher");
			if(flag){
				Constant.log.info("Verify purchase bill settled for full amount test case is successful");
				extentTest.log(LogStatus.PASS, "Verify purchase bill settled for full amount test case is successful");
			}else{
				System.err.println("Verify purchase bill settled for full amount test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test086_SettleFullAmt_PurchaseBV")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Settle full amount for Purchase bill");
	}

	@Test @Category(MediumPriorityTestCases.class)
	public void Test087_SettlePartialAmt_PurchaseBV() throws Exception{
		log.startTestCase("Settle Partial amount for Purchase bill");
		extentTest = extent.startTest("Test087_SettlePartialAmt_PurchaseBV",
				"Verify purchase bill settled for Partial amount").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(86,"Voucher");
			if(flag){
				Constant.log.info("Verify purchase bill settled for Partial amount test case is successful");
				extentTest.log(LogStatus.PASS, "Verify purchase bill settled for Partial amount test case is successful");
			}else{
				System.err.println("Verify purchase bill settled for Partial amount test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test087_SettlePartialAmt_PurchaseBV")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Settle Partial amount for Purchase bill");
	}

	@Test @Category(MediumPriorityTestCases.class)
	public void Test088_SettleGreaterAmt_PurchaseBV() throws Exception{
		log.startTestCase("Settle Greater amount for Purchase bill");
		extentTest = extent.startTest("Test088_SettleGreaterAmt_PurchaseBV",
				"Verify purchase bill settled for Greater amount").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.settlementAmtGreaterWarn(87,"Voucher");
			if(flag){
				Constant.log.info("Verify purchase bill settled for Greater amount test case is successful");
				extentTest.log(LogStatus.PASS, "Verify purchase bill settled for Greater amount test case is successful");
			}else{
				System.err.println("Verify purchase bill settled for Greater amount test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test088_SettleGreaterAmt_PurchaseBV")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Settle Greater amount for Purchase bill");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test089_SettleFullAmt_SalesBV() throws Exception{
		log.startTestCase("Settle full amount for Sales bill");
		extentTest = extent.startTest("Test089_SettleFullAmt_SalesBV",
				"Verify Sales bill settled for full amount");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(88,"Voucher");
			if(flag){
				Constant.log.info("Verify Sales bill settled for full amount test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Sales bill settled for full amount test case is successful");
			}else{
				System.err.println("Verify Sales bill settled for full amount test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test089_SettleFullAmt_SalesBV")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Settle full amount for Sales bill");
	}

	@Test @Category(MediumPriorityTestCases.class)
	public void Test090_SettlePartialAmt_SalesBV() throws Exception{
		log.startTestCase("Settle Partial amount for Sales bill");
		extentTest = extent.startTest("Test087_SettlePartialAmt_SalesBV",
				"Verify Sales bill settled for Partial amount").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(89,"Voucher");
			if(flag){
				Constant.log.info("Verify Sales bill settled for Partial amount test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Sales bill settled for Partial amount test case is successful");
			}else{
				System.err.println("Verify Sales bill settled for Partial amount test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test087_SettlePartialAmt_SalesBV")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Settle Partial amount for Sales bill");
	}

	@Test @Category(MediumPriorityTestCases.class)
	public void Test091_SettleGreaterAmt_SalesBV() throws Exception{
		log.startTestCase("Settle Greater amount for Sales bill");
		extentTest = extent.startTest("Test088_SettleGreaterAmt_SalesBV",
				"Verify Sales bill settled for Greater amount").assignCategory("VoucherTestcases","MediumPriorityTestCases");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.settlementAmtGreaterWarn(90,"Voucher");
			if(flag){
				Constant.log.info("Verify Sales bill settled for Greater amount test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Sales bill settled for Greater amount test case is successful");
			}else{
				System.err.println("Verify Sales bill settled for Greater amount test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test088_SettleGreaterAmt_SalesBV")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Settle Greater amount for Sales bill");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test092_SettleFullAmt_PurchaseCV() throws Exception{
		log.startTestCase("Settle full amount for Purchase bill");
		extentTest = extent.startTest("Test092_SettleFullAmt_PurchaseCV",
				"Verify purchase bill settled for full amount");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(91,"Voucher");
			if(flag){
				Constant.log.info("Verify purchase bill settled for full amount test case is successful");
				extentTest.log(LogStatus.PASS, "Verify purchase bill settled for full amount test case is successful");
			}else{
				System.err.println("Verify purchase bill settled for full amount test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test092_SettleFullAmt_PurchaseCV")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Settle full amount for Purchase bill");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test095_SettleFullAmt_SalesCV() throws Exception{
		log.startTestCase("Settle full amount for Sales bill");
		extentTest = extent.startTest("Test095_SettleFullAmt_SalesCV",
				"Verify Sales bill settled for full amount");
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			boolean flag = accounts.addVoucher(94,"Voucher");
			if(flag){
				Constant.log.info("Verify Sales bill settled for full amount test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Sales bill settled for full amount test case is successful");
			}else{
				System.err.println("Verify Sales bill settled for full amount test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test095_SettleFullAmt_SalesCV")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Settle full amount for Sales bill");
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
