package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static support.TestContext.getDriver;

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

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicyCheckBox;

    @FindBy(xpath = "//button[@id='thirdPartyButton']")
    private WebElement thirdPartyButton;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//div[@id='nameDialog']")
    private WebElement nameDialog;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firsName;

    @FindBy(xpath = "//input[@id='middleName']")
    private WebElement middleName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='dateOfBirth']")
    private WebElement dateOfBirthField;

    @FindBy(xpath = "//select[@name='countryOfOrigin']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//span[contains(text(),'Male')]/..//input")
    private WebElement maleGenderRadioButton;

    @FindBy(xpath = "//select[@name='carMake']//option[contains(text(),'Ford')]")
    private WebElement fordCarMake;

    @FindBy(xpath = "//select[@name='carMake']//option[contains(text(),'Toyota')]")
    private WebElement toyotaCarMake;

    @FindBy(xpath = "//select[@name='carMake']")
    private WebElement carMake;

    @FindBy(xpath = "//input[@name='allowedToContact']")
    private WebElement allowedToContact;

    @FindBy(xpath = "//button[contains(text(),'Related documents (click)')]")
    private WebElement relatedDocumentsButton;

    @FindBy(id = "attachment")
    private WebElement uploadFile;

    @FindBy(xpath = "//textarea[@id='address']")
    private WebElement addressField;

    @FindBy(xpath = "//input[@id='dateOfBirth']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    private WebElement selectDatePickerMonth;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    private WebElement selectDatePickerYear;

    @FindBy(xpath = "//input[@id='contactPersonName']")
    private WebElement contactPersonName;

    @FindBy(xpath = "//input[@id='contactPersonPhone']")
    private WebElement contactPersonPhone;

    public void chooseFile(String fileName) {
        String pathname = null;
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac")) {
          //  pathname = "/Users/" + System.getProperty("user.name") + "/Documents/Selenium/cucumberProject/src/test/resources/data/attachments/"+fileName+"";
            pathname = System.getProperty("user.dir") + "/src/test/resources/data/attachments/"+fileName+"";
        } else {

            pathname = "/src/test/resources/data/attachments/"+fileName+"";
        }

        getDriver().findElement(By.id("attachment")).sendKeys(pathname);

    }

    public void fillOutContactPersonInfo(String name, String phone) {
        sendKeys(contactPersonName, name);
        sendKeys(contactPersonPhone, phone);
    }


    public void selectDateOfBirth(String month, String day, String year) throws InterruptedException {
        click(dateOfBirth);
        selectDropdown(month, selectDatePickerMonth);
        selectDropdown(year, selectDatePickerYear);

        // working solution
//        WebElement selectedDay = getByXpath("//table/tbody/tr/td[@data-handler]/a[contains(text(), '" + day + "' )]");
//        click(selectedDay);


        // working solution using loop
        WebElement dateWidget = getDriver().findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody"));
        List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

        for (WebElement cell: columns){
            if (cell.getText().equals(day)){
                cell.findElement(By.linkText(day)).click();
                break;
            }
        }
    }

    public void clickOnRelatedDocumentsButton() throws InterruptedException {
        click(relatedDocumentsButton);
    }

    public void clickOnallowedToContactButton() {
        click(allowedToContact);
    }

    public void  acceptThirdPartyButton() throws InterruptedException{
        click(thirdPartyButton);
        getDriver().switchTo().alert().accept();
    }

    public void fillOutAddressField(String txt){
        sendKeys(addressField, txt);
    }


    public void selectCountryByVisibleText(String text) throws InterruptedException {
        selectDropdown(text, countryDropdown);
    }

    public void selectCarMakeByVisibleText(String text) throws InterruptedException {
        selectDropdown(text, carMake);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        click(privacyPolicyCheckBox);
    }

    public void  fillOutThePassword(String password) {
        sendKeys(passwordField, password);
    }

    public void  fillOutConfirmPassword(String password) {
        sendKeys(confirmPasswordField, password);
    }

    public void  fillOutThePhoneNumber(String number) {
        sendKeys(phoneField, number);
    }

    public void typeFirstName(String firstName) {
        sendKeys(this.firsName, firstName);
    }

    public void typeMiddleName(String middleName) {
        sendKeys(this.middleName, middleName);
    }

    public void typeLastName(String lastName) {
        sendKeys(this.lastName, lastName);
    }

    public void clickSaveButton(){
        click(saveButton);
    }

    public void selectGender(String gender) throws InterruptedException{
       getDriver().findElement(By.xpath("//*[text()='"+gender+"']/..//input")).click();
    }

    public String getTextFromTheNameField() {
        return nameField.getAttribute("value");
    }

    public boolean nameDialogIsDisplayed() {
        if (nameDialog.isDisplayed()) {
            return true;
        }
        // qw

        return false;

    }

    public void clickOnName() {
        click(nameField);
    }


    public boolean isLocationPresent() {
        if (location.isDisplayed()) {
            return true;
        }
        return false;
    }


    public boolean isconfirmPasswordFieldEnabled() {
        if (confirmPasswordField.isEnabled()) {
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


    public String getTExtFromUsernameError() {
        return usernameError.getText();
    }


    public String getTExtFromEmailError() {
        return emailError.getText();
    }

    public String getTExtFromPasswordError() {
        return passwordError.getText();
    }

    public String getTExtFromNamedError() {
        return nameError.getText();
    }

    public String getTExtFromPrivacyPolicyError() {
        return privacyPolicyError.getText();
    }

    public boolean isUsernameErrorPresent() {
        waitForVisible(usernameError);

        if (usernameError.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean isUsernameErrorNotPresent() {
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
