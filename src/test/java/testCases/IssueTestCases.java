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
import pages.LoginPage;
import pages.ProfilePage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IssueTestCases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
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
		Constant.logFile("Issue");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
		navigate.navigateToStore();
		Thread.sleep(Constant.Min_Sleep);
		navigate.navigateToIssue();
	}

	@Test   	@Category(MediumPriorityTestCases.class)
	public void Test010_MandatoryFieldsCheck() throws Exception{
		log.startTestCase("Mandatory Fields check");
		extentTest = extent.startTest("Test010_MandatoryFieldsCheck",
				"Verify if mandatory fields warning msgs displayed").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.mandatoryFieldCheck_Issue(9,"Issue");
			if(flag){
				Constant.log.info("Mandatory error messages are displayed");
				extentTest.log(LogStatus.PASS, "Mandatory error messages are displayed");
			}else{
				System.err.println("Mandatory error messages are not displayed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test010_MandatoryFieldsCheck")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Mandatory Fields check");
	}

	@Test   	@Category(MediumPriorityTestCases.class)
	public void Test012_AvailStockSingleMake() throws Exception{
		log.startTestCase("stock check for single make");
		extentTest = extent.startTest("Test012_AvailStockSingleMake",
				"Verify stock of material with single make").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			String sStock = master.fetchStock(11,"Issue");
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.availStockCheck(11,"Issue", sStock);
			if(flag){
				Constant.log.info("stock check for single make is successful");
				extentTest.log(LogStatus.PASS, "stock check for single make is successful");
			}else{
				System.err.println("stock check for single make is unsuccessful");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test012_AvailStockSingleMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("stock check for single make");
	}

	@Test   	@Category(MediumPriorityTestCases.class)
	public void Test013_AvailStockMultiMake() throws Exception{
		log.startTestCase("Stock check for material with multiple make");
		extentTest = extent.startTest("Test013_AvailStockMultiMake",
				"Verify stock of material with multiple make").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			String sStock = master.fetchStock(12,"Issue");
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.availStockCheck(12,"Issue", sStock);
			if(flag){
				Constant.log.info("Stock check for material with multiple make is successful");
				extentTest.log(LogStatus.PASS, "Stock check for material with multiple make is successful");
			}else{
				System.err.println("Stock check for material with multiple make is unsuccessful");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test013_AvailStockMultiMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Stock check for material with multiple make");
	}

	@Test   	@Category(MediumPriorityTestCases.class)
	public void Test014_AvailStockWOMake() throws Exception{
		log.startTestCase("Stock check for material without make");
		extentTest = extent.startTest("Test014_AvailStockWOMake",
				"Verify stock of material without make").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			String sStock = master.fetchStock(13,"Issue");
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.availStockCheck(13,"Issue", sStock);
			if(flag){
				Constant.log.info("Stock check for material without make is successful");
				extentTest.log(LogStatus.PASS, "Stock check for material without make is successful");
			}else{
				System.err.println("Stock check for material without make is unsuccessful");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test014_AvailStockWOMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Stock check for material without make");
	}

	@Test   	@Category(MediumPriorityTestCases.class)
	public void Test015_MaterialMandatoryFieldsCheck() throws Exception{
		log.startTestCase("Material Mandatory Fields check");
		extentTest = extent.startTest("Test015_MaterialMandatoryFieldsCheck",
				"Verify if material mandatory fields warning msgs displayed").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.mandatoryMaterialWarning_Issue(14,"Issue");
			if(flag){
				Constant.log.info("material Mandatory error messages are displayed");
				extentTest.log(LogStatus.PASS, "material Mandatory error messages are displayed");
			}else{
				System.err.println("material Mandatory error messages are not displayed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test015_MaterialMandatoryFieldsCheck")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("material Mandatory Fields check");
	}

	@Test   	@Category(MediumPriorityTestCases.class)
	public void Test016_MaterialListGridCheck() throws Exception{
		log.startTestCase("Material list grid check");
		extentTest = extent.startTest("Test016_MaterialListGridCheck",
				"Verify material list grid ").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.materialListgrid_issue(15,"Issue");
			if(flag){
				Constant.log.info("Material list grid validation is successfull");
				extentTest.log(LogStatus.PASS, "Material list grid validation is successfull");
			}else{
				System.err.println("Material list grid validation is unsuccessfull");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test016_MaterialListGridCheck")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("material list grid check");
	}

	@Test   @Category(MediumPriorityTestCases.class)
	public void Test017_StockNotAvailable_Popup() throws Exception{
		log.startTestCase("Stock Not Available pop up");
		extentTest = extent.startTest("Test017_StockNotAvailable_Popup",
				"Verify stock not avaialble warning displayed ").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.stockNotAvailableWarning(16,"Issue");
			if(flag){
				Constant.log.info("Verify if Stock not available pop up is displayed test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if Stock not available pop up is displayed test case is successful");
			}else{
				System.err.println("Verify if Stock not available pop up is displayed test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test017_StockNotAvailable_Popup")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Stock Not Available pop up");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test018_AddMaterialWithDecimalQty() throws Exception{
		log.startTestCase("Add Material with decimal qty");
		extentTest = extent.startTest("Test018_AddMaterialWithDecimalQty",
				"Verify if Material is added with material having decimal qty").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.materialListgrid_issue(17,"Issue");
			if(flag){
				Constant.log.info("Material Addition having material with decimal qty test case is successful");
				extentTest.log(LogStatus.PASS, "Material Addition having material with decimal qty test case is successful");
			}else{
				System.err.println("Material Addition having material with decimal qty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test018_AddMaterialWithDecimalQty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Material with decimal qty");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test019_AddMaterialWithFullQty() throws Exception{
		log.startTestCase("Add Material with full qty");
		extentTest = extent.startTest("Test019_AddMaterialWithAvailQty",
				"Verify if Material is added with material having full qty").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.addFullQty_issue(18,"Issue");
			if(flag){
				Constant.log.info("Material Addition having material with full qty test case is successful");
				extentTest.log(LogStatus.PASS, "Material Addition having material with full qty test case is successful");
			}else{
				System.err.println("Material Addition having material with full qty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test019_AddMaterialWithAvailQty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Material with full qty");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test020_InvalidMatCheck() throws Exception{
		log.startTestCase("Invalid material check");
		extentTest = extent.startTest("Test020_InvalidMatCheck",
				"Verify Invalid material check").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.newMaterialWarning();
			if(flag){
				Constant.log.info("Invalid material check test case is successful");
				extentTest.log(LogStatus.PASS, "Invalid material check test case is successful");
			}else{
				System.err.println("Invalid material check test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test020_InvalidMatCheck")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Invalid material check");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test021_NoMaterialWArning() throws Exception{
		log.startTestCase("No Material WArning");
		extentTest = extent.startTest("Test021_NoMaterialWArning",
				"Verify No Material WArning").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.noMaterialWarning_Issue(20, "Issue");
			if(flag){
				Constant.log.info("No Material WArning check test case is successful");
				extentTest.log(LogStatus.PASS, "No Material WArning check test case is successful");
			}else{
				System.err.println("No Material WArning check test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test021_NoMaterialWArning")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("No Material WArning check");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test022_AddIssueWithMake() throws Exception{
		log.startTestCase("Add Issue with make");
		extentTest = extent.startTest("Test022_AddIssueWithMake",
				"Verify if issue is added with material having make").assignCategory("IssueTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addIssue(21,"Issue");
			if(flag){
				Constant.log.info("Issue Addition having material with make test case is successful");
				extentTest.log(LogStatus.PASS, "Issue Addition having material with make test case is successful");
			}else{
				System.err.println("Issue Addition having material with make test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test022_AddIssueWithMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue with make");
	}

	@Category(SmokeTest.class)
	@Test
	public void Test023_AddIssueWithOutMake() throws Exception{
		log.startTestCase("Add Issue without make");
		extentTest = extent.startTest("Test023_AddIssueWithOutMake",
				"Verify if issue is added").assignCategory("IssueTestCases","SmokeTest");
		try{
			boolean flag = store.addIssue(22,"Issue");
			if(flag){
				Constant.log.info("Issue Addition having material without make test case is successful");
				extentTest.log(LogStatus.PASS, "Issue Addition having material without make test case is successful");
			}else{
				System.err.println("Issue Addition having material without make test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test023_AddIssueWithOutMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue without make");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test024_AddIssueWithMultMake_SameMaterial() throws Exception{
		log.startTestCase("Add Issue with multiple make for same material");
		extentTest = extent.startTest("Test024_AddIssueWithMultMake_SameMaterial",
				"Verify if issue is added with same material having multiple make").assignCategory("IssueTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addIssue(23,"Issue");
			if(flag){
				Constant.log.info("Issue Addition with same material multiple make test case is successful");
				extentTest.log(LogStatus.PASS, "Issue Addition with same material multiple make  test case is successful");
			}else{
				System.err.println("Issue Addition with same material multiple make test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test024_AddIssueWithMultMake_SameMaterial")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue with multiple make for same material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test025_AddIssueWithMultMatHavMake() throws Exception{
		log.startTestCase("Add Issue with multiple material having make");
		extentTest = extent.startTest("Test025_AddIssueWithMultMatHavMake",
				"Verify if issue is added with multiple material having make").assignCategory("IssueTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addIssue(24,"Issue");
			if(flag){
				Constant.log.info("Issue Addition with multiple material having make test case is successful");
				extentTest.log(LogStatus.PASS, "Issue Addition with multiple material having make test case is successful");
			}else{
				System.err.println("Issue Addition with multiple material having make test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test025_AddIssueWithMultMatHavMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue with multiple material having make");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test026_AddIssueWithMultMat() throws Exception{
		log.startTestCase("Add Issue with multiple material");
		extentTest = extent.startTest("Test026_AddIssueWithMultMat",
				"Verify if issue is added with multiple material").assignCategory("IssueTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addIssue(25,"Issue");
			if(flag){
				Constant.log.info("Issue Addition with multiple material test case is successful");
				extentTest.log(LogStatus.PASS, "Issue Addition with multiple material test case is successful");
			}else{
				System.err.println("Issue Addition with multiple material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test026_AddIssueWithMultMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue with multiple material");
	}

	@Test  	@Category(HighPriorityTestCases.class)
	public void Test027_AddIssueWithMultMatWithNdWithoutMake() throws Exception{
		log.startTestCase("Add Issue with multiple material with and without make");
		extentTest = extent.startTest("Test027_AddIssueWithMultMatWithNdWithoutMake",
				"Verify if issue is added with multiple material with and without make").assignCategory("IssueTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addIssue(26,"Issue");
			if(flag){
				Constant.log.info("Issue Addition with multiple material having with and without make test case is successful");
				extentTest.log(LogStatus.PASS, "Issue Addition with multiple material test case is successful");
			}else{
				System.err.println("Issue Addition with multiple material having with and without make test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test027_AddIssueWithMultMatWithNdWithoutMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue with multiple material with and without make");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test028_ItemAlreadyExist_SameMake() throws Exception{
		log.startTestCase("Item already exists warning for same make");
		extentTest = extent.startTest("Test028_ItemAlreadyExist_SameMake",
				"Verify Item already exists warning for same make").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.validateMatAlreadyExistsWArning(27, "Issue");
			if(flag){
				Constant.log.info("Item already exists warning for same make test case is successful");
				extentTest.log(LogStatus.PASS, "Item already exists warning for same make test case is successful");
			}else{
				System.err.println("Item already exists warning for same make test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test028_ItemAlreadyExist_SameMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Item already exists warning for same make");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test029_AddIssue_DiffMake() throws Exception{
		log.startTestCase("Add issue with different make");
		extentTest = extent.startTest("Test029_AddIssue_DiffMake",
				"Verify Add issue with different make").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.addIssue(28, "Issue");
			if(flag){
				Constant.log.info("Add issue with different make test case is successful");
				extentTest.log(LogStatus.PASS, "Add issue with different make test case is successful");
			}else{
				System.err.println("Add issue with different make test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test029_AddIssue_DiffMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add issue with different make");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test030_AddIssue_FaultyMat() throws Exception{
		log.startTestCase("Add issue with faulty material");
		extentTest = extent.startTest("Test030_AddIssue_FaultyMat",
				"Verify Add issue with faulty material").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.addIssue(29, "Issue");
			if(flag){
				Constant.log.info("Add issue with faulty material test case is successful");
				extentTest.log(LogStatus.PASS, "Add issue with faulty material test case is successful");
			}else{
				System.err.println("Add issue with faulty material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test030_AddIssue_FaultyMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add issue with faulty material");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test031_AddIssue_FaultyMatWmake() throws Exception{
		log.startTestCase("Add issue with faulty material and make");
		extentTest = extent.startTest("Test031_AddIssue_FaultyMatWmake",
				"Verify Add issue with faulty material and make").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.addIssue(30, "Issue");
			if(flag){
				Constant.log.info("Add issue with faulty material and make test case is successful");
				extentTest.log(LogStatus.PASS, "Add issue with faulty material and make test case is successful");
			}else{
				System.err.println("Add issue with faulty material and make test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test031_AddIssue_FaultyMatWmake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add issue with faulty material and make");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test032_AddIssue_MultiFaultyMat() throws Exception{
		log.startTestCase("Add issue with multiple faulty material");
		extentTest = extent.startTest("Test032_AddIssue_MultiFaultyMat",
				"Verify Add issue with multiple faulty material").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.addIssue(31, "Issue");
			if(flag){
				Constant.log.info("Add issue with multiple faulty material test case is successful");
				extentTest.log(LogStatus.PASS, "Add issue with multiple faulty material test case is successful");
			}else{
				System.err.println("Add issue with multiple faulty material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test032_AddIssue_MultiFaultyMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add issue with multiple faulty material");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test033_AddIssue_WNWOfaultyMat() throws Exception{
		log.startTestCase("Add issue with N without faulty material");
		extentTest = extent.startTest("Test033_AddIssue_WNWOfaultyMat",
				"Verify Add issue with N without faulty material").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.addIssue(32, "Issue");
			if(flag){
				Constant.log.info("Add issue with N without faulty material test case is successful");
				extentTest.log(LogStatus.PASS, "Add issue with N without faulty material test case is successful");
			}else{
				System.err.println("Add issue with N without faulty material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test033_AddIssue_WNWOfaultyMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add issue with N without faulty material");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test034_AddIssue_WNWOfaultyMake() throws Exception{
		log.startTestCase("Add issue with N without faulty make");
		extentTest = extent.startTest("Test034_AddIssue_WNWOfaultyMake",
				"Verify Add issue with N without faulty make").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.addIssue(33, "Issue");
			if(flag){
				Constant.log.info("Add issue with N without faulty make test case is successful");
				extentTest.log(LogStatus.PASS, "Add issue with N without faulty make test case is successful");
			}else{
				System.err.println("Add issue with N without faulty make test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test034_AddIssue_WNWOfaultyMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add issue with N without faulty make");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test035_AddIssue_WithRemarks() throws Exception{
		log.startTestCase("Add issue with remarks");
		extentTest = extent.startTest("Test035_AddIssue_WithRemarks",
				"Verify Add issue with remarks").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.addIssue(34, "Issue");
			if(flag){
				Constant.log.info("Add issue with remarks test case is successful");
				extentTest.log(LogStatus.PASS, "Add issue with remarks test case is successful");
			}else{
				System.err.println("Add issue with remarks test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test035_AddIssue_WithRemarks")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add issue with remarks");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test036_DeleteMat_AddIssue() throws Exception{
		log.startTestCase("Delete material in add issue page");
		extentTest = extent.startTest("Test036_DeleteMat_AddIssue",
				"Verify Delete material in add issue page").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.deleteMaterial(35, "Issue");
			if(flag){
				Constant.log.info("Delete material in add issue page test case is successful");
				extentTest.log(LogStatus.PASS, "Delete material in add issue page test case is successful");
			}else{
				System.err.println("Delete material in add issue page test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test036_DeleteMat_AddIssue")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Delete material in add issue page");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test038_UpdateIssue_AddMat() throws Exception{
		log.startTestCase("Update issue by adding material");
		extentTest = extent.startTest("Test038_UpdateIssue_AddMat",
				"Verify Update issue by adding material").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			store.addIssue(34,"Issue");//dont change row no
			boolean flag = store.updateIssue_AddMat(37, "Issue");
			if(flag){
				Constant.log.info("Update issue by adding material test case is successful");
				extentTest.log(LogStatus.PASS, "Update issue by adding material test case is successful");
			}else{
				System.err.println("Update issue by adding material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test038_UpdateIssue_AddMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update issue by adding material");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test039_UpdateIssue_DeleteMat() throws Exception{
		log.startTestCase("Update issue by deleting material");
		extentTest = extent.startTest("Test039_UpdateIssue_DeleteMat",
				"Verify Update issue by deleting material").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			store.addIssue(38,"Issue");
			boolean flag = store.updateIssue_DeleteMat(38, "Issue");
			if(flag){
				Constant.log.info("Update issue by deleting material test case is successful");
				extentTest.log(LogStatus.PASS, "Update issue by deleting material test case is successful");
			}else{
				System.err.println("Update issue by deleting material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test039_UpdateIssue_DeleteMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update issue by deleting material");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test040_UpdateIssue_AddNDeleteMat() throws Exception{
		log.startTestCase("Update issue by deleting and adding material");
		extentTest = extent.startTest("Test040_UpdateIssue_AddNDeleteMat",
				"Verify Update issue by deleting and adding material").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.updateIssue(39, "Issue");
			if(flag){
				Constant.log.info("Update issue by deleting and adding material test case is successful");
				extentTest.log(LogStatus.PASS, "Update issue by deleting and adding material test case is successful");
			}else{
				System.err.println("Update issue by deleting and adding material test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test040_UpdateIssue_AddNDeleteMat")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update issue by deleting and adding material");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test041_UpdateIssueForNTo() throws Exception{
		log.startTestCase("Update issue for and to");
		extentTest = extent.startTest("Test041_UpdateIssueForNTo",
				"Verify Update issue for and to").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.updateIssueForTo(40, "Issue");
			if(flag){
				Constant.log.info("Update issue for and to test case is successful");
				extentTest.log(LogStatus.PASS, "Update issue for and to test case is successful");
			}else{
				System.err.println("Update issue for and to test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test041_UpdateIssueForNTo")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update issue for and to");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test042_UpdateIssuedDate() throws Exception{
		log.startTestCase("Update issued date");
		extentTest = extent.startTest("Test042_UpdateIssuedDate",
				"Verify Update issued date").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			store.addIssue(41, "Issue");
			boolean flag = store.updateIssuedDate(41, "Issue");
			if(flag){
				Constant.log.info("Update issued date test case is successful");
				extentTest.log(LogStatus.PASS, "Update issued date test case is successful");
			}else{
				System.err.println("Update issued date test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test042_UpdateIssuedDate")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update issued date");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test043_UpdateIssue_SameMatWMake() throws Exception{
		log.startTestCase("Update adding same material with make");
		extentTest = extent.startTest("Test043_UpdateIssue_SameMatWMake",
				"Verify Upby adding same material with make issued by adding same material with make").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			store.addIssue(35, "Issue");//dont chnage row no
			boolean flag = store.updateIssue_AddMat(42, "Issue");
			if(flag){
				Constant.log.info("Update adding same material with make test case is successful");
				extentTest.log(LogStatus.PASS, "Update adding same material with make test case is successful");
			}else{
				System.err.println("Update adding same material with make test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test043_UpdateIssue_SameMatWMake")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update adding same material with make");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test044_UpdateIssue_SameMatWFaulty() throws Exception{
		log.startTestCase("Update adding same material with Faulty");
		extentTest = extent.startTest("Test044_UpdateIssue_SameMatWFaulty",
				"Verify Update adding same material with Faulty").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			store.addIssue(35, "Issue");
			boolean flag = store.updateIssue_AddMat(43, "Issue");
			if(flag){
				Constant.log.info("Update adding same material with Faulty test case is successful");
				extentTest.log(LogStatus.PASS, "Update adding same material with Faulty test case is successful");
			}else{
				System.err.println("Update adding same material with Faulty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test044_UpdateIssue_SameMatWFaulty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update adding same material with Faulty");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test045_UpdateIssue_MultiMatWMakeFaulty() throws Exception{
		log.startTestCase("Update adding multiple material with make N faulty");
		extentTest = extent.startTest("Test044_UpdateIssue_multipleMatWFaulty",
				"Verify Update adding multiple material with make N faulty").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			store.addIssue(35, "Issue");
			boolean flag = store.updateIssue_AddMat(44, "Issue");
			if(flag){
				Constant.log.info("Update adding multiple material with make N faulty test case is successful");
				extentTest.log(LogStatus.PASS, "Update adding multiple material with make N faulty test case is successful");
			}else{
				System.err.println("Update adding multiple material with make N faulty test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test044_UpdateIssue_multipleMatWFaulty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Update adding multiple material with make N faulty");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test046_AddIssue_PastDate() throws Exception{
		log.startTestCase("Add issue for past date");
		extentTest = extent.startTest("Test046_AddIssue_PastDate",
				"Verify Add issue for past date").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.addIssue_PastDate(45, "Issue");
			if(flag){
				Constant.log.info("Add issue for past date test case is successful");
				extentTest.log(LogStatus.PASS, "Add issue for past date test case is successful");
			}else{
				System.err.println("Add issue for past date test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test046_AddIssue_PastDate")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add issue for past date");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test056_QtyGreaterStockWarn_BOMPopup() throws Exception{
		log.startTestCase("Qty greater than stock warning in bom popup");
		extentTest = extent.startTest("Test056_QtyGreaterStockWarn_BOMPopup",
				"Verify Qty greater than stock warning in bom popup").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			boolean flag = store.qtyGreaterStockBOMWarn(55, "Issue");
			if(flag){
				Constant.log.info("Qty greater than stock warning in bom popup test case is successful");
				extentTest.log(LogStatus.PASS, "Qty greater than stock warning in bom popup test case is successful");
			}else{
				System.err.println("Qty greater than stock warning in bom popup test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test056_QtyGreaterStockWarn_BOMPopup")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Qty greater than stock warning in bom popup");
	}

	@Test  	@Category(MediumPriorityTestCases.class)
	public void Test057_nilStockParent_addChildWStock() throws Exception{
		log.startTestCase("Parent with nil stock but child with stock");
		extentTest = extent.startTest("Test057_nilStockParent_addChildWStock",
				"Verify Parent with nil stock but child with stock is added from bom popup").assignCategory("IssueTestCases","MediumPriorityTestCases");
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			master.addMaterial_BOM();
			String sMaterial = master.firstMaterial.getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			boolean flag = store.childMatAddedWOParentStock(sMaterial);
			if(flag){
				Constant.log.info("Verify Parent with nil stock but child with stock is added from bom popup test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Parent with nil stock but child with stock is added from bom popup test case is successful");
			}else{
				System.err.println("Verify Parent with nil stock but child with stock is added from bom popup test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test057_nilStockParent_addChildWStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Parent with nil stock but child with stock");
	}


	@Test  	@Category(HighPriorityTestCases.class)
	public void Test074_AddIssueWithRemarks() throws Exception{
		log.startTestCase("Add Issue with Remarks");
		extentTest = extent.startTest("Test074_AddIssueWithRemarks",
				"Verify if issue is added with Remarks").assignCategory("IssueTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.addIssue(73,"Issue");
			if(flag){
				Constant.log.info("Issue added with remarks test case is successful");
				extentTest.log(LogStatus.PASS, "Issue added with remarks test case is successful");
			}else{
				System.err.println("Issue added with remarks test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test074_AddIssueWithRemarks")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue with Remarks");
	}

	@Test  @Category(SanityTests.class)
	public void Test075_UpdateIssueWithRemarks() throws Exception{
		log.startTestCase("Issue Update");
		extentTest = extent.startTest("Test075_UpdateIssueWithRemarks",
				"Verify if issue is updated").assignCategory("IssueTestCases","SanityTests");
		try{
			boolean flag = store.updateIssue(74,"Issue");
			if(flag){
				Constant.log.info("Issue update test case is successful");
				extentTest.log(LogStatus.PASS, "Issue update test case is successful");
			}else{
				System.err.println("Issue update test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test075_UpdateIssueWithRemarks")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Issue Update");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test160_VerifyDraftIRNDetails() throws Exception{
		log.startTestCase("Draft IRN Details");
		extentTest = extent.startTest("Test160_VerifyDraftIRNDetails",
				"Verify if Draft IRN details gets displayed in Material returned popup").assignCategory("IssueTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.draftIRNDetailsValidate(159,"Issue");
			if(flag){
				Constant.log.info("Validate draft IRN details displayed in Material returned popup test case is successful");
				extentTest.log(LogStatus.PASS, "Validate draft IRN details displayed in Material returned popup test case is successful");
			}else{
				System.err.println("Validate draft IRN details displayed in Material returned popup test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test160_VerifyDraftIRNDetails")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Draft IRN Details");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test161_VerifyApproveIRNDetails() throws Exception{
		log.startTestCase("Approve IRN Details");
		extentTest = extent.startTest("Test161_VerifyApproveIRNDetails",
				"Verify if Approve IRN details gets displayed in Material returned popup").assignCategory("IssueTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.approvedIRNDetailsValidate(160,"Issue");
			if(flag){
				Constant.log.info("Validate Approve IRN details displayed in Material returned popup test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Approve IRN details displayed in Material returned popup test case is successful");
			}else{
				System.err.println("Validate Approve IRN details displayed in Material returned popup test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test161_VerifyApproveIRNDetails")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Approve IRN Details");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test162_VerifyRejectIRNDetails() throws Exception{
		log.startTestCase("Reject IRN Details");
		extentTest = extent.startTest("Test162_VerifyRejectIRNDetails",
				"Verify if Reject IRN details gets displayed in Material returned popup").assignCategory("IssueTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.rejectIRNDetailsValidate(161,"Issue");
			if(flag){
				Constant.log.info("Validate Reject IRN details displayed in Material returned popup test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Reject IRN details displayed in Material returned popup test case is successful");
			}else{
				System.err.println("Validate Reject IRN details displayed in Material returned popup test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test162_VerifyRejectIRNDetails")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject IRN Details");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test163_VerifyUpdatedIRNDetails() throws Exception{
		log.startTestCase("Updated IRN Details");
		extentTest = extent.startTest("Test163_VerifyUpdatedIRNDetails",
				"Verify if Updated IRN details gets displayed in Material returned popup").assignCategory("IssueTestCases","HighPriorityTestCases");
		try{
			boolean flag = store.updateIRNDetailsValidate(162,"Issue");
			if(flag){
				Constant.log.info("Validate Updated IRN details displayed in Material returned popup test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Updated IRN details displayed in Material returned popup test case is successful");
			}else{
				System.err.println("Validate Updated IRN details displayed in Material returned popup test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test163_VerifyUpdatedIRNDetails")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Updated IRN Details");
	}

	@Test  	@Category(SanityTests.class)
	public void Test259_AddIssueWithNonStock() throws Exception{
		log.startTestCase("Add Issue with NonStock");
		extentTest = extent.startTest("Test259_AddIssueWithNonStock",
				"Verify if issue is added with material having NonStock").assignCategory("IssueTestCases","SanityTests");
		try{
			boolean flag = store.addIssue(258,"Sanity Test");
			if(flag){
				Constant.log.info("Issue Addition having material with NonStock test case is successful");
				extentTest.log(LogStatus.PASS, "Issue Addition having material with NonStock test case is successful");
			}else{
				System.err.println("Issue Addition having material with NonStock test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test259_AddIssueWithNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Add Issue with NonStock");
	}

	@Test @Category(SanityTests.class)
	public void Test290_AddIssue_AltUnit() throws Exception{
		log.startTestCase("ADD Issue with alternate unit");
		extentTest = extent.startTest("Test290_AddIssue_AltUnit",
				"Verify if Issue with added with alternate unit").assignCategory("IssueTestCases","SanityTests");
		try{
			boolean flag = store.addIssue(289, "Sanity Test");
			if(flag){
				Constant.log.info("ADD Issue with alternate unit is successful");
				extentTest.log(LogStatus.PASS, "ADD Issue with alternate unit is successful");
			}else{
				System.err.println("ADD Issue with alternate unit failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test290_AddIssue_AltUnit")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("ADD Issue with alternate unit");
	}



	/*
	@Test
	public void Test002_SearchIssue_Project() throws Exception{
		log.startTestCase("Search Issue Project");
		extentTest = extent.startTest("Add Issue",
				"Verify if issue is added");
		login.login();
		try{
			boolean flag = store.searchIssue_Project(1);
			if(flag == true){
				Constant.log.info("Issue Search Project test case is successful");
				extentTest.log(LogStatus.PASS, "Issue Addition test case is successful");
			}else{
				System.err.println("Issue Search Project test case failed ");
				Constant.captureScreen_Negative("Search Issue Project");
				extentTest.log(LogStatus.FAIL, "Issue addition test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("SearchIssue_Project");
	}

	@Test
	public void Test003_SearchIssue_SearchIn() throws Exception{
		log.startTestCase("SearchIssue_SearchIn");
		extentTest = extent.startTest("Search Issue and Search In",
				"Verify Search Issue and Search In Fields");
		login.login();
		try{
			boolean flag = store.searchIssue_SearchIn(2);
			if(flag == true){
				Constant.log.info("Issue Search of Search In field test case is successful");
				extentTest.log(LogStatus.PASS, "Issue Search of Search In field test case is successful");
			}else{
				System.err.println("Issue Search of Search In field test case failed ");
				Constant.captureScreen_Negative("SearchIssue_SearchIn");
				extentTest.log(LogStatus.FAIL, "Issue Search of Search In field test case failed ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("SearchIssue_SearchIn");
	}

	@Test
	public void Test005_CancelIssue() throws Exception{
		log.startTestCase("IssueCancel");
		extentTest = extent.startTest("Cancel button",
				"Verify Cancel button Issue add page");
		login.login();
		try{
			boolean flag = store.cancelIssue(4,"Issue");
			if(flag == true){
				Constant.log.info("Issue Cancel test case is successful");
				extentTest.log(LogStatus.PASS, "Issue Cancel test case is successful");
			}else{
				System.err.println("Issue Cancel test case failed ");
				Constant.captureScreen_Negative("IssueCancel");
				extentTest.log(LogStatus.FAIL, "Issue Cancel test case failed ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("IssueCancel");
	}

	@Test
	public void Test009_DatewiseSearch() throws Exception{
		log.startTestCase("Date wise Search");
		extentTest = extent.startTest("Date wise Search",
				"Validate date wise search");
		login.login();
		try{
			boolean flag = store.last30Days(8,2);
			boolean flag1 = store.currentMonth(2);
			boolean flag2 = store.currentYear(2);
			boolean flag3 = store.currentFinancialYear(2);
			boolean flag4 = store.customRange(2);
			if(flag == true && flag1 == true && flag2 == true && flag3 == true && flag4 == true){
				Constant.log.info("Date wise search is successful");
				extentTest.log(LogStatus.PASS, "Date wise search is successful");
			}else{
				System.err.println("Date wise search is not successful ");
				Constant.captureScreen_Negative("Date wise Search");
				extentTest.log(LogStatus.FAIL, "Date wise search is not successful ");
			}
			Assert.assertTrue(flag == true && flag1 == true && flag2 == true && flag3 == true && flag4 == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Date wise Search");
	}

	@Test
	public void Test012_MandatoryFieldCheck_Edit() throws Exception{
		log.startTestCase("Mandatory Fields check while eidting");
		extentTest = extent.startTest("Mandatory Fields check while eidting",
				"Verify if mandatory error messages are displayed while eidting");
		login.login();
		try{
			boolean flag = store.MandatoryFieldsCheckEdit(11,"Issue");
			if(flag == true){
				Constant.log.info("Mandatory error messages are displayed while eidting");
				extentTest.log(LogStatus.PASS, "Mandatory error messages are displayed while eidting");
			}else{
				System.err.println("Mandatory error messages are not displayed while eidting ");
				Constant.captureScreen_Negative("Mandatory Fields check while eidting");
				extentTest.log(LogStatus.FAIL, "Mandatory error messages are not displayed while eidting ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Mandatory Fields check while eidting");
	}

	@Test
	public void Test013_CheckColumNames() throws Exception{
		log.startTestCase("Column names validation");
		extentTest = extent.startTest("Column names validation",
				"Verify column names display");
		login.login();
		try{
			boolean flag = store.columnNamesValidation(12);
			if(flag == true){
				Constant.log.info("Column names are displayed properly");
				extentTest.log(LogStatus.PASS, "Column names are displayed properly");
			}else{
				System.err.println("Column names are not displayed properly ");
				Constant.captureScreen_Negative("Column names validation");
				extentTest.log(LogStatus.FAIL, "Column names are not displayed properly ");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
				System.err.println(e);
			}
		log.endTestCase("Column names validation");
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
