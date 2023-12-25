package pageObjects.nativeApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GalleryPage {

    @AndroidFindBy(accessibility = "1. Photos")
    private WebElement photos;

    private AndroidDriver driver;
    public GalleryPage(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickPhotos() {
        photos.click();
    }


}
