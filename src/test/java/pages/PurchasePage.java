package pages;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

public class PurchasePage {

	ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	ProfilePage master = PageFactory.initElements(Constant.driver, ProfilePage.class);
	StorePage store = PageFactory.initElements(Constant.driver, StorePage.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);

	@FindBy(xpath=".//*[@data-original-title='Create New P.O.']") WebElement addPOBtn;

	@FindBy(xpath="//span[contains(@class,'btn-new-item-label quick_po')]") WebElement addQuickPOBtn;

	@FindBy(id="po_list_info")
	public WebElement poVisibleRecordCount;

	@FindBy(xpath=".//span[@class='page_header']/span")
	private WebElement amendCountPoEditpage;

	@FindBy(xpath=".//p[text()='This PO has already been revised 5 times. No further Amendment allowed!!']")
	private WebElement amendedMaxWarning;

	@FindBy(id="btn-sa-confirm")
	private WebElement okBtn;

	@FindBy(xpath=".//small[text()='(Use As-Is)']/parent::span")
	private WebElement useAsIsOption;

	@FindBy(xpath="//th[contains(text(),'S. No')]")
	private WebElement poSNOColumn;

	@FindBy(xpath="//span[contains(text(),'Purchase Order')]")
	private WebElement poAddPage;

	@FindBy(xpath=".//*[@id='indents_chosen']/a/span")
	private WebElement indentDropDwn;

	@FindBy(xpath=".//input[@id='generate_pdf'] [@value='Approve / Reject']")
	private WebElement approveRejectBtn;

	@FindBy(id="indent_type")
	private WebElement indentTypeDropDwn;

	@FindBy(xpath=".//label[text()='Non Stockable']")
	private WebElement nonStockableChkBx;

	@FindBy(xpath="//*[@id='projectheader_chosen']")
	private WebElement projectDropDwn;

	@FindBy(xpath="//div[@id='projectheader_chosen']//input[@class='chosen-search-input']")
	private WebElement projectSearchText;

	@FindBy(id="purpose")
	private WebElement purposeTxtField;

	@FindBy(xpath=".//*[@id='indents_chosen']/div/ul/li")
	private List<WebElement> indentNoList;

	@FindBy(xpath=".//label[@for='txttransport']")
	private WebElement transportCheckBox;

	@FindBy(xpath=".//label[@for='txtpacking']")
	private WebElement packingForwardingCheckBox;

	@FindBy(xpath="//label[contains(text(),'Blanket/Open PO')]")
	private WebElement blanketPOChkBx;

	@FindBy(id="reportrange")
	private WebElement blanketpoDateRange;

	@FindBy(xpath=".//*[@id='supplier_chosen']/a/span")
	private WebElement supplierField;

	@FindBy(xpath=".//*[@id='supplier_chosen']/div/ul/li")
	private List<WebElement> supplierList;

	@FindBy(xpath=".//tr[contains(@id,'ind_material')]/td[4]/div")
	private List<WebElement> actMaterialCount;

	@FindBy(id="instructions")
	private WebElement poInstructions;

	@FindBy(id="id_po-remarks")
	private WebElement poRemarks;

	@FindBy(xpath=".//*[@id='po_materials_table']/tbody/tr/td[@class='text-left']")
	private List<WebElement> poMaterialList;

	@FindBy(xpath=".//*[@id='po_materials_table']/tbody/tr/td[4]")
	private List<WebElement> poMaterialCountList;

	@FindBy(xpath=".//ul/li[text()='Others']/following::li[1]")
	private WebElement poFirstSupplier;

	@FindBy(id="cmdSave") WebElement addPO;

	@FindBy(id="cmdSaveApprove") WebElement approvePO;

	@FindBy(xpath=".//*[@id='po_materials_table']/tbody/tr/td[5]")
	private List<WebElement> poOrderedCountList;

	@FindBy(xpath=".//*[@id='po_materials_table']/tbody/tr/td[5]/span[2]")
	private List<WebElement> poBalanceCountList;

	@FindBy(xpath=".//*[contains(@id,'txtpurqty')]")
	private List<WebElement> poCountList;

	@FindBy(xpath=".//*[contains(@id,'txtpurprice')]")
	private List<WebElement> poPriceList;

	@FindBy(xpath=".//*[contains(@id,'txtdiscount')]")
	private List<WebElement> poDiscountList;

	@FindBy(xpath=".//*[contains(@id,'txtunitrate')]")
	private List<WebElement> poUnitRateList;

	@FindBy(xpath=".//*[contains(@id,'txtpurvalue')]")
	private List<WebElement> poValueList;

	@FindBy(xpath=".//span[text()=' -NA- ']")
	private WebElement taxDropDwn;

	@FindBy(xpath=".//*[@id='id_po_tax_chosen']/div/div/input")
	private WebElement taxSearchField;

	@FindBy(id="add_po_tax")
	private WebElement addTaxBtn;

	@FindBy(xpath=".//h4[contains(text(),'Order Quantity specified ')]")
	private WebElement orderQtySpecWarning;

	@FindBy(id="cmdreview")
	private WebElement submitForApprovalBtn;

	@FindBy(id="total_price")
	private WebElement totalPoPrice;

	@FindBy(id="cgst_total")
	private WebElement cgstPoPrice;

	@FindBy(id="sgst_total")
	private WebElement sgstPoPrice;

	@FindBy(id="igst_total")
	private WebElement igstPoPrice;

	@FindBy(xpath=".//*[@id='po_taxes_table']/tbody/tr/td[3]/input")
	private List<WebElement> poAddedTaxList;

	@FindBy(id="txttotalpurvalue")
	private WebElement grandTotalField;

	@FindBy(xpath=".//a[@title='Remove Tax']/i")
	private WebElement deleteTax;

	@FindBy(id="cmdupdate") WebElement update;

	@FindBy(id="approve_po_doc")
	private WebElement approveBtn;

	@FindBy(xpath="//div[@id='po_document_modal']//button[@class='close'][contains(text(),'�')]")
	private WebElement closeBtn_PDF;

	@FindBy(xpath="//div[@id='chooseIndent']//button[@class='close'][contains(text(),'�')]")
	private WebElement closeBtn_ChooseIndent;

	@FindBy(xpath=".//h2[text()='Successfully Rejected']")
	private WebElement rejectedSuccessPopup;

	@FindBy(xpath="//h2[contains(text(),'Review Successfully')]")
	private WebElement reviewedSuccessPopup;

	@FindBy(xpath="//button[text()='Yes, discard it!']")
	private WebElement bYesDiscard;

	@FindBy(xpath=".//h2[text()='Removed Successfully']")
	private WebElement removedSuccessPopup;

	@FindBy(id="reject_po")
	private WebElement rejectBtn;

	@FindBy(id="review_po")
	private WebElement reviewBtn;

	@FindBy(id="po_remarks")
	private WebElement remarksTxtField;

	@FindBy(id="amend_po") WebElement amendBtn;

	@FindBy(xpath="//table[@id='po_materials_table']/tbody/tr")
	private WebElement poMaterials;

	@FindBy(xpath="//h4[contains(text(),'Preview Document')]")
	private WebElement poPDFPopUp;

	@FindBy(xpath="//span[@class='header_current_page']")
	private WebElement poNo_EditPage;

	@FindBy(xpath=".//button[contains(@class,'btn-filter')]")
	private WebElement filterBtn;

	@FindBy(id="refresh") WebElement viewReportBtn;

	@FindBy(xpath=".//div[contains(@class,'scrollHeadInner')]//thead//th")
	private List<WebElement> poReportscolumn; //po and material wise report

	@FindBy(xpath="//a[contains(@class,'create_indent_po')]/span") WebElement createIndentPoBtn;

	@FindBy(xpath="//div[@id='indent_po_filter']//input[@id='filter_textbox']")
	private WebElement filterSearchIndentList;

	@FindBy(xpath="//td[text()='No matching records found']")
	private WebElement noMatchingRecords;

	@FindBy(xpath=".//*[@id='po_list']/tbody/tr[1]/td[2]/a") WebElement firstPo;

	@FindBy(xpath=".//div/a[text()='Job Order']")
	private WebElement jobPOToggleBtn;

	@FindBy(xpath=".//div/a[text()='Purchase Order']")
	private WebElement poToggleBtn;

	@FindBy(id="materialrequiredjob")
	private WebElement materialNameTxt;

	@FindBy(id="id_material-alternate_units")
	private WebElement altUnitDrpDwn;

	@FindBy(xpath="//select[@id='id_material-alternate_units']/option[2]")
	private WebElement altUnitOption;

	@FindBy(id="job_qty")
	private WebElement jobQtyTxt;

	@FindBy(id="id_material-all_units")
	private WebElement jobUnitDrpDwn;

	@FindBy(id="job_price")
	private WebElement jobPriceTxt;

	@FindBy(id="job_discount")
	private WebElement jobDiscountTxt;

	@FindBy(id="addmaterials")
	private WebElement jobAddMaterialBtn;

	@FindBy(xpath="//h4[contains(text(),'Order Quantity specified ')]")
	private WebElement poSPQPopup;

	@FindBy(xpath="//table[@id='po_materials_table']/tbody/tr/td[2]")
	private List<WebElement> QuickPoMaterialList;

