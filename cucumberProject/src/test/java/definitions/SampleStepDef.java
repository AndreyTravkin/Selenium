package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

        if (field.equalsIgnoreCase("username"))  {
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


}
