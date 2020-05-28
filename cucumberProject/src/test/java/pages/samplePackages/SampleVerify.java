package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SampleVerify extends Page {
    public SampleVerify() {
        setUrl("http://skryabin.com/webdriver/html/sample.html");
    }

    @FindBy(xpath = "//div[@class='well form-container container-fluid']")
    private WebElement wholePageText;

    @FindBy(xpath = "//button[@id='return']")
    private WebElement returnButton;

    @FindBy(xpath = "//b[@name='countryOfOrigin']")
    private WebElement country;

    @FindBy(xpath = "//b[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//b[@name='gender']")
    private WebElement gender;

    @FindBy(xpath = "//b[@name='allowedToContact']")
    private WebElement allowedToContact;

    @FindBy(xpath = "//b[@name='name']")
    private WebElement name;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement agreedToPrivacyPolicy;

    @FindBy(xpath = "//b[@name='phone']")
    private WebElement phone;

    @FindBy(xpath = "//b[@name='contactPersonName']")
    private WebElement contactPersonName;

    @FindBy(xpath = "//b[@name='contactPersonPhone']")
    private WebElement contactPersonPhone;

    @FindBy(xpath = "//b[@name='thirdPartyAgreement']")
    private WebElement thirdPartyAgreement;

    @FindBy(xpath = "//b[@name='carMake']")
    private WebElement carMake;

    @FindBy(xpath = "//b[@name='dateOfBirth']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//b[@name='location']")
    private WebElement location;

    @FindBy(xpath = "//b[@name='attachmentName']")
    private WebElement attachmentName;

    @FindBy(xpath = "//b[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//b[@name='address']")
    private WebElement address;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//b[@name='currentDate']")
    private WebElement currentDate;




    public String getTextFromCurrentDate(){
        return currentDate.getText();
    }

    public String getTextFromPassword() {
        return password.getText();
    }

    public String getTextFromAddress() {
        return address.getText();
    }


    public String getTextFromUsername() {
        return username.getText();
    }

    public String getTextFromAttachmentName() {
        return attachmentName.getText();
    }

    public String getTextFromLocation() {
        return location.getText();
    }

    public String getTextFromDateOfBirth() {
        return dateOfBirth.getText();
    }

    public String getTextFromCarMake() {
        return carMake.getText();
    }

    public boolean isThirdPartyAgreementAccepted() {
        if(thirdPartyAgreement.getText().equalsIgnoreCase("accepted")) {
            return true;
        }
        return false;
    }

    public String getTextFromContactPersonPhone() {
        return contactPersonPhone.getText();
    }

    public String getTextFromContactPersonName() {
        return contactPersonName.getText();
    }

    public String getTextFromPhone() {
        return phone.getText();
    }

    public String getTextFromName() {
        return name.getText();
    }

    public boolean isAgreedToPrivacyPolicySelected() {
        if (agreedToPrivacyPolicy.getText().equalsIgnoreCase("true")) {
            return true;
        }
        return false;
    }

    public boolean isAllowedToContactSelected() {
        if (allowedToContact.getText().equalsIgnoreCase("true")) {
            return true;
        }

        return false;
    }

    public String getTextFromGender() {
        return gender.getText();
    }

    public String getTextFromEmail() {
        return email.getText();
    }


    public String getTextFromCountry() {
        return country.getText();
    }


}
