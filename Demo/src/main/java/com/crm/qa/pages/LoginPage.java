package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

//**********************Page Factor or OR(Object Repository)**************************//
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
    WebElement password;
	
	@FindBy (xpath = "/html/body/div[1]/header/div/nav/div[2]/div/a")
	WebElement Login1xpath;
	
	@FindBy (xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement Login2xpath;
	
	@FindBy (xpath = "SignUpbtn_xpath")
	WebElement SignUpbtnxpath;
	
	@FindBy (xpath = "/html/body/div[1]/header/div/nav/div[2]/div/div[1]/div/a/svg")
	WebElement Logo;
	
	//To initialize the Elements of Page Factory Creating the constructor of it//
	
	public LoginPage() {
		//to initialize the Elements of Page Factory there is method i.e initElement
		// driver comes from Testbase class and (this) the current class object
		// All the above variables will comes in driver
		
	}

}
