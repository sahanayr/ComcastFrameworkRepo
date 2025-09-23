package baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;
import com.comcast.crm.generic.data.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.data.fileutility.ExcelUtility;
import com.comcast.crm.generic.data.fileutility.FileUtility;
import com.comcast.crm.generic.data.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.data.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.data.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	
	public WebDriver driver = null;
	public static  WebDriver sdriver = null;
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtlity jLib = new JavaUtlity();
	public WebDriverUtility wLib = new WebDriverUtility();
	public DataBaseUtility dLib = new DataBaseUtility();
	
	
	
	@BeforeSuite(groups = {"smokeTest", "regressionTest"})
	public void BS() throws Throwable {
		System.out.println("Connect to DB, Report Config");
		dLib.getDbConnection();
		
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest", "regressionTest"})
//	public void BC(String browser) throws Exception {
		public void BC() throws Exception {
//		String BROWSER = browser;
		System.out.println("Launch the Browser");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		
//		Dont store the driver object inside the @beforeclass annotation (it becomes local variable to @beforeclass annotation method )bcz this driver object also required in @beforemethod annotation to login to application , hence declare this as global variable.
	
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	public void BM() throws Exception {
		System.out.println("Login");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void AM() {
		System.out.println("Logout");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void AC() {
		System.out.println("Close the Browser");
		driver.quit();
	}
	
	@AfterSuite(groups = {"smokeTest", "regressionTest"})
	public void AS() throws Exception {
		System.out.println("close Db, report backup");
		dLib.closeDbConnection();
		
		
	}
	
}
	
	
	