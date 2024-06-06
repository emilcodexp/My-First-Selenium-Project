package TestNG_March.Maven_Project_5292024;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class MyTestExample {
	@BeforeClass
	public void openApp() {
		System.out.println("Application opened");
	}

	@Ignore
	@Test(enabled = false)
	public void testApp() {
		System.out.println("Application testing started");
	}

	@Test(invocationCount = 5)
	public void testApp1() {
		System.out.println("Application testing started second time");
	}

	@AfterClass
	public void closeApp() {
		System.out.println("Application closed");
	}

	@Test(priority = 1)
	public void checkLoadingTime() {
		System.out.println("checking Opening time");
	}

	@Test(priority = 2)
	public void checkClosingTime() {
		System.out.println("checking Closing time");
	}
}
