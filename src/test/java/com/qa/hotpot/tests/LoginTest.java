package com.qa.hotpot.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.hotpot.base.BasePage;
import com.qa.hotpot.cases.LoginPage;
import com.qa.hotpot.util.Constants;

public class LoginTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop=basePage.initialize_properties();
		driver = basePage.initialise_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@Test(priority=1, description="login testnwith correct username and password")
	public void loginTest() throws InterruptedException {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=2, description="login page title test")
	public void loginPageTitleTest() throws InterruptedException 
	{
		Thread.sleep(5000);
		String title=loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"login title is incorrect");
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}
