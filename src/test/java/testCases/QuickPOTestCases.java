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
import pages.SettingPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuickPOTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	PurchasePage purchase = PageFactory.initElements(Constant.driver, PurchasePage.class);
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
		Constant.logFile("Quick PO");
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

	@Test  	@Category(SmokeTest.class)
	public void Test069_AddPO_Stock() throws Exception{
		log.startTestCase("Add Quick PO with stock material");
		extentTest = extent.startTest("Test069_AddPO_Stock",
				"Verify quick po created with stock material").assignCategory("QuickPOTestCases","SmokeTest");
		try{
			boolean flag = purchase.addQuickPO(68,"Quick PO");
			if(flag){
				Constant.log.info("Quick po additioin with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Quick po additioin with stock material test case is successful");
			}else{
				System.err.println("Quick po additioin with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test069_AddPO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Quick PO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test070_AddPO_NonStock() throws Exception{
		log.startTestCase("Add Quick PO with non stock material");
		extentTest = extent.startTest("Test070_AddPO_NonStock",
				"Verify quick po created with non stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.addQuickPO(69,"Quick PO");
			if(flag){
				Constant.log.info("Quick po additioin with non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Quick po additioin with non stock material test case is successful");
			}else{
				System.err.println("Quick po additioin with non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test070_AddPO_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Quick PO with non stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test071_AddPO_StockNNonStock() throws Exception{
		log.startTestCase("Add Quick PO with Stock and non stock material");
		extentTest = extent.startTest("Test071_AddPO_StockNNonStock",
				"Verify quick po created with Stock and non stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.addQuickPO(70,"Quick PO");
			if(flag){
				Constant.log.info("Quick po additioin with Stock and non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Quick po additioin with Stock and non stock material test case is successful");
			}else{
				System.err.println("Quick po additioin with Stock and non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test071_AddPO_StockNNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Quick PO with Stock and non stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test072_AddPO_MultStock() throws Exception{
		log.startTestCase("Add Quick PO with multiple stock material");
		extentTest = extent.startTest("Test072_AddPO_MultStock",
				"Verify quick po created with multiple stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.addQuickPO(71,"Quick PO");
			if(flag){
				Constant.log.info("Quick po additioin with multiple stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Quick po additioin with multiple stock material test case is successful");
			}else{
				System.err.println("Quick po additioin with multiple stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test072_AddPO_MultStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Quick PO with multiple stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test073_AddPO_MultNonStock() throws Exception{
		log.startTestCase("Add Quick PO with multiple Non stock material");
		extentTest = extent.startTest("Test073_AddPO_MultNonStock",
				"Verify quick po created with multiple Non stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.addQuickPO(72,"Quick PO");
			if(flag){
				Constant.log.info("Quick po additioin with multiple Non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Quick po additioin with multiple Non stock material test case is successful");
			}else{
				System.err.println("Quick po additioin with multiple Non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test073_AddPO_MultNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Quick PO with multiple Non stock material");
	}

	@Test  	@Category(SanityTests.class)
	public void Test084_AddJO_Stock() throws Exception{
		log.startTestCase("Add Quick JO with stock material");
		extentTest = extent.startTest("Test084_AddJO_Stock",
				"Verify quick JO created with stock material").assignCategory("QuickPOTestCases","SanityTests");
		try{
			boolean flag = purchase.addQuickJO(83,"Quick PO");
			if(flag){
				Constant.log.info("Quick JO addition with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Quick JO addition with stock material test case is successful");
			}else{
				System.err.println("Quick JO addition with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test084_AddJO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Quick JO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test085_AddJO_NonStock() throws Exception{
		log.startTestCase("Add Quick JO with non stock material");
		extentTest = extent.startTest("Test085_AddJO_NonStock",
				"Verify quick JO created with non stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.addQuickJO(84,"Quick PO");
			if(flag){
				Constant.log.info("Quick JO addition with non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Quick JO additioin with non stock material test case is successful");
			}else{
				System.err.println("Quick JO additioin with non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test085_AddJO_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Quick JO with non stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test086_AddJO_StockNNonStock() throws Exception{
		log.startTestCase("Add Quick JO with Stock and non stock material");
		extentTest = extent.startTest("Test086_AddJO_StockNNonStock",
				"Verify quick JO created with Stock and non stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.addQuickJO(85,"Quick PO");
			if(flag){
				Constant.log.info("Quick JO additioin with Stock and non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Quick JO additioin with Stock and non stock material test case is successful");
			}else{
				System.err.println("Quick JO additioin with Stock and non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test086_AddJO_StockNNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Quick JO with Stock and non stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test087_AddJO_MultStock() throws Exception{
		log.startTestCase("Add Quick JO with multiple stock material");
		extentTest = extent.startTest("Test087_AddJO_MultStock",
				"Verify quick JO created with multiple stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.addQuickJO(86,"Quick PO");
			if(flag){
				Constant.log.info("Quick JO additioin with multiple stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Quick JO additioin with multiple stock material test case is successful");
			}else{
				System.err.println("Quick JO additioin with multiple stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test087_AddJO_MultStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Quick JO with multiple stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test088_AddJO_MultNonStock() throws Exception{
		log.startTestCase("Add Quick JO with multiple Non stock material");
		extentTest = extent.startTest("Test088_AddJO_MultNonStock",
				"Verify quick JO created with multiple Non stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.addQuickJO(87,"Quick PO");
			if(flag){
				Constant.log.info("Quick JO additioin with multiple Non stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Quick JO additioin with multiple Non stock material test case is successful");
			}else{
				System.err.println("Quick JO additioin with multiple Non stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test088_AddJO_MultNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Quick JO with multiple Non stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test099_ApprovePO_Stock() throws Exception{
		log.startTestCase("Approve Quick po with stock material");
		extentTest = extent.startTest("Test099_ApprovePO_Stock",
				"Verify quick po approved with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.ApproveQuickPO(98,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick po approved with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick po approved with stock material test case is successful");
			}else{
				System.err.println("Verify quick po approved with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test099_ApprovePO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Quick po with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test100_ApproveJO_Stock() throws Exception{
		log.startTestCase("Approve Quick JO with stock material");
		extentTest = extent.startTest("Test100_ApproveJO_Stock",
				"Verify quick JO approved with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.ApproveQuickJO(99,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick JO approved with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick JO approved with stock material test case is successful");
			}else{
				System.err.println("Verify quick JO approved with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test100_ApproveJO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Quick JO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test101_DiscardPO_Stock() throws Exception{
		log.startTestCase("Discard Quick PO with stock material");
		extentTest = extent.startTest("Test101_DiscardPO_Stock",
				"Verify quick PO discarded with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.DiscardQuickPO(100,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick PO discarded with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick PO discarded with stock material test case is successful");
			}else{
				System.err.println("Verify quick PO discarded with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test101_DiscardPO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Discard Quick PO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test102_DiscardJO_Stock() throws Exception{
		log.startTestCase("Discard Quick JO with stock material");
		extentTest = extent.startTest("Test102_DiscardJO_Stock",
				"Verify quick JO discarded with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.DiscardQuickJO(101,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick JO discarded with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick JO discarded with stock material test case is successful");
			}else{
				System.err.println("Verify quick JO discarded with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test102_DiscardJO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Discard Quick JO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test103_RejectPO_Stock() throws Exception{
		log.startTestCase("Reject Quick PO with stock material");
		extentTest = extent.startTest("Test103_RejectPO_Stock",
				"Verify quick PO Reject with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.RejectQuickPO(102,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick PO Reject with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick PO Reject with stock material test case is successful");
			}else{
				System.err.println("Verify quick PO Reject with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test103_RejectPO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject Quick PO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test104_RejectJO_Stock() throws Exception{
		log.startTestCase("Reject Quick JO with stock material");
		extentTest = extent.startTest("Test104_RejectJO_Stock",
				"Verify quick JO Reject with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.RejectQuickPO(103,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick JO Reject with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick JO Reject with stock material test case is successful");
			}else{
				System.err.println("Verify quick JO Reject with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test104_RejectJO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject Quick JO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test105_ReviewPO_Stock() throws Exception{
		log.startTestCase("Review Quick PO with stock material");
		extentTest = extent.startTest("Test105_ReviewPO_Stock",
				"Verify quick PO Review with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.ReviewQuickPO(104,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick PO Review with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick PO Review with stock material test case is successful");
			}else{
				System.err.println("Verify quick PO Review with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test105_ReviewPO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Review Quick PO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test106_ReviewJO_Stock() throws Exception{
		log.startTestCase("Review Quick JO with stock material");
		extentTest = extent.startTest("Test106_ReviewJO_Stock",
				"Verify quick JO Review with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.ReviewQuickJO(105,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick JO Review with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick JO Review with stock material test case is successful");
			}else{
				System.err.println("Verify quick JO Review with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test106_ReviewJO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Review Quick JO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test107_SubmitReviewedPO_Stock() throws Exception{
		log.startTestCase("Submit Reviewed Quick PO with stock material");
		extentTest = extent.startTest("Test107_SubmitReviewedPO_Stock",
				"Verify quick PO resubmit Reviewed with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.SubmitReviewedQuickPO(106,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick PO resubmit Reviewed with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick PO resubmit Reviewed with stock material test case is successful");
			}else{
				System.err.println("Verify quick PO resubmit Reviewed with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test107_SubmitReviewedPO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Submit Reviewed Quick PO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test108_SubmitReviewedJO_Stock() throws Exception{
		log.startTestCase("Submit Reviewed Quick JO with stock material");
		extentTest = extent.startTest("Test108_SubmitReviewedJO_Stock",
				"Verify quick JO resubmit Reviewed with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.SubmitReviewedQuickJO(107,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick JO resubmit Reviewed with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick JO resubmit Reviewed with stock material test case is successful");
			}else{
				System.err.println("Verify quick JO resubmit Reviewed with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test108_SubmitReviewedJO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Submit Reviewed Quick JO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test109_ApproveReviewedPO_Stock() throws Exception{
		log.startTestCase("Approve Reviewed Quick PO with stock material");
		extentTest = extent.startTest("Test109_ApproveReviewedPO_Stock",
				"Verify Reviewed quick PO Approved with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.ApproveReviewedQuickPO(108,"Quick PO");
			if(flag){
				Constant.log.info("Verify Reviewed quick PO Approved with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Reviewed quick PO Approved with stock material test case is successful");
			}else{
				System.err.println("Verify Reviewed quick PO Approved with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test109_ApproveReviewedPO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Reviewed Quick PO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test110_ApproveReviewedJO_Stock() throws Exception{
		log.startTestCase("Approve Reviewed Quick JO with stock material");
		extentTest = extent.startTest("Test110_ApproveReviewedJO_Stock",
				"Verify Reviewed quick JO Approved with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.ApproveReviewedQuickJO(109,"Quick PO");
			if(flag){
				Constant.log.info("Verify Reviewed quick JO Approved with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Reviewed quick JO Approved with stock material test case is successful");
			}else{
				System.err.println("Verify Reviewed quick JO Approved with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test110_ApproveReviewedJO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Reviewed Quick JO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test111_DiscardReviewedPO_Stock() throws Exception{
		log.startTestCase("Discard Reviewed Quick PO with stock material");
		extentTest = extent.startTest("Test111_DiscardReviewedPO_Stock",
				"Verify Reviewed quick PO Discarded with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.DiscardReviewedQuickPO(110,"Quick PO");
			if(flag){
				Constant.log.info("Verify Reviewed quick PO Discarded with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Reviewed quick PO Discarded with stock material test case is successful");
			}else{
				System.err.println("Verify Reviewed quick PO Discarded with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test111_DiscardReviewedPO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Discard Reviewed Quick PO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test112_DiscardReviewedJO_Stock() throws Exception{
		log.startTestCase("Discard Reviewed Quick JO with stock material");
		extentTest = extent.startTest("Test112_DiscardReviewedJO_Stock",
				"Verify Reviewed quick JO Discarded with stock material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.DiscardReviewedQuickJO(111,"Quick PO");
			if(flag){
				Constant.log.info("Verify Reviewed quick JO Discarded with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Reviewed quick JO Discarded with stock material test case is successful");
			}else{
				System.err.println("Verify Reviewed quick JO Discarded with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test112_DiscardReviewedJO_Stock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Discard Reviewed Quick JO with stock material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test124_UpdateJO_AddMaterial() throws Exception{
		log.startTestCase("Update JO adding material");
		extentTest = extent.startTest("Test124_UpdateJO_AddMaterial",
				"Verify quick JO can be updated adding material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.updateJO_AddMat_QuickPO(123,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick JO can be updated adding material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick JO can be updated adding material test case is successful");
			}else{
				System.err.println("Verify quick JO can be updated adding material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test124_UpdateJO_AddMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update JO adding material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test129_UpdatePO_AddMaterial() throws Exception{
		log.startTestCase("Update PO adding material");
		extentTest = extent.startTest("Test129_UpdatePO_AddMaterial",
				"Verify quick po can be updated adding material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.updatePO_AddMat_QuickPO(128,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick po can be updated adding material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick po can be updated adding material test case is successful");
			}else{
				System.err.println("Verify quick po can be updated adding material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test129_UpdatePO_AddMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update PO adding material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test134_AmendPO_TaxPriceQty() throws Exception{
		log.startTestCase("Amend PO editing tax, price and qty");
		extentTest = extent.startTest("Test134_AmendPO_TaxPriceQty",
				"Verify quick po can be Amended editing tax, price and qty").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.amendPO_QuickPOTaxRateQty(133,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick po can be Amended editing tax, price and qty test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick po can be Amended editing tax, price and qty test case is successful");
			}else{
				System.err.println("Verify quick po can be Amended editing tax, price and qty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test134_AmendPO_TaxPriceQty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend PO editing tax, price and qty");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test135_AmendPO_AddMaterial() throws Exception{
		log.startTestCase("Amend PO adding material");
		extentTest = extent.startTest("Test135_AmendPO_AddMaterial",
				"Verify quick po can be Amended adding material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.amendPO_QuickPOAddMat(134,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick po can be Amended adding material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick po can be Amended adding material test case is successful");
			}else{
				System.err.println("Verify quick po can be Amended adding material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test135_AmendPO_AddMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend PO adding material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test137_AmendJO_TaxPriceQty() throws Exception{
		log.startTestCase("Amend JO editing tax, price and qty");
		extentTest = extent.startTest("Test137_AmendJO_TaxPriceQty",
				"Verify quick Jo can be Amended editing tax, price and qty").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.amendJO_QuickPOTaxRateQty(133,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick Jo can be Amended editing tax, price and qty test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick Jo can be Amended editing tax, price and qty test case is successful");
			}else{
				System.err.println("Verify quick Jo can be Amended editing tax, price and qty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test137_AmendJO_TaxPriceQty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend JO editing tax, price and qty");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test138_AmendJO_AddMaterial() throws Exception{
		log.startTestCase("Amend JO adding material");
		extentTest = extent.startTest("Test138_AmendJO_AddMaterial",
				"Verify quick Jo can be Amended adding material").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.amendJO_QuickPOTaxRateQty(134,"Quick PO");
			if(flag){
				Constant.log.info("Verify quick Jo can be Amended adding material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify quick Jo can be Amended adding material test case is successful");
			}else{
				System.err.println("Verify quick Jo can be Amended adding material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test138_AmendJO_AddMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend PO adding material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test153_IndentNotAvlPopUP_FullPO() throws Exception{
		log.startTestCase("Indent not Available in indent popup po created");
		extentTest = extent.startTest("Test153_IndentNotAvlPopUP_FullPO",
				"Verify if indent no not available in choose indent popup when po created for full qty").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.indentNotAvl_POFullqty(152,"Quick PO");
			if(flag){
				Constant.log.info("Verify if indent no not available in choose indent popup when po created for full qty test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if indent no not available in choose indent popup when po created for full qty test case is successful");
			}else{
				System.err.println("Verify if indent no not available in choose indent popup when po created for full qty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test153_IndentNotAvlPopUP_FullPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Indent not Available in indent popup po created");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test154_IndentNotAvlPopUP_ShortClose() throws Exception{
		log.startTestCase("Indent not Available in indent popup indent short close");
		extentTest = extent.startTest("Test154_IndentNotAvlPopUP_ShortClose",
				"Verify if indent no not available in choose indent popup when po created for full qty").assignCategory("QuickPOTestCases","HighPriorityTestCases");
		try{
			boolean flag = purchase.indentNotAvl_shortClose(153,"Quick PO");
			if(flag){
				Constant.log.info("Verify if indent no not available in choose indent popup when po created for full qty test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if indent no not available in choose indent popup when po created for full qty test case is successful");
			}else{
				System.err.println("Verify if indent no not available in choose indent popup when po created for full qty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test154_IndentNotAvlPopUP_ShortClose")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Indent not Available in indent popup indent short close");
	}

	@Test  @Category(SanityTests.class)
	public void Test267_AddPO_NewMaterial() throws Exception{
		boolean flag = false;
		log.startTestCase("Add PO with new material");
		extentTest = extent.startTest("Test267_AddPO_NewMaterial",
				"Verify if PO is added with new material").assignCategory("QuickPOTestCases","SanityTests");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			int iCount = master.materialCountWithNonStock();
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			purchase.addQuickPO(266,"Sanity Test");
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			int iAfterAddition = master.materialCountWithNonStock();
			if(iAfterAddition > iCount){
				flag = true;
			}
			if(flag){
				Constant.log.info("Add PO with new material test case is successful");
				extentTest.log(LogStatus.PASS, "Add PO with new material test case is successful");
			}else{
				System.err.println("Add PO with new material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test267_AddPO_NewMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add PO with new material");
	}

	@Test  @Category(SanityTests.class)
	public void Test269_AddPO_withSPqWarn() throws Exception{
		log.startTestCase("Add PO with new material");
		extentTest = extent.startTest("Test269_AddPO_withSPqWarn",
				"Verify if PO is added with new material").assignCategory("QuickPOTestCases","SanityTests");
		try{
			boolean flag = purchase.addQuickPO_SPQWarning(268,"Sanity Test");
			if(flag){
				Constant.log.info("Add PO with new material test case is successful");
				extentTest.log(LogStatus.PASS, "Add PO with new material test case is successful");
			}else{
				System.err.println("Add PO with new material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test269_AddPO_withSPqWarn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Add PO with new material");
	}

	@Test @Category(SanityTests.class)
	public void Test282_AddBlanketPO() throws Exception{
		log.startTestCase("Add Blanket PO");
		extentTest = extent.startTest("Test282_AddBlanketPO",
				"Verify if Blanket PO is added").assignCategory("QuickPOTestCases","SanityTests");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			setting.blanketPO_Check();
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.addQuickPO(281, "Sanity Test");
			if(flag){
				Constant.log.info("Add Blanket PO test case is successful");
				extentTest.log(LogStatus.PASS, "Add Blanket PO test case is successful");
			}else{
				System.err.println("Add Blanket PO test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test282_AddBlanketPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Blanket PO");
	}

	@Test @Category(SanityTests.class)
	public void Test283_AddBlanketJO() throws Exception{
		log.startTestCase("Add Blanket JO");
		extentTest = extent.startTest("Test283_AddBlanketJO",
				"Verify if Blanket JO is added").assignCategory("QuickPOTestCases","SanityTests");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			setting.blanketPO_Check();
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.addQuickJO(282, "Sanity Test");
			if(flag){
				Constant.log.info("Add Blanket JO test case is successful");
				extentTest.log(LogStatus.PASS, "Add Blanket JO test case is successful");
			}else{
				System.err.println("Add Blanket JO test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test283_AddBlanketJO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Blanket JO");
	}

	@Test @Category(SanityTests.class)
	public void Test284_UpdateBlanketPO() throws Exception{
		log.startTestCase("update Blanket PO");
		extentTest = extent.startTest("Test284_UpdateBlanketPO",
				"Verify if Blanket PO is updateed").assignCategory("QuickPOTestCases","SanityTests");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			setting.blanketPO_Check();
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = purchase.updatePO_AddMat_QuickPO(283, "Sanity Test");
			if(flag){
				Constant.log.info("update Blanket PO test case is successful");
				extentTest.log(LogStatus.PASS, "update Blanket PO test case is successful");
			}else{
				System.err.println("update Blanket PO test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test284_UpdateBlanketPO")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("update Blanket PO");
	}

	@Test  	@Category(SanityTests.class)
	public void Test285_ApproveBlanketPo() throws Exception{
		log.startTestCase("Approve Blanket po with stock material");
		extentTest = extent.startTest("Test285_ApproveBlanketPo",
				"Verify Blanket po approved with stock material").assignCategory("QuickPOTestCases","SanityTests");
		try{
			boolean flag = purchase.ApproveQuickPO(284,"Sanity Test");
			if(flag){
				Constant.log.info("Verify Blanket po approved with stock material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Blanket po approved with stock material test case is successful");
			}else{
				System.err.println("Verify Blanket po approved with stock material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test285_ApproveBlanketPo")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve Blanket po with stock material");
	}

	@Test  	@Category(SanityTests.class)
	public void Test287_AddPO_AltUnit() throws Exception{
		log.startTestCase("Add po with alternate unit");
		extentTest = extent.startTest("Test287_AddPO_AltUnit",
				"Verify able to add po with alternate unit").assignCategory("QuickPOTestCases","SanityTests");
		try{
			boolean flag = purchase.addQuickPO(286,"Sanity Test");
			if(flag){
				Constant.log.info("Verify able to add po with alternate unit test case is successful");
				extentTest.log(LogStatus.PASS, "Verify able to add po with alternate unit test case is successful");
			}else{
				System.err.println("Verify able to add po with alternate unit test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test287_AddPO_AltUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add po with alternate unit");
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
