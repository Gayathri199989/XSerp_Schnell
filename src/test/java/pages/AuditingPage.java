package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import utility.Constant;
import utility.ExcelUtils;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

public class AuditingPage {

	ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
	PurchasePage purchase = PageFactory.initElements(Constant.driver, PurchasePage.class);
	SalesPage sale = PageFactory.initElements(Constant.driver, SalesPage.class);

	@FindBy(xpath=".//label[@for='id_is_checked']")
	private WebElement invoiceValuesCheck;

	@FindBy(id="id-collapse_document")
	private WebElement invoiceTab;

	@FindBy(id="add_new_form")
	private WebElement addOtherItem;

	@FindBy(id="txtDescription")
	private WebElement otherTxtField;

	@FindBy(id="filter_textbox")
	private WebElement filterText;

	@FindBy(xpath="//a[@class='edit_link_code']")
	public List<WebElement> icdList;

	@FindBy(xpath=".//label[contains(@for,'auditNoteCheck')]")
	private List<WebElement> invoiceTaxDetailsCheck;

	@FindBy(xpath=".//table[@id='grn_table']/tbody/tr/td[2]")
	private WebElement grnMatDetails_InvoiceTab;

	@FindBy(id="txtremarks")
	private WebElement remarks;

	@FindBy(xpath=".//span[contains(text(),'Select Tax')]")
	private WebElement selectTaxDrpDwn;

	@FindBy(xpath=".//*[@id='id_note_tax_chosen']/div/div/input")
	private WebElement searchTaxField;

	@FindBy(xpath="//label[contains(text(),'Is Credit')]")
	private WebElement isCreditChckBx;

	@FindBy(id="add_note_tax")
	private WebElement addICDTaxBtn;

	@FindBy(id="receipt_tap")
	private WebElement receiptTab;

	@FindBy(id="po_tap")
	private WebElement poTab;

	@FindBy(id="po")
	private WebElement poPDF;

	@FindBy(id="grn")
	private WebElement grnPDf;

	@FindBy(id="txtnetvalue")
	private WebElement grnGrandTotal;

	@FindBy(id="txtround_off")
	private WebElement grnRoundOff;

	@FindBy(id="cmdupdate") WebElement checkedOkBtn;

	@FindBy(id="txtnetvalue")
	private WebElement netValue;

	@FindBy(xpath=".//*[contains(@id,'txtAccrate')]")
	private List<WebElement> icdAutoRate;

	@FindBy(xpath=".//*[contains(@id,'txtrate')]")
	private List<WebElement> icdRate;

	@FindBy(xpath=".//input[contains(@id,'txtRate')]")
	private List<WebElement> noteRate;

	@FindBy(xpath=".//input[contains(@id,'txtrate')]")
	private List<WebElement> noteRate_EditPg;

	@FindBy(xpath=".//*[@id='drcrtable']/tbody[1]/tr/td[4]")
	private List<WebElement> icdQty;

	@FindBy(xpath=".//*[contains(@id,'txt_hsn_code')]")
	private List<WebElement> hsnICDField;

	@FindBy(id="txtQty")
	private List<WebElement> noteQty;

	@FindBy(xpath=".//input[@name='othersHsn_code']")
	private List<WebElement> otherHsnCode;

	@FindBy(xpath=".//*[contains(@id,'txtdrvalue')]")
	private List<WebElement> icdAutoAmt;

	@FindBy(xpath="//select[@name='other_cgst']")
	private WebElement icdOther_Cgst;

	@FindBy(xpath="//select[@name='other_sgst']")
	private WebElement icdOther_Sgst;

	@FindBy(xpath="//select[@name='other_igst']")
	private WebElement icdOther_Igst;

	@FindBy(xpath="//span[@name='other_cgstamt']")
	private WebElement icdOtherAmt_Cgst;

	@FindBy(xpath="//span[@name='other_sgstamt']")
	private WebElement icdOtherAmt_Sgst;

	@FindBy(xpath="//span[@name='other_igstamt']")
	private WebElement icdOtherAmt_Igst;

	@FindBy(xpath=".//*[contains(@id,'txtchangedrvalue')]")
	private List<WebElement> icdAmt;

	@FindBy(id="txtAmount")
	private List<WebElement> noteAmt;

	@FindBy(xpath=".//span[text()='Dr']/preceding-sibling::input[contains(@id,'txtchangedrvalue')]")
	private List<WebElement> icdAmt_Debit;

	@FindBy(xpath=".//span[text()='Cr']/preceding-sibling::input[contains(@id,'txtchangedrvalue')]")
	private List<WebElement> icdAmt_Credit;

	@FindBy(xpath=".//*[@id='drcrtable']/tbody/tr/td[7]/span[contains(text(),'Dr')]/following::span[@name='cgstamt']")
	private List<WebElement> icdCGSTAmt_Debit;

	@FindBy(xpath=".//*[@id='drcrtable']/tbody/tr/td[7]/span[contains(text(),'Cr')]/following::span[@name='cgstamt']")
	private List<WebElement> icdCGSTAmt_Credit;

	@FindBy(xpath=".//*[@id='drcrtable']/tbody/tr/td[7]/span[contains(text(),'Dr')]/following::span[@name='sgstamt']")
	private List<WebElement> icdSGSTAmt_Debit;

	@FindBy(xpath=".//*[@id='drcrtable']/tbody/tr/td[7]/span[contains(text(),'Cr')]/following::span[@name='sgstamt']")
	private List<WebElement> icdSGSTAmt_Credit;

	@FindBy(xpath=".//*[@id='drcrtable']/tbody/tr/td[7]/span[contains(text(),'Dr')]/following::span[@name='igstamt']")
	private List<WebElement> icdIGSTAmt_Debit;

	@FindBy(xpath=".//*[@id='drcrtable']/tbody/tr/td[7]/span[contains(text(),'Cr')]/following::span[@name='igstamt']")
	private List<WebElement> icdIGSTAmt_Credit;

	@FindBy(xpath=".//*[@id='note_taxes_table']/tbody/tr/td[3]/input")
	private List<WebElement> icdTaxList;

	@FindBy(xpath=".//*[@id='drcrtable']/tbody[1]/tr/td[text()='Total']/following::td[4]/span")
	private WebElement icdTotalAmt;

	@FindBy(id="cgst_total_amt")
	private WebElement cgstTotalAmt;

	@FindBy(id="sgst_total_amt")
	private WebElement sgstTotalAmt;

	@FindBy(id="igst_total_amt")
	private WebElement igstTotalAmt;

	@FindBy(id="view_note") WebElement viewNoteBtn;

	@FindBy(id="party_acknowledge_note") WebElement partyAcknNote;

	@FindBy(id="cmdverify") WebElement verifyBtn;

	@FindBy(id="party_reject_note") WebElement rejectPartyAcknNote;

	@FindBy(xpath="//h4[contains(text(),'Preview Document')]")
	private WebElement icdPDf;

	@FindBy(xpath=".//button[text()='Close']") WebElement closeBtnPDf;

	@FindBy(id="cmdcancel_up")
	private WebElement backBtnICD;

	@FindBy(xpath=".//div[contains(text(),'Note Verified!')]")
	private WebElement noteVerifiedTxt;

	@FindBy(xpath=".//div[contains(text(),'Party Rejected!')]")
	private WebElement notePartyRejected;

	@FindBy(xpath=".//div[contains(text(),' Party Acknowledged!')]")
	private WebElement notePartyAckTxt;

	@FindBy(xpath=".//button[text()='Ok']")
	private WebElement okButton;

	@FindBy(id="materialrequired")
	private WebElement descriptionTxtField;

	@FindBy(id="id_note_item-__prefix__-reason_id")
	private WebElement resonDropDwn;

	@FindBy(id="id_note_item-__prefix__-quantity")
	private WebElement qtyTxtField;

	@FindBy(xpath="//div/input[contains(@id,'hsn_code')]")
	private WebElement noteHSNCodeField;

	@FindBy(id="id_note_item-__prefix__-rate")
	private WebElement rateTxtField;

	@FindBy(id="id_note_item-__prefix__-unit_id")
	private WebElement unitTxtDropDwn;

	@FindBy(id="id_note_item-__prefix__-amount_display")
	private WebElement manualNoteAmt;

	@FindBy(id="add_note_item")
	private WebElement addNoteBtn;

	@FindBy(xpath=".//*[contains(@id,'item_name')]")
	private List<WebElement> manualNoteItemList;

	@FindBy(id="note_creation") WebElement noteBtn;

	@FindBy(xpath=".//span[text()='Note Creation']")
	private WebElement noteCreationPage;

	@FindBy(id="id_note_supplier_id_chosen")
	private WebElement partyDrpDwn;

	@FindBy(xpath=".//*[@id='id_note_supplier_id_chosen']/div/div/input")
	private WebElement searchParty;

	@FindBy(id="id_note_project_code_chosen")
	private WebElement projectDropDown;

	@FindBy(xpath=".//*[@id='id_note_project_code_chosen']/div/div/input[@class='chosen-search-input']")
	private WebElement searchProject;

	@FindBy(id="id_note-receipt_code")
	private WebElement receiptNoTxtField;

	@FindBy(id="id_note-invoice_no")
	private WebElement noteInvoiceNo;

	@FindBy(id="id_note-invoice_value")
	private WebElement noteInvoiceValue;

	@FindBy(xpath="//span[@data-default='Upload Document']")
	private WebElement uploadDoc;

	@FindBy(css="i[class$='btn-browse-remove']")
	private WebElement attachmentRemove;

	@FindBy(id="id_note-remarks")
	private WebElement noteRemarksTxtField;

	@FindBy(xpath=".//span[contains(text(),'Tax')]")
	private WebElement taxDropDwn;

	@FindBy(xpath=".//*[@id='note_tax_list_chosen']/div/div/input")
	private WebElement taxSearchField;

	@FindBy(id="add_note_tax")
	private WebElement addTaxBtn;

	@FindBy(id="cmdApprove") WebElement approveBtn;

	@FindBy(xpath=".//a[text()='Credit']")
	private WebElement creditDebitToggle;

	@FindBy(id="id_note-value")
	private WebElement noteGrandTotalTxtField;

	@FindBy(id="id_note-round_off")
	private WebElement noteRoundOffTxtField;

	@FindBy(xpath=".//a[contains(@id,'deleteInvoiceMaterial')]")
	private List<WebElement> deleteItems;

	@FindBy(xpath=".//*[contains(@id,'amount_display')]")
	private List<WebElement> manualNoteAmtList;

	@FindBy(xpath=".//input[@name='CGST_AMT']")
	private List<WebElement> cgstAmtList;

	@FindBy(xpath=".//*[contains(@id,'txtothercgstamt')]")
	private List<WebElement> cgstNoteAmtList;

	@FindBy(xpath=".//input[@name='SGST_AMT']")
	private List<WebElement> sgstAmtList;

	@FindBy(xpath=".//*[contains(@id,'txtothersgstamt')]")
	private List<WebElement> sgstNoteAmtList;

	@FindBy(xpath=".//input[@name='IGST_AMT']")
	private List<WebElement> igstAmtList;

	@FindBy(xpath=".//*[contains(@id,'txtotherigstamt')]")
	private List<WebElement> igstNoteAmtList;

	@FindBy(xpath=".//*[@id='note_tax_table']/tbody/tr/td[3]/input")
	private List<WebElement> taxAmtList;

	@FindBy(xpath=".//*[@id='note_taxes_table']/tbody/tr/td[3]/input")
	private List<WebElement> checkedNotetaxAmtList;

	@FindBy(xpath=".//*[@id='expense_table_list_tbody']/tr/td[2]/a")
	private List<WebElement> expenseNoList;

	@FindBy(id="a-create-my-exp") WebElement addBtnMyExpense;

	@FindBy(xpath=".//*[@id='tab2']/div/div/div/div[4]/a[@data-original-title='Create New Expenses']")
	private WebElement addBtnOtherExpense;

	@FindBy(xpath=".//h3[text()='Add Expenses']")
	private WebElement addExpensePage;

	@FindBy(xpath=".//*[@id='id_exp_claim_head_ledger_id_chosen']/a/span")
	private WebElement cliamHeadDropDwn;

	@FindBy(xpath=".//*[@id='id_exp_claim_head_ledger_id_chosen']/div/div/input")
	private WebElement searchClaimHead;

	@FindBy(id="id_exp-group_description")
	private WebElement descTextField;

	@FindBy(id="id_exp_item-__prefix__-description")
	private WebElement expItemDescField;

	@FindBy(xpath=".//span[contains(text(),'Select Expense Head')]")
	private WebElement expenseHeadField;

	@FindBy(xpath=".//*[@id='id_exp_expense_head_ledger_chosen']/div/div/input")
	private WebElement searchExpenseHeadField;

	@FindBy(id="id_exp_item-__prefix__-amount")
	private WebElement amountField;

	@FindBy(xpath=".//label[text()='Bill Available']")
	private WebElement billCheckBx;

	@FindBy(xpath=".//span[text()='Attachment']")
	private WebElement billAttachmentBtn;

	@FindBy(id="cmdadd")
	private WebElement addAttachment;

	@FindBy(id="id_exp-claimed_amount")
	private WebElement claimedAmount;

	@FindBy(xpath=".//td/div/input[contains(@id,'amount')]")
	private List<WebElement> expAmtList;

	@FindBy(id="id_exp-remarks")
	private WebElement expRemarks;

	@FindBy(id="cmd_exp_save") WebElement expSaveBtn;

	@FindBy(xpath=".//h2[contains(text(),'Last modified expense:')]")
	private WebElement successMsgPopUp;

	@FindBy(id="btn-sa-confirm")
	private WebElement okBtn;

	@FindBy(id="id_exp-claim_head_ledger_name")
	private WebElement claimHeaderName;

	@FindBy(id="id_expense_group_description-purpose")
	private WebElement claimGrpDesc_AddPge;

	@FindBy(id="id_exp-group_description")
	private WebElement claimGrpDesc_EditPge;

	@FindBy(id="cmd_exp_confirm") WebElement confirmBtn;

	@FindBy(id="cmd_exp_approve") WebElement approveBtnExp;

	@FindBy(xpath=".//tr/td[6]/div")
	private List<WebElement> amountList;

	@FindBy(xpath=".//tr/td[7]/div/input")
	private List<WebElement> approverAmountList;

	@FindBy(xpath=".//tr/td[8]/div/input")
	private List<WebElement> auditAmountList;

	@FindBy(xpath=".//tr/td[9]/div/input")
	private List<WebElement> remarksList;

	@FindBy(xpath=".//tr/td[10]/div/input")
	private List<WebElement> netValueList;

	@FindBy(id="id_exp-approved_amount")
	private WebElement approvedAmt;

	@FindBy(xpath=".//*[@id='expense_table_list_tbody_others']/tr/td[7]")
	private List<WebElement> claimAmountList;

	@FindBy(xpath=".//*[@id='expense_table_list_tbody_others']/tr/td[8]")
	private List<WebElement> approveAmountList;

	@FindBy(xpath=".//*[@id='expense_table_list_tbody']/tr/td[7]/span[1]")
	private List<WebElement> expenseStatusList;

	@FindBy(xpath=".//*[@id='expense_table_list_tbody_others']/tr/td[2]") List<WebElement> expenseNoList_OtherExp;

	@FindBy(xpath=".//*[@id='expense_table_list_tbody_others']/tr/td[9]/span[1]") List<WebElement> expenseStatusList_OtherExp;

	@FindBy(xpath=".//*[@id='expense_table_list_tbody_others']/tr/td[9]/span[2]/i") List<WebElement> expenseStatusEdit_OtherExp;

	@FindBy(xpath=".//*[@id='expense_table_list_tbody_others']/tr/td[2]/a") List<WebElement> expenseNoEdit_OtherExp;

	@FindBy(xpath=".//h3[text()='Expense Details']")
	private WebElement expenseDetailsPage;

	@FindBy(xpath=".//tr/td[14]/span/label")
	private List<WebElement> checkList;

	@FindBy(id="cmd_checked_ok") WebElement checkedOKBtn;

