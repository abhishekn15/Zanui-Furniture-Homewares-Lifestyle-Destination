package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.BaseTest;

public class Zanui2Page {

	@FindBy(id = "header-search")
	private WebElement ZanuiSearch;

	@FindBy(css="div[class='dy-lb-close']")
	private WebElement closepopup;

	public Zanui2Page(WebDriver driver) {
		PageFactory.initElements(driver, this);


	}

	public WebElement getZanuiSearch() {
		return ZanuiSearch;
	}

	public WebElement getClosepopup() {
		return closepopup;
	}
	public void SearchWithoutElement()    {
		closepopup.click();
		ZanuiSearch.sendKeys(Keys.ENTER);
		String ExpectedTitle = "Search Results: table | Zanui";
		String ActualTitle = BaseTest.driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

}
