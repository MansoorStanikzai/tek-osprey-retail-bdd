package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.AccountProfilePage;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.pages.SignInPage;
import tek.bdd.utility.DataGeneratorUtility;
import tek.bdd.utility.SeleniumUtilities;

import java.util.List;
import java.util.Map;

public class CreateAccountSteps extends SeleniumUtilities {

    private String generatedRandomEmail;


    @Given("User click on Create Account")
    public void clickCreateAccount() {
    clickElement(SignInPage.CREATE_ACCOUNT_BUTTON);
    }

    @When("User fill up Sign up Form")
    public void userFillUpSignUpForm(DataTable dataTable) {
        //Step 1) Converting Data Table to Map.
        Map<String, String> data = dataTable.asMap();
        String email = data.get("email");
        String name = data.get("name");
        String password = data.get("password");

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);

        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }

    @When("User fill up Sign up Form With List Of Map Data Table")
    public void userFillUpSignUpFormWithListOfMapDataTable(DataTable dataTable) {
    //Converting data table to List of maps.
        List<Map<String, String>> data = dataTable.asMaps();
        //Extract first row Data
        Map<String, String> dataMap = data.get(0);

        String email = dataMap.get("email");
        String name = dataMap.get("name");
        String password = dataMap.get("password");

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);

        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }

    @When("User fill up Sign up Form With List Data Table")
    public void userFillUpSignUpFormWithListDataTable(DataTable dataTable) {
        //This Example used List of Data table to List.
        List<String> data = dataTable.asList();
        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);

        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }

    @When("User fill Form {string} and {string} and {string}")
    public void userEnterCredentials(String name, String email, String password) {
        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);

        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }

    @When("User fill up Sign up Form With List Of List Data Table")
    public void UserFillUpSignUpFormWithListOfListDataTable(DataTable dataTable) {
        //Convert data table ot List of List asLists()
        List<List<String>> rawData = dataTable.asLists();
        //Extracting first row of List
        List<String> data = rawData.get(0);

        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);

        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }


    @When("User Click on Sign up button")
    public void userClickOnSignUpButton() {
        clickElement(SignUpPage.SIGN_UP_BUTTON);
    }

    @Then("User will navigate to Account Profile Page")
    public void userWillNavigateToAccountProfilePage() {
        clickElement(HomePage.ACCOUNT_BUTTON);
    }

    @Then("Validate {string} and email in Account Page")
    public void validateAndInAccountPage(String expectedName) {
        String actualName = getElementText(AccountProfilePage.PROFILE_NAME_TEXT);
        Assert.assertEquals(expectedName, actualName);

        String actualEmail = getElementText(AccountProfilePage.PROFILE_EMAIL_TEXT);
        Assert.assertEquals(generatedRandomEmail, actualEmail);


    }


}
