package com.qa.hotpot.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.hotpot.base.BasePage;
import com.qa.hotpot.cases.HomePage;
import com.qa.hotpot.cases.LoginPage;
import com.qa.hotpot.util.Constants;

public class HomePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop=basePage.initialize_properties();
		driver = basePage.initialise_driver(prop);
		loginPage = new LoginPage(driver);
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	Thread.sleep(8000);
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

//	@Test(priority = 2)
//	public void verifyHomePageHeaderTest() {
//		String headerValue = homePage.getHomePageHeaderValue();
//		System.out.println("home page header is: " + headerValue);
//		Assert.assertEquals(headerValue, Constants.HOME_PAGE_HEADER);
//	}
//
//	@Test(priority = 3)
//	public void verifyLoggedInUserAccountTest() {
//		String accountName = homePage.getLoggedInAcoountName();
//		System.out.println("logged in account name is: " + accountName);
//		Assert.assertTrue(homePage.verifyLoggedInAcoountName());
//		Assert.assertEquals(accountName, prop.getProperty("accountname"));
//	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
