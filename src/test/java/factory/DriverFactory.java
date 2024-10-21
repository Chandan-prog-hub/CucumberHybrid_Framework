package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory { 
	static WebDriver driver = null;
	
	public static void InitializeBrowser(String browserName) {
		
		
		
		
		if (browserName.equalsIgnoreCase("chrome")) {
			 driver= new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			 driver= new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("safari")) {
			 driver= new SafariDriver();
		}
		
		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
