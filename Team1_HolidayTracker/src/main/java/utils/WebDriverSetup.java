package utils;


import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup 
{

	public static WebDriver driver;
	public static WebDriver getWebDriver(String browserName) 
	{
		if(browserName.equalsIgnoreCase("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();

			//Customizing the Chrome Browser
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("Edge")) 
		{
			WebDriverManager.edgedriver().setup();
			
			//Customizing the Edge Browser
			EdgeOptions options = new EdgeOptions();
        	driver = new EdgeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("Firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();

			//Customizing the firefox Browser
			FirefoxOptions option = new FirefoxOptions();
            driver = new FirefoxDriver(option);
		}
		else
		{
			driver = null;
			System.out.println("Please provide the browser as Chrome/firefox/Edge !!!");
			String ch;
			System.out.println("Enter the browser name(chrome/firefox/Edge)");

			@SuppressWarnings("resource")
			Scanner input=new Scanner(System.in);

			ch=input.nextLine();
			getWebDriver(ch);
		}
		driver.manage().window().maximize();
		return driver;
	}

}

