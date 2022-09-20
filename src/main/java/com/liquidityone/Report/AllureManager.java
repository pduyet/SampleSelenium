package com.liquidityone.Report;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import com.liquidityone.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;

import static org.openqa.selenium.OutputType.BYTES;

public class AllureManager {
    public AllureManager() {}

    public static void setAllureEnvironmentInformation(String url, String browser, String env) {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Test url", url)
                        .put("Test browser", browser)
                        .put("Test environment", env)
                        .build());
    }


    @Attachment(value = "Failed test screenshot", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport() {
        try {
            return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new byte[0];
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
}
