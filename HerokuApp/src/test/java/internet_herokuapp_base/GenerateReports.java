package internet_herokuapp_base;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.Constants;

public class GenerateReports {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	private static GenerateReports ob;
	static String testcaseReportName=null;
	public GenerateReports() {
		
	}
	public static GenerateReports getInstance() {
		if(ob==null) {
			ob=new GenerateReports();
		}
		return ob;
	}
	public void startExtentReport() {
		htmlReporter=new ExtentHtmlReporter(Constants.GENERATE_REPORT_PATH);
		extent=new ExtentReports();
		
		htmlReporter.config().setDocumentTitle("Test Execution Report");
		htmlReporter.config().setReportName("Internet HerokuApp Automation Tests");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name","HerokuApp");
		extent.setSystemInfo("Environment","Automation Testing");
		extent.setSystemInfo("User Name","simplilearn");
	}
	public void startSingleTestCaseReport(String testCaseName) {
		testcaseReportName=testCaseName;
		logger=extent.createTest(testCaseName);
	}
	public void logTest(String strMessage) {
		logger.log(Status.INFO, strMessage);
	}
	public void logTestResultPass() {
		logger.log(Status.PASS,MarkupHelper.createLabel(testcaseReportName+" is Passed", ExtentColor.GREEN));
	}
	public void logTestResultFail() {
		logger.log(Status.FAIL,MarkupHelper.createLabel(testcaseReportName+" is not Passed", ExtentColor.RED));
	}
	public void logTestResultSkip() {
		logger.log(Status.SKIP,MarkupHelper.createLabel(testcaseReportName+" is Skipped", ExtentColor.PURPLE));
	}
	public void endSingleTestCaseReport() {
		extent.flush();
	}
	public void attachScreenshot(String strTCName) throws IOException {
		logger.addScreenCaptureFromPath(Constants.SCREENSHOT_PATH+strTCName+".jpg");
		logTest("Screenshot of the Test report for Testcase " +strTCName);
		
	}
}
