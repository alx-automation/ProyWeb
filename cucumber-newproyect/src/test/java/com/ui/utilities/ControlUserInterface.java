package com.ui.utilities;

import com.ui.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlUserInterface extends BaseDriver {

    public void esperaObjeto(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(elemento));
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
    }

    public boolean esVisible(WebElement elemento) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void estaPresente(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(elemento));

    }

    public static By updateXpath(By by, String addValue) {
        String auxXpath = by.toString();
        auxXpath = auxXpath.substring(auxXpath.indexOf("//"));
        auxXpath = String.format(auxXpath, addValue);
        return By.xpath(auxXpath);
    }

}