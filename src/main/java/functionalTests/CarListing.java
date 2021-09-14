package functionalTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.PropertyReader;

public class CarListing {
	WebDriver driver;
	AllWebElementsPom ObjPom ;
	
	 JavascriptExecutor js;
	String driverPath = null,HomeURL;
	String brandname="BMW , Test Demoy";
	String fuelname="CNG";
	
@BeforeMethod
public void beforeMethod() throws InterruptedException, IOException {
	
			  driverPath = PropertyReader.getProperty("ChromeDriverPath");
			  HomeURL=PropertyReader.getProperty("HomeURL");
			 
			  System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				 js = (JavascriptExecutor) driver;
				 
 }
		 
	  
	
  @Test
  public void FetchCar() throws InterruptedException {
	
	  		driver.get(HomeURL);//getURL
			driver.manage().window().maximize();
			Thread.sleep(5000);
			
			ObjPom =new AllWebElementsPom(driver);
			
			//click on carlisting btn
			ObjPom.click_CarListingbtn();
			 Thread.sleep(5000);
			
			 js.executeScript("window.scrollBy(0,350)", "");//scroll down
			 Thread.sleep(5000);
			 
			 //select BMW from brand dropdown list
			 Select drpBrand= new Select(driver.findElement(By.name("brand")));
			 drpBrand.selectByVisibleText("BMW");
			 
			 //select fuel from fuel dropdown list
			 Select drpFuel = new Select(driver.findElement(By.name("fueltype")));
			 drpFuel.selectByIndex(3);
			 Thread.sleep(8000);
			 
			// click search car
			 ObjPom.click_SearchCar();
			 Thread.sleep(5000);

			 String getbrandname=driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[2]/div[2]/h5/a")).getText();
			 String getfuel=driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[2]/div[2]/ul/li[3]")).getText();
			 assertEquals(brandname,getbrandname);
			 assertEquals(fuelname,getfuel);
	 
	 
  }
  
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
