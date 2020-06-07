package com.ui.pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.ui.utilities.ControlUserInterface;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ui.driver.BaseDriver;

import static java.lang.Thread.sleep;

public class EbaySearchPage extends BaseDriver {

    WebDriver driver;

    public EbaySearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private ArrayList<String> listaNombres = new ArrayList<String>();
    private ArrayList<String> listaPrecios = new ArrayList<String>();

    ControlUserInterface controlUI = new ControlUserInterface();

    @FindBy(id = "gh-ac")
    private WebElement campoBusqueda;
    @FindBy(id = "gh-btn")
    private WebElement botonBuscar;
    @FindBy(xpath = "//*[@id='w4']//*[text()='10']")
    private WebElement checkTalla;
    @FindBy(id = "w4-w12-0[0]")
    private WebElement campoMarcasDisponibles;
    @FindBy(xpath = "//*[@id='w4']//*[@id='w4-w12']//*[text()='PUMA']")
    private WebElement checkMarca;
    @FindBy(xpath = "//*[@id='mainContent']/div[1]/div/div[2]//descendant::h1/span")
    private WebElement lblTotalResultado;
    @FindBy(xpath = "//div[@id='w9']//button")
    private WebElement cboOrdenamiento;

    @FindBy(xpath = "//*[@id='w9']/div/descendant::li[4]//span")
    private WebElement opcion;
    @FindBy(xpath = "///div[@id='srp-river-results']")
    private WebElement botonFiltrosAplicados;


    private By talla = By.xpath("//*[@id=\'msku-sel-1\']");
    private By opcionTalla = By.xpath("//*[@id=\'msku-opt-5\']");


    private By lblTituloFuncionalidad = By.xpath("//android.widget.TextView[@text='%s']");


//	private By campoCantidad = By.xpath("//*[@id=\'qtyTextBox\']");
//	private By btnComprar = By.xpath("//*[@id=\"binBtn_btn\"]");
//	private By btnCompletarCompra = By.xpath("//*[@id=\"sbin-gxo-btn\"]");

//	private By btnVolver = By.xpath("//*[@id=\"smtBackToAnchorArrow\"]/span");

    public void ingresarDireccionWeb(String url) {
        driver.get(url);
    }

    public void realizarBusquedaProducto(String producto) {
        controlUI.esperaObjeto(campoBusqueda);
        campoBusqueda.sendKeys(producto);
        botonBuscar.click();
    }

    public void elegirFlitrosBusqueda(String talla, String marca) {
        boolean encontrado;
        controlUI.esperaObjeto(campoMarcasDisponibles);
        campoMarcasDisponibles.sendKeys(marca);
        controlUI.esperaObjeto(checkMarca);
        checkMarca.click();
        do {
            encontrado = controlUI.esVisible(checkTalla);
            if (encontrado) {
                checkTalla.click();
            } else {
                controlUI.scrollDown();
            }
        } while (!encontrado);
    }

    public void mostrarTotalResultadosBusqueda() {
        controlUI.esVisible(lblTotalResultado);
        System.out.println("Pregunta 5) Cantidad de resultados: " + lblTotalResultado.getText() + "\n");
    }

    public void seleccionarTipoOrdenamiento() throws InterruptedException {
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", cboOrdenamiento);
        controlUI.estaPresente(opcion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", opcion);
    }

    public void seleccionarItems(int cantidadItems) throws InterruptedException {
        String cadena = "";
        By nombreArticulo;
        By precioArticulo;
        int i = 1;
        int j = 0;

        controlUI.esperaObjeto(botonFiltrosAplicados);

        for (i = 1; i <= cantidadItems; i++) {
            nombreArticulo = By.xpath("//*[@id='srp-river-results-listing" + i + "']/descendant::h3");
            precioArticulo = By.xpath("//*[@id='srp-river-results-listing" + i + "']/descendant::span[2]");
//            cadena += "Producto " + i + ": " + driver.findElement(nombreArticulo).getText() + "\n" +
//                    "Precio   " + i + ": " + driver.findElement(precioArticulo).getText() + "\n";

            listaNombres.add(driver.findElement(nombreArticulo).getText());
            listaPrecios.add(driver.findElement(precioArticulo).getText());
        }
//        System.out.println("----------(Pregunta 8)----------: INICIO");
//        System.out.println(cadena);
//        System.out.println("----------(Pregunta 8)----------: FIN\n");

        for (String lista : listaNombres) {
            System.out.println(lista);
            System.out.println(listaPrecios.get(j));
            j++;
        }

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
        for (String list : lista) {
            System.out.println(list);
        }
    }

    public void validarMensaje(String mensaje) {
        Assert.assertEquals("Finalizado con éxito", mensaje, "finalizado ok");
    }
}
