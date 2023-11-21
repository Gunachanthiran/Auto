package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample {
	public static String url="https://demo.guru99.com/test/newtours/login.php";
	WebDriver driver;
	@BeforeTest
	public void bs() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		Thread.sleep(5000);
	}
	@Test
	public void tc1() {
		System.out.println("hello");
	}
	
}
