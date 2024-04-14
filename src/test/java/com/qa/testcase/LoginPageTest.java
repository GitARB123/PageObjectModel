package com.qa.testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends Testbase{
	
	public static LoginPage login;
	HomePage homepage;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException{
		Initialisation();
		login = new LoginPage();
	}
	
	
	@Test
	public void LoginPageTitleTest() {
		String Title = login.ValidateLoginPage();
		Assert.assertEquals(Title, "Free CRM Software for customer relationship management, sales, and support.");
	}
	
	@Test
	public void CRMLogoTest() {
		boolean flag = login.ValidateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void LoginTest() throws Exception {
		homepage = login.Credential(prop.getProperty("UserName"), prop.getProperty("Password"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
