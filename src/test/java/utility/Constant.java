package utility;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;



public class Constant {
	public static WebDriver driver;
	//Log initialization
	public static Logger log = Logger.getLogger("Constant");

	public static long Min_Sleep = 2000;

	public static long Medium_Sleep = 6000;

	public static long Max_Sleep = 12000;

	  static String pageLoadStatus = null;

	    static JavascriptExecutor js;

	    public static String date = Constant.DateTimeFormat();


    public static String NormalDateFormat(){
    	 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		 //get current date time with Date()
		  Date date = new Date();

		 // Now format the date
		 String date1= dateFormat.format(date);
		 return date1;
    }

    public static String CorrectedDate(){
    	String sCorrectedDate = Constant.currentDate().substring(4, 6);
		if(sCorrectedDate.startsWith("0")){
			sCorrectedDate = Constant.currentDate().substring(0,4)+Constant.currentDate().substring(5,12);
		}else{
			sCorrectedDate = Constant.currentDate();
		}
		return sCorrectedDate;
    }

    public static String get_Month(){
    	   Date date = new Date();
    	   SimpleDateFormat formatter = new SimpleDateFormat("MMMMMMMMM");
    	   return formatter.format(date);
    	 }

    public static String DateTimeFormat(){
    	DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");

		 //get current date time with Date()
		  Date date = new Date();

		 // Now format the date
		 String date1= dateFormat.format(date);
		 return date1;
   }

    public static String PreviousDate(){
    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    	//get previous day date
		Date date = DateUtils.addDays(new Date(), -1);
		 // Now format the date
		String date1 = dateFormat.format(date);
		return date1;
    }

    public static String currentDate(){
		DateFormat dDateFormat = new SimpleDateFormat("MMM dd, yyyy");
		Date dDate1 = new Date();
		String sCurrentDate = dDateFormat.format(dDate1);
		return sCurrentDate;
    }

    public static String lastDateOfMonth(){
    	 Date today = new Date();

         Calendar calendar = Calendar.getInstance();
         calendar.setTime(today);

         calendar.add(Calendar.MONTH, 1);
         calendar.set(Calendar.DAY_OF_MONTH, 1);
         calendar.add(Calendar.DATE, -1);

         Date lastDayOfMonth = calendar.getTime();
         DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String date = sdf.format(lastDayOfMonth).substring(8, 10);
         return date;
    }

