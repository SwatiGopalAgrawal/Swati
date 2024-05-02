package stepdefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BaseLayer.BaseClass;
import PageLayer.CheckoutCompletePage;
import PageLayer.OverviewPage;
import PageLayer.YourInformationCheckoutPage;
import io.cucumber.java.en.Then;

public class InfoAndOverviewSteps extends BaseClass {

	int saucelabquantity = 1;

	public static YourInformationCheckoutPage yourinfopage;
	public static OverviewPage overviewpage;
	public static CheckoutCompletePage checkoutpage;

	// @Test(priority = 8)
	@Then("user enter FirstName, LastName and PostalCode")
	public void user_enter_first_name_last_name_and_postal_code() {

		yourinfopage = new YourInformationCheckoutPage();
		yourinfopage.generateRandomString();
		yourinfopage.generateRandomString();
		yourinfopage.generateRandomInt();

	}

	// @Test(priority = 9)
	@Then("click on continue button")
	public void click_on_continue_button() {
		yourinfopage.click();

	}

	@Then("user validate the quantity and price of the product")
	public void user_validate_the_quantity_and_price_of_the_product() {

		// validation for quantity

		int Quantity = 0;
		List<WebElement> listofquantity = driver.findElements(By.xpath("//*[text()='1']"));

		for (WebElement wb : listofquantity) {
			String quantity = wb.getText();
			Quantity = Integer.parseInt(quantity);

		}

		Assert.assertEquals(saucelabquantity, Quantity);

		// validation for price and total

		WebElement wb = driver.findElement(By.xpath("//div[@class='summary_total_label']"));
		String TotalValue = wb.getText();

		String tvalue = TotalValue.substring(8);
		float newvalue = Float.parseFloat(tvalue);

		List<WebElement> wb1 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

		String fprice = wb1.get(0).getText();

		float first = Float.parseFloat(fprice.substring(1));

		String sprice = wb1.get(1).getText();

		float second = Float.parseFloat(sprice.substring(1));

		float total = first + second;
		System.out.println(total);

		String tax = driver.findElement(By.xpath("//div[@class='summary_tax_label']")).getText();
		String Tax = tax.substring(6);
		float taxvalue = Float.parseFloat(Tax);
		System.out.println(taxvalue);

		float newtotal = total + taxvalue;

		System.out.println(newtotal);

		Assert.assertEquals(newvalue, newtotal);

	}

	@Then("user click on finish button")
	public void user_click_on_finish_button() {

		OverviewPage overviewpage = new OverviewPage();
		overviewpage.clickOnFinishButton();

		// driver.findElement(By.xpath("//button[@id='finish']")).click();

	}

	@Then("user validate the thank you message")
	public void user_validate_the_thank_you_message() {
		
		checkoutpage = new CheckoutCompletePage();


		String message = checkoutpage.captureCompleteOrderText();

		// String message = driver.findElement(By.xpath("//h2[text()='Thank you for your
		// order!']")).getText();
		boolean b = message.contains("Thank you for your order!");
		Assert.assertTrue(b);

	}

	@Then("user click on button")
	public void user_click_on_button() {

		checkoutpage = new CheckoutCompletePage();
		checkoutpage.clickOnMenu();

		// driver.findElement(By.xpath("//button[text()='Open Menu']")).click();

	}

	@Then("user click on logout button")
	public void user_click_on_logout_button() {
		checkoutpage = new CheckoutCompletePage();
		checkoutpage.clickOnLogout();

		// driver.findElement(By.xpath("//a[text()='Logout']")).click();

	}

	@Then("user validate it")
	public void user_validate_it() {

		WebElement display = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
		Assert.assertTrue(display.isDisplayed());

	}

}
