package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.data.fileutility.ExcelUtility;
import com.comcast.crm.generic.data.fileutility.FileUtility;
import com.comcast.crm.generic.data.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.data.webdriverutility.WebDriverUtility;

public class CreateOrganizationWithIndustryTest {

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
		
		String OrganizationName = eLib.getDataFromExcel("org", 3 , 2) + jlib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 3 , 5);
		String type = eLib.getDataFromExcel("org", 3 , 4);
		
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
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(OrganizationName);
		
		WebElement we1 = driver.findElement(By.name("industry"));
		
		wLib.select(we1,industry);
		
		WebElement we2 = driver.findElement(By.name("accounttype"));
		
		wLib.select(we2,type);
			
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
//	verify the industry and type Info	
		
		String actIndustry =	driver.findElement(By.id("dtlview_Industry")).getText();		
		if (actIndustry.equals(industry)) 
		{
			System.out.println(industry + " information is verified==PASS");
		} 
		else
		{
			System.out.println(industry + " information is not verified==FAIL");
		}
		
		
		String actType =	driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.equals(type)) 
		{
			System.out.println(type + " information is verified==PASS");
		} 
		else
		{
			System.out.println(type + " information is not verified==FAIL");
		}
		
	
		driver.quit();

	}



	}



	


