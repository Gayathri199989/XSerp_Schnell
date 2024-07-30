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
import pages.SalesPage;
import pages.SettingPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalesEstimate {

	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
	ProfilePage master = PageFactory.initElements(Constant.driver, ProfilePage.class);
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
		Constant.logFile("OA");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test035_AddSe_NonStock() throws Exception{
		log.startTestCase("Add SE non stock");
		extentTest = extent.startTest("Test035_AddSe_NonStock",
				"Verify if SE is added with non stock").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addSe(34,"Sales estimate");
			if(flag){
				Constant.log.info("Add SE with non stock test case is successful");
				extentTest.log(LogStatus.PASS, "Add SE with non stock test case is successful");
			}else{
				System.err.println("Add SE with non stock test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test035_AddSe_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add SE with non stock");
	}

	@Test  @Category(SmokeTest.class)
	public void Test036_AddSe_StockNNonStock() throws Exception{
		log.startTestCase("Add SE with stock and non stock material");
		extentTest = extent.startTest("Test036_AddSe_StockNNonStock",
				"Verify if SE is added with stock and non stock material").assignCategory("SalesEstimate","SmokeTest");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addSe(35,"Sales estimate");
			if(flag){
				Constant.log.info("Add SE with stock and non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Add SE with stock and non stock material test case is successful");
			}else{
				System.err.println("Add SE with stock and non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test036_AddSe_StockNNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add SE with stock and non stock material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test038_AddSe_MultipleStockNNonStock() throws Exception{
		log.startTestCase("Add SE with multiple stock and non stock material");
		extentTest = extent.startTest("Test038_AddSe_MultipleStockNNonStock",
				"Verify if SE is added with multiple stock and non stock material").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addSe(37,"Sales estimate");
			if(flag){
				Constant.log.info("Add SE with multiple stock and non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Add SE with multiple stock and non stock material test case is successful");
			}else{
				System.err.println("Add SE with multiple stock and non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test038_AddSe_MultipleStockNNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add SE with multiple stock and non stock material");
	}

	@Test  @Category(SanityTests.class)
	public void Test046_ApproveSe() throws Exception{
		log.startTestCase("Approve SE");
		extentTest = extent.startTest("Test046_ApproveSe",
				"Verify if SE is Approved").assignCategory("SalesEstimate","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.approveSE(45,"Sales estimate");
			if(flag){
				Constant.log.info("Approve SE test case is successful");
				extentTest.log(LogStatus.PASS, "Approve SE test case is successful");
			}else{
				System.err.println("Approve SE test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test046_ApproveSe")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve SE");
	}

	@Test  @Category(SanityTests.class)
	public void Test047_RejectDraftSe() throws Exception{
		log.startTestCase("Reject Draft SE");
		extentTest = extent.startTest("Test047_RejectDraftSe",
				"Verify if SE is Reject Drafted").assignCategory("SalesEstimate","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.rejectDraftSE(46,"Sales estimate");
			if(flag){
				Constant.log.info("Reject Draft SE test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Draft SE test case is successful");
			}else{
				System.err.println("Reject Draft SE test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test047_RejectDraftSe")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft SE");
	}

	@Test  @Category(SanityTests.class)
	public void Test048_RejectApprovedSe() throws Exception{
		log.startTestCase("Reject Approved SE");
		extentTest = extent.startTest("Test048_RejectApprovedSe",
				"Verify if SE is Reject Approved").assignCategory("SalesEstimate","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.rejectApprovedSE(47,"Sales estimate");
			if(flag){
				Constant.log.info("Reject Approved SE test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Approved SE test case is successful");
			}else{
				System.err.println("Reject Approved SE test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test048_RejectApprovedSe")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved SE");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test059_ValidateStock_SeAdded() throws Exception{
		log.startTestCase("Validate Stock after SE addition");
		extentTest = extent.startTest("Test059_ValidateStock_SeAdded",
				"Verify if stock is added after se addition").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			String sStock = master.fetchStock(58,"Sales estimate");
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addSe(58,"Sales estimate");
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			String sActStock = master.fetchStock(58,"Sales estimate");
			if(sActStock.equals(sStock)){
				flag = true;
			}
			if(flag){
				Constant.log.info("Reject Approved SE test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Approved SE test case is successful");
			}else{
				System.err.println("Reject Approved SE test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test059_ValidateStock_SeAdded")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate Stock after SE addition");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test062_UpdateSe_addStockMat() throws Exception{
		log.startTestCase("Update SE by adding stock material");
		extentTest = extent.startTest("Test062_UpdateSe_addStockMat",
				"Verify if SE is Updated by adding stock material").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.addSe(47,"Sales estimate");//dont change rowNo
			boolean flag = sales.updateSE(61,"Sales estimate");
			if(flag){
				Constant.log.info("Update SE by adding stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Update SE by adding stock material test case is successful");
			}else{
				System.err.println("Update SE by adding stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test062_UpdateSe_addStockMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update SE by adding stock material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test068_UpdateSe_addnonstockMat() throws Exception{
		log.startTestCase("Update SE by adding non stock material");
		extentTest = extent.startTest("Test068_UpdateSe_addnonstockMat",
				"Verify if SE is Updated by adding non stock material").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.addSe(47,"Sales estimate");//dont change rowNo
			boolean flag = sales.updateSE(67,"Sales estimate");
			if(flag){
				Constant.log.info("Update SE by adding non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Update SE by adding non stock material test case is successful");
			}else{
				System.err.println("Update SE by adding non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test068_UpdateSe_addnonstockMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update SE by adding non stock material");
	}

	@Test  @Category(SanityTests.class)
	public void Test069_UpdateSe_addStockNNonstockMat() throws Exception{
		log.startTestCase("Update SE by adding stock N non stock material");
		extentTest = extent.startTest("Test069_UpdateSe_addStockNNonstockMat",
				"Verify if SE is Updated by adding stock N non stock material").assignCategory("SalesEstimate","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.addSe(47,"Sales estimate");//dont change rowNo
			boolean flag = sales.updateSE(68,"Sales estimate");
			if(flag){
				Constant.log.info("Update SE by adding stock N non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Update SE by adding stock N non stock material test case is successful");
			}else{
				System.err.println("Update SE by adding stock N non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test069_UpdateSe_addStockNNonstockMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update SE by adding stock N non stock material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test070_UpdateSe_DeleteMat() throws Exception{
		log.startTestCase("Update SE by deleting material");
		extentTest = extent.startTest("Test070_UpdateSe_DeleteMat",
				"Verify if SE is Updated by deleting material").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.addSe(69,"Sales estimate");
			boolean flag = sales.deleteMaterial_UpdateSe(69,"Sales estimate");
			if(flag){
				Constant.log.info("Update SE by deleting material test case is successful");
				extentTest.log(LogStatus.PASS, "Update SE by deleting material test case is successful");
			}else{
				System.err.println("Update SE by deleting material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test070_UpdateSe_DeleteMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update SE by deleting material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test071_WArning_DeleteAllMat() throws Exception{
		log.startTestCase("Validate warning without material");
		extentTest = extent.startTest("Test071_WArning_DeleteAllMat",
				"Validate warning when SE updated without materials").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.addSe(70,"Sales estimate");
			boolean flag = sales.warningwithtoutMat();
			if(flag){
				Constant.log.info("Validate warning when SE updated without materials test case is successful");
				extentTest.log(LogStatus.PASS, "Validate warning when SE updated without materials test case is successful");
			}else{
				System.err.println("Validate warning when SE updated without materials test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test071_WArning_DeleteAllMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Validate warning without material");
	}

	@Test  @Category(SanityTests.class)
	public void Test095_AmendApprovedSe_AddMAt() throws Exception{
		log.startTestCase("Amend Approved SE by adding mat");
		extentTest = extent.startTest("Test095_AmendApprovedSe_AddMAt",
				"Verify if SE is approved Amend by adding mat").assignCategory("SalesEstimate","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.approveSE(61, "Sales estimate");//dont change rowno
			boolean flag = sales.amendSE(94,"Sales estimate");
			if(flag){
				Constant.log.info("Amend Approved SE by adding mat test case is successful");
				extentTest.log(LogStatus.PASS, "Amend Approved SE by adding mat test case is successful");
			}else{
				System.err.println("Amend Approved SE by adding mat test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test095_AmendApprovedSe_AddMAt")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Amend Approved SE by adding mat");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test096_AmendApprovedSe_AddMulNonStockMat() throws Exception{
		log.startTestCase("Amend Approved SE by adding multiple non stock material");
		extentTest = extent.startTest("Test096_AmendApprovedSe_AddMulNonStockMat",
				"Verify if SE is approved Amend by adding multiple non stock material").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.approveSE(61, "Sales estimate");//dont change rowno
			boolean flag = sales.amendSE(95,"Sales estimate");
			if(flag){
				Constant.log.info("Amend Approved SE by adding multiple non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Amend Approved SE by adding multiple non stock material test case is successful");
			}else{
				System.err.println("Amend Approved SE by adding multiple non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test096_AmendApprovedSe_AddMulNonStockMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Amend Approved SE by adding multiple non stock material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test097_AmendApprovedSe_DeleteMat() throws Exception{
		log.startTestCase("Amend Approved SE by deleting material");
		extentTest = extent.startTest("Test097_AmendApprovedSe_DeleteMat",
				"Verify if SE is approved Amend by deleting material").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.approveSE(70, "Sales estimate");//dont change rowno
			boolean flag = sales.deleteMaterial_AmendSe(96,"Sales estimate");
			if(flag){
				Constant.log.info("Amend Approved SE by adding multiple non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Amend Approved SE by adding multiple non stock material test case is successful");
			}else{
				System.err.println("Amend Approved SE by adding multiple non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test097_AmendApprovedSe_DeleteMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Amend Approved SE by adding multiple non stock material");
	}

	@Test  @Category(SanityTests.class)
	public void Test129_ReviewSe() throws Exception{
		log.startTestCase("Review SE");
		extentTest = extent.startTest("Test129_ReviewSe",
				"Verify if SE is Reviewed").assignCategory("SalesEstimate","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.reviewSE(128, "Sales estimate");
			if(flag){
				Constant.log.info("Review SE test case is successful");
				extentTest.log(LogStatus.PASS, "Review SE test case is successful");
			}else{
				System.err.println("Review SE test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test129_ReviewSe")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Review SE");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test131_ReSubmitSe_NoChange() throws Exception{
		log.startTestCase("ReSubmit SE without change");
		extentTest = extent.startTest("Test131_ReSubmitSe_NoChange",
				"Verify if SE is ReSubmited without change").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.resubmitSE_NoChange(130, "Sales estimate");
			if(flag){
				Constant.log.info("ReSubmit SE without change test case is successful");
				extentTest.log(LogStatus.PASS, "ReSubmit SE without change test case is successful");
			}else{
				System.err.println("ReSubmit SE without change test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test131_ReSubmitSe_NoChange")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("ReSubmit SE without change");
	}

	@Test  @Category(SanityTests.class)
	public void Test132_ReSubmitSe_AddMat() throws Exception{
		log.startTestCase("ReSubmit SE by adding material");
		extentTest = extent.startTest("Test132_ReSubmitSe_AddMat",
				"Verify if SE is ReSubmited by adding material").assignCategory("SalesEstimate","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.reviewSE(70, "Sales estimate");//dont change rowno
			boolean flag = sales.resubmitSE_AddMat(131, "Sales estimate");
			if(flag){
				Constant.log.info("ReSubmit SE by adding material test case is successful");
				extentTest.log(LogStatus.PASS, "ReSubmit SE by adding material test case is successful");
			}else{
				System.err.println("ReSubmit SE by adding material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test132_ReSubmitSe_AddMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("ReSubmit SE by adding material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test162_ChangeLog_SEAddWithAllDetails() throws Exception{
		log.startTestCase("Change log validation for SE addition with all details");
		extentTest = extent.startTest("Test162_ChangeLog_SEAddWithAllDetails",
				"Verify if change log displayed for created SE with all details ").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.changeLog_NEwSE(131, "Sales estimate");
			if(flag){
				Constant.log.info("Change log validation for SE addition with all details test case is successful");
				extentTest.log(LogStatus.PASS, "Change log validation for SE addition with all details test case is successful");
			}else{
				System.err.println("Change log validation for SE addition with all details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test162_ChangeLog_SEAddWithAllDetails")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Change log validation for SE addition with all details");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test200_ChangeLog_SEReviewed() throws Exception{
		log.startTestCase("Change log validation for SE REview");
		extentTest = extent.startTest("Test200_ChangeLog_SEReviewed",
				"Verify if change log displayed for SE REview ").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.reviewSE(199, "Sales estimate");
			boolean flag = sales.changeLogStatusChange("Review");
			if(flag){
				Constant.log.info("Change log validation for SE REview with all details test case is successful");
				extentTest.log(LogStatus.PASS, "Change log validation for SE REview with all details test case is successful");
			}else{
				System.err.println("Change log validation for SE REview with all details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test200_ChangeLog_SEReviewed")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Change log validation for SE REview");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test201_ChangeLog_SEApproved() throws Exception{
		log.startTestCase("Change log validation for SE Approved");
		extentTest = extent.startTest("Test201_ChangeLog_SEApproved",
				"Verify if change log displayed for SE Approved ").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.approveSE(200, "Sales estimate");
			boolean flag = sales.changeLogStatusChange("approved");
			if(flag){
				Constant.log.info("Change log validation for SE Approved with all details test case is successful");
				extentTest.log(LogStatus.PASS, "Change log validation for SE Approved with all details test case is successful");
			}else{
				System.err.println("Change log validation for SE Approved with all details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test201_ChangeLog_SEApproved")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Change log validation for SE Approved");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test202_ChangeLog_SErejected() throws Exception{
		log.startTestCase("Change log validation for SE rejected");
		extentTest = extent.startTest("Test202_ChangeLog_SErejected",
				"Verify if change log displayed for SE rejected ").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.rejectApprovedSE(201, "Sales estimate");
			boolean flag = sales.changeLogStatusChange("rejected");
			if(flag){
				Constant.log.info("Change log validation for SE rejected with all details test case is successful");
				extentTest.log(LogStatus.PASS, "Change log validation for SE rejected with all details test case is successful");
			}else{
				System.err.println("Change log validation for SE rejected with all details test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test202_ChangeLog_SErejected")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Change log validation for SE rejected");
	}

	@Test  @Category(SanityTests.class)
	public void Test216_AddOA_PromoteToOA() throws Exception{
		log.startTestCase("Add OA by Promote to OA");
		extentTest = extent.startTest("Test216_AddOA_PromoteToOA",
				"Verify if OA added by clicking promote to OA").assignCategory("SalesEstimate","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addOa_PromoteOA(215, "Sales estimate");
			if(flag){
				Constant.log.info("Add OA by Promote to OA test case is successful");
				extentTest.log(LogStatus.PASS, "Add OA by Promote to OA test case is successful");
			}else{
				System.err.println("Add OA by Promote to OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test216_AddOA_PromoteToOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add OA by Promote to OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test225_ApproveOA_PromoteToOA() throws Exception{
		log.startTestCase("Approve OA by Promote to OA");
		extentTest = extent.startTest("Test225_ApproveOA_PromoteToOA",
				"Verify if OA Approveed by clicking promote to OA").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			sales.addOa_PromoteOA(224, "Sales estimate");
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.approveOA(224, "Sales estimate");
			if(flag){
				Constant.log.info("Approve OA by Promote to OA test case is successful");
				extentTest.log(LogStatus.PASS, "Approve OA by Promote to OA test case is successful");
			}else{
				System.err.println("Approve OA by Promote to OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test225_ApproveOA_PromoteToOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve OA by Promote to OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test227_DiscardOA_PromoteToOA() throws Exception{
		log.startTestCase("Discard OA by Promote to OA");
		extentTest = extent.startTest("Test227_DiscardOA_PromoteToOA",
				"Verify if OA Discarded by clicking promote to OA").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			sales.addOa_PromoteOA(226, "Sales estimate");
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.rejectDraftOA(226, "Sales estimate");
			if(flag){
				Constant.log.info("Discard OA by Promote to OA test case is successful");
				extentTest.log(LogStatus.PASS, "Discard OA by Promote to OA test case is successful");
			}else{
				System.err.println("Discard OA by Promote to OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test227_DiscardOA_PromoteToOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Discard OA by Promote to OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test228_RejectApprovedOA_PromoteToOA() throws Exception{
		log.startTestCase("Reject Approved OA by Promote to OA");
		extentTest = extent.startTest("Test228_RejectApprovedOA_PromoteToOA",
				"Verify if OA Reject Approved by clicking promote to OA").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			sales.addOa_PromoteOA(227, "Sales estimate");
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			sales.approveOA(227, "Sales estimate");
			boolean flag = sales.rejectApprovedOA(227, "Sales estimate");
			if(flag){
				Constant.log.info("Reject Approved OA by Promote to OA test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Approved OA by Promote to OA test case is successful");
			}else{
				System.err.println("Reject Approved OA by Promote to OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test228_RejectApprovedOA_PromoteToOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved OA by Promote to OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test229_UpdateOAWithSE_DeleteMat() throws Exception{
		log.startTestCase("update OA by deleting material with se no");
		extentTest = extent.startTest("Test229_UpdateOAWithSE_DeleteMat",
				"Verify if OA update by deleting material with se no").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			sales.addOa_PromoteOA(228, "Sales estimate");
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.updateOA_DeleteMat(228, "Sales estimate");
			if(flag){
				Constant.log.info("A update by deleting material with se no test case is successful");
				extentTest.log(LogStatus.PASS, "A update by deleting material with se no test case is successful");
			}else{
				System.err.println("A update by deleting material with se no test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test229_UpdateOAWithSE_DeleteMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("update OA by deleting material with se no");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test230_AddMultipleOAWithSE() throws Exception{
		log.startTestCase("Add multiple OA for single SE");
		extentTest = extent.startTest("Test230_AddMultipleOAWithSE",
				"Verify if multiple OA added for same SE").assignCategory("SalesEstimate","HighPriorityTestCases");
		boolean flag = false;
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			int sOAActualList = sales.oaList.size();
			String sSENo = sales.validatePromoteOA(229, "Sales estimate");
			sales.addOaFromSEPge(229, "Sales estimate", sSENo, sOAActualList);
			for(int i=0;i<3;i++){
				sSENo = sales.promoteToOA(229, "Sales estimate");
				flag = sales.addOaFromSEPge(229, "Sales estimate", sSENo, sOAActualList);
				if(flag = true){
					continue;
				}else{
					break;
				}
			}
			if(flag){
				Constant.log.info("Verify if multiple OA added for same SE test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if multiple OA added for same SE is successful");
			}else{
				System.err.println("Verify if multiple OA added for same SE test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test230_AddMultipleOAWithSE")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add multiple OA for single SE");
	}

	@Test  @Category(SanityTests.class)
	public void Test234_AddInvoice_PromoteToInvoice() throws Exception{
		log.startTestCase("Add Invoice by Promote to Invoice");
		extentTest = extent.startTest("Test234_AddInvoice_PromoteToInvoice",
				"Verify if Invoice added by clicking promote to Invoice").assignCategory("SalesEstimate","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addInvoice_PromoteInvoice(233,"Sales estimate");
			if(flag){
				Constant.log.info("Add Invoice by Promote to Invoice test case is successful");
				extentTest.log(LogStatus.PASS, "Add Invoice by Promote to Invoice test case is successful");
			}else{
				System.err.println("Add Invoice by Promote to Invoice test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test234_AddInvoice_PromoteToInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Invoice by Promote to Invoice");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test239_UpdateInvoiceWithSe_AddMat() throws Exception{
		log.startTestCase("Update invoice with SE by adding material");
		extentTest = extent.startTest("Test239_UpdateInvoiceWithSe_AddMat",
				"Verify if Invoice with se updated by adding materials").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			sales.addInvoice_PromoteInvoice(238,"Sales estimate");
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.updateInvoicewithNewMaterial(233,"Sales estimate");//dont change rowno
			if(flag){
				Constant.log.info("Update invoice with SE by adding material test case is successful");
				extentTest.log(LogStatus.PASS, "Update invoice with SE by adding material test case is successful");
			}else{
				System.err.println("Update invoice with SE by adding material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test239_UpdateInvoiceWithSe_AddMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update invoice with SE by adding material");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test241_ApproveInvoiceWithSe() throws Exception{
		log.startTestCase("Approve invoice with SE");
		extentTest = extent.startTest("Test241_ApproveInvoiceWithSe",
				"Verify if Invoice with se Approved").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			sales.addInvoice_PromoteInvoice(238,"Sales estimate");
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.approveInvoice();
			if(flag){
				Constant.log.info("Approve invoice with SE test case is successful");
				extentTest.log(LogStatus.PASS, "Approve invoice with SE test case is successful");
			}else{
				System.err.println("Approve invoice with SE test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test241_ApproveInvoiceWithSe")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve invoice with SE");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test243_DiscardInvoiceWithSe() throws Exception{
		log.startTestCase("Discard invoice with SE");
		extentTest = extent.startTest("Test243_DiscardInvoiceWithSe",
				"Verify if Invoice with se Discarded").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			sales.addInvoice_PromoteInvoice(242,"Sales estimate");
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.rejectDraftInvoice(242,"Sales estimate");
			if(flag){
				Constant.log.info("Discard invoice with SE test case is successful");
				extentTest.log(LogStatus.PASS, "Discard invoice with SE test case is successful");
			}else{
				System.err.println("Discard invoice with SE test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test243_DiscardInvoiceWithSe")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Discard invoice with SE");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test244_RejectApprovedInvoiceWithSe() throws Exception{
		log.startTestCase("Reject Approved invoice with SE");
		extentTest = extent.startTest("Test244_RejectApprovedInvoiceWithSe",
				"Verify if Invoice with se Reject Approveded").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			sales.addInvoice_PromoteInvoice(243,"Sales estimate");
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			sales.approveInvoice();
			boolean flag = sales.rejectApprovedInvoice(243,"Sales estimate");
			if(flag){
				Constant.log.info("Reject Approved invoice with SE test case is successful");
				extentTest.log(LogStatus.PASS, "Reject Approved invoice with SE test case is successful");
			}else{
				System.err.println("Reject Approved invoice with SE test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test244_RejectApprovedInvoiceWithSe")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved invoice with SE");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test251_AddGRNJobIn_OAWithSE() throws Exception{
		log.startTestCase("Add GRN job in for OA with SE");
		extentTest = extent.startTest("Test251_AddGRNJobIn_OAWithSE",
				"Verify if GRn job in is added for OA with SE").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			sales.addOa_PromoteOA(250,"Sales estimate");
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			sales.approveOA(250,"Sales estimate");
			int i = sales.oaList.size()-1;
			String sOaNo = sales.oaList.get(i).getText();
			boolean flag = store.addGRN(250,"Sales estimate",sOaNo);
			if(flag){
				Constant.log.info("Add GRN job in for OA with SE test case is successful");
				extentTest.log(LogStatus.PASS, "Add GRN job in for OA with SE test case is successful");
			}else{
				System.err.println("Add GRN job in for OA with SE test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test251_AddGRNJobIn_OAWithSE")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add GRN job in for OA with SE");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test252_AddDC_OAWithSE() throws Exception{
		log.startTestCase("Add DC  for OA with SE");
		extentTest = extent.startTest("Test252_AddDC_OAWithSE",
				"Verify if DC  is added for OA with SE").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			sales.addOa_PromoteOA(251,"Sales estimate");
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			sales.approveOA(251,"Sales estimate");
			int i = sales.oaList.size()-1;
			String sOaNo = sales.oaList.get(i).getText();
			boolean flag = sales.addInvoice(251,"Sales estimate",sOaNo);
			if(flag){
				Constant.log.info("Add DC  for OA with SE test case is successful");
				extentTest.log(LogStatus.PASS, "Add DC  for OA with SE test case is successful");
			}else{
				System.err.println("Add DC  for OA with SE test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test252_AddDC_OAWithSE")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add DC  for OA with SE");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test271_AddSE_altUnit() throws Exception{
		log.startTestCase("Add SE with alternate unit");
		extentTest = extent.startTest("Test271_AddSE_altUnit",
				"Verify if SE added with alternate unit").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.addSe(270,"Sales estimate");
			if(flag){
				Constant.log.info("Add SE with alternate unit test case is successful");
				extentTest.log(LogStatus.PASS, "Add SE with alternate unit test case is successful");
			}else{
				System.err.println("Add SE with alternate unit test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test271_AddSE_altUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add SE with alternate unit");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test275_UpdateSE_altUnit() throws Exception{
		log.startTestCase("Update SE with alternate unit");
		extentTest = extent.startTest("Test275_UpdateSE_altUnit",
				"Verify if SE Updateed with alternate unit").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.updateDraftSE(274,"Sales estimate");
			if(flag){
				Constant.log.info("Update SE with alternate unit test case is successful");
				extentTest.log(LogStatus.PASS, "Update SE with alternate unit test case is successful");
			}else{
				System.err.println("Update SE with alternate unit test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test275_UpdateSE_altUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update SE with alternate unit");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test278_AmendSE_altUnit() throws Exception{
		log.startTestCase("Amend SE with alternate unit");
		extentTest = extent.startTest("Test278_AmendSE_altUnit",
				"Verify if SE Amended with alternate unit").assignCategory("SalesEstimate","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			sales.approveSE(277,"Sales estimate");
			boolean flag = sales.amendSE(277,"Sales estimate");
			if(flag){
				Constant.log.info("Amend SE with alternate unit test case is successful");
				extentTest.log(LogStatus.PASS, "Amend SE with alternate unit test case is successful");
			}else{
				System.err.println("Amend SE with alternate unit test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test278_AmendSE_altUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Amend SE with alternate unit");
	}

	@Test  @Category(SanityTests.class)
	public void Test248_ClientApproveSe() throws Exception{
		log.startTestCase("Client approve SE");
		extentTest = extent.startTest("Test248_ClientApproveSe",
				"Verify if SE is Client approveed").assignCategory("SalesEstimate","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test248_ClientApproveSe")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Client approve SE");
	}

	@Test  @Category(SanityTests.class)
	public void Test249_ClientRejectSe() throws Exception{
		log.startTestCase("Client Reject SE");
		extentTest = extent.startTest("Test249_ClientRejectSe",
				"Verify if SE is Client Rejected").assignCategory("SalesEstimate","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test249_ClientRejectSe")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Client Reject SE");
	}



	@Test  @Category(SanityTests.class)
	public void Test251_AmendClientApprovedSe() throws Exception{
		log.startTestCase("Amend Client Approved SE");
		extentTest = extent.startTest("Test251_AmendClientApprovedSe",
				"Verify if SE is Amend Client  Approved").assignCategory("SalesEstimate","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test251_AmendClientApprovedSe")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Amend Client Approved SE");
	}

	@Test  @Category(SanityTests.class)
	public void Test298_SEConfigNoChange() throws Exception{
		log.startTestCase("SE config without Change");
		extentTest = extent.startTest("Test298_SEConfigNoChange",
				"Verify invoice template saved without change").assignCategory("SalesEstimate","SanityTests");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSEConfig();
			boolean flag = setting.seConfigSave();
			if(flag){
				Constant.log.info("Verify invoice template saved without change test case is successful");
				extentTest.log(LogStatus.PASS, "Verify invoice template saved without change test case is successful");
			}else{
				System.err.println("SE config without Change test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test298_SEConfigNoChange")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("SE config without Change");
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
