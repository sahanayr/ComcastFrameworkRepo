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
import com.comcast.crm.objectrepositoryutility.DocumentInformationPage;
import com.comcast.crm.objectrepositoryutility.DocumentsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateNewDocumentTest extends BaseClass {
	@Test
	public void createNewDocument() throws Exception {
		
		UtilityClassObject .getTest().log(Status.INFO, "read data from excel");
		String title = eLib.getDataFromExcel("documents", 1 , 2);
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getDocumentsLink().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to document page");
		DocumentsPage dp = new DocumentsPage(driver);
		dp.getNewDocBtn().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to create new document page");
		CreateNewDocumentPage cndp = new CreateNewDocumentPage(driver);
		cndp.getTitleTxtF().sendKeys(title);
		cndp.getSaveBtn().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "verified the document created");
		DocumentInformationPage dip = new DocumentInformationPage(driver);
		String actTitle = dip.getDocInfo().getText();
		boolean status = actTitle.contains(title);
		Assert.assertEquals(status, true);		


		
	}
}
