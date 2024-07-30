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

import category.SanityTests;
import pages.LoginPage;
import pages.SalesPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalesReportTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
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
		Constant.logFile("Sales report");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Category(SanityTests.class)
	@Test
	public void Test044_StatusReportColumnValidation() throws Exception{
		log.startTestCase("Status Report Column Verify");
		extentTest = extent.startTest("Test044_StatusReportColumnValidation",
				"Verify Status Report column").assignCategory("SalesReportTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToStatusReport();
			boolean flag = sales.statusReportColumnValidation(43,"Sanity Test");
			if(flag){
				Constant.log.info("Status Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Status Report column validation test case is successful");
			}else{
				System.err.println("Status Report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test044_StatusReportColumnValidation")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Status Report Column Verify");
	}

	@Test  @Category(SanityTests.class)
	public void Test045_TaxReportColumnValidation() throws Exception{
		log.startTestCase("Tax Report Column Verify");
		extentTest = extent.startTest("Test045_TaxReportColumnValidation",
				"Verify Tax Report column").assignCategory("SalesReportTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToTaxReport();
			boolean flag = sales.taxReportColumnValidation(44,"Sanity Test");
			if(flag){
				Constant.log.info("Tax Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Tax Report column validation test case is successful");
			}else{
				System.err.println("Tax Report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test045_TaxReportColumnValidation")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Tax Report Column Verify");
	}

	@Test  @Category(SanityTests.class)
	public void Test046_MaterialReportColumnValidation() throws Exception{
		log.startTestCase("Material Report Column Verify");
		extentTest = extent.startTest("Test046_MaterialReportColumnValidation",
				"Verify Material Report column").assignCategory("SalesReportTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterialReport();
			boolean flag = sales.materialReportColumnValidation(45,"Sanity Test");
			if(flag){
				Constant.log.info("Material Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Material Report column validation test case is successful");
			}else{
				System.err.println("Material Report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test046_MaterialReportColumnValidation")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Material Report Column Verify");
	}

	@Test  @Category(SanityTests.class)
	public void Test047_SalesReportColumnValidationWithDraft() throws Exception{
		log.startTestCase("Sales Report Column Verify with draft");
		extentTest = extent.startTest("Test047_SalesReportColumnValidationWithDraft",
				"Verify Sales Report column with draft").assignCategory("SalesReportTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReport();
			boolean flag = sales.salesReportColumnValidationWithDraft(46,"Sanity Test");
			if(flag){
				Constant.log.info("Sales Report column validation with draft test case is successful");
				extentTest.log(LogStatus.PASS, "Sales Report column validation with draft test case is successful");
			}else{
				System.err.println("Sales Report column validation with draft test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test047_SalesReportColumnValidationWithDraft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales Report Column Verify");
	}

	@Test  @Category(SanityTests.class)
	public void Test048_SalesReportColumnValidationWithoutDraft() throws Exception{
		log.startTestCase("Sales Report Column Verify without draft ");
		extentTest = extent.startTest("Test048_SalesReportColumnValidationWithoutDraft",
				"Verify Sales Report column without draft").assignCategory("SalesReportTestCases","SanityTests");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReport();
			boolean flag = sales.salesReportColumnValidationWithoutDraft(47,"Sanity Test");
			if(flag){
				Constant.log.info("Sales Report column validation without draft test case is successful");
				extentTest.log(LogStatus.PASS, "Sales Report column validation without draft test case is successful");
			}else{
				System.err.println("Sales Report column validation without draft test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test048_SalesReportColumnValidationWithoutDraft")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Sales Report Column Verify without draft");
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
