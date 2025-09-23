package extent_report;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.data.fileutility.ExcelUtility;
import com.comcast.crm.generic.data.fileutility.FileUtility;
import com.comcast.crm.generic.data.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.data.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.data.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOpportunityPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OpportunitiesInformationPage;
import com.comcast.crm.objectrepositoryutility.OpportunitiesPage;
import com.comcast.crm.objectrepositoryutility.OpportunityOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateNewOpportunityTest extends BaseClass{
	@Test
	public void createNewOpportunity() throws Throwable {
		
		UtilityClassObject .getTest().log(Status.INFO, "read data from excel");
		String opportunityName = eLib.getDataFromExcel("opportunites", 1 , 2);
		String OrganizationName = eLib.getDataFromExcel("org", 1 , 2)+jLib.getRandomNumber();
		String type = eLib.getDataFromExcel("opportunites", 1 , 3);
		String source = eLib.getDataFromExcel("opportunites", 1 , 4);
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		UtilityClassObject .getTest().log(Status.INFO, "navigate to org page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to create new org page");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(OrganizationName);
		Thread.sleep(2000);
		UtilityClassObject .getTest().log(Status.INFO, "navigate to opportunity page");
		hp.getOpportunityLink().click();
		UtilityClassObject .getTest().log(Status.INFO, "navigate to create new opportunity page");
		OpportunitiesPage opp = new OpportunitiesPage(driver);
		opp.getCreateOpportunityBtn().click();
		
		CreateNewOpportunityPage cnopp = new CreateNewOpportunityPage(driver);
		cnopp.getOpportunityNameTxtF().sendKeys(opportunityName);
		cnopp.getAddRelatedToBtn().click();
		UtilityClassObject .getTest().log(Status.INFO, "swith to child tab");
		wLib.switchToTabOnURL(driver, "module=Accounts");
		OpportunityOrganizationsPage oop = new OpportunityOrganizationsPage(driver);
		oop.getSearchTxtF().sendKeys(OrganizationName);
		oop.getSearchNowBtn().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+OrganizationName+"']")).click();
		
		UtilityClassObject .getTest().log(Status.INFO, "switch back to parent tab");
		wLib.switchToTabOnURL(driver, "Potentials&action");
		UtilityClassObject .getTest().log(Status.INFO, "create opportunity with type,source and close date");
		cnopp.createOpportunity(type, source);	
		String closeDate = jLib.getRequiredDateyyyyMMddFormat(100);
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cnopp.getCloseDateTxtF().clear();
		cnopp.getCloseDateTxtF().sendKeys(closeDate);
		cnopp.getSaveBtn().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "verified opportunity with type,source and close date");
		OpportunitiesInformationPage oip = new OpportunitiesInformationPage(driver);
		String actOpportunityName = oip.getOpportunityInfo().getText();
		boolean status = actOpportunityName.contains(opportunityName);
		Assert.assertEquals(status, true);
		
	} 
}
