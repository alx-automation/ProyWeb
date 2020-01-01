package com.ui.driver;

import com.ui.dataProviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {

    protected static WebDriver driver;
    ConfigFileReader configFileReader= new ConfigFileReader();

    public void inicializarDriver() {
        System.setProperty(configFileReader.obtenerChromeDriver(), configFileReader.obtenerChromeDriverPath());
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
