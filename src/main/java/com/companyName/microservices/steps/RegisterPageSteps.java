package com.companyName.microservices.steps;

import com.companyName.Utils.WebUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.companyName.microservices.pages.RegisterPage.*;

public class RegisterPageSteps extends WebUI {

    @Step("Complete the sign-up form with email: {0}, country: {1}, phoneNumber: {2}")
    public RegisterPageSteps fill_Information(String email, String country, String phoneNumber) {
        sendKeys(EMAIL_FIELD, email);
        clickElement(COUNTRY_DROPDOWN);
        waitForElementIsPresence(COUNTRY_INPUT, 5);
        sendKeys(COUNTRY_INPUT, country);
        clickElement(COUNTRY_VALUE);
        sendKeys(PHONE_NUMBER_FIELD, phoneNumber);
        clickElement(POLICY_CHECKBOX);
        checkElementIsEnable(SUBMIT_BTN);
        clickElement(SUBMIT_BTN);
        return this;
    }

    @Step("Input country value is: {0}")
    public RegisterPageSteps enter_Country(String country) {
        clickElement(COUNTRY_DROPDOWN);
        waitForElementIsPresence(COUNTRY_INPUT, 5);
        sendKeys(COUNTRY_INPUT, country);
        return this;
    }

    @Step("Verify register successfully")
    public RegisterPageSteps verify_Register_Successfully() {
        waitForElementIsPresence(FORM_REGISTER_SUCCESSFULLY, 10);
        return this;
    }

    public List<String> get_All_Region_Code_Value() {
        clickElement(COUNTRY_DROPDOWN);
        List<WebElement> list_Country_Code_Value = get_List_Element(COUNTRY_VALUE);
        List<String> list_Value = new ArrayList<>();
        for (WebElement lCCV : list_Country_Code_Value) {
            list_Value.add(lCCV.getText());
        }
        return list_Value;
    }

    @Step("Verify total country value")
    public RegisterPageSteps verify_Number_Country_Value() {
        Assert.assertEquals(get_All_Region_Code_Value().size(), 242);
        return this;
    }

    @Step("Verify alert when email is empty")
    public RegisterPageSteps verify_Email_Is_Empty() {
        Assert.assertTrue(elementIsPresent(ALERT_ERROR_EMAIL));
        return this;
    }

    @Step("Verify alert when phone number is empty")
    public RegisterPageSteps verify_Phone_Number_Is_Empty() {
        Assert.assertTrue(elementIsPresent(ALERT_ERROR_PHONE_NUMBER));
        return this;
    }

    @Step("Verify alert when email is invalid")
    public RegisterPageSteps verify_Email_Is_Invalid() {
        Assert.assertTrue(elementIsPresent(ALERT_INVALID_EMAIL));
        return this;
    }

    @Step("Verify alert when phone number is invalid")
    public RegisterPageSteps verify_Phone_Number_Is_Invalid() {
        Assert.assertTrue(elementIsPresent(ALERT_INVALID_PHONE_NUMBER));
        return this;
    }

    @Step("Verify alert when country is invalid")
    public RegisterPageSteps verify_Invalid_Country() {
        Assert.assertTrue(elementIsPresent(ALERT_COUNTRY_NOT_FOUND));
        return this;
    }
}
