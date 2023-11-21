package Selenium;

import org.testng.annotations.Test;

public class method {
	@Test(alwaysRun = true)
	public void tc() {
		System.out.println("always run");
	}
	@Test(dependsOnMethods = "tc" )
	public void tc2() {
		System.out.println("depends on methods");
	}
}
