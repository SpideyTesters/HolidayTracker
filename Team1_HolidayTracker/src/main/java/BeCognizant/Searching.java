package BeCognizant;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Base;
import objectReposatory.locators;
import utils.TakeScreenShot;

public class Searching extends locators {
	public static WebDriver driver;
	Base base = new Base();
	public void search() throws InterruptedException {
		driver=Base.driver;
		String UserValidation = driver.findElement(By.xpath("//*[@id=\"userProfileToggleBtn\"]/div/div[2]")).getText();
		System.out.println(UserValidation);
        WebElement Holiday=driver.findElement(search);   //Click Search Box
		Holiday.sendKeys("Holiday Tracker");       //Enter Holiday Tracker
		
		TakeScreenShot.CaptureScreenShot("User Validation");
		Holiday.sendKeys(Keys.ENTER);              //Click Enter
		Thread.sleep(5000);

	}}
