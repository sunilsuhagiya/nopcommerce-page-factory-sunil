package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ConfirmOrderPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Credit Card')]")
    WebElement paymentMethod;
    @CacheLookup
    @FindBy(xpath = "//div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]")
    WebElement shippingtMethod;

    @CacheLookup
    @FindBy(xpath = "//tbody/tr[4]/td[2]/span[1]/strong[1]")
    WebElement price;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    WebElement confirmButton;

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]")
    WebElement secondDayAir;

    @CacheLookup
    @FindBy(xpath = "//tbody/tr[4]/td[2]/span[1]/strong[1]")
    WebElement nokiaTotalPrice;


    public String VerifyCreditCardPaymentMethod() {
        Reporter.log("Verify Credit Card Payment Method" + paymentMethod.toString());
        CustomListeners.test.log(Status.PASS, "Verify Credit Card Payment Method");
        return getTextFromElement(paymentMethod);
    }

    public String VerifyShippingMethod() {
        Reporter.log("Verify Shipping Method" + shippingtMethod.toString());
        CustomListeners.test.log(Status.PASS, "Verify Shipping Method");
        return getTextFromElement(shippingtMethod);
    }

    public String VerifytheTotalPrice() {
        Reporter.log("Verify the Total Price" + price.toString());
        CustomListeners.test.log(Status.PASS, "Verify the Total Price");
        return getTextFromElement(price);
    }

    public void clickOnConFirm() {
        Reporter.log("Click on confirm Button" + confirmButton.toString());
        clickOnElement(confirmButton);
        CustomListeners.test.log(Status.PASS, "Click on confirm Button ");
    }

    public String verifySecondDayAir() {
        Reporter.log("Verify Second Day Air" + secondDayAir.toString());
        CustomListeners.test.log(Status.PASS, "Verify vSecond Day Air");
        return getTextFromElement(secondDayAir);
    }

    public String verifyNokiaTotalPrice() {
        Reporter.log("Verify nokia Total Price" + nokiaTotalPrice.toString());
        CustomListeners.test.log(Status.PASS, "Verify nokia Total Price");
        return getTextFromElement(nokiaTotalPrice);
    }
}
