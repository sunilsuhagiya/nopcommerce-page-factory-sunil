package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeskTopPage extends Utility {
    @CacheLookup
    @FindBy(name = "products-orderby")
    WebElement sortByName;

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
    WebElement addToCart;



    public void selectSortByName(String text) {
        Reporter.log("Select Sort By Name" + sortByName.toString());
        selectByVisibleTextFromDropDown(sortByName, text);
        CustomListeners.test.log(Status.PASS, "Select Sort By Name" + text);
    }

    public void clickOnAddToCart() {
        Reporter.log("Click On Add To Cart" + addToCart.toString());
        try {
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        } catch (StaleElementReferenceException e) {
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        }
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "Click On Add To Cart");
    }

    public Map<String, ArrayList> arrangeProductInDescendingOrder() {
        Reporter.log("arrange Product In Descending Order" + addToCart.toString());
        Map<String, ArrayList> mapArrays = new HashMap<String, ArrayList>();
        List<WebElement> products = driver.findElements(By.xpath("//h2/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        System.out.println(originalProductsName);
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: Z to A");
        products = driver.findElements(By.xpath("//h2/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        mapArrays.put("originalProductsName", originalProductsName);
        mapArrays.put("afterSortByZToAProductsName", afterSortByZToAProductsName);
        CustomListeners.test.log(Status.PASS, "arrange Product In Descending Order");
        return mapArrays;

    }
}
