package com.companyName.microservices.pages;

import org.openqa.selenium.By;

public class LoginPage {
    public LoginPage() {
    }

    public static By EMAIL_FIELD = By.id("okta-signin-username");
    public static By PASS_FIELD = By.id("okta-signin-password");
    public static By BTN_SIGN_IN = By.id("okta-signin-submit");
    public static By ALERT_ERROR = By.xpath("//div[@role='alert']");
    public static By ERROR_EMAIL = By.xpath("//input[@name='username']/../../p[@role='alert']");
    public static By ERROR_PASS = By.xpath("//input[@name='password']/../../p[@role='alert']");
    public static By REGISTER_BTN = By.xpath("//a[normalize-space()='Register']");
}
