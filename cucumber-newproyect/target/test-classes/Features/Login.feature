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

  @wip
  Scenario: Realizo una busqueda de zapatos de talla 10 y marca PUMA en ebay
    Given ingreso a la siguiente direccion web "https://www.ebay.com/"
    And realizo una busqueda por "shoes"
    And selecciono la talla "10" y la marca "PUMA"
    And muestro el total de resultados
    And ordeno el resultado por precio ascendente
    When selecciono e imprimo los 5 primeros items
    And ordeno los items por nombre de forma ascendente
    And ordeno los items por precio de forma descendente
    Then se muestra mensaje de "finalizado ok"


