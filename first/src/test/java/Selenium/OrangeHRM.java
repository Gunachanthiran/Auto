package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class OrangeHRM {
	
	public static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    WebDriver driver;
    ExtentHtmlReporter htmlreporter;
    ExtentReports extent;
    ExtentTest test;
    
	@BeforeTest
	public void bt() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//gunac//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe/");
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);    
        
        
        htmlreporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlreporter);
	}
	
	@Test(enabled=false, priority=1)
	public void login() throws InterruptedException {
		    WebElement un=driver.findElement(By.name("username"));
	        un.sendKeys("Admin");
	        WebElement pwd=driver.findElement(By.name("password"));
	        pwd.sendKeys("admin123");
	        //Thread.sleep(3000);
	        driver.findElement(By.xpath("//*[@type='submit']")).click();
	        Thread.sleep(5000);
	}
	
	@Test(enabled=false, priority=2)
	public void printAllLinks() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for(int i=0;i<allLinks.size();i++) {
			String link = allLinks.get(i).getText();
			System.out.println(link);
		}
	}
	
	@Test(enabled=false, priority=1)
	public void compareTitles() {
		String expected = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement un=driver.findElement(By.name("username"));
		un.sendKeys("Admin");
		WebElement pwd=driver.findElement(By.name("password"));
		pwd.sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		String actual=driver.getTitle();
		System.out.println(expected);
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	}
	
	@Test(enabled=false, priority=1)
	public void mouseHoverActions() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement un=driver.findElement(By.name("username"));
		un.sendKeys("Admin");
		WebElement pwd=driver.findElement(By.name("password"));
		pwd.sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Actions a=new Actions(driver);
		//WebElement path=driver.findElement(By.xpath("//*[text()='Admin']"));
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@placeholder='Type for hints...']")).sendKeys("employee2");
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		WebElement dp1 = driver.findElement(By.xpath("(//*[@class='oxd-select-text-input'])[1]"));
		Thread.sleep(5000);
		act.sendKeys(dp1,Keys.ARROW_DOWN).click().build().perform();
		//act.sendKeys(dp1,Keys.ARROW_DOWN).click().build().perform();
		//a.contextClick(path).perform();
	}
	
	@Test(enabled = false, priority = 0)
	public void compareTitlesUsingSA() {
		String expected = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement un=driver.findElement(By.name("username"));
		un.sendKeys("Admin");
		WebElement pwd=driver.findElement(By.name("password"));
		pwd.sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		String actual = driver.getTitle();
		System.out.println(expected);
		System.out.println(actual);
	    SoftAssert s=new SoftAssert();
		s.assertEquals(expected, actual);
		s.assertAll();
	}
	
	@Test(enabled = true, priority = 0)
	public void table() throws InterruptedException {
		test = extent.createTest("this is my first test");
		WebElement un=driver.findElement(By.name("username"));
		un.sendKeys("Admin");
		WebElement pwd=driver.findElement(By.name("password"));
		pwd.sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Admin")).click();
		test.pass("i clicked on admin");
		List<WebElement> rows = driver.findElements(By.xpath("//*[@class='oxd-table-card']"));
		test.pass("finding the list of elements");
	    int count = rows.size();
	    test.pass("printing the size of rows");
	    System.out.println(count);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    driver.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(4).click();
	    test.pass("clicking on the checkbox");
	    extent.flush();
	}
	
	
}