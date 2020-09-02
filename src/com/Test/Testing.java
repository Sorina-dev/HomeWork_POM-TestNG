package com.Test;

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
	public static WebDriver driver;
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
	//	WebDriverWait wait =WebDriverWait(20,driver);

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
	    login.userNameBox.clear();
	    login.passwordBox.clear();
	}


	@Test
	public void UserNameEmpty() throws InterruptedException {
		Thread.sleep(2000);
		login.userNameBox.sendKeys("");
		login.passwordBox.sendKeys("Hum@nhrm123");
		login.LoginBtn.click();

		SoftAssert softAssertion1 = new SoftAssert();
		String expectedMessage1 = "Username cannot be empty";
		Thread.sleep(4000);
		String actualMessage1 = login.spanMessage.getText();
		softAssertion1.assertEquals(actualMessage1, expectedMessage1);
		System.out.println(actualMessage1);
		softAssertion1.assertAll();
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

		SoftAssert softAssertion2 = new SoftAssert();
		String expectedMessage2 = "Invalid credentials";
		String actualMessage2 = login.spanMessage.getText();
		softAssertion2.assertEquals(actualMessage2, expectedMessage2);
		System.out.println(actualMessage2);
		softAssertion2.assertAll();
		Thread.sleep(2000);
	}

}