	@FindBy(id="other_particulars")
	private WebElement othersTab;

	@FindBy(xpath=".//*[@id='supplier_chosen']//input")
	private WebElement supplierSearchTxtField;

	@FindBy(id="filter_textbox")
	private WebElement filterText;

	@FindBy(xpath=".//span[contains(@class,'filtered-date')]/b")
	private WebElement dateFilter;

	@FindBy(xpath=".//span[text()='Click here']")
	private WebElement clickHereLnk;

	@FindBy(id="refno")
	private WebElement quotationRefNo;

	@FindBy(id="po_quot_date")
	private WebElement quotationRefDate;

	@FindBy(id="po_delivery_date")
	private WebElement deliveryDueDate;

	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='prev'][contains(text(),'�')]")
	private WebElement previousQuotationMnth;

	@FindBy(xpath="//td[@class='day'][contains(text(),'18')]")
	private WebElement QuotationDate;

	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='next'][contains(text(),'�')]")
	private WebElement nextDeliveryMnth;

	@FindBy(xpath="//div[@class='datepicker-days']/table/tbody/tr/td[contains(text(),'22')]")
	private WebElement DeliveryDate;

	String sDate = Constant.DateTimeFormat();
	String sCurrentDate = Constant.currentDate();

	public WebDriver driver;
	public PurchasePage(WebDriver driver){
		this.driver = driver;
	}

	public void addPODetails(){
		try{
			transportCheckBox.click();
			packingForwardingCheckBox.click();
			deliveryDueDate.click();
			nextDeliveryMnth.click();
			DeliveryDate.click();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(Constant.Min_Sleep);
			quotationRefNo.sendKeys(sDate);
			quotationRefDate.click();
			previousQuotationMnth.click();
			QuotationDate.click();
			poRemarks.sendKeys("Automation Remark"+sDate);
			poInstructions.sendKeys("Test quick po automation "+sDate);
		}catch(Exception e){
			System.err.println("Failed to add po details "+e);
		}
	}

	public boolean addPurchase_Indent(int iRowNo, String sheet, int iPONumber){
		boolean flag = false, flag1 = false, flag2 = false, flag3 = false, flag4 = false;
		int j;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(indentDropDwn), "Failed to load PO add page");
			sCurrentDate = Constant.CorrectedDate();
			indentDropDwn.click();
			Thread.sleep(Constant.Min_Sleep);
			for(int i=1;i<indentNoList.size();i++){
				indentNoList.get(i).click();
				Thread.sleep(Constant.Medium_Sleep);
				supplierField.click();
				Thread.sleep(Constant.Min_Sleep);
				if((supplierList.size() > 2)){
					poFirstSupplier.click();
					Constant.waitForPageLoad();
					break;
				}
				indentDropDwn.click();
				continue;
			}
			String sIndentNo = indentDropDwn.getText().substring(10);
			String sSupplier = supplierField.getText();
			String[] sSupplierSplit = sSupplier.split("\\(");
			Thread.sleep(Constant.Medium_Sleep);
			addPODetails();
			jse.executeScript("window.scrollBy(0,-5000)", "");
			if(clickHereLnk.isDisplayed()){
				clickHereLnk.click();
			}
			for(j=0;j<poPriceList.size();j++){
				if(!poBalanceCountList.get(j).getText().equals("0.000")){
					break;
				}
			}
			flag1 = fillPOMaterialDetails(j,iRowNo,sheet);
			flag2 = vaidateGST(j, iRowNo,sheet);
			flag4 = TaxAddition(iRowNo,sheet);
			flag3 = validateGrandTotalValue();
			if(flag1 && flag2 && flag3 && flag4){
				String sGrandTotal = grandTotalField.getAttribute("value");
				Thread.sleep(Constant.Min_Sleep);
				addPO.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load PO view page");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Constant.waitForPageLoad();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+(iPONumber+1)+"]/td[1]")));
				WebElement ele = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+(iPONumber+1)+"]/td[1]/following::td[2][text()='"+sCurrentDate+"']/following::td[2][text()='-']/following::td[contains(text(),'"+sSupplierSplit[0].trim()+"')]/following::td[text()='"+sGrandTotal+"']/following::td[2][contains(text(),'"+sIndentNo+"')]/following::td[2]/a[1][contains(text(),'Draft')]"));
				if(ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Purchase addition failed "+e);
		}
		return flag;
	}

	/**
	 * To add new purchase order by selecting last indent form the drop down
	 * @return
	 */

	public boolean addPurchase(int iRowNo, String sheet){
		boolean flag = false, flag2 = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load PO view page");
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			addPOBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(poToggleBtn), "Failed to load PO add page");
			if(indentDropDwn.isDisplayed()){
				poToggleBtn.click();
				Thread.sleep(Constant.Max_Sleep);
				flag2 = addPurchase_Indent(iRowNo, sheet,iPONumber);
			}
			if(flag2){
				int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
				if(iActPONumber > iPONumber){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Purchase order creation failed "+e);
		}
		return flag;
	}

	public boolean fillPOMaterialDetails(int j, int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sPrice = xls.get(iRowNo).get("Price");
		String sDiscount = xls.get(iRowNo).get("Discount");
		String sActPrice, sUnitPrice;
		Double value = null;Double unitprice = null;Double poCount;Double dUnitPrice = null;
		try{
			if(!indentDropDwn.getText().contains("Select an Indent")){
				value = Double.parseDouble(poBalanceCountList.get(j).getText());
				if(value > 100){
					poCountList.get(j).sendKeys(Keys.CONTROL+"a");
					poCountList.get(j).sendKeys(Keys.DELETE);
					value = 100.00;
					poCountList.get(j).sendKeys("100");
				}else if(value <= 100 && value > 0){
					poCountList.get(j).sendKeys(Keys.CONTROL+"a");
					poCountList.get(j).sendKeys(Keys.DELETE);
					poCountList.get(j).sendKeys(Double.toString(value));
				}
			}else{
				poCountList.get(j).sendKeys(Keys.CONTROL+"a");
				poCountList.get(j).sendKeys(Keys.DELETE);
				poCountList.get(j).sendKeys("100");
			}
			poCount = Double.parseDouble(poCountList.get(j).getAttribute("value"));
			poPriceList.get(j).click();
			Thread.sleep(Constant.Min_Sleep);
			boolean flag1 = Constant.isElementPresent(By.xpath(".//small[text()='(Use As-Is)']/parent::span"));
			if(flag1){
				useAsIsOption.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			if(driver.getPageSource().contains("Do you want to Reset?")){
				okBtn.click();
			}
			if(poPriceList.get(j).getAttribute("value").equals("0") || poPriceList.get(j).getAttribute("value").equals("0.0")){
				poPriceList.get(j).sendKeys(Keys.CONTROL+"a");
				poPriceList.get(j).sendKeys(Keys.DELETE);
				poPriceList.get(j).sendKeys(sPrice);
			}
			sActPrice = poPriceList.get(j).getAttribute("value");
			poDiscountList.get(j).sendKeys(Keys.CONTROL+"a");
			poDiscountList.get(j).sendKeys(Keys.DELETE);
			poDiscountList.get(j).sendKeys(sDiscount);
			Thread.sleep(Constant.Min_Sleep);
			poPriceList.get(j).click();
			sUnitPrice = poUnitRateList.get(j).getAttribute("value");
			Double Value = Double.parseDouble(sActPrice)-((Double.parseDouble(sActPrice) * (Double.parseDouble(sDiscount))) / 100);
			String sCalUnit = Double.toString(Value);
			dUnitPrice = Math.round(Value * 100.0) / 100.0;
			unitprice = roundOffValue(sCalUnit, Value, unitprice);
			if(Double.parseDouble(sUnitPrice) == unitprice || Double.parseDouble(sUnitPrice) == dUnitPrice){
				String sActPOValue = poValueList.get(j).getAttribute("value");
				Double d = poCount * Value;
				double actValue = Math.round(d * 100.0) / 100.0;
				unitprice = roundOffValue(sActPOValue, d, unitprice);
				if(actValue == Double.parseDouble(sActPOValue) || unitprice == Double.parseDouble(sActPOValue)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to fill po material details "+e);
		}
		return flag;
	}

	public Double roundOffValue(String sCalUnit, Double Value, Double unitprice){
		if(sCalUnit.contains(".")){
			String[] sListCalUnit = sCalUnit.split("\\.");
			if(sListCalUnit[1].length() > 2){
				if(sListCalUnit[1].substring(2, 3).equals("5")){
					String sUnit = sListCalUnit[0]+"."+sListCalUnit[1].substring(0, 2);
					unitprice = Double.parseDouble(sUnit);
				}else{
					unitprice = Math.round(Value * 100.0) / 100.0;
				}
			}else{
				unitprice = Math.round(Value * 100.0) / 100.0;
			}
		}else{
			unitprice = Math.round(Value * 100.0) / 100.0;
		}
		return unitprice;
	}

	public boolean vaidateGST(int i, int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCGST = xls.get(iRowNo).get("CGST");
		String sSGST = xls.get(iRowNo).get("SGST");
		String sIGST = xls.get(iRowNo).get("IGST");
		try{
			driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/select[contains(@id,'txtcgst')]/option[@value='"+sCGST+"']")).click();
			String sCgst = driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/select[contains(@id,'txtcgst')]/option[@value='"+sCGST+"']")).getText();
			driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/select[contains(@id,'txtsgst')]/option[@value='"+sSGST+"']")).click();
			String sSgst = driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/select[contains(@id,'txtsgst')]/option[@value='"+sSGST+"']")).getText();
			driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/select[contains(@id,'txtigst')]/option[@value='"+sIGST+"']")).click();
			String sIgst = driver.findElement(By.xpath(".//tr["+(i+1)+"]/td/select[contains(@id,'txtigst')]/option[@value='"+sIGST+"']")).getText();
			String sAmount = poValueList.get(i).getAttribute("value");
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
		}catch(Exception e){
			System.err.println("GST validation failed "+e);
		}
		return flag;
	}

	public boolean validateGrandTotalValue(){
		boolean flag = false;
		ArrayList<String> tax = new ArrayList<>();
		List<Double> arrayOfInts = new ArrayList<>();
		double sum = 0;
		try{
			String sTotal = totalPoPrice.getText();
			String sNetCGST = cgstPoPrice.getText();
			String sNetSGST = sgstPoPrice.getText();
			String sNetIGST = igstPoPrice.getText();
			for (WebElement element : poAddedTaxList) {
				tax.add(element.getAttribute("value"));
			}
			for(Object str : tax) {
			   arrayOfInts.add(Double.parseDouble((String)str));
			}
			for (Double arrayOfInt : arrayOfInts) {
			   sum += arrayOfInt;
			}
			if(sNetCGST.isEmpty()){
				sNetCGST = "0";
			}
			if(sNetSGST.isEmpty()){
				sNetSGST = "0";
			}
			if(sNetIGST.isEmpty()){
				sNetIGST = "0";
			}
			String sGrandTotal = grandTotalField.getAttribute("value");
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

	public boolean updatePO(int iRowNo, String sheet,int iPoNum){
		boolean flag = false,flag1,flag2,flag3,flag4,flag5;
		try{
			if(indentDropDwn.isDisplayed()){
				Constant.waitFor(ExpectedConditions.elementToBeClickable(approveRejectBtn), "Failed to load PO edit page");
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,-2500)", "");
				Thread.sleep(Constant.Min_Sleep);
				deliveryDueDate.click();
				nextDeliveryMnth.click();
				DeliveryDate.click();
				Thread.sleep(Constant.Min_Sleep);
				flag1 = fillPOMaterialDetails(0,iRowNo,sheet);
				flag2 = vaidateGST(0,iRowNo,sheet);
				Thread.sleep(Constant.Min_Sleep);
				transportCheckBox.click();
				packingForwardingCheckBox.click();
				quotationRefNo.clear();
				quotationRefNo.sendKeys(sDate);
				Thread.sleep(Constant.Min_Sleep);
				quotationRefDate.click();
				previousQuotationMnth.click();
				QuotationDate.click();
				if(driver.getPageSource().contains("Net Rate")){
					deleteTax.click();
				}
				flag4 = TaxAddition(iRowNo,sheet);
				flag3 = validateGrandTotalValue();
				if(flag1 && flag2 && flag3 && flag4){
					Thread.sleep(Constant.Min_Sleep);
					String sGrandTotal = grandTotalField.getAttribute("value");
					Thread.sleep(Constant.Min_Sleep);
					update.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
					Thread.sleep(Constant.Min_Sleep);
					okBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load PO view page");
					Thread.sleep(Constant.Min_Sleep);
					flag5 = navigate.showAllEntries();
					if(flag5){
						jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[7]")));
						String sActTotal = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[7]")).getText();
						if(sGrandTotal.contains(sActTotal)){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("update po failed "+e);
		}
		return flag;
	}

	public boolean validateUpdatePO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addPurchase(iRowNo,sheet);
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]//span[2]/i")).click();
			Constant.waitForPageLoad();
			Thread.sleep(Constant.Min_Sleep);
			flag = updatePO(iRowNo,sheet,iPoNum);
		}catch(Exception e){
			System.err.println("Purchase order update failed "+e);
		}
		return flag;
	}

	public boolean approvePO(){
		boolean flag = false,flag2;
		try{
 			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+(iPoNum)+"]/td[1]")));
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[1]/i"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[1]/i")).click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(approveBtn), "Failed to load PO pdf");
			Thread.sleep(Constant.Min_Sleep);
			if(poPDFPopUp.isDisplayed()){
				approveBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				Constant.waitFor(ExpectedConditions.visibilityOf(okBtn), "Failed to load success popup");
				okBtn.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				closeBtn_PDF.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load PO view page");
				Thread.sleep(Constant.Min_Sleep);
				flag2 = navigate.showAllEntries();
				if(flag2){
					jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[1]")));
					String sActStatus = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/a[1]")).getText();
					String sPONum = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")).getText();
					if(sActStatus.equals("Approved") && sPONum.contains("PO") || sPONum.contains("JO")){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("PO approve failed "+e);
		}
		return flag;
	}

	public boolean validateApprovePO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addPurchase(iRowNo,sheet);
			flag = approvePO();
		}catch(Exception e){
			System.err.println("PO approve failed "+e);
		}
		return flag;
	}

	public boolean rejectApprovedPO(){
		boolean flag = false,flag2;
		try{
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+(iPoNum)+"]/td[1]")));
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[1]/i"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[1]/i")).click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(rejectBtn), "Failed to load PO pdf");
			Thread.sleep(Constant.Min_Sleep);
			if(poPDFPopUp.isDisplayed()){
				remarksTxtField.sendKeys("Test"+sDate);
				rejectBtn.click();
				Constant.waitFor(ExpectedConditions.visibilityOf(okBtn), "Failed to load success pop up");
				Thread.sleep(Constant.Min_Sleep);
				if(rejectedSuccessPopup.isDisplayed()){
					okBtn.sendKeys(Keys.ENTER);
					Thread.sleep(Constant.Min_Sleep);
					closeBtn_PDF.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load PO view page");
					Thread.sleep(Constant.Min_Sleep);
					flag2 = navigate.showAllEntries();
					if(flag2){
						jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[1]")));
						String sActStatus = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/a[1]")).getText();
						String sPONum = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")).getText();
						if(sActStatus.equals("Rejected") && sPONum.contains("PO") || sPONum.contains("JO")){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Reject approved PO failed "+e);
		}
		return flag;
	}

	public boolean validateRejectApprovedPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			validateApprovePO(iRowNo,sheet);
			flag = rejectApprovedPO();
		}catch(Exception e){
			System.err.println("Failed to reject approved PO "+e);
		}
		return flag;
	}

	public boolean rejectDraftPO(){
		boolean flag = false,flag1;
		try{
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[1]")));
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[1]/i"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[1]/i")).click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(rejectBtn), "Failed to load PO pdf");
			Thread.sleep(Constant.Min_Sleep);
			if(poPDFPopUp.isDisplayed()){
				remarksTxtField.sendKeys("Test"+sDate);
				rejectBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(bYesDiscard), "Failed to load PO pdf");
				Thread.sleep(Constant.Min_Sleep);
				bYesDiscard.sendKeys(Keys.ENTER);
				Constant.waitFor(ExpectedConditions.visibilityOf(removedSuccessPopup), "Failed to load PO pdf");
				Thread.sleep(Constant.Min_Sleep);
				if(removedSuccessPopup.isDisplayed()){
					okBtn.sendKeys(Keys.ENTER);
					Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load PO view page");
					Thread.sleep(Constant.Min_Sleep);
					flag1 = navigate.showAllEntries();
					if(flag1){
						int iActPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
						if(iActPoNum < iPoNum){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to reject draft PO "+e);
		}
		return flag;
	}

	public boolean validateRejectDraftPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addPurchase(iRowNo,sheet);
			flag = rejectDraftPO();
		}catch(Exception e){
			System.err.println("Failed to reject draft PO "+e);
		}
		return flag;
	}

	public boolean amendPO(int iPoNum, int iRowNo, String sheet){
		boolean flag = false, flag1, flag2, flag3, flag4;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(poMaterials), "Failed to load PO edit page");
			Thread.sleep(Constant.Max_Sleep);//dynamic loading of po edit page
			if(driver.getPageSource().contains("Net Rate")){
				deleteTax.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			transportCheckBox.click();
			packingForwardingCheckBox.click();
			flag2 = fillPOMaterialDetails(0,iRowNo,sheet);
			flag3 = vaidateGST(0, iRowNo,sheet);
			flag4 = TaxAddition(iRowNo,sheet);
			String sGrandTotal = grandTotalField.getAttribute("value");
			Thread.sleep(Constant.Min_Sleep);
			amendBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(closeBtn_PDF), "Failed to load PO pdf popup");
			Thread.sleep(Constant.Min_Sleep);
