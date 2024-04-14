package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class HomePage extends Testbase{
	
	public HomePage() throws Exception{
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//td[contains(test(),'Akshay Bhagat')]")
	WebElement User;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement Deals;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement Tasks;

	
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public void GetUserName() {
		User.getText();
	}
	
	public ContactsPage ClickonContactsPage() throws IOException {
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public DealPage ClickonDeals() {
		Deals.click();
		return new DealPage();
			
	}
	
	public TasksPage ClickonTaskPage() throws IOException  {
		Tasks.click();
		return new TasksPage();
	}
	
	
	
}


