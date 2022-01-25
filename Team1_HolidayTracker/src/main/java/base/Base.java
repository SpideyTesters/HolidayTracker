package base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BeCognizant.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectReposatory.locators;

public class Base extends locators {
	

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static WebDriverWait wait;
	static Properties properties;

	// To call different browsers
	@SuppressWarnings("deprecation")
	public void invokeBrowser(String browser_name) {
		try {


			// To Open Chrome Browser
			if (browser_name.equalsIgnoreCase("chrome")) { //validating browser
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(); // initializing driver variable using ChromeDriver
			}

			// To Open Firefox Browser
			else if (browser_name.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(); // initializing driver variable using FirefoxDriver

				// To Open Edge Browser
			} else if (browser_name.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(); // initializing driver variable using EdgeDriver 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize(); //to maximize the window
		driver.manage().deleteAllCookies(); // to delete all cookies
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // To wait untill page load
	}

	public void geturl() {
		ReusableMethods method = new ReusableMethods();
		properties = method.fileReader();
		driver.get(properties.getProperty("URL"));
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.presenceOfElementLocated(search));   //Click SearchBox
	}

	public void titlevalidation() {
		String actual=driver.getTitle();
		String expected="Be.Cognizant";     //To validate URL page Validation
		Assert.assertEquals(actual, expected, "Wrong Page");
	}


	public void closeBrowser() {// To close the Browser
		driver.quit();
	}

}
