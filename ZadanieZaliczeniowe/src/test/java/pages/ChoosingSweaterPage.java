package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChoosingSweaterPage {

    private static WebDriver driver;

    public ChoosingSweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // konstruktor do tworzenia obiektu
    }

    @FindBy(id = "group_1")
    private WebElement selectSize; // jeszcze zrobić objekt typu Select

    @FindBy(id = "quantity_wanted")
    private WebElement selectQuantity; // pamiętaj o click clear

    @FindBy(css = "button.btn-primary")
    private WebElement addToCart;

    @FindBy(css = "a.btn")
    private WebElement checkOut;


    public void sweaterDetails(String size, String quantity) {

        Select selectObject = new Select(selectSize);
        selectObject.selectByVisibleText(size);

        selectQuantity.click();
        selectQuantity.clear();
        selectQuantity.sendKeys(quantity);

        addToCart.click();

        WebElement waitForCheckOutButton = new WebDriverWait(driver, 1)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn"))); // musi być wait, ponieważ nie chciało wybrać się proceed to check out - przycisk wait czeka, aż przycisk będzie gotowy do kliknięcia


        checkOut.click();


    }


}
