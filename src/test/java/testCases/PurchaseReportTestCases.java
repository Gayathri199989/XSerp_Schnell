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
import pages.PurchasePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PurchaseReportTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
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
		Constant.logFile("Purchase Report");
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
	public void Test049_POWiseReportColumnValidation() throws Exception{
		log.startTestCase("PO Wise Report Column Verify");
		extentTest = extent.startTest("Test049_POWiseReportColumnValidation",
				"Verify PO Wise Report column").assignCategory("PurchaseReportTestCases","SanityTests");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPOWiseReports();
			boolean flag = purchase.poWiseReportColumnValidation(48,"Sanity Test");
			if(flag){
				Constant.log.info("PO Wise Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "PO Wise Report column validation test case is successful");
			}else{
				System.err.println("PO Wise Report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test049_POWiseReportColumnValidation")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("PO Wise Report Column Verify");
	}

	@Test  @Category(SanityTests.class)
	public void Test050_MaterialWiseReportColumnValidation() throws Exception{
		log.startTestCase("Material Wise Report Column Verify");
		extentTest = extent.startTest("Test050_MaterialWiseReportColumnValidation",
				"Verify Material Wise Report column").assignCategory("PurchaseReportTestCases","SanityTests");
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterialWiseReports();
			boolean flag = purchase.materialWiseReportColumnValidation(49,"Sanity Test");
			if(flag){
				Constant.log.info("Material Wise Report column validation test case is successful");
				extentTest.log(LogStatus.PASS, "Material Wise Report column validation test case is successful");
			}else{
				System.err.println("Material Wise Report column validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test050_MaterialWiseReportColumnValidation")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Material Wise Report Column Verify");
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
