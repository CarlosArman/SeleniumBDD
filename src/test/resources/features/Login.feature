Feature: Login

  Background: Precondicion de login
    Given El usuario navega a la pagina de login

  @regression
  Scenario Outline: Credenciales invalidas
    When El usuario escribe las username "<username>" con password "<password>" y presiona el boton de login
    Then Debe aparecer un mensaje indicando "<mensajeError>"
    Examples:
      | username        | password     | mensajeError                                                              |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | hola mundo      | hola123      | Epic sadface: Username and password do not match any user in this service |


  @regression @smoke
  Scenario: Verificar la UI
    Then El usuario verifica que la UI tenga elementos correctos