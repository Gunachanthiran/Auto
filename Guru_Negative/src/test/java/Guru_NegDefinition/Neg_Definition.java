package Guru_NegDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Neg_Definition {
	public static String url="https://demo.guru99.com/test/newtours/login.php";
	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
    ExtentReports extent;
    ExtentTest test;
	@Given("I should be login page of Guru99 demo site")
	public void i_should_be_login_page_of_guru99_demo_site() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(5000);
	    
	}

	@And("Enter The Username {string}")
	public void enter_the_username(String string) {
		htmlreporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlreporter);
        test = extent.createTest("Guru Report");
		driver.findElement(By.xpath("//*[@name='userName']")).sendKeys(string);
		test.pass("username entered");
	}

	@And("Enter  The Password {string}")
	public void enter_the_password(String string) {
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(string);
		test.pass("password entered");
	}

	@When("Click on The Submit button")
	public void click_on_the_submit_button() {
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

	@Then("I Should see the Title as {string}")
	public void i_should_see_the_title_as(String string) {
		String guru_title = driver.getTitle();
		String value = string;
		SoftAssert guruneg = new SoftAssert();
		guruneg.assertEquals(value, guru_title);
		guruneg.assertAll();
	    
	}

	@And("Click on Register button")
	public void click_on_register_button() {
		driver.findElement(By.linkText("REGISTER")).click();
	}

	@When("I Should see the Page Title as {string}")
	public void i_should_see_the_page_title_as(String string) {
		String gurureg_title = driver.getTitle();
		String reg_value = string;
		SoftAssert guruneg = new SoftAssert();
		guruneg.assertEquals(reg_value, gurureg_title);
		guruneg.assertAll();
	}

	@And("Enter First Name {string}")
	public void enter_first_name(String string) {
		driver.findElement(By.name("firstName")).sendKeys(string);
	}

	@And("Enter Last Name {string}")
	public void enter_last_name(String string) {
		driver.findElement(By.name("lastName")).sendKeys(string);
	}

	@And("Enter Phone {string}")
	public void enter_phone(String string) {
		driver.findElement(By.name("phone")).sendKeys(string);
	}

	@And("Enter Gmail {string}")
	public void enter_gmail(String string) {
		driver.findElement(By.name("userName")).sendKeys(string);
	}

	@And("Enter Address {string}")
	public void enter_address(String string) {
		driver.findElement(By.name("address1")).sendKeys(string);
	}

	@And("Enter City  {string}")
	public void enter_city(String string) {
		driver.findElement(By.name("city")).sendKeys(string);
	}

	@And("Enter State\\/Provience {string}")
	public void enter_state_provience(String string) {
		driver.findElement(By.name("state")).sendKeys(string);
	}

	@And("Enter Postal Code {string}")
	public void enter_postal_code(String string) {
		driver.findElement(By.name("postalCode")).sendKeys(string);
	}

	@And("Select Country  {string}")
	public void select_country(String string) {
		WebElement country = driver.findElement(By.name("country"));
		Select option = new Select(country);
		option.selectByIndex(107);
	}

	@And("Enter Username {string}")
	public void enter_username(String string) {
		driver.findElement(By.name("email")).sendKeys(string);
	}

	@And("Enter Password {string}")
	public void enter_password(String string) {
		driver.findElement(By.name("password")).sendKeys(string);
	}

	@And("Enter Confirm Password {string}")
	public void enter_confirm_password(String string) {
		driver.findElement(By.name("confirmPassword")).sendKeys(string);
	}

	@When("Click on Submit button")
	public void click_on_submit_button() {
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

	@Then("I Should see Title as {string}")
	public void i_should_see_title_as(String string) {
		String gururegister_title = driver.getTitle();
		String register_value = string;
		SoftAssert guruneg = new SoftAssert();
		guruneg.assertEquals(register_value, gururegister_title);
		guruneg.assertAll();
		extent.flush();
		driver.close();
	}
}
