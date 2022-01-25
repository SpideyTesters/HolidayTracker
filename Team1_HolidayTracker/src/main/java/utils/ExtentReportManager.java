package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	public static ExtentReports report;
	public static ExtentReports reporter() {
		if (report == null) {
			// Using ExtentHtmlReporter to generate Extent Report
			ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "./HolidayTracker.html"); // Location to save
			report = new ExtentReports();
			report.attachReporter(htmlreporter);
			report.setSystemInfo("OS", "Windows 10");// Environment set up info
			report.setSystemInfo("Browser", "Edge"); // Browser info

			htmlreporter.config().setDocumentTitle("Holiday Tracker"); // Document Title
			htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlreporter.config().setTheme(Theme.DARK); // Theme
			htmlreporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss"); // Date formate
		}
		return report;
	}

}
