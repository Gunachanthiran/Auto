package Selenium;

import org.testng.annotations.Test;

public class groups {
	@Test(priority = 0, groups = {"smoke"})
	public void tc1() {
		System.out.println("hello");
	}
	@Test(priority = 1, groups = {"regression"})
	public void tc2() {
		System.out.println("hi");
	}
	@Test(priority = 0, groups = {"smoke"})
	public void tc3() {
		System.out.println("gm");
	}
	@Test(priority = 1, groups = {"regression"})
	public void tc4() {
		System.out.println("bye");
	}

}
