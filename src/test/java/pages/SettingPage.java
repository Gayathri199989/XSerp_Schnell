package pages;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utility.Constant;
import utility.ExcelUtils;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

public class SettingPage {

	ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	LoginPage login = PageFactory.initElements(Constant.driver, LoginPage.class);
//	AccountsPage accounts = PageFactory.initElements(Constant.driver, AccountsPage.class);
//	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
//	AuditingPage audit = PageFactory.initElements(Constant.driver, AuditingPage.class);
//	PurchasePage purchase = PageFactory.initElements(Constant.driver, PurchasePage.class);
//	SalesPage sales = PageFactory.initElements(Constant.driver, SalesPage.class);
//	ProfilePage masters = PageFactory.initElements(Constant.driver, ProfilePage.class);
//	HRPage hr = PageFactory.initElements(Constant.driver, HRPage.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);

	@FindBy(xpath=".//span[@data-original-title='Create New User']/span")
	private WebElement addUserBtn;

	@FindBy(id="id_user-email")
	private WebElement userEmailField;

	@FindBy(id="id_user-password")
	private WebElement passwordField;

	@FindBy(id="id_user-first_name")
	private WebElement firstName;

	@FindBy(id="id_user-last_name")
	private WebElement lastName;

	@FindBy(id="id_user-username")
	private WebElement nickname;

	@FindBy(xpath="//div[7]//div[1]//div[1]//div[2]//span[1]")
	private WebElement addAllClaimHeads;

	@FindBy(xpath="//div[9]//div[1]//div[1]//div[2]//span[1]")
	private WebElement addAllExpenseHeads;

	@FindBy(xpath="//tr//td[3]//label")
	private List<WebElement> viewAccess;

	@FindBy(xpath="//tr//td[4]//label")
	private List<WebElement> editAccess;

	@FindBy(xpath="//tr//td[5]//label")
	private List<WebElement> approveAccess;

	@FindBy(xpath=".//label[text()='Is Super']")
	private WebElement isSuperCheckBx;

	@FindBy(xpath=".//a[contains(text(),'Save')]")
	private WebElement saveBtn;

	@FindBy(xpath=".//a[contains(text(),'Update')]")
	private WebElement updateBtn;

	@FindBy(xpath="//tr//td//input[@type='checkbox']")
	private List<WebElement> accessCheckboxList;

	@FindBy(xpath=".//*[@id='user_list']/tbody/tr/td[4]")
	private List<WebElement> emailList;

	@FindBy(id="filter_textbox")
	private WebElement filterText;

	@FindBy(xpath=".//strong[contains(text(),'User ID (Email) & Password does not match.')]")
	private WebElement invalidLoginWarning;

	@FindBy(xpath=".//font[contains(text(),'Mandate PO for all Purchase')]")
	private List<WebElement> mandatePO_configPg;

	@FindBy(xpath=".//span[contains(text(),'Request Acknowledgement')]")
	private List<WebElement> reqAckChckBx;

	@FindBy(xpath=".//font[contains(text(),'Blanket PO')]")
	private List<WebElement> blanketPOChckBx;

	@FindBy(xpath="//div[@class='row workflow-container editable-container']//button[contains(text(),'Save')]")
	private WebElement save_configModulePopup;

	@FindBy(id="btn-sa-confirm")
	private  WebElement yesActivate;

	@FindBy(xpath="//button[contains(@class,'enterprice-modal-close close')]")
	private WebElement configModulePopupClose;

	@FindBy(xpath=".//*[@id='user_list']/tbody/tr[1]/td[4]/a")
	private WebElement firstUser;

	@FindBy(xpath=".//input[@id='pdf_preview']/preceding::input[1]")
	private WebElement templateSaveBtn;

	@FindBy(xpath="//span[contains(text(),'Purchase Order Template')]/following::input[1]")
	private  WebElement poConfigSaveBtn;

	@FindBy(id="save_expense")
	private  WebElement expenseSaveBtn;

	@FindBy(xpath="//p[contains(text(),'Invoice Configuration has been modified successful')]")
	private WebElement invoiceConfigSaveMsg;

	@FindBy(xpath="//p[contains(text(),'Enterprise Expense Configuration updated successfu')]")
	private WebElement expenseSaveMsg;

	@FindBy(xpath="//p[contains(text(),'PO configration saved successfully')]")
	private WebElement poPrintConfigSaveMsg;

	@FindBy(id="save_sales")
	private WebElement seSaveBtn;

	@FindBy(xpath="//p[contains(text(),'Sales Estimate Template Configuration updated succ')]")
	private WebElement seConfigSaveMsg;

	@FindBy(xpath=".//li[2]/a[@id='a-change-pwd-menu']")
	private WebElement changePwdTab;

	@FindBy(id="id_old_password")
	private WebElement oldPwdTxtField;

	@FindBy(id="id_new_password")
	private WebElement newPwdTxtField;

	@FindBy(id="id_confirm_password")
	private WebElement confirmPwdTxtField;

	@FindBy(id="change_password")
	private WebElement changePwdBtn;

