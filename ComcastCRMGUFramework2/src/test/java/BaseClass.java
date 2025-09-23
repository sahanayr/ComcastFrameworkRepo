import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import com.comcast.crm.generic.data.fileutility.FileUtility;

public class BaseClass {
	WebDriver driver;
	FileUtility fLib = new FileUtility();
	public void BC() throws Exception {
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
}
	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void AC() {
		driver.quit();
	}
}
