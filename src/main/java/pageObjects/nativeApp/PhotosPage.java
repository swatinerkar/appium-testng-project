package pageObjects.nativeApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidGestures;

public class PhotosPage {
    @AndroidFindBy(xpath = "(//android.widget.ImageView)[1]")
    private WebElement firstPhoto;
    private AndroidDriver driver;
    public PhotosPage(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyFirstPhotoFocusable(String expectedFosusable) {
        Assert.assertEquals(firstPhoto.getAttribute("focusable"), expectedFosusable);
    }

    public void swipePhoto(String directionOfSwipe) {
        AndroidGestures.getAndroidGesturesObj().swipe(firstPhoto, directionOfSwipe);
    }
}
