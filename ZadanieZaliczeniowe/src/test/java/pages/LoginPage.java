package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.html.CSS;

public class LoginPage {

    private static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // konstruktor do tworzenia obiektu
    }

    @FindBy (css =".user-info > a:nth-child(1)") // selektor CSS
    private WebElement signInButton;

    @FindBy (name = "email")
    private WebElement emailLogIn;

    @FindBy (name = "password")
    private WebElement passwordLogIn;

    @FindBy (id = "submit-login")
    private WebElement signIn;

    public void userLogIn(String email, String password){


        signInButton.click();

        emailLogIn.click();
        emailLogIn.clear();
        emailLogIn.sendKeys(email);

        passwordLogIn.click();
        passwordLogIn.clear();
        passwordLogIn.sendKeys(password);

        signIn.click();


    }


}
