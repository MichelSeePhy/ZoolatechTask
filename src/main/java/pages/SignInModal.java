package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class SignInModal {

    private SelenideElement emailField = $("#login-email");
    private SelenideElement passwordField = $("#login-password");
    private SelenideElement signInButton = $("td>button");
    private SelenideElement openSignIn = $(".header_bar-sign_in>button");


    public void signIn(String email, String password) {
        openSignIn.shouldBe(Condition.visible).click();
        emailField.shouldBe(Condition.visible).sendKeys(email); //Using sendKeys instead of setValue to imitate user's behaviour
        passwordField.shouldBe(Condition.visible).sendKeys(password); //Using sendKeys instead of setValue to imitate user's behaviour
        signInButton.shouldBe(Condition.visible).click();
    }
}
