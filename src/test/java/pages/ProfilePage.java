package pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
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

public class ProfilePage {

	ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);

	//Material module web elements starts

	@FindBy(id="add_new_material") WebElement addMaterial;

	@FindBy(xpath=".//span[text()='New Goods']")
	private WebElement newAddPage;

	@FindBy(id="id_material-drawing_no")
	private WebElement drawingNoTxt;

	@FindBy(css="#id_material_category_select_chosen> a> span")
	private WebElement categoryDropDwn;

	@FindBy(css="#id_material_category_select_chosen >div>div >input")
	private WebElement categorySearch;

	@FindBy(id="id_material-name")
	private WebElement materialNameTxt;

	@FindBy(id="id_material_unit_id_chosen")
	private WebElement materialUnitDropDwn;

	@FindBy(id="alternateUoms")
	private WebElement alternateUnitLnk;

	@FindBy(css="div>select[id$='alternate_unit_id']")
	private WebElement unitDrpDwn_AltUnitPopup;

	@FindBy(css="div>input[id$='scale_factor']")
	private WebElement scaleFactorTxt;

	@FindBy(css="a#addNewUnit")
	private WebElement addAlternateUnit;

	@FindBy(css="tr>td>input[id$='unit_name']")
	private List<WebElement> addedAlternateUnitList;

	@FindBy(css="div>select[id$='alternate_unit_id']>option")
	private List<WebElement> unitDrpDwn_AltUnitPopupoptions;

	@FindBy(xpath=".//div[@id='add_new_alternate_unit']//a[text()='Close']")
	private WebElement alternateUnitClose;

	@FindBy(css="#alternateUoms>span")
	private WebElement altUnitCount;

	@FindBy(xpath="//td/input[contains(@id,'scale_factor')][contains(@name,'scale_factor')]")
	private List<WebElement> altUnitScaleFactor;

	@FindBy(id="id_material-price")
	private WebElement materialPrice;

	@FindBy(id="id_material-description")
	private WebElement materialDesc;

	@FindBy(id="id_material-tariff_no")
	private WebElement tariffNo;

	@FindBy(id="id_material_make-__prefix__-make")
	private WebElement materialMakeProfile;

	@FindBy(id="id_manufacture_value")
	private WebElement mpnTxtfield;

	@FindBy(id="id_packing_value")
	private WebElement SPQTxtfield;

	@FindBy(id="id_material-minimum_stock_level")
	private WebElement minStockValue;

	@FindBy(xpath="//span/span[contains(text(),'+')]")
	private WebElement specificationAdd;

	@FindBy(xpath="//div/input[contains(@id,'parameter')]")
	private WebElement specParameter;

	@FindBy(xpath="//div/input[contains(@id,'min_value')]")
	private WebElement specMinValue;

	@FindBy(xpath="//div/input[contains(@id,'max_value')]")
	private WebElement specMaxValue;

	@FindBy(xpath="//div/input[contains(@id,'unit')][contains(@name,'specification')]")
	private WebElement specUnit;

	@FindBy(xpath="//div/input[contains(@id,'inspection_method')]")
	private WebElement specInspectionMethod;

	@FindBy(xpath="//div/input[contains(@id,'reaction_plan')]")
	private WebElement specReactionPlan;

	@FindBy(xpath="//div/input[contains(@id,'comments')]")
	private WebElement specComments;

	@FindBy(id="add_new_specification") WebElement addSpecification;

	@FindBy(id="id_material-qc_method") WebElement qcMethod;

	@FindBy(id="id_material-sample_size") WebElement sampleSize;

	@FindBy(id="id_material-lot_size") WebElement lotSize;

	@FindBy(id="id_material-reaction_plan") WebElement reactionPlan;

	@FindBy(xpath="//label[contains(text(),'Stockable')]")
	private WebElement stockableToggle;

	@FindBy(id="saveCatalogueButton") WebElement saveMaterialBtn;

	@FindBy(xpath=".//span[text()='Name is required.']")
	private WebElement nameReqWarning;

	@FindBy(xpath=".//span[text()='Drawing Number is required.']")
	private WebElement drawingNumReqWarning;

	@FindBy(xpath=".//span[text()='Description is required.']")
	private WebElement descReqWarning;

	@FindBy(xpath=".//button[contains(@data-original-title,'Modify')]/i")
	private WebElement filterIcon;

	@FindBy(xpath="//label[contains(text(),'Include Not in Use')]")
	private WebElement filterNotInUseOption;

	@FindBy(xpath="//label[contains(text(),'Include Price Profile')]")
	private WebElement filterPriceProfileOption;

	@FindBy(xpath="//label[contains(text(),'Include Non Stock')]")
	private WebElement filterNonStockOption;

	@FindBy(xpath=".//input[@value='Apply']")
	private WebElement applyBTN;

	@FindBy(id="filter_textbox")
	public WebElement filterText;

	@FindBy(xpath=".//a[contains(text(),'Supplier Profile')]")
	public WebElement supplierProfileSection;

	@FindBy(xpath=".//*[@id='supp_price_table']/tbody/tr/td[6]")
	public List<WebElement> supplierDateList;

	@FindBy(xpath=".//*[@id='searchResult']/tbody/tr/td[2]/a")
	private List<WebElement> materialNameList;

	@FindBy(xpath=".//a[text()='Import Materials']")
	private WebElement importMaterial;

	@FindBy(xpath=".//span[text()='Choose file']")
	private WebElement chooseFile;

	@FindBy(xpath=".//tr[1]/td[3]/a")
	public WebElement firstMaterial;

	@FindBy(xpath="//div[@class='material-name header-label']")
	public WebElement currentPageHeader;

	@FindBy(xpath="//label[contains(text(),'Available Stock:')]")
	public WebElement availableStock;

	@FindBy(xpath="//td[text()='-NA-']/following::td[1]")
	public WebElement stockWOMake;

	@FindBy(xpath=".//*[@id='id_material_unit_id_chosen']/a/span")
	private WebElement selectedUnit;

	@FindBy(id="id_material-unit_conversion_rate")
	private WebElement materialRate;

	@FindBy(xpath=".//*[@id='makes']/ul/li/a")
	private List<WebElement> addedMakeProfileList;

	@FindBy(xpath=".//label[text()='In Use']")
	private WebElement inUseCheckbox;

	@FindBy(xpath=".//h2[contains(text(),'Last Modified Item Name:')]")
	private WebElement updatePopUpTxt;

	@FindBy(xpath=".//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(id="make_model_save")
	private WebElement OKBtn;

	@FindBy(xpath=".//*[@id='searchResult']/tbody/tr[1]/td[9]/label")
	private WebElement deleteMaterial;

	@FindBy(xpath=".//button[text()='Yes, delete it!']")
	public WebElement yesDelete;

	@FindBy(xpath=".//a[@data-original-title='Bill of Materials']/img")
	private WebElement billOfMaterials;

	@FindBy(xpath=".//*[@id='materialtable']/tbody/tr")
	private List<WebElement> bOMMaterialList;

	@FindBy(xpath=".//*[@id='materialtable']/tbody/tr[2]/td/a/img")
	private WebElement bOMDelete;

	@FindBy(xpath=".//*[@id='material_selected']")
	private WebElement materialName;

	@FindBy(xpath=".//div/input[@placeholder='Quantity']")
	private WebElement quantity;

	@FindBy(id="add_new_catalogue_material")
	private WebElement billAddBtn;

	@FindBy(xpath="//h2[contains(text(),'Duplicate Material Exists!')]")
	private WebElement duplicateMatWarning;

	@FindBy(xpath="//button[@class='cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath="//div[@id='material_bom_modal']//a[contains(text(),'Close')]")
	private WebElement closeBOMPoup;

	@FindBy(xpath=".//a[@data-original-title='Price Profile']/img")
	private WebElement supplier;

	@FindBy(xpath=".//select[contains(@id,'status_select')]")
	public List<WebElement> rejectedStatusDrpDwn;

	@FindBy(xpath=".//*[@id='supp_price_table']/tbody/tr")
	public List<WebElement> supplierMaterialList;

	@FindBy(xpath=".//*[@id='supp_price_table']/tbody/tr[2]/td/a/img")
	private WebElement supplierDelete;

	@FindBy(id="supplier_selected")
	private WebElement supplierName;

	@FindBy(id="id_price_material-__prefix__-price")
	private WebElement supplierPrice;

	@FindBy(id="id_price_material-__prefix__-remarks")
	private WebElement supplierRemarks;

	@FindBy(id="add_new_supplier_material")
	private WebElement addSupplier;

	@FindBy(id="id_price_material-0-supplier_select_field")
	private WebElement addedSupplier;

	@FindBy(xpath=".//div[@class='report-date form-control']")
	private WebElement supplier_EffectiveSince;

	@FindBy(id="id_price_material-__prefix__-currency_id")
	private WebElement supplierCurrency;

	@FindBy(id="id_price_material-__prefix__-price")
	private WebElement price;

	@FindBy(id="effect_from_date")
	private WebElement effectiveDate;

	@FindBy(id="effect_till_date")
	private WebElement effectiveTillDate;

	@FindBy(id="add_new_supplier_material")
	private WebElement supplierAddBtn;

	@FindBy(xpath="//div[@id='material_price_profile']//a[contains(text(),'Close')]")
	private WebElement closeSupplierPopup;

	@FindBy(xpath=".//input[@placeholder='Remarks']")
	private WebElement remarks;

	@FindBy(xpath=".//td[3]/a[1]")
	private List<WebElement> materialList;

	@FindBy(xpath=".//*[@id='bill_of_material']/div[3]/div/button")
	private WebElement bomMakeDropDwn;

	@FindBy(xpath=".//*[@id='bill_of_material']/div[3]/div/ul/li/a/label")
	private List<WebElement> bomMakeList;

	@FindBy(id="cancellCatalogue") WebElement cancelMaterial;

	@FindBy(id="visible_record_count")
	private WebElement totalRecords;

	@FindBy(xpath=".//tr/td[3]/input[contains(@id,'id_price_material')]")
	private List<WebElement> supplierPriceList;

	@FindBy(xpath=".//*[@id='supp_price_table']/tbody/tr[contains(@id,'price_material')]/preceding-sibling::tr/td[contains(@style,'color')]")
	private List<WebElement> supplierList;

	@FindBy(xpath=".//*[@id='searchResult']/tbody/tr/td[7]")
	private List<WebElement> priceProfileStatusColumn;

	@FindBy(xpath=".//select[contains(@id,'status')]")
	private List<WebElement> supplierStatusDropDwnList;


	//Party module webelements start

	@FindBy(id="a-add-party") WebElement addPartyBtn;

	@FindBy(id="id_party-code")
	private WebElement partyCodeTxtField;

	@FindBy(id="id_party-name")
	private WebElement partyNameTxtField;

	@FindBy(id="id_party-address")
	private WebElement partyAddress1TxtField;

	@FindBy(id="id_party-city")
	private WebElement partyCityTxtField;

	@FindBy(xpath=".//*[contains(@id,'id_country')]")
	private WebElement CountryDrpDwn;

	@FindBy(xpath=".//select[contains(@id,'id_state')]")
	private WebElement stateDrpDwn;

	@FindBy(id="id_party-phone")
	private WebElement partyPhoneTxtField;

	@FindBy(id="id_party-fax")
	private WebElement partyFaxField;

	@FindBy(id="id_party-email")
	private WebElement partyEmailTxtField;

	@FindBy(id="id_party-contact_person")
	private WebElement partyContactTxtField;

	@FindBy(xpath=".//a[text()='+ Add']")
	private WebElement addRegistrationLnk;

	@FindBy(xpath="//select[contains(@id,'id_gst_category')]")
	private WebElement registrationDrpDwn;

	@FindBy(id="party_gstin_number")
	private WebElement partyGSTTxtField;

	@FindBy(xpath="//div[@class='registration-extra-details']/div/input[contains(@class,'registraion-key')]")
	private List<WebElement> registrationKeyList;

	@FindBy(xpath="//div[@class='registration-extra-details']/div/input[contains(@class,'registraion-value')]")
	private List<WebElement> registrationValueList;

	@FindBy(id="party_pan_number")
	private WebElement partyPANTxtField;

	@FindBy(xpath=".//label[text()='Remind Duty Passed']")
	private WebElement partyDutyPassCheckBx;

	@FindBy(xpath=".//label[text()='Supplier']")
	private WebElement partySupplierCheckBx;

	@FindBy(xpath=".//label[text()='Customer']")
	private WebElement partyCustomerCheckBx;

	@FindBy(id="pay_cre_days")
	private WebElement partySupCreditDays;

	@FindBy(id="rec_cre_days")
	private WebElement partyCusCreditDays;

	@FindBy(id="id_currency")
	private WebElement partyCurrency;

	@FindBy(id="save-Party-details") WebElement partySave;

	@FindBy(xpath=".//span[text()='Code is required.']")
	private WebElement codeReqWarning;

	@FindBy(xpath=".//td/span/a")
	private List<WebElement> partyNameList;

	@FindBy(xpath=".//*[@id='dettable']/tbody/tr[1]/td[2]/span/a") WebElement firstParty;

	@FindBy(xpath=".//*[@id='dettable']/tbody/tr[1]/td[2]/span[2]/span[1]/i")
	private WebElement partyInlineEditIcon;

	@FindBy(xpath=".//*[@id='dettable']/tbody/tr[1]/td[8]/input")
	private WebElement partyInlinePhoneNoField;

	@FindBy(xpath=".//*[@id='dettable']/tbody/tr[1]/td[2]/span[2]/span[6]/i")
	private WebElement partyInlinesaveIcon;

	@FindBy(id="update-Party-details") WebElement update;

	@FindBy(xpath=".//p[text()='Party Updated Successfully']")
	private WebElement partyModifiedSuccessMsg;

	@FindBy(xpath="//a/mark[1]/following::span/span[4]/i")
	private WebElement deleteParty;

	@FindBy(xpath="//a/mark[1]/following::span")
	private WebElement partyCode;

	@FindBy(xpath=".//p[contains(text(),'Do you want to delete the party')]")
	private WebElement deleteWarningMsg;


	@FindBy(xpath=".//*[@id='dettable']/tbody/tr/td/a")
	private List<WebElement> partiesList;

	//Tax module webelements start here

	@FindBy(xpath=".//a[@data-original-title='Add New Tax']") WebElement addTax;

	@FindBy(xpath=".//tr/td[2]/span/a")
	private List<WebElement> taxList;

	@FindBy(id="id_tax-code")
	private WebElement taxCodeField;

	@FindBy(id="id_tax-name")
	private WebElement taxNameField;

	@FindBy(id="id_tax-type")
	private WebElement taxTypeDropDwn;

	@FindBy(xpath=".//label[text()='Compound']")
	private WebElement compoundLabel;

	@FindBy(id="id_tax-base_rate")
	private WebElement taxBaseRate;

	@FindBy(id="id_net_rate_dummy")
	private WebElement taxNetRate;

	@FindBy(id="save_tax_button") WebElement saveTaxBtn;

	@FindBy(xpath=".//a[@data-original-title='Back']") WebElement backBtn;

	@FindBy(xpath=".//tr[1]/td[2]/span/a") WebElement firstTax;

	@FindBy(xpath=".//*[@id='taxList']/tbody/tr[1]/td[5]")
	private WebElement taxNetRate_List;

	@FindBy(id="a-import-party") WebElement importParty;

	@FindBy(id="cmdUpload") WebElement upload;

	@FindBy(xpath=".//span[text()='File is required.']")
	private WebElement importWarning;

	@FindBy(xpath=".//div[@id='modal_importsupplier']/div/div/div/button[@class='close']") WebElement importCancel;

	String sNorDate = Constant.NormalDateFormat().substring(3, 5);
	String sDate = Constant.DateTimeFormat();

	private WebDriver driver;
	public ProfilePage(WebDriver driver){
		this.driver = driver;
	}



	/**
	 * To add material
	 * @param iRowNo
	 * @return true, if new material is added
	 * @throws Exception
	 */

	public boolean addMaterial(int iRowNo,String sheet) throws Exception{
		boolean flag = false, flag1;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sDrawingNo = xls.get(iRowNo).get("Drawing No");
		String sCategory = xls.get(iRowNo).get("Category");
		String sUnit = xls.get(iRowNo).get("Unit");
		String sPrice = xls.get(iRowNo).get("Price");
		String sNonStock = xls.get(iRowNo).get("Is Non Stock");
		String sProfile = xls.get(iRowNo).get("Make Profile");
		String sModifiedDate = new SimpleDateFormat("MMM dd, yyyy").format(java.util.Date.parse(Constant.NormalDateFormat()));
		try{
			int i = sModifiedDate.length();
			if(sModifiedDate.substring(4, 5).contains("0")){
				sModifiedDate = sModifiedDate.substring(0, 4)+sModifiedDate.substring(5, i);
			}
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
			int iBeforeAdd = Integer.parseInt(totalRecords.getText().replaceAll(",", ""));
			addMaterial.click();
			Constant.waitFor(ExpectedConditions.visibilityOf(newAddPage), "Failed to load material add page");
			if(newAddPage.isDisplayed()){
				drawingNoTxt.sendKeys(sDrawingNo.substring(0, 14)+RandomStringUtils.randomNumeric(5));
				categoryDropDwn.click();
				categorySearch.sendKeys(sCategory);
				driver.findElement(By.xpath(".//em[text()='"+sCategory+"']")).click();
				materialNameTxt.sendKeys(sDrawingNo+sDate);
				materialUnitDropDwn.click();
				driver.findElement(By.xpath(".//*[@id='id_material_unit_id_chosen']/div/ul/li[text()='"+sUnit+"']")).click();
				Thread.sleep(Constant.Min_Sleep);
				materialPrice.click();
				Thread.sleep(Constant.Min_Sleep);
				flag1 = addAlternateUnit();
				materialPrice.sendKeys(Keys.CONTROL+"a");
				materialPrice.sendKeys(Keys.DELETE);
				materialPrice.sendKeys(sPrice);
				tariffNo.sendKeys(sDate);
				materialMakeProfile.sendKeys(sProfile+sDate);
				materialMakeProfile.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				mpnTxtfield.sendKeys(sDate);
				SPQTxtfield.sendKeys("10");
				minStockValue.sendKeys(Keys.CONTROL+"a");
				minStockValue.sendKeys(Keys.DELETE);
				minStockValue.sendKeys("500");
				Thread.sleep(Constant.Min_Sleep);
				OKBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				specificationAdd.click();
				Thread.sleep(Constant.Min_Sleep);
				specParameter.sendKeys("Spec "+sDate);
				specMinValue.sendKeys("10.2555");
				specMaxValue.sendKeys("15.47487");
				specUnit.sendKeys("unit "+sDate);
				specInspectionMethod.sendKeys("Spec Inspec Method "+sDate);
				specReactionPlan.sendKeys("Reaction plan "+sDate);
				specComments.sendKeys("Specification comments "+sDate);
				addSpecification.click();
				Thread.sleep(Constant.Min_Sleep);
				qcMethod.sendKeys("Quality control Method "+sDate);
				sampleSize.sendKeys("15.266565");
				lotSize.sendKeys("546.1656");
				reactionPlan.sendKeys("Reaction plan "+sDate);
				materialDesc.sendKeys("Material Added through automation on "+sDate);
				if(sNonStock.contains("Yes")){
					stockableToggle.click();
				}
				String sTime = Constant.DateTimeFormat().substring(8, 10)+":"+Constant.DateTimeFormat().substring(10,12);
				saveMaterialBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
				if(updatePopUpTxt.isDisplayed() && driver.getPageSource().contains(sDrawingNo)){
					okBtn.click();
					if(sNonStock.contains("Yes")){
						filterIcon.click();
						filterNonStockOption.click();
						applyBTN.click();
						Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
					}
					int iAfterAdd = Integer.parseInt(totalRecords.getText().replaceAll(",", ""));
					WebElement ele = driver.findElement(By.xpath(".//a[contains(text(),'"+sDrawingNo+sDate+"')]/following::td[contains(text(),'"+sCategory+"')]/following::td[contains(text(),'"+sPrice+"')]/following::td[contains(text(),'"+sModifiedDate+", "+sTime+"')][1]"));
					if(ele.isDisplayed() && iAfterAdd > iBeforeAdd && flag1){
						flag = true;
					}
				}
			}

		}catch(Exception e){
			System.err.println("Material addition not successful "+e);
		}
		return flag;
	}

	public boolean addAlternateUnit(){
		boolean flag = false;
		try{
			alternateUnitLnk.click();
			Thread.sleep(Constant.Min_Sleep);
			Select select = new Select(unitDrpDwn_AltUnitPopup);
			for(int j=1;j<unitDrpDwn_AltUnitPopupoptions.size();j++){
				if(unitDrpDwn_AltUnitPopupoptions.get(j).getAttribute("disabled") == null){
					select.selectByValue(Integer.toString(j));
					String sSelectUnit = unitDrpDwn_AltUnitPopupoptions.get(j).getText();
					scaleFactorTxt.sendKeys("12.5");
					addAlternateUnit.click();
					for (WebElement element : addedAlternateUnitList) {
						int alternateCount = addedAlternateUnitList.size();
						if(element.getAttribute("value").contains(sSelectUnit)){
							alternateUnitClose.click();
							Thread.sleep(Constant.Min_Sleep);
							if(alternateCount-1 ==  Integer.parseInt(altUnitCount.getText().trim())){
								flag = true;
								break;
							}
						}
					}
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add alternate unit "+e);
		}
		return flag;
	}

	/**
	 * To update material details
	 * @param iRowNo
	 * @return true, if material is updated
	 * @throws Exception
	 */

	public boolean updateMaterial(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(), sheet);
		String sCategory = xls.get(iRowNo).get("Category");
		String sUnit = xls.get(iRowNo).get("Unit");
		String sRate = xls.get(iRowNo).get("Conversion Rate");
		String sProfile = xls.get(iRowNo).get("Make Profile");
		String sPrice = xls.get(iRowNo).get("Price");
		String sDrawingNo = null;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
			int iBeforeAdd = Integer.parseInt(totalRecords.getText().replaceAll(",", ""));
			String sMaterial = firstMaterial.getText();
			firstMaterial.click();
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    Constant.waitFor(ExpectedConditions.elementToBeClickable(categoryDropDwn), "Failed to load material edit page");
		    if(currentPageHeader.getText().equals(sMaterial)){
		    	sDrawingNo = drawingNoTxt.getAttribute("value");
		    	categoryDropDwn.click();
				categorySearch.sendKeys(sCategory);
				driver.findElement(By.xpath(".//em[text()='"+sCategory+"']")).click();
				if(!selectedUnit.getText().contains(sUnit)){
					materialUnitDropDwn.click();
					driver.findElement(By.xpath(".//*[@id='id_material_unit_id_chosen']/div/ul/li[text()='"+sUnit+"']")).click();
					Thread.sleep(Constant.Min_Sleep);
					materialRate.click();
					Thread.sleep(Constant.Min_Sleep);
//					flag1 = addAlternateUnit();
					materialRate.sendKeys(Keys.CONTROL+"a");
					materialRate.sendKeys(Keys.DELETE);
					materialRate.sendKeys(sRate);
				}
				materialPrice.sendKeys(Keys.CONTROL+"a");
				materialPrice.sendKeys(Keys.DELETE);
				materialPrice.sendKeys(sPrice);
				materialDesc.clear();
				materialDesc.sendKeys("Material updated through automation on "+sDate);
				tariffNo.clear();
				tariffNo.sendKeys(sDate);
				for(int i=2;i<addedMakeProfileList.size();i++){
					if(i == addedMakeProfileList.size()){
						break;
					}else{
						driver.findElement(By.xpath(".//*[@id='makes']/ul/li["+i+"]/a")).click();
					}
				}
				materialMakeProfile.sendKeys(sProfile+sDate);
				materialMakeProfile.sendKeys(Keys.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				mpnTxtfield.sendKeys(sDate);
				SPQTxtfield.sendKeys("10");
				Thread.sleep(Constant.Min_Sleep);
				OKBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				minStockValue.sendKeys(Keys.CONTROL+"a");
				minStockValue.sendKeys(Keys.DELETE);
				minStockValue.sendKeys("500");
				Thread.sleep(Constant.Min_Sleep);
				specificationAdd.click();
				Thread.sleep(Constant.Min_Sleep);
				specParameter.sendKeys("Spec "+sDate);
				specMinValue.sendKeys("10.2555");
				specMaxValue.sendKeys("15.47487");
				specUnit.sendKeys("unit "+sDate);
				specInspectionMethod.sendKeys("Spec Inspec Method "+sDate);
				specReactionPlan.sendKeys("Reaction plan "+sDate);
				specComments.sendKeys("Specification comments "+sDate);
				addSpecification.click();
				Thread.sleep(Constant.Min_Sleep);
				qcMethod.clear();
				qcMethod.sendKeys("Quality control Method "+sDate);
				sampleSize.sendKeys("15.266565");
				lotSize.sendKeys("546.1656");
				reactionPlan.sendKeys("Reaction plan "+sDate);
				saveMaterialBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
		    }
			if(updatePopUpTxt.isDisplayed() && driver.getPageSource().contains(sDrawingNo)){
				okBtn.click();
				driver.close();
			    driver.switchTo().window(tabs2.get(0));
			    int iAfterAdd = Integer.parseInt(totalRecords.getText().replaceAll(",", ""));
				driver.findElement(By.linkText(""+sMaterial+"")).click();
				ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
			    driver.switchTo().window(tabs.get(1));
			    Constant.waitFor(ExpectedConditions.elementToBeClickable(categoryDropDwn), "Failed to load material edit page");
			    Thread.sleep(Constant.Min_Sleep);
				if(Constant.driver.getPageSource().contains(sDate) && iAfterAdd == iBeforeAdd){
					flag = true;
				}
				driver.close();
			    driver.switchTo().window(tabs.get(0));
			    Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Material update not successful "+e);
		}
		return flag;
	}

	/**
	 * To delete material
	 * @return true, if material is deleted
	 */

	public boolean deleteMaterial(int iRowNo,String sheet){
		boolean flag = false;
		try{
			addMaterial(iRowNo,sheet);
			filterText.clear();
			filterText.sendKeys(" ");
			int iBeforeAdd = Integer.parseInt(totalRecords.getText().replaceAll(",", ""));
			String sMaterial = firstMaterial.getText();
			deleteMaterial.click();
			Thread.sleep(Constant.Min_Sleep);
			yesDelete.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
			navigate.showAllEntries();
			int iAfterAdd = Integer.parseInt(totalRecords.getText().replaceAll(",", ""));
			filterIcon.click();
			filterNotInUseOption.click();
			applyBTN.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
			filterText.sendKeys(sMaterial);
			String[] sMat =  sMaterial.split("\\s+");
			String sStatus = driver.findElement(By.xpath(".//a/mark[contains(text(),'"+sMat[sMat.length-1]+"')]/following::td[6]")).getText();
			if(iAfterAdd < iBeforeAdd && sStatus.contains("NO")){
				flag = true;
			}
			driver.findElement(By.linkText(""+sMaterial+"")).click();
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    Constant.waitFor(ExpectedConditions.elementToBeClickable(categoryDropDwn), "Failed to load material edit page");
		    inUseCheckbox.click();
			saveMaterialBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
			okBtn.click();
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    Thread.sleep(Constant.Min_Sleep);
		    driver.navigate().refresh();
		    Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
		}catch(Exception e){
			System.err.println("Material delete not successful "+e);
		}
	return flag;
	}

	/**
	 * To add material with BOM
	 * @param iRowNo
	 * @return true, if material is added with BOM materials
	 * @throws Exception
	 */

	public boolean addMaterial_BOM() throws Exception{
		boolean flag = false;
		String sDrawingNo = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
			int iBeforeAdd = Integer.parseInt(totalRecords.getText().replaceAll(",", ""));
			String sMaterial = firstMaterial.getText();
			firstMaterial.click();
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    if(currentPageHeader.getText().equals(sMaterial)){
		    	sDrawingNo = drawingNoTxt.getAttribute("value");
		    	js.executeScript("window.scrollBy(0,-5000)");
		    	Thread.sleep(Constant.Min_Sleep);
				billOfMaterials.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=1;i<11;i++){
					materialName.sendKeys(" ");
					Thread.sleep(Constant.Min_Sleep);
					driver.findElement(By.xpath(".//ul/li[@class='ui-menu-item']["+i+"]/a")).click();
					Thread.sleep(Constant.Min_Sleep);
					bomMakeDropDwn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(bomMakeList.size() > 1){
						bomMakeList.get(1).click();
					}else{
						bomMakeList.get(0).click();
					}
					quantity.sendKeys("10.50");
					billAddBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					boolean flag1 = Constant.isElementPresent(By.xpath("//button[@class='cancel']"));
					if(flag1 && cancelBtn.isDisplayed()){
						cancelBtn.click();
						Thread.sleep(Constant.Min_Sleep);
					}
				}
				closeBOMPoup.click();
				Thread.sleep(Constant.Min_Sleep);
				materialDesc.sendKeys("Material Added through automation on "+sDate);
				tariffNo.sendKeys(sDate);
				saveMaterialBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
				if(updatePopUpTxt.isDisplayed() && driver.getPageSource().contains(sDrawingNo)){
					okBtn.click();
					driver.close();
				    driver.switchTo().window(tabs2.get(0));
				    int iAfterAdd = Integer.parseInt(totalRecords.getText().replaceAll(",", ""));
					driver.findElement(By.linkText(""+sMaterial+"")).click();
					ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
				    driver.switchTo().window(tabs.get(1));
				    Constant.waitFor(ExpectedConditions.elementToBeClickable(categoryDropDwn), "Failed to load material edit page");
				    Thread.sleep(Constant.Min_Sleep);
					if(Constant.driver.getPageSource().contains(sDate) && iAfterAdd == iBeforeAdd){
						flag = true;
					}
					driver.close();
				    driver.switchTo().window(tabs2.get(0));
				    Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Material addition with BOM not successful "+e);
		}
		return flag;
	}

	/**
	 * To add material with supplier
	 * @param iRowNo
	 * @return true, if material is added with supplier
	 * @throws Exception
	 */

	public boolean addsupplierProfile_Material(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sPrice = xls.get(iRowNo).get("Price");
		String sModifiedDate = Constant.CorrectedDate();
		int i, sPendingCount = 0;
		ArrayList<String> priceProfile = new ArrayList<>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
			navigate.showAllEntries();
			int iBeforeAdd = materialList.size();
			String sMaterial = firstMaterial.getText();
			firstMaterial.click();
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    if(currentPageHeader.getText().equals(sMaterial)){
		    	String sDrawingNo = drawingNoTxt.getAttribute("value");
		    	js.executeScript("window.scrollBy(0,-5000)");
		    	Thread.sleep(Constant.Min_Sleep);
				supplier.click();
				Thread.sleep(Constant.Min_Sleep);
				for(i=1;i<5;i++){
					supplierName.sendKeys(RandomStringUtils.randomAlphabetic(1));
					Thread.sleep(Constant.Min_Sleep);
					driver.findElement(By.xpath(".//ul[contains(@id,'ui-id')]/li[@class='ui-menu-item']/a")).click();
					Thread.sleep(Constant.Min_Sleep);
					String sActPrice = Double.toString(Double.parseDouble(sPrice)+i);
					price.sendKeys(Keys.CONTROL+"a");
					price.sendKeys(Keys.DELETE);
					price.sendKeys(sActPrice);
					effectiveDate.click();
					driver.findElement(By.xpath(".//div[@class='datepicker-days']/table/thead/tr[2]/th[1]")).click();
					driver.findElement(By.xpath(".//div[@class='datepicker-days']/table/tbody/tr[3]/td[4]")).click();
					effectiveTillDate.click();
					driver.findElement(By.xpath(".//div[@class='datepicker-days']/table/thead/tr[2]/th[3]")).click();
					driver.findElement(By.xpath(".//div[@class='datepicker-days']/table/tbody/tr[3]/td[4]")).click();
					remarks.sendKeys("Remarks"+sDate);
					Thread.sleep(Constant.Min_Sleep);
					String sMaterialPrice = materialPrice.getAttribute("value");
					if(sActPrice.contains(sMaterialPrice)){
						Constant.log.info("Price of material for supplier is updated successfully");
					}
					supplierAddBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				closeSupplierPopup.click();
				Thread.sleep(Constant.Min_Sleep);
				saveMaterialBtn.click();
				String sTime = Constant.DateTimeFormat().substring(8, 10);
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load success popup");
				if(updatePopUpTxt.isDisplayed() && driver.getPageSource().contains(sDrawingNo)){
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					driver.close();
				    driver.switchTo().window(tabs2.get(0));
					navigate.showAllEntries();
					int iAfterAdd = materialList.size();
					driver.navigate().refresh();
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load success popup");
					filterText.sendKeys(sDrawingNo);
					driver.findElement(By.linkText(""+sMaterial+"")).click();
					ArrayList<String> tabs4 = new ArrayList<> (driver.getWindowHandles());
				    driver.switchTo().window(tabs4.get(1));
				    Constant.waitFor(ExpectedConditions.elementToBeClickable(supplier), "Failed to load success popup");
				    supplier.click();
					Thread.sleep(Constant.Min_Sleep);
					for (WebElement element : supplierList) {
						priceProfile.add(element.getText());
					}
					for(int j=1;j<supplierStatusDropDwnList.size();j++){
						if(driver.findElement(By.xpath(".//*[(@id='id_price_material-"+(j-1)+"-status')]/option[@selected='selected']")).getText().contains("Pending")){
							sPendingCount = sPendingCount +1;
						}
					}
					closeSupplierPopup.click();
					Thread.sleep(Constant.Min_Sleep);
					driver.close();
				    driver.switchTo().window(tabs4.get(0));
				    Thread.sleep(Constant.Min_Sleep);
				    filterIcon.click();
				    filterPriceProfileOption.click();
					applyBTN.click();
					Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
					WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'"+sMaterial+"')]/following::td[3][contains(text(),'"+priceProfile.size()+"')]/following::td[contains(text(),'"+(sPendingCount)+" - Pending')]/following::td[contains(text(),'"+sModifiedDate+""+", "+""+sTime+"')][1]"));
					if(iAfterAdd == iBeforeAdd && ele.isDisplayed()){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Supplier profile addition to material failed "+e);
		}
		return flag;
	}

	/**
	 * To import materials
	 * @return true, if materials are imported successfully
	 */

	public boolean importMaterial(){
		boolean flag = false;
		try{
			String[] sList = ExcelUtils.ReadCSV("E:\\PartyImport.csv");
			navigate.navigateToMasters();
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			int iValue = materialNameList.size();
			importMaterial.click();
			Thread.sleep(Constant.Min_Sleep);
			chooseFile.click();
			Thread.sleep(Constant.Min_Sleep);// wait for page load
			Runtime.getRuntime().exec("E:\\AutoIT_Material.exe");//execute AutoIT to upload import file
			Thread.sleep(Constant.Min_Sleep);
			upload.click();
			Thread.sleep(Constant.Min_Sleep);
			int iActValue = materialNameList.size();
			if(iActValue>iValue){
				flag = true;
			}
			String sName = sList[1];
			Constant.driver.findElement(By.xpath(".//a[text()='"+sName+" ']")).click();
			Thread.sleep(Constant.Min_Sleep);
			 ((JavascriptExecutor) Constant.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			 Thread.sleep(Constant.Min_Sleep);
			 deleteParty.click();
			driver.switchTo().alert().accept();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Material import not successful "+e);
		}
	return flag;
	}

	/**
	 * To validate cancel button in add material tab
	 * @param iRowNo
	 * @return true, if cancel button is working as required
	 */

	public boolean cancelMaterial(int iRowNo, String sheet){
		boolean flag = false;
		try{
			navigate.navigateToMasters();
			navigate.navigateToMaterial();
			if(materialNameList.size() == 0){
				addMaterial(iRowNo,sheet);
			}
			Constant.driver.findElement(By.xpath(".//*[@id='searchResult']/tbody/tr[1]/td[2]/a")).click();
			 Thread.sleep(Constant.Min_Sleep);
			 cancelMaterial.click();
			 Thread.sleep(Constant.Min_Sleep);
			 if(Constant.driver.getCurrentUrl().contains("http://192.168.2.54:8443/erp/masters/mastershome/")){
				 flag = true;
			 }
		}catch(Exception e){
			System.err.println("Cancel button of material is not working "+e);
		}
	return flag;
	}

	/**
	 * To delete materials from BOM material list
	 * @param iRowNo
	 * @return true, if materials are deleted from BOM list
	 */

	public boolean deleteBOM(int iRowNo, String sheet){
		boolean flag = false;
		try{
			navigate.navigateToMasters();
			navigate.navigateToMaterial();
			addMaterial_BOM();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			Constant.driver.findElement(By.xpath(".//*[@id='searchResult']/tbody/tr[1]/td[2]/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			billOfMaterials.click();
			Thread.sleep(Constant.Min_Sleep);
			int iValue = bOMMaterialList.size();
			bOMDelete.click();
			driver.switchTo().alert().accept();
			saveMaterialBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Constant.driver.findElement(By.xpath(".//*[@id='searchResult']/tbody/tr[1]/td[2]/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			billOfMaterials.click();
			Thread.sleep(Constant.Min_Sleep);
			int iActValue = bOMMaterialList.size();
			if(iValue > iActValue){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Delete button of BOM not working "+e);
		}
   	return flag;
	}

	/**
	 * To delete supplier from the material
	 * @param iRowNo
	 * @return true, if supplier is delete from the material list
	 */

	public boolean deleteSupplier(int iRowNo, String sheet){
		boolean flag = false;
		try{
			navigate.navigateToMasters();
			navigate.navigateToMaterial();
			addsupplierProfile_Material(iRowNo,sheet);
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Thread.sleep(Constant.Min_Sleep);
			Constant.driver.findElement(By.xpath(".//*[@id='searchResult']/tbody/tr[1]/td[2]/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			supplier.click();
			Thread.sleep(Constant.Min_Sleep);
			int iValue = supplierMaterialList.size();
			supplierDelete.click();
			driver.switchTo().alert().accept();
			saveMaterialBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToMaterial();
			Constant.driver.findElement(By.xpath(".//*[@id='searchResult']/tbody/tr[1]/td[2]/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			supplier.click();
			Thread.sleep(Constant.Min_Sleep);
			int iActValue = supplierMaterialList.size();
			if(iValue > iActValue){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Delete button of Supplier not working "+e);
		}
   	return flag;
	}

	/**
	 * To verify mandatory field error message in material add tab
	 * @param iRowNo
	 * @return true, if mandatory error messages are displayed
	 */

	public boolean materialMandatoryFields(int iRowNo){
       	boolean flag = false;
		try{
			addMaterial.click();
			Thread.sleep(Constant.Min_Sleep);
			saveMaterialBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(nameReqWarning.isDisplayed() && drawingNumReqWarning.isDisplayed() && descReqWarning.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Mandatory fields warning of material is successful "+e);
		}
   	return flag;
	}

	/**
	 * To validate in use material status displayed by clicking on in use check box
	 * @param iRowNo
	 * @return true, if material status gets changed to in use
	 */

	public boolean inUse(int iRowNo){
   		boolean flag = false;
		try{
			String sMaterial = firstMaterial.getText();
			deleteMaterial.click();
			driver.switchTo().alert().accept();
			Constant.driver.findElement(By.linkText(""+sMaterial+"")).click();
			Thread.sleep(Constant.Min_Sleep);
			inUseCheckbox.click();
			saveMaterialBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			String sStatus = Constant.driver.findElement(By.xpath(".//td/a[contains(text(),'"+sMaterial+"')]/following::td[2]")).getText();
			if(sStatus.contains("In-Use")){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Mandatory fields warning of material is successful "+e);
		}
		return flag;
	}

	/**
	 * To add new party
	 * @param iRowNo - indicates row no in the excel
	 * @return - returns true if the party is added successfully
	 * @throws Exception
	 */

	public String addParty(int iRowNo, String sheet) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sAddress1 = xls.get(iRowNo).get("Address1");
		String sCity = xls.get(iRowNo).get("City");
		String sState = xls.get(iRowNo).get("State");
		String sEmail = xls.get(iRowNo).get("Email");
		String sContact = xls.get(iRowNo).get("ContactPerson");
		String sPan = xls.get(iRowNo).get("Pan No");
		String sWithSupplier = xls.get(iRowNo).get("Supplier");
		String sWithCustomer = xls.get(iRowNo).get("Customer");
		String sSupplierCrDays = xls.get(iRowNo).get("Supplier Credit days");
		String sCustomerCrDays = xls.get(iRowNo).get("Customer Credit days");
		 String sGSTCat = xls.get(iRowNo).get("GST Category");
		String sPartyName = null;
		try{
			sPartyName  = "Test Party Name"+sDate.substring(9, 14);
			partyCodeTxtField.sendKeys("Test "+sDate.substring(9, 14));
			if(sWithCustomer.contains("Yes")){
				boolean flag = driver.findElement(By.id("id_is_customer")).isSelected();
				if(!flag){
					partyCustomerCheckBx.click();
				}
			}
			if(sWithSupplier.contains("Yes")){
				boolean flag1 = driver.findElement(By.id("id_is_supplier")).isSelected();
				if(!flag1){
					partySupplierCheckBx.click();
				}
			}
			if(partySupCreditDays.isDisplayed() && sSupplierCrDays.contains("Yes")){
				partySupCreditDays.clear();
				partySupCreditDays.sendKeys("15");
			}
			if(partySupCreditDays.isDisplayed() && sCustomerCrDays.contains("Yes")){
				partyCusCreditDays.clear();
				partyCusCreditDays.sendKeys("20");
			}
			partyNameTxtField.sendKeys(sPartyName);
			partyAddress1TxtField.sendKeys(sAddress1);
			partyCityTxtField.sendKeys(sCity);
			Select country = new Select(CountryDrpDwn);
			country.selectByVisibleText("India");
			Select state = new Select(stateDrpDwn);
			state.selectByVisibleText(sState);
			partyPhoneTxtField.sendKeys(sDate);
			partyFaxField.sendKeys(sDate);
			partyEmailTxtField.sendKeys(sEmail);
			partyContactTxtField.sendKeys(sContact);
			partyPANTxtField.sendKeys(sPan+sDate);
			partyGSTTxtField.sendKeys(sDate);
			partyDutyPassCheckBx.click();
			Select select = new Select(registrationDrpDwn);
			select.selectByVisibleText(sGSTCat);
			String[] sRegistrationDetails = {"CST", "TIN","ECC","CIN","TAN"};
			for(int i=0;i<5;i++){
				addRegistrationLnk.click();
				Thread.sleep(Constant.Min_Sleep);
				registrationKeyList.get(i+2).sendKeys(sRegistrationDetails[i]);
				registrationValueList.get(i+2).sendKeys(sDate);
			}
			partySave.click();
			Thread.sleep(Constant.Min_Sleep);
			okBtn.click();
		}catch(Exception e){
			System.err.println("Failed to add party "+e);
		}
		return sPartyName;
	}

	public boolean validateAddParty(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		String sPartyName;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load party view page");
			navigate.showAllEntries();
			int iBeforeAdd = partiesList.size();
			addPartyBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			sPartyName = addParty(iRowNo,sheet);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load party view page");
			navigate.showAllEntries();
			int iAfterAdd = partiesList.size();
			filterText.sendKeys(sPartyName);
			if(driver.findElement(By.xpath(".//a/mark[contains(text(),'Name"+sDate.substring(9, 14)+"')]")).isDisplayed() && iAfterAdd > iBeforeAdd){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("New Party addition failed "+e);
		}
		return flag;
	}

	/**
	 * To update party
	 * @param iRowNo - indicated the row no in the test data excel sheet
	 * @return - returns true when the party is updated successfully
	 * @throws Exception
	 */

	public boolean updateParty(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sAddress1 = xls.get(iRowNo).get("Address1");
		String sCity = xls.get(iRowNo).get("City");
		String sState = xls.get(iRowNo).get("State");
		String sEmail = xls.get(iRowNo).get("Email");
		String sContact = xls.get(iRowNo).get("ContactPerson");
		String sPan = xls.get(iRowNo).get("Pan No");
		 String sGSTCat = xls.get(iRowNo).get("GST Category");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load party view page");
			navigate.showAllEntries();
			if(!(partyNameList.size() > 0)){
				addPartyBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				addParty(iRowNo, sheet);
			}
			int iBeforeAdd = partiesList.size();
			firstParty.click();
			Thread.sleep(Constant.Min_Sleep);
			partyAddress1TxtField.clear();
			partyAddress1TxtField.sendKeys(sAddress1);
			partyCityTxtField.clear();
			partyCityTxtField.sendKeys(sCity);
			Select country = new Select(CountryDrpDwn);
			country.selectByVisibleText("India");
			Select state = new Select(stateDrpDwn);
			state.selectByVisibleText(sState);
			partyPhoneTxtField.clear();
			partyPhoneTxtField.sendKeys(sDate);
			partyFaxField.clear();
			partyFaxField.sendKeys(sDate);
			partyEmailTxtField.clear();
			partyEmailTxtField.sendKeys(sEmail);
			partyContactTxtField.clear();
			partyContactTxtField.sendKeys(sContact);
			partyPANTxtField.clear();
			partyPANTxtField.sendKeys(sPan+sDate);
			partyGSTTxtField.clear();
			partyGSTTxtField.sendKeys(sDate);
			partyDutyPassCheckBx.click();
			Select select = new Select(registrationDrpDwn);
			select.selectByVisibleText(sGSTCat);
			for (WebElement element : registrationValueList) {
				element.clear();
				element.sendKeys(sDate);
			}
			partySupplierCheckBx.click();
			partyCustomerCheckBx.click();
			Thread.sleep(Constant.Min_Sleep);
			if(partySupCreditDays.isDisplayed() && partyCusCreditDays.isDisplayed()){
				partySupCreditDays.clear();
				partySupCreditDays.sendKeys("15");
				partyCusCreditDays.clear();
				partyCusCreditDays.sendKeys("20");
			}
			update.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
			if(partyModifiedSuccessMsg.isDisplayed()){
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load party view page");
				navigate.showAllEntries();
				int iAfterAdd = partiesList.size();
				if(Constant.driver.getPageSource().contains(sDate) && iAfterAdd == iBeforeAdd){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Update party failed"+e);
		}
		return flag;
	}

	/**
	 * To delete party
	 * @param iRowNo - indicated the excel row no
	 * @return - returns true if party is deleted successfully
	 * @throws Exception
	 */

	public boolean deleteParty(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load party view page");
			addPartyBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			String sParty = addParty(iRowNo, sheet);
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load party view page");
			navigate.showAllEntries();
			int Value = partyNameList.size();
			filterText.sendKeys(sParty);
			Thread.sleep(Constant.Min_Sleep);
			Actions actions = new Actions(driver);
			actions.moveToElement(partyCode).build().perform();
			deleteParty.click();
			Thread.sleep(Constant.Min_Sleep);
			if(deleteWarningMsg.isDisplayed()){
				yesDelete.click();
				Thread.sleep(Constant.Min_Sleep);
				okBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				navigate.showAllEntries();
				int ActValue = partyNameList.size();
				if(Value>ActValue){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Delete Party failed"+e);
		}
		return flag;
	}

	/**
	 * To search a party in the search field
	 * @param iRowNo - indicated the row no in the test data excel sheet
	 * @return - returns true when the search party is successful
	 * @throws Exception
	 */

	public boolean searchParty(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Party");
		String sParty = xls.get(iRowNo).get("Search Party");
		String sCode = xls.get(iRowNo).get("Code");
		try{
			navigate.navigateToMasters();
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			if(!(partyNameList.size() > 0)){
				addParty(iRowNo, sheet);
				filterText.sendKeys(sCode);
				if(Constant.driver.getPageSource().contains(sCode)){
					flag = true;
				}
			}else{
				filterText.sendKeys(sParty);
				if(Constant.driver.findElement(By.xpath(".//td[text()='"+sParty+"']")).isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Search party failed"+e);
		}
		return flag;
	}

	/**
	 * To import party
	 * @param iRowNo - indicates the row no in the test data excel sheet
	 * @return - returns true if the import is successful
	 */

	public boolean importParty(int iRowNo){
		boolean flag = false;
		try{
			String[] sList = ExcelUtils.ReadCSV("E:\\PartyImport.csv");
			navigate.navigateToMasters();
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			int iValue = partyNameList.size();
			importParty.click();
			Thread.sleep(Constant.Min_Sleep);
			chooseFile.click();
			Thread.sleep(Constant.Min_Sleep);// wait for page load
			Runtime.getRuntime().exec("E:\\AutoIt.exe");
			Thread.sleep(Constant.Min_Sleep);
			upload.click();
			Thread.sleep(Constant.Min_Sleep);
			int iActValue = partyNameList.size();
			if(iActValue>iValue){
				flag = true;
			}
			String sName = sList[1];
			Constant.driver.findElement(By.xpath(".//a[text()='"+sName+" ']")).click();
			Thread.sleep(Constant.Min_Sleep);
			 ((JavascriptExecutor) Constant.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");//scroll to bottom of the page
			 Thread.sleep(Constant.Min_Sleep);
			 deleteParty.click();
			driver.switchTo().alert().accept();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Import party failed"+e);
		}
		return flag;
	}

	/**
	 * To verify that the ledger is created when party is created
	 * @param iRowNo - indicates the row no in the test data excel sheet
	 * @return - returns true if the ledger is created when party is created
	 * @throws Exception
	 */

	public boolean addParty_LedgerUpdate(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),"Party");
		String sCode = xls.get(iRowNo).get("Code");
		String sName = xls.get(iRowNo).get("Name");
		String sAddress1 = xls.get(iRowNo).get("Address1");
		String sCity = xls.get(iRowNo).get("City");
		String sState = xls.get(iRowNo).get("State");
		String sEmail = xls.get(iRowNo).get("Email");
		String sContact = xls.get(iRowNo).get("ContactPerson");
		String sPan = xls.get(iRowNo).get("Pan No");
		try{
			navigate.navigateToMasters();
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			partyCodeTxtField.sendKeys(sCode+sDate);
			partyNameTxtField.sendKeys(sName+sDate);
			partyAddress1TxtField.sendKeys(sAddress1);
			partyCityTxtField.sendKeys(sCity);
			Select country = new Select(CountryDrpDwn);
			country.selectByVisibleText("India");
			Select state = new Select(stateDrpDwn);
			state.selectByVisibleText(sState);
			partyPhoneTxtField.sendKeys(sDate);
			partyEmailTxtField.sendKeys(sEmail);
			partyContactTxtField.sendKeys(sContact);
			partyPANTxtField.sendKeys(sPan+sDate);
			partyGSTTxtField.sendKeys(sDate);
			String[] sRegistrationDetails = {"CST", "TIN","ECC","CIN","TAN"};
			for(int i=0;i<7;i++){
				addRegistrationLnk.click();
				Thread.sleep(Constant.Min_Sleep);
				registrationKeyList.get(i+2).sendKeys(sRegistrationDetails[i]);
				registrationValueList.get(i+2).sendKeys(sDate);
			}
			partyDutyPassCheckBx.click();
			partySupplierCheckBx.click();
			partyCustomerCheckBx.click();
			partySave.click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.driver.getPageSource().contains(sDate)){
				Constant.log.info("Party is added with Supplied and customer");
			}else{
				System.err.println("Party failed to add with Supplied and customer");
			}
			navigate.navigateToAccounts();
			navigate.navigateToLedger();
			filterText.sendKeys(sName+sDate);
			if(Constant.driver.getPageSource().contains("Sundry Debtors") && Constant.driver.getPageSource().contains("Sundry Creditors")){
				flag = true;
			}


		}catch(Exception e){
			System.err.println("Ledger update for new party addition failed "+e);
		}
		return flag;
	}

	/**
	 * To verify the mandatory fields in the party
	 * @param iRowNo - indicates excel row no
	 * @return - returns true when the mandatory field warning message is displayed
	 * @throws Exception
	 */

	public boolean mandatoryField() throws Exception{
		boolean flag = false;
		try{
			navigate.navigateToMasters();
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			partySave.click();
			Thread.sleep(Constant.Min_Sleep);
			if(codeReqWarning.isDisplayed() && nameReqWarning.isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Mandatory Party fields failed"+e);
		}
		return flag;
	}

	/**
	 * To verify the cancel button in the import pop up
	 * @return - returns true if the import pop up gets closed after cancel button is clicked
	 * @throws Exception
	 */

	public boolean importCancel() throws Exception{
		boolean flag = false;
		String[] sList = ExcelUtils.ReadCSV("E:\\PartyImport.csv");
		try{
			navigate.navigateToMasters();
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			int iValue = partyNameList.size();
			importParty.click();
			Thread.sleep(Constant.Min_Sleep);
			chooseFile.click();
			Thread.sleep(Constant.Min_Sleep);// wait for page load
			Runtime.getRuntime().exec("E:\\AutoIt.exe");
			Thread.sleep(Constant.Min_Sleep);
			importCancel.click();
			Thread.sleep(Constant.Min_Sleep);
			int iActValue = partyNameList.size();
			String sName = sList[1];
			if((!partyNameList.contains(sName)) && iActValue==iValue){
				flag = true;
			 }

		}catch(Exception e){
			System.err.println("Import Party Cancel failed "+e);
		}
		return flag;
	}

	/**
	 * To verify whether warning message is displayed if import is performed without import file
	 * @return - returns true if the warning message is displayed
	 */

	public boolean importWithoutFile(){
		boolean flag = false;
		try{
			navigate.navigateToMasters();
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			importParty.click();
			Thread.sleep(Constant.Min_Sleep);
			upload.click();
			if(importWarning.isDisplayed()){
				flag = true;
			}
			importCancel.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Import without file failed "+e);
		}
		return flag;
	}

	/**
	 * To verify cancel button in the Party
	 * @param iRowNo - indicated the row no of the test data sheet
	 * @return - returns true if the cancel button click is successful
	 */

	public boolean partyCancel(int iRowNo){
		boolean flag = false;
		try{
			navigate.navigateToMasters();
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			if(!firstParty.isDisplayed()){
				addParty_LedgerUpdate(iRowNo);
			}
			firstParty.click();
			Thread.sleep(Constant.Min_Sleep);
//			partyCancel.click();
			Thread.sleep(Constant.Min_Sleep);
			if(partyCodeTxtField.getText().isEmpty()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Cancel Party details failed "+e);
		}
		return flag;
	}

	/**
	 * TO verify that the code field is enabled after party is deleted
	 * @param iRowNo - indicated the row no of the test data sheet
	 * @return - returns true if the code field is editable
	 */

	public boolean codeFieldEnabled_Delete(int iRowNo){
		boolean flag = false;
		try{
			navigate.navigateToMasters();
			navigate.navigateToParty();
			Thread.sleep(Constant.Min_Sleep);
			if(!firstParty.isDisplayed()){
				addParty_LedgerUpdate(iRowNo);
			}
			firstParty.click();
			Thread.sleep(Constant.Min_Sleep);
			flag = partyCodeTxtField.isEnabled();
		}catch(Exception e){
			System.err.println("Cancel Party details failed "+e);
		}
		return flag;
	}

	public boolean verifyPartyInlineSaveIcon(){
		boolean flag = false;
		try{
			 Actions actions = new Actions(driver);
			 actions.moveToElement(firstParty).moveToElement(partyInlineEditIcon).click().build().perform();
			Thread.sleep(Constant.Min_Sleep);
			partyInlinePhoneNoField.clear();
			partyInlinePhoneNoField.sendKeys(sDate);
			partyInlinesaveIcon.click();
			Thread.sleep(Constant.Min_Sleep);
			okBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.getPageSource().contains(sDate)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Save Party details through inline failed "+e);
		}
		return flag;
	}

	public boolean verifyPartyInlineSave_EnerKey(){
		boolean flag = false;
		try{
			 Actions actions = new Actions(driver);
			 actions.moveToElement(firstParty).moveToElement(partyInlineEditIcon).click().build().perform();
			Thread.sleep(Constant.Min_Sleep);
			partyInlinePhoneNoField.clear();
			partyInlinePhoneNoField.sendKeys(sDate);
			Thread.sleep(Constant.Min_Sleep);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER); //press enter key
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(Constant.Min_Sleep);
			okBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.getPageSource().contains(sDate)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Save Party details by enter key inline save failed "+e);
		}
		return flag;
	}

	/**
	 * To add new tax
	 * @return true, if new tax is added successfully
	 * @throws Exception
	 */

	public boolean addTax(int iRowNo, String sSheet) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sSheet);
		String sTaxtype = xls.get(iRowNo).get("Tax Type");
		boolean flag = false;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load tax view page");
			navigate.showAllEntries();
			int iBeforeAdd = taxList.size();
			addTax.click();
			Thread.sleep(Constant.Min_Sleep);
			taxCodeField.sendKeys("Test"+sDate.substring(8, 13));
			taxNameField.sendKeys("Test"+sDate.substring(8, 13));
			Select select = new Select(taxTypeDropDwn);
			select.selectByValue(sTaxtype);
			compoundLabel.click();
			taxBaseRate.clear();
			taxBaseRate.sendKeys("15.50");
			saveTaxBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			backBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load tax view page");
			navigate.showAllEntries();
			int iAfterAdd = taxList.size();
			if(iAfterAdd > iBeforeAdd && driver.getPageSource().contains("Test"+sDate.substring(8, 13))){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Tax addition failed "+e);
		}
		return flag;
	}

	public boolean updateTax(int iRowNo, String sSheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sSheet);
		String sTaxtype = xls.get(iRowNo).get("Tax Type");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load tax view page");
			navigate.showAllEntries();
			int iBeforeAdd = taxList.size();
			firstTax.click();
			Thread.sleep(Constant.Min_Sleep);
			Select select = new Select(taxTypeDropDwn);
			select.selectByValue(sTaxtype);
			compoundLabel.click();
			taxBaseRate.clear();
			taxBaseRate.sendKeys("15.50");
			saveTaxBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			String sNetRate = taxNetRate.getAttribute("value");
			backBtn.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load tax view page");
			navigate.showAllEntries();
			int iAfterAdd = taxList.size();
			if(iAfterAdd == iBeforeAdd && sNetRate.contains(taxNetRate_List.getText())){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Tax update failed "+e);
		}
		return flag;
	}

	public boolean updateMaterialSupplierJob(){
		boolean flag = false;
		String sDrawingNo = null; int j = 0;
		String sModifiedDate = Constant.CorrectedDate();
		int sPendingCount = 0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load success popup");
			int iBeforeAdd = Integer.parseInt(totalRecords.getText().replaceAll(",", ""));
			String sMaterial = firstMaterial.getText();
			firstMaterial.click();
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			if(categoryDropDwn.isDisplayed()){
		    	sDrawingNo = drawingNoTxt.getAttribute("value");
		    	js.executeScript("window.scrollBy(0,-5000)");
		    	Thread.sleep(Constant.Min_Sleep);
		    	supplier.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=1;i<2;i++){
					supplierName.sendKeys(RandomStringUtils.randomAlphabetic(1));
					Thread.sleep(Constant.Min_Sleep);
					driver.findElement(By.xpath(".//ul[contains(@id,'ui-id')]/li[@class='ui-menu-item']["+i+"]/a")).click();
					Thread.sleep(Constant.Min_Sleep);
					price.sendKeys(Keys.CONTROL+"a");
					price.sendKeys(Keys.DELETE);
					price.sendKeys(""+i+"23.45");
					String sActPrice = ""+i+"23.45";
					effectiveDate.click();
					driver.findElement(By.xpath(".//div[@class='datepicker-days']/table/thead/tr[2]/th[1]")).click();
					driver.findElement(By.xpath(".//div[@class='datepicker-days']/table/tbody/tr[3]/td[4]")).click();
					effectiveTillDate.click();
					driver.findElement(By.xpath(".//div[@class='datepicker-days']/table/thead/tr[2]/th[3]")).click();
					driver.findElement(By.xpath(".//div[@class='datepicker-days']/table/tbody/tr[3]/td[4]")).click();
					remarks.sendKeys("Remarks"+sDate);
					Thread.sleep(Constant.Min_Sleep);
					String sMaterialPrice = materialPrice.getAttribute("value");
					if(sActPrice.contains(sMaterialPrice)){
						Constant.log.info("Price of material for supplier is updated successfully");
					}
					supplierAddBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					j = supplierPriceList.size()-2;
					driver.findElement(By.xpath(".//tr/td[3]/input[@id='id_price_material-"+j+"-is_service']")).click();
				}
				closeSupplierPopup.click();
				Thread.sleep(Constant.Min_Sleep);
				saveMaterialBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material page");
				if(updatePopUpTxt.isDisplayed() && driver.getPageSource().contains(sDrawingNo)){
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					driver.close();
				    driver.switchTo().window(tabs2.get(0));
				    Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material page");
				    navigate.showAllEntries();
					int iAfterAdd = materialList.size();
					driver.findElement(By.linkText(""+sMaterial+"")).click();
					Thread.sleep(Constant.Min_Sleep);
					ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
				    driver.switchTo().window(tabs.get(1));
				    js.executeScript("window.scrollBy(0,-5000)");
			    	Thread.sleep(Constant.Min_Sleep);
				    supplier.click();
					Thread.sleep(Constant.Min_Sleep);
					for(int k=1;k<supplierStatusDropDwnList.size();k++){
						if(driver.findElement(By.xpath(".//*[(@id='id_price_material-"+(k-1)+"-status')]/option[@selected='selected']")).getText().contains("Pending")){
							sPendingCount = sPendingCount +1;
						}
					}
					closeSupplierPopup.click();
					Thread.sleep(Constant.Min_Sleep);
					if(iAfterAdd == iBeforeAdd && driver.getPageSource().contains(sDate)){
						driver.close();
					    driver.switchTo().window(tabs2.get(0));
					    driver.navigate().refresh();
					    Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material page");
					    filterIcon.click();
					    filterPriceProfileOption.click();
						applyBTN.click();
						Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
					    WebElement ele = driver.findElement(By.xpath(".//a[contains(text(),'"+sMaterial+"')]/following::td[4][contains(text(),'"+(sPendingCount)+" - Pending')]/following::td[contains(text(),'"+sModifiedDate+"')][1]"));
						if(ele.isDisplayed()){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Material update with supplier job service failed "+e);
		}
		return flag;
	}

	public boolean rejectSupplierPrice(int rowNo, String sheet){
		boolean flag = false;
		String sModifiedDate = Constant.CorrectedDate();
		String sMaterial = null, sReviewedCount = null; String[] sPriceProfile = null;
		int j=0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load success popup");
			filterIcon.click();
			filterPriceProfileOption.click();
			applyBTN.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
			navigate.showAllEntries();
			for(int i=0;i<priceProfileStatusColumn.size();i++){
				js.executeScript("arguments[0].scrollIntoView(true);", priceProfileStatusColumn.get(i));
				if(priceProfileStatusColumn.get(i).getText().contains("Pending")){
					sPriceProfile = priceProfileStatusColumn.get(i).getText().split("-");
					if(Integer.parseInt(sPriceProfile[0].trim()) > 0){
						if(priceProfileStatusColumn.get(i).getText().contains("Reviewed")){
							String[] sReview = sPriceProfile[1].trim().split(" ");
							sReviewedCount = sReview[1].trim();
						}
						sMaterial = driver.findElement(By.xpath(".//*[@id='searchResult']/tbody/tr["+(i+1)+"]/td[7]/preceding-sibling::td[4]/a[1]")).getText();
						driver.findElement(By.linkText(sMaterial)).click();
						Thread.sleep(Constant.Min_Sleep);
						j = i;
						break;
					}
				}
			}
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			Constant.waitFor(ExpectedConditions.elementToBeClickable(supplier), "Failed to load material edit page");
			if(currentPageHeader.getText().equals(sMaterial)){
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
				supplier.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<supplierStatusDropDwnList.size()-1;i++){
					if(driver.findElement(By.xpath(".//*[(@id='id_price_material-"+(i)+"-status')]/option[@selected='selected']")).getText().contains("Pending")){
						Select select = new Select(driver.findElement(By.id("id_price_material-"+(i)+"-status")));
						select.selectByVisibleText("Rejected");
						driver.findElement(By.id("id_price_material-"+(i)+"-reject_remarks")).sendKeys("Not correct price "+sDate);
						js.executeScript("window.scrollBy(0,-5000)");
						break;
					}
				}
				closeSupplierPopup.click();
				Thread.sleep(Constant.Min_Sleep);
				saveMaterialBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load success popup");
				Constant.waitForPageLoad();
				if(updatePopUpTxt.isDisplayed()){
					okBtn.click();
					if(sReviewedCount == null){
						sReviewedCount = "0";
					}
					filterIcon.click();
					filterPriceProfileOption.click();
					applyBTN.click();
					Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//a[contains(text(),'"+sMaterial+"')]")));
				    WebElement ele = driver.findElement(By.xpath(".//a[contains(text(),'"+sMaterial+"')]/following::td[4][contains(text(),'"+(Integer.parseInt(sPriceProfile[0].trim())-1)+" - Pending')]/following::td[contains(text(),'"+sModifiedDate+"')][1]"));
				    if(ele.isDisplayed() && priceProfileStatusColumn.get(0).getText().contains((Integer.parseInt(sReviewedCount)+1)+" - Reviewed")){
				    	driver.close();
					    driver.switchTo().window(tabs2.get(0));
					    Thread.sleep(Constant.Min_Sleep);
					    driver.findElement(By.linkText(sMaterial)).click();
					    ArrayList<String> tabs3 = new ArrayList<> (driver.getWindowHandles());
						driver.switchTo().window(tabs3.get(1));
					    Thread.sleep(Constant.Min_Sleep);
					    supplier.click();
						Thread.sleep(Constant.Min_Sleep);
					    if(driver.getPageSource().contains(sDate)){
					    	flag = true;
					    }
					    closeSupplierPopup.click();
						Thread.sleep(Constant.Min_Sleep);
					    driver.close();
					    driver.switchTo().window(tabs3.get(0));
					    Thread.sleep(Constant.Min_Sleep);
				    }
				}
			}
		}catch(Exception e){
			System.err.println("Failed to reject supplier price "+e);
		}
		return flag;
	}

	public boolean resubmitSupplierPrice(int rowNo, String sheet){
		boolean flag = false;
		String sModifiedDate = Constant.CorrectedDate();
		String sMaterial = null; String[] sPriceProfile = null, sReviewedCount = null;
		int j=0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load success popup");
			filterIcon.click();
			filterPriceProfileOption.click();
			applyBTN.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
			navigate.showAllEntries();
			for(int i=0;i<priceProfileStatusColumn.size();i++){
				js.executeScript("arguments[0].scrollIntoView(true);", priceProfileStatusColumn.get(i));
				if(priceProfileStatusColumn.get(i).getText().contains("Reviewed")){
					sPriceProfile = priceProfileStatusColumn.get(i).getText().split("-");
					sReviewedCount = sPriceProfile[1].split(" ");
					sMaterial = driver.findElement(By.xpath(".//*[@id='searchResult']/tbody/tr["+(i+1)+"]/td[7]/preceding-sibling::td[4]/a[1]")).getText();
					driver.findElement(By.linkText(sMaterial)).click();
					Thread.sleep(Constant.Min_Sleep);
					j = i;
					break;
				}
			}
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			Constant.waitFor(ExpectedConditions.elementToBeClickable(supplier), "Failed to load material edit page");
			if(currentPageHeader.getText().equals(sMaterial)){
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
				supplier.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<supplierStatusDropDwnList.size()-1;i++){
					Select select = new Select(rejectedStatusDrpDwn.get(i));
					select.selectByVisibleText("Re-Submit");
					break;
				}
				closeSupplierPopup.click();
				Thread.sleep(Constant.Min_Sleep);
				saveMaterialBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load success popup");
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
				if(updatePopUpTxt.isDisplayed()){
					okBtn.click();
					if(sReviewedCount[2] == null){
						sReviewedCount[2] = "0";
					}
					Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
					filterIcon.click();
					filterPriceProfileOption.click();
					applyBTN.click();
					Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
					navigate.showAllEntries();
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//a[contains(text(),'"+sMaterial+"')]")));
					Thread.sleep(Constant.Min_Sleep);
					WebElement ele = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sMaterial+"')]/following::td[4][contains(text(),'"+(Integer.parseInt(sPriceProfile[0].trim())+1)+" - Pending')]/following::td[contains(text(),'"+sModifiedDate+"')][1]"));
				    if(!priceProfileStatusColumn.get(j).getText().contains("Reviewed") && ele.isDisplayed()){
				    	flag = true;
				    }else if(priceProfileStatusColumn.get(j).getText().contains((Integer.parseInt(sReviewedCount[2].trim())-1)+" - Reviewed") && ele.isDisplayed()){
				    	flag = true;
				    }
				    driver.close();
				    driver.switchTo().window(tabs2.get(0));
				    Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to resubmit supplier price "+e);
		}
		return flag;
	}

	public boolean removeSupplierPrice(int rowNo, String sheet){
		boolean flag = false;
		String sModifiedDate = Constant.CorrectedDate();
		String sMaterial = null, sReviewedCount = null; String[] sPriceProfile = null;
		int j=0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load success popup");
			filterIcon.click();
			filterPriceProfileOption.click();
			applyBTN.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
			navigate.showAllEntries();
			for(int i=0;i<priceProfileStatusColumn.size();i++){
				js.executeScript("arguments[0].scrollIntoView(true);", priceProfileStatusColumn.get(i));
				if(priceProfileStatusColumn.get(i).getText().contains("Reviewed")){
					sPriceProfile = priceProfileStatusColumn.get(i).getText().split("-");
					String[] sReview = sPriceProfile[1].trim().split(" ");
					sReviewedCount = sReview[1].trim();
					sMaterial = driver.findElement(By.xpath(".//*[@id='searchResult']/tbody/tr["+(i+1)+"]/td[7]/preceding-sibling::td[4]/a[1]")).getText();
					driver.findElement(By.linkText(sMaterial)).click();
					Thread.sleep(Constant.Min_Sleep);
					j = i;
					break;
				}
			}
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			if(currentPageHeader.getText().equals(sMaterial)){
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
				supplier.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<supplierStatusDropDwnList.size()-1;i++){
//					if(rejectedStatusDrpDwn.get(i).getAttribute("data-original-title").contains("Rejected due to")){
						Select select = new Select(driver.findElement(By.xpath(".//select[contains(@id,'status_select')]")));
						select.selectByVisibleText("Remove");
						break;
//					}
				}
				closeSupplierPopup.click();
				Thread.sleep(Constant.Min_Sleep);
				saveMaterialBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load success popup");
				Constant.waitForPageLoad();
				if(updatePopUpTxt.isDisplayed()){
					okBtn.click();
					navigate.showAllEntries();
					if(sReviewedCount.equals(null)){
						sReviewedCount = "0";
					}
					filterIcon.click();
					filterPriceProfileOption.click();
					applyBTN.click();
					Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+sMaterial+"')]")));
					Thread.sleep(Constant.Min_Sleep);
					WebElement ele = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sMaterial+"')]/following::td[4][contains(text(),'"+(Integer.parseInt(sPriceProfile[0].trim()))+" - Pending')]/following::td[contains(text(),'"+sModifiedDate+"')][1]"));
				    if(!priceProfileStatusColumn.get(j).getText().contains("Reviewed") && ele.isDisplayed()){
				    	flag = true;
				    }else if(priceProfileStatusColumn.get(j).getText().contains((Integer.parseInt(sReviewedCount)-1)+" - Reviewed") && ele.isDisplayed()){
				    	flag = true;
				    }
				    driver.close();
				    driver.switchTo().window(tabs2.get(0));
				    Thread.sleep(Constant.Min_Sleep);
				}
			}
		}catch(Exception e){
			System.err.println("Failed to remove supplier price "+e);
		}
		return flag;
	}

	public boolean approveSupplierPrice(int rowNo, String sheet){
		boolean flag = false;
		String sModifiedDate = Constant.CorrectedDate();
		String sMaterial = null; String[] sPriceProfile = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load success popup");
			filterIcon.click();
			filterPriceProfileOption.click();
			applyBTN.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
			navigate.showAllEntries();
			for(int i=0;i<priceProfileStatusColumn.size();i++){
				js.executeScript("arguments[0].scrollIntoView(true);", priceProfileStatusColumn.get(i));
				if(priceProfileStatusColumn.get(i).getText().contains("Pending")){
					sPriceProfile = priceProfileStatusColumn.get(i).getText().split("-");
					if(Integer.parseInt(sPriceProfile[0].trim()) > 0){
						sMaterial = driver.findElement(By.xpath(".//*[@id='searchResult']/tbody/tr["+(i+1)+"]/td[7]/preceding-sibling::td[4]/a[1]")).getText();
						driver.findElement(By.linkText(sMaterial)).click();
						Thread.sleep(Constant.Min_Sleep);
						break;
					}
				}
			}
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			if(currentPageHeader.getText().equals(sMaterial)){
				js.executeScript("window.scrollBy(0,-5000)");
				Thread.sleep(Constant.Min_Sleep);
				supplier.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=1;i<supplierStatusDropDwnList.size();i++){
					if(driver.findElement(By.xpath(".//*[(@id='id_price_material-"+(i-1)+"-status')]/option[@selected='selected']")).getText().contains("Pending")){
						Select select = new Select(driver.findElement(By.id("id_price_material-"+(i-1)+"-status")));
						select.selectByVisibleText("Approved");
						break;
					}
				}
				closeSupplierPopup.click();
				Thread.sleep(Constant.Min_Sleep);
				saveMaterialBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load success popup");
				if(updatePopUpTxt.isDisplayed()){
					okBtn.click();
					navigate.showAllEntries();
					filterIcon.click();
					filterPriceProfileOption.click();
					applyBTN.click();
					Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//td/a[contains(text(),'"+sMaterial+"')]")));
				    WebElement ele = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sMaterial+"')]/following::td[4][contains(text(),'"+(Integer.parseInt(sPriceProfile[0].trim())-1)+" - Pending')]/following::td[contains(text(),'"+sModifiedDate+"')][1]"));
				    if(ele.isDisplayed()){
				    	flag = true;
				    }
				}
				driver.close();
			    driver.switchTo().window(tabs2.get(0));
			    Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to approve supplier price "+e);
		}
		return flag;
	}

	public boolean addSupplier(int iRowNo, String sSheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sSheet);
		String sSupplierName = xls.get(iRowNo).get("Supplier Name");
		if(sNorDate.startsWith("0")){
			sNorDate = sNorDate.substring(1);
		}
		try{
			supplierName.sendKeys(sSupplierName);
			driver.findElement(By.xpath(".//a[contains(text(),'"+sSupplierName+"')]")).click();
			String sPrice = materialPrice.getAttribute("value");
			supplierPrice.sendKeys(Double.toString(Double.parseDouble(sPrice)+1));
			Select select = new Select(supplierCurrency);
			select.selectByVisibleText("INR");
			supplier_EffectiveSince.click();
			driver.findElement(By.xpath(".//td[contains(@class,'today') and  text()='"+sNorDate+"']")).click();
			supplierRemarks.sendKeys(sDate);
			addSupplier.click();
			String sSupplier = addedSupplier.getAttribute("value");
			if(sSupplier.contains(sSupplierName)){
				flag = true;
			}
			saveMaterialBtn.click();
			okBtn.click();
		}catch(Exception e){
			System.err.println("Supplier addition failed "+e);
		}
		return flag;
	}

	public String fetchStock(int iRowNo, String sSheet){
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sSheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sStock = "0";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String[] sMat =  sMaterial.split("-");
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
			filterText.sendKeys(sMat[0].trim());
			driver.findElement(By.xpath("//a/mark[contains(text(),'"+sMat[0].trim()+"')]")).click();
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			if(currentPageHeader.getText().contains(sMat[0].trim())){
			  	js.executeScript("window.scrollBy(0,-5000)");
			  	Thread.sleep(Constant.Min_Sleep);
				availableStock.click();
				Thread.sleep(Constant.Min_Sleep);
				if(sMaterial.contains("[")){
					String[] sMake = sMat[1].split("\\[");
					if(Constant.isElementPresent(By.xpath("//td[text()='"+sMake[1].substring(0, sMake[1].length()-1)+"']/following::td[1]"))){
						sStock = driver.findElement(By.xpath("//td[text()='"+sMake[1].substring(0, sMake[1].length()-1)+"']/following::td[1]")).getText();
					}
				}else if(Constant.isElementPresent(By.xpath("//td[text()='-NA-']/following::td[1]"))){
					sStock = stockWOMake.getText();
				}
				driver.close();
			    driver.switchTo().window(tabs2.get(0));
			    Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to fetch stock value "+e);
		}
		return sStock;
	}

	public boolean validateStockWOMake(int iRowNo, String sSheet, String sStock) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sSheet);
		String sMaterial = xls.get(iRowNo).get("Material");
		String sQuantity = xls.get(iRowNo).get("Quantity");
		String sAltUnit = xls.get(iRowNo).get("Alternate unit");
		String sScaleFactor = "1";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
			filterText.sendKeys(sMaterial);
			driver.findElement(By.xpath("//a/mark[contains(text(),'"+sMaterial+"')]")).click();
			Thread.sleep(Constant.Min_Sleep);
			ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			if(currentPageHeader.getText().contains(sMaterial)){
				if(sAltUnit.contains("Yes")){
					if(Integer.parseInt(altUnitCount.getText().trim()) > 0){
						altUnitCount.click();
						Thread.sleep(Constant.Min_Sleep);
						sScaleFactor = altUnitScaleFactor.get(1).getAttribute("value");
						alternateUnitClose.click();
					}
				}
				js.executeScript("window.scrollBy(0,-5000)");
			  	Thread.sleep(Constant.Min_Sleep);
				availableStock.click();
				Thread.sleep(Constant.Min_Sleep);
				String sActStock = stockWOMake.getText();
				if((Double.parseDouble(sScaleFactor)*Double.parseDouble(sQuantity))+Double.parseDouble(sStock) == Double.parseDouble(sActStock)){
					flag = true;
				}
				driver.close();
			    driver.switchTo().window(tabs2.get(0));
			    Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Stock validation without make failed "+e);
		}
		return flag;
	}

	public int materialCountWithNonStock(){
		int iCount = 0;
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(filterText), "Failed to load material view page");
			filterIcon.click();
			filterNonStockOption.click();
			applyBTN.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(applyBTN), "Failed to load material view page");
			iCount = Integer.parseInt(totalRecords.getText().replaceAll(",", ""));
		}catch(Exception e){
			System.err.println("Auto created material validation failed "+e);
		}
		return iCount;
	}

}
