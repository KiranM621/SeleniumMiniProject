import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Java\\MiniProject\\resource\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost/online%20car%20rental%20PHP%20upd/carrental/index.php");
	
		driver.quit();
	}

}
