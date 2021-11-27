package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.ExcelUtility;
import pom.Zanui1Page;

public class ZanuiTest5Script extends BaseTest {
	@Test
	public void script5() {
		String filepath = "./testdata/testdata.xlsx";
		ExcelUtility exl = new ExcelUtility(filepath);
		String srchtbl = exl.readData("Sheet4", 0, 0);
		System.out.println(srchtbl);
		
		Zanui1Page zp = new Zanui1Page(driver);
		zp.tableSrch(srchtbl);
		Reporter.log("Homepage is verified", true);
	}

}
