package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class BrowserFactory {
	
	public static WebDriver launchBrowser(String browserName) {
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

			driver = new ChromeDriver();
			Reporter.log("chrome browser launched", true);
		}
		return driver;

	}

}
