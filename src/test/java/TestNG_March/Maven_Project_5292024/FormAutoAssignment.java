package TestNG_March.Maven_Project_5292024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FormAutoAssignment {

	@Test
	public void formAutomation() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/register/");
		
		

		WebElement edition = driver.findElement(By.cssSelector("select#payment_plan_id"));

		WebElement editionSelect = driver.findElement(By.xpath("//option[text()='Free Edition']"));

		WebElement firstName = driver.findElement(By.xpath("//input[@type='text' and @name='first_name']"));

		WebElement lastName = driver.findElement(By.xpath("//input[@type='text' and @name='surname']"));

		WebElement email = driver.findElement(By.cssSelector("input[name='email']"));

		WebElement confirmEmail = driver.findElement(By.cssSelector("input[name='email_confirm']"));

		WebElement userName = driver.findElement(By.cssSelector("input[name='username']"));

		WebElement password = driver.findElement(By.xpath("//input[@type='password' and @name='password']"));

		WebElement confirmPassword = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));

		WebElement termsCheck = driver.findElement(By.cssSelector("input[data-bv-field='agreeTerms']"));

		WebElement submitBtn = driver.findElement(By.xpath("//button[text()='SUBMIT']"));
		
		

		edition.click();

		editionSelect.click();

		firstName.sendKeys("Emil");

		lastName.sendKeys("Sunny");

		email.sendKeys("emilsunn@gmail.com");

		confirmEmail.sendKeys("emilsunn@gmail.com");

		userName.sendKeys("code007");

		password.sendKeys("Guest@12");

		confirmPassword.sendKeys("Guest@12");

		termsCheck.click();

		submitBtn.click();

	}

}
