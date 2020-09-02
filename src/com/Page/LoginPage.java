package com.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Util.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(id="txtUsername")
	public WebElement userNameBox;
	
	@FindBy(id="txtPassword")
	public WebElement passwordBox;
	
	@FindBy(id="btnLogin")
	public WebElement LoginBtn;
	
	@FindBy(id="spanMessage")
	public WebElement spanMessage;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
}
