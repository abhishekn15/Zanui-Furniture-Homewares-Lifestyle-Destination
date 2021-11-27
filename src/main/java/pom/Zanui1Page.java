package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.BaseTest;

public class Zanui1Page {

	@FindBy(id = "header-search")
	private WebElement ZanuiSearch;

	@FindBy(xpath = "//div[@class='dy-lb-close']")
	private WebElement closepopup;

	@FindBy(xpath = "//h4[contains(text(),' matches for “Table”')]")
	private WebElement tableverify;

	public Zanui1Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getZanuiSearch() {
		return ZanuiSearch;
	}

	public WebElement getClosepopup() {
		return closepopup;
	}

	public WebElement getTableverify() {
		return tableverify;
	}

	public void tableSrch(String srchtbl) {
		closepopup.click();
		ZanuiSearch.sendKeys(srchtbl);
		ZanuiSearch.sendKeys(Keys.ENTER);
		String ExpectedTitle = "Search Results: table | Zanui";
		String ActualTitle = BaseTest.driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	

	}

	

}
