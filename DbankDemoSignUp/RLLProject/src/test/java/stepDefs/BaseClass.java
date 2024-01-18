package stepDefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {
	
	
	public static WebDriver driver;
	
	//@Before
	public static void setUp() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://dbankdemo.com/bank/login");
		
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	//@After
	public static void tearDown() {
		driver.close();
	}
}
