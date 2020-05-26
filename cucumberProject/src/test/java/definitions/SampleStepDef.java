package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import pages.SapmlePage;

import static org.testng.Assert.assertTrue;
import static support.TestContext.getDriver;


public class SampleStepDef {

    SapmlePage page = new SapmlePage();


    @Given("I go to the {string} page")
    public void iGoToThePage(String url) {
        switch (url) {
            case "sample":
                new SapmlePage().open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + url);
        }
    }


    @When("I change resolution to {string} layout")
    public void iChangeResolutionToLayout(String layout) throws InterruptedException {
        if (layout.equalsIgnoreCase("Desktop")) {
            getDriver().manage().window().setSize(new Dimension(1440, 681));
        } else if (layout.equalsIgnoreCase("Tablet")) {
            getDriver().manage().window().setSize(new Dimension(850, 681));
        } else if (layout.equalsIgnoreCase("Phone")) {
            getDriver().manage().window().setSize(new Dimension(700, 681));
        } else {
            System.out.println("Wrong screen type");
        }
    }


    @Then("I verify that location date and time present")
    public void iVerifyThatLocationDateAndTimePresent() throws InterruptedException {
        assertTrue(page.isLocationPresent());
        assertTrue(page.isDatePresent());
        assertTrue(page.isTimePresent());
    }

    @Then("I verify that location date and time not present")
    public void iVerifyThatLocationDateAndTimeNotPresent() throws InterruptedException {
        Assert.assertFalse(page.isLocationPresent());
        Assert.assertFalse(page.isDatePresent());
        Assert.assertFalse(page.isTimePresent());
    }

    @When("I click submit button")
    public void iClickSubmitButton() {
        page.clickSubmitButton();
    }

    @Then("I verify username error text is {string}")
    public void iVerifyUsernameErrorTextIs(String text) throws InterruptedException {
        Assert.assertEquals(page.getTExtFromUsernameError(), text);
    }


    @When("I send text {string} into username field")
    public void iSendTextIntoUsernameField(String text) throws InterruptedException {
        page.fillUsername(text);
    }

    @Then("I verify that error message is not present")
    public void iVerifyThatErrorMessageIsNotPresent() throws InterruptedException {

        Assert.assertFalse(page.isUsernameErrorNotPresent());
    }

    @Then("I verify {string} error text is {string}")
    public void iVerifyErrorTextIs(String field, String text) throws InterruptedException {

        if (field.equalsIgnoreCase("username")) {
            Assert.assertEquals(page.getTExtFromUsernameError(), text);
        }


        if (field.equalsIgnoreCase("email")) {
            Assert.assertEquals(page.getTExtFromEmailError(), text);
        }

        if (field.equalsIgnoreCase("password")) {
            Assert.assertEquals(page.getTExtFromPasswordError(), text);
        }

        if (field.equalsIgnoreCase("name")) {
            Assert.assertEquals(page.getTExtFromNamedError(), text);
        }

        if (field.equalsIgnoreCase("Privacy Policy")) {
            assertTrue(page.getTExtFromPrivacyPolicyError().contains(text));
        } else {
            System.out.println("Wrong input");
        }

    }

    @When("I send text {string} into {string} field")
    public void iSendTextIntoField(String text, String field) {
        page.fillEmail(text);
    }


    @Then("I verify that confirmPassword field is disabled")
    public void iVerifyThatConfirmPasswordFieldIsDisabled() {
        Assert.assertFalse(page.isconfirmPasswordFieldEnabled());
    }

    @When("I click on name field")
    public void iClickOnNameField() {
        page.clickOnName();
    }

    @Then("I verify that nameDialog is displayed")
    public void iVerifyThatNameDialogIsDisplayed() {
        page.nameDialogIsDisplayed();
    }

    @When("I send {string} to the name field")
    public void iSendToTheNameField(String firstName) {
        page.typeFirstName(firstName);
    }

    @And("I send {string} to middle name field")
    public void iSendToMiddleNameField(String middleName) {
        page.typeMiddleName(middleName);
    }

    @And("I send {string} to the last name field")
    public void iSendToTheLastNameField(String lastName) {
        page.typeLastName(lastName);
    }

    @When("I hit save button")
    public void iHitSaveButton() {
        page.clickSaveButton();
    }

    @Then("I verify that name {string}")
    public void iVerifyThatName(String expectedName) throws InterruptedException {
        String actualName = page.getTextFromTheNameField();

        Assert.assertEquals(actualName, expectedName);
    }

    @When("I check privacyPolicy checkbox")
    public void iCheckPrivacyPolicyCheckbox() {
        page.clickOnPrivacyPolicyCheckBox();
    }


    @When("I fill out password field with {string}")
    public void iFillOutPasswordFieldWith(String password) {
        page.fillOutThePassword(password);
    }

    @When("I fill out confirm password field {string}")
    public void iFillOutConfirmPasswordField(String password) {
        page.fillOutConfirmPassword(password);
    }


    @When("I fill out phone number field with {string}")
    public void iFillOutPhoneNumberFieldWith(String number) {
        page.fillOutThePhoneNumber(number);
    }

    @When("I select gender as {string}")
    public void iSelectGenderAs(String gender) throws InterruptedException {
        page.selectGender(gender);
    }

    @When("I select country Of Origin is {string}")
    public void iSelectCountryOfOriginIs(String country) throws InterruptedException {
       page.selectCountryByVisibleText("Russia");
    }

    @When("I fill out the address with {string}")
    public void iFillOutTheAddressWith(String address) throws InterruptedException {
        page.fillOutAddressField(address);
    }


    @When("I accept party agreement")
    public void iAcceptPartyAgreement() throws InterruptedException{
        page.acceptThirdPartyButton();
    }

    @When("I hit checkbox to allow to contact with me")
    public void iHitCheckboxToAllowToContactWithMe() {
        page.clickOnallowedToContactButton();
    }


    @When("I select my car makers {string} and {string}")
    public void iSelectMyCarMakersAnd(String toyota, String other) throws InterruptedException {
        page.selectCarMakeByVisibleText(toyota);
        page.selectCarMakeByVisibleText(other);
    }

    @When("I read related documents")
    public void iReadRelatedDocuments() throws InterruptedException {
        page.clickOnRelatedDocumentsButton();
    }

    @Then("I verify that related documents contains {string}")
    public void iVerifyThatRelatedDocumentsContains(String expectedText) throws InterruptedException {

        // get current window handle

        String winHandleBefore = getDriver().getWindowHandle();

        // switch to another window handle

        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }

        // Assert that actual texr from the page contains our expected text
        String actualText = getDriver().findElement(By.xpath("//html")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

        // Close the new window, if that window no more required
        getDriver().close();

        // Switch back to original browser (first window)
        getDriver().switchTo().window(winHandleBefore);

        Thread.sleep(5000);
    }

    @When("I select my date of birth as day {string} month {string} year {string}")
    public void iSelectMyDateOfBirthAsDayMonthYear(String day, String month, String year) {

    }
}
