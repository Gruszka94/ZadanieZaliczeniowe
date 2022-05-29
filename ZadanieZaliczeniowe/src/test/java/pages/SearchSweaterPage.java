package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchSweaterPage {

    private static WebDriver driver;

    public SearchSweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // konstruktor do tworzenia obiektu
    }


    @FindBy(name = "s")
    private WebElement searchCatalog;

//    @FindBy(className = "material-icons")
//    private WebElement lookUpSearch; // lupa nie działa -> zostanie użyty submit

    @FindBy(xpath = "//*[contains(text(),'Hummingbird printed sweater')]")
    private WebElement findSweater;

    public void searchSweaterInCatalog(String sweaterName) {

        searchCatalog.click();
        searchCatalog.sendKeys(sweaterName);

        searchCatalog.submit();

        findSweater.click();
    }


}
