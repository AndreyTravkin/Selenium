package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LookUpZipCodeUsps extends Page {
    public LookUpZipCodeUsps() {
    }

    @FindBy(xpath = "//input[@id='tAddress']")
    private WebElement streetField;

    @FindBy(xpath = "//input[@id='tCity']")
    private WebElement cityField;

    @FindBy(xpath = "//select[@id='tState']")
    private WebElement state;

    @FindBy(xpath = "//a[@id='zip-by-address']")
    private WebElement findButton;


    public void fillOutStreetFiled(String street) throws InterruptedException {
        streetField.sendKeys(street);
    }

    public void fillOutCityFiled(String city) throws InterruptedException {
        cityField.sendKeys(city);
    }


    public void selectTheState(String state) throws  InterruptedException {
        selectDropdownUsingValue(state, this.state);
    }

    public void FillOutAndSubmitTheForm(String street, String city, String state) throws InterruptedException {
        fillOutStreetFiled(street);
        fillOutCityFiled(city);
        selectTheState(state);
        click(findButton);
    }

    public void chooseLookUpaZIPCode(String menuOption) throws InterruptedException {
        WebElement lookupZipCodeMenu =  getByXpath("//a[contains(text(),'"+menuOption+"')]");
        waitForClickable(lookupZipCodeMenu);
        lookupZipCodeMenu.click();
    }



}
