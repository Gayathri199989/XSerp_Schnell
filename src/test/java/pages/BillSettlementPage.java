package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utility.Constant;
import utility.ExcelUtils;
import utility.NavigateToPages;
import utility.ReadPropertyFile;

public class BillSettlementPage {

	ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);

	@FindBy(xpath="//div[@id='payment_creditors_chosen']//span[contains(text(),'--Select Ledger--')]")
	private WebElement selectParty;

	@FindBy(xpath="//div[@id='payment_creditors_chosen']//input")
	private WebElement enterPartySearchTxt;

	@FindBy(id="unsettled_advance")
	private WebElement advanceAmt;

	@FindBy(id="id_payment_amt")
	private WebElement paymentAmt;

	@FindBy(xpath="//div[@id='fund_ledgers_chosen']//span[contains(text(),'--Select Ledger--')]")
	private WebElement paidFrom;

	@FindBy(id="settle_outstanding")
	private WebElement settleOutstandingBtn;

	@FindBy(xpath="//a[contains(@class,'reset_adv_amt')]//i")
	private WebElement resetAdvAmt;

	@FindBy(xpath="//table[@id='party_bill_details']//tbody/tr/td[7]/span")
	private List<WebElement> pendingBillAmtList;

	@FindBy(xpath="//table[@id='party_bill_details']//tbody/tr/td[2]")
	private List<WebElement> BillNoList;

	@FindBy(xpath="//input[contains(@id,'settled_amount')]")
	private List<WebElement> settlementAmtList;

	@FindBy(xpath="//input[contains(@id,'paid_amount')]")
	private List<WebElement> paidAmtList;

	@FindBy(xpath="//input[contains(@id,'paid_amount')][contains(@class,'error-border')]")
	private List<WebElement> paidAmtErrorList;

	@FindBy(id="create_payment_voucher")
	private WebElement createVoucher;

	@FindBy(xpath="//p[contains(text(),'Voucher ')]")
	private WebElement successPopup;

	@FindBy(xpath="//table[@id='particulars_table']//tbody/tr/td[2]/form/a")
	private List<WebElement> AdvanceVoucherList;

	@FindBy(id="bill_settlement")
	private WebElement settleBTN;

	@FindBy(id="btn-sa-confirm")
	private WebElement okBtn;

	@FindBy(xpath="//div[@id='particulars_listing']//button[@class='btn btn-default'][contains(text(),'Close')]")
	private WebElement AdvCloseBtn;

	@FindBy(xpath=".//button[contains(@class,'btn-filter')]")
	private WebElement btnFilter;

	@FindBy(id="reportrange")
	private WebElement dateCalendarDrpDown;

	@FindBy(id="id-filter-voucher")
	private WebElement searchVoucher;

	@FindBy(id="filter_textbox")
	private WebElement filterText;

	@FindBy(id="enable_edit_voucher") WebElement editVoucherBtn;

	@FindBy(xpath="//a[@role='button']/span[@class='bill-list']")
	private WebElement billBTN;

	@FindBy(xpath="//div[@id='fund_ledgers_chosen']//input[@class='chosen-search-input']")
	private WebElement paidFromSearch;

	private WebDriver driver;
	public BillSettlementPage(WebDriver driver){
		this.driver = driver;
	}

	public boolean billSettlement_Advance(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		try{
			selectParty.click();
			enterPartySearchTxt.sendKeys(sParty);
			driver.findElement(By.xpath(".//em[text()='"+sParty+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			settleOutstandingBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			resetAdvAmt.click();
			Thread.sleep(Constant.Min_Sleep);
			String[] sBillNo = enterAmtFromAdvance();
			settleBTN.click();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.getPageSource().contains("Unused Balance Available")){
				okBtn.click();
			}
			Thread.sleep(Constant.Min_Sleep);
			okBtn.click();
			navigate.navigateToAccounts();
			Thread.sleep(Constant.Min_Sleep);
			navigate.navigateToVoucher();
			Thread.sleep(Constant.Min_Sleep);
			flag = validateSettledAdvancedBill(sBillNo[0], sBillNo[1]);
		}catch(Exception e){
			System.err.println("Bill settlement from advance failed"+e);
		}
		return flag;
	}

	public boolean validateSettledAdvancedBill(String sBillNo, String sVoucher){
		boolean flag = false;
		String sDateRangeOption;
		try{
			if(Constant.currentFY().contains(sVoucher.substring(0, 5))){
				sDateRangeOption = "Current Financial Year";
			}else{
				sDateRangeOption = "Last Financial Year";
			}
			btnFilter.click();
			dateCalendarDrpDown.click();
			driver.findElement(By.xpath("//li[contains(text(),'"+sDateRangeOption+"')]")).click();
			searchVoucher.click();
			Constant.waitFor(ExpectedConditions.invisibilityOf(searchVoucher), "Failed to load GRN view page");
			Thread.sleep(Constant.Min_Sleep);
			filterText.sendKeys(sVoucher);
			driver.findElement(By.xpath("//mark[contains(text(),'"+sVoucher+"')]")).click();
			Thread.sleep(Constant.Min_Sleep);
//			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//		    driver.switchTo().window(tabs2.get(1));
		    editVoucherBtn.click();
		    Thread.sleep(Constant.Min_Sleep);
		    if(billBTN.getText().contains(sBillNo)){
		    	flag = true;
		    }
//		    driver.close();
//		    driver.switchTo().window(tabs2.get(0));
		}catch(Exception e){
			System.err.println("Bill settlement from advance failed"+e);
		}
		return flag;
	}

	public String[] enterAmtFromAdvance(){
		String sBillNo = null, sVoucherNo = null;
		try{
			String sAdvance = advanceAmt.getText();
			if(Double.parseDouble(sAdvance) > 0){
				for(int i=0;i<pendingBillAmtList.size();i++){
					sBillNo = BillNoList.get(i).getText();
					advanceAmt.click();
					Thread.sleep(Constant.Min_Sleep);
					sVoucherNo = AdvanceVoucherList.get(i).getAttribute("innerHTML");
					AdvCloseBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					settlementAmtList.get(i).sendKeys(Keys.CONTROL+"a");
					settlementAmtList.get(i).sendKeys(Keys.DELETE);
					settlementAmtList.get(i).clear();
					if(Double.parseDouble(sAdvance) > 100){
						if(Double.parseDouble(pendingBillAmtList.get(i).getText()) > 100){
							settlementAmtList.get(i).sendKeys("100");
						}else{
							settlementAmtList.get(i).sendKeys(pendingBillAmtList.get(i).getText());
						}
					}else{
						if(Double.parseDouble(pendingBillAmtList.get(i).getText()) > Double.parseDouble(sAdvance)){
							settlementAmtList.get(i).sendKeys(sAdvance);
						}else{
							settlementAmtList.get(i).sendKeys(pendingBillAmtList.get(i).getText());
						}
					}
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Bill settlement from advance failed"+e);
		}
		return new String[] {sBillNo, sVoucherNo};
	}

	public boolean CreateVoucher_Amount(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sBank = xls.get(iRowNo).get("Paid From Ledger");
		String sBillNo = null, sVoucherNo = null;
		try{
			selectParty.click();
			enterPartySearchTxt.sendKeys(sParty);
			driver.findElement(By.xpath(".//em[text()='"+sParty+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			settleOutstandingBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			sBillNo = BillNoList.get(0).getText();
			resetAdvAmt.click();
			Thread.sleep(Constant.Min_Sleep);
			paymentAmt.sendKeys(Keys.CONTROL+"a");
			paymentAmt.sendKeys(Keys.DELETE);
			paymentAmt.sendKeys("100");
			paidFrom.click();
			paidFromSearch.sendKeys(sBank.trim());
			driver.findElement(By.xpath(".//em[text()='"+sBank.trim()+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(Double.parseDouble(paidAmtList.get(0).getAttribute("value")) > 0){
				createVoucher.click();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.getPageSource().contains("No! Create Voucher")){
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					sVoucherNo = successPopup.getText().substring(8, 23);
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToAccounts();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToVoucher();
					Thread.sleep(Constant.Min_Sleep);
					filterText.sendKeys(sVoucherNo);
					driver.findElement(By.xpath("//mark[contains(text(),'"+sVoucherNo+"')]")).click();
					Thread.sleep(Constant.Min_Sleep);
					ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
				    driver.switchTo().window(tabs2.get(1));
				    editVoucherBtn.click();
				    Thread.sleep(Constant.Min_Sleep);
				    if(billBTN.getText().contains(sBillNo)){
				    	flag = true;
				    }
				    driver.close();
				    driver.switchTo().window(tabs2.get(0));
				}
			}
		}catch(Exception e){
			System.err.println("Bill settlement from advance failed"+e);
		}
		return flag;
	}

	public boolean CreateVoucherNSettle_AmountNAdv(int iRowNo, String sheet) throws Exception{
		boolean flag = false, flag1 = false, flag2;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sParty = xls.get(iRowNo).get("Party");
		String sBank = xls.get(iRowNo).get("Paid From Ledger");
		String sBillNo = null, sVoucherNo = null;
		int i;
		try{
			selectParty.click();
			enterPartySearchTxt.sendKeys(sParty);
			driver.findElement(By.xpath(".//em[text()='"+sParty+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			settleOutstandingBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			sBillNo = BillNoList.get(0).getText();
			resetAdvAmt.click();
			Thread.sleep(Constant.Min_Sleep);
			paymentAmt.sendKeys(Keys.CONTROL+"a");
			paymentAmt.sendKeys(Keys.DELETE);
			paymentAmt.sendKeys("100");
			paidFrom.click();
			paidFromSearch.sendKeys(sBank.trim());
			driver.findElement(By.xpath(".//em[text()='"+sBank.trim()+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			String[] sVoucherValues = enterAmtFromAdvance();
			paidAmtList.get(0).click();
			Thread.sleep(Constant.Min_Sleep);
			for(i=0;i<paidAmtErrorList.size();i++){
				paidAmtErrorList.get(i).sendKeys(Keys.CONTROL+"a");
				paidAmtErrorList.get(i).sendKeys(Keys.DELETE);
			}
			if(Double.parseDouble(paidAmtList.get(i).getAttribute("value")) > 0){
				createVoucher.click();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.getPageSource().contains("No! Create Voucher")){
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					sVoucherNo = successPopup.getText();
					sVoucherNo = sVoucherNo.substring(sVoucherNo.indexOf("Voucher")+8).substring(0, 15);
					okBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToAccounts();
					Thread.sleep(Constant.Min_Sleep);
					navigate.navigateToVoucher();
					Thread.sleep(Constant.Min_Sleep);
					filterText.sendKeys(sVoucherNo);
					driver.findElement(By.xpath("//mark[contains(text(),'"+sVoucherNo+"')]")).click();
					Thread.sleep(Constant.Min_Sleep);
					ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
				    driver.switchTo().window(tabs2.get(1));
				    editVoucherBtn.click();
				    Thread.sleep(Constant.Min_Sleep);
				    if(billBTN.getText().contains(sBillNo)){
				    	flag1 = true;
				    }
				    driver.close();
				    driver.switchTo().window(tabs2.get(0));
				}
			}
			 flag2 = validateSettledAdvancedBill(sVoucherValues[0], sVoucherValues[1]);
			 if(flag1 && flag2){
				 flag = true;
			 }
		}catch(Exception e){
			System.err.println("Bill settlement from advance failed"+e);
		}
		return flag;
	}

}
