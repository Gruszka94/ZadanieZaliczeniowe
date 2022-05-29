package coderslab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class Zadanie2Test {

    private static WebDriver driver;

    String email = "hkowalska123@wp.pl";
    String password = "Paulina94";
    String size = "M";
    String quantity = "5";
    String sweater = "Hummingbird Printed Sweater";


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl");

    }


    @Test
    public void testPrintedSweaterSearch() {
        //logowanie użytkownika
        LoginPage userLogIn = new LoginPage(driver);
        userLogIn.userLogIn(email, password);

        // wyszukanie swetra
        SearchSweaterPage searchSweater = new SearchSweaterPage(driver);
        searchSweater.searchSweaterInCatalog(sweater);

        // dodawanie swetra do koszyka
        ChoosingSweaterPage karton = new ChoosingSweaterPage(driver);
        karton.sweaterDetails(size, quantity);

        // akcja w koszyku
        ShoppingCartPage order = new ShoppingCartPage(driver);
        order.cartProcess();

        // screenshot
        order.screenShot();

    }


    @After
    public void tearDown() {
        driver.quit();
    }

}

