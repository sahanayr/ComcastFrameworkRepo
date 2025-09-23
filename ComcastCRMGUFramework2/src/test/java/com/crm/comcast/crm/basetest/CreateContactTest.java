package com.crm.comcast.crm.basetest;

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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContact() throws Exception {	
		String lastName = eLib.getDataFromExcel("contact", 1 , 2) + jLib.getRandomNumber();
	
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastNameTxtF().sendKeys(lastName);
		cncp.getSaveBtn().click();
		ContactInformationPage cip = new ContactInformationPage(driver);
		
		String contactInfo = cip.getContactInfo().getText();	
		boolean status = contactInfo.contains(lastName);
		Assert.assertEquals(status, true);
		}
	
	@Test(groups = "regressionTest")
	public void createContactWithSupportDate() throws Exception {
		String lastName = eLib.getDataFromExcel("contact", 3 , 2) + jLib.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastNameTxtF().sendKeys(lastName);
		String startDate = jLib.getSystemDateyyyyMMddFormat();
		String endDate = jLib.getRequiredDateyyyyMMddFormat(30);
		cncp.getStartDateTxtF().clear();
		cncp.getStartDateTxtF().sendKeys(startDate);
		cncp.getEndDateTxtF().clear();
		cncp.getEndDateTxtF().sendKeys(endDate);
		cncp.getSaveBtn().click();
		
		ContactInformationPage cip = new ContactInformationPage(driver);
		String contactInfo = cip.getContactInfo().getText();	
		boolean status = contactInfo.contains(lastName);
		Assert.assertEquals(status, true);
		
		String actStartDate = cip.getStartDateInfo().getText();
		SoftAssert SA = new SoftAssert();
		SA.assertEquals(actStartDate, startDate);
		SA.assertAll();
		
		String actEndDate =	cip.getEndDateInfo().getText();
		SA.assertEquals(actEndDate, endDate);
		SA.assertAll();
	}
	
	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws Exception {
		String lastName = eLib.getDataFromExcel("contact", 5 , 2) + jLib.getRandomNumber();
		String OrgName = eLib.getDataFromExcel("contact", 5 , 3) + jLib.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(OrgName);
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status1 = actOrgName.contains(OrgName);
		Assert.assertEquals(status1, true);
		
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
		boolean status = contactInfo.contains(lastName);
		Assert.assertEquals(status, true);
		
		actOrgName = cip.getOrgName().getText();
		boolean status2= actOrgName.contains(OrgName);
		Assert.assertEquals(status2, true);
}
}
