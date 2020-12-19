package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    private ElementsCollection products = $$("p>a");
    private SelenideElement emptyCartButton = $(".clear-bag");
    private SelenideElement subtotalValue = $(".sums .surcharge-cell");
    private SelenideElement myAccountDropdown = $(".dropdown.header_bar-my_account>a");


    public boolean productsInCart(String productName) {
        return products.findBy(Condition.text(productName)).isDisplayed();
    }

    public boolean myAccountIsPresent() {
        return myAccountDropdown.exists();
    }

    public SelenideElement getSubtotalValue() {
        return subtotalValue;
    }

    public Double getMultipliedSubtotal(Double multipliedValue) {
        return Double.parseDouble(getSubtotalValue()
                .shouldHave(Condition.text(multipliedValue.toString())).getText().substring(1));

    }

    public void emptyCart() {
        emptyCartButton.shouldBe(Condition.visible).click();
        Selenide.switchTo().alert().accept();
    }

    public void setProductQuantity(String productName, String quantity) {
        SelenideElement productQuantity = getProductQuantityElement(productName);
        productQuantity.shouldBe(Condition.visible).clear();
        productQuantity.shouldBe(Condition.visible).sendKeys(quantity); //Using sendKeys instead of setValue to imitate user's behaviour
        productQuantity.shouldBe(Condition.visible).pressEnter();
    }

    public String getProductQuantity(String productName) {
        return getProductQuantityElement(productName).getValue();
    }

    public SelenideElement getProductQuantityElement(String productName) {
        return $(By.xpath("//a[contains(text(), " +
                "'" + productName + "')]//ancestor::tr//form//input[@title]"));
    }
}
