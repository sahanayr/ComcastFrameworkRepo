package brokenlinksandcalender;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinksSBI {
	@Test 
	public void handleBrokenLinksTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.onlinesbi.sbi/");
		driver.findElements(By.tagName("a"));
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		
		for (WebElement link : allLinks) {
//		String eachLink = link.getAttribute("href");
		String eachLink = link.getDomAttribute("href");
		
		try {
		URL url = new URL(eachLink);
		HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();
		int statusCode = httpconn.getResponseCode();
		if (statusCode>=400) {
			System.out.println(eachLink+ "==" +statusCode);
		}
		} catch (Exception e) {
			
		}
		}
		driver.quit();
	}
}


