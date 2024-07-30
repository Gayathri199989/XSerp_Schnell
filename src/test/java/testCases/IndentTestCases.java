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
import pages.PurchasePage;
import pages.SalesPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IndentTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
	ProfilePage master = PageFactory.initElements(Constant.driver, ProfilePage.class);
	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
	PurchasePage purchase = PageFactory.initElements(Constant.driver, PurchasePage.class);
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
		Constant.logFile("Indent");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(SmokeTest.class)
	public void Test055_AddStockIndent() throws Exception{
		log.startTestCase("Add Indent with stock materials");
		extentTest = extent.startTest("Test055_AddStockIndent",
				"Verify if indent is added with only stock materials").assignCategory("IndentTestCases","SmokeTest");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.verifyAddIndent(54,"IndentPO");
			if(flag){
				Constant.log.info("Add Indent with stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Add Indent with stock materials test case is successful");
			}else{
				System.err.println("Add Indent with stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test055_AddStockIndent")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Indent with stock materials");
	}

	@Test  @Category(SanityTests.class)
	public void Test056_AddNonStockIndent() throws Exception{
		log.startTestCase("Add Indent with non stock materials");
		extentTest = extent.startTest("Test056_AddNonStockIndent",
				"Verify if indent is added with only non stock materials").assignCategory("IndentTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.verifyAddIndent(55,"IndentPO");
			if(flag){
				Constant.log.info("Add Indent with non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Add Indent with non stock materials test case is successful");
			}else{
				System.err.println("Add Indent with non stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test056_AddNonStockIndent")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Indent with non stock materials");
	}

	@Test @Category(SanityTests.class)
	public void Test058_AddStockNNonStockIndent() throws Exception{
		log.startTestCase("Add Indent with stock and non stock materials");
		extentTest = extent.startTest("Test058_AddStockNNonStockIndent",
				"Verify if indent is added with stock and non stock materials").assignCategory("IndentTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.verifyAddIndent(57,"IndentPO");
			if(flag){
				Constant.log.info("Add Indent with stock and non stock materials test case is successful");
				extentTest.log(LogStatus.PASS, "Add Indent with stock and non stock materials test case is successful");
			}else{
				System.err.println("Add Indent with stock and non stock materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test058_AddStockNNonStockIndent")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Indent with stock and non stock materials");
	}

	@Category(SanityTests.class)
	@Test
	public void Test060_UpdateIndent() throws Exception{
		log.startTestCase("Update Indent");
		extentTest = extent.startTest("Test060_UpdateIndent",
				"Validate indent update").assignCategory("IndentTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.updateIndent(59,"IndentPO");
			if(flag){
				Constant.log.info("Validate whether indent update test case is successful");
				extentTest.log(LogStatus.PASS, "Validate whether indent update test case is successful");
			}else{
				System.err.println("Indent update test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test060_UpdateIndent")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Indent");
	}

	@Category(SanityTests.class)
	@Test
	public void Test076_IndentDelete() throws Exception{
		log.startTestCase("Delete Indent");
		extentTest = extent.startTest("Test076_IndentDelete",
				"Verify if indent is added").assignCategory("IndentTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.deleteIndent(75,"IndentPO");
			if(flag){
				Constant.log.info("Delete Indent test case is successful");
				extentTest.log(LogStatus.PASS, "Delete Indent test case is successful");
			}else{
				System.err.println("Delete Indent test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test076_IndentDelete")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("DeleteIndent");
	}

	@Test  @Category(SanityTests.class)
	public void Test085_PoShortClose() throws Exception{
		log.startTestCase("PO Short Close");
		extentTest = extent.startTest("Test085_PoShortClose",
				"Validate po short close link").assignCategory("IndentTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.validateShortClose(84, "IndentPO");
			if(flag){
				Constant.log.info("Po short close link validation test case is successful");
				extentTest.log(LogStatus.PASS, "Po short close link validation test case is successful");
			}else{
				System.err.println("Po short close link validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test085_PoShortClose")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("PO Short Close");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test153_CreateIndentPO_OtherBucket() throws Exception{
		log.startTestCase("Create PO from Indent PO with Other bucket");
		extentTest = extent.startTest("Test153_CreateIndentPO_OtherBucket",
				"Verify if PO can be created from Indent po page with Other bucket").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = store.createPO_IndentPo(152,"IndentPO");
			if(flag){
				Constant.log.info("Verify if PO can be created from Indent po page with Other bucket test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if PO can be created from Indent po page with Other bucket test case is successful");
			}else{
				System.err.println("Verify if PO can be created from Indent po page with Other bucket test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test153_CreateIndentPO_OtherBucket")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create PO from Indent PO with Other bucket");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test155_CreatePO_IndentPOSingleMat() throws Exception{
		log.startTestCase("Create PO from Indent PO with single material");
		extentTest = extent.startTest("Test155_CreatePO_IndentPOSingleMat",
				"Verify if PO can be created from Indent po page with single material").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = store.createPO_IndentPo(154,"IndentPO");
			if(flag){
				Constant.log.info("Verify if PO can be created from Indent po page with single material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if PO can be created from Indent po page with single material test case is successful");
			}else{
				System.err.println("Verify if PO can be created from Indent po page with single material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test155_CreatePO_IndentPOSingleMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create PO from Indent PO with single material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test157_CreateIndentPO_nonStock() throws Exception{
		log.startTestCase("Create PO from Indent PO with non stock material");
		extentTest = extent.startTest("Test157_CreateIndentPO_nonStock",
				"Verify if PO can be created from Indent po page with non stock material").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = store.createPO_IndentPo(156,"IndentPO");
			if(flag){
				Constant.log.info("Verify if PO can be created with non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if PO can be created with non stock material test case is successful");
			}else{
				System.err.println("Verify if PO can be created with non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test157_CreateIndentPO_nonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create PO from Indent PO with non stock material");
	}

	@Test  @Category(SanityTests.class)
	public void Test158_CreateIndentPO_StockNnonStock() throws Exception{
		log.startTestCase("Create PO from Indent PO with Stock N non stock material");
		extentTest = extent.startTest("Test158_CreateIndentPO_StockNnonStock",
				"Verify if PO can be created from Indent po page with Stock N non stock material").assignCategory("IndentTestCases","SanityTests");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = store.createPO_IndentPo(157,"IndentPO");
			if(flag){
				Constant.log.info("Verify if PO can be created with Stock N non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if PO can be created with Stock N non stock material test case is successful");
			}else{
				System.err.println("Verify if PO can be created with Stock N non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test158_CreateIndentPO_StockNnonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create PO from Indent PO with Stock N non stock material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test160_CreatePO_IndentPOPage() throws Exception{
		log.startTestCase("Create PO from Indent PO");
		extentTest = extent.startTest("Test160_CreatePO_IndentPOPage",
				"Verify if PO can be created from Indent po page").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = store.createPO_IndentPo(159,"Sanity Test");
			if(flag){
				Constant.log.info("Verify if PO can be created from Indent po page test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if PO can be created from Indent po page test case is successful");
			}else{
				System.err.println("Verify if PO can be created from Indent po page test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test160_CreatePO_IndentPOPage")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create PO from Indent PO");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test163_CreateIndentPO_POQtylessIndentQty() throws Exception{
		log.startTestCase("Create PO with PO qty less than indent qty");
		extentTest = extent.startTest("Test163_CreateIndentPO_POQtylessIndentQty",
				"Verify if PO can be created with PO qty less than indent qty").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = store.createPO_IndentPo(162,"IndentPO");
			if(flag){
				Constant.log.info("Verify if PO can be created with PO qty less than indent qty test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if PO can be created with PO qty less than indent qty test case is successful");
			}else{
				System.err.println("Verify if PO can be created with PO qty less than indent qty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test163_CreateIndentPO_POQtylessIndentQty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create PO from Indent PO with PO qty less than indent qty");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test164_CreateIndentPO_POAlreadyCreated() throws Exception{
		log.startTestCase("Create PO from Indent for which Po already created");
		extentTest = extent.startTest("Test164_CreateIndentPO_POAlreadyCreated",
				"Verify if PO can be created from Indent for which Po already created").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			store.createIndentPO(163,"IndentPO");
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = store.createPO_ExistingIndent(163,"IndentPO");
			if(flag){
				Constant.log.info("Verify if PO can be created for which Po already created test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if PO can be created for which Po already created test case is successful");
			}else{
				System.err.println("Verify if PO can be created for which Po already created test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test164_CreateIndentPO_POAlreadyCreated")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create PO from Indent PO for which Po already created");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test165_CreateIndentJO_SingleMat() throws Exception{
		log.startTestCase("Create JO from Indent with single material");
		extentTest = extent.startTest("Test165_CreateIndentJO_SingleMat",
				"Verify if JO can be created from Indent with single material").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = store.createPO_IndentPo(164,"IndentPO");
			if(flag){
				Constant.log.info("Verify if JO can be created with single material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if JO can be created with single material test case is successful");
			}else{
				System.err.println("Verify if JO can be created with single material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test165_CreateIndentJO_SingleMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create JO can be created with single material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test167_CreateIndentPO_nonStock() throws Exception{
		log.startTestCase("Create JO from Indent JO with non stock material");
		extentTest = extent.startTest("Test167_CreateIndentPO_nonStock",
				"Verify if JO can be created from Indent JO page with non stock material").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = store.createPO_IndentPo(166,"IndentPO");
			if(flag){
				Constant.log.info("Verify if JO can be created with non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if JO can be created with non stock material test case is successful");
			}else{
				System.err.println("Verify if JO can be created with non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test167_CreateIndentPO_nonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create JO from Indent JO with non stock material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test168_CreateIndentJO_StockNnonStock() throws Exception{
		log.startTestCase("Create JO from Indent JO with Stock N non stock material");
		extentTest = extent.startTest("Test168_CreateIndentJO_StockNnonStock",
				"Verify if JO can be created from Indent JO page with Stock N non stock material").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = store.createPO_IndentPo(167,"IndentPO");
			if(flag){
				Constant.log.info("Verify if JO can be created with Stock N non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if JO can be created with Stock N non stock material test case is successful");
			}else{
				System.err.println("Verify if JO can be created with Stock N non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test168_CreateIndentJO_StockNnonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Create JO from Indent JO with Stock N non stock material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test209_ApproveIndentPO() throws Exception{
		log.startTestCase("Approve Indent PO");
		extentTest = extent.startTest("Test209_ApproveIndentPO",
				"Verify if indent po can be approved").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.approveIndentPO(208,"IndentPO");
			if(flag){
				Constant.log.info("Verify if indent po can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if indent po can be approved test case is successful");
			}else{
				System.err.println("Verify if indent po can be approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test209_ApproveIndentPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Indent PO");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test210_ApproveIndentJO() throws Exception{
		log.startTestCase("Approve Indent JO");
		extentTest = extent.startTest("Test210_ApproveIndentJO",
				"Verify if indent JO can be approved").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.approveIndentPO(209,"IndentPO");
			if(flag){
				Constant.log.info("Verify if indent JO can be approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if indent JO can be approved test case is successful");
			}else{
				System.err.println("Verify if indent JO can be approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test210_ApproveIndentJO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Indent JO");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test215_DiscardIndentPO() throws Exception{
		log.startTestCase("Discard Indent PO");
		extentTest = extent.startTest("Test215_DiscardIndentPO",
				"Verify if indent po can be Discardd").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.discardIndentPO(214,"IndentPO");
			if(flag){
				Constant.log.info("Verify if indent po can be Discardd test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if indent po can be Discardd test case is successful");
			}else{
				System.err.println("Verify if indent po can be Discardd test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test215_DiscardIndentPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Discard Indent PO");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test216_DiscardIndentJO() throws Exception{
		log.startTestCase("Discard Indent JO");
		extentTest = extent.startTest("Test216_DiscardIndentJO",
				"Verify if indent JO can be Discard").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.discardIndentPO(215,"IndentPO");
			if(flag){
				Constant.log.info("Verify if indent JO can be Discardd test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if indent JO can be Discardd test case is successful");
			}else{
				System.err.println("Verify if indent JO can be Discardd test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test216_DiscardIndentJO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Discard Indent JO");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test217_RejectApprovedIndentPO() throws Exception{
		log.startTestCase("RejectApproved Indent PO");
		extentTest = extent.startTest("Test217_RejectApprovedIndentPO",
				"Verify if indent po can be RejectApprovedd").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.rejectApprovedIndentPO(216,"IndentPO");
			if(flag){
				Constant.log.info("Verify if indent po can be RejectApprovedd test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if indent po can be RejectApprovedd test case is successful");
			}else{
				System.err.println("Verify if indent po can be RejectApprovedd test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test217_RejectApprovedIndentPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("RejectApproved Indent PO");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test218_RejectApprovedIndentJO() throws Exception{
		log.startTestCase("RejectApproved Indent JO");
		extentTest = extent.startTest("Test218_RejectApprovedIndentJO",
				"Verify if indent JO can be RejectApproved").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.rejectApprovedIndentPO(217,"IndentPO");
			if(flag){
				Constant.log.info("Verify if indent JO can be RejectApprovedd test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if indent JO can be RejectApprovedd test case is successful");
			}else{
				System.err.println("Verify if indent JO can be RejectApprovedd test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test218_RejectApprovedIndentJO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("RejectApproved Indent JO");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test219_AmendIndentPO() throws Exception{
		log.startTestCase("Amend Indent PO");
		extentTest = extent.startTest("Test219_AmendIndentPO",
				"Verify if indent po can be Amendd").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.amendIndentPO(218,"IndentPO");
			if(flag){
				Constant.log.info("Verify if indent po can be Amendd test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if indent po can be Amendd test case is successful");
			}else{
				System.err.println("Verify if indent po can be Amendd test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test219_AmendIndentPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend Indent PO");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test220_AmendIndentJO() throws Exception{
		log.startTestCase("Amend Indent JO");
		extentTest = extent.startTest("Test220_AmendIndentJO",
				"Verify if indent JO can be Amend").assignCategory("IndentTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = purchase.amendIndentPO(219,"IndentPO");
			if(flag){
				Constant.log.info("Verify if indent JO can be Amendd test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if indent JO can be Amendd test case is successful");
			}else{
				System.err.println("Verify if indent JO can be Amendd test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test220_AmendIndentJO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend Indent JO");
	}

	@Test  @Category(SanityTests.class)
	public void Test253_AddIndent_AltUnit() throws Exception{
		log.startTestCase("Add Indent with alternate unit");
		extentTest = extent.startTest("Test253_AddIndent_AltUnit",
				"Verify if indent is added with alternate unit").assignCategory("IndentTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.verifyAddIndent(252,"Sanity Test");
			if(flag){
				Constant.log.info("Add Indent with alternate unit test case is successful");
				extentTest.log(LogStatus.PASS, "Add Indent with alternate unit test case is successful");
			}else{
				System.err.println("Add Indent with alternate unit test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test253_AddIndent_AltUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Indent with alternate unit");
	}

	@Test  @Category(SanityTests.class)
	public void Test266_AddIndent_NewMaterial() throws Exception{
		log.startTestCase("Add Indent with new material");
		extentTest = extent.startTest("Test266_AddIndent_NewMaterial",
				"Verify if indent is added with new material").assignCategory("IndentTestCases","SanityTests");
		boolean flag = false;
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			int iCount = master.materialCountWithNonStock();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			store.verifyAddIndent(265,"Sanity Test");
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			int iAfterAddition = master.materialCountWithNonStock();
			if(iAfterAddition > iCount){
				flag = true;
			}
			if(flag){
				Constant.log.info("Add Indent with new material test case is successful");
				extentTest.log(LogStatus.PASS, "Add Indent with new material test case is successful");
			}else{
				System.err.println("Add Indent new material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test266_AddIndent_NewMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Indent new material");
	}

	@Test  @Category(SanityTests.class)
	public void Test268_addindentpo_SPQPOpup() throws Exception{
		log.startTestCase("Add Indent po with spq warning");
		extentTest = extent.startTest("Test268_addindentpo_SPQPOpup",
				"Verify if indent po is added with spq warning").assignCategory("IndentTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			boolean flag = store.addindentpo_spq(267,"Sanity Test");
			if(flag){
				Constant.log.info("Add Indent po with spq warning test case is successful");
				extentTest.log(LogStatus.PASS, "Add Indent po with spq warning test case is successful");
			}else{
				System.err.println("Add Indent po with spq warning test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test268_addindentpo_SPQPOpup")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Indent po with spq warning");
	}


	/*
	@Test
	public void Test003_IndentSearchProject() throws Exception{
		log.startTestCase("Indent Search Project");
		extentTest = extent.startTest("Indent Search Project",
				"Verify whether indent project search works");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.indentProjectSearch(2);
			if(flag == true){
				Constant.log.info("Indent project search test case is successful");
				extentTest.log(LogStatus.PASS, "Indent project search test case is successful");
			}else{
				System.err.println("Indent project search test case failed ");
				Constant.captureScreen_Negative("Indent Search Project");
				extentTest.log(LogStatus.FAIL, "Indent project search test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Indent Search Project");
	}

	@Test
	public void Test004_IndentNumSearch() throws Exception{
		log.startTestCase("IndentNumberSearch");
		extentTest = extent.startTest("Indent Number Search",
				"Verify whether indent number search works");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.indentNumSearch(3,"Indent");
			if(flag == true){
				Constant.log.info("Indent number search test case is successful");
				extentTest.log(LogStatus.PASS, "Indent number search test case is successful");
			}else{
				System.err.println("Indent number search test case failed ");
				Constant.captureScreen_Negative("IndentNumberSearch");
				extentTest.log(LogStatus.FAIL, "Indent number search test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("IndentNumberSearch");
	}

	@Test
	public void Test005_BOMCancelBtncheck() throws Exception{
		log.startTestCase("BOM Pop up Cancel button");
		extentTest = extent.startTest("BOM Pop up Cancel button",
				"Verify whether cancel button works in BOM pop up");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.bomCancelBtn(4);
			if(flag == true){
				Constant.log.info("Verify whether cancel button works in BOM pop up test case is successful");
				extentTest.log(LogStatus.PASS, "Verify whether cancel button works in BOM pop up test case is successful");
			}else{
				System.err.println("Verify whether cancel button works in BOM pop up test case failed ");
				Constant.captureScreen_Negative("BOM Pop up Cancel button");
				extentTest.log(LogStatus.FAIL, "Verify whether cancel button works in BOM pop up test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("BOM Pop up Cancel button");
	}

	@Test
	public void Test006_IndentWithBOM() throws Exception{
		log.startTestCase("Indent With BOM");
		extentTest = extent.startTest("Indent With BOM",
				"Verify whether indent with BOM can be created");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.bomAddBtn(5);
			if(flag == true){
				Constant.log.info("Verify indent with BOM test case is successful");
				extentTest.log(LogStatus.PASS, "Verify indent with BOM test case is successful");
			}else{
				System.err.println("Verify indent with BOM test case failed ");
				Constant.captureScreen_Negative("Indent With BOM");
				extentTest.log(LogStatus.FAIL, "Verify indent with BOM test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Indent With BOM");
	}

	@Test
	public void Test007_BOMDelete_ConfirmationYes() throws Exception{
		log.startTestCase("Delete a material from BOM");
		extentTest = extent.startTest("Delete a material from BOM",
				"Verify whether a material is deleted from BOM");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.bomMaterialDelete_Yes(6);
			if(flag == true){
				Constant.log.info("Verify whether a material is deleted from BOM test case is successful");
				extentTest.log(LogStatus.PASS, "Verify whether a material is deleted from BOM test case is successful");
			}else{
				System.err.println("Verify whether a material is deleted from BOM test case failed ");
				Constant.captureScreen_Negative("Delete a material from BOM");
				extentTest.log(LogStatus.FAIL, "Verify whether a material is deleted from BOM test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Delete a material from BOM");
	}

	@Test
	public void Test008_BOMDelete_ConfirmationNo() throws Exception{
		log.startTestCase("Validate cancel button in delete confirmation pop up");
		extentTest = extent.startTest("Validate cancel button in delete confirmation pop up",
				"Validate cancel button in delete confirmation pop up");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.bomMaterialDelete_No(7);
			if(flag == true){
				Constant.log.info("Validate cancel button in delete confirmation pop up test case is successful");
				extentTest.log(LogStatus.PASS, "Validate cancel button in delete confirmation pop up test case is successful");
			}else{
				System.err.println("Validate cancel button in delete confirmation pop up test case failed ");
				Constant.captureScreen_Negative("Validate cancel button in delete confirmation pop up");
				extentTest.log(LogStatus.FAIL, "Validate cancel button in delete confirmation pop up test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate cancel button in delete confirmation pop up");
	}

	@Test
	public void Test010_CancelBtn_DeleteIndent() throws Exception{
		log.startTestCase("Cancel button validation in Indent delete");
		extentTest = extent.startTest("Cancel button validation in Indent delete",
				"validate cancel button during indent delete");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.cancelBtn_deleteIndent(9,"Indent");
			if(flag == true){
				Constant.log.info("validate cancel button during indent delete test case is successful");
				extentTest.log(LogStatus.PASS, "validate cancel button during indent delete test case is successful");
			}else{
				System.err.println("validate cancel button during indent delete test case failed ");
				Constant.captureScreen_Negative("Cancel button validation in Indent delete");
				extentTest.log(LogStatus.FAIL, "validate cancel button during indent delete test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Cancel button validation in Indent delete");
	}

	@Test
	public void Test011_CancelBtn_DeleteMaterial() throws Exception{
		log.startTestCase("Cancel button validation in material delete");
		extentTest = extent.startTest("Cancel button validation in material delete",
				"validate cancel button during material delete");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.cancelBtn_MaterialDelete(10);
			if(flag == true){
				Constant.log.info("validate cancel button during material delete test case is successful");
				extentTest.log(LogStatus.PASS, "validate cancel button during material delete test case is successful");
			}else{
				System.err.println("validate cancel button during material delete test case failed ");
				Constant.captureScreen_Negative("Cancel button validation in material delete");
				extentTest.log(LogStatus.FAIL, "validate cancel button during material delete test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Cancel button validation in material delete");
	}

	@Test
	public void Test012_MandatoryFields_Check() throws Exception{
		log.startTestCase("Mandatory Field Check");
		extentTest = extent.startTest("Mandatory Field Check",
				"validate Mandatory field errors are displayed");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.mandatoryFieldsCheck(11);
			if(flag == true){
				Constant.log.info("Mandatory field error messages validation is successful");
				extentTest.log(LogStatus.PASS, "Mandatory field error messages validation is successful");
			}else{
				System.err.println("Mandatory field error messages validation failed ");
				Constant.captureScreen_Negative("Mandatory Field Check");
				extentTest.log(LogStatus.FAIL, "Mandatory field error messages validation failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Mandatory Field Check");
	}

	@Test
	public void Test013_DatewiseSearch() throws Exception{
		log.startTestCase("Date wise Search");
		extentTest = extent.startTest("Date wise Search",
				"Validate date wise search");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.last30Days(12,4);
			boolean flag1 = store.currentMonth(4);
			boolean flag2 = store.currentYear(4);
			boolean flag3 = store.currentFinancialYear(4);
			boolean flag4 = store.customRange(4);
			if(flag == true && flag1 == true && flag2 == true && flag3 == true && flag4 == true){
				Constant.log.info("Date wise search is successful");
				extentTest.log(LogStatus.PASS, "Date wise search is successful");
			}else{
				System.err.println("Date wise search is not successful ");
				Constant.captureScreen_Negative("Date wise Search");
				extentTest.log(LogStatus.FAIL, "Date wise search is not successful ");
			}
			Assert.assertTrue(flag == true && flag1 == true && flag2 == true && flag3 == true && flag4 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Date wise Search");
	}

	@Test
	public void Test014_IndentFoundVerify() throws Exception{
		log.startTestCase("Indent Found Verify");
		extentTest = extent.startTest("Indent Found Verify",
				"Validate indent found count");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.indentsFoundCount();
			if(flag == true){
				Constant.log.info("Indent Found count validation is successful");
				extentTest.log(LogStatus.PASS, "Indent Found count validation is successful");
			}else{
				System.err.println("Indent Found count validation failed ");
				Constant.captureScreen_Negative("Indent Found Verify");
				extentTest.log(LogStatus.FAIL, "Indent Found count validation failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Indent Found Verify");
	}

	@Test
	public void Test015_AddMultipleMaterial() throws Exception{
		log.startTestCase("Add Multiple Material");
		extentTest = extent.startTest("Add Multiple Material",
				"Validate multiple material is added");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.multipleMaterial(14);
			if(flag == true){
				Constant.log.info("Multiple material addition validation is successful");
				extentTest.log(LogStatus.PASS, "Multiple material addition validation is successful");
			}else{
				System.err.println("Multiple material addition validation failed ");
				Constant.captureScreen_Negative("Add Multiple Material");
				extentTest.log(LogStatus.FAIL, "Multiple material addition validation failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Multiple Material");
	}

	@Test
	public void Test016_DeleteMaterialCount() throws Exception{
		log.startTestCase("Delete Material Count");
		extentTest = extent.startTest("Delete Material Count",
				"Validate multiple material is added");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.removeBOMMaterialCount(15);
			boolean flag1 = store.removeMaterialCount(15);
			if(flag == true && flag1 == true){
				Constant.log.info("Multiple material addition validation is successful");
				extentTest.log(LogStatus.PASS, "Multiple material addition validation is successful");
			}else{
				System.err.println("Multiple material addition validation failed ");
				Constant.captureScreen_Negative("Delete Material Count");
				extentTest.log(LogStatus.FAIL, "Multiple material addition validation failed");
			}
			Assert.assertTrue(flag == true && flag1 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Delete Material Count");
	}

	@Test
	public void Test017_ValidateColumnNames() throws Exception{
		log.startTestCase("List grid column names validation");
		extentTest = extent.startTest("List grid column names validation",
				"Validate column names in the list grid");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.indentColumnValidation(16);
			if(flag == true){
				Constant.log.info("Validation of column names in the list grid is successful");
				extentTest.log(LogStatus.PASS, "Validation of column names in the list grid is successful");
			}else{
				System.err.println("List grid column validation failed ");
				Constant.captureScreen_Negative("List grid column names validation");
				extentTest.log(LogStatus.FAIL, "List grid column validation failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("List grid column names validation");
	}

//	@Test
//	public void Test018_ValidateTagField() throws Exception{
//		log.startTestCase("Validate Tag Field");
//		extentTest = extent.startTest("Validate Tag Field",
//				"Verify if tag is added in invoice");
//		login.login();
//		try{
//			navigate.navigateToStore();
//			Thread.sleep(Constant.Min_Sleep);
//			navigate.navigateToIndent();
//			Thread.sleep(Constant.Min_Sleep);
//			boolean flag1 = sales.verifyTag();
//			boolean flag2 = sales.addAvailableTag(17,"Indent");
//			if(flag1 == true && flag2 == true){
//				Constant.log.info("Verify if tag is added and deleted in invoice test case is successful");
//				extentTest.log(LogStatus.PASS, "Verify if tag is added in invoice test case is successful");
//			}else{
//				System.err.println("Tag addition and delete in invoice test case failed ");
//				Constant.captureScreen_Negative("Validate Tag Field");
//				extentTest.log(LogStatus.FAIL, "Tag addition and delete in invoice test case failed");
//			}
//			Assert.assertTrue(flag1 == true && flag2 == true);
//		}catch(Exception e){
//				System.err.println(e);
//			}
//		log.endTestCase("Validate Tag Field");
//	}

	@Test
	public void Test019_ValidateEditPage() throws Exception{
		log.startTestCase("Validate Edit page");
		extentTest = extent.startTest("Validate Edit page",
				"Verify non editable fields in edit page");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = store.nonEditableFields();
			if(flag1 == true){
				Constant.log.info("Non editable fields in edit page validation is successful");
				extentTest.log(LogStatus.PASS, "Non editable fields in edit page validation is successful");
			}else{
				System.err.println("Non editable fields in edit page validation failed ");
				Constant.captureScreen_Negative("Validate Edit page");
				extentTest.log(LogStatus.FAIL, "Non editable fields in edit page validation failed");
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate Edit page");
	}

	@Test
	public void Test020_AddIndentWithoutTag() throws Exception{
		log.startTestCase("Add Indent Without tag");
		extentTest = extent.startTest("Add Indent Without tag",
				"Verify if indent is added");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.verifyAddIndent(19,"Indent");
			if(flag == true){
				Constant.log.info("Verify indent is added without tag is successful");
				extentTest.log(LogStatus.PASS, "Verify indent is added without tag is successful");
			}else{
				System.err.println("Indent addition without tag failed ");
				Constant.captureScreen_Negative("Add Indent Without tag");
				extentTest.log(LogStatus.FAIL, "Indent addition without tag failed ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Indent Without tag");
	}

	@Test
	public void Test021_AddMultiMaterialWithoutTag() throws Exception{
		log.startTestCase("Add Multiple Material Without Tag");
		extentTest = extent.startTest("Add Multiple Material Without Tag",
				"Validate multiple material is added Without Tag");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.multipleMaterial(20);
			if(flag == true){
				Constant.log.info("Multiple material addition without tag validation is successful");
				extentTest.log(LogStatus.PASS, "Multiple material addition without tag validation is successful");
			}else{
				System.err.println("Multiple material addition  without tag validation failed ");
				Constant.captureScreen_Negative("Add Multiple Material Without Tag");
				extentTest.log(LogStatus.FAIL, "Multiple material addition  without tag validation failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Multiple Material Without Tag");
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
