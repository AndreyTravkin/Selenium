package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Careers;
import support.RestWrapper;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class CareersStepDefs {
    @And("I login as {string}")
    public void iLoginAs(String role) {
        new Careers()
                .clickLogin()
                .login(getData(role));

    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
        String actualName = new Careers().getLoggedInUser();
        assertThat(actualName).isEqualTo(getData(role).get("name"));
    }

    @When("I create {string} requisition")
    public void iCreateRequisition(String arg0) {

    }

    @When("I create {string} position")

    @Given("I login to REST API as {string}")
    public void iLoginToRESTAPIAs(String role) {
        new RestWrapper().login(getData(role));
    }

    @When("I create via REST API {string} position")
    public void iCreateViaRESTAPIPosition(String type) {
        new RestWrapper().createPosition(getData(type));
    }
}
