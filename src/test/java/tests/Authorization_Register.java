package tests;

import base.BaseTest;
import com.liquidityone.microservices.steps.LoginPageSteps;
import com.liquidityone.microservices.steps.RegisterPageSteps;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.liquidityone.microservices.models.Constant.RegisterScreen.*;

public class Authorization_Register extends BaseTest {
    RegisterPageSteps registerPageSteps = new RegisterPageSteps();
    LoginPageSteps loginPageSteps = new LoginPageSteps();

    @Test(description = "Register successfully",enabled = false)
    public void Auth_Register01_Register_Successfully() {
        loginPageSteps.redirect_To_Register_Page();
        registerPageSteps.fill_Information(email, country, phone_number)
                .verify_Register_Successfully();
    }

    @Test(description = "Register unsuccessfully")
    @Description("Register with empty field")
    public void Auth_Register02_Register_With_Empty_Field() {
        loginPageSteps.redirect_To_Register_Page();
        registerPageSteps.fill_Information("", country, "")
                .verify_Email_Is_Empty()
                .verify_Phone_Number_Is_Empty();
    }

    @Test(description = "Register unsuccessfully")
    @Description("Register with invalid email")
    public void Auth_Register03_Register_With_Invalid_Email() {
        loginPageSteps.redirect_To_Register_Page();
        registerPageSteps.fill_Information(invalid_email, country, phone_number)
                .verify_Email_Is_Invalid();
    }

    @Test(description = "Register unsuccessfully")
    @Description("Register with invalid phone number")
    public void Auth_Register03_Register_With_Invalid_Phone_Number() {
        loginPageSteps.redirect_To_Register_Page();
        registerPageSteps.fill_Information(email, country, invalid_phone_number)
                .verify_Phone_Number_Is_Invalid();
    }

    @Test(description = "Register unsuccessfully")
    @Description("Register with invalid country")
    public void Auth_Register04_Register_With_Invalid_Country() {
        loginPageSteps.redirect_To_Register_Page();
        registerPageSteps.enter_Country(invalid_country)
                .verify_Invalid_Country();
    }

    @Test(description = "Verify total country value")
    @Description("Check total country value")
    public void Auth_Register05_Check_Total_Value_Region_Code() {
        loginPageSteps.redirect_To_Register_Page();
        registerPageSteps.verify_Number_Country_Value();
    }

}