    public static String captureScreen_Positive(String ScriptName) throws Exception {
    	ReadPropertyFile property = new ReadPropertyFile();
    	String path;
        try {
        	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	String date = DateTimeFormat();
            path = property.getScreenshotpath()+"Screenshots_Positive\\"+ScriptName+"."+date+"\\" + source.getName();
            FileUtils.copyFile(source, new File(path));
            log.info("Screenshot captured for successful execution");
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }


    public static String captureScreen_Negative(String ScriptName) throws Exception {
    	ReadPropertyFile property = new ReadPropertyFile();
        String errflpath = null;
        try {
        	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	File Dest = new File(property.getScreenshotpath()+"Screenshots_Negative\\"+ScriptName+"."+date+"\\" + source.getName() +".png");
//            path = property.getScreenshotpath()+"Screenshots_Negative\\"+ScriptName+"."+date+"\\" + source.getName();
            errflpath = Dest.getAbsolutePath();
            FileUtils.copyFile(source, Dest);
            log.info("Screenshot captured for failure");

        }
        catch(IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
        return errflpath;
    }

	public static File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}

	public static void BrowserInitialization_download() throws Exception{
    	ReadPropertyFile property = new ReadPropertyFile();
    	//Browser Initialisation
    	System.setProperty("webdriver.gecko.driver",property.getGeckodriverpath());
//    	FirefoxProfile profile = profile();
    	driver = new FirefoxDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(500000, TimeUnit.SECONDS);
    	log.info("Browser Inisialization is successful");
    }

	public static void BrowserInitialization() throws Exception{
		ReadPropertyFile property = new ReadPropertyFile();
		try{
			String browserSelection = property.getBrowserSelection();

			if(browserSelection != null && browserSelection.contains("Chrome")){
				System.setProperty("webdriver.chrome.driver",property.getChromeDrivePath());
				ChromeOptions co = new ChromeOptions();
	            co.addArguments("--start-maximized");
	            driver = new ChromeDriver(co);
		    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    	log.info("Browser Inisialization is successful");
			}else{
		    	System.setProperty("webdriver.gecko.driver",property.getGeckodriverpath());
		    	driver = new FirefoxDriver();
		    	driver.manage().window().maximize();
		    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    	log.info("Browser Initialization is successful");
			}
		}catch(Exception e){
			System.err.println("Browser Initialization failed"+e);
		}
	}

	public static void closeBrowser() throws Exception{
		try{
			if(driver != null){
				// Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
				// Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
				Runtime.getRuntime().exec("pkill -f chromedriver");
				Runtime.getRuntime().exec("pkill -f geckodriver");
	        	driver.quit();
			}
		}
        catch(Exception e){
        	System.err.println("browser close failed "+e);
        }
	}

    public static FirefoxProfile profile() throws Exception{
	    //Create FireFox Profile object
		FirefoxProfile profile = new FirefoxProfile();
		ReadPropertyFile property = new ReadPropertyFile();
		//Set Location to store files after downloading.
		profile.setPreference("browser.download.dir", property.getdownloadPath());
		profile.setPreference("browser.download.folderList", 2);
		profile.setAcceptUntrustedCertificates (true);
		//Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;");

		profile.setPreference( "browser.download.manager.showWhenStarting", false );
		profile.setPreference( "pdfjs.disabled", true );

		return profile;
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

    public static void logFile(String logfile) throws Exception{
    	ReadPropertyFile property = new ReadPropertyFile();
    	// This block configure the logger with handler and formatter
    	String date = DateTimeFormat();
//    	log.setLevel(log.DEBUG);
    	FileHandler fh = new FileHandler(property.getLogFilePath()+logfile+date+".log");
//    	fh.setLevel(log.DEBUG);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        log.addHandler(fh);
        log.info("Log file created");
    }

    public static boolean isAlertPresents() {
    	try {
	    	driver.switchTo().alert();
	    	return true;
    	}// try
    	catch (Exception e) {
    		return false;
    	}
    }

    public static boolean verifyColumnOrder(WebElement element, String List) {
		boolean flag = false;
		try{
		    String expectedHeaders = String.join(" ", List).toUpperCase();
		    String visibleHeaders = element.getText();
			if(expectedHeaders.contains(visibleHeaders)){
		    	flag = true;
		    }
		}catch(Exception e){
			System.err.println("Column order verification failed "+e);
		}
	    return flag;
	}

    public static boolean verifyColumnOrder_ScrollTable(List<WebElement> mainColumn, String List) {
		boolean flag = false;
		ArrayList<String> array = new ArrayList<>();
		String visibleHeaders = "";
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try{
			String expectedHeaders = String.join(" ", List).toUpperCase();
			for(int i=0; i<mainColumn.size();i++){
				if(mainColumn.get(i).getText().contains("Total:")){
					i++;
				}else{
					js.executeScript("arguments[0].scrollIntoView(true);", mainColumn.get(i));
					array.add(mainColumn.get(i).getText());
				}
			}
			for(String s : array){
				visibleHeaders += s + " ";
			}
			if(visibleHeaders.contains(expectedHeaders)){
		    	flag = true;
		    }
		}catch(Exception e){
			System.err.println("Column order verification failed "+e);
		}
	    return flag;
	}

    public static boolean isElementPresent(By locatorKey) {
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (Exception e) {
            return false;
        }finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public static String currentFY() {
    	String FY;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        if (month <= 3) {
        	FY = (year - 1) + "-" + year;
        } else {
        	FY = year + "-" + (year + 1);
        }
        return FY.substring(2,5)+FY.substring(7,9);
    }

    public static int countRegexInString(String sRegex, String sMaterial){
    	Pattern pattern = Pattern.compile(sRegex);
        Matcher matcher = pattern.matcher(sMaterial);
        int count = 0;
        while (matcher.find())
            count++;
        return count;
    }


    public static void waitForPageLoad() {
	    do {

	    js = (JavascriptExecutor) driver;

	    pageLoadStatus = (String)js.executeScript("return document.readyState");

	    } while ( !pageLoadStatus.equals("complete") );
    }

    public static String createBug(String Component, String sSummary) {
    	String bug = null;
    	int id = 0;
    	int bugId = 0;
    	try{
    		String serverURL = "http://dev.permisso.in/bugzilla/?api_key=BQL3JdHxaQcSQixoL92e3HJpR2xDPUDs0sXstpsa";
//    		BugzillaConnector conn = new BugzillaConnector();
//
//    		conn.connectTo(serverURL);
//    		LogIn logIn = new LogIn("niranjani.j", "welcome");
//    		conn.executeMethod(logIn);
//    		Bug bug = new BugFactory().newBug()
//    				.setComponent("Test")
//    				.setProduct("Test")
//    				.setSummary("Testing report")
//    				.setVersion("1.0.6")
//    				.createBug();
//    		ReportBug report = new ReportBug(bug);
//    		GetBug get = new GetBug(id);
//    		conn.executeMethod(get);
//    		assertEquals("A valid bug should be returned", get.getBug());
//    		bugId = report.getID();
	        HttpClient client = new HttpClient();
	        PostMethod method = new PostMethod (serverURL + "/bug?username=niranjani.j&password=welcome");
	        method.addParameter("product", "xserp");
	        method.addParameter("component", Component);
	        method.addParameter("summary", sSummary);
	        method.addParameter("version", "2.17.2");
	        client.executeMethod(method);
	        bug = method.getStatusCode() + " " + method.getResponseBodyAsString();
    	}catch(Exception e){
    		System.err.println("Failed to create bug "+e);
    	}
    	return bug;
    }


    public static void attachFile(){
    	try{
	    	ReadPropertyFile property = new ReadPropertyFile();
	    	 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			    StringSelection str = new StringSelection(property.getAttachmentPath());
			    clipboard.setContents(str, null);


			    Robot robot = new Robot();
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    Thread.sleep(1000);
			    robot.keyRelease(KeyEvent.VK_CONTROL);
			    robot.keyRelease(KeyEvent.VK_V);
			    Thread.sleep(1000);
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);
    	}catch(Exception e){
    		System.err.println("Failed to attache file "+e);
    	}
    }

	public static Object getDriver() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getDriver'");
	}

}
