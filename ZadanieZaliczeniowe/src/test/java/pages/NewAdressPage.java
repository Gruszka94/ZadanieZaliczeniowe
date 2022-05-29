package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewAdressPage {

    private static WebDriver driver;

    public NewAdressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "address-link")
    private WebElement newAddressButton;

    @FindBy (name = "alias" )
    private WebElement typeAlias;

    @FindBy (name = "address1")
    private WebElement typeAddress;

    @FindBy (name = "postcode")
    private WebElement typePostCode;

    @FindBy (name = "city")
    private WebElement typeCity;

    @FindBy (name = "id_country")
    private WebElement typeCountry;

    @FindBy (name = "phone")
    private WebElement typePhone;

    @FindBy (css = "button.btn")
    private WebElement saveButton;

    public void CreateNewAddress(String alias, String address, String zip, String city, String country, String phone){

        newAddressButton.click();

        typeAlias.click();
        typeAlias.sendKeys(alias);

        typeAddress.click();
        typeAddress.sendKeys(address);

        typePostCode.click();
        typePostCode.sendKeys(zip);

        typeCity.click();
        typeCity.sendKeys(city);

        typeCountry.click();
        typeCountry.sendKeys(country);

        typePhone.click();
        typePhone.sendKeys(phone);

        saveButton.click();


    }

}
