package com.ui.steps;

import com.ui.page.PageImplementation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {

    PageImplementation pageImplementation = new PageImplementation();
	@Given("ingreso a la siguiente direccion web {string}")
	public void ingreso_a_la_siguiente_direccion_web(String url) {
		pageImplementation.buscarDireccionWeb(url);
	}
	
	@Given("realizo una busqueda por {string}")
	public void realizo_una_busqueda_por(String shoes) {
	    pageImplementation.realizarBusquedaArticulo(shoes);
	}
	
	@When("selecciono la talla {string} y la marca {string}")
	public void selecciono_la_talla_y_la_marca(String talla, String marca) {
	    pageImplementation.seleccionarOpciones(talla, marca);
	}
	
	@Then("observo el total de resultados")
	public void observo_el_total_de_resultados() {
	   pageImplementation.mostrarTotalResultadosBusqueda();
	}

	@Given("que elijo la opcion {string}")
	public void que_elijo_la_opcion(String string) throws InterruptedException {
	    pageImplementation.seleccionarTipoOrdenamiento(string);
	}
	
	@When("selecciono los {int} primeros items para realizar un pedido")
	public void selecciono_los_primeros_items_para_realizar_un_pedido(Integer cantidadItems) throws InterruptedException {
	    pageImplementation.seleccionarItems(cantidadItems);
	}
	
	@When("ordeno los items por nombre de forma ascendente")
	public void ordeno_los_items_por_nombre_de_forma_ascendente() {
	    pageImplementation.ordenarItemsPorNombre();
	}
	
	@When("ordeno los items por precio de forma descendente")
	public void ordeno_los_items_por_precio_de_forma_descendente() {
	    pageImplementation.ordenarItemsPorPrecio();
	}

	@Then("se muestra mensaje de {string}")
	public void se_muestra_mensaje_de(String mensaje) {
	    pageImplementation.validarMensaje(mensaje);
	}
}
