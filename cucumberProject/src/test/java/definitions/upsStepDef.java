package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ups.UpsMainPage;
import pages.ups.UpsShipping;

public class upsStepDef {

    UpsMainPage ups = new UpsMainPage();
    UpsShipping shipping = new UpsShipping();

    @When("I open Shipping menu")
    public void iOpenShippingMenu() throws InterruptedException{
        ups.goToShippingMenu();
    }

    @And("I go to {string}")
    public void iGoTo(String menu) throws InterruptedException {
        ups.openShippingMenu(menu);
    }


    @When("I fill out origin shipment fields with {string} country, {string} name, {string}, contact name, {string} address, {string} zip code, {string}, city {string} state, {string} email {string} phone")
    public void iFillOutOriginShipmentFieldsWithCountryNameContactNameAddressZipCodeCityStateEmailPhone(String country, String name, String contactName, String address, String zipCode, String city, String state, String email, String phone) throws  InterruptedException {
        shipping.fillOutTheForm(country, name, contactName, address, zipCode, city, state, email, phone);
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() throws InterruptedException {
        shipping.submitTheForm();
    }


    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() throws InterruptedException {
      shipping.isShipmentFormSubmitted();
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() throws InterruptedException {
        shipping.cancelShippment();
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() throws InterruptedException {
        shipping.isShipmentFormReset();
        //
    }
}
