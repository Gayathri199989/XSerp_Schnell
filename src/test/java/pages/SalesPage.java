package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
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

public class SalesPage {

	ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	ProfilePage masters = PageFactory.initElements(Constant.driver, ProfilePage.class);
	AccountsPage accounts = PageFactory.initElements(Constant.driver, AccountsPage.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);

	@FindBy(id="filter_textbox")
	private WebElement filterText;

	@FindBy(xpath=".//button[contains(@class,'btn-filter')]")
	private WebElement filterBtn;

	@FindBy(id="refresh") WebElement viewReportBtn;

	@FindBy(xpath=".//*[@id='report-table']/thead")
	 WebElement reportColumnNames;//For status, tax and material reports column head

	@FindBy(id="salesreportview") WebElement salesViewReportBtn;

	@FindBy(xpath=".//div[contains(@class,'scrollHeadInner')]//tr[@class='exclude_export']/th")
	List<WebElement> salesReportColumnNames;

	@FindBy(xpath=".//label[text()='Exclude Drafts']")
	 WebElement excludeDrafts;

	@FindBy(xpath=".//span[contains(text(),'New')]")
	 WebElement addInvoicePage;

	@FindBy(xpath=".//a[contains(@class,'create_invoice')]")
	public WebElement addIcon;

	@FindBy(xpath=".//span[text()='INR']")
	private WebElement currency;

	@FindBy(xpath=".//li[text()='USD']")
	private WebElement usd;

	@FindBy(xpath=".//span[text()='Invoice # ']")
	private WebElement indentAddPage;

	@FindBy(id="id_invoice-currency_conversion_rate")
	private WebElement conversionRate;

	@FindBy(xpath=".//a[@data-original-title='Download Invoice List as CSV']")
	 WebElement exportCSV;

	@FindBy(id="description_display")
	 WebElement materialDesc;

	@FindBy(id="grand_total_value")
	 WebElement grandTotal;

	@FindBy(xpath=".//select[contains(@class,'sel_consolidated_cgst')]")
	List <WebElement> cgst_InvoiceDC;

	@FindBy(xpath=".//select[contains(@class,'sel_consolidated_sgst')]")
	List <WebElement> sgst_InvoiceDC;

	@FindBy(xpath=".//select[contains(@class,'sel_consolidated_igst')]")
	List <WebElement> igst_InvoiceDC;

	@FindBy(xpath=".//span[contains(@class,'txt_consolidated_cgst')]")
	List <WebElement> cgstValue_InvoiceDC;

	@FindBy(xpath=".//span[contains(@class,'txt_consolidated_sgst')]")
	List <WebElement> sgstValue_InvoiceDC;

	@FindBy(xpath=".//span[contains(@class,'txt_consolidated_igst')]")
	List <WebElement> igstValue_InvoiceDC;

	@FindBy(xpath=".//span[contains(@class,'txt_consolidated_total')]")
	List <WebElement> itemAmtList_InvoiceDC;

	@FindBy(id="id_invoice-round_off")
	 WebElement roundOff;

	@FindBy(xpath=".//span[text()=' New']")
	 WebElement invoiceNewPage;

	@FindBy(xpath=".//*[@id='invoice_materials_table']/thead")
	 WebElement invoiceMaterialsTable;

	@FindBy(id="add_invoice_item")
	 WebElement addInvoiceItem;

	@FindBy(xpath=".//p[text()='Stock Not Available!']")
	private WebElement stockNotAvail;

	@FindBy(xpath=".//span[text()='Material Name is required.']")
	 WebElement matName_MandatoryMsg;

	@FindBy(xpath=".//span[text()='HSN/SAC is required.']")
	 WebElement hSN_MandatoryMsg;

	@FindBy(xpath=".//span[text()='Atleast add 1 Quantity.']")
	 WebElement qtynonStock_MandatoryMsg;

	@FindBy(xpath=".//span[text()='Unit type is required.']")
	 WebElement unitType_MandatoryMsg;

	@FindBy(xpath=".//span[text()='Rate cannot be 0.']")
	 WebElement rateNonStock_MandatoryMsg;

	@FindBy(xpath=".//span[text()='Quantity is required.']")
	 WebElement qtyStock_MandatoryMsg;

	@FindBy(xpath=".//span[text()='Unit Rate is required.']")
	 WebElement rateStock_MandatoryMsg;

	@FindBy(xpath="//span[@class='for_dc']//label")
	 WebElement stockReturnCheckBx;

	@FindBy(id="cmdSaveInvoice") WebElement save;

	@FindBy(xpath=".//*[@id='grnList']/tbody/tr/td[4]/a")  List<WebElement> grnList;

	@FindBy(id="download_copy") WebElement printDwnload;

	@FindBy(xpath="//tr[contains(@class,'invoice_item')]//input[contains(@id,'is_returnable')]")
	List<WebElement> returnChckBox_EditPage;

	@FindBy(xpath="//span[contains(text(),'Print')]")
	 WebElement printBtn;

	@FindBy(xpath=".//p[text()='Please add atleast one material to the Invoice']")
	 WebElement addAtleast1MatPopUp;

	@FindBy(id="btn-sa-confirm")
	 WebElement okButton;

	@FindBy(xpath = ".//li[@id='item_particulars']/a[text()='Material']")
	WebElement materialTab;

	@FindBy(xpath=".//span[text()='-- Tax --']")
	 WebElement taxDropDown;

	@FindBy(id="id_invoice_currency_id_chosen")
	 WebElement currencyField;

	@FindBy(xpath=".//*[@id='invoice_tax_list_chosen']/div/div/input")
	 WebElement taxSearch;

	@FindBy(id="add_invoice_tax")
	 WebElement addTax;

	@FindBy(xpath=".//span[text()='New Invoice']")
	 WebElement invoiceAddPage;

	@FindBy(xpath=".//span[text()='New Delivery Challan']")
	 WebElement DCAddPage;

	@FindBy(id="id_invoice-type")
	 WebElement invoiceType;

	@FindBy(xpath=".//*[@id='id_invoice_project_code_chosen']/a/span")
	 WebElement invoiceProject;

	@FindBy(xpath=".//*[@id='id_invoice_sale_account_id_chosen']/a")
	 WebElement salesAcctDropDwn;

	@FindBy(xpath=".//*[@id='id_invoice_sale_account_id_chosen']/div/div/input")
	 WebElement salesAcctSearchTxt;

	@FindBy(xpath=".//*[@id='id_invoice_project_code_chosen']/div/div/input")
	 WebElement invoiceProjectSearch;

	@FindBy(xpath=".//*[@id='id_invoice_party_id_chosen']/a/span")
	 WebElement customerDropDwn;

	@FindBy(xpath=".//*[@id='invoice_list']/thead")
	private WebElement invoiceColumnNames;

	@FindBy(xpath=".//*[@id='id_invoice_party_id_chosen']/div/ul/li")
	private List<WebElement> customerDropDown;

	@FindBy(xpath=".//li[text()='+ Add New']")
	 WebElement addNewButton;

	@FindBy(xpath=".//*[@id='id_invoice_party_id_chosen']/div/ul/li[contains(@class,'active-result')]")
	 List<WebElement> supplierList;

	@FindBy(xpath=".//*[@id='id_invoice_mat-deleteInvoiceMaterial']/i")
	 List<WebElement> deleteInvoiceMat;

	@FindBy(xpath=".//*[@id='id_invoice_party_id_chosen']/div/div/input[@class='chosen-search-input']")
	 WebElement customerText;

	@FindBy(xpath=".//span[text()='Invoice Type is required.']")
	private WebElement invoiceType_MandatoryMsg;

	@FindBy(xpath=".//span[text()='Project is required.']")
	private WebElement project_MandatoryMsg;

	@FindBy(xpath=".//span[text()='Customer is required.']")
	private WebElement customer_MandatoryMsg;

	@FindBy(id="id_invoice-po_no")
	 WebElement pONo;

	@FindBy(xpath="//label[contains(text(),'GOODS ALREADY SUPPLIED')]")
	 WebElement goodsSuppliedChckBx;

	@FindBy(xpath="//div[@id='div_dc_no_display']//div[1]//button[1]//span[1]")
	 WebElement dcFinYrDropDwn;

	@FindBy(xpath="//div[@class='btn-group open']//label[@class='checkbox']")
	 List<WebElement> DcFYOptions;

	@FindBy(xpath="//div[@id='div_dc_no_display']/div[2]/button/span[1]")
	 WebElement dcNoDropDwn;

	@FindBy(xpath="//*[@id='div_oa_no_display']/div/button/span[1]")
	 WebElement partyDcNoDropDwn;

	@FindBy(xpath="//*[contains(text(),'View GRN Material')]")
	 WebElement viewGRNMaterialsPopup;

	@FindBy(xpath="//p[contains(text(),'Quantity of a material is greater than Pending Quantity. Please check!!')]")
	 WebElement qtyWarning;

	@FindBy(xpath="//span[@class='currently_available_pending']")
	 WebElement currentAvailPending;


	@FindBy(xpath="//tr[contains(@id,'invoice_mat')]/td/div/input[contains(@id,'quantity')]")
	 List<WebElement> matListGridQty;

	@FindBy(xpath="//span/input[contains(@id,'item_name')]")
	 List<WebElement> matListGridMaterialAddPge;

	@FindBy(xpath="//span[@class='item_description']")
	 List<WebElement> matListGridMaterialEditpage;

	@FindBy(xpath="//*[@id='div_oa_no_display']/div/ul/li/a")
	 List<WebElement> partyDCNoList;

	@FindBy(xpath=".//tr[contains(@id,'invoice_mat')]/td[4]/span/b/parent::span")
	 List<WebElement> oaNoMaterialListGrid;

	@FindBy(xpath="//table[@id='invoice_materials_table']/tbody/tr/td[2]/span[@class='consolidated_material_name']")
	 List<WebElement> dcNoMaterialListGrid;

	@FindBy(xpath="//div[@id='div_dc_no_display']/div[2]/ul/li/a/label")
	 List<WebElement> DcNoOptions;

