package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;


public class LoginTestCRM extends BaseClass {


    @Test(priority = 1)
    public void loginApp() {

        logger = report.createTest("Login to PHP Travels");

        logger.info("Start Application");

        LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
        loginpage.loginCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));

        logger.pass("Login Success");


    }

    @Test(priority = 2)
    public void logOut() {
        report.createTest("Logout");
        logger.fail("Logout Fail");

        //System.out.println("LogOut Sucessfully");

    }

}
