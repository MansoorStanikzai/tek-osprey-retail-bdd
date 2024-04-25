package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.pages.HomePage;
import tek.bdd.utility.SeleniumUtilities;

import java.time.Duration;

public class SmokeTestSteps extends SeleniumUtilities {

    @Then("Validate top left corner is {string}")
    public void validateTopLeftCorner(String expectedTitle) {
        String actualTitle = getElementText(HomePage.TOP_NAV_LOGO);
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("Validate Sign In Button is Enabled")
    public void validateSignInButtonIsEnabled() {
        boolean isButtonEnabled = isElementEnabled(HomePage.SIGN_IN_BUTTON);
        Assert.assertTrue(isButtonEnabled);

    }

}
