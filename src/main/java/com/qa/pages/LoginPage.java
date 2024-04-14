package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class LoginPage extends Testbase{
	
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name="username")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginButton;
	
	@FindBy(xpath="//a[Contain(text(),'Sign Up')]")
	WebElement SignUpButton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement FreeCRMLogo;


	public String ValidateLoginPage() {
		return driver.getTitle();
	}
	
	public boolean ValidateLogo() {
		return FreeCRMLogo.isDisplayed();
	}
	
	public HomePage Credential(String Un, String Pw) throws Exception{
		Username.sendKeys(Un);
		Password.sendKeys(Pw);
		LoginButton.click();
		
		return new HomePage();
		
	}
	
	
	
	
	
	
	
	
	
	
}
