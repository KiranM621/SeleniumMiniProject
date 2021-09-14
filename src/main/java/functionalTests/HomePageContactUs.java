package functionalTests;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.PropertyReader;

public class HomePageContactUs {
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
  public void f() throws InterruptedException {
		
	  	driver.get(HomeURL);//getURL
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		ObjPom =new AllWebElementsPom(driver);
		
		//click on contact-us
		ObjPom.click_contactus();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(5000);
  
		ObjPom.contactus_enterfullname("ABC");
		ObjPom.contactus_enteremail("abc@gmail.com");
		ObjPom.contactus_enterphone("823482398");
		ObjPom.contactus_message("Hello Iam");
		Thread.sleep(5000);
        
		
		//driver.findElement(By.name("send")).click();
      //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       Thread.sleep(5000);
       
       
       
     // String msg=  driver.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div[1]")).getText();
	//  assertEquals("SUCCESS:Query Sent. We will contact you shortly",msg);
	  
  }
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  
}
