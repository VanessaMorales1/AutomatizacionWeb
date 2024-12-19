package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStorePage {
public static  By userInput= By.xpath("//*[@id=\"field-email\"]");
public static By passInput=By.xpath("//*[@id=\"field-password\"]");
public static By inicioSesionBtn=By.xpath("//*[@id=\"submit-login\"]");
public static By iniciarSesion=By.xpath("//*[@id=\"_desktop_user_info\"]/div/a");
public static By categoria=By.xpath("//*[@id=\"category-3\"]/a");
public static By subcategoria=By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a");
public static By producto=By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a");
public static By cantidad=By.xpath("//*[@id=\"quantity_wanted\"]");
public static By carritoBtn=By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
public static By montoTotal=By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
public static By precio=By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");
public static By popUp=By.xpath("//*[@id=\"myModalLabel\"]");
public static By cantidadComprada=By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[3]");
public static By finalizarCompraBtn=By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
public static By tituloCarrito=By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");
public static By precioCarrito=By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");
public static By cantidadCarrito=By.xpath("//*[@id=\"cart-subtotal-products\"]/span[1]");
public static By totalCarrito=By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");
public static By loginFallo=By.xpath("//*[@id=\"_desktop_user_info\"]/div");
}
