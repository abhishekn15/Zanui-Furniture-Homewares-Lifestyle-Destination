package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

/**
 * This class is Used to monitor the Runtime events and also Screenshot is configure in the fail count.
 * 
 * @author dell
 *
 *
 */
public class SearchListener implements ITestListener {

	public static int executionCount, passCount, failCount, skipCount = 0;

	@Override
	public void onTestStart(ITestResult result) {
		executionCount++;
		Reporter.log(result.getName() + " script is executing:" + new Date(), true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		passCount++;
		Reporter.log(result.getName() + " script is passed:", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		failCount++;
		Reporter.log(result.getName() + " script is failed:", true);
		TakesScreenshot ts = (TakesScreenshot) BaseTest.driver;

		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./screenshots" + result.getName() + ".png"); 
		try 
		{
			Files.copy(srcfile, destfile);
		}

		catch (IOException e) {

		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		skipCount++;
		Reporter.log(result.getName() + " script is skipped:", true);
	}

	@Override
	public void onStart(ITestContext context) {

		Reporter.log("Suite Execution starts" + new Date(), true);
	}

	@Override
	public void onFinish(ITestContext context) {

		Reporter.log("Suite Execution finished:" + new Date(), true);
		Reporter.log("Total script executed:" + (executionCount - skipCount), true);

		Reporter.log("Total scripts passed:", +passCount, true);

		Reporter.log("Total scripts failed:" + failCount, true);
		Reporter.log("Total scripts skipped:" + skipCount, true);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
}
