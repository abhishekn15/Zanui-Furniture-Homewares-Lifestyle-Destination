package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.ExcelUtility;
import pom.Zanui4Page;

public class ZanuiTest4Script extends BaseTest {
	@Test(enabled=true)
	public void script4() throws InterruptedException {
	String filepath="./testdata/testdata.xlsx";
	ExcelUtility ex = new ExcelUtility(filepath);
	         String data4 = ex.readData("Sheet3",0 , 0);
	
	          Zanui4Page zp = new Zanui4Page(driver);
	          zp.SearchFoodItem(data4);
	

}
}