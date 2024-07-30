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
import pages.HRPage;
import pages.LoginPage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeTestCases {

	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	HRPage hr = PageFactory.initElements(Constant.driver, HRPage.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
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
		Constant.logFile("Employee");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
	}


	@Test  @Category(HighPriorityTestCases.class)
	public void Test031_AddEmployee_MandatoryFields() throws Exception{
		log.startTestCase("Add Employee with only mandatory fields");
		extentTest = extent.startTest("Test031_AddEmployee_MandatoryFields",
				"validate employee addition with only mandatory fields").assignCategory("EmployeeTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.addEmployee_MandatoryFields(30, "Employees");
			if(flag){
				Constant.log.info("Employee addition with only mandatory fields test case is successful");
				extentTest.log(LogStatus.PASS, "Employee addition with only mandatory fields test case is successful");
			}else{
				System.err.println("Employee addition with only mandatory fields test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test031_AddEmployee_MandatoryFields")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Employee with only mandatory fields");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test032_AddEmployee_PaystrucValues() throws Exception{
		log.startTestCase("Add Employee with only mandatory fields");
		extentTest = extent.startTest("Test032_AddEmployee_PaystrucValues",
				"validate employee addition with only mandatory fields").assignCategory("EmployeeTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.addEmployee_MandatoryFields(31, "Employees");
			if(flag){
				Constant.log.info("Employee addition with only mandatory fields test case is successful");
				extentTest.log(LogStatus.PASS, "Employee addition with only mandatory fields test case is successful");
			}else{
				System.err.println("Employee addition with only mandatory fields test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test032_AddEmployee_PaystrucValues")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Employee with only mandatory fields");
	}

	@Test 	@Category(SmokeTest.class)
	public void Test033_AddEmployee_AllFields() throws Exception{
		log.startTestCase("Add Employee with all fields");
		extentTest = extent.startTest("Test033_AddEmployee_AllFields",
				"validate employee addition with all fields").assignCategory("EmployeeTestCases","SmokeTest");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.addEmployee(32, "Employees");
			if(flag){
				Constant.log.info("Employee addition with all fields test case is successful");
				extentTest.log(LogStatus.PASS, "Employee addition with all fields test case is successful");
			}else{
				System.err.println("Employee addition with all fields test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test033_AddEmployee_AllFields")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Employee with all fields");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test037_AddEmployee_NewDept() throws Exception{
		log.startTestCase("Add Employee with new department");
		extentTest = extent.startTest("Test037_AddEmployee_NewDept",
				"validate employee addition with new department").assignCategory("EmployeeTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.addEmployee_MandatoryFields(36, "Employees");
			if(flag){
				Constant.log.info("Employee addition with new department test case is successful");
				extentTest.log(LogStatus.PASS, "Employee addition with new department test case is successful");
			}else{
				System.err.println("Employee addition with new department test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test037_AddEmployee_NewDept")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Employee with new department");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test038_AddEmployee_NewSubDept() throws Exception{
		log.startTestCase("Add Employee with new sub department");
		extentTest = extent.startTest("Test038_AddEmployee_NewSubDept",
				"validate employee addition with new sub department").assignCategory("EmployeeTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.addEmployee_MandatoryFields(37, "Employees");
			if(flag){
				Constant.log.info("Employee addition with new sub department test case is successful");
				extentTest.log(LogStatus.PASS, "Employee addition with new sub department test case is successful");
			}else{
				System.err.println("Employee addition with new sub department test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test038_AddEmployee_NewSubDept")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Employee with new sub department");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test039_AddEmployee_FutureJoinDate() throws Exception{
		log.startTestCase("Add Employee with future join date");
		extentTest = extent.startTest("Test039_AddEmployee_FutureJoinDate",
				"validate employee addition with future join date").assignCategory("EmployeeTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.addEmployee(38, "Employees");
			if(flag){
				Constant.log.info("Employee addition with future join date test case is successful");
				extentTest.log(LogStatus.PASS, "Employee addition with future join date test case is successful");
			}else{
				System.err.println("Employee addition with future join date test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test039_AddEmployee_FutureJoinDate")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Employee with future join date");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test040_AddEmployee_IFSCCode() throws Exception{
		log.startTestCase("Add Employee with IFSC code");
		extentTest = extent.startTest("Test040_AddEmployee_IFSCCode",
				"validate employee addition with IFSC code").assignCategory("EmployeeTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.addEmployee(38, "Employees");
			if(flag){
				Constant.log.info("Employee addition with IFSC code test case is successful");
				extentTest.log(LogStatus.PASS, "Employee addition with IFSC code test case is successful");
			}else{
				System.err.println("Employee addition with IFSC code test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test040_AddEmployee_IFSCCode")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Employee with IFSC code");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test043_UpdateEmployee_General() throws Exception{
		log.startTestCase("Update Employee General section");
		extentTest = extent.startTest("Test043_UpdateEmployee_General",
				"validate employee Update General section").assignCategory("EmployeeTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.updateEmployee_General(42, "Employees");
			if(flag){
				Constant.log.info("Employee Update General section test case is successful");
				extentTest.log(LogStatus.PASS, "Employee Update General section test case is successful");
			}else{
				System.err.println("Employee Update General section test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test043_AddEmployee_IFSCCode")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Employee General section");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test044_UpdateEmployee_Work() throws Exception{
		log.startTestCase("Update Employee Work section");
		extentTest = extent.startTest("Test044_UpdateEmployee_Work",
				"validate employee Update Work section").assignCategory("EmployeeTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.updateEmployee_Work(43, "Employees");
			if(flag){
				Constant.log.info("Employee Update Work section test case is successful");
				extentTest.log(LogStatus.PASS, "Employee Update Work section test case is successful");
			}else{
				System.err.println("Employee Update Work section test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test043_AddEmployee_IFSCCode")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Employee Work section");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test045_UpdateEmployee_PersonalDetails() throws Exception{
		log.startTestCase("Update Employee PersonalDetails section");
		extentTest = extent.startTest("Test045_UpdateEmployee_PersonalDetails",
				"validate employee Update PersonalDetails section").assignCategory("EmployeeTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.updateEmployee_PersonalDetails(44, "Employees");
			if(flag){
				Constant.log.info("Employee Update PersonalDetails section test case is successful");
				extentTest.log(LogStatus.PASS, "Employee Update PersonalDetails section test case is successful");
			}else{
				System.err.println("Employee Update PersonalDetails section test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test045_UpdateEmployee_PersonalDetails")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Employee PersonalDetails section");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test046_UpdateEmployee_BankDetails() throws Exception{
		log.startTestCase("Update Employee BankDetails section");
		extentTest = extent.startTest("Test046_UpdateEmployee_BankDetails",
				"validate employee Update BankDetails section").assignCategory("EmployeeTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.updateEmployee_BankDetails(45, "Employees");
			if(flag){
				Constant.log.info("Employee Update BankDetails section test case is successful");
				extentTest.log(LogStatus.PASS, "Employee Update BankDetails section test case is successful");
			}else{
				System.err.println("Employee Update BankDetails section test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test045_UpdateEmployee_PersonalDetails")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Employee BankDetails section");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test047_UpdateEmployee_PayStruc() throws Exception{
		log.startTestCase("Update Employee PayStruc section");
		extentTest = extent.startTest("Test047_UpdateEmployee_PayStruc",
				"validate employee Update PayStruc section").assignCategory("EmployeeTestCases","HighPriorityTestCases");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.updateEmployee_PayStruc(46, "Employees");
			if(flag){
				Constant.log.info("Employee Update PayStruc section test case is successful");
				extentTest.log(LogStatus.PASS, "Employee Update PayStruc section test case is successful");
			}else{
				System.err.println("Employee Update PayStruc section test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test047_UpdateEmployee_PayStruc")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Employee PayStruc section");
	}

	@Test  @Category(SanityTests.class)
	public void Test077_UpdateEmployee() throws Exception{
		log.startTestCase("Update Employee");
		extentTest = extent.startTest("Test077_UpdateEmployee",
				"validate employee Update").assignCategory("EmployeeTestCases","SanityTests");
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag = hr.updateEmployee(76, "Sanity Test");
			if(flag){
				Constant.log.info("Employee Update test case is successful");
				extentTest.log(LogStatus.PASS, "Employee Update test case is successful");
			}else{
				System.err.println("Employee Update test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test077_UpdateEmployee")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update Employee");
	}

	/*
	@Test
	public void test003_SearchEmployee() throws Exception{
		log.startTestCase("Search Employee");
		login.login();
		try{
			boolean flag = hr.searchEmployee(2,"Employees");
			if(flag == true){
				Constant.log.info("Employees search test case is successful");
			}else{
				System.err.println("Employees search test case failed ");
				Constant.captureScreen_Negative("SearchEmployee");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Search Employee");
	}

	@Test
	public void test006_CancelEmployee() throws Exception{
		log.startTestCase("Cancel Employee");
		login.login();
		try{
			boolean flag = hr.cancel_Employee(4);
			if(flag == true){
				Constant.log.info("Employees Cancel test case is successful");
			}else{
				System.err.println("Employees Cancel test case failed ");
				Constant.captureScreen_Negative("CancelEmployee");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Cancel Employee");
	}

	@Test
	public void test007_MandatoryFields() throws Exception{
		log.startTestCase("Mandatory Fields");
		login.login();
		try{
			boolean flag = hr.mandatoryFields_Emp(5);
			if(flag == true){
				Constant.log.info("Verification of Mandatory Fields test case is successful");
			}else{
				System.err.println("Verification of Mandatory Fields test case failed ");
				Constant.captureScreen_Negative("MandatoryFields");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		log.endTestCase("Mandatory Fields");
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
