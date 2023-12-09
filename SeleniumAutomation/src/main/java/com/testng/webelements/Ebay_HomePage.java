package com.testng.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ebay_HomePage {
	
	WebDriver driver;
	
	@FindBy(css="#gh-btn")
	 public WebElement searchBtn;

	public Ebay_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

}


