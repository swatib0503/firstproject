package com.bankingproject.pageobjectclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement UserID;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginbtn;
	
	@FindBy(xpath="//input[@name='btnReset']")
	WebElement resetbtn;

public LoginPage(WebDriver rdriver){
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	
}

public void SetUserID(String name) {
	
	UserID.sendKeys(name);
}

public void SetPassword(String pass) {
	
	Password.sendKeys(pass);
}
	
public void ClickonLoginbtn() {
	
	loginbtn.click();
}	

public void ClickonResetbtn() {
	
	resetbtn.click();
}
	
}
