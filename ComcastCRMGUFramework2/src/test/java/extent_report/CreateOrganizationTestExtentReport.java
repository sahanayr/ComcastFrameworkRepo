package extent_report;

import org.openqa.selenium.Alert;
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
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTestExtentReport extends BaseClass {
	@Test(groups = "smokeTest")
	public void orgPage() throws Throwable {
	UtilityClassObject .getTest().log(Status.INFO, "read data from excel");
	String OrganizationName = eLib.getDataFromExcel("org", 1 , 2) + jLib.getRandomNumber();
	
	UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
	HomePage hp = new HomePage(driver);
	hp.getOrgLink().click(); 
	UtilityClassObject .getTest().log(Status.INFO, "navigate to org page");
	OrganizationsPage op = new OrganizationsPage(driver);
	op.getCreateNewOrgBtn().click();
	UtilityClassObject .getTest().log(Status.INFO, "navigate to create new org page");
	CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	cnop.createOrg(OrganizationName);
	
	UtilityClassObject .getTest().log(Status.INFO, "verify the org name created");
	OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	String actOrgName = oip.getHeaderMsg().getText();
	boolean status = actOrgName.contains(OrganizationName);
	Assert.assertEquals(status, true);
}
	
	@Test(groups = "regressionTest")
	public void createOrgWithIndustry()throws Exception {
		UtilityClassObject .getTest().log(Status.INFO, "read data from excel");
		String OrganizationName = eLib.getDataFromExcel("org", 3 , 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 3 , 5);
		String type = eLib.getDataFromExcel("org", 3 , 4);
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		UtilityClassObject .getTest().log(Status.INFO, "navigate to org page");
		OrganizationsPage op = new OrganizationsPage(driver);
		UtilityClassObject .getTest().log(Status.INFO, "navigate to create org page");
		op.getCreateNewOrgBtn().click();
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		UtilityClassObject .getTest().log(Status.INFO, "org created with industry and type");
		cnop.createOrg(OrganizationName, industry, type);
		
		UtilityClassObject .getTest().log(Status.INFO, "org created with industry and type is verified");
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status = actOrgName.contains(OrganizationName);
		Assert.assertEquals(status, true);
		
		String actIndustry = oip.getIndustryInfo().getText();	
		SoftAssert SA = new SoftAssert();
		SA.assertEquals(actIndustry, industry);
		SA.assertAll();
		
		String actType = oip.getTypeInfo().getText();		
		SA.assertEquals(actType, type);
		SA.assertAll();
	}
	
	@Test(groups = "regressionTest")
	public void createOrgWithPhoneNumber() throws Exception {
		UtilityClassObject .getTest().log(Status.INFO, "read data from excel");
		String OrganizationName = eLib.getDataFromExcel("org", 5 , 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 5 , 4); 
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		UtilityClassObject .getTest().log(Status.INFO, "navigate to org page");
		hp.getOrgLink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		UtilityClassObject .getTest().log(Status.INFO, "navigate to create org page");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameTxtF().sendKeys(OrganizationName);
		cnop.getPhoneNumTxtF().sendKeys(phoneNumber);
		cnop.getSaveBtn().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "org created with phoneNumber is verified");
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status = actOrgName.contains(OrganizationName);
		Assert.assertEquals(status, true);
		
		String actPhoneNum = oip.getPhoneNum().getText();
		SoftAssert SA = new SoftAssert();
		SA.assertEquals(actPhoneNum, phoneNumber);
		SA.assertAll();
}
	
	@Test(groups = "regressionTest")
	public void deleteOrgTest() throws Throwable {
		UtilityClassObject .getTest().log(Status.INFO, "read data from excel");
		String OrganizationName = eLib.getDataFromExcel("org", 7 , 2) + jLib.getRandomNumber();
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click(); 
		UtilityClassObject .getTest().log(Status.INFO, "navigate to org page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();	
		UtilityClassObject .getTest().log(Status.INFO, "navigate to create org page");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(OrganizationName);
		
		UtilityClassObject .getTest().log(Status.INFO, "verify the org name created");
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status = actOrgName.contains(OrganizationName);
		Assert.assertEquals(status, true);
		
		hp.getOrgLink().click(); 
		op.getSeartchTxtF().sendKeys(OrganizationName);
		wLib.select(op.getSearchDd(), "Organization Name");
		op.getSearchBtn().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "org name got deleted");
		driver.findElement(By.xpath("//a[text()='"+OrganizationName+"']/../../td[8]/a[text()='del']")).click();
		
	     Alert popup = driver.switchTo().alert();
	     popup.accept();
		
	}
}

	

