package com.ui.driver;

import com.ui.dataProviders.ConfigFileReader;
import com.ui.managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {

    protected static WebDriver driver;
    ConfigFileReader configFileReader= new ConfigFileReader();

    public void inicializarDriver() {
        System.setProperty(FileReaderManager.getInstance().getConfigReader().getChromeDriver(), FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
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
