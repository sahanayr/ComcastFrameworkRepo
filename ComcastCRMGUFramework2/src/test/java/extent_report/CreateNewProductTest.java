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
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.ProductsInformationPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;

public class CreateNewProductTest extends BaseClass{

	@Test
	public void createNewContact() throws Throwable {
		
		UtilityClassObject .getTest().log(Status.INFO, "read data from excel");
		String productName = eLib.getDataFromExcel("products", 1 , 2);
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to products page");
		ProductsPage pp = new ProductsPage(driver);
		pp.getCreateProductBtn().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "navigate to create new product page");
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.getProductNameTxtF().sendKeys(productName);
		cnpp.getSaveBtn().click();
		
		UtilityClassObject .getTest().log(Status.INFO, "verified new product created");
		ProductsInformationPage pip = new ProductsInformationPage(driver);
		String actProductName = pip.getProductInfo().getText();
		boolean status = actProductName.contains(productName);
		Assert.assertEquals(status, true);	}
}
