package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;

public class CheckoutCompletePage extends BaseClass {

	// 1. create OR by using @FindBy annotations
	@FindBy(xpath = "//h2[@class='complete-header']")
	private WebElement completeText;
	
	
	@FindBy(xpath ="//button[text()='Open Menu']")
	private WebElement openmenu;
	
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;
	

	// 2, initialize the OR by using PageFactory.initElements() method in
	// constructor
	public CheckoutCompletePage() {
		PageFactory.initElements(driver, this);
	}

	// 3. create associated method for each and every object repository without
	// entering test data.

	public String captureCompleteOrderText() {
		return completeText.getText();
	}
	
	public void clickOnMenu()
	{
		openmenu.click();
		
	}
	
	public void clickOnLogout()
	{
		logout.click();
		
	}
}
