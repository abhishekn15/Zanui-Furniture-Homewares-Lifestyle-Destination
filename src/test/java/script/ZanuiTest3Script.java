package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.ExcelUtility;
import pom.Zanui3Page;

public class ZanuiTest3Script extends BaseTest {
	@Test(enabled=true)
	public void script3() {
		String filepath="./testdata/testdata.xlsx";
		ExcelUtility ex = new ExcelUtility(filepath);
		String data = ex.readData("Sheet2",0,0);
		
		Zanui3Page zp=new Zanui3Page(driver);
		zp.SearchWithInvalidElement(data);
		Reporter.log("Search with the invalid element",true);
		
	}

}
