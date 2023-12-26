package pageObjects;

import org.testng.annotations.BeforeMethod;
import pageObjects.hybridApp.CartPage;
import pageObjects.hybridApp.HybridWebPage;
import pageObjects.hybridApp.LoginFormPage;
import pageObjects.hybridApp.ProductListPage;
import testBase.Base;

public class AllPageObjectsHybridApp extends Base {

    protected LoginFormPage loginFormPage;
    protected ProductListPage productListPage;
    protected CartPage cartPage;
    protected HybridWebPage hybridWebPage;

    @BeforeMethod(groups = {"hybrid"}, onlyForGroups = {"hybrid"})
    public void initPages(){
        loginFormPage = new LoginFormPage(driver);
        productListPage = new ProductListPage(driver);
        cartPage = new CartPage(driver);
        hybridWebPage = new HybridWebPage(driver);
    }


}
