package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Usps;
import pages.UspsPostalStore;
import pages.UspsSignIn;
import pages.UspsTracking;

import java.text.ParseException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class UspsObjectStepDefs {
    @When("^I go to \"([^\"]*)\" oop$")
    public void iGoToOop(String buttonType) throws Throwable {
        switch (buttonType) {
            case "stamps":
                new Usps().clickStamps();
                break;
            case "boxes":
                new Usps().clickBoxes();
                break;
            case "labels":
                new Usps().clickLabels();
                break;
            case "tracking":
                new Usps().clickTracking();
                break;
            default:
                throw new RuntimeException("Unrecognized buttonType: " + buttonType);
        }

    }

    @And("^I sort by \"([^\"]*)\" oop$")
    public void iSortByOop(String text) throws Throwable {
        new UspsPostalStore().selectSortBy(text);
    }

    @Then("^I verify that \"([^\"]*)\" is cheapest oop$")
//    public void iVerifyThatIsCheapestOop(String expected) throws Throwable {
//        String actualItem = new USPSPostalStore().getFirstFoundItem();
//        System.out.println("Actual: " + actualItem);
//        System.out.println("Expected: " + expected);
//        assertThat(actualItem).contains(expected);
    public void iVerifyThatIsCheapestOop(String expected) throws ParseException {
        boolean isFound = new UspsPostalStore().isCheapestItem(expected);
        assertThat(isFound).isTrue();
    }

//    @When("I go to {string} oop page")
//    public void iGoToOopPage(String arg0) {
//  new Usps().clickBoxes();
//    }

    @And("I verify section {string} exists oop")
//    public void iVerifySectionExistsOop(String expected) {
//        String actualItem = new UspsPostalStore().getSectionExists();
//        System.out.println("Actual: " + actualItem);
//        System.out.println("Expected: " + expected);
//        assertThat(actualItem).contains(expected);
    public void iVerifySectionExistsOop(String section) {
        String filterText = new UspsPostalStore().getLeftFilters();
        assertThat(filterText).containsIgnoringCase(section);
    }

    @When("I go to {string} menu oop")
    public void iGoToMenuOop(String menu) {
        new Usps().clickMenuItem(menu);
    }

    @And("I search for {string} in store oop")
    public void iSearchForInStoreOop(String value) {
        UspsPostalStore ps = new UspsPostalStore();
        ps.typeIntoSearchField(value);
        ps.clickPostalStoreSearchButton();
    }

    @Then("I verify that {string} is required oop")
    public void iVerifyThatIsRequiredOop(String arg) {
        boolean isRequired = new UspsSignIn().isSignInRequired();
        assertThat(isRequired).isTrue();

    }

    @Then("I verify that {string} is possible oop")
    public void iVerifyThatIsPossibleOop(String action) {
        // Based on below URLs:
        // https://reg.usps.com/entreg/LoginAction_input
        // https://tools.usps.com/go/TrackConfirmAction

        String url = getDriver().getCurrentUrl();
        if (url.contains("Login")) {
            assertThat(new UspsSignIn().isSignUpPossible()).isTrue();
        } else if (url.contains("Track")) {
            assertThat(new UspsTracking().isSignUpPossible()).isTrue();
        } else {
            throw new RuntimeException("Unrecognized Url: " + url);
        }
    }
}

