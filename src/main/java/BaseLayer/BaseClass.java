package BaseLayer;


import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {

	// Declare the reference of WebDriver as global so we can access in another class

	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {
		try {
			FileInputStream fis = new FileInputStream(
					new File(System.getProperty("user.dir") + "\\src\\main\\java\\ConfigLayer\\config.properties"));
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void initialization(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {

			// 1. Up Casting
			 driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			 driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("incognito")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--incognito");
			 driver = new ChromeDriver(opt);
		} else if (browserName.equalsIgnoreCase("headless")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--headless");
			 driver = new ChromeDriver(opt);
		}

		// 2. maximize the browser

		driver.manage().window().maximize();

		// 3. implicitlyWait

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 4. pageLoadTimeout

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		// 5. delete all Cookies

		driver.manage().deleteAllCookies();

		String url = prop.getProperty("url");
		driver.get(url);

	}
}
