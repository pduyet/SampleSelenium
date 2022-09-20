package com.companyName.microservices.steps;

import com.companyName.Utils.WebUI;
import io.qameta.allure.Step;

import static com.companyName.microservices.pages.HomePage.*;

public class HomePageSteps extends WebUI {

    @Step("Verify login successfully")
    public void verify_Login_Successfully() {
        waitForElementIsPresence(MENU_NAVBAR, 20);
    }
}
