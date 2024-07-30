package pages;

import java.math.BigDecimal;
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

public class AccountsPage {

	ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);


	@FindBy(xpath=".//tr/td[3]/a")
	public List<WebElement> voucherNoList;

	@FindBy(id="filter_textbox")
	private WebElement filterText;

	@FindBy(id="enable_edit_voucher") WebElement editVoucherBtn;

	@FindBy(id="id_voucher-narration")
	private WebElement narrationTxt;

	@FindBy(id="id_dr_total_amount")
	private WebElement totalDebitAmt;

	@FindBy(id="id_cr_total_amount")
	private WebElement totalCreditAmt;

	@FindBy(id="save_voucher_button") WebElement saveVoucherBtn;

	@FindBy(xpath="//span[contains(text(),'Voucher Type is required.')]")
	private WebElement voucherTypeMandatoryWarning;

	@FindBy(xpath="//p[contains(text(),'* Debit and Credit Values are not Equal.')]")
	private WebElement valueMismatchError;

	@FindBy(xpath="//p[contains(text(),'* Please add atleast one ledger value to save/ app')]")
	private WebElement addLedgerWarning;

	@FindBy(xpath="//span[contains(text(),'select ledger from the type ahead list.')]")
	private WebElement invalidLedgerWarning;

	@FindBy(xpath="//p[contains(text(),'* Debit and Credit Values are not Equal.')]")
	private WebElement drCrNotMatch;

	@FindBy(xpath="//span[contains(text(),'Ledger is required.')]")
	private WebElement mandatoryLedgerWarn;

	@FindBy(xpath="//h2[contains(text(),'Voucher Code')]")
	private WebElement successMsgPopUp;

	@FindBy(xpath="//a[contains(@class,'view_voucher')]")
	public WebElement backBtn_Voucher;

	@FindBy(id="approve_voucher_button") WebElement approveVoucherBtn;

	@FindBy(xpath=".//td/a")
	private List<WebElement> voucherList;

	@FindBy(xpath=".//a[@data-original-title='Create New Ledger']") WebElement addNewLedger;

	@FindBy(id="id_voucher-type_id")
	private WebElement voucherTypeDrpDown;

	@FindBy(xpath=".//*[@id='id_bank_ledger_chosen']/a/span")
	private WebElement bankLedgerDropDwn;

	@FindBy(xpath=".//a[@data-original-title='Create New Voucher']") WebElement addVoucher;

	@FindBy(xpath=".//*[@id='id_bank_ledger_chosen']/div/div/input")
	private WebElement searchBankLedger;

	@FindBy(xpath=".//*[@id='id_voucher_project_code_chosen']/a/span")
	private WebElement projectDrpDown;

	@FindBy(xpath=".//*[@id='id_voucher_project_code_chosen']/div/div/input")
	private WebElement searchProject;

	@FindBy(id="id_voucher-transaction_instrument_no")
	private WebElement transInstNoTxt;

	@FindBy(id="id_voucher-transaction_description")
	private WebElement transDescTxt;

	@FindBy(id="ledgername")
	private WebElement ledgerNameTxt;

	@FindBy(id="is_debit")
	private WebElement dDr_CrDrpDwn;

	@FindBy(id="amount")
	private WebElement amountTxt;

	@FindBy(id="add_new_ledger")
	private WebElement addLedger;

	@FindBy(xpath="//input[contains(@id,'ledger_label')]")
	private List<WebElement> ledgerList;

	@FindBy(xpath="//div[contains(@id,'id_opening')]")
	private List<WebElement> openingBalList;

	@FindBy(xpath=".//a[contains(@id,'bill_details')]/span")
	private List<WebElement> billEditBtn;

	@FindBy(xpath="//td[7]/input[contains(@id,'credit_settlement')]")
	private List<WebElement> billCreditSettlementList;

	@FindBy(xpath="//td[6]/input[contains(@id,'debit_settlement')]")
	private List<WebElement> billDebitSettlementList;

	@FindBy(xpath="//a[contains(@id,'delete_v_particular')]/i")
	private List<WebElement> deleteLedgerDetails;

	@FindBy(xpath="//td/input[contains(@id,'bill_no')]")
	private List<WebElement> billNoListSettlementPopup;

	@FindBy(xpath=".//a[contains(@id,'bill_details')]/span/preceding::td[4]/input")
	private List<WebElement> voucherNameWBillNo;

	@FindBy(xpath="//tbody/tr/td/a")
	private List<WebElement> ledgerNameList_BillPopup;

	@FindBy(xpath="//tbody[@id='ledgerTBody']/tr/td[4]")
	private List<WebElement> billNoList_BillsTableAccts;

	@FindBy(xpath="//tbody[@id='ledgerTBody']/tr/td[7]")
	private List<WebElement> billValueList_BillsTableAccts;

	@FindBy(xpath="//h3[text()='Payables']/following::span[contains(text(),'30 Days')]")
	private WebElement thirtyDaysReceivable;

	@FindBy(xpath="//h3[text()='Receivables']/following::span[contains(text(),'30 Days')][1]")
	private WebElement thirtyDaysPayable;

	@FindBy(xpath=".//a[contains(@id,'bill_details')]/input")
	private List<WebElement> billAddBtn;

	@FindBy(id="bill_no")
	private WebElement billNoTxtField;

	@FindBy(id="ledger_bill_amount")
	private WebElement billAmtTxtField;

	@FindBy(id="add_new_ledger_bill")
	private WebElement billAddBtn_Popup;

	@FindBy(xpath="//span[contains(text(),'Bill No. is required.')]")
	private WebElement billNoMandatoryWarn;

	@FindBy(xpath="//div[@id='DueDetails']//button[text()='Close']")
	private WebElement billDetailsCloseBtn;

	@FindBy(xpath="//span[contains(text(),'Amount is required.')]")
	private WebElement amtMandatoryWarn;

	@FindBy(xpath=".//h4[text()='Bill']")
	private WebElement billPopUp;

	@FindBy(xpath="//p[contains(text(),'Total amount is not completely utilized for Bill S')]")
	private WebElement billSettlementWarning;

	@FindBy(xpath="//p[contains(text(),'Settlement amount exceeds the Voucher Value.')]")
	private WebElement settlmentExceedsWarn;

	@FindBy(xpath=".//*[@id='bill_list']/tbody/tr[2][contains(@id,'ledger_bill')]/td[5]")
	private WebElement firstBillValue;

	@FindBy(id="buttonautofill")
	private WebElement buttonAutoFill;

	@FindBy(id="ledger_amount")
	private WebElement voucherAmt;

	@FindBy(id="btn-sa-confirm")
	private WebElement okBtn;

	@FindBy(xpath=".//*[@id='bill_list']/tbody/tr[1][contains(@id,'ledger_bill')]/td/input[contains(@id,'debit_settlement')]")
	private WebElement debitBillValuePopup;

	@FindBy(xpath=".//*[@id='bill_list']/tbody/tr[1][contains(@id,'ledger_bill')]/td/input[contains(@id,'credit_settlement')]")
	private WebElement creditBillValuePopup;

	@FindBy(xpath=".//a[contains(@id,'bill_details')]/preceding::td[2]/input")
	private List<WebElement> debitBillValue;

	@FindBy(xpath=".//a[contains(@id,'bill_details')]/preceding::td[1]/input")
	private List<WebElement> creditBillValue;

	@FindBy(id="balance_amount")
	private WebElement balanceAmt;

	@FindBy(id="total_credit_amount")
	private WebElement creditAmt;

	@FindBy(id="total_debit_amount")
	private WebElement debitAmt;

	@FindBy(id="save_button")
	private WebElement saveBtn;

	@FindBy(id="close_button")
	private WebElement closeBillPopup;

	@FindBy(id="id_v_particular-0-credit_amount")
	private WebElement firstCreditAmt;

	@FindBy(id="id_v_particular-0-debit_amount")
	private WebElement firstDebitAmt;

	@FindBy(id="cancel_button")
	private WebElement resetBillPopup;

	@FindBy(xpath=".//tr/td[6]/*[contains(@id,'id_v_particular')]")
	private List<WebElement> creditAmtList;

	@FindBy(xpath=".//tr/td[5]/*[contains(@id,'id_v_particular')]")
	private List<WebElement> debitAmtList;

	@FindBy(xpath=".//*[@id='voucherList']/tbody/tr/td[5]")
	public List<WebElement> narrationList;

	@FindBy(xpath=".//*[@id='id_cash_ledger_chosen']/a/span")
	private WebElement cashLedger;

	@FindBy(xpath=".//*[@id='id_cash_ledger_chosen']/div/div/input")
	private WebElement searchCashLedger;

	@FindBy(id="id_name")
	private WebElement ledgerNameField;

	@FindBy(id="id_description")
	private WebElement ledgerDescriptionField;

	@FindBy(id="id_group_select")
	private WebElement acctGrp;

	@FindBy(id="a_trial_balance")
	private WebElement runTrialBalanceBtn;

	@FindBy(xpath="//b[contains(text(),'Net Balance')]")
	private WebElement trialNetBal;

	@FindBy(xpath=".//li/a[text()='Trial Balance']")
	private WebElement trialBalTab;

	@FindBy(id="a_generate")
	private WebElement generateStatementsBtn;

	@FindBy(xpath=".//h4[text()='Moderation']")
	private WebElement moderationPopup;

	@FindBy(id="generate_statement")
	private WebElement proceedBtn;

	@FindBy(xpath=".//a[text()='Balance Sheet']")
	private WebElement provisionalBalSheetTab;

	@FindBy(xpath=".//*[@id='table_trial_balance']/thead")
	private WebElement trialBalColumn;

	@FindBy(xpath=".//h4[text()='Provisional Balance Sheet']")
	private WebElement provisionalBalHeading;

	@FindBy(xpath=".//a[text()='Provisional Profit and Loss']")
	private WebElement provisionalProfiltLossTab;

	@FindBy(xpath=".//h4[text()='Provisional Profit and Loss Statement']")
	private WebElement provisionalProfitLossHeading;

	@FindBy(xpath=".//a[text()='Notes']")
	private WebElement notesTab;

	@FindBy(xpath=".//h4[text()='Notes']")
	private WebElement notesHeading;

	@FindBy(xpath=".//button[contains(@class,'btn-filter')]")
	private WebElement filterBtn;

	@FindBy(id="grnreportview")
	private WebElement applyBtn;

	@FindBy(xpath=".//input[@id='filter_textbox'][@aria-controls='gstr-b2b-report']")
	private WebElement b2bFilterTxt;

	@FindBy(xpath=".//div[contains(@id,'gstr-b2b-report_wrapper')]//thead//th")
	private List<WebElement> gstrReportColumn;

	@FindBy(xpath="//div[@class='dataTables_scrollHeadInner']/table[1]/thead[1]/tr[1]/th")
	private List<WebElement> purchaseRegisterColumn;

	@FindBy(id="gstr1salesreportview") WebElement grnSalesReportView;

	@FindBy(xpath=".//*[@id='ledgerList']/tbody/tr[1]/td[2]/form/a") WebElement firstLedger;

	@FindBy(id="saveLedger") WebElement saveLedgerBtn;

	@FindBy(xpath=".//a[@data-original-title='Back']") WebElement cancelBtn_Ledger;

	@FindBy(xpath=".//tr[1]/td/form/a") WebElement firstVoucher;

	@FindBy(xpath=".//*[@id='voucherList']/tbody/tr/td[7]")
	private List<WebElement> voucherNo;

	@FindBy(xpath=".//input[@type='search']")
	private WebElement searchLedger;

	@FindBy(xpath=".//*[@id='voucherList']/thead//th")
	private List<WebElement> bankReconciliationColumns;

	@FindBy(id="load_statement") WebElement loadStatement;

	@FindBy(id="id_save_reconcile") WebElement saveReconcile;

	@FindBy(xpath=".//*[@id='id_ledger_id_chosen']/div/ul/li[1]") WebElement firstLedger_BRS;

	@FindBy(xpath=".//*[@id='id_ledger_id_chosen']/a/span") WebElement brsLedger;

	@FindBy(xpath=".//*[@id='id_ledger_id_chosen']/div/div/input") WebElement searchLedgerDrpDwn;



	String sDate = Constant.DateTimeFormat();

	private WebDriver driver;
	public AccountsPage(WebDriver driver){
		this.driver = driver;
	}

	public void editLedgerValues(int iRowNo, String sheet){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sAmount = xls.get(iRowNo).get("Amount");
		try{
			for (WebElement element : billEditBtn) {
				if(element.isDisplayed()){
					element.click();
					Thread.sleep(Constant.Min_Sleep);
					break;
				}
			}
			resetBillPopup.click();
			Thread.sleep(Constant.Min_Sleep);
			closeBillPopup.click();
			Thread.sleep(Constant.Min_Sleep);
			for(int i=0;i<creditAmtList.size()-1;i++){
				if(creditAmtList.get(i).isEnabled()){
					creditAmtList.get(i).sendKeys(Keys.CONTROL+"a");
					creditAmtList.get(i).sendKeys(Keys.DELETE);
					creditAmtList.get(i).sendKeys(sAmount);
				}
			}
			for(int i=0;i<debitAmtList.size()-1;i++){
				if(debitAmtList.get(i).isEnabled()){
					debitAmtList.get(i).sendKeys(Keys.CONTROL+"a");
					debitAmtList.get(i).sendKeys(Keys.DELETE);
					debitAmtList.get(i).sendKeys(sAmount);
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			if(driver.getPageSource().contains("There was a change in your voucher amount. Please verify your bill amount too.")){
				closeBillPopup.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			narrationTxt.click();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.getPageSource().contains("Voucher Form errors")){
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			Thread.sleep(Constant.Min_Sleep);
			if(closeBillPopup.isDisplayed()){
				Thread.sleep(Constant.Min_Sleep);
				closeBillPopup.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			equalizeEditVoucherValue();
			adjustBillValue();
		}catch(Exception e){
			System.err.println("Failed to edit ledger values "+e);
		}
	}

	public void adjustBillValue(){
		try{
			if(!closeBillPopup.isDisplayed()){
				for (WebElement element : billEditBtn) {
					if(element.isDisplayed()){
						element.click();
						break;
					}
				}
			}
//			narrationTxt.click();
			Thread.sleep(Constant.Min_Sleep);
			String sBalance = voucherAmt.getAttribute("value");
			if(debitBillValuePopup.isDisplayed()){
				debitBillValuePopup.sendKeys(Keys.CONTROL+"a");
				debitBillValuePopup.sendKeys(Keys.DELETE);
				debitBillValuePopup.sendKeys(sBalance);
			}else{
				creditBillValuePopup.sendKeys(Keys.CONTROL+"a");
				creditBillValuePopup.sendKeys(Keys.DELETE);
				creditBillValuePopup.sendKeys(sBalance);
			}
			saveBtn.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to adjust bill value "+e);
		}
	}

	public void equalizeEditVoucherValue(){
		Double dDiff;
		String sActAmt;
		int i;
		try{
			Double totalDebit = Double.parseDouble(totalDebitAmt.getAttribute("value"));
			Double totalCredit = Double.parseDouble(totalCreditAmt.getAttribute("value"));
			for(i=0;i<billEditBtn.size();i++){
				if(billEditBtn.get(i).isDisplayed()){
					break;
				}
			}
			if(!totalDebitAmt.getAttribute("value").equals(totalCreditAmt.getAttribute("value"))){
				if(totalDebit > totalCredit){
					dDiff = totalDebit - totalCredit;
					double roundOff = Math.round(dDiff * 100.0) / 100.0;
					for (WebElement element : creditBillValue) {
						sActAmt = element.getAttribute("value");
						if(Double.parseDouble(sActAmt) > 0){
							element.sendKeys(Keys.CONTROL+"a");
							element.sendKeys(Keys.DELETE);
							element.sendKeys(Double.toString((Double.parseDouble(sActAmt)+roundOff)));
							break;
						}
					}
				}else{
					dDiff = totalCredit - totalDebit;
					double roundOff = Math.round(dDiff * 100.0) / 100.0;
					for (WebElement element : debitBillValue) {
						sActAmt = element.getAttribute("value");
						if(Double.parseDouble(sActAmt) > 0){
							element.sendKeys(Keys.CONTROL+"a");
							element.sendKeys(Keys.DELETE);
							element.sendKeys(Double.toString((Double.parseDouble(sActAmt)+roundOff)));
							break;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to adjust bill value "+e);
		}
	}

	public void equalizeAddVoucherValue(){
		Double dDiff;
		String sActAmt;
		int i;
		try{
			Double totalDebit = Double.parseDouble(totalDebitAmt.getAttribute("value"));
			Double totalCredit = Double.parseDouble(totalCreditAmt.getAttribute("value"));
			for(i=0;i<billAddBtn.size();i++){
				if(billAddBtn.get(i).isDisplayed()){
					break;
				}
			}
			if(!totalDebitAmt.getAttribute("value").equals(totalCreditAmt.getAttribute("value"))){
				if(totalDebit > totalCredit){
					dDiff = totalDebit - totalCredit;
					sActAmt = driver.findElement(By.id("id_v_particular-"+i+"-credit_amount")).getAttribute("value");
					double roundOff = Math.round(dDiff * 100.0) / 100.0;
					driver.findElement(By.id("id_v_particular-"+i+"-credit_amount")).sendKeys(Keys.CONTROL+"a");
					driver.findElement(By.id("id_v_particular-"+i+"-credit_amount")).sendKeys(Keys.DELETE);
					driver.findElement(By.id("id_v_particular-"+i+"-credit_amount")).sendKeys(Double.toString((Double.parseDouble(sActAmt)+roundOff)));
				}else{
					dDiff = totalCredit - totalDebit;
					sActAmt = driver.findElement(By.id("id_v_particular-"+i+"-debit_amount")).getAttribute("value");
					double roundOff = Math.round(dDiff * 100.0) / 100.0;
					driver.findElement(By.id("id_v_particular-"+i+"-debit_amount")).sendKeys(Keys.CONTROL+"a");
					driver.findElement(By.id("id_v_particular-"+i+"-debit_amount")).sendKeys(Keys.DELETE);
					driver.findElement(By.id("id_v_particular-"+i+"-debit_amount")).sendKeys(Double.toString((Double.parseDouble(sActAmt)+roundOff)));
				}
			}
		}catch(Exception e){
			System.err.println("Failed to adjust bill value "+e);
		}
	}

	public boolean verifyBillNo_AfterBillDelete(){
		boolean flag = false;
		String sBillNo = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<String> sLedger = new ArrayList<>();
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			for(int j=0;j<narrationList.size();j++){
				js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(j));
				if(narrationList.get(j).getText().contains(sDate)){
					voucherNoList.get(j).click();
					break;
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<billEditBtn.size();i++){
					if(billEditBtn.get(i).isDisplayed()){
						sBillNo = billEditBtn.get(0).getText();
						sLedger.add(voucherNameWBillNo.get(i).getAttribute("value"));
						billEditBtn.get(0).click();
						if(billCreditSettlementList.get(i).isDisplayed()){
							billCreditSettlementList.get(i).clear();
						}else{
							billDebitSettlementList.get(i).clear();
						}
						saveBtn.click();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
				saveVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    navigate.navigateToAccounts();
		    Thread.sleep(Constant.Min_Sleep);
		    navigate.navigateToAccountDash();
		    Thread.sleep(Constant.Min_Sleep);
		    thirtyDaysReceivable.click();
		    Thread.sleep(Constant.Min_Sleep);
		    for (WebElement element : ledgerNameList_BillPopup) {
		    	for (String element2 : sLedger) {
			    	if(element2.contains(element.getText())){
			    		element.click();
			    		 for (WebElement billNoList_BillsTableAcct : billNoList_BillsTableAccts) {
			 		    	if(!sBillNo.contains(billNoList_BillsTableAcct.getText())){
			 		    		flag = true;
			 		    		break;
			 		    	}
			 		    }
			    	}
		    	}
		    }
		    billDetailsCloseBtn.click();
	    	Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to update voucher with bill value "+e);
		}
		return flag;
	}

	public boolean verifyBillNo_AfterBillNoUpdate(){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<String> sLedger = new ArrayList<>();
		String sBillNO = RandomStringUtils.randomNumeric(8);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			for(int j=0;j<narrationList.size();j++){
				js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(j));
				if(narrationList.get(j).getText().contains(sDate)){
					voucherNoList.get(j).click();
					break;
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<billEditBtn.size();i++){
					if(billEditBtn.get(i).isDisplayed()){
						sLedger.add(voucherNameWBillNo.get(i).getAttribute("value"));
						billEditBtn.get(0).click();
						billNoListSettlementPopup.get(0).clear();
						billNoListSettlementPopup.get(0).sendKeys(sBillNO);
						saveBtn.click();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
				saveVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    navigate.navigateToAccounts();
		    Thread.sleep(Constant.Min_Sleep);
		    navigate.navigateToAccountDash();
		    Thread.sleep(Constant.Min_Sleep);
		    thirtyDaysReceivable.click();
		    Thread.sleep(Constant.Min_Sleep);
		    for (WebElement element : ledgerNameList_BillPopup) {
		    	for (String element2 : sLedger) {
			    	if(element2.contains(element.getText())){
			    		element.click();
			    		 for (WebElement billNoList_BillsTableAcct : billNoList_BillsTableAccts) {
			 		    	if(billNoList_BillsTableAcct.getText().contains(sBillNO)){
			 		    		flag = true;
			 		    		break;
			 		    	}
			 		    }
			    	}
		    	}
		    }
		    billDetailsCloseBtn.click();
	    	Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to update voucher with bill value "+e);
		}
		return flag;
	}

	public boolean verifyBillValue_AfterVoucherUpdate(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sAmount = xls.get(iRowNo).get("Amount");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<String> sLedger = new ArrayList<>();
		String sBillNo = null;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			for(int j=0;j<narrationList.size();j++){
				js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(j));
				if(narrationList.get(j).getText().contains(sDate)){
					voucherNoList.get(j).click();
					break;
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<billEditBtn.size();i++){
					if(billEditBtn.get(i).isDisplayed()){
						sLedger.add(voucherNameWBillNo.get(i).getAttribute("value"));
						sBillNo = billEditBtn.get(0).getText();
					}
				}
				for(int i=0;i<creditAmtList.size()-1;i++){
					if(creditAmtList.get(i).isEnabled()){
						creditAmtList.get(i).sendKeys(Keys.CONTROL+"a");
						creditAmtList.get(i).sendKeys(Keys.DELETE);
						creditAmtList.get(i).sendKeys(sAmount);
					}
				}
				for(int i=0;i<debitAmtList.size()-1;i++){
					if(debitAmtList.get(i).isEnabled()){
						debitAmtList.get(i).sendKeys(Keys.CONTROL+"a");
						debitAmtList.get(i).sendKeys(Keys.DELETE);
						debitAmtList.get(i).sendKeys(sAmount);
					}
				}
				Thread.sleep(Constant.Min_Sleep);
				if(driver.getPageSource().contains("Voucher Form errors")){
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				Thread.sleep(Constant.Min_Sleep);
				if(closeBillPopup.isDisplayed()){
					Thread.sleep(Constant.Min_Sleep);
					closeBillPopup.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				if(driver.getPageSource().contains("Total amount is not completely utilized for Bill Settlement.")){
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				equalizeEditVoucherValue();
				adjustBillValue();
				saveVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    navigate.navigateToAccounts();
		    Thread.sleep(Constant.Min_Sleep);
		    navigate.navigateToAccountDash();
		    Thread.sleep(Constant.Min_Sleep);
		    thirtyDaysReceivable.click();
		    Thread.sleep(Constant.Min_Sleep);
		    for (WebElement element : ledgerNameList_BillPopup) {
		    	for (String element2 : sLedger) {
			    	if(element2.contains(element.getText())){
			    		element.click();
			    		 for(int k=0;k<billNoList_BillsTableAccts.size();k++){
			    			 if(billNoList_BillsTableAccts.get(k).getText().contains(sBillNo)){
				 		    	if(billValueList_BillsTableAccts.get(k).getText().contains(sAmount)){
				 		    		flag = true;
				 		    		break;
				 		    	}
			    			 }
			 		    }
			    	}
		    	}
		    }
		    billDetailsCloseBtn.click();
	    	Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to update voucher with bill value "+e);
		}
		return flag;
	}

	public boolean verifyBillNo(){
		boolean flag = false;
		String sBillNo = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<String> sLedger = new ArrayList<>();
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			for(int j=0;j<narrationList.size();j++){
				js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(j));
				if(narrationList.get(j).getText().contains(sDate)){
					voucherNoList.get(j).click();
					break;
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<billEditBtn.size();i++){
					if(billEditBtn.get(i).isDisplayed()){
						sBillNo = billEditBtn.get(0).getText();
						billEditBtn.get(0).click();
						sLedger.add(voucherNameWBillNo.get(i).getAttribute("value"));
					}
				}
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    navigate.navigateToAccounts();
		    Thread.sleep(Constant.Min_Sleep);
		    navigate.navigateToAccountDash();
		    Thread.sleep(Constant.Min_Sleep);
		    thirtyDaysPayable.click();
		    Thread.sleep(Constant.Min_Sleep);
		    for (WebElement element : ledgerNameList_BillPopup) {
		    	for (String element2 : sLedger) {
			    	if(element2.contains(element.getText())){
			    		element.click();
			    		 for (WebElement billNoList_BillsTableAcct : billNoList_BillsTableAccts) {
			 		    	if(sBillNo.contains(billNoList_BillsTableAcct.getText())){
			 		    		flag = true;
			 		    		break;
			 		    	}
			 		    }
			    	}
		    	}
		    }
		    billDetailsCloseBtn.click();
	    	Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to update voucher with bill value "+e);
		}
		return flag;
	}

	/**
	 * To save voucher. Select any draft voucher and click on save
	 * @return true, if voucher saved success pop up gets displayed
	 */
	public boolean updateVoucher_EditLedger(int iRowNo, String sheet){
		boolean flag = false;
		int i;
		String sVoucher = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			navigate.showAllEntries();
			for(i=0;i<voucherNoList.size();i++){
				js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(i));
				if(voucherNoList.get(i).getText().contains("TMP")){
					sVoucher = voucherNoList.get(i).getText();
					Actions actions = new Actions(driver);
					actions.moveToElement(voucherNoList.get(i)).perform();
					voucherNoList.get(i).click();
					Thread.sleep(Constant.Min_Sleep);
					break;
				}
			}
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				editLedgerValues(iRowNo, sheet);
				narrationTxt.sendKeys(" Update Voucher by editing ledger" +sDate);
				saveVoucherBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
				Thread.sleep(Constant.Min_Sleep);
				String sText1 = successMsgPopUp.getText();
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(sText1.contains(sVoucher)){
					backBtn_Voucher.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]")));
					String sNarration = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]/following::td[2]")).getText();
					if(sNarration.contains("Update Voucher by editing ledger" )){
						flag = true;
					}
				}
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to update voucher with bill value "+e);
		}
		return flag;
	}

	public boolean updateVoucher_SplitBillNo(int iRowNo, String sheet){
		boolean flag = false;
		String sVoucher = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			navigate.showAllEntries();
			for (WebElement element : voucherNoList) {
				js.executeScript("arguments[0].scrollIntoView(true);",element);
				if(element.getText().contains("TMP")){
					sVoucher = element.getText();
					Actions actions = new Actions(driver);
					actions.moveToElement(element).perform();
					element.click();
					Thread.sleep(Constant.Min_Sleep);
					break;
				}
			}
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				for (WebElement element : billEditBtn) {
					if(element.isDisplayed()){
						element.click();
						Thread.sleep(Constant.Min_Sleep);
						break;
					}
				}
				String sBalance = voucherAmt.getAttribute("value");
				String sBalanceSplit = Double.toString(Double.parseDouble(sBalance)/2);
				if(debitBillValuePopup.isDisplayed()){
					debitBillValuePopup.sendKeys(Keys.CONTROL+"a");
					debitBillValuePopup.sendKeys(Keys.DELETE);
					debitBillValuePopup.sendKeys(sBalanceSplit);
				}else{
					creditBillValuePopup.sendKeys(Keys.CONTROL+"a");
					creditBillValuePopup.sendKeys(Keys.DELETE);
					creditBillValuePopup.sendKeys(sBalanceSplit);
				}
				billNoTxtField.sendKeys("Bill"+sDate);
				billAmtTxtField.sendKeys(sBalanceSplit);
				billAddBtn_Popup.click();
				Thread.sleep(Constant.Min_Sleep);
				Double iAmt = Double.parseDouble(creditAmt.getAttribute("value")) + Double.parseDouble(debitAmt.getAttribute("value"));
				if(Double.parseDouble(sBalance) == iAmt){
					saveBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					flag = true;
				}
				narrationTxt.sendKeys(" Update Voucher by editing ledger" +sDate);
				saveVoucherBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
				Thread.sleep(Constant.Min_Sleep);
				String sText1 = successMsgPopUp.getText();
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(sText1.contains(sVoucher)){
					backBtn_Voucher.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]")));
					String sNarration = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]/following::td[2]")).getText();
					if(sNarration.contains("Update Voucher by editing ledger" )){
						flag = true;
					}
				}
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to update voucher with bill value "+e);
		}
		return flag;
	}

	public boolean updateVoucher_MismatchValues(){
		boolean flag = false;
		int i;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			navigate.showAllEntries();
			for(i=0;i<voucherNoList.size();i++){
				js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(i));
				if(voucherNoList.get(i).getText().contains("TMP")){
					Actions actions = new Actions(driver);
					actions.moveToElement(voucherNoList.get(i)).perform();
					voucherNoList.get(i).click();
					Thread.sleep(Constant.Min_Sleep);
					break;
				}
			}
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				for(int j=0;j<creditAmtList.size()-1;j++){
					if(creditAmtList.get(i).isEnabled()){
						creditAmtList.get(i).sendKeys(Keys.CONTROL+"a");
						creditAmtList.get(i).sendKeys(Keys.DELETE);
					}
				}
				narrationTxt.sendKeys(" Update Voucher by editing ledger" +sDate);
				saveVoucherBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
				Thread.sleep(Constant.Min_Sleep);
				if(valueMismatchError.isDisplayed()){
					flag = true;
				}
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to update voucher with bill value "+e);
		}
		return flag;
	}

	public boolean updateOriginBillNo(){
		boolean flag = false;
		List<String> sLedger = new ArrayList<>();
		String sBillNO = RandomStringUtils.randomNumeric(8);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			navigate.showAllEntries();
			for (WebElement element : voucherNoList) {
				js.executeScript("arguments[0].scrollIntoView(true);",element);
				if(element.getText().contains("TMP")){
					Actions actions = new Actions(driver);
					actions.moveToElement(element).perform();
					element.click();
					Thread.sleep(Constant.Min_Sleep);
					break;
				}
			}
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<billEditBtn.size();i++){
					if(billEditBtn.get(i).isDisplayed()){
						sLedger.add(voucherNameWBillNo.get(i).getAttribute("value"));
						billEditBtn.get(0).click();
						Thread.sleep(Constant.Min_Sleep);
						billNoListSettlementPopup.get(0).clear();
						billNoListSettlementPopup.get(0).sendKeys(sBillNO);
						saveBtn.click();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
				saveVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
			for (WebElement element : voucherNoList) {
				js.executeScript("arguments[0].scrollIntoView(true);",element);
				if(element.getText().contains("TMP")){
					Actions actions = new Actions(driver);
					actions.moveToElement(element).perform();
					element.click();
					Thread.sleep(Constant.Min_Sleep);
					break;
				}
			}
			tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.getPageSource().contains(sBillNO)){
					flag = true;
				}
		    }
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to update origin bill no "+e);
		}
		return flag;
	}

	public boolean updateBankLedger(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sBank = xls.get(iRowNo).get("Bank Ledger");
		String sType = xls.get(iRowNo).get("Voucher Type");
		String sCash = xls.get(iRowNo).get("Cash Ledger");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String sVoucher = null;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			navigate.showAllEntries();
			for(int j=0;j<narrationList.size();j++){
				js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(j));
				if(narrationList.get(j).getText().contains(sDate)){
					sVoucher = voucherNoList.get(j).getText();
					voucherNoList.get(j).click();
					break;
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				if(sType.contains("Bank")){
					bankLedgerDropDwn.click();
					searchBankLedger.sendKeys(sBank);
					driver.findElement(By.xpath(".//em[text()='"+sBank+"']")).click();
				}
				if(sType.contains("Cash")){
					cashLedger.click();
					searchCashLedger.sendKeys(sCash);
					driver.findElement(By.xpath(".//em[text()='"+sCash+"']")).click();
				}
				narrationTxt.sendKeys(" update Bank or Cash ledger");
				Thread.sleep(Constant.Min_Sleep);
				saveVoucherBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load sales view page");
				String sText = successMsgPopUp.getText();
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(sText.contains(sVoucher)){
					backBtn_Voucher.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]")));
					String sNarration = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]/following::td[2]")).getText();
					if(sNarration.contains("update Bank or Cash ledger")){
						flag = true;
					}
				}
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to update voucher with bank/cash ledger "+e);
		}
		return flag;
	}

	public boolean updateTransNoNDesc(){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String sVoucher = null;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			navigate.showAllEntries();
			for(int j=0;j<narrationList.size();j++){
				js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(j));
				if(narrationList.get(j).getText().contains(sDate)){
					sVoucher = voucherNoList.get(j).getText();
					voucherNoList.get(j).click();
					break;
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				transInstNoTxt.clear();
				transInstNoTxt.sendKeys("update Trans no");
				transDescTxt.clear();
				transDescTxt.sendKeys("update trans desc");
				narrationTxt.sendKeys(" update transaction no and description");
				Thread.sleep(Constant.Min_Sleep);
				saveVoucherBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load sales view page");
				String sText = successMsgPopUp.getText();
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(sText.contains(sVoucher)){
					backBtn_Voucher.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]")));
					String sNarration = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]/following::td[2]")).getText();
					if(sNarration.contains("update transaction no and description")){
						flag = true;
					}
				}
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to update voucher with bank/cash ledger "+e);
		}
		return flag;
	}

	public boolean updateVoucher_AddLedger(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sType = xls.get(iRowNo).get("Voucher Type");
		String sVoucher = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<Double> creditList = new ArrayList<>();
		List<Double> debitList = new ArrayList<>();
		Double totalCreditValue = 0.0, totalDebitValue = 0.0;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			for(int j=0;j<narrationList.size();j++){
				js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(j));
				if(narrationList.get(j).getText().contains(sDate)){
					sVoucher = voucherNoList.get(j).getText();
					voucherNoList.get(j).click();
					break;
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				addLedgerDetails(iRowNo, sheet);
				addBillPopupDetails(iRowNo, sheet);
				for(int k=0;k<creditAmtList.size()-1;k++){
					String sCreditAmt = creditAmtList.get(k).getAttribute("value");
					String sDebitAmt = debitAmtList.get(k).getAttribute("value");
					creditList.add(Double.parseDouble(sCreditAmt));
					debitList.add(Double.parseDouble(sDebitAmt));
					totalCreditValue += creditList.get(k);
					totalDebitValue += debitList.get(k);
				}
				Double totalDebit = Double.parseDouble(totalDebitAmt.getAttribute("value"));
				Double totalCredit = Double.parseDouble(totalCreditAmt.getAttribute("value"));
				if(sType.contains("Bank") || sType.contains("Cash")){
					totalDebitValue = totalDebit;
					totalCreditValue = totalCredit;
				}
				if(totalCreditValue.equals(totalCredit) && totalDebitValue.equals(totalDebit)){
					narrationTxt.sendKeys(" Update Voucher by adding ledger");
					saveVoucherBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
					Thread.sleep(Constant.Min_Sleep);
					String sText1 = successMsgPopUp.getText();
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(sText1.contains(sVoucher)){
						backBtn_Voucher.click();
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
						navigate.showAllEntries();
						js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]")));
						String sNarration = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]/following::td[2]")).getText();
						if(sNarration.contains("Update Voucher by adding ledger")){
							flag = true;
						}
					}
				}
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to update voucher adding ledger "+e);
		}
		return flag;
	}

	public boolean updateVoucher_DeleteLedger(int iRowNo, String sheet){
		boolean flag = false;
		String sVoucher = null, sCreditAmt = null, sDebitAmt = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<Double> creditList = new ArrayList<>();
		List<Double> debitList = new ArrayList<>();
		Double totalCreditValue = 0.0, totalDebitValue = 0.0;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			for(int j=0;j<narrationList.size();j++){
				js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(j));
				if(narrationList.get(j).getText().contains(sDate)){
					sVoucher = voucherNoList.get(j).getText();
					voucherNoList.get(j).click();
					break;
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<deleteLedgerDetails.size();i++){
					deleteLedgerDetails.get(i).click();
					Thread.sleep(Constant.Min_Sleep);
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(i == 1 ){
						break;
					}
				}
				for(int k=0;k<creditAmtList.size()-1;k++){
					if(creditAmtList.get(k).isDisplayed()){
						sCreditAmt = creditAmtList.get(k).getAttribute("value");
						creditList.add(Double.parseDouble(sCreditAmt));
						totalCreditValue += creditList.get(creditList.size()-1);
					}
					if(debitAmtList.get(k).isDisplayed()){
						sDebitAmt = debitAmtList.get(k).getAttribute("value");
						debitList.add(Double.parseDouble(sDebitAmt));
						totalDebitValue += debitList.get(debitList.size()-1);
					}
				}
				Double totalDebit = Double.parseDouble(totalDebitAmt.getAttribute("value"));
				Double totalCredit = Double.parseDouble(totalCreditAmt.getAttribute("value"));
				if(totalCreditValue.equals(totalCredit) && totalDebitValue.equals(totalDebit)){
					narrationTxt.sendKeys(" Update Voucher by deleting ledger ");
					saveVoucherBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
					Thread.sleep(Constant.Min_Sleep);
					String sText1 = successMsgPopUp.getText();
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(sText1.contains(sVoucher)){
						backBtn_Voucher.click();
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
						navigate.showAllEntries();
						js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]")));
						String sNarration = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]/following::td[2]")).getText();
						if(sNarration.contains("Update Voucher by deleting ledger")){
							flag = true;
						}
					}
				}
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to update voucher adding ledger "+e);
		}
		return flag;
	}

	public boolean updateVoucher_DeleteNAddLedger(int iRowNo, String sheet){
		boolean flag = false;
		String sVoucher = null, sCreditAmt = null, sDebitAmt = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<Double> creditList = new ArrayList<>();
		List<Double> debitList = new ArrayList<>();
		Double totalCreditValue = 0.0, totalDebitValue = 0.0;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			navigate.showAllEntries();
			for(int j=0;j<narrationList.size();j++){
				js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(j));
				if(narrationList.get(j).getText().contains(sDate)){
					sVoucher = voucherNoList.get(j).getText();
					voucherNoList.get(j).click();
					break;
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<deleteLedgerDetails.size();i++){
					deleteLedgerDetails.get(i).click();
					Thread.sleep(Constant.Min_Sleep);
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(i == 1 ){
						break;
					}
				}
				addLedgerDetails(iRowNo, sheet);
				addBillPopupDetails(iRowNo, sheet);
				for(int k=0;k<creditAmtList.size()-1;k++){
					if(creditAmtList.get(k).isDisplayed()){
						sCreditAmt = creditAmtList.get(k).getAttribute("value");
						creditList.add(Double.parseDouble(sCreditAmt));
						totalCreditValue += creditList.get(creditList.size()-1);
					}
					if(debitAmtList.get(k).isDisplayed()){
						sDebitAmt = debitAmtList.get(k).getAttribute("value");
						debitList.add(Double.parseDouble(sDebitAmt));
						totalDebitValue += debitList.get(debitList.size()-1);
					}
				}
				Double totalDebit = Double.parseDouble(totalDebitAmt.getAttribute("value"));
				Double totalCredit = Double.parseDouble(totalCreditAmt.getAttribute("value"));
				if(totalCreditValue.equals(totalCredit) && totalDebitValue.equals(totalDebit)){
					narrationTxt.sendKeys(" Update Voucher by deleting ledger ");
					saveVoucherBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
					Thread.sleep(Constant.Min_Sleep);
					String sText1 = successMsgPopUp.getText();
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(sText1.contains(sVoucher)){
						backBtn_Voucher.click();
						Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
						navigate.showAllEntries();
						js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]")));
						String sNarration = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]/following::td[2]")).getText();
						if(sNarration.contains("Update Voucher by deleting ledger")){
							flag = true;
						}
					}
				}
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to update voucher deleting N adding ledger "+e);
		}
		return flag;
	}

	public String validateOpeningBal(int iRowNo, String sheet){
		String sOpBal = null;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			navigate.showAllEntries();
			addVoucher.click();
			Thread.sleep(Constant.Min_Sleep);
			addLedgerDetails(iRowNo, sheet);
			sOpBal = openingBalList.get(0).getText();
		}catch(Exception e){
			System.err.println("Failed to validate opening balance of ledger "+e);
		}
		return sOpBal;
	}

	public boolean updateLedgerValues(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sAmount = xls.get(iRowNo).get("Amount");
		String sVoucher = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			for(int j=0;j<narrationList.size();j++){
				js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(j));
				if(narrationList.get(j).getText().contains(sDate)){
					sVoucher = voucherNoList.get(j).getText();
					voucherNoList.get(j).click();
					break;
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<creditAmtList.size()-1;i++){
					if(creditAmtList.get(i).isEnabled()){
						creditAmtList.get(i).sendKeys(Keys.CONTROL+"a");
						creditAmtList.get(i).sendKeys(Keys.DELETE);
						creditAmtList.get(i).sendKeys(sAmount);
					}
				}
				for(int i=0;i<debitAmtList.size()-1;i++){
					if(debitAmtList.get(i).isEnabled()){
						debitAmtList.get(i).sendKeys(Keys.CONTROL+"a");
						debitAmtList.get(i).sendKeys(Keys.DELETE);
						debitAmtList.get(i).sendKeys(sAmount);
					}
				}
				Thread.sleep(Constant.Min_Sleep);
				if(driver.getPageSource().contains("Voucher Form errors")){
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				Thread.sleep(Constant.Min_Sleep);
				if(closeBillPopup.isDisplayed()){
					Thread.sleep(Constant.Min_Sleep);
					closeBillPopup.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				if(driver.getPageSource().contains("Total amount is not completely utilized for Bill Settlement.")){
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				equalizeEditVoucherValue();
				adjustBillValue();
				Thread.sleep(Constant.Min_Sleep);
				narrationTxt.sendKeys(" Update Voucher by updating ledger values");
				saveVoucherBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
				Thread.sleep(Constant.Min_Sleep);
				String sText1 = successMsgPopUp.getText();
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(sText1.contains(sVoucher)){
					backBtn_Voucher.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]")));
					String sNarration = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sVoucher+"')]/following::td[2]")).getText();
					if(sNarration.contains("Update Voucher by updating ledger values")){
						flag = true;
					}
				}
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to update voucher adding ledger "+e);
		}
		return flag;
	}

	/**
	 * Approve Voucher. Select a draft voucher and approve it.
	 * @return true, if approved success pop up is displayed
	 */
	public boolean approveVoucher(int iRowNo, String sheet, String sGRNNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sType = xls.get(iRowNo).get("Voucher Type");
		int i;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			navigate.showAllEntries();
			if(sGRNNo == null){
				for(i=0;i<voucherNoList.size();i++){
					js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(i));
					if(voucherNoList.get(i).getText().contains(sType)){
						voucherNoList.get(i).click();
						Thread.sleep(Constant.Min_Sleep);
						break;
					}
				}
			}else{
				filterText.sendKeys(sGRNNo);
				Thread.sleep(Constant.Min_Sleep);
				Actions actions = new Actions(driver);
				actions.moveToElement(driver.findElement(By.partialLinkText(sType))).perform();
				driver.findElement(By.partialLinkText(sType)).click();
				Thread.sleep(Constant.Min_Sleep);
			}
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    Constant.waitFor(ExpectedConditions.elementToBeClickable(editVoucherBtn), "Failed to load edit page");
		    Thread.sleep(Constant.Medium_Sleep);
			if(editVoucherBtn.isDisplayed()){
				js.executeScript("window.scrollBy(0,-500)");
				editVoucherBtn.click();
				if(totalDebitAmt.getAttribute("value").equals(totalCreditAmt.getAttribute("value"))){
					narrationTxt.sendKeys(" Approved through automation"+sDate);
					approveVoucherBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
					String sText = successMsgPopUp.getText();
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					String[] list = sText.split(":");
					js.executeScript("window.scrollBy(0,-5000)");
					backBtn_Voucher.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+list[1].trim()+"')]/following::td[2]")));
					String sNarration = driver.findElement(By.xpath(".//td/a[contains(text(),'"+list[1].trim()+"')]/following::td[2]")).getText();
					if(sNarration.contains(sDate)){
						flag = true;
					}
				}
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to approve voucher "+e);
		}
		return flag;
	}

	public boolean mandatoryFieldsCheck(){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			addVoucher.click();
			Thread.sleep(Constant.Min_Sleep);
			saveVoucherBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(voucherTypeMandatoryWarning.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to check mandatory fields "+e);
		}
		return flag;
	}

	public boolean saveWOLedger(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sType = xls.get(iRowNo).get("Voucher Type");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			addVoucher.click();
			Thread.sleep(Constant.Min_Sleep);
			Select select = new Select(voucherTypeDrpDown);
			select.selectByVisibleText(sType);
			saveVoucherBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(addLedgerWarning.isDisplayed()){
				flag = true;
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Warning not displayed when saved voucher without ledger "+e);
		}
		return flag;
	}

	public boolean mandatoryLedgerWarning(){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			addVoucher.click();
			Thread.sleep(Constant.Min_Sleep);
			addLedger.click();
			Thread.sleep(Constant.Min_Sleep);
			if(mandatoryLedgerWarn.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to mandatory error displayed for ledger "+e);
		}
		return flag;
	}

	public boolean invalidLedgerWarning(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sType = xls.get(iRowNo).get("Voucher Type");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			addVoucher.click();
			Thread.sleep(Constant.Min_Sleep);
			Select select = new Select(voucherTypeDrpDown);
			select.selectByVisibleText(sType);
			ledgerNameTxt.sendKeys("test");
			Thread.sleep(Constant.Min_Sleep);
			amountTxt.sendKeys("25");
			addLedger.click();
			Thread.sleep(Constant.Min_Sleep);
			if(invalidLedgerWarning.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to check invalid ledger warning "+e);
		}
		return flag;
	}

	public boolean debitCreditValueNotMatched(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sType = xls.get(iRowNo).get("Voucher Type");
		String sLedger = xls.get(iRowNo).get("Ledger Name");
		String sAmount = xls.get(iRowNo).get("Amount");
		String[] sLedgerOptions = sLedger.split(",");
		int l = 0;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			addVoucher.click();
			Thread.sleep(Constant.Min_Sleep);
			Select select = new Select(voucherTypeDrpDown);
			select.selectByVisibleText(sType);
			for(int i=0;i<sLedgerOptions.length;i++){
				Select dr_cr = new Select(dDr_CrDrpDwn);
				dr_cr.selectByVisibleText(sLedgerOptions[i+1].trim());
				ledgerNameTxt.sendKeys(sLedgerOptions[i].trim());
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//ul/li[1]/a[contains(text(),'"+sLedgerOptions[i].trim()+"')]")).click();
				amountTxt.sendKeys(Double.toString(Double.parseDouble(sAmount)+i));
				addLedger.click();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.findElement(By.id("id_v_particular-"+l+"-ledger_label")).getAttribute("value").contains(sLedgerOptions[i].trim())){
					i = i+1;
					l++;
					if(i==7){
						break;
					}
				}
			}
			saveVoucherBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(drCrNotMatch.isDisplayed()){
				flag = true;
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to check invalid ledger warning "+e);
		}
		return flag;
	}

	public boolean mandatoryFieldsBillPopup(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sLedger = xls.get(iRowNo).get("Ledger Name");
		String sAmount = xls.get(iRowNo).get("Amount");
		String[] sLedgerOptions = sLedger.split(",");
		int l = 0;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			addVoucher.click();
			Thread.sleep(Constant.Min_Sleep);
			for(int i=0;i<sLedgerOptions.length;i++){
				Select dr_cr = new Select(dDr_CrDrpDwn);
				dr_cr.selectByVisibleText(sLedgerOptions[i+1].trim());
				ledgerNameTxt.sendKeys(sLedgerOptions[i].trim());
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//ul/li[1]/a[contains(text(),'"+sLedgerOptions[i].trim()+"')]")).click();
				amountTxt.sendKeys(sAmount);
				addLedger.click();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.findElement(By.id("id_v_particular-"+l+"-ledger_label")).getAttribute("value").contains(sLedgerOptions[i].trim())){
					i = i+1;
					l++;
					if(i==7){
						break;
					}
				}
			}
			for (WebElement element : billAddBtn) {
				if(element.isDisplayed()){
					element.click();
					Thread.sleep(Constant.Min_Sleep);
					break;
				}
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(closeBillPopup), "Failed to load bill popup");
			if(billPopUp.isDisplayed()){
				billAddBtn_Popup.click();
				if(billNoMandatoryWarn.isDisplayed() && amtMandatoryWarn.isDisplayed()){
					closeBillPopup.click();
					Thread.sleep(Constant.Min_Sleep);
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check invalid ledger warning "+e);
		}
		return flag;
	}

	public boolean checkWarn_BillLessThanBal(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addVoucherMandatoryDetails(iRowNo, sheet);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(closeBillPopup), "Failed to load bill popup");
			if(billPopUp.isDisplayed()){
				String sBalance = balanceAmt.getAttribute("value");
				billNoTxtField.sendKeys("Bill"+sDate);
				billAmtTxtField.sendKeys(Double.toString(Double.parseDouble(sBalance)-1));
				billAddBtn_Popup.click();
				Thread.sleep(Constant.Min_Sleep);
				saveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(billSettlementWarning.isDisplayed()){
					flag = true;
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check warning when bill value entered less than balance "+e);
		}
		return flag;
	}

	public void addVoucherMandatoryDetails(int iRowNo, String sheet){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sLedger = xls.get(iRowNo).get("Ledger Name");
		String sAmount = xls.get(iRowNo).get("Amount");
		String[] sLedgerOptions = sLedger.split(",");
		int l = 0;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			addVoucher.click();
			Thread.sleep(Constant.Min_Sleep);
			for(int i=0;i<sLedgerOptions.length;i++){
				Select dr_cr = new Select(dDr_CrDrpDwn);
				dr_cr.selectByVisibleText(sLedgerOptions[i+1].trim());
				ledgerNameTxt.sendKeys(sLedgerOptions[i].trim());
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//ul/li[1]/a[contains(text(),'"+sLedgerOptions[i].trim()+"')]")).click();
				amountTxt.sendKeys(sAmount);
				addLedger.click();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.findElement(By.id("id_v_particular-"+l+"-ledger_label")).getAttribute("value").contains(sLedgerOptions[i].trim())){
					i = i+1;
					l++;
					if(i==7){
						break;
					}
				}
			}
			for (WebElement element : billAddBtn) {
				if(element.isDisplayed()){
					element.click();
					Thread.sleep(Constant.Min_Sleep);
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add mandatory voucher details "+e);
		}
	}

	public boolean checkWarn_BillGreaterThanBal(int iRowNo, String sheet){
		boolean flag = false;

		try{
			addVoucherMandatoryDetails(iRowNo, sheet);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(closeBillPopup), "Failed to load bill popup");
			if(billPopUp.isDisplayed()){
				String sBalance = balanceAmt.getAttribute("value");
				billNoTxtField.sendKeys("Bill"+sDate);
				billAmtTxtField.sendKeys(Double.toString(Double.parseDouble(sBalance)+100));
				billAddBtn_Popup.click();
				Thread.sleep(Constant.Min_Sleep);
				saveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(settlmentExceedsWarn.isDisplayed()){
					flag = true;
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					resetBillPopup.click();
					Thread.sleep(Constant.Min_Sleep);
					closeBillPopup.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to check warning when bill value entered less than balance "+e);
		}
		return flag;
	}

	/**
	 * To create bank voucher with a bill settlement
	 * @param iRowNo - to get data from test data sheet
	 * @param sheet - sheet name
	 * @return true, When new bank voucher is created and get listed in list grid
	 * @throws Exception
	 */

	public boolean addVoucher(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sBank = xls.get(iRowNo).get("Bank Ledger");
		String sProject = xls.get(iRowNo).get("Project");
		String sType = xls.get(iRowNo).get("Voucher Type");
		String sCash = xls.get(iRowNo).get("Cash Ledger");
		String sSettlement = xls.get(iRowNo).get("Bill Settlement");
		List<Double> creditList = new ArrayList<>();
		List<Double> debitList = new ArrayList<>();
		Double totalCreditValue = 0.0, totalDebitValue = 0.0;
		int j;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			navigate.showAllEntries();
			int iList = voucherList.size();
			addVoucher.click();
			Thread.sleep(Constant.Min_Sleep);
			Select select = new Select(voucherTypeDrpDown);
			select.selectByVisibleText(sType);
			if(sType.contains("Bank")){
				bankLedgerDropDwn.click();
				searchBankLedger.sendKeys(sBank);
				driver.findElement(By.xpath(".//em[text()='"+sBank+"']")).click();
			}
			if(sType.contains("Cash")){
				cashLedger.click();
				searchCashLedger.sendKeys(sCash);
				driver.findElement(By.xpath(".//em[text()='"+sCash+"']")).click();
			}
			projectDrpDown.click();
			searchProject.sendKeys(sProject);
			driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
			transInstNoTxt.sendKeys(sDate);
			transDescTxt.sendKeys("automation test");
			addLedgerDetails(iRowNo, sheet);
			if(sSettlement != null){
				if(sSettlement.contains("Full")){
					getBillValue();
					addBillPopupDetails(iRowNo, sheet);
				}else if(sSettlement.contains("Partial")){
					addBillPopupDetails(iRowNo, sheet);
				}else{
					getBillValue();

				}
			}
			for(int k=0;k<creditAmtList.size()-1;k++){
				String sCreditAmt = creditAmtList.get(k).getAttribute("value");
				String sDebitAmt = debitAmtList.get(k).getAttribute("value");
				creditList.add(Double.parseDouble(sCreditAmt));
				debitList.add(Double.parseDouble(sDebitAmt));
				totalCreditValue += creditList.get(k);
				totalDebitValue += debitList.get(k);
			}
			Double totalDebit = Double.parseDouble(totalDebitAmt.getAttribute("value"));
			Double totalCredit = Double.parseDouble(totalCreditAmt.getAttribute("value"));
			if(totalCreditValue.equals(totalCredit) && totalDebitValue.equals(totalDebit)){
				narrationTxt.sendKeys("automation test "+sDate);
				Thread.sleep(Constant.Min_Sleep);
				saveVoucherBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load sales view page");
				String sText = successMsgPopUp.getText();
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				backBtn_Voucher.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
				navigate.showAllEntries();
				int iActList = voucherList.size();
				for(j=0;j<narrationList.size();j++){
					JavascriptExecutor js = ((JavascriptExecutor) driver);
					js.executeScript("arguments[0].scrollIntoView(true);",voucherNoList.get(j));
					if(narrationList.get(j).getText().contains(sDate)){
						if(sText.contains(voucherNoList.get(j).getText()) && iList < iActList && voucherNoList.get(j).getText().contains(sType.substring(0,1))){
							flag = true;
							break;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Voucher creation failed "+e);

		}
		return flag;
	}

	public boolean settlementAmtGreaterWarn(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load voucher view page");
			addVoucher.click();
			Thread.sleep(Constant.Min_Sleep);
			addLedgerDetails(iRowNo, sheet);
			for (WebElement element : billAddBtn) {
				if(element.isDisplayed()){
					element.click();
					Thread.sleep(Constant.Min_Sleep);
					break;
				}
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(closeBillPopup), "Failed to load bill popup");
			if(billPopUp.isDisplayed()){
				String sBalance = balanceAmt.getAttribute("value");
				billNoTxtField.sendKeys("Bill"+sDate);
				billAmtTxtField.sendKeys(Double.toString(Double.parseDouble(sBalance)+1));
				billAddBtn_Popup.click();
				saveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(settlmentExceedsWarn.isDisplayed()){
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					flag = true;
					resetBillPopup.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				closeBillPopup.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to validate warning when settlement amt greater than bill value "+e);
		}
		return flag;
	}


	public void getBillValue(){
		try{
			for (WebElement element : billAddBtn) {
				if(element.isDisplayed()){
					element.click();
					Thread.sleep(Constant.Min_Sleep);
					break;
				}
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(closeBillPopup), "Failed to load bill popup");
			if(billPopUp.isDisplayed()){
				String[] sBillValue = firstBillValue.getText().split(" ");
				closeBillPopup.click();
				Thread.sleep(Constant.Min_Sleep);
				if(firstDebitAmt.isEnabled()){
					firstDebitAmt.sendKeys(Keys.CONTROL+"a");
					firstDebitAmt.sendKeys(Keys.DELETE);
					firstDebitAmt.sendKeys(sBillValue[0].trim());
				}else{
					firstCreditAmt.sendKeys(Keys.CONTROL+"a");
					firstCreditAmt.sendKeys(Keys.DELETE);
					firstCreditAmt.sendKeys(sBillValue[0].trim());
				}
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Getting bill value failed "+e);

		}
	}

	public void addLedgerDetails(int iRowNo, String sheet){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sLedger = xls.get(iRowNo).get("Ledger Name");
		String sAmount = xls.get(iRowNo).get("Amount");
		String sType = xls.get(iRowNo).get("Voucher Type");
		String[] sLedgerOptions = sLedger.split(",");
		try{
			int l = ledgerList.size()-1;
			for(int i=0;i<sLedgerOptions.length;i++){
				Select dr_cr = new Select(dDr_CrDrpDwn);
				dr_cr.selectByVisibleText(sLedgerOptions[i+1].trim());
				ledgerNameTxt.sendKeys(sLedgerOptions[i].trim());
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//ul/li[1]/a[contains(text(),'"+sLedgerOptions[i].trim()+"')]")).click();
				amountTxt.sendKeys(sAmount);
				addLedger.click();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.findElement(By.id("id_v_particular-"+l+"-ledger_label")).getAttribute("value").contains(sLedgerOptions[i].trim())){
					i = i+1;
					l++;
					if(i==7){
						break;
					}
				}
			}
			if(!(sType.contains("Bank") || sType.contains("Cash"))){
				equalizeAddVoucherValue();
			}
		}catch(Exception e){
			System.err.println("Failed to add ledger details "+e);
		}
	}

	public boolean addBillPopupDetails(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sType = xls.get(iRowNo).get("Voucher Type");
		try{
			for (WebElement element : billAddBtn) {
				if(element.isDisplayed()){
					element.click();
					Thread.sleep(Constant.Min_Sleep);
					Constant.waitFor(ExpectedConditions.elementToBeClickable(closeBillPopup), "Failed to load bill popup");
					if(billPopUp.isDisplayed()){
						resetBillPopup.click();
						Thread.sleep(Constant.Min_Sleep);
						String sBalance = balanceAmt.getAttribute("value");
						if(sType.contains("Bank") || sType.contains("Cash")){
							if(voucherAmt.getAttribute("value").equals(sBalance)){
								buttonAutoFill.click();
							}
						}else{
							if(!driver.getPageSource().contains(sDate)){
								billNoTxtField.sendKeys("Bill"+sDate);
							}else{
								billNoTxtField.sendKeys("Bill"+sDate.substring(8, 13));
							}
							billAmtTxtField.sendKeys(sBalance);
							billAddBtn_Popup.click();
						}
						Thread.sleep(Constant.Min_Sleep);
						Double iAmt = Double.parseDouble(creditAmt.getAttribute("value")) + Double.parseDouble(debitAmt.getAttribute("value"));
						if(Double.parseDouble(sBalance) == iAmt){
							saveBtn.click();
							Thread.sleep(Constant.Min_Sleep);
							flag = true;
						}
					}
				}
			}

		}catch(Exception e){
			System.err.println("Failed to add bill details "+e);
		}
		return flag;
	}

	public boolean addLedger(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sAccountGrp = xls.get(iRowNo).get("Account Group");
		String sLedgerName = xls.get(iRowNo).get("Ledger Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ledger view page");
			navigate.showAllEntries();
			int iBeforeAdd = voucherList.size();
			addNewLedger.click();
			Thread.sleep(Constant.Min_Sleep);
			ledgerNameField.sendKeys(sLedgerName+sDate.substring(8, 13));
			ledgerDescriptionField.sendKeys(sLedgerName+sDate);
			acctGrp.click();
			driver.findElement(By.xpath(".//*[@id='id_group_select']/option[contains(text(),'"+sAccountGrp+"')]")).click();
			saveLedgerBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ledger view page");
			navigate.showAllEntries();
			int iAfterAdd = voucherList.size();
			if(iAfterAdd > iBeforeAdd &&
					driver.getPageSource().contains(sLedgerName+sDate)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Ledger validation failed "+e);
		}
		return flag;
	}

	public boolean updateLedger(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sAccountGrp = xls.get(iRowNo).get("Account Group");
		String sLedgerName = xls.get(iRowNo).get("Ledger Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ledger view page");
			addLedger(iRowNo, sheet);
			int iBeforeAdd = voucherList.size();
			searchLedger.sendKeys(sLedgerName+sDate.substring(8, 13));
			driver.findElement(By.linkText(sLedgerName+sDate.substring(8, 13))).click();
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    if(ledgerDescriptionField.isDisplayed()){
				ledgerDescriptionField.clear();
				ledgerDescriptionField.sendKeys(sLedgerName+sDate.substring(4));
				acctGrp.click();
				driver.findElement(By.xpath(".//*[@id='id_group_select']/option[contains(text(),'"+sAccountGrp+"')]")).click();
				saveLedgerBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load ledger view page");
				navigate.showAllEntries();
				int iAfterAdd = voucherList.size();
				if(iAfterAdd == iBeforeAdd &&
						driver.getPageSource().contains(sLedgerName+sDate.substring(4))){
					flag = true;
				}
		    }
		    driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Ledger validation failed "+e);
		}
		return flag;
	}

	public boolean accountDashboardValidation(){
		boolean flag = false;
		List<BigDecimal> RecBal = new ArrayList<>();
		List<BigDecimal> overdueRec = new ArrayList<>();
		List<BigDecimal> payBal = new ArrayList<>();
		List<BigDecimal> overduePay = new ArrayList<>();
		List<BigDecimal> cashBal = new ArrayList<>();
		List<BigDecimal> bankBal = new ArrayList<>();
		List<BigDecimal> salesBal = new ArrayList<>();
		BigDecimal cashBalance = new BigDecimal(0), bankBalance = new BigDecimal(0), salesBalance = new BigDecimal(0), amountRec = new BigDecimal(0), receivables = new BigDecimal(0), totalRec = new BigDecimal(0), amountPay = new BigDecimal(0), payables = new BigDecimal(0),
				totalPay = new BigDecimal(0), cashTotal = new BigDecimal(0), bankTotal = new BigDecimal(0), salesTotal = new BigDecimal(0);
		String sBalance;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			//Bills Receivable by you
			List<WebElement> Receivables = driver.findElements(By.xpath(".//div/div[1][@class='invoice-box bills']/div/span[@class='invoice-box-value']"));
			for(int i=0;i<Receivables.size();i++){
				sBalance = Receivables.get(i).getText();
				RecBal.add(new BigDecimal(sBalance.replaceAll(",", "")));
				receivables = RecBal.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
			}
			sBalance = driver.findElement(By.xpath(".//div/div[1][@class='invoice-box bills']/div/span[@class='invoice-box-value total']")).getText();
			totalRec = new BigDecimal(sBalance.replaceAll(",", ""));
			List<WebElement> OverdueReceivable = driver.findElements(By.xpath(".//div/div[2][@class='invoice-box bills']/div/span[2]"));
			for(int i=0;i<OverdueReceivable.size();i++){
				sBalance = OverdueReceivable.get(i).getText();
				overdueRec.add(new BigDecimal(sBalance.replaceAll(",", "")));
				amountRec = overdueRec.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
			}
			//Bills Payable by you
			List<WebElement> Payable = driver.findElements(By.xpath(".//div/div[1][@class='invoice-box invoice']/div/span[@class='invoice-box-value']"));
			for(int i=0;i<Payable.size();i++){
				sBalance = Payable.get(i).getText();
				payBal.add(new BigDecimal(sBalance.replaceAll(",", "")));
				payables = payBal.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
			}
			sBalance = driver.findElement(By.xpath(".//div/div[1][@class='invoice-box invoice']/div/span[@class='invoice-box-value total']")).getText();
			totalPay = new BigDecimal(sBalance.replaceAll(",", ""));
			List<WebElement> OverduePayable = driver.findElements(By.xpath(".//div/div[2][@class='invoice-box invoice']/div/span[2]"));
			for(int i=0;i<OverduePayable.size();i++){
				sBalance = OverduePayable.get(i).getText();
				overduePay.add(new BigDecimal(sBalance.replaceAll(",", "")));
				amountPay = overduePay.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
			}
			//CAsh Balance
			List<WebElement> cashList = driver.findElements(By.xpath(".//tr/th/span[text()='Cash In Hand']/following::tr[2]/td[2]"));
			for(int i=0;i<cashList.size();i++){
				sBalance = cashList.get(i).getText();
				cashBal.add(new BigDecimal(sBalance.replaceAll(",", "")));
				cashBalance = cashBal.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//span[text()='Cash In Hand']/ancestor::div[@class='account-box scroll-container']")));
				Thread.sleep(2000);
			}
			sBalance = driver.findElement(By.xpath(".//span[text()='Cash In Hand']/following::span[1]")).getText();
			cashTotal = new BigDecimal(sBalance.replaceAll(",", ""));
			//Bank Balance
			List<WebElement> bankList = driver.findElements(By.xpath(".//*[@id='page-wrapper']/div/div[1]/div[3]/div/div[2]/div/div[1]/table/tbody/tr/td[2]"));
			for(int i=0;i<bankList.size();i++){
				sBalance = bankList.get(i).getText();
				bankBal.add(new BigDecimal(sBalance.replaceAll(",", "")));
				bankBalance = bankBal.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//span[text()='Bank Balance']/ancestor::div[@class='account-box scroll-container']")));
				Thread.sleep(2000);
			}
			sBalance = driver.findElement(By.xpath(".//span[text()='Bank Balance']/following::span[1]")).getText();
			bankTotal = new BigDecimal(sBalance.replaceAll(",", ""));
			//sales
			List<WebElement> amtList = driver.findElements(By.xpath(".//*[@id='top_customers_list']/tr/td[2]"));
			for(int i=0;i<amtList.size();i++){
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//span[text()='Top 8 Customers']/ancestor::div[@class='revenue-box scroll-container']")));
				sBalance = amtList.get(i).getText();
				salesBal.add(new BigDecimal(sBalance.replaceAll(",", "")));
				salesBalance = salesBal.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
			}
			String sBankAndCashBal = driver.findElement(By.xpath(".//span[contains(text(),'Top 8 Customers')]/following::span[1]/span")).getText();
			salesTotal = new BigDecimal(sBankAndCashBal.replaceAll(",", ""));
			if(receivables.compareTo(totalRec) == 0 && amountRec.compareTo(totalRec) <= 0 && payables.compareTo(totalPay) == 0 && amountPay.compareTo(totalPay) <= 0 &&
					cashTotal.compareTo(cashBalance) == 0 && bankTotal.compareTo(bankBalance) == 0 && salesTotal.compareTo(salesBalance) == 0){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Accounts dashboard validation failed "+e);
		}
		return flag;
	}

	/**
	 * Run trial Balance
	 * @return true, if all the tabs gets displayed
	 * @throws Exception
	 */

	public boolean runTrialBal() throws Exception{
		boolean flag = false;
		try{
			runTrialBalanceBtn.click();
			if(generateStatementsBtn.isDisplayed()){
				generateStatementsBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(moderationPopup.isDisplayed()){
					proceedBtn.click();
					trialBalTab.click();
					if(trialNetBal.isDisplayed()){
						provisionalBalSheetTab.click();
						Thread.sleep(Constant.Min_Sleep);
						if(provisionalBalHeading.isDisplayed()){
							provisionalProfiltLossTab.click();
							Thread.sleep(Constant.Min_Sleep);
							if(provisionalProfitLossHeading.isDisplayed()){
								notesTab.click();
								Thread.sleep(Constant.Min_Sleep);
								if(notesHeading.isDisplayed()){
									flag = true;
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Run trial balance and generate statements validation failed "+e);
		}
		return flag;
	}

	public boolean purchaseRegistReportColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.visibilityOf(filterBtn), "Failed to load grn report");
			filterBtn.click();
			applyBtn.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(applyBtn), "Failed to load grn report");
			flag = Constant.verifyColumnOrder_ScrollTable(purchaseRegisterColumn,sColumn);
		}catch(Exception e){
			System.err.println("Sales Report column validation with draft failed "+e);
		}
		return flag;
	}

	public boolean gstrpurchaseReportColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.visibilityOf(filterBtn), "Failed to load grn report");
			filterBtn.click();
			applyBtn.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(applyBtn), "Failed to load grn report");
			flag = Constant.verifyColumnOrder_ScrollTable(gstrReportColumn,sColumn);
		}catch(Exception e){
			System.err.println("GSTR purchase Report column validation with draft failed "+e);
		}
		return flag;
	}

	public boolean gstrSalesReportColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			filterBtn.click();
			grnSalesReportView.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(grnSalesReportView), "Failed to load grn report");
			flag = Constant.verifyColumnOrder_ScrollTable(gstrReportColumn,sColumn);
		}catch(Exception e){
			System.err.println("GSTR Sales Report column validation with draft failed "+e);
		}
		return flag;
	}

	public boolean bankReconciliationColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			brsLedger.click();
			firstLedger_BRS.click();
			Thread.sleep(Constant.Min_Sleep);
			loadStatement.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder_ScrollTable(bankReconciliationColumns,sColumn);
		}catch(Exception e){
			System.err.println("BRS column validation failed "+e);
		}
		return flag;
	}

	public boolean validateBRS_AddingVoucher(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sBank = xls.get(iRowNo).get("Bank Ledger");
		String sVoucherNo = null;
		try{
			addVoucher(iRowNo, sheet);
			for(int i=0;i<narrationList.size();i++){
				if(narrationList.get(i).getText().contains(sDate)){
					sVoucherNo = voucherNoList.get(i).getText();
				}
			}
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToBankReconciliation();
			Thread.sleep(Constant.Min_Sleep);
			brsLedger.click();
			searchLedgerDrpDwn.sendKeys(sBank);
			driver.findElement(By.xpath(".//em[text()='"+sBank+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			loadStatement.click();
			Thread.sleep(Constant.Min_Sleep);
			for (WebElement element : voucherNo) {
				if(element.getText().contains(sVoucherNo)){
					flag = true;
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate BRS with created voucher "+e);
		}
		return flag;
	}


}
