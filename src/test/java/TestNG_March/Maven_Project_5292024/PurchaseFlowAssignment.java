package TestNG_March.Maven_Project_5292024;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PurchaseFlowAssignment {

	WebDriver driver;
	Actions actions;

	@BeforeMethod
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		actions = new Actions(driver);

	}

	@Test
	public void loginTest() {

		driver.findElement(By.cssSelector("input[placeholder='E-Mail Address']")).sendKeys("stevrog@gmail.com");

		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Last@first");

		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		String loginUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginUrl, "https://naveenautomationlabs.com/opencart/index.php?route=account/account");

	}

	@Test
	public void addCartTest() {
		loginTest();
		WebElement desktop = driver.findElement(By.cssSelector("nav#menu li.dropdown:first-of-type>a"));
		actions.moveToElement(desktop).click().perform();

		WebElement selectProduct = driver.findElement(By.xpath("//a[text()='Mac (1)']"));
		actions.moveToElement(selectProduct).click().perform();

		WebElement addCart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
		actions.moveToElement(addCart).click().perform();
		
		String addCartText=driver.findElement(By.cssSelector("div.alert-dismissible")).getText();
		Assert.assertEquals(addCartText, "addCartTextDisplayed","Add cart text not visible");

	}

	@Test
	public void orderConfirmationTest() {

		addCartTest();

		driver.findElement(By.xpath("//span[text()='Checkout']")).click();
		
		String shoppingCartText=driver.findElement(By.cssSelector("div#content>h1")).getText();
		Assert.assertEquals(shoppingCartText, "added to shopping cart","shopping cart text not visible");
	}

	@AfterMethod
	public void tearDown() {

		driver.close();

	}

}
