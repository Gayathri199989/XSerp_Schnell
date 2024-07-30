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
import pages.AccountsPage;
import pages.LoginPage;
import pages.SalesPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvoiceTestCases {

	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
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
		Constant.logFile("Invoice");
		 //Browser Initialization
		 Constant.BrowserInitialization();

	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(SmokeTest.class)
	public void Test034_AddGSTInvoice_WithStock() throws Exception{
		log.startTestCase("Add GST Invoice with stock");
		extentTest = extent.startTest("Test034_AddGSTInvoice_WithStock",
				"Verify if GST Invoice with stock is added").assignCategory("InvoiceTestCases","SmokeTest");
		try{
			boolean flag = sales.addInvoice(33, "Invoice", null);
			if(flag){
				Constant.log.info("Verify if GST invoice with stock is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GST invoice with stock is added test case is successful");
			}else{
				System.err.println("GST invoice with stock is added test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test034_AddGSTInvoice_WithStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GST Invoice with stock");
	}

	@Test  @Category(SanityTests.class)
	public void Test035_AddGSTInvoice_WithStockNNonstock() throws Exception{
		log.startTestCase("Add GST Invoice with stock and non stock");
		extentTest = extent.startTest("Test035_AddGSTInvoice_WithStockNNonstock",
				"Verify if GST Invoice with stock and non stock is added").assignCategory("InvoiceTestCases","SanityTests");
		try{
			boolean flag = sales.addInvoice(34, "Invoice", null);
			if(flag){
				Constant.log.info("Verify if GST Invoice is added with stock and non stock test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GST Invoice with stock and non stock is added test case is successful");
			}else{
				System.err.println("GST Invoice is added test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test035_AddGSTInvoice_WithStockNNonstock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GST Invoice with stock and non stock");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test036_AddGSTInvoice_WithNonStock() throws Exception{
		log.startTestCase("Add GST Invoice with Non stock");
		extentTest = extent.startTest("Test036_AddGSTInvoice_WithNonStock",
				"Verify if GST Invoice with Non stock is added").assignCategory("InvoiceTestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.addInvoice(35, "Invoice", null);
			if(flag){
				Constant.log.info("Verify if GST invoice with Non stock is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GST invoice with Non stock is added test case is successful");
			}else{
				System.err.println("Add GST invoice with Non stock is added test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test036_AddGSTInvoice_WithNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GST Invoice with Non stock");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test037_AddGSTInvoice_OAFullQtyStock() throws Exception{
		log.startTestCase("Add GST Invoice with full pending qty of OA Stock Material");
		extentTest = extent.startTest("Test037_AddGSTInvoice_OAFullQtyStock",
				"Verify if GST Invoice is added with full pending qty of OA Stock Material").assignCategory("InvoiceTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			boolean flag = sales.addInvoiceWithOa(36,"Invoice");
			if(flag){
				Constant.log.info("Verify if GST Invoice is added with full pending qty of OA Stock Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GST invoice is added with full pending qty of OA Stock Material test case is successful");
			}else{
				System.err.println("GST Invoice is added with full pending qty of OA Stock Material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test037_AddGSTInvoice_OAFullQtyStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GST Invoice with full pending qty of OA Stock Material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test038_AddGSTInvoice_OAFullQtyNonStock() throws Exception{
		log.startTestCase("Add GST Invoice with full pending qty of OA Non Stock Material");
		extentTest = extent.startTest("Test038_AddGSTInvoice_OAFullQtyNonStock",
				"Verify if GST Invoice is added with full pending qty of OA Non Stock Material").assignCategory("InvoiceTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			boolean flag = sales.addInvoiceWithOa(37,"Invoice");
			if(flag){
				Constant.log.info("Verify if GST Invoice is added with full pending qty of OA Non Stock Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GST invoice is added with full pending qty of OA Non Stock Material test case is successful");
			}else{
				System.err.println("GST Invoice is added with full pending qty of OA Non Stock Material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test038_AddGSTInvoice_OAFullQtyNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GST Invoice with full pending qty of OA Non Stock Material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test039_AddGSTInvoice_OAFullQtyStockNNonStock() throws Exception{
		log.startTestCase("Add GST Invoice with full pending qty of OA Stock and Non Stock Material");
		extentTest = extent.startTest("Test039_AddGSTInvoice_OAFullQtyStockNNonStock",
				"Verify if GST Invoice is added with full pending qty of OA Stock and Non Stock Material").assignCategory("InvoiceTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			boolean flag = sales.addInvoiceWithOa(38,"Invoice");
			if(flag){
				Constant.log.info("Verify if GST Invoice is added with full pending qty of OA Stock and Non Stock Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GST invoice is added with full pending qty of OA Stock and Non Stock Material test case is successful");
			}else{
				System.err.println("GST Invoice is added with full pending qty of OA Stock and Non Stock Material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test039_AddGSTInvoice_OAFullQtyStockNNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GST Invoice with full pending qty of OA Stock and Non Stock Material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test040_AddGSTInvoice_OAHalfQtyStock() throws Exception{
		log.startTestCase("Add GST Invoice with Half pending qty of OA for Stock materials");
		extentTest = extent.startTest("Test040_AddGSTInvoice_OAHalfQtyStock",
				"Verify if GST Invoice is added with Half pending qty of OA for Stock materials").assignCategory("InvoiceTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			boolean flag = sales.addInvoiceWithOa(39,"Invoice");
			if(flag){
				Constant.log.info("Verify if GST Invoice is added with Half pending qty of OA for Stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GST Invoice is added with Half pending qty of OA for Stock materials test case is successful");
			}else{
				System.err.println("GST Invoice is added with Half pending qty of OA for Stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test040_AddGSTInvoice_OAHalfQtyStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GST Invoice with Half pending qty of OA for Stock materials");
	}

	@Test  @Category(SanityTests.class)
	public void Test041_AddGST_OAHalfQtyNonStock() throws Exception{
		log.startTestCase("Add GST Invoice with Half pending qty of OA for Non Stock materials");
		extentTest = extent.startTest("Test041_AddGST_OAHalfQtyNonStock",
				"Verify if GST Invoice is added with Half pending qty of OA for Non Stock materials").assignCategory("InvoiceTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			boolean flag = sales.addInvoiceWithOa(40,"Invoice");
			if(flag){
				Constant.log.info("Verify if GST Invoice is added with Half pending qty of OA for Non Stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GST Invoice is added with Half pending qty of OA for Non Stock materials test case is successful");
			}else{
				System.err.println("GST Invoice is added with Half pending qty of OA for Non Stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test041_AddGST_OAHalfQtyNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GST Invoice with Half pending qty of OA for Non Stock materials");
	}

	@Test  @Category(SanityTests.class)
	public void Test042_AddGSTInvoice_OAHalfQtyStockNNonStock() throws Exception{
		log.startTestCase("Add GST Invoice with Half pending qty of OA for Stock and Non Stock materials");
		extentTest = extent.startTest("Test042_AddGSTInvoice_OAHalfQtyStockNNonStock",
				"Verify if GST Invoice is added with Half pending qty of OA for Stock and Non Stock materials").assignCategory("InvoiceTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			boolean flag = sales.addInvoiceWithOa(41,"Invoice");
			if(flag){
				Constant.log.info("Verify if GST Invoice is added with Half pending qty of OA for Stock and Non Stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if GST Invoice is added with Half pending qty of OA for Stock and Non Stock materials test case is successful");
			}else{
				System.err.println("GST Invoice is added with Half pending qty of OA for Stock and Non Stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test042_AddGSTInvoice_OAHalfQtyStockNNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GST Invoice with Half pending qty of OA for Stock and Non Stock materials");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test050_AddExciseInvoice() throws Exception{
		log.startTestCase("Add Excise Invoice");
		extentTest = extent.startTest("Test050_AddExciseInvoice",
				"Verify if Excise Invoice is added").assignCategory("InvoiceTestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.addInvoice(49, "Invoice", null);
			if(flag){
				Constant.log.info("Verify if excise invoice is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if excise invoice is added test case is successful");
			}else{
				System.err.println("Excise invoice is added test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test050_AddExciseInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Excise Invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test051_AddTradingInvoice() throws Exception{
		log.startTestCase("Add Trading Invoice");
		extentTest = extent.startTest("Test051_AddTradingInvoice",
				"Verify if Trading Invoice is added").assignCategory("InvoiceTestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.addInvoice(50, "Invoice", null);
			if(flag){
				Constant.log.info("Verify if Trading invoice is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Trading invoice is added test case is successful");
			}else{
				System.err.println("Trading invoice is added test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test051_AddTradingInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Trading Invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test052_AddServiceLabourInvoice() throws Exception{
		log.startTestCase("Add Service/Labour Invoice");
		extentTest = extent.startTest("Test052_AddServiceLabourInvoice",
				"Verify if Service/Labour Invoice is added").assignCategory("InvoiceTestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.addInvoice(51, "Invoice", null);
			if(flag){
				Constant.log.info("Verify if Service/Labour invoice is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Service/Labour invoice is added test case is successful");
			}else{
				System.err.println("Service/Labour invoice is added test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test052_AddServiceLabourInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Service/Labour Invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test053_AddBillOfSupplyInvoice() throws Exception{
		log.startTestCase("Add Bill of supply Invoice");
		extentTest = extent.startTest("Test053_AddBillOfSupplyInvoice",
				"Verify if Bill of supply Invoice is added").assignCategory("InvoiceTestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.addInvoice(52, "Invoice", null);
			if(flag){
				Constant.log.info("Verify if Bill of supply invoice is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Bill of supply invoice is added test case is successful");
			}else{
				System.err.println("Bill of supply invoice is added test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test053_AddBillOfSupplyInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Bill of supply Invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test055_updateInvoiceAddingOA() throws Exception{
		log.startTestCase("Update invoice adding OA");
		extentTest = extent.startTest("Test055_updateInvoiceAddingOA",
				"Verify if invoice is updated adding OA").assignCategory("InvoiceTestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.updateInvoiceWithOa(54, "Invoice");
			if(flag){
				Constant.log.info("Verify if invoice is updated adding OA test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if invoice is updated adding OA test case is successful");
			}else{
				System.err.println("Verify if invoice is updated adding OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test055_updateInvoiceAddingOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update invoice adding OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test202_VerifyPrintAllOptions() throws Exception{
		log.startTestCase("Print All options verify");
		extentTest = extent.startTest("Test202_VerifyPrintAllOptions",
				"Verify if all print options can be printed").assignCategory("InvoiceTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			boolean flag = sales.printOptions(201, "Invoice");
			if(flag){
				Constant.log.info("Verify if all print options can be printed test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if all print options can be printed test case is successful");
			}else{
				System.err.println("Verify if all print options can be printed test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test202_VerifyPrintAllOptions")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Print All options verify");
	}

	/*
	@Test
	public void Test001_AddNListGridPageComponents() throws Exception{
		log.startTestCase("Add and List grid page components");
		extentTest = extent.startTest("Add and List grid components",
				"Verify if Add and List grid components are displayed properly");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = sales.verifyInvoiceComponents(0,"Invoice");
			if(flag1 == true){
				Constant.log.info("Validate add and list grid page components test case is successful");
				extentTest.log(LogStatus.PASS, "Validate add and list grid page components test case is successful");
			}else{
				System.err.println("Validation of Add and list grid page components test case failed ");
				Constant.captureScreen_Negative("Add and List grid page components");
				extentTest.log(LogStatus.FAIL, "Validation of Add and list grid page components test case failed ");
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add and List grid page components");
	}

	@Test
	public void Test002_DateWiseSearch() throws Exception{
		log.startTestCase("Date wise search");
		extentTest = extent.startTest("Date wise search",
				"Validate Date wise search ");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.last30Days();
			boolean flag1 = sales.currentMonth();
			boolean flag2 = sales.currentYear();
			boolean flag3 = sales.currentFinancialYear();
			boolean flag4 = sales.customRange();
			boolean flag5 = sales.lastMonth();
			boolean flag6 = sales.lastFinancialYear();
			if(flag == true && flag1 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true){
				Constant.log.info("Validation of date wise search field with all options are successful");
				extentTest.log(LogStatus.PASS, "Validation of date wise search field with all options are successful");
			}else{
				System.err.println("Validation of date wise search field with all options are unsuccessful ");
				Constant.captureScreen_Negative("Date wise search");
				extentTest.log(LogStatus.FAIL, "Validation of date wise search field with all options are unsuccessful");
			}
			Assert.assertTrue(flag == true && flag1 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Date wise search");
	}

	@Test
	public void Test003_StatusSearch() throws Exception{
		log.startTestCase("Status Search");
		extentTest = extent.startTest("Status Search",
				"Verify if Status Search is success");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.statusSearch();
			if(flag == true){
				Constant.log.info("Verify if Status Search test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Status Search test case is successful");
			}else{
				System.err.println("Status Search test case failed ");
				Constant.captureScreen_Negative("Status Search");
				extentTest.log(LogStatus.FAIL, "Status Search test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Status Search");
	}

	@Test
	public void Test004_PartyNameSearch() throws Exception{
		log.startTestCase("Party Name Search");
		extentTest = extent.startTest("Party Name Search",
				"Verify if Party Name Search is success");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.partyNameSearch(3,"Invoice");
			if(flag == true){
				Constant.log.info("Verify if Party Name Search test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Party Name Search test case is successful");
			}else{
				System.err.println("Party Name Search test case failed ");
				Constant.captureScreen_Negative("Party Name Search");
				extentTest.log(LogStatus.FAIL, "Party Name Search test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Party Name Search");
	}

	@Test
	public void Test005_PartyDateStatusSearch() throws Exception{
		log.startTestCase("Party, Date and status fields Search");
		extentTest = extent.startTest("Party, Date and status fields Search",
				"Verify if Party, Date and status fields Search is success");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.searchInvoice_PartyDateStatus(4,"Invoice");
			if(flag == true){
				Constant.log.info("Verify if Party, Date and status fields Search test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Party, Date and status fields Search test case is successful");
			}else{
				System.err.println("Party, Date and status fields Search test case failed ");
				Constant.captureScreen_Negative("Party, Date and status fields Search");
				extentTest.log(LogStatus.FAIL, "Party, Date and status fields Search test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Party, Date and status fields Search");
	}

	@Test
	public void Test006_InvoiceFetchedNumCheck() throws Exception{
		log.startTestCase("Invoice Fetched Number Check");
		extentTest = extent.startTest("Invoice Fetched Number Check",
				"Verify if Invoice Fetched number check is success");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.invoiceFetchedCheck(5, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Invoice Fetched number check test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Invoice Fetched number check test case is successful");
			}else{
				System.err.println("Invoice Fetched number check test case failed ");
				Constant.captureScreen_Negative("Invoice Fetched Number Check");
				extentTest.log(LogStatus.FAIL, "Invoice Fetched number check test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Invoice Fetched Number Check");
	}

	@Test
	public void Test007_PaginationCheck() throws Exception{
		log.startTestCase("Pagination Check");
		extentTest = extent.startTest("Pagination Check",
				"Verify if Pagination check is success");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.paginationValidation(6,"Invoice");
			if(flag == true){
				Constant.log.info("Verify if Pagination check test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Pagination check test case is successful");
			}else{
				System.err.println("Pagination check test case failed ");
				Constant.captureScreen_Negative("Pagination Check");
				extentTest.log(LogStatus.FAIL, "Pagination check test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Pagination Check");
	}

	@Test
	public void Test008_ValidateSorting() throws Exception{
		log.startTestCase("List grid columns sorting");
		extentTest = extent.startTest("List grid columns sorting",
				"Verify if list grid column sorting is successful");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validateListGridColumnSort_Asc();
			boolean flag1 = sales.validateListGridColumnSort_Dsc();
			if(flag == true && flag1 == true){
				Constant.log.info("Verify if list grid column sorting is successful");
				extentTest.log(LogStatus.PASS, "Verify if list grid column sorting is successful");
			}else{
				System.err.println("List grid column sorting check test case failed ");
				Constant.captureScreen_Negative("List grid columns sorting");
				extentTest.log(LogStatus.FAIL, "List grid column sorting failed");
			}
			Assert.assertTrue(flag == true && flag1 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("List grid columns sorting");
	}

	@Test
	public void Test009_FilterSearch() throws Exception{
		log.startTestCase("Filter Search");
		extentTest = extent.startTest("Filter Search",
				"Verify if Filter Search is success");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.filterSearch();
			if(flag == true){
				Constant.log.info("Verify if Filter Search test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Filter Search test case is successful");
			}else{
				System.err.println("Filter Search test case failed ");
				Constant.captureScreen_Negative("Filter Search");
				extentTest.log(LogStatus.FAIL, "Filter Search test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Filter Search");
	}

	@Test
	public void Test010_MandatoryFieldsCheck() throws Exception{
		log.startTestCase("Mandatory Fields check");
		extentTest = extent.startTest("Mandatory Fields check",
				"Verify if mandatory fields warning messages are displayed");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.mandatoryfieldsCheck(9,"Invoice");
			if(flag == true){
				Constant.log.info("Mandatory fields warning messages are displayed");
				extentTest.log(LogStatus.PASS, "Mandatory fields warning messages are displayed");
			}else{
				System.err.println("Mandatory fields warning messages are not displayed");
				Constant.captureScreen_Negative("Mandatory Fields check");
				extentTest.log(LogStatus.FAIL, "Mandatory fields warning messages are not displayed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Mandatory Fields check");
	}

	@Test
	public void Test011_CreateNewCustomer() throws Exception{
		log.startTestCase("Create New Customer");
		extentTest = extent.startTest("Create New Customer",
				"Verify if new customer is created in invoice page");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.createNewCustomer(10,"Invoice");
			if(flag == true){
				Constant.log.info("Create new customer in invoice add page test case is successful");
				extentTest.log(LogStatus.PASS, "Create new customer in invoice add page test case is successful");
			}else{
				System.err.println("Create new customer in invoice add page test case failed");
				Constant.captureScreen_Negative("Create New Customer");
				extentTest.log(LogStatus.FAIL, "Create new customer in invoice add page test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Create New Customer");
	}

	@Test
	public void Test012_SalesLedger_MainAcct() throws Exception{
		log.startTestCase("Sales ledger validation by adding main account group");
		extentTest = extent.startTest("Sales ledger validation by adding main account group",
				"Verify sales ledger validation by adding main account group");
		login.login();
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToLedger();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.salesLedgerValidation(11,"Invoice");
			if(flag == true){
				Constant.log.info("Sales ledger validation by adding main account group test case is successful");
				extentTest.log(LogStatus.PASS, "Sales ledger validation by adding main account group test case is successful");
			}else{
				System.err.println("Sales ledger validation by adding main account group test case failed");
				Constant.captureScreen_Negative("Sales ledger validation by adding main account group");
				extentTest.log(LogStatus.FAIL, "Sales ledger validation by adding main account group test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Sales ledger validation by adding main account group");
	}

	@Test
	public void Test013_SalesLedger_SubAcct() throws Exception{
		log.startTestCase("Sales ledger validation by adding sub account group");
		extentTest = extent.startTest("Sales ledger validation by adding sub account group",
				"Verify sales ledger validation ");
		login.login();
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToLedger();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.salesLedgerValidation(12,"Invoice");
			if(flag == true){
				Constant.log.info("Sales ledger validation by adding sub account group test case is successful");
				extentTest.log(LogStatus.PASS, "Sales ledger validation by adding sub account group test case is successful");
			}else{
				System.err.println("Sales ledger validation by adding sub account group test case failed");
				Constant.captureScreen_Negative("Sales ledger validation by adding sub account group");
				extentTest.log(LogStatus.FAIL, "Sales ledger validation by adding sub account group test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Sales ledger validation by adding sub account group");
	}

	@Test
	public void Test014_ValidateOaMaterialsPopup() throws Exception{
		log.startTestCase("Validate Oa Materials pop up");
		extentTest = extent.startTest("Validate Oa Materials pop up",
				"Verify oa materials pop up");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validateOAMaterialsPopup(13,"Invoice");
			if(flag == true){
				Constant.log.info("Validation of OA materials pop up test case is successful");
				extentTest.log(LogStatus.PASS, "Validation of OA materials pop up test case is successful");
			}else{
				System.err.println("Validation of OA materials test case failed ");
				Constant.captureScreen_Negative("Validate Oa Materials pop up");
				extentTest.log(LogStatus.FAIL, "Validation of OA materials test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate Oa Materials pop up");
	}

	@Test
	public void Test015_NetValue_StockMaterial() throws Exception{
		log.startTestCase("Validate Net Value for Stock Material");
		extentTest = extent.startTest("Validate Net Value for Stock Material",
				"Verify if net value is calculated correctly for stock material");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.netValue_StockMaterial(14);
			if(flag == true){
				Constant.log.info("Verify if net value is calculated correctly for stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if net value is calculated correctly for stock material test case is successful");
			}else{
				System.err.println("Net value is not calculated correctly for stock material ");
				Constant.captureScreen_Negative("Validate Net Value for Stock Material");
				extentTest.log(LogStatus.FAIL, "Net value is not calculated correctly for stock material ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate Net Value for Stock Material");
	}

	@Test
	public void Test017_deleteStockNNonStockMat() throws Exception{
		log.startTestCase("Delete Stock and non stock material");
		extentTest = extent.startTest("Delete Stock and non stock material",
				"Validate stock and non stock material delete");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.deleteAddedStockNNonStockMat(16,"Invoice");
			if(flag == true){
				Constant.log.info("Validate stock and non stock materials delete test case is successful");
				extentTest.log(LogStatus.PASS, "Validate stock and non stock materials delete  test case is successful");
			}else{
				System.err.println("Validate stock and non stock materials delete test case failed ");
				Constant.captureScreen_Negative("Delete Stock and non stock material");
				extentTest.log(LogStatus.FAIL, "Validate stock and non stock materials delete  test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Delete Stock and non stock material");
	}

	@Test
	public void Test018_MaterialAlreadyExistsPopUp() throws Exception{
		log.startTestCase("Material Already Exists pop up check");
		extentTest = extent.startTest("Material Already Exists pop up check",
				"Verify if Mandatory warning message is displayed when rejection remarks not entered");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validateMaterialAlreadyExists(17,"Invoice");
			if(flag == true){
				Constant.log.info("Mandatory warning pop up displayed when rejection remarks not entered");
				extentTest.log(LogStatus.PASS, "Mandatory warning pop up displayed when rejection remarks not entered");
			}else{
				System.err.println("Mandatory warning pop up not displayed when rejection remarks not entered");
				Constant.captureScreen_Negative("Material Already Exists pop up check");
				extentTest.log(LogStatus.FAIL, "Mandatory warning pop up not displayed when rejection remarks not entered");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Material Already Exists pop up check");
	}

	@Test
	public void Test020_StockMaterialAdded() throws Exception{
		log.startTestCase("Validate stock material is added");
		extentTest = extent.startTest("Validate stock material is added",
				"Validate stock material is added");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.AddedStockMaterial(19,"Invoice");
			if(flag == true){
				Constant.log.info("Validate stock material is added test case is successful");
				extentTest.log(LogStatus.PASS, "Validate stock material is added test case is successful");
			}else{
				System.err.println("Stock material addition test case failed ");
				Constant.captureScreen_Negative("Validate stock material is added");
				extentTest.log(LogStatus.FAIL, "Stock material addition test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate stock material is added");
	}

	 @Test
	public void Test022_ValidateTaxAddition() throws Exception{
		log.startTestCase("Validate Tax Addition");
		extentTest = extent.startTest("Validate Tax Addition",
				"Validate whether tax is added");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validateTax(21,"Invoice");
			if(flag == true){
				Constant.log.info("Validate Tax Addition test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Tax Addition test case is successful");
			}else{
				System.err.println("Tax Addition test case failed ");
				Constant.captureScreen_Negative("Validate Tax Addition");
				extentTest.log(LogStatus.FAIL, "Tax Addition test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate tax is added");
	}

	@Test
	public void Test023_ValidateCGSTAddition() throws Exception{
		log.startTestCase("Validate CGST Addition");
		extentTest = extent.startTest("Validate CGST Addition",
				"Validate whether CGST is added");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validateCGST(22,"Invoice");
			if(flag == true){
				Constant.log.info("Validate whether CGST addition test case is successful");
				extentTest.log(LogStatus.PASS, "Validate whether CGST addition test case is successful");
			}else{
				System.err.println("Validate whether CGST addition test case failed ");
				Constant.captureScreen_Negative("Validate CGST Addition");
				extentTest.log(LogStatus.FAIL, "Validate whether CGST addition test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate whether CGST is added");
	}

	@Test
	public void Test024_ValidateSGSTAddition() throws Exception{
		log.startTestCase("Validate SGST Addition");
		extentTest = extent.startTest("Validate SGST Addition",
				"Validate whether SGST is added");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validateSGST(23,"Invoice");
			if(flag == true){
				Constant.log.info("Validate whether SGST addition test case is successful");
				extentTest.log(LogStatus.PASS, "Validate whether SGST addition test case is successful");
			}else{
				System.err.println("SGST addition test case failed ");
				Constant.captureScreen_Negative("Validate SGST Addition");
				extentTest.log(LogStatus.FAIL, "SGST addition test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate whether SGST is added");
	}

	@Test
	public void Test025_ValidateIGSTAddition() throws Exception{
		log.startTestCase("Validate IGST Addition");
		extentTest = extent.startTest("Validate IGST Addition",
				"Validate whether IGST is added");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validateIGST(24,"Invoice");
			if(flag == true){
				Constant.log.info("Validate whether IGST addition test case is successful");
				extentTest.log(LogStatus.PASS, "Validate whether IGST addition test case is successful");
			}else{
				System.err.println("IGST addition test case failed ");
				Constant.captureScreen_Negative("Validate IGST Addition");
				extentTest.log(LogStatus.FAIL, "IGST addition test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate whether IGST is added");
	}

	@Test
	public void Test026_ValidateTaxValues() throws Exception{
		log.startTestCase("Validate Tax percentage values");
		extentTest = extent.startTest("Validate Tax percentage values",
				"Validate Tax percentage values");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validateTaxPercentage(25,"Invoice");
			if(flag == true){
				Constant.log.info("Validate Tax percentage values test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Tax percentage values test case is successful");
			}else{
				System.err.println("Tax percentage values test case failed ");
				Constant.captureScreen_Negative("Tax percentage values");
				extentTest.log(LogStatus.FAIL, "Tax percentage values test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate Tax percentage values");
	}

	@Test
	public void Test027_ValidateGrandTotalValue() throws Exception{
		log.startTestCase("Validate Grand total values");
		extentTest = extent.startTest("Validate Grand total values",
				"Validate Grand total values");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validategrandTotal(26,"Invoice");
			if(flag == true){
				Constant.log.info("Validate Grand total values test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Grand total values test case is successful");
			}else{
				System.err.println("Grand total values test case failed ");
				Constant.captureScreen_Negative("Grand total values");
				extentTest.log(LogStatus.FAIL, "Grand total values test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate Grand total values");
	}

	@Test
	public void Test028_ValidateRoundOffValue() throws Exception{
		log.startTestCase("Validate Round Off values");
		extentTest = extent.startTest("Validate Round Off values",
				"Validate Round Off values");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.validateRoundOff(27,"Invoice");
			if(flag == true){
				Constant.log.info("Validate Round Off values test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Round Off values test case is successful");
			}else{
				System.err.println("Round Off values test case failed ");
				Constant.captureScreen_Negative("Validate Round Off values");
				extentTest.log(LogStatus.FAIL, "Round Off values test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate Round Off values");
	}

	@Test
	public void Test029_PackingNTransportCharges_GST() throws Exception{
		log.startTestCase("Packing and Transports Charges with GST");
		extentTest = extent.startTest("Packing and Transports Charges with GST",
				"Verify packing and transport charges with GST");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			sales.addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.packingNTransport_GST(28, "Invoice");
			if(flag == true){
				Constant.log.info("Verify packing and transport charges with GST test case is successful");
				extentTest.log(LogStatus.PASS, "Verify packing and transport charges with GST test case is successful");
			}else{
				System.err.println("packing and transport charges with GST test case failed ");
				Constant.captureScreen_Negative("Packing and Transports Charges with GST");
				extentTest.log(LogStatus.FAIL, "packing and transport charges with GST test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Packing and Transports Charges with GST");
	}

	@Test
	public void Test030_PackingNTransport_WithoutGST() throws Exception{
		log.startTestCase("Packing and Transports Charges without GST");
		extentTest = extent.startTest("Packing and Transports Charges without GST",
				"Verify packing and transport charges without GST");
		login.login();
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			sales.addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = sales.packingNTransport();
			if(flag1 == true){
				Constant.log.info("Verify packing and transport charges without GST test case is successful");
				extentTest.log(LogStatus.PASS, "Verify packing and transport charges without GST test case is successful");
			}else{
				System.err.println("packing and transport charges without GST test case failed ");
				Constant.captureScreen_Negative("Packing and Transports Charges without GST");
				extentTest.log(LogStatus.FAIL, "packing and transport charges without GST test case failed");
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Packing and Transports Charges without GST");
	}



	@Test
	public void Test018_AddDeliveryChallanInvoice() throws Exception{
		log.startTestCase("Add Delivery Challan Invoice");
		extentTest = extent.startTest("Add Delivery Challan Invoice",
				"Verify if Delivery Challan Invoice is added");
		login.login();
		try{
			boolean flag = sales.addInvoice(17, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Delivery Challan invoice is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan invoice is added test case is successful");
			}else{
				System.err.println("Delivery Challan invoice is added test case failed ");
				Constant.captureScreen_Negative("Add Delivery Challan Invoice");
				extentTest.log(LogStatus.FAIL, "Delivery Challan invoice is added test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Delivery Challan Invoice");
	}

	@Test
	public void Test019_UpdateExcise_Material() throws Exception{
		log.startTestCase("Update Excise Invoice with Material");
		extentTest = extent.startTest("Update Excise Invoice with Material",
				"Verify if Excise Invoice is updated");
		login.login();
		try{
			boolean flag = sales.UpdateInvoiceChangingCount(18, "Invoice");
			boolean flag1 = sales.updateInvoicewithNewMaterial(18, "Invoice");
			boolean flag2 = sales.deleteItem(18, "Invoice");
			if(flag == true && flag1 == true && flag2 == true){
				Constant.log.info("Excise invoice is updated with new material test case is successful");
				extentTest.log(LogStatus.PASS, "Excise invoice is updated with new material test case is successful");
			}else{
				System.err.println("Excise invoice is updated with new material test case failed ");
				Constant.captureScreen_Negative("Update Excise Invoice with Material");
				extentTest.log(LogStatus.FAIL, "Excise invoice is updated with new material test case failed");
			}
			Assert.assertTrue(flag == true && flag1 == true && flag2 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Excise Invoice with Material");
	}

	@Test
	public void Test020_UpdateTrading_Material() throws Exception{
		log.startTestCase("Update Trading Invoice with Material");
		extentTest = extent.startTest("Update Trading Invoice with Material",
				"Verify if Trading Invoice is updated with Material");
		login.login();
		try{
			boolean flag = sales.UpdateInvoiceChangingCount(19, "Invoice");
			boolean flag1 = sales.updateInvoicewithNewMaterial(19, "Invoice");
			boolean flag2 = sales.deleteItem(19, "Invoice");
			if(flag == true && flag1 == true && flag2 == true){
				Constant.log.info("Verify if Trading invoice is updated with Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Trading invoice is updated with Material test case is successful");
			}else{
				System.err.println("Trading invoice is updated with Material test case failed ");
				Constant.captureScreen_Negative("Update Trading Invoice with Material");
				extentTest.log(LogStatus.FAIL, "Trading invoice is updated with Material test case failed");
			}
			Assert.assertTrue(flag == true && flag1 == true && flag2 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Trading Invoice with Material");
	}

	@Test
	public void Test021_UpdateServiceLabour_Material() throws Exception{
		log.startTestCase("Update Service Labour Invoice with Material");
		extentTest = extent.startTest("Update Service Labour Invoice with Material",
				"Verify if Service Labour Invoice is updated with Material");
		login.login();
		try{
			boolean flag = sales.UpdateInvoiceChangingCount(20, "Invoice");
			boolean flag1 = sales.updateInvoicewithNewMaterial(20, "Invoice");
			boolean flag2 = sales.deleteItem(20, "Invoice");
			if(flag == true && flag1 == true && flag2 == true){
				Constant.log.info("Verify if Service Labour invoice is updated with Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Service Labour invoice is updated with Material test case is successful");
			}else{
				System.err.println("Service Labour invoice is updated with Material test case failed ");
				Constant.captureScreen_Negative("Update Service Labour Invoice with Material");
				extentTest.log(LogStatus.FAIL, "Service Labour invoice is updated with Material test case failed");
			}
			Assert.assertTrue(flag == true && flag1 == true && flag2 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Service Labour Invoice with Material");
	}

	@Test
	public void Test022_UpdateTaxGST_Material() throws Exception{
		log.startTestCase("Update Tax GST Invoice with Material");
		extentTest = extent.startTest("Update Tax GST Invoice with Material",
				"Verify if Tax GST Invoice is updated with Material");
		login.login();
		try{
			boolean flag = sales.UpdateInvoiceChangingCount(21, "Invoice");
			boolean flag1 = sales.updateInvoicewithNewMaterial(21, "Invoice");
			boolean flag2 = sales.deleteItem(21, "Invoice");
			if(flag == true && flag1 == true && flag2 == true){
				Constant.log.info("Verify if Tax GST invoice is updated with Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Tax GST invoice is updated with Material test case is successful");
			}else{
				System.err.println("Tax GST invoice is updated with Material test case failed ");
				Constant.captureScreen_Negative("Update Tax GST Invoice");
				extentTest.log(LogStatus.FAIL, "Tax GST invoice is updated with Material test case failed");
			}
			Assert.assertTrue(flag == true && flag1 == true && flag2 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Tax GST Invoice with Material");
	}

	@Test
	public void Test023_UpdateBillOfSupply_Material() throws Exception{
		log.startTestCase("Update Bill Of Supply Invoice with Material");
		extentTest = extent.startTest("Update Bill Of Supply Invoice with Material",
				"Verify if Bill Of Supply Invoice is updated with Material");
		login.login();
		try{
			boolean flag = sales.UpdateInvoiceChangingCount(22, "Invoice");
			boolean flag1 = sales.updateInvoicewithNewMaterial(22, "Invoice");
			boolean flag2 = sales.deleteItem(22, "Invoice");
			if(flag == true && flag1 == true && flag2 == true){
				Constant.log.info("Verify if Bill Of Supply invoice is updated with Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Bill Of Supply invoice is updated with Material test case is successful");
			}else{
				System.err.println("Bill Of Supply invoice is updated with Material test case failed ");
				Constant.captureScreen_Negative("Update Bill Of Supply Invoice");
				extentTest.log(LogStatus.FAIL, "Bill Of Supply invoice is updated with Material test case failed");
			}
			Assert.assertTrue(flag == true && flag1 == true && flag2 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Bill Of Supply Invoice with Material");
	}

	@Test
	public void Test024_UpdateDeliveryChallan_Material() throws Exception{
		log.startTestCase("Update Delivery Challan Invoice with Material");
		extentTest = extent.startTest("Update Delivery Challan  Invoice with Material",
				"Verify if Delivery Challan Invoice is updated with Material");
		login.login();
		try{
			boolean flag = sales.UpdateInvoiceChangingCount(23, "Invoice");
			boolean flag1 = sales.updateInvoicewithNewMaterial(23, "Invoice");
			boolean flag2 = sales.deleteItem(23, "Invoice");
			if(flag == true && flag1 == true && flag2 == true){
				Constant.log.info("Verify if Delivery Challan invoice is updated with Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan invoice is updated with Material test case is successful");
			}else{
				System.err.println("Delivery Challan invoice is updated with Material test case failed ");
				Constant.captureScreen_Negative("Update Delivery Challan Invoice with Material");
				extentTest.log(LogStatus.FAIL, "Delivery Challan invoice is updated with Material test case failed");
			}
			Assert.assertTrue(flag == true && flag1 == true && flag2 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Delivery Challan Invoice with Material");
	}

	@Test
	public void Test025_ApproveExciseInvoice() throws Exception{
		log.startTestCase("Approve Excise Invoice");
		extentTest = extent.startTest("Approve Excise Invoice",
				"Verify if Excise Invoice is approved");
		login.login();
		try{
			boolean flag = sales.approveInvoice(24, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Excise invoice is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Excise invoice is approved test case is successful");
			}else{
				System.err.println("Excise invoice is approved test case failed ");
				Constant.captureScreen_Negative("Approve Excise Invoice");
				extentTest.log(LogStatus.FAIL, "Excise invoice is approved test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Excise Invoice");
	}

	@Test
	public void Test026_ApproveTradingInvoice() throws Exception{
		log.startTestCase("Approve Trading Invoice");
		extentTest = extent.startTest("Approve Trading Invoice",
				"Verify if Trading Invoice is approved");
		login.login();
		try{
			boolean flag = sales.approveInvoice(25, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Trading invoice is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Trading invoice is approved test case is successful");
			}else{
				System.err.println("Trading invoice is approved test case failed ");
				Constant.captureScreen_Negative("Approve Trading Invoice");
				extentTest.log(LogStatus.FAIL, "Trading invoice is approved test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Trading Invoice");
	}

	@Test
	public void Test027_ApproveServiceLabourInvoice() throws Exception{
		log.startTestCase("Approve Service Labour Invoice");
		extentTest = extent.startTest("Approve Service Labour Invoice",
				"Verify if Service Labour Invoice is approved");
		login.login();
		try{
			boolean flag = sales.approveInvoice(26, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Service Labour invoice is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Service Labour invoice is approved test case is successful");
			}else{
				System.err.println("Service Labour invoice is approved test case failed ");
				Constant.captureScreen_Negative("Approve Service Labour Invoice");
				extentTest.log(LogStatus.FAIL, "Service Labour invoice is approved test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Service Labour Invoice");
	}

	@Test
	public void Test028_ApproveTaxGSTInvoice() throws Exception{
		log.startTestCase("Approve Tax GST Invoice");
		extentTest = extent.startTest("Approve Tax GST Invoice",
				"Verify if Tax GST Invoice is approved");
		login.login();
		try{
			boolean flag = sales.approveInvoice(27, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Tax GST invoice is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Tax GST invoice is approved test case is successful");
			}else{
				System.err.println("Tax GST invoice is approved test case failed ");
				Constant.captureScreen_Negative("Approve Tax GST Invoice");
				extentTest.log(LogStatus.FAIL, "Tax GST invoice is approved test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Tax GST Invoice");
	}

	@Test
	public void Test029_ApproveBillOfSupplyInvoice() throws Exception{
		log.startTestCase("Approve Bill Of Supply Invoice");
		extentTest = extent.startTest("Approve Bill Of Supply Invoice",
				"Verify if Bill Of Supply Invoice is approved");
		login.login();
		try{
			boolean flag = sales.approveInvoice(28, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Bill Of Supply invoice is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Bill Of Supply invoice is approved test case is successful");
			}else{
				System.err.println("Bill Of Supply invoice is approved test case failed ");
				Constant.captureScreen_Negative("Approve Bill Of Supply Invoice");
				extentTest.log(LogStatus.FAIL, "Bill Of Supply invoice is approved test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Bill Of Supply Invoice");
	}

	@Test
	public void Test030_ApproveDeliveryChallanInvoice() throws Exception{
		log.startTestCase("Approve Delivery Challan Invoice");
		extentTest = extent.startTest("Approve Delivery Challan Invoice",
				"Verify if Delivery Challan Invoice is approved");
		login.login();
		try{
			boolean flag = sales.approveInvoice(29, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Delivery Challan invoice is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan invoice is approved test case is successful");
			}else{
				System.err.println("Delivery Challan invoice is approved test case failed ");
				Constant.captureScreen_Negative("Approve Delivery Challan Invoice");
				extentTest.log(LogStatus.FAIL, "Delivery Challan invoice is approved test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Delivery Challan Invoice");
	}

	@Test
	public void Test031_RejectDraftExciseInvoice() throws Exception{
		log.startTestCase("Reject Draft Excise Invoice");
		extentTest = extent.startTest("Reject Draft Excise Invoice",
				"Verify if drafted Excise Invoice is rejected");
		login.login();
		try{
			boolean flag = sales.rejectDraftInvoice(30, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if drafted Excise Invoice is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Excise Invoice is rejected test case is successful");
			}else{
				System.err.println("Drafted Excise Invoice is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Draft Excise Invoice");
				extentTest.log(LogStatus.FAIL, "Drafted Excise Invoice is rejected test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Excise Invoice");
	}

	@Test
	public void Test032_RecjectDraftTradingInvoice() throws Exception{
		log.startTestCase("Reject Draft Trading Invoice");
		extentTest = extent.startTest("Reject Draft Trading Invoice",
				"Verify if drafted Trading Invoice is rejected");
		login.login();
		try{
			boolean flag = sales.rejectDraftInvoice(31, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if drafted Trading Invoice is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Trading Invoice is rejected test case is successful");
			}else{
				System.err.println("Drafted Trading Invoice is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Draft Trading Invoice");
				extentTest.log(LogStatus.FAIL, "Drafted Trading Invoice is rejected test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Trading Invoice");
	}

	@Test
	public void Test033_RejectDraftServiceLabourInvoice() throws Exception{
		log.startTestCase("Reject Draft Service Labour Invoice");
		extentTest = extent.startTest("Reject Draft Service Labour Invoice",
				"Verify if drafted Service Labour Invoice is rejected");
		login.login();
		try{
			boolean flag = sales.rejectDraftInvoice(32, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if drafted Service Labour Invoice is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Service Labour Invoice is rejected test case is successful");
			}else{
				System.err.println("Drafted Service Labour Invoice is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Draft Service Labour Invoice");
				extentTest.log(LogStatus.FAIL, "Drafted Service Labour Invoice is rejected test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Service Labour Invoice");
	}

	@Test
	public void Test034_RejectDraftTaxGSTInvoice() throws Exception{
		log.startTestCase("Reject Draft Tax GST Invoice");
		extentTest = extent.startTest("Reject Draft Tax GST Invoice",
				"Verify if drafted Tax GST Invoice is rejected");
		login.login();
		try{
			boolean flag = sales.rejectDraftInvoice(33, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if drafted Tax GST Invoice is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Tax GST Invoice is rejected test case is successful");
			}else{
				System.err.println("Drafted Tax GST Invoice is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Draft Tax GST Invoice");
				extentTest.log(LogStatus.FAIL, "Drafted Tax GST Invoice is rejected test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Tax GST Invoice");
	}

	@Test
	public void Test035_RejectDraftBillOfSupplyInvoice() throws Exception{
		log.startTestCase("Reject drafted Bill Of Supply Invoice");
		extentTest = extent.startTest("Reject drafted Bill Of Supply Invoice",
				"Verify if drafted Bill Of Supply Invoice is rejected");
		login.login();
		try{
			boolean flag = sales.rejectDraftInvoice(34, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if drafted Bill Of Supply Invoice is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Bill Of Supply Invoice is rejected test case is successful");
			}else{
				System.err.println("Drafted Bill Of Supply Invoice is rejected test case failed ");
				Constant.captureScreen_Negative("Reject drafted Bill Of Supply Invoice");
				extentTest.log(LogStatus.FAIL, "Drafted Bill Of Supply Invoice is rejected test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject draft Bill Of Supply Invoice");
	}

	@Test
	public void Test036_RejectDraftDeliveryChallanInvoice() throws Exception{
		log.startTestCase("Reject draft Delivery Challan Invoice");
		extentTest = extent.startTest("Reject draft Delivery Challan Invoice",
				"Verify if draft Delivery Challan Invoice is reject");
		login.login();
		try{
			boolean flag = sales.rejectDraftInvoice(35, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if draft Delivery Challan Invoice is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if draft Delivery Challan Invoice is reject test case is successful");
			}else{
				System.err.println("Draft Delivery Challan Invoice is reject test case failed ");
				Constant.captureScreen_Negative("Reject draft Delivery Challan Invoice");
				extentTest.log(LogStatus.FAIL, "Draft Delivery Challan Invoice is reject test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject draft Delivery Challan Invoice");
	}

	@Test
	public void Test037_RejectApprovedExciseInvoice() throws Exception{
		log.startTestCase("Reject Approved Excise Invoice");
		extentTest = extent.startTest("Reject Approved Excise Invoice",
				"Verify if Approved Excise Invoice is rejected");
		login.login();
		try{
			boolean flag = sales.rejectApprovedInvoice(36, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Approved Excise Invoice is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Excise Invoice is rejected test case is successful");
			}else{
				System.err.println("Approved Excise Invoice is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Approved Excise Invoice");
				extentTest.log(LogStatus.FAIL, "Approved Excise Invoice is rejected test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Excise Invoice");
	}

	@Test
	public void Test038_RecjectApprovedTradingInvoice() throws Exception{
		log.startTestCase("Reject Approved Trading Invoice");
		extentTest = extent.startTest("Reject Approved Trading Invoice",
				"Verify if Approved Trading Invoice is rejected");
		login.login();
		try{
			boolean flag = sales.rejectApprovedInvoice(37, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Approved Trading Invoice is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Trading Invoice is rejected test case is successful");
			}else{
				System.err.println("Approved Trading Invoice is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Approved Trading Invoice");
				extentTest.log(LogStatus.FAIL, "Approved Trading Invoice is rejected test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Trading Invoice");
	}

	@Test
	public void Test039_RejectApprovedServiceLabourInvoice() throws Exception{
		log.startTestCase("Reject Approved Service Labour Invoice");
		extentTest = extent.startTest("Reject Approved Service Labour Invoice",
				"Verify if Approved Service Labour Invoice is rejected");
		login.login();
		try{
			boolean flag = sales.rejectApprovedInvoice(38, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Approved Service Labour Invoice is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Service Labour Invoice is rejected test case is successful");
			}else{
				System.err.println("Approved Service Labour Invoice is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Approved Service Labour Invoice");
				extentTest.log(LogStatus.FAIL, "Approved Service Labour Invoice is rejected test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Service Labour Invoice");
	}

	@Test
	public void Test040_RejectApprovedTaxGSTInvoice() throws Exception{
		log.startTestCase("Reject Approved Tax GST Invoice");
		extentTest = extent.startTest("Reject Approved Tax GST Invoice",
				"Verify if Approved Tax GST Invoice is rejected");
		login.login();
		try{
			boolean flag = sales.rejectApprovedInvoice(39, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Approved Tax GST Invoice is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Tax GST Invoice is rejected test case is successful");
			}else{
				System.err.println("Approved Tax GST Invoice is rejected test case failed ");
				Constant.captureScreen_Negative("Reject Approved Tax GST Invoice");
				extentTest.log(LogStatus.FAIL, "Approved Tax GST Invoice is rejected test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Tax GST Invoice");
	}

	@Test
	public void Test041_RejectApprovedBillOfSupplyInvoice() throws Exception{
		log.startTestCase("Reject Approved Bill Of Supply Invoice");
		extentTest = extent.startTest("Reject Approved Bill Of Supply Invoice",
				"Verify if approved Bill Of Supply Invoice is rejected");
		login.login();
		try{
			boolean flag = sales.rejectApprovedInvoice(40, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if approved Bill Of Supply Invoice is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if approved Bill Of Supply Invoice is rejected test case is successful");
			}else{
				System.err.println("Approved Bill Of Supply Invoice is rejected test case failed ");
				Constant.captureScreen_Negative("Reject approved Bill Of Supply Invoice");
				extentTest.log(LogStatus.FAIL, "Approved Bill Of Supply Invoice is rejected test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject approved Bill Of Supply Invoice");
	}

	@Test
	public void Test042_RejectApprovedDeliveryChallanInvoice() throws Exception{
		log.startTestCase("Reject Approved Delivery Challan Invoice");
		extentTest = extent.startTest("Reject Approved Delivery Challan Invoice",
				"Verify if Approved Delivery Challan Invoice is reject");
		login.login();
		try{
			boolean flag = sales.rejectApprovedInvoice(41, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Approved Delivery Challan Invoice is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Delivery Challan Invoice is reject test case is successful");
			}else{
				System.err.println("Approved Delivery Challan Invoice is reject test case failed ");
				Constant.captureScreen_Negative("Reject Approved Delivery Challan Invoice");
				extentTest.log(LogStatus.FAIL, "Approved Delivery Challan Invoice is reject test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Delivery Challan Invoice");
	}

	@Test
	public void Test048_AddMultipleItems_Excise() throws Exception{
		log.startTestCase("Add multiple items to the Excise invoice");
		extentTest = extent.startTest("Add multiple items to the Excise invoice",
				"Verify if Excise Invoice can be added with multiple items");
		login.login();
		try{
			boolean flag = sales.addInvoice(47, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Excise Invoice can be added with multiple items test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Excise Invoice can be added with multiple items test case is successful");
			}else{
				System.err.println("Excise Invoice can be added with multiple items test case failed ");
				Constant.captureScreen_Negative("Add multiple items to the Excise invoice");
				extentTest.log(LogStatus.FAIL, "Excise Invoice can be added with multiple items test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add multiple items to the Excise invoice");
	}

	@Test
	public void Test049_AddMultipleItems_Trading() throws Exception{
		log.startTestCase("Add multiple items to the Trading invoice");
		extentTest = extent.startTest("Add multiple items to the Trading invoice",
				"Verify if Trading Invoice can be added with multiple items");
		login.login();
		try{
			boolean flag = sales.addInvoice(47, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Trading Invoice can be added with multiple items test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Trading Invoice can be added with multiple items test case is successful");
			}else{
				System.err.println("Trading Invoice can be added with multiple items test case failed ");
				Constant.captureScreen_Negative("Add multiple items to the Trading invoice");
				extentTest.log(LogStatus.FAIL, "Trading Invoice can be added with multiple items test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add multiple items to the Trading invoice");
	}

	@Test
	public void Test050_AddMultipleItems_ServiceLabour() throws Exception{
		log.startTestCase("Add multiple items to the Service/Labour invoice");
		extentTest = extent.startTest("Add multiple items to the Service/Labour invoice",
				"Verify if Service/Labour Invoice can be added with multiple items");
		login.login();
		try{
			boolean flag = sales.addInvoice(47, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Service/Labour Invoice can be added with multiple items test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Service/Labour Invoice can be added with multiple items test case is successful");
			}else{
				System.err.println("Service/Labour Invoice can be added with multiple items test case failed ");
				Constant.captureScreen_Negative("Add multiple items to the Service/Labour invoice");
				extentTest.log(LogStatus.FAIL, "Service/Labour Invoice can be added with multiple items test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add multiple items to the Service/Labour invoice");
	}

	@Test
	public void Test051_AddMultipleItems_TaxInvoice() throws Exception{
		log.startTestCase("Add multiple items to the Tax invoice");
		extentTest = extent.startTest("Add multiple items to the Tax invoice",
				"Verify if Tax Invoice can be added with multiple items");
		login.login();
		try{
			boolean flag = sales.addInvoice(47, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Tax Invoice can be added with multiple items test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Tax Invoice can be added with multiple items test case is successful");
			}else{
				System.err.println("Tax Invoice can be added with multiple items test case failed ");
				Constant.captureScreen_Negative("Add multiple items to the Tax invoice");
				extentTest.log(LogStatus.FAIL, "Tax Invoice can be added with multiple items test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add multiple items to the Tax invoice");
	}

	@Test
	public void Test052_AddMultipleItems_BillOfSupplier() throws Exception{
		log.startTestCase("Add multiple items to the Bill Of Supplier invoice");
		extentTest = extent.startTest("Add multiple items to the Bill Of Supplier invoice",
				"Verify if Bill Of Supplier Invoice can be added with multiple items");
		login.login();
		try{
			boolean flag = sales.addInvoice(47, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Bill Of Supplier Invoice can be added with multiple items test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Bill Of Supplier Invoice can be added with multiple items test case is successful");
			}else{
				System.err.println("Bill Of Supplier Invoice can be added with multiple items test case failed ");
				Constant.captureScreen_Negative("Add multiple items to the Bill Of Supplier invoice");
				extentTest.log(LogStatus.FAIL, "Bill Of Supplier Invoice can be added with multiple items test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add multiple items to the Bill Of Supplier invoice");
	}

	@Test
	public void Test053_AddMultipleItems_DeliveryChallan() throws Exception{
		log.startTestCase("Add multiple items to the Delivery Challan invoice");
		extentTest = extent.startTest("Add multiple items to the Delivery Challan invoice",
				"Verify if Delivery Challan Invoice can be added with multiple items");
		login.login();
		try{
			boolean flag = sales.addInvoice(47, "Invoice", null);
			if(flag == true){
				Constant.log.info("Verify if Delivery Challan Invoice can be added with multiple items test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan Invoice can be added with multiple items test case is successful");
			}else{
				System.err.println("Delivery Challan Invoice can be added with multiple items test case failed ");
				Constant.captureScreen_Negative("Add multiple items to the Delivery Challan invoice");
				extentTest.log(LogStatus.FAIL, "Delivery Challan Invoice can be added with multiple items test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add multiple items to the Delivery Challan invoice");
	}

	@Test
	public void Test054_StockNotAvailable_Popup() throws Exception{
		log.startTestCase("Stock Not Available pop up");
		extentTest = extent.startTest("Stock Not Available pop up",
				"Verify if Stock not available pop up is displayed");
		login.login();
		try{
			boolean flag = sales.stockNotAvail_Popup(53);
			if(flag == true){
				Constant.log.info("Verify if Stock not available pop up is displayed test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Stock not available pop up is displayed test case is successful");
			}else{
				System.err.println("Stock not available pop up is displayed test case failed ");
				Constant.captureScreen_Negative("Stock Not Available pop up");
				extentTest.log(LogStatus.FAIL, "Stock not available pop up is displayed test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Stock Not Available pop up");
	}

	@Test
	public void Test056_DiscountValueCheck() throws Exception{
		log.startTestCase("Discount Value check");
		extentTest = extent.startTest("Discount Value check",
				"Verify if warning message displayed when invalid discount value entered");
		login.login();
		try{
			boolean flag = sales.checkDiscount(55);
			if(flag == true){
				Constant.log.info("Warning pop displayed when invalid discount value is entered");
				extentTest.log(LogStatus.PASS, "Warning pop displayed when invalid discount value is entered");
			}else{
				System.err.println("Warning pop displayed when invalid discount value is entered");
				Constant.captureScreen_Negative("Discount Value check");
				extentTest.log(LogStatus.FAIL, "Warning pop not displayed when invalid discount value is entered");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Discount Value check");
	}

	@Test
	public void Test057_AddInvoice_Usd() throws Exception{
		log.startTestCase("Add invoice with USD currency");
		extentTest = extent.startTest("Add invoice with USD currency",
				"Verify if invoice is added with USD currency");
		login.login();
		try{
			boolean flag = sales.addInvoice_USD(56, "Invoice");
			if(flag == true){
				Constant.log.info("Invoice is added with currency USD");
				extentTest.log(LogStatus.PASS, "Invoice is added with currency USD");
			}else{
				System.err.println("Invoice is not added with currency USD");
				Constant.captureScreen_Negative("Add invoice with USD currency");
				extentTest.log(LogStatus.FAIL, "Invoice is not added with currency USD");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add invoice with USD currency");
	}

	@Test
	public void Test058_CheckRejectionRemarkMandatory() throws Exception{
		log.startTestCase("Rejection Remarks Mandatory check");
		extentTest = extent.startTest("Rejection Remarks Mandatory check",
				"Verify if Mandatory warning message is displayed when rejection remarks not entered");
		login.login();
		try{
			boolean flag = sales.validateRejectionMandatory(57, "Invoice");
			if(flag == true){
				Constant.log.info("Mandatory warning pop up displayed when rejection remarks not entered");
				extentTest.log(LogStatus.PASS, "Mandatory warning pop up displayed when rejection remarks not entered");
			}else{
				System.err.println("Mandatory warning pop up not displayed when rejection remarks not entered");
				Constant.captureScreen_Negative("Rejection Remarks Mandatory check");
				extentTest.log(LogStatus.FAIL, "Mandatory warning pop up not displayed when rejection remarks not entered");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Rejection Remarks Mandatory check");
	}



	@Test
	public void Test060_CustomerListValidation() throws Exception{
		log.startTestCase("Customer List Validation");
		extentTest = extent.startTest("Customer List Validation",
				"validate customer list in invoice and party");
		login.login();
		try{
			boolean flag = sales.customerListValidation();
			if(flag == true){
				Constant.log.info("Customer list in invoice and party list matches");
				extentTest.log(LogStatus.PASS, "Customer list in invoice and party list matches");
			}else{
				System.err.println("Customer list in invoice and party list does not match");
				Constant.captureScreen_Negative("Customer List Validation");
				extentTest.log(LogStatus.FAIL, "Customer list in invoice and party list does not match");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Customer List Validation");
	}

	@Test
	public void Test061_validateListGridColumns() throws Exception{
		log.startTestCase("Validate list grid columns");
		extentTest = extent.startTest("Validate list grid columns",
				"validate if list grid columns are displayed");
		login.login();
		try{
			boolean flag = sales.validateListGridColumns(60);
			if(flag == true){
				Constant.log.info("Invoice list grid columns are displayed properly");
				extentTest.log(LogStatus.PASS, "Invoice list grid columns are displayed properly");
			}else{
				System.err.println("Invoice list grid columns are not displayed properly");
				Constant.captureScreen_Negative("Validate list grid columns");
				extentTest.log(LogStatus.FAIL, "Invoice list grid columns are not displayed properly");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate list grid columns");
	}

	@Test
	public void Test062_MandatoryFieldCheckEdit() throws Exception{
		log.startTestCase("Mandatory field check edit");
		extentTest = extent.startTest("Mandatory field check edit",
				"validate mandatory fields while editing the invoice");
		login.login();
		try{
			boolean flag = sales.mandatoryFieldsCheck_Edit(61, "Invoice");
			if(flag == true){
				Constant.log.info("Mandatory field check is successful while editing the invoice");
				extentTest.log(LogStatus.PASS, "Mandatory field check is successful while editing the invoice");
			}else{
				System.err.println("Mandatory field check is unsuccessful while editing the invoice");
				Constant.captureScreen_Negative("Mandatory field check edit");
				extentTest.log(LogStatus.FAIL, "Mandatory field check is unsuccessful while editing the invoice");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Mandatory field check edit");
	}

	@Test
	public void Test063_DateWiseSearchDeliveryChallan() throws Exception{
		log.startTestCase("Date wise search field in Delivery Challan");
		extentTest = extent.startTest("Date wise search field in Delivery Challan",
				"Verify Date wise search in Delivery Challan");
		login.login();
		try{
			boolean flag = sales.last30Days(62);
			boolean flag1 = sales.currentMonth();
			boolean flag2 = sales.currentYear();
			boolean flag3 = sales.currentFinancialYear();
			boolean flag4 = sales.customRange();
			if(flag == true && flag1 == true && flag2 == true && flag3 == true && flag4 == true){
				Constant.log.info("Date wise search in Delivery Challan is successful");
				extentTest.log(LogStatus.PASS, "Date wise search in Delivery Challan is successful");
			}else{
				System.err.println("Date wise search in Delivery Challan is unsuccessful ");
				Constant.captureScreen_Negative("Date wise search field in Delivery Challan");
				extentTest.log(LogStatus.FAIL, "Date wise search in Delivery Challan is unsuccessful");
			}
			Assert.assertTrue(flag == true && flag1 == true && flag2 == true && flag3 == true && flag4 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Date wise search field in Delivery Challan");
	}

	@Test
	public void Test064_MandatoryFieldCheckDeliveryChallan() throws Exception{
		log.startTestCase("Mandatory Fields check in Delivery Challan");
		extentTest = extent.startTest("Mandatory Fields check in Delivery Challan",
				"Verify if mandatory fields warning messages are displayed in Delivery Challan");
		login.login();
		try{
			boolean flag = sales.mandatoryfieldsCheck_DeliveryChallan(63);
			if(flag == true){
				Constant.log.info("Mandatory fields warning messages are displayed in Delivery Challan");
				extentTest.log(LogStatus.PASS, "Mandatory fields warning messages are displayed in Delivery Challan");
			}else{
				System.err.println("Mandatory fields warning messages are not displayed in Delivery Challan");
				Constant.captureScreen_Negative("Mandatory Fields check in Delivery Challan");
				extentTest.log(LogStatus.FAIL, "Mandatory fields warning messages are not displayed in Delivery Challan");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Mandatory Fields check in Delivery Challan");
	}

	@Test
	public void Test065_PartyNameSearchDeliveryChallan() throws Exception{
		log.startTestCase("Party Name Search in Delivery Challan");
		extentTest = extent.startTest("Party Name Search in Delivery Challan",
				"Verify if Party Name in Delivery Challan Search is success ");
		login.login();
		try{
			boolean flag = sales.partyNameSearch(64, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Party Name Search in Delivery Challan test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Party Name Search in Delivery Challan test case is successful");
			}else{
				System.err.println("Party Name Search in Delivery Challan test case failed ");
				Constant.captureScreen_Negative("Party Name Search in Delivery Challan");
				extentTest.log(LogStatus.FAIL, "Party Name in Delivery Challan Search test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Party Name Search in Delivery Challan");
	}

	@Test
	public void Test066_StatusSearch() throws Exception{
		log.startTestCase("Status Search in Delivery Challan");
		extentTest = extent.startTest("Status Search in Delivery Challan",
				"Verify if Status Search is success");
		login.login();
		try{
			boolean flag = sales.statusSearch(65);
			if(flag == true){
				Constant.log.info("Verify if Status Search in Delivery Challan test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Status Search in Delivery Challan test case is successful");
			}else{
				System.err.println("Status Search in Delivery Challan test case failed ");
				Constant.captureScreen_Negative("Status Search in Delivery Challan");
				extentTest.log(LogStatus.FAIL, "Status Search in Delivery Challan test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Status Search in Delivery Challan");
	}

	@Test
	public void Test067_FilterSearchDeliveryChallan() throws Exception{
		log.startTestCase("Filter Search in Delivery Challan");
		extentTest = extent.startTest("Filter Search in Delivery Challan",
				"Verify if Filter Search in Delivery Challan is success");
		login.login();
		try{
			boolean flag = sales.filterSearch(66);
			if(flag == true){
				Constant.log.info("Verify if Filter Search in Delivery Challan test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Filter Search in Delivery Challan test case is successful");
			}else{
				System.err.println("Filter Search in Delivery Challan test case failed ");
				Constant.captureScreen_Negative("Filter Search in Delivery Challan");
				extentTest.log(LogStatus.FAIL, "Filter Search in Delivery Challan test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Filter Search in Delivery Challan");
	}

	@Test
	public void Test068_UpdateExciseInvoice_Taxes() throws Exception{
		log.startTestCase("Update Excise invoice which has only mandatory fields filled");
		extentTest = extent.startTest("Update Excise invoice which has only mandatory fields filled",
				"Verify if Excise invoice with only mandatory field data can be updated");
		login.login();
		try{
			boolean flag = sales.updateInvoiceWithTaxes(67, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Exicse Excise with only mandatory field data can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Excise invoice with only mandatory field data can be updated test case is successful");
			}else{
				System.err.println("Excise Invoice with only mandatory field data can be update test case failed ");
				Constant.captureScreen_Negative("Update Excise invoice which has only mandatory fields filled");
				extentTest.log(LogStatus.FAIL, "Excise Invoice with only mandatory field data can be update test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Excise invoice which has only mandatory fields filled");
	}

	@Test
	public void Test069_UpdateTradingInvoice_Taxes() throws Exception{
		log.startTestCase("Update Trading invoice which has only mandatory fields filled");
		extentTest = extent.startTest("Update Trading invoice which has only mandatory fields filled",
				"Verify if Trading invoice with only mandatory field data can be updated");
		login.login();
		try{
			boolean flag = sales.updateInvoiceWithTaxes(68, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Trading invoice with only mandatory field data can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Trading invoice with only mandatory field data can be updated test case is successful");
			}else{
				System.err.println("Trading Invoice with only mandatory field data can be update test case failed ");
				Constant.captureScreen_Negative("Update Trading invoice which has only mandatory fields filled");
				extentTest.log(LogStatus.FAIL, "Trading Invoice with only mandatory field data can be update test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Trading invoice which has only mandatory fields filled");
	}

	@Test
	public void Test070_UpdateServiceLabourInvoice_Taxes() throws Exception{
		log.startTestCase("Update Service Labour invoice which has only mandatory fields filled");
		extentTest = extent.startTest("Update Service Labour invoice which has only mandatory fields filled",
				"Verify if Service Labour invoice with only mandatory field data can be updated");
		login.login();
		try{
			boolean flag = sales.updateInvoiceWithTaxes(69, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Service Labour invoice with only mandatory field data can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Service Labour invoice with only mandatory field data can be updated test case is successful");
			}else{
				System.err.println("Service Labour Invoice with only mandatory field data can be update test case failed ");
				Constant.captureScreen_Negative("Update Service Labour invoice which has only mandatory fields filled");
				extentTest.log(LogStatus.FAIL, "Service Labour Invoice with only mandatory field data can be update test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Service Labour invoice which has only mandatory fields filled");
	}

	@Test
	public void Test071_UpdateTaxInvoice_Taxes() throws Exception{
		log.startTestCase("Update Tax invoice which has only mandatory fields filled");
		extentTest = extent.startTest("Update Tax invoice which has only mandatory fields filled",
				"Verify if Tax invoice with only mandatory field data can be updated");
		login.login();
		try{
			boolean flag = sales.updateInvoiceWithTaxes(70, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Tax invoice with only mandatory field data can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Tax invoice with only mandatory field data can be updated test case is successful");
			}else{
				System.err.println("Tax Invoice with only mandatory field data can be update test case failed ");
				Constant.captureScreen_Negative("Update Tax invoice which has only mandatory fields filled");
				extentTest.log(LogStatus.FAIL, "Tax Invoice with only mandatory field data can be update test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Tax invoice which has only mandatory fields filled");
	}

	@Test
	public void Test072_UpdateBillOfSupplyInvoice_MandatoryFields() throws Exception{
		log.startTestCase("Update Bill Of Supply invoice which has only mandatory fields filled");
		extentTest = extent.startTest("Update Bill Of Supply invoice which has only mandatory fields filled",
				"Verify if Bill Of Supply invoice with only mandatory field data can be updated");
		login.login();
		try{
			boolean flag = sales.updateInvoiceWithTaxes(71, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Bill Of Supply invoice with only mandatory field data can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Bill Of Supply invoice with only mandatory field data can be updated test case is successful");
			}else{
				System.err.println("Bill Of Supply Invoice with only mandatory field data can be update test case failed ");
				Constant.captureScreen_Negative("Update Bill Of Supply invoice which has only mandatory fields filled");
				extentTest.log(LogStatus.FAIL, "Bill Of Supply Invoice with only mandatory field data can be update test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Bill Of Supply invoice which has only mandatory fields filled");
	}

	@Test
	public void Test073_UpdateDeliveryChallanInvoice_MandatoryFields() throws Exception{
		log.startTestCase("Update Delivery challan invoice which has only mandatory fields filled");
		extentTest = extent.startTest("Update Delivery challan invoice which has only mandatory fields filled",
				"Verify if Delivery challan invoice with only mandatory field data can be updated");
		login.login();
		try{
			boolean flag = sales.updateInvoiceWithTaxes(72, "Invoice");
			if(flag == true){
				Constant.log.info("Verify if Delivery challan invoice with only mandatory field data can be updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery challan invoice with only mandatory field data can be updated test case is successful");
			}else{
				System.err.println("Delivery challan Invoice with only mandatory field data can be update test case failed ");
				Constant.captureScreen_Negative("Update Delivery challan invoice which has only mandatory fields filled");
				extentTest.log(LogStatus.FAIL, "Delivery challan Invoice with only mandatory field data can be update test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Delivery challan invoice which has only mandatory fields filled");
	}

	*/

	@Test  @Category(SanityTests.class)
	public void Test066_UpdateTaxInvoice_Material() throws Exception{
		log.startTestCase("Update Tax Invoice  with Material");
		extentTest = extent.startTest("Test066_UpdateTaxInvoice_Material",
				"Verify if Tax Invoice  is updated").assignCategory("InvoiceTestCases","SanityTests");
		try{
			sales.addInvoice(65, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(65, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(65, "Sanity Test");
			boolean flag2 = sales.deleteItem(65, "Sanity Test");
			if(flag && flag1 && flag2){
				Constant.log.info("Tax Invoice  is updated with new material test case is successful");
				extentTest.log(LogStatus.PASS, "Tax Invoice  is updated with new material test case is successful");
			}else{
				System.err.println("Tax Invoice  is updated with new material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test066_UpdateTaxInvoice_Material")));
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Tax Invoice  with Material");
	}

	@Test  @Category(SanityTests.class)
	public void Test067_ApproveTaxInvoice() throws Exception{
		log.startTestCase("Approve Tax Invoice ");
		extentTest = extent.startTest("Test067_ApproveTaxInvoice",
				"Verify if Tax Invoice  is approved").assignCategory("InvoiceTestCases","SanityTests");
		try{
			boolean flag = sales.validateApproveInvoice(66, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Tax Invoice  is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Tax Invoice  is approved test case is successful");
			}else{
				System.err.println("Tax Invoice  is approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test067_ApproveTaxInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Tax Invoice ");
	}

	@Test  @Category(SanityTests.class)
	public void Test068_RejectDraftTaxInvoice () throws Exception{
		log.startTestCase("Reject Draft Tax Invoice ");
		extentTest = extent.startTest("Test068_RejectDraftTaxInvoice",
				"Verify if drafted Tax Invoice  is rejected").assignCategory("InvoiceTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectDraftInvoice(67, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if drafted Tax Invoice  is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Tax Invoice  is rejected test case is successful");
			}else{
				System.err.println("Drafted Tax Invoice  is rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test068_RejectDraftTaxInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Tax Invoice ");
	}

	@Test  @Category(SanityTests.class)
	public void Test069_RejectApprovedTaxInvoice () throws Exception{
		log.startTestCase("Reject Approved Tax Invoice ");
		extentTest = extent.startTest("Test069_RejectApprovedTaxInvoice",
				"Verify if Approved Tax Invoice  is rejected").assignCategory("InvoiceTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(68, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Tax Invoice  is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Tax Invoice  is rejected test case is successful");
			}else{
				System.err.println("Approved Tax Invoice  is rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test069_RejectApprovedTaxInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Tax Invoice ");
	}

	@Test  @Category(SanityTests.class)
	public void Test123_UpdateTaxInvoice_Material_OA() throws Exception{
		log.startTestCase("Update Tax Invoice  with OA");
		extentTest = extent.startTest("Test123_UpdateTaxInvoice_Material_OA",
				"Verify if Tax Invoice  is updated with OA").assignCategory("InvoiceTestCases","SanityTests");
		try{
			sales.addInvoice(122, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(122, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(122, "Sanity Test");
			boolean flag2 = sales.deleteItem(122, "Sanity Test");
			if(flag && flag1 && flag2){
				Constant.log.info("Tax Invoice  is updated with OA test case is successful");
				extentTest.log(LogStatus.PASS, "Tax Invoice  is updated with OA test case is successful");
			}else{
				System.err.println("Tax Invoice  is updated with OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test123_UpdateTaxInvoice_Material_OA")));
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Tax Invoice  with OA");
	}


	@Test  @Category(SanityTests.class)
	public void Test124_ApproveTaxInvoice_OA() throws Exception{
		log.startTestCase("Approve Tax Invoice with OA");
		extentTest = extent.startTest("Test124_ApproveTaxInvoice_OA",
				"Verify if Tax Invoice with OA is approved").assignCategory("InvoiceTestCases","SanityTests");
		try{
			boolean flag = sales.validateApproveInvoice(123, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Tax Invoice with OA is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Tax Invoice with OA is approved test case is successful");
			}else{
				System.err.println("Tax Invoice with OA is approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test124_ApproveTaxInvoice_OA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Tax Invoice  with OA");
	}

	@Test  @Category(SanityTests.class)
	public void Test125_RejectDraftTaxInvoice_OA() throws Exception{
		log.startTestCase("Reject Draft Tax Invoice  with OA");
		extentTest = extent.startTest("Test125_RejectDraftTaxInvoice_OA",
				"Verify if drafted Tax Invoice  with OA is rejected").assignCategory("InvoiceTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectDraftInvoice(124, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if drafted Tax Invoice  with OA is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Tax Invoice  with OA is rejected test case is successful");
			}else{
				System.err.println("Drafted Tax Invoice  with OA is rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test125_RejectDraftTaxInvoice_OA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Tax Invoice  with OA");
	}

	@Test  @Category(SanityTests.class)
	public void Test126_RejectApprovedTaxInvoice_OA() throws Exception{
		log.startTestCase("Reject Approved Tax Invoice with OA");
		extentTest = extent.startTest("Test126_RejectApprovedTaxInvoice_OA",
				"Verify if Approved Tax Invoice with OA is rejected").assignCategory("InvoiceTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(125, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Tax Invoice  with OA is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Tax Invoice  with OA is rejected test case is successful");
			}else{
				System.err.println("Approved Tax Invoice  with OA is rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test126_RejectApprovedTaxInvoice_OA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Tax Invoice  with OA");
	}

	@Test @Category(SanityTests.class)
	public void Test176_AddInvoice_Dc() throws Exception{
		log.startTestCase("ADD Invoice with DC");
		extentTest = extent.startTest("Test176_AddInvoice_Dc",
				"Verify if Invoice with DC").assignCategory("InvoiceTestCases","SanityTests");
		try{
			boolean flag = sales.addInvoice(175, "Sanity Test",null);
			if(flag){
				Constant.log.info("ADD Invoice with DC is successful");
				extentTest.log(LogStatus.PASS, "ADD Invoice with DC is successful");
			}else{
				System.err.println("ADD Invoice with DC failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test176_AddInvoice_Dc")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("ADD Invoice with DC");
	}

	@Test  @Category(SanityTests.class)
	public void Test177_UpdateInvoice_Dc() throws Exception{
		log.startTestCase("Update Invoice created with DC");
		extentTest = extent.startTest("Test177_UpdateInvoice_Dc",
				"Verify if Invoice created with DC is updated").assignCategory("InvoiceTestCases","SanityTests");
		try{
			sales.addInvoice(176, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(176, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(176, "Sanity Test");
 			if(flag && flag1){
				Constant.log.info("Invoice created with DC is updated with new material test case is successful");
				extentTest.log(LogStatus.PASS, "Invoice created with DC is updated with new material test case is successful");
			}else{
				System.err.println("Invoice created with DC is updated with new material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test177_UpdateInvoice_Dc")));
			}
			Assert.assertTrue(flag && flag1);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Invoice created with DC");
	}

	@Test  @Category(SanityTests.class)
	public void Test178_ApproveInvoice_Dc() throws Exception{
		log.startTestCase("Approve Invoice created with DC");
		extentTest = extent.startTest("Test178_ApproveInvoice_Dc",
				"Verify if Invoice created with DC is approved").assignCategory("InvoiceTestCases","SanityTests");
		try{
			boolean flag = sales.validateApproveInvoice(177, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Invoice created with DC is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Invoice created with DC is approved test case is successful");
			}else{
				System.err.println("Invoice created with DC is approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test178_ApproveInvoice_Dc")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Invoice created with DC");
	}

	@Test  @Category(SanityTests.class)
	public void Test179_DiscardInvoice_Dc() throws Exception{
		log.startTestCase("Reject Draft Invoice created with DC");
		extentTest = extent.startTest("Test179_DiscardInvoice_Dc",
				"Verify if drafted Invoice created with DC is rejected").assignCategory("InvoiceTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectDraftInvoice(178, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if drafted Invoice created with DC is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Invoice created with DC is rejected test case is successful");
			}else{
				System.err.println("Drafted Invoice created with DC is rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test179_DiscardInvoice_Dc")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Invoice created with DC");
	}

	@Test  @Category(SanityTests.class)
	public void Test180_RejectInvoice_Dc() throws Exception{
		log.startTestCase("Reject Approved Invoice created with DC");
		extentTest = extent.startTest("Test180_RejectInvoice_Dc",
				"Verify if Approved Invoice created with DC is rejected").assignCategory("InvoiceTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(179, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Invoice created with DC is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Invoice created with DC is rejected test case is successful");
			}else{
				System.err.println("Approved Invoice created with DC is rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test180_RejectInvoice_Dc")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Invoice created with DC");
	}

	@Test @Category(SanityTests.class)
	public void Test288_AddInvoice_AltUnit() throws Exception{
		log.startTestCase("ADD Invoice with alternate unit");
		extentTest = extent.startTest("Test288_AddInvoice_AltUnit",
				"Verify if Invoice with added with alternate unit").assignCategory("InvoiceTestCases","SanityTests");
		try{
			boolean flag = sales.addInvoice(287, "Sanity Test",null);
			if(flag){
				Constant.log.info("ADD Invoice with alternate unit is successful");
				extentTest.log(LogStatus.PASS, "ADD Invoice with alternate unit is successful");
			}else{
				System.err.println("ADD Invoice with alternate unit failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test288_AddInvoice_AltUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("ADD Invoice with alternate unit");
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
