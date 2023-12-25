package com.test;

import org.testng.annotations.Test;
import pageObjects.AllPageObjectsNativeApp;
import utils.AndroidGestures;
import utils.MobileActions;

import java.util.Arrays;
import java.util.List;

public class TestScenarios_ApiDemos_Native extends AllPageObjectsNativeApp {

    @Test(enabled = true, groups = {"apiDemo"}, priority = 0)
    public void wifiSetting() throws InterruptedException {
        homePage.clickPreference();
        preferencePage.clickPreferenceDependencies();
        preferenceDependencies.checkTheWifiCheckbox();
        preferenceDependencies.clickWifiSettings();
        preferenceDependencies.verifyAlertTitle("WiFi settings");
        preferenceDependencies.enterWifiSettings("TEST: WIFI SETTINGS");
        preferenceDependencies.clickOkWifiSettings();
        MobileActions.getMobileActionsObj().clickBackOnMobile(2);
    }

    @Test(enabled = true, groups = {"apiDemo"}, priority = 1)
    public void verifyFeaturesAvailableOnAppHome() {
        List<String> expectedFeatures = Arrays.asList("Access'ibility", "Accessibility", "Animation", "App", "Content", "Graphics", "Media", "NFC", "OS", "Preference", "Text", "Views");
        homePage.verifyAllFeaturesOnHome(expectedFeatures);
    }

    @Test(enabled = true, groups = {"apiDemo"}, priority = 2)
    public void longPressOnOptionsPresent_view_expandableList_customAdapter_sequenceActions() {
        homePage.clickViews();
        viewsPage.clickExpandableLists();
        expandableLists.clickCustomAdapter();
        customAdapter.longClickWithSequence("People Names");
        customAdapter.verifySubMenu(Arrays.asList("Sample menu", "Sample action"));
        MobileActions.getMobileActionsObj().clickBackOnMobile(1);
    }


    //    Reference - https://appium.github.io/appium.io/docs/en/writing-running-appium/android/android-mobile-gestures/
    @Test(enabled = true, groups = {"apiDemo"},priority = 3)
    public void longPressOnOptionsPresent_view_expandableList_customAdapter_usingExtensionMethod_webElement() {
        customAdapter.longClickWithJavaScriptWithWebElement("Dog Names");
        customAdapter.verifySubMenu(Arrays.asList("Sample menu", "Sample action"));
        MobileActions.getMobileActionsObj().clickBackOnMobile(1);
    }

    @Test(enabled = true, groups = {"apiDemo"},priority = 4)
    public void longPressOnOptionsPresent_view_expandableList_customAdapter_usingExtensionMethod_coordinates() {
        customAdapter.longClickWithJavaScriptWithCoordinates("Cat Names");
        customAdapter.verifySubMenu(Arrays.asList("Sample menu", "Sample action"));
        MobileActions.getMobileActionsObj().clickBackOnMobile(3);
    }

    @Test(enabled = true, groups = {"apiDemo"}, priority = 5)
    public void scrollTillViewElement_UsingAndroidUIAutomationLocator(){
        viewsPage.scrollTillText("Picker");
    }

    @Test(enabled = true, groups = {"apiDemo"}, priority = 6)
    public void scroll_UsingSequenceActions() {
        viewsPage.scrollWithSequenceActions();

    }

    @Test(enabled = true, groups = {"apiDemo"}, priority = 7)
    public void scrollTillEnd(){
        viewsPage.scrollTillEnd();
    }

    @Test(enabled = true, groups = {"apiDemo"}, priority = 8)
    public void scrollBackwards(){
        viewsPage.scrollBackText("Gallery");
        viewsPage.clickGallery();
    }

    @Test(enabled = true, groups = {"apiDemo"}, priority = 9)
    public void swipeTest() {
        galleryPage.clickPhotos();
        photosPage.verifyFirstPhotoFocusable("true");
        photosPage.swipePhoto("left");
        photosPage.verifyFirstPhotoFocusable("false");
        MobileActions.getMobileActionsObj().clickBackOnMobile(2);

    }

    @Test(enabled = true, groups = {"apiDemo"}, priority = 10)
    public void dragAndDrop() {
        viewsPage.clickDragAndDrop();
        dragAndDropPage.dragTheElementAt(620, 497);
        dragAndDropPage.verifyTheDropMessage("Dropped!");
        MobileActions.getMobileActionsObj().clickBackOnMobile(2);
    }

    @Test(enabled = true, groups = {"apiDemo"}, priority = 11)
    public void alerts() {
        homePage.clickApp();
        appPage.clickAlertDialogs();
        alertDialogs.clickOkCancelDialogWithMessage();
        alertDialogs.verifyMessageOnDialog("Lorem ipsum dolor sit aie consectetur adipiscing\n" +
                "Plloaso mako nuto siwuf cakso dodtos anr koop.");
        alertDialogs.clickOkOnAlert();
        MobileActions.getMobileActionsObj().clickBackOnMobile(2);
    }

    @Test(enabled = true, groups = {"apiDemo"}, priority = 12)
    public void changeOrientationAndPasteDataFromClipboard(){
        homePage.clickPreference();
        preferencePage.clickPreferenceDependencies();
        preferenceDependencies.checkTheWifiCheckbox();
        MobileActions.getMobileActionsObj().changeToLandScapeMode();
        preferenceDependencies.clickWifiSettings();
        preferenceDependencies.verifyAlertTitle("WiFi settings");
//        pasting data from clipboard
        MobileActions.getMobileActionsObj().setClipboardText("TEST: COPY FROM CLIPBOARD");
        preferenceDependencies.enterWifiSettingsFromClipBoard();
        preferenceDependencies.clickOkWifiSettings();
//        Pressing mobile Home keys
        MobileActions.getMobileActionsObj().clickHomeOnMobile();
    }

    /**
     * NOTE: BEFORE RUNNING THIS TEST CASE, UNCOMMENT THE setAppPackage and setAppActivity capabilities in Base class. And Comment 1st line of below test case to launch application directly
     * Keep comment setAppPackage and setAppActivity capabilities in Base class and it will launch to home page and then switch directly to the provided activity.
     */
    @Test(enabled = true, groups = {"apiDemo"}, priority = 13)
    public void directlyOpenActivity() throws InterruptedException {
        AndroidGestures.getAndroidGesturesObj().switchActivity("io.appium.android.apis/.preference.PreferenceDependencies");
        preferenceDependencies.checkTheWifiCheckbox();
        preferenceDependencies.clickWifiSettings();
        preferenceDependencies.enterWifiSettings("TEST: DIRECT LAUNCH APP ACTIVITY");
        preferenceDependencies.clickOkWifiSettings();
    }

}
