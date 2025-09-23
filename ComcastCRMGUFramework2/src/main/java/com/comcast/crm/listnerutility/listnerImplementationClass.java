package com.comcast.crm.listnerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.data.webdriverutility.UtilityClassObject;

import baseclass.BaseClass;

public class listnerImplementationClass implements ITestListener , ISuiteListener{
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite) {
		String time = new Date().toString().replace(" ", "_").replace(":","_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chrome-100");
	}
	
	public void onFinish(ISuite suite) {
		report.flush();
	}
	
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());  
		UtilityClassObject.setTest(test);
	}
	
	public void onTestFailure(ITestResult result) {
//		tocapture the test method name bcs i want to take screenshot with testcase name 
		String testCaseName = result.getMethod().getMethodName();
		
		TakesScreenshot eDriver = (TakesScreenshot)UtilityClassObject.getDriver();
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", "_").replace(":","_");
		test.addScreenCaptureFromBase64String(filePath, testCaseName+"_"+time);

	}
}
