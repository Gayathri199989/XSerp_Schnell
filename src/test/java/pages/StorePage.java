package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
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

public class StorePage {

	ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);
	SettingPage setting = PageFactory.initElements(Constant.driver, SettingPage.class);

	@FindBy(xpath="//div[@id='indentList_info']")
	private WebElement totalRecords;

	@FindBy(id="visible_record_count")
	private WebElement recordCount;

	@FindBy(xpath=".//a[contains(@class,'create_grn')]")
	private WebElement addGRNBtn;

	@FindBy(xpath=".//a[@data-original-title='Create New Indent']") WebElement addIndentIcon;

	@FindBy(xpath=".//a[contains(@class,'create_invoice')]") WebElement addInvoiceIcon;

	@FindBy(xpath=".//*[@id='issue_table_list_tbody']/tr/td[6]")
	private List<WebElement> projectColList;

	@FindBy(xpath=".//*[@id='search']/option")
	private List<WebElement> searchInValList;

	@FindBy(id="search")
	private WebElement searchInDropDwn;

	@FindBy(id="txtsearch")
	private WebElement searchTxt;

	@FindBy(id="id_indent-purpose")
	public WebElement indentForTxt;

	@FindBy(id="load_dashboard_form")
	private WebElement submitBtn;

	@FindBy(id="btn_pending_indent")
	private WebElement raisedIndentStatus;

	@FindBy(xpath=".//div[@id='id_indent_purchase_account_id_chosen']")
	private WebElement indentTypeDropDwn;

	@FindBy(xpath="//div[@id='id_indent_purchase_account_id_chosen']//input[@class='chosen-search-input']")
	private WebElement indentTypeSearch;

	@FindBy(xpath=".//*[@id='id_indent_project_code_chosen']/a/span")
	private WebElement indentProjectDropDwn;

	@FindBy(xpath=".//*[@id='id_indent_project_code_chosen']/div/div/input")
	private WebElement projectSearch;

	@FindBy(id="indent_req_date")
	private WebElement indentReqDate;

	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='next'][contains(text(),'�')]")
	private WebElement indentNextMonth;

	@FindBy(xpath="//li[@id='mat_received']//a")
	private WebElement matReceivedTab;

	@FindBy(xpath="//label[contains(text(),'Faulty')]")
	private WebElement faultyChkBx;

	@FindBy(id="materialrequired")
	private WebElement materialReqTxt;

	@FindBy(id="explode_bom")
	private WebElement bomBtn;

	@FindBy(xpath="//h4[contains(text(),'BoM Materials')]")
	 WebElement bomPopUp;

	@FindBy(xpath="//table[contains(@id,'cattable')]/tbody/tr/td[8]/span")
	 List<WebElement> maxIssueBOMPopupList;

	@FindBy(xpath="//table[contains(@id,'cattable')]/tbody/tr/td[8]/span/preceding::td[5]")
	 List<WebElement> materialListBOMPopup;

	@FindBy(xpath="//table[contains(@id,'cattable')]/tbody/tr/td[3]/select/preceding::text()[1]")
	 List<WebElement> materialListTxtBOMPopup;

	@FindBy(xpath="//table[contains(@id,'cattable')]/tbody/tr/td[13]/a/i")
	 List<WebElement> bomPopDeleteIcon;

	@FindBy(xpath="//table[contains(@id,'cattable')]/tbody/tr/td[7]/input[contains(@class,'error-border-stock')]")
	 List<WebElement> bomPopUpErrorBorder;

	@FindBy(xpath="//table[contains(@id,'cattable')]/tbody/tr/td[7]/input")
	 List<WebElement> qtyColBOMPopup;

	@FindBy(id="id_material-alternate_units")
	private WebElement altUnitDrpDwnGrn;

	@FindBy(xpath="//select[@id='id_material-alternate_units']/option[2]")
	 WebElement altUnitOptionGRN;

	@FindBy(xpath="//select[@id='id_invoice_mat-__prefix__-alternate_units']")
	 WebElement altUnitDrpDwn;

	@FindBy(xpath="//select[@id='id_invoice_mat-__prefix__-alternate_units']/option[2]")
	 WebElement altUnitOption;

	@FindBy(xpath=".//span[text()='Purpose is required.']")
	private WebElement purposeErrorMsg;

	@FindBy(xpath=".//span[text()='Indent Type is required.']")
	private WebElement indentTypeErrorMsg;

	@FindBy(xpath=".//span[text()='Project is required.']")
	private WebElement projectErrorMsg;

	@FindBy(xpath=".//div/span[text()='Quantity is required.']")
	private WebElement quantityErrorMsg;

	@FindBy(xpath=".//span[text()='Material Name is required.']")
	private WebElement materialNameErrorMsg;

	@FindBy(id="id_ind_material-__prefix__-quantity")
	private WebElement quantityTxt;

	@FindBy(xpath="//*[contains(@id,'all_units')]")
	private WebElement unitDropdown;

	@FindBy(xpath="//div/Select[contains(@id,'alternate_units')]")
	private WebElement alternateUnit;

	@FindBy(xpath="//div/Select[contains(@id,'alternate_units')]/option[2]")
	private WebElement alternateUnitOptions;

	@FindBy(id="cmdshow")
	private WebElement viewBomBtn;

	@FindBy(xpath=".//h4[text()='View BOM']")
	private WebElement viewBOMPopup;

	@FindBy(id="catAdd")
	private WebElement addBOM;

	@FindBy(xpath="//p[contains(text(),'greater than Stock Quantity')]")
	private WebElement warnQtyGreaterStock;

	@FindBy(xpath=".//button[@class='cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath=".//*[@id='cattable']/tbody/tr/td[3]")
	private List<WebElement> bomMaterials;

	@FindBy(xpath=".//tr[contains(@id,'ind_material')]/td[3]/div")
	public List<WebElement> addedMaterials;

	@FindBy(id="catCancel")
	private WebElement cancelBnt_BOM;

	@FindBy(xpath=".//tr[1]/td[8]/a[text()='Delete ']")
	private WebElement firstBOMDelete;

	@FindBy(id="add_new_ind_material")
	private WebElement addMaterial;

	@FindBy(xpath=".//tr[1]/td[6]/input[@id='txtcatqty']")
	private WebElement bomMaterialCount_first;

	@FindBy(xpath=".//*[@id='cattable']/tbody/tr[1]/td[3]")
	private WebElement firstMaterial_BOM;

	@FindBy(xpath=".//*[@id='id_ind_material-0-quantity']")
	private WebElement firstMaterialQty;

	@FindBy(xpath=".//label[text()='Remarks']/following::textarea[@id='id_indent-instructions']")
	public WebElement indentRemark;

	@FindBy(id="save_indent_button") WebElement saveIndent;

	@FindBy(xpath=".//p[text()='Please add atleast one material']")
	private WebElement materialReqWarning_Indent;

	@FindBy(xpath=".//p[text()='Please add atleast one material to the Issue']")
	private WebElement materialReqWarning_Issue;

	@FindBy(xpath=".//*[@id='edit_indent_form']/div[2]/div/div[1]/div/span[2]")
	private WebElement indentNo_AddPage;

	@FindBy(xpath="//span[@class='page_header_indent']/span")
	private WebElement indentNo_Header;

	@FindBy(id="create_po")
	private WebElement indentPurchaseBtn;

	@FindBy(xpath=".//p[contains(text(),'One or more Order Quantity constraints has been violated for one or more Items')]")
	private WebElement indentSPQPopup;

	@FindBy(xpath=".//input[contains(@id,'po_quantity')]/following::span/i[contains(@class,'circle-down')]")
	private WebElement spqRoundDownArrow;

	@FindBy(xpath=".//input[contains(@id,'po_quantity')]/following::span/i[contains(@class,'thumbs')]")
	private WebElement spqThumbsUp;

	@FindBy(xpath=".//input[contains(@id,'po_quantity')]/following::span/i[contains(@class,'circle-up')]")
	private WebElement spqRoundUpArrow;

	@FindBy(xpath=".//div[@class='sweet-alert showSweetAlert visible']/p")
	private WebElement purchaseCreatedPopup;

	@FindBy(xpath="//*[@id='indent_bucket_view']/div/div/div/table/tbody/tr/td[14]")
	private List<WebElement> supplierBucketIndentQty;

	@FindBy(xpath="//*[@id='no-supplier']/div/table/tbody/tr/td[14]")
	private List<WebElement> otherBucketIndentQty;

	@FindBy(xpath="//*[@id='indent_bucket_view']/div/div/div/table/tbody/tr/td[15]")
	private List<WebElement> supplierBucketPoQty;

	@FindBy(xpath="//*[@id='no-supplier']/div/table/tbody/tr/td[15]")
	private List<WebElement> otherBucketPOQty;

	@FindBy(xpath="//tbody[@id='issue_table_list_tbody']/tr/td[8]")
	private List<WebElement> indentStatusList;

	@FindBy(xpath="//tbody[@id='issue_table_list_tbody']/tr/td[10]")
	private List<WebElement> BasicPOValueList;

	@FindBy(xpath="//tbody[@id='issue_table_list_tbody']/tr/td[2]/a")
	private List<WebElement> indentNoList;

	@FindBy(xpath=".//ul[@id='other_suppliers_tab']/li/a[text()='Others']")
	private WebElement OthersSupplierTab;

	@FindBy(xpath="//label[contains(text(),'Purchase Order')]")
	private List<WebElement> purchaseCheckboxes;

	@FindBy(xpath="//label[contains(text(),'Job Order')]")
	private List<WebElement> jobOrderCheckboxes;

	@FindBy(xpath="//div[@id='indent_bucket_view']//li/a")
	private List<WebElement> indentPOsupplierBucketList;

	@FindBy(xpath="//input[@name='po_quantity']")
	private List<WebElement> poQtyIndentPOPage;

	@FindBy(xpath="//div[contains(text(),'required field')]/preceding::span[contains(text(),'--Select Supplier--')][1]")
	private WebElement selectSupplierSplitPopup;

	@FindBy(xpath="//div/ul/li[@class='active-result']")
	private List<WebElement> supplierList;

	@FindBy(xpath="//input[@name='supp_material_price']")
	private List<WebElement> materialPriceTxtSplitPopup;

	@FindBy(xpath="//select[contains(@id,'order_type')]")
	private List<WebElement> poTypeDropDwn_Other;

	@FindBy(id="addSupplier")
	private WebElement addSupplierBtn;

	@FindBy(xpath="//input[@name='material_qty']")
	private List<WebElement> materialQtyTxtSplitPopup;

	@FindBy(id="btn_save_split_supplier")
	private WebElement splitSupplierBtn;

	@FindBy(xpath="//a[@class='btn btn-cancel'][contains(text(),'Close')]")
	WebElement PoListPopupClose;

	@FindBy(xpath="//td[contains(text(),'Total Purchase price')]/following::td[1]")
	private WebElement totalPriceEditPge;

	@FindBy(xpath=".//li[contains(text(),'Hint')]/following::div[1]/a") WebElement othersBucketAmtValue;

	@FindBy(xpath=".//a[@data-original-title='Back']") WebElement backButton;

	@FindBy(xpath=".//*[@id='icdList']/tbody/tr/td[3]/a") List<WebElement> grnNoList;

	@FindBy(xpath=".//*[@id='issue_table_list_tbody']/tr[1]/td[2]/a") WebElement firstIndent;

	@FindBy(xpath=".//*[@id='issue_table_list_tbody']/tr/td[2]/a")
	public List<WebElement> indentList;

	@FindBy(xpath=".//*[@id='po_list']/tbody/tr/td[5]")
	public List<WebElement> othersBucketPonoList;

	@FindBy(xpath=".//*[@id='po_list']/tbody/tr/td[12]/form")
	public List<WebElement> othersBucketStatusList;

	@FindBy(id="filter_textbox")
	public WebElement filterText;

	@FindBy(xpath="//a/mark[1]/preceding::td[1]/span")
	private WebElement indentSNo;

	@FindBy(xpath="//a/mark[1]/preceding::td[1]/span/span[3]/i")
	private WebElement deleteIndent;

	@FindBy(xpath="//div[@class='btn btn-save']")
	public WebElement addBtn_ShortageList;

	@FindBy(xpath=".//table[contains(@id,'materialtable')]/tbody[1]/tr/td/input[@name='hsn_code']")
	public WebElement grnMaterialTable;

	@FindBy(xpath="//i[@data-original-title='Indent View']")
	public WebElement iIndentView;

	@FindBy(xpath=".//*[@id='id_ind_material-0-deleteIndMaterial']/i")
	private WebElement firstMaterialDelete;

	@FindBy(xpath="//p[contains(text(),'Material has been returned against this issue.')]")
	private WebElement materialDeleteWarning;

	@FindBy(xpath="//h2[contains(text(),'Material has been returned against this issue.So this material Qty cannot be reduced below the returned Qty!')]")
	private WebElement warningPop_ReduceQty;

	@FindBy(xpath=".//button[text()='Yes, delete it!']")
	private WebElement yesButton;

	@FindBy(xpath=".//span[text()='ALL']")
	private WebElement projectDropDown;

	@FindBy(xpath=".//*[@id='projectmain_chosen']/div/ul/li")
	private List<WebElement> indentProjectViewList;

	@FindBy(xpath=".//*[@id='projectmain_chosen']/div/div/input")
	private WebElement projectSearchField;

	@FindBy(xpath=".//input[@value='Search']")
	private WebElement searchBtn;

	@FindBy(id="btn-sa-confirm")
	private WebElement okBtn;

	@FindBy(xpath=".//span[text()='ALL']")
	private WebElement searchProjectDropDwn;

	@FindBy(xpath=".//*[@id='search_project_chosen']/div/div/input")
	private WebElement projectSearchTextField;

	@FindBy(id="reportrange")
	private WebElement dateCalendarDrpDown;

	@FindBy(xpath=".//li[text()='Last 30 Days']")
	private WebElement last30Days;

	@FindBy(xpath=".//li[text()='Current Month']")
	private WebElement currentMonth;

	@FindBy(xpath=".//li[text()='Current Year']")
	private WebElement currentYear;

	@FindBy(xpath=".//li[text()='Current Financial Year']")
	private WebElement currentFinancialYear;

	@FindBy(xpath=".//li[text()='Custom Range']")
	private WebElement currentRange;

	@FindBy(xpath=".//th[@class='prev available']")
	private WebElement prevMonth;

	@FindBy(xpath=".//th[@class='next available']")
	private WebElement nextMonth;

	@FindBy(xpath=".//div[@class='calendar left']/div/input[@name='daterangepicker_start']")
	private WebElement fromDate;

	@FindBy(xpath=".//div[@class='calendar right']/div/input[@name='daterangepicker_end']")
	private WebElement toDate;

	@FindBy(xpath=".//div[@class='calendar left']/div[2]/table/thead/tr/th[2]/select[@class='monthselect']")
	private WebElement calendarLeft_Month;

	@FindBy(xpath=".//div[@class='calendar right']/div[2]/table/thead/tr/th[2]/select[@class='monthselect']")
	private WebElement calendarRight_Month;

	@FindBy(xpath=".//div[@class='calendar left']/div[2]/table/thead/tr/th[2]/select[2]")
	private WebElement calendarLeft_Year;

	@FindBy(xpath=".//div[@class='calendar right']/div[2]/table/thead/tr/th[2]/select[2]")
	private WebElement calendarRight_Year;

	@FindBy(xpath=".//*[@id='reportrange']/span")
	private WebElement dateRange;

	@FindBy(xpath=".//span[contains(text(),'Indents found:')]/following::span[1]")
	private WebElement indentsFound;

	@FindBy(xpath=".//*[@id='indentList_info']/b")
	private WebElement indentFetched;

	@FindBy(xpath=".//*[@id='issue_table_list_tbody']/tr/td[3]")
	private List<WebElement> indentProjectColList;

	@FindBy(xpath=".//button[text()='Yes, do it!']")
	private WebElement bYesDoIt;

	@FindBy(xpath=".//*[@id='grnList']/tbody/tr/td[4]/a")
	public  List<WebElement> grnList;

	@FindBy(xpath=".//*[@id='grnList']/tbody/tr/td[5]/span")
	public  List<WebElement> grnRefDocNoCol;

	@FindBy(xpath=".//*[@id='grnList']/tbody/tr/td[13]/a")  List<WebElement> grnStatusList;

	@FindBy(xpath=".//*[@id='project_chosen']/a/span")
	private WebElement selectProject;

	@FindBy(xpath=".//span[@class='header_current_page']")
	private WebElement grnDraft_EditPage;

	@FindBy(xpath=".//select[@id='issueno']/following::div[1]/button")
	private WebElement issueNoDropDwnField;

	@FindBy(xpath="//textarea[@id='txtremarks']/preceding::span[contains(text(),'remarks')]")
	private WebElement remarksLink_EditPge;

	@FindBy(xpath="//div[@id='remarks_list']//span[3]")
	private List<WebElement> remarksDescription;

	@FindBy(xpath="//h4[text()='Remarks']/preceding::button[1]")
	private WebElement remarksPopupCloseBtn;

	@FindBy(xpath="//tbody/tr/td[1]/div[1]/a[1]/span")
	public  List<WebElement> oaNoDropDwnMatGridList;

	@FindBy(xpath="//*[@id='materialtable']/tbody/tr/td[6]/a[1]/i[1]")
	public  List<WebElement> irnDeleteList;

	@FindBy(xpath="//*[@id='materialtable']/tbody/tr/td[1]")
	public  List<WebElement> materialReceivedList;

	@FindBy(xpath="//*[@id='dc_materialtable']/tbody/tr/td[3]")
	public  List<WebElement> materialRetIRNList;

	@FindBy(xpath="//table[@id='dc_materialtable']/tbody/tr/td[2]")
	public  List<WebElement> dcMaterialGridList;

	@FindBy(xpath="//table[@id='materialtable']/tbody/tr/td[1][contains(@class,'doc_code')]")
	public  List<WebElement> poMaterialGridList;

	@FindBy(id="id_note_preview")
	private WebElement notePreviewBTn;

	@FindBy(xpath="//td/div/a/span[text()='Select OA']/following::td[3]/input")
	public  List<WebElement> materialDCQtyWOOa;

	@FindBy(xpath="//td/div/a/span[text()='Select OA']/following::td[4]/input")
	public  List<WebElement> materialRecQtyWOOa;

	@FindBy(xpath="//td/div/a/span[text()='Select OA']/following::td[5]/input")
	public  List<WebElement> materialAccepQtyWOOa;

	@FindBy(xpath="//table[@id='grn_note_preview_table']/tbody/tr/td[4]")
	public  List<WebElement> notePreviewQtyList;

	@FindBy(xpath="//table[@id='grn_note_preview_table']/tbody/tr/td[5]")
	public  List<WebElement> notePreviewRateList;

	@FindBy(xpath="//table[@id='grn_note_preview_table']/tbody/tr/td[6]")
	public  List<WebElement> notePreviewAmtList;

	@FindBy(xpath="//table[@id='grn_note_preview_table']/tbody/tr/td[7]")
	public  List<WebElement> notePreviewCGSTList;

	@FindBy(xpath="//table[@id='grn_note_preview_table']/tbody/tr/td[8]")
	public  List<WebElement> notePreviewSGSTList;

	@FindBy(xpath="//table[@id='grn_note_preview_table']/tbody/tr/td[9]")
	public  List<WebElement> notePreviewIGSTList;

	@FindBy(xpath="//h4[text()='Note Preview']/preceding::button[1]")
	public  WebElement closePreviewBtn;

	@FindBy(xpath="//table[@id='grn_note_preview_table']/tbody/tr/td[text()='Note Value']/following::td[1]")
	private WebElement noteValue;

	@FindBy(xpath="//div[@id='tab_invoice']//tr//td[1]")
	private List<WebElement> MaterialTabPoNoList;

	@FindBy(id="id-invoicedItems")
	private WebElement itemsInvoicedBtn;

	@FindBy(id="recagainst")
	private WebElement receivedAgainstDropDwn;

	@FindBy(xpath=".//button[contains(@class,'btn-filter')]")
	public WebElement btnFilter;

	@FindBy(id="rec_against")
	public WebElement receivedAgainstDropDwnViewtab;

	@FindBy(id="loadgrns")
	public WebElement searchGRN;

	@FindBy(id="cmdSaveAndApprove")
	private WebElement saveNdApproveBtn;

	@FindBy(xpath=".//*[@id='id_invoice_project_code_chosen']/div/div/input")
	private WebElement searchInvoiceProject;

	@FindBy(xpath=".//*[@id='supplier_chosen']/a/span")
	private WebElement selectParty;

	@FindBy(xpath=".//label[contains(text(),'Received From')]/a/i")
	private WebElement superEditIconParty;

	@FindBy(xpath=".//*[@id='supplier_chosen']/div/div/input")
	private WebElement searchParty;

	@FindBy(xpath=".//*[@id='po_div']/div/ul/li/a/label/input")
	private List<WebElement> purchaseOrderCheckBx;

	@FindBy(xpath=".//*[@id='po_div']/div/ul/li/a/label")
	private List<WebElement> purchaseOrder;

	@FindBy(xpath=".//*[@id='party_div']/div/ul/li/a/label")
	private List<WebElement> partyDcNo;

	@FindBy(xpath="//span[@class='consolidated_material_name']")
	private List<WebElement> MaterialListPartyDcNo;

	@FindBy(xpath="//tr/td/select[@name='select_oa_id']/following::div[1]/a/span")
	private List<WebElement> oaDropDwnEditPge;

	@FindBy(xpath="//table[@id='materialtable']/tbody/tr[2]/td[1]")
	private WebElement firstMaterialPONo;

	@FindBy(xpath="//tr[contains(@id,'grn_mat')]/td[7]")
	private List<WebElement> materialReturnedList;

	@FindBy(xpath="//div[@id='po_div']/div/button[@type='button']")
	private WebElement purchaseOrderDropDwn;

	@FindBy(xpath=".//input[@placeholder='Search']")
	private WebElement searchTxtPurchaseDrpDwn;

	@FindBy(xpath="//div[@id='party_div']/div/button[@type='button']")
	private WebElement partyDcDropDwn;

	@FindBy(id="purchase_account")
	private WebElement indentType;

	@FindBy(id="invno")
	private WebElement invoiceNo;

	@FindBy(xpath="//label[contains(text(),'Goods Already Received')]")
	private WebElement cGoodsAlreayReceived;

	@FindBy(xpath="//div/a[text()='Invoice']")
	private WebElement tInvoicetoggle;

	@FindBy(xpath="//div/a[text()='DC']")
	private WebElement tDCtoggle;

	@FindBy(xpath="//input[@id='invdateNew']")
	private WebElement invoiceDateField;

	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='prev'][contains(text(),'�')]")
	private WebElement invoiceDatePrevMnth;

	@FindBy(xpath="//div[contains(@class,'days')]//td[contains(text(),'14')]")
	private WebElement invoiceDate;

	@FindBy(id="recthrough")
	private WebElement invoiceReceivedThro;

	@FindBy(id="id_gstin")
	private WebElement gstin;

	@FindBy(xpath="//span[@data-default='DC / INVOICE COPY']/following::i[1]")
	private WebElement removeAttachment;

	@FindBy(xpath="//span[@data-default='DC / INVOICE COPY']")
	private WebElement invoiceAttachment;

	@FindBy(xpath="//tbody/tr[1]/td[7]/span[1]/i[1]")
	private WebElement acceptWarningMatReturned;

	@FindBy(xpath="//div[contains(@id,'qtip')]/ul/li")
	private List<WebElement> tooltipWarning;

	@FindBy(id="txtrejremarks")
	private WebElement rejectionRemarksTxtField;

	@FindBy(id="txtremarks")
	private WebElement remarksTxtField;

	@FindBy(id="inwardno")
	private WebElement grnInwardNo;

	@FindBy(id="inspector_chosen")
	private WebElement grnInspectorName;

	@FindBy(xpath=".//*[@id='inspector_chosen']/div/div/input")
	private WebElement inspectorSearchText;

	@FindBy(id="packing_charges")
	private WebElement packingChargesTxtField;

	@FindBy(id="transport_charges")
	private WebElement transportChargesTxtField;

	@FindBy(id="txtothers")
	private WebElement othersTxtField;

	@FindBy(id="txt_duty_passed")
	private WebElement dutyPassedTxtField;

	@FindBy(id="txtnetvalue")
	private WebElement grnGrandTotal;

	@FindBy(id="txtround_off")
	private WebElement grnRoundOff;

	@FindBy(id="cmdSavegrn") WebElement addBtn;

	@FindBy(id="id-back_to_list") WebElement backBtn;

	@FindBy(id="id-materialUsage") WebElement materialUsageBtn;

	@FindBy(id="cmdSaveInvoice") WebElement issueSaveBtn;

	@FindBy(xpath="//a[contains(@class,'super_user')]")
	private WebElement issueNoEditIcon;

	@FindBy(id="inv_number") WebElement issueNoEdit_SuperEdit;

	@FindBy(xpath="//span[@class='super_edit_save']/i")
	private WebElement saveIconIssueNo_SuperEdit;

	@FindBy(xpath="//h4[contains(text(),'Material Usage')]")
	private WebElement materialUsagePopup;

	@FindBy(xpath="//a[contains(text(),'Go Back & Link OA')]/following::input")
	private WebElement continueBtn;

	@FindBy(xpath="//input[contains(@id,'item_name')][@name='oa_item_name']")
	private List<WebElement> oaMaterialNameTxt;

	@FindBy(xpath="//input[contains(@id,'item_hsn_code')]")
	private List<WebElement> oaHSNTxtField;

	@FindBy(xpath="//input[contains(@id,'item_qty')]")
	private List<WebElement> oaQtyTxtField;

	@FindBy(xpath="//input[contains(@id,'item_price')]")
	private List<WebElement> oaItemPriceList;

	@FindBy(xpath="//td/input[@value='Add']")
	private WebElement oaMaterialAddBtn;

	@FindBy(xpath="//input[@name='totalprice']")
	private List<WebElement> totalPriceList;

	@FindBy(xpath="//span[@name='cgstamt']")
	private List<WebElement> cgstAmtList;

	@FindBy(xpath="//span[@name='sgstamt']")
	private List<WebElement> sgstAmtList;

	@FindBy(xpath="//span[@name='igstamt']")
	private List<WebElement> igstAmtList;

	@FindBy(xpath="//td[@class='consolidated_price_column']//span[@name='cgstamt']")
	private List<WebElement> cgstAmtList_goods;

	@FindBy(xpath="//td[@class='consolidated_price_column']//span[@name='sgstamt']")
	private List<WebElement> sgstAmtList_goods;

	@FindBy(xpath="//td[@class='consolidated_price_column']//span[@name='igstamt']")
	private List<WebElement> igstAmtList_goods;

	@FindBy(xpath=".//*[@id='po_taxes_table']/tbody/tr/td[3]/input")
	private List<WebElement> poAddedTaxList;

	@FindBy(xpath="//*[@id='materialtable']/tbody/tr/td[1]/div[1]")
	private List<WebElement> selectOADrpDwn;

	@FindBy(xpath="//table[@id='materialtable']/tbody/tr/td/span[@name='pending_qty']")
	private List<WebElement> pendingQtyGRN;

	@FindBy(xpath="//table[@id='materialtable']/tbody/tr/td/input[@name='dc_qty']")
	private List<WebElement> dcInvoiceQtyList;

	@FindBy(xpath="//table[@id='dc_materialtable']/tbody/tr/td/input[@name='dc_qty']")
	private List<WebElement> dcReturnedInvoiceQtyList;

	@FindBy(xpath=".//table[@id='dc_materialtable']/tbody/tr/td[3]")
	private List<WebElement> returnedMatList;

	@FindBy(xpath="//div[@id='tab_dc']//tr//td[2]") List<WebElement> returnedJDCNoList;

	@FindBy(xpath="//table[@id='dc_materialtable']/tbody/tr/td/span[@name='pending_qty']")
	private List<WebElement> pendingReturnedQtyList;

	@FindBy(xpath="//table[@id='dc_materialtable']/tbody/tr/td/input[@name='rec_qty']")
	private List<WebElement> receivedReturnedQtyList;

	@FindBy(xpath="//table[@id='materialtable']/tbody/tr/td/input[@name='rec_qty']")
	private List<WebElement> receivedQtyList;

	@FindBy(xpath="//table[@id='dc_materialtable']/tbody/tr/td/input[@name='acc_qty']")
	private List<WebElement> acceptedReturnedQtyList;

	@FindBy(xpath="//table[@id='materialtable']/tbody/tr/td/input[@name='acc_qty']")
	private List<WebElement> acceptedQtyList;

	@FindBy(xpath="//tbody/tr/td[4]/span[contains(@class,'total_accept_qty')]")
	private List<WebElement> acceptedQtyList_Goods;

	@FindBy(xpath="//td[@class='consolidated_price_column']//input[@name='price']")
	private List<WebElement> priceConsolidate_goods;

	@FindBy(xpath="//td[@class='consolidated_price_column']//input[@name='discount']")
	private List<WebElement> discountConsolidate_goods;

	@FindBy(xpath="//td[@name='tot_price_col']//input[@name='totalprice']")
	private List<WebElement> totalPriceConsolidate_goods;

	@FindBy(xpath="//input[@name='price']")
	private List<WebElement> PriceList;

	@FindBy(xpath="//input[@name='discount']")
	private List<WebElement> discountList;

	@FindBy(xpath=".//select[@name='cgst']")
	private List<WebElement> CGSTDropDwn;

	@FindBy(xpath=".//select[@name='sgst']")
	private List<WebElement> SGSTDropDwn;

	@FindBy(xpath=".//select[@name='igst']")
	private List<WebElement> IGSTDropDwn;

	@FindBy(xpath="//td[@class='consolidated_price_column']//select[@name='cgst']")
	private WebElement CGSTDropDwn_goods;

	@FindBy(xpath="//td[@class='consolidated_price_column']//select[@name='sgst']")
	private WebElement SGSTDropDwn_goods;

	@FindBy(xpath="//td[@class='consolidated_price_column']//select[@name='igst']")
	private WebElement IGSTDropDwn_goods;

	@FindBy(xpath=".//span[contains(text(),'NA')]")
	private WebElement taxDropDwn;

	@FindBy(xpath=".//*[@id='id_po_tax_chosen']/div/div/input")
	private WebElement taxSearch;

	@FindBy(xpath=".//*[@id='po_taxes_table']/tbody/tr/th[2]/b")
	private List<WebElement> addedTax;

	@FindBy(id="add_po_tax")
	private WebElement addTaxBtn;

	@FindBy(xpath=".//a[@title='Remove Tax']/i")
	private WebElement deleteTax;

	@FindBy(id="view_receipt_document") WebElement approveRejectBtn;

	@FindBy(id="approve_grn")
	private WebElement approveGRNBtn;

	@FindBy(xpath="//div[@id='grn_document_modal']//button[@class='close'][contains(text(),'�')]")
	private WebElement closeBtn;

	@FindBy(xpath="//p[contains(text(),'GRN cannot be rejected')]")
	private WebElement rejectWarningpopup;

	@FindBy(id="reject_grn")
	private WebElement rejectGRNBtn;

	@FindBy(id="remarks")
	private WebElement tRejectRemarks;

	@FindBy(xpath="//h4[contains(text(),'Preview Document')]")
	private WebElement grnPDF;

	@FindBy(xpath="//span[contains(text(),'remarks')]")
	private WebElement remarksLink;

	@FindBy(xpath="//p/div/div/span[3]")
	private List<WebElement> availableRemarks;

	@FindBy(xpath="//span[contains(text(),'remarks')]/preceding::span[1]")
	private WebElement remarksCount;

	@FindBy(xpath=".//h5[text()='Materials Returned']") WebElement materialsReturnedTab;

	@FindBy(xpath=".//h5[text()='Materials Received']") WebElement materialsReceivedTab;

	@FindBy(id="cmdUpdateGRN") WebElement UpdateBtn;

	@FindBy(xpath=".//p[contains(text(),'Minimum Stock Level')]")
	private WebElement MSLWarning;

	@FindBy(xpath="//p[contains(text(),'Please atleast add one or more material quantity to continue.')]")
	private WebElement NoMatWarning;

	@FindBy(xpath=".//td/a[1]")
	public List<WebElement> preparedOn;

	@FindBy(xpath="//a[text()='Items Returned ']") WebElement materialsReturnedBtn;

	@FindBy(xpath="//a[text()='Items Not Returned ']")
	private WebElement materialsNotReturnedBtn;

	@FindBy(xpath="//h4[contains(text(),'Items')]") WebElement returnMaterialPopup;

	@FindBy(xpath="//h4[contains(text(),'Items Invoiced')]")
	private WebElement itemsInvoicedMaterialPopup;

	@FindBy(xpath="//div[@id='returnMaterial']//button[@class='close'][contains(text(),'�')]") WebElement returnMaterialPopupClose;

	@FindBy(xpath=".//h4[text()='Items Invoiced']/following::a[text()='Close']")
	private WebElement itemsInvoicedMaterialPopupClose;

	@FindBy(xpath="//div[@id='usageReport']//a[text()='Close']")
	private WebElement materialUsageClose;

	@FindBy(xpath=".//table[@id='return_material_list']/tbody/tr/td[2]") List<WebElement> returnedMaterialGRNNoList;

	@FindBy(xpath=".//table[@id='return_material_list']/tbody/tr/td[4]") List<WebElement> returnedMaterialPopupList;

	@FindBy(xpath=".//table/tbody/tr/td[2]/a")
	private List<WebElement> itemsInvoicedMaterialGRNNoList;

	@FindBy(xpath=".//table[@id='usageReportTable']/tbody/tr/td[4]")
	private List<WebElement> materialUsageMaterils;

	@FindBy(xpath=".//*[@id='issue_table_list_tbody']/tr[1]/td[3]/a") WebElement firstIssueNo;

	@FindBy(xpath=".//span[contains(text(),'New Issue')]")
	private WebElement newPage;

	@FindBy(xpath=".//*[@id='id_invoice_project_code_chosen']/a/span")
	private WebElement projectDropDwn;

	@FindBy(xpath=".//*[@id='id_invoice_issued_for_chosen']/a")
	private WebElement issueForDropdwn;

	@FindBy(xpath="//table[@id='invoice_materials_table']/tbody/tr/td[5]/span[@class='item_description']")
	private List<WebElement> matListGridMatCheck_Issue;

	@FindBy(xpath="//table[@id='invoice_materials_table']/tbody/tr/td[9]/div/span/input[@placeholder='Quantity']")
	private List<WebElement> matListGridQtyCheck_Issue;

	@FindBy(xpath=".//*[@id='id_invoice_issued_for_chosen']/div/div/input")
	private WebElement issueForDropdwn_Search;

	@FindBy(id="invoice_issued_on_date")
	private WebElement issuedOnDateDropDwn;

	@FindBy(xpath="//td[@class='day today active']")
	private WebElement dateSelect;

	@FindBy(xpath="//td[contains(@class,'day active')]/preceding::td[1]")
	private WebElement updateIssueDate;

	@FindBy(xpath="//span[contains(@class,'hour_am')][contains(text(),'10')]")
	private WebElement updateTimeHrSelect;

	@FindBy(xpath="//span[contains(@class,'minute')][contains(text(),'10:20')]")
	private WebElement updateTimeSelect;

	@FindBy(xpath="//span[contains(@class,'hour_am')][contains(text(),'9')]")
	private WebElement timeHrSelect;

	@FindBy(xpath="//span[contains(@class,'minute')][contains(text(),'9:10')]")
	private WebElement timeSelect;

	@FindBy(xpath=".//*[@id='id_invoice_issued_to_chosen']/a")
	private WebElement issueToDropdwn;

	@FindBy(xpath=".//*[@id='id_invoice_issued_to_chosen']/div/div/input")
	private WebElement issueToDropdwn_search;

	@FindBy(xpath="//div[@id='div_issueno']//div[1]/div/button")
	private WebElement issueNoYrDrpDwn;

	@FindBy(xpath="//div[@id='div_issueno']//div[2]/div/button")
	private WebElement issueNoDrpDwn;

	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement issueNoSearch;

	@FindBy(xpath=".//div[@id='div_issueno']/div[1]/div/ul/li/a/label")
	private List<WebElement> issueNoYrOptionDrpDwnList;

	@FindBy(xpath=".//div[@id='div_issueno']/div[1]/div/ul/li[@class='active']/a/label")
	private List<WebElement> selectedIssueNoYrOp;

	@FindBy(xpath="//div[@id='div_issueno']/div[2]/div/ul/li")
	private List<WebElement> issueNoOptionDrpDwnList;

	@FindBy(xpath="//div[@id='div_issueno']/div[2]/div/ul/li[@class='active']")
	private List<WebElement> selectedIssueNo;

	@FindBy(xpath=".//span[text()='Issue for is required.']")
	private WebElement issueFor_Mandatory;

	@FindBy(xpath=".//span[text()='Issue to is required.']")
	private WebElement issueTo_Mandatory;

	@FindBy(xpath="//span[contains(text(),'Date is required.')]")
	private WebElement dateMandatoryErr;

	@FindBy(xpath=".//span[text()='Material Name is required.']")
	private WebElement materialName_Mandatory;

	@FindBy(xpath=".//div/span[2][text()='Quantity is required.']")
	private WebElement quantity_Mandatory;

	@FindBy(id="closing_qty")
	private WebElement materialAvailQty;

	@FindBy(id="id_invoice_mat-__prefix__-quantity")
	private WebElement materialReqQtyTxt;

	@FindBy(xpath=".//*[@id='project_chosen']/div/div/input")
	private WebElement searchProject;

	@FindBy(xpath="//h4[contains(text(),'OA Materials')]")
	private WebElement viewOAMaterialsPopup;

	@FindBy(xpath="//*[@name='oa_qty']")
	private List<WebElement> oaQtyList;

	@FindBy(xpath="//*[@name='discount']")
	private List<WebElement> oaDiscountList;

	@FindBy(id="id-popActionButton")
	private WebElement addBtnOaPopup;

	@FindBy(id="qty")
	private WebElement materialReqQtyTxtGRN;

	@FindBy(id="hsn_code")
	private WebElement materialHSNTxtGRN;

	@FindBy(xpath="//table[@id='materialtable']//input[@name='hsn_code']")
	private List<WebElement> grnHSNCodeList;

	@FindBy(xpath="//table[@id='dc_materialtable']//input[@name='hsn_code']")
	private List<WebElement> grnHSNCodeList_MatRet;

	@FindBy(xpath="//tr/td[6]/input[@name='hsn_code']")
	private List<WebElement> viewOaMaterialHSn;

	@FindBy(xpath="//tr/td[6]/input[@name='hsn_code']")
	private List<WebElement> grnHSNCodegoodsList;

	@FindBy(id="add_invoice_item")
	private WebElement materialAdd;

	@FindBy(xpath=".//p[text()='Item has already been added to the Invoice. ']")
	private WebElement itemAlreadyExists;

	@FindBy(xpath=".//p[contains(text(),'Stock ')]")
	private WebElement stockNotAvail;

	@FindBy(id="cmdadd")
	private WebElement materialAddBTNGRN;

	@FindBy(id="unitChoices")
	private WebElement unitDropDwn;

	@FindBy(id="id_invoice_mat-__prefix__-remarks")
	private WebElement issueMaterialRemarks;

	@FindBy(xpath=".//span[@id='div_remarks']/span[text()='+ Add Remarks']")
	 WebElement addRemarks;

	@FindBy(id="id_invoice-remarks")
	private WebElement issueRemarksTxt;

	@FindBy(xpath=".//p[text()='Issue Saved Successfully']")
	private WebElement issueSavedPopup;

	@FindBy(xpath=".//button[text()='OK']")
	private WebElement okButton;

	@FindBy(xpath="//table[@id='materialtable']/tbody/tr/td[3]/div/span/i")
	private WebElement removeMaterialName;

	@FindBy(xpath=".//p[text()='Selected material Already Exist']")
	private WebElement MaterialAlreadyExists;

	@FindBy(xpath=".//a[text()='VIEW']") WebElement viewTab;

	@FindBy(xpath="//a[contains(@id,'deleteInvoiceMaterial')]")
	private List<WebElement> deleteMaterialBtn;

	@FindBy(xpath="//table[@id='invoice_materials_table']//div/input[contains(@id,'quantity')]")
	private List<WebElement> issueQtyList;

	@FindBy(xpath="//tbody/tr[contains(@id,'invoice_mat')]/td[2]/span[1]")
	private List<WebElement> issueSno;

	@FindBy(xpath=".//*[@id='materialtable']/tbody/tr/td[2]")
	private List<WebElement> firstMaterial;

	@FindBy(xpath=".//p[text()='Issue Updated Successfully']")
	private WebElement issueUpdatePopup;

	@FindBy(id="reportview") WebElement reportView;

	@FindBy(id="reportname")
	private WebElement reportsDropDwn;

	@FindBy(xpath=".//*[@id='Closing_Stock']/div[2]/div/div/table/thead")
	private WebElement closingStockColumnNames;

	@FindBy(xpath=".//*[@id='Po_Pending']/div[2]/div/table/thead")
	private WebElement poReportColumnNames;

	@FindBy(xpath=".//*[@id='Ind_Pending']/div[2]/div/table/thead")
	private WebElement indentPendingColumnNames;

	@FindBy(xpath=".//*[@id='indentList']/thead")
	private WebElement indentColumnNames;

	@FindBy(xpath=".//*[@id='issue_table_list']/thead")
	private WebElement issueColumnNames;

	@FindBy(xpath=".//*[@id='tablesorter']/thead")
	private WebElement dcReportsColumnNames;

	@FindBy(id="grnreportview") WebElement grnReportView;

	@FindBy(xpath=".//div[contains(@class,'scrollHeadInner')]/table[@aria-describedby='tablesorter_info']/thead/tr[@class='exclude_export']/th")
	private List<WebElement> grnReportColumns;

	@FindBy(xpath=".//button[contains(@class,'btn-filter')]")
	private WebElement filterBtn;

	@FindBy(xpath=".//label[text()='Exclude Drafts']")
	private WebElement excludeDrafts;

	@FindBy(id="dcreportview") WebElement dcReportView;

	@FindBy(id="refresh") WebElement materialReportViewReportBtn;

	@FindBy(xpath="//tr//a")
	private List<WebElement> receiptNoColumn;

	@FindBy(xpath=".//*[@id='item_details_chosen']/a/span")
	private WebElement materialNameDropDwn;

	@FindBy(xpath=".//*[@id='item_details_chosen']/div/div/input")
	private WebElement searchMaterialName;

	@FindBy(xpath=".//*[@id='report-table']/thead/tr[1]")
	private WebElement materialReportColumns; //Material receipt column

	@FindBy(xpath=".//*[@id='report-table']/thead/tr[1]/th")
	private List<WebElement> shortageReportColumns;

	@FindBy(xpath=".//div[contains(text(),'Material List')]") WebElement materialListBtn;

	@FindBy(xpath=".//label[text()='Select All']")
	private WebElement selectAllCheckBx;

	@FindBy(id="save_material_list") WebElement ViewReportBtn;

	@FindBy(xpath=".//div[contains(text(),'Selected items')]/span")
	private WebElement selectedItemCount;

	@FindBy(id="apply-shortage-list") WebElement applyShortageBTN;

	@FindBy(xpath="//div[@class='view_table add_table']//tr//td//span[@class='drag_serial_number']")
	private List<WebElement> shortageListTable;

	@FindBy(id="id-search_isr")
	 WebElement jobInReportApplyBtn;

	@FindBy(xpath=".//div[contains(@class,'scrollHeadInner')]//tr[@class='exclude_export']/th")
	List<WebElement> JobInOutReportColumnNames;

	@FindBy(xpath=".//tr[1]/td[2]/form/a") WebElement firstIssueOrIssueNo;

	@FindBy(id="cmdcancel") WebElement issueCancelBtn;

	@FindBy(id="short_close") WebElement shortCloseLnk;

	@FindBy(xpath=".//*[contains(@id,'po_qtyLabel')]")
	private List<WebElement> poQtyList;

	@FindBy(xpath=".//td/input[contains(@id,'quantity')][contains(@id,'id_ind')]")
	private List<WebElement> indentQtyList;

	@FindBy(id="po_list_info")
	private WebElement poVisibleRecordCount;

	@FindBy(xpath="//table[contains(@id,'issue_stock_report')]/thead")
	WebElement internalStockFlowColNames;

	String sNormalDate = Constant.NormalDateFormat().substring(3, 5);
	int iDate = Integer.parseInt(sNormalDate);
	DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
	Date date1 = new Date();
	String sCurrentDate = dateFormat.format(date1);
	String sDate = Constant.DateTimeFormat();
	Calendar cal = Calendar.getInstance();

	private WebDriver driver;
	public StorePage(WebDriver driver){
		this.driver = driver;
	}

	public boolean verifyAddIndent(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load Indent view page");
			String sIndentValue = totalRecords.getText();
			if(sIndentValue.endsWith("0")){
				sIndentValue = "0";
			}else{
				sIndentValue = recordCount.getText();
			}
			addIndent(iRowNo, sheet);
			String sIndentActValue = recordCount.getText();
			if(Integer.parseInt(sIndentValue) < Integer.parseInt(sIndentActValue)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("verification of indent addition failed"+e);
		}
		return flag;
	}

	public String addIndent(int iRowNo, String sheet) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sType = xls.get(iRowNo).get("Indent Type");
		String sProject = xls.get(iRowNo).get("Project");
		String sIndentNo_AddPage = null;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		boolean flag1 = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(addIndentIcon), "Failed to load Indent view page");
			addIndentIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(indentForTxt.isDisplayed()){
				indentForTxt.sendKeys("Test"+sDate);
				indentTypeDropDwn.click();
				indentTypeSearch.sendKeys(sType);
				driver.findElement(By.xpath("//ul/li/em[contains(text(),'"+sType+"')]")).click();
				indentProjectDropDwn.click();
				projectSearch.sendKeys(sProject);
				driver.findElement(By.xpath("//ul/li/em[contains(text(),'"+sProject+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				indentReqDate.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean flag2 = Constant.isElementPresent(By.xpath("html[1]/body[1]/div[contains(@class,'datepicker')]/div[1]/table[1]/tbody/tr[3]/td[4]"));
				if(flag2){
					indentNextMonth.click();
					driver.findElement(By.xpath("html[1]/body[1]/div[contains(@class,'datepicker')]/div[1]/table[1]/tbody/tr[3]/td[4]")).click();
					Thread.sleep(Constant.Min_Sleep);
				}
				indentRemark.sendKeys("Remark"+iDate);
				flag1 = addIndentStockMaterial(iRowNo,sheet);
				saveIndent.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			sIndentNo_AddPage = indentNo_Header.getText();
			String sIndentNo = driver.getTitle();
			String sPurchaseValue = totalPriceEditPge.getText().substring(3);
			backButton.click();
			String[] sTypeSplit = sType.split("]");
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load indent view page");
			boolean flag = navigate.showAllEntries();
			if(flag && flag1){
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//td/a[contains(text(),'"+sIndentNo+"')]")));
				WebElement ele = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sIndentNo+"')]/following::td[contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sCurrentDate+"')]/following::td[contains(text(),'"+sTypeSplit[1].trim()+"')]/following::td[contains(text(),'Test"+sDate+"')]/following::td[contains(text(),'"+sPurchaseValue+"')]/following::td[contains(text(),'Pending Due to PO')]"));
				if(ele.isDisplayed() && sIndentNo.contains(sIndentNo_AddPage)){
					Constant.logFile("Indent is added successfully");
				}
			}
		}catch(Exception e){
			System.err.println("Add indent failed"+e);
		}
		return sIndentNo_AddPage;
	}

	public boolean addIndentStockMaterial(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sQuantity = xls.get(iRowNo).get("Quantity");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		String sUnit = xls.get(iRowNo).get("Unit");
		String sDrawingNo = xls.get(iRowNo).get("Drawing No");
		try{
			if(!(sMaterial == null)){
				String[] sMaterialList = sMaterial.split(",");
				for (String element : sMaterialList) {
					materialReqTxt.sendKeys(element.trim());
					Thread.sleep(Constant.Min_Sleep);
					driver.findElement(By.xpath(".//ul/li/a[contains(text(),'"+element.trim()+"')]")).click();
					Thread.sleep(Constant.Min_Sleep);
					quantityTxt.sendKeys(sQuantity);
					if(sAltUnit.contains("Yes")){
						alternateUnit.click();
						alternateUnitOptions.click();
					}
					addMaterial.click();
					Thread.sleep(Constant.Min_Sleep);
					if(driver.findElement(By.xpath(".//div[contains(text(),'"+element.trim()+"')]")).isDisplayed()){
						flag = true;
					}
				}
			}else{
				materialReqTxt.sendKeys(sDrawingNo+sDate);
				Thread.sleep(Constant.Min_Sleep);
				quantityTxt.click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				quantityTxt.sendKeys(sQuantity);
				Select select = new Select(unitDropdown);
				select.selectByVisibleText(sUnit);
				addMaterial.click();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.findElement(By.xpath(".//div[contains(text(),'"+sDrawingNo+sDate+"')]")).isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add stock material "+e);
		}
		return flag;
	}

	public boolean updateIndent(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load indent view page");
			String indentNo = addIndent(iRowNo, sheet);
			int i = indentList.size();
			filterText.sendKeys(indentNo);
			driver.findElement(By.xpath(".//td/a/mark[contains(text(),'"+indentNo+"')]")).click();
			Thread.sleep(Constant.Min_Sleep);
			String sActIndentName = indentNo_Header.getText();
			indentReqDate.click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag2 = Constant.isElementPresent(By.xpath("html[1]/body[1]/div[contains(@class,'datepicker')]/div[1]/table[1]/tbody/tr[3]/td[4]"));
			if(flag2){
				driver.findElement(By.xpath("html[1]/body[1]/div[contains(@class,'datepicker')]/div[1]/table[1]/tbody/tr[3]/td[4]")).click();
				Thread.sleep(Constant.Min_Sleep);
			}
			iIndentView.click();
			Thread.sleep(Constant.Min_Sleep);
			firstMaterialDelete.click();
			yesButton.click();
			Thread.sleep(Constant.Min_Sleep);
			flag1 = addIndentStockMaterial(iRowNo,sheet);
			okBtn.click();
			if(driver.findElement(By.xpath(".//div[contains(text(),'"+sMaterial+"')]")).isDisplayed()){
				Thread.sleep(Constant.Min_Sleep);
				indentRemark.clear();
				indentRemark.sendKeys("Remark"+sDate);
				saveIndent.click();
				Thread.sleep(Constant.Min_Sleep);
				String sIndentName = indentNo_Header.getText();
				Thread.sleep(Constant.Min_Sleep);
				backButton.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load indent view page");
				navigate.showAllEntries();
				if(flag1){
					int indentActCount = indentList.size();
					if(i == indentActCount && sActIndentName.equals(sIndentName)){
						flag = true;
					}
				}
			}

		}catch(Exception e){
			System.err.println("updating indent failed "+e);
		}
		return flag;
	}

	public boolean deleteIndent(int iRowNo, String sheet) throws Exception{
		boolean flag = false,flag1;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load indent view page");
			String sIndentNo = addIndent(iRowNo, sheet);
			navigate.showAllEntries();
			int iIndentList = indentList.size();
			filterText.sendKeys(sIndentNo);
			Actions actions = new Actions(driver);
			actions.moveToElement(indentSNo).build().perform();
			actions.moveToElement(deleteIndent).click().build().perform();
			deleteIndent.click();
			Thread.sleep(Constant.Medium_Sleep);
			yesButton.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load indent view page");
			flag1 = navigate.showAllEntries();
			if(flag1){
				int iIndentActList = indentList.size();
				if(iIndentList > iIndentActList && !Constant.driver.getPageSource().contains(sIndentNo)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Indent delete failed "+e);
		}
		return flag;
	}

	public boolean indentProjectSearch(int iRowNo) throws Exception{
		boolean flag = false;
		try{
			projectDropDown.click();
			for(int i=1;i<indentProjectViewList.size();i++){
				String sProject = indentProjectViewList.get(i).getText();
				projectSearchField.sendKeys(sProject);
				Constant.driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
				searchBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				String sIndentValue = indentFetched.getText();
				if(sIndentValue.equals("0")){
					Constant.log.info("No Search result found for the search criteria");
				}else{
					for(WebElement ele:indentProjectColList){
						if(ele.getText().contains(indentProjectColList.get(i).getText())){
							flag = true;
						}

					}
				}
				driver.findElement(By.xpath(".//span[text()='"+sProject+"']")).click();
			}
		}catch(Exception e){
			System.err.println("Indent project search is not successful"+e);
		}
		return flag;
	}

	public boolean indentNumSearch(int iRowNo, String sheet){
		boolean flag = false;
		try{
			String sIndentNo = addIndent(iRowNo, sheet);
			searchTxt.sendKeys(sIndentNo);
			if(driver.findElement(By.xpath(".//a[contains(text(),'"+sIndentNo+"')]")).isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Indent number search is not successful"+e);
		}
		return flag;
	}

	public boolean indentStatusSearch(int iRowNo) throws Exception{
		boolean flag = false;
		try{
			for(int i=1;i<indentStatusList.size();i++){
				Select select = new Select(searchInDropDwn);
				select.selectByVisibleText(indentStatusList.get(i).getText());
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.driver.getPageSource().contains("No Results Found")){
					Constant.log.info("No Search result found for the search criteria");
				}else{
					for(WebElement ele:projectColList){
						if(ele.getText().contains(indentStatusList.get(i).getText())){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Indent Status search is not successful"+e);
		}
		return flag;
	}

	public boolean bomAddBtn(int iRowNo) throws Exception{
   		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Indent");
		String sType = xls.get(iRowNo).get("Indent Type");
		String sProject = xls.get(iRowNo).get("Project");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sQuantity = xls.get(iRowNo).get("Quantity");
		try{
			int iIndentCount = indentList.size();
			addIndentIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			indentForTxt.sendKeys("Test"+sDate);
			indentTypeDropDwn.click();
			indentTypeSearch.sendKeys(sType);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sType+"']")).click();
			indentProjectDropDwn.click();
			projectSearch.sendKeys(sProject);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
			materialReqTxt.sendKeys(sMaterial);
			Thread.sleep(Constant.Min_Sleep);
			Constant.driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
			quantityTxt.sendKeys(sQuantity);
			viewBomBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(viewBOMPopup.isDisplayed()){
				int iActCount = bomMaterials.size();
				addBOM.click();
				Thread.sleep(Constant.Min_Sleep);
				indentRemark.sendKeys("Remark"+sDate);
				int iAddedCount = addedMaterials.size()-1;
				Thread.sleep(Constant.Min_Sleep);
				saveIndent.click();
				Thread.sleep(Constant.Min_Sleep);
				backButton.click();
				Thread.sleep(Constant.Min_Sleep);
				int iIndentActCount = indentList.size();
				if(iActCount == iAddedCount && iIndentCount < iIndentActCount){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("BOM add button failed "+e);
		}
		return flag;
	}

	public boolean bomCancelBtn(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Indent");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sQuantity = xls.get(iRowNo).get("Quantity");
		try{
			addIndentIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			materialReqTxt.sendKeys(sMaterial);
			Thread.sleep(Constant.Min_Sleep);
			driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
			quantityTxt.sendKeys(sQuantity);
			viewBomBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(viewBOMPopup.isDisplayed()){
				cancelBnt_BOM.click();
				Thread.sleep(Constant.Min_Sleep);
				int i = addedMaterials.size();
				if(i == 1){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Cancel button in BOM pop not working "+e);
		}
		return flag;
	}

	public boolean bomMaterialDelete_Yes(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Indent");
		String sType = xls.get(iRowNo).get("Indent Type");
		String sProject = xls.get(iRowNo).get("Project");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sQuantity = xls.get(iRowNo).get("Quantity");
		try{
			int indentCount = indentList.size();
			addIndentIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			indentForTxt.sendKeys("Test"+sDate);
			indentTypeDropDwn.click();
			indentTypeSearch.sendKeys(sType);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sType+"']")).click();
			indentProjectDropDwn.click();
			projectSearch.sendKeys(sProject);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
			materialReqTxt.sendKeys(sMaterial);
			Thread.sleep(Constant.Min_Sleep);
			Constant.driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
			quantityTxt.sendKeys(sQuantity);
			viewBomBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(viewBOMPopup.isDisplayed()){
				int actCount = bomMaterials.size();
				firstBOMDelete.click();
				driver.switchTo().alert().accept();
				addBOM.click();
				Thread.sleep(Constant.Min_Sleep);
				indentRemark.sendKeys("Remark"+sDate);
				int addedCount = addedMaterials.size()-1;
				Thread.sleep(Constant.Min_Sleep);
				saveIndent.click();
				Thread.sleep(Constant.Min_Sleep);
				backButton.click();
				Thread.sleep(Constant.Min_Sleep);
				int indentActCount = indentList.size();
				if(actCount > addedCount && indentCount < indentActCount){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("BOM material delete with confirmation to delete failed "+e);
		}
		return flag;
	}

	public boolean bomMaterialDelete_No(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Indent");
		String sType = xls.get(iRowNo).get("Indent Type");
		String sProject = xls.get(iRowNo).get("Project");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sQuantity = xls.get(iRowNo).get("Quantity");
		try{
			int indentCount = indentList.size();
			addIndentIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			indentForTxt.sendKeys("Test"+sDate);
			indentTypeDropDwn.click();
			indentTypeSearch.sendKeys(sType);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sType+"']")).click();
			indentProjectDropDwn.click();
			projectSearch.sendKeys(sProject);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
			materialReqTxt.sendKeys(sMaterial);
			Thread.sleep(Constant.Min_Sleep);
			Constant.driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
			quantityTxt.sendKeys(sQuantity);
			viewBomBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(viewBOMPopup.isDisplayed()){
				int actCount = bomMaterials.size();
				firstBOMDelete.click();
				driver.switchTo().alert().dismiss();
				addBOM.click();
				Thread.sleep(Constant.Min_Sleep);
				indentRemark.sendKeys("Remark"+sDate);
				int addedCount = addedMaterials.size()-1;
				Thread.sleep(Constant.Min_Sleep);
				saveIndent.click();
				Thread.sleep(Constant.Min_Sleep);
				backButton.click();
				Thread.sleep(Constant.Min_Sleep);
				int indentActCount = indentList.size();
				if(actCount == addedCount && indentCount < indentActCount){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("BOM material delete with confirmation to delete failed "+e);
		}
		return flag;
	}

	public boolean cancelBtn_deleteIndent(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		try{
			String indentNo = addIndent(iRowNo, sheet);
			int i = indentList.size();
			Constant.driver.findElement(By.xpath(".//td/a[contains(text(),'"+indentNo+"')]/following::td/a/i[@id='deleteImage_']")).click();
			Thread.sleep(Constant.Min_Sleep);
			cancelBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			int j = indentList.size();
			if(i == j && Constant.driver.getPageSource().contains(indentNo)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Cancel button in delete warning pop up failed "+e);
		}
		return flag;
	}

	public boolean cancelBtn_MaterialDelete(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Indent");
		String sType = xls.get(iRowNo).get("Indent Type");
		String sProject = xls.get(iRowNo).get("Project");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sQuantity = xls.get(iRowNo).get("Quantity");
		String indentNo,sIndentNo = null;
		try{
			addIndentIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			indentForTxt.sendKeys("Test"+sDate);
			indentTypeDropDwn.click();
			indentTypeSearch.sendKeys(sType);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sType+"']")).click();
			indentProjectDropDwn.click();
			projectSearch.sendKeys(sProject);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
			indentReqDate.click();
			Constant.driver.findElement(By.xpath(".//td[contains(@class,'available')][text()='"+iDate+"'][contains(@class,'today')]")).click();
			materialReqTxt.sendKeys(sMaterial);
			Thread.sleep(Constant.Min_Sleep);
			Constant.driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
			quantityTxt.sendKeys(sQuantity);
			addMaterial.click();
			if(driver.findElement(By.xpath(".//div[contains(text(),'"+sMaterial+"')]")).isDisplayed()){
				Constant.log.info("Material is added successfully");
			}else{
				System.err.println("Material is not added");
			}
			firstMaterialDelete.click();
			driver.switchTo().alert().dismiss();
			Thread.sleep(Constant.Min_Sleep);
			indentRemark.sendKeys("Remark"+sDate);
			saveIndent.click();
			Thread.sleep(Constant.Min_Sleep);
			sIndentNo = indentNo_AddPage.getText();
			backButton.click();
			Thread.sleep(Constant.Min_Sleep);
			int i = indentList.size();
			indentNo = Constant.driver.findElement(By.xpath(".//*[@id='issue_table_list_tbody']/tr["+i+"]/td[2]/a")).getText();
			if(sIndentNo.contains(indentNo)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Cancel button in Material delete pop up validation failed "+e);
		}
		return flag;
	}

	 public boolean mandatoryFieldsCheck(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Indent");
		String sType = xls.get(iRowNo).get("Indent Type");
		String sProject = xls.get(iRowNo).get("Project");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sQuantity = xls.get(iRowNo).get("Quantity");
		String sIndentNo, indentNo = null;
		try{
			addIndentIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			saveIndent.click();
			Thread.sleep(Constant.Min_Sleep);
//			if(materialReqWarning_Indent.isDisplayed()){
//				okButton.click();
				if(purposeErrorMsg.isDisplayed() && indentTypeErrorMsg.isDisplayed() && projectErrorMsg.isDisplayed()){
					indentForTxt.sendKeys("Test"+sDate);
					saveIndent.click();
					Thread.sleep(Constant.Min_Sleep);
//					if(materialReqWarning_Indent.isDisplayed()){
//						okButton.click();
						if(indentTypeErrorMsg.isDisplayed() && projectErrorMsg.isDisplayed()){
							indentTypeDropDwn.click();
							indentTypeSearch.sendKeys(sType);
							Constant.driver.findElement(By.xpath(".//em[text()='"+sType+"']")).click();
							saveIndent.click();
							Thread.sleep(Constant.Min_Sleep);
//							okButton.click();
//							if(materialReqWarning_Indent.isDisplayed()){
								if(projectErrorMsg.isDisplayed()){
									indentProjectDropDwn.click();
									projectSearch.sendKeys(sProject);
									Constant.driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
									saveIndent.click();
									Thread.sleep(Constant.Min_Sleep);
									if(materialReqWarning_Indent.isDisplayed()){
										okButton.click();
										Thread.sleep(Constant.Min_Sleep);
										addMaterial.click();
										if(materialNameErrorMsg.isDisplayed() && quantityErrorMsg.isDisplayed()){
											materialReqTxt.sendKeys(sMaterial);
											Thread.sleep(Constant.Min_Sleep);
											Constant.driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
											addMaterial.click();
											if(quantityErrorMsg.isDisplayed()){
												quantityTxt.sendKeys(sQuantity);
												addMaterial.click();
												saveIndent.click();
												Thread.sleep(Constant.Min_Sleep);
												sIndentNo = indentNo_AddPage.getText();
												backButton.click();
												Thread.sleep(Constant.Min_Sleep);
												int i = indentList.size();
												indentNo = Constant.driver.findElement(By.xpath(".//*[@id='issue_table_list_tbody']/tr["+i+"]/td[2]/a")).getText();
												if(sIndentNo.contains(indentNo)){
													flag = true;
												}
											}
										}
									}
								}
							}
						}

//					}
//				}
//			}
		 }catch(Exception e){
			 System.err.println("Mandatory error messages validation failed "+e);
		 }
		 return flag;
	 }

	 public boolean indentsFoundCount(){
		 boolean flag = false;
		 try{
			 String count = indentsFound.getText();
			 int ActualCount = preparedOn.size();
			 if(count.contains(Integer.toString(ActualCount))){
				 flag = true;
			 }
		 }catch(Exception e){
			 System.err.println("Indent found count validation failed");
		 }
		 return flag;
	 }

	 public boolean last30Days(int iRowNo, int iiRowCount){
			boolean flag = false;
			Date Date30 = DateUtils.addDays(new Date(), -29);
			String sdate = dateFormat.format(Date30);
			try{
				dateCalendarDrpDown.click();
				Thread.sleep(Constant.Min_Sleep);
				if(last30Days.isDisplayed()){
					last30Days.click();
					searchBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					String sDateRange = dateRange.getText();
					String sDate[] = sDateRange.split("-");
					Date dateFrom = dateFormat.parse(sDate[0]);
					Date dateTo = dateFormat.parse(sDate[1].trim());
					Date currentDate = dateFormat.parse(sCurrentDate);
					Date date30 = dateFormat.parse(sdate);
					if(currentDate.equals(dateTo) && date30.equals(dateFrom)){
						List<WebElement> DateList = driver.findElements(By.xpath(".//*[@id='issue_table_list_tbody']/tr/td["+iiRowCount+"]"));
						for (WebElement element : DateList) {
							Date date2 = dateFormat.parse(element.getText());
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

		public boolean currentMonth(int iRowCount){
			boolean flag = false;
		    cal.setTime(date1);
		    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		    Date FirstDayOfMonth = cal.getTime();
			String sdate = dateFormat.format(FirstDayOfMonth);
			try{
				dateCalendarDrpDown.click();
				Thread.sleep(Constant.Min_Sleep);
				if(currentMonth.isDisplayed()){
					currentMonth.click();
					searchBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					String sDateRange = dateRange.getText();
					String sDate[] = sDateRange.split("-");
					Date dateFrom = dateFormat.parse(sDate[0]);
					Date dateTo = dateFormat.parse(sDate[1].trim());
					Date currentDate = dateFormat.parse(sCurrentDate);
					Date date30 = dateFormat.parse(sdate);
					if(currentDate.equals(dateTo) && date30.equals(dateFrom)){
						List<WebElement> DateList = driver.findElements(By.xpath(".//*[@id='issue_table_list_tbody']/tr/td["+iRowCount+"]"));
						for (WebElement element : DateList) {
							Date date2 = dateFormat.parse(element.getText());
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

		public boolean currentYear(int iRowCount){
			boolean flag = false;
			int FirstDayOfYear = cal.get(Calendar.YEAR);
			 String sdate = "Jan 1, "+FirstDayOfYear;
			try{
				dateCalendarDrpDown.click();
				Thread.sleep(Constant.Min_Sleep);
				if(currentYear.isDisplayed()){
					currentYear.click();
					searchBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					String sDateRange = dateRange.getText();
					String sDate[] = sDateRange.split("-");
					Date dateFrom = dateFormat.parse(sDate[0]);
					Date dateTo = dateFormat.parse(sDate[1].trim());
					Date currentDate = dateFormat.parse(sCurrentDate);
					Date date30 = dateFormat.parse(sdate);
					if(currentDate.equals(dateTo) && date30.equals(dateFrom)){
						List<WebElement> DateList = driver.findElements(By.xpath(".//*[@id='issue_table_list_tbody']/tr/td["+iRowCount+"]"));
						for (WebElement element : DateList) {
							Date date2 = dateFormat.parse(element.getText());
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

		public boolean currentFinancialYear(int iRowCount){
			boolean flag = false;
			 int iCurrentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
			 int iCurrentYear = Calendar.getInstance().get(Calendar.YEAR);
			 String sFromDate = null;
			 int iYear = 0;
			try{
				if(iCurrentMonth >= 4){
					iYear = iCurrentYear;
				}else{
					iYear = iCurrentYear-1;
				}
				sFromDate = "Apr 1, "+Integer.toString(iYear);
				dateCalendarDrpDown.click();
				Thread.sleep(Constant.Min_Sleep);
				if(currentFinancialYear.isDisplayed()){
					currentFinancialYear.click();
					searchBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					String sDateRange = dateRange.getText();
					String sDate[] = sDateRange.split("-");
					Date dateFrom = dateFormat.parse(sDate[0]);
					Date dateTo = dateFormat.parse(sDate[1].trim());
					Date currentDate = dateFormat.parse("Mar 31, "+(iYear+1));
					Date FrDate = dateFormat.parse(sFromDate);
					if(currentDate.equals(dateTo) && FrDate.equals(dateFrom)){
						List<WebElement> DateList = driver.findElements(By.xpath(".//*[@id='issue_table_list_tbody']/tr/td["+iRowCount+"]"));
						for (WebElement element : DateList) {
							Date date2 = dateFormat.parse(element.getText());
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

		public boolean customRange(int iRowCount){
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
					driver.findElement(By.xpath(".//div[@class='calendar right']/div/table/tbody/tr/td[@class='available'][text()='1']")).click();
					String sToDate = toDate.getAttribute("value");
					searchBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					String sDateRange = dateRange.getText();
					String sDate[] = sDateRange.split("-");
					Date dateFrom = dateFormat.parse(sDate[0]);
					Date dateTo = dateFormat.parse(sDate[1].trim());
					Date currentDate = dateFormat1.parse(sToDate);
					Date FrDate = dateFormat1.parse(sFromDate);
					if(currentDate.equals(dateTo) && FrDate.equals(dateFrom)){
						List<WebElement> DateList = driver.findElements(By.xpath(".//*[@id='issue_table_list_tbody']/tr/td["+iRowCount+"]"));
						for (WebElement element : DateList) {
							Date date2 = dateFormat.parse(element.getText());
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

	public boolean addindentpo_spq(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			String indentNo = addIndent(iRowNo, sheet);
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+indentNo+"')]")));
			driver.findElement(By.xpath(".//td/a[contains(text(),'"+indentNo+"')]")).click();
			Thread.sleep(Constant.Min_Sleep);
			poQtyIndentPOPage.get(0).sendKeys(Keys.CONTROL+"a");
			poQtyIndentPOPage.get(0).sendKeys(Keys.DELETE);
			poQtyIndentPOPage.get(0).sendKeys("15");
			indentPurchaseBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.isElementPresent(By.id("btn-sa-confirm"))){
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				indentPurchaseBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			if(indentSPQPopup.isDisplayed()){
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(spqRoundDownArrow.isDisplayed() && spqThumbsUp.isDisplayed() && spqRoundUpArrow.isDisplayed()){
					spqThumbsUp.click();
					Thread.sleep(Constant.Min_Sleep);
					indentPurchaseBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load GRN view page");
					Thread.sleep(Constant.Min_Sleep);
					String sPODraftNo = purchaseCreatedPopup.getText().substring(0, 4);
					okBtn.click();
					navigate.navigateToPurchase_Header();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToPurchase();
					Thread.sleep(Constant.Min_Sleep);
					navigate.showAllEntries();
					if(driver.getPageSource().contains(sPODraftNo)){
						flag = true;
					}
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("failed to validate spq popup "+e);
		}
		return flag;
	}

	//GRN

	public boolean addGRN(int iRowNo, String sheet, String sIssueNo) throws Exception{
		boolean flag = false, flag1 = false, flag2 = false,flag3 = false,flag4 = false,flag5 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIndentType = xls.get(iRowNo).get("Indent Type");
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sParty = xls.get(iRowNo).get("Party");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sQuantity = xls.get(iRowNo).get("Quantity");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sIssueNoCount = xls.get(iRowNo).get("Issue No Selection");
		String sReceivedAs = xls.get(iRowNo).get("Received As");
		String sPoMandatory = xls.get(iRowNo).get("PO Mandatory");
		String sReceived = xls.get(iRowNo).get("Received");
		String sReturned = xls.get(iRowNo).get("Returned");
		String sCreateOA = xls.get(iRowNo).get("Create OA");
		String sGrantTotal = null, sPoNo = null,sProject = null;
		WebElement ele;
		String[] sPartySplit = null,  sSplitMaterial = null;
		try{
			if(sCurrentDate.substring(4, 5).contains("0")){
				sCurrentDate = sCurrentDate.substring(0,4)+sCurrentDate.substring(5,12);
			}
			if(!(sReceivedAgainst.contains("Issues") || sReceivedAgainst.contains("Sales Return"))){
				navigate.navigateToStore();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToGRN();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
				btnFilter.click();
				Select selectReceivedView = new Select(receivedAgainstDropDwnViewtab);
				selectReceivedView.selectByValue(sReceivedAgainst);
				searchGRN.click();
				Constant.waitFor(ExpectedConditions.invisibilityOf(searchGRN), "Failed to load GRN view page");
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int grnCount = grnList.size();
			addGRNBtn.click();
			Constant.waitForPageLoad();
			if(!sReceivedAgainst.contains("Issues")){
				Select selectReceived = new Select(receivedAgainstDropDwn);
				selectReceived.selectByValue(sReceivedAgainst);
				selectParty.click();
				searchParty.sendKeys(sParty);
				driver.findElement(By.xpath(".//li[text()='All']/following::li/em[text()='"+sParty.trim()+"']")).click();
				Thread.sleep(Constant.Min_Sleep);
				if(!sReceivedAgainst.contains("Others") && !sReceivedAgainst.contains("Job In")){
					if(sReceivedAs.contains("DC")){
						tDCtoggle.click();
					}else if(sReceivedAs.contains("Invoice")){
						tInvoicetoggle.click();
					}else{
						cGoodsAlreayReceived.click();
					}
					Thread.sleep(Constant.Min_Sleep);
				}
			}
			if(!(sReceivedAgainst.contains("Others") || sReceivedAgainst.contains("Issues") || sPoMandatory.equals("Without Po"))){
				if(sIssueNo == null){
					sPoNo = selectPO(iRowNo, sheet);
				}else{
					if(!sIssueNoCount.contains("Single")){
						 selectPO(iRowNo, sheet);
						 purchaseOrderDropDwn.click();
						 Thread.sleep(Constant.Min_Sleep);
					}
					sPoNo = searchPoNo(sIssueNo, iRowNo, sheet);
				}
			}
			sProject = selectProject.getText();
			if(!(sReceivedAgainst.contains("Issues") || sReceivedAgainst.contains("Delivery Challan") || sReceivedAgainst.contains("Others")
					|| sReceivedAgainst.contains("Sales Return") || sReceivedAgainst.contains("Job In") )){
				Select select = new Select(indentType);
				select.selectByVisibleText(sIndentType);
			}
			if(!sReceivedAgainst.contains("Issues")){
				sParty = selectParty.getText();
				sPartySplit = sParty.split("\\(");
			}
			if(sReceivedAgainst.contains("Issues")){
				sIssueNo = selectIssueNo(iRowNo, sheet, sIssueNo);
			}
			if(sReceivedAgainst.contains("Job In") && !sPoMandatory.equals("Without Po")){
				flag1 = addMaterial_ViewOa(iRowNo,sheet);
			}
			Thread.sleep(Constant.Min_Sleep);
			if(!(sReceivedAgainst.contains("Delivery Challan") || sReceivedAgainst.contains("Others") || sReceivedAgainst.contains("Issues")
					|| sPoMandatory.equals("Without Po") || sReceivedAgainst.contains("Job In"))){
				if(sReceivedAs.contains("Goods")){
					flag1 = addGoodsAlreadyReceived();
					flag2 = addCGSTTax_goods(0,iRowNo,sheet);
					flag3 = addSGSTTax_goods(0,iRowNo,sheet);
					flag4 = addIGSTTax_goods(0,iRowNo,sheet);
				}else{
					if(sReceived.contains("Yes")){
						if(sIssueNoCount.contains("Single")){
							flag1 = addQtyDetails(0,iRowNo,sheet);
							flag2 = addCGSTTax(0,iRowNo,sheet);
							flag3 = addSGSTTax(0,iRowNo,sheet);
							flag4 = addIGSTTax(0,iRowNo,sheet);
						}else{
							for(int i=0;i<dcInvoiceQtyList.size();i++){
								flag1 = addQtyDetails(i,iRowNo,sheet);
								flag2 = addCGSTTax(i,iRowNo,sheet);
								flag3 = addSGSTTax(i,iRowNo,sheet);
								flag4 = addIGSTTax(i,iRowNo,sheet);
							}
						}
					}
				}
				flag5 = addTax(iRowNo,sheet);
			}else{
				flag2 = true; flag3 = true; flag4 = true; flag5 = true;
			}
			if(sPoMandatory.equals("Without Po") && sReceivedAs.contains("Goods")){
				sPoNo = selectDCPartyNo(iRowNo, sheet);
				flag1 = addGoodsAlreadyReceived();
				flag2 = addCGSTTax_goods(0,iRowNo,sheet);
				flag3 = addSGSTTax_goods(0,iRowNo,sheet);
				flag4 = addIGSTTax_goods(0,iRowNo,sheet);
				flag5 = addTax(iRowNo,sheet);
			}
			if(sReceivedAgainst.contains("Job Work") || sReceivedAgainst.contains("Delivery Challan") || sReceivedAgainst.contains("Issues")){
				if(!(sReceivedAs.contains("Goods") || sReturned.contains("No"))){
					flag1 = addReturnedQtyDetails(iRowNo, sheet, sIssueNoCount);
				}
				if(sReceived.contains("No")){
					flag2 = true; flag3 = true; flag4 = true; flag5 = true;
				}
			}
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			if(sReceivedAgainst.contains("Others") || sReceivedAgainst.contains("Issues") || sPoMandatory.contains("Without Po")){
				if(!((sReceivedAs.contains("Goods") || (sReceived.contains("No"))))){
					js.executeScript("window.scrollBy(0,-5000)");
					matReceivedTab.click();
					Thread.sleep(Constant.Min_Sleep);
					flag1 = addStockMaterial(iRowNo, sheet);
					sSplitMaterial = sMaterial.split("-");
				}
			}
			String sInvoiceNo = addGRNDetails(iRowNo,sheet, "add GRN");
			String sInvoiceDate = invoiceDateField.getAttribute("value");
			if(flag1 && flag2 && flag3 && flag4 && flag5){
				sGrantTotal = grnGrandTotal.getAttribute("value");
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(Constant.Min_Sleep);
				addBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(sReceivedAgainst.contains("Job In") && sPoMandatory.contains("Without Po") && sCreateOA.contains("No")){
					Constant.waitFor(ExpectedConditions.visibilityOf(continueBtn), "Failed to load oa link warning popup");
					continueBtn.click();
					Thread.sleep(Constant.Max_Sleep);
				}
				if(sReceivedAgainst.contains("Job In") && sPoMandatory.contains("Without Po") && sCreateOA.contains("Yes")){
					Constant.waitFor(ExpectedConditions.visibilityOf(continueBtn), "Failed to load oa link warning popup");
					if(addOAMaterial(iRowNo,sheet)){
						continueBtn.click();
						Thread.sleep(Constant.Max_Sleep);
					}
				}
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
					Thread.sleep(Constant.Min_Sleep);
				}
				Constant.waitFor(ExpectedConditions.visibilityOf(okButton), "Failed to load GRN edit page");
				Constant.waitForPageLoad();
				if(Constant.isElementPresent(By.xpath(".//h2/span[text()='Saved Successfully']/following::p/b[2]"))){
					sPoNo = driver.findElement(By.xpath(".//h2/span[text()='Saved Successfully']/following::p/b[2]")).getText();
				}
				if(sReceivedAgainst.contains("Job In") && sCreateOA.contains("Yes")){
					int iCount = sPoNo.length();
					for(int i=1;i<iCount;i++){
						iCount = sPoNo.length();
						if(iCount < 13){
							sPoNo = sPoNo.substring(0, 7)+String.format("%01d", 0)+sPoNo.substring(7,iCount);
						}else{
							break;
						}
					}
				}
				okButton.click();
				if(sReceived.contains("No") && !(sReceivedAgainst.contains("Job Work")) && !(sReceivedAgainst.contains("Job In"))){
						Thread.sleep(Constant.Max_Sleep);
						Thread.sleep(Constant.Max_Sleep);
						materialsReturnedTab.click();
						Thread.sleep(Constant.Min_Sleep);
				}
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
				js.executeScript("window.scrollBy(0,-5000)");
				Constant.waitForPageLoad();
				backBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
				if(!(sReceivedAgainst.contains("Issues") || sReceivedAgainst.contains("Sales Return"))){
					btnFilter.click();
					Select selectReceivedView = new Select(receivedAgainstDropDwnViewtab);
					selectReceivedView.selectByValue(sReceivedAgainst);
					searchGRN.click();
					Constant.waitFor(ExpectedConditions.invisibilityOf(searchGRN), "Failed to load GRN view page");
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				int grnActCount = grnList.size();
				if(sPoNo == null || sPoNo.contains("GRN")){
					sPoNo = "-NA-";
				}
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+grnActCount+"]/td[text()='"+grnActCount+".']")));
				Thread.sleep(Constant.Min_Sleep);
				if(!(sReceivedAgainst.contains("Others") || sReceivedAgainst.contains("Issues"))){
					ele = driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+grnActCount+"]/td[text()='"+grnActCount+".']/following::td[text()='"+sCurrentDate+"']/following::td[3]/span[contains(text(),'"+sPoNo+"')]/following::td[text()='"+sProject+"']/following::td[contains(text(),'"+sPartySplit[0].trim()+"')]/following::td[text()='"+sInvoiceNo+"']/following::td[text()='"+sInvoiceDate+"']/following::td[text()='"+sGrantTotal+"']/following::td[3]/a[text()='Draft']"));
				}else if(sReceivedAgainst.contains("Others")){
					ele = driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+grnActCount+"]/td[text()='"+grnActCount+".']/following::td[text()='"+sCurrentDate+"']/following::td[4][text()='"+sProject+"']/following::td[contains(text(),'"+sPartySplit[0].trim()+"')]/following::td[4][contains(text(),'"+sSplitMaterial[0].trim()+"')]/following::td[text()='"+sQuantity+"']/following::td/a[text()='Draft']"));
				}else{
					ele = driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+grnActCount+"]/td[text()='"+grnActCount+".']/following::td[text()='"+sCurrentDate+"']/following::td[3]/span[contains(text(),'"+sIssueNo+"')]/following::td[text()='"+sProject+"']/following::td[contains(text(),'"+sIssueTo+"')]/following::td[6]/a[text()='Draft']"));
				}
				if(grnActCount > grnCount && ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add GRN "+e);
		}
		return flag;
	}

	public String searchPoNo(String sInvoice, int iRowNo, String sheet){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAs = xls.get(iRowNo).get("Received As");
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		try{
			if(!sReceivedAs.contains("Goods")){
				purchaseOrderDropDwn.click();
				if(!sInvoice.contains("JO")){
					boolean flag = Constant.isElementPresent(By.xpath(".//input[@placeholder='Search']"));
					if(flag){
						searchTxtPurchaseDrpDwn.sendKeys(sInvoice);
						Thread.sleep(Constant.Min_Sleep);
					}
				}
				driver.findElement(By.xpath("//label[contains(text(),'"+sInvoice+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
			}else{
				partyDcDropDwn.click();
				if(!sInvoice.contains("JO")){
					searchTxtPurchaseDrpDwn.sendKeys(sInvoice);
					Thread.sleep(Constant.Min_Sleep);
				}
				driver.findElement(By.xpath("//label[contains(text(),'"+sInvoice+"')]")).click();
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
				Thread.sleep(Constant.Min_Sleep);
				for (WebElement element : MaterialListPartyDcNo) {
					element.click();
					String[] sMaterialList = element.getText().split("\\s+");
					if(driver.findElement(By.xpath("//table[@id='materialtable']/tbody/tr/td/span[contains(text(),'"+sMaterialList[0]+"')]/following::td[@class='doc_code']")).getText().contains("PO No")){
						sInvoice = driver.findElement(By.xpath("//table[@id='materialtable']/tbody/tr/td/span[contains(text(),'"+sMaterialList[0]+"')]/following::td[@class='doc_code']")).getText();
						sInvoice = sInvoice.substring(7, 22);
						element.click();
						break;
					}
					element.click();
				}

			}
			if(sReceivedAgainst.contains("Job In")){
				int iCount = sInvoice.length();
				for(int i=1;i<iCount;i++){
					iCount = sInvoice.length();
					if(iCount < 13){
						sInvoice = sInvoice.substring(0, 7)+String.format("%01d", 0)+sInvoice.substring(7,iCount);
					}else{
						break;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to search PO no "+e);
		}
		return sInvoice;
	}

	public String selectIssueNo(int iRowNo, String sheet, String sIssueNo){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sIssueNoCount = xls.get(iRowNo).get("Issue No Selection");
		int iIssueCount = 0;
		try{
			issueToDropdwn.click();
			issueToDropdwn_search.sendKeys(sIssueTo);
			driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
			Thread.sleep(Constant.Max_Sleep);
			Thread.sleep(Constant.Min_Sleep);
			issueNoYrDrpDwn.click();
			if(sIssueNo == null){
				if(sIssueNoCount.contains("Single")){
					iIssueCount = 1;
				}else{
					iIssueCount = 3;
				}
				if(issueNoYrOptionDrpDwnList.size() > 0){
					for (WebElement element : issueNoYrOptionDrpDwnList) {
						element.click();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
				Thread.sleep(Constant.Max_Sleep);
				issueNoDrpDwn.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int j=0;j<iIssueCount;j++){
					if(issueNoOptionDrpDwnList.size() > 0){
						sIssueNo = issueNoOptionDrpDwnList.get(j+1).getText();
						issueNoOptionDrpDwnList.get(j+1).click();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
			}else{
				String FY = sIssueNo.substring(0,5);
				driver.findElement(By.xpath(".//ul/li/a/label[contains(text(),'"+FY+"')]")).click();
				Thread.sleep(Constant.Medium_Sleep);
				issueNoDrpDwn.click();
				issueNoSearch.sendKeys(sIssueNo);
				driver.findElement(By.xpath(".//label[contains(text(),'"+sIssueNo+"')]")).click();
				Thread.sleep(Constant.Max_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to select Issue no "+e);
		}
		return sIssueNo;
	}

	public String selectPO(int iRowNo, String sheet){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAs = xls.get(iRowNo).get("Received As");
		String sIssueNoCount = xls.get(iRowNo).get("Issue No Selection");
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sPoNo = null;
		int j, k = 0;
		try{
			if(sIssueNoCount.contains("Single")){
				j = 1;
			}else{
				j = 3;
			}
			if(!sReceivedAs.contains("Goods")){
				purchaseOrderDropDwn.click();
				List<WebElement> list1 = driver.findElements(By.xpath(".//*[@id='po_div']/div/ul/li"));
				for(int i=0;i<list1.size();i++){
					if(list1.size() > 0){
						purchaseOrder.get(i).click();
						Thread.sleep(Constant.Min_Sleep);
						sPoNo = purchaseOrder.get(i).getText().trim();
						if(Constant.isElementPresent(By.xpath("//div[@class='sweet-alert showSweetAlert visible']"))){
							okButton.click();
							Thread.sleep(Constant.Min_Sleep);
							purchaseOrderDropDwn.click();
							purchaseOrder.get(i).click();
							Thread.sleep(Constant.Min_Sleep);
						}else{
							k = k+1;
							if(j == k){
								break;
							}
						}
					}
				}
				int iCount = sPoNo.length();
				if(!(sReceivedAgainst.contains("Delivery Challan"))){
					if(!(sPoNo.contains("PO") || sPoNo.contains("JO"))){
	//					sPoNo = sPoNo.substring(0, 7)+sPoNo.substring(9,iCount);
						for(int i=1;i<iCount;i++){
							iCount = sPoNo.length();
							if(iCount < 13){
								sPoNo = sPoNo.substring(0, 7)+String.format("%01d", 0)+sPoNo.substring(7,iCount);
							}else{
								break;
							}
						}
					}else{
						for(int i=1;i<iCount;i++){
							iCount = sPoNo.length();
							if(!(iCount >= 15)){
								sPoNo = sPoNo.substring(0, 9)+String.format("%01d", 0)+sPoNo.substring(9,iCount);
							}else{
								break;
							}
						}
					}
				}
			}else{
				sPoNo = selectDCPartyNo(iRowNo, sheet);
			}
			if(!sReceivedAgainst.contains("Job In")){
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			}
		}catch(Exception e){
			System.err.println("Failed to select PO "+e);
		}
		return sPoNo.trim();
	}

	public boolean validateOANowithMat(String sOaNo){
		boolean flag = false;
		try{
			for (WebElement element : oaDropDwnEditPge) {
				if(element.getText().contains(sOaNo)){
					flag = true;
				}else{
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Failed validate oa no linked with material "+e);
		}
		return flag;
	}

	public String selectAnotherPO(int iRowNo, String sheet){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAs = xls.get(iRowNo).get("Received As");
		String sPoNo = null;
		try{
			if(!sReceivedAs.contains("Goods")){
				purchaseOrderDropDwn.click();
				List<WebElement> list1 = driver.findElements(By.xpath(".//*[@id='po_div']/div/ul/li"));
				for(int i=0;i<list1.size();i++){
					if(list1.size() > 0){
						if(!purchaseOrderCheckBx.get(i).isSelected()){
							purchaseOrder.get(i).click();
							Thread.sleep(Constant.Min_Sleep);
							sPoNo = purchaseOrder.get(i).getText().trim();
							if(Constant.isElementPresent(By.xpath("//div[@class='sweet-alert showSweetAlert visible']"))){
								okButton.click();
								Thread.sleep(Constant.Min_Sleep);
								purchaseOrderDropDwn.click();
								purchaseOrder.get(i).click();
								Thread.sleep(Constant.Max_Sleep);
							}
							else{
								break;
							}
						}
					}
				}
			}else{
				sPoNo = selectDCPartyNo(iRowNo, sheet);
			}
		}catch(Exception e){
			System.err.println("Failed to select PO "+e);
		}
		return sPoNo.trim();
	}

	public String selectDCPartyNo(int iRowNo, String sheet){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sPoMandatory = xls.get(iRowNo).get("PO Mandatory");
		String sPoNo = null;
		try{
			partyDcDropDwn.click();
			if(sPoMandatory.contains("With Po")){
				for (WebElement element : partyDcNo) {
					element.click();
					Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
					partyDcDropDwn.click();
					MaterialListPartyDcNo.get(0).click();
					sPoNo = firstMaterialPONo.getText();
					if(!(sPoNo.contains("PO No")  || sPoNo.contains("JO No")|| sPoNo.contains("SR"))){
						sPoNo = "-NA-";
						partyDcDropDwn.click();
						element.click();
						Thread.sleep(Constant.Min_Sleep);
					}else{
						sPoNo = sPoNo.substring(7, 22);
						break;
					}
				}
			}else{
				for (WebElement element : partyDcNo) {
					element.click();
					Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
					partyDcDropDwn.click();
					MaterialListPartyDcNo.get(0).click();
					sPoNo = firstMaterialPONo.getText();
					if(!(sPoNo.contains("PO No")  || sPoNo.contains("JO No") || sPoNo.contains("SR"))){
						sPoNo = "-NA-";
						break;
					}else{
						sPoNo = sPoNo.substring(7, 22);
						partyDcDropDwn.click();
						element.click();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
			}
			MaterialListPartyDcNo.get(0).click();
		}catch(Exception e){
			System.err.println("Failed to select Party dc no "+e);
		}
		return sPoNo;
	}

	public boolean addStockMaterial(int iRowNo, String sheet){
		boolean flag = false, flag1, flag2, flag3, flag4;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sPoMandatory = xls.get(iRowNo).get("PO Mandatory");
		String sQuantity = xls.get(iRowNo).get("Quantity");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		String sShortage = xls.get(iRowNo).get("Shortage");
		String sRejected = xls.get(iRowNo).get("Rejected");
		String sFaulty = xls.get(iRowNo).get("Faulty");
		List<WebElement> materialsAddedInGRN;
		String[] sMaterialList = sMaterial.split(",");
		int j=0;
		try{
			for(int i=0;i<sMaterialList.length;i++){
				materialReqTxt.sendKeys("  ");
				Thread.sleep(Constant.Min_Sleep);
				materialReqTxt.clear();
				Thread.sleep(Constant.Min_Sleep);
				materialReqTxt.sendKeys(sMaterialList[i]);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//a[contains(text(),'"+sMaterialList[i]+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				if(sAltUnit.contains("Yes")){
					altUnitDrpDwnGrn.click();
					altUnitOptionGRN.click();
				}
				if(!(sFaulty == null)){
					if(sFaulty.equals("Yes")){
						faultyChkBx.click();
					}else if(sFaulty.contains("Yes and No")){
						if(i % 2 == 0){
							faultyChkBx.click();
						}
					}
					Thread.sleep(Constant.Min_Sleep);
				}
				materialReqQtyTxtGRN.sendKeys(Keys.CONTROL+"a");
				materialReqQtyTxtGRN.sendKeys(Keys.DELETE);
				materialReqQtyTxtGRN.sendKeys(sQuantity);
				if(materialHSNTxtGRN.getAttribute("value").isEmpty() || materialHSNTxtGRN.getAttribute("value").matches(".*[a-zA-Z]+.*")){
					materialHSNTxtGRN.sendKeys(Keys.CONTROL+"a");
					materialHSNTxtGRN.sendKeys(Keys.DELETE);
					materialHSNTxtGRN.sendKeys(sDate);
				}
				materialAddBTNGRN.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean checkElement = Constant.isElementPresent(By.xpath(".//button[text()='OK']"));
				if(checkElement && driver.findElement(By.id("btn-sa-confirm")).isDisplayed()){
					okButton.click();
					Thread.sleep(Constant.Min_Sleep);
					removeMaterialName.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				if(sShortage.contains("Yes")){
					receivedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
					receivedQtyList.get(i).sendKeys(Keys.DELETE);
					receivedQtyList.get(i).sendKeys(Integer.toString(Integer.parseInt(sQuantity)-2));
				}
				if(sRejected.contains("Yes")){
					acceptedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
					acceptedQtyList.get(i).sendKeys(Keys.DELETE);
					acceptedQtyList.get(i).sendKeys(Integer.toString(Integer.parseInt(sQuantity)-4));
				}
			}
			if(!(sReceivedAgainst.contains("Others") || sReceivedAgainst.contains("Issues"))){
				materialsAddedInGRN = driver.findElements(By.xpath(".//*[@id='materialtable']/tbody/tr/td[2]"));
			}else{
				materialsAddedInGRN = driver.findElements(By.xpath(".//*[@id='materialtable']/tbody/tr/td[1]"));
			}
			for(int i=0;i<materialsAddedInGRN.size();i++){
				if(sPoMandatory.equals("Without Po")  && !sReceivedAgainst.contains("Others") && !sReceivedAgainst.contains("Issues")){
					if(materialsAddedInGRN.get(i).getText().contains(sMaterialList[j].trim())){
						j++;
						flag1 = enterPriceDetails(i, sQuantity);
						if(!sReceivedAgainst.contains("Job In")){
							flag2 = addCGSTTax(i,iRowNo,sheet);
							flag3 = addSGSTTax(i,iRowNo,sheet);
							flag4 = addIGSTTax(i,iRowNo,sheet);
						}else{
							flag2 = true; flag3 = true; flag4 = true;
						}
						if(flag1 && flag2 && flag3 && flag4){
							flag = true;
						}
					}
				}else if(!sPoMandatory.contains("With and Without Po")){
					if(materialsAddedInGRN.get(i).getText().contains(sMaterialList[j].trim())){
						j++;
						flag = true;
					}
				}
				if(sPoMandatory.contains("With and Without Po")){
					if(materialsAddedInGRN.get(i).getText().contains(sMaterialList[j].trim())){
						j++;
						flag1 = enterPriceDetails(i, sQuantity);
						if(!sReceivedAgainst.contains("Job In")){
							flag2 = addCGSTTax(i,iRowNo,sheet);
							flag3 = addSGSTTax(i,iRowNo,sheet);
							flag4 = addIGSTTax(i,iRowNo,sheet);
						}else{
							flag2 = true; flag3 = true; flag4 = true;
						}
						if(flag1 && flag2 && flag3 && flag4){
							flag = true;
						}
					}
				}
				if(sMaterialList.length == j){
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add stock materials "+e);
		}
		return flag;
	}

	public boolean addMaterial_ViewOa(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sQuantity = xls.get(iRowNo).get("Quantity");
		String sShortage = xls.get(iRowNo).get("Shortage");
		String sRejected = xls.get(iRowNo).get("Rejected");
		int j;
		try{
			materialReqQtyTxtGRN.click();
			Thread.sleep(Constant.Min_Sleep);
			if(viewOAMaterialsPopup.isDisplayed()){
				boolean flag7 = Constant.isElementPresent(By.xpath(".//tbody/tr[1]/td[3]/span/i/a[1]"));
				if(flag7){
					driver.findElement(By.xpath(".//tbody/tr[1]/td[3]/span/i/a[1]")).click();
					Thread.sleep(Constant.Min_Sleep);
					j=1;
				}else{
					j=0;
				}
				for(int i=j;i<oaQtyList.size();i++){
					oaQtyList.get(i).sendKeys(Keys.CONTROL+"a");
					oaQtyList.get(i).sendKeys(Keys.DELETE);
					oaQtyList.get(i).sendKeys("500");
					if(viewOaMaterialHSn.get(i).getAttribute("value").isEmpty() || viewOaMaterialHSn.get(i).getAttribute("value").matches(".*[a-zA-Z]+.*")){
						viewOaMaterialHSn.get(i).sendKeys(Keys.CONTROL+"a");
						viewOaMaterialHSn.get(i).sendKeys(Keys.DELETE);
						viewOaMaterialHSn.get(i).sendKeys(sDate);
					}
				}
				addBtnOaPopup.click();
			}
			if(grnMaterialTable.isDisplayed()){
				for(int i=0;i<oaDiscountList.size();i++){
					oaDiscountList.get(i).sendKeys(Keys.CONTROL+"a");
					oaDiscountList.get(i).sendKeys(Keys.DELETE);
					oaDiscountList.get(i).sendKeys("2.5");
					if(sShortage.contains("Yes")){
						receivedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
						receivedQtyList.get(i).sendKeys(Keys.DELETE);
						receivedQtyList.get(i).sendKeys(Integer.toString(Integer.parseInt(sQuantity)-2));
					}
					if(sRejected.contains("Yes")){
						acceptedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
						acceptedQtyList.get(i).sendKeys(Keys.DELETE);
						acceptedQtyList.get(i).sendKeys(Integer.toString(Integer.parseInt(sQuantity)-4));
					}
				}
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to add stock materials "+e);
		}
		return flag;
	}

	public boolean addOAMaterial(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sQuantity = xls.get(iRowNo).get("Quantity");
		String sPrice = xls.get(iRowNo).get("Price");
		String[] sMaterialList = sMaterial.split(",");
		try{
			for(int i=0;i<sMaterialList.length;i++){
				oaMaterialNameTxt.get(i).clear();
				Thread.sleep(Constant.Min_Sleep);
				oaMaterialNameTxt.get(i).sendKeys(sMaterialList[i]);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//div[@id='oaMaterialsPopup']/following::a[contains(text(),'"+sMaterialList[i]+"')][1]")).click();
				Thread.sleep(Constant.Min_Sleep);
				oaQtyTxtField.get(i).sendKeys(Keys.CONTROL+"a");
				oaQtyTxtField.get(i).sendKeys(Keys.DELETE);
				oaQtyTxtField.get(i).sendKeys(sQuantity);
				if(oaHSNTxtField.get(i).getAttribute("value").isEmpty() || oaHSNTxtField.get(i).getAttribute("value").matches(".*[a-zA-Z]+.*")){
					oaHSNTxtField.get(i).sendKeys(Keys.CONTROL+"a");
					oaHSNTxtField.get(i).sendKeys(Keys.DELETE);
					oaHSNTxtField.get(i).sendKeys(sDate);
				}
				oaItemPriceList.get(i).sendKeys(Keys.CONTROL+"a");
				oaItemPriceList.get(i).sendKeys(Keys.DELETE);
				oaItemPriceList.get(i).sendKeys(sPrice);
				Thread.sleep(Constant.Min_Sleep);
				boolean checkElement = Constant.isElementPresent(By.xpath(".//button[text()='OK']"));
				if(checkElement && driver.findElement(By.id("btn-sa-confirm")).isDisplayed()){
					okButton.click();
				}
				if(i+1 != sMaterialList.length){
					oaMaterialAddBtn.click();
				}
			}
			if(oaMaterialNameTxt.size() == sMaterialList.length){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to add stock materials "+e);
		}
		return flag;
	}

	public boolean validateGrandTotalValue_Goods(){
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
		double sumTax = 0,sumTotal = 0,sumCGST = 0,sumSGST = 0,sumIGST = 0,packingCharges = 0, transportCharges = 0, others = 0;
		try{
			for(int i=0;i<totalPriceConsolidate_goods.size();i++){
				sTotal.add(totalPriceConsolidate_goods.get(i).getAttribute("value"));
				sNetCGST.add(cgstAmtList_goods.get(i).getText());
				sNetSGST.add(sgstAmtList_goods.get(i).getText());
				sNetIGST.add(igstAmtList_goods.get(i).getText());
				arrayOfTotal.add(Double.parseDouble(sTotal.get(i)));
				arrayOfCgst.add(Double.parseDouble(sNetCGST.get(i)));
				arrayOfSGST.add(Double.parseDouble(sNetSGST.get(i)));
				arrayOfIGST.add(Double.parseDouble(sNetIGST.get(i)));
				sumTotal += arrayOfTotal.get(i);
				sumCGST += arrayOfCgst.get(i);
				sumSGST += arrayOfSGST.get(i);
				sumIGST += arrayOfIGST.get(i);
			}
			for(int i=0;i<poAddedTaxList.size();i++){
				tax.add(poAddedTaxList.get(i).getAttribute("value"));
				arrayOfTax.add(Double.parseDouble(tax.get(i)));
				sumTax += arrayOfTax.get(i);
			}
			packingCharges = Double.parseDouble(packingChargesTxtField.getAttribute("value"));
			transportCharges = Double.parseDouble(transportChargesTxtField.getAttribute("value"));
			others = Double.parseDouble(othersTxtField.getAttribute("value"));
			grnRoundOff.sendKeys(Keys.CONTROL+"a");
			grnRoundOff.sendKeys(Keys.DELETE);
			grnRoundOff.sendKeys("0.00");
			dutyPassedTxtField.click();
			String sGrandTotal = grnGrandTotal.getAttribute("value");
			double Total = sumTax+sumTotal+sumCGST+sumSGST+sumIGST+packingCharges+transportCharges+others;
			double roundOff = Math.round(Total * 100.0) / 100.0;
			if(roundOff == Double.parseDouble(sGrandTotal)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Grand total is calculated wrongly "+e);
		}
		return flag;
	}

	public boolean validateGrandTotalValue_JobIn(){
		boolean flag = false;
		ArrayList<String> sTotal = new ArrayList<>();
		List<Double> arrayOfTotal = new ArrayList<>();
		double sumTotal = 0,packingCharges = 0, transportCharges = 0, others = 0;
		try{
			for(int i=0;i<totalPriceList.size();i++){
				sTotal.add(totalPriceList.get(i).getAttribute("value"));
				arrayOfTotal.add(Double.parseDouble(sTotal.get(i)));
				sumTotal += arrayOfTotal.get(i);
			}
			packingCharges = Double.parseDouble(packingChargesTxtField.getAttribute("value"));
			transportCharges = Double.parseDouble(transportChargesTxtField.getAttribute("value"));
			others = Double.parseDouble(othersTxtField.getAttribute("value"));
			grnRoundOff.sendKeys(Keys.CONTROL+"a");
			grnRoundOff.sendKeys(Keys.DELETE);
			grnRoundOff.sendKeys("0.00");
			dutyPassedTxtField.click();
			String sGrandTotal = grnGrandTotal.getAttribute("value");
			double Total = sumTotal+packingCharges+transportCharges+others;
			double roundOff = Math.round(Total * 100.0) / 100.0;
			if(roundOff == Double.parseDouble(sGrandTotal)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Grand total value validation for JobIn "+e);
		}
		return flag;
	}

	public boolean validateGrandTotalValue(){
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
		double sumTax = 0,sumTotal = 0,sumCGST = 0,sumSGST = 0,sumIGST = 0,packingCharges = 0, transportCharges = 0, others = 0;
		try{
			for(int i=0;i<totalPriceList.size();i++){
				sTotal.add(totalPriceList.get(i).getAttribute("value"));
				sNetCGST.add(cgstAmtList.get(i).getText());
				sNetSGST.add(sgstAmtList.get(i).getText());
				sNetIGST.add(igstAmtList.get(i).getText());
				arrayOfTotal.add(Double.parseDouble(sTotal.get(i)));
				arrayOfCgst.add(Double.parseDouble(sNetCGST.get(i)));
				arrayOfSGST.add(Double.parseDouble(sNetSGST.get(i)));
				arrayOfIGST.add(Double.parseDouble(sNetIGST.get(i)));
				sumTotal += arrayOfTotal.get(i);
				sumCGST += arrayOfCgst.get(i);
				sumSGST += arrayOfSGST.get(i);
				sumIGST += arrayOfIGST.get(i);
			}
			for(int i=0;i<poAddedTaxList.size();i++){
				tax.add(poAddedTaxList.get(i).getAttribute("value"));
				arrayOfTax.add(Double.parseDouble(tax.get(i)));
				sumTax += arrayOfTax.get(i);
			}
			packingCharges = Double.parseDouble(packingChargesTxtField.getAttribute("value"));
			transportCharges = Double.parseDouble(transportChargesTxtField.getAttribute("value"));
			others = Double.parseDouble(othersTxtField.getAttribute("value"));
			grnRoundOff.sendKeys(Keys.CONTROL+"a");
			grnRoundOff.sendKeys(Keys.DELETE);
			grnRoundOff.sendKeys("0.00");
			dutyPassedTxtField.click();
			String sGrandTotal = grnGrandTotal.getAttribute("value");
			double Total = sumTax+sumTotal+sumCGST+sumSGST+sumIGST+packingCharges+transportCharges+others;
			double roundOff = Math.round(Total * 100.0) / 100.0;
			if(roundOff == Double.parseDouble(sGrandTotal)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Grand total is calculated wrongly "+e);
		}
		return flag;
	}

	public boolean addReturnedQtyDetails(int iRowNo, String sheet, String sIssueNoCount){
		boolean flag = false;
		try{
			remarksTxtField.click();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollBy(0,-5000)");
			materialsReturnedTab.click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag9 = Constant.isElementPresent(By.xpath(".//input[@name='pending_qty']"));
			if(flag9){
				if(sIssueNoCount.contains("Single")){
					flag = addReturnedMatQty(iRowNo, sheet, 0);
					if(grnHSNCodeList_MatRet.get(0).getAttribute("value").isEmpty() || grnHSNCodeList_MatRet.get(0).getAttribute("value").matches(".*[a-zA-Z]+.*")){
						grnHSNCodeList_MatRet.get(0).sendKeys(Keys.CONTROL+"a");
						grnHSNCodeList_MatRet.get(0).sendKeys(Keys.DELETE);
						grnHSNCodeList_MatRet.get(0).sendKeys(sDate);
					}
				}else{
					for(int i=0;i<pendingReturnedQtyList.size();i++){
						flag = addReturnedMatQty(iRowNo, sheet,i);
						if(grnHSNCodeList_MatRet.get(i).getAttribute("value").isEmpty() || grnHSNCodeList_MatRet.get(i).getAttribute("value").matches(".*[a-zA-Z]+.*")){
							grnHSNCodeList_MatRet.get(i).sendKeys(Keys.CONTROL+"a");
							grnHSNCodeList_MatRet.get(i).sendKeys(Keys.DELETE);
							grnHSNCodeList_MatRet.get(i).sendKeys(sDate);
						}
					}
				}
			}else{
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to add returned qty "+e);
		}
		return flag;
	}

	public boolean addReturnedMatQty(int iRowNo, String sheet, int i) throws InterruptedException{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sShortage = xls.get(iRowNo).get("Shortage");
		String sRejected = xls.get(iRowNo).get("Rejected");
		try{
			if(pendingReturnedQtyList.size()>0){
				if(Double.parseDouble(pendingReturnedQtyList.get(i).getText()) <= 10.00){
					dcReturnedInvoiceQtyList.get(i).sendKeys(Keys.CONTROL+"a");
					dcReturnedInvoiceQtyList.get(i).sendKeys(Keys.DELETE);
					dcReturnedInvoiceQtyList.get(i).sendKeys(pendingReturnedQtyList.get(i).getText());
					receivedReturnedQtyList.get(i).sendKeys(Keys.CONTROL+"a");
					receivedReturnedQtyList.get(i).sendKeys(Keys.DELETE);
					if(sShortage.contains("Yes")){
						receivedReturnedQtyList.get(i).sendKeys(Double.toString(Double.parseDouble(pendingReturnedQtyList.get(i).getText())-2));
					}else{
						receivedReturnedQtyList.get(i).sendKeys(pendingReturnedQtyList.get(i).getText());
					}
					acceptedReturnedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
					acceptedReturnedQtyList.get(i).sendKeys(Keys.DELETE);
					if(sRejected.contains("Yes")){
						acceptedReturnedQtyList.get(i).sendKeys(Double.toString(Double.parseDouble(pendingReturnedQtyList.get(i).getText())-4));
					}else{
						acceptedReturnedQtyList.get(i).sendKeys(pendingReturnedQtyList.get(i).getText());
					}
					flag = true;
				}else{
					dcReturnedInvoiceQtyList.get(i).sendKeys(Keys.CONTROL+"a");
					dcReturnedInvoiceQtyList.get(i).sendKeys(Keys.DELETE);
					dcReturnedInvoiceQtyList.get(i).sendKeys("10");
					receivedReturnedQtyList.get(i).sendKeys(Keys.CONTROL+"a");
					receivedReturnedQtyList.get(i).sendKeys(Keys.DELETE);
					if(sShortage.contains("Yes")){
						receivedReturnedQtyList.get(i).sendKeys("8");
					}else{
						receivedReturnedQtyList.get(i).sendKeys("10");
					}
					acceptedReturnedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
					acceptedReturnedQtyList.get(i).sendKeys(Keys.DELETE);
					if(sRejected.contains("Yes")){
						acceptedReturnedQtyList.get(i).sendKeys("6");
					}else{
						acceptedReturnedQtyList.get(i).sendKeys("10");
					}
					flag = true;
				}
				if(grnHSNCodeList_MatRet.get(i).getAttribute("value").isEmpty() || grnHSNCodeList_MatRet.get(i).getAttribute("value").matches(".*[a-zA-Z]+.*")){
					grnHSNCodeList_MatRet.get(i).sendKeys(Keys.CONTROL+"a");
					grnHSNCodeList_MatRet.get(i).sendKeys(Keys.DELETE);
					grnHSNCodeList_MatRet.get(i).sendKeys(sDate);
				}
			}
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to add material in material returned tab "+e);
		}
		return flag;
	}

	public String deleteReturnedMatQty(int i) throws InterruptedException{
		String sMaterial = null;
		materialsReturnedTab.click();
		Thread.sleep(Constant.Min_Sleep);
		if(pendingReturnedQtyList.size()>0){
			dcReturnedInvoiceQtyList.get(i).sendKeys(Keys.CONTROL+"a");
			dcReturnedInvoiceQtyList.get(i).sendKeys(Keys.DELETE);
			receivedReturnedQtyList.get(i).sendKeys(Keys.CONTROL+"a");
			receivedReturnedQtyList.get(i).sendKeys(Keys.DELETE);
			acceptedReturnedQtyList.get(i).sendKeys(Keys.CONTROL+"a");
			acceptedReturnedQtyList.get(i).sendKeys(Keys.DELETE);
			sMaterial = returnedMatList.get(i).getText();
		}
		Thread.sleep(Constant.Min_Sleep);
		return sMaterial;
	}

	public String getIssueNo(){
		String sIssueNo = null;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			JavascriptExecutor js = ((JavascriptExecutor) Constant.driver);
			int iRow = preparedOn.size();
			js.executeScript("arguments[0].scrollIntoView(true);",  Constant.driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")));
			sIssueNo =  Constant.driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")).getText();
		}catch(Exception e){
			System.err.println("Issue no selection failed "+e);
		}
		return sIssueNo;
	}

	public boolean validateDraftUpdateQty(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false, flag1 = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			flag1 = updateQty(iRowNo, sheet,sGRNNo);
			if(flag1){
				flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, sIssueNo);
			}
		}catch(Exception e){
			System.err.println("Failed to update qty "+e);
		}
		return flag;
	}

	public boolean validateMSLWarning_MatReturn(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sMaterial = xls.get(iRowNo).get("Material");
		String[] sMaterialList = sMaterial.split(",");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				if(sReceivedAgainst.contains("Issues")){
					materialsReturnedTab.click();
					Thread.sleep(Constant.Min_Sleep);
					for(int i=0;i<pendingReturnedQtyList.size();i++){
						dcReturnedInvoiceQtyList.get(i).sendKeys(Keys.CONTROL+"a");
						dcReturnedInvoiceQtyList.get(i).sendKeys(Keys.DELETE);
						dcReturnedInvoiceQtyList.get(i).sendKeys("1");
						receivedReturnedQtyList.get(i).sendKeys(Keys.CONTROL+"a");
						receivedReturnedQtyList.get(i).sendKeys(Keys.DELETE);
						receivedReturnedQtyList.get(i).sendKeys("1");
						acceptedReturnedQtyList.get(i).sendKeys(Keys.CONTROL+"a");
						acceptedReturnedQtyList.get(i).sendKeys(Keys.DELETE);
						acceptedReturnedQtyList.get(i).sendKeys("1");
					}
					remarksTxtField.click();
					UpdateBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					for (String element : sMaterialList) {
						if(MSLWarning.getText().contains(element)){
							flag = true;
						}else{
							flag = false;
						}
					}
					Thread.sleep(Constant.Min_Sleep);
					if(MSLWarning.isDisplayed()){
						okBtn.click();
						Thread.sleep(Constant.Min_Sleep);
					}
					okBtn.click();
					Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate MSL warning "+e);
		}
		return flag;
	}

	public boolean validateMSLWarning_MatReceived(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sMaterial = xls.get(iRowNo).get("Material");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				if(sReceivedAgainst.contains("Issues")){
					for (WebElement element : acceptedQtyList) {
						String sValue = Double.toString(Double.parseDouble(element.getAttribute("value"))-1);
						element.sendKeys(Keys.CONTROL + "a");
						element.sendKeys(Keys.DELETE);
						element.sendKeys(sValue);
					}
					remarksTxtField.click();
					UpdateBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(MSLWarning.getText().contains(sMaterial)){
						okBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						okBtn.click();
						Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate MSL warning "+e);
		}
		return flag;
	}

	public boolean updateQty(int iRowNo, String sheet, String sGRNNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sShortage = xls.get(iRowNo).get("Shortage");
		String sRejected = xls.get(iRowNo).get("Rejected");
		try{
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				if(sReceivedAgainst.contains("Issues")){
					for (WebElement element : acceptedQtyList) {
						element.sendKeys(Keys.CONTROL + "a");
						element.sendKeys(Keys.DELETE);
						element.sendKeys("10");
					}
					materialsReturnedTab.click();
					Thread.sleep(Constant.Min_Sleep);
					for(int i=0;i<pendingReturnedQtyList.size();i++){
						dcReturnedInvoiceQtyList.get(i).sendKeys(Keys.CONTROL+"a");
						dcReturnedInvoiceQtyList.get(i).sendKeys(Keys.DELETE);
						dcReturnedInvoiceQtyList.get(i).sendKeys(Double.toString((Double.parseDouble(pendingReturnedQtyList.get(i).getText())-1)));
						receivedReturnedQtyList.get(i).sendKeys(Keys.CONTROL+"a");
						receivedReturnedQtyList.get(i).sendKeys(Keys.DELETE);
						receivedReturnedQtyList.get(i).sendKeys(Double.toString((Double.parseDouble(pendingReturnedQtyList.get(i).getText())-1)));
						acceptedReturnedQtyList.get(i).sendKeys(Keys.CONTROL+"a");
						acceptedReturnedQtyList.get(i).sendKeys(Keys.DELETE);
						acceptedReturnedQtyList.get(i).sendKeys(Double.toString((Double.parseDouble(pendingReturnedQtyList.get(i).getText())-1)));
						flag = true;
					}
				}else{
					for(int i=0;i<dcInvoiceQtyList.size();i++){
						dcInvoiceQtyList.get(i).sendKeys(Keys.CONTROL + "a");
						dcInvoiceQtyList.get(i).sendKeys(Keys.DELETE);
						dcInvoiceQtyList.get(i).sendKeys("10");
						receivedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
						receivedQtyList.get(i).sendKeys(Keys.DELETE);
						if(sShortage.contains("Yes")){
							receivedQtyList.get(i).sendKeys(Integer.toString(Integer.parseInt("10")-2));
						}else{
							receivedQtyList.get(i).sendKeys("10");
						}
						acceptedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
						acceptedQtyList.get(i).sendKeys(Keys.DELETE);
						if(sRejected.contains("Yes")){
							acceptedQtyList.get(i).sendKeys(Integer.toString(Integer.parseInt("10")-4));
						}else{
							acceptedQtyList.get(i).sendKeys("10");
						}
						if(grnHSNCodeList.get(i).getAttribute("value").isEmpty() || grnHSNCodeList.get(i).getAttribute("value").matches(".*[a-zA-Z]+.*")){
							grnHSNCodeList.get(i).sendKeys(Keys.CONTROL+"a");
							grnHSNCodeList.get(i).sendKeys(Keys.DELETE);
							grnHSNCodeList.get(i).sendKeys(sDate);
						}
						flag = enterPriceDetails(i, "10");
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to update qty "+e);
		}
		return flag;
	}

	public boolean validateAmendQty(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false, flag1 = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			flag1 = updateQty(iRowNo, sheet,sGRNNo);
			if(flag1){
				flag = validateAmendGRN(iRowNo, sheet, iGRNCount, sIssueNo);
			}
		}catch(Exception e){
			System.err.println("Failed to update qty "+e);
		}
		return flag;
	}

	public boolean validateAmendDeleteMat(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			deleteAllMAtExceptOne(sGRNNo);
			flag = validateAmendGRN(iRowNo, sheet, iGRNCount, sIssueNo);
		}catch(Exception e){
			System.err.println("Failed to update qty "+e);
		}
		return flag;
	}

	public boolean amendDeleteMatRecNAddMatReturn(int iRowNo, String sheet){
		boolean flag = false; String sIssueNo = null;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			sIssueNo = deleteReceivedNAddReturn(iRowNo, sheet, sGRNNo, null);
			flag = validateAmendGRN(iRowNo, sheet, iGRNCount, sIssueNo);
		}catch(Exception e){
			System.err.println("Failed to update qty "+e);
		}
		return flag;
	}

	public boolean superEditIssueNoNVerify(String sIssueNo){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			int iRow = preparedOn.size();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/span[2]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sIssueNo+"')]")).isDisplayed()){
				issueNoEditIcon.click();
				Thread.sleep(Constant.Min_Sleep);
				String sActNo = issueNoEdit_SuperEdit.getAttribute("value");
				issueNoEdit_SuperEdit.clear();
				issueNoEdit_SuperEdit.sendKeys(Integer.toString(Integer.parseInt(sActNo)+1));
				saveIconIssueNo_SuperEdit.click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				sIssueNo = grnDraft_EditPage.getText();
				navigate.navigateToStore();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToIssueReturn();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				int iGRNCount = grnList.size();
				js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
				if(grnRefDocNoCol.get(iGRNCount-1).getText().contains(sIssueNo)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate issue no update "+e);
		}
		return flag;
	}

	public boolean updateQty_OnlyReceived(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String sIssueNo = null;
		try{
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				for (WebElement element : acceptedQtyList) {
					element.sendKeys(Keys.CONTROL + "a");
					element.sendKeys(Keys.DELETE);
					element.sendKeys("10");
				}
				issueNoDrpDwn.click();
				Thread.sleep(Constant.Min_Sleep);
				for (WebElement element : selectedIssueNo) {
					js.executeScript("arguments[0].scrollIntoView(true);", element);
					sIssueNo = element.getText();
				}
			}
			flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, sIssueNo);
		}catch(Exception e){
			System.err.println("Failed to update qty "+e);
		}
		return flag;
	}

	public boolean updateDeleteReceived(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String sIssueNo = null;
		try{
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				if(driver.findElements(By.xpath(".//*[@id='materialtable']/tbody/tr/td[1]")).size() > 0){
					for (WebElement element : irnDeleteList) {
						element.click();
						Thread.sleep(Constant.Min_Sleep);
						driver.switchTo().alert().accept();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
				for (WebElement element : selectedIssueNo) {
					js.executeScript("arguments[0].scrollIntoView(true);", element);
					sIssueNo = element.getText();
				}
			}
			flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, sIssueNo);
		}catch(Exception e){
			System.err.println("Failed to update qty "+e);
		}
		return flag;
	}

	public String deleteReceivedNAddReturn(int iRowNo, String sheet, String sGRNNo, String sIssueNo){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				if(driver.findElements(By.xpath(".//*[@id='materialtable']/tbody/tr/td[1]")).size() > 0){
					for (WebElement element : irnDeleteList) {
						element.click();
						Thread.sleep(Constant.Min_Sleep);
						driver.switchTo().alert().accept();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
				if(sIssueNo == null){
					for (WebElement element : selectedIssueNo) {
						js.executeScript("arguments[0].scrollIntoView(true);", element);
						sIssueNo = element.getText();
					}
				}else{
					issueNoYrDrpDwn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(issueNoYrOptionDrpDwnList.size() > 0){
						for (WebElement element : selectedIssueNoYrOp) {
							element.click();
							Thread.sleep(Constant.Min_Sleep);
						}
						for (WebElement element : issueNoYrOptionDrpDwnList) {
							element.click();
							Thread.sleep(Constant.Min_Sleep);
						}
					}
					Thread.sleep(Constant.Max_Sleep);
					issueNoDrpDwn.click();
					issueNoSearch.sendKeys(sIssueNo);
					driver.findElement(By.xpath(".//label[contains(text(),'"+sIssueNo+"')]")).click();
					Thread.sleep(Constant.Max_Sleep);
				}
				materialsReturnedTab.click();
				Thread.sleep(Constant.Min_Sleep);
				addReturnedMatQty(iRowNo, sheet,0);
			}
		}catch(Exception e){
			System.err.println("Failed to delete material received and add returned materials "+e);
		}
		return sIssueNo;
	}

	public boolean updateDeleteReceived_AddMat(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			deleteReceivedNAddReturn(iRowNo, sheet, sGRNNo, sIssueNo);
			flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, sIssueNo);
		}catch(Exception e){
			System.err.println("Failed to update qty "+e);
		}
		return flag;
	}


	public boolean verifyPendingQtyOfIssue(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sQty = xls.get(iRowNo).get("Quantity");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			addGRNBtn.click();
			Constant.waitForPageLoad();
			issueToDropdwn.click();
			issueToDropdwn_search.sendKeys(sIssueTo);
			driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
			Thread.sleep(Constant.Max_Sleep);
			issueNoYrDrpDwn.click();
			String FY = sIssueNo.substring(0,5);
			driver.findElement(By.xpath(".//ul/li/a/label[contains(text(),'"+FY+"')]")).click();
			Thread.sleep(Constant.Medium_Sleep);
			issueNoDrpDwn.click();
			issueNoSearch.sendKeys(sIssueNo);
			driver.findElement(By.xpath(".//label[contains(text(),'"+sIssueNo+"')]")).click();
			Thread.sleep(Constant.Max_Sleep);
			materialsReturnedTab.click();
			Thread.sleep(Constant.Min_Sleep);
			for (WebElement element : pendingReturnedQtyList) {
				if(element.getText().contains(Integer.toString(Integer.parseInt(sQty)+1))){
					flag = true;
				}else{
					flag = false;
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate issue pending qty "+e);
		}
		return flag;
	}

	public boolean updateIRN_ReduceMatQty(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(updateQty(iRowNo, sheet, sGRNNo)){
				UpdateBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				okButton.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
				backBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
				navigate.showAllEntries();
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']")));
				Thread.sleep(Constant.Min_Sleep);
				WebElement ele = driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']/following::td[12]/a[text()='Rejected']"));
				if(ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to update IRN by reducing material qty "+e);
		}
		return flag;
	}

	public boolean updateIRN_ChangeIssueNo(int iRowNo, String sheet, String sStatus){
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int k = 0; String sIssueNo = null;
		ArrayList<String> sSelectedIssueNo = new ArrayList<>();
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			String[] sOptions = selectDraftIRN(sStatus);
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sOptions[0])){
				issueNoDrpDwn.click();
				Thread.sleep(Constant.Min_Sleep);
				for (WebElement element : selectedIssueNo) {
					js.executeScript("arguments[0].scrollIntoView(true);", element);
					sIssueNo = element.getText();
					element.click();
					sSelectedIssueNo.add(sIssueNo);
					Thread.sleep(Constant.Medium_Sleep);
				}
				issueNoDrpDwn.click();
				Thread.sleep(Constant.Min_Sleep);
				issueNoDrpDwn.click();
				Thread.sleep(Constant.Min_Sleep);
				for(k=1;k<issueNoOptionDrpDwnList.size();k++){
					if(!sSelectedIssueNo.contains(issueNoOptionDrpDwnList.get(k).getText())){
						sIssueNo = issueNoOptionDrpDwnList.get(k).getText();
						issueNoOptionDrpDwnList.get(k).click();
						Thread.sleep(Constant.Max_Sleep);
						Thread.sleep(Constant.Min_Sleep);
						break;
					}
				}
				materialsReturnedTab.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<pendingReturnedQtyList.size();i++){
					boolean flag9 = Constant.isElementPresent(By.xpath(".//input[@name='pending_qty']"));
					if(flag9){
						addReturnedMatQty(iRowNo, sheet,i);
						if(grnHSNCodeList_MatRet.get(i).getAttribute("value").isEmpty() || grnHSNCodeList_MatRet.get(i).getAttribute("value").matches(".*[a-zA-Z]+.*")){
							grnHSNCodeList_MatRet.get(i).sendKeys(Keys.CONTROL+"a");
							grnHSNCodeList_MatRet.get(i).sendKeys(Keys.DELETE);
							grnHSNCodeList_MatRet.get(i).sendKeys(sDate);
						}
					}
				}
			}
			flag = validateUpdateGRN(iRowNo, sheet, Integer.parseInt(sOptions[1]), sIssueNo);
		}catch(Exception e){
			System.err.println("Failed to update IRN by changing issue no "+e);
		}
		return flag;
	}

	public boolean verifyRemarkLink_AddGRN(){
		boolean flag = false;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				remarksLink_EditPge.click();
				Thread.sleep(Constant.Min_Sleep);
				if(remarksDescription.get(0).getText().contains(sDate)){
					flag = true;
					remarksPopupCloseBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate remark link "+e);
		}
		return flag;
	}

	public boolean verifyRemarkLink_UpdateGRN(){
		boolean flag = false;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				remarksLink_EditPge.click();
				Thread.sleep(Constant.Min_Sleep);
				if(remarksDescription.get(1).getText().contains(sDate)){
					flag = true;
					remarksPopupCloseBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate remark link "+e);
		}
		return flag;
	}

	public boolean addQtyDetails(int i,int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sShortage = xls.get(iRowNo).get("Shortage");
		String sRejected = xls.get(iRowNo).get("Rejected");
		try{
			String sPOPending = pendingQtyGRN.get(i).getText();
			if(!(Double.parseDouble(sPOPending) == 0)){
				if(Double.parseDouble(sPOPending) > 10){
					sPOPending = "10";
				}
				dcInvoiceQtyList.get(i).sendKeys(Keys.CONTROL + "a");
				dcInvoiceQtyList.get(i).sendKeys(Keys.DELETE);
				dcInvoiceQtyList.get(i).sendKeys(sPOPending);
				receivedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
				receivedQtyList.get(i).sendKeys(Keys.DELETE);
				if(sShortage.contains("Yes")){
					receivedQtyList.get(i).sendKeys(Double.toString(Double.parseDouble(sPOPending)-2));
				}else{
					receivedQtyList.get(i).sendKeys(sPOPending);
				}
				acceptedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
				acceptedQtyList.get(i).sendKeys(Keys.DELETE);
				if(sRejected.contains("Yes")){
					acceptedQtyList.get(i).sendKeys(Double.toString(Double.parseDouble(sPOPending)-4));
				}else{
					acceptedQtyList.get(i).sendKeys(sPOPending);
				}
				flag = enterPriceDetails(i, sPOPending);
			}else{
				dcInvoiceQtyList.get(i).sendKeys(Keys.CONTROL + "a");
				dcInvoiceQtyList.get(i).sendKeys(Keys.DELETE);
				dcInvoiceQtyList.get(i).sendKeys("500");
				receivedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
				receivedQtyList.get(i).sendKeys(Keys.DELETE);
				if(sShortage.contains("yes")){
					receivedQtyList.get(i).sendKeys("480");
				}else{
					receivedQtyList.get(i).sendKeys("500");
				}
				acceptedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
				acceptedQtyList.get(i).sendKeys(Keys.DELETE);
				if(sRejected.contains("yes")){
					acceptedQtyList.get(i).sendKeys("460");
				}else{
					acceptedQtyList.get(i).sendKeys("500");
				}
				flag = enterPriceDetails(i, "500");
			}
			if(grnHSNCodeList.get(i).getAttribute("value").isEmpty() || grnHSNCodeList.get(i).getAttribute("value").matches(".*[a-zA-Z]+.*")){
				grnHSNCodeList.get(i).sendKeys(Keys.CONTROL+"a");
				grnHSNCodeList.get(i).sendKeys(Keys.DELETE);
				grnHSNCodeList.get(i).sendKeys(sDate);
			}
		}catch(Exception e){
			System.err.println("Unable to add GRN material quantity details "+e);
		}
		return flag;
	}

	public boolean enterPriceDetails(int i, String sPOPending){
		boolean flag = false;
		String sPrice = RandomStringUtils.randomNumeric(3);
		String sDiscount = RandomStringUtils.randomNumeric(1);
		Double unitprice = null;Double dUnitPrice = null;
		try{
			PriceList.get(i).sendKeys(Keys.CONTROL + "a");
			PriceList.get(i).sendKeys(Keys.DELETE);
			PriceList.get(i).sendKeys(sPrice);
			discountList.get(i).sendKeys(Keys.CONTROL + "a");
			discountList.get(i).sendKeys(Keys.DELETE);
			discountList.get(i).sendKeys(sDiscount);
			PriceList.get(i).click();
			String sTotalPrice = totalPriceList.get(i).getAttribute("value");
			Double totalPrice = Double.parseDouble(sPOPending) * Double.parseDouble(sPrice);
			totalPrice = totalPrice - (totalPrice * Double.parseDouble(sDiscount) / 100);
			String sCalUnit = Double.toString(totalPrice);
			dUnitPrice = Math.round(totalPrice * 100.0) / 100.0;
			if(sCalUnit.contains(".")){
				String[] sListCalUnit = sCalUnit.split("\\.");
				if(sListCalUnit[1].length() > 2){
					if(sListCalUnit[1].substring(2, 3).equals("5")){
						String sUnit = sListCalUnit[0]+"."+sListCalUnit[1].substring(0, 2);
						unitprice = Double.parseDouble(sUnit);
					}else{
						unitprice = Math.round(totalPrice * 100.0) / 100.0;
					}
				}else{
					unitprice = Math.round(totalPrice * 100.0) / 100.0;
				}
			}else{
				unitprice = Math.round(totalPrice * 100.0) / 100.0;
			}
			if(Double.parseDouble(sTotalPrice) == unitprice || Double.parseDouble(sTotalPrice) == dUnitPrice){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Unable to add GRN material quantity details "+e);
		}
	return flag;
	}

	public boolean addCGSTTax(int i,int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCGST = xls.get(iRowNo).get("CGST");
		try{
			Select select = new Select(CGSTDropDwn.get(i));
			select.selectByValue(sCGST);
			String sTotalPrice = totalPriceList.get(i).getAttribute("value");
			String sCGSTValue = cgstAmtList.get(i).getText();
			String sDiscount = driver.findElement(By.xpath(".//select[@name='cgst']/option[@value='"+sCGST+"']")).getText();
			double totalPrice = (Double.parseDouble(sTotalPrice) * Double.parseDouble(sDiscount)) / 100;
			double actPrice = Math.round(totalPrice * 100.0) / 100.0;
			if(Double.parseDouble(sCGSTValue) == actPrice){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Unable to add cgst tax "+e);
		}
		return flag;
	}

	public boolean addSGSTTax(int i,int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sSGST = xls.get(iRowNo).get("SGST");
		try{
			Select select = new Select(SGSTDropDwn.get(i));
			select.selectByValue(sSGST);
			String sTotalPrice = totalPriceList.get(i).getAttribute("value");
			String sSGSTValue = sgstAmtList.get(i).getText();
			String sDiscount = driver.findElement(By.xpath(".//select[@name='sgst']/option[@value='"+sSGST+"']")).getText();
			double totalPrice = (Double.parseDouble(sTotalPrice) * Double.parseDouble(sDiscount)) / 100;
			double actPrice = Math.round(totalPrice * 100.0) / 100.0;
			if(Double.parseDouble(sSGSTValue) == actPrice){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Unable to add sgst tax "+e);
		}
		return flag;
	}

	public boolean addIGSTTax(int i,int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIGST = xls.get(iRowNo).get("IGST");
		try{
			Select select = new Select(IGSTDropDwn.get(i));
			select.selectByValue(sIGST);
			String sTotalPrice = totalPriceList.get(i).getAttribute("value");
			String sIGSTValue = igstAmtList.get(i).getText();
			String sDiscount = driver.findElement(By.xpath(".//select[@name='igst']/option[@value='"+sIGST+"']")).getText();
			double totalPrice = (Double.parseDouble(sTotalPrice) * Double.parseDouble(sDiscount)) / 100;
			double actPrice = Math.round(totalPrice * 100.0) / 100.0;
			if(Double.parseDouble(sIGSTValue) == actPrice){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Unable to add igst tax "+e);
		}
		return flag;
	}

	public boolean addCGSTTax_goods(int i,int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCGST = xls.get(iRowNo).get("CGST");
		try{
			Select select = new Select(CGSTDropDwn_goods);
			select.selectByValue(sCGST);
			String sTotalPrice = totalPriceConsolidate_goods.get(i).getAttribute("value");
			String sCGSTValue = cgstAmtList_goods.get(i).getText();
			String sDiscount = driver.findElement(By.xpath(".//td[@class='consolidated_price_column']//select[@name='cgst']/option[@value='"+sCGST+"']")).getText();
			double totalPrice = (Double.parseDouble(sTotalPrice) * Double.parseDouble(sDiscount)) / 100;
			double actPrice = Math.round(totalPrice * 100.0) / 100.0;
			if(Double.parseDouble(sCGSTValue) == actPrice){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Unable to add cgst tax "+e);
		}
		return flag;
	}

	public boolean addSGSTTax_goods(int i,int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sSGST = xls.get(iRowNo).get("SGST");
		try{
			Select select = new Select(SGSTDropDwn_goods);
			select.selectByValue(sSGST);
			String sTotalPrice = totalPriceConsolidate_goods.get(i).getAttribute("value");
			String sSGSTValue = sgstAmtList_goods.get(i).getText();
			String sDiscount = driver.findElement(By.xpath(".//td[@class='consolidated_price_column']//select[@name='sgst']/option[@value='"+sSGST+"']")).getText();
			double totalPrice = (Double.parseDouble(sTotalPrice) * Double.parseDouble(sDiscount)) / 100;
			double actPrice = Math.round(totalPrice * 100.0) / 100.0;
			if(Double.parseDouble(sSGSTValue) == actPrice){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Unable to add sgst tax "+e);
		}
		return flag;
	}

	public boolean addIGSTTax_goods(int i,int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIGST = xls.get(iRowNo).get("IGST");
		try{
			Select select = new Select(IGSTDropDwn_goods);
			select.selectByValue(sIGST);
			String sTotalPrice = totalPriceConsolidate_goods.get(i).getAttribute("value");
			String sIGSTValue = igstAmtList_goods.get(i).getText();
			String sDiscount = driver.findElement(By.xpath(".//td[@class='consolidated_price_column']//select[@name='igst']/option[@value='"+sIGST+"']")).getText();
			double totalPrice = (Double.parseDouble(sTotalPrice) * Double.parseDouble(sDiscount)) / 100;
			double actPrice = Math.round(totalPrice * 100.0) / 100.0;
			if(Double.parseDouble(sIGSTValue) == actPrice){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Unable to add igst tax "+e);
		}
		return flag;
	}

	public boolean addTax(int iRowNo,String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("Tax");
		try{
			taxDropDwn.click();
			Thread.sleep(Constant.Min_Sleep);
			taxSearch.sendKeys(sTax);
			driver.findElement(By.xpath(".//em[text()='"+sTax+"']")).click();
			addTaxBtn.click();
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

	public boolean RoundOff(){
		boolean flag = false;
		String sGrandTotal,sDecimalvalue;
		try{
			sGrandTotal = grnGrandTotal.getAttribute("value");
			grnRoundOff.sendKeys(Keys.CONTROL+"a");
			grnRoundOff.sendKeys(Keys.DELETE);
			grnRoundOff.sendKeys("0.00");
			grnGrandTotal.click();
			sGrandTotal = grnGrandTotal.getAttribute("value");
			Thread.sleep(2000);
			sDecimalvalue = sGrandTotal.substring(sGrandTotal.indexOf("."));
			if(!sDecimalvalue.contains("00")){
				sDecimalvalue = sDecimalvalue.substring(1);
				Thread.sleep(2000);
				int iRemaining = 100 - Integer.parseInt(sDecimalvalue);
				if(iRemaining < 50){
					if(iRemaining < 10){
						grnRoundOff.sendKeys(Keys.chord(Keys.CONTROL, "a"),".0"+iRemaining);
					}else{
						grnRoundOff.sendKeys(Keys.chord(Keys.CONTROL, "a"),"."+iRemaining);
					}
				}else{
					grnRoundOff.sendKeys(Keys.chord(Keys.CONTROL, "a"), "-."+sDecimalvalue);
				}
				grnRoundOff.sendKeys(Keys.TAB);
				grnRoundOff.sendKeys(Keys.ENTER);
				grnGrandTotal.click();
				Thread.sleep(Constant.Min_Sleep);
				sGrandTotal = grnGrandTotal.getAttribute("value");
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

	public boolean updateGRN(int iRowNo, String sheet, String sIssueNo) throws Exception{
		boolean flag = false;
		try{
			addGRN(iRowNo, sheet, sIssueNo);
			flag = validateGRNUpdate(iRowNo, sheet, sIssueNo);
		}catch(Exception e){
			System.err.println("Unable to update grn "+e);
		}
		return flag;
	}

	public boolean validateGRNUpdate(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false, flag1 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sReceivedAs = xls.get(iRowNo).get("Received As");
		String sPoMandatory = xls.get(iRowNo).get("PO Mandatory");
		String sGRNNo = null, sPONO = null;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int iGRNCount = grnList.size();
			sGRNNo = grnList.get(iGRNCount-1).getText();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
 				flag1 = updateGRNDetails(iRowNo, sheet, sIssueNo);
 				sPONO = sIssueNo;
 				if(sReceivedAgainst.contains("Issues") && sIssueNo == null){
 					String sSelectedIssueNo = issueNoDropDwnField.getAttribute("title");
 					String[] sIssueNumbers = sSelectedIssueNo.split(",");
 					sPONO = sIssueNumbers[0].trim();
 				}
 				if(sReceivedAgainst.contains("Delivery Challan")){
	 				for (WebElement element : dcMaterialGridList) {
	 					sPONO = element.getText();
	 					if(!sPONO.isEmpty()){
	 						break;
	 					}
	 				}
 				}
 				if(sReceivedAgainst.contains("Job Work") || sReceivedAgainst.contains("Purchase Order") || sReceivedAgainst.contains("Sales Return")){
 					for (WebElement element : poMaterialGridList) {
 	 					boolean flag2 = Constant.isElementPresent(By.xpath("//span[@class='consolidated_material_name']"));
 	 					if(!flag2){
 	 						sPONO = element.getText();
 	 	 					if(!sPONO.isEmpty()){
 	 	 						break;
 	 	 					}
 	 					}
 	 				}
 				}
 				if(sReceivedAgainst.contains("Job In")){
	 				for (WebElement element : oaNoDropDwnMatGridList) {
	 					sPONO = element.getText();
	 					if(sPONO.contains("Select OA")){
	 						sPONO = null;
	 					}else{
	 						break;
	 					}
	 				}
 				}
 				if(sReceivedAs.contains("Goods")){
					if(sPoMandatory.contains("With Po")){
						for(int i=0;i<MaterialListPartyDcNo.size();i++){
							MaterialListPartyDcNo.get(0).click();
							sPONO = firstMaterialPONo.getText();
							if(!(sPONO.contains("PO No")  || sPONO.contains("JO No") || sPONO.contains("SR"))){
								sPONO = "-NA-";
							}else{
								sPONO = sPONO.substring(7, 22);
								break;
							}
						}
					}else{
						for(int i=0;i<MaterialListPartyDcNo.size();i++){
							MaterialListPartyDcNo.get(0).click();
							sPONO = firstMaterialPONo.getText();
							if(!(sPONO.contains("PO No")  || sPONO.contains("JO No") || sPONO.contains("SR"))){
								sPONO = "-NA-";
								break;
							}else{
								sPONO = sPONO.substring(7, 22);
							}
						}
					}
					if(sPONO == "-NA-"){
						sPONO = null;
					}
 				}
			}
			if(sPONO != null){
				int iCount = sPONO.length();
				if(!sPONO.contains("D")){
					for(int j=1;j<iCount;j++){
						iCount = sPONO.length();
						if(iCount < 13){
							sPONO = sPONO.substring(0, 7)+String.format("%01d", 0)+sPONO.substring(7,iCount);
						}else if(iCount > 20 && (sPONO.contains("JO No") || sPONO.contains("PO No") || sPONO.contains("G0"))){
							sPONO = sPONO.substring(7, 22);
						}else{
							break;
						}
					}
				}
			}
			if(flag1){
				flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, sPONO);
			}
		}catch(Exception e){
			System.err.println("Unable to update grn "+e);
		}
		return flag;
	}

	public boolean validateIssueAdd_IRN(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false, flag1, flag2, flag3 = false;
		String sGRNNo = null;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueNoCount = xls.get(iRowNo).get("Issue No Selection");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int iGRNCount = grnList.size();
			sGRNNo = grnList.get(iGRNCount-1).getText();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				issueNoDrpDwn.click();
				issueNoSearch.sendKeys(sIssueNo);
				driver.findElement(By.xpath(".//label[contains(text(),'"+sIssueNo+"')]")).click();
				Thread.sleep(Constant.Max_Sleep);
				flag1 = addReturnedQtyDetails(iRowNo, sheet,sIssueNoCount);
				jse.executeScript("window.scrollBy(0,-5000)");
				if(grnHSNCodeList_MatRet.size() == 2){
					flag3 = true;
				}
				matReceivedTab.click();
				Thread.sleep(Constant.Min_Sleep);
				flag2 = addStockMaterial(iRowNo, sheet);
				if(flag1 && flag2 && flag3){
					flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, sIssueNo);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate issue addition in IRN "+e);
		}
		return flag;
	}

	public String[] selectDraftIRN(String sStatus){
		String sGRNNo = null; int i = 0;
		try{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			for(i=0;i<grnList.size();i++){
				jse.executeScript("arguments[0].scrollIntoView(true);",grnList.get(i));
				if(grnStatusList.get(i).getText().contains(sStatus)){
					sGRNNo = grnList.get(i).getText();
					Actions actions = new Actions(driver);
					actions.moveToElement(grnList.get(i)).perform();
					grnList.get(i).click();
					Thread.sleep(Constant.Min_Sleep);
					break;

				}
			}
		}catch(Exception e){
			System.err.println("Failed to select draft IRN "+e);
		}
		return new String[] {sGRNNo, Integer.toString(i+1)};
	}

	public boolean warningpoup_AllMatDelete(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addGRN(iRowNo, sheet, null);
			int iGRNCount = grnList.size();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				if(driver.findElements(By.xpath(".//*[@id='materialtable']/tbody/tr/td[1]")).size() > 0){
					for (WebElement element : irnDeleteList) {
						element.click();
						Thread.sleep(Constant.Min_Sleep);
						driver.switchTo().alert().accept();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
				materialsReturnedTab.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<pendingReturnedQtyList.size();i++){
					deleteReturnedMatQty(i);
				}
				UpdateBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(NoMatWarning.isDisplayed()){
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Warning popup not displayed when all materials deleted "+e);
		}
		return flag;
	}

	public boolean updateGRNByAddingJo(int iRowNo, String sheet){
		boolean flag = false, flag1 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sPoMandatory = xls.get(iRowNo).get("PO Mandatory");
		String sGRNNo = null, sPONo = null;
		 int i;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			sGRNNo = grnList.get(iGRNCount-1).getText();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				sPONo = selectAnotherPO(iRowNo, sheet);
				for(i=0;i<MaterialTabPoNoList.size();i++){
					if(MaterialTabPoNoList.get(i).getText().contains(sPONo)){
						break;
					}
				}
				if(!(sReceivedAgainst.contains("Delivery Challan") || sReceivedAgainst.contains("Others") || sReceivedAgainst.contains("Issues")
						|| sPoMandatory.equals("Without Po") || sReceivedAgainst.contains("Job In"))){
					flag1 = addQtyDetails(i,iRowNo,sheet);
					addCGSTTax(i,iRowNo,sheet);
					addSGSTTax(i,iRowNo,sheet);
					addIGSTTax(i,iRowNo,sheet);
				}
				if(sReceivedAgainst.contains("Job In") && !sPoMandatory.equals("Without Po")){
					flag1 = addMaterial_ViewOa(iRowNo,sheet);
				}
				remarksTxtField.click();
			}
			int iCount = sPONo.length();
			for(int j=1;j<iCount;j++){
				iCount = sPONo.length();
				if(iCount < 13){
					sPONo = sPONo.substring(0, 7)+String.format("%01d", 0)+sPONo.substring(7,iCount);
				}else{
					break;
				}
			}
			if(flag1){
				flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, sPONo);
			}
		}catch(Exception e){
			System.err.println("Unable to update grn adding Po"+e);
		}
		return flag;
	}

	public void deleteAllMAtExceptOne(String sGRNNo){
		try{
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				if(driver.findElements(By.xpath(".//*[@id='materialtable']/tbody/tr/td[1]")).size() > 0){
					for (WebElement element : irnDeleteList) {
						element.click();
						Thread.sleep(Constant.Min_Sleep);
						driver.switchTo().alert().accept();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
				materialsReturnedTab.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=1;i<pendingReturnedQtyList.size();i++){
					deleteReturnedMatQty(i);
				}
			}
		}catch(Exception e){
			System.err.println("Unable to delete material except one "+e);
		}
	}

	public boolean UpdateIRN_deleteAllMatExceptOne(int iRowNo, String sheet,String sIssueNo){
		boolean flag = false;
		String sGRNNo = null;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int iGRNCount = grnList.size();
			sGRNNo = grnList.get(iGRNCount-1).getText();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			deleteAllMAtExceptOne(sGRNNo);
			flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, sIssueNo);
		}catch(Exception e){
			System.err.println("Failed to update IRN after deleting material except one "+e);
		}
		return flag;
	}

	public boolean UpdateIRN_deleteItemWOMakeRFaulty(int iRowNo, String sheet,String sIssueNo){
		boolean flag = false;
		String sGRNNo = null;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int iGRNCount = grnList.size();
			sGRNNo = grnList.get(iGRNCount-1).getText();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				if(driver.findElements(By.xpath(".//*[@id='materialtable']/tbody/tr/td[1]")).size() > 0){
					for(int i=0;i<irnDeleteList.size();i++){
						materialsReceivedTab.click();
						Thread.sleep(Constant.Min_Sleep);
						if(!materialReceivedList.get(i).getText().contains("[")){
							irnDeleteList.get(i).click();
							Thread.sleep(Constant.Min_Sleep);
							driver.switchTo().alert().accept();
							Thread.sleep(Constant.Min_Sleep);
						}
					}
				}
				materialsReturnedTab.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<pendingReturnedQtyList.size();i++){
					if(!materialRetIRNList.get(i).getText().contains("[")){
						deleteReturnedMatQty(i);
					}
				}
				flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, sIssueNo);
			}
		}catch(Exception e){
			System.err.println("Failed to update IRN after deleting material without make or faulty "+e);
		}
		return flag;
	}

	public boolean UpdateIRN_deleteItemWMakeRFaulty(int iRowNo, String sheet,String sIssueNo){
		boolean flag = false;
		String sGRNNo = null;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int iGRNCount = grnList.size();
			sGRNNo = grnList.get(iGRNCount-1).getText();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				if(driver.findElements(By.xpath(".//*[@id='materialtable']/tbody/tr/td[1]")).size() > 0){
					for(int i=0;i<irnDeleteList.size();i++){
						if(materialReceivedList.get(i).getText().contains("[")){
							irnDeleteList.get(i).click();
							Thread.sleep(Constant.Min_Sleep);
							driver.switchTo().alert().accept();
							Thread.sleep(Constant.Min_Sleep);
						}
					}
				}
				materialsReturnedTab.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<pendingReturnedQtyList.size();i++){
					if(materialRetIRNList.get(i).getText().contains("[")){
						deleteReturnedMatQty(i);
					}
				}
				flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, sIssueNo);
			}
		}catch(Exception e){
			System.err.println("Failed to update IRN after deleting material with make or faulty "+e);
		}
		return flag;
	}

	public boolean verifyWarnMsgAccepQtyMoreThanPendQty(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			addGRNBtn.click();
			Constant.waitForPageLoad();
			issueToDropdwn.click();
			issueToDropdwn_search.sendKeys(sIssueTo);
			driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
			Thread.sleep(Constant.Max_Sleep);
			issueNoYrDrpDwn.click();
			String FY = sIssueNo.substring(0,5);
			driver.findElement(By.xpath(".//ul/li/a/label[contains(text(),'"+FY+"')]")).click();
			Thread.sleep(Constant.Medium_Sleep);
			issueNoDrpDwn.click();
			issueNoSearch.sendKeys(sIssueNo);
			driver.findElement(By.xpath(".//label[contains(text(),'"+sIssueNo+"')]")).click();
			Thread.sleep(Constant.Max_Sleep);
			materialsReturnedTab.click();
			Thread.sleep(Constant.Min_Sleep);
			dcReturnedInvoiceQtyList.get(0).sendKeys(Keys.CONTROL+"a");
			dcReturnedInvoiceQtyList.get(0).sendKeys(Keys.DELETE);
			dcReturnedInvoiceQtyList.get(0).sendKeys(Double.toString(Double.parseDouble(pendingReturnedQtyList.get(0).getText())+1));
			receivedReturnedQtyList.get(0).sendKeys(Keys.CONTROL+"a");
			receivedReturnedQtyList.get(0).sendKeys(Keys.DELETE);
			receivedReturnedQtyList.get(0).sendKeys(Double.toString(Double.parseDouble(pendingReturnedQtyList.get(0).getText())+1));
			acceptedReturnedQtyList.get(0).sendKeys(Keys.CONTROL+"a");
			acceptedReturnedQtyList.get(0).sendKeys(Keys.DELETE);
			acceptedReturnedQtyList.get(0).sendKeys(Double.toString(Double.parseDouble(pendingReturnedQtyList.get(0).getText())+1));
			remarksTxtField.click();
			Thread.sleep(Constant.Min_Sleep);
			acceptWarningMatReturned.click();
			if(tooltipWarning.get(0).getText().contains("Accepted quantity for the Invoice being more than the quantity mentioned as Pending in this Invoice.\nPending Qty: 1")){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to validate warning msg when accepted qty more than pending qty "+e);
		}
		return flag;
	}

	public boolean verifyWarnMsgAccepQtyMoreThanReceivedQty(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			addGRNBtn.click();
			Constant.waitForPageLoad();
			issueToDropdwn.click();
			issueToDropdwn_search.sendKeys(sIssueTo);
			driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
			Thread.sleep(Constant.Max_Sleep);
			issueNoYrDrpDwn.click();
			String FY = sIssueNo.substring(0,5);
			driver.findElement(By.xpath(".//ul/li/a/label[contains(text(),'"+FY+"')]")).click();
			Thread.sleep(Constant.Medium_Sleep);
			issueNoDrpDwn.click();
			issueNoSearch.sendKeys(sIssueNo);
			driver.findElement(By.xpath(".//label[contains(text(),'"+sIssueNo+"')]")).click();
			Thread.sleep(Constant.Max_Sleep);
			materialsReturnedTab.click();
			Thread.sleep(Constant.Min_Sleep);
			dcReturnedInvoiceQtyList.get(0).sendKeys(Keys.CONTROL+"a");
			dcReturnedInvoiceQtyList.get(0).sendKeys(Keys.DELETE);
			dcReturnedInvoiceQtyList.get(0).sendKeys(pendingReturnedQtyList.get(0).getText());
			receivedReturnedQtyList.get(0).sendKeys(Keys.CONTROL+"a");
			receivedReturnedQtyList.get(0).sendKeys(Keys.DELETE);
			receivedReturnedQtyList.get(0).sendKeys(pendingReturnedQtyList.get(0).getText());
			acceptedReturnedQtyList.get(0).sendKeys(Keys.CONTROL+"a");
			acceptedReturnedQtyList.get(0).sendKeys(Keys.DELETE);
			acceptedReturnedQtyList.get(0).sendKeys(Double.toString(Double.parseDouble(pendingReturnedQtyList.get(0).getText())+1));
			remarksTxtField.click();
			Actions actions = new Actions(driver);
			actions.moveToElement(acceptWarningMatReturned).perform();
			for(int i=0;i<tooltipWarning.size();i++){
				String[] sSentences = {"Accepted quantity for the Invoice being more than the quantity mentioned as Pending in this Invoice.\nPending Qty: 1",
						"Accepted quantity for the Invoice being more than the quantity mentioned as Received in this Invoice.\nReceived Qty: 1.00"};
				if(tooltipWarning.get(i).getText().contains(sSentences[i])){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate warning msg when accepted qty more than received qty "+e);
		}
		return flag;
	}

	public boolean amendGRNByAddingJo(int iRowNo, String sheet){
		boolean flag = false, flag1 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sPoMandatory = xls.get(iRowNo).get("PO Mandatory");
		String sGRNNo = null, sPONo = null;
		 int i;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			sGRNNo = grnList.get(iGRNCount-1).getText();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				sPONo = selectAnotherPO(iRowNo, sheet);
				for(i=0;i<MaterialTabPoNoList.size();i++){
					if(MaterialTabPoNoList.get(i).getText().contains(sPONo)){
						break;
					}
				}
				if(!(sReceivedAgainst.contains("Delivery Challan") || sReceivedAgainst.contains("Others") || sReceivedAgainst.contains("Issues")
						|| sPoMandatory.equals("Without Po") || sReceivedAgainst.contains("Job In"))){
					flag1 = addQtyDetails(i,iRowNo,sheet);
					addCGSTTax(i,iRowNo,sheet);
					addSGSTTax(i,iRowNo,sheet);
					addIGSTTax(i,iRowNo,sheet);
				}
				if(sReceivedAgainst.contains("Job In") && !sPoMandatory.equals("Without Po")){
					flag1 = addMaterial_ViewOa(iRowNo,sheet);
				}
				remarksTxtField.click();
			}
			int iCount = sPONo.length();
			for(int j=1;j<iCount;j++){
				iCount = sPONo.length();
				if(iCount < 13){
					sPONo = sPONo.substring(0, 7)+String.format("%01d", 0)+sPONo.substring(7,iCount);
				}else{
					break;
				}
			}
			if(flag1){
				flag = validateAmendGRN(iRowNo, sheet, iGRNCount, sPONo);
			}
		}catch(Exception e){
			System.err.println("Unable to update grn adding Po"+e);
		}
		return flag;
	}

	public boolean validateGRNAmend(int iRowNo, String sheet){
		boolean flag = false, flag1 = false;
		String sGRNNo = null, sPONO = null;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			sGRNNo = grnList.get(iGRNCount-1).getText();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
 				flag1 = updateGRNDetails(iRowNo, sheet, null);
 				for (WebElement element : oaNoDropDwnMatGridList) {
 					sPONO = element.getText();
 					if(sPONO.contains("Select OA")){
 						sPONO = null;
 					}else{
 						break;
 					}
 				}
			}
			if(sPONO != null){
				int iCount = sPONO.length();
				for(int j=1;j<iCount;j++){
					iCount = sPONO.length();
					if(iCount < 13){
						sPONO = sPONO.substring(0, 7)+String.format("%01d", 0)+sPONO.substring(7,iCount);
					}else{
						break;
					}
				}
			}
			if(flag1){
				flag = validateAmendGRN(iRowNo, sheet, iGRNCount, sPONO);
			}
		}catch(Exception e){
			System.err.println("Unable to update grn "+e);
		}
		return flag;
	}

	public String addGRNDetails(int iRowNo, String sheet, String sText){
		boolean flag1, flag2;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sPrice = xls.get(iRowNo).get("Price");
		String sName = xls.get(iRowNo).get("Inspector Name");
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sReceivedAs = xls.get(iRowNo).get("Received As");
		String sRejected = xls.get(iRowNo).get("Rejected");
		String sInvoiceNo = RandomStringUtils.randomNumeric(9);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			remarksTxtField.clear();
			remarksTxtField.sendKeys(sText+sDate);
			if(grnInwardNo.getAttribute("readonly") == null){
				grnInwardNo.clear();
				grnInwardNo.sendKeys(sDate);
			}
			grnInspectorName.click();
			inspectorSearchText.sendKeys(sName);
			driver.findElement(By.xpath(".//em[text()='"+sName+"']")).click();
			if(!(sReceivedAgainst.contains("Others") || sReceivedAgainst.contains("Issues"))){
				invoiceNo.clear();
				invoiceNo.sendKeys(sInvoiceNo);
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
				invoiceDateField.click();
				Thread.sleep(Constant.Min_Sleep);
				invoiceDatePrevMnth.click();
				Thread.sleep(Constant.Min_Sleep);
				invoiceDate.click();
				Select selectReceivedThro = new Select(invoiceReceivedThro);
				selectReceivedThro.selectByVisibleText("Courier");
				gstin.clear();
				gstin.sendKeys(sDate+1);
				if(removeAttachment.isDisplayed()){
					removeAttachment.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				invoiceAttachment.click();
				Thread.sleep(Constant.Min_Sleep);
				Constant.attachFile();
//				Runtime.getRuntime().exec("E:\\ExpenseBillUpload.exe");//execute AutoIT to upload import file
				Thread.sleep(Constant.Min_Sleep);
				boolean flag = Constant.isElementPresent(By.xpath("//li[@id='mat_received']//a"));
				if(flag && matReceivedTab.isDisplayed()){
					matReceivedTab.click();
				}
				if(packingChargesTxtField.isEnabled()){
					packingChargesTxtField.clear();
					packingChargesTxtField.sendKeys(sPrice);
				}
				if(transportChargesTxtField.isEnabled()){
					transportChargesTxtField.clear();
					transportChargesTxtField.sendKeys(sPrice);
				}
				othersTxtField.sendKeys(Keys.CONTROL+"a");
				othersTxtField.sendKeys(Keys.DELETE);
				othersTxtField.sendKeys(sPrice);
				if(sReceivedAs.contains("Goods")){
					flag1 = validateGrandTotalValue_Goods();
				}else if(sReceivedAgainst.contains("Job In")){
					flag1 = validateGrandTotalValue_JobIn();
				}else{
					flag1 = validateGrandTotalValue();
				}
				flag2 = RoundOff();
				dutyPassedTxtField.sendKeys(Keys.CONTROL+"a");
				dutyPassedTxtField.sendKeys(Keys.DELETE);
				dutyPassedTxtField.sendKeys(sPrice);
			}else{
				flag1 = true; flag2 = true;
			}
			if(sRejected.contains("Yes")){
				rejectionRemarksTxtField.sendKeys("rejection remarks "+sDate);
			}
			if(!flag1 || !flag2){
				sInvoiceNo = null;
			}
		}catch(Exception e){
			System.err.println("Unable to add grn details "+e);
		}
		return sInvoiceNo;
	}

	public boolean updateGRNDetails(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false, flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIndentType = xls.get(iRowNo).get("Indent Type");
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sIssueNoCount = xls.get(iRowNo).get("Issue No Selection");
		String sReceivedAs = xls.get(iRowNo).get("Received As");
		String sPoMandatory = xls.get(iRowNo).get("PO Mandatory");
		String sReturned = xls.get(iRowNo).get("Returned");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Thread.sleep(Constant.Min_Sleep);
			if(!(sReceivedAgainst.contains("Issues") || sReceivedAgainst.contains("Delivery Challan") || sReceivedAgainst.contains("Others")
					|| sReceivedAgainst.contains("Sales Return") || sReceivedAgainst.contains("Job In"))){
				Select select = new Select(indentType);
				select.selectByVisibleText(sIndentType);
			}
			if(sReceivedAgainst.contains("Issues")){
				if(sIssueNo == null){
					issueNoDrpDwn.click();
					if(issueNoOptionDrpDwnList.size() > 1){
						issueNoOptionDrpDwnList.get(2).click();
						Thread.sleep(Constant.Max_Sleep);
						Thread.sleep(Constant.Max_Sleep);
					}
				}else{
					issueNoDrpDwn.click();
					issueNoSearch.sendKeys(sIssueNo);
					if(!driver.findElement(By.xpath(".//label[contains(text(),'"+sIssueNo+"')]")).isEnabled()){
						driver.findElement(By.xpath(".//label[contains(text(),'"+sIssueNo+"')]")).click();
						Thread.sleep(Constant.Max_Sleep);
					}
				}
			}
			if(sReceivedAgainst.contains("Job In") && sPoMandatory.equals("With Po")){
				purchaseOrderDropDwn.click();
				Thread.sleep(Constant.Min_Sleep);
				flag1 = addMaterial_ViewOa(iRowNo,sheet);
			}
			if(driver.getPageSource().contains("Net Rate")){
				deleteTax.click();
			}
			if(!(sReceivedAgainst.contains("Delivery Challan") || sReceivedAgainst.contains("Others") || sReceivedAgainst.contains("Issues") || sPoMandatory.equals("Without Po")
					|| sReceivedAgainst.contains("Job In"))){
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
				if(sReceivedAs.contains("Goods")){
					flag1 = addGoodsAlreadyReceived();
					flag2 = addCGSTTax_goods(0,iRowNo,sheet);
					flag3 = addSGSTTax_goods(0,iRowNo,sheet);
					flag4 = addIGSTTax_goods(0,iRowNo,sheet);
				}else{
					flag1 = addQtyDetails(0,iRowNo,sheet);
					flag2 = addCGSTTax(0,iRowNo,sheet);
					flag3 = addSGSTTax(0,iRowNo,sheet);
					flag4 = addIGSTTax(0,iRowNo,sheet);
					for (WebElement element : grnHSNCodeList) {
						if(element.getAttribute("value").isEmpty() || element.getAttribute("value").matches(".*[a-zA-Z]+.*")){
							element.sendKeys(Keys.CONTROL+"a");
							element.sendKeys(Keys.DELETE);
							element.sendKeys(sDate);
						}
					}
				}
				flag5 = addTax(iRowNo,sheet);
			}else{
				flag2 = true; flag3 = true; flag4 = true; flag5 = true;
			}
			if(sPoMandatory.equals("Without Po") && sReceivedAs.contains("Goods")){
				flag1 = addGoodsAlreadyReceived();
				flag2 = addCGSTTax_goods(0,iRowNo,sheet);
				flag3 = addSGSTTax_goods(0,iRowNo,sheet);
				flag4 = addIGSTTax_goods(0,iRowNo,sheet);
				flag5 = addTax(iRowNo,sheet);
			}
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			if(sReceivedAgainst.contains("Job Work") || sReceivedAgainst.contains("Delivery Challan") ||  sReceivedAgainst.contains("Issues")){
				if(!(sReceivedAs.contains("Goods") || sReturned.contains("No"))){
					flag1 = addReturnedQtyDetails(iRowNo, sheet,sIssueNoCount);
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			if(sReceivedAgainst.contains("Others") || sReceivedAgainst.contains("Issues") || sPoMandatory.contains("Without Po")){
				if(!sReceivedAs.contains("Goods")){
					js.executeScript("window.scrollBy(0,-5000)");
					matReceivedTab.click();
					Thread.sleep(Constant.Min_Sleep);
					flag1 = addStockMaterial(iRowNo, sheet);
					if(!sPoMandatory.contains("Without Po")){
						for (WebElement element : receivedQtyList) {
							element.clear();
							element.sendKeys("550");
						}
					}
				}
			}
			addGRNDetails(iRowNo,sheet, "update GRN");
			if(flag1 && flag2 && flag3 && flag4 && flag5){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to update GRN details "+e);
		}
		return flag;
	}

	public boolean addGoodsAlreadyReceived(){
		boolean flag = false;
		Double unitprice = null;Double dUnitPrice = null;
		String sPOPending = null, sTotalPrice = null;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String sPrice = RandomStringUtils.randomNumeric(3);
		String sDiscount = RandomStringUtils.randomNumeric(1);
		try{
			for (WebElement element : MaterialListPartyDcNo) {
				element.click();
			}
			for(int i=0;i<dcInvoiceQtyList.size();i++){
				if(Double.parseDouble(dcInvoiceQtyList.get(i).getAttribute("value")) >= 10){
					sPOPending = "10";
				}else{
					sPOPending = dcInvoiceQtyList.get(i).getAttribute("value");
				}
				dcInvoiceQtyList.get(i).sendKeys(Keys.CONTROL + "a");
				dcInvoiceQtyList.get(i).sendKeys(Keys.DELETE);
				dcInvoiceQtyList.get(i).sendKeys(sPOPending);
				if(Double.parseDouble(receivedQtyList.get(i).getAttribute("value")) >= 10){
					sPOPending = "10";
				}else{
					sPOPending = receivedQtyList.get(i).getAttribute("value");
				}
				receivedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
				receivedQtyList.get(i).sendKeys(Keys.DELETE);
				receivedQtyList.get(i).sendKeys(sPOPending);
				if(Double.parseDouble(acceptedQtyList.get(i).getAttribute("value")) >= 10){
					sPOPending = "10";
				}else{
					sPOPending = acceptedQtyList.get(i).getAttribute("value");
				}
				acceptedQtyList.get(i).sendKeys(Keys.CONTROL + "a");
				acceptedQtyList.get(i).sendKeys(Keys.DELETE);
				acceptedQtyList.get(i).sendKeys(sPOPending);
				if(grnHSNCodegoodsList.get(i).getAttribute("value").isEmpty() || grnHSNCodegoodsList.get(i).getAttribute("value").matches(".*[a-zA-Z]+.*")){
					grnHSNCodegoodsList.get(i).sendKeys(Keys.CONTROL+"a");
					grnHSNCodegoodsList.get(i).sendKeys(Keys.DELETE);
					grnHSNCodegoodsList.get(i).sendKeys(sDate);
				}
				priceConsolidate_goods.get(i).sendKeys(Keys.CONTROL + "a");
				priceConsolidate_goods.get(i).sendKeys(Keys.DELETE);
				priceConsolidate_goods.get(i).sendKeys(sPrice);
				discountConsolidate_goods.get(i).sendKeys(Keys.CONTROL + "a");
				discountConsolidate_goods.get(i).sendKeys(Keys.DELETE);
				discountConsolidate_goods.get(i).sendKeys(sDiscount);
				priceConsolidate_goods.get(i).click();
				sTotalPrice = totalPriceConsolidate_goods.get(i).getAttribute("value");
				Double totalPrice = Double.parseDouble(acceptedQtyList_Goods.get(i).getText()) * Double.parseDouble(sPrice);
				totalPrice = totalPrice - (totalPrice * Double.parseDouble(sDiscount) / 100);
				String sCalUnit = Double.toString(totalPrice);
				dUnitPrice = Math.round(totalPrice * 100.0) / 100.0;
				if(sCalUnit.contains(".")){
					String[] sListCalUnit = sCalUnit.split("\\.");
					if(sListCalUnit[1].length() > 2){
						if(sListCalUnit[1].substring(2, 3).equals("5")){
							String sUnit = sListCalUnit[0]+"."+sListCalUnit[1].substring(0, 2);
							unitprice = Double.parseDouble(sUnit);
						}else{
							unitprice = Math.round(totalPrice * 100.0) / 100.0;
						}
					}else{
						unitprice = Math.round(totalPrice * 100.0) / 100.0;
					}
				}else{
					unitprice = Math.round(totalPrice * 100.0) / 100.0;
				}
				if(Double.parseDouble(sTotalPrice) == unitprice || Double.parseDouble(sTotalPrice) == dUnitPrice){
					flag = true;
				}else{
					break;
				}
			}
			for (WebElement element : MaterialListPartyDcNo) {
				js.executeScript("window.scrollBy(0,-5000)");
				element.click();
			}
		}catch(Exception e){
			System.err.println("Failed to update material count with goods already received "+e);
		}
		return flag;
	}

	public boolean approveGRN(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sReceived = xls.get(iRowNo).get("Received");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addGRN(iRowNo, sheet, sIssueNo);
			int iGRNCount = grnList.size();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			if(sReceived.contains("No")){
				Thread.sleep(Constant.Max_Sleep);
				Thread.sleep(Constant.Max_Sleep);
				materialsReturnedTab.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(Constant.Min_Sleep);
			approveRejectBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(approveGRNBtn), "Failed to load GRN pdf popup");
			Thread.sleep(Constant.Min_Sleep);
			if(grnPDF.isDisplayed()){
				tRejectRemarks.sendKeys("Approve GRN automation"+sDate);
				approveGRNBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load GRN view page");
				Thread.sleep(Constant.Min_Sleep);
				okButton.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				closeBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("window.scrollBy(0,-5000)");
				backBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
				if(!(sReceivedAgainst.contains("Issues") || sReceivedAgainst.contains("Sales Return"))){
					btnFilter.click();
					Select selectReceivedView = new Select(receivedAgainstDropDwnViewtab);
					selectReceivedView.selectByValue(sReceivedAgainst);
					searchGRN.click();
					Constant.waitFor(ExpectedConditions.invisibilityOf(searchGRN), "Failed to load GRN view page");
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
				navigate.showAllEntries();
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']")));
				Thread.sleep(Constant.Min_Sleep);
				String sGRNNo = grnList.get(iGRNCount-1).getText();
				if((sGRNNo.contains("GRN") || sGRNNo.contains("IRN") || sGRNNo.contains("SR"))&&
						driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[9]")).getText().contains("Approved")){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("GRN approval failed "+e);
		}
		return flag;
	}

	public boolean deleteMatWOOa(int iRowNo, String sheet){
		boolean flag = false;
		String sGRNNo = null, sPONO = null;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			sGRNNo = grnList.get(iGRNCount-1).getText();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				materialDCQtyWOOa.get(0).sendKeys(Keys.CONTROL + "a");
				materialDCQtyWOOa.get(0).sendKeys(Keys.DELETE);
				materialRecQtyWOOa.get(0).sendKeys(Keys.CONTROL + "a");
				materialRecQtyWOOa.get(0).sendKeys(Keys.DELETE);
				materialAccepQtyWOOa.get(0).sendKeys(Keys.CONTROL + "a");
				materialAccepQtyWOOa.get(0).sendKeys(Keys.DELETE);
				for (WebElement element : oaNoDropDwnMatGridList) {
 					sPONO = element.getText();
 					if(sPONO.contains("Select OA")){
 						sPONO = null;
 					}else{
 						break;
 					}
 				}
				if(sPONO != null){
					int iCount = sPONO.length();
					for(int j=1;j<iCount;j++){
						iCount = sPONO.length();
						if(iCount < 13){
							sPONO = sPONO.substring(0, 7)+String.format("%01d", 0)+sPONO.substring(7,iCount);
						}else{
							break;
						}
					}
				}
					flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, sPONO);
			}
		}catch(Exception e){
			System.err.println("Failed to delete material without OA "+e);
		}
		return flag;
	}

	public boolean unselectOA(int iRowNo, String sheet){
		boolean flag = false;
		String sGRNNo = null;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			sGRNNo = grnList.get(iGRNCount-1).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				for(int i=0;i<selectOADrpDwn.size();i++){
					selectOADrpDwn.get(i).click();
					driver.findElement(By.xpath("//*[@id='materialtable']/tbody/tr["+(i+1)+"]/td[1]/div[1]/div[1]/ul[1]/li[1]")).click();
				}
				flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, null);
			}
		}catch(Exception e){
			System.err.println("Failed to delete material without OA "+e);
		}
		return flag;
	}

	public boolean updateGRNParty(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sGRNNo = null;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			sGRNNo = grnList.get(iGRNCount-1).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				superEditIconParty.click();
				selectParty.click();
				searchParty.sendKeys(sParty);
				driver.findElement(By.xpath(".//li[text()='All']/following::li/em[text()='"+sParty.trim()+"']")).click();
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
				flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, null);
			}
		}catch(Exception e){
			System.err.println("Failed to update party of GRN "+e);
		}
		return flag;
	}

	public boolean selectOANoGRN(int iRowNo, String sheet){
		boolean flag = false;
		String sGRNNo = null, sPOno = null;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			int iGRNCount = grnList.size();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			sGRNNo = grnList.get(iGRNCount-1).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				for(int i=0;i<selectOADrpDwn.size();i++){
					selectOADrpDwn.get(i).click();
					sPOno = driver.findElement(By.xpath("//*[@id='materialtable']/tbody/tr["+(i+1)+"]/td[1]/div[1]/div[1]/ul[1]/li[2]")).getText();
					driver.findElement(By.xpath("//*[@id='materialtable']/tbody/tr["+(i+1)+"]/td[1]/div[1]/div[1]/ul[1]/li[2]")).click();
				}
				int iCount = sPOno.length();
				for(int i=1;i<iCount;i++){
					iCount = sPOno.length();
					if(iCount < 13){
						sPOno = sPOno.substring(0, 7)+String.format("%01d", 0)+sPOno.substring(7,iCount);
					}else{
						break;
					}
				}
				flag = validateUpdateGRN(iRowNo, sheet, iGRNCount, sPOno);
			}
		}catch(Exception e){
			System.err.println("Failed to update OA no in GRN "+e);
		}
		return flag;
	}

	public boolean validateAmendGRN(int iRowNo, String sheet, int iGRNCount, String sPoNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sPoMandatory = xls.get(iRowNo).get("PO Mandatory");
		String sCreateOA = xls.get(iRowNo).get("Create OA");
		String sParty = xls.get(iRowNo).get("Party");
		String sGrantTotal = null, sInvoiceDate = null;
		WebElement ele;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String[] sPartySplit = null;
		try{
			if(!sReceivedAgainst.contains("Issues")){
				sParty = selectParty.getText();
				sPartySplit = sParty.split("\\(");
			}
			sInvoiceDate = invoiceDateField.getAttribute("value");
			sGrantTotal = grnGrandTotal.getAttribute("value");
			UpdateBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(sReceivedAgainst.contains("Job In") && sPoMandatory.contains("Without Po") && sCreateOA.contains("No")){
				Constant.waitFor(ExpectedConditions.visibilityOf(continueBtn), "Failed to load oa link warning popup");
				continueBtn.click();
			}
			if(sReceivedAgainst.contains("Job In") && sPoMandatory.contains("Without Po") && sCreateOA.contains("Yes")){
				Constant.waitFor(ExpectedConditions.visibilityOf(continueBtn), "Failed to load oa link warning popup");
				if(addOAMaterial(iRowNo,sheet)){
					continueBtn.click();
				}
			}
			Thread.sleep(Constant.Medium_Sleep);
			if(Constant.isAlertPresents()){
				driver.switchTo().alert().accept();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load success popup");
			Constant.waitForPageLoad();
			if(Constant.isElementPresent(By.xpath(".//h2/span[text()='Saved Successfully']/following::p/b[2]"))){
				sPoNo = driver.findElement(By.xpath(".//h2/span[text()='Saved Successfully']/following::p/b[2]")).getText();
			}
			if(sReceivedAgainst.contains("Job In") && sCreateOA.contains("Yes")){
				int iCount = sPoNo.length();
				for(int i=1;i<iCount;i++){
					iCount = sPoNo.length();
					if(iCount < 13){
						sPoNo = sPoNo.substring(0, 7)+String.format("%01d", 0)+sPoNo.substring(7,iCount);
					}else{
						break;
					}
				}
			}
			if(sPoNo == null || sPoNo.contains("GRN")){
				sPoNo = "-NA-";
			}
			okButton.click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			jse.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			backBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			if(!(sReceivedAgainst.contains("Issues") || sReceivedAgainst.contains("Sales Return"))){
				btnFilter.click();
				Select selectReceivedView = new Select(receivedAgainstDropDwnViewtab);
				selectReceivedView.selectByValue(sReceivedAgainst);
				searchGRN.click();
				Constant.waitFor(ExpectedConditions.invisibilityOf(searchGRN), "Failed to load GRN view page");
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			navigate.showAllEntries();
			int grnActCount = grnList.size();
			jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']")));
			Thread.sleep(Constant.Min_Sleep);
			if(!(sReceivedAgainst.contains("Others") || sReceivedAgainst.contains("Issues"))){
				ele = driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']/following::td[text()='"+sCurrentDate+"']/following::td[3]/span[contains(text(),'"+sPoNo+"')]/following::td[2][contains(text(),'"+sPartySplit[0].trim()+"')]/following::td[2][text()='"+sInvoiceDate+"']/following::td[text()='"+sGrantTotal+"']/following::td[3]/a[text()='Approved']"));
			}else{
				ele = driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']/following::td[12]/a[text()='Approved']"));
			}
			if(grnActCount == iGRNCount && ele.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to validate grn amend "+e);
		}
		return flag;
	}

	public boolean validateUpdateGRN(int iRowNo, String sheet, int iGRNCount, String sPoNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sPoMandatory = xls.get(iRowNo).get("PO Mandatory");
		String sCreateOA = xls.get(iRowNo).get("Create OA");
		String sParty = xls.get(iRowNo).get("Party");
		String sReceived = xls.get(iRowNo).get("Received");
		String sGrantTotal = null, sInvoiceDate = null;
		WebElement ele;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String[] sPartySplit = null;
		try{
			if(!sReceivedAgainst.contains("Issues")){
				sParty = selectParty.getText();
				sPartySplit = sParty.split("\\(");
			}
			sInvoiceDate = invoiceDateField.getAttribute("value");
			sGrantTotal = grnGrandTotal.getAttribute("value");
			UpdateBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(sReceivedAgainst.contains("Job In") && sPoMandatory.contains("Without Po") && sCreateOA.contains("No")){
				Constant.waitFor(ExpectedConditions.visibilityOf(continueBtn), "Failed to load oa link warning popup");
				continueBtn.click();
			}
			if(sReceivedAgainst.contains("Job In") && sPoMandatory.contains("Without Po") && sCreateOA.contains("Yes")){
				Constant.waitFor(ExpectedConditions.visibilityOf(continueBtn), "Failed to load oa link warning popup");
				if(addOAMaterial(iRowNo,sheet)){
					continueBtn.click();
				}
			}
			Thread.sleep(Constant.Medium_Sleep);
			if(Constant.isAlertPresents()){
				driver.switchTo().alert().accept();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load success popup");
			Constant.waitForPageLoad();
			if(Constant.isElementPresent(By.xpath(".//h2/span[text()='Saved Successfully']/following::p/b[2]"))){
				sPoNo = driver.findElement(By.xpath(".//h2/span[text()='Saved Successfully']/following::p/b[2]")).getText();
			}
			if(sReceivedAgainst.contains("Job In") && sCreateOA.contains("Yes")){
				int iCount = sPoNo.length();
				for(int i=1;i<iCount;i++){
					iCount = sPoNo.length();
					if(iCount < 13){
						sPoNo = sPoNo.substring(0, 7)+String.format("%01d", 0)+sPoNo.substring(7,iCount);
					}else{
						break;
					}
				}
			}
			if(sPoNo == null || sPoNo.contains("GRN")){
				sPoNo = "-NA-";
			}
			okButton.click();
			if(sReceived.contains("No")){
				Thread.sleep(Constant.Max_Sleep);
				Thread.sleep(Constant.Max_Sleep);
				materialsReturnedTab.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			jse.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			backBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			if(!(sReceivedAgainst.contains("Issues") || sReceivedAgainst.contains("Sales Return"))){
				btnFilter.click();
				Select selectReceivedView = new Select(receivedAgainstDropDwnViewtab);
				selectReceivedView.selectByValue(sReceivedAgainst);
				searchGRN.click();
				Constant.waitFor(ExpectedConditions.invisibilityOf(searchGRN), "Failed to load GRN view page");
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			navigate.showAllEntries();
			jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']")));
			Thread.sleep(Constant.Min_Sleep);
			if(!(sReceivedAgainst.contains("Others") || sReceivedAgainst.contains("Issues"))){
				ele = driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']/following::td[text()='"+sCurrentDate+"']/following::td[3]/span[contains(text(),'"+sPoNo+"')]/following::td[2][contains(text(),'"+sPartySplit[0].trim()+"')]/following::td[2][text()='"+sInvoiceDate+"']/following::td[text()='"+sGrantTotal+"']/following::td[3]/a[text()='Draft']"));
			}else if(sReceivedAgainst.contains("Issues")){
				ele = driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']/following::td[4]/span[contains(text(),'"+sPoNo+"')]/following::td[8]/a[text()='Draft']"));
			}else{
				ele = driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']/following::td[12]/a[text()='Draft']"));
			}
			if(ele.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to validate grn update "+e);
		}
		return flag;
	}

	public boolean verifyRemarks(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false;
		try{
			approveGRN(iRowNo, sheet, sIssueNo);
			int iGRNCount = grnList.size();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[13]/span/i")).click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(remarksLink), "Failed to load GRN pdf popup");
			Thread.sleep(Constant.Min_Sleep);
			if(grnPDF.isDisplayed()){
				if(remarksCount.getText().contains("2")){
					remarksLink.click();
					for (WebElement availableRemark : availableRemarks) {
						if(availableRemark.getText().contains("Approve GRN automation"+sDate)){
							flag = true;
							break;
						}
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load GRN view page");
					Thread.sleep(Constant.Min_Sleep);
					okButton.sendKeys(Keys.ENTER);
					Thread.sleep(Constant.Min_Sleep);
				}
				closeBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to check remarks "+e);
		}
		return flag;
	}

	public boolean validateDraftRejectGRN(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sReceived = xls.get(iRowNo).get("Received");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addGRN(iRowNo, sheet, null);
			int iGRNCount = grnList.size();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			if(sReceived.contains("No")){
				Thread.sleep(Constant.Max_Sleep);
				Thread.sleep(Constant.Max_Sleep);
				materialsReturnedTab.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(Constant.Min_Sleep);
			approveRejectBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(rejectGRNBtn), "Failed to load pdf popup");
			Thread.sleep(Constant.Min_Sleep);
			if(grnPDF.isDisplayed()){
				tRejectRemarks.sendKeys("Draft rejected automation"+sDate);
				rejectGRNBtn.click();
//				Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load GRN view page");
//				Thread.sleep(Constant.Min_Sleep);
//				okButton.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load GRN view page");
				Thread.sleep(Constant.Min_Sleep);
				okButton.sendKeys(Keys.ENTER);
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
				if(!(sReceivedAgainst.contains("Issues") || sReceivedAgainst.contains("Sales Return"))){
					btnFilter.click();
					Select selectReceivedView = new Select(receivedAgainstDropDwnViewtab);
					selectReceivedView.selectByValue(sReceivedAgainst);
					searchGRN.click();
					Constant.waitFor(ExpectedConditions.invisibilityOf(searchGRN), "Failed to load GRN view page");
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
				navigate.showAllEntries();
				int iActGRNCount = grnList.size();
				if(iGRNCount > iActGRNCount){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("GRN reject failed "+e);
		}
		return flag;
	}

	public boolean vaildateRejectApprovedGRN(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false;
		try{
			approveGRN(iRowNo,sheet,sIssueNo);
			flag = rejectApprovedGRN(iRowNo,sheet);
		}catch(Exception e){
			System.err.println("Failed to reject approved grn "+e);
		}
		return flag;
	}

	public boolean rejectApprovedGRN(int iRowNo, String sheet){
		boolean flag =false;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sReceived = xls.get(iRowNo).get("Received");
		try{
			int iGRNCount = grnList.size();
			js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			if(sReceived.contains("No")){
				Thread.sleep(Constant.Max_Sleep);
				Thread.sleep(Constant.Max_Sleep);
				materialsReturnedTab.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(Constant.Min_Sleep);
			approveRejectBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(rejectGRNBtn), "Failed to load GRN view page");
			Thread.sleep(Constant.Min_Sleep);
 			if(grnPDF.isDisplayed()){
 				tRejectRemarks.sendKeys("Reject approved GRN "+sDate);
				rejectGRNBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load GRN view page");
				Thread.sleep(Constant.Min_Sleep);
				okButton.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				closeBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("window.scrollBy(0,-5000)");
				backBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
				if(!(sReceivedAgainst.contains("Issues") || sReceivedAgainst.contains("Sales Return"))){
					btnFilter.click();
					Select selectReceivedView = new Select(receivedAgainstDropDwnViewtab);
					selectReceivedView.selectByValue(sReceivedAgainst);
					searchGRN.click();
					Constant.waitFor(ExpectedConditions.invisibilityOf(searchGRN), "Failed to load GRN view page");
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
				navigate.showAllEntries();
				Thread.sleep(Constant.Min_Sleep);
				js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']")));
				if(driver.findElement(By.xpath(".//s[text()='"+sGRNNo+"']")).isDisplayed() &&
						driver.findElement(By.xpath("//s[contains(text(),'"+sGRNNo+"')]/following::td[9]")).getText().contains("Rejected")){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Reject approved grn failed "+e);
		}
		return flag;
	}

	public boolean validateRejectWarning(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRN();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			btnFilter.click();
			Select selectReceivedView = new Select(receivedAgainstDropDwnViewtab);
			selectReceivedView.selectByValue(sReceivedAgainst);
			searchGRN.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(searchGRN), "Failed to load GRN view page");
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			int iGRNCount = grnList.size();
			js.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(Constant.Min_Sleep);
			approveRejectBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(rejectGRNBtn), "Failed to load GRN pdf popup");
			Thread.sleep(Constant.Min_Sleep);
			if(grnPDF.isDisplayed()){
				tRejectRemarks.sendKeys("Reject approved GRN "+sDate);
				rejectGRNBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load GRN view page");
				if(rejectWarningpopup.isDisplayed()){
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load GRN view page");
					Thread.sleep(Constant.Min_Sleep);
					okBtn.sendKeys(Keys.ENTER);
					Thread.sleep(Constant.Min_Sleep);
					closeBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("window.scrollBy(0,-5000)");
					backBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
					if(!(sReceivedAgainst.contains("Issues") || sReceivedAgainst.contains("Sales Return"))){
						btnFilter.click();
						selectReceivedView.selectByValue(sReceivedAgainst);
						searchGRN.click();
						Constant.waitFor(ExpectedConditions.invisibilityOf(searchGRN), "Failed to load GRN view page");
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
					navigate.showAllEntries();
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']")));
					if((sGRNNo.contains("GRN") || sGRNNo.contains("IRN") || sGRNNo.contains("SR"))&&
							driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[9]")).getText().contains("Approved")){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate unable to reject warning"+e);
		}
		return flag;
	}

	public boolean validateOANoNotAvail(int iRowNo, String sheet, String sOANo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sParty = xls.get(iRowNo).get("Party");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRN();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			addGRNBtn.click();
			Constant.waitForPageLoad();
			Select selectReceived = new Select(receivedAgainstDropDwn);
			selectReceived.selectByValue(sReceivedAgainst);
			selectParty.click();
			searchParty.sendKeys(sParty);
			driver.findElement(By.xpath(".//li[text()='All']/following::li/em[text()='"+sParty.trim()+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			purchaseOrderDropDwn.click();
			boolean flag1 = Constant.isElementPresent(By.xpath(".//input[@placeholder='Search']"));
			if(flag1){
				searchTxtPurchaseDrpDwn.sendKeys(sOANo);
				Thread.sleep(Constant.Min_Sleep);
			}
			if(!Constant.isElementPresent(By.xpath("//label[contains(text(),'"+sOANo+"')]"))){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to validate unavailablity of OA number "+e);
		}
		return flag;
	}

	public boolean amendGRNDC_addingDc(int iRowNo, String sheet, String sIssueNo){
		boolean flag = false, flag1;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueNoCount = xls.get(iRowNo).get("Issue No Selection");
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String sGrantTotal = null, sInvoiceDate = null, sPoNo = null;
		WebElement ele;
		try{
			approveGRN(iRowNo,sheet,sIssueNo);
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				purchaseOrderDropDwn.click();
				List<WebElement> list1 = driver.findElements(By.xpath(".//*[@id='po_div']/div/ul/li"));
				for(int i=0;i<list1.size();i++){
					if(list1.size() > 3){
						purchaseOrder.get(i+3).click();
						Thread.sleep(Constant.Medium_Sleep);
						sPoNo = purchaseOrder.get(i+3).getText().trim();
						break;
					}
				}
				flag1 = addReturnedQtyDetails(iRowNo, sheet, sIssueNoCount);
				if(flag1){
					sInvoiceDate = invoiceDateField.getAttribute("value");
					sGrantTotal = grnGrandTotal.getAttribute("value");
					UpdateBtn.click();
					Thread.sleep(Constant.Medium_Sleep);
					if(Constant.isAlertPresents()){
						driver.switchTo().alert().accept();
						Thread.sleep(Constant.Min_Sleep);
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okButton), "Failed to load success popup");
					Thread.sleep(Constant.Min_Sleep);
					okButton.click();
					Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
					jse.executeScript("window.scrollBy(0,-5000)");
					Thread.sleep(Constant.Min_Sleep);
					backBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
					navigate.showAllEntries();
					int grnActCount = grnList.size();
					jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']")));
					Thread.sleep(Constant.Min_Sleep);
					ele = driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+grnActCount+"]/td[text()='"+grnActCount+".']/following::td[text()='"+sCurrentDate+"']/following::td[3]/span[contains(text(),'"+sPoNo+"')]/following::td[4][text()='"+sInvoiceDate+"']/following::td[text()='"+sGrantTotal+"']/following::td[3]/a[text()='Approved']"));
					if(grnActCount == iGRNCount && ele.isDisplayed()){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to amend GRN DC by adding dc "+e);
		}
		return flag;
	}

	public boolean MatUsageBtnNotDisplayed(){
		boolean flag = false;
		try{
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				if(!materialUsageBtn.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Material usage button not available validation failed "+e);
		}
		return flag;
	}



	public boolean validateMaterialIssueReport(int iRowNo, String sheet,String sGRNNo){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(materialReportViewReportBtn), "Failed to load report");
			materialNameDropDwn.click();
			searchMaterialName.sendKeys(sMaterial);
			driver.findElement(By.xpath(".//em[text()='"+sMaterial+"']")).click();
			materialReportViewReportBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			for (WebElement element : receiptNoColumn) {
				js.executeScript("arguments[0].scrollIntoView(true);",element);
				if(element.getText().contains(sGRNNo)){
					flag = true;
					break;
				}
			}
		}catch (Exception e){
			System.err.println("Failed to validate Material issue receipt report "+e);
		}
		return flag;
	}


	/**
	 * to add new issue
	 * @param iRowNo specifies the row no in the test data sheet
	 * @return flag true if the addition of issue is success
	 * @throws Exception
	 */
	public boolean addIssue(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sProject = xls.get(iRowNo).get("Project");
		String sIssueFor = xls.get(iRowNo).get("Issue For");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sQty = xls.get(iRowNo).get("Quantity");
		String[] sMaterialName;
		WebElement ele;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			int iRows = preparedOn.size();
			js.executeScript("arguments[0].scrollIntoView(true);", addInvoiceIcon);
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				Thread.sleep(Constant.Min_Sleep);
				projectDropDwn.click();
				searchInvoiceProject.sendKeys(sProject);
				driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
				issueForDropdwn.click();
				issueForDropdwn_Search.sendKeys(sIssueFor);
				driver.findElement(By.xpath(".//li[text()='All']/following::li[1]/em[text()='"+sIssueFor+"']")).click();
				issuedOnDateDropDwn.click();
				dateSelect.click();
				timeHrSelect.click();
				timeSelect.click();
				issueToDropdwn.click();
				issueToDropdwn_search.sendKeys(sIssueTo);
				driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
				String sDate = issuedOnDateDropDwn.getAttribute("value");
				if(sDate.length() == 20){
					sDate = sDate.substring(0, 4)+"0"+sDate.substring(4, 20);
				}
				boolean flag1 = addIssueMaterial(iRowNo,sheet);
				if(sQty == null){
					sQty = "1";
				}
				if(flag1){
					issueRemarksTxt.sendKeys("Issue add"+sDate);
					issueSaveBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					boolean flag2 = Constant.isElementPresent(By.id("btn-sa-confirm"));
					if(flag2){
						okBtn.click();
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
					navigate.showAllEntries();
					int iActualrows = preparedOn.size();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a")));
					String sIssueNo = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a")).getText();
					Actions actions = new Actions(driver);
					actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a"))).perform();
					actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/span[2]"))).click().perform();
					Thread.sleep(Constant.Min_Sleep);
					String sActIssueNo = driver.findElement(By.xpath(".//td[contains(text(),'Issue')]/following::td[1][contains(text(),'I')]")).getText();
					String sActDate = issuedOnDateDropDwn.getAttribute("value");
					js.executeScript("window.scrollBy(0,-5000)");
					Thread.sleep(Constant.Min_Sleep);
					backButton.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
					navigate.showAllEntries();
					int count = Constant.countRegexInString(",", sMaterial) + 1;
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]")));
					sMaterialName = sMaterial.split("\\s+");
					if(count > 1){
						sMaterialName[0] = "Multiple";
						ele = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]/following::td[contains(text(),'"+sDate+"')]/following::td[contains(text(),'"+sIssueTo+"')]/following::td[contains(text(),'"+sIssueFor+"')]/following::td[contains(text(),'"+sProject+"')]/following::td/i[contains(text(),'"+sMaterialName[0].trim()+"')]/following::td[1][contains(text(),'"+count+"')]"));
					}else{
						ele = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]/following::td[contains(text(),'"+sDate+"')]/following::td[contains(text(),'"+sIssueTo+"')]/following::td[contains(text(),'"+sIssueFor+"')]/following::td[contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sMaterialName[0].trim()+"')]/following::td[1][contains(text(),'"+sQty+"')]"));
					}
					if(ele.isDisplayed() && sIssueNo.equals(sActIssueNo) && sActDate.contains(sDate) && iActualrows > iRows){
						flag = true;
					}
				}
			}
//			}
		}catch(Exception e){
			System.err.println("Issue addition is not successful"+e);
		}
		return flag;
	}

	public boolean addIssue_PastDate(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sProject = xls.get(iRowNo).get("Project");
		String sIssueFor = xls.get(iRowNo).get("Issue For");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sQty = xls.get(iRowNo).get("Quantity");
		String[] sMaterialName;
		WebElement ele;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			int iRows = preparedOn.size();
			js.executeScript("arguments[0].scrollIntoView(true);", addInvoiceIcon);
			js.executeScript("window.scrollBy(0,-5000)");
			Thread.sleep(Constant.Min_Sleep);
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				Thread.sleep(Constant.Min_Sleep);
				issueForDropdwn.click();
				issueForDropdwn_Search.sendKeys(sIssueFor);
				driver.findElement(By.xpath(".//li[text()='All']/following::li[1]/em[text()='"+sIssueFor+"']")).click();
				issueToDropdwn.click();
				issueToDropdwn_search.sendKeys(sIssueTo);
				driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
				issuedOnDateDropDwn.click();
				updateIssueDate.click();
				timeHrSelect.click();
				timeSelect.click();
				String sDate = issuedOnDateDropDwn.getAttribute("value");
				if(sDate.length() == 20){
					sDate = sDate.substring(0, 4)+"0"+sDate.substring(4, 20);
				}
				boolean flag1 = addIssueMaterial(iRowNo,sheet);
				if(sQty == null){
					sQty = "1";
				}
				if(flag1){
					issueRemarksTxt.sendKeys("Issue add"+sDate);
					issueSaveBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					boolean flag2 = Constant.isElementPresent(By.id("btn-sa-confirm"));
					if(flag2){
						okBtn.click();
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
					navigate.showAllEntries();
					int iActualrows = preparedOn.size();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a")));
					String sIssueNo = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a")).getText();
					Actions actions = new Actions(driver);
					actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a"))).perform();
					actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/span[2]"))).click().perform();
					Thread.sleep(Constant.Min_Sleep);
					String sActIssueNo = driver.findElement(By.xpath(".//td[contains(text(),'Issue')]/following::td[1][contains(text(),'I')]")).getText();
					String sActDate = issuedOnDateDropDwn.getAttribute("value");
					js.executeScript("window.scrollBy(0,-5000)");
					Thread.sleep(Constant.Min_Sleep);
					backButton.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
					navigate.showAllEntries();
					int count = Constant.countRegexInString(",", sMaterial) + 1;
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]")));
					sMaterialName = sMaterial.split("\\s+");
					if(count > 1){
						sMaterialName[0] = "Multiple";
						ele = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]/following::td[contains(text(),'"+sDate+"')]/following::td[contains(text(),'"+sIssueTo+"')]/following::td[contains(text(),'"+sIssueFor+"')]/following::td[contains(text(),'"+sProject+"')]/following::td/i[contains(text(),'"+sMaterialName[0].trim()+"')]/following::td[1][contains(text(),'"+count+"')]"));
					}else{
						ele = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]/following::td[contains(text(),'"+sDate+"')]/following::td[contains(text(),'"+sIssueTo+"')]/following::td[contains(text(),'"+sIssueFor+"')]/following::td[contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sMaterialName[0].trim()+"')]/following::td[1][contains(text(),'"+sQty+"')]"));
					}
					if(ele.isDisplayed() && sIssueNo.equals(sActIssueNo) && sActDate.contains(sDate) && iActualrows > iRows){
						flag = true;
					}
				}
			}
//			}
		}catch(Exception e){
			System.err.println("Issue addition with past date is not successful"+e);
		}
		return flag;
	}

	public boolean qtyGreaterStockBOMWarn(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				Thread.sleep(Constant.Min_Sleep);
				materialReqTxt.click();
				Thread.sleep(Constant.Min_Sleep);
				materialReqTxt.sendKeys(sMaterial);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//a[contains(text(),'"+sMaterial+"')]")).click();
				Thread.sleep(Constant.Max_Sleep);
				Constant.waitForPageLoad();
				Thread.sleep(Constant.Max_Sleep);
				materialReqQtyTxt.sendKeys(Keys.CONTROL+"a");
				materialReqQtyTxt.sendKeys(Keys.DELETE);
				materialReqQtyTxt.sendKeys("1");
				Thread.sleep(Constant.Min_Sleep);
				bomBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(bomPopUp.isDisplayed()){
					for(int i=0;i<maxIssueBOMPopupList.size();i++){
						qtyColBOMPopup.get(i).sendKeys(Keys.CONTROL+"a");
						qtyColBOMPopup.get(i).sendKeys(Keys.DELETE);
						qtyColBOMPopup.get(i).sendKeys(Double.toString(Double.parseDouble(maxIssueBOMPopupList.get(i).getText())+1));
					}
					addBOM.click();
					Thread.sleep(Constant.Min_Sleep);
					if(warnQtyGreaterStock.isDisplayed()){
						okBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						if(bomPopUpErrorBorder.get(0).isDisplayed()){
							flag = true;
							cancelBnt_BOM.click();
							Thread.sleep(Constant.Min_Sleep);
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate warning popup "+e);
		}
		return flag;
	}

	public boolean childMatAddedWOParentStock(String sMaterial){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				Thread.sleep(Constant.Min_Sleep);
				materialReqTxt.click();
				Thread.sleep(Constant.Min_Sleep);
				materialReqTxt.sendKeys(sMaterial);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//a[contains(text(),'"+sMaterial+"')]")).click();
				Thread.sleep(Constant.Max_Sleep);
				Constant.waitForPageLoad();
				Thread.sleep(Constant.Max_Sleep);
				materialReqQtyTxt.sendKeys(Keys.CONTROL+"a");
				materialReqQtyTxt.sendKeys(Keys.DELETE);
				materialReqQtyTxt.sendKeys("1");
				Thread.sleep(Constant.Min_Sleep);
				if(materialAvailQty.getText().substring(10).contains("0.00")){
					bomBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					for(int i=0;i<maxIssueBOMPopupList.size();i++){
						String a = maxIssueBOMPopupList.get(i).getText();
						if(Double.parseDouble(maxIssueBOMPopupList.get(i).getText()) <= 0.00){
							if(materialListBOMPopup.get(i).getText().contains(materialListTxtBOMPopup.get(i).getText())){
								bomPopDeleteIcon.get(i).click();
								Thread.sleep(Constant.Min_Sleep);
								driver.switchTo().alert().accept();
								Thread.sleep(Constant.Min_Sleep);
							}
						}
					}
					for(int i=0;i<maxIssueBOMPopupList.size();i++){
						qtyColBOMPopup.get(i).sendKeys(Keys.CONTROL+"a");
						qtyColBOMPopup.get(i).sendKeys(Keys.DELETE);
						qtyColBOMPopup.get(i).sendKeys("1");
					}
					addBOM.click();
					Thread.sleep(Constant.Min_Sleep);
					if(!warnQtyGreaterStock.isDisplayed()){
						okBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate warning popup "+e);
		}
		return flag;
	}

	public boolean addIssueMaterial(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sRemark = xls.get(iRowNo).get("With Remark");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		String sQty = xls.get(iRowNo).get("Quantity");
		String sFaulty = xls.get(iRowNo).get("Faulty");
		try{
			String[] sMaterialList = sMaterial.split(",");
			for(int i=0;i<sMaterialList.length;i++){
				materialReqTxt.click();
				Thread.sleep(Constant.Min_Sleep);
				materialReqTxt.sendKeys(sMaterialList[i].trim());
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//a[contains(text(),'"+sMaterialList[i].trim()+"')]")).click();
				Thread.sleep(Constant.Max_Sleep);
				if(!(sFaulty == null)){
					if(sFaulty.equals("Yes")){
						faultyChkBx.click();
					}else if(sFaulty.contains("Yes and No")){
						if(i % 2 == 0){
							faultyChkBx.click();
						}
					}
					Thread.sleep(Constant.Max_Sleep);
				}
				if(sAltUnit.contains("Yes")){
					altUnitDrpDwn.click();
					altUnitOption.click();
				}
				materialReqQtyTxt.sendKeys(Keys.CONTROL+"a");
				materialReqQtyTxt.sendKeys(Keys.DELETE);
				if(sQty == null){
					materialReqQtyTxt.sendKeys("1");
				}else{
					materialReqQtyTxt.sendKeys(sQty);
				}
				sQty = materialReqQtyTxt.getAttribute("value");
				if(sRemark.contains("Yes")){
					addRemarks.click();
					Thread.sleep(Constant.Min_Sleep);
					issueMaterialRemarks.sendKeys("Issue material remarks "+sDate);
				}
				materialAdd.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean flag2 = Constant.isElementPresent(By.id("btn-sa-confirm"));
				if(flag2){
					okBtn.click();
				}
			}
			for(int i=0;i<matListGridMatCheck_Issue.size()-1;i++){
				if(matListGridMatCheck_Issue.get(i).getText().contains(sMaterialList[i].trim())
						&& (matListGridQtyCheck_Issue.get(i).getAttribute("value").contains(sQty) ||
								matListGridQtyCheck_Issue.get(i).getAttribute("value").contains("1.00"))){
					flag = true;
				}else{
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add material to issue "+e);
		}
		return flag;
	}

	public boolean validateMatAlreadyExistsWArning(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				String[] sMaterialList = sMaterial.split(",");
				materialReqTxt.sendKeys(sMaterialList[0].trim());
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//a[contains(text(),'"+sMaterialList[0].trim()+"')]")).click();
				Thread.sleep(Constant.Max_Sleep);
				Thread.sleep(Constant.Medium_Sleep);
				materialReqQtyTxt.sendKeys(Keys.CONTROL+"a");
				materialReqQtyTxt.sendKeys(Keys.DELETE);
				materialReqQtyTxt.sendKeys("1");
				materialAdd.click();
				Thread.sleep(Constant.Min_Sleep);
				for (String element : sMaterialList) {
					materialReqTxt.click();
					Thread.sleep(Constant.Min_Sleep);
					materialReqTxt.sendKeys(element.trim());
					Thread.sleep(Constant.Min_Sleep);
					driver.findElement(By.xpath(".//a[contains(text(),'"+element.trim()+"')]")).click();
					Thread.sleep(Constant.Max_Sleep);
					Thread.sleep(Constant.Medium_Sleep);
					materialReqQtyTxt.sendKeys(Keys.CONTROL+"a");
					materialReqQtyTxt.sendKeys(Keys.DELETE);
					materialReqQtyTxt.sendKeys("1");
					materialAdd.click();
					Thread.sleep(Constant.Min_Sleep);
					if(itemAlreadyExists.isDisplayed()){
						flag = true;
						okBtn.click();
						Thread.sleep(Constant.Min_Sleep);
					}else{
						flag = false;
						break;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate material already exists warning "+e);
		}
		return flag;
	}

	/**
	 * to update the issue
	 * @param iRowNo specifies test data sheet row no.
	 * @return true if update of the issue is success
	 * @throws Exception
	 */
	public boolean updateIssue(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueFor = xls.get(iRowNo).get("Issue For");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sProject = xls.get(iRowNo).get("Project");
		String sRemark = xls.get(iRowNo).get("Remark");
		int iRow = 0; WebElement ele;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addIssue(iRowNo, sheet);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			iRow = preparedOn.size();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")));
			String sIssueNo = driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/span[2]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sIssueNo+"')]")).isDisplayed()){
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<issueSno.size()-1;i++){
					actions.moveToElement(issueSno.get(i)).perform();
					Thread.sleep(Constant.Min_Sleep);
					actions.moveToElement(deleteMaterialBtn.get(i)).click().perform();
					Thread.sleep(Constant.Min_Sleep);
					yesButton.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				projectDropDwn.click();
				searchInvoiceProject.sendKeys(sProject);
				driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
				issueForDropdwn.click();
				issueForDropdwn_Search.sendKeys(sIssueFor);
				driver.findElement(By.xpath(".//li[text()='All']/following::li[1]/em[text()='"+sIssueFor+"']")).click();
				issuedOnDateDropDwn.click();
				dateSelect.click();
				timeHrSelect.click();
				timeSelect.click();
				issueToDropdwn.click();
				issueToDropdwn_search.sendKeys(sIssueTo);
				driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
				String sDate = issuedOnDateDropDwn.getAttribute("value");
				if(sDate.length() == 20){
					sDate = sDate.substring(0, 4)+"0"+sDate.substring(4, 20);
				}
				flag1 = addIssueMaterial(iRowNo,sheet);
				Thread.sleep(Constant.Min_Sleep);
				if(flag1){
					issueRemarksTxt.sendKeys(sRemark+sDate);
					issueSaveBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
					navigate.showAllEntries();
					int iActualrows = preparedOn.size();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a")));
					actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a"))).perform();
					actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/span[2]"))).click().perform();
					Thread.sleep(Constant.Min_Sleep);
					String sActIssueNo = driver.findElement(By.xpath(".//td[contains(text(),'Issue')]/following::td[1][contains(text(),'I')]")).getText();
					String sActDate = issuedOnDateDropDwn.getAttribute("value");
					js.executeScript("window.scrollBy(0,-5000)");
					Thread.sleep(Constant.Min_Sleep);
					backButton.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]")));
					int count = Constant.countRegexInString(",", sMaterial) + 1;
					String[] sMaterialName = sMaterial.split("\\s+");
					if(count > 1){
						sMaterialName[0] = "Multiple";
						ele = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]/following::td[contains(text(),'"+sDate+"')]/following::td[contains(text(),'"+sIssueTo+"')]/following::td[contains(text(),'"+sIssueFor+"')]/following::td[contains(text(),'"+sProject+"')]/following::td/i[contains(text(),'"+sMaterialName[0].trim()+"')]/following::td[1][contains(text(),'"+count+"')]"));
					}else{
						ele = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]/following::td[contains(text(),'"+sDate+"')]/following::td[contains(text(),'"+sIssueTo+"')]/following::td[contains(text(),'"+sIssueFor+"')]/following::td[contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sMaterialName[0].trim()+"')]/following::td[1][contains(text(),'1')]"));
					}
					if(ele.isDisplayed() && sIssueNo.equals(sActIssueNo) && sActDate.contains(sDate) && iActualrows == iRow){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Issue Update is not successful"+e);
		}
		return flag;
	}

	public boolean updateIssue_MatQty() throws Exception{
		boolean flag = false;
		int iRow = 0; WebElement ele; String sQty = null;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			iRow = preparedOn.size();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")));
			String sIssueNo = driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/span[2]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sIssueNo+"')]")).isDisplayed()){
				for(int i=0;i<issueQtyList.size()-1;i++){
					sQty = Double.toString(Double.parseDouble(issueQtyList.get(i+1).getAttribute("Value"))+1);
					issueQtyList.get(i+1).sendKeys(Keys.CONTROL+"a");
					issueQtyList.get(i+1).sendKeys(Keys.DELETE);
					issueQtyList.get(i+1).sendKeys(sQty);
				}
				Thread.sleep(Constant.Min_Sleep);
				issueSaveBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
				navigate.showAllEntries();
				int iActualrows = preparedOn.size();
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]")));
				ele = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]/following::td[6][contains(text(),'"+sQty+"')]"));
				if(ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Issue Update is not successful"+e);
		}
		return flag;
	}

	public boolean updateIssue_ReduceMatQty() throws Exception{
		boolean flag = false;
		int iRow = 0; WebElement ele; String sQty = null;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			iRow = preparedOn.size();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")));
			String sIssueNo = driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/span[2]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sIssueNo+"')]")).isDisplayed()){
				for(int i=0;i<issueQtyList.size()-1;i++){
					sQty = Double.toString(Double.parseDouble(issueQtyList.get(i+1).getAttribute("Value"))-1);
					issueQtyList.get(i+1).sendKeys(Keys.CONTROL+"a");
					issueQtyList.get(i+1).sendKeys(Keys.DELETE);
					issueQtyList.get(i+1).sendKeys(sQty);
				}
				Thread.sleep(Constant.Min_Sleep);
				issueSaveBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
				navigate.showAllEntries();
				int iActualrows = preparedOn.size();
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]")));
				ele = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]/following::td[6][contains(text(),'"+sQty+"')]"));
				if(ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Issue Update is not successful"+e);
		}
		return flag;
	}

	public boolean WarningPopUp_MatQty() throws Exception{
		boolean flag = false;
		int iRow = 0; String sQty = null;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			iRow = preparedOn.size();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")));
			String sIssueNo = driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/span[2]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sIssueNo+"')]")).isDisplayed()){
				for(int i=0;i<issueQtyList.size()-1;i++){
					sQty = Double.toString(Double.parseDouble(issueQtyList.get(i+1).getAttribute("Value"))-1);
					issueQtyList.get(i+1).sendKeys(Keys.CONTROL+"a");
					issueQtyList.get(i+1).sendKeys(Keys.DELETE);
					issueQtyList.get(i+1).sendKeys(sQty);
				}
				Thread.sleep(Constant.Min_Sleep);
				issueSaveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(warningPop_ReduceQty.isDisplayed()){
					flag = true;
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Issue Update is not successful"+e);
		}
		return flag;
	}

	public boolean updateIssue_AddMat(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueFor = xls.get(iRowNo).get("Issue For");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sProject = xls.get(iRowNo).get("Project");
		String sRemark = xls.get(iRowNo).get("Remark");
		int iRow = 0; WebElement ele;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			iRow = preparedOn.size();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")));
			String sIssueNo = driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/span[2]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sIssueNo+"')]")).isDisplayed()){
				flag1 = addIssueMaterial(iRowNo,sheet);
				Thread.sleep(Constant.Min_Sleep);
				if(flag1){
					issueRemarksTxt.sendKeys("Update adding material"+sRemark+sDate);
					issueSaveBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
					navigate.showAllEntries();
					int iActualrows = preparedOn.size();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]")));
					ele = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]/following::td[contains(text(),'"+sIssueTo+"')]/following::td[contains(text(),'"+sIssueFor+"')]/following::td[contains(text(),'"+sProject+"')]/following::td/i[contains(text(),'Multiple')]"));
					if(ele.isDisplayed()){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Issue Update is not successful"+e);
		}
		return flag;
	}

	public boolean updateIssue_DeleteMat(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueFor = xls.get(iRowNo).get("Issue For");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sProject = xls.get(iRowNo).get("Project");
		String sRemark = xls.get(iRowNo).get("Remark");
		int iRow = 0; WebElement ele;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			iRow = preparedOn.size();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")));
			String sIssueNo = driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/span[2]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sIssueNo+"')]")).isDisplayed()){
				deleteMaterialBtn.get(1).click();
				Thread.sleep(Constant.Min_Sleep);
				yesButton.click();
				Thread.sleep(Constant.Min_Sleep);
				issueRemarksTxt.sendKeys("Update adding material"+sRemark+sDate);
				issueSaveBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
				navigate.showAllEntries();
				int iActualrows = preparedOn.size();
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]")));
				ele = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]/following::td[contains(text(),'"+sIssueTo+"')]/following::td[contains(text(),'"+sIssueFor+"')]/following::td[contains(text(),'"+sProject+"')]/following::td[contains(text(),'1')]"));
				if(ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Issue Update is not successful"+e);
		}
		return flag;
	}

	public boolean WarningDeleteMat_AfterIRN() throws Exception{
		boolean flag = false;
		int iRow = 0;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			iRow = preparedOn.size();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")));
			String sIssueNo = driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/span[2]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sIssueNo+"')]")).isDisplayed()){
				for(int i=1;i<issueSno.size();i++){
					actions.moveToElement(issueSno.get(i)).perform();
					actions.moveToElement(deleteMaterialBtn.get(i)).click().perform();
					Thread.sleep(Constant.Min_Sleep);
					if(materialDeleteWarning.isDisplayed()){
						flag = true;
						okBtn.click();
						Thread.sleep(Constant.Min_Sleep);
					}else{
						flag = false;
						break;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Issue Update is not successful"+e);
		}
		return flag;
	}



	public boolean updateIssueForTo(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueFor = xls.get(iRowNo).get("Issue For");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sProject = xls.get(iRowNo).get("Project");
		String sRemark = xls.get(iRowNo).get("Remark");
		int iRow = 0; WebElement ele;
		String sMat;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			iRow = preparedOn.size();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")));
			String sIssueNo = driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/span[2]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sIssueNo+"')]")).isDisplayed()){
				issueForDropdwn.click();
				issueForDropdwn_Search.sendKeys(sIssueFor);
				driver.findElement(By.xpath(".//li[text()='All']/following::li[1]/em[text()='"+sIssueFor+"']")).click();
				issueToDropdwn.click();
				issueToDropdwn_search.sendKeys(sIssueTo);
				driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
				issueRemarksTxt.sendKeys("Update adding material"+sRemark+sDate);
				if(matListGridMatCheck_Issue.size() > 2){
					sMat = "Multiple";
				}else{
					sMat = "1";
				}
				issueSaveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean flag2 = Constant.isElementPresent(By.id("btn-sa-confirm"));
				if(flag2){
					okBtn.click();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
				navigate.showAllEntries();
				int iActualrows = preparedOn.size();
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]")));
				ele = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]/following::td[contains(text(),'"+sIssueTo+"')]/following::td[contains(text(),'"+sIssueFor+"')]/following::td[contains(text(),'"+sProject+"')]/following::td/i[contains(text(),'"+sMat+"')]"));
				if(ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Issue Update is not successful"+e);
		}
		return flag;
	}

	public boolean updateIssuedDate(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueFor = xls.get(iRowNo).get("Issue For");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sProject = xls.get(iRowNo).get("Project");
		String sRemark = xls.get(iRowNo).get("Remark");
		WebElement ele; int iRow = 0;
		String sMat;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			iRow = preparedOn.size();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")));
			String sIssueNo = driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//tbody/tr["+iRow+"]/td/span[2]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sIssueNo+"')]")).isDisplayed()){
				issuedOnDateDropDwn.click();
				updateIssueDate.click();
				updateTimeHrSelect.click();
				updateTimeSelect.click();
				issueRemarksTxt.sendKeys("Update adding material"+sRemark+sDate);
				if(matListGridMatCheck_Issue.size() > 2){
					sMat = "Multiple";
				}else{
					sMat = "1";
				}
				issueSaveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				boolean flag2 = Constant.isElementPresent(By.id("btn-sa-confirm"));
				if(flag2){
					okBtn.click();
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
				navigate.showAllEntries();
				int iActualrows = preparedOn.size();
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]")));
				ele = driver.findElement(By.xpath(".//tbody/tr["+iActualrows+"]/td/a[contains(text(),'"+sIssueNo+"')]/following::td[contains(text(),'"+sIssueTo+"')]/following::td[contains(text(),'"+sIssueFor+"')]/following::td[contains(text(),'"+sProject+"')]/following::td[contains(text(),'"+sMat+"')]"));
				if(ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Issue Update is not successful"+e);
		}
		return flag;
	}

	/**
	 * To search the issues by selecting all the available projects
	 * @param iRowNo specifies the row number in the test data sheet
	 * @return true if the search of project is success
	 * @throws Exception
	 */
	public boolean searchIssue_Project(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Issue");
		String sProject = xls.get(iRowNo).get("Project");
		try{
			searchProjectDropDwn.click();
			projectSearchTextField.sendKeys(sProject);
			driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
			searchBtn.click();
			for(WebElement ele:projectColList){
				if(ele.getText().contains(sProject)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Issue Porject Search is not successful"+e);
		}
		return flag;
	}

	/**
	 * To search the issues with the available search in options
	 * @param iRowNo specifies the row number in test data sheet
	 * @return true of the search in of the issues is success
	 * @throws Exception
	 */

	public boolean searchIssue_SearchIn(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Issue");
		String sSearchIn = xls.get(iRowNo).get("Search In");
		try{
			searchBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> Result = new ArrayList<>();
			if (sSearchIn != null) {
				String[] sSplitData = sSearchIn.split("\\s*,\\s*");
				for (String element : sSplitData) {
					if (!(element == null) || !(element.length() == 0)) {
						Result.add(element.trim());
					}
				}
			}
			for(int i=1;i<searchInValList.size();i++){
				if(i == 4){
					continue;
				}else{
  					Select select = new Select(searchInDropDwn);
					select.selectByVisibleText(searchInValList.get(i).getText());
					searchTxt.clear();
					searchTxt.sendKeys(Result.get((i-1)));
					Thread.sleep(Constant.Min_Sleep);
					if(Constant.driver.getPageSource().contains("No Results Found")){
						Constant.log.info("No Search result found for the search criteria");
					}else{
						List<WebElement> list = Constant.driver.findElements(By.xpath(".//*[@id='issue_table_list_tbody']/tr/td["+(i+1)+"]"));
						for(WebElement ele : list){
							if(ele.getText().contains(Result.get((i-1)))){
								flag = true;
								}
							}
						}
					}
				}


		}catch(Exception e){
			System.err.println("Issue Search is not successful"+e);
		}
		return flag;
	}

	/**
	 * to verify whether cancel button works in the issue page
	 * @param iRowNo specifies the row no of test data sheet
	 * @return true if the issue is cancelled success
	 * @throws Exception
	 */

	public boolean cancelIssue(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		int iRow = 0;
		try{
			if(Constant.driver.getPageSource().contains("No Results Found")){
				addIssue(iRowNo, sheet);
				viewTab.click();
			}
			iRow = preparedOn.size();
			firstIssueNo.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				Constant.log.info("Add Tab is displayed");
				issueRemarksTxt.clear();
				issueRemarksTxt.sendKeys("Qa Testing"+sDate);
				issueCancelBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				int iActualrows = preparedOn.size();
				if(!Constant.driver.getPageSource().contains(sDate) && iRow == iActualrows){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Issue Cancel is not successful"+e);
		}
		return flag;
	}

	/**
	 * To validate mandatory fields check for issue add page
	 * @param iRowNo
	 * @return true, When warning messages are displayed for mandatory fields
	 * @throws Exception
	 */

	public boolean mandatoryFieldCheck_Issue(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueFor = xls.get(iRowNo).get("Issue For");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sRemark = xls.get(iRowNo).get("Remark");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				issueSaveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(issueFor_Mandatory.isDisplayed() && issueTo_Mandatory.isDisplayed() && dateMandatoryErr.isDisplayed()){
					issueForDropdwn.click();
					issueForDropdwn_Search.sendKeys(sIssueFor);
					driver.findElement(By.xpath(".//li[text()='All']/following::li[1]/em[text()='"+sIssueFor+"']")).click();
					issueSaveBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(issueTo_Mandatory.isDisplayed() && dateMandatoryErr.isDisplayed()){
						issueToDropdwn.click();
						issueToDropdwn_search.sendKeys(sIssueTo);
						driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
						issueSaveBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						if(dateMandatoryErr.isDisplayed()){
							issuedOnDateDropDwn.click();
							dateSelect.click();
							timeHrSelect.click();
							timeSelect.click();
							issueSaveBtn.click();
							Thread.sleep(Constant.Min_Sleep);
							if(materialReqWarning_Issue.isDisplayed()){
								okButton.click();
								Thread.sleep(Constant.Min_Sleep);
								materialReqTxt.sendKeys(sMaterial);
								Thread.sleep(Constant.Min_Sleep);
								Constant.driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
								Thread.sleep(Constant.Max_Sleep);
								materialReqQtyTxt.sendKeys(Keys.CONTROL+"a");
								materialReqQtyTxt.sendKeys(Keys.DELETE);
								materialReqQtyTxt.sendKeys("1");
								materialAdd.click();
								issueRemarksTxt.sendKeys(sRemark+sDate);
								issueSaveBtn.click();
								Thread.sleep(Constant.Min_Sleep);
								Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
								navigate.showAllEntries();
								if(Constant.driver.getPageSource().contains(sDate)){
									flag = true;
									Constant.log.info("Issue added successfully");
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Mandatory field check for issues failed "+e);
		}
		return flag;
	}

	public boolean noMaterialWarning_Issue(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueFor = xls.get(iRowNo).get("Issue For");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				issueForDropdwn.click();
				issueForDropdwn_Search.sendKeys(sIssueFor);
				driver.findElement(By.xpath(".//li[text()='All']/following::li[1]/em[text()='"+sIssueFor+"']")).click();
				issueToDropdwn.click();
				issueToDropdwn_search.sendKeys(sIssueTo);
				driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
				issuedOnDateDropDwn.click();
				dateSelect.click();
				timeHrSelect.click();
				timeSelect.click();
				issueSaveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(materialReqWarning_Issue.isDisplayed()){
					okButton.click();
					Thread.sleep(Constant.Min_Sleep);
					flag = true;
					Constant.log.info("Issue added successfully");
				}
			}
		}catch(Exception e){
			System.err.println("Mandatory material warning check for issues failed "+e);
		}
		return flag;
	}

	public boolean deleteMaterial(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueFor = xls.get(iRowNo).get("Issue For");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		try{
			materialListgrid_issue(iRowNo,sheet);
			issueForDropdwn.click();
			issueForDropdwn_Search.sendKeys(sIssueFor);
			driver.findElement(By.xpath(".//li[text()='All']/following::li[1]/em[text()='"+sIssueFor+"']")).click();
			issueToDropdwn.click();
			issueToDropdwn_search.sendKeys(sIssueTo);
			driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
			issuedOnDateDropDwn.click();
			dateSelect.click();
			timeHrSelect.click();
			timeSelect.click();
			for(int i=1;i<deleteMaterialBtn.size();i++){
				deleteMaterialBtn.get(i).click();
				Thread.sleep(Constant.Min_Sleep);
				yesButton.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			issueSaveBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(materialReqWarning_Issue.isDisplayed()){
				okButton.click();
				Thread.sleep(Constant.Min_Sleep);
				flag = true;
				Constant.log.info("Issue added successfully");
			}
		}catch(Exception e){
			System.err.println("Failed to delete material "+e);
		}
		return flag;
	}

	public boolean mandatoryMaterialWarning_Issue(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueFor = xls.get(iRowNo).get("Issue For");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sMaterial = xls.get(iRowNo).get("Material");
		String sRemark = xls.get(iRowNo).get("Remark");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				issueForDropdwn.click();
				issueForDropdwn_Search.sendKeys(sIssueFor);
				driver.findElement(By.xpath(".//li[text()='All']/following::li[1]/em[text()='"+sIssueFor+"']")).click();
				issueToDropdwn.click();
				issueToDropdwn_search.sendKeys(sIssueTo);
				driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
				issuedOnDateDropDwn.click();
				dateSelect.click();
				timeHrSelect.click();
				timeSelect.click();
				issueSaveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(materialReqWarning_Issue.isDisplayed()){
					okButton.click();
					Thread.sleep(Constant.Min_Sleep);
					materialAdd.click();
					Thread.sleep(Constant.Min_Sleep);
					if(materialName_Mandatory.isDisplayed() && quantity_Mandatory.isDisplayed()){
						materialReqTxt.sendKeys(sMaterial);
						Thread.sleep(Constant.Min_Sleep);
						Constant.driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
						Thread.sleep(Constant.Max_Sleep);
						materialAdd.click();
						Thread.sleep(Constant.Min_Sleep);
						if(quantity_Mandatory.isDisplayed()){
							materialReqQtyTxt.sendKeys(Keys.CONTROL+"a");
							materialReqQtyTxt.sendKeys(Keys.DELETE);
							materialReqQtyTxt.sendKeys("1");
							materialAdd.click();
							issueRemarksTxt.sendKeys(sRemark+sDate);
							issueSaveBtn.click();
							Thread.sleep(Constant.Min_Sleep);
							Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
							navigate.showAllEntries();
							if(Constant.driver.getPageSource().contains(sDate)){
								flag = true;
								Constant.log.info("Issue added successfully");
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Mandatory material warning check for issues failed "+e);
		}
		return flag;
	}

	public boolean materialListgrid_issue(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				flag = addIssueMaterial(iRowNo,sheet);
			}
		}catch(Exception e){
			System.err.println("Failed to validate Material list grid "+e);
		}
		return flag;
	}

	public boolean addFullQty_issue(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sValue = null;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			String[] sMaterialList = sMaterial.split(",");
			if(newPage.isDisplayed()){
				materialReqTxt.sendKeys(sMaterialList[0].trim());
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//a[contains(text(),'"+sMaterialList[0].trim()+"')]")).click();
				Thread.sleep(Constant.Max_Sleep);
				Thread.sleep(Constant.Medium_Sleep);
				sValue = materialAvailQty.getText().substring(10);
				materialReqQtyTxt.sendKeys(Keys.CONTROL+"a");
				materialReqQtyTxt.sendKeys(Keys.DELETE);
				materialReqQtyTxt.sendKeys(sValue);
				materialAdd.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			if(matListGridMatCheck_Issue.get(1).getAttribute("value").contains(sMaterial)
					&& (matListGridQtyCheck_Issue.get(1).getAttribute("value").contains(sValue))){
				flag = true;
			}else{
				flag = false;
			}
		}catch(Exception e){
			System.err.println("Failed to add full qty for material in issue "+e);
		}
		return flag;
	}

	public boolean newMaterialWarning(){
		boolean flag = false;
		String sMaterial = RandomStringUtils.randomAlphabetic(10);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				materialReqTxt.sendKeys(sMaterial);
				Thread.sleep(Constant.Min_Sleep);
				materialReqQtyTxt.click();
			}
			if(driver.findElement(By.xpath(".//b[contains(text(),'"+sMaterial+"')]")).isDisplayed()){
				flag = true;
				cancelBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to add full qty for material in issue "+e);
		}
		return flag;
	}

	public boolean stockNotAvailableWarning(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				materialReqTxt.sendKeys(sMaterial);
				Thread.sleep(Constant.Min_Sleep);
				Constant.driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
				Thread.sleep(Constant.Max_Sleep);
				String sValue = materialAvailQty.getText().substring(10);
				materialReqQtyTxt.sendKeys(Keys.CONTROL+"a");
				materialReqQtyTxt.sendKeys(Keys.DELETE);
				materialReqQtyTxt.sendKeys(Double.toString(Double.parseDouble(sValue)+1));
				materialAdd.click();
				Thread.sleep(Constant.Min_Sleep);
				if(stockNotAvail.isDisplayed()){
					flag = true;
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Stock not available warning check failed "+e);
		}
		return flag;
	}

	public boolean MandatoryFieldsCheckEdit(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sIssueFor = xls.get(iRowNo).get("Issue For");
		String sIssueTo = xls.get(iRowNo).get("Issue To");
		String sMaterial = xls.get(iRowNo).get("Material");
		int iRow = 0;
		try{
			addIssue(iRowNo, sheet);
			viewTab.click();
			iRow = preparedOn.size();
			driver.findElement(By.xpath(".//*[@id='issue_table_list_tbody']/tr["+iRow+"]/td[3]/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				for(int i=1;i<deleteMaterialBtn.size();i++){
					deleteMaterialBtn.get(i).click();
					Thread.sleep(Constant.Min_Sleep);
					yesButton.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				Select selectIssueFor = new Select(issueForDropdwn);
				selectIssueFor.selectByValue("0");
				issueToDropdwn.click();
				issueToDropdwn_search.sendKeys("--Select Issue To--");
				driver.findElement(By.xpath(".//em[text()='--Select Issue To--']")).click();
				UpdateBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(issueFor_Mandatory.isDisplayed() && issueTo_Mandatory.isDisplayed()){
					selectIssueFor.selectByVisibleText(sIssueFor);
					UpdateBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(issueTo_Mandatory.isDisplayed()){
						issueToDropdwn.click();
						issueToDropdwn_search.sendKeys(sIssueTo);
						driver.findElement(By.xpath(".//em[text()='"+sIssueTo+"']")).click();
						UpdateBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						if(materialReqWarning_Issue.isDisplayed()){
							okButton.click();
							Thread.sleep(Constant.Min_Sleep);
							materialAdd.click();
							Thread.sleep(Constant.Min_Sleep);
							driver.switchTo().alert().accept();
							Thread.sleep(Constant.Min_Sleep);
							if(materialName_Mandatory.isDisplayed() && quantity_Mandatory.isDisplayed()){
								materialReqTxt.sendKeys(sMaterial);
								Thread.sleep(Constant.Min_Sleep);
								driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
								Thread.sleep(Constant.Min_Sleep);
								materialAdd.click();
								Thread.sleep(Constant.Min_Sleep);
								driver.switchTo().alert().accept();
								Thread.sleep(Constant.Min_Sleep);
								if(quantity_Mandatory.isDisplayed()){
									materialReqQtyTxt.sendKeys("1");
									materialAdd.click();
									UpdateBtn.click();
									Thread.sleep(Constant.Min_Sleep);
									if(issueUpdatePopup.isDisplayed()){
										okButton.click();
										Thread.sleep(Constant.Min_Sleep);
										if(Constant.driver.getPageSource().contains(sDate)){
											flag = true;
											Constant.log.info("Issue added successfully");
										}
									}
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Mandatory fields check during edit failed "+e);
		}
		return flag;
	}

	public boolean availStockCheck(int iRowNo, String sheet, String sStock){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			addInvoiceIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			if(newPage.isDisplayed()){
				Thread.sleep(Constant.Min_Sleep);
				materialReqTxt.sendKeys(sMaterial.trim());
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//a[contains(text(),'"+sMaterial+"')]")).click();
				Thread.sleep(Constant.Max_Sleep);
				String value = materialAvailQty.getText().substring(10);
				if(Double.parseDouble(value) == (Double.parseDouble(sStock))){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to load available qty in issue add page "+e);
		}
		return flag;
	}


	/**
	 *
	 * @return
	 * @throws Exception
	 */

	public boolean columnNamesValidation(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Issue");
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			flag = Constant.verifyColumnOrder(issueColumnNames,sColumn);
		}catch(Exception e){
			System.err.println("Column name validation failed "+e);
		}
		return flag;
	}

	public boolean closingStockColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(reportView), "Failed to load indent pending report");
			reportView.click();
			Constant.waitFor(ExpectedConditions.visibilityOf(closingStockColumnNames), "Failed to load indent pending report");
			flag = Constant.verifyColumnOrder(closingStockColumnNames,sColumn);
		}catch(Exception e){
			System.err.println("Closing stock Report column validation failed "+e);
		}
		return flag;
	}

	public boolean poPendingColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(reportView), "Failed to load indent pending report");
			Select select = new Select(reportsDropDwn);
			select.selectByVisibleText("PO Pending Report");
			reportView.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder(poReportColumnNames,sColumn);
		}catch(Exception e){
			System.err.println("PO Pending report column validation failed "+e);
		}
		return flag;
	}

	public boolean indentPendingColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Select select = new Select(reportsDropDwn);
			select.selectByVisibleText("Indent Pending Report");
			reportView.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load indent pending report");
			flag = Constant.verifyColumnOrder(indentPendingColumnNames,sColumn);
		}catch(Exception e){
			System.err.println("Indent Pending report column validation failed "+e);
		}
		return flag;
	}

	public boolean grnReportColumnVerifyWithDraft(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load grn report");
			filterBtn.click();
			grnReportView.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(grnReportView), "Failed to load grn report");
			flag = Constant.verifyColumnOrder_ScrollTable(grnReportColumns, sColumn);
		}catch(Exception e){
			System.err.println("GRN Report column with draft validation failed "+e);
		}
		return flag;
	}

	public boolean grnReportColumnVerifyWithoutDraft(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load grn report");
			filterBtn.click();
			excludeDrafts.click();
			grnReportView.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(grnReportView), "Failed to load grn report");
			flag = Constant.verifyColumnOrder_ScrollTable(grnReportColumns, sColumn);
		}catch(Exception e){
			System.err.println("GRN Report column without draft validation failed "+e);
		}
		return flag;
	}

	public boolean dcReportColumnVerifyWithDraft(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load Dc report");
			filterBtn.click();
			dcReportView.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder(dcReportsColumnNames,sColumn);
		}catch(Exception e){
			System.err.println("DC Report column with Draft validation failed "+e);
		}
		return flag;
	}

	public boolean dcReportColumnVerifyWithoutDraft(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load Dc report");
			filterBtn.click();
			excludeDrafts.click();
			dcReportView.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder(dcReportsColumnNames,sColumn);
		}catch(Exception e){
			System.err.println("DC Report column without Draft validation failed "+e);
		}
		return flag;
	}

	public boolean materialReceiptReportWithDraft(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		String sMaterial = xls.get(iRowNo).get("Material");
		try{
			materialNameDropDwn.click();
			searchMaterialName.sendKeys(sMaterial);
			driver.findElement(By.xpath(".//em[text()='"+sMaterial+"']")).click();
			materialReportViewReportBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder(materialReportColumns,sColumn);
		}catch(Exception e){
			System.err.println("Material Receipt report with draft column validation failed "+e);
		}
		return flag;
	}

	public boolean materialReceiptReportWithoutDraft(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		String sMaterial = xls.get(iRowNo).get("Material");
		try{
			materialNameDropDwn.click();
			searchMaterialName.sendKeys(sMaterial);
			driver.findElement(By.xpath(".//em[text()='"+sMaterial+"']")).click();
			excludeDrafts.click();
			materialReportViewReportBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder(materialReportColumns,sColumn);
		}catch(Exception e){
			System.err.println("Material Receipt report without draft column validation failed "+e);
		}
		return flag;
	}

	public boolean shortageListColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		ArrayList<String> array = new ArrayList<>();
		String visibleHeaders = "";
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(addBtn_ShortageList), "Failed to load shortage report");
			addBtn_ShortageList.click();
			Thread.sleep(Constant.Min_Sleep);
			selectAllCheckBx.click();
			String sCount = selectedItemCount.getText();
			ViewReportBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			applyShortageBTN.click();
			Thread.sleep(Constant.Max_Sleep);
			Thread.sleep(Constant.Max_Sleep);
			Thread.sleep(Constant.Max_Sleep);
			Thread.sleep(Constant.Max_Sleep);
			Thread.sleep(Constant.Max_Sleep);
			Thread.sleep(Constant.Max_Sleep);
			String expectedHeaders = String.join(" ", sColumn).toUpperCase();
			for (WebElement shortageReportColumn : shortageReportColumns) {
				array.add(shortageReportColumn.getText());
				if(shortageReportColumn.getText().contains("SHORTAGE")){
					break;
				}
			}
			for(String s : array){
				visibleHeaders += s + " ";
			}
			if(visibleHeaders.contains(expectedHeaders) && shortageListTable.size() == Integer.parseInt(sCount)){
		    	flag = true;
		    }
		}catch(Exception e){
			System.err.println("Shortage List report column validation failed "+e);
		}
		return flag;
	}

	public boolean JobInOutReportColValid(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load Job in report");
			filterBtn.click();
			jobInReportApplyBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder_ScrollTable(JobInOutReportColumnNames,sColumn);
		}catch(Exception e){
			System.err.println("Sales Report column validation without draft failed "+e);
		}
		return flag;
	}

	public boolean InternalStockFlowColValid(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load Job in report");
			filterBtn.click();
			jobInReportApplyBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder(internalStockFlowColNames,sColumn);
		}catch(Exception e){
			System.err.println("Sales Report column validation without draft failed "+e);
		}
		return flag;
	}


	public String shortClose(){
		List<Double> poQty = new ArrayList<>();
		List<Double> indentQty = new ArrayList<>();
		double totalPoQty = 0.0;
		String sStatus = null;
		try{
			Thread.sleep(Constant.Min_Sleep);
			iIndentView.click();
			Thread.sleep(Constant.Min_Sleep);
			if(shortCloseLnk.isDisplayed()){
				shortCloseLnk.click();
				for(int j=0;j<poQtyList.size();j++){
					poQty.add(Double.parseDouble(poQtyList.get(j).getText()));
					indentQty.add(Double.parseDouble(indentQtyList.get(j+1).getAttribute("value")));
					totalPoQty += poQty.get(j);
				}
				if(totalPoQty == 0){
					sStatus = "Completed";
				}else{
					sStatus = "Pending due to Material";
				}
				saveIndent.click();
				Thread.sleep(Constant.Min_Sleep);
				backButton.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to validate short close "+e);
		}
		return sStatus;
	}

	public boolean validateShortClose(int iRowNo, String sheet){
		boolean flag = false;
		String sStatus = null;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			addIndent(iRowNo, sheet);
			String sIndentValue = totalRecords.getText().substring(15);
			driver.findElement(By.xpath(".//*[@id='issue_table_list_tbody']/tr["+(Integer.parseInt(sIndentValue))+"]/td[2]/a")).click();
			sStatus = shortClose();
			if(!sStatus.isEmpty()){
				navigate.showAllEntries();
				js.executeScript("arguments[0].scrollIntoView(true);", indentStatusList.get(Integer.parseInt(sIndentValue)-1));
				String sIndentActValue = totalRecords.getText().substring(15);
				if(indentStatusList.get(Integer.parseInt(sIndentValue)-1).getText().contains(sStatus) && Integer.parseInt(sIndentValue) == Integer.parseInt(sIndentActValue)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate short close "+e);
		}
		return flag;
	}

	public boolean multipleMaterial(int iRowNo) throws Exception{
		 boolean flag = false;
		 List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Indent");
		 String sType = xls.get(iRowNo).get("Indent Type");
		 String sProject = xls.get(iRowNo).get("Project");
		 String sMaterial = xls.get(iRowNo).get("Material");
		 String sQuantity = xls.get(iRowNo).get("Quantity");
		 String sMake = xls.get(iRowNo).get("Make Profile");
		 String sIndentNo,indentNo = null;
		 try{
			 addIndentIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			indentForTxt.sendKeys("Test"+sDate);
			indentTypeDropDwn.click();
			indentTypeSearch.sendKeys(sType);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sType+"']")).click();
			indentProjectDropDwn.click();
			projectSearch.sendKeys(sProject);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
			indentReqDate.click();
			Constant.driver.findElement(By.xpath(".//td[contains(@class,'available')][text()='"+iDate+"'][contains(@class,'today')]")).click();
			ArrayList<String> material = new ArrayList<>();
			ArrayList<String> make = new ArrayList<>();
			if (sMaterial != null) {
				String[] splitMaterial = sMaterial.split("\\s*,\\s*");
				String[] splitMake = sMake.split("\\s*,\\s*");
				for (int i = 0; i < splitMaterial.length; i++) {
					if (!(splitMaterial[i] == null) || !(splitMaterial[i].length() == 0)) {
						material.add(splitMaterial[i].trim());
						make.add(splitMake[i].trim());
					}
				}
			}
			for (String element : material) {
				materialReqTxt.sendKeys(element);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//a[text()='"+element+"']")).click();
				Thread.sleep(Constant.Min_Sleep);
				quantityTxt.sendKeys(sQuantity);
				addMaterial.click();
				if(driver.findElement(By.xpath(".//div[contains(text(),'"+element+"')]")).isDisplayed()){
					Constant.log.info(element +"Material is added successfully");
				}else{
					System.err.println(element +"Material is not added");
				}
				Thread.sleep(Constant.Min_Sleep);
			}
			indentRemark.sendKeys("Remark"+sDate);
			saveIndent.click();
			Thread.sleep(Constant.Min_Sleep);
			sIndentNo = indentNo_AddPage.getText();
			backButton.click();
			Thread.sleep(Constant.Min_Sleep);
			int num = indentList.size();
			indentNo = Constant.driver.findElement(By.xpath(".//*[@id='issue_table_list_tbody']/tr["+num+"]/td[2]/a")).getText();
			if(sIndentNo.contains(indentNo)){
				flag = true;
			}
		 }catch(Exception e){
			 System.err.println("Multiple material addition to indent failed "+e);
		 }
		 return flag;
	 }

	 public boolean removeBOMMaterialCount(int iRowNo) throws Exception{
		 boolean flag = false;
		 List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Indent");
		 String sType = xls.get(iRowNo).get("Indent Type");
		 String sProject = xls.get(iRowNo).get("Project");
		 String sMaterial = xls.get(iRowNo).get("Material");
		 String sQuantity = xls.get(iRowNo).get("Quantity");
		 String sIndentNo, indentNo = null;
		 try{
			 addIndentIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			indentForTxt.sendKeys("Test"+sDate);
			indentTypeDropDwn.click();
			indentTypeSearch.sendKeys(sType);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sType+"']")).click();
			indentProjectDropDwn.click();
			projectSearch.sendKeys(sProject);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
			indentReqDate.click();
			Constant.driver.findElement(By.xpath(".//td[contains(@class,'available')][text()='"+iDate+"'][contains(@class,'today')]")).click();
			materialReqTxt.sendKeys(sMaterial);
			Thread.sleep(Constant.Min_Sleep);
			Constant.driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
			quantityTxt.sendKeys(sQuantity);
			viewBomBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(viewBOMPopup.isDisplayed()){
				int iActCount = bomMaterials.size();
				bomMaterialCount_first.clear();
				addBOM.click();
				Thread.sleep(Constant.Min_Sleep);
				int iAddedCount = addedMaterials.size()-1;
				if(iAddedCount < iActCount){
					saveIndent.click();
					Thread.sleep(Constant.Min_Sleep);
					sIndentNo = indentNo_AddPage.getText();
					backButton.click();
					Thread.sleep(Constant.Min_Sleep);
					int num = indentList.size();
					indentNo = Constant.driver.findElement(By.xpath(".//*[@id='issue_table_list_tbody']/tr["+num+"]/td[2]/a")).getText();
					if(sIndentNo.contains(indentNo)){
						flag = true;
					}
				}
			}
		 }catch(Exception e){
			 System.err.println("Remove BOM material count validation failed "+e);
		 }
		 return flag;
	 }

	 public boolean removeMaterialCount(int iRowNo) throws Exception{
		 boolean flag = false;
		 List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Indent");
		 String sType = xls.get(iRowNo).get("Indent Type");
		 String sProject = xls.get(iRowNo).get("Project");
		 String sMaterial = xls.get(iRowNo).get("Material");
		 String sQuantity = xls.get(iRowNo).get("Quantity");
		 try{
			 int iList = indentList.size();
			 addIndentIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			indentForTxt.sendKeys("Test"+sDate);
			indentTypeDropDwn.click();
			indentTypeSearch.sendKeys(sType);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sType+"']")).click();
			indentProjectDropDwn.click();
			projectSearch.sendKeys(sProject);
			Constant.driver.findElement(By.xpath(".//em[text()='"+sProject+"']")).click();
			indentReqDate.click();
			Constant.driver.findElement(By.xpath(".//td[contains(@class,'available')][text()='"+iDate+"'][contains(@class,'today')]")).click();
			materialReqTxt.sendKeys(sMaterial);
			Thread.sleep(Constant.Min_Sleep);
			Constant.driver.findElement(By.xpath(".//a[text()='"+sMaterial+"']")).click();
			quantityTxt.sendKeys(sQuantity);
			addMaterial.click();
			firstMaterialQty.clear();
			saveIndent.click();
			Thread.sleep(Constant.Min_Sleep);
			backButton.click();
			Thread.sleep(Constant.Min_Sleep);
			int iActualList = indentList.size();
			if(iList == iActualList){
				flag = true;
			}
		 }catch(Exception e){
			 System.err.println("Removing material count validation failed "+e);
		 }
		 return flag;
	 }

	 public boolean indentColumnValidation(int iRowNo) throws Exception{
		 boolean flag = false;
		 List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Indent");
		 String sColumn = xls.get(iRowNo).get("Column Name");
		 try{
			 flag = Constant.verifyColumnOrder(indentColumnNames,sColumn);
		 }catch(Exception e){
			 System.err.println("Indent list grid column names validation failed "+e);
		 }
		 return flag;
	 }

	 public boolean nonEditableFields(){
		 boolean flag = false;
		 try{
			 firstIndent.click();
			 Thread.sleep(Constant.Min_Sleep);
			 if(!(indentForTxt.isEnabled() && indentTypeDropDwn.isEnabled() && projectSearch.isEnabled())){
				 flag = true;
			 }
		 }catch(Exception e){
			 System.err.println("Non Editable fields validation failed "+e);
		 }
		 return flag;
	 }

	 /**
		 * To Search Store Dashboard with entered from date
		 * Validation: Indent Status Raised value is validated with the available indent fetched value form Indent page
		 * @return returns the boolean flag true if the validation is success
		 */

	public boolean searchStore(){
		boolean flag = false;
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToStoreDash();
			Thread.sleep(Constant.Min_Sleep);
			submitBtn.click();
			String sActValue = raisedIndentStatus.getAttribute("value").trim();
			String sValue = fetchIndentValue().trim();
			if(sActValue.equals(sValue)){
				flag = true;
				Constant.log.info("Store Dashboard refresh is successful");
			}
		}catch(Exception e){
			System.err.println("Store Dashboard refresh is not successful"+e);
		}
		return flag;
	}

	/**
	 * To fetch indent value for the entered date range
	 * @return returns the indent fetched value
	 */

	public String fetchIndentValue(){
		String sValue = null;
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			searchBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			sValue = indentFetched.getText();
			if(!(sValue == null)){
				Constant.log.info("Indent value is fetched successfully");
			}
		}catch(Exception e){
			System.err.println("Fetching indent value failed "+e);
		}
		return sValue;
	}

	/**
	 * to verify whether on clicking raised indent value in dashboard navigates to indent page
	 * raised values should match for the date specified
	 * @return flag true when the values in dashboard and indent match
	 */
	public boolean raisedIndent(){
		boolean flag = false;
		String sValue = null;
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			String sActValue = raisedIndentStatus.getAttribute("value").trim();
			raisedIndentStatus.click();
			Thread.sleep(Constant.Min_Sleep);
			if(indentFetched.isDisplayed()){
				sValue = indentFetched.getText();
				if(!(sValue == null)){
					Constant.log.info("Indent value is fetched successfully");
				}
			}
			if(sActValue.equals(sValue)){
				flag = true;
				Constant.log.info("Store Dashboard refresh is successful");
			}
		}catch(Exception e){
			System.err.println("Raised Indent status navigates to Indent Page successfully");
		}
		return flag;
	}

	public boolean approvedIRNDetailsValidate(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addIssue(iRowNo, sheet);
			navigate.showAllEntries();
			int iRows = preparedOn.size();
			String sIssueNo = driver.findElement(By.xpath("//table[@id='invoice_list']/tbody/tr["+iRows+"]/td/a")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			approveGRN(iRowNo,sheet,sIssueNo);
			int grnCount = grnList.size();
			String sGRNNo = driver.findElement(By.xpath("//tr["+grnCount+"]//td[4]")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]")));
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]"))).perform();
			actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			materialsReturnedBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(returnMaterialPopup.isDisplayed()){
				for (WebElement element : returnedMaterialGRNNoList) {
					if(element.getText().contains(sGRNNo)){
						flag = true;
					}
				}
				returnMaterialPopupClose.click();
			}
		}catch(Exception e){
			System.err.println("Failed to validate Draft IRN details in Issue page "+e);
		}
		return flag;
	}

	public boolean rejectIRNDetailsValidate(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addIssue(iRowNo, sheet);
			navigate.showAllEntries();
			int iRows = preparedOn.size();
			String sIssueNo = driver.findElement(By.xpath("//table[@id='invoice_list']/tbody/tr["+iRows+"]/td/a")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			vaildateRejectApprovedGRN(iRowNo,sheet,sIssueNo);
			int grnCount = grnList.size();
			String sGRNNo = driver.findElement(By.xpath("//tr["+grnCount+"]//td[4]")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			Constant.waitFor(ExpectedConditions.visibilityOf(filterText), "Failed to load GRN edit page");
			navigate.showAllEntries();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]")));
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]"))).perform();
			actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(materialsNotReturnedBtn.isDisplayed()){
				flag = true;
			}else{
				materialsReturnedBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				for (WebElement element : returnedMaterialGRNNoList) {
					if(!element.getText().contains(sGRNNo)){
						flag = true;
					}
				}
				returnMaterialPopupClose.click();
			}
		}catch(Exception e){
			System.err.println("Failed to validate Draft IRN details in Issue page "+e);
		}
		return flag;
	}

	public boolean draftIRNDetailsValidate(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sFaulty = xls.get(iRowNo).get("Faulty");
		List<String> sMatList = new ArrayList<>();
		String[] sMat = new String[100];
		try{
			addIssue(iRowNo, sheet);
			navigate.showAllEntries();
			int iRows = preparedOn.size();
			String sIssueNo = driver.findElement(By.xpath("//table[@id='invoice_list']/tbody/tr["+iRows+"]/td/a")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			addGRN(iRowNo, sheet, sIssueNo);
			int grnCount = grnList.size();
			String sGRNNo = driver.findElement(By.xpath("//tr["+grnCount+"]//td[4]")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load issue view page");
			navigate.showAllEntries();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]")));
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]"))).perform();
			actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			materialsReturnedBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(returnMaterialPopup.isDisplayed()){
				for(int i=0;i<returnedMaterialGRNNoList.size();i++){
					if(returnedMaterialPopupList.get(i).getText().contains("[Faulty]")){
						sMat = returnedMaterialPopupList.get(i).getText().split("\\[");
					}else{
						sMat[0] = returnedMaterialPopupList.get(i).getText();
					}
					if(returnedMaterialGRNNoList.get(i).getText().contains(sGRNNo) && sMaterial.contains(sMat[0].trim())){
						sMatList.add(returnedMaterialPopupList.get(i).getText());
						flag = true;
					}
				}
				if(sFaulty.contains("Yes")){
					for (String element : sMatList) {
						if(element.contains("Faulty")){
							flag = true;
							break;
						}else{
							flag = false;
						}
					}
				}
				returnMaterialPopupClose.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to validate Draft IRN details in Issue page "+e);
		}
		return flag;
	}

	public boolean updateIRNDetailsValidate(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		int j = 0;
		try{
			addIssue(iRowNo, sheet);
			navigate.showAllEntries();
			int iRows = preparedOn.size();
			String sIssueNo = driver.findElement(By.xpath("//table[@id='invoice_list']/tbody/tr["+iRows+"]/td/a")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			addGRN(iRowNo, sheet, sIssueNo);
			int grnCount = grnList.size();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//tr["+grnCount+"]//td[4]")));
			String sGRNNo = driver.findElement(By.xpath("//tr["+grnCount+"]//td[4]")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//a[@class='edit_link_code'][contains(text(),'"+sGRNNo+"')]"))).perform();
			driver.findElement(By.xpath("//a[@class='edit_link_code'][contains(text(),'"+sGRNNo+"')]")).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				updateGRNDetails(iRowNo, sheet, sIssueNo);
				UpdateBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
					Thread.sleep(Constant.Min_Sleep);
				}
				Constant.waitFor(ExpectedConditions.visibilityOf(okButton), "Failed to load GRN edit page");
				okButton.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			}
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]")));
			Thread.sleep(Constant.Min_Sleep);
			actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]"))).perform();
			actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			materialsReturnedBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(returnMaterialPopup.isDisplayed()){
				for(int i=0;i<returnedMaterialGRNNoList.size();i++){
					if(returnedMaterialGRNNoList.get(i).getText().contains(sGRNNo)){
						j = i+1;
					}
				}
				int count = Constant.countRegexInString(",", sMaterial) + 1;
				if(count == j){
					flag = true;
				}
				returnMaterialPopupClose.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Updated IRN details validation "+e);
		}
		return flag;
	}

	public boolean approveReturnedGRN(int iRowNo, String sheet){
		boolean flag = false;
		String sGRNNo = null;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			navigate.showAllEntries();
			for(int i=0;i<grnList.size();i++){
				js.executeScript("arguments[0].scrollIntoView(true);", grnStatusList.get(i));
				if(grnStatusList.get(i).getText().contains("Returned")){
					sGRNNo = grnList.get(i).getText();
					Actions actions = new Actions(driver);
					actions.moveToElement(grnList.get(i)).perform();
					grnList.get(i).click();
					Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
					break;
				}
			}
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				updateGRNDetails(iRowNo, sheet, null);
				Thread.sleep(Constant.Min_Sleep);
				saveNdApproveBtn.click();
				Thread.sleep(Constant.Medium_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
					Thread.sleep(Constant.Min_Sleep);
				}
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load ok button");
				okBtn.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
				backButton.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
				navigate.showAllEntries();
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]")));
				if(driver.findElement(By.xpath("//td/a[contains(text(),'"+sGRNNo+"')]/following::td[9]")).getText().contains("Approved")){
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToAuditing();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToICD();
					Thread.sleep(Constant.Min_Sleep);
					navigate.showAllEntries();
					for (WebElement element : grnNoList) {
						js.executeScript("arguments[0].scrollIntoView(true);", element);
						if(element.getText().contains(sGRNNo)){
							flag = true;
							break;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to approve returned GRn from ICD "+e);
		}
		return flag;
	}

	public boolean createPO_IndentPo(int iRowNo, String sheet){
		boolean flag = false, flag1;
		try{
			Constant.waitFor(ExpectedConditions.visibilityOf(poVisibleRecordCount), "Failed to load po page");
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			String[] sPODraftNo = createIndentPO(iRowNo, sheet);
			flag1 = validateIndentEditPg_AfterPoCreated();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(driver.getPageSource().contains(sPODraftNo[0]) && iActPONumber > iPONumber && flag1){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to create po from indent po page "+e);
		}
		return flag;
	}

	public String[] createIndentPO(int iRowNo, String sheet){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String sPODraftNo = null, indentNo = null;
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			indentNo = addIndent(iRowNo, sheet);
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+indentNo+"')]")));
			driver.findElement(By.xpath(".//td/a[contains(text(),'"+indentNo+"')]")).click();
			Thread.sleep(Constant.Min_Sleep);
			sPODraftNo = createPO(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Failed to create po from indent po page "+e);
		}
		return new String[] {sPODraftNo, indentNo};
	}

	public String createPO(int iRowNo, String sheet){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sQtyToEntered = xls.get(iRowNo).get("Qty to be Entered");
		String sType = xls.get(iRowNo).get("Type");
		String sMaterial = xls.get(iRowNo).get("Material");
		String[] sMaterialList = sMaterial.split(",");
 		String sPODraftNo = null; List<String> sSupplierList = new ArrayList<>();
		try{
			if(indentPurchaseBtn.isDisplayed()){
				for(int i=0;i<indentPOsupplierBucketList.size();i++){
					sSupplierList.add(indentPOsupplierBucketList.get(i).getText());
				}
				for (WebElement element : purchaseCheckboxes) {
					element.click();
				}
				for (WebElement element : jobOrderCheckboxes) {
					element.click();
				}
				for(int i=0;i<sMaterialList.length;i++){
					String sPendingPoCount = poQtyIndentPOPage.get(i).getAttribute("value");
					driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'"+sMaterialList[i]+"')]/following::td[14]/img")).click();
					Thread.sleep(Constant.Min_Sleep);
					addSupplierBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					selectSupplierSplitPopup.click();
					Thread.sleep(Constant.Min_Sleep);
					for(int j=0;j<supplierList.size();j++){
						if(!sSupplierList.contains(supplierList.get(j).getText())){
							supplierList.get(j).click();
							Thread.sleep(Constant.Min_Sleep);
							break;
						}
					}
					materialPriceTxtSplitPopup.get(materialPriceTxtSplitPopup.size()-1).sendKeys(Keys.CONTROL+"a");
					materialPriceTxtSplitPopup.get(materialPriceTxtSplitPopup.size()-1).sendKeys(Keys.DELETE);
					materialPriceTxtSplitPopup.get(materialPriceTxtSplitPopup.size()-1).sendKeys("12.50");
					Select select = new Select(poTypeDropDwn_Other.get(poTypeDropDwn_Other.size()-1));
					select.selectByVisibleText(sType);
					if(Double.parseDouble(sPendingPoCount) > 0){
						materialQtyTxtSplitPopup.get(materialQtyTxtSplitPopup.size()-1).sendKeys(Keys.CONTROL+"a");
						materialQtyTxtSplitPopup.get(materialQtyTxtSplitPopup.size()-1).sendKeys(Keys.DELETE);
						if(sQtyToEntered.equals("Normal")){
							if(Double.parseDouble(sPendingPoCount) > 10){
								materialQtyTxtSplitPopup.get(materialQtyTxtSplitPopup.size()-1).sendKeys("10");
							}else{
								materialQtyTxtSplitPopup.get(materialQtyTxtSplitPopup.size()-1).sendKeys(sPendingPoCount);
							}
						}else{
							materialQtyTxtSplitPopup.get(materialQtyTxtSplitPopup.size()-1).sendKeys(sPendingPoCount);
						}
						splitSupplierBtn.click();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
			}
			indentPurchaseBtn.click();
			Constant.waitFor(ExpectedConditions.visibilityOf(okBtn), "Failed to load GRN edit page");
			Thread.sleep(Constant.Min_Sleep);
			sPODraftNo = purchaseCreatedPopup.getText().substring(0, 4);
			okBtn.click();
		}catch(Exception e){
			System.err.println("Failed to create po from indent po page "+e);
		}
		return sPODraftNo;
	}

	public boolean validateIndentEditPg_AfterPoCreated(){
		boolean flag = false;
		try{
			if(supplierBucketIndentQty.get(0).isDisplayed()){
				for(int i=0;i<supplierBucketIndentQty.size();i++){
					if(Double.parseDouble(supplierBucketPoQty.get(i).getText()) != 0){
						flag = true;
						break;
					}
				}
			}else{
				for(int i=0;i<otherBucketIndentQty.size();i++){
					if(Double.parseDouble(otherBucketPOQty.get(i).getText()) != 0){
						flag = true;
						break;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate indent edit page after po creation "+e);
		}
		return flag;
	}

	public boolean createPO_ExistingIndent(int iRowNo, String sheet){
		boolean flag = false, flag1;
		String sPODraftNo;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load PO view page");
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("arguments[0].scrollIntoView(true);",indentStatusList.get(indentNoList.size()-1));
			indentNoList.get(indentNoList.size()-1).click();
			Thread.sleep(Constant.Min_Sleep);
			sPODraftNo = createPO(iRowNo, sheet);
			flag1 = validateIndentEditPg_AfterPoCreated();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(driver.getPageSource().contains(sPODraftNo) && iActPONumber > iPONumber && flag1){
				flag = true;
			}

		}catch(Exception e){
			System.err.println("Failed to creat po from existing indent "+e);
		}
		return flag;
	}

	public boolean validateMaterialReturnedpopup_MatDelete(int iRowNo, String sheet){
		boolean flag = false;
		String sDeletedMaterial = null;
		try{
			addIssue(iRowNo, sheet);
			navigate.showAllEntries();
			int iRows = preparedOn.size();
			String sIssueNo = driver.findElement(By.xpath("//table[@id='invoice_list']/tbody/tr["+iRows+"]/td/a")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			addGRN(iRowNo, sheet, sIssueNo);
			int grnCount = grnList.size();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//tr["+grnCount+"]//td[4]")));
			String sGRNNo = driver.findElement(By.xpath("//tr["+grnCount+"]//td[4]")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(grnCount-1)).perform();
			grnList.get(grnCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				sDeletedMaterial  = deleteReturnedMatQty(0);
				UpdateBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
					Thread.sleep(Constant.Min_Sleep);
				}
				Constant.waitFor(ExpectedConditions.visibilityOf(okButton), "Failed to load GRN edit page");
				Thread.sleep(Constant.Min_Sleep);
				okButton.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			}
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]")));
			Thread.sleep(Constant.Min_Sleep);
			actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]"))).perform();
			actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			materialsReturnedBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(returnMaterialPopup.isDisplayed()){
				for (WebElement element : returnedMaterialGRNNoList) {
					if(element.getText().contains(sGRNNo)){
						String sMaterial = driver.findElement(By.xpath("//a[contains(text(),'"+sGRNNo+"')]/following::td[2]")).getText();
						if(!sMaterial.contains(sDeletedMaterial)){
							flag = true;
							break;
						}
					}
				}
				returnMaterialPopupClose.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to validate Material returned pop up after material delete in IR "+e);
		}
		return flag;
	}

	public boolean amendIR_AddingMat(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		int j = 0;
		try{
			addIssue(iRowNo, sheet);
			navigate.showAllEntries();
			int iRows = preparedOn.size();
			String sIssueNo = driver.findElement(By.xpath("//table[@id='invoice_list']/tbody/tr["+iRows+"]/td/a")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssueReturn();
			approveGRN(iRowNo, sheet, sIssueNo);
			int grnCount = grnList.size();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//tr["+grnCount+"]//td[4]")));
			String sGRNNo = driver.findElement(By.xpath("//tr["+grnCount+"]//td[4]")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(grnCount-1)).perform();
			grnList.get(grnCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				addReturnedQtyDetails(iRowNo, sheet,"Multiple");
				UpdateBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.isAlertPresents()){
					driver.switchTo().alert().accept();
					Thread.sleep(Constant.Min_Sleep);
				}
				Constant.waitFor(ExpectedConditions.visibilityOf(okButton), "Failed to load success poppu");
				Thread.sleep(Constant.Min_Sleep);
				okButton.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
				js.executeScript("window.scrollBy(0,-5000)");
				backBtn.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(filterText), "Failed to load GRN view page");
			}
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIssue();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]")));
			actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]"))).perform();
			actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+sIssueNo+"')]"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			materialsReturnedBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(returnMaterialPopup.isDisplayed()){
				for(int i=0;i<returnedMaterialGRNNoList.size();i++){
					if(returnedMaterialGRNNoList.get(i).getText().contains(sGRNNo)){
						j = i+1;
					}
				}
				int count = Constant.countRegexInString(",", sMaterial) + 1;
				if(count == j){
					flag = true;
				}
				returnMaterialPopupClose.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to validate Material returned popup after IR amend adding material "+e);
		}
		return flag;
	}

	public boolean verifyItemsInvoiced_Draft(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addGRN(iRowNo, sheet, null);
			flag = verifyItemsInvoiced();
		}catch(Exception e){
			System.err.println("Failed to validate items invoiced popup when grn in draft status"+e);
		}
		return flag;
	}

	public boolean verifyItemsInvoiced_Approved(int iRowNo, String sheet){
		boolean flag = false;
		try{
			approveGRN(iRowNo, sheet, null);
			flag = verifyItemsInvoiced();
		}catch(Exception e){
			System.err.println("Failed to validate items invoiced popup when grn in approved status"+e);
		}
		return flag;
	}

	public boolean verifyItemsInvoiced_DraftRejected(int iRowNo, String sheet){
		boolean flag = false;
		String sGRNNo = null, sDateRangeOption;
		try{
			addGRN(iRowNo, sheet, null);
			int iGRNCount = grnList.size();
			String sDraftNo = grnList.get(iGRNCount-1).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			if(grnDraft_EditPage.getText().contains(sDraftNo)){
				MaterialListPartyDcNo.get(0).click();
				sGRNNo = firstMaterialPONo.getText();
				sGRNNo = sGRNNo.substring(sGRNNo.lastIndexOf(":")+2);
				approveRejectBtn.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(rejectGRNBtn), "Failed to load GRN edit page");
				if(grnPDF.isDisplayed()){
					tRejectRemarks.sendKeys("Draft rejected automation"+sDate);
					rejectGRNBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					okButton.click();
				}
			}
			Constant.waitFor(ExpectedConditions.visibilityOf(filterText), "Failed to load GRN view page");
			if(Constant.currentFY().contains(sGRNNo.substring(0, 5))){
				sDateRangeOption = "Current Financial Year";
			}else{
				sDateRangeOption = "Last Financial Year";
			}
			btnFilter.click();
			dateCalendarDrpDown.click();
			driver.findElement(By.xpath("//li[contains(text(),'"+sDateRangeOption+"')]")).click();
			searchGRN.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(searchGRN), "Failed to load GRN view page");
			Constant.waitFor(ExpectedConditions.visibilityOf(filterText), "Failed to load GRN view page");
			filterText.sendKeys(sGRNNo);
			Thread.sleep(Constant.Min_Sleep);
			actions.moveToElement(driver.findElement(By.xpath("//mark[contains(text(),'"+sGRNNo+"')]"))).perform();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//mark[contains(text(),'"+sGRNNo+"')]")));
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				itemsInvoicedBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(itemsInvoicedMaterialPopup.isDisplayed()){
					Constant.waitFor(ExpectedConditions.elementToBeClickable(itemsInvoicedMaterialPopupClose), "Failed to load GRN edit page");
					if(Constant.driver.getPageSource().contains("No Records Found!")){
						flag = true;
					}else{
						Constant.waitFor(ExpectedConditions.visibilityOfAllElements(itemsInvoicedMaterialGRNNoList), "Failed to load GRN edit page");
						for(int i=0;i<itemsInvoicedMaterialGRNNoList.size();i++){
							if(!itemsInvoicedMaterialGRNNoList.get(i).getText().contains(sDraftNo)){
								if(i+1 == itemsInvoicedMaterialGRNNoList.size()){
									flag = true;
								}
							}
						}
					}
					itemsInvoicedMaterialPopupClose.click();
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate items invoiced popup when draft grn rejected"+e);
		}
		return flag;
	}

	public boolean verifyItemsInvoiced_ApprovedRejected(int iRowNo, String sheet){
		boolean flag = false;
		try{
			vaildateRejectApprovedGRN(iRowNo, sheet, null);
			flag = verifyItemsInvoiced_Rejected();
		}catch(Exception e){
			System.err.println("Failed to validate items invoiced popup when approved grn rejected"+e);
		}
		return flag;
	}

	public boolean verifyItemsInvoiced(){
		boolean flag = false;
		try{
			String[] options = searchDCGRN();
			if(grnDraft_EditPage.getText().contains(options[1])){
				itemsInvoicedBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(itemsInvoicedMaterialPopup.isDisplayed()){
					for (WebElement element : itemsInvoicedMaterialGRNNoList) {
						if(element.getText().contains(options[0])){
							flag = true;
						}
					}
					itemsInvoicedMaterialPopupClose.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate items invoiced popup"+e);
		}
		return flag;
	}

	public String[] searchDCGRN(){
		String sDateRangeOption, sGRNNo = null, sDraftNo = null;
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			int iGRNCount = grnList.size();
			jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='grnList']/tbody/tr["+iGRNCount+"]/td[text()='"+iGRNCount+".']")));
			Thread.sleep(Constant.Min_Sleep);
			sDraftNo = grnList.get(iGRNCount-1).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sDraftNo)){
				MaterialListPartyDcNo.get(0).click();
				sGRNNo = firstMaterialPONo.getText();
				sGRNNo = sGRNNo.substring(sGRNNo.lastIndexOf(":")+2);
				jse.executeScript("window.scrollBy(0,-5000)");
				backBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			}
			if(Constant.currentFY().contains(sGRNNo.substring(0, 5))){
				sDateRangeOption = "Current Financial Year";
			}else{
				sDateRangeOption = "Last Financial Year";
			}
			btnFilter.click();
			dateCalendarDrpDown.click();
			driver.findElement(By.xpath("//li[contains(text(),'"+sDateRangeOption+"')]")).click();
			searchGRN.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(searchGRN), "Failed to load GRN view page");
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			filterText.sendKeys(sGRNNo);
			actions.moveToElement(driver.findElement(By.xpath("//mark[contains(text(),'"+sGRNNo+"')]"))).perform();
			driver.findElement(By.xpath("//mark[contains(text(),'"+sGRNNo+"')]")).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
		}catch(Exception e){
			System.err.println("Failed to search DC grn"+e);
		}
		return new String[] {sDraftNo, sGRNNo};
	}

	public boolean verifyItemsInvoiced_Rejected(){
		boolean flag = false;
		try{
			String[] options = searchDCGRN();
			if(grnDraft_EditPage.getText().contains(options[1])){
				itemsInvoicedBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(itemsInvoicedMaterialPopup.isDisplayed()){
					Constant.waitFor(ExpectedConditions.elementToBeClickable(itemsInvoicedMaterialPopupClose), "Failed to load item invoiced popup");
					boolean flag1 = Constant.isElementPresent(By.xpath("//td[contains(text(),'No Records Found!')]"));
					if(flag1){
						flag = true;
					}else{
						Constant.waitFor(ExpectedConditions.visibilityOfAllElements(itemsInvoicedMaterialGRNNoList), "Failed to load GRN view page");
						for(int i=0;i<itemsInvoicedMaterialGRNNoList.size();i++){
							if(!itemsInvoicedMaterialGRNNoList.get(i).getText().contains(options[0])){
								if(i+1 == itemsInvoicedMaterialGRNNoList.size()){
									flag = true;
								}
							}
						}
					}
					itemsInvoicedMaterialPopupClose.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate items invoiced popup when grn with goods in rejected status"+e);
		}
		return flag;
	}

	public boolean verifyNotePreviewPopup(int iRowNo, String sheet){
		boolean flag = false, flag1 = false;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ArrayList<String> sTotal = new ArrayList<>();
		ArrayList<String> sNetCGST = new ArrayList<>();
		ArrayList<String> sNetSGST = new ArrayList<>();
		ArrayList<String> sNetIGST = new ArrayList<>();
		List<Double> arrayOfTotal = new ArrayList<>();
		List<Double> arrayOfCgst = new ArrayList<>();
		List<Double> arrayOfSGST = new ArrayList<>();
		List<Double> arrayOfIGST = new ArrayList<>();
		double sumTotal = 0,sumCGST = 0,sumSGST = 0,sumIGST = 0;
		try{
			addGRN(iRowNo, sheet, null);
			int iGRNCount = grnList.size();
			String sGRNNo = grnList.get(iGRNCount-1).getText();
			jse.executeScript("arguments[0].scrollIntoView(true);", grnList.get(iGRNCount-1));
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN view page");
			if(grnDraft_EditPage.getText().contains(sGRNNo)){
				notePreviewBTn.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[contains(text(),'Note Preview')]"))), "Failed to load note preview popup");
				for(int i=0;i<notePreviewQtyList.size();i++){
					String sQty = notePreviewQtyList.get(i).getText();
					String[] sRate = notePreviewRateList.get(i).getText().split("/");
					String[] sAmt = notePreviewAmtList.get(i).getText().split("\\s+");
					String[] sCGST = notePreviewCGSTList.get(i).getText().split("\\s+");
					String[] sSGST = notePreviewSGSTList.get(i).getText().split("\\s+");
					String[] sIGST = notePreviewIGSTList.get(i).getText().split("\\s+");
					String sPerCGST = sCGST[1].trim().substring(1, sCGST[1].length()-1);
					String sPerSGST = sSGST[1].trim().substring(1, sSGST[1].length()-1);
					String sPerIGST = sIGST[1].trim().substring(1, sIGST[1].length()-1);
					Double sActAmt = Double.parseDouble(sQty) * Double.parseDouble(sRate[0]);
					sActAmt = Math.round(sActAmt * 100.0) / 100.0;
					sTotal.add(Double.toString(sActAmt));
					Double sCGSTAmt = (Double.parseDouble(sPerCGST) * Double.parseDouble(sAmt[0]))/100;
					sCGSTAmt = Math.round(sCGSTAmt * 100.0) / 100.0;
					sNetCGST.add(Double.toString(sCGSTAmt));
					Double sSGSTAmt = (Double.parseDouble(sPerSGST) * Double.parseDouble(sAmt[0]))/100;
					sSGSTAmt = Math.round(sSGSTAmt * 100.0) / 100.0;
					sNetSGST.add(Double.toString(sSGSTAmt));
					Double sIGSTAmt = (Double.parseDouble(sPerIGST) * Double.parseDouble(sAmt[0]))/100;
					sIGSTAmt = Math.round(sIGSTAmt * 100.0) / 100.0;
					sNetIGST.add(Double.toString(sIGSTAmt));
					arrayOfTotal.add(Double.parseDouble(sTotal.get(i)));
					arrayOfCgst.add(Double.parseDouble(sNetCGST.get(i)));
					arrayOfSGST.add(Double.parseDouble(sNetSGST.get(i)));
					arrayOfIGST.add(Double.parseDouble(sNetIGST.get(i)));
					sumTotal += arrayOfTotal.get(i);
					sumCGST += arrayOfCgst.get(i);
					sumSGST += arrayOfSGST.get(i);
					sumIGST += arrayOfIGST.get(i);
					if(sAmt[0].contains(Double.toString(sActAmt)) && sCGST[0].contains(Double.toString(sCGSTAmt)) && sSGST[0].contains(Double.toString(sSGSTAmt)) && sIGST[0].contains(Double.toString(sIGSTAmt))){
						flag1 = true;
					}
				}
				if(flag1){
					Double dActnoteValue = sumTotal + sumCGST + sumSGST + sumIGST;
					String[] sNoteValue = noteValue.getText().split("\\s+");
					dActnoteValue = Math.round(dActnoteValue * 100.0) / 100.0;
					if(sNoteValue[0].contains(Double.toString(dActnoteValue))){
						flag = true;
					}

				}
				closePreviewBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to validate items invoiced popup when grn with goods in rejected status"+e);
		}
		return flag;
	}

	public boolean validateDCDropDwn(int iRowNo, String sheet, String sInvoice){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sParty = xls.get(iRowNo).get("Party");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRN();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			btnFilter.click();
			Select selectReceivedView = new Select(receivedAgainstDropDwnViewtab);
			selectReceivedView.selectByValue(sReceivedAgainst);
			searchGRN.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(searchGRN), "Failed to load GRN view page");
			addGRNBtn.click();
			Thread.sleep(Constant.Medium_Sleep);
			Select selectReceived = new Select(receivedAgainstDropDwn);
			selectReceived.selectByValue(sReceivedAgainst);
			selectParty.click();
			searchParty.sendKeys(sParty);
			driver.findElement(By.xpath(".//li[text()='All']/following::li/em[text()='"+sParty.trim()+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			purchaseOrderDropDwn.click();
			boolean flag1 = Constant.isElementPresent(By.xpath(".//input[@placeholder='Search']"));
			if(flag1){
				searchTxtPurchaseDrpDwn.sendKeys(sInvoice);
				Thread.sleep(Constant.Min_Sleep);
			}
			if(!Constant.isElementPresent(By.xpath("//label[contains(text(),'"+sInvoice+"')]"))){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to validate grn dc drop down "+e);
		}
		return flag;
	}

	public boolean vaildateMaterialUsage(int iRowNo, String sheet, String sDcNO){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sReceivedAgainst = xls.get(iRowNo).get("Received Against");
		String sMaterial = xls.get(iRowNo).get("Material");
		String[] sMaterialList = sMaterial.split("-");
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToGRN();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load GRN view page");
			btnFilter.click();
			Select selectReceivedView = new Select(receivedAgainstDropDwnViewtab);
			selectReceivedView.selectByValue(sReceivedAgainst);
			navigate.showAllEntries();
			int iGRNCount = grnList.size();
			String sDraftNo = grnList.get(iGRNCount-1).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(grnList.get(iGRNCount-1)).perform();
			grnList.get(iGRNCount-1).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(grnMaterialTable), "Failed to load GRN edit page");
			if(grnDraft_EditPage.getText().contains(sDraftNo)){
				materialUsageBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(materialUsagePopup.isDisplayed()){
					Constant.waitFor(ExpectedConditions.elementToBeClickable(materialUsageClose), "Failed to load material usage popup");
					if(Constant.driver.getPageSource().contains("No Records Found!")){
						flag = false;
					}else{
						Constant.waitFor(ExpectedConditions.visibilityOfAllElements(materialUsageMaterils), "Failed to load GRN edit page");
						for (WebElement materialUsageMateril : materialUsageMaterils) {
							if(materialUsageMateril.getText().contains(sMaterialList[0].trim())){
								flag = true;
							}
						}
					}
					materialUsageClose.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate DC report "+e);
		}
		return flag;
	}

	public boolean validateDCReport(String sDCNo){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load report");
			filterText.sendKeys(sDCNo);
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath("//mark[text()='"+sDCNo+"']")).isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to validate DC report "+e);
		}
		return flag;
	}



}
