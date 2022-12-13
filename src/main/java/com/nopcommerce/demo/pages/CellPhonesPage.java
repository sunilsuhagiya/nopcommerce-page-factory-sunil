package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CellPhonesPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']/h1[text() = 'Cell phones']")
    WebElement cellPhonesText;

    @CacheLookup
    @FindBy(xpath = "//div/a[text()='List']")
    WebElement listViewLink;

    @CacheLookup
    @FindBy(xpath = "//h2/a[text()='Nokia Lumia 1020']")
    WebElement nokiaLumiaText;


    public String verifyCellPhonesText() {
        Reporter.log("Get Text cell Phones" + cellPhonesText.toString());
        CustomListeners.test.log(Status.PASS, "Get Text cell Phones ");
        return getTextFromElement(cellPhonesText);
    }

    public void clickOnListView() {
        Reporter.log("Click On List View" + listViewLink.toString());
        clickOnElement(listViewLink);
        CustomListeners.test.log(Status.PASS, "Click On List View");
    }

    public void clickOnNokiaLumia() {
        Reporter.log("Click On Nokia Lumia" + nokiaLumiaText.toString());
        clickOnElement(nokiaLumiaText);
        CustomListeners.test.log(Status.PASS, "Click On Nokia Lumia");

    }
}
