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
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import category.HighPriorityTestCases;
import category.SanityTests;
import category.SmokeTest;
import pages.LoginPage;
import pages.PurchasePage;
import pages.SalesPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeliveryChallanTestCases {

	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
	PurchasePage purchase = PageFactory.initElements(Constant.driver, PurchasePage.class);
	StorePage stores = PageFactory.initElements(Constant.driver, StorePage.class);
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
		Constant.logFile("Delivery challan");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(SmokeTest.class)
	public void Test038_AddDC_WithStock() throws Exception{
		log.startTestCase("Add DC with stock");
		extentTest = extent.startTest("Test038_AddDC_WithStock",
				"Verify if DC with stock is added").assignCategory("DeliveryChallanTestCases","SmokeTest");
		try{
			boolean flag = sales.addInvoice(37, "DC", null);
			if(flag){
				Constant.log.info("Verify if DC with stock is added test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if DC with stock is added test case is successful");
			}else{
				System.err.println("DC with stock is added test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test038_AddDC_WithStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add DC with stock");
	}

	@Test  @Category(SanityTests.class)
	public void Test039_AddDC_WithNonStock() throws Exception{
		log.startTestCase("Add DC with Non Stock");
		extentTest = extent.startTest("Test039_AddDC_WithNonStock",
				"Verify if DC with Non Stock is added").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.addInvoice(38, "DC", null);
			if(flag){
				Constant.log.info("Verify if DC is added with Non Stock test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if DC with Non Stock is added test case is successful");
			}else{
				System.err.println("DC added with non stock test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test039_AddDC_WithNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add DC with Non Stock");
	}

	@Test @Category(HighPriorityTestCases.class)
	public void Test042_AddDC_WithMulStockNonStock() throws Exception{
		log.startTestCase("Add DC with Multiple Stock and Non Stock");
		extentTest = extent.startTest("Test042_AddDC_WithMulStockNonStock",
				"Verify if DC with Multiple Stock and Non Stock is added").assignCategory("DeliveryChallanTestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.addInvoice(41, "DC", null);
			if(flag){
				Constant.log.info("Verify if DC is added with Multiple Stock and Non Stock test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if DC with Multiple Stock and Non Stock is added test case is successful");
			}else{
				System.err.println("DC added with Multiple Stock and non stock test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test042_AddDC_WithMulStockNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add DC with Multiple Stock and Non Stock");
	}

	@Test  @Category(SanityTests.class)
	public void Test047_ApproveDeliveryChallan() throws Exception{
		log.startTestCase("Approve Delivery Challan");
		extentTest = extent.startTest("Test047_ApproveDeliveryChallan",
				"Verify if Delivery Challan is approved").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateApproveInvoice(46, "DC", null);
			if(flag){
				Constant.log.info("Verify if Delivery Challan is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan is approved test case is successful");
			}else{
				System.err.println("Delivery Challan is approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test047_ApproveDeliveryChallan")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Delivery Challan");
	}

	@Test  @Category(SanityTests.class)
	public void Test048_RejectDraftDeliveryChallan() throws Exception{
		log.startTestCase("Reject draft Delivery Challan");
		extentTest = extent.startTest("Test048_RejectDraftDeliveryChallan",
				"Verify if draft Delivery Challan is reject").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectDraftInvoice(47, "DC");
			if(flag){
				Constant.log.info("Verify if draft Delivery Challan is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if draft Delivery Challan is reject test case is successful");
			}else{
				System.err.println("Draft Delivery Challan is reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test048_RejectDraftDeliveryChallan")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject draft Delivery Challan");
	}

	@Test  @Category(SanityTests.class)
	public void Test049_RejectApprovedDeliveryChallan() throws Exception{
		log.startTestCase("Reject Approved Delivery Challan");
		extentTest = extent.startTest("Test049_RejectApprovedDeliveryChallan",
				"Verify if Approved Delivery Challan is reject").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(48, "DC", null);
			if(flag){
				Constant.log.info("Verify if Approved Delivery Challan is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Delivery Challan is reject test case is successful");
			}else{
				System.err.println("Approved Delivery Challan is reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test049_RejectApprovedDeliveryChallan")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Delivery Challan");
	}

	@Test  @Category(SanityTests.class)
	public void Test091_AddDeliveryChallan_WithReturn() throws Exception{
		log.startTestCase("Add Delivery Challan with Return");
		extentTest = extent.startTest("Test091_AddDeliveryChallan_WithReturn",
				"Verify if Delivery Challan is added with Return").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.addInvoice(90, "DC", null);
			if(flag){
				Constant.log.info("Verify if Delivery Challan is added with return test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan is added with Return test case is successful");
			}else{
				System.err.println("Delivery Challan is added with Return test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test091_AddDeliveryChallan_WithReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add Delivery Challan with Return");
	}

	@Test  @Category(SanityTests.class)
	public void Test098_ApproveDeliveryChallan_WithReturn() throws Exception{
		log.startTestCase("Approve Delivery Challan with Return");
		extentTest = extent.startTest("Test098_ApproveDeliveryChallan_WithReturn",
				"Verify if Delivery Challan is approved with Return").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateApproveInvoice(97, "DC", null);
			if(flag){
				Constant.log.info("Verify if Delivery Challan is approved with Return test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan is approved with Return test case is successful");
			}else{
				System.err.println("Delivery Challan is approved with Return test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test098_ApproveDeliveryChallan_WithReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Delivery Challan with Return");
	}

	@Test  @Category(SanityTests.class)
	public void Test099_RejectDraftDeliveryChallan_WithReturn() throws Exception{
		log.startTestCase("Reject draft Delivery Challan with Return");
		extentTest = extent.startTest("Test099_RejectDraftDeliveryChallan_WithReturn",
				"Verify if draft Delivery Challan with Return is reject").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectDraftInvoice(98, "DC");
			if(flag){
				Constant.log.info("Verify if draft Delivery Challan with Return is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if draft Delivery Challan with Return is reject test case is successful");
			}else{
				System.err.println("Draft Delivery Challan with Return is reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test099_RejectDraftDeliveryChallan_WithReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject draft Delivery Challan with Return");
	}

	@Test  @Category(SanityTests.class)
	public void Test100_RejectApprovedDeliveryChallan_WithReturn() throws Exception{
		log.startTestCase("Reject Approved Delivery Challan with Return");
		extentTest = extent.startTest("Test100_RejectApprovedDeliveryChallan_WithReturn",
				"Verify if Approved Delivery Challan with Return is reject").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(99, "DC", null);
			if(flag){
				Constant.log.info("Verify if Approved Delivery Challan with Return is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Delivery Challan with Return is reject test case is successful");
			}else{
				System.err.println("Approved Delivery Challan with Return is reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test100_RejectApprovedDeliveryChallan_WithReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Delivery Challan with Return");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test101_UpdateDC_CheckReturnFlag() throws Exception{
		log.startTestCase("Update DC by checking return flag");
		extentTest = extent.startTest("Test101_UpdateDC_CheckReturnFlag",
				"Verify if DC Updated by checking return flag").assignCategory("DeliveryChallanTestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.updateDC_CheckReturn(100, "DC");
			if(flag){
				Constant.log.info("Verify if DC Updated by checking return flag test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if DC Updated by checking return flag test case is successful");
			}else{
				System.err.println("Verify if DC Updated by checking return flag test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test101_UpdateDC_CheckReturnFlag")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update DC by checking return flag");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test118_MaterialReturnedDC_GRNApproved() throws Exception{
		log.startTestCase("Material Returned Popup for DC when GRN approved");
		extentTest = extent.startTest("Test118_MaterialReturnedDC_GRNApproved",
				"Verify Material Returned Popup for DC when GRN approved").assignCategory("DeliveryChallanTestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.materialReturnedDC_GRNApproved(117, "DC");
			if(flag){
				Constant.log.info("Verify Material Returned Popup for DC when GRN approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Material Returned Popup for DC when GRN approved test case is successful");
			}else{
				System.err.println("Material Returned Popup for DC when GRN approved verification test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test118_MaterialReturnedDC_GRNApproved")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Material Returned Popup for DC when GRN approved");
	}

	@Test  @Category(SanityTests.class)
	public void Test150_AddJDC_PoPopUp() throws Exception{
		log.startTestCase("Add JDC from po popup");
		extentTest = extent.startTest("Test150_AddJDC_PoPopUp",
				"Verify JDC added from po popup").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.addInvoice(149, "DC", null);
			if(flag){
				Constant.log.info("Verify JDC added from po popup test case is successful");
				extentTest.log(LogStatus.PASS, "Verify JDC added from po popup test case is successful");
			}else{
				System.err.println("Verify JDC added from po popup test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test150_AddJDC_PoPopUp")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add JDC from po popup");
	}

	@Test @Category(SanityTests.class)
	public void Test151_AddJDC_ItemParticular() throws Exception{
		log.startTestCase("Add JDC from Item Particular");
		extentTest = extent.startTest("Test151_AddJDC_ItemParticular",
				"Verify JDC added from Item Particular").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.addInvoice(150, "DC", null);
			if(flag){
				Constant.log.info("Verify JDC added from Item Particular test case is successful");
				extentTest.log(LogStatus.PASS, "Verify JDC added from Item Particular test case is successful");
			}else{
				System.err.println("Verify JDC added from Item Particular test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test151_AddJDC_ItemParticular")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add JDC from Item Particular");
	}

	@Test @Category(SanityTests.class)
	public void Test153_UpdateJDC_ChangePONo() throws Exception{
		log.startTestCase("Update JDc by changing PoNo");
		extentTest = extent.startTest("Test153_UpdateJDC_ChangePONo",
				"Verify JDc updated by po no").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.updateJDC_ChangePONo(152, "DC");
			if(flag){
				Constant.log.info("Verify JDc updated by po no test case is successful");
				extentTest.log(LogStatus.PASS, "Verify JDc updated by po no test case is successful");
			}else{
				System.err.println("Verify JDc updated by po no test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test153_UpdateJDC_ChangePONo")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update JDc by changing PoNo");
	}

	@Test  @Category(SanityTests.class)
	public void Test160_ApproveJobDc() throws Exception{
		log.startTestCase("Approve Job Dc ");
		extentTest = extent.startTest("Test160_ApproveJobDc",
				"Verify if Job Dc is approved").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateApproveInvoice(159, "DC", null);
			if(flag){
				Constant.log.info("Verify if Job Dc is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Job Dc is approved test case is successful");
			}else{
				System.err.println("Job Dc is approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test160_ApproveJobDc")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Job Dc");
	}

	@Test  @Category(SanityTests.class)
	public void Test161_RejectDraftJobDc() throws Exception{
		log.startTestCase("Reject draft Job Dc");
		extentTest = extent.startTest("Test161_RejectDraftJobDc",
				"Verify if draft Job Dc is reject").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectDraftInvoice(160, "DC");
			if(flag){
				Constant.log.info("Verify if draft Job Dc is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if draft Job Dc is reject test case is successful");
			}else{
				System.err.println("Draft Job Dc is reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test161_RejectDraftJobDc")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject draft Job Dc");
	}

	@Test   @Category(SanityTests.class)
	public void Test162_RejectApprovedJobDc() throws Exception{
		log.startTestCase("Reject Approved Job Dc");
		extentTest = extent.startTest("Test162_RejectApprovedJobDc",
				"Verify if Approved Job Dc is reject").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(161, "DC", null);
			if(flag){
				Constant.log.info("Verify if Approved Job Dc is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Job Dc is reject test case is successful");
			}else{
				System.err.println("Approved Job Dc is reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test162_RejectApprovedJobDc")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Job Dc");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test176_MaterialReturnedJDC_GRNApproved() throws Exception{
		log.startTestCase("Material Returned Popup for JDC when GRN approved");
		extentTest = extent.startTest("Test176_MaterialReturnedJDC_GRNApproved",
				"Verify Material Returned Popup for JDC when GRN approved").assignCategory("DeliveryChallanTestCases","HighPriorityTestCases");
		try{
			boolean flag = sales.materialReturnedJDC_GRNApproved(175, "DC");
			if(flag){
				Constant.log.info("Verify Material Returned Popup for JDC when GRN approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Material Returned Popup for JDC when GRN approved test case is successful");
			}else{
				System.err.println("Material Returned Popup  for JDC when GRN approved verification test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test176_MaterialReturnedJDC_GRNApproved")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Material Returned Popup for JDC when GRN approved");
	}

	@Test  @Category(SanityTests.class)
	public void Test095_UpdateJobDc_Material() throws Exception{
		log.startTestCase("Update Job Dc with Material");
		extentTest = extent.startTest("Test095_UpdateJobDc_Material",
				"Verify if Job Dc is updated with Material").assignCategory("DeliveryChallanTestCases","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test095_UpdateJobDc_Material")));
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Job Dc with Material");
	}


	/*

	@Test
	public void Test001_VerifyAddNListGridComponents() throws Exception{
		log.startTestCase("Add and List grid page components");
		extentTest = extent.startTest("Add and List grid components",
				"Verify if Add and List grid components are displayed properly");
		login.login();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = sales.verifyInvoiceComponents(0,"DC");
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
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.last30Days();
			boolean flag1 = sales.currentMonth();
			boolean flag2 = sales.currentYear();
			boolean flag3 = sales.currentFinancialYear();
			boolean flag4 = sales.customRange();
			if(flag == true && flag1 == true && flag2 == true && flag3 == true && flag4 == true){
				Constant.log.info("Validation of date wise search field with all options are successful");
				extentTest.log(LogStatus.PASS, "Validation of date wise search field with all options are successful");
			}else{
				System.err.println("Validation of date wise search field with all options are unsuccessful ");
				Constant.captureScreen_Negative("Date wise search");
				extentTest.log(LogStatus.FAIL, "Validation of date wise search field with all options are unsuccessful");
			}
			Assert.assertTrue(flag == true && flag1 == true && flag2 == true && flag3 == true && flag4 == true);
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
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
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
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.partyNameSearch(3,"DC");
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
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = sales.searchInvoice_PartyDateStatus(4,"DC");
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
	*/
	@Test  @Category(SanityTests.class)
	public void Test090_UpdateDeliveryChallan_Material() throws Exception{
		log.startTestCase("Update Delivery Challan with Material");
		extentTest = extent.startTest("Test090_UpdateDeliveryChallan_Material",
				"Verify if Delivery Challan is updated with Material").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			sales.addInvoice(89, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(89, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(89, "Sanity Test");
			boolean flag2 = sales.deleteItem(89, "Sanity Test");
			if(flag && flag1 && flag2){
				Constant.log.info("Verify if Delivery Challan is updated with Material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan is updated with Material test case is successful");
			}else{
				System.err.println("Delivery Challan is updated with Material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test090_UpdateDeliveryChallan_Material")));
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Delivery Challan with Material");
	}

	@Test  @Category(SanityTests.class)
	public void Test105_UpdateJobDc_PO() throws Exception{
		log.startTestCase("Update Job Dc with PO");
		extentTest = extent.startTest("Test105_UpdateJobDc_PO",
				"Verify if Job Dc is updated with PO").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			sales.addInvoice(104, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(104, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(104, "Sanity Test");
			boolean flag2 = sales.deleteItem(104, "Sanity Test");
			if(flag && flag1 && flag2){
				Constant.log.info("Verify if Job Dc with PO is updated test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Job Dc with PO is updated test case is successful");
			}else{
				System.err.println("Job Dc with PO is updated test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test105_UpdateJobDc_PO")));
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Job Dc with PO");
	}

	@Test   @Category(SanityTests.class)
	public void Test106_ApproveJobDc_PO() throws Exception{
		log.startTestCase("Approve Job Dc with PO");
		extentTest = extent.startTest("Test106_ApproveJobDc_PO",
				"Verify if Job Dc is approved with PO").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateApproveInvoice(105, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Job Dc is approved with PO test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Job Dc is approved with PO test case is successful");
			}else{
				System.err.println("Job Dc is approved with PO test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test106_ApproveJobDc_PO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Job Dc with PO");
	}

	@Test  @Category(SanityTests.class)
	public void Test107_RejectDraftJobDc_PO() throws Exception{
		log.startTestCase("Reject draft Job Dc with PO");
		extentTest = extent.startTest("Test107_RejectDraftJobDc_PO",
				"Verify if draft Job Dc with PO is reject").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectDraftInvoice(106, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if draft Job Dc with PO is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if draft Job Dc with PO is reject test case is successful");
			}else{
				System.err.println("Draft Job Dc with PO is reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test107_RejectDraftJobDc_PO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject draft Job Dc with PO");
	}

	@Test  @Category(SanityTests.class)
	public void Test108_RejectApprovedJobDc_PO() throws Exception{
		log.startTestCase("Reject Approved Job Dc with PO");
		extentTest = extent.startTest("Test108_RejectApprovedJobDc_PO",
				"Verify if Approved Job Dc with PO is reject").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(107, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Job Dc with PO is reject test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Job Dc with PO is reject test case is successful");
			}else{
				System.err.println("Approved Job Dc with PO is reject test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test108_RejectApprovedJobDc_PO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Job Dc with PO");
	}

	@Test  @Category(SanityTests.class)
	public void Test110_UpdateDeliveryChallan_WithReturn() throws Exception{
		log.startTestCase("Update Delivery Challan with Return");
		extentTest = extent.startTest("Test110_UpdateDeliveryChallan_WithReturn",
				"Verify if Delivery Challan is updated with Return").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			sales.addInvoice(109, "Sanity Test", null);
			boolean flag = sales.UpdateInvoiceChangingCount(109, "Sanity Test");
			boolean flag1 = sales.updateInvoicewithNewMaterial(109, "Sanity Test");
			boolean flag2 = sales.deleteItem(109, "Sanity Test");
			if(flag && flag1 && flag2){
				Constant.log.info("Verify if Delivery Challan is updated with Return test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Delivery Challan is updated with Return test case is successful");
			}else{
				System.err.println("Delivery Challan is updated with Return test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test110_UpdateDeliveryChallan_WithReturn")));
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Delivery Challan with Return");
	}

	@Test  @Category(SanityTests.class)
	public void Test171_AddDC_OA() throws Exception{
		log.startTestCase("ADD DC with OA");
		extentTest = extent.startTest("Test171_AddDC_OA",
				"Verify if DC added with OA").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.addInvoice(170, "Sanity Test",null);
			if(flag){
				Constant.log.info("ADD DC with OA is successful");
				extentTest.log(LogStatus.PASS, "ADD DC with OA is successful");
			}else{
				System.err.println("ADD DC with OA failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test171_AddDC_OA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("ADD DC with OA");
	}

	@Test  @Category(SanityTests.class)
	public void Test172_UpdateDC_Oa() throws Exception{
		log.startTestCase("Update Dc created with Oa");
		extentTest = extent.startTest("Test172_UpdateDC_Oa",
				"Verify if Dc created with Oa is updated").assignCategory("DeliveryChallanTestCases","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test172_UpdateDC_Oa")));
			}
			Assert.assertTrue(flag && flag1 && flag2);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Update Dc created with Oa");
	}

	@Test  @Category(SanityTests.class)
	public void Test173_ApproveDC_Oa() throws Exception{
		log.startTestCase("Approve Dc created with Oa");
		extentTest = extent.startTest("Test173_ApproveDC_Oa",
				"Verify if Dc created with Oa is approved").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateApproveInvoice(172, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Dc created with Oa is approved test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Dc created with Oa is approved test case is successful");
			}else{
				System.err.println("Dc created with Oa is approved test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test173_ApproveDC_Oa")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Approve Dc created with Oa");
	}

	@Test  @Category(SanityTests.class)
	public void Test174_DiscardDC_Oa() throws Exception{
		log.startTestCase("Reject Draft Dc created with Oa");
		extentTest = extent.startTest("Test174_DiscardDC_Oa",
				"Verify if drafted Dc created with Oa is rejected").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectDraftInvoice(173, "Sanity Test");
			if(flag){
				Constant.log.info("Verify if drafted Dc created with Oa is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if drafted Dc created with Oa is rejected test case is successful");
			}else{
				System.err.println("Drafted Dc created with Oa is rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test174_DiscardDC_Oa")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Draft Dc created with Oa");
	}

	@Test  @Category(SanityTests.class)
	public void Test175_RejectDC_Oa() throws Exception{
		log.startTestCase("Reject Approved Dc created with Oa");
		extentTest = extent.startTest("Test175_RejectDC_Oa",
				"Verify if Approved Dc created with Oa is rejected").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.validateRejectApprovedInvoice(174, "Sanity Test", null);
			if(flag){
				Constant.log.info("Verify if Approved Dc created with Oa is rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Approved Dc created with Oa is rejected test case is successful");
			}else{
				System.err.println("Approved Dc created with Oa is rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test175_RejectDC_Oa")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Reject Approved Dc created with Oa");
	}

	@Test  @Category(SanityTests.class)
	public void Test264_AddJDCNonStock_PoPopUp() throws Exception{
		log.startTestCase("Add JDC NonStock from po popup");
		extentTest = extent.startTest("Test264_AddJDCNonStock_PoPopUp",
				"Verify JDC NonStock added from po popup").assignCategory("DeliveryChallanTestCases","SanityTests");
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
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test264_AddJDCNonStock_PoPopUp")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add JDC NonStock from po popup");
	}

	@Test @Category(SanityTests.class)
	public void Test289_AddDc_AltUnit() throws Exception{
		log.startTestCase("ADD Dc with alternate unit");
		extentTest = extent.startTest("Test289_AddDc_AltUnit",
				"Verify if Dc with added with alternate unit").assignCategory("DeliveryChallanTestCases","SanityTests");
		try{
			boolean flag = sales.addInvoice(288, "Sanity Test",null);
			if(flag){
				Constant.log.info("ADD Dc with alternate unit is successful");
				extentTest.log(LogStatus.PASS, "ADD Dc with alternate unit is successful");
			}else{
				System.err.println("ADD Dc with alternate unit failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test289_AddDc_AltUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("ADD Dc with alternate unit");
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
