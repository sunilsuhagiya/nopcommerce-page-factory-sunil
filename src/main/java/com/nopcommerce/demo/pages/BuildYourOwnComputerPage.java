package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BuildYourOwnComputerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement buildYourOwnComputer;

    @CacheLookup
    @FindBy(name = "product_attribute_1")
    WebElement processorName;
    @CacheLookup
    @FindBy(name = "product_attribute_2")
    WebElement ram;

    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_3_7']")
    WebElement HDD;

    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_4_9']")
    WebElement OS;

    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_5_12']")
    WebElement software;

    @CacheLookup
    @FindBy(xpath = "//span[text() = '$1,475.00']")
    WebElement price;

    @CacheLookup
    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[5]/div[1]/p[1]")
    WebElement message;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[5]/div[1]/span[1]")
    WebElement closeBar;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement shoppingCart;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement clickCart;


    public String VerifytheTextBuildyourowncomputer() {
        Reporter.log("Get Text Message" + buildYourOwnComputer.toString());
        CustomListeners.test.log(Status.PASS, "Get Tex tMessage ");
        return getTextFromElement(buildYourOwnComputer);
    }

    public void selectProcessor(String text) {
        Reporter.log("Select on Processor Name" + processorName.toString());
        selectByValueFromDropDown(processorName, text);
        CustomListeners.test.log(Status.PASS, "Select on Processor Name" +text);
    }

    public void selectRam(String text) {
        Reporter.log("Select Ram" + ram.toString());
        selectByValueFromDropDown(ram, text);
        CustomListeners.test.log(Status.PASS, "Select Ram"+text);
    }

    public void selectHDDRadio() {
        Reporter.log("Select HDD" + HDD.toString());
        clickOnElement(HDD);
        CustomListeners.test.log(Status.PASS, "Click on HDD ");
    }

    public void selectOSRadiVistaPremium() {
        Reporter.log("Select OS" + OS.toString());
        clickOnElement(OS);
        CustomListeners.test.log(Status.PASS, "Select on OS ");
    }

    public void selectSoftware() {
        Reporter.log("Select software" + software.toString());
        clickOnElement(software);
        CustomListeners.test.log(Status.PASS, "Select on software ");
    }

    public String VerifythePrice() {
        Reporter.log("Verify Price" + price.toString());
        CustomListeners.test.log(Status.PASS, "Verify Price");
        return getTextFromElement(price);
    }

    public void clickOnAddToCartButton() {
        Reporter.log("Click on Cart Button" + addToCart.toString());
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "Click on Cart Button");
    }

    public String VerifytheMessageOnTopGreenbar() {
        Reporter.log("Verify Message on Top Green Bar" + message.toString());
        CustomListeners.test.log(Status.PASS, "Verify Message on Top Green Bar");
        return getTextFromElement(message);
    }

    public void clickOnCloseBar() {
        Reporter.log("Click on Close Bar" + closeBar.toString());
        clickOnElement(closeBar);
        CustomListeners.test.log(Status.PASS, "Click on Close Bar");
    }

    public void mouseHoverOnShoppingCart() {
        Reporter.log("Mouse Hover On Shopping Cart" + shoppingCart.toString());
        mouseHoverToElement(shoppingCart);
        CustomListeners.test.log(Status.PASS, "Mouse Hover On Shopping Cart");
    }

    public void clickOnShoppingCart() {
        Reporter.log("Click On Shopping Cart" + clickCart.toString());
        clickOnElement(clickCart);
        CustomListeners.test.log(Status.PASS, "Click On Shopping Cart");
    }
}
