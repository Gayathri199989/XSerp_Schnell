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
import pages.AuditingPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IRTestCases {

	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);
	AuditingPage audit = PageFactory.initElements(Constant.driver, AuditingPage.class);
	ProfilePage master = PageFactory.initElements(Constant.driver, ProfilePage.class);

	static ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	static String extentReportFile;
	static ExtentReports extent;
	static ExtentTest extentTest;

	@BeforeClass
	public static void BeforeClass() throws Exception{
		extentReportFile = property.getExtentReportFile()+"ExtentReport"+Constant.date+"."+"html";
		// Create object of extent report and specify the report file path.
		extent = new ExtentReports(extentReportFile, false);
		Constant.logFile("Internal Receipt");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(SmokeTest.class)
	public void Test020_AddIssueGRNWithSingleIssue() throws Exception{
		log.startTestCase("Add Issue GRN with single issue no");
		extentTest = extent.startTest("Test020_AddIssueGRNWithSingleIssue",
				"Verify if Issue GRN is added with single issue no").assignCategory("IRTestCases","SmokeTest");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(19, "Internal Receipt",null);
			if(flag){
				Constant.log.info("Issue GRN addition with single issue no is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with single issue no is successful");
			}else{
				System.err.println("Issue GRN addition with single issue no failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test020_AddIssueGRNWithSingleIssue")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with single issue no");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test021_AddIssueGRNwithMultIssueNo() throws Exception{
		log.startTestCase("Add Issue GRN with multiple issue no");
		extentTest = extent.startTest("Test021_AddIssueGRNwithMultIssueNo",
				"Verify if Issue GRN is added with multiple issue no").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(20, "Internal Receipt",null);
			if(flag){
				Constant.log.info("Issue GRN addition with multiple issue no is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with multiple issue no is successful");
			}else{
				System.err.println("Issue GRN addition with multiple issue no failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test021_AddIssueGRNwithMultIssueNo")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with multiple issue no");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test023_AddIssueGRNwithoutMake() throws Exception{
		log.startTestCase("Add Issue GRN with without make");
		extentTest = extent.startTest("Test023_AddIssueGRNwithoutMake",
				"Verify if Issue GRN is added with without make").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(22, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(22, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Issue GRN addition with without make is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with without make is successful");
			}else{
				System.err.println("Issue GRN addition with without make failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test023_AddIssueGRNwithoutMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with without make");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test024_AddIssueGRNwithMake() throws Exception{
		log.startTestCase("Add Issue GRN with make");
		extentTest = extent.startTest("Test024_AddIssueGRNwithMake",
				"Verify if Issue GRN is added with make").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(23, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(23, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Issue GRN addition with make is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with make is successful");
			}else{
				System.err.println("Issue GRN addition with make failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test024_AddIssueGRNwithMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with make");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test025_AddIssueGRNMultiWOMake() throws Exception{
		log.startTestCase("Add Issue GRN with multiple material without make");
		extentTest = extent.startTest("Test025_AddIssueGRNMultiWOMake",
				"Verify if Issue GRN is added with multiple material without make").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(24, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(24, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Issue GRN addition with multiple material without make is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with multiple material without make is successful");
			}else{
				System.err.println("Issue GRN addition with multiple material without make failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test025_AddIssueGRNMultiWOMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with multiple material without make");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test026_AddIssueGRNMultiWMake() throws Exception{
		log.startTestCase("Add Issue GRN with multiple material  make");
		extentTest = extent.startTest("Test026_AddIssueGRNMultiWMake",
				"Verify if Issue GRN is added with multiple material  make").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(25, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(25, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Issue GRN addition with multiple material  make is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with multiple material  make is successful");
			}else{
				System.err.println("Issue GRN addition with multiple material  make failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test026_AddIssueGRNMultiWMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with multiple material  make");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test027_AddIssueGRNWNWOMake() throws Exception{
		log.startTestCase("Add Issue GRN with N without make");
		extentTest = extent.startTest("Test027_AddIssueGRNWNWOMake",
				"Verify if Issue GRN is added with N without make").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(26, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(26, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Issue GRN addition with N without make is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with N without make is successful");
			}else{
				System.err.println("Issue GRN addition with N without make failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test027_AddIssueGRNWNWOMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with N without make");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test028_AddIssueGRNWFaulty() throws Exception{
		log.startTestCase("Add Issue GRN with faulty");
		extentTest = extent.startTest("Test028_AddIssueGRNWFaulty",
				"Verify if Issue GRN is added with faulty").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(27, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(27, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Issue GRN addition with faulty is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with faulty is successful");
			}else{
				System.err.println("Issue GRN addition with faulty failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test028_AddIssueGRNWFaulty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with faulty");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test029_AddIssueGRNWMultiFaulty() throws Exception{
		log.startTestCase("Add Issue GRN with multiple faulty material");
		extentTest = extent.startTest("Test029_AddIssueGRNWMultiFaulty",
				"Verify if Issue GRN is added with multiple faulty material").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(28, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(28, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Issue GRN addition with multiple faulty material is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with multiple faulty material is successful");
			}else{
				System.err.println("Issue GRN addition with multiple faulty material failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test029_AddIssueGRNWMultiFaulty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with multiple faulty material");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test030_AddIssueGRNWMakeNFaulty() throws Exception{
		log.startTestCase("Add Issue GRN with make and faulty");
		extentTest = extent.startTest("Test030_AddIssueGRNWMakeNFaulty",
				"Verify if Issue GRN is added with make and faulty").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(29, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(29, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Issue GRN addition with make and faulty is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with make and faulty is successful");
			}else{
				System.err.println("Issue GRN addition with make and faulty failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test030_AddIssueGRNWMakeNFaulty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with make and faulty");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test031_AddIssueGRNWNWOMakeNFaulty() throws Exception{
		log.startTestCase("Add Issue GRN with N without make and faulty");
		extentTest = extent.startTest("Test031_AddIssueGRNWNWOMakeNFaulty",
				"Verify if Issue GRN is added with N without make and faulty").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(30, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(30, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Issue GRN addition with N without make and faulty is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with N without make and faulty is successful");
			}else{
				System.err.println("Issue GRN addition with N without make and faulty failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test031_AddIssueGRNWNWOMakeNFaulty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with N without make and faulty");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test032_AddIssueGRNSameMatWNWOMakeNFaulty() throws Exception{
		log.startTestCase("Add Issue GRN with same material having make WO make and faulty");
		extentTest = extent.startTest("Test032_AddIssueGRNSameMatWNWOMakeNFaulty",
				"Verify if Issue GRN is added with same material having make WO make and faulty").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(31, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(31, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Issue GRN addition with same material having make WO make and faulty is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with same material having make WO make and faulty is successful");
			}else{
				System.err.println("Issue GRN addition with same material having make WO make and faulty failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test032_AddIssueGRNSameMatWNWOMakeNFaulty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with same material having make WO make and faulty");
	}

	@Test  @Category(SanityTests.class)
	public void Test037_ApproveIssueGRN() throws Exception{
		log.startTestCase("Approve Issue GRN");
		extentTest = extent.startTest("Test037_ApproveIssueGRN",
				"Verify if GRN is Approved").assignCategory("IRTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.approveGRN(36, "Internal Receipt",null);
			if(flag){
				Constant.log.info("Issue GRN Approve is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN Approve is successful");
			}else{
				System.err.println("Issue GRN Approve failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test037_ApproveIssueGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Issue Approve GRN");
	}

	@Test  @Category(SanityTests.class)
	public void Test038_DraftIssueGRNReject() throws Exception{
		log.startTestCase("Draft Issue GRN Reject");
		extentTest = extent.startTest("Test038_DraftIssueGRNReject",
				"Verify if draft Issue GRN is Rejected").assignCategory("IRTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.validateDraftRejectGRN(37, "Internal Receipt");
			if(flag){
				Constant.log.info("Draft Issue GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Draft Issue GRN Reject is successful");
			}else{
				System.err.println("Draft Issue GRN Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test038_DraftIssueGRNReject")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft Issue GRN Reject");
	}

	@Test  @Category(SanityTests.class)
	public void Test039_ApprovedIssueGRNReject() throws Exception{
		log.startTestCase("Approved Issue GRN Reject");
		extentTest = extent.startTest("Test039_ApprovedIssueGRNReject",
				"Verify if Approved Issue GRN is Rejected").assignCategory("IRTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.vaildateRejectApprovedGRN(38, "Internal Receipt",null);
			if(flag){
				Constant.log.info("Approved Issue GRN Reject is successful");
				extentTest.log(LogStatus.PASS, "Approved Issue GRN Reject is successful");
			}else{
				System.err.println("Approved Issue GRN Reject failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test039_ApprovedIssueGRNReject")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approved Issue GRN Reject");
	}

	@Test  @Category(SanityTests.class)
	public void Test040_UpdateIRNWithoutMake() throws Exception{
		log.startTestCase("Update IRN Without Make");
		extentTest = extent.startTest("Test040_UpdateIRNWithoutMake",
				"Verify if IRN can be updated by adding Material Without make ").assignCategory("IRTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(39, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.updateGRN(39, "Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Verify if IRN can be updated by adding Material Without make  is successful");
				extentTest.log(LogStatus.PASS, "Verify if IRN can be updated by adding Material Without make  is successful");
			}else{
				System.err.println("Verify if IRN can be updated by adding Material Without make  failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test040_UpdateIRNWithoutMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update IRN Without Make");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test041_UpdateIRNWithMake() throws Exception{
		log.startTestCase("Update IRN with Make");
		extentTest = extent.startTest("Test041_UpdateIRNWithMake",
				"Verify if IRN can be updated by adding Material with make ").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(40, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.updateGRN(40, "Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Verify if IRN can be updated by adding Material with make  is successful");
				extentTest.log(LogStatus.PASS, "Verify if IRN can be updated by adding Material with make  is successful");
			}else{
				System.err.println("Verify if IRN can be updated by adding Material with make  failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test041_UpdateIRNWithMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update IRN with Make");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test042_UpdateIRNWithFaulty() throws Exception{
		log.startTestCase("Update IRN with Faulty");
		extentTest = extent.startTest("Test042_UpdateIRNWithFaulty",
				"Verify if IRN can be updated by adding Material with Faulty ").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(41, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.updateGRN(41, "Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Verify if IRN can be updated by adding Material with Faulty  is successful");
				extentTest.log(LogStatus.PASS, "Verify if IRN can be updated by adding Material with Faulty  is successful");
			}else{
				System.err.println("Verify if IRN can be updated by adding Material with Faulty  failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test042_UpdateIRNWithFaulty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update IRN with Faulty");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test043_UpdateIRNByAddSameMatDiffIssue() throws Exception{
		log.startTestCase("Update IRN By adding same material with different issue");
		extentTest = extent.startTest("Test043_UpdateIRNByAddSameMatDiffIssue",
				"Verify if IRN can be updated By adding same material with different issue").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(42, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(42, "Internal Receipt", sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(42, "Internal Receipt");
			sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.validateIssueAdd_IRN(42, "Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Verify if IRN can be updated By adding same material with different issue is successful");
				extentTest.log(LogStatus.PASS, "Verify if IRN can be updated By adding same material with different issue is successful");
			}else{
				System.err.println("Verify if IRN can be updated By adding same material with different issue failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test043_UpdateIRNByAddSameMatDiffIssue")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update IRN By adding same material with different issue");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test044_UpdateIRNByAddSameFaultyMatDiffIssue() throws Exception{
		log.startTestCase("Update IRN By adding same faulty material with different issue");
		extentTest = extent.startTest("Test044_UpdateIRNByAddSameFaultyMatDiffIssue",
				"Verify if IRN can be updated By adding same faulty material with different issue").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(43, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(43, "Internal Receipt", sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(43, "Internal Receipt");
			sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.validateIssueAdd_IRN(43, "Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Verify if IRN can be updated By adding same faulty material with different issue is successful");
				extentTest.log(LogStatus.PASS, "Verify if IRN can be updated By adding same faulty material with different issue is successful");
			}else{
				System.err.println("Verify if IRN can be updated By adding same faulty material with different issue failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test044_UpdateIRNByAddSameFaultyMatDiffIssue")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update IRN By adding same faulty material with different issue");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test045_UpdateIRNByAddSameMakeNFaultyMatDiffIssue() throws Exception{
		log.startTestCase("Update IRN By adding same make and faultymaterial with different issue");
		extentTest = extent.startTest("Test045_UpdateIRNByAddSameMakeNFaultyMatDiffIssue",
				"Verify if IRN can be updated By adding same make and faultymaterial with different issue").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(44, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(44, "Internal Receipt", sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(44, "Internal Receipt");
			sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.validateIssueAdd_IRN(44, "Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Verify if IRN can be updated By adding same make and faultymaterial with different issue is successful");
				extentTest.log(LogStatus.PASS, "Verify if IRN can be updated By adding same make and faultymaterial with different issue is successful");
			}else{
				System.err.println("Verify if IRN can be updated By adding same make and faultymaterial with different issue failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test045_UpdateIRNByAddSameMakeNFaultyMatDiffIssue")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update IRN By adding same make and faultymaterial with different issue");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test046_WarningPopupDraftIRN_DeleteMat() throws Exception{
		log.startTestCase("Validate warning popup after deleting material for draft IRN");
		extentTest = extent.startTest("Test046_WarningPopupDraftIRN_DeleteMat",
				"Verify if warning popup is displayed when material for draft IRN deleted and IRN updated").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.warningpoup_AllMatDelete(45, "Internal Receipt");
			if(flag){
				Constant.log.info("Verify if warning popup is displayed when material for draft IRN deleted and IRN updated is successful");
				extentTest.log(LogStatus.PASS, "Verify if warning popup is displayed when material for draft IRN deleted and IRN updated is successful");
			}else{
				System.err.println("Verify if warning popup is displayed when material for draft IRN deleted and IRN updated failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test046_WarningPopupDraftIRN_DeleteMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate warning popup after deleting material for draft IRN");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test047_Update_DeleteAllMatExceptOne() throws Exception{
		log.startTestCase("Update by deleting all material except one");
		extentTest = extent.startTest("Test047_Update_DeleteAllMatExceptOne",
				"Verify if warning popup is displayed when material deleted and IRN updated").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(46, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(46, "Internal Receipt", sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.UpdateIRN_deleteAllMatExceptOne(46, "Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Verify if warning popup is displayed when material deleted and IRN updated is successful");
				extentTest.log(LogStatus.PASS, "Verify if warning popup is displayed when material deleted and IRN updated is successful");
			}else{
				System.err.println("Verify if warning popup is displayed when material deleted and IRN updated failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test047_Update_DeleteAllMatExceptOne")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update by deleting all material except one");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test048_Update_DeleteItemWOMakeRFaulty() throws Exception{
		log.startTestCase("Update by deleting item without make or faulty");
		extentTest = extent.startTest("Test048_Update_DeleteItemWOMakeRFaulty",
				"Verify if IRN updated by deleting item without make or faulty").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(47, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(47, "Internal Receipt", sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.UpdateIRN_deleteItemWOMakeRFaulty(47, "Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Verify if IRN updated by deleting item without make or faulty is successful");
				extentTest.log(LogStatus.PASS, "Verify if IRN updated by deleting item without make or faulty is successful");
			}else{
				System.err.println("Verify if IRN updated by deleting item without make or faulty failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test048_Update_DeleteItemWOMakeRFaulty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update by deleting item without make or faulty");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test049_Update_DeleteItemWMakeRFaulty() throws Exception{
		log.startTestCase("Update by deleting item with make or faulty");
		extentTest = extent.startTest("Test049_Update_DeleteItemWMakeRFaulty",
				"Verify if IRN updated by deleting item with make or faulty").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(48, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(48, "Internal Receipt", sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.UpdateIRN_deleteItemWMakeRFaulty(48, "Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Verify if IRN updated by deleting item with make or faulty is successful");
				extentTest.log(LogStatus.PASS, "Verify if IRN updated by deleting item with make or faulty is successful");
			}else{
				System.err.println("Verify if IRN updated by deleting item with make or faulty failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test049_Update_DeleteItemWMakeRFaulty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update by deleting item with make or faulty");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test050_ValidWarnMSg_AcceptQtyMoreThanPending() throws Exception{
		log.startTestCase("Validate warning message when accepted qty more than pending qty");
		extentTest = extent.startTest("Test050_ValidWarnMSg_AcceptQtyMoreThanPending",
				"Verify if warning message when accepted qty more than pending qty").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(49, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.verifyWarnMsgAccepQtyMoreThanPendQty(49, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Verify if warning message when accepted qty more than pending qty is successful");
				extentTest.log(LogStatus.PASS, "Verify if warning message when accepted qty more than pending qty is successful");
			}else{
				System.err.println("Verify if warning message when accepted qty more than pending qty failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test050_ValidWarnMSg_AcceptQtyMoreThanPending")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate warning message when accepted qty more than pending qty");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test051_ValidWarnMSg_AcceptQtyMoreThanReceived() throws Exception{
		log.startTestCase("Validate warning message when accepted qty more than received qty");
		extentTest = extent.startTest("Test051_ValidWarnMSg_AcceptQtyMoreThanreceived",
				"Verify if warning message when accepted qty more than received qty").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(50, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.verifyWarnMsgAccepQtyMoreThanReceivedQty(50, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Verify if warning message when accepted qty more than received qty is successful");
				extentTest.log(LogStatus.PASS, "Verify if warning message when accepted qty more than received qty is successful");
			}else{
				System.err.println("Verify if warning message when accepted qty more than received qty failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test051_ValidWarnMSg_AcceptQtyMoreThanreceived")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate warning message when accepted qty more than received qty");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test052_UpdateIRNQty() throws Exception{
		log.startTestCase("Update IRN Qty");
		extentTest = extent.startTest("Test052_UpdateIRNQty",
				"Verify if IRN qty is updated").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(51, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(51, "Internal Receipt", sIssueNo);
			boolean flag = store.validateDraftUpdateQty(51, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("IRN qty update is successful");
				extentTest.log(LogStatus.PASS, "IRN qty update is successful");
			}else{
				System.err.println("IRN qty is update failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test052_UpdateIRNQty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update IRN Qty");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test053_UpdateIRNChangingIssueNo() throws Exception{
		log.startTestCase("Update IRN changing issue no");
		extentTest = extent.startTest("Test053_UpdateIRNChangingIssueNo",
				"Verify if IRN changing issue no is updated").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.updateIRN_ChangeIssueNo(52, "Internal Receipt", "Draft");
			if(flag){
				Constant.log.info("IRN changing issue no update is successful");
				extentTest.log(LogStatus.PASS, "IRN changing issue no update is successful");
			}else{
				System.err.println("IRN changing issue no is update failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test053_UpdateIRNChangingIssueNo")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update IRN changing issue no");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test055_VerifyPendingQtyAfterIssueUpdate() throws Exception{
		log.startTestCase("Verify pending qty after issue update");
		extentTest = extent.startTest("Test055_VerifyPendingQtyAfterIssueUpdate",
				"Verify if pending qty is updated after issue is updated").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(54, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			store.updateIssue_MatQty();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.verifyPendingQtyOfIssue(54, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Verify pending qty after issue update is successful");
				extentTest.log(LogStatus.PASS, "Verify pending qty after issue update is successful");
			}else{
				System.err.println("Pending qty updated after issue update failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test055_VerifyPendingQtyAfterIssueUpdate")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify pending qty after issue update");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test056_WarningIssueReturnMatDeleted() throws Exception{
		log.startTestCase("Verify warning displayed when material deleted ");
		extentTest = extent.startTest("Test056_WarningIssueReturnMatDeleted",
				"Verify if warning displayed when material deleted after IRN creation").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(55, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(55, "Internal Receipt",sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.WarningDeleteMat_AfterIRN();
			if(flag){
				Constant.log.info("Verify warning displayed when material deleted after irn creation test case is successful");
				extentTest.log(LogStatus.PASS, "Verify warning displayed when material deleted after irn creation test case is successful");
			}else{
				System.err.println("Warning not displayed when material deleted after IRN creation");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test056_WarningIssueReturnMatDeleted")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify pending qty after issue update");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test057_WarningReduceQty() throws Exception{
		log.startTestCase("Verify warning popup displayed when qty reduced below returned qty ");
		extentTest = extent.startTest("Test057_WarningReduceQty",
				"Verify warning popup displayed when qty reduced below returned qty").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(56, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(56, "Internal Receipt",sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.WarningPopUp_MatQty();
			if(flag){
				Constant.log.info("Verify warning popup displayed when qty reduced below returned qty test case is successful");
				extentTest.log(LogStatus.PASS, "Verify warning popup displayed when qty reduced below returned qty test case is successful");
			}else{
				System.err.println("Warning not displayed when material deleted after IRN creation");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test057_WarningReduceQty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify warning popup displayed when qty reduced below returned qty");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test058_IRNNotAvailICD() throws Exception{
		log.startTestCase("Verify IRN not displayed in ICD page");
		extentTest = extent.startTest("Test058_IRNNotAvailICD",
				"Verify IRN not displayed in ICD page").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(57, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.approveGRN(57, "Internal Receipt",sIssueNo);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.verifyGRNNotDisplayed(sGRNNo);
			if(flag){
				Constant.log.info("Verify IRN not displayed in ICD page test case is successful");
				extentTest.log(LogStatus.PASS, "Verify IRN not displayed in ICD page test case is successful");
			}else{
				System.err.println("IRN displayed in ICD page verification test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test058_IRNNotAvailICD")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify warning popup displayed when qty reduced below returned qty");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test060_ReduceMatQtyAfterIRNReject() throws Exception{
		log.startTestCase("Reduce Material Qty After IRN Reject");
		extentTest = extent.startTest("Test060_ReduceMatQtyAfterIRNReject",
				"Verify if able to reduce issue material qty after irn rejected").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(59, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.vaildateRejectApprovedGRN(59, "Internal Receipt",sIssueNo);
			boolean flag = store.updateIRN_ReduceMatQty(59, "Internal Receipt",sIssueNo);
			if(flag){
				Constant.log.info("Verify able to reduce issue material qty after irn rejected test case is successful");
				extentTest.log(LogStatus.PASS, "Verify able to reduce issue material qty after irn rejected test case is successful");
			}else{
				System.err.println("Unable to reduce issue material qty after irn rejected");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test060_ReduceMatQtyAfterIRNReject")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reduce Material Qty After IRN Reject");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test061_PendingIssueQty_AddPage() throws Exception{
		log.startTestCase("Pending Issue Qty in Add Page");
		extentTest = extent.startTest("Test061_PendingIssueQty_AddPage",
				"Verify if warning displayed when material deleted after IRN creation").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(60, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(60, "Internal Receipt",sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.WarningDeleteMat_AfterIRN();
			if(flag){
				Constant.log.info("Verify warning displayed when material deleted after irn creation test case is successful");
				extentTest.log(LogStatus.PASS, "Verify warning displayed when material deleted after irn creation test case is successful");
			}else{
				System.err.println("Warning not displayed when material deleted after IRN creation");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test061_PendingIssueQty_AddPage")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Pending Issue Qty in Add Page");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test062_validateRemarkLinkinEditPge_AddGRN() throws Exception{
		log.startTestCase("Remark Link validation in edit page for Add GRN");
		extentTest = extent.startTest("Test062_validateRemarkLinkinEditPge_AddGRN",
				"Verify if remark link after add IRN").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(61, "Internal Receipt",null);
			boolean flag = store.verifyRemarkLink_AddGRN();
			if(flag){
				Constant.log.info("Verify Remark link validation in edit page after grn add test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Remark link validation in edit page after grn add test case is successful");
			}else{
				System.err.println("Remark link validation in edit page test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test062_validateRemarkLinkinEditPge_AddGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Remark Link validation in edit page for Add GRN");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test063_validateRemarkLinkinEditPge_UpdateIRN() throws Exception{
		log.startTestCase("Remark Link validation in edit page UpdateIRN");
		extentTest = extent.startTest("Test063_validateRemarkLinkinEditPge_UpdateIRN",
				"Verify if remark link after add IRN").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.updateGRN(61, "Internal Receipt",null);
			boolean flag = store.verifyRemarkLink_UpdateGRN();
			if(flag){
				Constant.log.info("Verify Remark link validation in edit page UpdateIRN test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Remark link validation in edit page UpdateIRN test case is successful");
			}else{
				System.err.println("Remark link validation in edit page test case failed");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test063_validateRemarkLinkinEditPge_UpdateIRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Remark Link validation in edit page UpdateIRN");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test074_VerifyApproveIRNDetails_MatReturned() throws Exception{
		log.startTestCase("Approve IRN Details in Material Returned pop up");
		extentTest = extent.startTest("Test074_VerifyApproveIRNDetails_MatReturned",
				"Verify if Approve IRN details gets displayed in Material returned popup").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.approvedIRNDetailsValidate(73,"Internal Receipt");
			if(flag){
				Constant.log.info("Validate Approve IRN details displayed in Material returned popup test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Approve IRN details displayed in Material returned popup test case is successful");
			}else{
				System.err.println("Validate Approve IRN details displayed in Material returned popup test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test074_VerifyApproveIRNDetails_MatReturned")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve IRN Details in Material Returned pop up");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test075_VerifyRejectIRNDetail_MatReturned() throws Exception{
		log.startTestCase("Reject IRN Details in Material Returned pop up");
		extentTest = extent.startTest("Test075_VerifyRejectIRNDetail_MatReturned",
				"Verify if Reject IRN details gets displayed in Material returned popup").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.rejectIRNDetailsValidate(74,"Internal Receipt");
			if(flag){
				Constant.log.info("Validate Reject IRN details displayed in Material returned popup test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Reject IRN details displayed in Material returned popup test case is successful");
			}else{
				System.err.println("Validate Reject IRN details displayed in Material returned popup test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test075_VerifyRejectIRNDetail_MatReturned")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject IRN Details in Material Returned pop up");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test076_VerifyIRNDetails_MaterialDeleted() throws Exception{
		log.startTestCase("IRN Details In Material Returned pop up after material delete");
		extentTest = extent.startTest("Test076_VerifyIRNDetails_MaterialDeleted",
				"Verify if IRN details gets displayed in Material returned popup after material delete").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.validateMaterialReturnedpopup_MatDelete(75,"Internal Receipt");
			if(flag){
				Constant.log.info("Validate IRN details displayed in Material returned popup after material delete test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN details displayed in Material returned popup after material delete test case is successful");
			}else{
				System.err.println("Validate IRN details displayed in Material returned popup after material delete test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test076_VerifyIRNDetails_MaterialDeleted")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("IRN Details In Material Returned pop up after material delete");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test077_MaterialReturnedPopup_SameMatDiffMake() throws Exception{
		log.startTestCase("Material returned popup validation with same material and different make");
		extentTest = extent.startTest("Test077_MaterialReturnedPopup_SameMatDiffMake",
				"Verify if Material returned popup with same material and different make").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.draftIRNDetailsValidate(76,"Internal Receipt");
			if(flag){
				Constant.log.info("Validate material returned popup with same material with different make test case is successful");
				extentTest.log(LogStatus.PASS, "Validate material returned popup with same material with different make test case is successful");
			}else{
				System.err.println("Validate material returned popup with same material with different make test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test077_MaterialReturnedPopup_SameMatDiffMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Material returned popup validation with same material and different make");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test078_MaterialReturnedPopup_WNWOFaulty() throws Exception{
		log.startTestCase("Material returned popup validation with N without faulty");
		extentTest = extent.startTest("Test078_MaterialReturnedPopup_WNWOFaulty",
				"Verify if Material returned popup with N without faulty").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.draftIRNDetailsValidate(77,"Internal Receipt");
			if(flag){
				Constant.log.info("Validate material returned popup with N without faulty test case is successful");
				extentTest.log(LogStatus.PASS, "Validate material returned popup with N without faulty test case is successful");
			}else{
				System.err.println("Validate material returned popup with N without faulty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test078_MaterialReturnedPopup_WNWOFaulty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Material returned popup validation with N without faulty");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test096_AddIRN_MatReceived() throws Exception{
		log.startTestCase("Add IRN with only Material Received");
		extentTest = extent.startTest("Test096_AddIRN_MatReceived",
				"Verify if add IRN with only material in material received tab").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(95,"Internal Receipt", null);
			if(flag){
				Constant.log.info("Validate IRN added with material in material received tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN added with material in material received tab test case is successful");
			}else{
				System.err.println("Validate IRN added with material in material received tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test096_AddIRN_MatReceived")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add IRN with only Material Received");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test097_AddIRN_MultiMatReceived() throws Exception{
		log.startTestCase("Add IRN with multiple material only Material Received");
		extentTest = extent.startTest("Test097_AddIRN_MultiMatReceived",
				"Verify if add IRN with multiple material in material received tab").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(96,"Internal Receipt", null);
			if(flag){
				Constant.log.info("Validate IRN added with multiple material in material received tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN added with multiple material in material received tab test case is successful");
			}else{
				System.err.println("Validate IRN added with multiple material in material received tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test097_AddIRN_MultiMatReceived")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add IRN with only multiple Material Received");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test098_AddIRN_SameMatDiffMakeMatReceived() throws Exception{
		log.startTestCase("Add IRN with same material different make only Material Received");
		extentTest = extent.startTest("Test098_AddIRN_SameMatDiffMakeMatReceived",
				"Verify if add IRN with same material different make material received tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(97,"Internal Receipt", null);
			if(flag){
				Constant.log.info("Validate IRN added with same material different make material received tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN added with same material different make material received tab test case is successful");
			}else{
				System.err.println("Validate IRN added with same material different make material received tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test098_AddIRN_SameMatDiffMakeMatReceived")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add IRN with same material different make only Material Received");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test099_AddIRN_SameMatWNWOFaulty() throws Exception{
		log.startTestCase("Add IRN with same material with and without faulty");
		extentTest = extent.startTest("Test099_AddIRN_SameMatWNWOFaulty",
				"Verify if add IRN with same material with N without faulty material received tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(98,"Internal Receipt", null);
			if(flag){
				Constant.log.info("Validate IRN added with same material with N without faulty material received tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN added with same material with N without faulty material received tab test case is successful");
			}else{
				System.err.println("Validate IRN added with same material with N without faulty material received tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test099_AddIRN_SameMatWNWOFaulty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add IRN with same material with N without faulty only Material Received");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test100_AddMatToIssue_IRNAddedWOMatReturn() throws Exception{
		log.startTestCase("Add material to issue after IRN creation without material return");
		extentTest = extent.startTest("Test100_AddMatToIssue_IRNAddedWOMatReturn",
				"Verify if material added to issue after IRN creation without material return").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(99, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(99,"Internal Receipt", sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.updateIssue_AddMat(96,"Internal Receipt");//dont change rowno
			if(flag){
				Constant.log.info("Validate material added to issue after IRN creation without material return test case is successful");
				extentTest.log(LogStatus.PASS, "Validate material added to issue after IRN creation without material return test case is successful");
			}else{
				System.err.println("Validate material added to issue after IRN creation without material return test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test100_AddMatToIssue_IRNAddedWOMatReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add material to issue after IRN creation without material return");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test101_AddIRN_MatInRecNReturn() throws Exception{
		log.startTestCase("Add IRN with material in received and returned tab");
		extentTest = extent.startTest("Test101_AddIRN_MatInRecNReturn",
				"Verify if add IRN with material in received and returned tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(100,"Internal Receipt", null);
			if(flag){
				Constant.log.info("Validate IRN added with material in received and returned tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN added with material in received and returned tab test case is successful");
			}else{
				System.err.println("Validate IRN added with material in received and returned tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test101_AddIRN_MatInRecNReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add IRN with material in received and returned tab");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test102_AddIRN_MatInRecNReturnWithMultIssue() throws Exception{
		log.startTestCase("Add IRN with material in received and returned tab With Multiple Issue");
		extentTest = extent.startTest("Test102_AddIRN_MatInRecNReturnWithMultIssue",
				"Verify if add IRN with material in received and returned tab With Multiple Issue").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(101,"Internal Receipt", null);
			if(flag){
				Constant.log.info("Validate IRN added with material in received and returned tab With Multiple Issue test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN added with material in received and returned tab With Multiple Issue test case is successful");
			}else{
				System.err.println("Validate IRN added with material in received and returned tab With Multiple Issue test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test102_AddIRN_MatInRecNReturnWithMultIssue")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add IRN with material in received and returned tab With Multiple Issue");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test103_ApproveIRN_MatInRecTab() throws Exception{
		log.startTestCase("Approve IRN with material in received tab");
		extentTest = extent.startTest("Test103_ApproveIRN_MatInRecTab",
				"Verify if IRN approved with material in received tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.approveGRN(102,"Internal Receipt", null);
			if(flag){
				Constant.log.info("Validate IRN approved with material in received tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN approved with material in received tab test case is successful");
			}else{
				System.err.println("Validate IRN approved with material in received tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test103_ApproveIRN_MatInRecTab")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve IRN with material in received tab");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test104_RejectDraftIRN_MatInRecTab() throws Exception{
		log.startTestCase("Reject draft IRN with material in received tab");
		extentTest = extent.startTest("Test103_Reject Test104_RejectDraftIRN_MatInRecTab",
				"Verify if IRN Reject draftd with material in received tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.validateDraftRejectGRN(103,"Internal Receipt");
			if(flag){
				Constant.log.info("Validate IRN Reject draftd with material in received tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN Reject draftd with material in received tab test case is successful");
			}else{
				System.err.println("Validate IRN Reject draftd with material in received tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test104_RejectDraftIRN_MatInRecTab")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject draft IRN with material in received tab");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test105_RejectapproveIRN_MatInRecTab() throws Exception{
		log.startTestCase("Reject approve IRN with material in received tab");
		extentTest = extent.startTest("Test103_Reject Test104_RejectapproveIRN_MatInRecTab",
				"Verify if IRN Reject approved with material in received tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.vaildateRejectApprovedGRN(104,"Internal Receipt", null);
			if(flag){
				Constant.log.info("Validate IRN Reject approved with material in received tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN Reject approved with material in received tab test case is successful");
			}else{
				System.err.println("Validate IRN Reject approved with material in received tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test104_RejectapproveIRN_MatInRecTab")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject approve IRN with material in received tab");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test106_ApproveIRN_MatInRecNReturnTab() throws Exception{
		log.startTestCase("Approve IRN with material in received N return tab");
		extentTest = extent.startTest("Test106_ApproveIRN_MatInRecNReturnTab",
				"Verify if IRN approved with material in received N return tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.approveGRN(105,"Internal Receipt", null);
			if(flag){
				Constant.log.info("Validate IRN approved with material in received N return tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN approved with material in received N return tab test case is successful");
			}else{
				System.err.println("Validate IRN approved with material in received N return tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test106_ApproveIRN_MatInRecNReturnTab")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve IRN with material in received N return tab");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test107_RejectDraftIRN_MatInRecNReturnTab() throws Exception{
		log.startTestCase("Reject draft IRN with material in received N return tab");
		extentTest = extent.startTest("Test107_RejectDraftIRN_MatInRecNReturnTab",
				"Verify if IRN Reject draftd with material in received N return tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.validateDraftRejectGRN(106,"Internal Receipt");
			if(flag){
				Constant.log.info("Validate IRN Reject draftd with material in received N return tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN Reject draftd with material in received N return tab test case is successful");
			}else{
				System.err.println("Validate IRN Reject draftd with material in received N return tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test107_RejectDraftIRN_MatInRecNReturnTab")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject draft IRN with material in received N return tab");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test108_RejectapproveIRN_MatInRecNReturnTab() throws Exception{
		log.startTestCase("Reject approve IRN with material in received N return tab");
		extentTest = extent.startTest("Test108_RejectapproveIRN_MatInRecNReturnTab",
				"Verify if IRN Reject approved with material in received N return tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.vaildateRejectApprovedGRN(107,"Internal Receipt", null);
			if(flag){
				Constant.log.info("Validate IRN Reject approved with material in received N return tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN Reject approved with material in received N return tab test case is successful");
			}else{
				System.err.println("Validate IRN Reject approved with material in received N return tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test108_RejectapproveIRN_MatInRecNReturnTab")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject approve IRN with material in received N return tab");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test109_VerifyStockMat_RecNReturn() throws Exception{
		log.startTestCase("Stock of material when IRN added with received and returned");
		extentTest = extent.startTest("Test109_VerifyStockMat_RecNReturn",
				"Verify if Stock of material when IRN added with received and returned").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			String sStock = master.fetchStock(108,"Internal Receipt");
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(108, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(108,"Internal Receipt", sIssueNo);
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			boolean flag = master.validateStockWOMake(108,"Internal Receipt", sStock);
			if(flag){
				Constant.log.info("Validate Stock of material when IRN added with received and returned test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Stock of material when IRN added with received and returned test case is successful");
			}else{
				System.err.println("Validate Stock of material when IRN added with received and returned test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test109_VerifyStockMat_RecNReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Stock of material when IRN added with received and returned");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test110_updateIRN_addMatInRec() throws Exception{
		log.startTestCase("update IRN by adding material in received tab");
		extentTest = extent.startTest("Test110_updateIRN_MatInRec",
				"Verify if update IRN by adding material in received tab").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(104,"Internal Receipt", null);//dont change row no
			boolean flag = store.validateGRNUpdate(109,"Internal Receipt", null);
			if(flag){
				Constant.log.info("Validate IRN updateed by adding  material in received tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN updateed by adding  material in received tab test case is successful");
			}else{
				System.err.println("Validate IRN updateed by adding  material in received tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test110_updateIRN_MatInRec")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("update IRN by adding  material in received tab");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test111_updateIRNQty_MatInRecNReturn() throws Exception{
		log.startTestCase("update IRN QTY in received tab");
		extentTest = extent.startTest("Test111_updateIRNQty_MatInRecNReturn",
				"Verify if update IRN Qtyin received tab").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(110,"Internal Receipt", null);
			boolean flag = store.updateQty_OnlyReceived(110,"Internal Receipt");
			if(flag){
				Constant.log.info("Validate IRN updateed Qtyin received tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN updateed Qtyin received tab test case is successful");
			}else{
				System.err.println("Validate IRN updateed Qtyin received tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test111_updateIRNQty_MatInRecNReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("update IRN Qtyin received tab");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test112_updateIRN_DeleteMatReceived() throws Exception{
		log.startTestCase("update IRN by deleting material in received tab");
		extentTest = extent.startTest("Test112_updateIRN_DeleteMatReceived",
				"Verify if update IRN by deleting material in received tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(111,"Internal Receipt", null);
			boolean flag = store.updateDeleteReceived(75,"Internal Receipt");//dont change row no
			if(flag){
				Constant.log.info("Validate IRN updateed by deleting material in received tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN updateed by deleting material in received tab test case is successful");
			}else{
				System.err.println("Validate IRN updateed by deleting material in received tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test112_updateIRN_DeleteMatReceived")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("update IRN by deleting material in received tab");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test113_updateIRN_AddExistMat() throws Exception{
		log.startTestCase("update IRN by adding existing material in received tab");
		extentTest = extent.startTest("Test113_updateIRN_AddExistMat",
				"Verify if update IRN by adding existing material in received tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.updateGRN(112,"Internal Receipt", null);
			if(flag){
				Constant.log.info("Validate IRN updateed by adding existing material in received tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN updateed by adding existing material in received tab test case is successful");
			}else{
				System.err.println("Validate IRN updateed by adding existing material in received tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test113_updateIRN_AddExistMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("update IRN by adding existing material in received tab");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test114_updateIRNQty() throws Exception{
		log.startTestCase("update IRN by updating QTY in received and returned tabs");
		extentTest = extent.startTest("Test114_updateIRNQty",
				"Verify if update IRN by updating QTY in received and returned tabs").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(113, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(113,"Internal Receipt", sIssueNo);
			boolean flag = store.validateDraftUpdateQty(113,"Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Validate IRN updateed by updating QTY in received and returned tabs test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN updateed by updating QTY in received and returned tabs test case is successful");
			}else{
				System.err.println("Validate IRN updateed by updating QTY in received and returned tabs test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test114_updateIRNQty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("update IRN by updating QTY in received and returned tabs");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test115_updateIRN_DeleteMatReceivedAddMatReturn() throws Exception{
		log.startTestCase("update IRN by deleting material in received tab and add material in return tab");
		extentTest = extent.startTest("Test115_updateIRN_DeleteMatReceivedAddMatReturn",
				"Verify if update IRN by deleting material in received tab and add material in return tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(114,"Internal Receipt", null);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(114, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.updateDeleteReceived_AddMat(74,"Internal Receipt", sIssueNo);//dont change row no
			if(flag){
				Constant.log.info("Validate IRN updateed by deleting material in received tab and add material in return tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN updateed by deleting material in received tab and add material in return tab test case is successful");
			}else{
				System.err.println("Validate IRN updateed by deleting material in received tab and add material in return tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test115_updateIRN_DeleteMatReceivedAddMatReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("update IRN by deleting material in received tab and add material in return tab");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test116_updateIRN_AddMatReceivedNReturned() throws Exception{
		log.startTestCase("update IRN by adding material in received and returned");
		extentTest = extent.startTest("Test116_updateIRN_AddMatReceivedNReturned",
				"Verify if update IRN by adding material in received and returned").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(114, "Internal Receipt");//dont change row no
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(114,"Internal Receipt", sIssueNo);//dont change row no
			boolean flag = store.validateGRNUpdate(115,"Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Validate IRN updateed by adding material in received and returned test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN updateed by adding material in received and returned test case is successful");
			}else{
				System.err.println("Validate IRN updateed by adding material in received and returned test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test116_updateIRN_AddMatReceivedNReturned")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("update IRN by adding material in received and returned");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test117_updateIRNQty_ReceivedNReturned() throws Exception{
		log.startTestCase("update IRN by updating qty in received and returned");
		extentTest = extent.startTest("Test117_updateIRNQty_ReceivedNReturned",
				"Verify if update IRN by updating qty in received and returned").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(115, "Internal Receipt");//dont change row no
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(115,"Internal Receipt", sIssueNo);//dont change row no
			boolean flag = store.validateDraftUpdateQty(116,"Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Validate IRN updateed by updating qty in received and returned test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN updateed by updating qty in received and returned test case is successful");
			}else{
				System.err.println("Validate IRN updateed by updating qty in received and returned test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test117_updateIRNQty_ReceivedNReturned")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("update IRN by updating qty in received and returned");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test123_AmendIRAddMaterial() throws Exception{
		log.startTestCase("Amend IR by adding material");
		extentTest = extent.startTest("Test123_AmendIRAddMaterial",
				"Verify if IR can be amended by adding material").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.amendIR_AddingMat(122,"Internal Receipt");
			if(flag){
				Constant.log.info("Verify if IR can be amended by adding material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if IR can be amended by adding material test case is successful");
			}else{
				System.err.println("Verify if IR can be amended by adding material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test123_AmendIRAddMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend IR by adding material");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test124_AmendIRUpdateQty() throws Exception{
		log.startTestCase("Amend IR by updating qty");
		extentTest = extent.startTest("Test124_AmendIRUpdateQty",
				"Verify if IR can be amended by updating qty").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(123, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.approveGRN(123,"Internal Receipt", sIssueNo);
			boolean flag = store.validateAmendQty(123,"Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Verify if IR can be amended by updating qty test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if IR can be amended by updating qty test case is successful");
			}else{
				System.err.println("Verify if IR can be amended by updating qty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test124_AmendIRUpdateQty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend IR by updating qty");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test125_AmendIR_DeleteMatRecNRet() throws Exception{
		log.startTestCase("Amend IR by deleting material received and returned");
		extentTest = extent.startTest("Test125_AmendIR_DeleteMatRecNRet",
				"Verify if IR can be amended by deleting material received and returned").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(124, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.approveGRN(124,"Internal Receipt", sIssueNo);
			boolean flag = store.validateAmendDeleteMat(124,"Internal Receipt", sIssueNo);
			if(flag){
				Constant.log.info("Verify if IR can be amended by deleting material received and returned test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if IR can be amended by deleting material received and returned test case is successful");
			}else{
				System.err.println("Verify if IR can be amended by deleting material received and returned test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test125_AmendIR_DeleteMatRecNRet")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend IR by deleting material received and returned");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test126_WarningPopupApproved_DeleteMat() throws Exception{
		log.startTestCase("Validate warning popup after deleting material for approved IRN");
		extentTest = extent.startTest("Test126_WarningPopupApproved_DeleteMat",
				"Verify if warning popup is displayed when material for approved IRN deleted and IRN updated").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.warningpoup_AllMatDelete(125,"Internal Receipt");
			if(flag){
				Constant.log.info("Verify if warning popup is displayed when material for approved IRN deleted and IRN updated is successful");
				extentTest.log(LogStatus.PASS, "Verify if warning popup is displayed when material for approved IRN deleted and IRN updated is successful");
			}else{
				System.err.println("Verify if warning popup is displayed when material for approved IRN deleted and IRN updated failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test126_WarningPopupApproved_DeleteMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Validate warning popup after deleting material for approved IRN");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test127_AmendIRN_DeleteMatReceivedAddMatReturn() throws Exception{
		log.startTestCase("Amend IRN by deleting material in received tab and add material in return tab");
		extentTest = extent.startTest("Test127_AmendIRN_DeleteMatReceivedAddMatReturn",
				"Verify if Amend IRN by deleting material in received tab and add material in return tab").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.approveGRN(126,"Internal Receipt", null);
			boolean flag = store.amendDeleteMatRecNAddMatReturn(75,"Internal Receipt");//dont change row no
			if(flag){
				Constant.log.info("Validate IRN Amended by deleting material in received tab and add material in return tab test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN Amended by deleting material in received tab and add material in return tab test case is successful");
			}else{
				System.err.println("Validate IRN Amended by deleting material in received tab and add material in return tab test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test127_AmendIRN_DeleteMatReceivedAddMatReturn")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Amend IRN by deleting material in received tab and add material in return tab");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test128_EditIssueNoNVerifyIRN() throws Exception{
		log.startTestCase("Edit issue no and verify IRN");
		extentTest = extent.startTest("Test128_EditIssueNoNVerifyIRN",
				"Verify if IRN is updated when Issue no edited").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(127, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(127,"Internal Receipt", sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.superEditIssueNoNVerify(sIssueNo);
			if(flag){
				Constant.log.info("Validate IRN is updated when Issue no edited test case is successful");
				extentTest.log(LogStatus.PASS, "Validate IRN is updated when Issue no edited test case is successful");
			}else{
				System.err.println("Validate IRN is updated when Issue no edited test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test128_EditIssueNoNVerifyIRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Edit issue no and verify IRN");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test129_WarningReduceQty_ApprovedIRN() throws Exception{
		log.startTestCase("Verify warning popup displayed when qty reduced below returned qty for approved IRN ");
		extentTest = extent.startTest("Test129_WarningReduceQty_ApprovedIRN",
				"Verify warning popup displayed when qty reduced below returned qty for approved IRN").assignCategory("IRTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(128, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.approveGRN(128, "Internal Receipt",sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.WarningPopUp_MatQty();
			if(flag){
				Constant.log.info("Verify warning popup displayed when qty reduced below returned qty for approved IRN test case is successful");
				extentTest.log(LogStatus.PASS, "Verify warning popup displayed when qty reduced below returned qty for approved IRN test case is successful");
			}else{
				System.err.println("Warning not displayed when material deleted after IRN creation");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test129_WarningReduceQty_ApprovedIRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify warning popup displayed when qty reduced below returned qty for approved IRN");
	}

//	@Test  @Category(MediumPriorityTestCases.class)
//	public void Test130_WarningReduceQty_ApprovedIRN() throws Exception{
//		log.startTestCase("Verify warning popup displayed when qty reduced below returned qty for approved IRN ");
//		extentTest = extent.startTest("Test129_WarningReduceQty_ApprovedIRN",
//				"Verify warning popup displayed when qty reduced below returned qty for approved IRN").assignCategory("IRTestCases","MediumPriorityTestCases");
//		try{
//			navigate.navigateToStore();
//			Thread.sleep(Constant.Min_Sleep);
//			navigate.navigateToIssue();
//			store.addIssue(128, "Internal Receipt");
//			String sIssueNo = store.getIssueNo();
//			navigate.navigateToStore();
//			Thread.sleep(Constant.Min_Sleep);
//			navigate.navigateToIssueReturn();
//			store.approveGRN(128, "Internal Receipt",sIssueNo);
//			navigate.navigateToStore();
//			Thread.sleep(Constant.Min_Sleep);
//			navigate.navigateToIssue();
//			boolean flag = store.WarningPopUp_MatQty();
//			if(flag == true){
//				Constant.log.info("Verify warning popup displayed when qty reduced below returned qty for approved IRN test case is successful");
//				extentTest.log(LogStatus.PASS, "Verify warning popup displayed when qty reduced below returned qty for approved IRN test case is successful");
//			}else{
//				System.err.println("Warning not displayed when material deleted after IRN creation");
//				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test129_WarningReduceQty_ApprovedIRN")));
//			}
//			Assert.assertTrue(flag == true);
//		}catch(Exception e){
//			System.err.println(e);
//			}
//		log.endTestCase("Verify warning popup displayed when qty reduced below returned qty for approved IRN");
//	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test131_MSLWarn_ReturnPositive() throws Exception{
		log.startTestCase("MSL warning in material returned tab for positive MSL");
		extentTest = extent.startTest("Test131_MSLWarn_ReturnPositive",
				"Verify MSL warning in material returned tab for positive MSL").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(130, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(129, "Internal Receipt",sIssueNo);
			boolean flag = store.validateMSLWarning_MatReturn(130, "Internal Receipt");
			if(flag){
				Constant.log.info("Verify MSL warning in material returned tab for positive MSL test case is successful");
				extentTest.log(LogStatus.PASS, "Verify MSL warning in material returned tab for positive MSL test case is successful");
			}else{
				System.err.println("MSL warning in material returned tab for positive MSL test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test131_MSLWarn_ReturnPositive")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("MSL warning in material returned tab for positive MSL");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test133_MSLWarn_ReturnNegative() throws Exception{
		log.startTestCase("MSL warning in material returned tab for Negative MSL");
		extentTest = extent.startTest("Test133_MSLWarn_ReturnNegative",
				"Verify MSL warning in material returned tab for Negative MSL").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(132, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(129, "Internal Receipt",sIssueNo);
			boolean flag = store.validateMSLWarning_MatReturn(131, "Internal Receipt");
			if(flag){
				Constant.log.info("Verify MSL warning in material returned tab for Negative MSL test case is successful");
				extentTest.log(LogStatus.PASS, "Verify MSL warning in material returned tab for Negative MSL test case is successful");
			}else{
				System.err.println("MSL warning in material returned tab for Negative MSL test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test133_MSLWarn_ReturnNegative")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("MSL warning in material returned tab for Negative MSL");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test134_MSLWarn_NoMSLReceivedTab() throws Exception{
		log.startTestCase("MSL warning in material received tab for NO MSL");
		extentTest = extent.startTest("Test134_MSLWarn_NoMSLReceivedTab",
				"Verify MSL warning in material received tab for NO MSL").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(133, "Internal Receipt", null);
			boolean flag = store.validateMSLWarning_MatReceived(133, "Internal Receipt");
			if(flag){
				Constant.log.info("Verify MSL warning in material received tab for NO MSL test case is successful");
				extentTest.log(LogStatus.PASS, "Verify MSL warning in material received tab for NO MSL test case is successful");
			}else{
				System.err.println("MSL warning in material received tab for NO MSL test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test134_MSLWarn_NoMSLReceivedTab")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("MSL warning in material received tab for NO MSL");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test135_MSLWarn_WMakeReceivedTab() throws Exception{
		log.startTestCase("MSL warning in material received tab with make");
		extentTest = extent.startTest("Test135_MSLWarn_WMakeReceivedTab",
				"Verify MSL warning in material received tab with make").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(134, "Internal Receipt", null);
			boolean flag = store.validateMSLWarning_MatReceived(134, "Internal Receipt");
			if(flag){
				Constant.log.info("Verify MSL warning in material received tab with make test case is successful");
				extentTest.log(LogStatus.PASS, "Verify MSL warning in material received tab with make test case is successful");
			}else{
				System.err.println("MSL warning in material received tab with make test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test135_MSLWarn_WMakeReceivedTab")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("MSL warning in material received tab with make");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test136_MSLWarnReturnedTab_NoMSL() throws Exception{
		log.startTestCase("MSL warning in material returned tab for NO MSL");
		extentTest = extent.startTest("Test136_MSLWarnReturnedTab_NoMSL",
				"Verify MSL warning in material returned tab for NO MSL").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(135, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(129, "Internal Receipt",sIssueNo);
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(135, "Internal Receipt");
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.validateMSLWarning_MatReturn(135, "Internal Receipt");
			if(flag){
				Constant.log.info("Verify MSL warning in material returned tab for NO MSL test case is successful");
				extentTest.log(LogStatus.PASS, "Verify MSL warning in material returned tab for NO MSL test case is successful");
			}else{
				System.err.println("MSL warning in material returned tab for NO MSL test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test136_MSLWarnReturnedTab_NoMSL")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("MSL warning in material returned tab for NO MSL");
	}

	@Test  @Category(MediumPriorityTestCases.class)
	public void Test137_MSLWarnReturnedTab_MultMat() throws Exception{
		log.startTestCase("MSL warning in material returned tab for multiple material");
		extentTest = extent.startTest("Test137_MSLWarnReturnedTab_MultMat",
				"Verify MSL warning in material returned tab for multiple material").assignCategory("IRTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			store.addIssue(136, "Internal Receipt");
			String sIssueNo = store.getIssueNo();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			store.addGRN(116, "Internal Receipt",sIssueNo);
			boolean flag = store.validateMSLWarning_MatReturn(136, "Internal Receipt");
			if(flag){
				Constant.log.info("Verify MSL warning in material returned tab for multiple material test case is successful");
				extentTest.log(LogStatus.PASS, "Verify MSL warning in material returned tab for multiple material test case is successful");
			}else{
				System.err.println("MSL warning in material returned tab for multiple material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test137_MSLWarnReturnedTab_MultMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("MSL warning in material returned tab for multiple material");
	}

	@Test  @Category(SanityTests.class)
	public void Test133_UpdateIssueGRN() throws Exception{
		log.startTestCase("Update Issue GRN");
		extentTest = extent.startTest("Test133_UpdateIssueGRN",
				"Verify if Issue GRN is Updated").assignCategory("IRTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.updateGRN(132, "Sanity Test", null);
			if(flag){
				Constant.log.info("Issue GRN Update is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN Update is successful");
			}else{
				System.err.println("Issue GRN Update failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test133_UpdateIssueGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Issue GRN");
	}

	@Test  @Category(SanityTests.class)
	public void Test258_AddIssueGRNWithNonStock() throws Exception{
		log.startTestCase("Add Issue GRN with Non Stock");
		extentTest = extent.startTest("Test258_AddIssueGRNWithNonStock",
				"Verify if Issue GRN is added with Non Stock").assignCategory("IRTestCases","SanityTests");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			boolean flag = store.addGRN(257, "Sanity Test",null);
			if(flag){
				Constant.log.info("Issue GRN addition with Non Stock is successful");
				extentTest.log(LogStatus.PASS, "Issue GRN addition with single Non Stock is successful");
			}else{
				System.err.println("Issue GRN addition with Non Stock failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test258_AddIssueGRNWithNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue GRN with Non Stock");
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
