package com.ui.pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ui.utilities.ControlUserInterface;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ui.driver.BaseDriver;

public class EbaySearchPage extends BaseDriver {

    WebDriver driver;

    public EbaySearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    List<String> listaProductos= new ArrayList<>();
    List<String> listaPrecios= new ArrayList<>();

    ControlUserInterface controlUI = new ControlUserInterface();

    @FindBy(id = "gh-ac")
    private WebElement campoBusqueda;
    @FindBy(id = "gh-btn")
    private WebElement botonBuscar;
    @FindBy(xpath = "//span[text()='10']")
    private WebElement checkTalla;
    @FindBy(xpath = "//span[text()='PUMA']")
    private WebElement checkMarca;
    @FindBy(id = "w4-w12-0[0]")
    private WebElement campoMarcasDisponibles;
    @FindBy(xpath = "//*[@id='mainContent']/div[1]/div/div[2]//descendant::h1/span")
    private WebElement lblTotalResultado;
    @FindBy(xpath = "//span[@class='expand-btn__cell']/span[text()='Mejor resultado']")
    private WebElement cboOrdenamiento;
    @FindBy(xpath = "//span[text()='Precio + Envío: más alto primero']")
    private WebElement opcion;
    @FindBy(xpath = "//button/span[text()='2 filtros aplicados']")
    private WebElement botonFiltrosAplicados;


    @FindBy(xpath = "//div[@class='s-item__info clearfix']//h3")
    private List<WebElement> nombreProducto;
    @FindBy(xpath = "//div[@class='s-item__info clearfix']//span[@class='s-item__price']")
    private List<WebElement> precioProducto;
    

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
        do {
            encontrado = controlUI.esVisible(checkTalla);
            if (encontrado) {
                checkTalla.click();
            } else {
                controlUI.scrollDown();
            }
        } while (!encontrado);
        controlUI.esperaObjeto(checkMarca);
        checkMarca.click();
    }

    public void mostrarTotalResultadosBusqueda() {
        controlUI.esVisible(lblTotalResultado);
        System.out.println("Pregunta 5) Cantidad de resultados: " + lblTotalResultado.getText() + "\n");
    }

    public void seleccionarTipoOrdenamiento() {
        controlUI.esVisible(cboOrdenamiento);
        cboOrdenamiento.click();
        controlUI.estaPresente(opcion);
        opcion.click();
    }

    public void seleccionarItems(int cantidadItems) {
        controlUI.esVisible(botonFiltrosAplicados);
        AgregarItems(nombreProducto,listaProductos,cantidadItems);
        AgregarItems(precioProducto,listaPrecios,cantidadItems);
        System.out.println("----------(Pregunta 8)----------: INICIO");
        mostrarItems(listaProductos);
        mostrarItems(listaPrecios);
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
        Collections.sort(listaProductos);

        System.out.println("----------(Pregunta 9)----------: INICIO");
        mostrarItems(listaProductos);
        System.out.println("----------(Pregunta 9)----------: FIN\n");
    }

    public void ordenarItemsPorPrecio() {
        Comparator<String> comparador = Collections.reverseOrder();
        Collections.sort(listaPrecios, comparador);

        System.out.println("----------(Pregunta 10)----------: INICIO");
        mostrarItems(listaPrecios);
        System.out.println("----------(Pregunta 10)----------: FIN\n");
    }

    public void AgregarItems(List<WebElement> listaProductos, List<String> lista, int cantidadItems) {
        int i = 1;
        for (i = 1; i <= cantidadItems; i++) {
            lista.add(listaProductos.get(i).getText());
        }
    }

    public void mostrarItems(List<String> lista) {
        for (String list : lista) {
            System.out.println(list);
        }
    }

    public void validarMensaje(String mensaje) {
        Assert.assertEquals("Finalizado con éxito", mensaje, "finalizado ok");
    }
}
