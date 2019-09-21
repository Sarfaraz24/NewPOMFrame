package com.qa.hotpot.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hotpot.base.BasePage;
import com.qa.hotpot.util.Constants;
import com.qa.hotpot.util.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	By emailId=By.id("username");
	By password=By.id("password");
	By loginButton=By.id("loginBtn");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		 elementUtil=new ElementUtil(driver);
	}
	@Step("getting login page title")
	public String getLoginPageTitle()
	{
		elementUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
		return driver.getTitle();
	}
	public HomePage doLogin(String username,String pwd)
	{
		elementUtil.doSendKeys(emailId,username);
		elementUtil.doSendKeys(password,pwd);
		elementUtil.doClick(loginButton);
		
		return new HomePage(driver);
	}
}
