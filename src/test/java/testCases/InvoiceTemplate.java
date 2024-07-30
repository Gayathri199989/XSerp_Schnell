package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import category.SanityTests;
import pages.LoginPage;
import pages.SettingPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

public class InvoiceTemplate {

	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
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
		Constant.logFile("Accounts Report");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Test  @Category(SanityTests.class)
	public void Test295_SaveTemplateNoChange() throws Exception{
		log.startTestCase("Save Template without Change");
		extentTest = extent.startTest("Test295_SaveTemplateNoChange",
				"Verify invoice template saved without change").assignCategory("InvoiceTemplate","SanityTests");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoiceTemplate();
			boolean flag = setting.invoiceTemplateSave();
			if(flag){
				Constant.log.info("Verify invoice template saved without change test case is successful");
				extentTest.log(LogStatus.PASS, "Verify invoice template saved without change test case is successful");
			}else{
				System.err.println("Save Template without Change test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test295_SaveTemplateNoChange")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Save Template without Change");
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
