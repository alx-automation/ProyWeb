package com.ui.steps;

import com.ui.driver.BaseDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    private static BaseDriver bd = new BaseDriver();

    @Before
    public static void iniciarDriver() throws Exception {
        bd.inicializarDriver();
        Thread.sleep(5000);
    }

    @After
    public static void CerrarDriver() {
        bd.endDriver();
    }
}
