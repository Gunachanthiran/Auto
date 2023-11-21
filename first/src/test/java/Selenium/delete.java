package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class delete {
	public static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    WebDriver driver;
    @BeforeTest
	public void bt() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//gunac//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe/");
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    
    @Test(enabled = true, priority=0)
	public void login() throws InterruptedException {
		    WebElement un=driver.findElement(By.name("username"));
	        un.sendKeys("Admin");
	        WebElement pwd=driver.findElement(By.name("password"));
	        pwd.sendKeys("admin123");
	        driver.findElement(By.xpath("//*[@type='submit']")).click();
	        Thread.sleep(5000);
    }
    
    @Test(enabled = true, priority = 1)
    public void del() {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.linkText("Admin")).click();
    	driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(4).click();
    	driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
    	driver.close();
    }

}
