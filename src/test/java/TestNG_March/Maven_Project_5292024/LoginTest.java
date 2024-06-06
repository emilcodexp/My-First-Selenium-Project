package TestNG_March.Maven_Project_5292024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;

	@BeforeMethod
	public void loadWebpage() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

	}

	@Test
	public void validateLogin() {

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("stevrog@gmail.com");

		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Last@first");

		driver.findElement(By.cssSelector("input[type='submit']")).click();

		String loginText = driver.findElement(By.cssSelector("#content>h2:first-of-type")).getText();

		Assert.assertEquals(loginText, "My Account");

	}

	@Test
	public void validateForgotPassword() {

		driver.findElement(By.cssSelector("input[type='password']+a")).click();

		driver.findElement(By.xpath("//input[@type='text' and @placeholder='E-Mail Address']"))
				.sendKeys("stevrog@gmail.com");

		driver.findElement(By.xpath("//input[@type='submit']")).submit();

		String forgotPassText = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
				.getText();

		Assert.assertEquals(forgotPassText, "An email with a confirmation link has been sent your email address.");

	}

	@AfterMethod
	public void closeBrowser() {

		driver.close();
	}

}
