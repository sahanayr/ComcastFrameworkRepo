package testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class AttatchScreenshotToExtentReport {
	ExtentReports report;
	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chrome-100");
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
	@Test
	public void createContactTest() {
	WebDriver driver = new ChromeDriver();
	driver.get("http://49.249.28.218:8888/");
	
	TakesScreenshot eDriver = (TakesScreenshot)driver;
	String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
	
	ExtentTest test = report.createTest("createContactTest");  
    
    test.log(Status.INFO, "Login to app");
    test.log(Status.INFO, "navigate to contact page");
    test.log(Status.INFO, "create contact");
    if ("HDdFC".equals("HDFC")) {
		test.log(Status.PASS, "contact is created");
	} else {
		test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
	}
    driver.close();
}
}
