package internet_herokuapp_base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CommonUtilities;
import utilities.Constants;


public class Base_Tests {
	protected static WebDriver driver;
	protected static Boolean blnflag;
	protected static WebDriverWait wait=null;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static GenerateReports report;
	@BeforeTest
	public static void initialSetup() {
		report=GenerateReports.getInstance();
		report.startExtentReport();
	}
	
	@BeforeMethod
	public static void setUp(Method method) throws IOException {
		report.startSingleTestCaseReport(method.getName());
		getDriver();
		launchInternetHerokuApp();
	}
	
	@AfterMethod
	public static void cleanup() {
		driver.quit();
	}
	@AfterTest
	public static void finalcleanup() throws IOException {
		report.endSingleTestCaseReport();
	}
	
	public static void getDriver() {		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		report.logTest("Firefox driver instance created!");
	}
	
	public static void launchInternetHerokuApp() throws IOException {		
		String urlVal=CommonUtilities.getPropertyValue("URL");
		driver.get(urlVal);
		report.logTest("Launched Internet Heroku application");
	}
	
	public static void waitForElemtToBeVisible(By locator,long time) {	
		wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void enterTextForSendKeys(WebElement element, String textToEnter, Object objName) {	
		element.sendKeys(textToEnter);
		report.logTest("Text is entered in the " +objName);
	}
	public static void testResult(String actual, String expected) {
		if(actual.equals(expected)) {
			report.logTestResultPass();
		}else {
			report.logTestResultFail();
		}
	}
	public static void testResultBln(Boolean blnflag) {
		if(blnflag=true) {
			report.logTestResultPass();
		}
		else {
			report.logTestResultFail();
		}
	}
	public static Boolean returnBlnflag(String actual, String expected) {
		if(actual.equals(expected)) {
			blnflag=true;
		}else {
			blnflag=false;
		}
		return blnflag;
		
	}
	public static void selectByText(WebElement element, String strText) {
		Select selectOption=new Select(element);
		selectOption.selectByVisibleText(strText);
		report.logTest("Selected option: "+strText);
	}
	public static void selectByIndex(WebElement element, int index) {
		Select selectOption=new Select(element);
		selectOption.selectByIndex(index);
		report.logTest("Selected option at index: "+index);
	}
	public static void selectByValue(WebElement element, String strText) {
		Select selectOption=new Select(element);
		selectOption.selectByValue(strText);
		report.logTest("Selected option: "+strText);
	}
	public static void acceptAlert() {
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public static void dismissAlert() {
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public static void getWindowHandles(String strMainWindowHandle) {
		Set<String> windowHandles=driver.getWindowHandles();
		for(String handle:windowHandles) {
			if(!strMainWindowHandle.equalsIgnoreCase(handle))
				driver.switchTo().window(handle);
		}
	}
	
	public static void captureScreenshot(String strDesc) throws IOException {
		TakesScreenshot screencapture=(TakesScreenshot)driver;
		File sourceFile= screencapture.getScreenshotAs(OutputType.FILE);
		String path=Constants.SCREENSHOT_PATH+strDesc+".jpg";
		File destFile=new File(path);
		FileUtils.copyFile(sourceFile, destFile);
		report.logTest("Screenshot captured for Test case: "+strDesc);
	}
}
