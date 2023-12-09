package com.testng.pages;

import org.openqa.selenium.WebDriver;

import com.testng.webelements.Ebay_HomePage;

public class Ebay_HomePg {
	
	WebDriver driver;
	Ebay_HomePage ebay_homepage_elements;
	
	
	public Ebay_HomePg(WebDriver driver) {
		this.driver = driver;
		ebay_homepage_elements = new Ebay_HomePage(driver);
	}
	
	public void ClickonSearchBtn() {
		ebay_homepage_elements.searchBtn.click();
	}
	
	public boolean CheckSearchBtn() {
		return ebay_homepage_elements.searchBtn.isEnabled();
	}
	
	

}
