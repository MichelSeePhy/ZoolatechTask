package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CatalogPage;
import pages.MainPage;
import pages.AddProductModal;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.actions;
import static org.assertj.core.api.Assertions.assertThat;


public class CatalogSteps {

    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    AddProductModal addProductModal = new AddProductModal();

    @Then("^I use search to find product: (.*)$")
    public void searchProduct(String product) {
        mainPage.searchForProduct(product);
        assertThat(catalogPage.productsInCatalog()).contains(catalogPage.productsInCatalog()
                .findBy(Condition.text(product)));
    }

    @Then("I verify that dollar symbol is present before each price tag")
    public void verifyDollarSymbolPresence() {
        for (SelenideElement e : mainPage.getAllPrices()) {
            assertThat(e.getText()).startsWith("$");
        }
    }

    @Then("^I add a (.*) to the cart$")
    public void addProductToCart(String product) {
        actions().moveToElement(catalogPage.productsInCatalog()
                .findBy(Condition.text(product))).perform();
        catalogPage.addProductToCart(product);
    }
    @And("^I proceed to cart from modal window$")
    public void moveToCartFromModalWindow() {
        addProductModal.viewCartFromModal();
    }
}