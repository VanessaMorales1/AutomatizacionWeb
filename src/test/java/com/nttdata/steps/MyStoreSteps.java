package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyStoreSteps {
    private WebDriver driver;
    //constructor
    public MyStoreSteps(WebDriver driver){
        this.driver = driver;
    }

    public void darClicSesion(){
    this.driver.findElement(MyStorePage.iniciarSesion).click();    }
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(MyStorePage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.inicioSesionBtn));


    }
    public void typePassword(String password){
        this.driver.findElement(MyStorePage.passInput).sendKeys(password);

    }
    public void login(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            this.driver.findElement(MyStorePage.inicioSesionBtn).click();
            WebElement tituloElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.loginFallo));
            String titulo = tituloElement.getText();
            System.out.println(titulo);

            if (titulo.equals("\uE7FF Iniciar sesión")) {
                throw new AssertionError("Error: El login falló.");         }
        } catch (TimeoutException e) {
            throw new AssertionError("Error: El login falló.");
        }

    }


    public void navegarCatYSub(String cat, String sub) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        WebElement categoriaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.categoria));
        String categoria = categoriaElement.getText();
        System.out.println(categoria);
        if (!categoria.equals(cat)) {
            throw new NoSuchElementException("Categoría no es válida.");
        }

        this.driver.findElement(MyStorePage.categoria).click();
        WebElement subCategoriaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.subcategoria));
        String subCategoria = subCategoriaElement.getAttribute("title");
        System.out.println(subCategoria);

        if (!subCategoria.equals(sub)) {
            throw new NoSuchElementException("subCategoría no es válida.");
        }
        wait.until(ExpectedConditions.elementToBeClickable(MyStorePage.subcategoria)).click();
    }

    public void agregarProducto(int unidades) {
        this.driver.findElement(MyStorePage.producto).click();
        WebElement cantidadInputElement = driver.findElement(MyStorePage.cantidad);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.carritoBtn));
        cantidadInputElement.sendKeys( Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        cantidadInputElement.sendKeys(String.valueOf(unidades));
        this.driver.findElement(MyStorePage.carritoBtn).click();
    }

    public void validarMonto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement montoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.montoTotal));
        String montoTotal = montoElement.getText();
        String numMonto = montoTotal.replaceAll("[^0-9.]", "");
        WebElement cantidadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.cantidadComprada));
        String cantidad = cantidadElement.getText();
        String numCant = cantidad.replaceAll("[^0-9.]", "");
        WebElement precioElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.precio));
        String precio=precioElement.getText();
        String numPrecio = precio.replaceAll("[^0-9.]", "");

        double monto = Double.parseDouble(numMonto);
        System.out.println(monto);
        double cant = Double.parseDouble(numCant);
        System.out.println(cant);
        double prec =Double.parseDouble(numPrecio);
        System.out.println(prec);

        double total=cant*prec;
        System.out.println(total);
        Assertions.assertEquals(total, monto);

    }

    public void validarPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement popUpElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.popUp));
        String titulo = popUpElement.getText();
        Assertions.assertEquals("\uE876Producto añadido correctamente a su carrito de compra",titulo);
    }

    public void finalizarCompra() {
    this.driver.findElement(MyStorePage.finalizarCompraBtn).click();
    }

    public void validarTitulo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement tituloElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.tituloCarrito));
        String tituloCarrito = tituloElement.getText();
        Assertions.assertEquals("CARRITO",tituloCarrito);

    }

    public void validarPrecioCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        WebElement montoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.totalCarrito));
        String montoTotal = montoElement.getText();
        String numMonto = montoTotal.replaceAll("[^0-9.]", "");
         WebElement cantidadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.cantidadCarrito));
        String cantidad = cantidadElement.getText();
        String numCant = cantidad.replaceAll("[^0-9.]", "");
        WebElement precioElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.precioCarrito));
        String precio=precioElement.getText();
        String numPrecio = precio.replaceAll("[^0-9.]", "");

        double monto = Double.parseDouble(numMonto);
        System.out.println(montoTotal);
        double cant = Double.parseDouble(numCant);
        System.out.println(cant);
        double prec =Double.parseDouble(numPrecio);
        System.out.println(prec);

        double total=cant*prec;
        System.out.println(total);
        Assertions.assertEquals(total, monto);
    }
}
