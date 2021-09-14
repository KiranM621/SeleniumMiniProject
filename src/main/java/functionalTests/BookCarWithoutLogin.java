package functionalTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.PropertyReader;

public class BookCarWithoutLogin {
	WebDriver driver;
	AllWebElementsPom ObjPom ;
	
	 JavascriptExecutor js;
	String driverPath = null;
	String HomeURL,email,password, bookmsg,fromdate,todate;

	@BeforeMethod
	 public void beforeMethod() throws InterruptedException, IOException {
			
			  driverPath = PropertyReader.getProperty("ChromeDriverPath");
			  email=PropertyReader.getProperty("useremail");
			  password=PropertyReader.getProperty("password");
			  HomeURL=PropertyReader.getProperty("HomeURL");
			  bookmsg=PropertyReader.getProperty("bookmsg");
			  fromdate=PropertyReader.getProperty("fromdate");
			  todate=PropertyReader.getProperty("todate");
			  System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				 js = (JavascriptExecutor) driver;
				 
		  }	
	
  @Test
  public void bookwithoutlogin() throws InterruptedException {
	  driver.get(HomeURL);//getURL
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		ObjPom =new AllWebElementsPom(driver);
		
	  //click on carlisting btn
	   	ObjPom.click_CarListingbtn();
		 Thread.sleep(5000);
		
		 js.executeScript("window.scrollBy(0,350)", "");//scroll down
		 
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
		 js.executeScript("window.scrollBy(0,350)", "");
		 Thread.sleep(5000);
		 
		 //click view details of car
		 ObjPom.click_ViewDetails();
		 js.executeScript("window.scrollBy(0,350)", "");
		 
	 
	 String textofbtn=driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/a")).getText();
	 assertEquals("LOGIN FOR BOOK",textofbtn);
	 driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/a")).click();
	 Thread.sleep(5000);	
	 driver.quit();

  }
  
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
}
