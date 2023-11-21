package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadriven {
	public static String url = "https://demo.guru99.com/test/newtours/login.php";
	WebDriver driver;
	
	@BeforeTest
	public void bt() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users//gunac//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe/");
		driver = new ChromeDriver();
		driver.get(url);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
	}
	@Test
	public void dd() throws IOException, InterruptedException {
		File dd = new File("C:/Users/gunac/OneDrive/Desktop/dd.xlsx");
		FileInputStream file = new FileInputStream(dd); //getting the input from the excel
		XSSFWorkbook book = new XSSFWorkbook(file); //my excel sheet workbook format
		XSSFSheet sheet = book.getSheet("Sheet1"); //taking the input from sheet1 present i xssf format
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		for (int i=0; i<=rowcount; i++) {
			String user = sheet.getRow(i).getCell(0).getStringCellValue();
			String pass = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(user);
			System.out.println(pass);
			driver.findElement(By.xpath("//*[@name='userName']")).sendKeys(user);
			driver.findElement(By.xpath("//*[@name='password']")).sendKeys(pass);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			Thread.sleep(2000);
		}
	}

}
