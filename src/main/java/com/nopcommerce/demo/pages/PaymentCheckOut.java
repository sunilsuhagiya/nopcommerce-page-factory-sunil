package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PaymentCheckOut extends Utility {
    @CacheLookup
    @FindBy(id = "CreditCardType")
    WebElement cardType;
    @CacheLookup
    @FindBy(id = "CardholderName")
    WebElement cardHolderNameField;
    @CacheLookup
    @FindBy(id = "CardNumber")
    WebElement cardNumberField;
    @CacheLookup
    @FindBy(id = "ExpireMonth")
    WebElement expireMonthField;

    @CacheLookup
    @FindBy(id = "ExpireYear")
    WebElement expireYearField;
    @CacheLookup
    @FindBy(id = "CardCode")
    WebElement cardCodeField;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
    WebElement continueButton;


    public void selectCardTypeFromDropDown(String text) {
        Reporter.log("Select card type from drop down" + cardType.toString());
        selectByValueFromDropDown(cardType, text);
        CustomListeners.test.log(Status.PASS, "Select card type from drop down" + text);
    }

    public void enterCardHolderName(String text) {
        Reporter.log("Enter card Card holder name" + cardHolderNameField.toString());
        sendTextToElement(cardHolderNameField, text);
        CustomListeners.test.log(Status.PASS, "Enter card Card holder name" + text);
    }

    public void enterCardNumber(String text) {
        Reporter.log("Enter card Card number" + cardNumberField.toString());
        sendTextToElement(cardNumberField, text);
        CustomListeners.test.log(Status.PASS, "Enter card Card number" + text);
    }

    public void selectExpiryMonthFromDropDown(String text) {
        Reporter.log("Select Expiry Month" + expireMonthField.toString());
        selectByValueFromDropDown(expireMonthField, text);
        CustomListeners.test.log(Status.PASS, "Select Expiry Month" + text);
    }

    public void selectExpiryYearFromDropDown(String text) {
        Reporter.log("Select expire Year" + expireYearField.toString());
        selectByValueFromDropDown(expireYearField, text);
        CustomListeners.test.log(Status.PASS, "Select Expiry year" + text);
    }

    public void enterCardCode(String text) {
        Reporter.log("Enter Card Code" + cardCodeField.toString());
        sendTextToElement(cardCodeField, text);
        CustomListeners.test.log(Status.PASS, "Enter Card Code" + text);
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button" + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }
}
