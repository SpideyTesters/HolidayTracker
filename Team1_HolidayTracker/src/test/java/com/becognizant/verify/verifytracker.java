package com.becognizant.verify;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BeCognizant.ClickOnTracker;
import BeCognizant.Searching;
import base.Base;
import utils.ExtentReportManager;

public class verifytracker {
	public static ExtentTest logger;
	Base base= new Base();
	Searching searching=new Searching();
	ClickOnTracker tracker=new ClickOnTracker();
	ExtentReports report = ExtentReportManager.reporter();

	@Parameters("browser_name")
	@BeforeTest(groups= {"smoke","regression"})
	public void invoke(String browser) {

		logger = report.createTest("Browser invoke");
		try {
			base.invokeBrowser(browser);
			logger.log(Status.PASS, "Browser Invoked Successfully");
		} catch (Exception e) {
			logger.log(Status.FAIL, "Invalid Browser");
		}

	}
	@Test(priority=1,groups= {"smoke","regression"})
	public void url() {

		logger = report.createTest("Open URL");
		try {
			base.geturl();
			logger.log(Status.PASS, "URL Opened");
		} catch (Exception e) {
			logger.log(Status.FAIL, "URL was not Opened");
		}
	}
	@Test(priority=2,groups= {"regression"})
	public void validation() {

		logger = report.createTest("Validating User");
		try {
			base.titlevalidation();
			logger.log(Status.PASS, "Correct URL");
		} catch (Exception e) {
			logger.log(Status.FAIL, "URL was Wrong");
		}
	}
	@Test(priority=3,groups= {"regression"})
	public void Search() throws InterruptedException {

		logger = report.createTest("Search Holiday Tracker");
		try {
			searching.search();
			logger.log(Status.PASS, "Searched Holiday on BeCognizant");
			logger.addScreenCaptureFromPath("./Screenshots/User Validation.png");
		} catch (Exception e) {
			logger.log(Status.FAIL, "Holiday was not Searched");
		}
	}
	@Test(priority=4,groups= {"regression"})
	public void getholiday() throws InterruptedException {

		logger = report.createTest("Fetching Holidays");
		try {
			ClickOnTracker.holiday();
			logger.log(Status.PASS, "Holidays Fetched Sucessfully");
			logger.addScreenCaptureFromPath("./Screenshots/Holidays.png");
			logger.addScreenCaptureFromPath("./Screenshots/Location Verification.png");
		} catch (Exception e) {
			logger.log(Status.FAIL, "Holidays not Fetched ");
		}
	}
	@AfterTest(groups= {"smoke","regression"})
	public void close() {

		logger = report.createTest("Closing Browser");
		try {
			base.closeBrowser();
			logger.log(Status.PASS, "Browser Closed Successfully");
		} catch (Exception e) {
			logger.log(Status.FAIL, "Browser was not Closed");
		}
		report.flush();
	}

}
