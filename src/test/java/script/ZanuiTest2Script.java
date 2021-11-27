package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pom.Zanui2Page;


 public class ZanuiTest2Script extends BaseTest{
	 @Test(enabled=true)
	 public void Script2() {
		 Zanui2Page zp=new Zanui2Page(driver);
		 zp.SearchWithoutElement();
		 Reporter.log("The page is verifed",true);
	 }

}
