package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.Wait;



public class YourInformationCheckoutPage extends BaseClass {

	// 1. create object repository with the help of @FindBy annotation

	@FindBy(name = "firstName")
	private WebElement fname;

	@FindBy(name = "lastName")
	private WebElement lname;

	@FindBy(name = "postalCode")
	private WebElement postalCode;

	@FindBy(name = "continue")
	private WebElement Continue;

	// 2. initialize the Object Repository by using PageFactory.initElements()
	// method in construtor
	public YourInformationCheckoutPage() {
		PageFactory.initElements(driver,this);
	}

	// 3. create associated method for each and every object repository without
	// entering the test data.

	public String getYourInformationPageUrl() {
		return driver.getCurrentUrl();
	}

	public void generateRandomString() {
		fname.sendKeys(Wait.randomString());
		lname.sendKeys(Wait.randomString());

	}

	public void generateRandomInt() {
		postalCode.sendKeys(Wait.randomInt());

	}

	public void click() {
		Continue.click();
	}

}
