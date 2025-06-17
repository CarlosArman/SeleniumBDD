package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.CommonFlows;

public class LoginStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final LoginPage loginPage = new LoginPage();

    @Given("El usuario navega a la pagina de login")
    public void goToLoginPage() {
        commonFlows.goToLoginPage();
    }

    @When("El usuario escribe las username {string} con password {string} y presiona el boton de login")
    public void fillLoginForm(String username, String password) {
        loginPage.fillLogin(username, password);
    }

    @Then("Debe aparecer un mensaje indicando {string}")
    public void verifyErrorMessage(String errorMessage) {
        loginPage.verifyErrorMessage(errorMessage);
    }

    @Then("El usuario verifica que la UI tenga elementos correctos")
    public void verifyUILogin() {
        loginPage.verifyPage();
    }


}
