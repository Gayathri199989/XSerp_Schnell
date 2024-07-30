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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import category.HighPriorityTestCases;
import category.SanityTests;
import category.SmokeTest;
import pages.AuditingPage;
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
public class ReceiptJobInTestCases {
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
	AuditingPage audit = PageFactory.initElements(Constant.driver, AuditingPage.class);
	SettingPage setting = PageFactory.initElements(Constant.driver, SettingPage.class);
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
		Constant.logFile("Receipt Job in");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(SmokeTest.class)
	public void Test054_AddJobInGRN_OA() throws Exception{
		log.startTestCase("Job in GRN addition with OA");
		extentTest = extent.startTest("Test054_AddJobInGRN_OA",
				"Verify if grn against job in is added with oa").assignCategory("ReceiptJobInTestCases","SmokeTest");
		try{
			boolean flag = store.addGRN(53,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN addition with OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN addition with OA test case is successful");
			}else{
				System.err.println("Job in GRN addition with OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test054_AddJobInGRN_OA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN addition with OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test055_AddJobInGRN_OABOM() throws Exception{
		log.startTestCase("Job in GRN addition with OA having bom");
		extentTest = extent.startTest("Test055_AddJobInGRN_OABOM",
				"Verify if grn against job in is added with oa having bom").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			sales.validateApproveOA(54, "Receipt Job in");
			int sOAActualList = sales.oaList.size();
			String sOANumber = sales.oaList.get(sOAActualList-1).getText();
			boolean flag = store.addGRN(54,"Receipt Job in", sOANumber);
			if(flag){
				Constant.log.info("Job in GRN addition with OA having bom test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN addition with OA test case is successful");
			}else{
				System.err.println("Job in GRN addition with OA having bom test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test055_AddJobInGRN_OABOM")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN addition with OA having bom");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test056_AddJobInGRN_MultOA() throws Exception{
		log.startTestCase("Job in GRN addition with multiple OA");
		extentTest = extent.startTest("Test056_AddJobInGRN_MultOA",
				"Verify if grn against job in is added with multiple OA").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(55,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN addition with multiple OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN addition with multiple OA test case is successful");
			}else{
				System.err.println("Job in GRN addition with multiple OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test056_AddJobInGRN_MultOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN addition with multiple OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test060_AddJobInGRN_WNWOOA() throws Exception{
		log.startTestCase("Job in GRN addition with and without OA");
		extentTest = extent.startTest("Test060_AddJobInGRN_WNWOOA",
				"Verify if grn against job in is added with and without OA").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(59,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN addition with and without OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN addition with and without OA test case is successful");
			}else{
				System.err.println("Job in GRN addition with and without OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test060_AddJobInGRN_WNWOOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN addition with and without OA");
	}

	@Test  @Category(SanityTests.class)
	public void Test061_AddJobInGRN_WOOAStock() throws Exception{
		log.startTestCase("Job in GRN addition with stock material and without OA");
		extentTest = extent.startTest("Test061_AddJobInGRN_WOOAStock",
				"Verify if grn against job in is added  with stock material and without oa").assignCategory("ReceiptJobInTestCases","SanityTests");
		try{
			boolean flag = store.addGRN(60,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN addition  with stock material and without OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN addition with stock material and without OA test case is successful");
			}else{
				System.err.println("Job in GRN addition with stock material and without OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test061_AddJobInGRN_WOOAStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN addition with stock material and without OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test062_AddJobInGRN_WOOAnonstock() throws Exception{
		log.startTestCase("Job in GRN addition with non stock material and without OA");
		extentTest = extent.startTest("Test062_AddJobInGRN_WOOAnonstock",
				"Verify if grn against job in is added  with non stock material and without oa").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(61,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN addition  with non stock material and without OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN addition with non stock material and without OA test case is successful");
			}else{
				System.err.println("Job in GRN addition with non stock material and without OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test062_AddJobInGRN_WOOAnonstock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN addition with non stock material and without OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test063_AddJobInGRN_WOOAnonstock() throws Exception{
		log.startTestCase("Job in GRN addition with stock N non stock material and without OA");
		extentTest = extent.startTest("Test063_AddJobInGRN_WOOAnonstock",
				"Verify if grn against job in is added  with stock N non stock material and without oa").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(62,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN addition  with stock N non stock material and without OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN addition with stock N non stock material and without OA test case is successful");
			}else{
				System.err.println("Job in GRN addition with stock N non stock material and without OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test063_AddJobInGRN_WOOAnonstock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN addition with stock N non stock material and without OA");
	}

	@Test  @Category(SanityTests.class)
	public void Test076_AutoCreatedOA_GRNJobin() throws Exception{
		log.startTestCase("Auto Created OA GRN JOb in");
		extentTest = extent.startTest("Test076_AutoCreatedOA_GRNJobin",
				"Verify if job in Return DC is created").assignCategory("ReceiptJobInTestCases","SanityTests");
		boolean flag = false;
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			int sOAList = sales.oaList.size();
			if(store.addGRN(75,"Receipt Job in", null)){
				int grnActCount = store.grnList.size();
				String sOANo = Constant.driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+grnActCount+"]/td[text()='"+grnActCount+".']/following::td[4]/span")).getText();
				navigate.navigateToSales();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToOA();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				int sOAActualList = sales.oaList.size();
				sOANo = sOANo.substring(0, 7)+sOANo.substring(8,13);
				JavascriptExecutor js = ((JavascriptExecutor) Constant.driver);
				js.executeScript("arguments[0].scrollIntoView(true);",Constant.driver.findElement(By.xpath(".//tr["+sOAActualList+"]/td[2]/a[contains(text(),'"+sOANo+"')]")));
				Thread.sleep(Constant.Min_Sleep);
				if(sOAActualList > sOAList && Constant.driver.findElement(By.xpath(".//tr["+sOAActualList+"]/td[2]/a[contains(text(),'"+sOANo+"')]")).isDisplayed()){
					flag = true;
				}
				if(flag){
					Constant.log.info("OA auto created from GRN Job in test case is successful");
					extentTest.log(LogStatus.PASS, "OA auto created from GRN Job in test case is successful");
				}else{
					System.err.println("OA auto created from GRN Job in test case failed ");
					extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test076_AutoCreatedOA_GRNJobin")));
				}
				Assert.assertTrue(flag);
			}
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Auto Created OA GRN JOb in");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test077_VerifyAutoCreatedOA_GRNJobin() throws Exception{
		log.startTestCase("Verify Auto Created OA GRN JOb in");
		extentTest = extent.startTest("Test077_VerifyAutoCreatedOA_GRNJobin",
				"Verify auto created OA from grn job in").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		boolean flag = false;
		try{
			if(store.addGRN(76,"Receipt Job in", null)){
				int grnActCount = store.grnList.size();
				String sOANo = Constant.driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+grnActCount+"]/td[text()='"+grnActCount+".']/following::td[4]/span")).getText();
				navigate.navigateToSales();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToOA();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				int sOAActualList = sales.oaList.size();
				sOANo = sOANo.substring(0, 7)+sOANo.substring(8,13);
				JavascriptExecutor js = ((JavascriptExecutor) Constant.driver);
				js.executeScript("arguments[0].scrollIntoView(true);",Constant.driver.findElement(By.xpath(".//tr["+sOAActualList+"]/td[2]/a[contains(text(),'"+sOANo+"')]")));
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.driver.findElement(By.xpath(".//tr["+sOAActualList+"]/td[2]/a[contains(text(),'"+sOANo+"')]")).isDisplayed()){
					Actions actions = new Actions(Constant.driver);
					actions.moveToElement(Constant.driver.findElement(By.xpath(".//tr["+sOAActualList+"]/td[2]/a[contains(text(),'"+sOANo+"')]"))).perform();
					js.executeScript("arguments[0].click();", Constant.driver.findElement(By.xpath(".//tr["+sOAActualList+"]/td[2]/a[contains(text(),'"+sOANo+"')]")));
					Thread.sleep(Constant.Min_Sleep);
					flag = sales.validateMatListOaEditPge(76,"Receipt Job in");
				}
				if(flag){
					Constant.log.info("OA auto created from GRN Job in verfication test case is successful");
					extentTest.log(LogStatus.PASS, "OA auto created from GRN Job in verfication test case is successful");
				}else{
					System.err.println("OA auto created from GRN Job in verfication test case failed ");
					extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test077_VerifyAutoCreatedOA_GRNJobin")));
				}
				Assert.assertTrue(flag);
			}
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify Auto Created OA GRN JOb in");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test078_VerifyOANo_GRNJobinEditPge() throws Exception{
		log.startTestCase("Verify OA No in GRN JObin edit page");
		extentTest = extent.startTest("Test078_VerifyOANo_GRNJobinEditPge",
				"Verify OA No in GRN JObin edit page").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		boolean flag = false;
		try{
			if(store.addGRN(77,"Receipt Job in", null)){
				int grnActCount = store.grnList.size();
				String sOANo = Constant.driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+grnActCount+"]/td[text()='"+grnActCount+".']/following::td[4]/span")).getText();
				sOANo = sOANo.substring(0, 7)+sOANo.substring(8,13);
				Actions actions = new Actions(Constant.driver);
				actions.moveToElement(store.grnList.get(grnActCount-1)).perform();
				store.grnList.get(grnActCount-1).click();
				Constant.waitFor(ExpectedConditions.visibilityOf(store.grnMaterialTable), "Failed to load GRN view page");
				flag = store.validateOANowithMat(sOANo);
				if(flag){
					Constant.log.info("Verify OA No in GRN JObin edit page test case is successful");
					extentTest.log(LogStatus.PASS, "Verify OA No in GRN JObin edit page test case is successful");
				}else{
					System.err.println("Verify OA No in GRN JObin edit page test case failed ");
					extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test078_VerifyOANo_GRNJobinEditPge")));
				}
				Assert.assertTrue(flag);
			}
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify OA No in GRN JObin edit page");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test082_AddJobInGRN_WOOAShortRej() throws Exception{
		log.startTestCase("Job in GRN addition with Shortage N Rejected material and without OA");
		extentTest = extent.startTest("Test082_AddJobInGRN_WOOAShortRej",
				"Verify if grn against job in is added  with Shortage N Rejected material and without oa").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(81,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN addition  with Shortage N Rejected material and without OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN addition with Shortage N Rejected material and without OA test case is successful");
			}else{
				System.err.println("Job in GRN addition with Shortage N Rejected material and without OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test078_VerifyOANo_GRNJobinEditPge")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN addition with Shortage N Rejected material and without OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test083_AddJobInGRN_WOAShortRej() throws Exception{
		log.startTestCase("Job in GRN addition with Shortage N Rejected material and with OA");
		extentTest = extent.startTest("Test083_AddJobInGRN_WOAShortRej",
				"Verify if grn against job in is added  with Shortage N Rejected material and with oa").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(82,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN addition  with Shortage N Rejected material and with OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN addition with Shortage N Rejected material and with OA test case is successful");
			}else{
				System.err.println("Job in GRN addition with Shortage N Rejected material and with OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test083_AddJobInGRN_WOAShortRej")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN addition with Shortage N Rejected material and with OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test084_AddJobInGRN_WPriceNDisc() throws Exception{
		log.startTestCase("Job in GRN addition with price N disc material and with OA");
		extentTest = extent.startTest("Test084_AddJobInGRN_WPriceNDisc",
				"Verify if grn against job in is added  with price N disc material and with oa").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(83,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN addition  with price N disc material and with OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN addition with price N disc material and with OA test case is successful");
			}else{
				System.err.println("Job in GRN addition with price N disc material and with OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test084_AddJobInGRN_WPriceNDisc")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN addition with price N disc material and with OA");
	}

	@Test  @Category(SanityTests.class)
	public void Test095_ApproveJobInGRN_WOOA() throws Exception{
		log.startTestCase("Job in GRN Approve without OA");
		extentTest = extent.startTest("Test095_ApproveJobInGRN_WOOA",
				"Verify if grn against job in is Approved without oa").assignCategory("ReceiptJobInTestCases","SanityTests");
		try{
			boolean flag = store.approveGRN(94,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN Approved without OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN Approved without OA test case is successful");
			}else{
				System.err.println("Job in GRN Approved without OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test095_ApproveJobInGRN_WOOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN Approved without OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test096_DraftRejectJobInGRN_WOOA() throws Exception{
		log.startTestCase("Job in GRN Draft Reject without OA");
		extentTest = extent.startTest("Test096_DraftRejectJobInGRN_WOOA",
				"Verify if grn against job in is Draft Rejectd without oa").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.validateDraftRejectGRN(95,"Receipt Job in");
			if(flag){
				Constant.log.info("Job in GRN Draft Rejectd without OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN Draft Rejectd without OA test case is successful");
			}else{
				System.err.println("Job in GRN Draft Rejectd without OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test096_DraftRejectJobInGRN_WOOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN Draft Rejectd without OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test098_RejectJobInGRN_WOOA() throws Exception{
		log.startTestCase("Job in GRN  Reject without OA");
		extentTest = extent.startTest("Test098_RejectJobInGRN_WOOA",
				"Verify if grn against job in is  Rejectd without oa").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.vaildateRejectApprovedGRN(97,"Receipt Job in",null);
			if(flag){
				Constant.log.info("Job in GRN  Rejectd without OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN  Rejectd without OA test case is successful");
			}else{
				System.err.println("Job in GRN  Rejectd without OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test098_RejectJobInGRN_WOOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN  Rejectd without OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test099_Warning_GRNReject_JobinReturnDraft() throws Exception{
		log.startTestCase("warning msg on GRN rejection after Job in return");
		extentTest = extent.startTest("Test099_Warning_GRNReject_JobinReturnDraft",
				"Verify warning msg on GRN rejection after Job in return").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.approveGRN(98,"Receipt Job in",null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			sales.addInvoice(98,"Receipt Job in",sGRNNo);
			boolean flag = store.validateRejectWarning(98,"Receipt Job in");
			if(flag){
				Constant.log.info("warning msg on GRN rejection after Job in return test case is successful");
				extentTest.log(LogStatus.PASS, "warning msg on GRN rejection after Job in return test case is successful");
			}else{
				System.err.println("warning msg on GRN rejection after Job in return test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test099_Warning_GRNReject_JobinReturnDraft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("warning msg on GRN rejection after Job in return");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test100_NoWarning_GRNReject_JobinReturnReject() throws Exception{
		log.startTestCase("No warning msg on GRN rejection after Job in return rejected");
		extentTest = extent.startTest("Test100_NoWarning_GRNReject_JobinReturnReject",
				"Verify No warning msg on GRN rejection after Job in return rejected").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.approveGRN(99,"Receipt Job in",null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			sales.validateRejectApprovedInvoice(99,"Receipt Job in",sGRNNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRN();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(store.filterText), "Failed to load GRN view page");
			store.btnFilter.click();
			Select selectReceivedView = new Select(store.receivedAgainstDropDwnViewtab);
			selectReceivedView.selectByValue("Job In");
			store.searchGRN.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(store.searchGRN), "Failed to load GRN view page");
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = store.rejectApprovedGRN(99,"Receipt Job in");
			if(flag){
				Constant.log.info("No warning msg on GRN rejection after Job in return rejected test case is successful");
				extentTest.log(LogStatus.PASS, "No warning msg on GRN rejection after Job in return rejected test case is successful");
			}else{
				System.err.println("No warning msg on GRN rejection after Job in return rejected test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test100_NoWarning_GRNReject_JobinReturnReject")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("No warning msg on GRN rejection after Job in return rejected");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test101_OaNotAvail_FullQtyInvoice() throws Exception{
		log.startTestCase("OA no not available when full qty invoiced ");
		extentTest = extent.startTest("Test101_OaNotAvail_FullQtyInvoice",
				"Verify OA no not available when full qty invoiced").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			sales.validateApproveOA(100,"Receipt Job in");
			int i = sales.oaList.size()-1;
			String sOANumber = sales.oaList.get(i).getText();
			sales.addInvoice(100,"Receipt Job in", sOANumber);
			boolean flag = store.validateOANoNotAvail(100,"Receipt Job in", sOANumber);
			if(flag){
				Constant.log.info("OA no not available when full qty invoiced test case is successful");
				extentTest.log(LogStatus.PASS, "OA no not available when full qty invoiced test case is successful");
			}else{
				System.err.println("OA no not available when full qty invoiced test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test101_OaNotAvail_FullQtyInvoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("OA no not available when full qty invoiced");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test102_OaNotAvail_FullQtyDC() throws Exception{
		log.startTestCase("OA no not available when full qty DCd ");
		extentTest = extent.startTest("Test102_OaNotAvail_FullQtyDC",
				"Verify OA no not available when full qty DCd").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			sales.validateApproveOA(101,"Receipt Job in");
			int i = sales.oaList.size()-1;
			String sOANumber = sales.oaList.get(i).getText();
			sales.addInvoice(101,"Receipt Job in", sOANumber);
			boolean flag = store.validateOANoNotAvail(101,"Receipt Job in", sOANumber);
			if(flag){
				Constant.log.info("OA no not available when full qty DCd test case is successful");
				extentTest.log(LogStatus.PASS, "OA no not available when full qty DCd test case is successful");
			}else{
				System.err.println("OA no not available when full qty DCd test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test102_OaNotAvail_FullQtyDC")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("OA no not available when full qty DCd");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test107_VerifyRefDocNo_W1Oa() throws Exception{
		log.startTestCase("Verify Ref doc no for job in wih 1 Oa");
		extentTest = extent.startTest("Test107_VerifyRefDocNo_W1Oa",
				"Verify if ref doc no for grn against job in oa with 1 OA").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(106,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Verify Ref doc no for job in wih 1 Oa test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Ref doc no for job in wih 1 Oa test case is successful");
			}else{
				System.err.println("Verify Ref doc no for job in wih 1 Oa test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test107_VerifyRefDocNo_W1Oa")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify Ref doc no for job in wih 1 Oa");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test108_VerifyRefDocNo_WmultiOa() throws Exception{
		log.startTestCase("Verify Ref doc no for job in wih multi Oa");
		extentTest = extent.startTest("Test108_VerifyRefDocNo_WmultiOa",
				"Verify if ref doc no for grn against job in oa with multi OA").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addGRN(107,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Verify Ref doc no for job in wih multi Oa test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Ref doc no for job in wih multi Oa test case is successful");
			}else{
				System.err.println("Verify Ref doc no for job in wih multi Oa test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test108_VerifyRefDocNo_WmultiOa")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify Ref doc no for job in wih multi Oa");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test109_MultipleGRN_SameOA() throws Exception{
		log.startTestCase("Multiple GRN same OA");
		extentTest = extent.startTest("Test109_MultipleGRN_SameOA",
				"Verify able to create multiple grn for same OA").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		boolean flag = false;
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToOA();
			Thread.sleep(Constant.Min_Sleep);
			sales.validateApproveOA(108,"Receipt Job in");
			int i = sales.oaList.size()-1;
			String sOANumber = sales.oaList.get(i).getText();
			for(int j=0;j<3;j++){
				boolean flag1 = store.addGRN(108,"Receipt Job in", sOANumber);
				if(flag1){
					flag = true;
				}else{
					flag = false;
					break;
				}
			}
			if(flag){
				Constant.log.info("Verify able to create multiple grn for same OA test case is successful");
				extentTest.log(LogStatus.PASS, "Verify able to create multiple grn for same OA test case is successful");
			}else{
				System.err.println("Verify able to create multiple grn for same OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test109_MultipleGRN_SameOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify able to create multiple grn for same OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test110_VerifyJobInGRNNotAvailICd() throws Exception{
		log.startTestCase("Verify Job in GRN not available in ICD");
		extentTest = extent.startTest("Test110_VerifyJobInGRNNotAvailICd",
				"Verify Job in GRN not available in ICD").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.approveGRN(109,"Receipt Job in", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.verifyGRNNotAvail(sGRNNo);
			if(flag){
				Constant.log.info("Verify Job in GRN not available in ICD test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Job in GRN not available in ICD test case is successful");
			}else{
				System.err.println("Verify Job in GRN not available in ICD test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test110_VerifyJobInGRNNotAvailICd")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify Job in GRN not available in ICD");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test112_ValStockMat_WOAltUnit() throws Exception{
		log.startTestCase("Validate Material stock without alternate unit");
		extentTest = extent.startTest("Test112_ValStockMat_WOAltUnit",
				"Verify if Supplier price is Resubmited").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToProfile();
			Thread.sleep(Constant.Min_Sleep);
			setting.purchaseMandatoryChkBx_UnCheck();
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			String sStock = master.fetchStock(111,"Receipt Job in");
			store.addGRN(111,"Receipt Job in", null);
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.validateStockWOMake(111,"Receipt Job in", sStock);
			if(flag){
				Constant.log.info("Supplier price removed test case is successful");
				extentTest.log(LogStatus.PASS, "Supplier price removed test case is successful");
			}else{
				System.err.println("Supplier price removed test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test112_ValStockMat_WOAltUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Validate Material stock without alternate unit");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test115_UpdateJobInGRN_WQty() throws Exception{
		log.startTestCase("Job in GRN update with qty");
		extentTest = extent.startTest("Test115_UpdateJobInGRN_WQty",
				"Verify if grn against job in is updated with qty").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.addGRN(114,"Receipt Job in", null);
			boolean flag = store.validateDraftUpdateQty(114,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN updated with qty test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN updated with qty test case is successful");
			}else{
				System.err.println("Job in GRN updated with qty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test115_UpdateJobInGRN_WQty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN updated with qty");
	}

	@Test  @Category(SanityTests.class)
	public void Test117_UpdateJobInGRN_WQtyViewOaMatPopup() throws Exception{
		log.startTestCase("Job in GRN update qty from oa material popup");
		extentTest = extent.startTest("Test117_UpdateJobInGRN_WQtyViewOaMatPopup",
				"Verify if grn against job in is updated qty from oa material popup").assignCategory("ReceiptJobInTestCases","SanityTests");
		try{
			boolean flag = store.updateGRN(116,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN updated qty from oa material popup test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN updated qty from oa material popup test case is successful");
			}else{
				System.err.println("Job in GRN updated qty from oa material popup test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test117_UpdateJobInGRN_WQtyViewOaMatPopup")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN updated qty from oa material popup");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test118_UpdateJobInGRN_AddOA() throws Exception{
		log.startTestCase("Job in GRN update adding oa");
		extentTest = extent.startTest("Test118_UpdateJobInGRN_AddOA",
				"Verify if grn against job in is updated adding oa").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.addGRN(117,"Receipt Job in", null);
			boolean flag = store.updateGRNByAddingJo(117,"Receipt Job in");
			if(flag){
				Constant.log.info("Job in GRN updated adding oa test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN updated adding oa test case is successful");
			}else{
				System.err.println("Job in GRN updated adding oa test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test118_UpdateJobInGRN_AddOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN updated adding oa");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test123_UpdateJobInGRN_AddStockMat() throws Exception{
		log.startTestCase("Job in GRN update adding stock mat");
		extentTest = extent.startTest("Test123_UpdateJobInGRN_AddStockMat",
				"Verify if grn against job in is updated adding stock mat").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.updateGRN(122,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN updated adding stock mat test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN updated adding stock mat test case is successful");
			}else{
				System.err.println("Job in GRN updated adding stock mat test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test123_UpdateJobInGRN_AddStockMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN updated adding stock mat");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test124_UpdateJobInGRN_AddNonStockMat() throws Exception{
		log.startTestCase("Job in GRN update adding NonStock mat");
		extentTest = extent.startTest("Test124_UpdateJobInGRN_AddNonStockMat",
				"Verify if grn against job in is updated adding NonStock mat").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.updateGRN(123,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN updated adding NonStock mat test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN updated adding NonStock mat test case is successful");
			}else{
				System.err.println("Job in GRN updated adding NonStock mat test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test124_UpdateJobInGRN_AddNonStockMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN updated adding NonStock mat");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test127_UpdateJobInGRN_DeleteMAtWOOa() throws Exception{
		log.startTestCase("Job in GRN update deleting material without Oa");
		extentTest = extent.startTest("Test127_UpdateJobInGRN_DeleteMAtWOOa",
				"Verify if grn against job in is updated deleting material without Oa").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.addGRN(126,"Receipt Job in", null);
			boolean flag = store.deleteMatWOOa(117,"Receipt Job in");//dont change the row no
			if(flag){
				Constant.log.info("Job in GRN updated deleting material without Oa test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN updated deleting material without Oa test case is successful");
			}else{
				System.err.println("Job in GRN updated deleting material without Oa test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test127_UpdateJobInGRN_DeleteMAtWOOa")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN updated deleting material without Oa");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test128_UpdateJobInGRN_AddingNewOa() throws Exception{
		log.startTestCase("Job in GRN update adding New OA");
		extentTest = extent.startTest("Test128_UpdateJobInGRN_AddingNewOa",
				"Verify if grn against job in is updated adding New OA").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.addGRN(123,"Receipt Job in", null);//dont change rowno
			boolean flag = store.validateGRNUpdate(127,"Receipt Job in", null);
			if(flag){
				Constant.log.info("Job in GRN updated adding New OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN updated adding New OA test case is successful");
			}else{
				System.err.println("Job in GRN updated adding New OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test128_UpdateJobInGRN_AddingNewOa")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN updated adding New OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test132_UpdateJobInGRN_UnselectAddingNewOa() throws Exception{
		log.startTestCase("Job in GRN update by unselecting OA and adding New OA");
		extentTest = extent.startTest("Test132_UpdateJobInGRN_UnselectAddingNewOa",
				"Verify if grn against job in is updated by unselecting OA and adding New OA").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.addGRN(117,"Receipt Job in", null);//dont change rown no
			boolean flag = store.unselectOA(131,"Receipt Job in");
			if(flag){
				Constant.log.info("Job in GRN updated by unselecting OA and adding New OA test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN updated by unselecting OA and adding New OA test case is successful");
			}else{
				System.err.println("Job in GRN updated by unselecting OA and adding New OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test132_UpdateJobInGRN_UnselectAddingNewOa")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN update by unselecting OA and adding New OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test134_UpdateJobInGRN_Supplier() throws Exception{
		log.startTestCase("Job in GRN update supplier");
		extentTest = extent.startTest("Test134_UpdateJobInGRN_Supplier",
				"Verify if grn against job in is updated supplier").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.addGRN(123,"Receipt Job in", null);//dont change rown no
			boolean flag = store.updateGRNParty(133,"Receipt Job in");
			if(flag){
				Constant.log.info("Job in GRN updated supplier test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN updated supplier test case is successful");
			}else{
				System.err.println("Job in GRN updated supplier test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test134_UpdateJobInGRN_Supplier")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN updated supplier");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test136_UpdateOANoJobInGRNWOOa() throws Exception{
		log.startTestCase("Update Oa no for GRN without OA");
		extentTest = extent.startTest("Test136_UpdateOANoJobInGRNWOOa",
				"Verify if grn against job in is updated oa no").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.addGRN(133,"Receipt Job in", null);//dont change rown no
			boolean flag = store.selectOANoGRN(135,"Receipt Job in");
			if(flag){
				Constant.log.info("Update Oa no for GRN without OA test case is successful");
				extentTest.log(LogStatus.PASS, "Update Oa no for GRN without OA test case is successful");
			}else{
				System.err.println("Update Oa no for GRN without OA test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test136_UpdateOANoJobInGRNWOOa")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Oa no for GRN without OA");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test141_AmendJobInGRN_AddOA() throws Exception{
		log.startTestCase("Job in GRN Amend adding oa");
		extentTest = extent.startTest("Test141_AmendJobInGRN_AddOA",
				"Verify if grn against job in is Amendd adding oa").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.approveGRN(140,"Receipt Job in", null);
			boolean flag = store.amendGRNByAddingJo(140,"Receipt Job in");
			if(flag){
				Constant.log.info("Job in GRN Amendd adding oa test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN Amendd adding oa test case is successful");
			}else{
				System.err.println("Job in GRN Amendd adding oa test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test141_AmendJobInGRN_AddOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN Amendd adding oa");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test145_AmendJobInGRN_AddMAtWOOA () throws Exception{
		log.startTestCase("Job in GRN Amend adding material without OA ");
		extentTest = extent.startTest("Test145_AmendJobInGRN_AddMAtWOOA",
				"Verify if grn against job in is Amendd adding material without OA ").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.approveGRN(140,"Receipt Job in", null);
			boolean flag = store.validateGRNAmend(144,"Receipt Job in");
			if(flag){
				Constant.log.info("Job in GRN Amendd adding material without OA  test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN Amendd adding material without OA  test case is successful");
			}else{
				System.err.println("Job in GRN Amendd adding material without OA  test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test145_AmendJobInGRN_AddMAtWOOA")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN Amendd adding material without OA ");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test146_AmendJobInGRN_updatingQty () throws Exception{
		log.startTestCase("Job in GRN Amend updating qty ");
		extentTest = extent.startTest("Test146_AmendJobInGRN_updatingQty",
				"Verify if grn against job in is Amendd updating qty ").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.approveGRN(145,"Receipt Job in", null);
			boolean flag = store.validateGRNAmend(145,"Receipt Job in");
			if(flag){
				Constant.log.info("Job in GRN Amendd updating qty  test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN Amendd updating qty  test case is successful");
			}else{
				System.err.println("Job in GRN Amendd updating qty  test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test146_AmendJobInGRN_updatingQty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Job in GRN Amendd updating qty ");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test158_validateMaterialIssueReport() throws Exception{
		log.startTestCase("Material issue receipt report");
		extentTest = extent.startTest("Test158_validateMaterialIssueReport",
				"Verify if grn job in avaialble in Material issue receipt report").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.addGRN(157,"Receipt Job in", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterialReceiptReport();
			boolean flag = store.validateMaterialIssueReport(157,"Receipt Job in", sGRNNo);
			if(flag){
				Constant.log.info("Job in GRN avaialble in Material issue receipt report test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN avaialble in Material issue receipt report test case is successful");
			}else{
				System.err.println("Job in GRN avaialble in Material issue receipt report test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test158_validateMaterialIssueReport")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Material issue receipt report");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test210_validateMaterialIssueReport() throws Exception{
		log.startTestCase("Material issue receipt report");
		extentTest = extent.startTest("Test210_validateMaterialIssueReport",
				"Verify if grn job in avaialble in Material issue receipt report").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		try{
			store.approveGRN(209,"Receipt Job in", null);
			boolean flag = store.MatUsageBtnNotDisplayed();
			if(flag){
				Constant.log.info("Job in GRN avaialble in Material issue receipt report test case is successful");
				extentTest.log(LogStatus.PASS, "Job in GRN avaialble in Material issue receipt report test case is successful");
			}else{
				System.err.println("Job in GRN avaialble in Material issue receipt report test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test210_validateMaterialIssueReport")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Material issue receipt report");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test215_MaterialUsageValidation() throws Exception{
		log.startTestCase("Validate material usage popup after JIN creation");
		extentTest = extent.startTest("Test215_MaterialUsageValidation",
				"Verify if material usage popup after JIN creation").assignCategory("ReceiptJobInTestCases","HighPriorityTestCases");
		JavascriptExecutor js = ((JavascriptExecutor) Constant.driver);
		try{
			store.approveGRN(214, "Receipt Job in", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			sales.addInvoice(214, "Receipt Job in", sGRNNo);
			String sInvoices = Integer.toString(sales.invoices.size());
			js.executeScript("arguments[0].scrollIntoView(true);", Constant.driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/a")));
			String sInvoiceNo = Constant.driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[2]/a")).getText();
			boolean flag = store.vaildateMaterialUsage(214, "Receipt Job in", sInvoiceNo);
			if(flag){
				Constant.log.info("Validate material usage popup after JIN creation test case is successful");
				extentTest.log(LogStatus.PASS, "Validate material usage popup after JIN creation test case is successful");
			}else{
				System.err.println("Validate material usage popup after JIN creation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test215_MaterialUsageValidation")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate material usage popup after JIN creation");
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
