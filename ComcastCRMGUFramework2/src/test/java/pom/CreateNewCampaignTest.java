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
import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewCampaignPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateNewCampaignTest {
	@Test
	public void createNewCampaign() throws Exception {
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtlity jlib = new JavaUtlity();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		String campaignName = eLib.getDataFromExcel("campaigns", 1 , 2);
		
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
		hp.getMoreLink().click();
		hp.getCampaignLink().click();
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getNewcampaignBtn().click();
		CreateNewCampaignPage cncp = new CreateNewCampaignPage(driver);
		cncp.getCampaignNameTxtF().sendKeys(campaignName);
		cncp.getSaveBtn().click();
		
		CampaignInformationPage cip = new CampaignInformationPage(driver);
		String actCampaignName = cip.getCampaignInfo().getText();
		if (actCampaignName.contains(campaignName)) 
		{
			System.out.println(campaignName + " is verified==PASS");
		} 
		else
		{
			System.out.println(campaignName + " is not verified==FAIL");
		}
	
	hp.logout();

	driver.quit();
		
		
		
	}
}
