package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.crm.qa.util.TimeUtil;

public class TestBase {

//***********make it public static so we can use this variables in child class also***************************//
	public static WebDriver driver;
	public static Properties prop;

//***********Public Constructor of class TestBase**************************************//
	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream in = new FileInputStream(
					"C:\\Users\\ekta.narke\\eclipse-workspace\\" + "Demo\\Driver\\chromedriver.exe");
			prop.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	public static void initialization() {
		String BrowserName = prop.getProperty("browser");
		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} // ************Just for Example Firefox exe file not
			// download**********************//
		else if (BrowserName.equals("FireFox")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		// ************Just for Example Safari exe file not
		// download**********************//
		else if (BrowserName.equals("Safari")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new SafariDriver();
		}
		// ************Just for Example InternetExplorerDriver exe file not
		// download**********************//
		else if (BrowserName.equals("InternetExplorer")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("No such browser found");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeUtil.page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeUtil.implicitly_Wait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
