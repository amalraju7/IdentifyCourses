package com.base.classes;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OpenBrowser {
	public static WebDriver driver;

	public WebDriver openBrowser(String browsername) {

		
		System.out.println("To change the browser go to //resources//data.properties and change ");
		try {

			if (browsername.equalsIgnoreCase("chrome")) {

				
				DesiredCapabilities dc =  DesiredCapabilities.chrome();
				driver = new RemoteWebDriver(new URL("http://10.211.55.4:4444/wd/hub"),dc);
				System.out.println("Opening " + browsername + " browser.................");
				driver.manage().window().maximize(); // to enter maximized screen

			}

			else if (browsername.equalsIgnoreCase("IE")) {

			
		
				DesiredCapabilities capabilities = DesiredCapabilities.edge();
			
				driver = new RemoteWebDriver(new URL("http://10.211.55.4:4444/wd/hub"), capabilities);
			
				driver.manage().window().maximize(); // to enter maximized screen

			}

			else {
				DesiredCapabilities dc =  DesiredCapabilities.firefox();
				driver = new RemoteWebDriver(new URL("http://10.211.55.4:4444/wd/hub"),dc);
				System.out.println("Opening " + browsername + " browser.................");
				driver.manage().window().maximize(); // to enter maximized screen

			}
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		return driver;

	}
	/************* closes the browser *****************/
	public void closeBrowser() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	
		driver.quit();
		
			
	}
}
