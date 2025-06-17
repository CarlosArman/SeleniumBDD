Feature: Burger Menu

  Background: Precondicion del feature
    Given El usuario entra logeado y abre el burger menu

  @regression @smoke
  Scenario: Logout
    When El usuario hace click en la opcion de logout
    Then la aplicacion redirige a la pagina de Login

  Scenario: About
    Then El usuario verifica que la opcion de About tenga el link correcto de "https://saucelabs.com/"
