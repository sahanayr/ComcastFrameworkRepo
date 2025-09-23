package extent_report;

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
import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewCampaignPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateNewCampaignTest extends BaseClass{
	@Test
	public void createNewCampaign() throws Exception {
		
		UtilityClassObject .getTest().log(Status.INFO, "read data from excel");
		String campaignName = eLib.getDataFromExcel("campaigns", 1 , 2);

		UtilityClassObject .getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getMoreLink().click();
		UtilityClassObject .getTest().log(Status.INFO, "navigate to more link");
		hp.getCampaignLink().click();
		UtilityClassObject .getTest().log(Status.INFO, "navigate to campaign page");
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getNewcampaignBtn().click();
		UtilityClassObject .getTest().log(Status.INFO, "navigate to create new campaign page");
		CreateNewCampaignPage cncp = new CreateNewCampaignPage(driver);
		cncp.getCampaignNameTxtF().sendKeys(campaignName);
		cncp.getSaveBtn().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "verified campaign name created");
		CampaignInformationPage cip = new CampaignInformationPage(driver);
		String actCampaignName = cip.getCampaignInfo().getText();
		boolean status = actCampaignName.contains(campaignName);
		Assert.assertEquals(status, true);
	
	}
}
