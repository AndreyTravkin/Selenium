package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static support.TestContext.getDriver;

public class UspsMainPage extends Page {
    public UspsMainPage() {
        setUrl("https://www.usps.com");
    }


    public void goToLookupZipPageByAddress(String navbar) throws InterruptedException {
        WebElement element =  getDriver().findElement(By.xpath("//ul[@class='nav-list']//a[text()='"+navbar+"']"));
        waitForVisible(element);
       moveToElement(element);
    }

    public void ClickOnQuickToolsMenu(String menuName) throws InterruptedException {
        WebElement quickToolsMenu =  getByXpath("//li[@class='qt-nav menuheader']//a[contains(string(),'"+menuName+"')]");
        waitForClickable(quickToolsMenu);
        quickToolsMenu.click();
    }





}


