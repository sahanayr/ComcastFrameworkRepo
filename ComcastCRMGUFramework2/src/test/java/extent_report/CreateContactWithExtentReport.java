package extent_report;

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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.data.fileutility.ExcelUtility;
import com.comcast.crm.generic.data.fileutility.FileUtility;
import com.comcast.crm.generic.data.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.data.webdriverutility.UtilityClassObject;
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

public class CreateContactWithExtentReport extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContact() throws Exception {	
		UtilityClassObject .getTest().log(Status.INFO, "read data from excel");
		String lastName = eLib.getDataFromExcel("contact", 1 , 2) + jLib.getRandomNumber();
	
		UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		hp.getContactLink().click();
		ContactsPage cp = new ContactsPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create new contact page");
		cp.getCreateNewContactBtn().click();
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastNameTxtF().sendKeys(lastName);
		cncp.getSaveBtn().click();
		ContactInformationPage cip = new ContactInformationPage(driver);
		
		UtilityClassObject .getTest().log(Status.INFO, "verified the contact name created");
		String contactInfo = cip.getContactInfo().getText();	
		boolean status = contactInfo.contains(lastName);
		Assert.assertEquals(status, true);
		}
	
	@Test(groups = "regressionTest")
	public void createContactWithSupportDate() throws Exception {
		UtilityClassObject .getTest().log(Status.INFO, "read data from excel");
		String lastName = eLib.getDataFromExcel("contact", 3 , 2) + jLib.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		hp.getContactLink().click();
		ContactsPage cp = new ContactsPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create new contact page");
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
		
		UtilityClassObject .getTest().log(Status.INFO, "verify the contact name created with start and end date");
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
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastName = eLib.getDataFromExcel("contact", 5 , 2) + jLib.getRandomNumber();
		String OrgName = eLib.getDataFromExcel("contact", 5 , 3) + jLib.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		hp.getOrgLink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create new org page");
		
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(OrgName);
		
		UtilityClassObject .getTest().log(Status.INFO, "verify the org name created");
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status1 = actOrgName.contains(OrgName);
		Assert.assertEquals(status1, true);
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		hp.getContactLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create new contact page");
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastNameTxtF().sendKeys(lastName);
		cncp.getAddOrgBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "control shifted to child tab");
		wLib.switchToTabOnURL(driver, "module=Accounts");
		
		ContactOrganizationsPage cop = new ContactOrganizationsPage(driver);
		cop.getSearchTxtF().sendKeys(OrgName);
		cop.getSearchBtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		UtilityClassObject.getTest().log(Status.INFO, "control shifted back to parent tab");
		wLib.switchToTabOnURL(driver, "module=Contacts");
		cncp.getSaveBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "verify the contact name created with org");
		ContactInformationPage cip = new ContactInformationPage(driver);
		String contactInfo = cip.getContactInfo().getText();	
		boolean status = contactInfo.contains(lastName);
		Assert.assertEquals(status, true);
		
		actOrgName = cip.getOrgName().getText();
		boolean status2= actOrgName.contains(OrgName);
		Assert.assertEquals(status2, true);
}
}
