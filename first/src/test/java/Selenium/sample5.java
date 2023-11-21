package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sample5 {
	public static String url="https://www.saucedemo.com/v1/";
    WebDriver driver;
    
    @BeforeTest
    public void bt() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "C://Users//gunac//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe/");
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);    
    }
    
    @Test(enabled = true, priority = 1)
    public void login() throws InterruptedException {
    	WebElement un = driver.findElement(By.id("user-name"));
    	un.sendKeys("standard_user");
    	WebElement pwd=driver.findElement(By.name("password"));
    	pwd.sendKeys("secret_sauce");
    	driver.findElement(By.className("btn_action")).click();
    	Thread.sleep(3000);
    }
    
    @Test(enabled = true, priority = 2)
    public void printAllLinks() {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
    	int count = allLinks.size();
    	System.out.println(count);
    	for(int i=0;i<count;i++) {
    		String link = allLinks.get(i).getText();
    		String href = allLinks.get(i).getAttribute("href");
    		System.out.println(href+" : "+link);
    		//System.out.println(link);
    	}
    	driver.close();
    }
}