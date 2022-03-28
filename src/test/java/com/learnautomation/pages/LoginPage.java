package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver ldriver) {
        this.driver = ldriver;

    }

//	@FindBy(name="login") WebElement user;
//	
//	@FindBy(name="passwd") WebElement pass;
//	
//	@FindBy(xpath="//input[@class='signinbtn']") WebElement loginButton;
//	
//	@FindBy(xpath="//a[contains(text(),'Signout')]") WebElement signoutButton;

    @FindBy(name = "email")
    WebElement user;

    @FindBy(name = "password")
    WebElement pass;

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement loginButton;

    //@FindBy(xpath="//a[contains(text(),'Signout')]") WebElement signoutButton;


    public void loginCRM(String usernameApplication, String passwordApplication) {
        try {

            Thread.sleep(2000);

        } catch (InterruptedException e) {

        }

        user.clear();
        user.sendKeys(usernameApplication);
        pass.clear();
        pass.sendKeys(passwordApplication);
        loginButton.click();
        //signoutButton.click();
    }


}
