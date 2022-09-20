package com.companyName.microservices.steps;

import com.companyName.Utils.WebUI;
import com.companyName.microservices.pages.HomePage;
import com.companyName.microservices.pages.RegisterPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.companyName.microservices.pages.LoginPage.*;

public class LoginPageSteps extends WebUI {

    @Step("login into the system with email: {0} and password: {1}")
    public LoginPageSteps fill_Email_Password(String email, String pass) {
        sendKeys(EMAIL_FIELD, email);
        sendKeys(PASS_FIELD, pass);
        clickElement(BTN_SIGN_IN);
        return this;
    }

    @Step("Login successfully. Redirect to home page")
    public HomePage login_With_Valid_User() {
        return new HomePage();
    }

    @Step("Click register button. Redirect to register page")
    public RegisterPage redirect_To_Register_Page() {
        clickElement(REGISTER_BTN);
        return new RegisterPage();
    }

    @Step("Verify login unsuccessfully")
    public LoginPageSteps verify_Alert_Error() {
        Assert.assertTrue(elementIsPresent(ALERT_ERROR));
        return this;
    }

    @Step("Verify error when login with error email")
    public LoginPageSteps verify_Message_Error_Email() {
        Assert.assertTrue(elementIsPresent(ERROR_EMAIL));
        return this;
    }

    @Step("Verify error when login with error password")
    public LoginPageSteps verify_Message_Error_Pass() {
        Assert.assertTrue(elementIsPresent(ERROR_PASS));
        return this;
    }

}
