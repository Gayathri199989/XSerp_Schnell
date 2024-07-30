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
import category.SmokeTest;
import pages.HRPage;
import pages.LoginPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PayStructTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	HRPage hr = PageFactory.initElements(Constant.driver, HRPage.class);
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
		Constant.logFile("Pay structure");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Category(SmokeTest.class)
	@Test
	public void Test078_AddPayStruc() throws Exception{
		log.startTestCase("Add Pay Structure");
		extentTest = extent.startTest("Test078_AddPayStruc",
				"validate Pay Struc addition").assignCategory("PayStructTestCases","SmokeTest");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPayStructure();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.addPayStructure();
			if(flag){
				Constant.log.info("Pay structure addition test case is successful");
				extentTest.log(LogStatus.PASS, "Pay structure addition test case is successful");
			}else{
				System.err.println("Pay structure addition test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test078_AddPayStruc")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Pay structure");
	}

	@Test  @Category(SanityTests.class)
	public void Test079_UpdatePayStruc() throws Exception{
		log.startTestCase("Update Pay Structure");
		extentTest = extent.startTest("Test079_UpdatePayStruc",
				"validate Pay Structure update").assignCategory("PayStructTestCases","SanityTests");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPayStructure();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.updatePayStructure();
			if(flag){
				Constant.log.info("Pay Structure Update test case is successful");
				extentTest.log(LogStatus.PASS, "Pay Structure Update test case is successful");
			}else{
				System.err.println("Pay Structure Update test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test079_UpdatePayStruc")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Pay Structure");
	}

	@Test  @Category(SanityTests.class)
	public void Test080_DeletePayStruc() throws Exception{
		log.startTestCase("Delete Pay Structure");
		extentTest = extent.startTest("Test080_DeletePayStruc",
				"validate Pay Struc delete").assignCategory("PayStructTestCases","SanityTests");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPayStructure();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.deletePayStructure();
			if(flag){
				Constant.log.info("Pay Structure Delete test case is successful");
				extentTest.log(LogStatus.PASS, "Pay Structure Delete test case is successful");
			}else{
				System.err.println("Pay Structure Delete test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test080_DeletePayStruc")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Delete Pay Structure");
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
