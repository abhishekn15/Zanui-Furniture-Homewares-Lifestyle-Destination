package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.BaseTest;

public class Zanui3Page {
	@FindBy(id = "header-search")
	private WebElement ZanuiSearch;

	@FindBy(css="div[class='dy-lb-close']")
	private WebElement closepopup;

	public  Zanui3Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getZanuiSearch() {
		return ZanuiSearch;
	}

	public WebElement getClosepopup() {
		return closepopup;
	}
	public void SearchWithInvalidElement(String table2)    {
		closepopup.click();
		ZanuiSearch.sendKeys(table2);
		ZanuiSearch.sendKeys(Keys.ENTER);
		String ExpectedTitle = "Search Results: medicnes | Zanui";
		String ActualTitle = BaseTest.driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);

}}
