package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.NewAdressPage;
import pages.YourAddressPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class StoreTests {



    private WebDriver driver;

    @Given("an open browser mystore-testlab.coderslab.pl")
    public void openCodersLab() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl");

    }

    @When("^user loggs in with email \"(.*)\" and password \"(.*)\"$")
    public void logIn(String email, String password){
        LoginPage loginUser = new LoginPage(driver);
        loginUser.userLogIn(email,password);

    }

    @Then("^fill in formula address with \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void typeIn(String alias, String address, String zip, String city, String country, String phone){
        NewAdressPage addressPage = new NewAdressPage(driver);
        addressPage.CreateNewAddress(alias, address, zip, city, country, phone);
    }

    @And("^verify data in YourAddress \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void yourFirstAddress(String alias, String address, String zip, String city, String country, String phone){

        YourAddressPage firstAdress = new YourAddressPage(driver);


        // Asercja
        assertTrue(firstAdress.dataVerification().contains(alias));
        assertTrue(firstAdress.dataVerification().contains(address));
        assertTrue(firstAdress.dataVerification().contains(zip));
        assertTrue(firstAdress.dataVerification().contains(city));
        assertTrue(firstAdress.dataVerification().contains(country));
        assertTrue(firstAdress.dataVerification().contains(phone));



    }




}
