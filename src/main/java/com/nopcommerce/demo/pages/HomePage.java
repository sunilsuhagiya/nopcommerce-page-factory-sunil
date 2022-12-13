package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktop;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
    WebElement welcomeText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logoutText;
    @CacheLookup
    @FindBy(xpath = "//div/ul[@class='top-menu notmobile']/li[2]/a[@href='/electronics']")
    WebElement hoverOnElectronic;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")
    WebElement clickOnCellPhone;

    public void selectMenu(String menu) {
        Reporter.log("selectMenu");
        String mainmenu = menu.toLowerCase();
        String expression = "//a[@href ='/" + mainmenu + "']";
        driver.findElement(By.xpath(expression)).click();
        String currentUrl = driver.getCurrentUrl();
        CustomListeners.test.log(Status.PASS, "Select Menu" + menu);
    }

    public void clickOnDeskTop() {
        Reporter.log("Click on desktop" + desktop.toString());
        clickOnElement(desktop);
        CustomListeners.test.log(Status.PASS, "Click on desktop");
    }

    public void mouseHoverOnElectronics() {
        Reporter.log("Mouse Hover On Electronics" + hoverOnElectronic.toString());
        mouseHoverToElement(hoverOnElectronic);
        CustomListeners.test.log(Status.PASS, "Mouse Hover On Electronics");
    }


    public void mouseHoverOnCellPhonesAndClick() {
        Reporter.log("Click On Cell Phone" + clickOnCellPhone.toString());
        mouseHoverToElementAndClick(clickOnCellPhone);
        CustomListeners.test.log(Status.PASS, "Click On Cell Phone");
    }

    public String verifyWelComeText() {
        Reporter.log("Get welcome Text Message" + welcomeText.toString());
        CustomListeners.test.log(Status.PASS, "Get welcome Text Message");
        return getTextFromElement(welcomeText);
    }

    public void clickOnLogoutButton() {
        Reporter.log("Click on logout" + logoutText.toString());
        clickOnElement(logoutText);
        CustomListeners.test.log(Status.PASS, "Click on logout");
    }

}
