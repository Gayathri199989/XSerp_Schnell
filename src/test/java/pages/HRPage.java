package pages;

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

public class HRPage {

	ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	NavigateToPages navigate = PageFactory.initElements(Constant.driver, NavigateToPages.class);

	@FindBy(xpath=".//a[@data-original-title='Add New Employee']") WebElement employeeAddBtn;

	@FindBy(id="saveEmployee") WebElement empSave;

	@FindBy(xpath=".//span[text()='Code is required.']")
	private WebElement codeMandatoryWarning;

	@FindBy(xpath=".//span[text()='Name is required.']")
	private WebElement nameMandatoryWarning;

	@FindBy(xpath=".//*[@id='addCustomer']/div[3]/a[text()='Cancel']") WebElement cancelBtn;

	@FindBy(xpath=".//*[@id='employeeList']/tbody/tr[1]/td[1]/form/a") WebElement firstEmployee;

	@FindBy(xpath=".//a[@data-original-title='Add New Pay Structure']") WebElement payStructureAddTab;

	@FindBy(id="save_pay_button") WebElement savePayBtn;

	@FindBy(xpath=".//*[@id='addPay']/div[4]/div[2]/a[text()='Cancel']") WebElement cancelPayBtn;

	@FindBy(xpath=".//*[@id='payList']/tbody/tr[1]/td[2]/form/a") WebElement firstPayStruct;

	@FindBy(xpath=".//a[text()='Import Attendance Details']") WebElement importAttendace;

	@FindBy(id="upload_month_wise_report") WebElement uploadImportAttendance;

	@FindBy(id="cmdhideUpload") WebElement cancelUpload;

	@FindBy(xpath="//tbody/tr/td[1]/a")
	private List<WebElement> employeesList;

	@FindBy(id="id_emp_code")
	private WebElement empCode;

	@FindBy(id="id_first_name")
	private WebElement empFirstName;

	@FindBy(id="id_last_name")
	private WebElement empLastName;

	@FindBy(id="id_phone_no")
	private WebElement empPhone;

	@FindBy(id="id_email")
	private WebElement empEmail;

	@FindBy(xpath=".//div[text()='Upload Image']")
	private WebElement uploadImage;

	@FindBy(xpath=".//a[text()='Apply']")
	private WebElement applyBtn;

	@FindBy(xpath=".//a[contains(text(),'Work')]")
	private WebElement workTab;

	@FindBy(id="id_department_id")
	private WebElement empDept;

	@FindBy(xpath="//h4[contains(text(),'ADD DEPARTMENT')]")
	private WebElement addDptPopup;

	@FindBy(id="id_department-name")
	private WebElement empDeptName;

	@FindBy(id="id_department-parent_id")
	private WebElement empDeptParentDrpDwn;

	@FindBy(id="save_department_button")
	private WebElement saveDptButton;

	@FindBy(id="id_employment_type")
	private WebElement employmentType;

	@FindBy(id="id_status")
	private WebElement status;

	@FindBy(id="date_of_joining")
	private WebElement dateOfJoining;

	@FindBy(id="id_designation")
	private WebElement designation;

	@FindBy(xpath="//td[contains(@class,'day')][contains(text(),'12')]")
	private WebElement dateSelect;

	@FindBy(id="id_pay_structure_id")
	private WebElement payStructure;

	@FindBy(id="add_pay")
	private WebElement editPayStruct;

	@FindBy(xpath=".//*[@id='pay_list']/tbody/tr/td[3]/input")
	private List<WebElement> payStructDetailsList;

	@FindBy(xpath=".//*[@id='employee_pay_structure_div']/div/div/div[1]/button[text()='�']")
	private WebElement closePayStruc;

	@FindBy(id="id_place_of_work")
	private WebElement empPlaceOfWrk;

	@FindBy(id="id_no_of_el")
	private WebElement elDetails;

	@FindBy(id="id_no_of_cl")
	private WebElement clDetails;

	@FindBy(id="id_address1")
	private WebElement empAddress1;

	@FindBy(id="id_address2")
	private WebElement empAddress2;

	@FindBy(id="id_city")
	private WebElement empCity;

	@FindBy(xpath=".//select[contains(@id,'id_country')]")
	private WebElement empCountry;

	@FindBy(id="id_blood_group")
	private WebElement empBloodGRP;

	@FindBy(xpath=".//select[contains(@id,'id_state')]")
	private WebElement empState;

