package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;


public class CartSteps {

    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();
    private String productSubtotal;

    @Then("^I verify the (.*) added to the cart$")
    public void productAddedToCart(String product) {
        assertThat(cartPage.productsInCart(product)).isTrue();
    }

    @When("^I verify that subtotal is present$")
    public void subtotalIsPresent() {
        assertThat(cartPage.getSubtotalValue().isDisplayed()).isTrue();
        productSubtotal = cartPage.getSubtotalValue().getText().substring(1);
    }

    @Then("^I change (.*) quantity to (.*)$")
    public void changeProductQuantity(String productName, String quantity) {
        cartPage.setProductQuantity(productName, quantity);
    }

    @Then("^I verify that subtotal value has multiplied by (.*)$")
    public void verifyChangedSubtotal(int amount) {
        Double multipliedSubtotal = Double.parseDouble(productSubtotal) * amount;
        Double expectedSubtotal = cartPage.getMultipliedSubtotal(multipliedSubtotal);
        assertThat(multipliedSubtotal).isEqualTo(expectedSubtotal);
    }

    @Given("^Open cart page$")
    public void openCartPage() {
        mainPage.openPage("?target=cart");
    }

    @And("^Empty the cart$")
    public void emptyCart() {
        cartPage.emptyCart();
    }

    @And("^I Verify carts of anonymous and logged in user are merged \\((.*) of (.*) are present in cart\\)$")
    public void verifyMergedInfoOfAnonymousUser(String quantity, String productName) {
        mainPage.openPage("?target=cart"); // to make this step reusable from any part of the website.
        assertThat(cartPage.getProductQuantity(productName)).isEqualTo(quantity);
        assertThat(cartPage.myAccountIsPresent()).isTrue();
    }
}
