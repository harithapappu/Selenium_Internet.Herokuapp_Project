package internet_herokuapp_tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestReports {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		htmlReporter=new ExtentHtmlReporter("./extentreports/new.html");
		extent=new ExtentReports();
		
		htmlReporter.config().setDocumentTitle("Test Execution Report");
		htmlReporter.config().setReportName("Internet HerokuApp Automation Tests");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name","InternetHerokuApp");
		extent.setSystemInfo("Environment","Automation Testing");
		extent.setSystemInfo("User Name","simplilearn");
		
		logger=extent.createTest("First Testcase");
		
		logger.log(Status.INFO, "Test Case Started");
		logger.log(Status.INFO, "Username entered");
		logger.log(Status.INFO, "Password entered");
		logger.log(Status.INFO, "Login Button Clicked");
		logger.log(Status.PASS,MarkupHelper.createLabel("Testcase Passed", ExtentColor.GREEN));
		
		extent.flush();
	}

}
