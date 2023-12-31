package com.orangeHRM.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.home.OrangeHRM_SingInPage;

public class OrangeHRM_BasePage {
	
	private WebDriver driver;
	
	@FindBy(name = "username")
	WebElement txtUsername;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement txtWelcome;
	
	@FindBy(linkText = "Logout")
	WebElement lnLogout;
	
	@FindBy(xpath = "//img[@alt='company-branding']")
	WebElement divLogo_img;

	public WebDriver getDriver() {
		return driver;
	}

	public OrangeHRM_BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Sign in functionality
	public OrangeHRM_SingInPage GoToHomePageAndSignIn(String username, String passwd) throws Exception {
		return signInToOrangeHRM(username, passwd);
	}

	public OrangeHRM_SingInPage signInToOrangeHRM(String username, String passwd) {
		enterUserName(username);
		enterPassword(passwd);
		submitButton();
		return new OrangeHRM_SingInPage(driver);
	}

	public void enterUserName(String username) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
	}

	public void enterPassword(String passwd) {
		txtPassword.clear();
		txtPassword.sendKeys(passwd);
	}

	public void submitButton() {
		btnLogin.click();
	}
	
	public void logout() throws InterruptedException {
		txtWelcome.click();
		Thread.sleep(2000);
		lnLogout.click();
		Thread.sleep(5000);
		divLogo_img.isDisplayed();
	}
}