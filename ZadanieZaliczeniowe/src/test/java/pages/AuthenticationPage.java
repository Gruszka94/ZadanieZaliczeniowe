package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage {

    private WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".user-info > a:nth-child(1)") // selektor CSS
    private WebElement signInButton;


    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "password")
    private WebElement inputPassword;


    @FindBy(id = "submit-login")
    private WebElement submitButton;


    public void loginAs(String email, String password) {

        signInButton.click();

        inputEmail.click();
        inputEmail.sendKeys(email);

        inputPassword.click();
        inputPassword.sendKeys(password);

        submitButton.click();

    }
}
