package com.page.classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentTest;
import com.base.classes.BaseClass;

public class HomePage extends BaseClass {

	public HomePage(WebDriver l_driver, ExtentTest logger) {
		super(l_driver, logger);

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='What do you want to learn?']")
	WebElement search;
	
	@FindBy(xpath="//*[@id='rendered-content']/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div")
	WebElement button;

	public void home(String CourseName) throws Exception {

		// Search function is implemented
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		search.sendKeys(CourseName);
	
		button.click();
		

	}

}
