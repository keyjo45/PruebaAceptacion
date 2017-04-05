#Author: yosimar.valega@techandsolve.com
#Keywords Summary :
#Feature: Ingreso de Usuario.
#Ingreso de Usuario
@tag
Feature: Ingreso de Usuario
  Quiero ingresar al aplicativo Vuelos a traves de un usuario y contraseña

  @tag1
  Scenario Outline: Ingreso de Usuario
    Given ir a la pagina "http://192.168.1.181:9080/Vuelos/"
    When ingreso el email <email>
  	And ingreso el password <password>
    And presiono el boton Autenticar
    Then muestra pagina de bienvenida con el usuario <usuario>

    Examples: 
      | email              						| password   	 | usuario           | dato |
      | "oscar.mora@techandsolve.com" | "1234567890" | "OSCAR" 					 | "ok" |