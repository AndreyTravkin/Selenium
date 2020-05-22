package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.Careers;
import pages.QuoteForm;
import pages.Usps;

public class QuoteObjectStepDefs {

    @Given("I go to {string} page oop")
    public void iGoToPageOop(String page) {
        switch (page) {
            case "quote":
                new QuoteForm().open();
                break;
            case "usps":
                new Usps().open();
                break;
            case "careers":
                new Careers().open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }

    @When("I fill out required fields oop")
    public void iFillOutRequiredFieldsOop() {
        QuoteForm form = new QuoteForm();
        form.fillUsername("skryabin");
        form.fillEmail("slava@skryabin.com");
        form.fillPassword("welcome");
        form.fillConfirmPassword("welcome");

    }
}


