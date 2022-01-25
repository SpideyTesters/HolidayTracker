package BeCognizant;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.Base;
import objectReposatory.locators;
import utils.TakeScreenShot;
import utils.WriteExcelData;

public class ClickOnTracker extends locators {
	public static WebDriver driver;
	Base base = new Base();


	public static void holiday() throws Exception {
		driver=Base.driver;

		//click Holiday tracker link
		driver.findElement(holiday).click();  //click HT link
		Thread.sleep(5000);

		//Click view all
		String parentWin = driver.getWindowHandle(); // get parent window
		Set<String> allWindows = driver.getWindowHandles(); // get all windows and store in a set
		for (String child : allWindows) {
			if (!parentWin.equalsIgnoreCase(child)) {
				driver.switchTo().window(child); // switch to child window
				Thread.sleep(1000);
			}
		}
		driver.switchTo().frame("appFrame");         //To switch to One Cognizant page
		TakeScreenShot.CaptureScreenShot("User's location");
		driver.findElement(viewall).click();   //Click View All
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		String Userlocation = driver.findElement(By.xpath("//*[@id=\'apphomewrapper\']/div[2]/div/div[2]/p/span")).getText();
		System.out.println(Userlocation);

			String leave =driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[19]/div[3]/table/tbody")).getText(); //Display holidays
			System.out.println(leave);
		

		Thread.sleep(5000);
		action.sendKeys(Keys.ESCAPE).build().perform(); //To close Holidays table
		Thread.sleep(5000);
		WebElement search = driver.findElement(searchbox);  //click on Search Box
		search.click();
		search.sendKeys("Republic Day");  //To search Republic Day
		Thread.sleep(5000);
		search.sendKeys(Keys.ARROW_DOWN);  //To click the displaying Republic day
		search.sendKeys(Keys.ENTER);       //Click Enter
		Thread.sleep(5000);
		TakeScreenShot.CaptureScreenShot("Location Verification");
		List<WebElement> list2 = driver.findElements(days);
		int list2Size = list2.size();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("________________________________");
		for(int j=1;j<=list2Size;j++) 
		{
			for(int k =1;k<5;k++) {
				WebElement Holiday = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[10]/div[3]/div[1]/table/tr["+j+"]/td["+k+"]"));   //Location having the Republic Day as Holidays
				js.executeScript("arguments[0].scrollIntoView(true);", Holiday);   //To scroll the Holidays
				String hday = Holiday.getText();
				System.out.println(hday);          //To print Locations on console
				WriteExcelData.write("Holiday", (j-1), (k-1), hday);   //To print Locations on Excel Sheet

			}
			System.out.println("________________________________");
		}

		Thread.sleep(3000);
		driver.close();                         //close the child window
		driver.switchTo().window(parentWin);    //Switching to parent window


	}



}
