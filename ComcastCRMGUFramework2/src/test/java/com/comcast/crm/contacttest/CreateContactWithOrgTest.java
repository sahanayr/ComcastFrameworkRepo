package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.data.fileutility.ExcelUtility;
import com.comcast.crm.generic.data.fileutility.FileUtility;
import com.comcast.crm.generic.data.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.data.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {

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
		
		String lastName = eLib.getDataFromExcel("contact", 5 , 2) + jlib.getRandomNumber();
		String OrgName = eLib.getDataFromExcel("contact", 5 , 3) + jlib.getRandomNumber();

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
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String headerInfo =	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();		
		if (headerInfo.trim().contains(OrgName)) 
		{
			System.out.println(OrgName + " is created==PASS");
		} 
		else
		{
			System.out.println(OrgName + " is not created==FAIL");
		}
		
		String actOrgName =	driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.trim().equals(OrgName)) 
		{
			System.out.println(OrgName + " is created==PASS");
		} 
		else
		{
			System.out.println(OrgName + " is not created==FAIL");
		}
		
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	
		wLib.switchToTabOnURL(driver, "module=Accounts");
		
		driver.findElement(By.name("search_text")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		
		wLib.switchToTabOnURL(driver, "module=Contacts");
		
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();		
		if (headerInfo.trim().contains(lastName)) 
		{
			System.out.println(lastName + " is created==PASS");
		} 
		else
		{
			System.out.println(lastName + " is not created==FAIL");
		}
		
		
		 actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			if (actOrgName.trim().equals(OrgName)) 
			{
				System.out.println(OrgName + " is created==PASS");
			} 
			else
			{
				System.out.println(OrgName + " is not created==FAIL");
			}
		
		driver.quit();
	}

}
