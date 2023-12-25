package pageObjects.nativeApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ExpandableLists {

    @AndroidFindBy(accessibility = "1. Custom Adapter")
    private WebElement customAdapter;
    private AndroidDriver driver;
    public ExpandableLists(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickCustomAdapter() {
        customAdapter.click();
    }
}
