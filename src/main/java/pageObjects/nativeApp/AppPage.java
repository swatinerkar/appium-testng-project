package pageObjects.nativeApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AppPage {
    @AndroidFindBy(accessibility = "Alert Dialogs")
    private WebElement alertDialogs;
    private AndroidDriver driver;
    public AppPage(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickAlertDialogs() {
        alertDialogs.click();
    }
}