	@FindBy(xpath=".//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath=".//div[contains(text(),'Change Your Password')]")
	private WebElement changePwdPage;

	@FindBy(xpath=".//p[text()='Your Password has been changed successfully.']")
	private WebElement changePwdPopUp;

	private WebDriver driver;
	public SettingPage(WebDriver driver){
		this.driver = driver;
	}

	public boolean addUser(){
		boolean flag = false;
		int j=0;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load user view page");
			navigate.showAllEntries();
			int iList = emailList.size();
			String sEmail = "automation"+RandomStringUtils.randomAlphanumeric(4)+"@gmail.com";
			addUserBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			userEmailField.sendKeys(sEmail);
			passwordField.sendKeys("Password");
			firstName.sendKeys("Automation");
			lastName.sendKeys("Test");
			nickname.sendKeys("Qa"+RandomStringUtils.randomAlphanumeric(4));
			addAllClaimHeads.click();
			addAllExpenseHeads.click();
			isSuperCheckBx.click();
			for(WebElement ele: accessCheckboxList){
				if(ele.isSelected()){
					j++;
				}
			}
			if(j == 40){
				saveBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load user view page");
				navigate.showAllEntries();
				int iActList = emailList.size();
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].scrollIntoView(true);", emailList.get(iActList-1));
				if(iActList > iList && emailList.get(iActList-1).getText().equals(sEmail)){
					flag = true;
				}
			}

		}catch(Exception e){
			System.err.println("User creation failed "+e);
		}
		return flag;
	}

	public boolean userStatusChange(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sEmail = xls.get(iRowNo).get("Email");
		String sPassword = xls.get(iRowNo).get("Password");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load user view page");
			driver.findElement(By.xpath(".//td/form/a[contains(text(),'"+sEmail+"')]/following::td[1]/form/a/label/span")).click();
			driver.findElement(By.xpath(".//button[@class='confirm']")).click();
			Thread.sleep(Constant.Min_Sleep);
			driver.navigate().refresh();
			login.logout();
			login.userName.sendKeys(sEmail);
			login.password.sendKeys(sPassword);
			login.signIn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(invalidLoginWarning.isDisplayed()){
				login.login();
				navigate.navigateToSettings();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToUser();
				Thread.sleep(Constant.Min_Sleep);
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load user view page");
				driver.findElement(By.xpath(".//td/form/a[contains(text(),'"+sEmail+"')]/following::td[1]/form/a/label/span")).click();
				yesActivate.click();
				flag = true;
			}
		}catch(Exception e){
			System.err.println("User status change validation failed "+e);
		}
		return flag;
	}
	/*
	public boolean userWithOnlyEditAccess(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1, flag2, flag3, flag4, flag5,flag6,flag7,flag8;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sEmail = xls.get(iRowNo).get("Email");
		String sPassword = xls.get(iRowNo).get("Password");
		try{
			driver.findElement(By.xpath(".//a[contains(text(),'"+sEmail+"')]")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//label[text()='Is Super']/preceding::input[1]")).isSelected()){
				isSuperCheckBx.click();
			}else{
				isSuperCheckBx.click();
				isSuperCheckBx.click();
			}
			for(int i=0;i<editAccess.size();i++){
				editAccess.get(i).click();
			}
			updateBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			login.logout();
			login.userName.sendKeys(sEmail);
			login.password.sendKeys(sPassword);
			login.signIn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag1 = accountsEditAccessValidation(iRowNo, sheet);
			flag2 = auditingEditAccessValidation();
			flag3 = purchaseEditAccessValidation();
			flag4 = salesEditAccessValidation();
			flag5 = storeEditAccessValidation();
			flag6 = masterEditAccessValidation();
			flag7 = settingsEditAccessValidation();
			flag8 = hrEditAccessValidation();
			if(flag1 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true && flag7 == true && flag8 == true){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("validate user with only edit access failed "+e);
		}
		return flag;
	}

	public boolean accountsEditAccessValidation(int iRowNo, String sheet){
		boolean flag = false,flag4 = false, flag6 = false ;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToLedger();
			Thread.sleep(Constant.Min_Sleep);
			accounts.firstLedger.click();
			Thread.sleep(Constant.Min_Sleep);
			if(accounts.saveLedgerBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				accounts.cancelBtn_Ledger.click();
				accounts.addNewLedger.click();
				Thread.sleep(Constant.Min_Sleep);
				if(accounts.saveLedgerBtn.isDisplayed()){
					navigate.navigateToAccounts();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToVoucher();
					Thread.sleep(Constant.Min_Sleep);
					accounts.addVoucher.click();
					Thread.sleep(Constant.Min_Sleep);
					if(accounts.saveVoucherBtn.isDisplayed()){
						js.executeScript("window.scrollBy(0,-500)");
						accounts.backBtn_Voucher.click();
						accounts.firstVoucher.click();
						Thread.sleep(Constant.Min_Sleep);
						ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
						driver.switchTo().window(tabs2.get(1));
						if(accounts.editVoucherBtn.isDisplayed()){
							js.executeScript("window.scrollBy(0,-500)");
							accounts.editVoucherBtn.click();
							Thread.sleep(Constant.Min_Sleep);
							if(accounts.saveVoucherBtn.isDisplayed()){
								boolean flag2 = Constant.isElementPresent(By.id("approve_voucher_button"));
								if(flag2 == false){
									driver.close();
								    driver.switchTo().window(tabs2.get(0));
								    navigate.navigateToAccounts();
									Thread.sleep(Constant.Min_Sleep);
									navigate.navigateToBankReconciliation();
									Thread.sleep(Constant.Min_Sleep);
									accounts.brsLedger.click();
									accounts.firstLedger_BRS.click();
									Thread.sleep(Constant.Min_Sleep);
									accounts.loadStatement.click();
									if(accounts.saveReconcile.isDisplayed()){
										flag6 = true;
									}
									navigate.navigateToAccounts();
									Thread.sleep(Constant.Min_Sleep);
									navigate.navigateToProvisionalStatements();
									Thread.sleep(Constant.Min_Sleep);
									boolean flag1 = accounts.runTrialBal();
									navigate.navigateToAccounts();
									Thread.sleep(Constant.Min_Sleep);
									navigate.navigateToPurchaseReport();
									Thread.sleep(Constant.Min_Sleep);
									boolean flag3 = accounts.gstrPurchaseReportColumnValidation(iRowNo, sheet);
									navigate.navigateToAccounts();
									Thread.sleep(Constant.Min_Sleep);
									navigate.navigateToSalesReport();
									Thread.sleep(Constant.Min_Sleep);
									if(accounts.grnSalesReportView.isDisplayed()){
										flag4 = true;
									}
									Thread.sleep(Constant.Min_Sleep);
									navigate.navigateToAccounts();
									Thread.sleep(Constant.Min_Sleep);
									navigate.navigateToAccountDash();
									Thread.sleep(Constant.Min_Sleep);
									boolean flag5 = accounts.accountDashboardValidation();
									if(flag1 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true){
										flag = true;
									}
								}
							}

						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for accounts module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean auditingEditAccessValidation(){
		boolean flag = false, flag1 = false;
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			Thread.sleep(Constant.Min_Sleep);
			audit.noteBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(audit.saveBtn.isDisplayed()){
				audit.backBtn_Down.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				for(int i=0;i<audit.icdGRNList.size();i++){
					if(audit.icdGRNList.get(i).getText().contains("Pending")){
						if(audit.grnNoList.get(i).getText().contains("GRN")){
							audit.icdGRNList.get(i).click();
							Thread.sleep(Constant.Min_Sleep);
							break;
						}
					}
				}
				if(audit.checkedOkBtn.isDisplayed()){
					audit.backBtn_Down.click();
					Thread.sleep(Constant.Min_Sleep);
					driver.navigate().refresh();
					Thread.sleep(Constant.Min_Sleep);
					navigate.showAllEntries();
					for(int i=0;i<audit.icdGRNList.size();i++){
						if(audit.icdGRNList.get(i).getText().contains("Pending")){
							if(audit.grnNoList.get(i).getText().contains("IAN")){
								audit.icdGRNList.get(i).click();
								Thread.sleep(Constant.Min_Sleep);
								break;
							}
						}
					}
					if(audit.saveBtn.isDisplayed()){
						audit.backBtn_Down.click();
						Thread.sleep(Constant.Min_Sleep);
						navigate.showAllEntries();
						for(int i=0;i<audit.icdGRNList.size();i++){
							if(audit.icdGRNList.get(i).getText().contains("Checked")){
								if(audit.grnNoList.get(i).getText().contains("GRN")){
									audit.icdGRNList.get(i).click();
									Thread.sleep(Constant.Min_Sleep);
									break;
								}
							}
						}
						audit.viewNoteBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						if(!driver.getPageSource().contains("Verify")){
							audit.closeBtnPDf.click();
							Thread.sleep(Constant.Min_Sleep);
							navigate.showAllEntries();
							for(int i=0;i<audit.icdGRNList.size();i++){
								if(audit.icdGRNList.get(i).getText().contains("Checked")){
									if(audit.grnNoList.get(i).getText().contains("IAN")){
										audit.icdGRNList.get(i).click();
										Thread.sleep(Constant.Min_Sleep);
										break;
									}
								}
							}
							audit.viewNoteBtn.click();
							if(!driver.getPageSource().contains("Verify")){
								navigate.navigateToAuditing();
								Thread.sleep(Constant.Min_Sleep);
								navigate.navigateToExpense();
								Thread.sleep(Constant.Min_Sleep);
								audit.addBtnMyExpense.click();
								Thread.sleep(Constant.Min_Sleep);
								if(audit.confirmBtn.isDisplayed() && audit.expSaveBtn.isDisplayed()){
									audit.backBtn_Down.click();
									Thread.sleep(Constant.Min_Sleep);
									audit.otherExpensesTab.click();
									Thread.sleep(Constant.Min_Sleep);
									navigate.showAllEntries();
									for(int i=0;i<audit.expenseNoList_OtherExp.size();i++){
										if(audit.expenseStatusList_OtherExp.get(i).getText().contains("Confirmed")){
											flag1 = true;
											break;
										}
									}
									if(flag1 == false){
										for(int i=0;i<audit.expenseNoList_OtherExp.size();i++){
											if(audit.expenseStatusList_OtherExp.get(i).getText().contains("Approved")){
												audit.expenseStatusList_OtherExp.get(i).click();
												Thread.sleep(Constant.Min_Sleep);
												break;
											}
										}
										if(audit.checkedOKBtn.isDisplayed()){
											audit.backBtn_Down.click();
											Thread.sleep(Constant.Min_Sleep);
											audit.otherExpensesTab.click();
											Thread.sleep(Constant.Min_Sleep);
											navigate.showAllEntries();
											for(int i=1;i<audit.expenseNoList_OtherExp.size();i++){
												if(audit.expenseStatusList_OtherExp.get(i-1).getText().contains("Checked")){
													audit.expenseStatusList_OtherExp.get(i-1).click();
													Thread.sleep(Constant.Min_Sleep);
													break;
												}
											}
											boolean flag2 = Constant.isElementPresent(By.id("cmdverify"));
											if(flag2 == false){
												flag = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for auditing module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean purchaseEditAccessValidation(){
		boolean flag = false;
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			purchase.addPOBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(purchase.addPO.isDisplayed()){
				store.viewTab.click();
				Thread.sleep(Constant.Min_Sleep);
				purchase.firstPo.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean flag2 = Constant.isElementPresent(By.id("generate_pdf"));
				if(!driver.getPageSource().contains("Amend") && purchase.update.isDisplayed() && flag2 == false){
					navigate.navigateToPurchase_Header();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToPOWiseReports();
					Thread.sleep(Constant.Min_Sleep);
					if(purchase.viewReportBtn.isDisplayed()){
						navigate.navigateToPurchase_Header();
						Thread.sleep(Constant.Min_Sleep);
						navigate.navigateToMaterialWiseReports();
						Thread.sleep(Constant.Min_Sleep);
						if(purchase.viewReportBtn.isDisplayed()){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for purchase module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean salesEditAccessValidation(){
		boolean flag = false,flag4 = false, flag5 = false;
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			sales.addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(sales.save.isDisplayed()){
				sales.backBtn.click();
				for(int i=0;i<sales.status.size();i++){
					if(sales.status.get(i).getText().contains("Pending")){
						sales.status.get(i).click();
						break;
					}
				}
				boolean flag2 = Constant.isElementPresent(By.id("approve_invoice"));
				boolean flag3 = Constant.isElementPresent(By.id("reject_invoice"));
				navigate.navigateToSales();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToOA();
				Thread.sleep(Constant.Min_Sleep);
				sales.oaAddBtn.click();
				if(sales.oaSave.isDisplayed()){
					flag4 = true;
				}
				sales.oaCancelBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				for(int i=0;i<sales.oaList.size();i++){
					if(sales.oaList.get(i).getText().contains("DRAFT")){
						sales.oaList.get(i).click();
						break;
					}
				}
				navigate.navigateToSales();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToStatusReport();
				Thread.sleep(Constant.Min_Sleep);
				if(sales.viewReportBtn.isDisplayed()){
					navigate.navigateToSales();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToTaxReport();
					Thread.sleep(Constant.Min_Sleep);
					if(sales.viewReportBtn.isDisplayed()){
						navigate.navigateToSales();
						Thread.sleep(Constant.Min_Sleep);
						navigate.navigateToMaterialReport();
						Thread.sleep(Constant.Min_Sleep);
						if(sales.viewReportBtn.isDisplayed()){
							navigate.navigateToSales();
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToSalesReport();
							Thread.sleep(Constant.Min_Sleep);
							if(sales.salesViewReportBtn.isDisplayed()){
								navigate.navigateToSales();
								Thread.sleep(Constant.Min_Sleep);
								navigate.navigateToCustomReport();
								Thread.sleep(Constant.Min_Sleep);
								if(sales.viewCustomReport.isDisplayed()){
									flag5 = true;
								}
								if(flag2 == false &&  flag3 == false && flag4 == true && flag5 == true){
									flag = true;
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for sales module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean storeEditAccessValidation(){
		boolean flag = false;
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			Thread.sleep(Constant.Min_Sleep);
			store.addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(store.issueSaveBtn.isDisplayed()){
				sales.backBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				store.firstIssueOrIssueNo.click();
				Thread.sleep(Constant.Min_Sleep);
				if(store.issueSaveBtn.isDisplayed()){
					navigate.navigateToStore();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToIndent();
					Thread.sleep(Constant.Min_Sleep);
					store.addIndentIcon.click();
					Thread.sleep(Constant.Min_Sleep);
					if(store.saveIndent.isDisplayed()){
						store.backButton.click();
						Thread.sleep(Constant.Min_Sleep);
						store.firstIssueOrIssueNo.click();
						Thread.sleep(Constant.Min_Sleep);
						if(store.saveIndent.isDisplayed()){
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToStore();
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToGRN();
							Thread.sleep(Constant.Min_Sleep);
							addUserBtn.click();
							Thread.sleep(Constant.Min_Sleep);
							if(store.addBtn.isDisplayed()){
								store.issueCancelBtn.click();
								Thread.sleep(Constant.Min_Sleep);
								for(int i=0;i<store.grnList.size();i++){
									if(store.grnList.get(i).getText().contains("GRN")){
										store.grnList.get(i).click();
										Thread.sleep(Constant.Min_Sleep);
										break;
									}
								}
								boolean flag2 = Constant.isElementPresent(By.id("view_receipt"));
								if(flag2 == false){
									store.backBtn.click();
									Thread.sleep(Constant.Min_Sleep);
									for(int i=0;i<store.grnList.size();i++){
										if(!store.grnList.get(i).getText().contains("GRN")){
											store.grnList.get(i).click();
											Thread.sleep(Constant.Min_Sleep);
											break;
										}
									}
									boolean flag3 = Constant.isElementPresent(By.id("view_receipt"));
									if(store.UpdateBtn.isDisplayed() && flag3 == false){
										navigate.navigateToStore();
										Thread.sleep(Constant.Min_Sleep);
										navigate.navigateToDeliveryChallan();
										Thread.sleep(Constant.Min_Sleep);
										sales.addIcon.click();
										Thread.sleep(Constant.Min_Sleep);
										JavascriptExecutor js = (JavascriptExecutor) driver;
										js.executeScript("window.scrollBy(0,1000)");
										if(sales.save.isDisplayed()){
											js.executeScript("window.scrollBy(0, -1000)");
											sales.backBtn.click();
											Thread.sleep(Constant.Min_Sleep);
											for(int i=0;i<sales.status.size();i++){
												if(sales.status.get(i).getText().contains("Pending")){
													sales.status.get(i).click();
													Thread.sleep(Constant.Min_Sleep);
													break;
												}
											}
											boolean flag1 = Constant.isElementPresent(By.id("approve_invoice"));
											boolean flag4 = Constant.isElementPresent(By.id("reject_invoice"));
											if(flag1 == false && flag4 == false){
												navigate.navigateToStore();
												Thread.sleep(Constant.Min_Sleep);
												navigate.navigateToStockReport();
												Thread.sleep(Constant.Min_Sleep);
												if(store.reportView.isDisplayed()){
													navigate.navigateToStore();
													Thread.sleep(Constant.Min_Sleep);
													navigate.navigateToGRNReport();
													Thread.sleep(Constant.Min_Sleep);
													if(store.grnReportView.isDisplayed()){
														Thread.sleep(Constant.Min_Sleep);
														navigate.navigateToStore();
														Thread.sleep(Constant.Min_Sleep);
														navigate.navigateToDCReport();
														Thread.sleep(Constant.Min_Sleep);
														if(store.dcReportView.isDisplayed()){
															Thread.sleep(Constant.Min_Sleep);
															navigate.navigateToStore();
															Thread.sleep(Constant.Min_Sleep);
															navigate.navigateToMaterialReceiptReport();
															Thread.sleep(Constant.Min_Sleep);
															if(store.materialReportViewReportBtn.isDisplayed()){
																Thread.sleep(Constant.Min_Sleep);
																navigate.navigateToStore();
																Thread.sleep(Constant.Min_Sleep);
																navigate.navigateToShortageListReport();
																Thread.sleep(Constant.Min_Sleep);
																store.materialListBtn.click();
																Thread.sleep(Constant.Min_Sleep);
																js.executeScript("arguments[0].scrollIntoView();", store.ViewReportBtn);
																Thread.sleep(Constant.Min_Sleep);
																if(store.ViewReportBtn.isDisplayed()){
																	flag = true;
																	driver.navigate().refresh();
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for store module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean masterEditAccessValidation(){
		boolean flag = false;
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			masters.addPartyBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(masters.partySave.isDisplayed()){
				masters.partyCancel.click();
				Thread.sleep(Constant.Min_Sleep);
				masters.firstParty.click();
				Thread.sleep(Constant.Min_Sleep);
				if(masters.update.isDisplayed()){
					masters.partyCancel.click();
					Thread.sleep(Constant.Min_Sleep);
					masters.importParty.click();
					Thread.sleep(Constant.Min_Sleep);
					if(masters.upload.isDisplayed()){
						masters.importCancel.click();
						Thread.sleep(Constant.Min_Sleep);
						navigate.navigateToMasters();
						Thread.sleep(Constant.Min_Sleep);
						navigate.navigateToMaterial();
						Thread.sleep(Constant.Min_Sleep);
						masters.addMaterial.click();
						Thread.sleep(Constant.Min_Sleep);
						if(masters.saveMaterialBtn.isDisplayed()){
							masters.cancelMaterial.click();
							Thread.sleep(Constant.Min_Sleep);
							masters.firstMaterial.click();
							Thread.sleep(Constant.Medium_Sleep);
							ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
						    driver.switchTo().window(tabs2.get(1));
						    Thread.sleep(Constant.Min_Sleep);
						    if(masters.saveMaterialBtn.isDisplayed()){
							    driver.close();
							    driver.switchTo().window(tabs2.get(0));
							    navigate.navigateToMasters();
								Thread.sleep(Constant.Min_Sleep);
							    navigate.navigateToTax();
							    Thread.sleep(Constant.Min_Sleep);
							    masters.addTax.click();
							    Thread.sleep(Constant.Min_Sleep);
								if(masters.saveTaxBtn.isDisplayed()){
									masters.backBtn.click();
									Thread.sleep(Constant.Min_Sleep);
									masters.firstTax.click();
									Thread.sleep(Constant.Min_Sleep);
									if(masters.saveTaxBtn.isDisplayed()){
										flag = true;
									}
								}
						    }
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for master module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean hrEditAccessValidation(){
		boolean flag = false;
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			hr.employeeAddBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(hr.empSave.isDisplayed()){
				hr.cancelBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				hr.firstEmployee.click();
				Thread.sleep(Constant.Min_Sleep);
				if(hr.empSave.isDisplayed()){
					navigate.navigateToHR();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToPayStructure();
					Thread.sleep(Constant.Min_Sleep);
					hr.payStructureAddTab.click();
					Thread.sleep(Constant.Min_Sleep);
					if(hr.savePayBtn.isDisplayed()){
						hr.cancelPayBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						hr.firstPayStruct.click();
						Thread.sleep(Constant.Min_Sleep);
						if(hr.savePayBtn.isDisplayed()){
							navigate.navigateToHR();
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToAttendance();
							Thread.sleep(Constant.Min_Sleep);
							if(hr.importAttendace.isDisplayed()){
								hr.importAttendace.click();
								Thread.sleep(Constant.Min_Sleep);
								if(hr.uploadImportAttendance.isDisplayed()){
									hr.cancelUpload.click();
									flag = true;
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for HR module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean settingsEditAccessValidation(){
		boolean flag = false;
		try{
			navigate.navigateToProfile();
			if(saveEnterprise.isDisplayed()){
				navigate.navigateToSettings();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToUser();
				Thread.sleep(Constant.Min_Sleep);
				addUserBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(saveBtn.isDisplayed()){
					store.viewTab.click();
					Thread.sleep(Constant.Min_Sleep);
					firstUser.click();
					Thread.sleep(Constant.Min_Sleep);
					if(updateBtn.isDisplayed()){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for master module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean userWithOnlyViewAccess(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1, flag2, flag3, flag4, flag5,flag6,flag7,flag8;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sEmail = xls.get(iRowNo).get("Email");
		String sPassword = xls.get(iRowNo).get("Password");
		try{
			driver.findElement(By.xpath(".//td/a[contains(text(),'"+sEmail+"')]")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(isSuperCheckBx.isSelected()){
				isSuperCheckBx.click();
			}else{
				isSuperCheckBx.click();
				isSuperCheckBx.click();
			}
			for(int i=0;i<viewAccess.size();i++){
				viewAccess.get(i).click();
			}
			updateBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			login.logout();
			login.userName.sendKeys(sEmail);
			login.password.sendKeys(sPassword);
			login.signIn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag1 = accountsViewAccessValidation(iRowNo, sheet);
			flag2 = auditingViewAccessValidation();
			flag3 = purchaseViewAccessValidation();
			flag4 = salesViewAccessValidation();
			flag5 = storeViewAccessValidation();
			flag6 = masterViewAccessValidation();
			flag7 = settingsViewAccessValidation();
			flag8 = hrViewAccessValidation();
			if(flag1 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true && flag7 == true && flag8 == true){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("validate user with only edit access failed "+e);
		}
		return flag;
	}

	public boolean accountsViewAccessValidation(int iRowNo, String sheet){
		boolean flag = false, flag7 = false,flag9 = false;
		try{
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToLedger();
			Thread.sleep(Constant.Min_Sleep);
			accounts.firstLedger.click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = Constant.isElementPresent(By.id("saveLedger"));
			if(flag1 == false){
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-1000)");
				accounts.cancelBtn_Ledger.click();
				Thread.sleep(Constant.Min_Sleep);
				accounts.addNewLedger.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean flag2 = Constant.isElementPresent(By.id("saveLedger"));
				if(flag2 == false){
					navigate.navigateToAccounts();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToVoucher();
					Thread.sleep(Constant.Min_Sleep);
					accounts.addVoucher.click();
					Thread.sleep(Constant.Min_Sleep);
					boolean flag3 = Constant.isElementPresent(By.id("save_voucher_button"));
					if(flag3 == false){
						accounts.cancelBtn_Ledger.click();
						Thread.sleep(Constant.Min_Sleep);
						accounts.firstVoucher.click();
						Thread.sleep(Constant.Min_Sleep);
						ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
					    driver.switchTo().window(tabs2.get(1));
						boolean flag4 = Constant.isElementPresent(By.id("enable_edit_voucher"));
						if(flag4 == false){
							driver.close();
						    driver.switchTo().window(tabs2.get(0));
						    navigate.navigateToAccounts();
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToBankReconciliation();
							Thread.sleep(Constant.Min_Sleep);
							if(!accounts.saveReconcile.isDisplayed()){
								flag9 = true;
							}
							navigate.navigateToAccounts();
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToProvisionalStatements();
							Thread.sleep(Constant.Min_Sleep);
							boolean flag5 = accounts.runTrialBal();
							navigate.navigateToAccounts();
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToPurchaseReport();
							Thread.sleep(Constant.Min_Sleep);
							boolean flag6 = accounts.gstrPurchaseReportColumnValidation(iRowNo, sheet);
							navigate.navigateToAccounts();
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToSalesReport();
							Thread.sleep(Constant.Min_Sleep);
							if(accounts.grnSalesReportView.isDisplayed()){
								flag7 = true;
							}
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToAccounts();
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToAccountDash();
							Thread.sleep(Constant.Min_Sleep);
							boolean flag8 = accounts.accountDashboardValidation();
							if(flag5 == true && flag6 == true && flag7 == true && flag8 == true && flag9 == true){
								flag = true;
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for accounts module with only view access failed "+e);
		}
		return flag;
	}

	public boolean auditingViewAccessValidation(){
		boolean flag = false;
		try{
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			Thread.sleep(Constant.Min_Sleep);
			audit.noteBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = Constant.isElementPresent(By.id("cmdSave"));
			if(flag1 == false){
				audit.backBtn_Down.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				for(int i=0;i<audit.icdGRNList.size();i++){
					if(audit.icdGRNList.get(i).getText().contains("Pending")){
						if(audit.grnNoList.get(i).getText().contains("GRN")){
							audit.icdGRNList.get(i).click();
							Thread.sleep(Constant.Min_Sleep);
							break;
						}
					}
				}
				boolean flag2 = Constant.isElementPresent(By.id("cmdupdate"));
				if(flag2 == false){
					audit.backBtn_Down.click();
					Thread.sleep(Constant.Min_Sleep);
					driver.navigate().refresh();
					Thread.sleep(Constant.Min_Sleep);
					navigate.showAllEntries();
					for(int i=0;i<audit.icdGRNList.size();i++){
						if(audit.icdGRNList.get(i).getText().contains("Pending")){
							if(audit.grnNoList.get(i).getText().contains("IAN")){
								audit.icdGRNList.get(i).click();
								Thread.sleep(Constant.Min_Sleep);
								break;
							}
						}
					}
					boolean flag3 = Constant.isElementPresent(By.id("cmdSave"));
					if(flag3 == false){
						audit.backBtn_Down.click();
						Thread.sleep(Constant.Min_Sleep);
						driver.navigate().refresh();
						Thread.sleep(Constant.Min_Sleep);
						navigate.showAllEntries();
						for(int i=0;i<audit.icdGRNList.size();i++){
							if(audit.icdGRNList.get(i).getText().contains("Checked")){
								if(audit.grnNoList.get(i).getText().contains("GRN")){
									audit.icdGRNList.get(i).click();
									Thread.sleep(Constant.Min_Sleep);
									break;
								}
							}
						}
						audit.viewNoteBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						if(!driver.getPageSource().contains("Verify")){
							audit.closeBtnPDf.click();
							Thread.sleep(Constant.Min_Sleep);
							driver.navigate().refresh();
							Thread.sleep(Constant.Min_Sleep);
							navigate.showAllEntries();
							for(int i=0;i<audit.icdGRNList.size();i++){
								if(audit.icdGRNList.get(i).getText().contains("Checked")){
									if(audit.grnNoList.get(i).getText().contains("IAN")){
										audit.icdGRNList.get(i).click();
										Thread.sleep(Constant.Min_Sleep);
										break;
									}
								}
							}
							audit.viewNoteBtn.click();
							Thread.sleep(Constant.Min_Sleep);
							if(!driver.getPageSource().contains("Verify")){
								navigate.navigateToAuditing();
								Thread.sleep(Constant.Min_Sleep);
								navigate.navigateToExpense();
								Thread.sleep(Constant.Min_Sleep);
								audit.addBtnMyExpense.click();
								Thread.sleep(Constant.Min_Sleep);
								boolean flag4 = Constant.isElementPresent(By.id("cmd_exp_confirm"));
								boolean flag5 = Constant.isElementPresent(By.id("cmd_exp_save"));
								boolean flag6 = Constant.isElementPresent(By.xpath(".//a[text()='OTHER EXPENSES']"));
								if(flag4 == false && flag5 == false && flag6 == false){
									flag = true;
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for auditing module with only VIEW access failed "+e);
		}
		return flag;
	}

	public boolean purchaseViewAccessValidation(){
		boolean flag = false;
		try{
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			addUserBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = Constant.isElementPresent(By.id("cmdSave"));
			if(flag1 == false){
				store.viewTab.click();
				Thread.sleep(Constant.Min_Sleep);
				purchase.firstPo.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean flag2 = Constant.isElementPresent(By.id("cmdupdate"));
				if(!driver.getPageSource().contains("Amend") && flag2 == false){
					navigate.navigateToPurchase_Header();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToPOWiseReports();
					Thread.sleep(Constant.Min_Sleep);
					if(purchase.viewReportBtn.isDisplayed()){
						navigate.navigateToPurchase_Header();
						Thread.sleep(Constant.Min_Sleep);
						navigate.navigateToMaterialWiseReports();
						Thread.sleep(Constant.Min_Sleep);
						if(purchase.viewReportBtn.isDisplayed()){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for purchase module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean salesViewAccessValidation(){
		boolean flag = false;
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			addUserBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = Constant.isElementPresent(By.id("cmdSave"));
			if(flag1 == false){
				store.viewTab.click();
				for(int i=0;i<sales.status.size();i++){
					if(sales.status.get(i).getText().contains("Pending")){
						sales.status.get(i).click();
						break;
					}
				}
				if(Constant.isAlertPresents() == true){
					String sAlert = driver.switchTo().alert().getText();
					if(sAlert.contains("You dont have sufficient permission to Process this Invoice")){
						driver.switchTo().alert().accept();
						navigate.navigateToSales();
						Thread.sleep(Constant.Min_Sleep);
						navigate.navigateToStatusReport();
						Thread.sleep(Constant.Min_Sleep);
						if(sales.viewReportBtn.isDisplayed()){
							navigate.navigateToSales();
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToTaxReport();
							Thread.sleep(Constant.Min_Sleep);
							if(sales.viewReportBtn.isDisplayed()){
								navigate.navigateToSales();
								Thread.sleep(Constant.Min_Sleep);
								navigate.navigateToMaterialReport();
								Thread.sleep(Constant.Min_Sleep);
								if(sales.viewReportBtn.isDisplayed()){
									navigate.navigateToSales();
									Thread.sleep(Constant.Min_Sleep);
									navigate.navigateToSalesReport();
									Thread.sleep(Constant.Min_Sleep);
									if(sales.salesViewReportBtn.isDisplayed()){
										navigate.navigateToSales();
										Thread.sleep(Constant.Min_Sleep);
										navigate.navigateToCustomReport();
										Thread.sleep(Constant.Min_Sleep);
										if(sales.viewCustomReport.isDisplayed()){
											flag = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for sales module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean storeViewAccessValidation(){
		boolean flag = false;
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			Thread.sleep(Constant.Min_Sleep);
			addUserBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = Constant.isElementPresent(By.id("cmdSave"));
			if(flag1 == false){
				store.viewTab.click();
				Thread.sleep(Constant.Min_Sleep);
				store.firstIssueOrIssueNo.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean flag2 = Constant.isElementPresent(By.id("cmdupdate"));
				if(flag2 == false){
					navigate.navigateToStore();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToIndent();
					Thread.sleep(Constant.Min_Sleep);
					addUserBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					boolean flag3 = Constant.isElementPresent(By.id("save_indent_button"));
					if(flag3 == false){
						store.viewTab.click();
						Thread.sleep(Constant.Min_Sleep);
						store.firstIssueOrIssueNo.click();
						Thread.sleep(Constant.Min_Sleep);
						boolean flag4 = Constant.isElementPresent(By.id("save_indent_button"));
						if(flag4 == false){
							navigate.navigateToStore();
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToGRN();
							Thread.sleep(Constant.Min_Sleep);
							addUserBtn.click();
							Thread.sleep(Constant.Min_Sleep);
							boolean flag5 = Constant.isElementPresent(By.id("cmdSave"));
							if(flag5 == false){
								store.issueCancelBtn.click();
								Thread.sleep(Constant.Min_Sleep);
								for(int i=0;i<store.grnList.size();i++){
									if(store.grnList.get(i).getText().contains("GRN")){
										store.grnList.get(i).click();
										Thread.sleep(Constant.Min_Sleep);
										break;
									}
								}
								boolean flag6 = Constant.isElementPresent(By.id("view_receipt"));
								if(flag6 == false){
									store.viewTab.click();
									Thread.sleep(Constant.Min_Sleep);
									for(int i=0;i<store.grnList.size();i++){
										if(!store.grnList.get(i).getText().contains("GRN")){
											store.grnList.get(i).click();
											Thread.sleep(Constant.Min_Sleep);
											break;
										}
									}
									boolean flag7 = Constant.isElementPresent(By.id("view_receipt"));
									boolean flag10 = Constant.isElementPresent(By.id("cmdupdate"));
									if(flag10 == false && flag7 == false){
										navigate.navigateToStore();
										Thread.sleep(Constant.Min_Sleep);
										navigate.navigateToDeliveryChallan();
										Thread.sleep(Constant.Min_Sleep);
										addUserBtn.click();
										Thread.sleep(Constant.Min_Sleep);
										boolean flag11 = Constant.isElementPresent(By.id("cmdSave"));
										if(flag11 == false){
											store.viewTab.click();
											Thread.sleep(Constant.Min_Sleep);
											for(int i=0;i<sales.status.size();i++){
												if(sales.status.get(i).getText().contains("Pending")){
													sales.status.get(i).click();
													Thread.sleep(Constant.Min_Sleep);
													break;
												}
											}
											if(Constant.isAlertPresents() == true){
												String sAlert = driver.switchTo().alert().getText();
												if(sAlert.contains("You dont have sufficient permission to Process this Invoice")){
													driver.switchTo().alert().accept();
													navigate.navigateToStore();
													Thread.sleep(Constant.Min_Sleep);
													navigate.navigateToStockReport();
													Thread.sleep(Constant.Min_Sleep);
													if(store.reportView.isDisplayed()){
														Thread.sleep(Constant.Min_Sleep);
														navigate.navigateToStore();
														Thread.sleep(Constant.Min_Sleep);
														navigate.navigateToGRNReport();
														Thread.sleep(Constant.Min_Sleep);
														if(store.grnReportView.isDisplayed()){
															Thread.sleep(Constant.Min_Sleep);
															navigate.navigateToStore();
															Thread.sleep(Constant.Min_Sleep);
															navigate.navigateToDCReport();
															Thread.sleep(Constant.Min_Sleep);
															if(store.dcReportView.isDisplayed()){
																Thread.sleep(Constant.Min_Sleep);
																navigate.navigateToStore();
																Thread.sleep(Constant.Min_Sleep);
																navigate.navigateToMaterialReceiptReport();
																Thread.sleep(Constant.Min_Sleep);
																if(store.materialReportViewReportBtn.isDisplayed()){
																	Thread.sleep(Constant.Min_Sleep);
																	navigate.navigateToStore();
																	Thread.sleep(Constant.Min_Sleep);
																	navigate.navigateToShortageListReport();
																	Thread.sleep(Constant.Min_Sleep);
																	store.materialListBtn.click();
																	Thread.sleep(Constant.Min_Sleep);
																	if(store.ViewReportBtn.isDisplayed()){
																		driver.navigate().refresh();
																		flag = true;
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for store module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean masterViewAccessValidation(){
		boolean flag = false;
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = Constant.isElementPresent(By.id(".//a[text()='Add Party']"));
			if(flag1 == false){
				masters.firstParty.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean flag2 = Constant.isElementPresent(By.id("cmdupdate"));
				if(flag2 == false){
					masters.partyCancel.click();
					Thread.sleep(Constant.Min_Sleep);
					boolean flag3 = Constant.isElementPresent(By.xpath(".//a[text()='Import Party Details']"));
					if(flag3 == false){
						navigate.navigateToMasters();
						Thread.sleep(Constant.Min_Sleep);
						navigate.navigateToMaterial();
						Thread.sleep(Constant.Min_Sleep);
						boolean flag4 = Constant.isElementPresent(By.id(".//a[text()='Add Materials']"));
						if(flag4 == false){
							masters.firstMaterial.click();
							Thread.sleep(Constant.Min_Sleep);
							ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
						    driver.switchTo().window(tabs2.get(1));
						    boolean flag5 = Constant.isElementPresent(By.id("saveCatalogueButton"));
							if(flag5 == false){
							    driver.close();
							    driver.switchTo().window(tabs2.get(0));
							    navigate.navigateToMasters();
								Thread.sleep(Constant.Min_Sleep);
							    navigate.navigateToTax();
							    Thread.sleep(Constant.Min_Sleep);
							    addUserBtn.click();
							    Thread.sleep(Constant.Min_Sleep);
							    boolean flag6 = Constant.isElementPresent(By.id("save_tax_button"));
								if(flag6 == false){
									store.viewTab.click();
									Thread.sleep(Constant.Min_Sleep);
									masters.firstTax.click();
									Thread.sleep(Constant.Min_Sleep);
									boolean flag7 = Constant.isElementPresent(By.id("save_tax_button"));
									if(flag7 == false){
										flag = true;
									}
								}
						    }
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for master module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean hrViewAccessValidation(){
		boolean flag = false;
		try{
			navigate.navigateToHR();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToEmployees();
			Thread.sleep(Constant.Min_Sleep);
			hr.employeeAddBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = Constant.isElementPresent(By.id("saveEmployee"));
			if(flag1 == false){
				hr.cancelBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				hr.firstEmployee.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean flag2 = Constant.isElementPresent(By.id("saveEmployee"));
				if(flag2 == false){
					navigate.navigateToHR();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToPayStructure();
					Thread.sleep(Constant.Min_Sleep);
					hr.payStructureAddTab.click();
					Thread.sleep(Constant.Min_Sleep);
					boolean flag3 = Constant.isElementPresent(By.id("save_pay_button"));
					if(flag3 == false){
						hr.cancelPayBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						hr.firstPayStruct.click();
						Thread.sleep(Constant.Min_Sleep);
						boolean flag4 = Constant.isElementPresent(By.id("save_pay_button"));
						if(flag4 == false){
							navigate.navigateToHR();
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToAttendance();
							Thread.sleep(Constant.Min_Sleep);
							boolean flag5 = Constant.isElementPresent(By.xpath(".//a[text()='Import Attendance Details']"));
							if(flag5 == false){
								flag = true;
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for HR module with only edit access failed "+e);
		}
		return flag;
	}

	public boolean settingsViewAccessValidation(){
		boolean flag = false;
		try{
			navigate.navigateToProfile();
			boolean flag1 = Constant.isElementPresent(By.id("save_enterprise"));
			if(flag1 == false){
				navigate.navigateToSettings();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToUser();
				Thread.sleep(Constant.Min_Sleep);
				addUserBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean flag2 = Constant.isElementPresent(By.xpath(".//a[contains(text(),'Save')]"));
				if(flag2 == false){
					store.viewTab.click();
					Thread.sleep(Constant.Min_Sleep);
					firstUser.click();
					Thread.sleep(Constant.Min_Sleep);
					boolean flag3 = Constant.isElementPresent(By.xpath(".//a[contains(text(),'Update')]"));
					if(flag3 == false){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("validation for master module with only edit access failed "+e);
		}
		return flag;
	}
	*/
	public boolean changePwd(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sEmail = xls.get(iRowNo).get("Email");
		String sPassword = xls.get(iRowNo).get("Password");
		try{
			login.logout();
			Thread.sleep(Constant.Min_Sleep);
			login.userName.sendKeys(sEmail);
			Thread.sleep(Constant.Min_Sleep);
			login.password.sendKeys(sPassword);
			Thread.sleep(Constant.Min_Sleep);
			login.signIn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(login.accountsModule), "Element not loaded");
			Constant.waitForPageLoad();
			if(login.accountsModule.isDisplayed()){
				Constant.waitFor(ExpectedConditions.elementToBeClickable(login.skipBtn), "Element not loaded");
				Thread.sleep(Constant.Min_Sleep);
				if(login.skipBtn.isDisplayed()){
					login.skipBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(login.profileImg), "Element not loaded");
			login.profileImg.click();
			changePwdTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(changePwdPage.isDisplayed()){
				oldPwdTxtField.sendKeys(sPassword);
				newPwdTxtField.sendKeys("testAutomation");
				confirmPwdTxtField.sendKeys("testAutomation");
				changePwdBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Element not loaded");
				Thread.sleep(Constant.Min_Sleep);
				if(changePwdPopUp.isDisplayed()){
					okBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(login.userName), "Element not loaded");
					Thread.sleep(Constant.Min_Sleep);
					if(login.userName.isDisplayed()){
						login.userName.sendKeys(sEmail);
						login.password.sendKeys("testAutomation");
						login.signIn.click();
						Thread.sleep(Constant.Min_Sleep);
						Constant.waitFor(ExpectedConditions.elementToBeClickable(login.accountsModule), "Element not loaded");
						if(login.accountsModule.isDisplayed()){
							flag = true;
							login.profileImg.click();
							changePwdTab.click();
							Thread.sleep(Constant.Min_Sleep);
							oldPwdTxtField.sendKeys("testAutomation");
							newPwdTxtField.sendKeys(sPassword);
							confirmPwdTxtField.sendKeys(sPassword);
							changePwdBtn.click();
							Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Element not loaded");
							Constant.waitForPageLoad();
							if(changePwdPopUp.isDisplayed()){
								Thread.sleep(Constant.Min_Sleep);
								okBtn.click();
								if(login.userName.isDisplayed()){
									login.login();
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to change password "+e);
		}
		return flag;
	}

	public void purchaseMandatoryChkBx_Check(){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			mandatePO_configPg.get(0).click();
			Thread.sleep(Constant.Medium_Sleep);
			if(Constant.isElementPresent(By.xpath(".//*[@id='mandate_po'] [contains(@class,'item-disabled')]"))){
				js.executeScript("arguments[0].scrollIntoView(true);", save_configModulePopup);
				Thread.sleep(Constant.Min_Sleep);
				mandatePO_configPg.get(1).click();
				Thread.sleep(Constant.Min_Sleep);
				save_configModulePopup.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(yesActivate), "Failed to load enterprice success popup");
				Thread.sleep(Constant.Min_Sleep);
				yesActivate.click();
				Thread.sleep(Constant.Min_Sleep);
			}else{
				configModulePopupClose.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to check purchase order mandatory checkbox "+e);
		}
	}

	public void purchaseMandatoryChkBx_UnCheck(){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			mandatePO_configPg.get(0).click();
			Thread.sleep(Constant.Medium_Sleep);
			if(!Constant.isElementPresent(By.xpath(".//*[@id='mandate_po'] [contains(@class,'item-disabled')]"))){
				js.executeScript("arguments[0].scrollIntoView(true);", save_configModulePopup);
				Thread.sleep(Constant.Min_Sleep);
				mandatePO_configPg.get(1).click();
				Thread.sleep(Constant.Min_Sleep);
				save_configModulePopup.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(yesActivate), "Failed to load enterprice success popup");
				Thread.sleep(Constant.Min_Sleep);
				yesActivate.click();
				Thread.sleep(Constant.Min_Sleep);
			}else{
				configModulePopupClose.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to uncheck purchase order mandatory checkbox "+e);
		}
	}

	public void reqAckn_Check(){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			reqAckChckBx.get(0).click();
			Thread.sleep(Constant.Medium_Sleep);
			if(Constant.isElementPresent(By.xpath(".//*[@id='request_ack'] [contains(@class,'item-disabled')]"))){
				js.executeScript("arguments[0].scrollIntoView(true);", save_configModulePopup);
				Thread.sleep(Constant.Min_Sleep);
				reqAckChckBx.get(1).click();
				Thread.sleep(Constant.Min_Sleep);
				save_configModulePopup.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(yesActivate), "Failed to load enterprice success popup");
				Thread.sleep(Constant.Min_Sleep);
				yesActivate.click();
				Thread.sleep(Constant.Min_Sleep);
			}else{
				configModulePopupClose.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to check request Acknowledgement checkbox "+e);
		}
	}

	public void reqAckn_UnCheck(){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			reqAckChckBx.get(0).click();
			Thread.sleep(Constant.Medium_Sleep);
			if(!Constant.isElementPresent(By.xpath(".//*[@id='request_ack'] [contains(@class,'item-disabled')]"))){
				js.executeScript("arguments[0].scrollIntoView(true);", save_configModulePopup);
				Thread.sleep(Constant.Min_Sleep);
				reqAckChckBx.get(1).click();
				Thread.sleep(Constant.Min_Sleep);
				save_configModulePopup.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(yesActivate), "Failed to load enterprice success popup");
				Thread.sleep(Constant.Min_Sleep);
				yesActivate.click();
				Thread.sleep(Constant.Min_Sleep);
			}else{
				configModulePopupClose.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to uncheck request Acknowledgement checkbox "+e);
		}
	}

	public void blanketPO_Check(){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			blanketPOChckBx.get(0).click();
			Thread.sleep(Constant.Medium_Sleep);
			if(Constant.isElementPresent(By.xpath(".//*[@id='blanket_po'] [contains(@class,'item-disabled')]"))){
				js.executeScript("arguments[0].scrollIntoView(true);", save_configModulePopup);
				Thread.sleep(Constant.Min_Sleep);
				blanketPOChckBx.get(1).click();
				Thread.sleep(Constant.Min_Sleep);
				save_configModulePopup.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(yesActivate), "Failed to load enterprice success popup");
				Thread.sleep(Constant.Min_Sleep);
				yesActivate.click();
				Thread.sleep(Constant.Min_Sleep);
			}else{
				configModulePopupClose.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to check blanket PO checkbox "+e);
		}
	}

	public void blanketPO_UnCheck(){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			blanketPOChckBx.get(0).click();
			Thread.sleep(Constant.Medium_Sleep);
			if(!Constant.isElementPresent(By.xpath(".//*[@id='blanket_po'] [contains(@class,'item-disabled')]"))){
				js.executeScript("arguments[0].scrollIntoView(true);", save_configModulePopup);
				Thread.sleep(Constant.Min_Sleep);
				blanketPOChckBx.get(1).click();
				Thread.sleep(Constant.Min_Sleep);
				save_configModulePopup.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(yesActivate), "Failed to load enterprice success popup");
				Thread.sleep(Constant.Min_Sleep);
				yesActivate.click();
				Thread.sleep(Constant.Min_Sleep);
			}else{
				configModulePopupClose.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to uncheck blanket checkbox "+e);
		}
	}

	public boolean invoiceTemplateSave(){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(templateSaveBtn), "Failed to load invoice template");
			templateSaveBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(invoiceConfigSaveMsg.isDisplayed()){
				yesActivate.click();
				Thread.sleep(Constant.Min_Sleep);
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to save invoice template "+e);
		}
		return flag;
	}

	public boolean expenseConfigSave(){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(expenseSaveBtn), "Failed to load expense config popup");
			expenseSaveBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(expenseSaveMsg.isDisplayed()){
				yesActivate.click();
				Thread.sleep(Constant.Min_Sleep);
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to save expense config "+e);
		}
		return flag;
	}

	public boolean poConfigSave(){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(poConfigSaveBtn), "Failed to load po config page");
			poConfigSaveBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(poPrintConfigSaveMsg.isDisplayed()){
				yesActivate.click();
				Thread.sleep(Constant.Min_Sleep);
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to save po config "+e);
		}
		return flag;
	}

	public boolean seConfigSave(){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(seSaveBtn), "Failed to load SE config page");
			seSaveBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(seConfigSaveMsg.isDisplayed()){
				yesActivate.click();
				Thread.sleep(Constant.Min_Sleep);
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to save SE config "+e);
		}
		return flag;
	}

}
