@Prueba
Feature: Title of your feature
  I want to use this template for my feature file

  Background: Resolver preguntas de uno al cinco
    Given ingreso a la siguiente direccion web "https://www.ebay.com/"
    And realizo una busqueda por "shoes"
    When selecciono la talla "10" y la marca "PUMA"
    Then observo el total de resultados

  @tag1
  Scenario: Resolución de preguntas seis hasta diez
  	Given que elijo la opcion "Precio + Envío: más bajo primero"
  	When selecciono los 5 primeros items para realizar un pedido
  	And ordeno los items por nombre de forma ascendente
  	And ordeno los items por precio de forma descendente 
  	Then se muestra mensaje de "finalizado ok"
  	 