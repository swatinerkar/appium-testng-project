package pageObjects.hybridApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidGestures;
import utils.ExplicitlyWait;

public class ProductListPage {
    AndroidDriver driver;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/counterText")
    private WebElement numberOnCart_txt;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart_icon;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement productsTitle_txt;
    public ProductListPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void addProductToCartByText(String expectedElementText) throws InterruptedException {
//        Thread.sleep(2000);
        AndroidGestures.getAndroidGesturesObj().scrollTillTextVisible(expectedElementText);
        driver.findElement(By.xpath("//*[@text=\""+expectedElementText+"\"]/../android.widget.LinearLayout/android.widget.TextView[@text='ADD TO CART']")).click();
    }

    public void verifyNumberOfProductsAdd(String expectedNumberOfProducts) {
        String actualNumOfItemsInCart=numberOnCart_txt.getText();
        Assert.assertEquals(actualNumOfItemsInCart, "2");
    }

    public void clickCartIcon() {
        cart_icon.click();
    }

    public void verifyProductsPageTitle(String expectedTitle) {
        ExplicitlyWait.getWait().waitUntilElementVisible(productsTitle_txt);
        Assert.assertEquals(productsTitle_txt.getText(), expectedTitle);
    }
}
