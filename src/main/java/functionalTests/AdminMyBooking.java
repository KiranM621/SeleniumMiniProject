package functionalTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

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

public class AdminMyBooking {
	WebDriver driver;
	 JavascriptExecutor js;
	String driverPath;
	String AdminURL,HomeURL,Admin_username,email,password;
	
	@BeforeMethod
	 public void beforeMethod() throws InterruptedException, IOException {
			
			  driverPath = PropertyReader.getProperty("ChromeDriverPath");
			  AdminURL=PropertyReader.getProperty("AdminURL");
			  HomeURL=PropertyReader.getProperty("HomeURL");
			  email=PropertyReader.getProperty("useremail");
			  Admin_username=PropertyReader.getProperty("Admin_username");
			  password=PropertyReader.getProperty("password");
			 
			  System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				 js = (JavascriptExecutor) driver;
				 
		  }
		
  @Test
  public void f() throws InterruptedException {
	  driver.get(AdminURL);//load url
	  Thread.sleep(4000);
	  //enter username ,password 
	  driver.findElement(By.name("username")).sendKeys(Admin_username);
		driver.findElement(By.name("password")).sendKeys(password);
		//click on login 
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/form/button")).click();
		Thread.sleep(4000);
		
		//click on manage booking
		driver.findElement(By.xpath("/html/body/div[2]/nav/ul/li[5]/a")).click();
		//click on confirmed button
		driver.findElement(By.xpath("//*[@id=\"zctb\"]/tbody/tr[9]/td[9]/a[1]")).click();
		 Alert alert=driver.switchTo().alert();
		
				Thread.sleep(5000);
				alert.accept();
		
	//check whether status On home page of my booking it updated or not	
		
		//navigate to home page of carrental
		driver.navigate().to(HomeURL);
		Thread.sleep(4000);
		//login 
		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[1]/input")).sendKeys(email);
		 driver.findElement(By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[2]/input")).sendKeys(password);
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[4]/input")).click();
		
		 // click mybooking under profile 
		 driver.findElement(By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/a")).click();
		driver.findElement(By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/ul/li[3]/a")).click();
		
		//validate confirmed is updated or not
		String btnText= driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[2]/div/div/ul/li[7]/div[3]/a")).getText();
		assertEquals("Confirmed",btnText);
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
 
  
  
}
