package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class BaseTest {
	public ExtentReports reports;
	public ExtentTest test;
	public static WebDriver driver;

	@BeforeMethod(groups = { "Smoke", "Functional", "Integration", "System" })

	@Parameters({ "browser", "baseurl" })
	public void preCondition(String browserName, String url) {
		driver = BrowserFactory.launchBrowser(browserName);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		Reporter.log(url + " url navigated", true);

		reports = new ExtentReports("./extReport/extentreports.html", true);
		reports.addSystemInfo("HostName:", "Krati");

		reports.addSystemInfo("User Name:", "KratiVerma");

		reports.addSystemInfo("Environment:", "QA");

		test = reports.startTest("regression test cases");
	}

	@AfterMethod
	public void postCondition() throws Exception {

		driver.close();
		Reporter.log("Browser  closed", true);

		reports.endTest(test);

		reports.flush();

		driver.quit();
	}

}