	@FindBy(id="cmd_exp_verify") WebElement verifyExpBtn;

	@FindBy(id="cmdSave") WebElement saveBtn;

	@FindBy(xpath=".//a[@data-original-title='Back']") WebElement backBtn_Down;

	@FindBy(xpath="//*[@id='icdList']/tbody/tr/td[11]") List<WebElement> icdGRNList;

	@FindBy(xpath="//*[@id='icdList']/tbody/tr/td[11]/span[1]") List<WebElement> icdPreviewIcon;

	@FindBy(xpath="//*[@id='icdList']/tbody/tr/td[10]") List<WebElement> icdNoteValueList;

	@FindBy(xpath=".//*[@id='icdList']/tbody/tr/td[3]/a")
	public List<WebElement> grnNoList;

	@FindBy(xpath=".//*[@id='icdList']/tbody/tr/td[4]")
	public List<WebElement> refNoList;

	@FindBy(xpath="//a[contains(text(),'OTHER EXPENSES')]") WebElement otherExpensesTab;

	@FindBy(xpath="//a[contains(text(),'MY EXPENSES')]") WebElement MyExpensesTab;

	@FindBy(id="id-remarks") WebElement icdRemarksTxtField;

	@FindBy(id="id-acknowledgement") WebElement partyIcdRejectRemarks;

	@FindBy(id="id-returnNote") WebElement returnNoteBtn;

	@FindBy(xpath="//div[@id='icd_note_returned_text']") WebElement icdReturnText_Pdf;

	@FindBy(id="id_user_email") WebElement userName;

	@FindBy(id="id_password") WebElement password;

	@FindBy(id="sign_in_form") WebElement signIn;

	@FindBy(id="menu_accounts") WebElement accountsModule;

	@FindBy(xpath=".//b[contains(text(),'New')]/following::button[text()='�']")
	WebElement skipBtn;

	@FindBy(id="cmdgrnreturn_up") WebElement returnToGRNBtn;

	@FindBy(xpath="//input[@placeholder='Enter Remarks']") WebElement enterReturnRemarkTxt;

	String sDate = Constant.DateTimeFormat();

	private WebDriver driver;
	public AuditingPage(WebDriver driver){
		this.driver = driver;
	}

	public boolean checkGRNPO(int iRowNo, String sheet, String sGRNType){
		boolean flag = false;
		try{
			store.approveGRN(iRowNo, sheet, null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			flag = checkICD(iRowNo, sheet, sGRNNo, sGRNType);
		}catch(Exception e){
			System.err.println("Failed to check ICD of GRN againt po with invoice toggle "+e);
		}
		return flag;
	}

	public boolean returnGRNPO(int iRowNo, String sheet, String sGRNType, String sStatus){
		boolean flag = false;
		try{
			store.approveGRN(iRowNo, sheet, null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			checkICD(iRowNo, sheet, sGRNNo, sGRNType);
			flag = returnICD(iRowNo, sheet, sGRNNo, sStatus);
		}catch(Exception e){
			System.err.println("Failed to check ICD of GRN againt po with invoice toggle "+e);
		}
		return flag;
	}

	public boolean verifyReturnGRNPO(int iRowNo, String sheet, String sGRNType, String sStatus){
		boolean flag = false;
		try{
			store.approveGRN(iRowNo, sheet, null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			checkICD(iRowNo, sheet, sGRNNo, sGRNType);
			returnICD(iRowNo, sheet, sGRNNo, sStatus);
			checkReturnedICD(iRowNo, sheet, sGRNNo);
			flag = icdVerify(sGRNNo, sStatus);
		}catch(Exception e){
			System.err.println("Failed to check ICD of GRN againt po with invoice toggle "+e);
		}
		return flag;
	}

	public boolean verifyGRNPO(int iRowNo, String sheet, String sGRNType, String sStatus){
		boolean flag = false;
		try{
			store.approveGRN(iRowNo, sheet, null);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			checkICD(iRowNo, sheet, sGRNNo, sGRNType);
			flag = icdVerify(sGRNNo, sStatus);
		}catch(Exception e){
			System.err.println("Failed to check ICD of GRN againt po with invoice toggle "+e);
		}
		return flag;
	}

	public boolean verifyGRNPO_addingPo(int iRowNo, String sheet, String sGRNType, String sStatus){
		boolean flag = false;
		try{
			purchase.ApproveQuickPO(iRowNo, sheet);
			int iPoNum = Integer.parseInt(purchase.poVisibleRecordCount.getText().substring(14).trim());
			String sPoNO = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")).getText().trim();
			store.approveGRN(iRowNo, sheet, sPoNO);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			checkICD(iRowNo, sheet, sGRNNo, sGRNType);
			flag = icdVerify(sGRNNo, sStatus);
		}catch(Exception e){
			System.err.println("Failed to check ICD of GRN againt po with invoice toggle "+e);
		}
		return flag;
	}

	public boolean verifyGRNPO_addingJDC(int iRowNo, String sheet, String sGRNType, String sStatus){
		boolean flag = false;
		try{
			purchase.ApproveQuickJO(iRowNo, sheet);
			int iPoNum = Integer.parseInt(purchase.poVisibleRecordCount.getText().substring(14).trim());
			String sPoNO = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")).getText().trim();
			sale.validateApproveInvoice(iRowNo, sheet, sPoNO);
			store.approveGRN(iRowNo, sheet, sPoNO);
			int iGRNCount = store.grnList.size();
			String sGRNNo = store.grnList.get(iGRNCount-1).getText();
			navigate.navigateToAuditing();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToICD();
			checkICD(iRowNo, sheet, sGRNNo, sGRNType);
			flag = icdVerify(sGRNNo, sStatus);
		}catch(Exception e){
			System.err.println("Failed to check ICD of GRN againt po with invoice toggle "+e);
		}
		return flag;
	}

	public boolean checkICD_0Note(){
		boolean flag = false, flag1, flag2, flag3;
		String[] options = null; String sGRNNo;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			options = selectICD_EditPage("Pending", "GRN");
			sGRNNo = options[0];
			i = Integer.parseInt(options[1])+1;
			Constant.waitFor(ExpectedConditions.elementToBeClickable(invoiceTab), "Failed to load ICD edit page");
			if(driver.findElement(By.xpath(".//span[text()='"+sGRNNo+"']")).isDisplayed()){
				js.executeScript("window.scrollBy(0,-2000)");
				invoiceTab.click();
				Thread.sleep(Constant.Min_Sleep);
				invoiceValuesCheck.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMatDetails_InvoiceTab), "Failed to load all materials in invoice tab");
				for (WebElement element : invoiceTaxDetailsCheck) {
					element.click();
				}
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("window.scrollBy(0,-2000)");
				invoiceTab.click();
				Thread.sleep(Constant.Min_Sleep);
				if(icdAutoRate.size() > 0){
					flag1 = clearNoteDetails();
					flag2 = validateGrandTotal_ICD();
					flag3 = roundOff(grnGrandTotal,grnRoundOff);
				}else{
					flag1 = true; flag2 = true; flag3 = true;
				}
				String sNetValue = netValue.getAttribute("value");
				checkedOkBtn.click();
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
				navigate.showAllEntries();
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//td/a[text()='"+sGRNNo+"']/following::td[7]")));
				String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(i)+"]/td[9]")).getText();
				sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
				if(!sActNoteValue.contains(".")){
					sActNoteValue = sActNoteValue+".00";
				}
				if(icdGRNList.get(i-1).getText().contains("Checked") && flag1 && flag2 && flag3 && sActNoteValue.contains(sNetValue) &&
						driver.findElement(By.xpath("//td/a[text()='"+sGRNNo+"']/following::td[7]/a")).getText().contains("Checked")){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check ICd with 0 note value "+e);
		}
		return flag;
	}

	public boolean returnICD_0Note(){
		boolean flag = false;
		String[] options = null;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			options = selectICD_0Note("Checked", "GRN");
			if(!icdPDf.isDisplayed()){
				driver.navigate().refresh();
				checkICD_0Note();
				options = selectICD_0Note("Checked", "GRN");
			}
			if(icdPDf.isDisplayed()){
				icdRemarksTxtField.sendKeys("Automation "+sDate);
				returnNoteBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load ICD view page");
				Thread.sleep(Constant.Min_Sleep);
				okButton.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				String sReturnText = icdReturnText_Pdf.getText();
				closeBtnPDf.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
				js.executeScript("arguments[0].scrollIntoView(true);", icdGRNList.get(Integer.parseInt(options[1])));
				if(icdGRNList.get(Integer.parseInt(options[1])).getText().contains("Returned") && sReturnText.contains("Note Returned!") &&
						driver.findElement(By.xpath("//td/a[contains(text(),'"+options[0]+"')]/following::td[8]/a")).getText().contains("Returned")){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to return ICD "+e);
		}
		return flag;
	}

	public boolean verifyGRNNotDisplayed(String sGRNNo){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			filterText.sendKeys(sGRNNo);
			if(!driver.getPageSource().contains(sGRNNo)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to verify grn not displayed "+e);
		}
		return flag;
	}

	public boolean checkICD(int iRowNo, String sheet, String sGRNNo, String sGRNType) throws Exception{
		boolean flag = false, flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag6,flag7;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("Tax");
		String[] options = null;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			if(sGRNNo == null){
				options = selectICD_EditPage("Pending", sGRNType);
				sGRNNo = options[0];
				i = Integer.parseInt(options[1])+1;
			}else{
				i = icdList.size();
				filterText.sendKeys(sGRNNo);
				driver.findElement(By.xpath("//mark[text()='"+sGRNNo+"']")).click();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(invoiceTab), "Failed to load ICD edit page");
			if(driver.findElement(By.xpath(".//span[text()='"+sGRNNo+"']")).isDisplayed()){
				js.executeScript("window.scrollBy(0,-2000)");
				invoiceTab.click();
				Thread.sleep(Constant.Min_Sleep);
				invoiceValuesCheck.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMatDetails_InvoiceTab), "Failed to load all materials in invoice tab");
				for (WebElement element : invoiceTaxDetailsCheck) {
					element.click();
				}
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("window.scrollBy(0,-2000)");
				invoiceTab.click();
				Thread.sleep(Constant.Min_Sleep);
				if(icdAutoRate.size() > 0){
					flag1 = validateNoteDetails();
					Thread.sleep(Constant.Min_Sleep);
					flag2 = validateGST(iRowNo, sheet);
					Thread.sleep(Constant.Min_Sleep);
					flag7 = validateGrandTotal_ICD();
					boolean flag5 = Constant.isElementPresent(By.xpath(".//*[@id='note_taxes_table']/tbody/tr[1]/th[2]/b"));
					if(!flag5){
						selectTaxDrpDwn.click();
						searchTaxField.sendKeys(sTax);
						driver.findElement(By.xpath(".//em[text()='"+sTax+"']")).click();
						addICDTaxBtn.click();
					}
					flag6 = roundOff(grnGrandTotal,grnRoundOff);
				}else{
					flag1 = true; flag6 = true;
					flag2 = true; flag7 = true;
				}
				if(flag1 && flag2){
					remarks.sendKeys("Test"+sDate);
					String sNetValue = netValue.getAttribute("value");
					receiptTab.click();
					Thread.sleep(Constant.Min_Sleep);
					if(grnPDf.isDisplayed()){
						receiptTab.click();
						flag3 = true;
					}
					Thread.sleep(Constant.Min_Sleep);
					if(poTab.isDisplayed()){
						poTab.click();
						Thread.sleep(Constant.Min_Sleep);
						if(poPDF.isDisplayed()){
							poTab.click();
							flag4 = true;
						}
						Thread.sleep(Constant.Min_Sleep);
					}else{
						flag4 = true;
					}
					checkedOkBtn.click();
					if(Constant.isAlertPresents()){
						driver.switchTo().alert().accept();
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
					Thread.sleep(Constant.Min_Sleep);
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[8]")));
					String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(i)+"]/td[10]")).getText();
					sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
					if(!sActNoteValue.contains(".")){
						sActNoteValue = sActNoteValue+".00";
					}
					if((icdGRNList.get(i-1).getText().contains("Checked") || icdGRNList.get(i-1).getText().contains("Party Acknowledgement Pending")) && flag3 && flag4 &&
							sActNoteValue.contains(sNetValue) && flag6 && flag7 &&
							(driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[8]/a")).getText().contains("Checked") ||
									driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[8]/a")).getText().contains("Party Acknowledgement Pending"))){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check ICD "+e);
		}
		return flag;
	}

