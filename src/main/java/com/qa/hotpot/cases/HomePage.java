package com.qa.hotpot.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hotpot.base.BasePage;
import com.qa.hotpot.util.Constants;
import com.qa.hotpot.util.ElementUtil;
public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	By header = By.cssSelector("h1.private-header__heading>i18n-string");
	By accountName = By.cssSelector("a#account-menu>span.account-name ");
	
	By contactsMainTab = By.id("nav-primary-contacts-branch");
	By conatctsChildTab = By.id("nav-secondary-contacts");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil=new ElementUtil(driver);
	}

	public String getHomePageTitle() {
		return elementUtil.waitForPageTitle(Constants.HOME_PAGE_TITLE);
	}

	public String getHomePageHeaderValue() {
		return elementUtil.doGetText(header);
	}

	public boolean verifyLoggedInAcoountName() {
		return elementUtil.isElementDisplayed(accountName);
	}

	public String getLoggedInAcoountName() {
		return driver.findElement(accountName).getText();
	}
	private void clickOnContacts(){
		elementUtil.doClick(contactsMainTab);
		elementUtil.doClick(conatctsChildTab);
	}
	
	public ContactsPage gotoContactsPage(){
		clickOnContacts();
		return new ContactsPage(driver);
	}
}
