package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.ExcelUtility;
import net.bytebuddy.asm.Advice.Enter;
import pom.Zanui1Page;

class ZanuiTest1Script extends BaseTest {
	@Test(enabled = true)

	public void script1() {

		String filepath = "./testdata/testdata.xlsx";
		ExcelUtility exl = new ExcelUtility(filepath);
		String srchtbl = exl.readData("Sheet1", 0, 0);

		Zanui1Page zp = new Zanui1Page(driver);
		zp.tableSrch(srchtbl);
		Reporter.log("Homepage is verified", true);
	}
}