package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;

public class YourCartPage extends BaseClass {

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartBadge;

	@FindBy(id = "checkout")
	private WebElement checkout;

	// 2. initialize the Object repository by using PageFactory.initElements()
	// methods

	public YourCartPage() {
		PageFactory.initElements(driver, this);
	}

	// 3. create associated method for each and every Object Repository (OR) without
	// entering the test data.

	public void ClickonCartBadge() {

		cartBadge.click();
	}

	public void clickOnCheckout() {
		checkout.click();
	}

}
