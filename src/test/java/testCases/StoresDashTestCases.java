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
import pages.LoginPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoresDashTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);

	static ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	static String extentReportFile;
	static ExtentReports extent;
	static ExtentTest extentTest;


	@BeforeClass
	public static void BeforeClass() throws Exception{
		extentReportFile = property.getExtentReportFile()+"ExtentReport"+Constant.date+"."+"html";
		// Create object of extent report and specify the report file path.
		extent = new ExtentReports(extentReportFile, false);
		Constant.logFile("Store Dashboard");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}


	@Test  	@Category(SanityTests.class)
	public void Test001_SearchStoreDashboard() throws Exception{
		log.startTestCase("SearchStoreDashboard");
		extentTest = extent.startTest("Test001_SearchStoreDashboard",
				"Verify Account dashboard ").assignCategory("StoresDashTestCases","SanityTests");
		try{
			boolean flag = store.searchStore();
			if(flag){
				Constant.log.info("Searching Store Dashboard is successful");
				extentTest.log(LogStatus.PASS, "Searching Store Dashboard is successful");
			}else{
				System.err.println("Searching Store Dashboard test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test001_SearchStoreDashboard")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println("Searching Store Dashboard failed "+e);
				Constant.captureScreen_Negative("SearchStoreDashboard");
			}
		log.endTestCase("SearchStoreDashboard");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test002_StoreIndentRaised() throws Exception{
		extentTest = extent.startTest("Test002_StoreIndentRaised",
				"Verify Account dashboard ").assignCategory("StoresDashTestCases","HighPriorityTestCases");
		log.startTestCase("StoreIndentRaised");
		try{
			boolean flag = store.raisedIndent();
			if(flag){
				Constant.log.info("Raised Indent when clicked navigates to Indent successfully");
				extentTest.log(LogStatus.PASS, "Raised Indent when clicked navigates to Indent successfully");
			}else{
				System.err.println("Raised Indent when clicked navigates to Indent test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test002_StoreIndentRaised")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println("Raise Indent value navigate to Indent is not successfull "+e);
				Constant.captureScreen_Negative("StoreIndentRaised");
			}
		log.endTestCase("StoreIndentRaised");
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
