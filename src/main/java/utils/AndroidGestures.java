package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import testBase.Base;

import java.time.Duration;
import java.util.Collections;

public class AndroidGestures {
    private static AndroidDriver driver;
    private static AndroidGestures androidGestures = new AndroidGestures();
    private AndroidGestures(){}

    public static AndroidGestures getAndroidGesturesObj() {
        driver = Base.getDriverObj();
        return androidGestures;
    }

    public void longPressWithSequence(int x, int y){
        Point centerOfElement = new Point(x, y);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofSeconds(1)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public void longPressWithElement(WebElement elementToBeClickedForLong){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) elementToBeClickedForLong).getId(), "duration", 10000)
        );
    }

    public void longPressWithOffsets(int x, int y){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x",x, "y", y, "duration", 20000)
        );
    }

    public void scrollTillTextVisible(String elementText) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"));"));
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+elementText+"\").instance(0));"));
    }

    public void scrollBackwardsTillTextVisible(String elementText) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+elementText+"\")).scrollBackward()"));
    }

    public void scrollWithSequence(int startX, int startY, int endX, int endY){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        int i=0;
        do {
            driver.perform(Collections.singletonList(sequence));
            i++;
        }while(i<1);
    }

    public void scrollTillEnd(){
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while(canScrollMore);
    }

    public void swipe(WebElement element, String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    /**
     *
     * @param  activity appPackage/.appActivity
     */
    public void switchActivity(String activity) throws InterruptedException {
       driver.executeScript("mobile: startActivity", ImmutableMap.of("intent", activity));
        Thread.sleep(2000);
    }

    public void dragAndDrop(WebElement elementToBeDragged, int x, int y){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) elementToBeDragged).getId(),
                "endX", x,
                "endY", y
        ));
    }

    public int[] getCenterCoordinatesOfWebElement(WebElement elementToBeClickedForLong) {
        Dimension size = elementToBeClickedForLong.getSize();
        Point location = elementToBeClickedForLong.getLocation();

        int x = location.getX() + size.getWidth() / 2;
        int y = location.getY() + size.getHeight() / 2;
        return new int[]{x, y};
    }
}
