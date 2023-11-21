package definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	public static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    WebDriver driver;
	@Given("I should be login page of OrangeHRM")
	public void i_should_be_login_page_of_orange_hrm() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	     driver.get(url);
	     driver.manage().window().maximize();
	     Thread.sleep(5000);
	}

	@And("Enter Username")
	public void enter_username() {
		driver.findElement(By.name("username")).sendKeys("Admin");
	   
	}

	@And("Enter Passwod")
	public void enter_passwod() {
		driver.findElement(By.name("password")).sendKeys("admin123");
	    
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

	@Then("I Should see the Title as {string}")
	public void i_should_see_the_title_as(String string) {
		String etitle = "OrangeHRM";
	    String title = driver.getTitle();
	    Assert.assertEquals(etitle, title);
	    driver.close();
	}
}
