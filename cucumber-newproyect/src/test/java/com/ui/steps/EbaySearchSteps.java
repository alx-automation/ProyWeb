package com.ui.steps;

import com.ui.driver.BaseDriver;
import com.ui.managers.PageObjectManager;
import com.ui.pageObjects.EbaySearchPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EbaySearchSteps {
    BaseDriver bd = new BaseDriver();
    PageObjectManager pageObjectManager = new PageObjectManager(bd.obtenerDriver());
    EbaySearchPage ebaySearchPage = pageObjectManager.obtenerEbaySearchPage();

    @Given("ingreso a la siguiente direccion web {string}")
    public void ingreso_a_la_siguiente_direccion_web(String url) {
        ebaySearchPage.ingresarDireccionWeb(url);
    }

    @Given("realizo una busqueda por {string}")
    public void realizo_una_busqueda_por(String producto) {
        ebaySearchPage.realizarBusquedaProducto(producto);
    }

    @When("selecciono la talla {string} y la marca {string}")
    public void selecciono_la_talla_y_la_marca(String talla, String marca) {
        ebaySearchPage.elegirFlitrosBusqueda(talla, marca);
    }

    @Then("muestro el total de resultados")
    public void observo_el_total_de_resultados() {
        ebaySearchPage.mostrarTotalResultadosBusqueda();
    }

    @When("selecciono e imprimo los {int} primeros items")
    public void selecciono_los_primeros_items_para_realizar_un_pedido(int cantidadItems) {
        ebaySearchPage.seleccionarItems(cantidadItems);
    }

    @When("ordeno los items por nombre de forma ascendente")
    public void ordeno_los_items_por_nombre_de_forma_ascendente() {
        ebaySearchPage.ordenarItemsPorNombre();
    }

    @When("ordeno los items por precio de forma descendente")
    public void ordeno_los_items_por_precio_de_forma_descendente() {
        ebaySearchPage.ordenarItemsPorPrecio();
    }

    @Then("se muestra mensaje de {string}")
    public void se_muestra_mensaje_de(String mensaje) {
        ebaySearchPage.validarMensaje(mensaje);
    }

    @And("ordeno el resultado por precio ascendente")
    public void ordenoElResultadoDeOrPrecioAscendente() {
        ebaySearchPage.seleccionarTipoOrdenamiento();
    }
}
