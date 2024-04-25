package tek.bdd.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.SignInPage;
import tek.bdd.utility.SeleniumUtilities;

public class SecurityTestSteps extends SeleniumUtilities {

    @When("Navigate to sign in page")
    public void NavigateSignIn() {
      clickElement(HomePage.SIGN_IN_BUTTON);
    }


    @And("User enter {string} and {string}")
    public void signInWithCorrectInformation(String email, String password) {
        sendTextToElement(SignInPage.ENTER_EMAIL, email);
        sendTextToElement(SignInPage.ENTER_PASSWORD, password);
    }

    @Then("Log in")
    public void logIn() {
        clickElement(SignInPage.LOGIN_BUTTON);
    }

    @Then("Validate that you sign in successfully, find the logout button")
    public void validateLogoutBtn() {
        boolean isButtonEnabled = isElementEnabled(SignInPage.LOGOUT_BUTTON);
        Assert.assertTrue(isButtonEnabled);
    }

    @Then("validate error message {string}")
    public void validateErrorMessage(String expectedErrorText) {
        String actualErrorText = getElementText(SignInPage.ERROR_TEXT);
        Assert.assertEquals(expectedErrorText, actualErrorText);
    }
}
