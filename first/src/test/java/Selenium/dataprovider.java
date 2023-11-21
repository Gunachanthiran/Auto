package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataprovider {
	public static String url="https://www.saucedemo.com/v1/";
    WebDriver driver;
    
    @BeforeTest
    public void open(){
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize(); 
    }
    @Test(dataProvider = "dp")
    public void login(String uname, String pass){
    	WebElement un = driver.findElement(By.id("user-name"));
    	un.sendKeys(uname);
    	WebElement pwd=driver.findElement(By.name("password"));
    	pwd.sendKeys(pass);
    	driver.findElement(By.className("btn_action")).click();
    	driver.navigate().back();
    	driver.navigate().refresh();
    }
    @DataProvider
    public Object[][] dp() {
    	return new Object[][] {
    	new Object[] {"standard_user","secret_sauce"},
    	new Object[] {"locked_out_user","secret_sauce"},
    	new Object[] {"problem_user","secret_sauce"},
    	new Object[] {"performance_glitch_user","secret_sauce"},
    };}

}
