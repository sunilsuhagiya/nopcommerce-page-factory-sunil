package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BillingCheckOutPage extends Utility {
    @CacheLookup
    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_Email")
    WebElement emailAddressField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement countryField;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement stateField;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_City")
    WebElement cityField;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement addressField;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCodeField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumberField;

    @CacheLookup
    @FindBy(xpath = "//div[1]/button[4]")
    WebElement checkout;
    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]")
    WebElement continueButton;


    public void enterBillingFirstName(String text) {
        Reporter.log("Enter Billing First Name" + firstNameField.toString());
        sendTextToElement(firstNameField, text);
        CustomListeners.test.log(Status.PASS, "Enter user name " + text);
    }

    public void enterBillingLastName(String text) {
        Reporter.log("Enter Billing Last Name" + lastNameField.toString());
        sendTextToElement(lastNameField, text);
        CustomListeners.test.log(Status.PASS, "Enter Last Name " + text);
    }

    public void enterBillingEmailAddress(String text) {
        Reporter.log("Enter Billing Email Address" + emailAddressField.toString());
        sendTextToElement(emailAddressField, text);
        CustomListeners.test.log(Status.PASS, "Enter Email Address " + text);
    }

    public void selectCountryFromDropDown(String text) {
        Reporter.log("Select Country" + countryField.toString());
        selectByValueFromDropDown(countryField, text);
        CustomListeners.test.log(Status.PASS, "Select Country ");
    }

    public void selectStateFromDropDown(String text) {
        Reporter.log("Select Country" + stateField.toString());
        selectByValueFromDropDown(stateField, text);
        CustomListeners.test.log(Status.PASS, "Select State ");

    }

    public void enterBillingCity(String text) {
        Reporter.log("Enter Billing City Name" + cityField.toString());
        sendTextToElement(cityField, text);
        CustomListeners.test.log(Status.PASS, "Enter Billing City Name" + text);
    }

    public void enterBillingAddress(String text) {
        Reporter.log("Enter Billing Address" + addressField.toString());
        sendTextToElement(addressField, text);
        CustomListeners.test.log(Status.PASS, "Enter Billing Address" + text);
    }

    public void enterBillingZipcode(String text) {
        Reporter.log("Enter Billing Zipcode" + zipCodeField.toString());
        sendTextToElement(zipCodeField, text);
        CustomListeners.test.log(Status.PASS, "Enter Billing Zipcode" + text);

    }

    public void enterBillingPhoneNumber(String text) {
        Reporter.log("Enter Billing Phone number" + phoneNumberField.toString());
        sendTextToElement(phoneNumberField, text);
        CustomListeners.test.log(Status.PASS, "Enter Billing Phone number" + text);
    }

    public void clickOnCheckOutButton() {
        Reporter.log("Click on checkout" + checkout.toString());
        clickOnElement(checkout);
        CustomListeners.test.log(Status.PASS, "Click on checkout ");
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue Button" + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue Button");

    }
}
