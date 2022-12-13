package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerPageText;
    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailId;
    @CacheLookup
    @FindBy(id = "Password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(id = "register-button")
    WebElement registerButton;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registrationPageText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButtonText;


    public String verifyRegisterText(){
        Reporter.log("verify Register Text" + registerPageText.toString());
        CustomListeners.test.log(Status.PASS, "verify Register Text");
        return getTextFromElement(registerPageText);
    }

    public void enterFirstName(String text){
        Reporter.log("Enter First Name" + firstName.toString());
        sendTextToElement(firstName,text + getAlphaNumericString(5));
        CustomListeners.test.log(Status.PASS, "Enter First Name" + text);
    }
    public void enterLastName(String text){
        Reporter.log("Enter Last Name" + lastName.toString());
        sendTextToElement(lastName,text + getAlphaNumericString(5));
        CustomListeners.test.log(Status.PASS, "Enter Last Name"+ text);
    }
    public void enterEmail(String text){
        Reporter.log("Enter Email" + emailId.toString());
        sendTextToElement(emailId,text );
        CustomListeners.test.log(Status.PASS, "Enter Email"+ text);
    }
    public void enterPassword(String text){
        Reporter.log("Enter Password" + password.toString());
        sendTextToElement(password,text);
        CustomListeners.test.log(Status.PASS, "Enter Password"+ text);
    }
    public void enterConfirmPassword(String text){
        Reporter.log("Enter Confirm Password" + confirmPassword.toString());
        CustomListeners.test.log(Status.PASS, "Enter Confirm Password"+ text);
        sendTextToElement(confirmPassword, text);
    }

    public void clickOnRegisterButton(){
        Reporter.log("Click on Register button" + registerButton.toString());
        clickOnElement(registerButton);
        CustomListeners.test.log(Status.PASS, "Click on Register button");
    }

    public String verifyRegistrationText(){
        Reporter.log("Registration Page Text" + registrationPageText.toString());
        CustomListeners.test.log(Status.PASS, "Registration Page Text");
        return getTextFromElement(registrationPageText);
    }

    public void clickOnContinueButton(){
        Reporter.log("Click on Continue button" + continueButtonText.toString());
        clickOnElement(continueButtonText);
        CustomListeners.test.log(Status.PASS, "Click on Continue Password");
    }



}
