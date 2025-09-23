

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class mock1DemoWebShop {
	@Test
	public void register() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-register")).click();
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("vini");
		driver.findElement(By.id("LastName")).sendKeys("yr");
		driver.findElement(By.id("Email")).sendKeys("vini@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("viniyr");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("viniyr");
		driver.findElement(By.id("register-button")).click();
	}
	
	@Test
	public void login() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys("vini@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("viniyr");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@Test
	public void books() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/books");
		driver.findElement(By.xpath("//a[@href='/books']")).click();	
		driver.findElement(By.xpath("(//input[@type='button'])[4]")).click();
		driver.findElement(By.xpath("(//input[@type='button'])[4]")).click();
		driver.findElement(By.xpath("(//input[@type='button'])[5]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//span[@class=\"cart-label\"])[1]")).click();
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
	



