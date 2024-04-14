package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	
   public static WebDriver driver;
   public static Properties prop;
	static FileInputStream fis;
	
	
	public Testbase() throws IOException {
		
		try {
		prop = new Properties();
		fis = new FileInputStream("C:/Users/Akshay R B/eclipse-workspace/FreeCRMTest/src/main/java/com/qa/config/config.properties");
		prop.load(fis);
		
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Initialisation() {
		String BrowserName = prop.getProperty("browser");
		if(BrowserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(!BrowserName.equals("Chrome")){
			System.out.println("Browser Not Supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Implicit_Wait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.Page_Load_TimeOut));
		
		driver.get(prop.getProperty("BaseURL"));
		
		
		
		
		
		
	}

	

}
