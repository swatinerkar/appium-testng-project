package pageObjects.nativeApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidGestures;
import utils.ExplicitlyWait;

public class ViewsPage {

    @AndroidFindBy(accessibility = "Expandable Lists")
    private WebElement expandableLists;

    @AndroidFindBy(accessibility = "Gallery")
    private WebElement gallery;

    @AndroidFindBy(accessibility = "Drag and Drop")
    private WebElement dragAndDrop;

    private AndroidDriver driver;
    public ViewsPage(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickExpandableLists() {
        expandableLists.click();
    }



    public void scrollTillEnd() {
        AndroidGestures.getAndroidGesturesObj().scrollTillEnd();
    }

    public void clickGallery() {
        ExplicitlyWait.getWait().waitUntilElementVisible(gallery);
        gallery.click();
    }

    public void scrollBackText(String textToVisible) {
        AndroidGestures.getAndroidGesturesObj().scrollBackwardsTillTextVisible(textToVisible);
    }

    public void scrollTillText(String textToVisible) {
        AndroidGestures.getAndroidGesturesObj().scrollTillTextVisible(textToVisible);
    }

    public void clickDragAndDrop() {
        dragAndDrop.click();
    }

    public void scrollWithSequenceActions() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth()/2;
        int startY = size.getHeight()/2;
        int endX = startX;
        int endY = startY / 2;
        AndroidGestures.getAndroidGesturesObj().scrollWithSequence(startX, startY, endX, endY);
    }
}
