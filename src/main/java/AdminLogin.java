import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminLogin {

	
	String base_url = "http://localhost/online%20car%20rental%20PHP%20upd/carrental/index.php";
	WebDriver driver;
	
	@BeforeTest
	
	public void BeforeTest() {

		System.setProperty("webdriver.chrome.driver","D:\\Java\\MiniProject\\resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;




	}

	
	
	

	@Test(priority = 1)
	
	public void validLogin() { 
		
		String expectedTitle = "Car Rental Portal | Admin Change Password";
		//	driver = new ChromeDriver();
		
		//System.setProperty("webdriver.chrome.driver","F:\\Selenium\\Practice\\resource\\chromedriver.exe");
		
		//String base_url = "http://localhost/online%20car%20rental%20PHP%20upd/carrental/index.php";
			
		//WebDriver driver = new ChromeDriver();
		driver.get(base_url);
		
		driver.findElement(By.linkText("Admin Login")).click();
		
		driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys("admin");
		

		
		WebElement web = driver.findElement(By.xpath("(//input[@name = 'password'])"));

        
		web.sendKeys("Test@12345");
		

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		web.sendKeys(Keys.ENTER);
		
		//driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;

		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		

		
	}
	
	@Test(priority = 2)

	public void adminLogout() throws InterruptedException { 
		
		String expectedTitle = "Car Rental Portal | Admin Login";
		driver.findElement(By.linkText("Account")).click();

		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Logout")).click();
		
		Thread.sleep(100);

		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}
	
	@Test(priority = 3)
	
	public void invalidLogin() { 
		driver.get(base_url);
		String expmsg = "Invalid Details";
		
		driver.get(base_url);
		
		driver.findElement(By.linkText("Admin Login")).click();
		
		driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys("admin");
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		
		WebElement web = driver.findElement(By.xpath("(//input[@name = 'password'])"));

        
		web.sendKeys("Test@1234");
		

		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		web.sendKeys(Keys.ENTER);
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		
		
		
		String msg = driver.switchTo().alert().getText();
		
		Assert.assertEquals(msg, expmsg);

	}
	
	
	@AfterTest
	
	public void AfterTest() { 
		
		driver.quit();
		
	}
	
}
