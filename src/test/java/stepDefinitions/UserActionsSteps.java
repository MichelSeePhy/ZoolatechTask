package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.MainPage;
import pages.SignInModal;

import static data.UsersCredentials.EMAIL;
import static data.UsersCredentials.PASSWORD;

public class UserActionsSteps {

    SignInModal signInModal = new SignInModal();
    MainPage mainPage = new MainPage();

    @Given("I open main page")
    public void openMainPage() {
        mainPage.openPage();
    }

    @Then("^I Log in as existing user$")
    public void logInAsExistingUser() throws InterruptedException {
        signInModal.signIn(EMAIL, PASSWORD);
    }


}
