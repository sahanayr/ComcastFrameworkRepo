import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class mock1Test {

	@Test
	public void demoWebShop() throws Exception{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		DemoWebShop dws = new DemoWebShop(driver);
		dws.RegisterToApp();
		dws.getBooksLink().click();
		dws.getB1C().click();
		dws.getB2C().click();
		dws.getB3C().click();
		Thread.sleep(4000);
		dws.getShopping().click();
		TakesScreenshot ts =(TakesScreenshot)driver;
		   File temp = ts.getScreenshotAs(OutputType.FILE);
		   File perm = new File("./screenshots/screenshot1.png");
		   FileHandler.copy(temp, perm);
	        List<WebElement> NameOfTheProducts = driver.findElements(By.xpath("//a[@class='product-name']"));
	        XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sh = wb.createSheet("books");
			Row r = sh.createRow(0);
			r.createCell(0).setCellValue("Book Name");
			for (int i = 0; i < NameOfTheProducts.size(); i++) {
				String	Name =  NameOfTheProducts.get(i).getText();
				Row r1 = sh.createRow(i+1);
				r1.createCell(0).setCellValue(Name);
			}
			FileOutputStream fos = new FileOutputStream("Books.xlsx");
			wb.write(fos);
			fos.close();
			wb.close();
			System.out.println("Data written to Excel");
			driver.quit(); 

	}
}