	public boolean acknowledgePartyICD(int iRowNo, String sheet, String sGRNNo, String sGRNType) throws Exception{
		boolean flag = false;
		String[] options = null;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			if(sGRNNo == null){
				options = selectICD_EditPage("Party Acknowledgement Pending", sGRNType);
				sGRNNo = options[0];
				i = Integer.parseInt(options[1])+1;
			}else{
				i = icdList.size();
				filterText.sendKeys(sGRNNo);
				driver.findElement(By.xpath("//mark[text()='"+sGRNNo+"']")).click();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(viewNoteBtn), "Failed to load ICD edit page");
			if(driver.findElement(By.xpath(".//span[text()='"+sGRNNo+"']")).isDisplayed()){
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(Constant.Min_Sleep);
				viewNoteBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(partyAcknNote), "Failed to load ICD pdf popup");
				Thread.sleep(Constant.Min_Sleep);
				if(driver.getPageSource().contains("No Note generated for this Receipt.") || icdPDf.isDisplayed()){
					partyAcknNote.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load ICD pdf popup");
					Thread.sleep(Constant.Min_Sleep);
					okBtn.sendKeys(Keys.ENTER);
					Constant.waitFor(ExpectedConditions.visibilityOf(notePartyAckTxt), "Failed to load ICD pdf popup");
					Thread.sleep(Constant.Min_Sleep);
					if(notePartyAckTxt.isDisplayed()){
						closeBtnPDf.click();
						Thread.sleep(Constant.Min_Sleep);
						js.executeScript("window.scrollBy(0,-5000)");
						backBtnICD.click();
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
						navigate.showAllEntries();
						js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[contains(text(),'"+sGRNNo+"')]/following::td[7]")));
						if(icdGRNList.get(i-1).getText().contains("Party Acknowledged")){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check ICD "+e);
		}
		return flag;
	}

	public boolean roundOff(WebElement grandTotal, WebElement roundoff){
		boolean flag = false;
		String sGrandTotal,sDecimalvalue;
		try{
			Thread.sleep(Constant.Min_Sleep);
			roundoff.sendKeys(Keys.CONTROL+"a");
			roundoff.sendKeys(Keys.DELETE);
			roundoff.sendKeys("0.00");
			Thread.sleep(Constant.Min_Sleep);
			grandTotal.click();
			sGrandTotal = grandTotal.getAttribute("value");
			sDecimalvalue = sGrandTotal.substring(sGrandTotal.indexOf("."));
			if(!sDecimalvalue.contains("00")){
				sDecimalvalue = sDecimalvalue.substring(1);
				Thread.sleep(Constant.Min_Sleep);
				int iRemaining = 100 - Integer.parseInt(sDecimalvalue);
				roundoff.sendKeys(Keys.CONTROL+"a");
				roundoff.sendKeys(Keys.DELETE);
				if(iRemaining < 50){
					if(iRemaining < 10){
						roundoff.sendKeys(".0"+iRemaining);
					}else{
						roundoff.sendKeys("."+iRemaining);
					}
				}else{
					roundoff.sendKeys("- ."+sDecimalvalue);
				}
				grandTotal.click();
				Thread.sleep(Constant.Min_Sleep);
				sGrandTotal = grandTotal.getAttribute("value");
				sDecimalvalue = sGrandTotal.substring(sGrandTotal.indexOf("."));
			}
			if(sDecimalvalue.contains("00")){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Round off value validation failed "+e);
		}
		return flag;
	}

	public boolean validateNoteDetails(){
		boolean flag = false;
		try{
			for(int i=0;i<icdAutoRate.size();i++){
				String sAmt = icdAutoRate.get(i).getAttribute("value");
				icdRate.get(i).sendKeys(Keys.CONTROL+"a");
				icdRate.get(i).sendKeys(Keys.DELETE);
				icdRate.get(i).sendKeys(Double.toString(Double.parseDouble(sAmt)+1));
				Thread.sleep(Constant.Min_Sleep);
				String sQty = icdQty.get(i).getText();
				if(hsnICDField.get(i).getAttribute("value").isEmpty()){
					hsnICDField.get(i).sendKeys(sDate);
				}
				icdQty.get(i).click();
				String sAutoAmt = icdAutoAmt.get(i).getAttribute("value");
				Double rateAuto = Double.parseDouble(sAmt) * Double.parseDouble(sQty);
				rateAuto = Math.round(rateAuto * 100.0) / 100.0;
				String sAmount = icdAmt.get(i).getAttribute("value");
				Double rate = (Double.parseDouble(sAmt)+1) * Double.parseDouble(sQty);
				rate = Math.round(rate * 100.0) / 100.0;
				if(sAutoAmt.contains(Double.toString(rateAuto)) && sAmount.contains(Double.toString(rate))){
					flag = true;
				}else{
					flag = false;
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Note details validation failed "+e);
		}
		return flag;
	}
	public boolean clearNoteDetails(){
		boolean flag = false;
		try{
			for(int i=0;i<icdAutoRate.size();i++){
				String sAmt = icdAutoRate.get(i).getAttribute("value");
				icdRate.get(i).clear();
				icdQty.get(i).click();
				Thread.sleep(Constant.Min_Sleep);
				String sQty = icdQty.get(i).getText();
				String sAutoAmt = icdAutoAmt.get(i).getAttribute("value");
				Double rateAuto = Double.parseDouble(sAmt) * Double.parseDouble(sQty);
				rateAuto = Math.round(rateAuto * 100.0) / 100.0;
				String sAmount = icdAmt.get(i).getAttribute("value");
				double rate = (Double.parseDouble(sAmt)+1) * Double.parseDouble(sQty);
				rate = Math.round(rate * 100.0) / 100.0;
				if(sAutoAmt.contains(Double.toString(rateAuto)) && sAmount.equals("0.00")){
					flag = true;
				}else{
					flag = false;
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Note details validation failed "+e);
		}
		return flag;
	}

	public boolean validateManualNoteDetails(){
		boolean flag = false;
		try{
			for(int i=0;i<noteRate.size();i++){
				String sAmt = noteRate.get(i).getAttribute("value");
				noteRate.get(i).clear();
				noteRate.get(i).sendKeys(Double.toString(Double.parseDouble(sAmt)+1));
				noteRate.get(i).click();
				Thread.sleep(Constant.Min_Sleep);
				remarks.click();
				String sQty = noteQty.get(i).getAttribute("value");
				String sAmount = noteAmt.get(i).getAttribute("value");
				Double rate = (Double.parseDouble(sAmt)+1) * Double.parseDouble(sQty);
				rate = Math.round(rate * 100.0) / 100.0;
				if(sAmount.contains(Double.toString(rate))){
					flag = true;
				}else{
					flag = false;
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Note details validation failed "+e);
		}
		return flag;
	}

	public boolean vaidateNoteGST(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCGST = xls.get(iRowNo).get("CGST");
		String sSGST = xls.get(iRowNo).get("SGST");
		String sIGST = xls.get(iRowNo).get("IGST");
		try{
			for(int i=0;i<icdRate.size();i++){
				Select selectCGST = new Select(driver.findElement(By.id("txtothercgst"+i+"_"+(i+1)+"")));
				selectCGST.selectByValue(sCGST);
				String sCgst = driver.findElement(By.xpath(".//*[@id='txtothercgst"+i+"_"+(i+1)+"']/option[@value='"+sCGST+"']")).getText();
				Select selectSGST = new Select(driver.findElement(By.id("txtothersgst"+i+"_"+(i+1)+"")));
				selectSGST.selectByValue(sSGST);
				String sSgst = driver.findElement(By.xpath(".//*[@id='txtothersgst"+i+"_"+(i+1)+"']/option[@value='"+sSGST+"']")).getText();
				Select selectIGST = new Select(driver.findElement(By.id("txtotherigst"+i+"_"+(i+1)+"")));
				selectIGST.selectByValue(sIGST);
				String sIgst = driver.findElement(By.xpath(".//*[@id='txtotherigst"+i+"_"+(i+1)+"']/option[@value='"+sIGST+"']")).getText();
				String sAmount = noteAmt.get(i).getAttribute("value");
				String sCGSTAmount = driver.findElement(By.id("txtothercgstamt"+i+"")).getAttribute("value");
				String sSGSTAmount = driver.findElement(By.id("txtothersgstamt"+i+"")).getAttribute("value");
				String sIGSTAmount = driver.findElement(By.id("txtotherigstamt"+i+"")).getAttribute("value");
				Double amtCGST = Double.parseDouble(sAmount) * Double.parseDouble(sCgst) / 100;
				amtCGST = Math.round(amtCGST * 100.0) / 100.0;
				Double amtSGST = Double.parseDouble(sAmount) * Double.parseDouble(sSgst) / 100;
				amtSGST = Math.round(amtSGST * 100.0) / 100.0;
				Double amtIGST = Double.parseDouble(sAmount) * Double.parseDouble(sIgst) / 100;
				amtIGST = Math.round(amtIGST * 100.0) / 100.0;
				if((Double.toString(amtCGST)).contains(sCGSTAmount) && (Double.toString(amtSGST)).contains(sSGSTAmount) && (Double.toString(amtIGST)).contains(sIGSTAmount)){
					flag = true;
				}

			}
		}catch(Exception e){
			System.err.println("GST validation failed "+e);
		}
		return flag;
	}

	public boolean validateGST(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCGST = xls.get(iRowNo).get("CGST");
		String sSGST = xls.get(iRowNo).get("SGST");
		String sIGST = xls.get(iRowNo).get("IGST");
		try{
			for(int i=0;i<icdAutoRate.size();i++){
				driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/select[contains(@id,'txtcgst')]/option[@value='"+sCGST+"']")).click();
				String sCgst = driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/select[contains(@id,'txtcgst')]/option[@value='"+sCGST+"']")).getText();
				driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/select[contains(@id,'txtsgst')]/option[@value='"+sSGST+"']")).click();
				String sSgst = driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/select[contains(@id,'txtsgst')]/option[@value='"+sSGST+"']")).getText();
				driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/select[contains(@id,'txtigst')]/option[@value='"+sIGST+"']")).click();
				String sIgst = driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/select[contains(@id,'txtigst')]/option[@value='"+sIGST+"']")).getText();
				String sAmount = icdAmt.get(i).getAttribute("value");
				String sCGSTAmount = driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/span[contains(@id,'txtcgstamt')]")).getText();
				String sSGSTAmount = driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/span[contains(@id,'txtsgstamt')]")).getText();
				String sIGSTAmount = driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/span[contains(@id,'txtigstamt')]")).getText();
				Double amtCGST = Double.parseDouble(sAmount) * Double.parseDouble(sCgst) / 100;
				amtCGST = Math.round(amtCGST * 100.0) / 100.0;
				Double amtSGST = Double.parseDouble(sAmount) * Double.parseDouble(sSgst) / 100;
				amtSGST = Math.round(amtSGST * 100.0) / 100.0;
				Double amtIGST = Double.parseDouble(sAmount) * Double.parseDouble(sIgst) / 100;
				amtIGST = Math.round(amtIGST * 100.0) / 100.0;
				if(sCGSTAmount.contains(Double.toString(amtCGST)) && sSGSTAmount.contains(Double.toString(amtSGST)) && sIGSTAmount.contains(Double.toString(amtIGST))){
					flag = true;
				}

			}
		}catch(Exception e){
			System.err.println("GST validation failed "+e);
		}
		return flag;
	}

	public boolean vaidateOtherGST(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCGST = xls.get(iRowNo).get("CGST");
		String sSGST = xls.get(iRowNo).get("SGST");
		String sIGST = xls.get(iRowNo).get("IGST");
		try{
			Select selectCGST = new Select(icdOther_Cgst);
			selectCGST.selectByValue(sCGST);
			Select selectSGST = new Select(icdOther_Sgst);
			selectSGST.selectByValue(sSGST);
			Select selectIGST = new Select(icdOther_Igst);
			selectIGST.selectByValue(sIGST);
			String sCgst = driver.findElement(By.xpath("//select[@name='other_cgst']/option[@value='"+sCGST+"']")).getText();
			String sSgst = driver.findElement(By.xpath("//select[@name='other_sgst']/option[@value='"+sSGST+"']")).getText();
			String sIgst = driver.findElement(By.xpath("//select[@name='other_igst']/option[@value='"+sIGST+"']")).getText();
			String sAmount = noteAmt.get(0).getAttribute("value");
			String sCGSTAmount = icdOtherAmt_Cgst.getText();
			String sSGSTAmount = icdOtherAmt_Sgst.getText();
			String sIGSTAmount = icdOtherAmt_Igst.getText();
			Double amtCGST = Double.parseDouble(sAmount) * Double.parseDouble(sCgst) / 100;
//			amtCGST = Math.round(amtCGST * 100.0) / 100.0;
			Double amtSGST = Double.parseDouble(sAmount) * Double.parseDouble(sSgst) / 100;
//			amtSGST = Math.round(amtSGST * 100.0) / 100.0;
			Double amtIGST = Double.parseDouble(sAmount) * Double.parseDouble(sIgst) / 100;
//			amtIGST = Math.round(amtIGST * 100.0) / 100.0;
			if(Double.toString(amtCGST).contains(sCGSTAmount) && Double.toString(amtSGST).contains(sSGSTAmount) && Double.toString(amtIGST).contains(sIGSTAmount)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("GST validation failed "+e);
		}
		return flag;
	}

	public boolean validateGrandTotal_ICD(){
		boolean flag = false;
		ArrayList<String> tax = new ArrayList<>();
		ArrayList<String> amtTotal_Dr = new ArrayList<>();
		ArrayList<String> amtTotal_Cr = new ArrayList<>();
		ArrayList<String> sNetCGST_Dr = new ArrayList<>();
		ArrayList<String> sNetSGST_Dr = new ArrayList<>();
		ArrayList<String> sNetIGST_Dr = new ArrayList<>();
		ArrayList<String> sNetCGST_Cr = new ArrayList<>();
		ArrayList<String> sNetSGST_Cr = new ArrayList<>();
		ArrayList<String> sNetIGST_Cr = new ArrayList<>();
		List<Double> arrayOfTax = new ArrayList<>();
		List<Double> arrayOfautoAmtTotal_Cr = new ArrayList<>();
		List<Double> arrayOfAmtTotal_Dr = new ArrayList<>();
		List<Double> arrayOfAmtTotal_Cr = new ArrayList<>();
		List<Double> arrayOfCgst_Dr = new ArrayList<>();
		List<Double> arrayOfSGST_Dr = new ArrayList<>();
		List<Double> arrayOfIGST_Dr = new ArrayList<>();
		List<Double> arrayOfCgst_Cr = new ArrayList<>();
		List<Double> arrayOfSGST_Cr = new ArrayList<>();
		List<Double> arrayOfIGST_Cr = new ArrayList<>();
		double sumAmtTotal = 0,sumTax = 0,sumAmtTotal_Dr = 0,sumAmtTotal_Cr = 0,sumCGST_Dr = 0, sumSGST_Dr = 0,sumIGST_Dr = 0,
				sumCGST_Cr = 0,sumSGST_Cr = 0,sumIGST_Cr = 0, packingCharges = 0, transportCharges = 0, others = 0, sumCGST = 0, sumSGST = 0, sumIGST = 0;
		try{
			for(int i=0;i<icdAmt_Debit.size();i++){
				String[] icdAmt = icdAmt_Debit.get(i).getAttribute("value").split("\\s+");
				amtTotal_Dr.add(icdAmt[0]);
				sNetCGST_Dr.add(icdCGSTAmt_Debit.get(i).getText());
				sNetSGST_Dr.add(icdSGSTAmt_Debit.get(i).getText());
				sNetIGST_Dr.add(icdIGSTAmt_Debit.get(i).getText());
				arrayOfAmtTotal_Dr.add(Double.parseDouble(amtTotal_Dr.get(i)));
				arrayOfCgst_Dr.add(Double.parseDouble(sNetCGST_Dr.get(i)));
				arrayOfSGST_Dr.add(Double.parseDouble(sNetSGST_Dr.get(i)));
				arrayOfIGST_Dr.add(Double.parseDouble(sNetIGST_Dr.get(i)));
				sumAmtTotal_Dr += arrayOfAmtTotal_Dr.get(i);
				sumAmtTotal_Dr = Math.round(sumAmtTotal_Dr * 100.0) / 100.0;
				sumCGST_Dr += arrayOfCgst_Dr.get(i);
				sumCGST_Dr = Math.round(sumCGST_Dr * 100.0) / 100.0;
				sumSGST_Dr += arrayOfSGST_Dr.get(i);
				sumSGST_Dr = Math.round(sumSGST_Dr * 100.0) / 100.0;
				sumIGST_Dr += arrayOfIGST_Dr.get(i);
				sumIGST_Dr = Math.round(sumIGST_Dr * 100.0) / 100.0;
			}
			for(int i=0;i<icdAmt_Credit.size();i++){
				String[] icdAmt = icdAmt_Credit.get(i).getAttribute("value").split("\\s+");
				amtTotal_Cr.add(icdAmt[0]);
				sNetCGST_Cr.add(icdCGSTAmt_Credit.get(i).getText());
				sNetSGST_Cr.add(icdSGSTAmt_Credit.get(i).getText());
				sNetIGST_Cr.add(icdIGSTAmt_Credit.get(i).getText());
				arrayOfautoAmtTotal_Cr.add(Double.parseDouble(amtTotal_Cr.get(i)));
				arrayOfAmtTotal_Cr.add(Double.parseDouble(amtTotal_Cr.get(i)));
				arrayOfCgst_Cr.add(Double.parseDouble(sNetCGST_Cr.get(i)));
				arrayOfSGST_Cr.add(Double.parseDouble(sNetSGST_Cr.get(i)));
				arrayOfIGST_Cr.add(Double.parseDouble(sNetIGST_Cr.get(i)));
				sumAmtTotal_Cr += arrayOfAmtTotal_Cr.get(i);
				sumAmtTotal_Cr = Math.round(sumAmtTotal_Cr * 100.0) / 100.0;
				sumCGST_Cr += arrayOfCgst_Cr.get(i);
				sumCGST_Cr = Math.round(sumCGST_Cr * 100.0) / 100.0;
				sumSGST_Cr += arrayOfSGST_Cr.get(i);
				sumSGST_Cr = Math.round(sumSGST_Cr * 100.0) / 100.0;
				sumIGST_Cr += arrayOfIGST_Cr.get(i);
				sumIGST_Cr = Math.round(sumIGST_Cr * 100.0) / 100.0;
			}
			sumAmtTotal = sumAmtTotal_Dr - sumAmtTotal_Cr;
			sumAmtTotal = Math.round(sumAmtTotal * 100.0) / 100.0;
			sumAmtTotal = Math.abs(sumAmtTotal);
			sumCGST = sumCGST_Dr - sumCGST_Cr;
			sumCGST = Math.round(sumCGST * 100.0) / 100.0;
			sumCGST = Math.abs(sumCGST);
			sumSGST = sumSGST_Dr - sumSGST_Cr;
			sumSGST = Math.round(sumSGST * 100.0) / 100.0;
			sumSGST = Math.abs(sumSGST);
			sumIGST = sumIGST_Dr - sumIGST_Cr;
			sumIGST = Math.round(sumIGST * 100.0) / 100.0;
			sumIGST = Math.abs(sumIGST);
			for(int i=0;i<icdTaxList.size();i++){
				tax.add(icdTaxList.get(i).getAttribute("value"));
				arrayOfTax.add(Double.parseDouble(tax.get(i)));
				sumTax += arrayOfTax.get(i);
			}
			String[] sicdTotalAmt = icdTotalAmt.getText().split("\\s+");
			if(sicdTotalAmt[0].contains(Double.toString(sumAmtTotal)) && cgstTotalAmt.getText().contains(Double.toString(sumCGST))
					&& sgstTotalAmt.getText().contains(Double.toString(sumSGST)) && igstTotalAmt.getText().contains(Double.toString(sumIGST))){
				String sGrandTotal = grnGrandTotal.getAttribute("value");
				double Total = sumTax+sumAmtTotal+sumCGST+sumSGST+sumIGST+packingCharges+transportCharges+others;
				double roundOff = Math.round(Total * 100.0) / 100.0;
				if(roundOff == Double.parseDouble(sGrandTotal)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Grand total validation failed "+e);
		}
		return flag;
	}

	public boolean validateGrandTotal_Note(String sOtherItem){
		boolean flag = false;
		ArrayList<String> tax = new ArrayList<>();
		ArrayList<String> amtTotal_Dr = new ArrayList<>();
		ArrayList<String> amtTotal_Cr = new ArrayList<>();
		ArrayList<String> sNetCGST_Dr = new ArrayList<>();
		ArrayList<String> sNetSGST_Dr = new ArrayList<>();
		ArrayList<String> sNetIGST_Dr = new ArrayList<>();
		ArrayList<String> sNetCGST_Cr = new ArrayList<>();
		ArrayList<String> sNetSGST_Cr = new ArrayList<>();
		ArrayList<String> sNetIGST_Cr = new ArrayList<>();
		List<Double> arrayOfTax = new ArrayList<>();
		List<Double> arrayOfAmtTotal_Dr = new ArrayList<>();
		List<Double> arrayOfAmtTotal_Cr = new ArrayList<>();
		List<Double> arrayOfCgst_Dr = new ArrayList<>();
		List<Double> arrayOfSGST_Dr = new ArrayList<>();
		List<Double> arrayOfIGST_Dr = new ArrayList<>();
		List<Double> arrayOfCgst_Cr = new ArrayList<>();
		List<Double> arrayOfSGST_Cr = new ArrayList<>();
		List<Double> arrayOfIGST_Cr = new ArrayList<>();
		double sumTax = 0,sumAmtTotal = 0,sumAmtTotal_Dr = 0,sumAmtTotal_Cr = 0,sumCGST_Dr = 0,
				sumSGST_Dr = 0,sumIGST_Dr = 0, cgstOther = 0, sgstOther = 0, igstOther = 0,
				sumCGST_Cr = 0,sumSGST_Cr = 0,sumIGST_Cr = 0, packingCharges = 0, transportCharges = 0, others = 0, sumCGST = 0, sumSGST = 0, sumIGST = 0, sumOtherItem = 0;
		try{
			for(int i=0;i<icdAmt_Debit.size();i++){
				String[] icdAmt = icdAmt_Debit.get(i).getAttribute("value").split("\\s+");
				amtTotal_Dr.add(icdAmt[0]);
				sNetCGST_Dr.add(icdCGSTAmt_Debit.get(i).getText());
				sNetSGST_Dr.add(icdSGSTAmt_Debit.get(i).getText());
				sNetIGST_Dr.add(icdIGSTAmt_Debit.get(i).getText());
				arrayOfAmtTotal_Dr.add(Double.parseDouble(amtTotal_Dr.get(i)));
				arrayOfCgst_Dr.add(Double.parseDouble(sNetCGST_Dr.get(i)));
				arrayOfSGST_Dr.add(Double.parseDouble(sNetSGST_Dr.get(i)));
				arrayOfIGST_Dr.add(Double.parseDouble(sNetIGST_Dr.get(i)));
				sumAmtTotal_Dr += arrayOfAmtTotal_Dr.get(i);
				sumAmtTotal_Dr = Math.round(sumAmtTotal_Dr * 100.0) / 100.0;
				sumCGST_Dr += arrayOfCgst_Dr.get(i);
				sumCGST_Dr = Math.round(sumCGST_Dr * 100.0) / 100.0;
				sumSGST_Dr += arrayOfSGST_Dr.get(i);
				sumSGST_Dr = Math.round(sumSGST_Dr * 100.0) / 100.0;
				sumIGST_Dr += arrayOfIGST_Dr.get(i);
				sumIGST_Dr = Math.round(sumIGST_Dr * 100.0) / 100.0;
			}
			for(int i=0;i<icdAmt_Credit.size();i++){
				String[] icdAmt = icdAmt_Credit.get(i).getAttribute("value").split("\\s+");
				amtTotal_Cr.add(icdAmt[0]);
				sNetCGST_Cr.add(icdCGSTAmt_Credit.get(i).getText());
				sNetSGST_Cr.add(icdSGSTAmt_Credit.get(i).getText());
				sNetIGST_Cr.add(icdIGSTAmt_Credit.get(i).getText());
				arrayOfAmtTotal_Cr.add(Double.parseDouble(amtTotal_Cr.get(i)));
				arrayOfCgst_Cr.add(Double.parseDouble(sNetCGST_Cr.get(i)));
				arrayOfSGST_Cr.add(Double.parseDouble(sNetSGST_Cr.get(i)));
				arrayOfIGST_Cr.add(Double.parseDouble(sNetIGST_Cr.get(i)));
				sumAmtTotal_Cr += arrayOfAmtTotal_Cr.get(i);
				sumAmtTotal_Cr = Math.round(sumAmtTotal_Cr * 100.0) / 100.0;
				sumCGST_Cr += arrayOfCgst_Cr.get(i);
				sumCGST_Cr = Math.round(sumCGST_Cr * 100.0) / 100.0;
				sumSGST_Cr += arrayOfSGST_Cr.get(i);
				sumSGST_Cr = Math.round(sumSGST_Cr * 100.0) / 100.0;
				sumIGST_Cr += arrayOfIGST_Cr.get(i);
				sumIGST_Cr = Math.round(sumIGST_Cr * 100.0) / 100.0;
			}
			if(sOtherItem.contains("Debit")){
				sumOtherItem = Double.parseDouble(noteAmt.get(0).getAttribute("value"));
				sumAmtTotal_Dr += sumOtherItem;
				cgstOther = Double.parseDouble(icdOtherAmt_Cgst.getText());
				sgstOther = Double.parseDouble(icdOtherAmt_Sgst.getText());
				igstOther = Double.parseDouble(icdOtherAmt_Igst.getText());
				sumCGST_Dr += cgstOther;
				sumSGST_Dr += sgstOther;
				sumIGST_Dr += igstOther;
			}else if(sOtherItem.contains("Credit")){
				sumOtherItem = Double.parseDouble(noteAmt.get(0).getAttribute("value"));
				sumAmtTotal_Cr += sumOtherItem;
				cgstOther = Double.parseDouble(icdOtherAmt_Cgst.getText());
				sgstOther = Double.parseDouble(icdOtherAmt_Sgst.getText());
				igstOther = Double.parseDouble(icdOtherAmt_Igst.getText());
				sumCGST_Cr += cgstOther;
				sumSGST_Cr += sgstOther;
				sumIGST_Cr += igstOther;
			}
			sumAmtTotal = sumAmtTotal_Dr - sumAmtTotal_Cr;
			sumAmtTotal = Math.round(sumAmtTotal * 100.0) / 100.0;
			sumAmtTotal = Math.abs(sumAmtTotal);
			sumCGST = sumCGST_Dr - sumCGST_Cr;
			sumCGST = Math.round(sumCGST * 100.0) / 100.0;
			sumCGST = Math.abs(sumCGST);
			sumSGST = sumSGST_Dr - sumSGST_Cr;
			sumSGST = Math.round(sumSGST * 100.0) / 100.0;
			sumSGST = Math.abs(sumSGST);
			sumIGST = sumIGST_Dr - sumIGST_Cr;
			sumIGST = Math.round(sumIGST * 100.0) / 100.0;
			sumIGST = Math.abs(sumIGST);
			for(int i=0;i<icdTaxList.size();i++){
				tax.add(icdTaxList.get(i).getAttribute("value"));
				arrayOfTax.add(Double.parseDouble(tax.get(i)));
				sumTax += arrayOfTax.get(i);
			}
			String[] sicdTotalAmt = icdTotalAmt.getText().split("\\s+");
			if(sicdTotalAmt[0].contains(Double.toString(sumAmtTotal)) &&
					cgstTotalAmt.getText().contains(Double.toString(sumCGST)) && sgstTotalAmt.getText().contains(Double.toString(sumSGST)) &&
					igstTotalAmt.getText().contains(Double.toString(sumIGST))){
				String sGrandTotal = grnGrandTotal.getAttribute("value");
				double Total = sumTax+sumAmtTotal+sumCGST+sumSGST+sumIGST+packingCharges+transportCharges+others;
				double roundOff = Math.round(Total * 100.0) / 100.0;
				if(roundOff == Double.parseDouble(sGrandTotal)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Grand total validation failed "+e);
		}
		return flag;
	}

	public boolean icdVerify(String sGRNNo, String sStatus){
		boolean flag = false;
		String[] options = null;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			if(sGRNNo == null){
				options = selectICD_EditPage(sStatus, "GRN");
				sGRNNo = options[0];
				i = Integer.parseInt(options[1])+1;
			}else{
				i = icdList.size();
				filterText.sendKeys(sGRNNo);
				driver.findElement(By.xpath("//mark[text()='"+sGRNNo+"']")).click();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(viewNoteBtn), "Failed to load ICD edit page");
			if(driver.findElement(By.xpath(".//span[text()='"+sGRNNo+"']")).isDisplayed()){
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(Constant.Min_Sleep);
				viewNoteBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(verifyBtn), "Failed to load ICD pdf popup");
				Thread.sleep(Constant.Min_Sleep);
				if(driver.getPageSource().contains("No Note generated for this Receipt.") || icdPDf.isDisplayed()){
					verifyBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load ICD pdf popup");
					Thread.sleep(Constant.Min_Sleep);
					okButton.sendKeys(Keys.ENTER);
					Constant.waitFor(ExpectedConditions.visibilityOf(noteVerifiedTxt), "Failed to load ICD pdf popup");
					Thread.sleep(Constant.Min_Sleep);
					if(noteVerifiedTxt.isDisplayed()){
						closeBtnPDf.click();
						Thread.sleep(Constant.Min_Sleep);
						js.executeScript("window.scrollBy(0,-5000)");
						backBtnICD.click();
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
						navigate.showAllEntries();
						js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[contains(text(),'"+sGRNNo+"')]/following::td[7]")));
						if(icdGRNList.get(i-1).getText().contains("Verified")){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("ICD verify failed "+e);
		}
		return flag;
	}

	public boolean RejectPartyAck(String sGRNNo, String sStatus){
		boolean flag = false;
		String[] options = null;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			if(sGRNNo == null){
				options = selectICD_EditPage(sStatus, "GRN");
				sGRNNo = options[0];
				i = Integer.parseInt(options[1])+1;
			}else{
				i = icdList.size();
				filterText.sendKeys(sGRNNo);
				driver.findElement(By.xpath("//mark[text()='"+sGRNNo+"']")).click();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(viewNoteBtn), "Failed to load ICD edit page");
			if(driver.findElement(By.xpath(".//span[text()='"+sGRNNo+"']")).isDisplayed()){
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(Constant.Min_Sleep);
				viewNoteBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(rejectPartyAcknNote), "Failed to load ICD pdf popup");
				Thread.sleep(Constant.Min_Sleep);
				if(driver.getPageSource().contains("No Note generated for this Receipt.") || icdPDf.isDisplayed()){
					partyIcdRejectRemarks.sendKeys("Automation "+sDate);
					rejectPartyAcknNote.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load ICD pdf popup");
					Thread.sleep(Constant.Min_Sleep);
					okBtn.sendKeys(Keys.ENTER);
					Constant.waitFor(ExpectedConditions.visibilityOf(notePartyRejected), "Failed to load ICD pdf popup");
					Thread.sleep(Constant.Min_Sleep);
					if(notePartyRejected.isDisplayed()){
						closeBtnPDf.click();
						Thread.sleep(Constant.Min_Sleep);
						js.executeScript("window.scrollBy(0,-5000)");
						backBtnICD.click();
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
						navigate.showAllEntries();
						js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[contains(text(),'"+sGRNNo+"')]/following::td[7]")));
						if(icdGRNList.get(i-1).getText().contains("Party Rejected")){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("ICD verify failed "+e);
		}
		return flag;
	}

	public String[] selectICD_EditPage(String sStatus, String type) throws InterruptedException{
		String sGRNNo = null; int i;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(i=0;i<grnNoList.size();i++){
			js.executeScript("arguments[0].scrollIntoView(true);",grnNoList.get(i));
			if(driver.getPageSource().contains(" Internal Control ")){
				if(grnNoList.get(i).getText().contains(type)){
					sGRNNo = grnNoList.get(i).getText();
					if(driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[8]")).getText().equals(sStatus)){
						grnNoList.get(i).click();
						Thread.sleep(Constant.Min_Sleep);
						break;
					}

				}
			}else{
				if(type == "IAN"){
					if(grnNoList.get(i).getText().contains(type)){
						if(!(refNoList.get(i).getText().contains("GRN") ||refNoList.get(i).getText().contains("SR"))){
							sGRNNo = grnNoList.get(i).getText();
							if(driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[8]")).getText().equals(sStatus)){
								grnNoList.get(i).click();
								Thread.sleep(Constant.Min_Sleep);
								break;
							}
						}
					}
				}else{
					if(refNoList.get(i).getText().contains("GRN") || refNoList.get(i).getText().contains("SR")){
						sGRNNo = refNoList.get(i).getText();
						if(driver.findElement(By.xpath("//*[contains(text(),'"+sGRNNo+"')]/following::td[7]")).getText().equals(sStatus)){
							grnNoList.get(i).click();
							Thread.sleep(Constant.Min_Sleep);
							break;
						}
					}
				}
			}
		}
		return new String[] {sGRNNo, String.valueOf(i)};
	}

	public String[] selectICD_PDF(String sStatus, String type) throws InterruptedException{
		String sGRNNo = null; int i;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(i=0;i<icdGRNList.size();i++){
			js.executeScript("arguments[0].scrollIntoView(true);", icdGRNList.get(i));
			if(driver.getPageSource().contains(" Internal Control ")){
				if(icdGRNList.get(i).getText().contains(sStatus)){
					if(grnNoList.get(i).getText().contains(type)){
						sGRNNo = grnNoList.get(i).getText();
						Thread.sleep(Constant.Min_Sleep);
						Actions actions = new Actions(driver);
						actions.moveToElement(icdGRNList.get(i)).perform();
						actions.moveToElement(icdPreviewIcon.get(i)).perform();
						icdPreviewIcon.get(i).click();
						Thread.sleep(Constant.Min_Sleep);
						break;
					}
				}
			}else{
				if(type == "IAN"){
					if(icdGRNList.get(i).getText().contains(sStatus)){
						if(!(refNoList.get(i).getText().contains("GRN") ||refNoList.get(i).getText().contains("SR"))){
							if(grnNoList.get(i).getText().contains(type)){
								sGRNNo = grnNoList.get(i).getText();
								Actions actions = new Actions(driver);
								actions.moveToElement(icdGRNList.get(i)).perform();
								actions.moveToElement(icdPreviewIcon.get(i)).perform();
								icdPreviewIcon.get(i).click();
								Thread.sleep(Constant.Min_Sleep);
								break;
							}
						}
					}
				}else{
					if(refNoList.get(i).getText().contains("GRN") || refNoList.get(i).getText().contains("SR")){
						if(icdGRNList.get(i).getText().contains(sStatus)){
							sGRNNo = refNoList.get(i).getText();
							if(driver.findElement(By.xpath("//*[contains(text(),'"+sGRNNo+"')]/following::td[7]")).getText().contains(sStatus)){
								Actions actions = new Actions(driver);
								actions.moveToElement(icdGRNList.get(i)).perform();
								actions.moveToElement(icdPreviewIcon.get(i)).perform();
								icdPreviewIcon.get(i).click();
								Thread.sleep(Constant.Min_Sleep);
								break;
							}
						}
					}
				}
			}
		}
		return new String[] {sGRNNo, String.valueOf(i)};
	}

	public String[] selectICD_0Note(String sStatus, String type) throws InterruptedException{
		String sGRNNo = null; int i;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(i=0;i<icdGRNList.size();i++){
			js.executeScript("arguments[0].scrollIntoView(true);", icdGRNList.get(i));
			if(icdGRNList.get(i).getText().contains(sStatus)){
				if(grnNoList.get(i).getText().contains(type) && icdNoteValueList.get(i).getText().trim().equals("0.00")){
					sGRNNo = grnNoList.get(i).getText();
					Actions actions = new Actions(driver);
					actions.moveToElement(icdGRNList.get(i)).perform();
					actions.moveToElement(icdPreviewIcon.get(i)).perform();
					icdPreviewIcon.get(i).click();
					Thread.sleep(Constant.Min_Sleep);
					break;
				}
			}
		}
		return new String[] {sGRNNo, String.valueOf(i)};
	}



	public boolean returnICD(int iRowNo, String sheet, String sGRNNo, String sStatus){
		boolean flag = false;
		String[] options = null;
		int i;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			if(sGRNNo == null){
				options = selectICD_PDF(sStatus, "GRN");
				sGRNNo = options[0];
				i = Integer.parseInt(options[1])+1;
			}else{
				for(i=0;i<icdGRNList.size();i++){
					js.executeScript("arguments[0].scrollIntoView(true);", icdGRNList.get(i));
					if(grnNoList.get(i).getText().contains(sGRNNo)){
						Actions actions = new Actions(driver);
						actions.moveToElement(icdGRNList.get(i)).perform();
						actions.moveToElement(icdPreviewIcon.get(i)).perform();
						icdPreviewIcon.get(i).click();
						Thread.sleep(Constant.Min_Sleep);
						i = i+1;
						break;
					}
				}
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(returnNoteBtn), "Failed to load ICD view page");
			Thread.sleep(Constant.Min_Sleep);
			if(icdPDf.isDisplayed()){
				icdRemarksTxtField.sendKeys("Automation "+sDate);
				returnNoteBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load ICD view page");
				Thread.sleep(Constant.Min_Sleep);
				okButton.sendKeys(Keys.ENTER);
				Constant.waitFor(ExpectedConditions.visibilityOf(icdReturnText_Pdf), "Failed to load ICD pdf");
				String sReturnText = icdReturnText_Pdf.getText();
				closeBtnPDf.click();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", icdGRNList.get(i-1));
				Thread.sleep(Constant.Min_Sleep);
				if(icdGRNList.get(i-1).getText().contains("Returned") && sReturnText.contains("Note Returned!") ){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to return ICD "+e);
		}
		return flag;
	}

	public boolean checkReturnedICd_WithoutChange(){
		boolean flag = false;
		String[] options = null;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			options = selectICD_EditPage("Returned", "GRN");
			if(driver.findElement(By.xpath(".//span[text()='"+options[0]+"']")).isDisplayed()){
				js.executeScript("window.scrollBy(0,-5000)");
				invoiceTab.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMatDetails_InvoiceTab), "Failed to load all materials in invoice tab");
				Thread.sleep(Constant.Min_Sleep);
				invoiceTaxDetailsCheck.get(invoiceTaxDetailsCheck.size()-1).click();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("window.scrollBy(0,-5000)");
				invoiceTab.click();
				String sNetValue = netValue.getAttribute("value");
				checkedOkBtn.click();
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
				navigate.showAllEntries();
				js.executeScript("arguments[0].scrollIntoView(true);", icdGRNList.get(Integer.parseInt(options[1])));
				String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(Integer.parseInt(options[1])+1)+"]/td[10]")).getText();
				sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
				if(!sActNoteValue.contains(".")){
					sActNoteValue = sActNoteValue+".00";
				}
				if(icdGRNList.get(Integer.parseInt(options[1])).getText().contains("Checked") && sActNoteValue.contains(sNetValue) &&
						driver.findElement(By.xpath("//td/a[contains(text(),'"+options[0]+"')]/following::td[8]/a")).getText().contains("Checked")){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check returned ICd without updation "+e);
		}
		return flag;
	}

	public boolean addOtherItem(int iRowNo, String sSheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(), sSheet);
		String sItem = xls.get(iRowNo).get("Other Item");
		try{
			addOtherItem.click();
			otherTxtField.sendKeys("Test"+sDate);
			noteQty.get(0).sendKeys(Keys.CONTROL+"a");
			noteQty.get(0).sendKeys(Keys.DELETE);
			noteQty.get(0).sendKeys("10");
			noteRate.get(0).sendKeys(Keys.CONTROL+"a");
			noteRate.get(0).sendKeys(Keys.DELETE);
			noteRate.get(0).sendKeys("12");
			noteQty.get(0).click();
			otherHsnCode.get(0).sendKeys(sDate);
			if(sItem.contains("Credit")){
				isCreditChckBx.click();
			}
			String sActAmt = noteAmt.get(0).getAttribute("value");
			Double rate = 12.00 * 10;
			rate = Math.round(rate * 100.0) / 100.0;
			if(sActAmt.contains(Double.toString(rate))){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to add other item "+e);
		}
		return flag;
	}

	public boolean checkReturnedICd_addOtherItem(int iRowNo, String sSheet){
		boolean flag = false, flag1, flag2, flag3, flag4;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(), sSheet);
		String sItem = xls.get(iRowNo).get("Other Item");
		String[] options = null;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			options = selectICD_EditPage("Returned", "GRN");
			Constant.waitFor(ExpectedConditions.elementToBeClickable(invoiceTab), "Failed to load ICD view page");
			if(driver.findElement(By.xpath(".//span[text()='"+options[0]+"']")).isDisplayed()){
				js.executeScript("window.scrollBy(0,-5000)");
				invoiceTab.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMatDetails_InvoiceTab), "Failed to load all materials in invoice tab");
				Thread.sleep(Constant.Min_Sleep);
				invoiceTaxDetailsCheck.get(invoiceTaxDetailsCheck.size()-1).click();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("window.scrollBy(0,-5000)");
				invoiceTab.click();
				Thread.sleep(Constant.Min_Sleep);
				flag1 = addOtherItem(iRowNo, sSheet);
				flag2 = vaidateOtherGST(iRowNo, sSheet);
				grnRoundOff.clear();
				grnRoundOff.sendKeys("0.00");
				grnGrandTotal.click();
				flag3 = validateGrandTotal_Note(sItem);
				flag4 = roundOff(grnGrandTotal,grnRoundOff);
				String sNetValue = netValue.getAttribute("value");
				if(flag1 && flag2 && flag3 && flag4){
					checkedOkBtn.click();
					if(Constant.isAlertPresents()){
						driver.switchTo().alert().accept();
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);", icdGRNList.get(Integer.parseInt(options[1])));
					String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(Integer.parseInt(options[1])+1)+"]/td[10]")).getText();
					sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
					if(!sActNoteValue.contains(".")){
						sActNoteValue = sActNoteValue+".00";
					}
					if(icdGRNList.get(Integer.parseInt(options[1])).getText().contains("Checked") && sActNoteValue.contains(sNetValue)
							&& driver.findElement(By.xpath("//td/a[contains(text(),'"+options[0]+"')]/following::td[8]/a")).getText().contains("Checked")){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check returned ICd without updation "+e);
		}
		return flag;
	}

	public boolean checkReturnedICD(int iRowNo, String sheet, String sGRNNo) throws Exception{
		boolean flag = false, flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag6,flag7;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("Tax");
		String[] options = null;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			if(sGRNNo == null){
				options = selectICD_EditPage("Returned", "GRN");
				sGRNNo = options[0];
				i = Integer.parseInt(options[1])+1;
			}else{
				i = icdList.size();
				filterText.sendKeys(sGRNNo);
				driver.findElement(By.xpath("//mark[text()='"+sGRNNo+"']")).click();
				Thread.sleep(Constant.Min_Sleep);
			}
			if(driver.findElement(By.xpath(".//span[text()='"+sGRNNo+"']")).isDisplayed()){
				js.executeScript("window.scrollBy(0,-5000)");
				invoiceTab.click();
				Thread.sleep(Constant.Min_Sleep);
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMatDetails_InvoiceTab), "Failed to load all materials in invoice tab");
				Thread.sleep(Constant.Min_Sleep);
				invoiceTaxDetailsCheck.get(invoiceTaxDetailsCheck.size()-1).click();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("window.scrollBy(0,-5000)");
				invoiceTab.click();
				Thread.sleep(Constant.Min_Sleep);
				if(icdAutoRate.size() > 0){
					flag1 = validateNoteDetails();
					Thread.sleep(Constant.Min_Sleep);
					flag2 = validateGST(iRowNo, sheet);
					Thread.sleep(Constant.Min_Sleep);
					grnRoundOff.clear();
					grnRoundOff.sendKeys("0.00");
					grnGrandTotal.click();
					flag7 = validateGrandTotal_ICD();
					boolean flag5 = Constant.isElementPresent(By.xpath(".//*[@id='note_taxes_table']/tbody/tr[1]/th[2]/b"));
					if(!flag5){
						selectTaxDrpDwn.click();
						searchTaxField.sendKeys(sTax);
						driver.findElement(By.xpath(".//em[text()='"+sTax+"']")).click();
						addICDTaxBtn.click();
					}
					flag6 = roundOff(grnGrandTotal,grnRoundOff);
				}else{
					flag1 = true; flag6 = true;
					flag2 = true; flag7 = true;
				}
				if(flag1 && flag2){
					remarks.sendKeys("Test"+sDate);
					Thread.sleep(Constant.Min_Sleep);
					String sNetValue = netValue.getAttribute("value");
					receiptTab.click();
					Thread.sleep(Constant.Min_Sleep);
					if(grnPDf.isDisplayed()){
						receiptTab.click();
						flag3 = true;
					}
					Thread.sleep(Constant.Min_Sleep);
					if(poTab.isDisplayed()){
						poTab.click();
						Thread.sleep(Constant.Min_Sleep);
						if(poPDF.isDisplayed()){
							poTab.click();
							flag4 = true;
						}
						Thread.sleep(Constant.Min_Sleep);
					}else{flag4 = true;}
					checkedOkBtn.click();
					if(Constant.isAlertPresents()){
						driver.switchTo().alert().accept();
					}
 					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
 					Thread.sleep(Constant.Min_Sleep);
 					navigate.showAllEntries();
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[8]")));
					String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(i)+"]/td[10]")).getText();
					sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
					if(!sActNoteValue.contains(".")){
						sActNoteValue = sActNoteValue+".00";
					}
					if((icdGRNList.get(i-1).getText().contains("Checked") || icdGRNList.get(i-1).getText().contains("Party Acknowledgement Pending")) && flag3 && flag4 &&
							sActNoteValue.contains(sNetValue) && flag6 && flag7 &&
							(driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[8]/a")).getText().contains("Checked") ||
									driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[8]/a")).getText().contains("Party Acknowledgement Pending"))){
						flag = true;
					}
					if(icdGRNList.get(i-1).getText().contains("Checked") && flag3 && flag4 &&
							sActNoteValue.contains(sNetValue) && flag6 && flag7 &&
							driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[8]/a")).getText().contains("Checked")){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check returned ICD "+e);
		}
		return flag;
	}

	public boolean returnManualNote(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			approveNote_Editpage(iRowNo, sheet);
			int i = icdList.size();
			String sGRNNo = grnNoList.get(i-1).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(icdGRNList.get(i-1)).perform();
			actions.moveToElement(icdPreviewIcon.get(i-1)).perform();
			icdPreviewIcon.get(i-1).click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(returnNoteBtn), "Failed to load PDf");
			Thread.sleep(Constant.Min_Sleep);
			if(icdPDf.isDisplayed()){
				icdRemarksTxtField.sendKeys("Automation "+sDate);
				returnNoteBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Constant.waitFor(ExpectedConditions.visibilityOf(icdReturnText_Pdf), "Failed to load PDf");
				String sReturnText = icdReturnText_Pdf.getText();
				closeBtnPDf.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				js.executeScript("arguments[0].scrollIntoView(true);", icdGRNList.get(i-1));
				if(icdGRNList.get(i-1).getText().contains("Returned") && sReturnText.contains("Note Returned!") &&
						driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[8]/a")).getText().contains("Returned")){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to return ICD "+e);
		}
		return flag;
	}

	public boolean addNoteDescription(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReason = xls.get(iRowNo).get("Reason");
		String sQty = xls.get(iRowNo).get("Quantity");
		String sRate = xls.get(iRowNo).get("Price");
		String sUnit = xls.get(iRowNo).get("Unit");
		String sMatCount = xls.get(iRowNo).get("Material Count");
		double Amt;
		try{
			for(int j=0;j<Integer.parseInt(sMatCount);j++){
				String sRandomChar = RandomStringUtils.randomNumeric(5);
				descriptionTxtField.sendKeys("Material Desc"+sRandomChar);
				Select select = new Select(resonDropDwn);
				select.selectByVisibleText(sReason);
				qtyTxtField.sendKeys(Keys.CONTROL+"a");
				qtyTxtField.sendKeys(Keys.DELETE);
				qtyTxtField.sendKeys(sQty);
				noteHSNCodeField.sendKeys(sDate);
				Select unit = new Select(unitTxtDropDwn);
				unit.selectByVisibleText(sUnit);
				rateTxtField.sendKeys(Keys.CONTROL+"a");
				rateTxtField.sendKeys(Keys.DELETE);
				rateTxtField.sendKeys(sRate);
				Amt = Double.parseDouble(sRate) * Double.parseDouble(sQty);
 				qtyTxtField.click();
				Thread.sleep(Constant.Min_Sleep);
				String sActAmt = manualNoteAmt.getAttribute("value");
				addNoteBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Amt == Double.parseDouble(sActAmt)){
					for(int i=2;i<manualNoteItemList.size();i++){
						if(manualNoteItemList.get(i).getAttribute("value").contains("Material Desc"+sRandomChar)){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Manual note description addition failed "+e);
		}
		return flag;
	}

	public boolean createNote(int iRowNo,String sheet) throws Exception{
		boolean flag = false, flag1;
		String sTotal;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			int iGRNList = grnNoList.size();
			noteBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(noteCreationPage.isDisplayed()){
				flag1 = addManualNoteDetails(iRowNo, sheet);
				sTotal = noteGrandTotalTxtField.getAttribute("value");
				saveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
				navigate.showAllEntries();
				int iGRNActList = grnNoList.size();
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+iGRNActList+"]/td[10]")));
				String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+iGRNActList+"]/td[10]")).getText();
				sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
				if(!sActNoteValue.contains(".")){
					sActNoteValue = sActNoteValue+".00";
				}
				if(icdGRNList.get(iGRNActList-1).getText().contains("Pending") && iGRNActList > iGRNList &&
						sTotal.contains(sActNoteValue) && flag1){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("unable to create Note" +e);
		}
		return flag;
	}

	public boolean checkReturnedNote_AddItems(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1 = false, flag2 = false, flag6,flag7;
		String[] options = null;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(), sheet);
		String sItem = xls.get(iRowNo).get("Other Item");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
			navigate.showAllEntries();
			options = selectICD_EditPage("Returned", "IAN");
			if(driver.findElement(By.xpath(".//span[text()='"+options[0]+"']")).isDisplayed()){
				js.executeScript("window.scrollBy(0,-2000)");
				Thread.sleep(Constant.Medium_Sleep);
				invoiceTaxDetailsCheck.get(invoiceTaxDetailsCheck.size()-1).click();
				Thread.sleep(Constant.Min_Sleep);
//				if(noteRate_EditPg.size() > 0){
					flag1 = addOtherItem(iRowNo, sheet);
					flag2 = vaidateOtherGST(iRowNo, sheet);
					grnRoundOff.clear();
					grnRoundOff.sendKeys("0.00");
					grnGrandTotal.click();
					flag7 = validateGrandTotal_Note(sItem);
					flag6 = roundOff(grnGrandTotal,grnRoundOff);
//				}else{
//					flag1 = true; flag6 = true;
//					flag2 = true; flag7 = true;
//				}
				if(flag1 && flag2){
					String sNetValue = netValue.getAttribute("value");
					checkedOkBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(Constant.isElementPresent(By.id("btn-sa-confirm"))){
						okBtn.click();
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
					navigate.showAllEntries();
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("arguments[0].scrollIntoView(true);", icdGRNList.get(Integer.parseInt(options[1])));
					String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(Integer.parseInt(options[1])+1)+"]/td[10]")).getText();
					sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
					if(!sActNoteValue.contains(".")){
						sActNoteValue = sActNoteValue+".00";
					}
					if(icdGRNList.get(Integer.parseInt(options[1])).getText().contains("Checked") &&
							sActNoteValue.contains(sNetValue) && flag6 && flag7){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check returned manual note by adding items "+e);
		}
		return flag;
	}

	public boolean checkReturnedNote_DeleteItems(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1 = false, flag2 = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			returnManualNote(iRowNo, sheet);
			int i = icdList.size();
			String sGRNNo = grnNoList.get(i-1).getText();
			grnNoList.get(i-1).click();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[text()='"+sGRNNo+"']")).isDisplayed()){
				js.executeScript("window.scrollBy(0,-2000)");
				Thread.sleep(Constant.Min_Sleep);
				invoiceTaxDetailsCheck.get(invoiceTaxDetailsCheck.size()-1).click();
				Thread.sleep(Constant.Min_Sleep);
				if(noteRate_EditPg.size() > 1){
					noteRate_EditPg.get(0).clear();
					grnRoundOff.clear();
					grnRoundOff.sendKeys("0.00");
					grnGrandTotal.click();
//					flag1 = validateGrandTotal_CheckedNote();
					flag1 = validateGrandTotal_ICD();
					flag2 = roundOff(grnGrandTotal,grnRoundOff);
				}else{
					flag1 = true; flag2 = true;
				}
				if(flag1 && flag2){
					String sNetValue = netValue.getAttribute("value");
					checkedOkBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
					navigate.showAllEntries();
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("arguments[0].scrollIntoView(true);", icdGRNList.get(i-1));
					String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(i)+"]/td[10]")).getText();
					sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
					if(!sActNoteValue.contains(".")){
						sActNoteValue = sActNoteValue+".00";
					}
					if(icdGRNList.get(i-1).getText().contains("Checked") && sActNoteValue.contains(sNetValue)){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check returned manual note by deleting items "+e);
		}
		return flag;
	}

	public boolean checkReturnedNote_AddNDeleteItems(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1 = false, flag2 = false, flag3 = false, flag4 = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			returnManualNote(iRowNo, sheet);
			int i = icdList.size();
			String sGRNNo = grnNoList.get(i-1).getText();
			grnNoList.get(i-1).click();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[text()='"+sGRNNo+"']")).isDisplayed()){
				js.executeScript("window.scrollBy(0,-2000)");
				Thread.sleep(Constant.Medium_Sleep);
				invoiceTaxDetailsCheck.get(invoiceTaxDetailsCheck.size()-1).click();
				Thread.sleep(Constant.Min_Sleep);
				if(noteRate_EditPg.size() > 0){
					noteRate_EditPg.get(0).clear();
					flag1 = addOtherItem(iRowNo, sheet);
					flag2 = vaidateOtherGST(iRowNo, sheet);
					grnRoundOff.clear();
					grnRoundOff.sendKeys("0.00");
					grnGrandTotal.click();
					flag3 = validateGrandTotal_CheckedNote();
					flag4 = roundOff(grnGrandTotal,grnRoundOff);
				}else{
					flag1 = true;
					flag2 = true;
				}
				if(flag1 && flag2 && flag3 && flag4){
					String sNetValue = netValue.getAttribute("value");
					checkedOkBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
					navigate.showAllEntries();
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("arguments[0].scrollIntoView(true);", icdGRNList.get(i-1));
					String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(i)+"]/td[10]")).getText();
					sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
					if(!sActNoteValue.contains(".")){
						sActNoteValue = sActNoteValue+".00";
					}
					if(icdGRNList.get(i-1).getText().contains("Checked") &&
							sActNoteValue.contains(sNetValue)){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check returned manual note by deleting items "+e);
		}
		return flag;
	}

	public boolean checkReturnedNote(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1 = false, flag2 = false, flag6,flag7;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("Tax");
		String[] options = null;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
			navigate.showAllEntries();
			options = selectICD_EditPage("Returned", "IAN");
			if(driver.findElement(By.xpath(".//span[text()='"+options[0]+"']")).isDisplayed()){
				js.executeScript("window.scrollBy(0,-2000)");
				Thread.sleep(Constant.Max_Sleep);
				invoiceTaxDetailsCheck.get(invoiceTaxDetailsCheck.size()-1).click();
				Thread.sleep(Constant.Min_Sleep);
				if(icdRate.size() > 0){
					flag1 = validateNoteDetails();
					Thread.sleep(Constant.Min_Sleep);
					flag2 = validateGST(iRowNo, sheet);
					Thread.sleep(Constant.Min_Sleep);
					grnRoundOff.clear();
					grnRoundOff.sendKeys("0.00");
					grnGrandTotal.click();
					flag7 = validateGrandTotal_CheckedNote();
					boolean flag5 = Constant.isElementPresent(By.xpath(".//*[@id='note_taxes_table']/tbody/tr[1]/th[2]/b"));
					if(!flag5){
						selectTaxDrpDwn.click();
						searchTaxField.sendKeys(sTax);
						driver.findElement(By.xpath(".//em[text()='"+sTax+"']")).click();
						addICDTaxBtn.click();
					}
					flag6 = roundOff(grnGrandTotal,grnRoundOff);
				}else{
					flag1 = true; flag6 = true;
					flag2 = true; flag7 = true;
				}
				if(flag1 && flag2){
					remarks.sendKeys("Test"+sDate);
					String sNetValue = netValue.getAttribute("value");
					checkedOkBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(Constant.isAlertPresents()){
						driver.switchTo().alert().accept();
					}
					Thread.sleep(Constant.Min_Sleep);
					if(Constant.isElementPresent(By.id("btn-sa-confirm"))){
						okBtn.click();
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
					navigate.showAllEntries();
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("arguments[0].scrollIntoView(true);", icdGRNList.get(Integer.parseInt(options[1])));
					String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(Integer.parseInt(options[1])+1)+"]/td[10]")).getText();
					sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
					if(!sActNoteValue.contains(".")){
						sActNoteValue = sActNoteValue+".00";
					}
					if(icdGRNList.get(Integer.parseInt(options[1])).getText().contains("Checked") &&
							sActNoteValue.contains(sNetValue) && flag6 && flag7){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check returned manual note "+e);
		}
		return flag;
	}

	public boolean addCGSTTax(int iRowNo,int iPosition,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("CGST");
		try{
			Select select = new Select(driver.findElement(By.id("id_note_item_tax_"+iPosition+"-0-rate_drop_down")));
			select.selectByValue(sTax);
			String sValue = driver.findElement(By.id("id_note_item_tax_"+iPosition+"-0-amount")).getAttribute("value");
			String sTotal = driver.findElement(By.id("id_note_item-"+iPosition+"-amount_display")).getAttribute("value");
			String sPercent = driver.findElement(By.id("id_note_item_tax_"+iPosition+"-0-rate")).getAttribute("value");
			double dCgst = Double.parseDouble(sTotal)*Double.parseDouble(sPercent)/100;
			double dRoundOff = Math.round(dCgst * 100.0) / 100.0;
			if(dRoundOff == Double.parseDouble(sValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("CGST tax addition for note failed "+e);
		}
		return flag;
	}

	public boolean addSGSTTax(int iRowNo, int iPosition,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("SGST");
		try{
			Select select = new Select(driver.findElement(By.id("id_note_item_tax_"+iPosition+"-1-rate_drop_down")));
			select.selectByValue(sTax);
			String sValue = driver.findElement(By.id("id_note_item_tax_"+iPosition+"-1-amount")).getAttribute("value");
			String sTotal = driver.findElement(By.id("id_note_item-"+iPosition+"-amount")).getAttribute("value");
			String sPercent = driver.findElement(By.id("id_note_item_tax_"+iPosition+"-1-rate")).getAttribute("value");
			double dSgst = Double.parseDouble(sTotal)*Double.parseDouble(sPercent)/100;
			double dRoundOff = Math.round(dSgst * 100.0) / 100.0;
			if(dRoundOff == Double.parseDouble(sValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("SGST tax addition for note failed "+e);
		}
		return flag;
	}

	public boolean addIGSTTax(int iRowNo, int iPosition, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("IGST");
		try{
			Select select = new Select(driver.findElement(By.id("id_note_item_tax_"+iPosition+"-2-rate_drop_down")));
			select.selectByValue(sTax);
			String sValue = driver.findElement(By.id("id_note_item_tax_"+iPosition+"-2-amount")).getAttribute("value");
			String sTotal = driver.findElement(By.id("id_note_item-"+iPosition+"-amount")).getAttribute("value");
			String sPercent = driver.findElement(By.id("id_note_item_tax_"+iPosition+"-2-rate")).getAttribute("value");
			double dIgst = Double.parseDouble(sTotal)*Double.parseDouble(sPercent)/100;
			double dRoundOff = Math.round(dIgst * 100.0) / 100.0;
			if(dRoundOff == Double.parseDouble(sValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("IGST tax addition for note failed "+e);
		}
		return flag;
	}

	public boolean validateGrandTotal_Note(){
		boolean flag = false;
		ArrayList<String> tax = new ArrayList<>();
		ArrayList<String> sTotal = new ArrayList<>();
		ArrayList<String> sNetCGST = new ArrayList<>();
		ArrayList<String> sNetSGST = new ArrayList<>();
		ArrayList<String> sNetIGST = new ArrayList<>();
		List<Double> arrayOfTax = new ArrayList<>();
		List<Double> arrayOfTotal = new ArrayList<>();
		List<Double> arrayOfCgst = new ArrayList<>();
		List<Double> arrayOfSGST = new ArrayList<>();
		List<Double> arrayOfIGST = new ArrayList<>();
		double sumTax = 0,sumTotal = 0,sumCGST = 0,sumSGST = 0,sumIGST = 0;
		try{
			for(int i=0;i<manualNoteAmtList.size()-2;i++){
				sTotal.add(manualNoteAmtList.get(i+2).getAttribute("value"));
				sNetCGST.add(cgstAmtList.get(i+1).getAttribute("value"));
				sNetSGST.add(sgstAmtList.get(i+1).getAttribute("value"));
				sNetIGST.add(igstAmtList.get(i+1).getAttribute("value"));
				arrayOfTotal.add(Double.parseDouble(sTotal.get(i)));
				arrayOfCgst.add(Double.parseDouble(sNetCGST.get(i)));
				arrayOfSGST.add(Double.parseDouble(sNetSGST.get(i)));
				arrayOfIGST.add(Double.parseDouble(sNetIGST.get(i)));
				sumTotal += arrayOfTotal.get(i);
				sumCGST += arrayOfCgst.get(i);
				sumSGST += arrayOfSGST.get(i);
				sumIGST += arrayOfIGST.get(i);
			}
			for(int i=0;i<taxAmtList.size();i++){
				tax.add(taxAmtList.get(i).getAttribute("value"));
				arrayOfTax.add(Double.parseDouble(tax.get(i)));
				sumTax += arrayOfTax.get(i);
			}
			String sGrandTotal = noteGrandTotalTxtField.getAttribute("value");
			double Total = sumTax+sumTotal+sumCGST+sumSGST+sumIGST;
			double roundOff = Math.round(Total * 100.0) / 100.0;
			if(roundOff == Double.parseDouble(sGrandTotal)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("failed to validate grand total "+e);
		}
		return flag;
	}

	public boolean validateGrandTotal_CheckedNote(){
		boolean flag = false;
		ArrayList<String> tax = new ArrayList<>();
		ArrayList<String> sTotal = new ArrayList<>();
		ArrayList<String> sNetCGST = new ArrayList<>();
		ArrayList<String> sNetSGST = new ArrayList<>();
		ArrayList<String> sNetIGST = new ArrayList<>();
		List<Double> arrayOfTax = new ArrayList<>();
		List<Double> arrayOfTotal = new ArrayList<>();
		List<Double> arrayOfCgst = new ArrayList<>();
		List<Double> arrayOfSGST = new ArrayList<>();
		List<Double> arrayOfIGST = new ArrayList<>();
		double sumTax = 0,sumTotal = 0,sumCGST = 0,sumSGST = 0,sumIGST = 0;
		try{
			grnRoundOff.clear();
			grnRoundOff.sendKeys("0.00");
			grnGrandTotal.click();
			for(int i=0;i<noteAmt.size();i++){
				sTotal.add(noteAmt.get(i).getAttribute("value"));
				sNetCGST.add(cgstNoteAmtList.get(i).getAttribute("value"));
				sNetSGST.add(sgstNoteAmtList.get(i).getAttribute("value"));
				sNetIGST.add(igstNoteAmtList.get(i).getAttribute("value"));
				arrayOfTotal.add(Double.parseDouble(sTotal.get(i)));
				arrayOfCgst.add(Double.parseDouble(sNetCGST.get(i)));
				arrayOfSGST.add(Double.parseDouble(sNetSGST.get(i)));
				arrayOfIGST.add(Double.parseDouble(sNetIGST.get(i)));
				sumTotal += arrayOfTotal.get(i);
				sumCGST += arrayOfCgst.get(i);
				sumSGST += arrayOfSGST.get(i);
				sumIGST += arrayOfIGST.get(i);
			}
			for(int i=0;i<checkedNotetaxAmtList.size();i++){
				tax.add(checkedNotetaxAmtList.get(i).getAttribute("value"));
				arrayOfTax.add(Double.parseDouble(tax.get(i)));
				sumTax += arrayOfTax.get(i);
			}
			String sGrandTotal = grnGrandTotal.getAttribute("value");
			double Total = sumTax+sumTotal+sumCGST+sumSGST+sumIGST;
			double roundOff = Math.round(Total * 100.0) / 100.0;
			if(roundOff == Double.parseDouble(sGrandTotal)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("failed to validate grand total "+e);
		}
		return flag;
	}

	public boolean approveNote_Editpage(int iRowNo, String sheet){
		boolean flag = false, flag1;
		int i;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			createNote(iRowNo, sheet);
			i = grnNoList.size();
			grnNoList.get(i-1).click();
			Thread.sleep(Constant.Min_Sleep);
			approveBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.isAlertPresents()){
				driver.switchTo().alert().accept();
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			flag1 = navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);",icdGRNList.get(i-1));
			if(flag1){
				if(icdGRNList.get(i-1).getText().contains("Checked")){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Manually created note approve failed "+e);
		}
		return flag;
	}

	public boolean approveNote_AddPage(int iRowNo, String sheet){
		boolean flag = false, flag1;
		String sTotal;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			int iGRNList = grnNoList.size();
			noteBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(noteCreationPage.isDisplayed()){
				flag1 = addManualNoteDetails(iRowNo, sheet);
				sTotal = noteGrandTotalTxtField.getAttribute("value");
				approveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
				navigate.showAllEntries();
				int iGRNActList = grnNoList.size();
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+iGRNActList+"]/td[10]")));
				String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+iGRNActList+"]/td[10]")).getText();
				sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
				if(!sActNoteValue.contains(".")){
					sActNoteValue = sActNoteValue+".00";
				}
				if(icdGRNList.get(iGRNActList-1).getText().contains("Checked") && iGRNActList > iGRNList &&
						sTotal.contains(sActNoteValue) && flag1){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Manually created note approve failed "+e);
		}
		return flag;
	}

	public boolean verifyNote(int iRowNo, String sheet){
		boolean flag = false, flag1;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			approveNote_Editpage(iRowNo, sheet);
			int i = grnNoList.size();
			grnNoList.get(i-1).click();
			Thread.sleep(Constant.Min_Sleep);
			viewNoteBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(verifyBtn), "Failed to load ICD edit page");
			if(driver.getPageSource().contains("No Note generated for this Receipt.") || icdPDf.isDisplayed()){
				verifyBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load ICD view page");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Constant.waitFor(ExpectedConditions.visibilityOf(noteVerifiedTxt), "Failed to load ICD view page");
				if(noteVerifiedTxt.isDisplayed()){
					closeBtnPDf.click();
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("window.scrollBy(0,-5000)");
					Thread.sleep(Constant.Min_Sleep);
					backBtnICD.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
					flag1 = navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);",icdGRNList.get(i-1));
					if(flag1){
						if(icdGRNList.get(i-1).getText().contains("Verified")){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Note verification failed "+e);
		}
		return flag;
	}

	public boolean addManualNoteDetails(int iRowNo, String sheet){
		boolean  flag = false, flag1, flag2, flag3, flag4, flag5,flag6;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sProject = xls.get(iRowNo).get("Project");
		String sTax = xls.get(iRowNo).get("Tax");
		String sItem = xls.get(iRowNo).get("Other Item");
		try{
			if(sItem.contains("Credit")){
				creditDebitToggle.click();
			}
			partyDrpDwn.click();
			searchParty.sendKeys(sParty);
			driver.findElement(By.xpath(".//em[text()='"+sParty+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			projectDropDown.click();
			searchProject.sendKeys(sProject);
			driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
			receiptNoTxtField.clear();
			receiptNoTxtField.sendKeys(sDate);
			noteInvoiceNo.clear();
			noteInvoiceNo.sendKeys(sDate);
			Thread.sleep(Constant.Min_Sleep);
			noteInvoiceValue.sendKeys(Keys.CONTROL+"a");
			noteInvoiceValue.sendKeys(Keys.DELETE);
			noteInvoiceValue.sendKeys(sDate.substring(8));
			if(attachmentRemove.isDisplayed()){
				attachmentRemove.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			uploadDoc.click();
			Thread.sleep(Constant.Min_Sleep);
//			uploadDoc.sendKeys("E:\\ExpensesUpdate.png");
			Runtime.getRuntime().exec("E:\\ExpenseBillUpload.exe");//execute AutoIT to upload import file
			Thread.sleep(Constant.Min_Sleep);
			flag5 = addNoteDescription(iRowNo,sheet);
			flag1 = addCGSTTax(iRowNo, 0,sheet);
			flag2 = addSGSTTax(iRowNo, 0,sheet);
			flag3 = addIGSTTax(iRowNo, 0,sheet);
			noteRemarksTxtField.clear();
			noteRemarksTxtField.sendKeys("test"+sDate);
			boolean flag7 = Constant.isElementPresent(By.xpath(".//b[text()='"+sTax+"']"));
			if(!flag7){
				taxDropDwn.click();
				taxSearchField.sendKeys(sTax);
				driver.findElement(By.xpath(".//em[text()='"+sTax+"']")).click();
				addTaxBtn.click();
			}
			noteRoundOffTxtField.clear();
			noteRoundOffTxtField.sendKeys("0.00");
			Thread.sleep(Constant.Min_Sleep);
			flag6 = validateGrandTotal_Note();
			flag4 = roundOff(noteGrandTotalTxtField,noteRoundOffTxtField);
			if(flag1 && flag2
					&& flag3 && flag4 && flag5 && flag6){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to add manual note details "+e);
		}
		return flag;
	}

	public boolean updateManualNote_ChangeType(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String sTotal;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			int iGRNList = grnNoList.size();
			createNote(iRowNo, sheet);
			int i = grnNoList.size();
			js.executeScript("arguments[0].scrollIntoView(true);",grnNoList.get(i-1));
			grnNoList.get(i-1).click();
			Thread.sleep(Constant.Min_Sleep);
			if(noteCreationPage.isDisplayed()){
				creditDebitToggle.click();
				sTotal = noteGrandTotalTxtField.getAttribute("value");
				saveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
				navigate.showAllEntries();
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(i)+"]/td[10]")));
				String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(i)+"]/td[10]")).getText();
				sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
				if(!sActNoteValue.contains(".")){
					sActNoteValue = sActNoteValue+".00";
				}
				if(icdGRNList.get(i-1).getText().contains("Pending") && i > iGRNList &&
						sTotal.contains(sActNoteValue)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to update manual note changing type "+e);
		}
		return flag;
	}

	public boolean updateManualNote_AddItem(int iRowNo, String sheet){
		boolean flag = false, flag1, flag2, flag3, flag4;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String sTotal;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			int iGRNList = grnNoList.size();
			createNote(iRowNo, sheet);
			int i = grnNoList.size();
			js.executeScript("arguments[0].scrollIntoView(true);",grnNoList.get(i-1));
			grnNoList.get(i-1).click();
			Thread.sleep(Constant.Min_Sleep);
			if(noteCreationPage.isDisplayed()){
				flag4 = addNoteDescription(iRowNo,sheet);
				flag1 = addCGSTTax(iRowNo, 1,sheet);
				flag2 = addSGSTTax(iRowNo, 1,sheet);
				flag3 = addIGSTTax(iRowNo, 1,sheet);
				noteRemarksTxtField.click();
				sTotal = noteGrandTotalTxtField.getAttribute("value");
				if(flag1 && flag2 && flag3 && flag4){
					saveBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(Constant.isAlertPresents()){
						driver.switchTo().alert().accept();
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+i+"]/td[10]")));
					String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(i)+"]/td[10]")).getText();
					sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
					if(!sActNoteValue.contains(".")){
						sActNoteValue = sActNoteValue+".00";
					}
					if(icdGRNList.get(i-1).getText().contains("Pending") && i > iGRNList &&
							sTotal.contains(sActNoteValue)){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to update manual note changing type "+e);
		}
		return flag;
	}

	public boolean updateManualNote_DeleteItem(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String sTotal;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			int iGRNList = grnNoList.size();
			createNote(iRowNo, sheet);
			int i = grnNoList.size();
			js.executeScript("arguments[0].scrollIntoView(true);",grnNoList.get(i-1));
			grnNoList.get(i-1).click();
			Thread.sleep(Constant.Min_Sleep);
			if(noteCreationPage.isDisplayed()){
				deleteItems.get(0).click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				sTotal = noteGrandTotalTxtField.getAttribute("value");
				saveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
				navigate.showAllEntries();
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+i+"]/td[10]")));
				String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(i)+"]/td[10]")).getText();
				sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
				if(!sActNoteValue.contains(".")){
					sActNoteValue = sActNoteValue+".00";
				}
				if(icdGRNList.get(i-1).getText().contains("Pending") && i > iGRNList &&
						sTotal.contains(sActNoteValue)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to update manual note changing type "+e);
		}
		return flag;
	}

	public boolean updateManualNote(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		int i; String[] options = null; String sTotal;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			int iGRNList = grnNoList.size();
			options = selectICD_EditPage("Pending", "IAN");
			i = Integer.parseInt(options[1]);
			boolean flag1 = Constant.isElementPresent(By.id("cmdSave"));
			if(!flag1){
				createNote(iRowNo, sheet);
				i = grnNoList.size();
				js.executeScript("arguments[0].scrollIntoView(true);",grnNoList.get(i));
				grnNoList.get(i-1).click();
				Thread.sleep(Constant.Min_Sleep);
			}
			if(noteCreationPage.isDisplayed()){
				addManualNoteDetails(iRowNo, sheet);
				sTotal = noteGrandTotalTxtField.getAttribute("value");
				saveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
				navigate.showAllEntries();
				int iGRNActList = grnNoList.size();
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(i+1)+"]/td[10]")));
				String sActNoteValue = driver.findElement(By.xpath(".//*[@id='icdList']/tbody/tr["+(i+1)+"]/td[10]")).getText();
				sActNoteValue = sActNoteValue.substring(0, sActNoteValue.length() -2).trim();
				if(!sActNoteValue.contains(".")){
					sActNoteValue = sActNoteValue+".00";
				}
				if(icdGRNList.get(i).getText().contains("Pending") && iGRNActList == iGRNList &&
						sTotal.contains(sActNoteValue)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Manual note update failed "+e);
		}
		return flag;
	}

	public boolean addExpense(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<Double> list = new ArrayList<>();
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sClaimHead = xls.get(iRowNo).get("Claim Head");
		String sExpenseHead = xls.get(iRowNo).get("Expense Head");
		String sAmt = xls.get(iRowNo).get("Price");
		Double iSum = 0.0;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
			navigate.showAllEntries();
			int iList = expenseNoList.size();
			addBtnMyExpense.click();
			Thread.sleep(Constant.Min_Sleep);
			if(addExpensePage.isDisplayed()){
				cliamHeadDropDwn.click();
				searchClaimHead.sendKeys(sClaimHead);
				driver.findElement(By.xpath(".//ul/li/em[text()='"+sClaimHead+"']")).click();
				descTextField.sendKeys("Test"+sDate);
				expItemDescField.sendKeys("Test"+sDate);
				expenseHeadField.click();
				searchExpenseHeadField.sendKeys(sExpenseHead);
				driver.findElement(By.xpath(".//em[text()='"+sExpenseHead+"']")).click();
				amountField.sendKeys(Keys.CONTROL+"a");
				amountField.sendKeys(Keys.DELETE);
				amountField.sendKeys(sAmt);
				billCheckBx.click();
				billAttachmentBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				Constant.attachFile();
//				Runtime.getRuntime().exec("E:\\ExpenseBillUpload.exe");//execute AutoIT to upload import file
				Thread.sleep(Constant.Min_Sleep);
				addAttachment.click();
				String sClaimAmt = claimedAmount.getAttribute("value");
				expRemarks.sendKeys("draft Test"+sDate);
				for(int i=1;i<expAmtList.size();i++){
					String sAmount = expAmtList.get(i).getAttribute("value");
					list.add(Double.parseDouble(sAmount));
					iSum += list.get(i-1);
				}
				if(iSum == Double.parseDouble(claimedAmount.getAttribute("value"))){
					expSaveBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					String sPopUp = successMsgPopUp.getText();
					sPopUp = sPopUp.substring(23,sPopUp.length());
					okBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
					int iActList = expenseNoList.size();
					String sCorrectedDate = Constant.currentDate().substring(4, 6);
					if(sCorrectedDate.startsWith("0")){
						sCorrectedDate = Constant.currentDate().substring(0,4)+Constant.currentDate().substring(5,12);
					}else{
						sCorrectedDate = Constant.currentDate();
					}
					js.executeScript("arguments[0].scrollIntoView(true);",expenseNoList.get(iActList-1));
					WebElement ele = driver.findElement(By.xpath(".//*[@id='expense_table_list_tbody']/tr["+(iList+1)+"]/td[text()='"+(iList+1)+"']/following::td[1]/a[contains(text(),'"+sPopUp+"')]/following::td[text()='"+sCorrectedDate+"']/following::td[contains(text(),'"+sClaimHead+"')]/following::td[text()='"+"Test"+sDate+"']/following::td[text()='"+sClaimAmt+"']/following::td[1]/span[contains(text(),'Draft')]"));
					if(iActList > iList && ele.isDisplayed() && sPopUp.contains(expenseNoList.get(iActList-1).getText())){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Unable to add expense "+e);
		}
		return flag;
	}

	public int selectExpense_MyExp(String sStatus) throws InterruptedException{
		int i;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(i=1;i<expenseNoList.size();i++){
			js.executeScript("arguments[0].scrollIntoView(true);",expenseNoList.get(i-1));
			if(expenseStatusList.get(i-1).getText().contains(sStatus)){
				expenseNoList.get(i-1).click();
				Thread.sleep(Constant.Min_Sleep);
				break;
			}
		}
		return i;
	}

	public boolean updateDraftExpense(int iRowNo, String sheet) throws Exception{
		List<Double> list = new ArrayList<>();
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sClaimHead = xls.get(iRowNo).get("Claim Head");
		String sExpenseHead = xls.get(iRowNo).get("Expense Head");
		String sAmt = xls.get(iRowNo).get("Price");
		boolean flag = false;
		int i; 	Double iSum = 0.0;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
			navigate.showAllEntries();
			int iList = expenseNoList.size();
			i = selectExpense_MyExp("Draft");
			if(!addExpensePage.isDisplayed()){
				addExpense(iRowNo, sheet);
				iList = expenseNoList.size();
				i = expenseNoList.size();
				js.executeScript("arguments[0].scrollIntoView(true);",expenseNoList.get(i-1));
				expenseNoList.get(i-1).click();
				Thread.sleep(Constant.Min_Sleep);
			}
			if(addExpensePage.isDisplayed()){
				cliamHeadDropDwn.click();
				searchClaimHead.sendKeys(sClaimHead);
				driver.findElement(By.xpath(".//ul/li/em[text()='"+sClaimHead+"']")).click();
				descTextField.clear();
				descTextField.sendKeys("Test"+sDate);
				expItemDescField.sendKeys("Test"+sDate);
				expenseHeadField.click();
				searchExpenseHeadField.sendKeys(sExpenseHead);
				driver.findElement(By.xpath(".//em[text()='"+sExpenseHead+"']")).click();
				amountField.sendKeys(Keys.CONTROL+"a");
				amountField.sendKeys(Keys.DELETE);
				amountField.sendKeys(sAmt);
				billCheckBx.click();
				billAttachmentBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				Constant.attachFile();
//				Runtime.getRuntime().exec("E:\\ExpenseBillUpload.exe");//execute AutoIT to upload import file
				Thread.sleep(Constant.Min_Sleep);
				addAttachment.click();
				String sClaimAmt = claimedAmount.getAttribute("value");
				expRemarks.sendKeys("draft updated"+sDate);
				for(int j=1;j<expAmtList.size();j++){
					String sAmount = expAmtList.get(j).getAttribute("value");
					list.add(Double.parseDouble(sAmount));
					iSum += list.get(j-1);
				}
				if(iSum == Double.parseDouble(claimedAmount.getAttribute("value"))){
					expSaveBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
					String sPopUp = successMsgPopUp.getText();
					sPopUp = sPopUp.substring(23,sPopUp.length());
					okBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
					navigate.showAllEntries();
					int iActList = expenseNoList.size();
					js.executeScript("arguments[0].scrollIntoView(true);",expenseNoList.get(i-1));
					WebElement ele = driver.findElement(By.xpath(".//*[@id='expense_table_list_tbody']/tr/td/following::td[1]/a[contains(text(),'"+sPopUp+"')]/following::td[2][text()='"+sClaimHead+"']/following::td[text()='"+"Test"+sDate+"']/following::td[text()='"+sClaimAmt+"']/following::td[1]/span[contains(text(),'Draft')]"));
					if(iActList == iList && ele.isDisplayed() && sPopUp.contains(expenseNoList.get(i-1).getText())){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Expense update failed "+e);
		}
		return flag;
	}

	public boolean confirmExpenses(int iRowNo, String sheet){
		boolean flag = false;
		int i;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
			navigate.showAllEntries();
			int iList = expenseNoList.size();
			i = selectExpense_MyExp("Draft");
			if(!addExpensePage.isDisplayed()){
				addExpense(iRowNo, sheet);
				i = expenseNoList.size();
				iList = i;
				js.executeScript("arguments[0].scrollIntoView(true);",expenseNoList.get(i-1));
				expenseNoList.get(i-1).click();
				Thread.sleep(Constant.Min_Sleep);
			}
			if(addExpensePage.isDisplayed()){
				String sClaimHead = cliamHeadDropDwn.getText();
				String sClaimAmt = claimedAmount.getAttribute("value");
				String sDesc = descTextField.getAttribute("value");
				confirmBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
				String sPopUp = successMsgPopUp.getText();
				sPopUp = sPopUp.substring(23,sPopUp.length());
				okBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
				navigate.showAllEntries();
				int iActList = expenseNoList.size();
				js.executeScript("arguments[0].scrollIntoView(true);",expenseNoList.get(i-1));
				WebElement ele = driver.findElement(By.xpath(".//*[@id='expense_table_list_tbody']/tr/td/following::td[1]/a[contains(text(),'"+sPopUp+"')]/following::td[2][text()='"+sClaimHead+"']/following::td[text()='"+sDesc+"']/following::td[contains(text(),'"+sClaimAmt+"')]/following::td[1]/span[contains(text(),'Confirmed')]"));
				if(iActList == iList && ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Expense confirm failed "+e);
		}
		return flag;
	}

	public boolean updateConfirmedExpense(int iRowNo, String sheet) throws Exception{
		List<Double> list = new ArrayList<>();
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sClaimHead = xls.get(iRowNo).get("Claim Head");
		String sExpenseHead = xls.get(iRowNo).get("Expense Head");
		String sAmt = xls.get(iRowNo).get("Price");
		boolean flag = false;
		int i; Double iSum = 0.0;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
			navigate.showAllEntries();
			int iList = expenseNoList.size();
			i = selectExpense_MyExp("Confirmed");
			if(!addExpensePage.isDisplayed()){
				confirmExpenses(iRowNo, sheet);
				iList = expenseNoList.size();
				i = expenseNoList.size();
				js.executeScript("arguments[0].scrollIntoView(true);",expenseNoList.get(i-1));
				expenseNoList.get(i-1).click();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(cliamHeadDropDwn), "Failed to load expense view page");
			js.executeScript("window.scrollBy(0,-2000)");
			Thread.sleep(Constant.Min_Sleep);
			if(addExpensePage.isDisplayed()){
				cliamHeadDropDwn.click();
				searchClaimHead.sendKeys(sClaimHead);
				driver.findElement(By.xpath(".//ul/li/em[text()='"+sClaimHead+"']")).click();
				descTextField.clear();
				descTextField.sendKeys("Test"+sDate);
				expItemDescField.sendKeys("Test"+sDate);
				expenseHeadField.click();
				searchExpenseHeadField.sendKeys(sExpenseHead);
				driver.findElement(By.xpath(".//em[text()='"+sExpenseHead+"']")).click();
				amountField.sendKeys(Keys.CONTROL+"a");
				amountField.sendKeys(Keys.DELETE);
				amountField.sendKeys(sAmt);
				billCheckBx.click();
				billAttachmentBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				Constant.attachFile();
//				Runtime.getRuntime().exec("E:\\ExpenseBillUpload.exe");//execute AutoIT to upload import file
				Thread.sleep(Constant.Min_Sleep);
				addAttachment.click();
				String sClaimAmt = claimedAmount.getAttribute("value");
				expRemarks.sendKeys("confirm updated"+sDate);
				for(int j=1;j<expAmtList.size();j++){
					String sAmount = expAmtList.get(j).getAttribute("value");
					list.add(Double.parseDouble(sAmount));
					iSum += list.get(j-1);
					iSum = Math.round(iSum * 100.0) / 100.0;
				}
				if(iSum == Double.parseDouble(claimedAmount.getAttribute("value"))){
					confirmBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					String sPopUp = successMsgPopUp.getText();
					sPopUp = sPopUp.substring(23,sPopUp.length());
					okBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
					navigate.showAllEntries();
					int iActList = expenseNoList.size();
					js.executeScript("arguments[0].scrollIntoView(true);",expenseNoList.get(i-1));
					WebElement ele = driver.findElement(By.xpath(".//*[@id='expense_table_list_tbody']/tr/td/following::td[1]/a[contains(text(),'"+sPopUp+"')]/following::td[2][text()='"+sClaimHead+"']/following::td[text()='Test"+sDate+"']/following::td[contains(text(),'"+sClaimAmt+"')]/following::td[1]/span[contains(text(),'Confirmed')]"));
					if(iActList == iList && ele.isDisplayed()){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Expense update failed "+e);
		}
		return flag;
	}

	public boolean login(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sUsername = xls.get(iRowNo).get("Email");
		String sPassword = xls.get(iRowNo).get("Password");
		try{
			Thread.sleep(Constant.Min_Sleep);
			userName.sendKeys(sUsername);
			Thread.sleep(Constant.Min_Sleep);
			password.sendKeys(sPassword);
			Thread.sleep(Constant.Min_Sleep);
			signIn.click();
			Thread.sleep(Constant.Medium_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(accountsModule), "Element not loaded");
			Thread.sleep(Constant.Min_Sleep);
			if(skipBtn.isDisplayed()){
				Constant.waitFor(ExpectedConditions.elementToBeClickable(skipBtn), "Element not loaded");
				Thread.sleep(Constant.Min_Sleep);
				if(skipBtn.isDisplayed()){
					skipBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(navigate.auditingHeader), "Element not loaded");
			if(navigate.auditingHeader.isDisplayed()){
				flag = true;
				navigate.navigateToAuditing();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToExpense();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
				otherExpensesTab.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
			}
		}catch(Exception e){
			System.err.println("Login failed "+e);
		}
		return flag;
	}

	public int selectExpense_OtherExp(String sStatus) throws InterruptedException{
		int i;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(i=0;i<expenseNoList_OtherExp.size();i++){
			js.executeScript("arguments[0].scrollIntoView(true);",expenseStatusList_OtherExp.get(i));
			if(expenseStatusList_OtherExp.get(i).getText().contains(sStatus)){
				Actions actions = new Actions(driver);
				actions.moveToElement(expenseStatusList_OtherExp.get(i)).perform();
				Thread.sleep(Constant.Min_Sleep);
				expenseNoEdit_OtherExp.get(i).click();
				Thread.sleep(Constant.Min_Sleep);
				break;
			}
		}
		return i;
	}

	public boolean ApproveExpenses(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		int i;
		List<Double> claimList = new ArrayList<>();
		List<Double> approveList = new ArrayList<>();
		Double totalClaimAmt = 0.0, totalApproverAmt = 0.0;
		String sValue;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			boolean flag1 = login(iRowNo, sheet);
			if(flag1){
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
				int iList = expenseStatusList_OtherExp.size();
				i = selectExpense_OtherExp("Confirmed");
				if(expenseDetailsPage.isDisplayed()){
					String sClaimHead = claimHeaderName.getAttribute("value");
					String sDesc = claimGrpDesc_EditPge.getAttribute("value");
					for(int j=1;j<amountList.size();j++){
						String sAmt = amountList.get(j).getText();
						if(Double.parseDouble(sAmt) > 10){
							sValue = "10";
						}else{
							sValue = "1";
						}
						approverAmountList.get(j).sendKeys(Keys.CONTROL + "a");
						approverAmountList.get(j).sendKeys(Keys.DELETE);
						approverAmountList.get(j).sendKeys(sValue);
						remarksList.get(j-1).sendKeys("Approve"+sDate);
						claimList.add(Double.parseDouble(sAmt));
						approveList.add(Double.parseDouble(netValueList.get(j).getAttribute("value")));
						totalClaimAmt += claimList.get(j-1);
						totalApproverAmt += approveList.get(j-1);
					}
					totalClaimAmt = Math.round(totalClaimAmt * 100.0) / 100.0;
					totalApproverAmt = Math.round(totalApproverAmt * 100.0) / 100.0;
					String sClaimedAmt = claimedAmount.getAttribute("value");
					String sApprovedAmt = approvedAmt.getAttribute("value");
					if(Double.parseDouble(sClaimedAmt) == totalClaimAmt && Double.parseDouble(sApprovedAmt) == totalApproverAmt){
						approveBtnExp.click();
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
						String sPopUp = successMsgPopUp.getText();
						sPopUp = sPopUp.substring(23,sPopUp.length());
						okBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
						otherExpensesTab.click();
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
						Constant.waitForPageLoad();
						navigate.showAllEntries();
						int iActList = expenseStatusList_OtherExp.size();
						js.executeScript("arguments[0].scrollIntoView(true);",expenseStatusList_OtherExp.get(i));
						WebElement ele = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sPopUp+"')]/following::td[2][text()='"+sClaimHead+"']/following::td[text()='"+sDesc+"']/following::td[2][text()='"+sClaimedAmt+"']/following::td[text()='"+sApprovedAmt+"']/following::td[1]/span[contains(text(),'Approved')]"));
						if(iActList == iList && ele.isDisplayed()){
							flag = true;
						}
					}
				}
			}else{
				Constant.log.info("No Confirmed expense is available");
			}
		}catch(Exception e){
			System.err.println("Expense Approve failed "+e);
		}
		return flag;
	}

	public boolean CheckExpenses(int iRowNo, String sheet){
		boolean flag = false;
		int i;
		List<Double> claimList = new ArrayList<>();
		List<Double> approveList = new ArrayList<>();
		Double totalClaimAmt = 0.0, totalApproverAmt = 0.0;
		String sValue;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			boolean flag1 = login(iRowNo, sheet);
			if(flag1){
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
				otherExpensesTab.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				int iList = expenseStatusList_OtherExp.size();
				i = selectExpense_OtherExp("Approved");
				if(expenseDetailsPage.isDisplayed()){
					String sClaimHead = claimHeaderName.getAttribute("value");
					String sDesc = claimGrpDesc_EditPge.getAttribute("value");
					for(int j=1;j<amountList.size();j++){
						String sAmt = amountList.get(j).getText();
						if(Double.parseDouble(sAmt) > 10){
							sValue = "10";
						}else{
							sValue = "1";
						}
						auditAmountList.get(j).sendKeys(Keys.CONTROL + "a");
						auditAmountList.get(j).sendKeys(Keys.DELETE);
						auditAmountList.get(j).sendKeys(sValue);
						remarksList.get(j-1).sendKeys("Check"+sDate);
						claimList.add(Double.parseDouble(sAmt));
						approveList.add(Double.parseDouble(netValueList.get(j).getAttribute("value")));
						totalClaimAmt += claimList.get(j-1);
						totalApproverAmt += approveList.get(j-1);
						checkList.get(j-1).click();
					}
					totalClaimAmt = Math.round(totalClaimAmt * 100.0) / 100.0;
					totalApproverAmt = Math.round(totalApproverAmt * 100.0) / 100.0;
					String sClaimedAmt = claimedAmount.getAttribute("value");
					String sApprovedAmt = approvedAmt.getAttribute("value");
					if(Double.parseDouble(sClaimedAmt) == totalClaimAmt && Double.parseDouble(sApprovedAmt) == totalApproverAmt){
						checkedOKBtn.click();
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
						String sPopUp = successMsgPopUp.getText();
						sPopUp = sPopUp.substring(23,sPopUp.length());
						okBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
						otherExpensesTab.click();
						Constant.waitForPageLoad();
						navigate.showAllEntries();
						int iActList = expenseStatusList_OtherExp.size();
						js.executeScript("arguments[0].scrollIntoView(true);",expenseStatusList_OtherExp.get(i));
						WebElement ele = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sPopUp+"')]/following::td[2][text()='"+sClaimHead+"']/following::td[text()='"+sDesc+"']/following::td[2][text()='"+sClaimedAmt+"']/following::td[text()='"+sApprovedAmt+"']/following::td[1]/span[contains(text(),'Checked')]"));
						if(iActList == iList && ele.isDisplayed()){
							flag = true;
						}
					}
				}else{
					Constant.log.info("No approved expense is available");
				}
			}
		}catch(Exception e){
			System.err.println("Expense check failed "+e);
		}
		return flag;
	}

	public boolean verifyExpenses(int iRowNo, String sheet){
		boolean flag = false;
		int i;
		List<Double> claimList = new ArrayList<>();
		List<Double> approveList = new ArrayList<>();
		Double totalClaimAmt = 0.0, totalApproverAmt = 0.0;
		String sValue;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			boolean flag1 = login(iRowNo, sheet);
			if(flag1){
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
				otherExpensesTab.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
				navigate.showAllEntries();
				int iList = expenseStatusList_OtherExp.size();
				i = selectExpense_OtherExp("Checked");
				if(expenseDetailsPage.isDisplayed()){
					String sClaimHead = claimHeaderName.getAttribute("value");
					String sDesc = claimGrpDesc_EditPge.getAttribute("value");
					for(int j=1;j<amountList.size();j++){
						String sAmt = amountList.get(j).getText();
						if(Double.parseDouble(sAmt) > 10){
							sValue = "10";
						}else{
							sValue = "1";
						}
						auditAmountList.get(j).sendKeys(Keys.CONTROL + "a");
						auditAmountList.get(j).sendKeys(Keys.DELETE);
						auditAmountList.get(j).sendKeys(sValue);
						remarksList.get(j-1).sendKeys("Verify"+sDate);
						claimList.add(Double.parseDouble(sAmt));
						approveList.add(Double.parseDouble(netValueList.get(j).getAttribute("value")));
						totalClaimAmt += claimList.get(j-1);
						totalApproverAmt += approveList.get(j-1);
					}
					totalClaimAmt = Math.round(totalClaimAmt * 100.0) / 100.0;
					totalApproverAmt = Math.round(totalApproverAmt * 100.0) / 100.0;
					String sClaimedAmt = claimedAmount.getAttribute("value");
					String sApprovedAmt = approvedAmt.getAttribute("value");
					if(Double.parseDouble(sClaimedAmt) == totalClaimAmt && Double.parseDouble(sApprovedAmt) == totalApproverAmt){
						verifyExpBtn.click();
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
						String sPopUp = successMsgPopUp.getText();
						sPopUp = sPopUp.substring(23,sPopUp.length());
						okBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
						otherExpensesTab.click();
						Constant.waitForPageLoad();
						navigate.showAllEntries();
						int iActList = expenseStatusList_OtherExp.size();
						js.executeScript("arguments[0].scrollIntoView(true);", expenseStatusList_OtherExp.get(i));
						WebElement ele = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sPopUp+"')]/following::td[2][text()='"+sClaimHead+"']/following::td[text()='"+sDesc+"']/following::td[2][text()='"+sClaimedAmt+"']/following::td[text()='"+sApprovedAmt+"']/following::td[1]/span[contains(text(),'Verified')]"));
						if(iActList == iList && ele.isDisplayed()){
							flag = true;
						}
					}
				}else{
					Constant.log.info("No Confirmed expense is available");
				}
			}
		}catch(Exception e){
			System.err.println("Expense verify failed "+e);
		}
		return flag;
	}

	public boolean returnICDToGRN(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			boolean flag1 = store.approveGRN(iRowNo,sheet,null);
			if(flag1){
				navigate.navigateToAuditing();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToICD();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load expense view page");
				navigate.showAllEntries();
				int iGRNCount = grnNoList.size();
				js.executeScript("arguments[0].scrollIntoView(true);", grnNoList.get(iGRNCount-1));
				grnNoList.get(iGRNCount-1).click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(returnToGRNBtn), "Failed to load icd edit page");
				Thread.sleep(Constant.Min_Sleep);
				invoiceTab.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMatDetails_InvoiceTab), "Failed to load all materials in invoice tab");
				Thread.sleep(Constant.Min_Sleep);
				returnToGRNBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(enterReturnRemarkTxt), "Failed to load success popup");
				Thread.sleep(Constant.Medium_Sleep);
				enterReturnRemarkTxt.sendKeys("Return" +sDate);
				Thread.sleep(Constant.Medium_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load icd view page");
				Thread.sleep(Constant.Min_Sleep);
				int iActGRNCount = grnNoList.size();
				if(iGRNCount > iActGRNCount){
					navigate.navigateToStore();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToGRN();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load grn view page");
					navigate.showAllEntries();
					iGRNCount = store.grnList.size();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//tr["+(iGRNCount)+"]//td[13]//a[1]")));
					if(driver.findElement(By.xpath("//tr["+(iGRNCount)+"]//td[13]//a[1]")).getText().contains("Returned")){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to return ICD to GRN "+e);
		}
		return flag;
	}

	public boolean verifyGRNNotAvail(String sGRNNo){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ICD view page");
			navigate.showAllEntries();
			if(!driver.getPageSource().contains(sGRNNo)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to verify if grn is available "+e);
		}
		return flag;
	}

}
