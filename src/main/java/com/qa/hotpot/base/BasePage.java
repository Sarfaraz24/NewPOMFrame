package com.qa.hotpot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author salam
 *
 */
public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public static String flash;
	/**
	 * 
	 * @return WebDriver
	 * @throws InterruptedException 
	 */
	public WebDriver initialise_driver(Properties prop) throws InterruptedException
	{
		//String browser="chrome";
		String Browser=prop.getProperty("browser");
		String headless=prop.getProperty("headless");
		flash=prop.getProperty("elementflash");
		if (Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().version("2.46").setup();
			if(headless.equalsIgnoreCase("yes")) {
				ChromeOptions co=new ChromeOptions();
				co.addArguments("--headless");
				driver=new ChromeDriver(co);
			}else
			{
			driver=new ChromeDriver();
		}}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			if(headless.equalsIgnoreCase("yes")) {
				FirefoxOptions fo=new FirefoxOptions();
				fo.addArguments("--headless");
				driver=new FirefoxDriver(fo);
			}
			else
			{
			driver=new FirefoxDriver();
		}}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://app.hubspot.com/login");
		return driver;
	}
	
	/**
	 * 
	 * @return Properties
	 */
	public Properties initialize_properties()
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/hotpot/config/config.properties");
			prop.load(ip);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("some exception occurred while quitting the browser");
		}
	}

	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("some exception occurred while closing the browser");
		}
	}
}
