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
import com.comcast.crm.objectrepositoryutility.CreateNewDocumentPage;
import com.comcast.crm.objectrepositoryutility.DocumentInformationPage;
import com.comcast.crm.objectrepositoryutility.DocumentsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateNewDocumentTest {
	@Test
	public void createNewDocument() throws Exception {
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtlity jlib = new JavaUtlity();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		String title = eLib.getDataFromExcel("documents", 1 , 2);
		
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
		hp.getDocumentsLink().click();
		
		DocumentsPage dp = new DocumentsPage(driver);
		dp.getNewDocBtn().click();
		
		CreateNewDocumentPage cndp = new CreateNewDocumentPage(driver);
		cndp.getTitleTxtF().sendKeys(title);
		cndp.getSaveBtn().click();
		
		DocumentInformationPage dip = new DocumentInformationPage(driver);
		String actTitle = dip.getDocInfo().getText();
		
		if (actTitle.contains(title)) 
		{
			System.out.println(title + " is verified==PASS");
		} 
		else
		{
			System.out.println(title + " is not verified==FAIL");
		}
	
	hp.logout();

	driver.quit();
		
		
	}
}
