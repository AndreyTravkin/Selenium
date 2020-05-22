package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SapmlePage extends Page {
    public SapmlePage() {
        setUrl("http://skryabin.com/webdriver/html/sample.html");
    }

    @FindBy(xpath = "//b[@id='location']")
    private WebElement location;

    @FindBy(xpath = "//b[@id='currentDate']")
    private WebElement date;

    @FindBy(xpath = "//b[@id='currentTime']")
    private WebElement time;

    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement submitButton;

    @FindBy(xpath = "//label[@id='username-error']")
    private WebElement usernameError;

    @FindBy(xpath = "//label[@id='email-error']")
    private WebElement emailError;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//label[@id='password-error']")
    private WebElement passwordError;

    @FindBy(xpath = "//label[@id='name-error']")
    private WebElement nameError;

    @FindBy(xpath = "//label[@id='agreedToPrivacyPolicy-error']")
    private WebElement privacyPolicyError;


    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;




    public boolean isLocationPresent() {
        if (location.isDisplayed()) {
            return true;
        }
        return false;
    }


    public boolean isDatePresent() {
        if (date.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean isTimePresent() {
        if (time.isDisplayed()) {
            return true;
        }
        return false;
    }


    public void clickSubmitButton() {
        submitButton.click();
    }


    public String getTExtFromUsernameError(){
        return usernameError.getText();
    }


    public String getTExtFromEmailError(){
        return emailError.getText();
    }

    public String getTExtFromPasswordError(){
        return passwordError.getText();
    }

    public String getTExtFromNamedError(){
        return nameError.getText();
    }

    public String getTExtFromPrivacyPolicyError(){
        return privacyPolicyError.getText();
    }

    public boolean isUsernameErrorPresent(){
        waitForVisible(usernameError);

        if (usernameError.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean isUsernameErrorNotPresent(){
        waitForNotVisible(usernameError);

        if (usernameError.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void fillUsername(String value) {
        username.clear();
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
      emailField.clear();
      sendKeys(emailField, value);
    }
}