	@FindBy(xpath="//label[contains(text(),'Po Date')]/following::i[1]")
	 WebElement poDateField;

	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='prev'][contains(text(),'�')]")
	 WebElement poDatePrevIcon;

	@FindBy(xpath="//table[@class='table-condensed']//td[@class='day'][contains(text(),'11')]")
	 WebElement poDateSelect;

	@FindBy(id="invoice_issued_on_date")
	private WebElement issuedOnDateDropDwn;

	@FindBy(id="id_invoice-ecommerce_gstin")
	private WebElement eGSTINTxtField;

	@FindBy(xpath="//td[@class='day today active']")
	private WebElement dateSelect;

	@FindBy(xpath="//span[contains(@class,'hour_am')][contains(text(),'9')]")
	private WebElement timeHrSelect;

	@FindBy(xpath="//span[contains(@class,'minute')][contains(text(),'9:10')]")
	private WebElement timeSelect;

	@FindBy(xpath=".//button[contains(@class,'multiselect')]")
	 WebElement oaNoDropDwn;

	@FindBy(id="id_invoice_job_po_id_chosen")
	 WebElement pONoDropDwn;

	@FindBy(xpath="//div[@id='id_invoice_job_po_id_chosen']//input[@class='chosen-search-input']")
	 WebElement poNoSearchField;

	@FindBy(xpath=".//*[@id='id_invoice_job_po_id_chosen']/div/ul/li")
	 List<WebElement> poNoList;

	@FindBy(xpath=".//*[contains(@id,'cattable')]/tbody/tr/td[3]")
	 List<WebElement> poMaterialsDrawingNoList;

	@FindBy(xpath=".//*[contains(@id,'cattable')]/tbody/tr/td/input[contains(@id,'hsn_code')]")
	 List<WebElement> poMaterialsHSNNoList;

	@FindBy(xpath=".//input[@name='catmaterial_qty']")
	 List<WebElement> poMaterialsQtyList;

	@FindBy(id="txtcatunitrate")
	 List<WebElement> poMaterialsUnitRate;

	@FindBy(id="txtcatdiscount")
	 List<WebElement> poMaterialsDis;

	@FindBy(id="txtcatamount")
	 List<WebElement> poMaterialsAmt;

	@FindBy(xpath=".//*[contains(@class,'error-border-stock')]/following::td/a[text()='Delete ']")
	 List<WebElement> poBomMatErrorBorderDelete;

	@FindBy(id="catCancel")
	 WebElement cancelPoMaterialPopup;

	@FindBy(id="catAdd")
	 WebElement addPOMaterials;

	@FindBy(xpath=".//div[@class='btn-group']/button")
	 WebElement oANoDropDwn;

	@FindBy(xpath=".//input[contains(@class,'multiselect-search')]")
	 WebElement oANoSearchField;

	@FindBy(xpath=".//div[@class='btn-group open']/ul/li/a/label")
	 List<WebElement> oANolist;

	@FindBy(id="invoice_oa_date")
	 WebElement oADate;

	@FindBy(id="invoice_return_date")
	 WebElement returnDate;

	@FindBy(id="id_invoice-transport_mode")
	 WebElement transportMode;

	@FindBy(id="id_invoice-road_permit_no")
	 WebElement roadPermitNo;

	@FindBy(id="id_invoice-packing_slip_no")
	 WebElement packingSlipNo;

	@FindBy(id="id_invoice-remarks")
	 WebElement invoiceRemarks;

	@FindBy(id="id_invoice-lr_no")
	 WebElement lorryNo;

	@FindBy(id="id_invoice-packing_description")
	 WebElement packingDesc;

	@FindBy(id="id_invoice-payment_terms")
	 WebElement paymenyTerms;

	@FindBy(id="id_invoice-special_instruction")
	 WebElement specialInst;

	@FindBy(id="id_invoice-deliver_to")
	 WebElement deliverTo;

	@FindBy(id="materialrequired")
	 WebElement materialReq;

	@FindBy(xpath="//select[@id='id_invoice_mat-__prefix__-alternate_units']")
	 WebElement altUnitDrpDwn;

	@FindBy(xpath="//select[@id='id_invoice_mat-__prefix__-alternate_units']/option[2]")
	 WebElement altUnitOption;

	@FindBy(xpath=".//*[@id='materialrequired']/following::span[2]/i")
	 WebElement materialRemovalIcon;

	@FindBy(xpath=".//label[text()='Faulty']")
	 WebElement faultyCheckBX;

	@FindBy(id="id_invoice_mat-__prefix__-hsn_code")
	 WebElement hSNCodeStock;

	@FindBy(id="closing_qty")
	 WebElement closingQty;

	@FindBy(id="id_invoice_mat-__prefix__-remarks")
	 WebElement remarksStock;

	@FindBy(xpath=".//span[@id='div_remarks']/span[text()='+ Add Remarks']")
	 WebElement addRemarks;

	@FindBy(id="id_invoice_mat-__prefix__-quantity")
	 WebElement quantityStock;

	@FindBy(id="id_invoice_mat-__prefix__-unit_id")
	 WebElement units;

	@FindBy(id="id_invoice_mat-__prefix__-rate")
	 WebElement rate_Stock;

	@FindBy(id="id_invoice_mat-__prefix__-discount")
	 WebElement discountStock;

	@FindBy(xpath=".//h2[text()='Please Enter Below 100']")
	private WebElement discountValueCheckPopUp;

	@FindBy(id="id_invoice_mat-__prefix__-amount")
	 WebElement netValueForStock;

	@FindBy(xpath=".//a[text()='Material']")
	 WebElement materialItemTab;

	@FindBy(id="invoice_tot")
	 WebElement invoiceTotal;

	@FindBy(id="net_cgst_value")
	 WebElement netCGSTValue;

	@FindBy(id="net_sgst_value")
	 WebElement netSGSTValue;

	@FindBy(id="net_igst_value")
	 WebElement netIGSTValue;

	@FindBy(xpath=".//*[@id='invoice_tax_table']/tbody/tr/td[3]/input")
	 List<WebElement> addedTaxList;

	@FindBy(id="tag-0-del_button")
	 WebElement firstTagdelete;

	@FindBy(xpath=".//a[@title='Remove Tax']/i")
	 WebElement deleteTax;

	@FindBy(xpath=".//a[@data-original-title='Back']") WebElement backBtn;

	@FindBy(xpath=".//button[text()='Yes, delete it!']")
	 WebElement yesDelete;

	@FindBy(xpath="//tbody/tr[@id='invoice_mat-0']/td[2]/span[1]")
	 WebElement firstMatSNO;

	@FindBy(xpath=".//*[@id='id_invoice_mat-0-deleteInvoiceMaterial']/i")
	 WebElement firstMatDelete;

	@FindBy(xpath=".//tr[@id='invoice_mat-0']/td/a[@id='id_invoice_mat-deleteInvoiceMaterial']/i")
	 WebElement deleteAddedStockMat;

	@FindBy(id="id_invoice_mat-0-item_name")
	 WebElement addedStockMaterial;

	@FindBy(id="id_invoice_mat-0-hsn_code")
	 WebElement addedStockHSN;

	@FindBy(id="id_invoice_mat-0-quantity")
	 WebElement addedStockQTY;

	@FindBy(id="id_invoice_mat-0-unit_id")
	 WebElement addedStockUnit;

	@FindBy(id="id_invoice_mat-0-rate")
	 WebElement addedStockRate;

	@FindBy(id="id_invoice_mat-0-discount")
	 WebElement addedStockDiscount;

	@FindBy(id="id_invoice_mat-0-amount")
	 WebElement addedStockAmountStock;

	@FindBy(id="id_invoice_non_stock_mat-0-amount")
	 WebElement addedStockAmount_NonStock;

	@FindBy(xpath="//h4[contains(text(),'Preview Document')]")
	 WebElement salesPDF;

	@FindBy(xpath=".//*[@id='invoice_list']/tbody/tr/td[8]/form/a/span")
	 List<WebElement> invoiceStatusList;

	@FindBy(xpath=".//table[@id='invoice_list']/tbody/tr/td[2]/form/a")
	 List<WebElement> invoiceNoList;

	@FindBy(id="approve_invoice") WebElement approveInvoice;

	@FindBy(id="reject_invoice") WebElement rejectInvoice;

	@FindBy(xpath=".//h2[text()='Please Enter Rejection Remarks']")
	private WebElement rejectionWarning;

	@FindBy(xpath=".//div[contains(@id,'_document_modal')]//button[@class='close'][contains(text(),'�')]")
	 WebElement pDfBackBtn;

	@FindBy(xpath=".//td[text()='Approved Date']/following::td[1]")
	 WebElement invoiceDateTimeAfterApprove;

	@FindBy(id="remarks")
	 WebElement remarks;

	@FindBy(xpath=".//tr/td[2]/a")
	public List<WebElement> invoices;

	@FindBy(id="id_invoice_number")
	private WebElement filter;

	@FindBy(xpath="//span[@class='header_current_page']")
	 WebElement invoiceNoEditPage;

	@FindBy(xpath="//tr//td[10]//a") List<WebElement> seStatus;

	@FindBy(xpath="//tr//td[8]//a") List<WebElement> oaStatus;

	@FindBy(xpath="//tr//td[10]//span[1]/i") List<WebElement> sePdficon;

	@FindBy(xpath="//*[contains(text(),'View OA Material')]")
	 WebElement viewOAMaterilPopup;

	@FindBy(xpath=".//*[@id='OAMaterialtable']/thead")
	 WebElement OAMaterialPopUpColumns;

	@FindBy(xpath=".//table[@id='OAMaterialtable']//span[contains(@class,'material_name')]")
	 List<WebElement> itemsInvoiceMaterialListPopUp;

	@FindBy(xpath=".//tr/td[5]/input[contains(@id,'hsn_code')]")
	 List<WebElement> hsnCodeOA;

	@FindBy(xpath=".//tr/td[6]/input[contains(@id,'remarks')]")
	 List<WebElement> remarksOA;

	@FindBy(xpath=".//*[@name='oamaterial_qty']")
	 List<WebElement> qtyOA;

	@FindBy(xpath=".//table[@id='OAMaterialtable']/tbody/tr[contains(@id,'id_oamaterial')]/td[3]")
	 List<WebElement> grnNoColumn;

	@FindBy(xpath=".//table[@id='OAMaterialtable']//input[contains(@class,'txt_consolidated_price')]")
	 List<WebElement> price_ItemsInvoicePopup;

	@FindBy(xpath=".//*[contains(@id,'row')]/td[7]")
	 List<WebElement> pendingOAQty;

	@FindBy(xpath=".//input[@name='oamaterial_disc']")
	 List<WebElement> discountOA;

	@FindBy(xpath=".//table[@id='OAMaterialtable']//input[contains(@class,'txt_consolidated_disc')]")
	 List<WebElement> discItemsInvoicedpopup;

	@FindBy(xpath=".//input[@name='oamaterial_amount']")
	 List<WebElement> amountOA;

	@FindBy(xpath=".//table[@id='OAMaterialtable']//span[@class='txt_consolidated_total']")
	 List<WebElement> amountInvoiceDCItems;

	@FindBy(xpath=".//*[contains(@class,'total_qty')]")
	 List<WebElement> consolidateQty;

	@FindBy(xpath=".//input[@name='oamaterial_unitrate']")
	 List<WebElement> unitRateOA;

	@FindBy(id="OAAdd")
	 WebElement addOAMaterials;

	@FindBy(xpath=".//*[contains(@id,'row')]/td[9]")
	 List<WebElement> stockOAMaterial;

	@FindBy(xpath=".//tr[@class[substring(.,string-length(.) - string-length('material_list') + 1) = 'material_list']]/td/div/input[contains(@id,'id_invoice_mat')] [@placeholder='HSN/SAC']")
	 List<WebElement> hsnStockMatList;

	@FindBy(xpath=".//tr[@class[substring(.,string-length(.) - string-length('material_list') + 1) = 'material_list']]/td[contains(@class,'td-tax-rate')]/select[@name='CGST']")
	 List<WebElement> cgstDropDwn;

	@FindBy(xpath=".//tr[@class[substring(.,string-length(.) - string-length('material_list') + 1) = 'material_list']]/td[contains(@class,'td-tax-rate')]/select[@name='SGST']")
	 List<WebElement> sgstDropDwn;

	@FindBy(xpath=".//tr[@class[substring(.,string-length(.) - string-length('material_list') + 1) = 'material_list']]/td[contains(@class,'td-tax-rate')]/select[@name='IGST']")
	 List<WebElement> igstDropDwn;

	@FindBy(xpath=".//tr[contains(@class,'exclude_export')]/td/div/input[contains(@id,'id_invoice_mat')] [@placeholder='HSN/SAC']")
	 List<WebElement> hsnEditStockMatList;

	@FindBy(xpath=".//tr[contains(@class,'exclude_export')]/td[contains(@class,'td-tax-rate')]/select[@name='CGST']")
	 List<WebElement> cgstEditDropDwn;

	@FindBy(xpath=".//tr[contains(@class,'exclude_export')]/td[contains(@class,'td-tax-rate')]/select[@name='SGST']")
	 List<WebElement> sgstEditDropDwn;

	@FindBy(xpath=".//tr[contains(@class,'exclude_export')]/td[contains(@class,'td-tax-rate')]/select[@name='IGST']")
	 List<WebElement> igstEditDropDwn;

	@FindBy(xpath=".//tr[@class[substring(.,string-length(.) - string-length('material_list') + 1) = 'material_list']]/td[contains(@class,'td-tax-rate')]/span[@name='CGST_AMT']")
	 List<WebElement> cgstAmt;

	@FindBy(xpath=".//tr[@class[substring(.,string-length(.) - string-length('material_list') + 1) = 'material_list']]/td[contains(@class,'td-tax-rate')]/span[@name='SGST_AMT']")
	 List<WebElement> sgstAmt;

	@FindBy(xpath=".//tr[@class[substring(.,string-length(.) - string-length('material_list') + 1) = 'material_list']]/td[contains(@class,'td-tax-rate')]/span[@name='IGST_AMT']")
	 List<WebElement> igstAmt;

	@FindBy(xpath=".//tr[contains(@class,'exclude_export')]/td[contains(@class,'td-tax-rate')]/span[@name='CGST_AMT']")
	 List<WebElement> cgstEditAmt;

	@FindBy(xpath=".//tr[contains(@class,'exclude_export')]/td[contains(@class,'td-tax-rate')]/span[@name='SGST_AMT']")
	 List<WebElement> sgstEditAmt;

	@FindBy(xpath=".//tr[contains(@class,'exclude_export')]/td[contains(@class,'td-tax-rate')]/span[@name='IGST_AMT']")
	 List<WebElement> igstEditAmt;

	@FindBy(xpath=".//tr[@class[substring(.,string-length(.) - string-length('material_list') + 1) = 'material_list']]/td/div/input[contains(@name,'amount')]")
	 List<WebElement> matAmt;

	@FindBy(xpath=".//tr[contains(@class,'exclude_export')]/td/div/input[contains(@name,'amount')]")
	 List<WebElement> matEditAmt;

	@FindBy(xpath=".//tr[@class[substring(.,string-length(.) - string-length('material_list') + 1) = 'material_list']]/td[contains(@class,'td-tax-rate')]/select[@name='CGST']/preceding::input[contains(@name,'rate')][1]")
	 List<WebElement> cgstPercentage;

	@FindBy(xpath=".//tr[@class[substring(.,string-length(.) - string-length('material_list') + 1) = 'material_list']]/td[contains(@class,'td-tax-rate')]/select[@name='SGST']/preceding::input[contains(@name,'rate')][1]")
	 List<WebElement> sgstPercentage;

	@FindBy(xpath=".//tr[@class[substring(.,string-length(.) - string-length('material_list') + 1) = 'material_list']]/td[contains(@class,'td-tax-rate')]/select[@name='IGST']/preceding::input[contains(@name,'rate')][1]")
	 List<WebElement> igstPercentage;

	@FindBy(xpath=".//tr[contains(@class,'exclude_export')]/td[contains(@class,'td-tax-rate')]/select[@name='CGST']/preceding::input[contains(@name,'rate')][1]")
	 List<WebElement> cgstEditPercentage;

	@FindBy(xpath=".//tr[contains(@class,'exclude_export')]/td[contains(@class,'td-tax-rate')]/select[@name='SGST']/preceding::input[contains(@name,'rate')][1]")
	 List<WebElement> sgstEditPercentage;

	@FindBy(xpath=".//tr[contains(@class,'exclude_export')]/td[contains(@class,'td-tax-rate')]/select[@name='IGST']/preceding::input[contains(@name,'rate')][1]")
	 List<WebElement> igstEditPercentage;

	@FindBy(xpath=".//*[contains(@id,'id_invoice_charge')][@placeholder='HSN/SAC']")
	 List<WebElement> hsnPackageList;

	@FindBy(xpath=".//*[contains(@id,'id_invoice_charge_tax')][@name='CGST']")
	 List<WebElement> cgstPackageList;

	@FindBy(xpath=".//*[contains(@id,'id_invoice_charge_tax')][@name='SGST']")
	 List<WebElement> sgstPackageList;

	@FindBy(xpath=".//*[contains(@id,'id_invoice_charge_tax')][@name='IGST']")
	 List<WebElement> igstPackageList;

	@FindBy(xpath=".//*[contains(@id,'id_invoice_charge')][@placeholder='Unit Rate']")
	 List<WebElement> unitRatePackageList;

	@FindBy(xpath=".//*[contains(@id,'id_invoice_charge')][contains(@name,'discount')]")
	 List<WebElement> discountRatePackageList;

	@FindBy(xpath=".//*[contains(@id,'id_invoice_charge')][@placeholder='Net Value']")
	 List<WebElement> netValuePackageList;

	@FindBy(xpath=".//*[contains(@id,'id_span_invoice_charge_tax')][@name='IGST_AMT']")
	 List<WebElement> igstValuePackageList;

	@FindBy(xpath=".//*[contains(@id,'id_span_invoice_charge_tax')][@name='CGST_AMT']")
	 List<WebElement> cgstValuePackageList;

	@FindBy(xpath=".//*[contains(@id,'id_span_invoice_charge_tax')][@name='SGST_AMT']")
	 List<WebElement> sgstValuePackageList;

	@FindBy(id="id_tag-0-tag_label")
	 WebElement firstAddedTag;

	@FindBy(id="filter_textbox")
	 WebElement filterTextbox;

	@FindBy(xpath=".//span[text()='Invoice']")
	 WebElement invoicePage;

	@FindBy(id="reportrange")
	 WebElement dateCalendarDrpDown;

	@FindBy(xpath=".//li[text()='Last 30 Days']")
	 WebElement last30Days;

	@FindBy(xpath=".//li[text()='Current Month']")
	 WebElement currentMonth;

	@FindBy(xpath=".//li[text()='Last Month']")
	 WebElement lastMonth;

	@FindBy(xpath=".//li[text()='Current Year']")
	 WebElement currentYear;

	@FindBy(xpath=".//li[text()='Current Financial Year']")
	 WebElement currentFinancialYear;

	@FindBy(xpath=".//li[text()='Custom Range']")
	 WebElement currentRange;

	@FindBy(xpath=".//li[text()='Last Financial Year']")
	 WebElement lastFinancialYr;

	@FindBy(xpath=".//th[@class='prev available']")
	 WebElement prevMonth;

	@FindBy(xpath=".//th[@class='next available']")
	 WebElement nextMonth;

	@FindBy(xpath=".//div[@class='calendar left']/div/input[@name='daterangepicker_start']")
	 WebElement fromDate;

	@FindBy(xpath=".//div[@class='calendar right']/div/input[@name='daterangepicker_end']")
	 WebElement toDate;

	@FindBy(xpath=".//div[@class='calendar left']/div[2]/table/thead/tr/th[2]/select[@class='monthselect']")
	 WebElement calendarLeft_Month;

	@FindBy(xpath=".//div[@class='calendar right']/div[2]/table/thead/tr/th[2]/select[@class='monthselect']")
	 WebElement calendarRight_Month;

	@FindBy(xpath=".//div[@class='calendar left']/div[2]/table/thead/tr/th[2]/select[2]")
	 WebElement calendarLeft_Year;

	@FindBy(xpath=".//div[@class='calendar right']/div[2]/table/thead/tr/th[2]/select[2]")
	 WebElement calendarRight_Year;

	@FindBy(xpath=".//*[@id='reportrange']/span")
	 WebElement dateRange;

	@FindBy(xpath=".//*[@id='invoice_list']/tbody/tr/td[4]")
	 List<WebElement> preparedOn;

	@FindBy(xpath=".//*[@id='id_party_name_chosen']/a/span")
	 WebElement partyName;

	@FindBy(xpath=".//*[@id='id_party_name_chosen']/div/div/input")
	 WebElement partyNameSearch;

	@FindBy(xpath=".//*[@id='invoice_list']/tbody/tr/td[7]")
	 List<WebElement> customerList;

	@FindBy(id="id_status")
	 WebElement statusField;

	@FindBy(id="visible_record_count")
	 WebElement invoicesFetched;

	@FindBy(xpath=".//*[@id='id_project_chosen']/a")
	 WebElement projectDropDwn;

	@FindBy(id="id_search_submit")
	 WebElement searchBtn;

	@FindBy(id="pagination-select")
	 WebElement showPageEntries;

	@FindBy(xpath=".//*[@id='invoice_list_paginate']/span/a")
	 List<WebElement> invoicePaginate;

	@FindBy(xpath=".//*[@id='invoice_list']/thead/tr/th")
	 List<WebElement> invoiceListGRidColumns;

	@FindBy(xpath=".//*[@id='invoice_list']/thead")
	 WebElement invoiceListGRidColumn;

	//OA page

	@FindBy(xpath=".//a[@data-original-title='Create New OA']") WebElement oaAddBtn;

	@FindBy(xpath=".//tr/td[2]/a")
	public List<WebElement> oaList;

	@FindBy(xpath="//td/input[contains(@id,'item_name')]")
	public List<WebElement> matListEditPge;

	@FindBy(xpath="//*[contains(@id,'deleteOAParticulars')]/i[1]")
	public List<WebElement> deleteMatList;

	@FindBy(id="id_oa_party_id_chosen")
	 WebElement oaPartyDropDwn;

	@FindBy(xpath=".//*[@id='id_oa_party_id_chosen']/div/div/input")
	 WebElement oaPartySearchTxt;

	@FindBy(id="id_oa-type")
	 WebElement oaType;

	@FindBy(id="id_oa_particular-__prefix__-item_name")
	 WebElement oaStockMaterialTextField;

	@FindBy(xpath="//select[@id='id_oa_particular-__prefix__-alternate_units']")
	 WebElement altUnitDrpDwnOa;

	@FindBy(xpath="//select[@id='id_oa_particular-__prefix__-alternate_units']/option[2]")
	 WebElement altUnitOptionOA;

	@FindBy(id="id_oa_particular-__prefix__-hsn_code")
	 WebElement oaStockHSNTextField;

	@FindBy(id="id_oa_particular-__prefix__-remarks")
	 WebElement oaStockRemarks;

	@FindBy(id="id_oa_particular-__prefix__-price")
	 WebElement oaStockPrice;

	@FindBy(id="id_oa_particular-__prefix__-quantity")
	 WebElement oaStockQty;

	@FindBy(id="id_oa_particular-__prefix__-discount")
	 WebElement oaDiscountQty;

	@FindBy(id="add_new_material")
	 WebElement oaAddStockMaterial;

	@FindBy(xpath=".//tr[contains(@id,'oa_particular')]/td/input[contains(@id,'item_name')]")
	 List<WebElement> addedStockMaterialList;

	@FindBy(xpath="//input[contains(@id,'amount')]")
	 List<WebElement> oaAmountList;

	@FindBy(xpath="//table[@id='oa_tax_table']/tbody/tr/th/a[@title='Remove Tax']/following::td[3]/input[contains(@name,'tax')]")
	 List<WebElement> oaTaxList;

	@FindBy(xpath="//input[contains(@id,'discount')]")
	 List<WebElement> oaDiscountList;

	@FindBy(xpath="//input[contains(@id,'price')] [@placeholder='Unit Rate']")
	 List<WebElement> oaPriceList;

	@FindBy(xpath="//table[@id='oa_particulars_table']//input[contains(@id,'quantity')][@placeholder='Quantity']")
	 List<WebElement> oaQuantityList;

	@FindBy(id="tabs_others")
	 WebElement oaOthersTab;

	@FindBy(id="id_oa-po_no")
	 WebElement oaPONo;

	@FindBy(id="quotation_date")
	 WebElement oaQuotationDateField;

	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='prev'][contains(text(),'�')]")
	 WebElement selectPrevMnth;

	@FindBy(xpath="//div[@class='datepicker-days']//td[contains(text(),'11')]")
	 WebElement selectDate;

	@FindBy(id="del_dueDate")
	 WebElement oaDueDateField;
	 

	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='next'][contains(text(),'�')]")
	 WebElement selectNxtMnth;

	@FindBy(id="id_oa-payment_terms")
	 WebElement oaPaymentTerms;

	@FindBy(css="i[class$='btn-browse-remove']")
	private WebElement attachmentRemove;

	@FindBy(xpath="//span[contains(text(),'Upload Document')]")
	 WebElement uploadOADocument;

	@FindBy(id="id_oa-document_description")
	 WebElement documentDesc;

	@FindBy(id="id_oa-remarks")
	 WebElement oaRemarks;

	@FindBy(id="id_oa-special_instructions")
	 WebElement oaSpecialInstruc;

	@FindBy(id="cmd_save_draft") WebElement oaSave;

	@FindBy(xpath=".//button[text()='OK']")
	 WebElement okBtn;

	@FindBy(id="btn-sa-confirm") WebElement ok;

	@FindBy(xpath=".//span[contains(text(),'Grand Total')]/span")
	 WebElement oaGrandTotal;

	@FindBy(id="approve_oa")
	 WebElement oaApprove;

	@FindBy(xpath=".//td[text()='O.A Date& Time']/following::td[1]")
	 WebElement oaDate;

	@FindBy(xpath=".//td[text()='O.A No.']/following::td[1]")
	public WebElement oaNo;

	@FindBy(xpath="//div[contains(@class,'history')]/ul/li/b")
	 List<WebElement> changeLogHistory;

	@FindBy(xpath="//a[@id='btn_change_log']/*[1]")
	public WebElement changeLogBtn;

	@FindBy(xpath="//ul/li/span[contains(@class,'username')]")
	 List<WebElement> changeLogUsername;

	@FindBy(xpath="//div[@id='change_log_modal']//a[contains(@class,'cancel')][text()='Close']")
	public WebElement CloseChangeLogBtn;

	@FindBy(xpath=".//*[@id='oa_list']/tbody/tr/td[5]")
	 List<WebElement> oaDateList;

	@FindBy(xpath=".//a[@data-original-title='Back']") WebElement oaCancelBtn;

	@FindBy(id="reject_oa")
	 WebElement oaRejectBtn;

	@FindBy(id="amend_oa")
	 WebElement oaAmendBtn;

	@FindBy(xpath=".//td[contains(@class,'stock_qty stockable')]/span")
	 List<WebElement> materialsStockNOnStockList;

	@FindBy(xpath=".//td[contains(@class,'stock_qty')]/span")
	 List<WebElement> matStockList;

	@FindBy(xpath=".//td[contains(@class,'stock_qty stockable')]/span/preceding::td[7]/a/i")
	 List<WebElement> deleteMaterialLink_OA;

	@FindBy(xpath="//*[contains(@id,'cattable')]//i[@class='fa fa-trash-o']")
	 List<WebElement> deleteMaterialLink_PO;

	@FindBy(id="customReportView") WebElement viewCustomReport;

	@FindBy(id="OACancel")
	 WebElement oaPopupCancelBtn;

	@FindBy(xpath="//span[contains(text(),'-- Tax --')]")
	WebElement oaTaxDD;

	@FindBy(xpath="//span[contains(text(),'-- Tax --')]/following::input[1]")
	WebElement oaSearchField;

	@FindBy(id="add_oa_tax")
	 WebElement addOATax;

	@FindBy(xpath="//table[@id='oa_tax_table']/tbody/tr/th/b")
	List<WebElement> addedTax;

	//Se page
	@FindBy(xpath=".//a[@data-original-title='Create New Sales Estimate']")
	private WebElement createSeBtn;

	@FindBy(id="id_se_party_id_chosen")
	private WebElement sePartyDD;

	@FindBy(id="id_se_project_code_chosen")
	private WebElement seProjectDD;

	@FindBy(xpath="//*[@id='id_se_project_code_chosen']/div/div/input")
	 private WebElement SEProjectsearch;

	@FindBy(xpath="//input[@placeholder='Search']")
	 private WebElement seSalesPersonSearch;

	@FindBy(id="id_se-type")
	private WebElement seTypeDD;

	@FindBy(id="id_se-purpose")
	private WebElement SEPurpose;

	@FindBy(id="id_se-ref_no")
	private WebElement SERefno;

	@FindBy(id="expiry_date")
	private WebElement SEexpirydate;

	@FindBy(id="ref_date")
	private WebElement SErefdate;

	@FindBy(id="id_se_particular-__prefix__-item_name")
	 WebElement SEMaterialfield;

	@FindBy(id="id_se_particular-__prefix__-hsn_code")
	 WebElement SEhsncode;

	@FindBy(id="id_se_particular-__prefix__-alternate_units")
	private WebElement alternateUnit;

	@FindBy(xpath="//div/Select[@id='id_se_particular-__prefix__-alternate_units']/option[2]")
	private WebElement alternateUnitOptions;

	@FindBy(id="id_se_particular-__prefix__-remarks")
	 WebElement seStockRemarks;

	@FindBy(id="id_se_particular-__prefix__-price")
	 WebElement SEPrice;

	@FindBy(id="id_se_particular-__prefix__-quantity")
	 WebElement SEqty;

	@FindBy(id="id_se_particular-__prefix__-discount")
	 WebElement SEDiscount;

	@FindBy(xpath="//tr/td[2]/a")
	private List<WebElement> seListRecords;

	@FindBy(xpath="//*[contains(@id,'deleteSEParticulars')]/i[1]")
	private List<WebElement> seDeleteMaterials;

	@FindBy(xpath="//a[contains(text(),'Promote to OA')]")
	 private WebElement promoteToOaBTn;

	@FindBy(xpath="//a[contains(text(),'Promote to Invoice')]")
	 private WebElement promoteToInvoiceBTn;

	@FindBy(xpath="//*[@id='id_se_party_id_chosen']/div/div/input")
	 private WebElement SEPartysearch;

	@FindBy(xpath=".//tr[contains(@id,'se_particular')]/td/input[contains(@id,'item_name')]")
	private List<WebElement> addedSEMaterials;

	@FindBy(id="id_se-grand_total")
	private WebElement seGrandTotal;

	@FindBy(xpath="//label[text()='Sales Person']/following::div/button[@title]")
	private WebElement salesPerson;

	@FindBy(id="id_se-payment_terms")
	private WebElement sePaymentTerms;

	@FindBy(id="se-attachment-icon")
	private WebElement attachmenticon;

	@FindBy(id="document_label")
	private WebElement attachmentlabel;

	@FindBy(xpath="//span[contains(text(),'Choose file')]")
	private WebElement chooseFile;

	@FindBy(id="sehideUploadButton")
	private WebElement addSEAttachment;

	@FindBy(id="sehideUpload")
	private WebElement closeSeAttachment;

	@FindBy(xpath=".//a[@data-original-title='Back']")
	private WebElement BackSE;

	@FindBy(id="id_se-remarks")
	private WebElement remark;

	@FindBy(xpath=".//label[text()='Notes']/following::div[1]/i")
	private WebElement seNotesSupereditIcon;

	@FindBy(id="add_se_notes")
	private WebElement addSeNotes;

	@FindBy(id="se_tax_list_chosen")
	private WebElement TaxDD;

	@FindBy(id="id_se-special_instructions")
	private WebElement seInstruction;

	@FindBy(id="add_se_tax")
	private WebElement seTaxadd;

	@FindBy(xpath="//table[@id='se_tax_table']//th/b")
	private List<WebElement> seAddedTax;

	@FindBy(id="id_se-round_off")
	private WebElement Roundoff;

	@FindBy(id="cmd_save_se")
	private WebElement SaveSE;

	@FindBy(id="cmd_se_update")
	private WebElement updateSE;

	@FindBy(xpath="//p[contains(text(),'Please add atleast one material to the SE!')]")
	private WebElement warningWOMat;

	@FindBy(xpath="//table[@id='se_particulars_table']/tbody/tr/td/input[contains(@id,'-price')]")
	private List<WebElement> seAmountCol;

	@FindBy(xpath="//table[@id='se_particulars_table']//input[contains(@id,'quantity')][@placeholder='Quantity']")
	private List<WebElement> seQtyCol;

	@FindBy(xpath="//table[@id='se_tax_table']/tbody/tr/th/a[@title='Remove Tax']/following::td[3]/input[contains(@name,'tax')]")
	 List<WebElement> seTaxList;

	@FindBy(id="review_se")
	private WebElement reviewSE;

	@FindBy(id="cmd_se_review")
	private WebElement submitSEReview;

	@FindBy(xpath=".//a[@data-original-title='Back'][@data-placement='bottom']")
	private WebElement seBackBtn;

	@FindBy(id="approve_se")
	private WebElement approveSE;

	@FindBy(xpath=".//td[text()='Est.Date']/following::td[1]")
	private WebElement seApprovedDate;

	@FindBy(xpath=".//td[text()=' Estimate #']/following::td[1]")
	private WebElement seNO;

	@FindBy(xpath=".//*[@id='se_list']/tbody/tr/td[4]")
	 List<WebElement> seDateList;

	@FindBy(id="reject_se")
	private WebElement rejectSE;

	@FindBy(id="client_approve_se")
	private WebElement clientApproveSE;

	@FindBy(id="client_reject_se")
	private WebElement clientRejectSE;

	@FindBy(id="amend_se")
	private WebElement amendSEBtn;



	DateFormat dDateFormat = new SimpleDateFormat("MMM dd, yyyy");
	Date dDate1 = new Date();
	String sCurrentDate = dDateFormat.format(dDate1);
	String sDate = Constant.DateTimeFormat();
	String sNorDate = Constant.NormalDateFormat().substring(3, 5);
	Calendar cCal = Calendar.getInstance();

	WebDriver driver;
	public SalesPage(WebDriver driver){
		this.driver = driver;
	}



	public boolean statusReportColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load status report");
			filterBtn.click();
			viewReportBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder(reportColumnNames,sColumn);
		}catch(Exception e){
			System.err.println("Status Report column validation failed "+e);
		}
		return flag;
	}


	public boolean taxReportColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load tax report");
			filterBtn.click();
			viewReportBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder(reportColumnNames,sColumn);
		}catch(Exception e){
			System.err.println("Tax Report column validation failed "+e);
		}
		return flag;
	}

	public boolean materialReportColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material report");
			filterBtn.click();
			viewReportBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder(reportColumnNames,sColumn);
		}catch(Exception e){
			System.err.println("Material Report column validation failed "+e);
		}
		return flag;
	}

	public boolean salesReportColumnValidationWithDraft(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales report");
			filterBtn.click();
			salesViewReportBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder_ScrollTable(salesReportColumnNames, sColumn);
		}catch(Exception e){
			System.err.println("Sales Report column validation with draft failed "+e);
		}
		return flag;
	}

	public boolean salesReportColumnValidationWithoutDraft(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales report");
			filterBtn.click();
			excludeDrafts.click();
			salesViewReportBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder_ScrollTable(salesReportColumnNames,sColumn);
		}catch(Exception e){
			System.err.println("Sales Report column validation without draft failed "+e);
		}
		return flag;
	}

	public boolean addInvoice(int iRowNo, String sheet, String sOANo) throws Exception{
		boolean flag = false, flag1 = false, flag2 = false, flag3 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sOA = xls.get(iRowNo).get("Invoice with OA");
		String sPO = xls.get(iRowNo).get("Invoice with PO");
		String sTax = xls.get(iRowNo).get("Tax");
		String sProject = xls.get(iRowNo).get("Project");
		String sSalesAcct = xls.get(iRowNo).get("Sales Account");
		String sInvoice_DC = xls.get(iRowNo).get("Invoice with DC");
		String sInvoice = null;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			if(sInvoiceType.contains("DC") || sInvoiceType.contains("JDC") || sInvoiceType.contains("JIN")){
				navigate.navigateToStore();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToDeliveryChallan();
			}else{
				navigate.navigateToSales();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToInvoice();
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			navigate.showAllEntries();
			int iBeforeAdd = invoices.size();
			js.executeScript("arguments[0].scrollIntoView(true);",addIcon);
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(sInvoiceType.contains("DC") || sInvoiceType.contains("JDC") || sInvoiceType.contains("JIN")){
				if(DCAddPage.isDisplayed()){
					flag2 = true;
				}
			}else{
				if(invoiceAddPage.isDisplayed()){
					salesAcctDropDwn.click();
					salesAcctSearchTxt.sendKeys(sSalesAcct);
					driver.findElement(By.xpath(".//em[text()='"+sSalesAcct+"']")).click();
					flag2 = true;
				}
			}
			String sCustomer = addInvoiceDetails(iRowNo, sheet, sOANo);
			sProject = invoiceProject.getText();
			String[] sCustomerSplit = sCustomer.split("\\(");
			if(sOA.contains("yes")){
				flag3 = addOAToInvoice(iRowNo, sheet, sOANo);
			}else{
				flag3 = true;
			}
			if(!(sInvoiceType.contains("DC") || sInvoiceType.contains("JDC") || sInvoiceType.contains("JIN"))){
				packingNTransport_GST(iRowNo, sheet);
			}
			if(!(sPO.equals("yes") || sOA.contains("yes") || sInvoice_DC.contains("yes") || sInvoiceType.contains("JIN"))){
				js.executeScript("window.scrollBy(0,-5000)");
				addMaterialDetails(iRowNo,sMaterial, sheet, sTax);
			}
			flag1 = validateGrandTotalValue();
			RoundOff();
			if(flag1 && flag2 && flag3){
				String sGrandTotal = grandTotal.getAttribute("value");
				save.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
					Thread.sleep(Constant.Min_Sleep);
				}
				boolean flag4 = Constant.isElementPresent(By.id("btn-sa-confirm"));
				if(flag4){
					okButton.click();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				int iAfterAdd = invoices.size();
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")));
				sInvoice = sInvoiceType.substring(0, 1);
				if(iBeforeAdd < iAfterAdd){
					String sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")).getText();
					Actions actions = new Actions(driver);
					actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td[9]/a"))).perform();
					actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td[9]/span/span[2]/i"))).click().perform();
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("window.scrollBy(0,-5000)");
					Thread.sleep(Constant.Min_Sleep);
					String sActDraftNo = invoiceNoEditPage.getText();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(backBtn), "Failed to load sales edit page");
					backBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")));
					WebElement ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a[contains(text(),'"+sDraftNo+"')]/following::td[contains(text(),'"+sInvoiceType+"')]/following::td[1][contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sCustomerSplit[0].trim()+"')]/following::td[text()=' "+sGrandTotal+"']/following::td/a[text()='Pending']"));
					if(sDraftNo.startsWith("PF#"+sInvoice+"") && ele.isDisplayed() && flag2 && sDraftNo.equals(sActDraftNo)){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Adding invoice/delivery challan failed "+e);
		}
		return flag;
	}

	public boolean addOAToInvoice(int iRowNo, String sheet, String sOANo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sQtyRequired = xls.get(iRowNo).get("Qty to be Entered");
		String sMatCount = xls.get(iRowNo).get("Material Count");
		String sTax = xls.get(iRowNo).get("Tax");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			oANoDropDwn.click();
			if(sOANo == null){
				if(oANolist.size() > 0){
					for(int i=0;i<oANolist.size();i++){
						oANolist.get(i).click();
 						Thread.sleep(Constant.Min_Sleep);
						if(i == 10){
							break;
						}
					}
				}
			}else{
				oANoSearchField.sendKeys(sOANo);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//label[contains(text(),'"+sOANo+"')]")).click();
			}
			Thread.sleep(Constant.Min_Sleep);
			driver.findElement(By.xpath(".//div[@class='btn-group open']/button")).click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(addOAMaterials), "Failed to load sales view page");
			Thread.sleep(Constant.Min_Sleep);
			if(viewOAMaterilPopup.isDisplayed()){
				String sLinkedNum = addDetailsViewMaterial(sQtyRequired, sMatCount);
				flag = validateLinkedNumber(sLinkedNum);
			}
			for(int i=0;i<hsnStockMatList.size();i++){
				addCGSTTax_Stock(iRowNo,i,sheet);
				addSGSTTax_Stock(iRowNo,i,sheet);
				addIGSTTax_Stock(iRowNo,i,sheet);
			}
			boolean flag1 = Constant.isElementPresent(By.xpath(".//th/i[text()='(Net Rate)']"));
			if(!flag1){
				addTax(iRowNo,sTax);
			}
		}catch(Exception e){
			System.err.println("Adding OA materials to invoice failed "+e);
		}
		return flag;
	}
	public boolean RoundOff(){
		boolean flag = false;
		String sGrandTotal,sDecimalvalue;
		try{
			roundOff.sendKeys(Keys.CONTROL+"a");
			roundOff.sendKeys(Keys.DELETE);
			grandTotal.click();
			sGrandTotal = grandTotal.getAttribute("value");
			Thread.sleep(Constant.Min_Sleep);
			sDecimalvalue = sGrandTotal.substring(sGrandTotal.indexOf("."));
			if(!sDecimalvalue.contains("00")){
				sDecimalvalue = sDecimalvalue.substring(1);
				Thread.sleep(Constant.Min_Sleep);
				int iRemaining = 100 - Integer.parseInt(sDecimalvalue);
				roundOff.sendKeys(Keys.CONTROL+"a");
				roundOff.sendKeys(Keys.DELETE);
				if(iRemaining < 50){
					if(iRemaining < 10){
						roundOff.sendKeys(".0"+iRemaining);
					}else{
						roundOff.sendKeys("."+iRemaining);
					}
				}else{
					roundOff.sendKeys("-."+sDecimalvalue);
				}
				roundOff.sendKeys(Keys.TAB);
				roundOff.sendKeys(Keys.ENTER);
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

	public void addStockMatWithGST(int iRowNo, String sMaterial, String sheet) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String[] sMaterialList = sMaterial.split(",");
		try{
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			for(int i=0;i<sMaterialList.length;i++){
				addStockMaterial(iRowNo,sMaterialList[i],sAltUnit);
				Thread.sleep(Constant.Min_Sleep);
				addInvoiceItem.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean flag = Constant.isElementPresent(By.id("btn-sa-confirm"));
				if(flag){
					okButton.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
				if(!sInvoiceType.contains("BoS")){
					addCGSTTax_Stock(iRowNo,i,sheet);
					addSGSTTax_Stock(iRowNo,i,sheet);
					addIGSTTax_Stock(iRowNo,i,sheet);
				}
				js.executeScript("window.scrollBy(0,-500)");
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Stock material addition with GST failed "+e);
		}
	}

	public void addMaterialDetails(int iRowNo, String sMaterial, String sheet, String sTax){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReturn = xls.get(iRowNo).get("DC with Return");
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		try{
			if(sReturn.contains("yes")){
				stockReturnCheckBx.click();
			}
			addStockMatWithGST(iRowNo, sMaterial, sheet);
			if(!sInvoiceType.contains("BoS")){
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				boolean flag1 = Constant.isElementPresent(By.xpath(".//th/i[text()='(Net Rate)']"));
				if(!flag1){
					addTax(iRowNo,sTax);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add material details "+e);
		}
	}

	/**
	 * Add invoice details
	 * @param iRowNo
	 * @throws Exception
	 */

	public String addInvoiceDetails(int iRowNo, String sheet, String sPONo){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sProject = xls.get(iRowNo).get("Project");
		String sCustomer = xls.get(iRowNo).get("Party");
		String sInvoice_DC = xls.get(iRowNo).get("Invoice with DC");
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(customerDropDwn), "Failed to load customer drop down");
			customerDropDwn.click();
			customerText.sendKeys(sCustomer);
			Thread.sleep(Constant.Min_Sleep);
			driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
			Constant.waitFor(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//button[contains(@title,'Loading')]")), "Failed to load oa drop down");
			if(invoiceType.isDisplayed()){
				Select select = new Select(invoiceType);
				select.selectByValue(sInvoiceType);
				Thread.sleep(Constant.Min_Sleep);
				invoiceProject.click();
				invoiceProjectSearch.sendKeys(sProject);
				driver.findElement(By.xpath(".//li[text()='All']/following::li/em[text()='"+sProject+"']")).click();
				Thread.sleep(Constant.Min_Sleep);
				poDateField.click();
				poDatePrevIcon.click();
				poDateSelect.click();
				issuedOnDateDropDwn.click();
				dateSelect.click();
				timeHrSelect.click();
				timeSelect.click();
				eGSTINTxtField.sendKeys(sDate+"1");
				if(sInvoiceType.contains("JDC")){
					if(sPONo == null){
						flag = selectPONO(iRowNo, sheet);
					}else{
						flag = searchPoNO(iRowNo, sheet, sPONo);
					}
				}else{
					pONo.clear();
					pONo.sendKeys(sDate);
					flag = true;
				}
				if(sInvoice_DC.contains("yes")){
					flag = selectDCNo(iRowNo, sheet);
				}
				if(sInvoiceType.contains("JIN")){
					if(sPONo == null){
						flag = selectPartyDCNO(0, iRowNo, sheet);
					}else{
						flag = searchPartyDCNO(iRowNo, sheet, sPONo);
					}
				}
				if(flag){
					sCustomer = customerDropDwn.getText();
					Thread.sleep(Constant.Min_Sleep);
					if(!sInvoiceType.contains("Service")){
						transportMode.clear();
						transportMode.sendKeys("Road");
						roadPermitNo.clear();
						roadPermitNo.sendKeys(sDate);
						packingSlipNo.clear();
						packingSlipNo.sendKeys(sDate);
						packingDesc.clear();
						packingDesc.sendKeys("Packed");
						lorryNo.clear();
						lorryNo.sendKeys(sDate);
					}
	//				oADate.click();
	//				driver.findElement(By.xpath(".//div[contains(@class,'daterangepicker')][3]/div[1]/div[2]/table/thead/tr[1]/th[1]")).click();
	//				driver.findElement(By.xpath(".//div[contains(@class,'daterangepicker')][3]/div[1]/div[2]/table/tbody/tr[3]/td[4]")).click();
					if(sInvoiceType.contains("DC") || sInvoiceType.contains("JDC") || sInvoiceType.contains("JIN")){
						returnDate.click();
						driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[2]/th[3]")).click();
						driver.findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr[3]/td[4]")).click();
					}
					paymenyTerms.clear();
					paymenyTerms.sendKeys("cash");
					specialInst.clear();
					specialInst.sendKeys("nothing");
					invoiceRemarks.clear();
					invoiceRemarks.sendKeys("Invoice creation for automation");
				}
			}
		}catch(Exception e){
			System.err.println("Addition of invoice details failed "+e);
		}
		return sCustomer;
	}

	public boolean searchPartyDCNO(int iRowNo, String sheet, String sPONo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sQtyRequired = xls.get(iRowNo).get("Qty to be Entered");
		String sMatCount = xls.get(iRowNo).get("Material Count");
		String sTax = xls.get(iRowNo).get("Tax");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(partyDcNoDropDwn), "Failed to load sales view page");
			Thread.sleep(Constant.Max_Sleep);
 			Thread.sleep(Constant.Min_Sleep);
			partyDcNoDropDwn.click();
			Thread.sleep(Constant.Medium_Sleep);
			oANoSearchField.sendKeys(sPONo);
			Thread.sleep(Constant.Min_Sleep);
			driver.findElement(By.xpath("//label[contains(text(),'"+sPONo+"')]")).click();
			Thread.sleep(Constant.Min_Sleep);
			partyDcNoDropDwn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(addOAMaterials), "Failed to load sales view page");
			if(viewGRNMaterialsPopup.isDisplayed()){
				Thread.sleep(Constant.Medium_Sleep);
				String sLinkedNum = addDetailsViewMaterial(sQtyRequired, sMatCount);
				flag = validateLinkedNumber(sLinkedNum);
			}
			for(int i=0;i<hsnStockMatList.size();i++){
				addCGSTTax_Stock(iRowNo,i,sheet);
				addSGSTTax_Stock(iRowNo,i,sheet);
				addIGSTTax_Stock(iRowNo,i,sheet);
			}
			boolean flag1 = Constant.isElementPresent(By.xpath(".//th/i[text()='(Net Rate)']"));
			if(!flag1){
				addTax(iRowNo,sTax);
			}
		}catch(Exception e){
			System.err.println("Failed to search PO no "+e);
		}
		return flag;
	}

	public boolean selectPartyDCNO(int j,int iRowNo, String sheet){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sQtyRequired = xls.get(iRowNo).get("Qty to be Entered");
		String sMatCount = xls.get(iRowNo).get("Material Count");
		String sTax = xls.get(iRowNo).get("Tax");
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//button[contains(@title,'Loading')]")), "Failed to load party dc drop down");
 			partyDcNoDropDwn.click();
			Thread.sleep(Constant.Min_Sleep);
			partyDCNoList.get(j).click();
			Thread.sleep(Constant.Min_Sleep);
			partyDcNoDropDwn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(addOAMaterials), "Failed to load OA popup");
			Thread.sleep(Constant.Min_Sleep);
			if(viewGRNMaterialsPopup.isDisplayed()){
				String sLinkedNum = addDetailsViewMaterial(sQtyRequired, sMatCount);
				flag = validateLinkedNumber(sLinkedNum);
			}

			for(int i=0;i<hsnStockMatList.size();i++){
				addCGSTTax_Stock(iRowNo,i,sheet);
				addSGSTTax_Stock(iRowNo,i,sheet);
				addIGSTTax_Stock(iRowNo,i,sheet);
			}
			boolean flag1 = Constant.isElementPresent(By.xpath(".//th/i[text()='(Net Rate)']"));
			if(!flag1){
				addTax(iRowNo,sTax);
			}
		}catch(Exception e){
			System.err.println("Failed to select Party dc no "+e);
		}
		return flag;
	}

	public boolean selectDCNo(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sQtyRequired = xls.get(iRowNo).get("Qty to be Entered");
		String sMatCount = xls.get(iRowNo).get("Material Count");
		String sTax = xls.get(iRowNo).get("Tax");
		try{
			goodsSuppliedChckBx.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(dcFinYrDropDwn), "Failed to load po no drop down");
			dcFinYrDropDwn.click();
			if(DcFYOptions.size() > 0){
				for (WebElement dcFYOption : DcFYOptions) {
					dcFYOption.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
			dcFinYrDropDwn.click();
			Thread.sleep(Constant.Max_Sleep);
			dcNoDropDwn.click();
			Thread.sleep(Constant.Min_Sleep);
			for (WebElement dcNoOption : DcNoOptions) {
				if(DcNoOptions.size() > 0){
					dcNoOption.click();
					Thread.sleep(Constant.Min_Sleep);
					break;
				}
			}
			dcNoDropDwn.click();
			Thread.sleep(Constant.Min_Sleep);
			String sLinkedNum = addDetails_ItemsInvoiced(sQtyRequired, sMatCount);
			Thread.sleep(Constant.Min_Sleep);
			for (WebElement element : dcNoMaterialListGrid) {
				element.click();
			}
			flag = validateLinkedNumber(sLinkedNum);
			Thread.sleep(Constant.Min_Sleep);
			for(int i=0;i<cgst_InvoiceDC.size();i++){
				addCGSTTax_InvoiceDC(iRowNo, i, sheet);
				addSGSTTax_InvoiceDC(iRowNo, i, sheet);
				addIGSTTax_InvoiceDC(iRowNo, i, sheet);
			}
			addTax(iRowNo,sTax);
		}catch(Exception e){
			System.err.println("Addition of materials from items invoiced popup failed "+e);
		}
		return flag;
	}

	public boolean searchPoNO(int iRowNo, String sheet, String sPONo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("Tax");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			pONoDropDwn.click();
			poNoSearchField.sendKeys(sPONo);
			poNoList.get(0).click();
			Thread.sleep(Constant.Min_Sleep);
			flag = addPOMaterials();
			js.executeScript("window.scrollBy(0,5000)");
			invoiceRemarks.sendKeys("Invoice creation for automation");
			for(int k=0;k<hsnEditStockMatList.size();k++){
				addCGSTEditTax_Stock(iRowNo,k,sheet);
				addSGSTEditTax_Stock(iRowNo,k,sheet);
				addIGSTEditTax_Stock(iRowNo,k,sheet);
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
			}
			addTax(iRowNo,sTax);
		}catch(Exception e){
			System.err.println("Failed to search PO no "+e);
		}
		return flag;
	}

	public boolean selectPONO(int iRowNo, String sheet){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sPO = xls.get(iRowNo).get("Invoice with PO");
		String sTax = xls.get(iRowNo).get("Tax");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(pONoDropDwn), "Failed to load po no drop down");
			customerDropDwn.click();
			for(int i=1;i<supplierList.size();i++){
				pONoDropDwn.click();
				if(poNoList.size() > 1){
					for(int j=1;j<poNoList.size();j++){
						poNoList.get(j).click();
						Constant.waitFor(ExpectedConditions.elementToBeClickable(cancelPoMaterialPopup), "Failed to load po materials popup");
						if(sPO.contains("yes")){
							flag = addPOMaterials();
							for(int k=0;k<hsnEditStockMatList.size();k++){
								addCGSTEditTax_Stock(iRowNo,k,sheet);
								addSGSTEditTax_Stock(iRowNo,k,sheet);
								addIGSTEditTax_Stock(iRowNo,k,sheet);
								js.executeScript("window.scrollBy(0,-5000)");
								Thread.sleep(Constant.Min_Sleep);
							}
							addTax(iRowNo,sTax);
							if(deleteInvoiceMat.size() > 1){
								break;
							}else{
								pONoDropDwn.click();
								continue;
							}
						}else{
							cancelPoMaterialPopup.click();
							Thread.sleep(Constant.Min_Sleep);
							flag = true;
							break;
						}
					}
				}else{
					customerDropDwn.click();
					supplierList.get(i).click();
					customerDropDwn.click();
					continue;
				}
				break;
			}
		}catch(Exception e){
			System.err.println("Failed to select Po no "+e);
		}
		return flag;
	}

	public String addDetailsViewMaterial(String sQtyRequired, String sMaterialCount){
		double value; int j = Integer.parseInt(sMaterialCount);
		String sLinkedNumber = null ;
		try{
			for(int i=0;i<materialsStockNOnStockList.size();i++){
				String a = materialsStockNOnStockList.get(i).getText();
				if(Double.parseDouble(materialsStockNOnStockList.get(i).getText()) <= 0){
					deleteMaterialLink_OA.get(i).click();
					Thread.sleep(Constant.Min_Sleep);
					okButton.click();
					Thread.sleep(Constant.Min_Sleep);
					i=-1;
				}
			}
			for(int i=0;i<hsnCodeOA.size();i++){
				if(hsnCodeOA.get(i).getAttribute("value").isEmpty() || hsnCodeOA.get(i).getAttribute("value").matches(".*[a-zA-Z]+.*")){
					hsnCodeOA.get(i).sendKeys(Keys.CONTROL+"a");
					hsnCodeOA.get(i).sendKeys(Keys.DELETE);
					hsnCodeOA.get(i).sendKeys(sDate);
				}
				if(remarksOA.get(i).getAttribute("value").isEmpty()){
					remarksOA.get(i).sendKeys("test remarks");
				}
				String[] count = pendingOAQty.get(i).getText().split("\\s");
				if(sQtyRequired.contains("Full")){
					value = Double.parseDouble(count[0]);
				}else{
					if(Double.parseDouble(count[0]) < 5){
						value = Double.parseDouble(count[0]);
					}else{
						value = 5;
					}
				}
				qtyOA.get(i).sendKeys(Keys.CONTROL+"a");
				qtyOA.get(i).sendKeys(Keys.DELETE);
				qtyOA.get(i).sendKeys(Double.toString(value));
				discountOA.get(i).sendKeys(Keys.CONTROL+"a");
				discountOA.get(i).sendKeys(Keys.DELETE);
				discountOA.get(i).sendKeys("2.5");
				hsnCodeOA.get(i).click();
				String sValue = amountOA.get(i).getAttribute("value");
				double iValue =(value*Double.parseDouble(unitRateOA.get(i).getAttribute("value")));
				double dDiscountValue = (iValue*2.5)/100;
				double dActAmount = iValue - dDiscountValue;
				sLinkedNumber = grnNoColumn.get(0).getText();
//					double dRoundOff = Math.round(dActAmount * 100.0) / 100.0; //amount round off to 2 decimals
				if(dActAmount == Double.parseDouble(sValue)){
					if(i == j){
						break;
					}
				}
			}
			addOAMaterials.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to add details to View Material pop up "+e);
		}
		return sLinkedNumber;
	}

	public String addDetails_ItemsInvoiced(String sQtyRequired, String sMaterialCount){
		double value; int j = Integer.parseInt(sMaterialCount);
		String sPrice = RandomStringUtils.randomNumeric(2);
		String sLinkedNumber = null;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(addOAMaterials), "Failed to load sales view page");
			if(viewOAMaterilPopup.isDisplayed()){
				for (WebElement element : itemsInvoiceMaterialListPopUp) {
					element.click();
				}
				for(int i=0;i<itemsInvoiceMaterialListPopUp.size();i++){
					if(hsnCodeOA.get(i).getAttribute("value").isEmpty() || hsnCodeOA.get(i).getAttribute("value").matches(".*[a-zA-Z]+.*")){
						hsnCodeOA.get(i).sendKeys(Keys.CONTROL+"a");
						hsnCodeOA.get(i).sendKeys(Keys.DELETE);
						hsnCodeOA.get(i).sendKeys(sDate);
					}
					if(remarksOA.get(i).getAttribute("value").isEmpty()){
						remarksOA.get(i).sendKeys("test remarks");
					}
					String[] count = pendingOAQty.get(i).getText().split("\\s");
					if(sQtyRequired.contains("Full")){
						value = Double.parseDouble(count[0]);
					}else{
						if(Double.parseDouble(count[0]) < 5){
							value = Double.parseDouble(count[0]);
						}else{
							value = 5;
						}
					}
					qtyOA.get(i).sendKeys(Keys.CONTROL+"a");
					qtyOA.get(i).sendKeys(Keys.DELETE);
					qtyOA.get(i).sendKeys(Double.toString(value));
					price_ItemsInvoicePopup.get(i).sendKeys(Keys.CONTROL+"a");
					price_ItemsInvoicePopup.get(i).sendKeys(Keys.DELETE);
					price_ItemsInvoicePopup.get(i).sendKeys(sPrice);
					discItemsInvoicedpopup.get(i).sendKeys(Keys.CONTROL+"a");
					discItemsInvoicedpopup.get(i).sendKeys(Keys.DELETE);
					discItemsInvoicedpopup.get(i).sendKeys("2.5");
					hsnCodeOA.get(i).click();
					Thread.sleep(Constant.Min_Sleep);
					String sValue = amountInvoiceDCItems.get(i).getText();
					double iValue =(Double.parseDouble(consolidateQty.get(i).getText())*Double.parseDouble(sPrice));
					double dDiscountValue = (iValue*2.5)/100;
					double dActAmount = iValue - dDiscountValue;
					double dRoundOff = Math.round(dActAmount * 100.0) / 100.0; //amount round off to 2 decimals
					sLinkedNumber = grnNoColumn.get(0).getText();
					if(dRoundOff == Double.parseDouble(sValue)){
						if(i == j){
							break;
						}
					}
					if(itemsInvoiceMaterialListPopUp.size() > i+1){
						for(i=j+1;i<itemsInvoiceMaterialListPopUp.size();i++){
							deleteMaterialLink_OA.get(i).click();
							Thread.sleep(Constant.Min_Sleep);
							okButton.click();
							Thread.sleep(Constant.Min_Sleep);
						}
					}
				}
			}
			addOAMaterials.click();
		}catch(Exception e){
			System.err.println("Failed to add details from items invoiced pop up "+e);
		}
		return sLinkedNumber;
	}

	public boolean addPOMaterials(){
		boolean flag = false;
		String sStock;
		try{
			for(WebElement ele:materialsStockNOnStockList){
				for(int j=0;j<materialsStockNOnStockList.size();j++){
					if(Double.parseDouble(materialsStockNOnStockList.get(j).getText()) < Double.parseDouble(poMaterialsQtyList.get(j).getAttribute("value")) || Double.parseDouble(materialsStockNOnStockList.get(j).getText()) <= 0){
						deleteMaterialLink_PO.get(j).click();
						Thread.sleep(Constant.Min_Sleep);
						driver.switchTo().alert().accept();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
			}
			for(int i=0;i<poMaterialsDrawingNoList.size();i++){
				if(poMaterialsHSNNoList.get(i).getText().isEmpty() || poMaterialsHSNNoList.get(i).getText().matches(".*[a-zA-Z]+.*")){
					poMaterialsHSNNoList.get(i).sendKeys(Keys.CONTROL+"a");
					poMaterialsHSNNoList.get(i).sendKeys(Keys.DELETE);
					poMaterialsHSNNoList.get(i).sendKeys(sDate);
				}
				sStock = matStockList.get(i).getText();
				poMaterialsQtyList.get(i).clear();
				if(poMaterialsQtyList.get(i).isDisplayed()){
					poMaterialsQtyList.get(i).sendKeys(Keys.CONTROL+"a");
					poMaterialsQtyList.get(i).sendKeys(Keys.DELETE);
					if(Double.parseDouble(sStock) <= 10 && Double.parseDouble(sStock) > 0){
						poMaterialsQtyList.get(i).sendKeys(sStock);
					}else if(Double.parseDouble(sStock) == 0 || Double.parseDouble(sStock) > 10){
						poMaterialsQtyList.get(i).sendKeys("5");
					}
				}
				poMaterialsDis.get(i).sendKeys(Keys.CONTROL+"a");
				poMaterialsDis.get(i).sendKeys(Keys.DELETE);
				poMaterialsDis.get(i).sendKeys("2.5");
				poMaterialsQtyList.get(i).click();
			}
			for(int i=0;i<poMaterialsDrawingNoList.size();i++){
				String sQty = poMaterialsQtyList.get(i).getAttribute("value");
				String sRate = poMaterialsUnitRate.get(i).getAttribute("value");
				String sDiscount = poMaterialsDis.get(i).getAttribute("value");
				String sAmt = poMaterialsAmt.get(i).getAttribute("value");
				double Value = Double.parseDouble(sRate)-((Double.parseDouble(sRate) * (Double.parseDouble(sDiscount))) / 100);
				double d = Double.parseDouble(sQty) * Value;
				double actValue = Math.round(d * 100.0) / 100.0;
				if(Double.parseDouble(sAmt) == actValue){
					flag = true;
				}else{
					flag = false;
					break;
				}
			}
			addPOMaterials.click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = Constant.isElementPresent(By.cssSelector("#btn-sa-confirm"));
			if(flag1){
				okButton.click();
			}
			if(Constant.isAlertPresents()){
				driver.switchTo().alert().accept();
				for(int i=0;i<poBomMatErrorBorderDelete.size();i++){
					poBomMatErrorBorderDelete.get(i).click();
					Thread.sleep(Constant.Min_Sleep);
					driver.switchTo().alert().accept();
					Thread.sleep(Constant.Min_Sleep);
					i = 0;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add po materials from pop up "+e);
		}
		return flag;
	}

	/**
	 * Add stock material
	 * @param iRowNo, Material
	 * @return true, if material is added with proper amount calculation
	 * @throws Exception
	 */
	public boolean addStockMaterial(int iRowNo,String sMaterial, String sAltUnit) throws Exception{
		boolean flag = false;
		try{
			if(invoiceType.isDisplayed()){
				materialReq.sendKeys(sMaterial);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//li[2]/a[contains(text(),'"+sMaterial+"')]")).click();
				Thread.sleep(Constant.Max_Sleep*2);
				if(sAltUnit.contains("Yes")){
					altUnitDrpDwn.click();
					altUnitOption.click();
				}
				if(hSNCodeStock.getAttribute("value").isEmpty() || hSNCodeStock.getAttribute("value").matches(".*[a-zA-Z]+.*")){
					hSNCodeStock.sendKeys(Keys.CONTROL+"a");
					hSNCodeStock.sendKeys(Keys.DELETE);
					hSNCodeStock.sendKeys(sDate);
					Thread.sleep(Constant.Min_Sleep);
				}
				addRemarks.click();
				Thread.sleep(Constant.Min_Sleep);
				remarksStock.sendKeys("Material remarks "+sDate);
				quantityStock.sendKeys(Keys.CONTROL+"a");
				quantityStock.sendKeys(Keys.DELETE);
				quantityStock.sendKeys("10");
				Thread.sleep(Constant.Min_Sleep);
				String sUnit = units.getAttribute("value");
				String sRate = rate_Stock.getAttribute("value");
				if(sRate.equals("0")){
					rate_Stock.sendKeys(Keys.CONTROL+"a");
					rate_Stock.sendKeys(Keys.DELETE);
					rate_Stock.sendKeys("10");
					sRate = rate_Stock.getAttribute("value");
				}
				if(!(sUnit.isEmpty() && sRate.isEmpty())){
					discountStock.sendKeys(Keys.CONTROL+"a");
					discountStock.sendKeys(Keys.DELETE);
					discountStock.sendKeys("12.45");
					Thread.sleep(Constant.Min_Sleep);
					remarksStock.click();
					String sStockvalue = netValueForStock.getAttribute("value");
					double iValue =(10*Double.parseDouble(sRate));
					double dDiscountValue = (iValue*12.45)/100;
					double dActAmount = iValue - dDiscountValue;
					double dRoundOff = Math.round(dActAmount * 100.0) / 100.0;
					if(dRoundOff == Double.parseDouble(sStockvalue)){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Addition of stock material failed "+e);
		}
		return flag;
	}

	public boolean validateGrandTotalValue(){
		boolean flag = false;
		ArrayList<String> tax = new ArrayList<>();
		List<Double> arrayOfInts = new ArrayList<>();
		double sum = 0;
		try{
			String sTotal = invoiceTotal.getAttribute("value");
			String sNetCGST = netCGSTValue.getAttribute("value");
			String sNetSGST = netSGSTValue.getAttribute("value");
			String sNetIGST = netIGSTValue.getAttribute("value");
			for (WebElement element : addedTaxList) {
				tax.add(element.getAttribute("value"));
			}
			for(Object str : tax) {
			   arrayOfInts.add(Double.parseDouble((String)str));
			}
			for (Double arrayOfInt : arrayOfInts) {
			   sum += arrayOfInt;
			}
			String sGrandTotal = grandTotal.getAttribute("value");
			double Total = Double.parseDouble(sTotal)+Double.parseDouble(sNetCGST)+Double.parseDouble(sNetSGST)+Double.parseDouble(sNetIGST)+sum;
			double roundOff = Math.round(Total * 100.0) / 100.0;
			if(roundOff == Double.parseDouble(sGrandTotal)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Grand total is calculated wrongly "+e);
		}
		return flag;
	}

	public boolean addCGSTTax_Stock(int iRowNo,int iPosition,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("CGST");
		try{
			Select select = new Select(cgstDropDwn.get(iPosition));
			select.selectByValue(sTax);
			String sValue = cgstAmt.get(iPosition).getText();
			String sTotal = matAmt.get(iPosition).getAttribute("value");
			String sPercent = cgstPercentage.get(iPosition).getAttribute("value");
			double dCgst = Double.parseDouble(sTotal)*Double.parseDouble(sPercent)/100;
			double dRoundOff = Math.round(dCgst * 100.0) / 100.0;
			if(dRoundOff == Double.parseDouble(sValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("CGST tax addition for stock material failed "+e);
		}
		return flag;
	}

	public boolean addSGSTTax_Stock(int iRowNo, int iPosition,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("SGST");
		try{
			Select select = new Select(sgstDropDwn.get(iPosition));
			select.selectByValue(sTax);
			String sValue = sgstAmt.get(iPosition).getText();
			String sTotal = matAmt.get(iPosition).getAttribute("value");
			String sPercent = sgstPercentage.get(iPosition).getAttribute("value");
			double dSgst = Double.parseDouble(sTotal)*Double.parseDouble(sPercent)/100;
			double dRoundOff = Math.round(dSgst * 100.0) / 100.0;
			if(dRoundOff == Double.parseDouble(sValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("SGST tax addition for stock material failed "+e);
		}
		return flag;
	}

	public boolean addIGSTTax_Stock(int iRowNo, int iPosition,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("IGST");
		try{
			Select select = new Select(igstDropDwn.get(iPosition));
			select.selectByValue(sTax);
			String sValue = igstAmt.get(iPosition).getText();
			String sTotal = matAmt.get(iPosition).getAttribute("value");
			String sPercent = igstPercentage.get(iPosition).getAttribute("value");
			double dIgst = Double.parseDouble(sTotal)*Double.parseDouble(sPercent)/100;
			double dRoundOff = Math.round(dIgst * 100.0) / 100.0;
			if(dRoundOff == Double.parseDouble(sValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("IGST tax addition for stock material failed "+e);
		}
		return flag;
	}

	public boolean addCGSTEditTax_Stock(int iRowNo,int iPosition,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("CGST");
		try{
			Select select = new Select(cgstEditDropDwn.get(iPosition));
			select.selectByValue(sTax);
			String sValue = cgstEditAmt.get(iPosition).getText();
			String sTotal = matEditAmt.get(iPosition).getAttribute("value");
			String sPercent = cgstEditPercentage.get(iPosition).getAttribute("value");
			double dCgst = Double.parseDouble(sTotal)*Double.parseDouble(sPercent)/100;
			double dRoundOff = Math.round(dCgst * 100.0) / 100.0;
			if(dRoundOff == Double.parseDouble(sValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("CGST tax Edit for stock material failed "+e);
		}
		return flag;
	}

	public boolean addSGSTEditTax_Stock(int iRowNo, int iPosition,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("SGST");
		try{
			Select select = new Select(sgstEditDropDwn.get(iPosition));
			select.selectByValue(sTax);
			String sValue = sgstEditAmt.get(iPosition).getText();
			String sTotal = matEditAmt.get(iPosition).getAttribute("value");
			String sPercent = sgstEditPercentage.get(iPosition).getAttribute("value");
			double dSgst = Double.parseDouble(sTotal)*Double.parseDouble(sPercent)/100;
			double dRoundOff = Math.round(dSgst * 100.0) / 100.0;
			if(dRoundOff == Double.parseDouble(sValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("SGST tax Edit for stock material failed "+e);
		}
		return flag;
	}

	public boolean addIGSTEditTax_Stock(int iRowNo, int iPosition,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("IGST");
		try{
			Select select = new Select(igstEditDropDwn.get(iPosition));
			select.selectByValue(sTax);
			String sValue = igstEditAmt.get(iPosition).getText();
			String sTotal = matEditAmt.get(iPosition).getAttribute("value");
			String sPercent = igstEditPercentage.get(iPosition).getAttribute("value");
			double dIgst = Double.parseDouble(sTotal)*Double.parseDouble(sPercent)/100;
			double dRoundOff = Math.round(dIgst * 100.0) / 100.0;
			if(dRoundOff == Double.parseDouble(sValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("IGST tax Edit for stock material failed "+e);
		}
		return flag;
	}

	public boolean addCGSTTax_InvoiceDC(int iRowNo,int iPosition,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("CGST");
		try{
			Select select = new Select(cgst_InvoiceDC.get(iPosition));
			select.selectByValue(sTax);
			String sValue = cgstValue_InvoiceDC.get(iPosition).getText();
			String sTotal = itemAmtList_InvoiceDC.get(iPosition).getText();
			WebElement option = select.getFirstSelectedOption();
			String sPercent = option.getText();
			double dCgst = Double.parseDouble(sTotal)*Double.parseDouble(sPercent)/100;
			double dRoundOff = Math.round(dCgst * 100.0) / 100.0;
			if(dRoundOff == Double.parseDouble(sValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("CGST tax addition for stock material failed "+e);
		}
		return flag;
	}

	public boolean addSGSTTax_InvoiceDC(int iRowNo, int iPosition,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("SGST");
		try{
			Select select = new Select(sgst_InvoiceDC.get(iPosition));
			select.selectByValue(sTax);
			String sValue = sgstValue_InvoiceDC.get(iPosition).getText();
			String sTotal = itemAmtList_InvoiceDC.get(iPosition).getText();
			WebElement option = select.getFirstSelectedOption();
			String sPercent = option.getText();
			double dSgst = Double.parseDouble(sTotal)*Double.parseDouble(sPercent)/100;
			double dRoundOff = Math.round(dSgst * 100.0) / 100.0;
			if(dRoundOff == Double.parseDouble(sValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("SGST tax addition for stock material failed "+e);
		}
		return flag;
	}

	public boolean addIGSTTax_InvoiceDC(int iRowNo, int iPosition,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("IGST");
		try{
			Select select = new Select(igst_InvoiceDC.get(iPosition));
			select.selectByValue(sTax);
			String sValue = igstValue_InvoiceDC.get(iPosition).getText();
			String sTotal = itemAmtList_InvoiceDC.get(iPosition).getText();
			WebElement option = select.getFirstSelectedOption();
			String sPercent = option.getText();
			double dIgst = Double.parseDouble(sTotal)*Double.parseDouble(sPercent)/100;
			double dRoundOff = Math.round(dIgst * 100.0) / 100.0;
			if(dRoundOff == Double.parseDouble(sValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("IGST tax addition for stock material failed "+e);
		}
		return flag;
	}

	public boolean addTax(int iRowNo,String sTax) throws Exception{
		boolean flag = false;
		try{
			if(invoiceType.isDisplayed()){
				taxDropDown.click();
				taxSearch.sendKeys(sTax);
				driver.findElement(By.xpath(".//em[text()='"+sTax+"']")).click();
				addTax.click();
				String sNetCGST = netCGSTValue.getAttribute("value");
				String sNetSGST = netSGSTValue.getAttribute("value");
				String sNetIGST = netIGSTValue.getAttribute("value");
				Thread.sleep(Constant.Medium_Sleep);
				if(driver.findElement(By.xpath(".//b[contains(text(),'"+sTax+"')]")).isDisplayed()){
					String sTaxName = driver.findElement(By.xpath(".//th/b[contains(text(),'"+sTax+"')]/following::td[3]/input")).getAttribute("value");
					String sTotal = invoiceTotal.getAttribute("value");
					String sPercentTax = driver.findElement(By.xpath(".//th/b[contains(text(),'"+sTax+"')]/following::td[1]/input")).getAttribute("value");
					double dActTotal = Double.parseDouble(sTotal)+Double.parseDouble(sNetCGST)+Double.parseDouble(sNetSGST)+Double.parseDouble(sNetIGST);
					double dActTax = dActTotal*Double.parseDouble(sPercentTax)/100;
					double dRoundOff = Math.round(dActTax * 100.0) / 100.0;
					if(dRoundOff == Double.parseDouble(sTaxName)){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Tax addition failed "+e);
		}
		return flag;
	}

	public boolean removePackingCharges(){
		boolean flag = false;
		try{
			for(int i=0;i<hsnPackageList.size();i++){
				hsnPackageList.get(i).clear();
				unitRatePackageList.get(i).clear();
				unitRatePackageList.get(i).sendKeys("0");
				discountRatePackageList.get(i).clear();
				discountRatePackageList.get(i).sendKeys("0");
				Select selectSGST = new Select(sgstPackageList.get(i));
				Select selectCGST = new Select(cgstPackageList.get(i));
				Select selectIGST = new Select(igstPackageList.get(i));
				selectCGST.selectByVisibleText("--");
				selectSGST.selectByVisibleText("--");
				selectIGST.selectByVisibleText("--");
			}
		}catch(Exception e){
			System.err.println("Failed to remove packing charges "+e);
		}
		return flag;
	}

	public boolean packingNTransport(){
		boolean flag = false;
		try{
			for(int i=0;i<hsnPackageList.size();i++){
				hsnPackageList.get(i).sendKeys(sDate);
				unitRatePackageList.get(i).clear();
				unitRatePackageList.get(i).sendKeys("11.25");
				discountRatePackageList.get(i).clear();
				discountRatePackageList.get(i).sendKeys("2");
				unitRatePackageList.get(i).click();
				String sNetValue = netValuePackageList.get(i).getAttribute("value");
				double dDiscountValue = (11.25*2)/100;
				double dActAmount = 11.25 - dDiscountValue;
				double dRoundOff = Math.round(dActAmount * 100.0) / 100.0;
				if(dRoundOff == Double.parseDouble(sNetValue)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate packing and transport without gst "+e);
		}
		return flag;
	}

	public boolean packingNTransport_GST(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCGSTTax = xls.get(iRowNo).get("CGST");
		String sSGSTTax = xls.get(iRowNo).get("SGST");
		String sIGSTTax = xls.get(iRowNo).get("IGST");
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		try{
			for(int i=0;i<hsnPackageList.size();i++){
				hsnPackageList.get(i).sendKeys(sDate);
				unitRatePackageList.get(i).sendKeys(Keys.CONTROL+"a");
				unitRatePackageList.get(i).sendKeys(Keys.DELETE);
				unitRatePackageList.get(i).sendKeys("11.25");
				discountRatePackageList.get(i).sendKeys(Keys.CONTROL+"a");
				discountRatePackageList.get(i).sendKeys(Keys.DELETE);
				discountRatePackageList.get(i).sendKeys("2");
				if(!sInvoiceType.contains("BoS")){
					Select selectSGST = new Select(sgstPackageList.get(i));
					Select selectCGST = new Select(cgstPackageList.get(i));
					Select selectIGST = new Select(igstPackageList.get(i));
					selectCGST.selectByValue(sCGSTTax);
					selectSGST.selectByValue(sSGSTTax);
					selectIGST.selectByValue(sIGSTTax);
				}
				String sNetValue = netValuePackageList.get(i).getAttribute("value");
				double dDiscountValue = (11.25*2)/100;
				double dActAmount = 11.25 - dDiscountValue;
				double dRoundOff = Math.round(dActAmount * 100.0) / 100.0;
				if(dRoundOff == Double.parseDouble(sNetValue)){
					if(!sInvoiceType.contains("BoS")){
						String sIGSTValue = igstValuePackageList.get(i).getText();
						String sCGSTValue = cgstValuePackageList.get(i).getText();
						String sSGSTValue = sgstValuePackageList.get(i).getText();
						String sCGSTPercent = driver.findElement(By.id("id_invoice_charge_tax_"+i+"-0-rate")).getAttribute("value");
						String sSGSTPercent = driver.findElement(By.id("id_invoice_charge_tax_"+i+"-1-rate")).getAttribute("value");
						String sIGSTPercent = driver.findElement(By.id("id_invoice_charge_tax_"+i+"-2-rate")).getAttribute("value");
						double dCgst = Double.parseDouble(sNetValue)*Double.parseDouble(sCGSTPercent)/100;
						double dSgst = Double.parseDouble(sNetValue)*Double.parseDouble(sSGSTPercent)/100;
						double dIgst = Double.parseDouble(sNetValue)*Double.parseDouble(sIGSTPercent)/100;
						double dIGSTRoundOff = Math.round(dIgst * 100.0) / 100.0;
						double dCGSTRoundOff = Math.round(dCgst * 100.0) / 100.0;
						double dSGSTRoundOff = Math.round(dSgst * 100.0) / 100.0;
						if(dIGSTRoundOff == Double.parseDouble(sIGSTValue) && dCGSTRoundOff == Double.parseDouble(sCGSTValue) && dSGSTRoundOff == Double.parseDouble(sSGSTValue)){
							flag = true;
						}else{
							flag = false;
						}
					}else{
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to enter data in packaging and transport charges with gst "+e);
		}
		return flag;
	}

	public boolean UpdateInvoiceChangingCount(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCustomer = xls.get(iRowNo).get("Party");
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sOA = xls.get(iRowNo).get("Invoice with OA");
		String sProject = xls.get(iRowNo).get("Project");
		String sQtyRequired = xls.get(iRowNo).get("Qty to be Entered");
		String sMatCount = xls.get(iRowNo).get("Material Count");
		String sInvoice_DC = xls.get(iRowNo).get("Invoice with DC");
		String sInvoice,sDraftNo = null, sLinkedNum;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement ele;
		try{
			sInvoice = sInvoiceType.substring(0, 1);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int iBeforeAdd = invoices.size();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")));
			Thread.sleep(Constant.Min_Sleep);
			sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/span/span[2]/i"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sDraftNo+"')]")).isDisplayed()){
				sProject = invoiceProject.getText();
				if(sOA.contains("yes")){
					Constant.waitFor(ExpectedConditions.elementToBeClickable(oANoDropDwn), "Failed to load OA drop down");
					oANoDropDwn.click();
					if(oANolist.size() > 1){
						Thread.sleep(Constant.Min_Sleep);
						driver.findElement(By.xpath(".//div[@class='btn-group open']/button")).click();
						Thread.sleep(Constant.Min_Sleep);
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(addOAMaterials), "Failed to load sales view page");
					Thread.sleep(Constant.Min_Sleep);
					if(viewOAMaterilPopup.isDisplayed()){
						sLinkedNum = addDetailsViewMaterial(sQtyRequired, sMatCount);
						flag1 = validateLinkedNumber(sLinkedNum);
					}
				}
				if(sInvoice_DC.contains("yes")){
					Thread.sleep(Constant.Medium_Sleep);
					dcNoDropDwn.click();
					if(DcNoOptions.size() > 1){
						DcNoOptions.get(1).click();
						Thread.sleep(Constant.Min_Sleep);
					}
					dcNoDropDwn.click();
					Thread.sleep(Constant.Max_Sleep);
					sLinkedNum = addDetails_ItemsInvoiced(sQtyRequired, sMatCount);
					Thread.sleep(Constant.Min_Sleep);
					for (WebElement element : dcNoMaterialListGrid) {
						element.click();
					}
					flag1 = validateLinkedNumber(sLinkedNum);
				}
				if(sInvoiceType.contains("JIN")){
					flag1 = selectPartyDCNO(1, iRowNo, sheet);
				}
				Thread.sleep(Constant.Min_Sleep);
				if(!sInvoice_DC.contains("yes")){
					defaultGSTValue_material(iRowNo,sInvoice,sheet);
				}
				if(!(sInvoiceType.contains("DC") || sInvoiceType.contains("JDC") || sInvoiceType.contains("JIN"))){
					removePackingCharges();
					Thread.sleep(Constant.Min_Sleep);
				}
				RoundOff();
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
				String sGrandTotal = grandTotal.getAttribute("value");
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", save);
				Thread.sleep(Constant.Min_Sleep);
//				if(flag1 == true){
					save.click();
					Thread.sleep(Constant.Min_Sleep);
					if(Constant.isAlertPresents()){
						driver.switchTo().alert().accept();
						Thread.sleep(Constant.Min_Sleep);
					}
					boolean flag4 = Constant.isElementPresent(By.id("btn-sa-confirm"));
					if(flag4){
						okButton.click();
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
					navigate.showAllEntries();
					int iAfterAdd = invoices.size();
					js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td[2]/a")));
					Thread.sleep(Constant.Min_Sleep);
					sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td[2]/a")).getText();
					actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/a"))).perform();
					actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/span/span[2]/i"))).click().perform();
					Constant.waitForPageLoad();
					js.executeScript("window.scrollBy(0,-5000)");
					Thread.sleep(Constant.Min_Sleep);
					backBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td[2]/a")));
					Thread.sleep(Constant.Min_Sleep);
					if(sDraftNo.contains("PF")){
						ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a[contains(text(),'"+sDraftNo+"')]/following::td[contains(text(),'"+sInvoiceType+"')]/following::td[1][contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sCustomer+"')]/following::td[text()=' "+sGrandTotal+"']/following::td/a[text()='Pending']"));
					}else{
						ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a[contains(text(),'"+sDraftNo+"')]/following::td[contains(text(),'"+sInvoiceType+"')]/following::td[1][contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sCustomer+"')]/following::td[text()=' "+sGrandTotal+"']/following::td/a[text()='Approved']"));
					}
					if(ele.isDisplayed()){
						flag = true;
					}
//				}
			}
		}catch(Exception e){
			System.err.println("Unable to update invoice "+e);
		}
		return flag;
	}

	public boolean UpdateInvoiceChangingParty(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCustomer = xls.get(iRowNo).get("Party");
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sProject = xls.get(iRowNo).get("Project");
		String sDraftNo = null;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement ele;
		try{
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int iBeforeAdd = invoices.size();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")));
			Thread.sleep(Constant.Min_Sleep);
			sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/span/span[2]/i"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sDraftNo+"')]")).isDisplayed()){
				customerDropDwn.click();
				customerText.sendKeys(sCustomer);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
				if(sInvoiceType.contains("JIN")){
					flag1 = selectPartyDCNO(0, iRowNo, sheet);
				}
				RoundOff();
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
				String sGrandTotal = grandTotal.getAttribute("value");
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", save);
				Thread.sleep(Constant.Min_Sleep);
//				if(flag1 == true){
					save.click();
					Thread.sleep(Constant.Min_Sleep);
					if(Constant.isAlertPresents()){
						driver.switchTo().alert().accept();
						Thread.sleep(Constant.Min_Sleep);
					}
					boolean flag4 = Constant.isElementPresent(By.id("btn-sa-confirm"));
					if(flag4){
						okButton.click();
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
					navigate.showAllEntries();
					int iAfterAdd = invoices.size();
					js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td[2]/a")));
					Thread.sleep(Constant.Min_Sleep);
					sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td[2]/a")).getText();
					actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td[9]/a"))).perform();
					actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td[9]/span/span[2]/i"))).click().perform();
					Constant.waitForPageLoad();
					js.executeScript("window.scrollBy(0,-5000)");
					Thread.sleep(Constant.Min_Sleep);
					backBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td[2]/a")));
					Thread.sleep(Constant.Min_Sleep);
					if(sDraftNo.contains("PF")){
						ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a[contains(text(),'"+sDraftNo+"')]/following::td[contains(text(),'"+sInvoiceType+"')]/following::td[1][contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sCustomer+"')]/following::td[text()=' "+sGrandTotal+"']/following::td/a[text()='Pending']"));
					}else{
						ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a[contains(text(),'"+sDraftNo+"')]/following::td[contains(text(),'"+sInvoiceType+"')]/following::td[1][contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sCustomer+"')]/following::td[text()=' "+sGrandTotal+"']/following::td/a[text()='Approved']"));
					}
					if(ele.isDisplayed()){
						flag = true;
					}
//				}
			}
		}catch(Exception e){
			System.err.println("Unable to update invoice "+e);
		}
		return flag;
	}

	public boolean validatePendingQty(int iRowNo, String sheet){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sQuantity = xls.get(iRowNo).get("Quantity");
		boolean flag = false;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			int iBeforeAdd = invoices.size();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")));
			Thread.sleep(Constant.Min_Sleep);
			String sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/span/span[2]/i"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sDraftNo+"')]")).isDisplayed()){
				partyDcNoDropDwn.click();
				Thread.sleep(Constant.Min_Sleep);
				partyDcNoDropDwn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(addOAMaterials), "Failed to load sales view page");
				if(viewGRNMaterialsPopup.isDisplayed()){
					for(int i=0;i<hsnCodeOA.size();i++){
						String[] count = pendingOAQty.get(i).getText().split("\\s");
						if(count[0].contains(Integer.toString(Integer.parseInt(sQuantity)-5))){
							flag = true;
							break;
						}else{
							flag = false;
						}
					}
					addOAMaterials.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate pending qty "+e);
		}
		return flag;
	}

	public boolean validateLinkedNumber(String sLinkedNum){
		boolean flag = false;
		try{
			for (WebElement element : oaNoMaterialListGrid) {
				if(sLinkedNum.contains(element.getText())){
					flag = true;
					break;
				}else if(element.getText().contains(sLinkedNum)){
					flag = true;
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate linked number "+e);
		}
		return flag;
	}

	public boolean updateInvoicewithNewMaterial(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCustomer = xls.get(iRowNo).get("Party");
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sTax = xls.get(iRowNo).get("Tax");
		String sProject = xls.get(iRowNo).get("Project");
		String sInvoice_DC = xls.get(iRowNo).get("Invoice with DC");
		String sDraftNo = null;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			int iBeforeAdd = invoices.size();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")));
			Thread.sleep(Constant.Min_Sleep);
			sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/span/span[2]/i"))).click().perform();
			Constant.waitForPageLoad();
			if(!sInvoice_DC.contains("yes")){
				addMaterialDetails(iRowNo,sMaterial,sheet, sTax);
			}else{
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<cgst_InvoiceDC.size();i++){
					addCGSTTax_InvoiceDC(iRowNo, i, sheet);
					addSGSTTax_InvoiceDC(iRowNo, i, sheet);
					addIGSTTax_InvoiceDC(iRowNo, i, sheet);
				}
				packingNTransport_GST(iRowNo, sheet);
			}
 			if(!(sInvoiceType.contains("DC")) && !(sInvoiceType.contains("JDC"))){
				RoundOff();
			}
			String sGrandTotal = grandTotal.getAttribute("value");
			js.executeScript("arguments[0].scrollIntoView(true);", save);
			Thread.sleep(Constant.Min_Sleep);
			save.click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.isAlertPresents()){
				driver.switchTo().alert().accept();
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")));
			Thread.sleep(Constant.Min_Sleep);
			sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")).getText();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/span/span[2]/i"))).click().perform();
			Constant.waitForPageLoad();
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			sProject = invoiceProject.getText();
			backBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")));
			Thread.sleep(Constant.Min_Sleep);
			WebElement ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a[contains(text(),'"+sDraftNo+"')]/following::td[contains(text(),'"+sInvoiceType+"')]/following::td[1][contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sCustomer+"')]/following::td[text()=' "+sGrandTotal+"']/following::td/a[text()='Pending']"));
			if(ele.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Unable to update DC/Invoice by adding material "+e);
		}
		return flag;
	}

	public boolean deleteItem(int iRowNo, String sheet) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCustomer = xls.get(iRowNo).get("Party");
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sTax = xls.get(iRowNo).get("Tax");
		String sProject = xls.get(iRowNo).get("Project");
		String sInvoice,sDraftNo = null;
		boolean flag = false;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement ele;
		try{
			sInvoice = sInvoiceType.substring(0, 1);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int iBeforeAdd = invoices.size();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")));
			Thread.sleep(Constant.Min_Sleep);
			sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/span/span[2]/i"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			actions.moveToElement(firstMatSNO).perform();
			actions.moveToElement(firstMatDelete).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			yesDelete.click();
			Thread.sleep(Constant.Min_Sleep);
			if(!sInvoice.contains("B") && !sInvoice.contains("D") && !sInvoiceType.contains("JIN")){
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				deleteTax.click();
				addMaterialDetails(iRowNo,sMaterial,sheet, sTax);
				RoundOff();
			}else if(!sInvoiceType.contains("JIN")){
				addMaterialDetails(iRowNo,sMaterial,sheet, sTax);
			}
			if(sInvoiceType.contains("JIN")){
				flag = selectPartyDCNO(1, iRowNo, sheet);
			}
			String sGrandTotal = grandTotal.getAttribute("value");
			js.executeScript("arguments[0].scrollIntoView(true);", save);
			Thread.sleep(Constant.Min_Sleep);
			save.click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.isAlertPresents()){
				driver.switchTo().alert().accept();
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")));
			Thread.sleep(Constant.Min_Sleep);
			sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")).getText();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/span/span[2]/i"))).click().perform();
			Constant.waitForPageLoad();
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			sProject = invoiceProject.getText();
			backBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/a")));
			Thread.sleep(Constant.Min_Sleep);
			if(sDraftNo.contains("PF")){
				ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a[contains(text(),'"+sDraftNo+"')]/following::td[contains(text(),'"+sInvoiceType+"')]/following::td[1][contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sCustomer+"')]/following::td[text()=' "+sGrandTotal+"']/following::td/a[text()='Pending']"));
			}else{
				ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a[contains(text(),'"+sDraftNo+"')]/following::td[contains(text(),'"+sInvoiceType+"')]/following::td[1][contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sCustomer+"')]/following::td[text()=' "+sGrandTotal+"']/following::td/a[text()='Approved']"));
			}
			if(ele.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Unable to delete item and updated "+e);
		}
		return flag;
	}

	public void defaultGSTValue_material(int iRowNo, String sInvoice, String sheet) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReturn = xls.get(iRowNo).get("DC with Return");
		try{
			boolean flag = Constant.isElementPresent(By.id("id_invoice_mat-0-hsn_code"));
			if(flag){
	   			addedStockHSN.clear();
				addedStockHSN.sendKeys(sDate);
				addedStockRate.sendKeys(Keys.CONTROL+"a");
				addedStockRate.sendKeys(Keys.DELETE);
				addedStockRate.sendKeys("45.23");
				addedStockDiscount.sendKeys(Keys.CONTROL+"a");
				addedStockDiscount.sendKeys(Keys.DELETE);
				addedStockDiscount.sendKeys("11.25");
				if(!sInvoice.contains("B")){
					Constant.waitFor(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("id_inv_mat_tax_0-0-rate_drop_down"))), "Failed to load gst drop down");
					Select selectCGST = new Select(driver.findElement(By.id("id_inv_mat_tax_0-0-rate_drop_down")));
					selectCGST.selectByVisibleText("--");
					Select selectSGST = new Select(driver.findElement(By.id("id_inv_mat_tax_0-1-rate_drop_down")));
					selectSGST.selectByVisibleText("--");
					Select selectIGST = new Select(driver.findElement(By.id("id_inv_mat_tax_0-2-rate_drop_down")));
					selectIGST.selectByVisibleText("--");
					Thread.sleep(Constant.Medium_Sleep);
				}
				if(sReturn.equals("yes")){
					driver.findElement(By.id("id_invoice_mat-0-is_returnable")).click();
				}
			}
		}catch(Exception e){
			System.err.println("Default value for GST selection failed "+e);
		}
	}

	public boolean validateApproveInvoice(int iRowNo,String sheet, String sPoNo) throws Exception{
		boolean flag = false;
		try{
			addInvoice(iRowNo,sheet, sPoNo);
			flag = approveInvoice();
		}catch(Exception e){
			System.err.println("unable to approve the invoice "+e);

		}
		return flag;
	}

	public boolean approveInvoice() throws Exception{
		boolean flag = false;
		String sStatus = null, sInvoices = null;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			sInvoices = Integer.toString(invoices.size());
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/a")));
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/span/span[1]/i"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/span/span[1]/i"))).click().perform();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(approveInvoice), "Failed to load sales pdf popup");
			Constant.waitForPageLoad();
			if(salesPDF.isDisplayed()){
				approveInvoice.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load sales pdf popup");
				Thread.sleep(Constant.Min_Sleep);
				okButton.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				pDfBackBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]")));
				sStatus = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]")).getText();
				String sInvoiceNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[2]/a")).getText();
				actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/a"))).perform();
				actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/span/span[2]/i"))).click().perform();
				Thread.sleep(Constant.Min_Sleep);
				String sActInvoiceNo = invoiceNoEditPage.getText();
				String IssueDate = invoiceDateTimeAfterApprove.getText();
				if(sStatus.contains("Approved") && IssueDate.contains(sCurrentDate)
						&& sActInvoiceNo.contains(sInvoiceNo)){
					flag = true;
				}
				js.executeScript("window.scrollBy(0,-5000)");
				Constant.waitFor(ExpectedConditions.elementToBeClickable(backBtn), "Failed to load sales pdf popup");
				backBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			}
		}catch(Exception e){
			System.err.println("unable to approve the invoice "+e);

		}
		return flag;
	}

	public boolean rejectDraftInvoice(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			int iBeforeAdd = invoices.size();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/a")));
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/span/span[1]/i"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[9]/span/span[1]/i"))).click().perform();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(rejectInvoice), "Failed to load sales pdf");
			Thread.sleep(Constant.Min_Sleep);
			if(salesPDF.isDisplayed()){
				remarks.sendKeys("Testing"+sDate);
				rejectInvoice.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load sales view page");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
				navigate.showAllEntries();
				int iAfterDelte = invoices.size();
				if(iAfterDelte < iBeforeAdd){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Unable to reject drafted invoice "+e);
		}
		return flag;
	}

	public boolean validateRejectDraftInvoice(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addInvoice(iRowNo,sheet, null);
			flag = rejectDraftInvoice(iRowNo,sheet);
		}catch(Exception e){
			System.err.println("Unable to reject drafted invoice "+e);
		}
		return flag;
	}

	public boolean validateRejectApprovedInvoice(int iRowNo, String sheet, String sIssueNo) throws Exception{
		boolean flag = false;
		try{
			validateApproveInvoice(iRowNo, sheet, sIssueNo);
			flag = rejectApprovedInvoice(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Unable to reject approved invoice "+e);
		}
		return flag;
	}

	public boolean rejectApprovedInvoice(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		String sStatus = null, sInvoices = null;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			navigate.showAllEntries();
			sInvoices = Integer.toString(invoices.size());
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/a")));
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/span/span[1]/i"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/span/span[1]/i"))).click().perform();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(rejectInvoice), "Failed to load sales pdf popup");
			Thread.sleep(Constant.Min_Sleep);
			if(salesPDF.isDisplayed()){
				remarks.sendKeys("Testing"+sDate);
				rejectInvoice.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load sales pdf popup");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				pDfBackBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]")));
				sStatus = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]")).getText();
				if(sStatus.contains("Cancelled")){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Unable to reject approved invoice "+e);
		}
		return flag;
	}

	public boolean addOA(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1, flag2, flag3, flag4;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sType = xls.get(iRowNo).get("OA Type");
		try{
			navigate.showAllEntries();
			int sOAActualList = oaList.size();
			oaAddBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			Select select = new Select(oaType);
			select.selectByValue(sType);
			oaPartyDropDwn.click();
			oaPartySearchTxt.sendKeys(sParty);
			driver.findElement(By.xpath(".//em[text()='"+sParty+"']")).click();
			flag1 = addStockMaterialOA(iRowNo, sheet);
			addOADetails();
			flag3 = addOATax(iRowNo, sheet);
			flag2 = validateAmountColumn();
			flag4 = validateGrandTotal();
			if(flag1 && flag2 && flag3 && flag4){
				String sGrandTotal = oaGrandTotal.getText();
				oaSave.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				int sOAList = oaList.size();
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].scrollIntoView(true);", oaList.get(sOAList-1));
				Thread.sleep(Constant.Min_Sleep);
				WebElement ele = driver.findElement(By.xpath(".//tr["+sOAList+"]/td[2]/a[contains(text(),'PF')]/following::td[contains(text(),'"+sType+"')]"
						+ "/following::td[contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sParty+"')]/following::td[contains(text(),'"+sGrandTotal+"')]/following::td/a[contains(text(),'Pending')]"));
				if(sOAList > sOAActualList && ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add OA "+e);
		}
		return flag;
	}

	public void addOADetails() throws Exception{
		try{
			oaPONo.sendKeys(sDate);
			oaQuotationDateField.click();
			selectPrevMnth.click();
			selectDate.click();
			oaDueDateField.click();
			selectNxtMnth.click();
			selectDate.click();
			oaPaymentTerms.sendKeys("cash");
			oaSpecialInstruc.sendKeys("Oa special instruction-automation "+sDate);
			if(attachmentRemove.isDisplayed()){
				attachmentRemove.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			uploadOADocument.click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.attachFile();
//			Runtime.getRuntime().exec("E:\\ExpenseBillUpload.exe");//execute AutoIT to upload import file
			Thread.sleep(Constant.Min_Sleep);
			documentDesc.sendKeys("Document "+sDate);
			oaRemarks.sendKeys("OA remarks "+sDate);
		}catch(Exception e){
			System.err.println("Failed to add OA "+e);
		}
	}

	public boolean addOATax(int iRowNo,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("Tax");
		try{
			oaTaxDD.click();
			Thread.sleep(Constant.Min_Sleep);
			oaSearchField.sendKeys(sTax);
			driver.findElement(By.xpath(".//em[text()='"+sTax+"']")).click();
			addOATax.click();
			Thread.sleep(Constant.Min_Sleep);
			for (WebElement element : addedTax) {
				if(element.getText().contains(sTax)){
					flag = true;
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Unable to add tax "+e);
		}
		return flag;
	}

	public boolean addStockMaterialOA(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sPrice = xls.get(iRowNo).get("Price");
		String sQty = xls.get(iRowNo).get("Quantity");
		String sDiscount = xls.get(iRowNo).get("Discount");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		try{
			String[] sMaterialList = sMaterial.split(",");
			for (String element : sMaterialList) {
				oaStockMaterialTextField.sendKeys(element);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//ul/li/a[contains(text(),'"+element+"')]")).click();
				if(sAltUnit.contains("Yes")){
					altUnitDrpDwnOa.click();
					altUnitOptionOA.click();
				}
				if(materialDesc.getText().isEmpty()){
					oaStockRemarks.sendKeys("Remark"+sDate);
				}else{
					oaStockRemarks.sendKeys(materialDesc.getText());
				}
				Thread.sleep(Constant.Min_Sleep);
				if(oaStockHSNTextField.getAttribute("value").isEmpty() || oaStockHSNTextField.getAttribute("value").matches(".*[a-zA-Z]+.*")){
					oaStockHSNTextField.sendKeys(Keys.CONTROL+"a");
					oaStockHSNTextField.sendKeys(Keys.DELETE);
					oaStockHSNTextField.sendKeys("HSN"+sDate);
				}
				if(oaStockPrice.getAttribute("value").equals("0")){
					oaStockPrice.sendKeys(Keys.CONTROL+"a");
					oaStockPrice.sendKeys(Keys.DELETE);
					oaStockPrice.sendKeys(sPrice);
				}
				oaStockQty.sendKeys(Keys.CONTROL+"a");
				oaStockQty.sendKeys(Keys.DELETE);
				oaStockQty.sendKeys(sQty);
				oaDiscountQty.sendKeys(Keys.CONTROL+"a");
				oaDiscountQty.sendKeys(Keys.DELETE);
				oaDiscountQty.sendKeys(sDiscount);
				oaAddStockMaterial.click();
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
			}
			for(int j = 0;j<addedStockMaterialList.size()-1;j++){
				if(addedStockMaterialList.get(j).getAttribute("value").contains(sMaterialList[j])){
					flag = true;
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add stock materials in OA "+e);
		}
		return flag;
	}

	public boolean validateAmountColumn(){
		boolean flag = false;
		Double dUnitPrice = null;
		try{
			for(int i=0;i<oaAmountList.size()-2;i++){
				String sQty = oaQuantityList.get(i).getAttribute("value");
				String sPrice = oaPriceList.get(i).getAttribute("value");
				String sAmount = oaAmountList.get(i).getAttribute("value");
				String sDiscount = oaDiscountList.get(i).getAttribute("value");
				double totalPrice = Double.parseDouble(sQty) * Double.parseDouble(sPrice);
				totalPrice = totalPrice - (totalPrice * Double.parseDouble(sDiscount) / 100);
				dUnitPrice = Math.round(totalPrice * 100.0) / 100.0;
				if(Double.parseDouble(sAmount) == dUnitPrice){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("OA Amount column validation "+e);
		}
		return flag;
	}

	public boolean validateGrandTotal(){
		boolean flag = false;
		ArrayList<String> tax = new ArrayList<>();
		ArrayList<String> sTotal = new ArrayList<>();
		List<Double> arrayOfTax = new ArrayList<>();
		List<Double> arrayOfTotal = new ArrayList<>();
		double sumTax = 0,sumTotal = 0;
		try{
			for(int i=0;i<oaAmountList.size()-1;i++){
				sTotal.add(oaAmountList.get(i).getAttribute("value"));
				arrayOfTotal.add(Double.parseDouble(sTotal.get(i)));
				sumTotal += arrayOfTotal.get(i);
			}
			for(int i=0;i<oaTaxList.size();i++){
				tax.add(oaTaxList.get(i).getAttribute("value"));
				arrayOfTax.add(Double.parseDouble(tax.get(i)));
				sumTax += arrayOfTax.get(i);
			}
			String sGrandTotal = oaGrandTotal.getText();
			double Total = sumTax+sumTotal;
			double roundOff = Math.round(Total * 100.0) / 100.0;
			if(roundOff == Double.parseDouble(sGrandTotal)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("OA Grand total validation "+e);
		}
		return flag;
	}

	public boolean updateOA(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sType = xls.get(iRowNo).get("OA Type");
		int sOAActualList, i;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			addOA(iRowNo, sheet);
			sOAActualList = oaList.size();
			js.executeScript("arguments[0].scrollIntoView(true);", oaList.get(sOAActualList-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(oaList.get(sOAActualList-1)).perform();
			js.executeScript("arguments[0].click();", oaList.get(sOAActualList-1));
			i = sOAActualList-1;
			Thread.sleep(Constant.Min_Sleep);
			Select select = new Select(oaType);
			select.selectByValue(sType);
			oaSpecialInstruc.sendKeys("Oa updated special instruction-automation "+sDate);
			js.executeScript("window.scrollBy(0,-5000)");
			oaPartyDropDwn.click();
			oaPartySearchTxt.sendKeys(sParty);
			driver.findElement(By.xpath(".//em[text()='"+sParty+"']")).click();
			addStockMaterialOA(iRowNo, sheet);
			addOADetails();
			addOATax(iRowNo, sheet);
			String sGrandTotal = oaGrandTotal.getText();
			oaSave.click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.isAlertPresents()){
				driver.switchTo().alert().accept();
			}
			Constant.waitFor(ExpectedConditions.visibilityOf(okBtn), "Failed to load GRN view page");
			Thread.sleep(Constant.Min_Sleep);
			okBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int sOAList = oaList.size();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tr["+(i+1)+"]/td[2]/a[contains(text(),'PF')]")));
			WebElement ele = driver.findElement(By.xpath(".//tr["+(i+1)+"]/td[2]/a[contains(text(),'PF')]/following::td[contains(text(),'"+sType+"')]"
					+ "/following::td[3][contains(text(),'"+sParty+"')]/following::td[contains(text(),'"+sGrandTotal+"')]/following::td/a[contains(text(),'Pending')]"));
			if(sOAList == sOAActualList && ele.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to update Oa "+e);
		}
		return flag;
	}

	public boolean validateMatListOaEditPge(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String[] sMaterialList = sMaterial.split(",");
		try{
			for(int i=1;i<matListEditPge.size()-1;i++){
				if(matListEditPge.get(i).getAttribute("value").contains(sMaterialList[i-1])){
					flag = true;
				}else{
					flag = false;
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate material list in oa edit page"+e);
		}
		return flag;
	}

	public boolean updateOA_DeleteMat(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sType = xls.get(iRowNo).get("OA Type");
		int sOAActualList, i;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			sOAActualList = oaList.size();
			js.executeScript("arguments[0].scrollIntoView(true);", oaList.get(sOAActualList-1));
			oaList.get(sOAActualList-1).click();
			i = sOAActualList-1;
			Thread.sleep(Constant.Min_Sleep);
			deleteMatList.get(1).click();
			Thread.sleep(Constant.Min_Sleep);
			okButton.click();
			Thread.sleep(Constant.Min_Sleep);
			String sGrandTotal = oaGrandTotal.getText();
			oaSave.click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.isAlertPresents()){
				driver.switchTo().alert().accept();
			}
			Constant.waitFor(ExpectedConditions.visibilityOf(okBtn), "Failed to load GRN view page");
			Thread.sleep(Constant.Min_Sleep);
			okBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int sOAList = oaList.size();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tr["+(i+1)+"]/td[2]/a[contains(text(),'PF')]")));
			WebElement ele = driver.findElement(By.xpath(".//tr["+(i+1)+"]/td[2]/a[contains(text(),'PF')]/following::td[contains(text(),'"+sType+"')]"
					+ "/following::td[3][contains(text(),'"+sParty+"')]/following::td[contains(text(),'"+sGrandTotal+"')]/following::td/a[contains(text(),'Pending')]"));
			if(sOAList == sOAActualList && ele.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to update Oa "+e);
		}
		return flag;
	}
	public boolean approveOA(int iRowNo, String sheet){
		boolean flag = false;
		String sStatus, sOANumber;
		int i;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			i = oaList.size()-1;
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", oaList.get(i-1));
			Thread.sleep(Constant.Min_Sleep);
			Actions actions = new Actions(driver);
			actions.moveToElement(oaStatus.get(i)).perform();
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//tr["+(i+1)+"]/td[8]/span[@data-original-title='Preview']")));
			Constant.waitFor(ExpectedConditions.elementToBeClickable(oaApprove), "Failed to load sales view page");
			if(salesPDF.isDisplayed()){
				oaApprove.click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				pDfBackBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", oaList.get(i-1));
				oaList.get(i).click();
				Thread.sleep(Constant.Min_Sleep);
				String IssueDate = oaDate.getText();
 				String sOaNo = oaNo.getText();
 				oaCancelBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", oaList.get(i-1));
 				sStatus = oaStatus.get(i).getText();
				sOANumber = oaList.get(i).getText();
				String sOaDate = oaDateList.get(i).getText();
				if(sStatus.contains("Approved") && IssueDate.contains(sOaDate) && sOANumber.equals(sOaNo)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to approve Oa "+e);
		}
		return flag;
	}

	public boolean validateApproveOA(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addOA(iRowNo, sheet);
			flag = approveOA(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Failed to update Oa "+e);
		}
		return flag;
	}

	public boolean rejectApprovedOA(int iRowNo, String sheet){
		boolean flag = false;
		String sStatus, sOANumber;
		int sOAActualList;
		try{
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			sOAActualList = oaList.size();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", oaList.get(sOAActualList-1));
			Thread.sleep(Constant.Min_Sleep);
			Actions actions = new Actions(driver);
			actions.moveToElement(oaList.get(sOAActualList-1)).perform();
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//tr["+(sOAActualList)+"]/td[8]/span[@data-original-title='Preview']")));
			Constant.waitFor(ExpectedConditions.elementToBeClickable(oaRejectBtn), "Failed to load sales view page");
			if(salesPDF.isDisplayed()){
				remarks.sendKeys("Rejecting for automation testing "+sDate);
				oaRejectBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				pDfBackBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", oaList.get(sOAActualList-1));
				Thread.sleep(Constant.Min_Sleep);
				sStatus = oaStatus.get(sOAActualList-1).getText();
				sOANumber = oaList.get(sOAActualList-1).getText();
				oaList.get(sOAActualList-1).click();
				Thread.sleep(Constant.Min_Sleep);
 				String sOaNo = oaNo.getText();
 				boolean flag1 = Constant.isElementPresent(By.id("amend_oa"));
 				if(sStatus.contains("Cancelled") && sOANumber.equals(sOaNo) && flag1){
					flag = true;
				}
				oaCancelBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved Oa "+e);
		}
		return flag;
	}

	public boolean validateRejectApprovedOA(int iRowNo, String sheet){
		boolean flag = false;
		try{
			validateApproveOA(iRowNo, sheet);
			flag = rejectApprovedOA(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Failed to reject approved Oa "+e);
		}
		return flag;
	}

	public boolean rejectDraftOA(int iRowNo, String sheet){
		boolean flag = false;
		int sOAActualList;
		try{
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			sOAActualList = oaList.size();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", oaList.get(sOAActualList-1));
			Thread.sleep(Constant.Min_Sleep);
			Actions actions = new Actions(driver);
			actions.moveToElement(oaList.get(sOAActualList-1)).perform();
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//tr["+(sOAActualList)+"]/td[8]/span[@data-original-title='Preview']")));
			Constant.waitFor(ExpectedConditions.elementToBeClickable(oaRejectBtn), "Failed to load pdf popup");
			if(salesPDF.isDisplayed()){
				remarks.sendKeys("Rejecting for automation testing "+sDate);
				oaRejectBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				int sOAList = oaStatus.size();
 				if(sOAList < sOAActualList){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to reject draft Oa "+e);
		}
		return flag;
	}

	public boolean validateRejectDraftOA(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addOA(iRowNo, sheet);
			flag = rejectDraftOA(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Failed to reject draft Oa "+e);
		}
		return flag;
	}

	public boolean amendOA(int iRowNo, String sheet){
		boolean flag = false;
		int i, sOAActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			validateRejectApprovedOA(iRowNo, sheet);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			sOAActualList = oaStatus.size();
			js.executeScript("arguments[0].scrollIntoView(true);", oaList.get(sOAActualList-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(oaList.get(sOAActualList-1)).perform();
			js.executeScript("arguments[0].click();", oaList.get(sOAActualList-1));
			Thread.sleep(Constant.Min_Sleep);
			i = sOAActualList-1;
			if(!(oaType.isSelected() && oaPartyDropDwn.isSelected())){
				addStockMaterialOA(iRowNo, sheet);
				Thread.sleep(Constant.Min_Sleep);
				addOADetails();
				addOATax(iRowNo, sheet);
				String sGrandTotal = oaGrandTotal.getText();
				String sOaNo = oaNo.getText();
				oaSpecialInstruc.sendKeys("Oa amend special instruction-automation "+sDate);
				oaAmendBtn.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(okButton), "Failed to load GRN view page");
				Thread.sleep(Constant.Min_Sleep);
				okButton.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tr["+(i+1)+"]/td[2]/a[contains(text(),'"+sOaNo+"')]")));
				int sOAList = oaList.size();
				WebElement ele = driver.findElement(By.xpath(".//tr["+(i+1)+"]/td[2]/a[contains(text(),'"+sOaNo+"')]/following::td[5][contains(text(),'"+sGrandTotal+"')]/following::td/a[contains(text(),'Approved')]"));
				if(sOAList == sOAActualList && ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to amend Oa "+e);
		}
		return flag;
	}

	public boolean verifyInvoiceComponents(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			if(invoicePage.isDisplayed() && dateCalendarDrpDown.isDisplayed() && partyName.isDisplayed()
					&& projectDropDwn.isDisplayed() && statusField.isDisplayed() && filterTextbox.isDisplayed()){
				addIcon.click();
				Thread.sleep(Constant.Min_Sleep);
				if(invoiceType.isDisplayed() && customerDropDwn.isDisplayed()
						&& pONo.isDisplayed() && invoiceProject.isDisplayed() && salesAcctDropDwn.isDisplayed()
						&& poDateField.isDisplayed() && oaNoDropDwn.isDisplayed() && transportMode.isDisplayed()
						&& roadPermitNo.isDisplayed() && packingSlipNo.isDisplayed() && invoiceRemarks.isDisplayed() && backBtn.isDisplayed()
						&& lorryNo.isDisplayed() && paymenyTerms.isDisplayed() && specialInst.isDisplayed() && deliverTo.isDisplayed()
						&& materialReq.isDisplayed() && faultyCheckBX.isDisplayed() && hSNCodeStock.isDisplayed() && quantityStock.isDisplayed()
						&& rate_Stock.isDisplayed() && discountStock.isDisplayed() && netValueForStock.isDisplayed() && remarksStock.isDisplayed()
						&& addInvoiceItem.isDisplayed() && taxDropDown.isDisplayed() && currencyField.isDisplayed() && save.isDisplayed()
						&& roundOff.isDisplayed() && grandTotal.isDisplayed() && addTax.isDisplayed()
						&& invoiceNewPage.isDisplayed()){
					flag = Constant.verifyColumnOrder(invoiceMaterialsTable,sColumn);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate invoice components "+e);
		}
		return flag;
	}

	/**
	 * To validate net value after adding stock material
	 * @param iRowNo
	 * @return true, when net value is correct after material is added
	 * @throws Exception
	 */

	public boolean netValue_StockMaterial(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");//To scroll to the bottom of the page
			Thread.sleep(Constant.Min_Sleep);
			flag = addStockMaterial(iRowNo,sMaterial,sAltUnit);
		}catch(Exception e){
			System.err.println("Net value validation for stock material failed "+e);
		}
		return flag;
	}

	public boolean AddedStockMaterial(int iRowNo,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(Constant.Min_Sleep);
			addStockMaterial(iRowNo,sMaterial, sAltUnit);
			String sUnit = units.getAttribute("value");
			String sRate = rate_Stock.getAttribute("value");
			String sStockvalue = netValueForStock.getAttribute("value");
			String sHSN = hSNCodeStock.getAttribute("value");
			addInvoiceItem.click();
			if(addedStockMaterial.getAttribute("value").contains(sMaterial) && addedStockHSN.getAttribute("value").contains(sHSN) && addedStockQTY.getAttribute("value").contains("10")
					&& addedStockUnit.getAttribute("value").contains(sUnit) && addedStockRate.getAttribute("value").contains(sRate)
					&& addedStockDiscount.getAttribute("value").contains("12.45") && addedStockAmountStock.getAttribute("value").contains(sStockvalue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Material with stock addition failed "+e);
		}
		return flag;
	}

	public boolean deleteAddedStockNNonStockMat(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			addStockMaterial(iRowNo,sMaterial, sAltUnit);
			addInvoiceItem.click();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			deleteAddedStockMat.click();
			Thread.sleep(Constant.Min_Sleep);
			yesDelete.click();
			Thread.sleep(Constant.Min_Sleep);
			Thread.sleep(Constant.Min_Sleep);
			save.click();
			Thread.sleep(Constant.Min_Sleep);
			if(addAtleast1MatPopUp.isDisplayed()){
				okButton.click();
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to delete added stock and non stock material "+e);
		}
		return flag;
	}

	public boolean validateTax(int iRowNo,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sTax = xls.get(iRowNo).get("Tax");
		try{
			AddedStockMaterial(iRowNo,sheet);
			addCGSTTax_Stock(iRowNo,0,sheet);
			addSGSTTax_Stock(iRowNo,0,sheet);
			addIGSTTax_Stock(iRowNo,0,sheet);
			flag = addTax(iRowNo,sTax);
		}catch(Exception e){
			System.err.println("Tax vaildation failed "+e);
		}
		return flag;
	}

	public boolean validateCGST(int iRowNo,String sheet){
		boolean flag = false;
		try{
			AddedStockMaterial(iRowNo,sheet);
			Thread.sleep(Constant.Min_Sleep);
			flag = addCGSTTax_Stock(iRowNo,0,sheet);
		}catch(Exception e){
			System.err.println("CGST validation failed "+e);
		}
		return flag;
	}

	public boolean validateSGST(int iRowNo,String sheet){
		boolean flag = false;
		try{
			AddedStockMaterial(iRowNo,sheet);
			Thread.sleep(Constant.Min_Sleep);
			flag = addSGSTTax_Stock(iRowNo,0,sheet);
		}catch(Exception e){
			System.err.println("SGST validation failed "+e);
		}
		return flag;
	}

	public boolean validateIGST(int iRowNo,String sheet){
		boolean flag = false;
		try{
			AddedStockMaterial(iRowNo,sheet);
			Thread.sleep(Constant.Min_Sleep);
			flag = addIGSTTax_Stock(iRowNo,0,sheet);
		}catch(Exception e){
			System.err.println("SGST validation failed "+e);
		}
		return flag;
	}

	public boolean validateTaxPercentage(int iRowNo,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sTax = xls.get(iRowNo).get("Tax");
		String sCGSTTax = xls.get(iRowNo).get("CGST");
		String sSGSTTax = xls.get(iRowNo).get("SGST");
		String sIGSTTax = xls.get(iRowNo).get("IGST");
		try{
			AddedStockMaterial(iRowNo,sheet);
			Thread.sleep(Constant.Min_Sleep);
			addTax(iRowNo,sTax);
			addCGSTTax_Stock(iRowNo,0,sheet);
			addSGSTTax_Stock(iRowNo,0,sheet);
			addIGSTTax_Stock(iRowNo,0,sheet);
			String sPercentTax = driver.findElement(By.xpath(".//th/b[contains(text(),'"+sTax+"')]/following::td[1]/input")).getAttribute("value");
			String sPercentCGST = driver.findElement(By.id("id_inv_mat_tax_0-0-rate")).getAttribute("value");
			String sPercentSGST = driver.findElement(By.id("id_inv_mat_tax_0-1-rate")).getAttribute("value");
			String sPercentIGST = driver.findElement(By.id("id_inv_mat_tax_0-2-rate")).getAttribute("value");
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToTax();
			Thread.sleep(Constant.Min_Sleep);
			filterTextbox.sendKeys(sTax);
			String sTaxName = driver.findElement(By.xpath(".//mark[contains(text(),'"+sTax+"')]/following::td[1]")).getText();
			filterTextbox.clear();
			filterTextbox.sendKeys(sCGSTTax);
			String sCgstTax = driver.findElement(By.xpath(".//mark[contains(text(),'"+sCGSTTax+"')]/following::td[3][@align='right']")).getText();
			filterTextbox.clear();
			filterTextbox.sendKeys(sSGSTTax);
			String sSgstTax = driver.findElement(By.xpath(".//mark[contains(text(),'"+sSGSTTax+"')]/following::td[3][@align='right']")).getText();
			filterTextbox.clear();
			filterTextbox.sendKeys(sIGSTTax);
			String sIgstTax = driver.findElement(By.xpath(".//mark[contains(text(),'"+sIGSTTax+"')]/following::td[3][@align='right']")).getText();
			if(sTaxName.contains(sPercentTax) && sCgstTax.contains(sPercentCGST) && sSgstTax.contains(sPercentSGST) && sIgstTax.contains(sPercentIGST)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Tax percentage validation failed "+e);
		}
		return flag;
	}

	public boolean validategrandTotal(int iRowNo,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sTax = xls.get(iRowNo).get("Tax");
		try{
			AddedStockMaterial(iRowNo,sheet);
			addTax(iRowNo,sTax);
			addCGSTTax_Stock(iRowNo,0,sheet);
			addSGSTTax_Stock(iRowNo,0,sheet);
			addIGSTTax_Stock(iRowNo,0,sheet);
			flag = validateGrandTotalValue();
		}catch(Exception e){
			System.err.println("unable to validate grand total value "+e);
		}
		return flag;
	}

	public boolean validateRoundOff(int iRowNo,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("Tax");
		try{
			AddedStockMaterial(iRowNo,sheet);
			addTax(iRowNo,sTax);
			addCGSTTax_Stock(iRowNo,0,sheet);
			addSGSTTax_Stock(iRowNo,0,sheet);
			addIGSTTax_Stock(iRowNo,0,sheet);
			flag = RoundOff();
		}catch(Exception e){
			System.err.println("unable to validate round off value "+e);
		}
		return flag;
	}

	public boolean last30Days() throws Exception{
		boolean flag = false;
		Date Date30 = DateUtils.addDays(new Date(), -29);
		String dt = dDateFormat.format(Date30);
		try{
			dateCalendarDrpDown.click();
			Thread.sleep(Constant.Min_Sleep);
			if(last30Days.isDisplayed()){
				last30Days.click();
				searchBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				String sDateRange = dateRange.getText();
				String sDate[] = sDateRange.split("-");
				Date dateFrom = dDateFormat.parse(sDate[0]);
				Date dateTo = dDateFormat.parse(sDate[1].trim());
				Date currentDate = dDateFormat.parse(sCurrentDate);
				Date date30 = dDateFormat.parse(dt);
				if(currentDate.equals(dateTo) && date30.equals(dateFrom)){
					for (WebElement element : preparedOn) {
						String preparedDate = element.getText().substring(0, 12);
						Date date2 = dDateFormat.parse(preparedDate);
						if(dateFrom.compareTo(date2) * date2.compareTo(dateTo) >= 0){
							flag = true;
						}else{
							flag = false;
							break;
						}
					}
				}
			}

		}catch(Exception e){
			System.err.println("Last 30 days Date wise search is not working "+e);
		}
		return flag;
	}

	public boolean lastMonth(){
		boolean flag = false;
		cCal.add(Calendar.MONTH, -1);
		Date FirstDayOfMonth = cCal.getTime();
	    cCal.setTime(FirstDayOfMonth);
		String dt1 = dDateFormat.format(FirstDayOfMonth);
		cCal.set(Calendar.DAY_OF_MONTH, cCal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastDayOfMonth = cCal.getTime();
        String dt = dDateFormat.format(lastDayOfMonth);
		try{
			dateCalendarDrpDown.click();
			Thread.sleep(Constant.Min_Sleep);
			if(lastMonth.isDisplayed()){
				lastMonth.click();
				searchBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				String sDateRange = dateRange.getText();
				String sDate[] = sDateRange.split("-");
				Date dateFrom = dDateFormat.parse(sDate[0]);
				Date dateTo = dDateFormat.parse(sDate[1].trim());
				Date currentDate = dDateFormat.parse(dt1);
				Date date30 = dDateFormat.parse(dt);
				if(currentDate.equals(dateFrom) && date30.equals(dateTo)){
					for (WebElement element : preparedOn) {
						String preparedDate = element.getText().substring(0, 12);
						Date date2 = dDateFormat.parse(preparedDate);
						if(dateFrom.compareTo(date2) * date2.compareTo(dateTo) >= 0){
							flag = true;
						}
					}
				}
			}

		}catch(Exception e){
			System.err.println("current month Date wise search is not working "+e);
		}
		return flag;
	}

	public boolean currentMonth(){
		boolean flag = false;
	    cCal.setTime(dDate1);
	    cCal.set(Calendar.DAY_OF_MONTH, cCal.getActualMinimum(Calendar.DAY_OF_MONTH));
	    Date FirstDayOfMonth = cCal.getTime();
		String dt = dDateFormat.format(FirstDayOfMonth);
		try{
			dateCalendarDrpDown.click();
			Thread.sleep(Constant.Min_Sleep);
			if(currentMonth.isDisplayed()){
				currentMonth.click();
				searchBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				String sDateRange = dateRange.getText();
				String sDate[] = sDateRange.split("-");
				Date dateFrom = dDateFormat.parse(sDate[0]);
				Date dateTo = dDateFormat.parse(sDate[1].trim());
				Date currentDate = dDateFormat.parse(sCurrentDate);
				Date date30 = dDateFormat.parse(dt);
				if(currentDate.equals(dateTo) && date30.equals(dateFrom)){
					for (WebElement element : preparedOn) {
						String preparedDate = element.getText().substring(0, 12);
						Date date2 = dDateFormat.parse(preparedDate);
						if(dateFrom.compareTo(date2) * date2.compareTo(dateTo) >= 0){
							flag = true;
						}
					}
				}
			}

		}catch(Exception e){
			System.err.println("current month Date wise search is not working "+e);
		}
		return flag;
	}

	public boolean currentYear(){
		boolean flag = false;
		int iFirstDayOfYear = cCal.get(Calendar.YEAR);
		 String dt = "Jan 1, "+iFirstDayOfYear;
		try{
			dateCalendarDrpDown.click();
			Thread.sleep(Constant.Min_Sleep);
			if(currentYear.isDisplayed()){
				currentYear.click();
				searchBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				String sDateRange = dateRange.getText();
				String sDate[] = sDateRange.split("-");
				Date dateFrom = dDateFormat.parse(sDate[0]);
				Date dateTo = dDateFormat.parse(sDate[1].trim());
				Date currentDate = dDateFormat.parse(sCurrentDate);
				Date date30 = dDateFormat.parse(dt);
				if(currentDate.equals(dateTo) && date30.equals(dateFrom)){
					for (WebElement element : preparedOn) {
						String preparedDate = element.getText().substring(0, 12);
						Date date2 = dDateFormat.parse(preparedDate);
						if(dateFrom.compareTo(date2) * date2.compareTo(dateTo) >= 0){
							flag = true;
						}
					}
				}
			}

		}catch(Exception e){
			System.err.println("Current year Date wise search is not working "+e);
		}
		return flag;
	}

	public boolean currentFinancialYear(){
		boolean flag = false;
		 int iCurrentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		 int iCurrentYear = Calendar.getInstance().get(Calendar.YEAR);
		 String sFromDate = null;
		 int iYear = 0;
		try{
			if(iCurrentMonth >= 4){
				iYear = iCurrentYear;
				sFromDate = "Apr 1, "+Integer.toString(iYear);
				sCurrentDate = "Mar 31, "+Integer.toString(iYear+1);
			}else{
				iYear = iCurrentYear-1;
				sFromDate = "Apr 1, "+Integer.toString(iYear);
			}
			dateCalendarDrpDown.click();
			Thread.sleep(Constant.Min_Sleep);
			if(currentFinancialYear.isDisplayed()){
				currentFinancialYear.click();
				searchBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				String sDateRange = dateRange.getText();
				String sDate[] = sDateRange.split("-");
				Date dateFrom = dDateFormat.parse(sDate[0]);
				Date dateTo = dDateFormat.parse(sDate[1].trim());
				Date currentDate = dDateFormat.parse(sCurrentDate);
				Date FrDate = dDateFormat.parse(sFromDate);
				if(currentDate.equals(dateTo) && FrDate.equals(dateFrom)){
					for (WebElement element : preparedOn) {
						String preparedDate = element.getText().substring(0, 12);
						Date date2 = dDateFormat.parse(preparedDate);
						if(dateFrom.compareTo(date2) * date2.compareTo(dateTo) >= 0){
							flag = true;
						}
					}
				}
			}

		}catch(Exception e){
			System.err.println("Current financial year Date wise search is not working "+e);
		}
		return flag;
	}

	public boolean customRange(){
		boolean flag = false;
		 int iCurrentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		 int iCurrentYear = Calendar.getInstance().get(Calendar.YEAR)-1;
		 DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		try{
			dateCalendarDrpDown.click();
			Thread.sleep(Constant.Min_Sleep);
			if(currentRange.isDisplayed()){
				currentRange.click();
				prevMonth.click();
				Select selectLeftMonth = new Select(calendarLeft_Month);
				selectLeftMonth.selectByValue(Integer.toString(iCurrentMonth));
				Select selectLeftYr = new Select(calendarLeft_Year);
				selectLeftYr.selectByValue(Integer.toString(iCurrentYear));
				driver.findElement(By.xpath(".//div[@class='calendar left']/div[2]/table/tbody/tr[1]/td[contains(@class,'available')][text()='1']")).click();
				String sFromDate = fromDate.getAttribute("value");
				nextMonth.click();
				Select selectRightMonth = new Select(calendarRight_Month);
				selectRightMonth.selectByValue(Integer.toString(iCurrentMonth));
				Select selectRightYr = new Select(calendarRight_Year);
				selectRightYr.selectByValue(Integer.toString(iCurrentYear+1));
				driver.findElement(By.xpath(".//div[@class='calendar right']/div[2]/table/tbody/tr/td[contains(@class,'available')][text()='1']")).click();
				String sToDate = toDate.getAttribute("value");
				searchBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				String sDateRange = dateRange.getText();
				String date[] = sDateRange.split("-");
				Date dateFrom = dDateFormat.parse(date[0]);
				Date dateTo = dDateFormat.parse(date[1].trim());
				Date currentDate = dateFormat1.parse(sToDate);
				Date FrDate = dateFormat1.parse(sFromDate);
				if(currentDate.equals(dateTo) && FrDate.equals(dateFrom)){
					for (WebElement element : preparedOn) {
						String preparedDate = element.getText().substring(0, 12);
						Date date2 = dDateFormat.parse(preparedDate);
						if(dateFrom.compareTo(date2) * date2.compareTo(dateTo) >= 0){
							flag = true;
						}
					}
				}
			}

		}catch(Exception e){
			System.err.println("custom range Date wise search is not working "+e);
		}
		return flag;
	}

	public boolean lastFinancialYear(){
		boolean flag = false;
		 int iCurrentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		 int iCurrentYear = Calendar.getInstance().get(Calendar.YEAR);
		 String sFromDate = null;
		 int iYear = 0;
		try{
			if(iCurrentMonth >= 4){
				iYear = iCurrentYear;
				sFromDate = "Apr 1, "+Integer.toString(iYear-1);
				sCurrentDate = "Mar 31, "+Integer.toString(iYear);
			}else{
				iYear = iCurrentYear-2;
				sFromDate = "Apr 1, "+Integer.toString(iYear-1);
			}
			dateCalendarDrpDown.click();
			Thread.sleep(Constant.Min_Sleep);
			if(lastFinancialYr.isDisplayed()){
				lastFinancialYr.click();
				String sDateRange = dateRange.getText();
				String date[] = sDateRange.split("-");
				Date dateFrom = dDateFormat.parse(date[0]);
				Date dateTo = dDateFormat.parse(date[1].trim());
				Date currentDate = dDateFormat.parse(sCurrentDate);
				Date FrDate = dDateFormat.parse(sFromDate);
				searchBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(currentDate.equals(dateTo) && FrDate.equals(dateFrom)){
					for (WebElement element : preparedOn) {
						String preparedDate = element.getText().substring(0, 12);
						Date date2 = dDateFormat.parse(preparedDate);
						if(dateFrom.compareTo(date2) * date2.compareTo(dateTo) >= 0){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("last financial year wise date search is not working "+e);
		}
		return flag;
	}

	public boolean partyNameSearch(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCustomer = xls.get(iRowNo).get("Party");
		try{
			partyName.click();
			partyNameSearch.sendKeys(sCustomer);
			driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
			searchBtn.click();
			for(WebElement ele : customerList){
				if(!ele.getText().contains(sCustomer)){
					flag = false;
					break;
				}else{
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Party Name search is not working "+e);
		}
		return flag;
	}

	public boolean searchInvoice_PartyDateStatus(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1 = false, flag2 = false, flag3 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCustomer = xls.get(iRowNo).get("Party");
		Date Date30 = DateUtils.addDays(new Date(), -29);
		String dt = dDateFormat.format(Date30);
		try{
			partyName.click();
			partyNameSearch.sendKeys(sCustomer);
			driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
			dateCalendarDrpDown.click();
			Thread.sleep(Constant.Min_Sleep);
			last30Days.click();
			Select select = new Select(statusField);
			select.selectByVisibleText("Approved");
			searchBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			String sDateRange = dateRange.getText();
			String sDate[] = sDateRange.split("-");
			Date dateFrom = dDateFormat.parse(sDate[0]);
			Date dateTo = dDateFormat.parse(sDate[1].trim());
			Date currentDate = dDateFormat.parse(sCurrentDate);
			Date date30 = dDateFormat.parse(dt);
			for(WebElement ele:oaStatus){
				if(!ele.getText().contains("Approved")){
					flag1 = false;
					break;
				}else{
					flag1 = true;
				}
			}
			for(WebElement ele : customerList){
				if(!ele.getText().contains(sCustomer)){
					flag2 = false;
					break;
				}else{
					flag2 = true;
				}
			}
			if(currentDate.equals(dateTo) && date30.equals(dateFrom)){
				for (WebElement element : preparedOn) {
					String preparedDate = element.getText().substring(0, 12);
					Date date2 = dDateFormat.parse(preparedDate);
					if(dateFrom.compareTo(date2) * date2.compareTo(dateTo) >= 0){
						flag3 = true;
					}else{
						flag3 = false;
						break;
					}
				}
			}
			if(flag1 && flag2 && flag3){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Party, Name and status search failed "+e);
		}
		return flag;
	}

	public boolean statusSearch() throws Exception{
		boolean flag = false;
		try{
			String[] sStatus = {"Approved", "Cancelled", "Pending"};
			for (String element : sStatus) {
				Select select = new Select(statusField);
				select.selectByVisibleText(element);
				searchBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				for(WebElement ele:oaStatus){
					if(!ele.getText().contains(element)){
						flag = false;
						break;
					}else{
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Status search is not working "+e);
		}
		return flag;
	}

	public boolean filterSearch(){
		boolean flag = false, flag1 = false, flag2 = false;
		int i;
		try{
			for(i=0;i<invoices.size();i++){
				if(!invoices.get(i).getText().startsWith("-PF- ")){
					filterTextbox.sendKeys(invoices.get(i).getText());
					if(driver.findElement(By.xpath(".//a/mark[text()='"+invoices.get(i).getText()+"']")).isDisplayed()){
						flag1 = true;
						break;
					}
				}
			}
			String a = invoices.get(i).getText().substring(11, 13);
			filterTextbox.clear();
			filterTextbox.sendKeys(a);
			List<WebElement> list = driver.findElements(By.xpath(".//*[@id='invoice_list']/tbody/tr"));
			for (WebElement element : list) {
				if(element.getText().contains(a)){
					flag2 = true;
				}else{
					flag2 = false;
				}
			}
			if(flag1 && flag2){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Filter search is not working "+e);
		}
		return flag;
	}

	public boolean invoiceFetchedCheck(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCustomer = xls.get(iRowNo).get("Party");
		String InvoicesNo;
		try{
			partyName.click();
			partyNameSearch.sendKeys(sCustomer);
			driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
			searchBtn.click();
			InvoicesNo = invoicesFetched.getText().trim();
			if(invoices.size() == Integer.parseInt(InvoicesNo)){
				Select select = new Select(statusField);
				select.selectByVisibleText("Pending");
				searchBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				InvoicesNo = invoicesFetched.getText().trim();
				if(invoices.size() == Integer.parseInt(InvoicesNo)){
					dateCalendarDrpDown.click();
					Thread.sleep(Constant.Min_Sleep);
					currentMonth.click();
					searchBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					InvoicesNo = invoicesFetched.getText().trim();
					if(invoices.size() == Integer.parseInt(InvoicesNo)){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Invoice fectched number validation failed "+e);
		}
		return flag;
	}

	public boolean paginationValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColNames = xls.get(iRowNo).get("Column Name");
		int iInvoices; String number = null;
		try{
			String[] sList = {"10","25","50","100","All"};
			for (String element : sList) {
				Select select = new Select(showPageEntries);
				select.selectByVisibleText(element);
				Thread.sleep(Constant.Min_Sleep);
				String sCount = invoicesFetched.getText();
				if(element.equals("All")){
					iInvoices = Integer.parseInt(sCount);
				}else{
					iInvoices = Integer.parseInt(element);
				}
				Double iActPageCount = Double.parseDouble(sCount)/iInvoices;
				int iPageCount = invoicePaginate.size();
				if(!(iActPageCount % 1 == 0)){
					iActPageCount = iActPageCount + 1;
					double decimalValue = iActPageCount - Math.floor(iActPageCount);
					decimalValue = Math.round(decimalValue * 100.0) / 100.0;
					number = String.valueOf(decimalValue);
					number = number.substring(number.indexOf(".")).substring(1);
				}
				if((int) Math.round(iActPageCount) == iPageCount){
					for(int j=0;j<iPageCount;j++){
						invoicePaginate.get(j).click();
						Thread.sleep(Constant.Min_Sleep);
						boolean flag1 = Constant.verifyColumnOrder(invoiceListGRidColumn, sColNames);
						if(flag1 && (invoices.size() == iInvoices || invoices.size() == Integer.parseInt(number))){
							flag = true;
						}else{
							flag = false;
							break;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate pagination "+e);
		}
		return flag;
	}

	public boolean validateListGridColumnSort_Asc(){
		boolean flag = false;
		ArrayList < String > arrayList=new ArrayList < >();
		try{
			for(int i=0;i<invoiceListGRidColumns.size();i++){
				List<WebElement> List = driver.findElements(By.xpath(".//*[@id='invoice_list']/tbody/tr/td["+(i+1)+"]"));
				for(WebElement ele:List){
					arrayList.add(ele.getText());
				}
				for (int j = 1; j < arrayList.size(); j++) {
			        if (arrayList.get(j-1).compareTo(arrayList.get(j)) > 0){
			        	flag = false;
			        }else{
			        	flag = true;
			        }
			    }
				if(i == invoiceListGRidColumns.size()-1){
					break;
				}
				invoiceListGRidColumns.get(i+1).click();
				arrayList.removeAll(arrayList);
			}
		}catch(Exception e){
			System.err.println("Failed to validate list grid column sort "+e);
		}
		return flag;
	}

	public boolean validateListGridColumnSort_Dsc(){
		boolean flag = false;
		ArrayList < String > arrayList=new ArrayList < >();
		try{
			for(int i=0;i<invoiceListGRidColumns.size();i++){
				invoiceListGRidColumns.get(i).click();
				invoiceListGRidColumns.get(i).click();
				List<WebElement> List = driver.findElements(By.xpath(".//*[@id='invoice_list']/tbody/tr/td["+(i+1)+"]"));
				for(WebElement ele:List){
					arrayList.add(ele.getText());
				}
				for (int j = 1; j < arrayList.size(); j++) {
			        if (arrayList.get(j-1).compareTo(arrayList.get(j)) < 0){
			        	flag = false;
			        }else{
			        	flag = true;
			        }
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate list grid column sort "+e);
		}
		return flag;
	}



	public boolean stockNotAvail_Popup(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sMaterial = xls.get(iRowNo).get("Material");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(addInvoicePage.isDisplayed()){
				materialReq.sendKeys(sMaterial);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
				hSNCodeStock.clear();
				hSNCodeStock.sendKeys(sDate);
				Thread.sleep(Constant.Min_Sleep);
				String sQty = closingQty.getText().substring(6);
				if(!sQty.equals("0")){
					quantityStock.clear();
					quantityStock.sendKeys(Double.toString(Double.parseDouble(sQty)+1));
					addInvoiceItem.click();
					if(stockNotAvail.isDisplayed()){
						flag = true;
						okButton.click();
					}
				}
			}
		}catch(Exception e){
			System.err.println("Stock Not available pop up is not displayed "+e);
		}
		return flag;
	}

	public boolean mandatoryfieldsCheck(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1 = false, flag2 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(addInvoicePage.isDisplayed()){
				save.click();
				if(addAtleast1MatPopUp.isDisplayed()){
					okButton.click();
					Thread.sleep(Constant.Min_Sleep);
					addInvoiceItem.click();
					if(matName_MandatoryMsg.isDisplayed() && hSN_MandatoryMsg.isDisplayed() && qtyStock_MandatoryMsg.isDisplayed() && rateStock_MandatoryMsg.isDisplayed()){
						materialReq.sendKeys(sMaterial);
						Thread.sleep(Constant.Min_Sleep);
						driver.findElement(By.xpath(".//li[1]/a[contains(text(),'"+sMaterial+"')]")).click();
						addInvoiceItem.click();
						if(qtyStock_MandatoryMsg.isDisplayed()){
							quantityStock.clear();
							quantityStock.sendKeys("10");
							addInvoiceItem.click();
							Thread.sleep(Constant.Min_Sleep);
							if(rateNonStock_MandatoryMsg.isDisplayed()){
								rate_Stock.clear();
								rate_Stock.sendKeys("15.25");
								addInvoiceItem.click();
								Thread.sleep(Constant.Min_Sleep);
								if(addedStockMaterial.isDisplayed()){
									flag1 = true;
								}
							}
						}
					}
				}
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
				if(flag1 && flag2){
					flag = true;
				}
			}

		}catch(Exception e){
			System.err.println("Mandatory field check failed"+e);
		}
		return flag;
	}

	public boolean createNewCustomer(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		try{
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(addInvoicePage.isDisplayed()){
				customerDropDwn.click();
				addNewButton.click();
				Thread.sleep(Constant.Min_Sleep);
				String sPartyName = masters.addParty(iRowNo,sheet);
				backBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				partyName.click();
				partyNameSearch.sendKeys(sPartyName);
				driver.findElement(By.xpath(".//em[text()='"+sPartyName+"']")).click();
				if(partyName.getText().equals(sPartyName)){
					addIcon.click();
					Thread.sleep(Constant.Min_Sleep);
					if(addInvoicePage.isDisplayed()){
						customerDropDwn.click();
						customerText.sendKeys(sPartyName);
						Thread.sleep(Constant.Min_Sleep);
						driver.findElement(By.xpath(".//em[text()='"+sPartyName+"']")).click();
						Thread.sleep(Constant.Min_Sleep);
						addStockMaterial(iRowNo,sMaterial,sAltUnit);
						addInvoiceItem.click();
						save.click();
						Thread.sleep(Constant.Min_Sleep);
						navigate.showAllEntries();
						int iAfterAdd = invoices.size();
						String sParty= driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td[7]")).getText();
						if(sParty.contains(sPartyName)){
							navigate.navigateToMasters();
							Thread.sleep(Constant.Min_Sleep);
							navigate.navigateToParty();
							Thread.sleep(Constant.Min_Sleep);
							masters.filterText.sendKeys(sPartyName);
							if(driver.findElement(By.xpath(".//a/mark[contains(text(),'"+sPartyName+"')]")).isDisplayed()){
								flag = true;
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to create new customer "+e);
		}
		return flag;
	}

	public boolean salesLedgerValidation(int iRowno, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sLedgerName = xls.get(iRowno).get("Ledger Name");
		try{
			accounts.addLedger(iRowno,sheet);
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(addInvoicePage.isDisplayed()){
				salesAcctDropDwn.click();
				salesAcctSearchTxt.sendKeys(sLedgerName+sDate.substring(8, 13));
				driver.findElement(By.xpath(".//em[text()='"+sLedgerName+sDate.substring(8, 13)+"']")).click();
				String sSalesAcct = salesAcctDropDwn.getText();
				if(sSalesAcct.equals(sLedgerName+sDate.substring(8, 13))){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate sales ledger in invoice add page "+e);
		}
		return flag;
	}

	public boolean validateOAMaterialsPopup(int iRowNo,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCustomer = xls.get(iRowNo).get("Party");
		String sColumnName = xls.get(iRowNo).get("Column Name");
		try{
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(addInvoicePage.isDisplayed()){
				customerDropDwn.click();
				customerText.sendKeys(sCustomer);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
				Thread.sleep(Constant.Min_Sleep);
				oANoDropDwn.click();
				if(oANolist.size() > 0){
					oANolist.get(0).click();
					driver.findElement(By.xpath(".//div[@class='btn-group open']/button")).click();
					Thread.sleep(Constant.Min_Sleep);
					if(viewOAMaterilPopup.isDisplayed()){
						flag = Constant.verifyColumnOrder(OAMaterialPopUpColumns, sColumnName);
						oaPopupCancelBtn.click();
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate oa materials pop up"+e);
		}
		return flag;
	}

	public boolean checkDiscount(int iRowNo) throws Exception{
		boolean flag = false,flag1 = false,flag2 = false,flag3 = false,flag4 = false,flag5 = false,
				flag6 = false, flag7 = false, flag8 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sMaterial = xls.get(iRowNo).get("Material");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(addInvoicePage.isDisplayed()){
				materialReq.sendKeys(sMaterial);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//li[1]/a[contains(text(),'"+sMaterial+"')]")).click();
				hSNCodeStock.clear();
				hSNCodeStock.sendKeys(sDate);
				quantityStock.clear();
				quantityStock.sendKeys("10");
				discountStock.clear();
				discountStock.sendKeys("101");
				addInvoiceItem.click();
				if(discountValueCheckPopUp.isDisplayed()){
					okButton.click();
					Thread.sleep(Constant.Min_Sleep);
					flag1 = true;
				}
				discountStock.clear();
				discountStock.sendKeys("99.99");
				addInvoiceItem.click();
				if(!discountValueCheckPopUp.isDisplayed()){
					flag2 = true;
				}
				discountStock.clear();
				discountStock.sendKeys("100");
				addInvoiceItem.click();
				if(!discountValueCheckPopUp.isDisplayed()){
					flag3 = true;
				}
				discountStock.clear();
				discountStock.sendKeys("100.1");
				addInvoiceItem.click();
				if(discountValueCheckPopUp.isDisplayed()){
					okButton.click();
					Thread.sleep(Constant.Min_Sleep);
					flag4 = true;
				}
				if(discountValueCheckPopUp.isDisplayed()){
					okButton.click();
					Thread.sleep(Constant.Min_Sleep);
					flag8 = true;
				}
				if(flag1 && flag2 && flag3 && flag4 &&
						flag5 && flag6 && flag7 && flag8){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Discount check failed "+e);
		}
		return flag;
	}

	public boolean validateMaterialAlreadyExists(int iRowNo,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		String sQty= null;
		try{
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(addInvoicePage.isDisplayed()){
				addStockMaterial(iRowNo, sMaterial,sAltUnit);
				addInvoiceItem.click();
				materialTab.click();
				Thread.sleep(Constant.Min_Sleep);
				materialReq.sendKeys("Test");
				Thread.sleep(Constant.Min_Sleep);
				materialReq.clear();
				Thread.sleep(Constant.Min_Sleep);
				addStockMaterial(iRowNo, sMaterial,sAltUnit);
				addInvoiceItem.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
					sQty = addedStockQTY.getAttribute("value");
					if(sQty.contains("20")){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Material already exists pop up check failed "+e);
		}
		return flag;
	}

	public boolean addInvoice_USD(int iRowNo, String sheet) throws Exception{
		boolean flag = false,flag1 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sCustomer = xls.get(iRowNo).get("Party");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sTax = xls.get(iRowNo).get("Tax");
		 String sInvoice = null;
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			String sInvoices = invoicesFetched.getText().trim();
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			addInvoiceDetails(iRowNo, sheet, null);
			addMaterialDetails(iRowNo,sMaterial,sheet, sTax);
			currency.click();
			usd.click();
			conversionRate.clear();
			conversionRate.sendKeys("25.50");
			if(!sInvoiceType.contains("Delivery Challan") && !sInvoiceType.contains("Bill of Supply")){
				flag1 = validateGrandTotalValue();
			}else{
				flag1 = true;
			}
			if(flag1){
				String sGrandTotal = grandTotal.getAttribute("value");
				save.click();
				Thread.sleep(Constant.Min_Sleep);
				String ActualInvoices = invoicesFetched.getText().trim();
				if(sInvoiceType.contains("G")){
					sInvoice = "G";
				}else{
					sInvoice = sInvoiceType.substring(0, 1);
				}
				String draftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+ActualInvoices+"]/td/form[@id='invoice_edit']/a")).getText();
				WebElement ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+ActualInvoices+"]/td[2]/following::td[1][contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sCustomer+"')]/following::td[1][text()=' "+sGrandTotal+"']/following::td[1]/form/a/span[text()='Pending']"));
				if(Integer.parseInt(sInvoices) < Integer.parseInt(ActualInvoices) && draftNo.startsWith("-NA- ("+sInvoice+"#") && ele.isDisplayed()){
					sInvoices = invoicesFetched.getText().trim();
					Thread.sleep(Constant.Min_Sleep);
					driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[7]/form/a/span")).click();
					Thread.sleep(Constant.Min_Sleep);
					if(salesPDF.isDisplayed()){
						approveInvoice.click();
						Thread.sleep(Constant.Min_Sleep);
						driver.switchTo().alert().accept();
						Thread.sleep(Constant.Min_Sleep);
						pDfBackBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						String sStatus = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[7]/form/a/span")).getText();
						driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[2]/form/a")).click();
						Thread.sleep(Constant.Min_Sleep);
						if(sStatus.contains("Approved") && driver.getPageSource().contains("Approved! No further Changes Allowed.")){
							flag = true;
						}
						backBtn.click();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
			}
		}catch(Exception e){
			System.err.println("Add invoice with USD failed "+e);
		}
		return flag;
	}

	public boolean validateRejectionMandatory(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addInvoice(iRowNo, sheet, null);
			Thread.sleep(Constant.Min_Sleep);
			String sInvoices = invoicesFetched.getText().trim();
			driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[7]/form/a/span")).click();
			Thread.sleep(Constant.Min_Sleep);
			rejectInvoice.click();
			Thread.sleep(Constant.Min_Sleep);
			if(rejectionWarning.isDisplayed()){
				okButton.click();
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Rejection remarks mandatory check failed "+e);
		}
		return flag;
	}

	public boolean customerListValidation(){
		boolean flag = false;
		List<String> customerListInvoice = new ArrayList<>();
		List<String> customerListParty = new ArrayList<>();
		try{
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			List<WebElement> element = driver.findElements(By.xpath(".//*[@id='dettable']/tbody/tr/td[19]"));
			for(int i=0;i<element.size();i++){
				String list = driver.findElement(By.xpath(".//*[@id='dettable']/tbody/tr["+(i+1)+"]/td[19]")).getText();
				if(list.contains("Customer")){
					String ele = driver.findElement(By.xpath(".//*[@id='dettable']/tbody/tr["+(i+1)+"]/td[2]/a")).getText().toUpperCase();
					customerListParty.add(ele);
					Collections.sort(customerListParty);
				}

			}
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(indentAddPage.isDisplayed()){
				customerDropDwn.click();
				for(int j=1; j<customerDropDown.size();j++){
					String ele = customerDropDown.get(j).getText().toUpperCase();
					customerListInvoice.add(ele);
					Collections.sort(customerListInvoice);
				}
			}
			Assert.assertEquals(customerListInvoice, customerListParty);
			if(customerListInvoice.containsAll(customerListParty)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Customer list validation failed "+e);
		}
		return flag;
	}

	public boolean validateListGridColumns(int iRowNo) throws Exception{
		boolean flag = false,flag1 = false,flag2 = false;
		 List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
			String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToInvoice();
			Thread.sleep(Constant.Min_Sleep);
			 flag1 = Constant.verifyColumnOrder(invoiceColumnNames,sColumn);
			 navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			Thread.sleep(Constant.Min_Sleep);
			WebElement element1 = driver.findElement(By.xpath(".//th[text()=' S.No. ']/following::th[text()=' Invoice No']/following::th[text()=' Prepared On']/following::th[text()=' Invoice Date']/following::th[text()=' Customer']/following::th[text()=' Total Value']/following::th[text()=' Status']"));
			if(element1.isDisplayed()){
				flag2 = true;
			}
			if(flag1 && flag2){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("List grid columns validation failed "+e);
		}
		return flag;
	}

	public boolean mandatoryFieldsCheck_Edit(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sProject = xls.get(iRowNo).get("Project");
		String sCustomer = xls.get(iRowNo).get("Party");
		try{
			addInvoice(iRowNo, sheet, null);
			Thread.sleep(Constant.Min_Sleep);
			String Invoices = invoicesFetched.getText().trim();
			driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+Invoices+"]/td[2]/form/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			Select select = new Select(invoiceType);
			select.selectByVisibleText("--");
			invoiceProject.click();
			invoiceProjectSearch.sendKeys("--Projects--");
			driver.findElement(By.xpath(".//em[text()='"+"--Projects--"+"']")).click();
			customerDropDwn.click();
			customerText.sendKeys("--");
			driver.findElement(By.xpath(".//em[text()='"+"--"+"']")).click();
			save.click();
			if(invoiceType_MandatoryMsg.isDisplayed() && project_MandatoryMsg.isDisplayed() && customer_MandatoryMsg.isDisplayed()){
				select.selectByVisibleText(sInvoiceType);
				Thread.sleep(Constant.Min_Sleep);
				save.click();
				Thread.sleep(Constant.Min_Sleep);
				if(project_MandatoryMsg.isDisplayed() && customer_MandatoryMsg.isDisplayed()){
					invoiceProject.click();
					invoiceProjectSearch.sendKeys(sProject);
					driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
					Thread.sleep(Constant.Min_Sleep);
					save.click();
					Thread.sleep(Constant.Min_Sleep);
					if(customer_MandatoryMsg.isDisplayed()){
						customerDropDwn.click();
						customerText.sendKeys(sCustomer);
						driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
						Thread.sleep(Constant.Min_Sleep);
						firstMatDelete.click();
						Thread.sleep(Constant.Min_Sleep);
						yesDelete.click();
						Thread.sleep(Constant.Min_Sleep);
						save.click();
						Thread.sleep(Constant.Min_Sleep);
						if(addAtleast1MatPopUp.isDisplayed()){
							okButton.click();
							Thread.sleep(Constant.Min_Sleep);
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Mandatory fields check during edit failed "+e);
		}
		return flag;
	}

	public boolean mandatoryfieldsCheck_DeliveryChallan(int iRowNo) throws Exception{
		boolean flag = false,flag2 = false,flag1 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sProject = xls.get(iRowNo).get("Project");
		String sCustomer = xls.get(iRowNo).get("Party");
		String sMaterial = xls.get(iRowNo).get("Material");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			Thread.sleep(Constant.Min_Sleep);
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(indentAddPage.isDisplayed()){
				save.click();
				if(project_MandatoryMsg.isDisplayed() && customer_MandatoryMsg.isDisplayed()){
					invoiceProject.click();
					invoiceProjectSearch.sendKeys(sProject);
					driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
					Thread.sleep(Constant.Min_Sleep);
					save.click();
					Thread.sleep(Constant.Min_Sleep);
					if(customer_MandatoryMsg.isDisplayed()){
						customerDropDwn.click();
						customerText.sendKeys(sCustomer);
						driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
						Thread.sleep(Constant.Min_Sleep);
						save.click();
						Thread.sleep(Constant.Min_Sleep);
						if(addAtleast1MatPopUp.isDisplayed()){
							okButton.click();
							Thread.sleep(Constant.Min_Sleep);
						}
					}
				}
				addInvoiceItem.click();
				if(matName_MandatoryMsg.isDisplayed() && hSN_MandatoryMsg.isDisplayed() && qtyStock_MandatoryMsg.isDisplayed() && rateStock_MandatoryMsg.isDisplayed()){
					materialReq.sendKeys(sMaterial);
					Thread.sleep(Constant.Min_Sleep);
					driver.findElement(By.xpath(".//li[1]/a[contains(text(),'"+sMaterial+"')]")).click();
					addInvoiceItem.click();
					if(hSN_MandatoryMsg.isDisplayed() && qtyStock_MandatoryMsg.isDisplayed()){
						hSNCodeStock.clear();
						hSNCodeStock.sendKeys(sDate);
						addInvoiceItem.click();
						if(qtyStock_MandatoryMsg.isDisplayed()){
							quantityStock.clear();
							quantityStock.sendKeys("10");
							addInvoiceItem.click();
							if(rateNonStock_MandatoryMsg.isDisplayed()){
								rate_Stock.clear();
								rate_Stock.sendKeys("10");
								addInvoiceItem.click();
								Thread.sleep(Constant.Min_Sleep);
								if(addedStockMaterial.isDisplayed()){
									flag1 = true;
								}
							}
						}
					}
				}
				if(flag1 && flag2){
					flag = true;
				}
				}

		}catch(Exception e){
			System.err.println("Mandatory field check for Delivery Challan failed"+e);
		}
		return flag;
	}

	/**
	 * To update an invoice which has only mandatory fields
	 * @param iRowNo
	 * @return
	 * @throws Exception
	 */

	public boolean updateInvoiceWithTaxes(int iRowNo, String sheet) throws Exception{
		boolean flag = false,flag1;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sCustomer = xls.get(iRowNo).get("Party");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sProject = xls.get(iRowNo).get("Project");
		String sTax = xls.get(iRowNo).get("Tax");
		String sInvoice,sGrandTotal,sActualInvoices,sDraftNo = null;
		try{
			if(sInvoiceType.contains("Delivery Challan")){
				navigate.navigateToStore();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToDeliveryChallan();
			}else{
				navigate.navigateToSales();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToInvoice();
			}
			Thread.sleep(Constant.Min_Sleep);
			if(sInvoiceType.contains("G")){
				sInvoice = "G";
			}else{
				sInvoice = sInvoiceType.substring(0, 1);
			}
			String sInvoices = invoicesFetched.getText().trim();
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			Select select = new Select(invoiceType);
			select.selectByVisibleText(sInvoiceType);
			invoiceProject.click();
			invoiceProjectSearch.sendKeys(sProject);
			driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
			customerDropDwn.click();
			customerText.sendKeys(sCustomer);
			driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			materialReq.sendKeys(sMaterial);
			Thread.sleep(Constant.Min_Sleep);
			driver.findElement(By.xpath(".//li[1]/a[contains(text(),'"+sMaterial+"')]")).click();
			hSNCodeStock.sendKeys(sDate);
			quantityStock.clear();
			quantityStock.sendKeys("10");
			addInvoiceItem.click();
			Thread.sleep(Constant.Min_Sleep);
			RoundOff();
			sGrandTotal = grandTotal.getAttribute("value");
			save.click();
			Thread.sleep(Constant.Min_Sleep);
			sActualInvoices = invoicesFetched.getText().trim();
			sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sActualInvoices+"]/td/form[@id='invoice_edit']/a")).getText();
			WebElement ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sActualInvoices+"]/td[2]/following::td[1][contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sCustomer+"')]/following::td[1][text()=' "+sGrandTotal+"']/following::td[1]/form/a/span[text()='Pending']"));
			if(Integer.parseInt(sInvoices) < Integer.parseInt(sActualInvoices) && sDraftNo.startsWith("-NA- ("+sInvoice+"#") && ele.isDisplayed()){
				driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sActualInvoices+"]/td[2]/form/a")).click();
				Thread.sleep(Constant.Min_Sleep);
				addInvoiceDetails(iRowNo,sheet, null);
				if(!sInvoiceType.contains("Delivery Challan") && !sInvoiceType.contains("Bill of Supply")){
					addCGSTTax_Stock(iRowNo,0,sheet);
					addSGSTTax_Stock(iRowNo,0,sheet);
					addIGSTTax_Stock(iRowNo,0,sheet);
					addTax(iRowNo,sTax);
					flag1 = validateGrandTotalValue();
				}else{
					flag1 = true;
				}
				if(flag1){
					RoundOff();
					sGrandTotal = grandTotal.getAttribute("value");
					save.click();
					Thread.sleep(Constant.Min_Sleep);
					WebElement element = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sActualInvoices+"]/td[2]/following::td[1][contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sCustomer+"')]/following::td[1][text()=' "+sGrandTotal+"']/following::td[1]/form/a/span[text()='Pending']"));
					if(Integer.parseInt(sInvoices) < Integer.parseInt(sActualInvoices) && sDraftNo.startsWith("-NA- ("+sInvoice+"#") && element.isDisplayed()){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("updating invoice which has only mandatory fields data failed "+e);
		}
		return flag;
	}

	public boolean last30Days(int iRowNo) throws Exception{
		boolean flag = false;
		Date Date30 = DateUtils.addDays(new Date(), -29);
		String dt = dDateFormat.format(Date30);
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		try{
			if(sInvoiceType.contains("Delivery Challan")){
				navigate.navigateToStore();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToDeliveryChallan();
			}else{
				navigate.navigateToSales();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToInvoice();
			}
			Thread.sleep(Constant.Min_Sleep);
			dateCalendarDrpDown.click();
			Thread.sleep(Constant.Min_Sleep);
			if(last30Days.isDisplayed()){
				last30Days.click();
				searchBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				String sDateRange = dateRange.getText();
				String sDate[] = sDateRange.split("-");
				Date dateFrom = dDateFormat.parse(sDate[0]);
				Date dateTo = dDateFormat.parse(sDate[1].trim());
				Date currentDate = dDateFormat.parse(sCurrentDate);
				Date date30 = dDateFormat.parse(dt);
				if(currentDate.equals(dateTo) && date30.equals(dateFrom)){
					for (WebElement element : preparedOn) {
						String preparedDate = element.getText().substring(0, 12);
						Date date2 = dDateFormat.parse(preparedDate);
						if(dateFrom.compareTo(date2) * date2.compareTo(dateTo) >= 0){
							flag = true;
						}
					}
				}
			}

		}catch(Exception e){
			System.err.println("Last 30 days Date wise search is not working "+e);
		}
		return flag;
	}

	public boolean partNameSearch(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sCustomer = xls.get(iRowNo).get("Party");
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		try{
			if(sInvoiceType.contains("Delivery Challan")){
				navigate.navigateToStore();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToDeliveryChallan();
			}else{
				navigate.navigateToSales();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToInvoice();
			}
			Thread.sleep(Constant.Min_Sleep);
			partyName.click();
			partyNameSearch.sendKeys(sCustomer);
			driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
			searchBtn.click();
			for(WebElement ele : customerList){
				if(!ele.getText().contains(sCustomer)){
					flag = false;
					break;
				}else{
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Party Name search is not working "+e);
		}
		return flag;
	}

	public boolean statusSearch(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		try{
			if(sInvoiceType.contains("Delivery Challan")){
				navigate.navigateToStore();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToDeliveryChallan();
			}else{
				navigate.navigateToSales();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToInvoice();
			}
			Thread.sleep(Constant.Min_Sleep);
			String[] sStatus = {"Approved", "Cancelled", "Pending"};
			for (String element : sStatus) {
				Select select = new Select(statusField);
				select.selectByVisibleText(element);
				searchBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				for(WebElement ele:oaStatus){
					if(!ele.getText().contains(element)){
						flag = false;
						break;
					}else{
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Status search is not working "+e);
		}
		return flag;
	}

	public boolean filterSearch(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		try{
			if(sInvoiceType.contains("Delivery Challan")){
				navigate.navigateToStore();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToDeliveryChallan();
			}else{
				navigate.navigateToSales();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToInvoice();
			}
			Thread.sleep(Constant.Min_Sleep);
			for (WebElement element : invoices) {
				if(!element.getText().startsWith("-NA- ")){
					filter.sendKeys(element.getText());
					if(driver.findElement(By.xpath(".//a[text()='"+element.getText()+"']")).isDisplayed()){
						flag = true;
						break;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Filter search is not working "+e);
		}
		return flag;
	}

	public boolean addInvoiceWithOa(int iRowNo, String sheet){
		boolean flag = false;
		String sOANumber;
		try{
			validateApproveOA(iRowNo, sheet);
			navigate.showAllEntries();
			int sOAActualList = oaList.size();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", oaList.get(sOAActualList-1));
			sOANumber = oaList.get(sOAActualList-1).getText();
			flag = addInvoice(iRowNo, sheet, sOANumber);
		}catch(Exception e){
			System.err.println("Failed to add Invoice with OA"+e);
		}
		return flag;
	}

	public boolean updateInvoiceWithOa(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Invoice");
		String sQtyRequired = xls.get(iRowNo).get("Qty to be Entered");
		String sMatCount = xls.get(iRowNo).get("Material Count");
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addInvoice(iRowNo, sheet, null);
			int iAfterAdd = invoices.size();
			String sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")).getText();
			driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("window.scrollBy(0,-5000)");
			Constant.waitFor(ExpectedConditions.elementToBeClickable(oANoDropDwn), "Failed to load OA drop down");
			oANoDropDwn.click();
			if(oANolist.size() > 0){
				for(int i=0;i<10;i++){
					oANolist.get(i).click();
					Thread.sleep(Constant.Min_Sleep);
					if(i == 10){
						break;
					}
				}
			}
			driver.findElement(By.xpath(".//div[@class='btn-group open']/button")).click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(addOAMaterials), "Failed to load sales view page");
			Thread.sleep(Constant.Min_Sleep);
			if(viewOAMaterilPopup.isDisplayed()){
				addDetailsViewMaterial(sQtyRequired, sMatCount);
			}
			for(int i=0;i<hsnStockMatList.size()-1;i++){
				addCGSTTax_Stock(iRowNo,i,sheet);
				addSGSTTax_Stock(iRowNo,i,sheet);
				addIGSTTax_Stock(iRowNo,i,sheet);
			}
			String sGrandTotal = grandTotal.getAttribute("value");
			save.click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.isAlertPresents()){
				driver.switchTo().alert().accept();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")));
			WebElement ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a[contains(text(),'"+sDraftNo+"')]/following::td[contains(text(),'"+sInvoiceType+"')]/following::td[1][contains(text(),'"+sCurrentDate+"')]/following::td[4][text()=' "+sGrandTotal+"']/following::td/a[text()='Pending']"));
			if(ele.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to update Invoice with OA"+e);
		}
		return flag;
	}

	public boolean printOptions(int iRowNo, String sheet) throws Exception{
 		boolean flag = false;
 		try{
	 		validateApproveInvoice(iRowNo, sheet, null);
	 		navigate.showAllEntries();
	 		Thread.sleep(Constant.Min_Sleep);
			String sInvoices = Integer.toString(invoices.size());
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/a")));
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+sInvoices+"]/td[9]/span[1]/i"))).click().perform();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(printDwnload), "Failed to load sales pdf popup");
			if(salesPDF.isDisplayed()){
				printDwnload.click();
				Thread.sleep(Constant.Min_Sleep);
//				driver.findElement(By.xpath("//span[@class='checkbox']//label[text()='Original For Recipient']")).click();
				List<WebElement> ele = driver.findElements(By.xpath(".//div[@id='download_copy_list']/span[@class='checkbox']/label"));
				for(WebElement element:ele){
					if(!element.isSelected()){
						element.click();
					}
				}
				printBtn.click();
				Thread.sleep(Constant.Medium_Sleep);
				if(driver.getPageSource().contains("Print")){
					flag = true;
					driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
					Thread.sleep(Constant.Min_Sleep);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("document.querySelector('print-preview-app').shadowRoot.querySelector('print-preview-sidebar').shadowRoot.querySelector('print-preview-button-strip').shadowRoot.querySelector('cr-button.cancel-button').click();");
					Thread.sleep(Constant.Min_Sleep);
					driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
				    Thread.sleep(Constant.Min_Sleep);
					pDfBackBtn.click();
				}
			}
 		}catch(Exception e){
 			System.err.println("Failed to print invoice pdf "+e);
 		}
		return flag;
	}

	public boolean updateDC_CheckReturn(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addInvoice(iRowNo,sheet, null);
			int iBeforeAdd = invoices.size();
			driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			for (WebElement element : returnChckBox_EditPage) {
				element.click();
			}
			save.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a")));
			driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(!returnChckBox_EditPage.get(0).isSelected()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to update Dc by unchecking return checkboxes"+e);
		}
		return flag;
	}

	public boolean materialReturnedDC_GRNApproved(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			validateApproveInvoice(iRowNo,sheet, null);
			navigate.showAllEntries();
			int iBeforeAdd = invoices.size();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a")));
			String sApprovedDcNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a")).getText();
			store.approveGRN(iRowNo, sheet, sApprovedDcNo);
			int grnCount = grnList.size();
			String sGRNNo = driver.findElement(By.xpath("//tr["+grnCount+"]//td[4]")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a")));
			Thread.sleep(Constant.Min_Sleep);
			driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			store.materialsReturnedBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(store.returnMaterialPopup.isDisplayed()){
				for (WebElement element : store.returnedMaterialGRNNoList) {
					if(element.getText().contains(sGRNNo)){
						flag = true;
					}
				}
				store.returnMaterialPopupClose.click();
			}
		}catch(Exception e){
			System.err.println("Failed to validate Material returned pop up for DC"+e);
		}
		return flag;
	}

	public boolean updateJDC_ChangePONo(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addInvoice(iRowNo,sheet, null);
			int iBeforeAdd = invoices.size();
			driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			pONoDropDwn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(poNoList.size() > 2){
				poNoList.get(3).click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(addPOMaterials), "Failed to load view po materials popup");
				addPOMaterials();
				for(int k=0;k<hsnEditStockMatList.size();k++){
					addCGSTEditTax_Stock(iRowNo,k,sheet);
					addSGSTEditTax_Stock(iRowNo,k,sheet);
					addIGSTEditTax_Stock(iRowNo,k,sheet);
					js.executeScript("window.scrollBy(0,-5000)");
					Thread.sleep(Constant.Min_Sleep);
				}
			}
			RoundOff();
			String sGrandTotal = grandTotal.getAttribute("value");
			save.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			navigate.showAllEntries();
			int iAfterAdd = invoices.size();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")));
			if(iBeforeAdd == iAfterAdd){
				String sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")).getText();
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")));
				WebElement ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a[contains(text(),'"+sDraftNo+"')]/following::td[2][contains(text(),'"+sCurrentDate+"')]/following::td[4][text()=' "+sGrandTotal+"']/following::td/a[text()='Pending']"));
				if(ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to update JDC by changing Po no"+e);
		}
		return flag;
	}

	public boolean materialReturnedJDC_GRNApproved(int iRowNo, String sheet){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		boolean flag = false;
		try{
			validateApproveInvoice(iRowNo,sheet, null);
			navigate.showAllEntries();
			int iBeforeAdd = invoices.size();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a")));
			String sApprovedDcNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a")).getText();
			store.approveGRN(iRowNo, sheet, null);
			int grnCount = grnList.size();
			String sGRNNo = driver.findElement(By.xpath("//tr["+grnCount+"]//td[4]")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(grnCount-1)).perform();
			grnList.get(grnCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(store.grnMaterialTable), "Failed to load GRN edit page");
			Thread.sleep(Constant.Medium_Sleep);
			store.materialsReturnedTab.click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag9 = Constant.isElementPresent(By.xpath("//table[@id='dc_materialtable']/tbody/tr/td/input[@name='pending_qty']"));
			if(flag9){
				for(int i=0;i<store.returnedJDCNoList.size();i++){
					js.executeScript("window.scrollBy(0, 250)");
					if(store.returnedJDCNoList.get(i).getText().contains(sApprovedDcNo)){
						store.addReturnedMatQty(iRowNo, sheet,i);
						break;
					}
				}
			}
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");//To scroll to the bottom of the page
			Thread.sleep(Constant.Min_Sleep);
			store.UpdateBtn.click();
			Thread.sleep(Constant.Max_Sleep);
			if(Constant.isAlertPresents()){
				driver.switchTo().alert().accept();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load ok button");
			Thread.sleep(Constant.Min_Sleep);
			okButton.click();
			Constant.waitFor(ExpectedConditions.visibilityOf(store.grnMaterialTable), "Failed to load GRN edit page");
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			backBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToDeliveryChallan();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a")));
			Thread.sleep(Constant.Min_Sleep);
			driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td/a")).click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(store.materialsReturnedBtn), "Failed to load sales edit page");
			Thread.sleep(Constant.Min_Sleep);
			store.materialsReturnedBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(store.returnMaterialPopupClose), "Failed to load sales edit page");
			if(store.returnMaterialPopup.isDisplayed()){
				for (WebElement element : store.returnedMaterialGRNNoList) {
					if(element.getText().contains(sGRNNo)){
						flag = true;
					}
				}
				store.returnMaterialPopupClose.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to validate material returned pop up in JDC"+e);
		}
		return flag;
	}

	//Se related methods

	public boolean addSe(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1, flag2, flag3, flag4, flag5;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sType = xls.get(iRowNo).get("OA Type");
		try{
			navigate.showAllEntries();
			int sSEActualList = seListRecords.size();
			createSeBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			Select select = new Select(seTypeDD);
			select.selectByValue(sType);
			sePartyDD.click();
			SEPartysearch.sendKeys(sParty);
			driver.findElement(By.xpath(".//em[text()='"+sParty+"']")).click();
			flag1 = addMaterialSE(iRowNo, sheet);
			addSEDetails(iRowNo, sheet);
			flag3 = addSeTax(iRowNo, sheet);
			flag2 = validateSEAmountColumn();
			flag4 = validateSEGrandTotal();
			flag5 = seRoundOff();
			if(flag1 && flag2 && flag3 && flag4 && flag5){
				String sGrandTotal = seGrandTotal.getAttribute("value");
				SaveSE.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
					Thread.sleep(Constant.Min_Sleep);
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				int sSEList = seListRecords.size();
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEList-1));
				Thread.sleep(Constant.Min_Sleep);
				WebElement ele = driver.findElement(By.xpath(".//tr["+sSEList+"]/td[2]/a[contains(text(),'PF')]/following::td[contains(text(),'"+sType+"')]"
						+ "/following::td[3][contains(text(),'"+sParty+"')]/following::td[contains(text(),'"+sGrandTotal+"')]"
								+ "/following::td/a[contains(text(),'Draft')]"));
				if(sSEList > sSEActualList && flag1 && ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add SE "+e);
		}
		return flag;
	}

	public boolean addMaterialSE(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sPrice = xls.get(iRowNo).get("Price");
		String sQty = xls.get(iRowNo).get("Quantity");
		String sDiscount = xls.get(iRowNo).get("Discount");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		List<String> addedMaterials = new ArrayList<>();
		try{
			String[] sMaterialList = sMaterial.split(",");
			for (String element : sMaterialList) {
				SEMaterialfield.sendKeys(element);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//ul/li/a[contains(text(),'"+element+"')]")).click();
//				oaStockRemarks.sendKeys(materialDesc.getText());
				Thread.sleep(Constant.Min_Sleep);
				if(SEhsncode.getAttribute("value").isEmpty() || SEhsncode.getAttribute("value").matches(".*[a-zA-Z]+.*")){
					SEhsncode.sendKeys(Keys.CONTROL+"a");
					SEhsncode.sendKeys(Keys.DELETE);
					SEhsncode.sendKeys(sDate);
				}
				if(sAltUnit.contains("Yes")){
					alternateUnit.click();
					alternateUnitOptions.click();
				}
				if(SEPrice.getAttribute("value").equals("0")){
					SEPrice.sendKeys(Keys.CONTROL+"a");
					SEPrice.sendKeys(Keys.DELETE);
					SEPrice.sendKeys(sPrice);
				}
				SEqty.sendKeys(Keys.CONTROL+"a");
				SEqty.sendKeys(Keys.DELETE);
				SEqty.sendKeys(sQty);
				SEDiscount.sendKeys(Keys.CONTROL+"a");
				SEDiscount.sendKeys(Keys.DELETE);
				SEDiscount.sendKeys(sDiscount);
				Thread.sleep(Constant.Min_Sleep);
				oaAddStockMaterial.click();
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
			}
			for(int j = 0;j<addedSEMaterials.size()-1;j++){
				addedMaterials.add(addedSEMaterials.get(j).getAttribute("value"));
			}
			for (String element : sMaterialList) {
				if(addedMaterials.contains(element)){
					flag = true;
				}else{
					flag = false;
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add stock materials in SE "+e);
		}
		return flag;
	}

	public void addSEDetails(int iRowNo, String sheet) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sProject = xls.get(iRowNo).get("Project");
		String sSalesPerson = xls.get(iRowNo).get("Sales Person");
		try{
			seProjectDD.click();
			SEProjectsearch.sendKeys(sProject);
			driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
			SEPurpose.sendKeys(sDate);
			SERefno.sendKeys(sDate);
//			salesPerson.click();
//			seSalesPersonSearch.sendKeys(sSalesPerson);
//			driver.findElement(By.xpath(".//label[contains(text(),'"+sSalesPerson+"')]")).click();
			SEexpirydate.click();
			selectNxtMnth.click();
			selectDate.click();
			SErefdate.click();
			selectPrevMnth.click();
			selectDate.click();
			sePaymentTerms.sendKeys("cash");
			seInstruction.sendKeys("SE special instruction-automation "+sDate);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			attachmenticon.click();
			Thread.sleep(Constant.Min_Sleep);
			attachmentlabel.sendKeys("Se attachment "+sDate);
			chooseFile.click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.attachFile();
//			Runtime.getRuntime().exec("E:\\ExpenseBillUpload.exe");//execute AutoIT to upload import file
			Thread.sleep(Constant.Min_Sleep);
			addSEAttachment.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(ok), "Failed to load success popup");
			ok.click();
			Thread.sleep(Constant.Min_Sleep);
			closeSeAttachment.click();
			Thread.sleep(Constant.Min_Sleep);
			remark.sendKeys("SE Remarks "+sDate);
			seNotesSupereditIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			driver.switchTo().frame(0);
			driver.findElement(By.xpath(".//html/body")).sendKeys("SE notes "+RandomStringUtils.randomAlphanumeric(10));
			driver.switchTo().defaultContent();
			addSeNotes.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to add SE details "+e);
		}
	}

	public boolean addSeTax(int iRowNo,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("Tax");
		try{
			oaTaxDD.click();
			Thread.sleep(Constant.Min_Sleep);
			oaSearchField.sendKeys(sTax);
			driver.findElement(By.xpath(".//em[text()='"+sTax+"']")).click();
			seTaxadd.click();
			Thread.sleep(Constant.Min_Sleep);
			for (WebElement element : seAddedTax) {
				if(element.getText().contains(sTax)){
					flag = true;
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Unable to add tax "+e);
		}
		return flag;
	}

	public boolean validateSEAmountColumn(){
		boolean flag = false;
		Double dUnitPrice = null;
		try{
			for(int i=0;i<seAmountCol.size();i++){
				String sQty = seQtyCol.get(i).getAttribute("value");
				String sPrice = oaPriceList.get(i).getAttribute("value");
				String sAmount = seAmountCol.get(i).getAttribute("value");
				String sDiscount = oaDiscountList.get(i).getAttribute("value");
				double totalPrice = Double.parseDouble(sQty) * Double.parseDouble(sPrice);
				totalPrice = totalPrice - (totalPrice * Double.parseDouble(sDiscount) / 100);
				dUnitPrice = Math.round(totalPrice * 100.0) / 100.0;
				if(Double.parseDouble(sAmount) == dUnitPrice){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("SE Amount column validation "+e);
		}
		return flag;
	}

	public boolean validateSEGrandTotal(){
		boolean flag = false;
		ArrayList<String> tax = new ArrayList<>();
		ArrayList<String> sTotal = new ArrayList<>();
		List<Double> arrayOfTax = new ArrayList<>();
		List<Double> arrayOfTotal = new ArrayList<>();
		double sumTax = 0,sumTotal = 0;
		try{
			for(int i=0;i<seAmountCol.size();i++){
				sTotal.add(seAmountCol.get(i).getAttribute("value"));
				arrayOfTotal.add(Double.parseDouble(sTotal.get(i)));
				sumTotal += arrayOfTotal.get(i);
			}
			for(int i=0;i<seTaxList.size();i++){
				tax.add(seTaxList.get(i).getAttribute("value"));
				arrayOfTax.add(Double.parseDouble(tax.get(i)));
				sumTax += arrayOfTax.get(i);
			}
			Roundoff.sendKeys(Keys.CONTROL+"a");
			Roundoff.sendKeys(Keys.DELETE);
			Roundoff.sendKeys("0.00");
			seGrandTotal.click();
			String sGrandTotal = seGrandTotal.getAttribute("value");
			double Total = sumTax+sumTotal;
			double roundOff = Math.round(Total * 100.0) / 100.0;
			if(roundOff == Double.parseDouble(sGrandTotal)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("SE Grand total validation "+e);
		}
		return flag;
	}

	public boolean seRoundOff(){
		boolean flag = false;
		String sGrandTotal,sDecimalvalue;
		try{
			Roundoff.sendKeys(Keys.CONTROL+"a");
			Roundoff.sendKeys(Keys.DELETE);
			Roundoff.sendKeys("0.00");
			seGrandTotal.click();
			sGrandTotal = seGrandTotal.getAttribute("value");
			Thread.sleep(1000);
			sDecimalvalue = sGrandTotal.substring(sGrandTotal.indexOf("."));
			if(!sDecimalvalue.contains("00")){
				sDecimalvalue = sDecimalvalue.substring(1);
				Thread.sleep(1000);
				int iRemaining = 100 - Integer.parseInt(sDecimalvalue);
				if(iRemaining < 50){
					if(iRemaining < 10){
						Roundoff.sendKeys(Keys.chord(Keys.CONTROL, "a"),".0"+iRemaining);
					}else{
						Roundoff.sendKeys(Keys.chord(Keys.CONTROL, "a"),"."+iRemaining);
					}
				}else{
					Roundoff.sendKeys(Keys.chord(Keys.CONTROL, "a"),"-."+sDecimalvalue);
				}
				Roundoff.sendKeys(Keys.TAB);
				Roundoff.sendKeys(Keys.ENTER);
				seGrandTotal.click();
				Thread.sleep(Constant.Min_Sleep);
				sGrandTotal = seGrandTotal.getAttribute("value");
				sDecimalvalue = sGrandTotal.substring(sGrandTotal.indexOf("."));
			}
			if(sDecimalvalue.contains("00")){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Round off value validation failed for se "+e);
		}
		return flag;
	}

	public boolean updateDraftSE(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		try{
			addSe(iRowNo, sheet);
			flag = updateSE(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Failed to update SE "+e);
		}
		return flag;
	}

	public boolean updateSE(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1, flag2, flag3, flag4, flag5;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sType = xls.get(iRowNo).get("OA Type");
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			seListRecords.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			Select select = new Select(seTypeDD);
			select.selectByValue(sType);
			js.executeScript("window.scrollBy(0,-5000)");
			sePartyDD.click();
			SEPartysearch.sendKeys(sParty);
			driver.findElement(By.xpath(".//em[text()='"+sParty+"']")).click();
			if(Constant.isElementPresent(By.xpath(".//a[@title='Remove Tax']/i"))){
				deleteTax.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			flag1 = addMaterialSE(iRowNo, sheet);
			flag3 = addSeTax(iRowNo, sheet);
			flag2 = validateSEAmountColumn();
			flag4 = validateSEGrandTotal();
			flag5 = seRoundOff();
			if(flag1 && flag2 && flag3 && flag4 && flag5){
				String sGrandTotal = seGrandTotal.getAttribute("value");
				updateSE.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
					Thread.sleep(Constant.Min_Sleep);
				}
				Constant.waitFor(ExpectedConditions.visibilityOf(okBtn), "Failed to load GRN view page");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				int sSEList = seListRecords.size();
				js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEList-1));
				WebElement ele = driver.findElement(By.xpath(".//tr["+sSEList+"]/td[2]/a[contains(text(),'PF')]/following::td[contains(text(),'"+sType+"')]"
						+ "/following::td[3][contains(text(),'"+sParty+"')]/following::td[contains(text(),'"+sGrandTotal+"')]"
								+ "/following::td/a[contains(text(),'Draft')]"));
				if(sSEList == sSEActualList && ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to update SE "+e);
		}
		return flag;
	}

	public boolean deleteMaterial_UpdateSe(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sType = xls.get(iRowNo).get("OA Type");
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			seListRecords.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			seDeleteMaterials.get(0).click();
			Thread.sleep(Constant.Min_Sleep);
			okButton.click();
			Thread.sleep(Constant.Min_Sleep);
			String sGrandTotal = seGrandTotal.getAttribute("value");
			updateSE.click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.isAlertPresents()){
				driver.switchTo().alert().accept();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.visibilityOf(okBtn), "Failed to load GRN view page");
			Thread.sleep(Constant.Min_Sleep);
			okBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int sSEList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEList-1));
			WebElement ele = driver.findElement(By.xpath(".//tr["+sSEList+"]/td[2]/a[contains(text(),'PF')]/following::td[contains(text(),'"+sType+"')]"
					+ "/following::td[3][contains(text(),'"+sParty+"')]/following::td[contains(text(),'"+sGrandTotal+"')]"
							+ "/following::td/a[contains(text(),'Draft')]"));
			if(sSEList == sSEActualList && ele.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to delete material in SE "+e);
		}
		return flag;
	}

	public boolean warningwithtoutMat(){
		boolean flag = false;
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			seListRecords.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			for(int j=0;j<seDeleteMaterials.size()-1;j++){
				seDeleteMaterials.get(j).click();
				Thread.sleep(Constant.Min_Sleep);
				okButton.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			updateSE.click();
			Thread.sleep(Constant.Min_Sleep);
			if(warningWOMat.isDisplayed()){
				okButton.click();
				Thread.sleep(Constant.Min_Sleep);
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Warning popup did not displayed "+e);
		}
		return flag;
	}

	public boolean reviewSE(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		int sSEActualList; String sStatus;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addSe(iRowNo, sheet);
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(seStatus.get(sSEActualList-1)).perform();
			actions.moveToElement(sePdficon.get(sSEActualList-1)).perform();
			sePdficon.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(reviewSE), "Failed to load se pdf");
			if(reviewSE.isDisplayed()){
				remarks.sendKeys("REview SE "+sDate);
				reviewSE.click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				pDfBackBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
				seListRecords.get(sSEActualList-1).click();
				Thread.sleep(Constant.Min_Sleep);
				if(submitSEReview.isDisplayed()){
					seBackBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					navigate.showAllEntries();
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
	 				sStatus = seStatus.get(sSEActualList-1).getText();
					if(sStatus.contains("Reviewed")){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to review SE "+e);
		}
		return flag;
	}

	public boolean resubmitSE_AddMat(int iRowNo, String sheet) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sType = xls.get(iRowNo).get("OA Type");
		boolean flag = false, flag1, flag3, flag5;
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			seListRecords.get(sSEActualList-1).click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(submitSEReview), "Failed to load se pdf");
			if(submitSEReview.isDisplayed()){
				if(Constant.isElementPresent(By.xpath(".//a[@title='Remove Tax']/i"))){
					deleteTax.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				flag1 = addMaterialSE(iRowNo, sheet);
				flag3 = addSeTax(iRowNo, sheet);
				flag5 = seRoundOff();
				if(flag1 && flag3 && flag5){
					String sGrandTotal = seGrandTotal.getAttribute("value");
					remark.sendKeys("resubmit SE "+sDate);
					submitSEReview.click();
					Thread.sleep(Constant.Min_Sleep);
					if(Constant.isAlertPresents()){
						driver.switchTo().alert().accept();
						Thread.sleep(Constant.Min_Sleep);
					}
					okBtn.sendKeys(Keys.ENTER);
					Thread.sleep(Constant.Min_Sleep);
					navigate.showAllEntries();
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
					int sSEList = seListRecords.size();
					js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEList-1));
					WebElement ele = driver.findElement(By.xpath(".//tr["+sSEList+"]/td[2]/a[contains(text(),'PF')]/following::td[contains(text(),'"+sType+"')]"
							+ "/following::td[3][contains(text(),'"+sParty+"')]/following::td[contains(text(),'"+sGrandTotal+"')]"
									+ "/following::td/a[contains(text(),'Draft')]"));
					if(sSEList == sSEActualList && ele.isDisplayed()){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to resubmit SE "+e);
		}
		return flag;
	}

	public boolean resubmitSE_NoChange(int iRowNo, String sheet) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sType = xls.get(iRowNo).get("OA Type");
		boolean flag = false;
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			reviewSE(iRowNo, sheet);
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			seListRecords.get(sSEActualList-1).click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(submitSEReview), "Failed to load se pdf");
			if(submitSEReview.isDisplayed()){
				String sGrandTotal = seGrandTotal.getAttribute("value");
				remark.sendKeys("resubmit SE "+sDate);
				submitSEReview.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
					Thread.sleep(Constant.Min_Sleep);
				}
				okBtn.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
				int sSEList = seListRecords.size();
				js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEList-1));
				WebElement ele = driver.findElement(By.xpath(".//tr["+sSEList+"]/td[2]/a[contains(text(),'PF')]/following::td[contains(text(),'"+sType+"')]"
						+ "/following::td[3][contains(text(),'"+sParty+"')]/following::td[contains(text(),'"+sGrandTotal+"')]"
								+ "/following::td/a[contains(text(),'Draft')]"));
				if(sSEList == sSEActualList && ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to resubmit SE "+e);
		}
		return flag;
	}

	public boolean approveSE(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		int sSEActualList; String sStatus;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addSe(iRowNo, sheet);
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(seStatus.get(sSEActualList-1)).perform();
			actions.moveToElement(sePdficon.get(sSEActualList-1)).perform();
			sePdficon.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(approveSE), "Failed to load se pdf");
			if(approveSE.isDisplayed()){
				remarks.sendKeys("approve SE "+sDate);
				approveSE.click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				pDfBackBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
				seListRecords.get(sSEActualList-1).click();
				Thread.sleep(Constant.Min_Sleep);
				String IssueDate = seApprovedDate.getText();
 				String sSeNo = seNO.getText();
 				seBackBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
				sStatus = seStatus.get(sSEActualList-1).getText();
				String sSENumber = seListRecords.get(sSEActualList-1).getText();
				String sSeDate = seDateList.get(sSEActualList-1).getText();
				if(sStatus.contains("Approved") && IssueDate.contains(sSeDate) && sSENumber.equals(sSeNo)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to approve SE "+e);
		}
		return flag;
	}

	public boolean rejectDraftSE(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addSe(iRowNo, sheet);
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(seStatus.get(sSEActualList-1)).perform();
			actions.moveToElement(sePdficon.get(sSEActualList-1)).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(rejectSE), "Failed to load se pdf");
			if(rejectSE.isDisplayed()){
				remarks.sendKeys("reject draft SE "+sDate);
				rejectSE.click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				int iSEList = seStatus.size();
 				if(iSEList < sSEActualList){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to reject draft SE "+e);
		}
		return flag;
	}

	public boolean rejectApprovedSE(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			approveSE(iRowNo, sheet);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(seStatus.get(sSEActualList-1)).perform();
			actions.moveToElement(sePdficon.get(sSEActualList-1)).perform();
			sePdficon.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(rejectSE), "Failed to load se pdf");
			if(rejectSE.isDisplayed()){
				remarks.sendKeys("reject approved SE "+sDate);
				rejectSE.click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				pDfBackBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
				String sStatus = seStatus.get(sSEActualList-1).getText();
				String sSENumber = seListRecords.get(sSEActualList-1).getText();
				seListRecords.get(sSEActualList-1).click();
				Thread.sleep(Constant.Min_Sleep);
 				String sSENo = seNO.getText();
 				if(sStatus.contains("Cancelled") && sSENumber.equals(sSENo)){
					flag = true;
				}
 				seBackBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved SE "+e);
		}
		return flag;
	}

	public boolean ClientApproveSE(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			approveSE(iRowNo, sheet);
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(seStatus.get(sSEActualList-1)).perform();
			actions.moveToElement(sePdficon.get(sSEActualList-1)).perform();
			sePdficon.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(clientApproveSE), "Failed to load se pdf");
			if(clientApproveSE.isDisplayed()){
				remarks.sendKeys("client approve SE "+sDate);
				clientApproveSE.click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				pDfBackBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
				String sStatus = seStatus.get(sSEActualList-1).getText();
				String sSENumber = seListRecords.get(sSEActualList-1).getText();
				seListRecords.get(sSEActualList-1).click();
				Thread.sleep(Constant.Min_Sleep);
 				String sSENo = seNO.getText();
 				if(sStatus.contains("Client Approved") && sSENumber.equals(sSENo)){
					flag = true;
				}
 				seBackBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to client approved SE "+e);
		}
		return flag;
	}

	public boolean ClientRejectSE(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			approveSE(iRowNo, sheet);
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(seStatus.get(sSEActualList-1)).perform();
			actions.moveToElement(sePdficon.get(sSEActualList-1)).perform();
			sePdficon.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(clientRejectSE), "Failed to load se pdf");
			if(clientRejectSE.isDisplayed()){
				remarks.sendKeys("client approve SE "+sDate);
				clientRejectSE.click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				pDfBackBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
				String sStatus = seStatus.get(sSEActualList-1).getText();
				String sSENumber = seListRecords.get(sSEActualList-1).getText();
				seListRecords.get(sSEActualList-1).click();
				Thread.sleep(Constant.Min_Sleep);
 				String sSENo = seNO.getText();
 				if(sStatus.contains("Client Rejected") && sSENumber.equals(sSENo)){
					flag = true;
				}
 				seBackBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved SE "+e);
		}
		return flag;
	}

	public boolean amendClientApprovedSE(int iRowNo, String sheet){
		boolean flag = false;
		try{
			ClientApproveSE(iRowNo, sheet);
			flag = amendSE(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Failed to amend approved SE "+e);
		}
		return flag;
	}

	public boolean amendSE(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1, flag2, flag3, flag4, flag5;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sType = xls.get(iRowNo).get("OA Type");
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			seListRecords.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.isElementPresent(By.xpath(".//a[@title='Remove Tax']/i"))){
				deleteTax.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			flag1 = addMaterialSE(iRowNo, sheet);
			flag3 = addSeTax(iRowNo, sheet);
			flag2 = validateSEAmountColumn();
			flag4 = validateSEGrandTotal();
			flag5 = seRoundOff();
			if(flag1 && flag2 && flag3 && flag4 && flag5){
				String sGrandTotal = seGrandTotal.getAttribute("value");
				String sSENo = seNO.getText();
				amendSEBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
				if(Constant.isElementPresent(By.xpath("//button[text()='Yes, Sure!']"))){
					okButton.click();
				}
				Constant.waitFor(ExpectedConditions.visibilityOf(okBtn), "Failed to load GRN view page");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				int sSEList = seListRecords.size();
				js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEList-1));
				WebElement ele = driver.findElement(By.xpath(".//tr["+sSEList+"]/td[2]/a[contains(text(),'"+sSENo+"')]/following::td[contains(text(),'"+sType+"')]"
						+ "/following::td[3][contains(text(),'"+sParty+"')]/following::td[contains(text(),'"+sGrandTotal+"')]"));
				if(sSEList == sSEActualList && ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to amend SE "+e);
		}
		return flag;
	}

	public boolean deleteMaterial_AmendSe(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sType = xls.get(iRowNo).get("OA Type");
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			seListRecords.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			seDeleteMaterials.get(0).click();
			Thread.sleep(Constant.Min_Sleep);
			okButton.click();
			Thread.sleep(Constant.Min_Sleep);
			String sGrandTotal = seGrandTotal.getAttribute("value");
			String sSENo = seNO.getText();
			amendSEBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.isAlertPresents()){
				driver.switchTo().alert().accept();
			}
			if(Constant.isElementPresent(By.xpath("//button[text()='Yes, Sure!']"))){
				okButton.click();
			}
			Constant.waitFor(ExpectedConditions.visibilityOf(okBtn), "Failed to load GRN view page");
			Thread.sleep(Constant.Min_Sleep);
			okBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int sSEList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEList-1));
			WebElement ele = driver.findElement(By.xpath(".//tr["+sSEList+"]/td[2]/a[contains(text(),'"+sSENo+"')]/following::td[contains(text(),'"+sType+"')]"
					+ "/following::td[3][contains(text(),'"+sParty+"')]/following::td[contains(text(),'"+sGrandTotal+"')]"));
			if(sSEList == sSEActualList && ele.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to delete material in SE "+e);
		}
		return flag;
	}

	public String validatePromoteOA(int iRowNo, String sheet){
		String sSENo = null;
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			ClientApproveSE(iRowNo, sheet);
			sSENo = promoteToOA(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Failed to validate promote to OA "+e);
		}
		return sSENo;
	}

	public String promoteToOA(int iRowNo, String sheet){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String sSENo = null;
		try{
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			Thread.sleep(Constant.Min_Sleep);
			seListRecords.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			sSENo = seNO.getText();
			promoteToOaBTn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.isElementPresent(By.id("btn-sa-confirm"))){
				okButton.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			seBackBtn.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to promote OA "+e);
		}
		return sSENo;
	}

	public String promoteInvoice(int iRowNo, String sheet){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String sSENo = null;
		try{
			navigate.navigateToSales();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToSe();
			Thread.sleep(Constant.Min_Sleep);
			ClientApproveSE(iRowNo, sheet);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			Thread.sleep(Constant.Min_Sleep);
			seListRecords.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			sSENo = seNO.getText();
			promoteToInvoiceBTn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.isElementPresent(By.id("btn-sa-confirm"))){
				okButton.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to navigate to OA add page on clicking promote to OA "+e);
		}
		return sSENo;
	}

	public boolean addOa_PromoteOA(int iRowNo, String sheet){
		boolean flag = false;
		try{
			navigate.showAllEntries();
			int sOAActualList = oaList.size();
			String sSENo = validatePromoteOA(iRowNo, sheet);
			flag = addOaFromSEPge(iRowNo, sheet, sSENo, sOAActualList);
		}catch(Exception e){
			System.err.println("Failed to Add OA from promote to OA "+e);
		}
		return flag;
	}

	public boolean addOaFromSEPge(int iRowNo, String sheet, String sSENo,int sOAActualList){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sType = xls.get(iRowNo).get("OA Type");
		try{
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    if(driver.findElement(By.xpath("//span[contains(text(),'"+sSENo+"')]")).isDisplayed()){
		    	String sGrandTotal = oaGrandTotal.getText();
		    	oaSave.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				int sOAList = oaList.size();
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].scrollIntoView(true);", oaList.get(sOAList-1));
				Thread.sleep(Constant.Min_Sleep);
				WebElement ele = driver.findElement(By.xpath(".//tr["+sOAList+"]/td[2]/a[contains(text(),'PF')]/following::td[contains(text(),'"+sType+"')]"
						+ "/following::td[contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sParty+"')]/following::td[contains(text(),'"+sGrandTotal+"')]/following::td/a[contains(text(),'Pending')]"));
				if(sOAList > sOAActualList && ele.isDisplayed()){
					flag = true;
				}
		    }
		    driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to Add OA from promote to OA "+e);
		}
		return flag;
	}

	public boolean addInvoice_PromoteInvoice(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sProject = xls.get(iRowNo).get("Project");
		String sCustomer = xls.get(iRowNo).get("Party");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			int iBeforeAdd = invoices.size();
			String sSENo = promoteInvoice(iRowNo, sheet);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    if(driver.findElement(By.xpath("//td[contains(text(),'"+sSENo+"')]")).isDisplayed()){
		    	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    	Thread.sleep(Constant.Min_Sleep);
		    	String sGrandTotal = grandTotal.getAttribute("value");
				save.click();
				Thread.sleep(Constant.Medium_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
					Thread.sleep(Constant.Min_Sleep);
				}
				boolean flag4 = Constant.isElementPresent(By.id("btn-sa-confirm"));
				if(flag4){
					okButton.click();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				int iAfterAdd = invoices.size();
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")));
				if(iBeforeAdd < iAfterAdd){
					String sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")).getText();
					driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")).click();
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("window.scrollBy(0,-5000)");
					Thread.sleep(Constant.Min_Sleep);
					String sActDraftNo = invoiceNoEditPage.getText();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(backBtn), "Failed to load sales edit page");
					backBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a")));
					WebElement ele = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iAfterAdd+"]/td/a[contains(text(),'"+sDraftNo+"')]/following::td[2][contains(text(),'"+sCurrentDate+"')]/following::td[2][contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sCustomer+"')]/following::td[text()=' "+sGrandTotal+"']/following::td/a[text()='Pending']"));
					if(sDraftNo.startsWith("PF#") && ele.isDisplayed()  && sDraftNo.equals(sActDraftNo)){
						flag = true;
					}
				}
		    }
		    driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Failed to Add invoice from promote to Invoice "+e);
		}
		return flag;
	}

	public boolean validatePartyDcno_Draft(int iRowNo, String sheet, String sGRNNo){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sCustomer = xls.get(iRowNo).get("Party");
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(oANoDropDwn), "Failed to load oa drop down");
			if(invoiceType.isDisplayed()){
				Select select = new Select(invoiceType);
				select.selectByValue(sInvoiceType);
				Thread.sleep(Constant.Min_Sleep);
				customerDropDwn.click();
				customerText.sendKeys(sCustomer);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(partyDcNoDropDwn), "Failed to load party dc no drop down");
				Thread.sleep(Constant.Max_Sleep);
				partyDcNoDropDwn.click();
				Thread.sleep(Constant.Min_Sleep);
				oANoSearchField.sendKeys(sGRNNo);
				Thread.sleep(Constant.Min_Sleep);
				if(!Constant.isElementPresent(By.xpath("//label[contains(text(),'"+sGRNNo+"')]"))){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate party dc no from drop down"+e);
		}
		return flag;
	}

	public boolean validatePartyDcno_approved(int iRowNo, String sheet, String sGRNNo){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sCustomer = xls.get(iRowNo).get("Party");
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(oANoDropDwn), "Failed to load oa drop down");
			if(invoiceType.isDisplayed()){
				Select select = new Select(invoiceType);
				select.selectByValue(sInvoiceType);
				Thread.sleep(Constant.Min_Sleep);
				customerDropDwn.click();
				customerText.sendKeys(sCustomer);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(partyDcNoDropDwn), "Failed to load party dc no drop down");
				Thread.sleep(Constant.Medium_Sleep);
				partyDcNoDropDwn.click();
				Thread.sleep(Constant.Min_Sleep);
				oANoSearchField.sendKeys(sGRNNo);
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isElementPresent(By.xpath("//label[contains(text(),'"+sGRNNo+"')]"))){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate party dc no from drop down"+e);
		}
		return flag;
	}

	public boolean validateQtyMaterialListGrid(int iRowNo, String sheet, String sGRNNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sCustomer = xls.get(iRowNo).get("Party");
		String sQtyRequired = xls.get(iRowNo).get("Qty to be Entered");
		String sMatCount = xls.get(iRowNo).get("Material Count");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(oANoDropDwn), "Failed to load oa drop down");
			if(invoiceType.isDisplayed()){
				Select select = new Select(invoiceType);
				select.selectByValue(sInvoiceType);
				Thread.sleep(Constant.Min_Sleep);
				customerDropDwn.click();
				customerText.sendKeys(sCustomer);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(partyDcNoDropDwn), "Failed to load party dc no drop down");
				Thread.sleep(Constant.Max_Sleep);
				partyDcNoDropDwn.click();
				Thread.sleep(Constant.Medium_Sleep);
				oANoSearchField.sendKeys(sGRNNo);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath("//label[contains(text(),'"+sGRNNo+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				partyDcNoDropDwn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(addOAMaterials), "Failed to load sales view page");
				if(viewGRNMaterialsPopup.isDisplayed()){
					addDetailsViewMaterial(sQtyRequired, sMatCount);
					for(int i=0;i<matListGridQty.size()-1;i++){
						if(matListGridQty.get(i+1).getAttribute("value").contains("5")){
							flag = true;
						}else{
							flag = false;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate qty in material list grid "+e);
		}
		return flag;
	}

	public boolean validateMaterials_MatListGridAddPge(int iRowNo, String sheet, String sGRNNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sCustomer = xls.get(iRowNo).get("Party");
		String sQtyRequired = xls.get(iRowNo).get("Qty to be Entered");
		String sMatCount = xls.get(iRowNo).get("Material Count");
		String sMaterial = xls.get(iRowNo).get("Material");
		String[] sMaterialList = sMaterial.split(",");
		ArrayList<String> materialListgrid = new ArrayList<>();
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(oANoDropDwn), "Failed to load sales view page");
			if(invoiceType.isDisplayed()){
				Select select = new Select(invoiceType);
				select.selectByValue(sInvoiceType);
				Thread.sleep(Constant.Min_Sleep);
				customerDropDwn.click();
				customerText.sendKeys(sCustomer);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(partyDcNoDropDwn), "Failed to load party dc no drop down");
				Thread.sleep(Constant.Medium_Sleep);
				partyDcNoDropDwn.click();
				Thread.sleep(Constant.Medium_Sleep);
				oANoSearchField.sendKeys(sGRNNo);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath("//label[contains(text(),'"+sGRNNo+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				partyDcNoDropDwn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(addOAMaterials), "Failed to load sales view page");
				if(viewGRNMaterialsPopup.isDisplayed()){
					addDetailsViewMaterial(sQtyRequired, sMatCount);
					for(int i=0;i<matListGridMaterialAddPge.size()-1;i++){
						materialListgrid.add(matListGridMaterialAddPge.get(i+1).getAttribute("value"));
					}
					for (String element : sMaterialList) {
						if(materialListgrid.contains(element)){
							flag = true;
						}else{
							flag = false;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate stock and non stock mateirals in material list grid "+e);
		}
		return flag;
	}

	public boolean validateMaterials_MatListGridEditPge(int iRowNo, String sheet, String sGRNNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String[] sMaterialList = sMaterial.split(",");
		ArrayList<String> materialListgrid = new ArrayList<>();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			int iBeforeAdd = invoices.size();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/form/a")));
			Thread.sleep(Constant.Min_Sleep);
			String sDraftNo = driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/form/a")).getText();
			driver.findElement(By.xpath(".//*[@id='invoice_list']/tbody/tr["+iBeforeAdd+"]/td[2]/form/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sDraftNo+"')]")).isDisplayed()){
				for(int i=0;i<matListGridMaterialAddPge.size()-1;i++){
					materialListgrid.add(matListGridMaterialAddPge.get(i+1).getAttribute("value"));
				}
				for (String element : sMaterialList) {
					if(materialListgrid.contains(element)){
						flag = true;
					}else{
						flag = false;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate stock and non stock mateirals in material list grid "+e);
		}
		return flag;
	}

	public boolean validateQtywarning_MaterialListGrid(int iRowNo, String sheet, String sGRNNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		String sCustomer = xls.get(iRowNo).get("Party");
		String sQtyRequired = xls.get(iRowNo).get("Qty to be Entered");
		String sMatCount = xls.get(iRowNo).get("Material Count");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(oANoDropDwn), "Failed to load sales view page");
			if(invoiceType.isDisplayed()){
				Select select = new Select(invoiceType);
				select.selectByValue(sInvoiceType);
				Thread.sleep(Constant.Min_Sleep);
				customerDropDwn.click();
				customerText.sendKeys(sCustomer);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//em[text()='"+sCustomer+"']")).click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(partyDcNoDropDwn), "Failed to load party dc no drop down");
				Thread.sleep(Constant.Max_Sleep);
				partyDcNoDropDwn.click();
				Thread.sleep(Constant.Medium_Sleep);
				oANoSearchField.sendKeys(sGRNNo);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath("//label[contains(text(),'"+sGRNNo+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				partyDcNoDropDwn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(addOAMaterials), "Failed to load sales view page");
				if(viewGRNMaterialsPopup.isDisplayed()){
					addDetailsViewMaterial(sQtyRequired, sMatCount);
					for(int i=0;i<matListGridQty.size()-1;i++){
						matListGridQty.get(i+1).sendKeys(Keys.CONTROL+"a");
						matListGridQty.get(i+1).sendKeys(Keys.DELETE);
						matListGridQty.get(i+1).sendKeys("550");
					}
					save.click();
					Thread.sleep(Constant.Min_Sleep);
					if(qtyWarning.isDisplayed()){
						okButton.click();
						Thread.sleep(Constant.Min_Sleep);
						if(currentAvailPending.getText().contains("500")){
							flag = true;
						}
					}

				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate stock and non stock mateirals in material list grid "+e);
		}
		return flag;
	}

	public boolean itemPart_NotAvailable(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sInvoiceType = xls.get(iRowNo).get("Invoice Type");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load sales view page");
			addIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(oANoDropDwn), "Failed to load sales view page");
			if(invoiceType.isDisplayed()){
				Select select = new Select(invoiceType);
				select.selectByValue(sInvoiceType);
				Thread.sleep(Constant.Min_Sleep);
				if(!Constant.isElementPresent(By.id("materialReq"))){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to verify Items particulars section not available "+e);
		}
		return flag;
	}

	public boolean changeLog_NEwSE(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sType = xls.get(iRowNo).get("OA Type");
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		 ArrayList<String> list = new ArrayList<>();
		try{
			addSe(iRowNo, sheet);
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			seListRecords.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			changeLogBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			changeLogUsername.get(0).click();
			Thread.sleep(Constant.Min_Sleep);
			for (WebElement element : changeLogHistory) {
				list.add(element.getText());
			}
			String[] strs = { "draft", sDate, sParty, sType};
			for (String str : strs) {
				if(list.contains(str)){
					flag = true;
				}else{
					flag = false;
					break;
				}
			}
			CloseChangeLogBtn.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Change log validation for new SE failed "+e);
		}
		return flag;
	}

	public boolean changeLogStatusChange(String sStatus){
		boolean flag = false;
		int sSEActualList;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		 ArrayList<String> list = new ArrayList<>();
		try{
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			sSEActualList = seListRecords.size();
			js.executeScript("arguments[0].scrollIntoView(true);", seListRecords.get(sSEActualList-1));
			seListRecords.get(sSEActualList-1).click();
			Thread.sleep(Constant.Min_Sleep);
			changeLogBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			changeLogUsername.get(0).click();
			Thread.sleep(Constant.Min_Sleep);
			for (WebElement element : changeLogHistory) {
				list.add(element.getText());
			}
			if(list.contains(sStatus)){
				flag = true;
			}else{
				flag = false;
			}
			CloseChangeLogBtn.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Change log Se status change validation failed "+e);
		}
		return flag;
	}

}
