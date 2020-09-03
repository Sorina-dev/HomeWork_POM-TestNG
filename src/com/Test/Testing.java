package com.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Page.LoginPage;
import com.Util.BaseClass;

public class Testing {
	
	LoginPage login = new LoginPage();

	@BeforeClass
	public void setUp() {
		BaseClass.setUp();
	}

	@AfterClass
	public void quitBrowser() {
		BaseClass.quitBrowser();
	}

	@Test
	public void PwdEmpty() throws InterruptedException {
	

		login = new LoginPage();
		login.userNameBox.sendKeys("Admin");
		login.passwordBox.sendKeys("");
		login.LoginBtn.click();

		SoftAssert softAssertion = new SoftAssert();
		String expectedMessage = "Password cannot be empty";
		Thread.sleep(2000);

		String actualMessage = login.spanMessage.getText();
		softAssertion.assertEquals(actualMessage, expectedMessage);
		System.out.println(actualMessage);
	    softAssertion.assertAll();
	    Thread.sleep(2000);
	    
	    TakesScreenshot ts =(TakesScreenshot) BaseClass.driver;
	    File scrFile = ts.getScreenshotAs(OutputType.FILE);
	    
	    try {
	    	FileUtils.copyFile(scrFile, new File("screenshots\\Proof\\Pic1.png"));
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	    Thread.sleep(2000);
	    login.userNameBox.clear();
	    login.passwordBox.clear();
	}


	@Test
	public void UserNameEmpty() throws InterruptedException {
		Thread.sleep(2000);
		login.userNameBox.sendKeys("");
		login.passwordBox.sendKeys("Hum@nhrm123");
		login.LoginBtn.click();

		SoftAssert softAssertion = new SoftAssert();
		String expectedMessage = "Username cannot be empty";
		Thread.sleep(4000);
		String actualMessage = login.spanMessage.getText();
		softAssertion.assertEquals(actualMessage, expectedMessage);
		System.out.println(actualMessage);
		softAssertion.assertAll();
		Thread.sleep(2000);
		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("screenshots\\Proof\\Pic2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		 login.userNameBox.clear();
		 login.passwordBox.clear();
	}

	@Test
	public void WrongPwd() throws InterruptedException {
		Thread.sleep(2000);
		login.userNameBox.sendKeys("Admin");
		login.passwordBox.sendKeys("sjdvhuer");
		login.LoginBtn.click();

		SoftAssert softAssertion = new SoftAssert();
		String expectedMessage = "Invalid credentials";
		String actualMessage = login.spanMessage.getText();
		softAssertion.assertEquals(actualMessage, expectedMessage);
		System.out.println(actualMessage);
		softAssertion.assertAll();
		Thread.sleep(2000);
		
		TakesScreenshot ts = (TakesScreenshot)BaseClass.driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(srcFile, new File("screenshots\\Proof\\Pic3.png"));
		}catch(IOException e) {
         e.printStackTrace();
		}
		
	}

}

