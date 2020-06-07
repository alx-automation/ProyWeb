package com.ui.driver;

import com.ui.managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class BaseDriver {

    protected static WebDriver driver;
    WebDriverManager webDriverManager;

    public void iniciarDriver() {
        webDriverManager = new WebDriverManager();
        try {
            driver = webDriverManager.getDriver();
        } catch (WebDriverException wde) {
            System.out.println(wde.getMessage());
        }
    }

    public WebDriver obtenerDriver() {
        return driver;
    }

    public void finalizarDriver() {
        if (driver != null) {
            webDriverManager.closeDriver();
        }
    }
}
