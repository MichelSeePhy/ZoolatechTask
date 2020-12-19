package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AddProductModal {

    private SelenideElement viewCartButton =  $("div.item-buttons>a");

    public void viewCartFromModal() {
       viewCartButton.click();
    }

}
