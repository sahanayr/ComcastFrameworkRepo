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
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.ProductsInformationPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;

public class CreateNewProductTest {

	@Test
	public void createNewContact() throws Throwable {
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtlity jlib = new JavaUtlity();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		String productName = eLib.getDataFromExcel("products", 1 , 2);
		
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
		hp.getProductsLink().click();
		
		ProductsPage pp = new ProductsPage(driver);
		pp.getCreateProductBtn().click();
		
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.getProductNameTxtF().sendKeys(productName);
		cnpp.getSaveBtn().click();
		
		ProductsInformationPage pip = new ProductsInformationPage(driver);
		String actProductName = pip.getProductInfo().getText();
		if (actProductName.contains(productName)) 
		{
			System.out.println(productName + " is verified==PASS");
		} 
		else
		{
			System.out.println(productName + " is not verified==FAIL");
		}
	
	hp.logout();

	driver.quit();
		
	}
}
