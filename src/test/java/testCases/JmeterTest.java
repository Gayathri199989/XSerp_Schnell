package testCases;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class JmeterTest {

	public static WebDriver driver;

//	@BeforeClass
//	public static void BeforeClass(){
//		System.setProperty("webdriver.chrome.driver","E:\\SeleniumSoftwares\\chromedriver.exe");
//
//    	driver.manage().window().maximize();
//    	driver.manage().timeouts().implicitlyWait(500000000, TimeUnit.SECONDS);
//	}

	@Before
	public void Before(){
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumSoftwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500000000, TimeUnit.SECONDS);
	}

	@Test
	public void login() throws Exception{
		driver.navigate().to("http://dev.permisso.in:8443/erp/");
		Thread.sleep(2000);
		driver.findElement(By.id("id_user_email")).sendKeys("Automation@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("id_password")).sendKeys("seleniumAdmin");
		Thread.sleep(2000);
		driver.findElement(By.id("sign_in_form")).click();
		Thread.sleep(2000);
		waitFor(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("menu_accounts"))), "Element not loaded");
		if(driver.findElement(By.id("menu_accounts")).isDisplayed()){
			boolean flag = isElementPresent(By.xpath("//button[contains(text(),'Skip')]"));
			if(flag && driver.findElement(By.xpath("//button[contains(text(),'Skip')]")).isEnabled()){
				driver.findElement(By.xpath("//button[contains(text(),'Skip')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("btn-sa-confirm")).click();
				Thread.sleep(2000);
			}
		}

	}

	 public static <T> T waitFor(ExpectedCondition<T> condition, String errorMessage) {
	    	Wait<WebDriver> wait = new FluentWait<>(driver)
	    	                             .withTimeout(Duration.ofSeconds(500))
	    	                             .ignoring(NullPointerException.class)
	    	                             .ignoring(StaleElementReferenceException.class)
	    	                             .ignoring(NoSuchElementException.class)
	    	                             .ignoring(ElementNotInteractableException.class)
	    	                             .ignoring(WebDriverException.class)
	    	                              .pollingEvery(Duration.ofSeconds(5))
	    	                             .withMessage(errorMessage);
	    	T result = wait.until(condition);
	    	return result;
	    	}

	public static boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

	@After
	public void After(){
		driver.quit();
	}


}
