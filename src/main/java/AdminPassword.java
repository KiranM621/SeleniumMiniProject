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
		
		//String expectedTitle = "Car Rental Portal | Admin Change Password";
	
    	String successMsg = "SUCCESS:Your Password succesfully changed";
		
		driver.findElement(By.linkText("Admin Login")).click();
		
		driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys("admin");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		
		WebElement web = driver.findElement(By.xpath("(//input[@name = 'password'])"));

        
		web.sendKeys("Test@12345");
		

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		web.sendKeys(Keys.ENTER);
		
		//driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		
		
		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys("Test@12345");
		
		driver.findElement(By.xpath("(//input[@name = 'newpassword'])")).sendKeys("Test@12345");

		driver.findElement(By.xpath("(//input[@name = 'confirmpassword'])")).sendKeys("Test@12345",Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

	    //driver.findElement(By.xpath("(//input[@class = 'page-title'])")).sendKeys(Keys.ENTER);;

		//webele.sendKeys(Keys.ENTER);
		//String actualTitle = driver.getTitle();
		
		
		String msg =  driver.findElement(By.xpath("(//div[@class = 'succWrap'])")).getText();
		WebDriverWait wait = new WebDriverWait(driver,20);

		Assert.assertEquals(successMsg, msg);

		//System.out.println(msg);
	}
    
    @Test(priority = 2)
	
	public void changePasswordTwo() { 
		
		//String expectedTitle = "Car Rental Portal | Admin Change Password";
	
    	String alertExpectedMsg = "New Password and Confirm Password Field do not match  !!";
		
		driver.findElement(By.linkText("Admin Login")).click();
		
		driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys("admin");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		
		WebElement web = driver.findElement(By.xpath("(//input[@name = 'password'])"));

        
		web.sendKeys("Test@12345");
		

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		web.sendKeys(Keys.ENTER);
		
		//driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		
		
		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys("Test@12345");
		
		driver.findElement(By.xpath("(//input[@name = 'newpassword'])")).sendKeys("Test@1234");

		driver.findElement(By.xpath("(//input[@name = 'confirmpassword'])")).sendKeys("Test@12345",Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

	    //driver.findElement(By.xpath("(//input[@class = 'page-title'])")).sendKeys(Keys.ENTER);;

		//webele.sendKeys(Keys.ENTER);
		//String actualTitle = driver.getTitle();
		
		
	    String alertActualMsg =  driver.switchTo().alert().getText();		
	    driver.switchTo().alert().accept();
		WebDriverWait wait = new WebDriverWait(driver,20);

	
		Assert.assertEquals(alertExpectedMsg,alertActualMsg);

		//System.out.println(msg);
	}
    
    
    @Test(priority = 3)
	
   	public void changePasswordThree() { 
   		
   		//String expectedTitle = "Car Rental Portal | Admin Change Password";
   	
       	String errorExpectedMsg = "ERROR:Your current password is not valid.";
   		
   		driver.findElement(By.linkText("Admin Login")).click();
   		
   		driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys("admin");
   		
   		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

   		
   		WebElement web = driver.findElement(By.xpath("(//input[@name = 'password'])"));

           
   		web.sendKeys("Test@12345");
   		

   		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

   		web.sendKeys(Keys.ENTER);
   		
   		//driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;

   		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
   		
   		
   		
   		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys("Test@1234");
   		
   		driver.findElement(By.xpath("(//input[@name = 'newpassword'])")).sendKeys("Test@1234");

   		driver.findElement(By.xpath("(//input[@name = 'confirmpassword'])")).sendKeys("Test@1234",Keys.ENTER);
   		
   		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

   	    //driver.findElement(By.xpath("(//input[@class = 'page-title'])")).sendKeys(Keys.ENTER);;

   		//webele.sendKeys(Keys.ENTER);
   		//String actualTitle = driver.getTitle();
   		
   	    String errorActualMsg =  driver.findElement(By.xpath("(//div[@class = 'errorWrap'])")).getText();;		
		WebDriverWait wait = new WebDriverWait(driver,20);

   	
   		Assert.assertEquals(errorExpectedMsg,errorActualMsg);

   		//System.out.println(msg);
   	}
       
	
	@AfterTest
	
	public void AfterTest() { 
		
		WebDriverWait wait = new WebDriverWait(driver,20);

		driver.quit();
		
	}
	
}
