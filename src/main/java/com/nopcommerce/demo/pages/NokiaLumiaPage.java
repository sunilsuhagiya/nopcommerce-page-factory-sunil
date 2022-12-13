package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class NokiaLumiaPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Nokia Lumia 1020')]")
    WebElement nokiaLumiaText;
    @CacheLookup
    @FindBy(xpath = "//span[@id='price-value-20']")
    WebElement nokiaPrice;
    @CacheLookup
    @FindBy(css = "#add-to-cart-button-20")
    WebElement nokiaAddToCartLink;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/p[1]")
    WebElement productAddedText;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/span[1]")
    WebElement crossButtonLink;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement shoppingCartLink;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement mouseHoverShoppingCart;


    public String verifyNokiaLumiaText() {
        Reporter.log("Verify Nokia Lumia Text" + nokiaLumiaText.toString());
        CustomListeners.test.log(Status.PASS, "Verify Nokia Lumia Text");
        return getTextFromElement(nokiaLumiaText);
    }

    public String verifyNokiaPrice() {
        Reporter.log("Verify Nokia Price" + nokiaPrice.toString());
        CustomListeners.test.log(Status.PASS, "Verify Nokia Price");
        return getTextFromElement(nokiaPrice);
    }

    public void changeNokiaQuantity() {
        Reporter.log("Change Quantity");
        driver.findElement(By.cssSelector("#product_enteredQuantity_20")).clear();
        sendTextToElement(By.cssSelector("#product_enteredQuantity_20"), "2");
        CustomListeners.test.log(Status.PASS, "Change Quantity");
    }

    public void nokiaAddToCartButton() {
        Reporter.log("Click on Cart" + nokiaAddToCartLink.toString());
        clickOnElement(nokiaAddToCartLink);
        CustomListeners.test.log(Status.PASS, "Click on Cart ");
    }

    public String productAddedToTheCartMessage() {
        Reporter.log("Product Added To The Cart Message" + productAddedText.toString());
        CustomListeners.test.log(Status.PASS, "Product Added To The Cart Message");
        return getTextFromElement(productAddedText);
    }

    public void clickOnCrossButton() {
        Reporter.log("Click on Cross Button" + crossButtonLink.toString());
        clickOnElement(crossButtonLink);
        CustomListeners.test.log(Status.PASS, "Click on Cross Button");
    }

    public void clickOnShoppingCartLink() {
        Reporter.log("Click on Shopping cart link" + shoppingCartLink.toString());
        mouseHoverToElement(mouseHoverShoppingCart);
        clickOnElement(shoppingCartLink);
        CustomListeners.test.log(Status.PASS, "Click on Shopping cart link");
    }
}
