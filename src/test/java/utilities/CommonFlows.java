package utilities;

import data.DataGiver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.*;

public class CommonFlows {

    final String url = "https://www.saucedemo.com/";
    final String url2 = "https://www.saucedemo.com/404";

    private WebDriver getDriver() {
        return new WebdriverProvider().get();
    }

    private void assignLoginCookie() {
        Logs.debug("Asignando la cookie de login");
        getDriver().get(url2);
        final var credentialesValidos = DataGiver.getValidCredentials();
        final var loginCookie = new Cookie("session-username", credentialesValidos.getUsername());
        getDriver().manage().addCookie(loginCookie);
    }

    public void goToLoginPage() {
        Logs.info("Navegando a la pagina: %s.", url);
        getDriver().get(url);
        new LoginPage().waitPageToLoad();
    }

    public void goToShoppingPage() {
        // goToLoginPage();
        // final var validCredentials = DataGiver.getValidCredentials();
        // new LoginPage().fillLogin(validCredentials.getUsername(), validCredentials.getPassword());
        assignLoginCookie();
        getDriver().get("https://www.saucedemo.com/inventory.html");
        new ShoppingPage().waitPageToLoad();
    }

    public void openBurgerMenu() {
        goToShoppingPage();
        new TopBar().waitPageToLoad();
        new TopBar().openMenuBurger();
        new MenuBurger().waitPageToLoad();
    }

    public void goToItemDetail(String itemName) {
        goToShoppingPage();
        new ShoppingPage().goToItemDetail(itemName);
        new ItemDetailPage().waitPageToLoad();
    }

    public void goToYourCartPage() {
        goToShoppingPage();
        new TopBar().clickShoppingCart();
        new YourCartPage().waitPageToLoad();
    }

    public void goYourInformationPage() {
        goToYourCartPage();
        new YourCartPage().clickCheckout();
        new YourInformationPage().waitPageToLoad();
    }
}
