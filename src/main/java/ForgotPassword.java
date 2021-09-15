import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ForgotPassword {
	
	String base_url = "http://localhost/online%20car%20rental%20PHP%20upd/carrental/index.php";
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() { 
		System.setProperty("webdriver.chrome.driver","D:\\Java\\MiniProject\\resource\\chromedriver.exe");

		driver = new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void beforeMethod() { 
		
		driver.get(base_url);
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void changePasswordOne() { 
		
		String expectedMessage = "Your Password succesfully changed";
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a")).click();
		driver.findElement(By.linkText("Forgot Password ?")).click();
		
		driver.findElement(By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[1]/input")).sendKeys("ani21@gmail.com");
		driver.findElement(By.xpath("(//input[@name='mobile'])")).sendKeys("8928476560");
		driver.findElement(By.xpath("(//input[@name='newpassword'])")).sendKeys("ani@1234");
		driver.findElement(By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[4]/input")).sendKeys("ani@1234");

		driver.findElement(By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[5]/input")).click();
	
	
		String actualMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(actualMessage, expectedMessage);
	
	}
	
	@Test(priority=2)
	public void changePasswordTwo() { 
		
		String expectedMessage = "New Password and Confirm Password Field do not match  !!";
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a")).click();
		driver.findElement(By.linkText("Forgot Password ?")).click();
		
		driver.findElement(By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[1]/input")).sendKeys("ani21@gmail.com");
		driver.findElement(By.xpath("(//input[@name='mobile'])")).sendKeys("8928476560");
		driver.findElement(By.xpath("(//input[@name='newpassword'])")).sendKeys("ani@1234");
		driver.findElement(By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[4]/input")).sendKeys("ani@12345");

		driver.findElement(By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[5]/input")).click();
	
	
		String actualMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(actualMessage, expectedMessage);
	
	}
	@AfterTest
	public void afterTest() { 
		
		driver.quit();
		
	}
	
	
}
