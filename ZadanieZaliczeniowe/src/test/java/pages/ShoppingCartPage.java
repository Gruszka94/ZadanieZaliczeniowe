package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ShoppingCartPage {

    private static WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // konstruktor do tworzenia obiektu
    }

    @FindBy(css = "a.btn")
    private WebElement proceedCheckOut;

    @FindBy(css = ".btn")
    private WebElement addressConfirmation;

    @FindBy(id = "delivery_option_1")
    private WebElement deliveryOption;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement deliveryConfirmation;

    @FindBy(id = "payment-option-1")
    private WebElement paymentMethod;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsAgreement;

    @FindBy(css = "div.ps-shown-by-js > button:nth-child(1)")
    private WebElement oderObligation;

    @FindBy(id = "content")
    private WebElement screen;


    public void cartProcess() {

        proceedCheckOut.click();

        addressConfirmation.click();

//        deliveryOption.click(); // checkbox, który nie reaguje na 2 kliknięcia
        if (!deliveryOption.isSelected()) {
            deliveryOption.click(); // jeżeli nie zaznaczony to kliknij
        }

        deliveryConfirmation.click();

//        paymentMethod.click(); // to samo
        if (!paymentMethod.isSelected()) {
            paymentMethod.click(); // jeżeli nie zaznaczony to kliknij
        }

        termsAgreement.click(); // musi być, bo nie będzie można dokończyć zakupu

        if (!termsAgreement.isSelected()) {
            termsAgreement.click(); // jeżeli nie zaznaczony to kliknij
        }
        oderObligation.click();


    }

    public void screenShot() {
        File scrFile = screen.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
