package functionalTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.PropertyReader;

public class LoginWithInvalidData {
	WebDriver driver;
	AllWebElementsPom ObjPom ;
	
	 JavascriptExecutor js;
	String driverPath = null;
	String HomeURL,email,password;
	
	@BeforeMethod
	 public void beforeMethod() throws InterruptedException, IOException {
			
			  driverPath = PropertyReader.getProperty("ChromeDriverPath");
			  email=PropertyReader.getProperty("useremail");
			  password=PropertyReader.getProperty("wrong_password");
			  HomeURL=PropertyReader.getProperty("HomeURL");
			  System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				 js = (JavascriptExecutor) driver;
				 
		  }
	
	@Test
	public void LoginWithInValidDetails() throws InterruptedException {
		driver.get(HomeURL);//getURL
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		ObjPom =new AllWebElementsPom(driver);
		
		//click on login/signup btn
		ObjPom.clickOnLoginSignup();
		
		//enter email
		ObjPom.enterUserName(email);
		
		//enter password
		ObjPom.enterPasswrod(password);
	   Thread.sleep(5000);
	   
	   // click on login button
	   	ObjPom.login();
		
		
		Alert alert=driver.switchTo().alert();
		String alertMessage=driver.switchTo().alert().getText();
		assertEquals("Invalid Details",alertMessage);
		Thread.sleep(5000);
		alert.accept();
	
	}
	
	@AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
	 
	
}