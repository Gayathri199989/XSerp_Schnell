package testCases;


import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import category.SmokeTest;
import pages.LoginPage;
import pages.SettingPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
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
		Constant.logFile("User");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}

	@Category(SmokeTest.class)
//	@Test
	public void Test053_AddUser() throws Exception{
		log.startTestCase("Add user");
		extentTest = extent.startTest("Test053_AddUser",
				"Verify if user is added").assignCategory("UserTestCases","SmokeTest");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToUser();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = setting.addUser();
			if(flag){
				Constant.log.info("User creation validation test case is successful");
				extentTest.log(LogStatus.PASS, "User creation validation test case is successful");
			}else{
				System.err.println("User creation validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test053_AddUser")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add user");
	}

	//@Test  @Category(SanityTests.class)
	public void Test054_UserStatusChange() throws Exception{
		log.startTestCase("User Status Change");
		extentTest = extent.startTest("Test054_UserStatusChange",
				"Verify user status change").assignCategory("UserTestCases","SanityTests");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToUser();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = setting.userStatusChange(53, "Sanity Test");
			if(flag){
				Constant.log.info("User Status Change validation test case is successful");
				extentTest.log(LogStatus.PASS, "User Status Change validation test case is successful");
			}else{
				System.err.println("User Status Change validation test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test054_UserStatusChange")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("User Status Change");
	}
	/*
	@Test  @Category(SanityTests.class)
	public void Test073_UserWithEditAccessOnly() throws Exception{
		log.startTestCase("User with Edit access only");
		extentTest = extent.startTest("User with Edit access only",
				"validate user with only edit access");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToUser();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = setting.userWithOnlyEditAccess(72, "Sanity Test");
			if(flag == true){
				Constant.log.info("User With only edit access validation test case is successful");
				extentTest.log(LogStatus.PASS, "User With only edit access validation test case is successful");
			}else{
				System.err.println("User With only edit access validation test case failed ");
				Constant.captureScreen_Negative("User with Edit access only");
				extentTest.log(LogStatus.FAIL, "User With only edit access validation test case failed ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("User with Edit access only");
	}

	@Test @Category(SanityTests.class)
	public void Test074_UserWithViewAccessOnly() throws Exception{
		log.startTestCase("User with View access only");
		extentTest = extent.startTest("User with View access only",
				"validate user with only View access");
		try{
			navigate.navigateToSettings();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToUser();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = setting.userWithOnlyViewAccess(73, "Sanity Test");
			if(flag == true){
				Constant.log.info("User With only View access validation test case is successful");
				extentTest.log(LogStatus.PASS, "User With only View access validation test case is successful");
			}else{
				System.err.println("User With only View access validation test case failed ");
				Constant.captureScreen_Negative("User with View access only");
				extentTest.log(LogStatus.FAIL, "User With only View access validation test case failed ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("User with View access only");
	}
	*/
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
