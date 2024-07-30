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
import pages.AuditingPage;
import pages.LoginPage;
import pages.SettingPage;
import pages.StorePage;
import utility.Constant;
import utility.Log;
import utility.NavigateToPages;
import utility.ReadPropertyFile;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ICDTestcases {

	Log log = PageFactory.initElements(Constant.driver, Log.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
	AuditingPage audit = PageFactory.initElements(Constant.driver, AuditingPage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
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
		Constant.logFile("ICD");
		 //Browser Initialization
		 Constant.BrowserInitialization();
	}

	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		login.login();
		navigate.navigateToSettings();
		Thread.sleep(Constant.Min_Sleep);
		navigate.navigateToProfile();
		Thread.sleep(Constant.Min_Sleep);
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test048_CheckICDGRNPO_Invoice() throws Exception{
		log.startTestCase("Check ICD of GRN Po with Invoice toggle");
		extentTest = extent.startTest("Test048_CheckICDGRNPO_Invoice",
				"Verify if ICD is checked for GRN po with Invoice toggle").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			setting.purchaseMandatoryChkBx_UnCheck();
			boolean flag = audit.checkGRNPO(47, "ICD", "GRN");
			if(flag){
				Constant.log.info("Verify if ICD is checked for GRN po with Invoice toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is checked for GRN po with Invoice toggle test case is successful");
			}else{
				System.err.println("Verify if ICD is checked for GRN po with Invoice toggle test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test048_CheckICDGRNPO_Invoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check ICD of GRN Po with Invoice toggle");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test049_VerifyICDGRNPO_Invoice() throws Exception{
		log.startTestCase("Verify ICD of GRN Po with Invoice toggle");
		extentTest = extent.startTest("Test049_VerifyICDGRNPO_Invoice",
				"Verify if ICD is Verifyed for GRN po with Invoice toggle").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			setting.purchaseMandatoryChkBx_UnCheck();
			boolean flag = audit.verifyGRNPO(48, "ICD", "GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Verified for GRN po with Invoice toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Verified for GRN po with Invoice toggle test case is successful");
			}else{
				System.err.println("Verify if ICD is Verified for GRN po with Invoice toggle test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test049_VerifyICDGRNPO_Invoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD of GRN Po with Invoice toggle");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test050_CheckICDGRNPO_Goods() throws Exception{
		log.startTestCase("Check ICD of GRN Po with Goods ");
		extentTest = extent.startTest("Test050_CheckICDGRNPO_Goods",
				"Verify if ICD is checked for GRN po with Goods ").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			setting.purchaseMandatoryChkBx_UnCheck();
			boolean flag = audit.checkGRNPO(49, "ICD", "GRN");
			if(flag){
				Constant.log.info("Verify if ICD is checked for GRN po with Goods  test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is checked for GRN po with Goods  test case is successful");
			}else{
				System.err.println("Verify if ICD is checked for GRN po with Goods  test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test050_CheckICDGRNPO_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check ICD of GRN Po with Goods ");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test051_VerifyICDGRNPO_Goods() throws Exception{
		log.startTestCase("Verify ICD of GRN Po with Goods ");
		extentTest = extent.startTest("Test051_VerifyICDGRNPO_Goods",
				"Verify if ICD is Verifyed for GRN po with Goods ").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			setting.purchaseMandatoryChkBx_UnCheck();
			boolean flag = audit.verifyGRNPO(50, "ICD", "GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Verified for GRN po with Goods  test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Verified for GRN po with Goods  test case is successful");
			}else{
				System.err.println("Verify if ICD is Verified for GRN po with Goods  test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test051_VerifyICDGRNPO_Goods")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD of GRN Po with Goods ");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test061_VerifyICDGRNPO_NonStock() throws Exception{
		log.startTestCase("Verify ICD of GRN Po with Non stock ");
		extentTest = extent.startTest("Test061_VerifyICDGRNPO_NonStock",
				"Verify if ICD is Verifyed for GRN po with Non stock ").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			setting.purchaseMandatoryChkBx_UnCheck();
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
            boolean flag = audit.verifyGRNPO_addingPo(60, "ICD", "GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Veified for GRN po with Non stock  test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Verified for GRN po with Non stock  test case is successful");
			}else{
				System.err.println("Verify if ICD is Verified for GRN po with Non stock  test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test061_VerifyICDGRNPO_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD of GRN Po with Non stock ");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test062_VerifyICDGRNJO_NonStock() throws Exception{
		log.startTestCase("Verify ICD of GRN JO with Non stock ");
		extentTest = extent.startTest("Test062_VerifyICDGRNJO_NonStock",
				"Verify if ICD is Verifyed for GRN JO with Non stock ").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			setting.purchaseMandatoryChkBx_UnCheck();
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = audit.verifyGRNPO_addingJDC(61, "ICD", "GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Verified for GRN JO with Non stock  test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Verified for GRN JO with Non stock  test case is successful");
			}else{
				System.err.println("Verify if ICD is Verified for GRN JO with Non stock  test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test062_VerifyICDGRNJO_NonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD of GRN JO with Non stock ");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test063_VerifyICDGRNPO_StockNNonStock() throws Exception{
		log.startTestCase("Verify ICD of GRN PO with Stock N Non stock ");
		extentTest = extent.startTest("Test063_VerifyICDGRNPO_StockNNonStock",
				"Verify if ICD is Verifyed for GRN PO with Stock N Non stock ").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			setting.purchaseMandatoryChkBx_UnCheck();
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = audit.verifyGRNPO_addingPo(62, "ICD", "GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Verified for GRN PO with Stock N Non stock  test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Verified for GRN PO with Stock N Non stock  test case is successful");
			}else{
				System.err.println("Verify if ICD is Verified for GRN PO with Stock N Non stock  test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test063_VerifyICDGRNPO_StockNNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD of GRN PO with Stock N Non stock ");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test064_VerifyICDGRNJO_StockNNonStock() throws Exception{
		log.startTestCase("Verify ICD of GRN JO with Stock N Non stock ");
		extentTest = extent.startTest("Test064_VerifyICDGRNJO_StockNNonStock",
				"Verify if ICD is Verifyed for GRN JO with Stock N Non stock ").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			setting.purchaseMandatoryChkBx_UnCheck();
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			boolean flag = audit.verifyGRNPO_addingJDC(63, "ICD", "GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Verified for GRN JO with Stock N Non stock  test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Verified for GRN JO with Stock N Non stock  test case is successful");
			}else{
				System.err.println("Verify if ICD is Verified for GRN JO with Stock N Non stock  test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test064_VerifyICDGRNJO_StockNNonStock")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD of GRN JO with Stock N Non stock ");
	}

	@Test @Category(SanityTests.class)
	public void Test096_ReturnICD() throws Exception{
		log.startTestCase("Return ICD");
		extentTest = extent.startTest("Test096_ReturnICD",
				"Verify if ICD is Returned").assignCategory("ICDTestcases","SanityTests");
		try{
			setting.reqAckn_UnCheck();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.returnICD(95,"ICD",null, "Checked");
			if(flag){
				Constant.log.info("Icd Return is successful");
				extentTest.log(LogStatus.PASS, "ICD Return is successful");
			}else{
				System.err.println("ICD Return failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test096_ReturnICD")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test098_VerifyReturnedICdChecked_WithoutChange() throws Exception{
		log.startTestCase("Verify Returned ICd checked without change ");
		extentTest = extent.startTest("Test098_VerifyReturnedICdChecked_WithoutChange",
				"Verify Returned ICd checked without change ").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.checkReturnedICd_WithoutChange();
			if(flag){
				Constant.log.info("Verify Returned ICd checked without change test case is successful");
				extentTest.log(LogStatus.PASS, "Verify Returned ICd checked without change test case is successful");
			}else{
				System.err.println("Verify Returned ICd checked without change test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test098_VerifyReturnedICdChecked_WithoutChange")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify Returned ICd checked without change");
	}

	@Test @Category(SanityTests.class)
	public void Test099_CheckReturnedICD() throws Exception{
		log.startTestCase("Check Returned ICD");
		extentTest = extent.startTest("Test099_CheckReturnedICD",
				"Verify if returned ICD is checked").assignCategory("ICDTestcases","SanityTests");
		try{
			setting.reqAckn_UnCheck();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.checkReturnedICD(98,"ICD", null);
			if(flag){
				Constant.log.info("Check returned icd test case is successful");
				extentTest.log(LogStatus.PASS, "Check returned icd test case is successful");
			}else{
				System.err.println("Check returned icd test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test099_CheckReturnedICD")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check Returned ICD");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test133_VerifyICDCreditDebitPg() throws Exception{
		log.startTestCase("Verify ICD in Credit/Debit page ");
		extentTest = extent.startTest("Test133_VerifyICDCreditDebitPg",
				"Verify ICD in Credit/Debit page").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.icdVerify(null, "Checked");
			if(flag){
				Constant.log.info("Verify ICD in Credit/Debit page test case is successful");
				extentTest.log(LogStatus.PASS, "Verify ICD in Credit/Debit page test case is successful");
			}else{
				System.err.println("Verify ICD in Credit/Debit page test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test133_VerifyICDCreditDebitPg")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD in Credit/Debit page");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test135_ReturnICDCreditDebitPg() throws Exception{
		log.startTestCase("Return ICD in Credit/Debit page ");
		extentTest = extent.startTest("Test135_ReturnICDCreditDebitPg",
				"Return ICD in Credit/Debit page").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToCredit_DebitNote();
			boolean flag = audit.returnICD(134, "ICD",null, "Checked");
			if(flag){
				Constant.log.info("Return ICD in Credit/Debit page test case is successful");
				extentTest.log(LogStatus.PASS, "Return ICD in Credit/Debit page test case is successful");
			}else{
				System.err.println("Return ICD in Credit/Debit page test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test135_ReturnICDCreditDebitPg")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD in Credit/Debit page");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test136_CheckReturnedICd_AddDebitItem() throws Exception{
		log.startTestCase("Check Returned ICD by adding Debit item ");
		extentTest = extent.startTest("Test136_CheckReturnedICd_AddDebitItem",
				"Verify able to check returned ICD by adding Debit item").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.checkReturnedICd_addOtherItem(135, "ICD");
			if(flag){
				Constant.log.info("Check Returned ICD by adding Debit item test case is successful");
				extentTest.log(LogStatus.PASS, "Check Returned ICD by adding Debit item test case is successful");
			}else{
				System.err.println("Check Returned ICD by adding Debit item test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test136_CheckReturnedICd_AddDebitItem")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check Returned ICD by adding Debit item");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test137_CheckReturnedICd_AddCreditItem() throws Exception{
		log.startTestCase("Check Returned ICD by adding Credit item ");
		extentTest = extent.startTest("Test137_CheckReturnedICd_AddCreditItem",
				"Verify able to check returned ICD by adding Credit item").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.checkReturnedICd_addOtherItem(136, "ICD");
			if(flag){
				Constant.log.info("Check Returned ICD by adding Credit item test case is successful");
				extentTest.log(LogStatus.PASS, "Check Returned ICD by adding Credit item test case is successful");
			}else{
				System.err.println("Check Returned ICD by adding Credit item test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test137_CheckReturnedICd_AddCreditItem")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check Returned ICD by adding Credit item");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test300_ReturnICD_0Note() throws Exception{
		log.startTestCase("Return ICD with 0 note ");
		extentTest = extent.startTest("Test300_ReturnICD_0Note",
				"Verify able to return ICD with 0 note").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.returnICD_0Note();
			if(flag){
				Constant.log.info("Verify able to return ICD with 0 note test case is successful");
				extentTest.log(LogStatus.PASS, "Verify able to return ICD with 0 note test case is successful");
			}else{
				System.err.println("Verify able to return ICD with 0 note test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test300_ReturnICD_0Note")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD with 0 note");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test363_ReturnICDGRNJO_Invoice() throws Exception{
		log.startTestCase("Return ICD of GRN Jo with Invoice toggle");
		extentTest = extent.startTest("Test363_ReturnICDGRNJO_Invoice",
				"Verify if ICD is Returned for GRN JO with Invoice toggle").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			setting.purchaseMandatoryChkBx_UnCheck();
			boolean flag = audit.returnGRNPO(362, "ICD", "GRN","Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Returned for GRN JO with Invoice toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Returned for GRN JO with Invoice toggle test case is successful");
			}else{
				System.err.println("Verify if ICD is Returned for GRN JO with Invoice toggle test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test363_ReturnICDGRNJO_Invoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD of GRN JO with Invoice toggle");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test366_ReturnICDSR_Invoice() throws Exception{
		log.startTestCase("Return ICD of SR with Invoice toggle");
		extentTest = extent.startTest("Test366_ReturnICDSR_Invoice",
				"Verify if ICD is Returned for SR with Invoice toggle").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			setting.purchaseMandatoryChkBx_UnCheck();
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSalesReturn();
			boolean flag = audit.returnGRNPO(365, "ICD", "SR", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Returned for SR with Invoice toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Returned for GRN SR with Invoice toggle test case is successful");
			}else{
				System.err.println("Verify if ICD is Returned for SR with Invoice toggle test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test366_ReturnICDSR_Invoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD of SR with Invoice toggle");
	}

	@Test  @Category(HighPriorityTestCases.class)
	public void Test368_ReturnICDGRNPO_Invoice() throws Exception{
		log.startTestCase("Return ICD of GRN PO with Invoice toggle");
		extentTest = extent.startTest("Test368_ReturnICDGRNPO_Invoice",
				"Verify if ICD is Returned for GRN PO with Invoice toggle").assignCategory("ICDTestcases","HighPriorityTestCases");
		try{
			setting.reqAckn_UnCheck();
			setting.purchaseMandatoryChkBx_UnCheck();
			boolean flag = audit.returnGRNPO(367, "ICD", "GRN", "Checked");
			if(flag){
				Constant.log.info("Verify if ICD is Returned for GRN PO with Invoice toggle test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD is Returned for GRN PO with Invoice toggle test case is successful");
			}else{
				System.err.println("Verify if ICD is Returned for GRN PO with Invoice toggle test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test368_ReturnICDGRNPO_Invoice")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD of GRN PO with Invoice toggle");
	}

	@Test  @Category(SanityTests.class)
	public void Test318_ReturnICDToGRN() throws Exception{
		log.startTestCase("Return ICD to GRN");
		extentTest = extent.startTest("Test318_ReturnICDToGRN",
				"Verify if ICD can be returned to GRN").assignCategory("ICDTestcases","SanityTests");
		try{
			setting.reqAckn_UnCheck();
			setting.purchaseMandatoryChkBx_UnCheck();
			boolean flag = audit.returnICDToGRN(317,"ICD");
			if(flag){
				Constant.log.info("Verify if ICD can be returned to GRN test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if ICD can be returned to GRN test case is successful");
			}else{
				System.err.println("Verify if ICD can be returned to GRN test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test318_ReturnICDToGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD to GRN");
	}

	@Category(SmokeTest.class)
	@Test
	public void Test018_CheckICD() throws Exception{
		log.startTestCase("Check ICD");
		extentTest = extent.startTest("Test018_CheckICD",
				"Verify if ICD is checked").assignCategory("ICDTestcases","SmokeTest");
		try{
			setting.reqAckn_UnCheck();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.checkICD(17, "Sanity Test", null, "GRN");
			if(flag){
				Constant.log.info("Checked ICD is successful");
				extentTest.log(LogStatus.PASS, "Checked ICD is successful");
			}else{
				System.err.println("ICD check failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test318_ReturnICDToGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Check ICD");
	}

	@Test @Category(SanityTests.class)
	public void Test019_VerifyICD() throws Exception{
		log.startTestCase("Verify ICD");
		extentTest = extent.startTest("Test019_VerifyICD",
				"Verify if ICD is verified").assignCategory("ICDTestcases","SanityTests");
		try{
			setting.reqAckn_UnCheck();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.icdVerify(null, "Checked");
			if(flag){
				Constant.log.info("Icd Verify is successful");
				extentTest.log(LogStatus.PASS, "ICD Verify is successful");
			}else{
				System.err.println("ICD Verify failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test318_RetuTest019_VerifyICDrnICDToGRN")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify ICD");
	}

	@Test  @Category(SanityTests.class)
	public void Test274_partyAcknowledgementPendingICD() throws Exception{
		log.startTestCase("Party Acknowledgement pending ICD");
		extentTest = extent.startTest("Test274_partyAcknowledgementPendingICD",
				"Verify if ICD is checked").assignCategory("ICDTestcases","SanityTests");
		try{
			setting.reqAckn_Check();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.checkICD(273, "Sanity Test", null, "GRN");
			if(flag){
				Constant.log.info("Checked ICD for Party acknowledgement pending is successful");
				extentTest.log(LogStatus.PASS, "Checked ICD for Party acknowledgement pending is successful");
			}else{
				System.err.println("Checked ICD for Party acknowledgement pending failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test274_partyAcknowledgementPendingICD")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Party Acknowledgement pending ICD");
	}

	@Test  @Category(SanityTests.class)
	public void Test275_acknowledgeByParty_ICd() throws Exception{
		log.startTestCase("Acknowledge by party");
		extentTest = extent.startTest("Test275_acknowledgeByParty_ICd",
				"Verify if ICd is party acknowledged").assignCategory("ICDTestcases","SanityTests");
		try{
			setting.reqAckn_Check();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.acknowledgePartyICD(274, "Sanity Test", null, "GRN");
			if(flag){
				Constant.log.info("ICD is party acknowledged test case is successful");
				extentTest.log(LogStatus.PASS, "ICD is party acknowledged test case is successful");
			}else{
				System.err.println("ICD is party acknowledged test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test275_acknowledgeByParty_ICd")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Acknowledge by party");
	}

	@Test  @Category(SanityTests.class)
	public void Test276_ReturnICd_AckByParty() throws Exception{
		log.startTestCase("Return ICD Acknowledge by party");
		extentTest = extent.startTest("Test276_ReturnICd_AckByParty",
				"Verify if party acknowledged ICD can be returned").assignCategory("ICDTestcases","SanityTests");
		try{
			setting.reqAckn_Check();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.returnICD(275, "Sanity Test", null, "Party Acknowledged");
			if(flag){
				Constant.log.info("Verify if party acknowledged ICD can be returned test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if party acknowledged ICD can be returned test case is successful");
			}else{
				System.err.println("Verify if party acknowledged ICD can be returned test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test276_ReturnICd_AckByParty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Return ICD Acknowledge by party");
	}

	@Test  @Category(SanityTests.class)
	public void Test277_CheckReturnedICd_AckByParty() throws Exception{
		log.startTestCase("check Returned ICD Acknowledge by party");
		extentTest = extent.startTest("Test277_CheckReturnedICd_AckByParty",
				"Verify if returned party acknowledged ICd can be checked").assignCategory("ICDTestcases","SanityTests");
		try{
			setting.reqAckn_Check();
			store.approveGRN(276, "Sanity Test", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			 audit.checkICD(276, "Sanity Test", sGRNNo, "GRN");
			audit.acknowledgePartyICD(276, "Sanity Test", sGRNNo, "GRN");
			audit.returnICD(276, "Sanity Test", sGRNNo, "Party Acknowledged");
			boolean flag = audit.checkReturnedICD(276, "Sanity Test", sGRNNo);
			if(flag){
				Constant.log.info("Verify if returned party acknowledged ICd can be checked test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if returned party acknowledged ICd can be checked test case is successful");
			}else{
				System.err.println("Verify if returned party acknowledged ICd can be checked test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test277_CheckReturnedICd_AckByParty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("check Returned ICD Acknowledge by party");
	}

	@Test  @Category(SanityTests.class)
	public void Test278_PartyAckReturnedICD() throws Exception{
		log.startTestCase("PArty Acknowledge returned ICD");
		extentTest = extent.startTest("Test278_PartyAckReturnedICD",
				"Verify if returned party acknowledged ICd can be checked").assignCategory("ICDTestcases","SanityTests");
		try{
			setting.reqAckn_Check();
			store.approveGRN(277, "Sanity Test", null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			 audit.checkICD(277, "Sanity Test", sGRNNo, "GRN");
			audit.acknowledgePartyICD(277, "Sanity Test", sGRNNo, "GRN");
			audit.returnICD(277, "Sanity Test", sGRNNo, "Party Acknowledged");
			audit.checkReturnedICD(277, "Sanity Test", sGRNNo);
			boolean flag = audit.acknowledgePartyICD(277, "Sanity Test", sGRNNo, "GRN");
			if(flag){
				Constant.log.info("Verify if returned party acknowledged ICd can be checked test case is successful");
				extentTest.log(LogStatus.PASS, "Verify if returned party acknowledged ICd can be checked test case is successful");
			}else{
				System.err.println("Verify if returned party acknowledged ICd can be checked test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test278_PartyAckReturnedICD")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("PArty Acknowledge returned ICD");
	}

	@Test @Category(SanityTests.class)
	public void Test279_VerifyPartyAckICD() throws Exception{
		log.startTestCase("Verify Party acknowledged ICD");
		extentTest = extent.startTest("Test279_VerifyPartyAckICD",
				"Verify if Party acknowledged ICD is verified").assignCategory("ICDTestcases","SanityTests");
		try{
			setting.reqAckn_Check();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.icdVerify(null, "Party Acknowledged");
			if(flag){
				Constant.log.info("Party acknowledged ICD Verify is successful");
				extentTest.log(LogStatus.PASS, "Party acknowledged ICD Verify is successful");
			}else{
				System.err.println("Party acknowledged ICD Verify failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test279_VerifyPartyAckICD")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Verify Party acknowledged ICD");
	}

	@Test @Category(SanityTests.class)
	public void Test281_RejectICdByParty() throws Exception{
		log.startTestCase("Reject ICD By Party");
		extentTest = extent.startTest("Test281_RejectICdByParty",
				"Verify if ICD rejected by Party").assignCategory("ICDTestcases","SanityTests");
		try{
			setting.reqAckn_Check();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			boolean flag = audit.RejectPartyAck(null, "Party Acknowledgement Pending");
			if(flag){
				Constant.log.info("ICD rejected by Party test case is successful");
				extentTest.log(LogStatus.PASS, "ICD rejected by Party test case is successful");
			}else{
				System.err.println("ICD rejected by Party test case failed ");
				extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(Constant.captureScreen_Negative("Test281_RejectICdByParty")));
			}
			Assert.assertTrue(flag);
		}catch(Exception e){
			System.err.println(e);
			}
		log.endTestCase("Reject ICD By Party");
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
