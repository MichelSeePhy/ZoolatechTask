package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {

    private ElementsCollection productsInCatalog = $$(".fn.url");

    public ElementsCollection productsInCatalog() {
        return productsInCatalog;
    }

    public void addProductToCart(String productName) {
        $(By.xpath("//h5//a[contains(text(), '"
                + productName + "')]//ancestor::div[1]//button")).click();
    }
}
