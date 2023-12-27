package com.test;


import org.testng.annotations.Test;
import pageObjects.AllPageObjectsHybridApp;
import utils.AndroidGestures;


public class TestScenarios_GeneralStore_Hybrid extends AllPageObjectsHybridApp {

    /**
     * All toast message are always being tagged with "android.widget.Toast". If there is more than one toast msgs when use position such as 1, 2
     * getText() method is not applicable for toast msgs. Use getAttribute("name")
     */
    @Test(groups = {"hybrid"}, enabled = true, priority = -1)
    public void verifyToastMsg() throws InterruptedException {
        loginFormPage.clickCountryDropDown();
        loginFormPage.selectCountry("Australia");
        loginFormPage.selectGender("female");
        loginFormPage.clickLetsShopBtn();
        loginFormPage.verifyToastMsg("Please enter your name");
    }
    @Test(groups = {"hybrid"}, enabled = true, priority = 0)
    public void fillLoginForm() throws InterruptedException {
        loginFormPage.clickCountryDropDown();
        loginFormPage.selectCountry("Austria");
        loginFormPage.enterName("Amit");
        loginFormPage.selectGender("male");
        loginFormPage.clickLetsShopBtn();
    }

    @Test(groups = {"hybrid"}, enabled = true, priority = 1)
    public void selectProducts() throws InterruptedException {
        productListPage.verifyProductsPageTitle("Products");
        productListPage.addProductToCartByText("Converse All Star");
        productListPage.addProductToCartByText("Jordan 6 Rings");
        productListPage.verifyNumberOfProductsAdd("2");
        productListPage.clickCartIcon();
    }

    @Test(groups = {"hybrid"}, enabled = true, priority = 2)
    public void verifyTotalPriceOnCart() throws InterruptedException {
        double totalAmt = cartPage.calculateTotalAmtOfAllItemsPresentInCart();
        cartPage.verifyTotalWithPayablePricePresentOnPage(totalAmt);
        cartPage.openReadTermsAndConditions();
        cartPage.verifyTitleOnTermAndConditionsAlert("Terms Of Conditions");
        cartPage.clickOkBtnOnTermAlert();
        cartPage.clickCheckboxSendEmails();
        cartPage.clickVisitWebSiteBtn();
    }

//      Need to change driver from android to web
//      Refer: https://appium.github.io/appium.io/docs/en/writing-running-appium/web/hybrid/
    @Test(groups = {"hybrid"},enabled = true, priority = 3)
    public void hybridApp() throws InterruptedException {
        Thread.sleep(8000);
        hybridWebPage.printListOfContext();
        hybridWebPage.switchContextToWeb("WEBVIEW_com.androidsample.generalstore");
        hybridWebPage.searchWithText("Swati Nerkar");
        hybridWebPage.pressMobileBackBtn();
        hybridWebPage.switchContextToNative();
    }

    @Test(groups = {"hybrid"},enabled = true, priority = 4)
    public void directMoveActivity() throws InterruptedException {
        fillLoginForm();
        productListPage.verifyProductsPageTitle("Products");
        AndroidGestures.getAndroidGesturesObj().switchActivity("com.androidsample.generalstore/.MainActivity");
    }
}
