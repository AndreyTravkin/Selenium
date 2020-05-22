package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteForm extends Page {

    public QuoteForm() {
        setUrl("https://skryabin.com/market/quote.html");
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPassword;

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillPassword(String value) {
        password.sendKeys(value);
    }

    public void fillConfirmPassword(String value) {
        confirmPassword.sendKeys(value);
    }

    public void fillOutRequiredFields() {

    }

}
