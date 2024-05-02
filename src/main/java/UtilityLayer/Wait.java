package UtilityLayer;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class Wait extends BaseClass {

	public static int time = 40;

	public static WebElement visibilityStatus(WebElement wb) {
		return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(wb));
	}

	public static List<WebElement> visibilityAllElement(WebElement wb) {
		return new WebDriverWait(driver, Duration.ofSeconds(time))
				.until(ExpectedConditions.visibilityOfAllElements(wb));
	}

	public static List<WebElement> visibilityAllElement(List<WebElement> wb) {
		return new WebDriverWait(driver, Duration.ofSeconds(time))
				.until(ExpectedConditions.visibilityOfAllElements(wb));
	}

	public static String randomInt() {
		String code = RandomStringUtils.randomNumeric(10);

		return code;
	}

	public static String randomString() {
		String name = RandomStringUtils.randomAlphabetic(05);

		return name;
	}

	
	public static void sendKeys(WebElement wb, String value) {
		visibilityStatus(wb).sendKeys(value);
	}

	public static void click(WebElement wb) {
		visibilityStatus(wb).click();
	}

	public static void clear(WebElement wb) {
		visibilityStatus(wb).clear();
	}

	public static String getText(WebElement wb) {
		return visibilityStatus(wb).getText();
	}

	public static String getAttribute(WebElement wb, String key) {
		return visibilityStatus(wb).getAttribute(key);
	}

	public static boolean isSelected(WebElement wb) {
		return visibilityStatus(wb).isSelected();
	}

	public static void selectAnyone(List<WebElement> wb, String value) {
		for (WebElement list : wb) {
			if (list.getText().equals(value)) {
				list.click();
				break;
			}
		}

	}

}
