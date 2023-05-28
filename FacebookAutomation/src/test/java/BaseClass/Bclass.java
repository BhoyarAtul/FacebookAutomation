package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Bclass {
	
	public static WebDriver openChrome() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\BrowserFiles\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		return driver;
	}
	
	
//	public static WebDriver openEdge() {
//		System.setProperty("webdriver.edge.driver", "src\\test\\resources\\BrowserFiles\\msedgedriver.exe");
//		WebDriver driver =new EdgeDriver();
//		return driver;
//	}

}
