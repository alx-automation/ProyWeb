package com.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {

    protected static WebDriver driver;

    public void inicializarDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver");
        try {
            driver = new ChromeDriver();
        } catch (WebDriverException wde) {
            System.out.println(wde.getMessage());
        }
    }

    public void endDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }


}
