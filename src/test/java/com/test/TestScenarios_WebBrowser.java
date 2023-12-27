package com.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AllPageObjectsWebBrowser;

public class TestScenarios_WebBrowser extends AllPageObjectsWebBrowser {

    @Test(groups = {"web"}, dataProvider = "TestData_WebBrowser")
    public void testWebAppOnBrowser(String url, String expectedTitle, String portfolioSectionName){
        homePage.launchWebApp(url);
        homePage.verifyTheTitleOfPage(expectedTitle);
        homePage.clickOpenMenuIcon();
        homePage.clickPortfolioOption();
        homePage.scrollTillTextVisible(portfolioSectionName);
        homePage.verifySectionIsDisplayed(portfolioSectionName);
    }

    @DataProvider(name = "TestData_WebBrowser")
    public Object[][] testData_WebBrowser(){
        return new Object[][] {
                {"https://swatinerkar.wordpress.com/", "SWATI NERKAR", "Mobile Automation"},
        };
    }
}
