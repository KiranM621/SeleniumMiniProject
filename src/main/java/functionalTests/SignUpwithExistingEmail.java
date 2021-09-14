package functionalTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.PropertyReader;

public class SignUpwithExistingEmail {
	WebDriver driver;
	AllWebElementsPom ObjPom ;
	
	 JavascriptExecutor js;
	String driverPath = null;
	String HomeURL,email,password,fullname,mob;
@BeforeMethod
	 public void beforeMethod() throws InterruptedException, IOException {
			
			  driverPath = PropertyReader.getProperty("ChromeDriverPath");
			  email=PropertyReader.getProperty("useremail");
			  HomeURL=PropertyReader.getProperty("HomeURL");
			   fullname=PropertyReader.getProperty("fullname");
			mob=PropertyReader.getProperty("mob");
			  System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				 js = (JavascriptExecutor) driver;
				 
		  }	
	
  @Test
  public void SignUpTest() throws InterruptedException {
	 
	  	driver.get(HomeURL);//getURL
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		ObjPom =new AllWebElementsPom(driver);
		
		//click on login/signup btn
		ObjPom.clickOnLoginSignup();
		
		//click on sign-up
		ObjPom.click_signup();
		Thread.sleep(5000);
		
		//enter name, mobile no, email
		ObjPom.enterfullname(fullname);
		ObjPom.entermob(mob);
		ObjPom.enterEmailId(email);
		 
		driver.findElement(By.xpath("//*[@id=\"signupform\"]/div/div/div[2]/div/div/div/form/div[4]/input")).sendKeys("asdsdd");
		  
		  
		String alertmsg=driver.findElement(By.xpath("//*[@id=\"user-availability-status\"]/span")).getText();
		assertEquals("Email already exists .",alertmsg);
		
		  
  }
  
  @AfterTest
  public void aftertest() {
	  driver.quit();
  }
}
