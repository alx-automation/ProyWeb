package com.ui.utilities;

import com.ui.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlUserInterface extends BaseDriver {

    public boolean esperaObjeto(WebElement Elemento) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(Elemento));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public static void esperaObjeto(By Elemento) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(Elemento));
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
    }

    public boolean esVisible(WebElement Elemento) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(Elemento));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}