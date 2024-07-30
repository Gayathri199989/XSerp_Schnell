package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utility.Constant;
import utility.ReadPropertyFile;

public class LoginPage {

	ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);

	@FindBy(id="id_user_email") WebElement userName;

	@FindBy(id="id_password") WebElement password;

	@FindBy(xpath="//a[text()='Login Again']")
	private WebElement loginAgainBtn;

	@FindBy(id="sign_in_form") WebElement signIn;

	@FindBy(id="menu_accounts") WebElement accountsModule;

	@FindBy(css="img[title='settings']")
	private WebElement settingIcon;

	@FindBy(css=".span-profile-img") WebElement profileImg;

	@FindBy(xpath="//*[text()[contains(.,'Logout')]]")
	WebElement logout;

	@FindBy(css="#whatNewModal > div > div > div.modal-header > button")
	WebElement skipBtn;



	public WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}

	/**
	 * To login to the application
	 * @throws Exception, if login not successful
	 */
	public void login() throws Exception{
		try{
			driver.navigate().to(property.getUrl_ERP());
			Constant.waitForPageLoad();
			userName.sendKeys(property.getUserName());
			password.sendKeys(property.getPassword());
			Thread.sleep(Constant.Min_Sleep);
			signIn.click();
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
		}catch(Exception e){
			System.err.println("Login failed "+e);
			Constant.captureScreen_Negative("login");
		}
	}

	/**
	 * To logout of the application
	 * @throws Exception
	 */

	public void logout() throws Exception{
		try{
			Constant.waitFor(ExpectedConditions.elementToBeClickable(profileImg), "Element not loaded");
			profileImg.click();
			logout.click();
			Constant.waitFor(ExpectedConditions.elementToBeClickable(loginAgainBtn), "Element not loaded");
			loginAgainBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(signIn.isDisplayed()){
				Constant.log.info("Logout is successfull");
			}
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Logout is unsuccessfull "+e);
			Constant.captureScreen_Negative("logout");
		}
	}
}
