package pageObjects.nativeApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PreferencePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")
    private WebElement preferenceDependencies;
    private AndroidDriver driver;
    public PreferencePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickPreferenceDependencies() {
        preferenceDependencies.click();
    }

}