	@FindBy(xpath=".//a[contains(text(),'Personal Details')]")
	private WebElement personalDetailsTab;

	@FindBy(xpath=".//a[contains(text(),'Bank Details')]")
	private WebElement bankDetailsTab;

	@FindBy(xpath=".//*[@id='collapseThree']/div/div[1]/input[2]")
	private WebElement dateOfBirth;

	@FindBy(id="id_gender")
	private WebElement gender;

	@FindBy(id="id_account_number")
	private WebElement acctNumber;

	@FindBy(id="id_account_type")
	private WebElement acctType;

	@FindBy(id="id_ifsc_code")
	private WebElement ifscCode;

	@FindBy(id="id_account_name")
	private WebElement acctName;

	@FindBy(id="id_pan_number")
	private WebElement panNumber;

	@FindBy(id="ifcs_bank_name")
	private WebElement ifscBankName;

	@FindBy(id="id_postal_code")
	private WebElement postalCode;

	@FindBy(id="id_father_name")
	private WebElement fatherName;

	@FindBy(id="id_mother_name")
	private WebElement motherName;

	@FindBy(id="id_contact_number")
	private WebElement contactNumber;

	@FindBy(id="id_nationality")
	private WebElement nationality;

	@FindBy(id="id_martial_status")
	private WebElement maritalStatus;

	@FindBy(id="id_aadhar_number")
	private WebElement aadharNum;

	@FindBy(id="id_esi_no")
	private WebElement esiNum;

	@FindBy(id="id_pf_no")
	private WebElement pfNo;

	@FindBy(id="search")
	public WebElement search;

	@FindBy(xpath=".//*[@id='employeeList']/tbody/tr/td[1]/a")
	private List<WebElement> employeeList;

	@FindBy(xpath=".//*[@id='payList']/tbody/tr/td[2]/span/a")
	private List<WebElement> noOfPayStruct;

	@FindBy(id="id_pay-description")
	private WebElement payStructureName;

	@FindBy(xpath=".//*[@id='id_pay_structure-__prefix__-type']/option")
	private List<WebElement> itemType;

	@FindBy(id="id_pay_structure-__prefix__-description")
	private WebElement payStructureDesc;

	@FindBy(id="add_new_pay_details")
	private WebElement addNewPayDetails;

	@FindBy(xpath=".//h2[text()='Success']")
	private WebElement payStructSavedSuccessPopUP;

