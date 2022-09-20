package com.liquidityone.microservices.steps;

import com.liquidityone.Utils.WebUI;
import io.qameta.allure.Step;

import static com.liquidityone.microservices.pages.HomePage.*;

public class HomePageSteps extends WebUI {

    @Step("Verify login successfully")
    public void verify_Login_Successfully() {
        waitForElementIsPresence(MENU_NAVBAR, 20);
    }
}
