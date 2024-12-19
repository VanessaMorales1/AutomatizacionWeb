#language: es
@validarfeature
Característica: Login
  Yo, como usuario
  Quiero, tener una opción para validar precios


  @validar
  Esquema del escenario: Validacion del precio de un producto
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "<correo>" y clave "<clave>"
    Cuando navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito
    Ejemplos:
      | correo               | clave           | categoria | subcategoria |
      | vlmoralesy@gmail.com | Vanessalizbeth1 | CLOTHES   | Men          |
      | vmorales@outlook.com | 123456          | CLOTHES   | Men          |
      | vlmoralesy@gmail.com | Vanessalizbeth1 | AUTOS     | Men          |




