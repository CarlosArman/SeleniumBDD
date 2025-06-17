package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ItemDetailPage;
import pages.ShoppingPage;
import utilities.CommonFlows;

public class ItemDetailStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final ItemDetailPage itemDetailPage = new ItemDetailPage();

    @Given("El usuario va al detalle del item llamado {string}")
    public void goToItemDetail(String itemName) {
        commonFlows.goToItemDetail(itemName);
    }

    @Then("El usuario verifica que la UI de la pagina del detalle de un item sea correcta")
    public void verifyItemDetailUI() {
        itemDetailPage.verifyPage();
    }

    @When("El usuario hace click en el boton Back to Products")
    public void clickBackToProducts() {
        itemDetailPage.clickBackToProducts();
    }

    @Then("La aplicacion redirige a la pagina Shopping")
    public void navigatesShoppingPage() {
        shoppingPage.waitPageToLoad();
        shoppingPage.verifyPage();
    }
}
