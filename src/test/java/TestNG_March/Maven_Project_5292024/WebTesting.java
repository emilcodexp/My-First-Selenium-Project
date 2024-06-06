package TestNG_March.Maven_Project_5292024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTesting {

	@Test
	public void validateLogin() {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/register/");

		WebElement firstName = driver.findElement(By.xpath("//input[@type='text' and @name='first_name']"));

		WebElement lastName = driver.findElement(By.xpath("//input[@type='text' and @name='surname']"));

		firstName.sendKeys("Emil");

		lastName.sendKeys("Sunny");

//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		
//		WebElement emailid = driver.findElement(By.id("input-email"));
//		
//		WebElement pwd = driver.findElement(By.cssSelector("input#input-password"));
//		
//		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
//		
//		
//		
//		emailid.sendKeys("katepqa@gmail.com");
//		
//		pwd.sendKeys("Tester01");
//		
//		loginBtn.click();
//		
//		driver.close();

	}

}
