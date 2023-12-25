package pageObjects.nativeApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidGestures;

public class DragAndDropPage {

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    private WebElement firstCircle;
    @AndroidFindBy(id = "io.appium.android.apis:id/drag_result_text")
    private WebElement dropMessage_txt;
    private AndroidDriver driver;
    public DragAndDropPage(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * @param x coordinateDropPosition
     * @param y coordinateDropPosition
     */
    public void dragTheElementAt(int x, int y) {
        AndroidGestures.getAndroidGesturesObj().dragAndDrop(firstCircle, 620, 497);
    }

    public void verifyTheDropMessage(String expectedMsg) {
        Assert.assertEquals(dropMessage_txt.getText(), "Dropped!");
    }
}
