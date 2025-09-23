package pom;

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
import org.testng.annotations.Test;

import com.comcast.crm.generic.data.fileutility.ExcelUtility;
import com.comcast.crm.generic.data.fileutility.FileUtility;
import com.comcast.crm.generic.data.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.data.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactWithSupportDateTest {
	@Test
	public void createContactWithSupportDate() throws Exception 
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
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastNameTxtF().sendKeys(lastName);
		String startDate = jlib.getSystemDateyyyyMMddFormat();
		String endDate = jlib.getRequiredDateyyyyMMddFormat(30);
		cncp.getStartDateTxtF().clear();
		cncp.getStartDateTxtF().sendKeys(startDate);
		cncp.getEndDateTxtF().clear();
		cncp.getEndDateTxtF().sendKeys(endDate);
		cncp.getSaveBtn().click();
		
		ContactInformationPage cip = new ContactInformationPage(driver);
		String contactInfo = cip.getContactInfo().getText();	
		if (contactInfo.contains(lastName)) 
		{
			System.out.println(lastName + " is verified==PASS");
		} 
		else
		{
			System.out.println(lastName + " is not verified==FAIL");
		}
		
		String actStartDate = cip.getStartDateInfo().getText();
		if (actStartDate.equals(startDate)) 
		{
			System.out.println(startDate + " is verified==PASS");
		} 
		else
		{
			System.out.println(startDate + " is not verified==FAIL");
		}
		
		String actEndDate =	cip.getEndDateInfo().getText();
		if (actEndDate.equals(endDate)) 
		{
			System.out.println(endDate + " is verified==PASS");
		} 
		else
		{
			System.out.println(endDate + " is not verified==FAIL");
		}
		
		hp.logout();
		
	
		driver.quit();

	}


	}


