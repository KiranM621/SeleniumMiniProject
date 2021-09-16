import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminPassword {

	String base_url = "http://localhost/online%20car%20rental%20PHP%20upd/carrental/index.php";
	WebDriver driver;
	
	@BeforeTest
	
	public void BeforeTest() {

		System.setProperty("webdriver.chrome.driver","D:\\Java\\MiniProject\\resource\\chromedriver.exe");
		driver = new ChromeDriver();



	}

	@BeforeMethod
	
	public void beforeMethod() {
		WebDriverWait wait = new WebDriverWait(driver,20);

		

		driver.get(base_url);
		

	}
	
    @Test(priority = 1)
	
	public void changePasswordOne() { 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		//String expectedTitle = "Car Rental Portal | Admin Change Password";
		WebDriverWait wait = new WebDriverWait(driver,20);

    	String successMsg = "SUCCESS:Your Password succesfully changed";
		
		driver.findElement(By.linkText("Admin Login")).click();
		
		driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys("admin");
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		
		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys("Test@12345");
		driver.findElement(By.tagName("button")).click();

		
		
		
		
		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys("Test@12345");
		
		driver.findElement(By.xpath("(//input[@name = 'newpassword'])")).sendKeys("Test@12345");

		driver.findElement(By.xpath("(//input[@name = 'confirmpassword'])")).sendKeys("Test@12345",Keys.ENTER);
		
		
		
		
		String msg =  driver.findElement(By.xpath("(//div[@class = 'succWrap'])")).getText();

		Assert.assertEquals(successMsg, msg);

	}
    
    @Test(priority = 2)
	
	public void changePasswordTwo() { 
		
	
    	String alertExpectedMsg = "New Password and Confirm Password Field do not match  !!";
		
		driver.findElement(By.linkText("Admin Login")).click();
		
		driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys("admin");
		

		
		WebElement web = driver.findElement(By.xpath("(//input[@name = 'password'])"));

        
		web.sendKeys("Test@12345");
		

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		web.sendKeys(Keys.ENTER);
		
		
		
		
		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys("Test@12345");
		
		driver.findElement(By.xpath("(//input[@name = 'newpassword'])")).sendKeys("Test@1234");

		driver.findElement(By.xpath("(//input[@name = 'confirmpassword'])")).sendKeys("Test@12345");
		
	
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		driver.findElement(By.tagName("button")).click();

		
	    String alertActualMsg =  driver.switchTo().alert().getText();		
	    driver.switchTo().alert().accept();

	
		Assert.assertEquals(alertExpectedMsg,alertActualMsg);

	}
    
    
    @Test(priority = 3)
	
   	public void changePasswordThree() { 
   		
   	
       	String errorExpectedMsg = "ERROR:Your current password is not valid.";
   		
   		driver.findElement(By.linkText("Admin Login")).click();
   		
   		driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys("admin");
   		

   		
   		WebElement web = driver.findElement(By.xpath("(//input[@name = 'password'])"));

           
   		web.sendKeys("Test@12345");
   		


   		web.sendKeys(Keys.ENTER);
   		

   		
   		
   		
   		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys("Test@1234");
   		
   		driver.findElement(By.xpath("(//input[@name = 'newpassword'])")).sendKeys("Test@1234");

   		driver.findElement(By.xpath("(//input[@name = 'confirmpassword'])")).sendKeys("Test@1234");
		WebDriverWait wait = new WebDriverWait(driver,20);

		driver.findElement(By.tagName("button")).click();

   		
   	    String errorActualMsg =  driver.findElement(By.xpath("(//div[@class = 'errorWrap'])")).getText();;		

   	
   		Assert.assertEquals(errorExpectedMsg,errorActualMsg);

   	}
       
	
	@AfterTest
	
	public void AfterTest() { 
		
		WebDriverWait wait = new WebDriverWait(driver,20);

		driver.quit();
		
	}
	
	
}
