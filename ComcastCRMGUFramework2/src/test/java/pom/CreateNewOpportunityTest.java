package pom;

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

public class CreateNewOpportunityTest {
	@Test
	public void createNewOpportunity() throws Throwable {
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtlity jlib = new JavaUtlity();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		

		String opportunityName = eLib.getDataFromExcel("opportunites", 1 , 2);
		String OrganizationName = eLib.getDataFromExcel("org", 1 , 2)+jlib.getRandomNumber();
		String type = eLib.getDataFromExcel("opportunites", 1 , 3);
		String source = eLib.getDataFromExcel("opportunites", 1 , 4);
		
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
		cnop.createOrg(OrganizationName);
		Thread.sleep(2000);
		hp.getOpportunityLink().click();
		OpportunitiesPage opp = new OpportunitiesPage(driver);
		opp.getCreateOpportunityBtn().click();
		
		CreateNewOpportunityPage cnopp = new CreateNewOpportunityPage(driver);
		cnopp.getOpportunityNameTxtF().sendKeys(opportunityName);
		cnopp.getAddRelatedToBtn().click();
		wLib.switchToTabOnURL(driver, "module=Accounts");
		OpportunityOrganizationsPage oop = new OpportunityOrganizationsPage(driver);
		oop.getSearchTxtF().sendKeys(OrganizationName);
		oop.getSearchNowBtn().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+OrganizationName+"']")).click();
		
		wLib.switchToTabOnURL(driver, "Potentials&action");
		cnopp.createOpportunity(type, source);	
		String closeDate = jlib.getRequiredDateyyyyMMddFormat(100);
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cnopp.getCloseDateTxtF().clear();
		cnopp.getCloseDateTxtF().sendKeys(closeDate);
		cnopp.getSaveBtn().click();
		
		OpportunitiesInformationPage oip = new OpportunitiesInformationPage(driver);
		String actOpportunityName = oip.getOpportunityInfo().getText();
		if (actOpportunityName.contains(opportunityName)) 
			{
				System.out.println(opportunityName + " is verified==PASS");
			} 
			else
			{
				System.out.println(opportunityName + " is not verified==FAIL");
			}
		
		hp.logout();
		driver.quit();
		
	} 
}