//			if(Constant.isAlertPresents() == true){
//				driver.switchTo().alert().accept();
//			}
//			Thread.sleep(Constant.Max_Sleep);
			closeBtn_PDF.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load PO view page");
			Thread.sleep(Constant.Min_Sleep);
			flag1 = navigate.showAllEntries();
			if(flag1 && flag2 && flag3 && flag4){
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[1]")));
				String sActTotal = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[7]")).getText();
				String sActStatus = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/a[1]")).getText();
				if(sGrandTotal.contains(sActTotal) && sActStatus.equals("Approved")){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to amend PO "+e);
		}
		return flag;
	}

	public boolean validateAmendPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			validateRejectApprovedPO(iRowNo,sheet);
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			Thread.sleep(Constant.Min_Sleep);
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[2]/i"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[2]/i")).click();
			flag = amendPO(iPoNum, iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Failed to amend PO "+e);
		}
		return flag;
	}

	public boolean nonEditableFields(){
		boolean flag = false, flag1 = false, flag2 = false;
		try{
			addPOBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(indentDropDwn.isDisplayed()){
				if(!indentTypeDropDwn.isEnabled() && !projectDropDwn.isEnabled() && !purposeTxtField.isEnabled() && !grandTotalField.isEnabled()){
					flag1 = true;
				}
				nonStockableChkBx.click();
				if(!indentDropDwn.isEnabled() && !grandTotalField.isEnabled()){
					flag2 = true;
				}
				if(flag1 && flag2){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Non editable field validation failed "+e);
		}
		return flag;
	}

	public boolean validateDataFromIndent(){
		boolean flag = false;
		String sMaterial, sIndentRemarks,sInstructions = null;
		String[] sMaterialList;
		ArrayList<String> sActMaterials = new ArrayList<>();
		ArrayList<String> sActMaterialCount = new ArrayList<>();
		ArrayList<String> sPOMaterials = new ArrayList<>();
		ArrayList<String> sPOMaterialCount = new ArrayList<>();
		try{
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			int iIndentList = store.indentList.size();
			driver.findElement(By.xpath(".//*[@id='issue_table_list_tbody']/tr["+iIndentList+"]/td[2]/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			//get indent material list
			for(int j=1;j<store.addedMaterials.size();j++){
				sMaterial = store.addedMaterials.get(j).getText();
				sActMaterials.add(sMaterial);
			}
			for(int i=1;i<actMaterialCount.size();i++){
				sMaterial = actMaterialCount.get(i).getText();
				sMaterialList = sMaterial.split("\\.");
				if(sMaterialList[1].equals("000")){
					sActMaterialCount.add(sMaterialList[0]);
				}else{
					sActMaterialCount.add(sMaterial);
				}
			}
			sIndentRemarks = store.indentRemark.getText();
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			addPOBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(indentDropDwn.isDisplayed()){
				Select indent = new Select(indentDropDwn);
				int options = indent.getOptions().size();
				indent.selectByIndex(options-1);
				Thread.sleep(Constant.Min_Sleep);
				sInstructions = poInstructions.getAttribute("value");
				for (WebElement element : poMaterialList) {
					sMaterial = element.getText();
					sPOMaterials.add(sMaterial);
				}
				for(int j=0;j<poMaterialCountList.size();j++){
					sMaterial = poMaterialCountList.get(j).getText();
					sPOMaterialCount.add(sMaterial);
					if(j == 1){
						break;
					}
				}
				if(sInstructions.equals(sIndentRemarks)  && sActMaterialCount.containsAll(sPOMaterialCount) && sActMaterials.containsAll(sPOMaterials)){
					flag = true;
				}

			}
		}catch(Exception e){
			System.err.println("Data from indent validation failed "+e);
		}
		return flag;
	}

	public boolean supplierDrpDwnValidation(){
		boolean flag = false;
		ArrayList<String> sSuplierList = new ArrayList<>();
		ArrayList<String> sPOMaterials = new ArrayList<>();
		ArrayList<String> sActSuplierList = new ArrayList<>();
		String sSupplier,sMaterial,sActSupplier = null;
		String[] sMaterialList;
		try{
			addPOBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			Select indent = new Select(indentDropDwn);
			int options = indent.getOptions().size();
			indent.selectByIndex(options-1);
			Thread.sleep(Constant.Min_Sleep);
			supplierField.click();
			if(supplierList.size() > 2){
				for(int i=0;i<supplierList.size()-2;i++){
					sSupplier = supplierList.get(i).getText();
					sSuplierList.add(sSupplier);
				}
				for (WebElement element : poMaterialList) {
					sMaterial = element.getText();
					sPOMaterials.add(sMaterial);
				}
				navigate.navigateToMasters();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToMaterial();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<sPOMaterials.size();i++){
					sMaterialList = sPOMaterials.get(i).split("-");
					master.filterText.clear();
					master.filterText.sendKeys(sMaterialList[0]);
					driver.findElement(By.xpath(".//td[contains(text(),'"+sMaterialList[0]+"')]/following::td[1]/a")).click();
					Thread.sleep(Constant.Min_Sleep);
					ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
				    driver.switchTo().window(tabs2.get(1));
				    master.supplierProfileSection.click();
				    Thread.sleep(Constant.Min_Sleep);
				    if(master.supplierMaterialList.size() > 1){
				    	for(int j=1;j<master.supplierMaterialList.size();j++){
				    		sActSupplier = driver.findElement(By.xpath(".//*[@id='supp_price_table']/tbody/tr["+(j+1)+"]/td[3]")).getText();
				    		sActSuplierList.add(sActSupplier);
				    	}
				    }
				    driver.close();
				    driver.switchTo().window(tabs2.get(0));
				}
				if(sSuplierList.containsAll(sActSuplierList)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Supplier drop down validation failed "+e);
		}
		return flag;
	}

	public boolean validateIndentOrderBalanceQty(){
		boolean flag = false;
		String sMaterialCount,sOrderedCount,sBalanceCount;
		ArrayList<String> sPOMaterialCount = new ArrayList<>();
		ArrayList<String> sPOOrderedCount = new ArrayList<>();
		ArrayList<String> sPOBalanceCount = new ArrayList<>();
		List<Integer> iPOMaterialCount = new ArrayList<>();
		List<Integer> iPOOrderedCount = new ArrayList<>();
		List<Integer> iPOBalanceCount = new ArrayList<>();
		List<Integer> iResult = new ArrayList<>();
		try{
			addPOBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			Select indent = new Select(indentDropDwn);
			int options = indent.getOptions().size();
			indent.selectByIndex(options-1);
			Thread.sleep(Constant.Min_Sleep);
			for(int j=0;j<poMaterialCountList.size()-1;j++){
				sMaterialCount = poMaterialCountList.get(j).getText();
				sPOMaterialCount.add(sMaterialCount);
				sOrderedCount = poOrderedCountList.get(j).getText();
				sPOOrderedCount.add(sOrderedCount);
				sBalanceCount = poBalanceCountList.get(j).getText();
				sPOBalanceCount.add(sBalanceCount);
			}
			for (Object str : sPOMaterialCount) {
				iPOMaterialCount.add(Integer.parseInt((String)str));
			}
			for (Object str : sPOOrderedCount) {
				iPOOrderedCount.add(Integer.parseInt((String)str));
			}
			for (Object str : sPOBalanceCount) {
				iPOBalanceCount.add(Integer.parseInt((String)str));
			}
			for(int i=0;i<iPOMaterialCount.size();i++){
				iResult.add(iPOMaterialCount.get(i) + iPOOrderedCount.get(i));
			}
			if(iResult.containsAll(iPOBalanceCount)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Validation of indent, order and balance qty failed "+e);
		}
		return flag;
	}

	public boolean ValidateMaterialRate(){
		boolean flag = false;
		String text, sSupplier = null, sDate, sAmt, sPrice;
		String[] sMaterialList;
		ArrayList<String> sPOMaterials = new ArrayList<>();
		ArrayList<String> sSupplierAmtList = new ArrayList<>();
		ArrayList<String> sPOPriceList = new ArrayList<>();
		List<Date> dates = new ArrayList<>();
		SimpleDateFormat fmt = new SimpleDateFormat("MMM dd, yyyy");
		try{
			addPOBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			Select indent = new Select(indentDropDwn);
			int options = indent.getOptions().size();
			indent.selectByIndex(options-1);
			Thread.sleep(Constant.Min_Sleep);
			supplierField.click();
			if(supplierList.size() > 2){
				sSupplier = supplierList.get(0).getText();
				driver.findElement(By.xpath(".//li[contains(text(),'"+sSupplier+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				for(int j=0;j<poPriceList.size();j++){
					sPrice = poPriceList.get(j).getAttribute("value");
					sPOPriceList.add(sPrice);
					text = poMaterialList.get(j).getText();
					sPOMaterials.add(text);
				}
				navigate.navigateToMasters();
				Thread.sleep(Constant.Min_Sleep);
				navigate.navigateToMaterial();
				Thread.sleep(Constant.Min_Sleep);
				for(int j=0;j<sPOMaterials.size();j++){
					sMaterialList = sPOMaterials.get(j).split("-");
					master.filterText.clear();
					master.filterText.sendKeys(sMaterialList[0]);
					driver.findElement(By.xpath(".//td[contains(text(),'"+sMaterialList[0]+"')]/following::td[1]/a")).click();
					Thread.sleep(Constant.Min_Sleep);
					ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
				    driver.switchTo().window(tabs2.get(1));
				    master.supplierProfileSection.click();
				    Thread.sleep(Constant.Min_Sleep);
				    if(master.supplierMaterialList.size() > 1){
				    	for(int k=1;k<master.supplierDateList.size();k++){
				    		text = driver.findElement(By.xpath(".//*[@id='supp_price_table']/tbody/tr["+(k+1)+"]/td[3]")).getText();
				    		if(text.equals(sSupplier)){
					    		sDate = master.supplierDateList.get(k).getText();
					    		Date date = fmt.parse(sDate);
					    		dates.add(date);
				    		}
				    	}
				    	if(!dates.isEmpty()){
					    	fmt.format(Collections.max(dates));
					    	Collections.sort(dates);
					    	sDate = fmt.format(dates.get(dates.size() - 1));
					    	sAmt = driver.findElement(By.xpath(".//td[text()='"+sDate+"']/preceding::td[2]")).getText();
					    	String[] sAmount = sAmt.split("\\.");
					    	if(sAmount[1].equals("00")){
					    		sSupplierAmtList.add(sAmount[0]);
							}else{
								sSupplierAmtList.add(sAmt);
							}
				    	}
					}
					driver.close();
					driver.switchTo().window(tabs2.get(0));
				}
				if(sPOPriceList.retainAll(sSupplierAmtList)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Material rate validation check failed "+e);
		}
		return flag;
	}

	public boolean ValidateTaxAddition(int iRowNo, String sheet) throws InterruptedException{
		boolean flag = false;
		try{
			addPOBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			Select indent = new Select(indentDropDwn);
			int options = indent.getOptions().size();
			indent.selectByIndex(options-1);
			Thread.sleep(Constant.Min_Sleep);
			supplierField.click();
			if(!(supplierList.size() > 2)){
				AddSupplierInMaterial(iRowNo,sheet);
			}
			poFirstSupplier.click();
			Thread.sleep(Constant.Min_Sleep);
			fillPOMaterialDetails(0,iRowNo,sheet);
			flag = TaxAddition(iRowNo,sheet);
		}catch(Exception e){
			System.err.println("Tax addition validation failed "+e);
		}
		return flag;
	}

	public boolean AddSupplierInMaterial(int iRowNo, String sheet){
		boolean flag = false;
		String text;
		String[] sMaterialList;
		ArrayList<String> sPOMaterials = new ArrayList<>();
		try{
			for(int j=0;j<poPriceList.size();j++){
				text = poMaterialList.get(j).getText();
				sPOMaterials.add(text);
			}
			navigate.navigateToMasters();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			for (String sPOMaterial : sPOMaterials) {
				sMaterialList = sPOMaterial.split("-");
				master.filterText.clear();
				master.filterText.sendKeys(sMaterialList[0].trim());
				driver.findElement(By.xpath(".//td[contains(text(),'"+sMaterialList[0].trim()+"')]/following::td[1]/a")).click();
				Thread.sleep(Constant.Min_Sleep);
				ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
			    driver.switchTo().window(tabs2.get(1));
			    master.supplierProfileSection.click();
			    Thread.sleep(Constant.Min_Sleep);
			    flag = master.addSupplier(iRowNo,sheet);
			}
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			addPOBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			Select indent = new Select(indentDropDwn);
			int options = indent.getOptions().size();
			indent.selectByIndex(options-1);
			Thread.sleep(Constant.Min_Sleep);
			supplierField.click();
		}catch(Exception e){
			System.err.println("Supplier addition failed "+e);
		}
		return flag;
	}

	public boolean TaxAddition(int iRowNo, String sheet) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sTax = xls.get(iRowNo).get("Tax");
		boolean flag = false;
		try{
			taxDropDwn.click();
			Thread.sleep(Constant.Min_Sleep);
			taxSearchField.sendKeys(sTax);
			driver.findElement(By.xpath(".//em[text()='"+sTax+"']")).click();
			addTaxBtn.click();
			Thread.sleep(Constant.Medium_Sleep);
			if(driver.findElement(By.xpath(".//b[contains(text(),'"+sTax+"')]")).isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Tax addition failed"+e);
		}
		return flag;
	}

	public boolean poWiseReportColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load po wise report");
			filterBtn.click();
			viewReportBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder_ScrollTable(poReportscolumn,sColumn);
		}catch(Exception e){
			System.err.println("PO Wise Report column validation failed "+e);
		}
		return flag;
	}

	public boolean materialWiseReportColumnValidation(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sColumn = xls.get(iRowNo).get("Column Name");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material wise report");
			filterBtn.click();
			viewReportBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = Constant.verifyColumnOrder_ScrollTable(poReportscolumn,sColumn);
		}catch(Exception e){
			System.err.println("Material Wise Report column validation failed "+e);
		}
		return flag;
	}

	public boolean addJobPo_Materials(int iRowNo, String sheet) throws Exception{
		boolean flag = false,flag3, flag4, flag5;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		try{
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			addPOBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(indentDropDwn), "Failed to load PO view page");
			if(indentDropDwn.isDisplayed()){
				jobPOToggleBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				transportCheckBox.click();
				packingForwardingCheckBox.click();
				quotationRefNo.sendKeys(sDate);
				deliveryDueDate.click();
				nextDeliveryMnth.click();
				DeliveryDate.click();
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(Constant.Min_Sleep);
				quotationRefDate.click();
				previousQuotationMnth.click();
				QuotationDate.click();
				jse.executeScript("window.scrollBy(0,-2500)", "");
				supplierField.click();
				supplierSearchTxtField.sendKeys(sParty);
				driver.findElement(By.xpath("//em[contains(text(),'"+sParty+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				flag5 = addStockMaterial(iRowNo,sheet,1, 0);
				flag4 = TaxAddition(iRowNo,sheet);
				flag3 = validateGrandTotalValue();
				if(flag3 && flag4 && flag5){
					Thread.sleep(Constant.Min_Sleep);
					addPO.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load popup with ok button");
					Thread.sleep(Constant.Min_Sleep);
					okBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load PO view page");
					Thread.sleep(Constant.Min_Sleep);
					navigate.showAllEntries();
					int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
					if(iActPONumber > iPONumber){
						flag = true;
					}
				}

			}
		}catch(Exception e){
			System.err.println("Job Po addition with material addition failed "+e);
		}
		return flag;
	}

	public boolean addJobPO_Indent(int iRowNo, String sheet){
		boolean flag = false,flag1, flag2 = false;
		try{
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			addPOBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			jobPOToggleBtn.click();
			Thread.sleep(Constant.Max_Sleep);
			if(indentDropDwn.isDisplayed()){
				flag2 = addPurchase_Indent(iRowNo, sheet,iPONumber);
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load PO view page");
			Thread.sleep(Constant.Min_Sleep);
			flag1 = navigate.showAllEntries();
			if(flag1 && flag2){
				int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
				if(iActPONumber > iPONumber){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Job Po addition with indent failed "+e);
		}
		return flag;
	}

	public boolean updateJobPO(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sPrice = xls.get(iRowNo).get("Price");
		String sDiscount = xls.get(iRowNo).get("Discount");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			addJobPo_Materials(iRowNo,sheet);
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[2]/i")).click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(indentDropDwn), "Failed to load PO view page");
			Thread.sleep(Constant.Medium_Sleep);
			jse.executeScript("window.scrollBy(0,-2500)", "");
			for(int i=10;i<11;i++){
				materialNameTxt.sendKeys(" ");
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath("//ul[contains(@id,'ui-id')]/li["+(i+11)+"]/a")).click();
				jobQtyTxt.sendKeys(Keys.CONTROL+"a");
				jobQtyTxt.sendKeys(Keys.DELETE);
				jobQtyTxt.sendKeys("5000");
				jobPriceTxt.sendKeys(Keys.CONTROL+"a");
				jobPriceTxt.sendKeys(Keys.DELETE);
				jobPriceTxt.sendKeys(sPrice);
				jobDiscountTxt.sendKeys(Keys.CONTROL+"a");
				jobDiscountTxt.sendKeys(Keys.DELETE);
				jobDiscountTxt.sendKeys(sDiscount);
				Thread.sleep(Constant.Min_Sleep);
				jobAddMaterialBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				vaidateGST(i, iRowNo,sheet);
				jse.executeScript("window.scrollBy(0,-2500)", "");
			}
			flag = updatePO(iRowNo,sheet,iPoNum);
		}catch(Exception e){
			System.err.println("Job Po update failed "+e);
		}
		return flag;
	}

	public boolean validateApproveJobPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addJobPo_Materials(iRowNo,sheet);
			flag = approvePO();
		}catch(Exception e){
			System.err.println("PO approve failed "+e);
		}
		return flag;
	}

	public boolean validateRejectApprovedJobPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			validateApproveJobPO(iRowNo,sheet);
			flag = rejectApprovedPO();
		}catch(Exception e){
			System.err.println("Failed to reject approved PO "+e);
		}
		return flag;
	}

	public boolean validateRejectDraftJobPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addJobPo_Materials(iRowNo,sheet);
			flag = rejectDraftPO();
		}catch(Exception e){
			System.err.println("Failed to reject approved PO "+e);
		}
		return flag;
	}

	public boolean validateAmendJobPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			validateRejectApprovedJobPO(iRowNo,sheet);
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			Thread.sleep(Constant.Min_Sleep);
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[2]/i")).click();
			flag = amendPO(iPoNum,iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Failed to amend PO "+e);
		}
		return flag;
	}

	public boolean addQuickPO(int iRowNo, String sheet){
		boolean flag = false, flag2 = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load PO view page");
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			addQuickPOBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(poAddPage.isDisplayed()){
				poToggleBtn.click();
				Constant.waitForPageLoad();
				flag2 = addQuickPOMaterial(iRowNo, sheet, iPONumber);
			}
			if(flag2){
				int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
				if(iActPONumber > iPONumber){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add quick po "+e);
		}
		return flag;
	}

	public boolean addQuickPO_SPQWarning(int iRowNo, String sheet){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sPrice = xls.get(iRowNo).get("Price");
		String sDiscount = xls.get(iRowNo).get("Discount");
		String sParty = xls.get(iRowNo).get("Party");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load PO view page");
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			addQuickPOBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(poAddPage.isDisplayed()){
				poToggleBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				jse.executeScript("window.scrollBy(0,-5000)", "");
				Thread.sleep(Constant.Min_Sleep);
				supplierField.click();
				supplierSearchTxtField.sendKeys(sParty);
				driver.findElement(By.xpath(".//em[contains(text(),'"+sParty+"')]")).click();
				materialNameTxt.sendKeys(sMaterial);
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath("//ul[contains(@id,'ui-id')]/li/a[contains(text(),'"+sMaterial+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				jobQtyTxt.sendKeys(Keys.CONTROL+"a");
				jobQtyTxt.sendKeys(Keys.DELETE);
				jobQtyTxt.sendKeys("15");
				jobPriceTxt.sendKeys(Keys.CONTROL+"a");
				jobPriceTxt.sendKeys(Keys.DELETE);
				jobPriceTxt.sendKeys(sPrice);
				jobDiscountTxt.sendKeys(Keys.CONTROL+"a");
				jobDiscountTxt.sendKeys(Keys.DELETE);
				jobDiscountTxt.sendKeys(sDiscount);
				jobAddMaterialBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(poSPQPopup.isDisplayed()){
					driver.findElement(By.xpath("//span[contains(text(),'15.000')]")).click();
					Thread.sleep(Constant.Min_Sleep);
					approvePO.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(closeBtn_PDF), "Failed to load pdf pop up");
					if(closeBtn_PDF.isDisplayed()){
						closeBtn_PDF.click();
						Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load po view page");
						Thread.sleep(Constant.Min_Sleep);
						int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
						if(iActPONumber > iPONumber){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add quick po "+e);
		}
		return flag;
	}

	public boolean addQuickPOMaterial(int iRowNo, String sheet, int iPONumber){
		boolean flag = false, flag1, flag2;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sProject = xls.get(iRowNo).get("Project");
		String sMatCount = xls.get(iRowNo).get("Material Count");
		String sBlanketPO = xls.get(iRowNo).get("Blanket PO");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		sCurrentDate = Constant.CorrectedDate();
		try{
			if(sBlanketPO.contains("Yes")){
				blanketPOChkBx.click();
				blanketpoDateRange.click();
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath("//li[contains(text(),'Current Financial Year')]")).click();
			}
			Thread.sleep(Constant.Min_Sleep);
			supplierField.click();
			supplierSearchTxtField.sendKeys(sParty);
			driver.findElement(By.xpath(".//em[contains(text(),'"+sParty+"')]")).click();
			Constant.waitForPageLoad();
			projectDropDwn.click();
			projectSearchText.sendKeys(sProject);
			driver.findElement(By.xpath("//li[text()='All']/following::li/em[contains(text(),'"+sProject+"')]")).click();
			Constant.waitForPageLoad();
			addPODetails();
			flag1 = addStockMaterial(iRowNo, sheet, Integer.parseInt(sMatCount), 0);
			flag2 = validateGrandTotalValue();
			if(flag1 && flag2){
				String sGrandTotal = grandTotalField.getAttribute("value");
				Double price = Double.parseDouble(sGrandTotal);
				DecimalFormat format = new DecimalFormat("0.#");
				Thread.sleep(Constant.Min_Sleep);
				addPO.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load po view page");
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//table[@id='po_list']/tbody/tr["+(iPONumber+1)+"]/td[1]")));
				WebElement ele = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+(iPONumber+1)+"]/td[1]/following::td[2][text()='"+sCurrentDate+"']/following::td[2][text()='-']/following::td[contains(text(),'"+sParty.trim()+"')]/following::td[contains(text(),'"+format.format(price)+"')]/following::td[4]/a[1][contains(text(),'Draft')]"));
				if(ele.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add quick po material details"+e);
		}
		return flag;
	}

	public boolean addStockMaterial(int iRowNo,String sheet,int l, int j){
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sPrice = xls.get(iRowNo).get("Price");
		String sDiscount = xls.get(iRowNo).get("Discount");
		String sDrawingNo = xls.get(iRowNo).get("Drawing No");
		String sUnit = xls.get(iRowNo).get("Unit");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			Thread.sleep(Constant.Min_Sleep);
			if(sMaterial == null){
				if(sDrawingNo == null){
					for(int i=j;i<l;i++){
						jse.executeScript("window.scrollBy(0,-5000)", "");
						Thread.sleep(Constant.Min_Sleep);
						materialNameTxt.sendKeys(" ");
						Thread.sleep(Constant.Min_Sleep);
						driver.findElement(By.xpath("//ul[contains(@id,'ui-id')]/li["+(i+6)+"]/a")).click();
						Thread.sleep(Constant.Min_Sleep);
						jobQtyTxt.sendKeys(Keys.CONTROL+"a");
						jobQtyTxt.sendKeys(Keys.DELETE);
						jobQtyTxt.sendKeys("5000");
						jobPriceTxt.sendKeys(Keys.CONTROL+"a");
						jobPriceTxt.sendKeys(Keys.DELETE);
						jobPriceTxt.sendKeys(sPrice);
						jobDiscountTxt.sendKeys(Keys.CONTROL+"a");
						jobDiscountTxt.sendKeys(Keys.DELETE);
						jobDiscountTxt.sendKeys(sDiscount);
						jobAddMaterialBtn.click();
						Thread.sleep(Constant.Min_Sleep);
					}
				}else{
					jse.executeScript("window.scrollBy(0,-5000)", "");
					Thread.sleep(Constant.Min_Sleep);
					materialNameTxt.sendKeys(sDrawingNo +sDate);
					Thread.sleep(Constant.Min_Sleep);
					jobQtyTxt.click();
					Thread.sleep(Constant.Min_Sleep);
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					jobQtyTxt.sendKeys(Keys.CONTROL+"a");
					jobQtyTxt.sendKeys(Keys.DELETE);
					jobQtyTxt.sendKeys("5000");
					Select select = new Select(jobUnitDrpDwn);
					select.selectByVisibleText(sUnit);
					jobPriceTxt.sendKeys(Keys.CONTROL+"a");
					jobPriceTxt.sendKeys(Keys.DELETE);
					jobPriceTxt.sendKeys(sPrice);
					jobDiscountTxt.sendKeys(Keys.CONTROL+"a");
					jobDiscountTxt.sendKeys(Keys.DELETE);
					jobDiscountTxt.sendKeys(sDiscount);
					jobAddMaterialBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}else{
				String[] sMaterialList = sMaterial.split(",");
				for (String element : sMaterialList) {
					jse.executeScript("window.scrollBy(0,-5000)", "");
					Thread.sleep(Constant.Min_Sleep);
					materialNameTxt.sendKeys(element);
					Thread.sleep(Constant.Min_Sleep);
					driver.findElement(By.xpath("//ul[contains(@id,'ui-id')]/li/a[contains(text(),'"+element+"')]")).click();
					Thread.sleep(Constant.Min_Sleep);
					if(sAltUnit.contains("Yes")){
						altUnitDrpDwn.click();
						altUnitOption.click();
					}
					jobQtyTxt.sendKeys(Keys.CONTROL+"a");
					jobQtyTxt.sendKeys(Keys.DELETE);
					jobQtyTxt.sendKeys("5000");
					jobPriceTxt.sendKeys(Keys.CONTROL+"a");
					jobPriceTxt.sendKeys(Keys.DELETE);
					jobPriceTxt.sendKeys(sPrice);
					jobDiscountTxt.sendKeys(Keys.CONTROL+"a");
					jobDiscountTxt.sendKeys(Keys.DELETE);
					jobDiscountTxt.sendKeys(sDiscount);
					jobAddMaterialBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				l = sMaterialList.length;
			}
			if(QuickPoMaterialList.size()-1 == l){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to add stock materials "+e);
		}
		return flag;
	}

	public boolean addQuickJO(int iRowNo, String sheet){
		boolean flag = false, flag2 = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load PO view page");
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			addQuickPOBtn.click();
			Constant.waitForPageLoad();
			if(poAddPage.isDisplayed()){
				jobPOToggleBtn.click();
				Constant.waitForPageLoad();
				flag2 = addQuickPOMaterial(iRowNo, sheet, iPONumber);
			}
			if(flag2){
				int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
				if(iActPONumber > iPONumber){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add quick po "+e);
		}
		return flag;
	}

	public boolean ApproveQuickPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitForPageLoad();
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			addQuickPO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = approvePO();
			}
		}catch(Exception e){
			System.err.println("Failed to approve quick po "+e);
		}
		return flag;
	}

	public boolean ApproveQuickJO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitForPageLoad();
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			addQuickJO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = approvePO();
			}
		}catch(Exception e){
			System.err.println("Failed to approve quick JO "+e);
		}
		return flag;
	}

	public boolean DiscardQuickPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load PO view page");
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			addQuickPO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = rejectDraftPO();
			}
		}catch(Exception e){
			System.err.println("Failed to reject draft PO "+e);
		}
		return flag;
	}

	public boolean DiscardQuickJO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load PO view page");
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			addQuickJO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = rejectDraftPO();
			}
		}catch(Exception e){
			System.err.println("Failed to reject draft JO "+e);
		}
		return flag;
	}

	public boolean RejectQuickPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitForPageLoad();
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			ApproveQuickPO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = rejectApprovedPO();
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved PO "+e);
		}
		return flag;
	}

	public boolean RejectQuickJO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitForPageLoad();
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			ApproveQuickJO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = rejectApprovedPO();
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved JO "+e);
		}
		return flag;
	}

	public boolean ReviewQuickPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load PO view page");
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			addQuickPO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = ReviewPO();
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved JO "+e);
		}
		return flag;
	}

	public boolean ReviewQuickJO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitForPageLoad();
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			addQuickJO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = ReviewPO();
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved JO "+e);
		}
		return flag;
	}

	public boolean ReviewPO(){
		boolean flag = false,flag2;
		try{
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+(iPoNum)+"]/td[1]")));
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[1]/i"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[1]/i")).click();
			Constant.waitFor(ExpectedConditions.visibilityOf(reviewBtn), "Failed to load pdf pop up");
			Thread.sleep(Constant.Min_Sleep);
			if(poPDFPopUp.isDisplayed()){
				remarksTxtField.sendKeys("Test"+sDate);
				reviewBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success pop up");
				Thread.sleep(Constant.Min_Sleep);
				if(reviewedSuccessPopup.isDisplayed()){
					okBtn.sendKeys(Keys.ENTER);
					Thread.sleep(Constant.Min_Sleep);
					closeBtn_PDF.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load PO view page");
					flag2 = navigate.showAllEntries();
					if(flag2){
						jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+(iPoNum)+"]/td[1]")));
						String sActStatus = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/a[1]")).getText();
						if(sActStatus.equals("Reviewed")){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Review draft PO failed "+e);
		}
		return flag;
	}

	public boolean SubmitReviewedQuickPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load PO view page");
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			ReviewQuickPO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = submitPO(iRowNo, sheet);
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved JO "+e);
		}
		return flag;
	}

	public boolean SubmitReviewedQuickJO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitForPageLoad();
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			ReviewQuickJO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = submitPO(iRowNo, sheet);
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved JO "+e);
		}
		return flag;
	}

	public boolean submitPO(int iRowNo, String sheet){
		boolean flag = false,flag2;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			Thread.sleep(Constant.Min_Sleep);
			String sPONum = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")).getText();
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[2]/i")).click();Constant.waitFor(ExpectedConditions.visibilityOf(submitForApprovalBtn), "Failed to load pdf pop up");
			Thread.sleep(Constant.Min_Sleep);
			if(poNo_EditPage.getText().contains(sPONum)){
				flag2 = updateQtyPriceTax(iRowNo,sheet);
				submitForApprovalBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load po view page");
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				if(flag2){
					jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[1]")));
					String sActStatus = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/a[1]")).getText();
					if(sActStatus.equals("Draft")){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Review draft PO failed "+e);
		}
		return flag;
	}

	public boolean updateQtyPriceTax(int iRowNo, String sheet){
		boolean flag = false;
		try{
			for(int j=0;j<poCountList.size();j++){
				poCountList.get(j).sendKeys(Keys.CONTROL+"a");
				poCountList.get(j).sendKeys(Keys.DELETE);
				poCountList.get(j).sendKeys("6000");
				poPriceList.get(j).sendKeys(Keys.CONTROL+"a");
				poPriceList.get(j).sendKeys(Keys.DELETE);
				poPriceList.get(j).sendKeys("25.50");
			}
			flag = TaxAddition(iRowNo,sheet);
		}catch(Exception e){
			System.err.println("Failed to update qty, price and tax of PO "+e);
		}
		return flag;
	}

	public boolean ApproveReviewedQuickPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load PO view page");
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			SubmitReviewedQuickPO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = approvePO();
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved JO "+e);
		}
		return flag;
	}

	public boolean ApproveReviewedQuickJO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitForPageLoad();
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			SubmitReviewedQuickJO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = approvePO();
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved JO "+e);
		}
		return flag;
	}

	public boolean DiscardReviewedQuickPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load PO view page");
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			ReviewQuickPO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = rejectDraftPO();
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved JO "+e);
		}
		return flag;
	}

	public boolean DiscardReviewedQuickJO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			Constant.waitForPageLoad();
			int iPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			ReviewQuickJO(iRowNo, sheet);
			int iActPONumber = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			if(iActPONumber > iPONumber){
				flag = rejectDraftPO();
			}
		}catch(Exception e){
			System.err.println("Failed to reject approved JO "+e);
		}
		return flag;
	}

	public boolean updatePO_AddMat_QuickPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addQuickPO(iRowNo, sheet);
			flag = updateQuickPo_AddingMat(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Quick PO update by adding material failed "+e);
		}
		return flag;
	}

	public boolean updateJO_AddMat_QuickPO(int iRowNo, String sheet){
		boolean flag = false;
		try{
			addQuickJO(iRowNo, sheet);
			flag = updateQuickPo_AddingMat(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Quick PO update by adding material failed "+e);
		}
		return flag;
	}

	public boolean updateQuickPo_AddingMat(int iRowNo, String sheet){
		boolean flag = false, flag2, flag3, flag4, flag5;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			Thread.sleep(Constant.Min_Sleep);
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[2]/i")).click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(approveRejectBtn), "Failed to load edit page");
			if(indentDropDwn.isDisplayed()){
				jse.executeScript("window.scrollBy(0,-2500)", "");
				Thread.sleep(Constant.Min_Sleep);
				flag2 = addStockMaterial(iRowNo, sheet, 2, 1);
				flag4 = TaxAddition(iRowNo,sheet);
				flag3 = validateGrandTotalValue();
				if(flag2 && flag3 && flag4){
					Thread.sleep(Constant.Min_Sleep);
					String sGrandTotal = grandTotalField.getAttribute("value");
					update.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
					Thread.sleep(Constant.Min_Sleep);
					okBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load po view page");
					Thread.sleep(Constant.Min_Sleep);
					flag5 = navigate.showAllEntries();
					jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//table[@id='po_list']/tbody/tr["+iPoNum+"]/td[7]")));
					Thread.sleep(Constant.Min_Sleep);
					if(flag5){
						String sActTotal = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[7]")).getText();
						if(sGrandTotal.contains(sActTotal)){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Quick Jo update by adding material failed "+e);
		}
	return flag;
	}

	public boolean amendPO_QuickPOAddMat(int iRowNo, String sheet){
		boolean flag = false;
		try{
			RejectQuickPO(iRowNo, sheet);
			flag = amendQuickPo_AddingMat(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Quick PO update by adding material failed "+e);
		}
		return flag;
	}

	public boolean amendJO_QuickPOAddMat(int iRowNo, String sheet){
		boolean flag = false;
		try{
			RejectQuickJO(iRowNo, sheet);
			flag = amendQuickPo_AddingMat(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Quick PO update by adding material failed "+e);
		}
		return flag;
	}

	public boolean amendQuickPo_AddingMat(int iRowNo, String sheet){
		boolean flag = false, flag2, flag3, flag4, flag5;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/a[1]")));
			Thread.sleep(Constant.Min_Sleep);
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[2]/i")).click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(indentDropDwn), "Failed to load po edit page");
			Thread.sleep(Constant.Min_Sleep);
			if(indentDropDwn.isDisplayed()){
				jse.executeScript("window.scrollBy(0,-2500)", "");
				Thread.sleep(Constant.Medium_Sleep);
				flag2 = addStockMaterial(iRowNo, sheet, 2, 1);
				flag4 = TaxAddition(iRowNo,sheet);
				flag3 = validateGrandTotalValue();
				if(flag2 && flag3 && flag4){
					Thread.sleep(Constant.Min_Sleep);
					String sGrandTotal = grandTotalField.getAttribute("value");
					amendBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(remarksTxtField), "Failed to load pdf popup");
					closeBtn_PDF.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load PO view page");
					Thread.sleep(Constant.Min_Sleep);
					flag5 = navigate.showAllEntries();
					if(flag5){
						jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/a[1]")));
						String sActTotal = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[7]")).getText();
						String sActStatus = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/a[1]")).getText();
						if(sGrandTotal.contains(sActTotal) && sActStatus.equals("Approved")){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Quick Jo update by adding material failed "+e);
		}
	return flag;
	}

	public boolean amendPO_QuickPOTaxRateQty(int iRowNo, String sheet){
		boolean flag = false;
		try{
			RejectQuickPO(iRowNo, sheet);
			flag = amendTaxRatePrice(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Quick PO update by adding material failed "+e);
		}
		return flag;
	}

	public boolean amendJO_QuickPOTaxRateQty(int iRowNo, String sheet){
		boolean flag = false;
		try{
			RejectQuickJO(iRowNo, sheet);
			flag = amendTaxRatePrice(iRowNo, sheet);
		}catch(Exception e){
			System.err.println("Quick PO update by adding material failed "+e);
		}
		return flag;
	}


	public boolean amendTaxRatePrice(int iRowNo, String sheet){
		boolean flag = false, flag2, flag3, flag4, flag5;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try{
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/a[1]")));
			Thread.sleep(Constant.Min_Sleep);
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[2]/i")).click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(indentDropDwn), "Failed to load po edit page");
			Constant.waitForPageLoad();
			if(indentDropDwn.isDisplayed()){
				jse.executeScript("window.scrollBy(0,-2500)", "");
				Thread.sleep(Constant.Medium_Sleep);
				flag2 = editPriceQty();
				flag4 = vaidateGST(0, iRowNo,sheet);
				flag3 = validateGrandTotalValue();
				if(flag2 && flag3 && flag4){
					Thread.sleep(Constant.Min_Sleep);
					String sGrandTotal = grandTotalField.getAttribute("value");
					amendBtn.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(remarksTxtField), "Failed to load pdf popup");
					closeBtn_PDF.click();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(dateFilter), "Failed to load po view page");
					Thread.sleep(Constant.Min_Sleep);
					flag5 = navigate.showAllEntries();
					if(flag5){
						jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/a[1]")));
						String sActTotal = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[7]")).getText();
						String sActStatus = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/a[1]")).getText();
						if(sGrandTotal.contains(sActTotal) && sActStatus.equals("Approved")){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Quick Jo update by adding material failed "+e);
		}
	return flag;
	}

	public boolean editPriceQty(){
		boolean flag = false;
		try{
			Double unitprice;
			for(int i=0;i<QuickPoMaterialList.size()-1;i++){
				poCountList.get(i).sendKeys(Keys.CONTROL+"a");
				poCountList.get(i).sendKeys(Keys.DELETE);
				poCountList.get(i).sendKeys("5100");
				poPriceList.get(i).sendKeys(Keys.CONTROL+"a");
				poPriceList.get(i).sendKeys(Keys.DELETE);
				poPriceList.get(i).sendKeys("12.52");
				Double poCount = Double.parseDouble(poCountList.get(i).getAttribute("value"));
				String sActPrice = poPriceList.get(i).getAttribute("value");
				poDiscountList.get(i).click();
				String sDiscount = poDiscountList.get(i).getAttribute("value");
				String sUnitPrice = poUnitRateList.get(i).getAttribute("value");
				Double Value = Double.parseDouble(sActPrice)-((Double.parseDouble(sActPrice) * (Double.parseDouble(sDiscount))) / 100);
				String sCalUnit = Double.toString(Value);
				Double dUnitPrice = Math.round(Value * 100.0) / 100.0;
				if(sCalUnit.contains(".")){
					String[] sListCalUnit = sCalUnit.split("\\.");
					if(sListCalUnit[1].length() > 2){
						if(sListCalUnit[1].substring(2, 3).equals("5")){
							String sUnit = sListCalUnit[0]+"."+sListCalUnit[1].substring(0, 2);
							unitprice = Double.parseDouble(sUnit);
						}else{
							unitprice = Math.round(Value * 100.0) / 100.0;
						}
					}else{
						unitprice = Math.round(Value * 100.0) / 100.0;
					}
				}else{
					unitprice = Math.round(Value * 100.0) / 100.0;
				}
				if(Double.parseDouble(sUnitPrice) == unitprice || Double.parseDouble(sUnitPrice) == dUnitPrice){
					String b = poValueList.get(i).getAttribute("value");
					double d = poCount * Value;
					double actValue = Math.round(d * 100.0) / 100.0;
					if(actValue == Double.parseDouble(b)){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to edit price and qty fields "+e);
		}
		return flag;
	}

	public boolean indentNotAvl_POFullqty(int iRowNo, String sheet){
		boolean flag = false;
		try{
			String[] sIndentNo = store.createIndentPO(iRowNo, sheet);
			flag = verifyIndentNotListed(sIndentNo[1].trim());
		}catch(Exception e){
			System.err.println("Indent no displayed in choose Indent popup though po created for full qty "+e);
		}
		return flag;
	}

	public boolean indentNotAvl_shortClose(int iRowNo, String sheet){
		boolean flag = false;
		try{
			String[] sIndentNo = store.createIndentPO(iRowNo, sheet);
			store.shortClose();
			flag = verifyIndentNotListed(sIndentNo[1].trim());
		}catch(Exception e){
			System.err.println("Indent no displayed in choose Indent popup though po created for full qty "+e);
		}
		return flag;
	}

	public boolean verifyIndentNotListed(String sIndentNo){
		boolean flag = false;
		try{
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase_Header();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToPurchase();
			Thread.sleep(Constant.Min_Sleep);
			createIndentPoBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			filterSearchIndentList.sendKeys(sIndentNo);
			if(noMatchingRecords.isDisplayed()){
				flag = true;
			}
			closeBtn_ChooseIndent.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Indent no displayed in choose Indent popup though po created for full qty "+e);
		}
		return flag;
	}

	public boolean approveIndentPO(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			store.createPO_IndentPo(iRowNo, sheet);
			approvePO();
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			driver.navigate().refresh();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")));
			String sPONum = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("arguments[0].scrollIntoView(true);",store.indentList.get(store.indentList.size()-1));
			Thread.sleep(Constant.Min_Sleep);
			store.indentList.get(store.indentList.size()-1).click();
			Thread.sleep(Constant.Min_Sleep);
			store.othersBucketAmtValue.click();
			Thread.sleep(Constant.Min_Sleep);
			for(int i=0;i<store.othersBucketPonoList.size();i++){
				if(store.othersBucketPonoList.get(i).getText().contains(sPONum)){
					if(store.othersBucketStatusList.get(i).getText().contains("Approved")){
						flag = true;
						break;
					}
				}
			}
			store.PoListPopupClose.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to approve indent po "+e);
		}
		return flag;
	}

	public boolean discardIndentPO(int iRowNo, String sheet){
		boolean flag = false, flag1;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			store.createPO_IndentPo(iRowNo, sheet);
			rejectDraftPO();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			js.executeScript("arguments[0].scrollIntoView(true);",store.indentList.get(store.indentList.size()-1));
			store.indentList.get(store.indentList.size()-1).click();
			Thread.sleep(Constant.Min_Sleep);
			flag1 = Constant.isElementPresent(By.id("poList"));
			if(!flag1){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to discard indent po "+e);
		}
		return flag;
	}

	public boolean rejectApprovedIndentPO(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			store.createPO_IndentPo(iRowNo, sheet);
			approvePO();
			rejectApprovedPO();
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			driver.navigate().refresh();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")));
			Thread.sleep(Constant.Min_Sleep);
			String sPONum = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("arguments[0].scrollIntoView(true);",store.indentList.get(store.indentList.size()-1));
			Thread.sleep(Constant.Min_Sleep);
			store.indentList.get(store.indentList.size()-1).click();
			Thread.sleep(Constant.Min_Sleep);
			store.othersBucketAmtValue.click();
			Thread.sleep(Constant.Min_Sleep);
			for(int i=0;i<store.othersBucketPonoList.size();i++){
				if(store.othersBucketPonoList.get(i).getText().contains(sPONum)){
					if(store.othersBucketStatusList.get(i).getText().contains("Rejected")){
						flag = true;
						break;
					}
				}
			}
			store.PoListPopupClose.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to discard indent po "+e);
		}
		return flag;
	}

	public boolean amendIndentPO(int iRowNo, String sheet){
		boolean flag = false;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			store.createPO_IndentPo(iRowNo, sheet);
			int iPoNum = Integer.parseInt(poVisibleRecordCount.getText().substring(14).trim());
			approvePO();
			rejectApprovedPO();
			Thread.sleep(Constant.Min_Sleep);
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]"))).perform();
			driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[11]/span[2]/i")).click();
			amendPO(iPoNum, iRowNo, sheet);
			driver.navigate().refresh();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")));
			Thread.sleep(Constant.Min_Sleep);
			String sPONum = driver.findElement(By.xpath(".//*[@id='po_list']/tbody/tr["+iPoNum+"]/td[4]/a")).getText();
			navigate.navigateToStore();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToIndent();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			Thread.sleep(Constant.Min_Sleep);
			js.executeScript("arguments[0].scrollIntoView(true);",store.indentList.get(store.indentList.size()-1));
			Thread.sleep(Constant.Min_Sleep);
			store.indentList.get(store.indentList.size()-1).click();
			Thread.sleep(Constant.Min_Sleep);
			store.othersBucketAmtValue.click();
			Thread.sleep(Constant.Min_Sleep);
			for(int i=0;i<store.othersBucketPonoList.size();i++){
				if(store.othersBucketPonoList.get(i).getText().contains(sPONum)){
					if(store.othersBucketStatusList.get(i).getText().contains("Approved")){
						flag = true;
						break;
					}
				}
			}
			store.PoListPopupClose.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to discard indent po "+e);
		}
		return flag;
	}

}
