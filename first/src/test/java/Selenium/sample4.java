package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class sample4 {
	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://Users//gunac//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe/");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Number of links: " + allLinks.size());
        for (WebElement link : allLinks) {
            String href = link.getAttribute("href");
            String text = link.getText();
            int linkSize = link.getSize().getHeight();

            System.out.println("Link Href: " + href);
            System.out.println("Link Text: " + text);
            System.out.println("Link Size: " + linkSize);
        }
        driver.quit();
    }

}
