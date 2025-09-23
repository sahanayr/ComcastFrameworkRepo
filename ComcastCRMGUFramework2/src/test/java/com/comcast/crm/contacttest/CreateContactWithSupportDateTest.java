package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.data.fileutility.ExcelUtility;
import com.comcast.crm.generic.data.fileutility.FileUtility;
import com.comcast.crm.generic.data.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.data.webdriverutility.WebDriverUtility;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws Exception 
	{
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtlity jlib = new JavaUtlity();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		String lastName = eLib.getDataFromExcel("contact", 3 , 2) + jlib.getRandomNumber();

		WebDriver driver = null;
		
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		wLib.waitForPageToLoad(driver);
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
	
		String startDate = jlib.getSystemDateyyyyMMddFormat();
		String endDate = jlib.getRequiredDateyyyyMMddFormat(60);
		
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
//		to clear the existing start date
		driver.findElement(By.name("support_start_date")).clear();
//		to pass the date that we required
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		
//		to clear the existing end date	
		driver.findElement(By.name("support_end_date")).clear();
//		to pass the date that we required
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actStartDate =	driver.findElement(By.id("dtlview_Support Start Date")).getText();		
		if (actStartDate.equals(startDate)) 
		{
			System.out.println(startDate + " is verified==PASS");
		} 
		else
		{
			System.out.println(startDate + " is not verified==FAIL");
		}
		
		
		String actEndDate =	driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.equals(endDate)) 
		{
			System.out.println(endDate + " is verified==PASS");
		} 
		else
		{
			System.out.println(endDate + " is not verified==FAIL");
		}
		
	
		driver.quit();

	}


	}


