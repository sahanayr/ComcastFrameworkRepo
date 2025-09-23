package testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;


public class SampleTestForScreenShot {
	@Test
	public void amazonTest() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
	EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
	File srcFile = edriver.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File("./screenshots/test.png"));
	}
}
