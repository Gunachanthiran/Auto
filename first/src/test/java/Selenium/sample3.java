package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sample3 {
	public static String url = "https://demo.guru99.com/test/newtours/login.php";
	WebDriver driver;
	@BeforeTest
	public void bt() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users//gunac//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe/");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(10000);
	}
	@Test(enabled = false,priority = 1)
	public void tc1() {

		WebElement user = driver.findElement(By.xpath("//*[@name='userName']"));
		user.sendKeys("user");
		WebElement pass = driver.findElement(By.xpath("//*[@name='password']"));
		pass.sendKeys("user");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
	@Test(enabled = false,priority = 0)
	public void tc2() {
		driver.findElement(By.linkText("REGISTER")).click();
		WebElement name = driver.findElement(By.name("firstName"));
		name.sendKeys("Guna");
		WebElement lname = driver.findElement(By.name("lastName"));
		lname.sendKeys("K");
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("1234567889");
		WebElement email = driver.findElement(By.name("userName"));
		email.sendKeys("guna12@gmail.com");
		WebElement add = driver.findElement(By.name("address1"));
		add.sendKeys("ulundurpet");
		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("villupuram");
		WebElement state = driver.findElement(By.name("state"));
		state.sendKeys("Tamil Nadu");
		WebElement pincode = driver.findElement(By.name("postalCode"));
		pincode.sendKeys("606107");
		WebElement country = driver.findElement(By.name("country"));
		Select option = new Select(country);
		option.selectByIndex(7);
		WebElement user = driver.findElement(By.name("email"));
		user.sendKeys("guna");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("guna");
		WebElement confirmpassword = driver.findElement(By.name("confirmPassword"));
		confirmpassword.sendKeys("guna");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
	@Test(enabled=true,priority = 0)
    public void links() {
        List<WebElement> link= driver.findElements(By.tagName("a"));  //all links in a tag
        for(int i=0;i<link.size();i++)
        {
           String ab=link.get(i).getAttribute("href");
           String c="https://demo.guru99.com/test/newtours/support.php";
           if(ab.equals(c)) {
               System.out.println("LINKS ARE UNDER CONSTRUCTION"+link.get(i).getText());

           }
           else {
               System.out.println("Links are working"+link.get(i).getText());
           }
        }
    }
	@Test(enabled = true,priority = 0)
	public void act() {
		Actions act = new Actions(driver);
		WebElement us = driver.findElement(By.name("userName"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		act.contextClick(us).click().build().perform();
		driver.close();
		
	}



}
