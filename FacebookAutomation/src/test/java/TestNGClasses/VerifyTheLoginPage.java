package TestNGClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass.Bclass;
import POMClasses.LogInPage;
import Utils.Utility;


public class VerifyTheLoginPage {
	
	WebDriver driver;
	LogInPage loginPage;
	ExtentTest test;
	ExtentHtmlReporter reporter;
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browser) {
		reporter = new ExtentHtmlReporter("test-output/ExtentReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if (browser.equals("Chrome")){
			driver=Bclass.openChrome();
		}
		
	}
	
	@BeforeClass
	public void openUrlOfFacebook() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	
	}
	@BeforeMethod
	public void feedDetails() throws IllegalStateException, IOException {
		String data= Utility.getExcelData("DATA", 1, 0);
		loginPage= new LogInPage(driver);
		loginPage.sendUsername(data);
		data= Utility.getExcelData("DATA", 1, 1);
		loginPage.sendPassword(data);
		
		
	}
	@Test
	public void verifyTheFunctionalityOfLogInButton() throws IllegalStateException, IOException {
		loginPage.clickOnLoginButton();
		String expectedTitle= "Log in to Facebook";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Utility.setExcelData("DATA", 1, 3, "Pass");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
		
	}
	@AfterClass
	public void clearObjects() {
		loginPage= null;
		
	}
	@AfterTest
	public void closeBrowser() {
		//driver.close();
		//driver.quit();
		driver=null;
		System.gc();
		
	}


}
