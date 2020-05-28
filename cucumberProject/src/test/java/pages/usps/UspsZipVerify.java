package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsZipVerify extends Page {
    public UspsZipVerify() {
    }

    @FindBy(xpath = "//div[@id='zipByAddressDiv']")
    private WebElement zipByAddressDiv;

    @FindBy(xpath = "//div[@id='zipByAddressDiv']")
    private WebElement textThatWeEntered;

    public String getTextFromZipByAddressDiv() throws InterruptedException {
        // I wait until text that we entered going to be present on the page
        waitForVisible(textThatWeEntered);
        return zipByAddressDiv.getText();
    }


}
