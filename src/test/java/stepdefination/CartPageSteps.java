package stepdefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.YourCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CartPageSteps extends BaseClass {

	public static YourCartPage yourcartpage;

	//@Test(priority = 5)

	@Given("user click on {string}, {string}")
	public void user_click_on(String product1, String product2) {
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));

		int count = 0;

		while (count < 2) {

			for (int i = 0; i < ls.size(); i++)

			{
				String a = ls.get(i).getText();

				if (a.equalsIgnoreCase(product1) || (a.equalsIgnoreCase(product2)))

				{
					WebElement p1 = driver.findElement(By.xpath("(//button[text()='Add to cart'])[" + i + 1 + "]"));
					p1.click();
					count++;
					break;

				}
			}
		}



	}

	//@Test(priority = 6)
	@Given("user click on add to cart")
	public void user_click_on_add_to_cart() {
		
		 yourcartpage = new YourCartPage();
		yourcartpage.ClickonCartBadge();
		//driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	}

	

	//@Test(priority = 7)
	@Then("user click on checkout button")
	public void user_click_on_checkout_button() {
		 yourcartpage = new YourCartPage();
		yourcartpage.clickOnCheckout();

		//driver.findElement(By.xpath("//button[@name='checkout']")).click();

	}

}
