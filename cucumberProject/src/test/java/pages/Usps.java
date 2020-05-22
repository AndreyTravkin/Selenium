package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;


public class Usps extends Page {
    public Usps() {
        setUrl("https://www.usps.com");
    }

    @FindBy(xpath = "//a[@id='stampButton']")
    private WebElement stampsButton;

    @FindBy(xpath = "//a[@id='orderButton']")
    private WebElement boxesButton;

    @FindBy(xpath = "//a[@class='menuitem'][contains(text(),'Postal Store')]")
    private WebElement menuItem;

    @FindBy(xpath = "//a[@id='quickMenuButtonShip']")
    private WebElement labels;

    @FindBy(xpath = "//input[@id='trackButton']")
    private WebElement tracking;

    public void clickTracking(){
        tracking.click();
    }

    public void clickLabels(){
        labels.click();
    }

    public void clickMenuItem(String menu){
        getDriver().findElement(By.xpath("//a[@class='menuitem'][text()='" + menu + "']")).click();
    }
    public void clickBoxes(){
        boxesButton.click();
    }

    public void clickStamps(){
        stampsButton.click();
    }

}

