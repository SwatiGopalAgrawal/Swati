package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;

public class LoginPage extends BaseClass {

	// Create Object Repository with the help of @FindBy annotation
	@FindBy(name = "user-name")
	private WebElement uname;

	@FindBy(name = "password")
	private WebElement pass;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	// 2. initialize the Object Repository by using PageFactory.initElements()
	// method in Constructor

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// 3. create Associated method for each and every object Repository without
	// passing test data.

	public void loginFunctionality(String username, String password)

	{
		uname.sendKeys(username);

		pass.sendKeys(password);

		loginButton.click();

	}

}
