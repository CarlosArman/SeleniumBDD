Feature: Footer

  Background: Precondicion de feature
    Given El usuario entra logeado a la pagina Shopping

  @regression
  Scenario: Verificar las redes sociales del footer
    Then El usuario verifica que los links sean correctos "https://twitter.com/saucelabs", "https://www.linkedin.com/company/sauce-labs/", "https://www.facebook.com/saucelabs"