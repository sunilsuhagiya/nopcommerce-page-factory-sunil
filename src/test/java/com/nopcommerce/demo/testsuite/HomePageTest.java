package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyPageNavigationComputer() {
        homePage.selectMenu("computers");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyPageNavigationElectronics() {
        homePage.selectMenu("electronics");
    }

    @Test(groups = {"regression"})
    public void verifyPageNavigationApparel() {
        homePage.selectMenu("apparel");
    }

    @Test(groups = {"regression"})
    public void verifyPageNavigationDigitalDownloads() {
        homePage.selectMenu("digital-downloads");
    }

    @Test(groups = {"regression"})
    public void verifyPageNavigationBooks() {
        homePage.selectMenu("books");
    }

    @Test(groups = {"regression"})
    public void verifyPageNavigationJewelry() {
        homePage.selectMenu("jewelry");
    }

    @Test(groups = {"regression"})
    public void verifyPageNavigationGiftCards() {
        homePage.selectMenu("gift-cards");
    }

}
