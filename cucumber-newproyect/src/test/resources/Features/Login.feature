@AutomationExam
Feature: Compra de productos en eBay
  1- Enter to Ebay
  2- Search for shoes
  3- Select brand PUMA
  4- Select size 10
  5- Print the number of results

  6- Order by price ascendant
  7- Assert the order taking the first 5 results
  8- Take the first 5 products with their prices and print them in console.
  9- Order and print the products by name (ascendant)
  10- Order and print the products by price in descendant mode
  11- Repository must be created in any git place (github, bitbucket, etc)
  12- Code must run in any CI tool.
  13- Report should be sent by mail.

  @Preguntas_1_5
  Scenario: Realizo una busqueda de zapatos en ebay de talla 10 y marca puma
    Given ingreso a la siguiente direccion web "https://www.ebay.com/"
    And realizo una busqueda por "shoes"
    When selecciono la talla "10" y la marca "PUMA"
    Then muestro el total de resultados

  @tag
  Scenario: Resolución de preguntas seis hasta diez
    Given que elijo la opcion "Precio + Envío: más bajo primero"
    When selecciono los 5 primeros items para realizar un pedido
    And ordeno los items por nombre de forma ascendente
    And ordeno los items por precio de forma descendente
    Then se muestra mensaje de "finalizado ok"
