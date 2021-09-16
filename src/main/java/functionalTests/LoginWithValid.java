package functionalTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.PropertyReader;

public class LoginWithValid {
	WebDriver driver;
	AllWebElementsPom ObjPom ;
	
	 JavascriptExecutor js;
	String driverPath = null;
	String HomeURL,email,password;
	
	@BeforeMethod
	 public void beforeMethod() throws InterruptedException, IOException {
			
			  driverPath = PropertyReader.getProperty("ChromeDriverPath");
			  email=PropertyReader.getProperty("useremail");
			  password=PropertyReader.getProperty("password");
			  HomeURL=PropertyReader.getProperty("HomeURL");
			  System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				 js = (JavascriptExecutor) driver;
				 
		  }

	@Test
	public void LoginWithValidDetails() throws InterruptedException {
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
		
	   	//validation of login
		Thread.sleep(5000);
		String msg= driver.findElement(By.xpath("//*[@id=\"banner\"]/div/div/div/div/div/h1")).getText();
		assertEquals("FIND THE RIGHT CAR FOR YOU.",msg);
		
		
	}
	
	@AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
	
	
}
