package utils;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;

import base.Base;

public class TakeScreenShot extends Base {
	public static void CaptureScreenShot(String name) {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver; // For Screenshot
		File source = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "./Screenshots/" + name + ".png"); // Screenshot location
		try {
			Files.copy(source, dest);
		} catch (Exception e) {
			e.getMessage();
		}
	}}