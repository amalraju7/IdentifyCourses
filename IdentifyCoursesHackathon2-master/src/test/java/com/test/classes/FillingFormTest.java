package com.test.classes;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import com.base.classes.BaseClass;

import com.framework.utilities.ExtentReportManager;
import com.page.classes.FillingFormPage;
import com.page.classes.HomePage;
import com.page.classes.LanguageLearning;
import com.page.classes.SearchCourse;

public class FillingFormTest {

	public static  WebDriver driver;
	public static WebDriverWait wait;
	// Extent report
	public static ExtentReports report;
	public static ExtentTest logger;

	//Initializing all classes
	BaseClass baseclass;
	HomePage homepage;
	SearchCourse searchcourse;
	LanguageLearning languagelearning;
	FillingFormPage fillingform;

	@BeforeClass(groups = { "Regression","smoke" })
	@Parameters({ "browser" })
	public void InvokeBrowser(@Optional String browser) {
		
		
		// The browser name is got from the properties file
		// Report and logger is instantiated
		browser="chrome";
		System.out.println("****************  Working with Test Scenario-1 --<Form Filling>-- *****************");
	
		String Testname = "FillingFormTestReport";
		report = ExtentReportManager.getReportInstance(browser, Testname);
		logger = report.createTest("Form Filling");

		baseclass = new BaseClass(driver, logger);

		boolean isvalid = baseclass.validateBrowser(browser);
		AssertJUnit.assertTrue(isvalid);

		// All the page classes are instantiated
		logger.log(Status.INFO, "Opening the browser ");
		
		//opening the browser
		driver = baseclass.openBrowser(browser);

		logger.log(Status.PASS, "Successfully opened the " + browser + " browser");
		homepage = new HomePage(driver, logger);
		searchcourse = new SearchCourse(driver, logger);
		languagelearning = new LanguageLearning(driver, logger);
		fillingform = new FillingFormPage(driver, logger);
		baseclass.getUrl();

	}
	
	@Test(priority = 1, groups = {"Regression","smoke" })
	public void clickForEnterpriseTest() {
		
		fillingform.ForEnterprise();
	}

	@Test(priority = 2, groups = { "Regression","smoke"  })
	public void openFormTest() throws Exception {

		// Methods of the filling form class is called using the object of the class
		fillingform.OpenForm();
	}
	
	@Test(priority = 3, groups = { "Regression" })
	public void getDetailsTest() throws IOException {
		
		fillingform.getUserDetails();
	}
	
	@Test(priority = 4, groups = { "Regression" })
	public void setDetailsTest() {
		
		fillingform.setUserDetails();		
	}
	
	
	@AfterClass(groups = { "Regression" ,"smoke" })
	public void endTest() throws Exception {
		
		//Closing the browser after the test implementation
		logger.log(Status.INFO, "Closing the browser");
		baseclass.closeBrowser();
		System.out.println("**************** Test Scenario-1 completed successfully ****************");
		logger.log(Status.PASS, "Closed browser successfully");
		report.flush();

	}

}
