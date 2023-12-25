package pageObjects.nativeApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidGestures;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter {

    private AndroidDriver driver;
    public CustomAdapter(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     *      Find the center of a webElement = Point with x, y values
     *      Move finger to the center of a web element
     *      down finger as we click on mouse left button
     *      hold for a long time
     *      up finger as we remove finger from mouse left button click
     * @param longClickOnText
     */
    public void longClickWithSequence(String longClickOnText) {
        WebElement elementToBeClickedForLong = getLongPressWebElement(longClickOnText);
        int coordinates[] = AndroidGestures.getAndroidGesturesObj().getCenterCoordinatesOfWebElement(elementToBeClickedForLong);
        AndroidGestures.getAndroidGesturesObj().longPressWithSequence(coordinates[0],coordinates[1]);
    }

    public <T> void verifySubMenu(List<T> expectedSubMenu) {
        List<WebElement> list_webElements_subMenu = driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\"]"));
        List<String> actualWebElementsSubMenu = new ArrayList<>();
        for (WebElement eachElement : list_webElements_subMenu)
            actualWebElementsSubMenu.add(eachElement.getText());
        System.out.println("List under SubMenu: " + actualWebElementsSubMenu);
        Assert.assertEquals(actualWebElementsSubMenu, expectedSubMenu);

    }

    public void longClickWithJavaScriptWithWebElement(String longClickOnText) {
        WebElement elementToBeClickedForLong = getLongPressWebElement(longClickOnText);
        AndroidGestures.getAndroidGesturesObj().longPressWithElement(elementToBeClickedForLong);
    }

    public void longClickWithJavaScriptWithCoordinates(String longClickOnText) {
        WebElement elementToBeClickedForLong = getLongPressWebElement(longClickOnText);
        int coordinates[] = AndroidGestures.getAndroidGesturesObj().getCenterCoordinatesOfWebElement(elementToBeClickedForLong);
        AndroidGestures.getAndroidGesturesObj().longPressWithOffsets(coordinates[0], coordinates[1]);
    }

    private WebElement getLongPressWebElement(String longClickOnText){
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\""+longClickOnText+"\"]"));
    }
}
