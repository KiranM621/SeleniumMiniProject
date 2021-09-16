package functionalTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllWebElementsPom {
	
	WebDriver driver;
	By loginSignupbtn=By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a");
	By Header = By.xpath("//*[@id=\"loginform\"]/div/div/div[1]/h3");
	By userName = By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[1]/input");
	By password = By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[2]/input");
	By login_btn = By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[4]/input");
	By car_list=By.xpath("//*[@id=\"navigation\"]/ul/li[3]/a");
	By search_car=By.xpath("/html/body/section[2]/div/div/aside/div[1]/div[2]/form/div[3]/button");
	By book_now=By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/div[4]/input");
	By view_details=By.xpath("/html/body/section[2]/div/div/div/div[2]/div[2]/a");
	By fromdate=By.name("fromdate");
	By todate=By.name("todate");
	By msg=By.name("message");
	By sign_up=By.xpath("//*[@id=\"loginform\"]/div/div/div[3]/p[1]/a");
	By fullname=By.name("fullname");
	By mob=By.name("mobileno");
	By email=By.id("emailid");
	By contact_us=By.xpath("//*[@id=\"navigation\"]/ul/li[5]/a");
	By contactus_fullname=By.id("fullname");
	By contactus_email=By.name("email");
	By contactus_mob=By.id("phonenumber");
	By contactus_msg=By.name("message");
	By profile=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/a");
	By my_booking=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/ul/li[3]/a");
	
	
	
	
	
	public AllWebElementsPom (WebDriver driver) {
		this.driver = driver;
		}
	
	
	public void clickOnLoginSignup() {
		driver.findElement(loginSignupbtn).click();
	}
	
	
	public void enterUserName(String arg1) {
	driver.findElement(userName).sendKeys(arg1);
	}
	
	public void enterPasswrod(String arg1) {
	driver.findElement(password).sendKeys(arg1);
	}
	
	public void login() {
		driver.findElement(login_btn).click();
		
	}
	
	public void click_CarListingbtn() {
		driver.findElement(car_list).click();
		
	}
	public void click_SearchCar() {
		driver.findElement(search_car).click();
		
	}
	public void click_BookNow() {
		driver.findElement(book_now).click();
		
	}
	public void click_ViewDetails() {
		driver.findElement(view_details).click();
		
	}
	public void enterfromdate(String arg1) {
		driver.findElement(fromdate).sendKeys(arg1);
		}
	public void entertodate(String arg1) {
		driver.findElement(todate).sendKeys(arg1);
		}
	public void entermessage(String arg1) {
		driver.findElement(msg).sendKeys(arg1);
		}
		
	public void click_signup() {
		driver.findElement(sign_up).click();
		
	}
	public void enterfullname(String arg1) {
		driver.findElement(fullname).sendKeys(arg1);
		}
	public void entermob(String arg1) {
		driver.findElement(mob).sendKeys(arg1);
		}
	public void enterEmailId(String arg1) {
		driver.findElement(email).sendKeys(arg1);
		}


	public void click_contactus() {
		// TODO Auto-generated method stub
		driver.findElement(contact_us).click();

	}


	public void click_contactus_message() {
		driver.findElement(contact_us).click();

	}
	public void contactus_enterfullname(String arg1) {
		driver.findElement(contactus_fullname).sendKeys(arg1);
	}
	
	public void contactus_enterphone(String arg1) {
		driver.findElement(contactus_email).sendKeys(arg1);
		
	}
	
	public void contactus_enteremail(String arg1) {
		driver.findElement(contactus_mob).sendKeys(arg1);
	}
	
	public void contactus_message(String arg1) {
		driver.findElement(contactus_msg).sendKeys(arg1);
	}
	
	public void clickOnprofile() {
		driver.findElement(profile).click();
	}
	
	
	public void clickOnMyBooking() {
		driver.findElement(my_booking).click();
	}
	

}
