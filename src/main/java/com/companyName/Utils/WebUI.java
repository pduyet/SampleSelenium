package com.companyName.Utils;

import com.companyName.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.List;

public class WebUI {
    static WebDriverWait wait;
    JavascriptExecutor js;
    Action action;
    Robot robot;
    public void getToUrl(String url) {
        DriverManager.getDriver().get(url);
    }

    public void clickElement(By by) {
        DriverManager.getDriver().findElement(by).click();
    }

    public void sendKeys(By by, String value) {
        clickElement(by);
        DriverManager.getDriver().findElement(by).sendKeys(value);
    }

    public void uploadFile(By by, String value) {
        DriverManager.getDriver().findElement(by).sendKeys(value);
    }

    public void selectElementByIndex(By by, int index) {
        Select slc = new Select(DriverManager.getDriver().findElement(by));
        slc.selectByIndex(index);
    }

    public List<WebElement> get_List_Element(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public void selectElementByValue(By by, String value) {
        Select slc = new Select(DriverManager.getDriver().findElement(by));
        slc.selectByValue(value);
    }

    public String getValueOfElement(By by) {
        return DriverManager.getDriver().findElement(by).getAttribute("value");
    }

    public void selectElementByVisibleText(By by, String text) {
        Select select = new Select(DriverManager.getDriver().findElement(by));
        select.selectByVisibleText(text);
    }

    public boolean elementIsPresent(By by) {
        try {
            DriverManager.getDriver().findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForElementIsPresence(By by, int time) {
        try {
            wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout for wait element: " + by.toString() + " on " + time);
            System.out.println(error.getMessage());
        }
    }

    public boolean checkElementIsEnable(By by) {
        if (DriverManager.getDriver().findElement(by).isEnabled()) {
            return true;
        } else return false;
    }

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
