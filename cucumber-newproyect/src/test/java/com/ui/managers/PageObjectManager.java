package com.ui.managers;

import com.ui.pageObjects.EbaySearchPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private EbaySearchPage ebaySearchPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public EbaySearchPage obtenerEbaySearchPage(){
        return (ebaySearchPage == null) ? ebaySearchPage = new EbaySearchPage(driver) : ebaySearchPage;
    }
}