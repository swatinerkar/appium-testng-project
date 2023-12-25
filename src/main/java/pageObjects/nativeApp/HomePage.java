package pageObjects.nativeApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidGestures;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private AndroidDriver driver;

    @AndroidFindBy(accessibility = "Preference")
    private WebElement preference;

    @AndroidFindBy(id = "android:id/text1")
    private List<WebElement> listOfFeaturesWebElements;

    @AndroidFindBy(accessibility = "Views")
    private WebElement views;

    @AndroidFindBy(accessibility = "App")
    private WebElement app;
    public HomePage(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickPreference() {
        preference.click();
    }

    public void navigateToHomePage(String homePageActivity) throws InterruptedException {
        AndroidGestures.getAndroidGesturesObj().switchActivity(homePageActivity);
    }

    public void verifyAllFeaturesOnHome(List<String> expectedFeatures) {
        List<String> actualFeatures = new ArrayList<>();
        for(int i = 0;i<listOfFeaturesWebElements.size();i++ ){
            actualFeatures.add(listOfFeaturesWebElements.get(i).getText());
        }
        System.out.println(actualFeatures);
        Assert.assertEquals(actualFeatures, expectedFeatures);
    }

    public void clickViews() {
        views.click();
    }

    public void clickApp() {
        app.click();

    }
}
