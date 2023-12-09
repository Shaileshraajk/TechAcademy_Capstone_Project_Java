package com.test.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScript extends BaseClass{
	
	@Test(dataProvider = "testData", dataProviderClass = DataProviderClass.class)
    public void loginTest(String username, String password, String success) {
        // 1. Launch URL
        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

        // 2. Enter Username and Password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // 3. Verify title after login
        if (success.equals("TRUE")) {
            Assert.assertEquals(driver.getTitle(), "Swag Labs");
        } else {
            // 4. Verify error message after unsuccessful login
            WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
            Assert.assertTrue(errorMessage.isDisplayed());
        }
    }

}
