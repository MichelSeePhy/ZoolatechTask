package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static data.Constants.*;

import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    private SelenideElement searchField = $(By.name("substring"));
    private ElementsCollection productPrices = $$(".price.product-price");

    public void openPage() {
        open(BASE_URL);
    }

    public void openPage(String path) {
        open(BASE_URL + path);
    }

    public ElementsCollection getAllPrices() {
        return productPrices;
    }

    public void searchForProduct(String product) {
        searchField.shouldBe(Condition.visible).sendKeys(product); //Using sendKeys instead of setValue to imitate user's behaviour
        searchField.shouldBe(Condition.visible).pressEnter();
    }

}
