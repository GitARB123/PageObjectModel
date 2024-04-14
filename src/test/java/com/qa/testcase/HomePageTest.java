 package com.qa.testcase;

import java.io.IOException;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.ContactsPage;
import com.qa.pages.DealPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class HomePageTest extends Testbase{
	
	LoginPage login;
	HomePage homepage;
	TestUtil util;
	ContactsPage contactspage;
	DealPage dealpage;

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		Initialisation();
		util = new TestUtil();
		login = new LoginPage();
		contactspage = new ContactsPage();
		homepage = login.Credential(prop.getProperty("UserName"), prop.getProperty("Password"));
	}
	
	@Test
	public void VerifyHomePageTitleTest() {
		String homepagetitle = homepage.VerifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Homepage title not matched");
	}
	
	@Test
	public void VerifyUserName() {
		util.SwitchtoFrame();
		homepage.GetUserName();	 
	}
	
	@Test
	public void ClickonContactsPageTest() throws IOException {
		util.SwitchtoFrame();
		contactspage = homepage.ClickonContactsPage();
	}
	
	@Test
	public void ClickonDealsTest() {
		util.SwitchtoFrame();
		dealpage = homepage.ClickonDeals();
	}
	
	@Test
	public void ClickonTaskPage() throws IOException {
		util.SwitchtoFrame();
		homepage.ClickonTaskPage();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
