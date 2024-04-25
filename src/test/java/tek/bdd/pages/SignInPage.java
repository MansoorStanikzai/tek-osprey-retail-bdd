package tek.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignInPage {

    public final static By ENTER_EMAIL = By.id("email");

    public final static By ENTER_PASSWORD = By.id("password");

    public final static By LOGIN_BUTTON = By.id("loginBtn");

    public final static By LOGOUT_BUTTON = By.id("logoutBtn");

    public final static By ERROR_TEXT = By.xpath("//div[@class='error']");

    public final static By CREATE_ACCOUNT_BUTTON = By.linkText("Create New Account");

}
