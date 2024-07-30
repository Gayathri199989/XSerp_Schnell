package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NavigateToPages {

	@FindBy(id="menu_accounts")
	private WebElement accountsModule;

	@FindBy(id="li_ledger")
	WebElement ledgerTab;

	@FindBy(id="li_brs")
	private WebElement bankReconciliation;

	@FindBy(id="li_voucher")
	private WebElement voucherTab;

	@FindBy(xpath=".//span[text()='Voucher']")
	private WebElement voucherPage;

	@FindBy(id="pagination-select")
	private WebElement showEntriesDropDwn;

	@FindBy(xpath=".//span[text()='Bank Reconciliation']")
	private WebElement bankReconciliationPage;

	@FindBy(xpath=".//span[text()='Ledger']")
	private WebElement ledgerPage;

	@FindBy(id="li_ac_dashboard")
	private WebElement accountsDashboard;

	@FindBy(xpath="//h3[text()='Receivables']")
	private WebElement billsReceivableHead;

	@FindBy(id="li_statements")
	private WebElement provisionalStatementsTab;

	@FindBy(xpath=".//label[text()='Provisional Statements']")
	private WebElement provisionalStatementpage;

	@FindBy(id="menu_audit")
	public WebElement auditingHeader;

	@FindBy(xpath=".//span[contains(text(),'Internal Control')]")
	private WebElement internalControlHeader;

	@FindBy(id="credit_debit")
	private WebElement creditDebitNoteTab;

	@FindBy(xpath=".//span[contains(text(),'Credit/Debit Note')]")
	private WebElement creditDebitNoteHeader;

	@FindBy(id="li_internal_control")
	private WebElement internalControlTab;

	@FindBy(id="menu_hr")
	public WebElement hrModule;

	@FindBy(id="li_employee")
	private WebElement employeesTab;

	@FindBy(xpath=".//span[text()='Employees']")
	private WebElement employeePage;

	@FindBy(id="li_paystructure") WebElement payStructureTab;

	@FindBy(xpath=".//span[text()='Pay Structure']")
	private WebElement payStructurePage;

	@FindBy(id="li_attendance") WebElement attendanceTab;

	@FindBy(xpath=".//span[text()='Attendance']") WebElement attendancePage;

	@FindBy(id="menu_master")
	private WebElement masterModule;

	@FindBy(id="li_party")
	private WebElement partyTab;

	@FindBy(xpath="//span[text()='Party']")
	private WebElement partyPage;

	@FindBy(id="li_goods")
	private WebElement materialTab;

	@FindBy(xpath=".//span[text()='Goods']")
	private WebElement materialPage;

	@FindBy(id="menu_purchase")
	private WebElement purchaseHeader;

	@FindBy(id="li_purchase_order")
	private WebElement purchaseTab;

	@FindBy(xpath=".//span[text()='PURCHASE']")
	private WebElement purchaseHeading;

	@FindBy(id="menu_sales")
	WebElement salesHeader;

	@FindBy(id="li_sr")
	WebElement salesReturnTab;

	@FindBy(id="li_status_report")
	WebElement statusReportTab;

	@FindBy(xpath=".//span[text()='Sales Return']")
	 WebElement salesReturnPage;

	@FindBy(xpath=".//span[text()='Status Report']")
	 WebElement statusReportPage;

	@FindBy(id="li_tax_report")
	 WebElement taxReportTab;

	@FindBy(id="li_sales_material_report")
	 WebElement materialReportTab;

	@FindBy(id="li_sales_report")
	 WebElement salesReportTab;

	@FindBy(id="li_job_in_register")
	 WebElement jobInReportTab;

	@FindBy(id="li_job_out_register")
	 WebElement jobOutReportTab;

	@FindBy(id="li_issue_stock_report")
	 WebElement internalStockFlowReportTab;

	@FindBy(xpath=".//span[text()='Tax Report']")
	 WebElement taxReportPage;

	@FindBy(xpath=".//span[text()='Material Report']")
	 WebElement materialReportPage;

	@FindBy(xpath=".//span[text()='Sales Report']")
	 WebElement salesReportPage;

	@FindBy(xpath="//span[contains(text(),'Job In Stock Register')]")
	 WebElement jobInStockReportPage;

	@FindBy(xpath="//span[contains(text(),'Job Out Stock Register')]")
	 WebElement jobOutStockReportPage;

	@FindBy(xpath="//span[contains(text(),'Internal Stock Flow')]")
	 WebElement internalStockFlowReportPage;

	@FindBy(id="li_custom_report")
	 WebElement customReport;

	@FindBy(xpath=".//span[text()='Custom Report']")
	 WebElement customReportPage;

	@FindBy(xpath=".//span[contains(text(),'Invoice')]")
	 WebElement invoicePage;

	@FindBy(id="li_invoice")
	 WebElement invoiceTab;

	@FindBy(id="li_oa")
	 WebElement oaTab;

	@FindBy(xpath=".//span[text()='Order Acknowledgement']")
	 WebElement oaPage;

	@FindBy(id="li_tax")
	private WebElement taxTab;

	@FindBy(xpath=".//a[text()='Tax']")
	private WebElement taxPage;

	@FindBy(id="menu_stores")
	private WebElement storeHeader;

	@FindBy(id="li_st_dashboard")
	private WebElement storeDash;

	@FindBy(xpath=".//span[contains(text(),'Delivery Challan')]")
	private WebElement deliveryChallanPage;

	@FindBy(id="li_dc")
	private WebElement deliveryChallan;

	@FindBy(id="li_issue")
	private WebElement issueTab;

	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	private WebElement storesDashPage;

	@FindBy(xpath=".//span[contains(text(),'Issue')]")
	private WebElement issuePage;

	@FindBy(id="li_indent")
	private WebElement indentTab;

	@FindBy(xpath=".//span[text()='Indent']")
	private WebElement indentPage;

	@FindBy(id="li_gstr_purchase_report")
	private WebElement purchaseReport;

	@FindBy(id="li_gstr2_purchase_report")
	private WebElement gstrPurchaseReport;

	@FindBy(xpath="//span[contains(text(),'GSTR-2 Purchase Report')]")
	private WebElement gstrPurchaseReportPage;

	@FindBy(xpath=".//span[contains(text(),'Purchase Register')]")
	private WebElement purchaseReportPage;

	@FindBy(id="li_gstr_sales_report")
	private WebElement gstrSalesReportTab;

	@FindBy(xpath=".//span[text()='GSTR-1 Sales Report']")
	private WebElement gstrSalesReportHeading;

	@FindBy(id="li_expenses")
	private WebElement expensesTab;

	@FindBy(xpath=".//label[text()='My Expenses']")
	private WebElement expensesPage;

	@FindBy(id="li_receipt")
	private WebElement receiptTab;

	@FindBy(id="li_irn")
	private WebElement issueReturnTab;

	@FindBy(xpath=".//span[text()='Internal Receipt']")
	private WebElement issueReturnPage;

	@FindBy(xpath=".//span[text()='Goods Receipt']")
	private WebElement receiptPage;

	@FindBy(id="li_po_report")
	private WebElement poWiseReportsTab;

	@FindBy(xpath=".//span[text()='P.O. Wise Report']")
	private WebElement poWiseReportsHeading;

	@FindBy(id="li_material_report")
	private WebElement materialWiseReportsTab;

	@FindBy(xpath=".//span[text()='Material Wise Report']")
	private WebElement materialWiseReportsHeading;

	@FindBy(id="li_stock_report")
	private WebElement stockReportsTab;

	@FindBy(xpath=".//span[text()='Stock Report']")
	private WebElement reportsPage;

	@FindBy(id="li_grn_report")
	private WebElement grnReportTab;

	@FindBy(xpath=".//span[text()='GRN Report']")
	private WebElement grnReportPage;

	@FindBy(id="li_dc_report")
	private WebElement dcReportTab;

	@FindBy(xpath=".//span[text()='DC Report']")
	private WebElement dcReportPage;

	@FindBy(id="li_issue_report")
	private WebElement materialReceiptIssueReportTab;

	@FindBy(xpath=".//span[text()='Material Receipt']")
	private WebElement materialReceiptPage;

	@FindBy(id="li_shortage")
	private WebElement shortageListTab;

	@FindBy(xpath=".//span[text()='Shortage List']")
	private WebElement shortageListPage;

	@FindBy(xpath="//button[contains(@class,'btn-setting')]/img[@title='settings']")
	private WebElement settingIcon;

	@FindBy(id="a-invoice-template-menu")
	private WebElement invoiceTemplate;

	@FindBy(xpath=".//span[contains(text(),'Invoice Template')]")
	private WebElement invoiceTemplatePge;

	@FindBy(id="a-expense-configration-menu")
	private WebElement expenseconfig;

	@FindBy(xpath=".//ul/li[@class='li_view_template'][3]/a")
	private WebElement seConfig;

	@FindBy(xpath="//h3[contains(text(),'Sales Estimate Print Configuration')]")
	private WebElement seConfigPage;

	@FindBy(xpath="//h3[contains(text(),'Expense Configuration')]")
	private WebElement expenseConfigPage;

	@FindBy(id="li_print_template")
	private WebElement printTemp;

	@FindBy(id="a-po-config-menu")
	private WebElement poConfig;

	@FindBy(xpath="//span[contains(text(),'Purchase Order Template')]")
	private WebElement poConfigPage;

	@FindBy(id="a-user-menu")
	private WebElement usersTab;

	@FindBy(xpath=".//span[text()='Users']")
	private WebElement userPage;

	@FindBy(id="a-enterprise-profile-menu")
	private WebElement configurationTab;

	@FindBy(xpath=".//span[text()='Enterprise Profile']")
	private WebElement profileHeading;

	@FindBy(id="li_payment")
	private WebElement billSettlement;

	@FindBy(xpath="//span[text()='Bill Settlements']")
	private WebElement billSettlmentPage;

	@FindBy(id="li_sales_estimate")
	private WebElement salesEstimate;

	@FindBy(xpath="//span[contains(text(),'Sales Estimate')]")
	private WebElement salesEstimatePage;


	private WebDriver driver;
	public NavigateToPages(WebDriver driver){
		this.driver = driver;
	}

	/**
	 * To navigate to account header
	 */

	public void navigateToAccounts(){
		try{
			accountsModule.click();
			Thread.sleep(Constant.Min_Sleep);
			if(ledgerTab.isDisplayed()){
				Constant.log.info("Navigated to Accounts module");
			}
		}catch(Exception e){
			System.err.println("Navigate to Accounts not successful "+e);
		}
	}

	/**
	 * To navigate to account header
	 */

	public void navigateToBankReconciliation(){
		try{
			bankReconciliation.click();
			Thread.sleep(Constant.Min_Sleep);
			if(bankReconciliationPage.isDisplayed()){
				Constant.log.info("Navigated to Bank Reconciliation module");
			}
		}catch(Exception e){
			System.err.println("Navigate to Bank Reconciliation not successful "+e);
		}
	}

	/**
	 * Navigate to Voucher module
	 */
	public void navigateToVoucher(){
		try{
			voucherTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(voucherPage.isDisplayed()){
				Constant.log.info("Navigated to Voucher Page");
			}
		}catch(Exception e){
			System.err.println("Navigate to voucher page failed "+e);
		}
	}

	public boolean showAllEntries(){
		boolean flag = false;
		try{
			if(showEntriesDropDwn.isDisplayed()){
				Select select = new Select(showEntriesDropDwn);
				select.selectByVisibleText("All");
				Thread.sleep(Constant.Min_Sleep);
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to select all entries "+e);
		}
		return flag;
	}

	/**
	 * To navigate to ledger module
	 */

	public void navigateToLedger(){
		try{
			ledgerTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(ledgerPage.isDisplayed()){
				Constant.log.info("Navigated to Ledger");
			}
		}catch(Exception e){
			System.err.println("Navigate to Ledger not successful "+e);
		}
	}

	/**
	 * Navigate to Accounts dashboard
	 */

	public void navigateToAccountDash(){
		try{
			accountsDashboard.click();
			Thread.sleep(Constant.Min_Sleep);
			if(billsReceivableHead.isDisplayed()){
				Constant.log.info("Navigated to Accounts Dashboard");
			}
		}catch(Exception e){
			System.err.println("Navigate to Accounts dashboard not successful "+e);
		}
	}

	/**
	 * Navigate to Provisional statements
	 */

	public void navigateToProvisionalStatements(){
		try{
			provisionalStatementsTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(provisionalStatementpage.isDisplayed()){
				Constant.log.info("Navigated to Provisional statement Page");
			}
		}catch(Exception e){
			System.err.println("Navigate to Provisional statement page failed "+e);
		}
	}

	/**
	 * To Navigate to Auditing
	 */

	public void navigateToAuditing(){
		try{
			auditingHeader.click();
			if(internalControlTab.isDisplayed()){
				Constant.log.info("Auditing Header is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Auditing header is not navigated successfully "+e);
		}

	}

	/**
	 * To Navigate to ICD
	 */

	public void navigateToICD(){
		try{
			internalControlTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(internalControlHeader.isDisplayed()){
				Constant.log.info("ICD page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("ICD page navigation is not successful"+e);
		}
	}

	/**
	 * To Navigate to Credit/Debit note
	 */

	public void navigateToCredit_DebitNote(){
		try{
			creditDebitNoteTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(creditDebitNoteHeader.isDisplayed()){
				Constant.log.info("Credit debit note page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Credit debit note page navigation is not successful"+e);
		}
	}

	public void navigateToHR(){
		try{
			hrModule.click();
			Thread.sleep(Constant.Min_Sleep);
			if(employeesTab.isDisplayed()){
				Constant.log.info("Navigated to Hr module");
			}
		}catch(Exception e){
			System.err.println("Unable to navigate to HR module "+e);
		}
	}

	/**
	 * To navigate to employee module
	 */

	public void navigateToEmployees(){
		try{
			employeesTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(employeePage.isDisplayed()){
				Constant.log.info("Navigated to Employees");
			}
		}catch(Exception e){
			System.err.println("Navigate to Employees not successful "+e);
		}
	}

	public void navigateToPayStructure(){
		try{
			payStructureTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(payStructurePage.isDisplayed()){
				Constant.log.info("Navigated to Pay structure");
			}
		}catch(Exception e){
			System.err.println("Navigate to Pay structure not successful "+e);
		}
	}

	public void navigateToAttendance(){
		try{
			attendanceTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(attendancePage.isDisplayed()){
				Constant.log.info("Navigated to Attendance page");
			}
		}catch(Exception e){
			System.err.println("Navigate to Attendance not successful" +e);
		}
	}

	/**
	 * To navigate to Masters module
	 */

	public void navigateToMasters(){
		try{
			masterModule.click();
			Thread.sleep(Constant.Min_Sleep);
			if(partyTab.isDisplayed()){
				Constant.log.info("Navigated to Masters module");
			}
		}catch(Exception e){
			System.err.println("Navigate to Masters not successful "+e);
		}

	}

	/**
	 * To navigate to Material module
	 */

	public void navigateToMaterial(){
		try{
			materialTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(materialPage.isDisplayed()){
				Constant.log.info("Navigated to Materials");
			}
		}catch(Exception e){
			System.err.println("Navigate to Material not successful "+e);
		}

	}

	/**
	 * To navigate to party sub module
	 */

	public void navigateToParty(){
		try{
			partyTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(partyPage.isDisplayed()){
				Constant.log.info("Navigated to Party");
			}
		}catch(Exception e){
			System.err.println("Navigate to Party not successful "+e);
		}

	}

	/**
	 * To Navigate to Purchase Module
	 */

	public void navigateToPurchase_Header(){
		try{
			purchaseHeader.click();
			if(purchaseTab.isDisplayed()){
				Constant.log.info("Purchase Header is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Purchase header is not navigated successfully "+e);
		}

	}

	/**
	 * To Navigate to Purchase page
	 */

	public void navigateToPurchase(){
		try{
			purchaseTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(purchaseHeading.isDisplayed()){
				Constant.log.info("Purcahse page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Purcahse page navigation is not successful"+e);
		}
	}

	/**
	 * To Navigate to Sales
	 */

	public void navigateToSales(){
		try{
			salesHeader.click();
			if(statusReportTab.isDisplayed()){
				Constant.log.info("Sales Header is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Sales header is not navigated successfully "+e);
		}
	}

	public void navigateToSalesReturn(){
		try{
			salesReturnTab.click();
			if(salesReturnPage.isDisplayed()){
				Constant.log.info("Sales Return Page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Sales Return Page is not navigated successfully "+e);
		}
	}

	public void navigateToStatusReport(){
		try{
			statusReportTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(statusReportPage.isDisplayed()){
				Constant.log.info("Status Report page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Status Report page is not navigated successfully "+e);
		}
	}

	public void navigateToTaxReport(){
		try{
			taxReportTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(taxReportPage.isDisplayed()){
				Constant.log.info("Tax Report page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Tax Report page is not navigated successfully "+e);
		}
	}

	public void navigateToMaterialReport(){
		try{
			materialReportTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(materialReportPage.isDisplayed()){
				Constant.log.info("Material Report page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Material Report page is not navigated successfully "+e);
		}
	}

	public void navigateToSalesReport(){
		try{
			salesReportTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(salesReportPage.isDisplayed()){
				Constant.log.info("Sales Report page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Sales Report page is not navigated successfully "+e);
		}
	}

	public void navigateToJobInReport(){
		try{
			jobInReportTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(jobInStockReportPage.isDisplayed()){
				Constant.log.info("Job in Stock Report page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Job in Stock Report page is not navigated successfully "+e);
		}
	}

	public void navigateToJobOutReport(){
		try{
			jobOutReportTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(jobOutStockReportPage.isDisplayed()){
				Constant.log.info("Job out Stock Report page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Job out Stock Report page is not navigated successfully "+e);
		}
	}

	public void navigateToInternalStockFlowReport(){
		try{
			internalStockFlowReportTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(internalStockFlowReportPage.isDisplayed()){
				Constant.log.info("Internal Stock flow Report page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Internal Stock flow Report page is not navigated successfully "+e);
		}
	}

	public void navigateToCustomReport(){
		try{
			customReport.click();
			if(customReportPage.isDisplayed()){
				Constant.log.info("Custom report page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Custom report is not navigated successfully "+e);
		}
	}

	public void navigateToOA(){
		try{
			oaTab.click();
			if(oaPage.isDisplayed()){
				Constant.log.info("OA page is navigated successfully ");
			}
		}catch(Exception e){
			System.err.println("OA page is not navigated successfully "+e);
		}
	}

	/**
	 * To Navigate to Invoice
	 */

	public void navigateToInvoice(){
		try{
			invoiceTab.click();
			if(invoicePage.isDisplayed()){
				Constant.log.info("Invoice page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Invoice page is not navigated successfully "+e);
		}
	}

	/**
	 * To navigate to tax module
	 */

	public void navigateToTax(){
		try{
			taxTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(taxPage.isDisplayed()){
				Constant.log.info("Navigated to Tax");
			}
		}catch(Exception e){
			System.err.println("Navigate to Tax not successful "+e);
		}
	}

	/**
	 * To Navigate to Store
	 */

	public void navigateToStore(){
		try{
			storeHeader.click();
			if(issueTab.isDisplayed()){
				Constant.log.info("Store Dashboard is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Store Dashboard is not navigated successfully "+e);
		}

	}

	public void navigateToStoreDash(){
		try{
			storeDash.click();
			Thread.sleep(Constant.Min_Sleep);
			if(storesDashPage.isDisplayed()){
				Constant.log.info("Store Header is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Store header is not navigated successfully "+e);
		}

	}


	/**
	 * To navigate to delivery challan page
	 */

	public void navigateToDeliveryChallan(){
		try{
			deliveryChallan.click();
			if(deliveryChallanPage.isDisplayed()){
				Constant.log.info("Delivery challan page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Delivery challan page is not navigated successfully "+e);
		}
	}

	/**
	 * To Navigate to Indent
	 */

	public void navigateToIndent(){
		try{
			indentTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(indentPage.isDisplayed()){
				Constant.log.info("Indent page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Indent page navigation is not successful"+e);
		}
	}

	/**
	 * To navigate to issue page
	 */
	public void navigateToIssue(){
		try{
			issueTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(issuePage.isDisplayed()){
				Constant.log.info("Issue page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Issue page navigation is not successful"+e);
		}
	}

	/**
	 * Navigate to Purchase report
	 */

	public void navigateToPurchaseRegister(){
		try{
			purchaseReport.click();
			Thread.sleep(Constant.Min_Sleep);
			if(purchaseReportPage.isDisplayed()){
				Constant.log.info("Navigated to purchase register");
			}
		}catch(Exception e){
			System.err.println("Navigate to purchase register not successful "+e);
		}
	}

	public void navigateToGstrPurchasereport(){
		try{
			gstrPurchaseReport.click();
			Thread.sleep(Constant.Min_Sleep);
			if(gstrPurchaseReportPage.isDisplayed()){
				Constant.log.info("Navigated to Gstr purchase report");
			}
		}catch(Exception e){
			System.err.println("Navigate to Gstr purchase report not successful "+e);
		}
	}

	/**
	 * Navigate to sales report
	 */

	public void navigateToGSTRSalesReport(){
		try{
			gstrSalesReportTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(gstrSalesReportHeading.isDisplayed()){
				Constant.log.info("Navigated to GSTR sales report");
			}
		}catch(Exception e){
			System.err.println("Navigate to GSTR sales report not successful "+e);
		}
	}

	public void navigateToExpense(){
		try{
			expensesTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(expensesPage.isDisplayed()){
				Constant.log.info("Expenses page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Failed to navigate to Expense" +e);
		}
	}

	public void navigateToGRN(){
		try{
			receiptTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(receiptPage.isDisplayed()){
				Constant.log.info("GRN page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("GRN page navigation is not successful"+e);
		}
	}

	public void navigateToIssueReturn(){
		try{
			issueReturnTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(issueReturnPage.isDisplayed()){
				Constant.log.info("Issue Return/Internal Receipt page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Issue Return/Internal Receipt page navigation is not successful"+e);
		}
	}

	public void navigateToPOWiseReports(){
		try{
			poWiseReportsTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(poWiseReportsHeading.isDisplayed()){
				Constant.log.info("PO Wise reports page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("PO Wise reports page navigation is not successful"+e);
		}
	}

	public void navigateToMaterialWiseReports(){
		try{
			materialWiseReportsTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(materialWiseReportsHeading.isDisplayed()){
				Constant.log.info("Material Wise reports page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Material Wise reports page navigation is not successful"+e);
		}
	}

	public void navigateToStockReport(){
		try{
			stockReportsTab.click();
			if(reportsPage.isDisplayed()){
				Constant.log.info("Stock Reports page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Stock Reports page navigation is not successful"+e);
		}
	}

	public void navigateToGRNReport(){
		try{
			grnReportTab.click();
			if(grnReportPage.isDisplayed()){
				Constant.log.info("GRN Reports page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("GRN Reports page navigation is not successful"+e);
		}
	}

	public void navigateToDCReport(){
		try{
			dcReportTab.click();
			if(dcReportPage.isDisplayed()){
				Constant.log.info("DC Reports page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("DC Reports page navigation is not successful"+e);
		}
	}

	public void navigateToMaterialReceiptReport(){
		try{
			materialReceiptIssueReportTab.click();
			if(materialReceiptPage.isDisplayed()){
				Constant.log.info("Material Receipt Reports page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Material Receipt Reports page navigation is not successful"+e);
		}
	}

	public void navigateToShortageListReport(){
		try{
			shortageListTab.click();
			if(shortageListPage.isDisplayed()){
				Constant.log.info("Shortage Reports page is navigated successfully");
			}
		}catch(Exception e){
			System.err.println("Shortage Receipt Reports page navigation is not successful"+e);
		}
	}

	public void navigateToSettings(){
		try{
			settingIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(usersTab.isDisplayed()){
				Constant.log.info("Navigated to setting");
			}
		}catch(Exception e){
			System.err.println("Navigate to Settings menu not successful "+e);
		}
	}

	public void navigateToInvoiceTemplate(){
		try{
			printTemp.click();
			Thread.sleep(Constant.Min_Sleep);
			invoiceTemplate.click();
			Thread.sleep(Constant.Min_Sleep);
			if(invoiceTemplatePge.isDisplayed()){
				Constant.log.info("Navigated to Invoice template");
			}
		}catch(Exception e){
			System.err.println("Navigated to Invoice template "+e);
		}
	}

	public void navigateToPoConfig(){
		try{
			printTemp.click();
			Thread.sleep(Constant.Min_Sleep);
			poConfig.click();
			Thread.sleep(Constant.Min_Sleep);
			if(poConfigPage.isDisplayed()){
				Constant.log.info("Navigated to Po Config");
			}
		}catch(Exception e){
			System.err.println("Navigated to PO config "+e);
		}
	}

	public void navigateToExpenseConfig(){
		try{
			expenseconfig.click();
			Thread.sleep(Constant.Min_Sleep);
			if(expenseConfigPage.isDisplayed()){
				Constant.log.info("Navigated to Expense Config");
			}
		}catch(Exception e){
			System.err.println("Navigated to Expense Config "+e);
		}
	}

	public void navigateToSEConfig(){
		try{
			printTemp.click();
			Thread.sleep(Constant.Min_Sleep);
			seConfig.click();
			Thread.sleep(Constant.Min_Sleep);
			if(seConfigPage.isDisplayed()){
				Constant.log.info("Navigated to SE Config");
			}
		}catch(Exception e){
			System.err.println("Navigated to SE Config "+e);
		}
	}

	public void navigateToUser(){
		try{
			usersTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(userPage.isDisplayed()){
				Constant.log.info("Navigated to user Page");
			}
		}catch(Exception e){
			System.err.println("Navigate to user Page not successful "+e);
		}
	}

	public void navigateToProfile(){
		try{
			configurationTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(profileHeading.isDisplayed()){
				Constant.log.info("Navigated to Profile Page");
			}
		}catch(Exception e){
			System.err.println("Navigate to Profile Page not successful "+e);
		}
	}

	public void navigateToBillSettlement(){
		try{
			billSettlement.click();
			Thread.sleep(Constant.Min_Sleep);
			if(billSettlmentPage.isDisplayed()){
				Constant.log.info("Navigated to Bill Settlement Page");
			}
		}catch(Exception e){
			System.err.println("Navigate to Bill Settlement not successful "+e);
		}
	}

	public void navigateToSe(){
		try{
			salesEstimate.click();
			Thread.sleep(Constant.Min_Sleep);
			if(salesEstimatePage.isDisplayed()){
				Constant.log.info("Navigated to Sales Estimate Page");
			}
		}catch(Exception e){
			System.err.println("Navigate to Sales Estimate not successful "+e);
		}
	}

}
