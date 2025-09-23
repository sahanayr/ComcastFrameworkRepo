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
import com.comcast.crm.objectrepositoryutility.CreateNewDocumentPage;
import com.comcast.crm.objectrepositoryutility.CreateNewTicketPage;
import com.comcast.crm.objectrepositoryutility.DocumentInformationPage;
import com.comcast.crm.objectrepositoryutility.DocumentsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.TroubleTicketInfoPage;
import com.comcast.crm.objectrepositoryutility.TroubleTitlePage;

public class CreateNewTicketTest extends BaseClass{
	@Test
	public void createTicket() throws Exception {
		
		UtilityClassObject .getTest().log(Status.INFO, "read data from excel");
		String title = eLib.getDataFromExcel("troubleTickets", 1 , 2);
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getTicketsLink().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to Trouble Title  page");
		TroubleTitlePage ttp = new TroubleTitlePage(driver);
		ttp.getNewTitleBtn().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to create new ticket page");
		CreateNewTicketPage cntp = new CreateNewTicketPage(driver);
		cntp.getTitleTxtAF().sendKeys(title);
		cntp.getSaveBtn().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "verified new ticket created");
		TroubleTicketInfoPage ttip = new TroubleTicketInfoPage(driver);
		String actTitle = ttip.getTroubleTitleInfo().getText();
		boolean status = actTitle.contains(title);
		Assert.assertEquals(status, true);
		
	
	
		
		
	}
}
