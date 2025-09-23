package pom;

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
import org.testng.annotations.Test;

import com.comcast.crm.generic.data.fileutility.ExcelUtility;
import com.comcast.crm.generic.data.fileutility.FileUtility;
import com.comcast.crm.generic.data.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.data.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithOrgTest {
	@Test
	public void createContactWithOrg() throws Exception 
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
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(OrgName);
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.contains(OrgName)) 
			{
				System.out.println(OrgName + " is verified==PASS");
			} 
			else
			{
				System.out.println(OrgName + " is not verified==FAIL");
			}
		
		hp.getContactLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastNameTxtF().sendKeys(lastName);
		cncp.getAddOrgBtn().click();
		
		wLib.switchToTabOnURL(driver, "module=Accounts");
		
		ContactOrganizationsPage cop = new ContactOrganizationsPage(driver);
		cop.getSearchTxtF().sendKeys(OrgName);
		cop.getSearchBtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		wLib.switchToTabOnURL(driver, "module=Contacts");
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
		
		actOrgName = cip.getOrgName().getText();
		if (actOrgName.trim().equals(OrgName)) 
		{
			System.out.println(OrgName + " is created==PASS");
		} 
		else
		{
			System.out.println(OrgName + " is not created==FAIL");
		}
	
		hp.logout();
		
		driver.quit();
	}

}
