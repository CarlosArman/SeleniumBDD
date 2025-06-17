Feature: Shopping

  Background: Precondicion de login
    Given El usuario entra logeado a la pagina Shopping

  @regression @smoke
  Scenario: Verifica la UI
    Then El usuario verifica que la UI de la pagina Shopping sea correcta

  @regression
  Scenario: Verificar Precios
    When Leo los productos esperados de Excel
    Then Verifico que los productos de Excel sean los mismos que de la pagina