package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CompletedCheckoutPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Thank you')]")
    WebElement thankyouText;

    @CacheLookup
    @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
    WebElement sucessText;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;


    public String verifyThankYouText() {
        Reporter.log("Verify Thank You Text" + thankyouText.toString());
        CustomListeners.test.log(Status.PASS, "Verify Thank You Text");
        return getTextFromElement(thankyouText);
    }

    public String verifySucessOrderText() {
        Reporter.log("Verify Sucess Order Text" + sucessText.toString());
        CustomListeners.test.log(Status.PASS, "Verify Sucess Order Text");
        return getTextFromElement(sucessText);
    }

    public void clickOnContinue() {
        Reporter.log("Click on Continue Button" + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on Continue Button");
    }

}
