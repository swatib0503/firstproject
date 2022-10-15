package com.bankingproject.pageobjectclass;

import java.io.File;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bankingproject.utilities.Readconfig;


public class Base_Class {
	Readconfig readconfig = new Readconfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String UserID = readconfig.getUserID();
	public String Password = readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static ExtentSparkReporter sparkreport;
	public static ExtentReports extent;
	public static ExtentTest test;
	static Random r = new Random();
	static int x= r.nextInt(10);
	
		@BeforeSuite
		public void setReport() {
		sparkreport = new ExtentSparkReporter("C:\\Users\\swati\\eclipse-workspace\\mavenproject\\Reports\\htmlreports"+x+".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkreport);
		extent.setSystemInfo("Operating System", "windows");
		extent.setSystemInfo("Environment", "QA");
		sparkreport.config().setReportName("Integration Test Execution");
		sparkreport.config().setDocumentTitle("QA Automation Testing Report");
		sparkreport.config().setTheme(Theme.STANDARD);
		
	}
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String str) {
		if(str.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\swati\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
					}
		else if(str.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					"C:\\Users\\swati\\Downloads\\geckodriver-v0.31.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(str.equals("ie")) {
			System.setProperty("webdriver.ie.driver", 
					"C:\\Users\\swati\\Downloads\\IEDriverServer_Win32_4.5.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
}
	
	public static String captureScreen() throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String des = ("C:\\Users\\swati\\eclipse-workspace\\mavenproject\\Screenshot"+x+".png");
		FileUtils.copyFile(src, new File(des));
		return des;
	
	}

@AfterClass

	public void closebrowser() {
		
		driver.quit();
	}

@AfterSuite
public void endReport() {
	extent.flush();
}
}
