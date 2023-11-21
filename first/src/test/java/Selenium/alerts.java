package Selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alerts {
	public static String url = "https://demoqa.com/alerts";
    WebDriver driver;
    @BeforeTest
	public void open() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "C://Users//gunac//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe/");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test (enabled = false)
    public void alert() {
//    	driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
    	driver.findElement(By.id("alertButton")).click();
    	System.out.println("alert button clicked");
    	Alert pop = driver.switchTo().alert();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	pop.accept();
    }
    @Test(enabled = false)
    public void alert2() {
    	driver.findElement(By.id("timealertButton")).click();
    	WebDriverWait wait = new WebDriverWait(driver, 7);
    	wait.until(ExpectedConditions.alertIsPresent());
    	Alert pop2 = driver.switchTo().alert();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	pop2.accept();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    }
    @Test(enabled = false)
    public void alert3() throws InterruptedException {
    	driver.findElement(By.id("confirmButton")).click();
    	Alert pop3 = driver.switchTo().alert();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	pop3.dismiss();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	Thread.sleep(3000);
    }
    @Test(enabled = false)
    public void alert4() throws InterruptedException {
    	driver.findElement(By.id("promtButton")).click();
    	Alert pop4 = driver.switchTo().alert();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	pop4.sendKeys("guna");
    	Thread.sleep(3000);
    	pop4.accept();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	Thread.sleep(3000);
    }
    
    @Test(enabled=true,priority=0,groups = {"smoke"})
    public void al4() throws InterruptedException, IOException {
        JavascriptExecutor scroll=(JavascriptExecutor)driver;
        //{0,100} this is for going or scrolling.
        scroll.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.xpath("(//*[@type='button'])[5]")).click();
        Alert alt=driver.switchTo().alert();
        alt.sendKeys("hello");
        alt.accept();
        scroll.executeScript("window.scrollBy(0,-100)");
        scroll.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        TakesScreenshot ss = (TakesScreenshot)driver;
        File fil = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fil, new File("C:\\Users\\gunac\\Pictures\\Selenium ss\\ss.png"));
    }
    @AfterTest
    public void close() {
    	driver.close();
    }
}
