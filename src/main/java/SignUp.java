
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp {

	String base_url = "http://localhost/online%20car%20rental%20PHP%20upd/carrental/index.php";
	WebDriver driver;
	
	@BeforeTest
	
	public void BeforeTest() {

		System.setProperty("webdriver.chrome.driver","D:\\Java\\MiniProject\\resource\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();;

	}
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverWait wait = new WebDriverWait(driver,30);

		

		driver.get(base_url);
		

	}
	
	@Test(priority=1)
	
	public void signupTestValid() { 
		WebDriverWait wait = new WebDriverWait(driver,30);
		String expectedMsg = "Registration successfull. Now you can login";
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

		
		

		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a")).click();
		
		driver.findElement(By.linkText("Signup Here")).click();
		
		driver.findElement(By.xpath("(//input[@name='fullname'])")).sendKeys("AniaaCole");
		driver.findElement(By.xpath("(//input[@name='mobileno'])")).sendKeys("8992847651");
		driver.findElement(By.xpath("(//input[@name='emailid'])")).sendKeys("aniaa21@gmail.com");

		
		driver.findElement(By.xpath("//*[@id=\"signupform\"]/div/div/div[2]/div/div/div/form/div[4]/input")).sendKeys("aniaa@123");
		driver.findElement(By.xpath("(//input[@name='confirmpassword'])")).sendKeys("aniaa@123");

		
		
		

		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

		String actualMsg =driver.switchTo().alert().getText() ;
		
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(actualMsg, expectedMsg);
		
		System.out.println(actualMsg);
		
	}
	
	@Test(priority=2)
	
	public void signupTestInvalid() { 
		WebDriverWait wait = new WebDriverWait(driver,30);
		String expectedMessage = "Email already exists .";
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

		
		

		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a")).click();
		
		driver.findElement(By.linkText("Signup Here")).click();
		
		driver.findElement(By.xpath("(//input[@name='fullname'])")).sendKeys("AniaCole");
		driver.findElement(By.xpath("(//input[@name='mobileno'])")).sendKeys("8912847651");
		driver.findElement(By.xpath("(//input[@name='emailid'])")).sendKeys("ania21@gmail.com");

		
		driver.findElement(By.xpath("//*[@id=\"signupform\"]/div/div/div[2]/div/div/div/form/div[4]/input")).sendKeys("ani@123");
		driver.findElement(By.xpath("(//input[@name='confirmpassword'])")).sendKeys("ania@123");

		
		
		String actualMessage = driver.findElement(By.xpath("//*[@id=\"user-availability-status\"]/span")).getText();
		

		//driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

		
		
		Assert.assertEquals(actualMessage,expectedMessage);
		
		System.out.println(actualMessage);
		
	}
	
	
	@AfterTest
	
	public void AfterTest() { 
		
		WebDriverWait wait = new WebDriverWait(driver,30);

		driver.quit();
		
	}
}
