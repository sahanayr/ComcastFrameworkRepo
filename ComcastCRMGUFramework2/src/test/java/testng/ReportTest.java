package testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportTest {
	 ExtentReports report;
	@Test
	public void createContactTest() {
	
	ExtentTest test = report.createTest("createContactTest");  
    
    test.log(Status.INFO, "Login to app");
    test.log(Status.INFO, "navigate to contact page");
    test.log(Status.INFO, "create contact");
    if ("HDFC".equals("HDFC")) {
		test.log(Status.PASS, "contact is created");
	} else {
		test.log(Status.FAIL, "contact is not created");
	}
}
	
	@Test
	public void createContactWithOrgTest() {
	
    ExtentTest test = report.createTest("createContactWithOrgTest");  
    
    test.log(Status.INFO, "Login to app");
    test.log(Status.INFO, "navigate to contact page");
    test.log(Status.INFO, "create contact");
    if ("HDFC".equals("HDFC")) {
		test.log(Status.PASS, "contact is created");
	} else {
		test.log(Status.FAIL, "contact is not created");
	}
}
	
	@Test
	public void createContactWithPhNumTest() {
	
    ExtentTest test = report.createTest("createContactWithPhNumTest");  
    
    test.log(Status.INFO, "Login to app");
    test.log(Status.INFO, "navigate to contact page");
    test.log(Status.INFO, "create contact");
    if ("HDFC".equals("HDFC")) {
		test.log(Status.PASS, "contact is created");
	} else {
		test.log(Status.FAIL, "contact is not created");
	}
}
}