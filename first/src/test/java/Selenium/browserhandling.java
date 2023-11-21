package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserhandling {
	public static String url = "https://demo.guru99.com/test/newtours/login.php";
	WebDriver cdriver;
	WebDriver edriver;
	@Parameters("{mybrowser}")
	
	@BeforeTest()
	public void open(@Optional("chrome") String mybrowser) {
//		if(mybrowser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			cdriver = new ChromeDriver();
//			cdriver.get(url);
//		}
		if(mybrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			edriver = new EdgeDriver();
			edriver.get(url);
		}
	}
	@Test
	public void tc() {
		System.out.println("hi");
	}
}
