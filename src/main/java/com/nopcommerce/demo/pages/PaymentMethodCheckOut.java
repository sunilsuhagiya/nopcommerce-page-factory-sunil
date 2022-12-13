package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PaymentMethodCheckOut extends Utility {
    @CacheLookup
    @FindBy(css = "#paymentmethod_1")
    WebElement creditCard;

    @CacheLookup
    @FindBy(xpath = "//ol[1]/li[4]/div[2]/div[1]/button[1]")
    WebElement continueButton;


    public void clickOnCreditCard() {
        Reporter.log("Click on Credit Card" + creditCard.toString());
        clickOnElement(creditCard);
        CustomListeners.test.log(Status.PASS, "Click on Credit Card");
    }

    public void clickOnContinue() {
        Reporter.log("Click on continue Button" + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue Button ");
    }
}
