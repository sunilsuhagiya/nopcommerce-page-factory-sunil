package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckOutAsGuest extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Welcome, Please Sign In!']")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "//button[text()= 'Checkout as Guest']")
    WebElement guestButton;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement registerLink;


    public String verifyWelComeText() {
        Reporter.log("Verify WelCome Text" + welcomeText.toString());
        CustomListeners.test.log(Status.PASS, "Verify WelCome Text");
        return getTextFromElement(welcomeText);
    }

    public void clickOnAsGuestButton() {
        Reporter.log("click On As Guest Button" + guestButton.toString());
        clickOnElement(guestButton);
        CustomListeners.test.log(Status.PASS, "click On As Guest Button");
    }

    public void clickOnRegisterTab() {
        Reporter.log("click On As Register Button" + registerLink.toString());
        clickOnElement(registerLink);
        CustomListeners.test.log(Status.PASS, "click On As Register Button");
    }
}
