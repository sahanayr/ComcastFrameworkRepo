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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.data.fileutility.ExcelUtility;
import com.comcast.crm.generic.data.fileutility.FileUtility;
import com.comcast.crm.generic.data.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.data.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateOrganizationTest {

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
		
		String OrganizationName = eLib.getDataFromExcel("org", 1 , 2) + jlib.getRandomNumber();
		
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
		
		LoginPage lp = new LoginPage(driver);
		
//		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		lp.LoginToApp(USERNAME, PASSWORD);
		
//		lp.getUsernameTxtF().sendKeys("admin");
//		lp.getPasswordTxtF().sendKeys("admin");
//		lp.getLoginButton().click();
		
		
		
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		driver.findElement(By.name("accountname")).sendKeys(OrganizationName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		
//		String headerInfo =	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();		
//		if (headerInfo.contains(OrganizationName)) 
//		{
//			System.out.println(OrganizationName + " is created==PASS");
//		} 
//		else
//		{
//			System.out.println(OrganizationName + " is not created==FAIL");
//		}
//		
//		
//		String actOrgName =	driver.findElement(By.id("dtlview_Organization Name")).getText();
//		if (actOrgName.equals(OrganizationName)) 
//		{
//			System.out.println(OrganizationName + " is created==PASS");
//		} 
//		else
//		{
//			System.out.println(OrganizationName + " is not created==FAIL");
//		}
//		
//	
		driver.quit();

	}



	}



	


