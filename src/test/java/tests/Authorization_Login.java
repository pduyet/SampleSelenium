package tests;

import base.BaseTest;
import com.liquidityone.microservices.steps.HomePageSteps;
import com.liquidityone.microservices.steps.LoginPageSteps;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.liquidityone.microservices.models.Constant.LoginScreen.*;

public class Authorization_Login extends BaseTest {
    HomePageSteps homePageSteps = new HomePageSteps();
    LoginPageSteps loginPageSteps = new LoginPageSteps();


    @Test(description = "login successfully")
    public void Auth_Login01_Login_Successfully() {
        loginPageSteps.fill_Email_Password(email, pass)
                .login_With_Valid_User();
        homePageSteps.verify_Login_Successfully();
    }

    @Test(description = "login unsuccessfully")
    @Description("login with empty all fields")
    public void Auth_Login02_Login_Unsuccessfully_With_Empty_All_Fields() {
        loginPageSteps.fill_Email_Password("", "")
                .verify_Alert_Error()
                .verify_Message_Error_Email()
                .verify_Message_Error_Pass();
    }

    @Test(description = "login unsuccessfully")
    @Description("login with empty email")
    public void Auth_Login02_01_Login_Unsuccessfully_With_Empty_Email() {
        loginPageSteps.fill_Email_Password("", pass)
                .verify_Message_Error_Email()
                .verify_Alert_Error();
    }

    @Test(description = "login unsuccessfully")
    @Description("login with empty pass")
    public void Auth_Login02_02_Login_Unsuccessfully_With_Empty_Pass() {
        loginPageSteps.fill_Email_Password(email, "")
                .verify_Alert_Error()
                .verify_Message_Error_Pass();
    }

    @Test(description = "login unsuccessfully")
    @Description("login with unregistered email")
    public void Auth_Login03_Login_Unsuccessfully_With_Unregistered_Email() {
        loginPageSteps.fill_Email_Password(unregistered_email, pass)
                .verify_Alert_Error();
    }

    @Test(description = "login unsuccessfully")
    @Description("login with invalid email")
    public void Auth_Login04_Login_Unsuccessfully_With_Invalid_Email() {
        loginPageSteps.fill_Email_Password(invalid_email, pass)
                .verify_Alert_Error();
    }

    @Test(description = "login unsuccessfully")
    @Description("login with invalid password")
    public void Auth_Login05_Login_Unsuccessfully_With_Invalid_Password() {
        loginPageSteps.fill_Email_Password(email, invalid_password)
                .verify_Alert_Error();
    }
}
