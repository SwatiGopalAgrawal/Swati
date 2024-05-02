package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;

public class OverviewPage extends BaseClass {

	// 1. create OR by using @FindBy annotations
	@FindBy(name = "finish")
	private WebElement finishButton;

	// 2, initialize the OR by using PageFactory.initElements() method in
	// constructor
	public OverviewPage() {
		PageFactory.initElements(driver, this);
	}

	// 3. create associated method for each and every object repository without
	// entering test data.

	public void clickOnFinishButton() {
		finishButton.click();
	}
}
