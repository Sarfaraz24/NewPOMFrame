package com.qa.hotpot.cases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hotpot.util.Constants;
import com.qa.hotpot.util.ElementUtil;

public class ContactsPage {
	WebDriver driver;
	ElementUtil elementUtil;

	By createContactButton = By.xpath("//span[text()='Create contact']");
	By createContactFormButton = By.xpath(".private-loading-button__content.private-button--internal-spacing");
	By email = By.id("UIFormControl-7");
	By firstName = By.id("UIFormControl-8");
	By lastName = By.id("UIFormControl-10");
	By jobTitle = By.id("UIFormControl-14");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getContactsPageTitle() {
		return elementUtil.waitForPageTitle(Constants.CONTACTS_PAGE_TITLE);
	}

	public void createNewContact(String emailID, String FN, String LN, String jobTitleVal) {
		elementUtil.doClick(createContactButton);
		elementUtil.doSendKeys(email, emailID);
		elementUtil.doSendKeys(firstName, FN);
		elementUtil.doSendKeys(lastName, LN);
		elementUtil.doSendKeys(jobTitle, jobTitleVal);

		elementUtil.doClick(createContactFormButton);
	}

}
