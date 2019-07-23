package com.ui.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.driver.BaseDriver;

public class PageImplementation extends BaseDriver {

	private By cpoBusqueda = By.xpath("//*[@id=\'gh-ac\']");
	private By btnBuscar = By.xpath("//*[@id=\'gh-btn\']");
	private By lblTalla = By.xpath("//*[@id=\'w3\']/li[1]/ul/li[2]/ul/li[1]/ul/li[5]/div/a/span[1]");
	private By cpoBuscarMarca = By.xpath("//*[@id=\'w3-w3-0[0]\']");
	private By lblMarca = By.xpath("//*[@id=\'w3-w3\']/ul/li[7]/div/a/span[1]");
	private By lblTotalResultado = By.xpath("//*[@id=\'mainContent\']/div[1]/div/div[2]/div/div[1]/h1");
	private By cboOrdenamiento = By.xpath("//*[@id=\'w7\']/button/div/div");
	private By opcion = By.xpath("//*[@id=\'w7\']/div/div/ul/li[4]/a/span");
	
//	private By talla = By.xpath("//*[@id=\'msku-sel-1\']");
//	private By opcionTalla = By.xpath("//*[@id=\'msku-opt-5\']");
//	private By campoCantidad = By.xpath("//*[@id=\'qtyTextBox\']");
//	private By btnComprar = By.xpath("//*[@id=\"binBtn_btn\"]");
//	private By btnCompletarCompra = By.xpath("//*[@id=\"sbin-gxo-btn\"]");
	
//	private By btnVolver = By.xpath("//*[@id=\"smtBackToAnchorArrow\"]/span");
	
	private ArrayList<String> listaNombres = new ArrayList<String>();
	private ArrayList<String> listaPrecios = new ArrayList<String>();
	

	public void buscarDireccionWeb(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void realizarBusquedaArticulo(String articulo) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(cpoBusqueda));

		driver.findElement(cpoBusqueda).sendKeys(articulo);
		driver.findElement(btnBuscar).click();

	}

	public void seleccionarOpciones(String talla, String marca) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(lblTalla));
		driver.findElement(lblTalla).click();

		driver.findElement(cpoBuscarMarca).sendKeys(marca);
		wait.until(ExpectedConditions.elementToBeClickable(lblMarca));
		driver.findElement(lblMarca).click();
	}

	public void mostrarTotalResultadosBusqueda() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(lblTotalResultado));
		System.out.println("Pregunta 5) Cantidad de resultados: " + driver.findElement(lblTotalResultado).getText() + "\n");
	}

	public void seleccionarTipoOrdenamiento(String orden) throws InterruptedException {
		WebElement elemento = driver.findElement(cboOrdenamiento);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", elemento);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(opcion));

		WebElement opcionOrden = driver.findElement(opcion);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", opcionOrden);

		Thread.sleep(5000);
	}

	public void seleccionarItems(Integer cantidadItems) throws InterruptedException {
		String cadena = "";
		By nombreArticulo;
		By precioArticulo;
		int i = 1;

		for (i = 1; i <= cantidadItems; i++) {
			nombreArticulo = By.xpath("//*[@id=\'srp-river-results-listing" + i + "\']/div/div[2]/a/h3");
			precioArticulo = By.xpath("//*[@id=\'srp-river-results-listing" + i + "\']/div/div[2]/div[3]/div[1]/span");
			cadena += "Producto " + i + ": " + driver.findElement(nombreArticulo).getText() + "\n" +
					  "Precio   " + i + ": " + driver.findElement(precioArticulo).getText();
			
			listaNombres.add(driver.findElement(nombreArticulo).getText());
			listaPrecios.add(driver.findElement(precioArticulo).getText());

//			comprarArticulo();
//			System.out.println(imageItem);
		}
		System.out.println("----------(Pregunta 8)----------: INICIO");
		System.out.println(cadena);
		System.out.println("----------(Pregunta 8)----------: FIN\n");

	}

//	private void comprarArticulo() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.elementToBeClickable(talla));
//		driver.findElement(talla).click();
//		
//		wait.until(ExpectedConditions.elementToBeClickable(opcionTalla));
//		driver.findElement(opcionTalla).click();
//		driver.findElement(campoCantidad).click();
//		driver.findElement(btnVolver).click();
		
/*
 * Esta sección no me conlleva a hacer nada nuevo a nivel de scripts, por eso y por el tiempo no considere necesario realizarla.
 */
		
//		wait.until(ExpectedConditions.elementToBeClickable(btnComprar));
//		driver.findElement(btnComprar).click();
//		
//		wait.until(ExpectedConditions.elementToBeClickable(btnCompletarCompra));
//		driver.findElement(btnCompletarCompra).click();
		
//	}

	public void ordenarItemsPorNombre() {
		Collections.sort(listaNombres);
		
		System.out.println("----------(Pregunta 9)----------: INICIO");
		mostrarItems(listaNombres);
		System.out.println("----------(Pregunta 9)----------: FIN\n");
	}

	public void ordenarItemsPorPrecio() {
		Comparator<String> comparador = Collections.reverseOrder();
		Collections.sort(listaPrecios, comparador);
		
		System.out.println("----------(Pregunta 10)----------: INICIO");
		mostrarItems(listaPrecios);
		System.out.println("----------(Pregunta 10)----------: FIN\n");
	}
	
	public void mostrarItems(ArrayList<String> lista) {
		for(String list : lista) {
			System.out.println(list);
		}
	}

	public void validarMensaje(String mensaje) {
		Assert.assertEquals("Finalizado con éxito", mensaje, "finalizado ok");
	}
}
