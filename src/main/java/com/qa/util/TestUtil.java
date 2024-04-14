package com.qa.util;

import java.io.IOException;

import com.qa.base.Testbase;

public class TestUtil extends Testbase{
	
	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public static int Page_Load_TimeOut = 20;
	public static int Implicit_Wait = 10;
	
	
	public void SwitchtoFrame() {
		driver.switchTo().frame("mainpanel");
		
	}

}
