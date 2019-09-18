package com.qa.hotpot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hotpot.base.BasePage;
import com.qa.hotpot.cases.ContactsPage;
import com.qa.hotpot.cases.HomePage;
import com.qa.hotpot.cases.LoginPage;
import com.qa.hotpot.util.Constants;

public class ContactsPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialise_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.gotoContactsPage();
	}

	@Test(priority = 1)
	public void verifyContactsPageTitleTest() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("contacts page title is: " + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}
	
	
//	@DataProvider()
//	public Object[][] getContactData(){
//		Object data[][] = ExcelUtil.getTestData("createcontact");
//		return data;
//	}

	@Test(priority = 2)
	public void createNewContactTest() {
		contactsPage.createNewContact("asasa.com", "asa", "roza", "engineer");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