	@FindBy(xpath=".//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath=".//*[@id='pay_details']/tbody/tr/td/a/i")
	private List<WebElement> deleteItemList;

	@FindBy(id="btn-sa-confirm")
	private WebElement confirmBtn;

	@FindBy(id="attendance_month")
	private WebElement monthYrAttendance;

	@FindBy(xpath=".//span[text()='Attachment']")
	private WebElement attachmentBtn;

	@FindBy(id="attendance_search_month")
	private WebElement attendanceSearchMonth;

	@FindBy(id="search_report")
	private WebElement searchReport;

	String sDate = Constant.DateTimeFormat();

	private WebDriver driver;
	public HRPage(WebDriver driver){
		this.driver = driver;
	}

	/**
	 * To add employee
	 * @param iRowNo
	 * @return true, if employee is added
	 * @throws Exception
	 */

	public boolean addEmployee(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sDept = xls.get(iRowNo).get("Department");
		String sEmpType = xls.get(iRowNo).get("Employment type");
		String sPayStruct = xls.get(iRowNo).get("Pay Structure");
		String sStatus = xls.get(iRowNo).get("Status");
		String sCity = xls.get(iRowNo).get("City");
		String sState = xls.get(iRowNo).get("State");
		String sEmail = xls.get(iRowNo).get("Email");
		String sAddress1 = xls.get(iRowNo).get("Address1");
		try{
			navigate.showAllEntries();
			int iValue = employeesList.size();
			employeeAddBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(empCode.isDisplayed()){
				empCode.sendKeys("Emp"+sDate.substring(7));
				empFirstName.sendKeys("Automation"+sDate);
				empLastName.sendKeys("Automation");
				empEmail.sendKeys(sEmail);
				empPhone.sendKeys(sDate);
				uploadImage.click();
				Thread.sleep(Constant.Min_Sleep);
				Constant.attachFile();
//				Runtime.getRuntime().exec("E:\\EmployeePhoto.exe");//execute AutoIT to upload import file
				Thread.sleep(Constant.Min_Sleep);
				applyBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				workTab.click();
				Select selectEmpDept = new Select(empDept);
				selectEmpDept.selectByVisibleText(sDept);
				Select selectEmpType = new Select(employmentType);
				selectEmpType.selectByVisibleText(sEmpType);
				Select selectStatus = new Select(status);
				selectStatus.selectByVisibleText(sStatus);
				dateOfJoining.click();
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//				dateSelect.click();
				driver.findElement(By.xpath("//td[@class='day'][contains(text(),'"+Constant.lastDateOfMonth()+"')]")).click();
				designation.sendKeys("Quality Analyst");
				Select selectPayStruc = new Select(payStructure);
				selectPayStruc.selectByVisibleText(sPayStruct);
				editPayStruct.click();
				Thread.sleep(Constant.Min_Sleep);
				for (WebElement element : payStructDetailsList) {
					element.sendKeys(Keys.CONTROL+"a");
					element.sendKeys(Keys.DELETE);
					element.sendKeys("500");
				}
				closePayStruc.click();
				Thread.sleep(Constant.Min_Sleep);
				empPlaceOfWrk.sendKeys("Company");
				elDetails.clear();
				elDetails.sendKeys("12");
				clDetails.clear();
				clDetails.sendKeys("12");
				workTab.click();
				personalDetailsTab.click();
				Thread.sleep(Constant.Min_Sleep);
				dateOfBirth.click();
				for(int i=1;i<4;i++){
					driver.findElement(By.xpath("//div["+i+"]/table/thead/tr[2]/th[2]")).click();
				}
				driver.findElement(By.xpath(".//span[text()='1990']")).click();
				driver.findElement(By.xpath(".//span[@class='year focused']")).click();
				driver.findElement(By.xpath(".//span[text()='Feb']")).click();
				driver.findElement(By.xpath("//div[10]/div[1]/table[1]/tbody[1]/tr[3]/td[4]")).click();
				Select selectGender = new Select(gender);
				selectGender.selectByVisibleText("Female");
				Select selectBloodGrp = new Select(empBloodGRP);
				selectBloodGrp.selectByValue("O+");
				empAddress1.sendKeys(sAddress1);
				empAddress2.sendKeys("PN palayam,");
				empCity.sendKeys(sCity);
				Select country = new Select(empCountry);
				country.selectByVisibleText("India");
				Thread.sleep(Constant.Min_Sleep);
				Select state = new Select(empState);
				state.selectByVisibleText(sState);
				postalCode.sendKeys("546123");
				fatherName.sendKeys("Jeevanathan");
				motherName.sendKeys("Lakshmi");
				contactNumber.sendKeys("7894561230");
				nationality.sendKeys("Indian");
				Select selectMaritalStatus = new Select(maritalStatus);
				selectMaritalStatus.selectByVisibleText("Unmarried");
				aadharNum.sendKeys("789456123013126");
				esiNum.sendKeys("1234568790");
				pfNo.sendKeys("789456123012");
				bankDetailsTab.click();
				Thread.sleep(Constant.Min_Sleep);
				acctNumber.sendKeys("789456123013");
				Select selectAcctType = new Select(acctType);
				selectAcctType.selectByValue("Salary");
				ifscCode.sendKeys("ICIC0000001");
				acctName.sendKeys("Swetha");
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(2000);
				if(ifscBankName.getText().contains("ICICI Bank, CHENNAI - CENOTAPH ROAD")){
					panNumber.sendKeys("ASD2342DS");
					empSave.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
			navigate.showAllEntries();
			int iActValue = employeesList.size();
			if(iActValue>iValue){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Employee addition failed "+e);
		}
		return flag;
	}

	public boolean addEmployee_MandatoryFields(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sDept = xls.get(iRowNo).get("Department");
		String sEmpType = xls.get(iRowNo).get("Employment type");
		String sPayStruct = xls.get(iRowNo).get("Pay Structure");
		String sStatus = xls.get(iRowNo).get("Status");
		String sPayStruc = xls.get(iRowNo).get("Edit Pay Struc");
		String sAddDept = xls.get(iRowNo).get("Add Department");
		String sAddSubDept = xls.get(iRowNo).get("Add Sub Department");
		try{
			navigate.showAllEntries();
			int iValue = employeesList.size();
			employeeAddBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(sAddDept.contains("Yes") || sAddSubDept.contains("Yes")){
				workTab.click();
				Thread.sleep(Constant.Min_Sleep);
				Select selectEmpDept = new Select(empDept);
				selectEmpDept.selectByVisibleText("[+] Add New Department");
				Thread.sleep(Constant.Min_Sleep);
				if(addDptPopup.isDisplayed()){
					if(sAddSubDept.contains("Yes")){
						empDeptName.sendKeys("Sub Dept "+sDate);
						Select select = new Select(empDeptParentDrpDwn);
						select.selectByVisibleText(sDept);
						saveDptButton.click();
					}else{
						empDeptName.sendKeys("Dept "+sDate);
						saveDptButton.click();
					}
					Thread.sleep(Constant.Min_Sleep);
					employeeAddBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
			}
			if(empCode.isDisplayed()){
				empCode.sendKeys("Emp"+sDate.substring(7));
				empFirstName.sendKeys("Automation"+sDate);
				empPhone.sendKeys(sDate);
				Thread.sleep(Constant.Min_Sleep);
				workTab.click();
				if(sAddDept.contains("Yes")){
					Select selectEmpDept = new Select(empDept);
					selectEmpDept.selectByVisibleText("Dept "+sDate);
				}else if(sAddSubDept.contains("Yes")){
					Select selectEmpDept = new Select(empDept);
					selectEmpDept.selectByVisibleText("Sub Dept "+sDate);
				}else{
					Select selectEmpDept = new Select(empDept);
					selectEmpDept.selectByVisibleText(sDept);
				}
				Select selectEmpType = new Select(employmentType);
				selectEmpType.selectByVisibleText(sEmpType);
				Select selectStatus = new Select(status);
				selectStatus.selectByVisibleText(sStatus);
				Select selectPayStruc = new Select(payStructure);
				selectPayStruc.selectByVisibleText(sPayStruct);
				if(sPayStruc.contains("Yes")){
					editPayStruct.click();
					Thread.sleep(Constant.Min_Sleep);
					for (WebElement element : payStructDetailsList) {
						element.sendKeys(Keys.CONTROL+"a");
						element.sendKeys(Keys.DELETE);
						element.sendKeys("500");
					}
					closePayStruc.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				workTab.click();
				Thread.sleep(Constant.Min_Sleep);
				personalDetailsTab.click();
				Thread.sleep(Constant.Min_Sleep);
				Select selectGender = new Select(gender);
				selectGender.selectByVisibleText("Female");
				Select selectMaritalStatus = new Select(maritalStatus);
				selectMaritalStatus.selectByVisibleText("Unmarried");
				aadharNum.sendKeys("789456123013126");
				empSave.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			navigate.showAllEntries();
			int iActValue = employeesList.size();
			if(iActValue>iValue){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Employee addition failed "+e);
		}
		return flag;
	}

	/**
	 * To update employee
	 * @param iRowNo
	 * @return true, if employee details update is successful
	 * @throws Exception
	 */

	public boolean updateEmployee(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sDept = xls.get(iRowNo).get("Department");
		String sEmpType = xls.get(iRowNo).get("Employment type");
		String sPayStruct = xls.get(iRowNo).get("Pay Structure");
		String sStatus = xls.get(iRowNo).get("Status");
		String sCity = xls.get(iRowNo).get("City");
		String sState = xls.get(iRowNo).get("State");
		String sEmail = xls.get(iRowNo).get("Email");
		String sAddress1 = xls.get(iRowNo).get("Address1");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			int iValue = employeesList.size();
			if(!(iValue > 0)){
				addEmployee(iRowNo,sheet);
			}
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//tbody/tr["+(iValue-1)+"]/td/a")));
			driver.findElement(By.xpath(".//tbody/tr["+(iValue-1)+"]/td/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(empFirstName.isDisplayed()){
				empFirstName.clear();
				empFirstName.sendKeys("update"+sDate);
				empLastName.clear();
				empLastName.sendKeys("Updated");
				empEmail.clear();
				empEmail.sendKeys(sEmail);
				empPhone.clear();
				empPhone.sendKeys("78945646549");
				workTab.click();
				Select selectEmpDept = new Select(empDept);
				selectEmpDept.selectByVisibleText(sDept);
				Select selectEmpType = new Select(employmentType);
				selectEmpType.selectByVisibleText(sEmpType);
				Select selectStatus = new Select(status);
				selectStatus.selectByVisibleText(sStatus);
				dateOfJoining.click();
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				dateSelect.click();
				designation.clear();
				designation.sendKeys("updated QA");
				Select selectPayStruc = new Select(payStructure);
				selectPayStruc.selectByVisibleText(sPayStruct);
				editPayStruct.click();
				Thread.sleep(Constant.Min_Sleep);
				for (WebElement element : payStructDetailsList) {
					element.sendKeys(Keys.CONTROL+"a");
					element.sendKeys(Keys.DELETE);
					element.sendKeys("250");
				}
				closePayStruc.click();
				Thread.sleep(Constant.Min_Sleep);
				empPlaceOfWrk.clear();
				empPlaceOfWrk.sendKeys("updated company");
				elDetails.clear();
				elDetails.sendKeys("11");
				clDetails.clear();
				clDetails.sendKeys("11");
				workTab.click();
				personalDetailsTab.click();
				Thread.sleep(Constant.Min_Sleep);
				dateOfBirth.click();
				driver.findElement(By.xpath("//div[10]/div[1]/table[1]/tbody[1]/tr[3]/td[5]")).click();
				Select selectGender = new Select(gender);
				selectGender.selectByVisibleText("Male");
				Select selectBloodGrp = new Select(empBloodGRP);
				selectBloodGrp.selectByValue("O-");
				empAddress1.clear();
				empAddress1.sendKeys(sAddress1);
				empAddress2.clear();
				empAddress2.sendKeys("PN palayam,");
				empCity.clear();
				empCity.sendKeys(sCity);
				Select country = new Select(empCountry);
				country.selectByVisibleText("India");
				Thread.sleep(Constant.Min_Sleep);
				Select state = new Select(empState);
				state.selectByVisibleText(sState);
				postalCode.clear();
				postalCode.sendKeys("454554");
				fatherName.clear();
				fatherName.sendKeys("Jaganathan");
				motherName.clear();
				motherName.sendKeys("MuthuLakshmi");
				contactNumber.clear();
				contactNumber.sendKeys(sDate);
				nationality.clear();
				nationality.sendKeys("Indian");
				Select selectMaritalStatus = new Select(maritalStatus);
				selectMaritalStatus.selectByVisibleText("Unmarried");
				aadharNum.clear();
				aadharNum.sendKeys(sDate);
				esiNum.clear();
				esiNum.sendKeys(sDate);
				pfNo.clear();
				pfNo.sendKeys(sDate);
				bankDetailsTab.click();
				Thread.sleep(Constant.Min_Sleep);
				acctNumber.clear();
				acctNumber.sendKeys(sDate);
				Select selectAcctType = new Select(acctType);
				selectAcctType.selectByValue("Salary");
				ifscCode.clear();
				ifscCode.sendKeys("ICIC0000001");
				acctName.clear();
				acctName.sendKeys("Malathi");
				panNumber.clear();
				panNumber.sendKeys("ASD"+sDate);
				empSave.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			navigate.showAllEntries();
			int iActValue = employeesList.size();
			if(iActValue == iValue && Constant.driver.getPageSource().contains(sDate)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Employee update not successful "+e);
		}
		return flag;
	}

	public boolean updateEmployee_General(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sEmail = xls.get(iRowNo).get("Email");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			int iValue = employeesList.size();
			if(!(iValue > 0)){
				addEmployee(iRowNo,sheet);
			}
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//tbody/tr["+(iValue-1)+"]/td[1]/a")));
			driver.findElement(By.xpath(".//tbody/tr["+(iValue-1)+"]/td/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(empFirstName.isDisplayed()){
				empFirstName.clear();
				empFirstName.sendKeys("update"+sDate);
				empLastName.clear();
				empLastName.sendKeys("Updated");
				empEmail.clear();
				empEmail.sendKeys(sEmail);
				empPhone.clear();
				empPhone.sendKeys("78945646549");
				empSave.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			navigate.showAllEntries();
			int iActValue = employeesList.size();
			if(iActValue == iValue && Constant.driver.getPageSource().contains(sDate)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Employee general update not successful "+e);
		}
		return flag;
	}

	public boolean updateEmployee_Work(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sDept = xls.get(iRowNo).get("Department");
		String sEmpType = xls.get(iRowNo).get("Employment type");
		String sPayStruct = xls.get(iRowNo).get("Pay Structure");
		String sStatus = xls.get(iRowNo).get("Status");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			int iValue = employeesList.size();
			if(!(iValue > 0)){
				addEmployee(iRowNo,sheet);
			}
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//tbody/tr["+(iValue-1)+"]/td/a")));
			driver.findElement(By.xpath(".//tbody/tr["+(iValue-1)+"]/td/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(empFirstName.isDisplayed()){
				empFirstName.clear();
				empFirstName.sendKeys("update"+sDate);
				workTab.click();
				Select selectEmpDept = new Select(empDept);
				selectEmpDept.selectByVisibleText(sDept);
				Select selectEmpType = new Select(employmentType);
				selectEmpType.selectByVisibleText(sEmpType);
				Select selectStatus = new Select(status);
				selectStatus.selectByVisibleText(sStatus);
				dateOfJoining.click();
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				dateSelect.click();
				designation.clear();
				designation.sendKeys("updated QA");
				Select selectPayStruc = new Select(payStructure);
				selectPayStruc.selectByVisibleText(sPayStruct);
				empPlaceOfWrk.clear();
				empPlaceOfWrk.sendKeys("updated company");
				elDetails.clear();
				elDetails.sendKeys("11");
				clDetails.clear();
				clDetails.sendKeys("11");
				workTab.click();
				empSave.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			navigate.showAllEntries();
			int iActValue = employeesList.size();
			if(iActValue == iValue && Constant.driver.getPageSource().contains(sDate)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Employee work update not successful "+e);
		}
		return flag;
	}

	public boolean updateEmployee_PayStruc(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sPayStruct = xls.get(iRowNo).get("Pay Structure");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			int iValue = employeesList.size();
			if(!(iValue > 0)){
				addEmployee(iRowNo,sheet);
			}
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//tbody/tr["+(iValue-1)+"]/td/a")));
			driver.findElement(By.xpath(".//tbody/tr["+(iValue-1)+"]/td/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(empFirstName.isDisplayed()){
				empFirstName.clear();
				empFirstName.sendKeys("update"+sDate);
				workTab.click();
				Thread.sleep(Constant.Min_Sleep);
				Select selectPayStruc = new Select(payStructure);
				selectPayStruc.selectByVisibleText(sPayStruct);
				editPayStruct.click();
				Thread.sleep(Constant.Min_Sleep);
				for (WebElement element : payStructDetailsList) {
					element.sendKeys(Keys.CONTROL+"a");
					element.sendKeys(Keys.DELETE);
					element.sendKeys("250");
				}
				closePayStruc.click();
				Thread.sleep(Constant.Min_Sleep);
				workTab.click();
				Thread.sleep(Constant.Min_Sleep);
				empSave.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			navigate.showAllEntries();
			int iActValue = employeesList.size();
			if(iActValue == iValue && Constant.driver.getPageSource().contains(sDate)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Employee work update not successful "+e);
		}
		return flag;
	}

	public boolean updateEmployee_PersonalDetails(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
		String sCity = xls.get(iRowNo).get("City");
		String sState = xls.get(iRowNo).get("State");
		String sAddress1 = xls.get(iRowNo).get("Address1");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			int iValue = employeesList.size();
			if(!(iValue > 0)){
				addEmployee(iRowNo,sheet);
			}
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//tbody/tr["+(iValue-1)+"]/td/a")));
			driver.findElement(By.xpath(".//tbody/tr["+(iValue-1)+"]/td/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(empFirstName.isDisplayed()){
				empFirstName.clear();
				empFirstName.sendKeys("update"+sDate);
				personalDetailsTab.click();
				Thread.sleep(Constant.Min_Sleep);
				dateOfBirth.click();
				driver.findElement(By.xpath("//div[10]/div[1]/table[1]/tbody[1]/tr[3]/td[5]")).click();
				Select selectGender = new Select(gender);
				selectGender.selectByVisibleText("Male");
				Select selectBloodGrp = new Select(empBloodGRP);
				selectBloodGrp.selectByValue("O-");
				empAddress1.clear();
				empAddress1.sendKeys(sAddress1);
				empAddress2.clear();
				empAddress2.sendKeys("PN palayam,");
				empCity.clear();
				empCity.sendKeys(sCity);
				Select country = new Select(empCountry);
				country.selectByVisibleText("India");
				Thread.sleep(Constant.Min_Sleep);
				Select state = new Select(empState);
				state.selectByVisibleText(sState);
				postalCode.clear();
				postalCode.sendKeys("454554");
				fatherName.clear();
				fatherName.sendKeys("Jaganathan");
				motherName.clear();
				motherName.sendKeys("MuthuLakshmi");
				contactNumber.clear();
				contactNumber.sendKeys(sDate);
				nationality.clear();
				nationality.sendKeys("Indian");
				Select selectMaritalStatus = new Select(maritalStatus);
				selectMaritalStatus.selectByVisibleText("Unmarried");
				aadharNum.clear();
				aadharNum.sendKeys(sDate);
				esiNum.clear();
				esiNum.sendKeys(sDate);
				pfNo.clear();
				pfNo.sendKeys(sDate);
				empSave.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			navigate.showAllEntries();
			int iActValue = employeesList.size();
			if(iActValue == iValue && Constant.driver.getPageSource().contains(sDate)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Employee Personal details update not successful "+e);
		}
		return flag;
	}

	public boolean updateEmployee_BankDetails(int iRowNo, String sheet) throws Exception{
		boolean flag = false;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			navigate.showAllEntries();
			int iValue = employeesList.size();
			if(!(iValue > 0)){
				addEmployee(iRowNo,sheet);
			}
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//tbody/tr["+(iValue-1)+"]/td/a")));
			driver.findElement(By.xpath(".//tbody/tr["+(iValue-1)+"]/td/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(empFirstName.isDisplayed()){
				empFirstName.clear();
				empFirstName.sendKeys("update"+sDate);
				bankDetailsTab.click();
				Thread.sleep(Constant.Min_Sleep);
				acctNumber.clear();
				acctNumber.sendKeys(sDate);
				Select selectAcctType = new Select(acctType);
				selectAcctType.selectByValue("Salary");
				ifscCode.clear();
				ifscCode.sendKeys("ICIC0000001");
				acctName.clear();
				acctName.sendKeys("Malathi");
				panNumber.clear();
				panNumber.sendKeys("ASD"+sDate);
				empSave.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			navigate.showAllEntries();
			int iActValue = employeesList.size();
			if(iActValue == iValue && Constant.driver.getPageSource().contains(sDate)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Employee update bank details not successful "+e);
		}
		return flag;
	}

	public boolean addPayStructure(){
		boolean flag = false;
		try{
			navigate.showAllEntries();
			int sValue = noOfPayStruct.size();
			payStructureAddTab.click();
			Thread.sleep(Constant.Min_Sleep);
			if(payStructureName.isDisplayed()){
				payStructureName.sendKeys("AutoMate"+sDate);
				for(int i=1;i<itemType.size();i++){
					itemType.get(i).click();
					payStructureDesc.sendKeys(itemType.get(i).getText()+" Desc" + sDate);
					addNewPayDetails.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				savePayBtn.sendKeys(Keys.ENTER);
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load sales view page");
				if(payStructSavedSuccessPopUP.isDisplayed()){
					okBtn.click();
				}
			}
			navigate.showAllEntries();
			int sActValue = noOfPayStruct.size();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//table[@id='payList']/tbody/tr["+sActValue+"]/td[2]/span/a")));
			String sName = driver.findElement(By.xpath(".//table[@id='payList']/tbody/tr["+sActValue+"]/td[2]/span/a")).getText();
			if(sActValue > sValue && sName.equals("AutoMate"+sDate)){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Party Structure addition failed "+e);
		}
		return flag;
	}

	public boolean updatePayStructure(){
		boolean flag = false;
		try{
			navigate.showAllEntries();
			int sValue = noOfPayStruct.size();
			if(sValue == 0){
				addPayStructure();
				sValue = noOfPayStruct.size();
			}
			driver.findElement(By.xpath(".//table[@id='payList']/tbody/tr["+sValue+"]/td[2]/span/a")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(payStructureName.isDisplayed()){
				for(int i=0;i<deleteItemList.size()-1;i++){
					deleteItemList.get(i).click();
					Thread.sleep(Constant.Min_Sleep);
					confirmBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				for(int i=1;i<itemType.size();i++){
					itemType.get(i).click();
					payStructureDesc.sendKeys(itemType.get(i).getText()+" Desc" + sDate);
					addNewPayDetails.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				savePayBtn.click();
				Constant.waitFor(ExpectedConditions.elementToBeClickable(okBtn), "Failed to load sales view page");
				if(payStructSavedSuccessPopUP.isDisplayed()){
					okBtn.click();
				}
			}
			navigate.showAllEntries();
			int sActValue = noOfPayStruct.size();
			if(sActValue == sValue){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Party Structure update failed "+e);
		}
		return flag;
	}

	 public boolean deletePayStructure(){
		 boolean flag = false;
		 try{
			 navigate.showAllEntries();
			int sValue = noOfPayStruct.size();
			if(sValue == 0){
				addPayStructure();
				sValue = noOfPayStruct.size();
			}
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(".//table[@id='payList']/tbody/tr["+(sValue)+"]/td[2]/span/a"))).perform();
			actions.moveToElement(driver.findElement(By.xpath(".//table[@id='payList']/tbody/tr["+(sValue)+"]/td[2]/span[2]/span[3]/i"))).click().perform();
			Thread.sleep(Constant.Min_Sleep);
			confirmBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			navigate.showAllEntries();
			int sActValue = noOfPayStruct.size();
			if(sActValue< sValue){
				flag = true;
			}
		 }catch(Exception e){
			 System.err.println("Party Structure delete failed "+e);
		 }
		 return flag;
	 }

	 public boolean importAttendance(){
		 boolean flag = false;
		 try{
			 importAttendace.click();
			 Thread.sleep(Constant.Min_Sleep);
			 monthYrAttendance.click();
			 String month = Constant.get_Month().substring(0, 3);
			 driver.findElement(By.xpath(".//td/span[text()='"+month+"']")).click();
			 attachmentBtn.click();
			 Thread.sleep(Constant.Min_Sleep);
			 Runtime.getRuntime().exec("E:\\firstAttendance.exe");//execute AutoIT to upload import file
			 Thread.sleep(Constant.Min_Sleep);
			 uploadImportAttendance.click();
			 Thread.sleep(Constant.Min_Sleep);
			 okBtn.click();
			 Thread.sleep(Constant.Min_Sleep);
			 attendanceSearchMonth.click();
			 driver.findElement(By.xpath(".//td/span[text()='"+month+"']")).click();
			 searchReport.click();
			 Thread.sleep(Constant.Min_Sleep);
			 String sFirstImport = driver.findElement(By.xpath(".//td/form/a[text()='emp8154924']/following::td[10]")).getText();
			 importAttendace.click();
			 Thread.sleep(Constant.Min_Sleep);
			 attachmentBtn.click();
			 Thread.sleep(Constant.Min_Sleep);
			 Runtime.getRuntime().exec("E:\\secondAttendance.exe");//execute AutoIT to upload import file
			 Thread.sleep(Constant.Min_Sleep);
			 uploadImportAttendance.click();
			 Thread.sleep(Constant.Min_Sleep);
			 okBtn.click();
			 Thread.sleep(Constant.Min_Sleep);
			 String sSecondImport = driver.findElement(By.xpath(".//td/form/a[text()='emp8154924']/following::td[10]")).getText();
			 if(!sFirstImport.equals(sSecondImport)){
				 flag = true;
			 }
		 }catch(Exception e){
			 System.err.println("Failed to import attendance "+e);
		 }
		 return flag;
	 }

	 /**
		 * To search employee list
		 * @param iRowNo
		 * @return true, if searched employee is displayed
		 * @throws Exception
		 */

		public boolean searchEmployee(int iRowNo, String sheet) throws Exception{
			boolean flag = false;
			List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_ERP(),sheet);
			String sSearchCode = xls.get(iRowNo).get("EmployeeCode");
			String sCode = xls.get(iRowNo).get("Code");
			try{
				navigate.navigateToEmployees();
				if(!(employeeList.size() > 0)){
					addEmployee(iRowNo,sheet);
					search.sendKeys(sCode);
					if(Constant.driver.getPageSource().contains(sCode)){
						flag = true;
					}
				}else{
					search.sendKeys(sSearchCode);
					if(Constant.driver.getPageSource().contains(sSearchCode)){
						flag = true;
					}
				}
			}catch(Exception e){
				System.err.println("Search employee not successful "+e);
			}
			return flag;
		}



		/**
		 * To validate cancel button in Employee add page
		 * @param iRowNo
		 * @return true, if cancel button is working
		 */

		public boolean cancel_Employee(int iRowNo){
			boolean flag = false;
			try{
				cancelBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(!Constant.driver.getPageSource().contains("Code")){
					flag = true;
				}
				}catch(Exception e){
					System.err.println("Cancel employee not successful "+e);
				}
			return flag;
		}

		/**
		 * To validate employee add page mandatory fields
		 * @param iRowNo
		 * @return true, if mandatory warning messages are displayed
		 */

		public boolean mandatoryFields_Emp(int iRowNo){
			boolean flag = false;
			try{
				empSave.click();
				if(codeMandatoryWarning.isDisplayed() && nameMandatoryWarning.isDisplayed()){
					flag = true;
				}
			}catch(Exception e){
				System.err.println("Mandatory field check of employee not successful "+e);
			}
			return flag;
		}

}
