package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.data.fileutility.ExcelUtility;
import com.comcast.crm.generic.data.fileutility.FileUtility;
import com.comcast.crm.generic.data.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.data.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest {
	@Test
	public void orgPage() throws Throwable {
		
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtlity jlib = new JavaUtlity();
	WebDriverUtility wLib = new WebDriverUtility();
	
	String BROWSER = fLib.getDataFromPropertiesFile("browser");
	String URL = fLib.getDataFromPropertiesFile("url");
	String USERNAME = fLib.getDataFromPropertiesFile("username");
	String PASSWORD = fLib.getDataFromPropertiesFile("password");
	
	String OrganizationName = eLib.getDataFromExcel("org", 1 , 2) + jlib.getRandomNumber();
	
	WebDriver driver=null;
	
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
//	getters method provide single element access 
	hp.getOrgLink().click(); 
//	Business method provides multiple elements access
//	hp.navigateToCampaignsPage();
	
	OrganizationsPage op = new OrganizationsPage(driver);
	op.getCreateNewOrgBtn().click();
	
	CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	cnop.createOrg(OrganizationName);
	
	OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	String actOrgName = oip.getHeaderMsg().getText();
	if (actOrgName.contains(OrganizationName)) 
		{
			System.out.println(OrganizationName + " is verified==PASS");
		} 
		else
		{
			System.out.println(OrganizationName + " is not verified==FAIL");
		}
	
	hp.logout();

	driver.quit();

}

}


