package com.companyName.microservices.pages;

import org.openqa.selenium.By;

public class RegisterPage {
    public RegisterPage(){
    }

    public static By EMAIL_FIELD = By.xpath("//label[normalize-space()='Email']/..//input");
    public static By COUNTRY_DROPDOWN = By.id("dropdown-basic");
    public static By COUNTRY_INPUT = By.xpath("//button[@id='dropdown-basic']/..//input");
    public static By COUNTRY_VALUE = By.xpath("//button[@id='dropdown-basic']/..//ul/a");
    public static By PHONE_NUMBER_FIELD = By.name("phoneNumber");
    public static By POLICY_CHECKBOX = By.xpath("//label[@data-testid='checkbox-container']/div");
    public static By SUBMIT_BTN = By.xpath("//button[@type='submit']");

    public static By FORM_REGISTER_SUCCESSFULLY = By.xpath("//h1[normalize-space()='Check Your Email']");

    public static By ALERT_ERROR_EMAIL = By.xpath("//div[normalize-space()='Please enter your email address.']");
    public static By ALERT_INVALID_EMAIL = By.xpath("//div[normalize-space()='Please enter a valid email address.']");
    public static By ALERT_ERROR_PHONE_NUMBER = By.xpath("//div[contains(text(),'Invalid phone number.')]");
    public static By ALERT_INVALID_PHONE_NUMBER = By.xpath("//div[contains(text(),'Invalid phone number.')]");
    public static By ALERT_COUNTRY_NOT_FOUND = By.xpath("//p[normalize-space()='Not found!']");
}
