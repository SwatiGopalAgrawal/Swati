package stepdefination;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.LoginPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginpageSteps extends BaseClass {
	
	
	//@Test(priority=1)
	@Given("user enter {string} browser and open login url")
	public void user_enter_browser_and_open_login_url(String browsername) {

		BaseClass.initialization(browsername);

	}
	//@Test(priority=2)
	@When("user enter valid credentials and click on login button")
	public void user_enter_valid_credentials_and_click_on_login_button() {

		LoginPage lpage = new LoginPage();
		lpage.loginFunctionality(prop.getProperty("usernname"), prop.getProperty("password"));

	}
	
	
	//@Test(priority=3)
	@Then("user validate title")
	public void user_validate_title() {

		String title = driver.getTitle();
		Assert.assertEquals(title,"Swag Labs");

	}
	//@Test(priority=4)
	@Then("user validate url")
	public void user_validate_url() {
		String url = driver.getCurrentUrl();
		boolean b = url.contains("saucedemo");
		Assert.assertEquals(b, true);

	}
	//@Test(priority=5)
	@AfterStep
	public static void tearDowm(Scenario scenario) {
		if (scenario.isFailed()) {

			byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(f,"image/png",scenario.getName());
		}
		else {
			byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(f,"image/png",scenario.getName());
		}
	}
}
