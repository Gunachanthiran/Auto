package Selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class junit {
	WebDriver driver;
	@Before
	public void bef() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	@Test
	public void tc() {
		String title = driver.getTitle();
		System.out.println("title of the page is "+ title);
	}
	@Test
	public void tc2() {
		String curl = driver.getCurrentUrl();
		System.out.println("url of the page is "+ curl);
	}
	@After
	public void close() {
		driver.close();
	}

}
