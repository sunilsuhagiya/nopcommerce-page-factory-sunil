package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ElectronicsTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";
    HomePage homePage;
    CellPhonesPage cellPhonesPage;
    NokiaLumiaPage nokiaLumiaPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutAsGuest checkOutAsGuest;
    RegisterPage registerPage;
    BillingCheckOutPage billingCheckOutPage;
    ShippingMethodCheckoutPage shippingMethodCheckoutPage;
    PaymentMethodCheckOut paymentMethodCheckOut;
    PaymentCheckOut paymentCheckOut;
    ConfirmOrderPage confirmOrderPage;
    CompletedCheckoutPage completedCheckoutPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        cellPhonesPage = new CellPhonesPage();
        nokiaLumiaPage = new NokiaLumiaPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutAsGuest = new CheckOutAsGuest();
        registerPage = new RegisterPage();
        billingCheckOutPage = new BillingCheckOutPage();
        shippingMethodCheckoutPage = new ShippingMethodCheckoutPage();
        paymentMethodCheckOut = new PaymentMethodCheckOut();
        paymentCheckOut = new PaymentCheckOut();
        confirmOrderPage = new ConfirmOrderPage();
        completedCheckoutPage = new CompletedCheckoutPage();
        softAssert = new SoftAssert();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        homePage.mouseHoverOnElectronics();
        homePage.mouseHoverOnCellPhonesAndClick();
        softAssert.assertEquals(cellPhonesPage.verifyCellPhonesText(), "Cell phones", "Text is not displayed");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException{

        homePage.mouseHoverOnElectronics();
        homePage.mouseHoverOnCellPhonesAndClick();
        softAssert.assertEquals(cellPhonesPage.verifyCellPhonesText(), "Cell phones", "Text is not displayed");
        cellPhonesPage.clickOnListView();
        Thread.sleep(1000);
        cellPhonesPage.clickOnNokiaLumia();
        softAssert.assertEquals(nokiaLumiaPage.verifyNokiaLumiaText(), "Nokia Lumia 1020", "Text not displayed");
        softAssert.assertEquals(nokiaLumiaPage.verifyNokiaPrice(), "$349.00", "Price not displayed");
        nokiaLumiaPage.changeNokiaQuantity();
        nokiaLumiaPage.nokiaAddToCartButton();
        softAssert.assertEquals(nokiaLumiaPage.productAddedToTheCartMessage(), "The product has been added to your shopping cart", "Product not added to Cart");
        nokiaLumiaPage.clickOnCrossButton();
        nokiaLumiaPage.clickOnShoppingCartLink();
        softAssert.assertEquals(shoppingCartPage.verifyShoppingCartText(), "Shopping cart", "Text is not displayed");
        softAssert.assertEquals(shoppingCartPage.verifyProductQuantity(), "2", "Quantity is not matching" );
        softAssert.assertEquals(shoppingCartPage.verifyTotalPrice(), "$698.00", "Price is not matching" );
        shoppingCartPage.clickOnTermsOfService();
        shoppingCartPage.clickOnCheckOutButton();
        checkOutAsGuest.verifyWelComeText();
        checkOutAsGuest.clickOnRegisterTab();
        softAssert.assertEquals(registerPage.verifyRegisterText(), "Register", "Register text is not displayed");
        registerPage.enterFirstName("Shane");
        registerPage.enterLastName("Jhones");
        registerPage.enterEmail("shane12jhones@example.com");
        registerPage.enterPassword("shane12345");
        registerPage.enterConfirmPassword("shane12345");
        registerPage.clickOnRegisterButton();
        softAssert.assertEquals(registerPage.verifyRegistrationText(), "Your registration completed", "Text not displayed");
        registerPage.clickOnContinueButton();
        softAssert.assertEquals(shoppingCartPage.verifyShoppingCartText(),"Shopping cart", "Text not displayed");
        shoppingCartPage.clickOnTermsOfService();
        shoppingCartPage.clickOnCheckOutButton();
        billingCheckOutPage.selectCountryFromDropDown("1");
        billingCheckOutPage.selectStateFromDropDown("49");
        billingCheckOutPage.enterBillingCity("New York");
        billingCheckOutPage.enterBillingAddress("Procter Close");
        billingCheckOutPage.enterBillingZipcode("380019");
        billingCheckOutPage.enterBillingPhoneNumber("9876543456");
        billingCheckOutPage.clickOnContinueButton();
        shippingMethodCheckoutPage.clickOnRadioButtonSecondDayAir();
        shippingMethodCheckoutPage.clickOnContinue();
        paymentMethodCheckOut.clickOnCreditCard();
        paymentMethodCheckOut.clickOnContinue();
        paymentCheckOut.selectCardTypeFromDropDown("visa");
        paymentCheckOut.enterCardHolderName("Shanes Jhones");
        paymentCheckOut.enterCardNumber("4222222222222");
        paymentCheckOut.selectExpiryMonthFromDropDown("9");
        paymentCheckOut.selectExpiryYearFromDropDown("2023");
        paymentCheckOut.enterCardCode("234");
        paymentCheckOut.clickOnContinueButton();
        softAssert.assertEquals(confirmOrderPage.VerifyCreditCardPaymentMethod(), "Credit Card");
        softAssert.assertEquals(confirmOrderPage.verifySecondDayAir(), "2nd Day Air", "Text is not matched");
        softAssert.assertEquals(confirmOrderPage.verifyNokiaTotalPrice(), "$698.00", "Price is not matched");
        confirmOrderPage.clickOnConFirm();
        softAssert.assertEquals(completedCheckoutPage.verifyThankYouText(),"Thank you","Text is not displayed");
        softAssert.assertEquals(completedCheckoutPage.verifySucessOrderText(),"Your order has been successfully processed!","Text isnot Display");
        completedCheckoutPage.clickOnContinue();
        softAssert.assertEquals(homePage.verifyWelComeText(),"Welcome to our store","Text is not displayed");
        homePage.clickOnLogoutButton();
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(baseUrl,currentUrl,"Invalid URL");
        softAssert.assertAll();
    }
}
