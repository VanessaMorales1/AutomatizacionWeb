package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MyStoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreStepDefs {
    private WebDriver driver;
    MyStoreSteps myStoreSteps;

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        myStoreSteps= new MyStoreSteps(driver);
        myStoreSteps.darClicSesion();
        myStoreSteps.typeUser(usuario);
        myStoreSteps.typePassword(clave);
        myStoreSteps.login();
        screenShot();

    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String cat, String sub) {
        myStoreSteps= new MyStoreSteps(driver);
        myStoreSteps.navegarCatYSub(cat,sub);
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) {
        myStoreSteps= new MyStoreSteps(driver);
        myStoreSteps.agregarProducto(unidades);
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        myStoreSteps= new MyStoreSteps(driver);
        myStoreSteps.validarPopUp();
    }
    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        myStoreSteps= new MyStoreSteps(driver);
        myStoreSteps.validarMonto();

    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        myStoreSteps= new MyStoreSteps(driver);
        myStoreSteps.finalizarCompra();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        myStoreSteps= new MyStoreSteps(driver);
        myStoreSteps.validarTitulo();

    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        myStoreSteps= new MyStoreSteps(driver);
        myStoreSteps.validarPrecioCarrito();
    }

}
