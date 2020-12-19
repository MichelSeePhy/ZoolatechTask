package pages;

import static com.codeborne.selenide.Selenide.$;

public class AddProductModal {

    public void viewCartFromModal() {
        $("div.item-buttons>a").click();
    }

}
