package pageObjects;

import org.testng.annotations.BeforeMethod;
import pageObjects.webBrowser.HomePage;
import testBase.Base;

public class AllPageObjectsWebBrowser extends Base {
    protected HomePage homePage;

    @BeforeMethod(groups = {"web"},onlyForGroups = {"web"})
    public void initPages(){
        homePage = new HomePage(driver);

    }

}
