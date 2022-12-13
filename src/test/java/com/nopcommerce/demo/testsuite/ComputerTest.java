package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Map;

public class ComputerTest extends BaseTest {

    HomePage homePage;
    DeskTopPage deskTopPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutAsGuest checkOutAsGuestPage;
    BillingCheckOutPage checkOutPage;
    ShippingMethodCheckoutPage checkoutPage1;
    PaymentMethodCheckOut checkOutPage2;
    PaymentCheckOut checkOutPage3;
    ConfirmOrderPage confirmOrderPage;
    CompletedCheckoutPage completedCheckoutPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        deskTopPage = new DeskTopPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutAsGuestPage = new CheckOutAsGuest();
        checkOutPage = new BillingCheckOutPage();
        checkoutPage1 = new ShippingMethodCheckoutPage();
        checkOutPage2 = new PaymentMethodCheckOut();
        checkOutPage3 = new PaymentCheckOut();
        confirmOrderPage = new ConfirmOrderPage();
        completedCheckoutPage = new CompletedCheckoutPage();
        softAssert = new SoftAssert();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphaBaticalOrder(){
        homePage.selectMenu("computers");
        homePage.clickOnDeskTop();
        deskTopPage.selectSortByName("Name: A to Z");
        Map<String, ArrayList> mapArrays = deskTopPage.arrangeProductInDescendingOrder();
        softAssert.assertEquals(mapArrays.get("originalProductsName"), mapArrays.get("afterSortByZToAProductsName"));
    }

    @Test(groups = {"smoke","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.selectMenu("computers");
        homePage.clickOnDeskTop();
        deskTopPage.selectSortByName("Name: A to Z");
        Thread.sleep(5000);
        deskTopPage.clickOnAddToCart();
        softAssert.assertEquals(buildYourOwnComputerPage.VerifytheTextBuildyourowncomputer(),"Build your own computer" , "Text is not Display");
        buildYourOwnComputerPage.selectProcessor("1");
        buildYourOwnComputerPage.selectRam("5");
        buildYourOwnComputerPage.selectHDDRadio();
        buildYourOwnComputerPage.selectOSRadiVistaPremium();
        buildYourOwnComputerPage.selectSoftware();
        softAssert.assertEquals(buildYourOwnComputerPage.VerifythePrice(),"$1,475.00" , "Price is not match");
        buildYourOwnComputerPage.clickOnAddToCartButton();
        softAssert.assertEquals(buildYourOwnComputerPage.VerifytheMessageOnTopGreenbar(),"The product has been added to your shopping cart","Message doesnot match");
        buildYourOwnComputerPage.clickOnCloseBar();
        buildYourOwnComputerPage.mouseHoverOnShoppingCart();
        buildYourOwnComputerPage.clickOnShoppingCart();
        softAssert.assertEquals(shoppingCartPage.verifyShoppingCartText(),"Shopping cart","Text is not display");
        Thread.sleep(5000);
        shoppingCartPage.clearTextInQuantityField();
        shoppingCartPage.sendTextToQuantityField();
        shoppingCartPage.UpdateShoppingCart();
        softAssert.assertEquals(shoppingCartPage.VerifytheTotalPrice(),"$2,950.00","Price is not match");
        shoppingCartPage.clickOnCheckBox();
        shoppingCartPage.clickOnCheckOutButton();
        softAssert.assertEquals(checkOutAsGuestPage.verifyWelComeText(),"Welcome, Please Sign In!","Text is not matched");
        checkOutAsGuestPage.clickOnAsGuestButton();
        checkOutPage.enterBillingFirstName("John");
        checkOutPage.enterBillingLastName("Smith");
        checkOutPage.enterBillingEmailAddress("john@example.com");
        checkOutPage.selectCountryFromDropDown("233");
        checkOutPage.selectStateFromDropDown("0");
        checkOutPage.enterBillingCity("London");
        checkOutPage.enterBillingAddress("4,Oxford Street");
        checkOutPage.enterBillingZipcode("W2 4TR");
        checkOutPage.enterBillingPhoneNumber("5665995116994");
        checkOutPage.clickOnCheckOutButton();
        Thread.sleep(5000);
        checkoutPage1.clickOnRadioButtonTextDayAir();
        checkoutPage1.clickOnContinue();
        checkOutPage2.clickOnCreditCard();
        checkOutPage2.clickOnContinue();
        checkOutPage3.enterCardHolderName("John Smith");
        checkOutPage3.enterCardNumber("5555555555554444");
        checkOutPage3.selectExpiryMonthFromDropDown("5");
        checkOutPage3.selectExpiryYearFromDropDown("2024");
        checkOutPage3.enterCardCode("3101");
        checkOutPage3.clickOnContinueButton();
        softAssert.assertEquals(confirmOrderPage.VerifyCreditCardPaymentMethod(),"Credit Card","Method is not correct");
        softAssert.assertEquals(confirmOrderPage.VerifyShippingMethod(),"Next Day Air","method is not correct");
        softAssert.assertEquals(confirmOrderPage.VerifytheTotalPrice(),"$2,950.00","Price is not Match");
        confirmOrderPage.clickOnConFirm();
        softAssert.assertEquals(completedCheckoutPage.verifyThankYouText(),"Thank you","Text is not displayed");
        softAssert.assertEquals(completedCheckoutPage.verifySucessOrderText(),"Your order has been successfully processed!","Text isnot Display");
        completedCheckoutPage.clickOnContinue();
        softAssert.assertEquals(homePage.verifyWelComeText(),"Welcome to our store","Text is not displayed");
        softAssert.assertAll();
    }
}
