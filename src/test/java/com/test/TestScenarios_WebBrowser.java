package com.test;

import org.testng.annotations.Test;
import pageObjects.AllPageObjectsWebBrowser;

public class TestScenarios_WebBrowser extends AllPageObjectsWebBrowser {

    @Test(groups = {"web"})
    public void testWebAppOnBrowser(){
        homePage.launchWebApp("https://swatinerkar.wordpress.com/");
        homePage.verifyTheTitleOfPage("SWATI NERKAR");
        homePage.clickOpenMenuIcon();
        homePage.clickPortfolioOption();
        homePage.scrollTillTextVisible("Mobile Automation");
        homePage.verifySectionIsDisplayed("Mobile Automation");

    }
}
