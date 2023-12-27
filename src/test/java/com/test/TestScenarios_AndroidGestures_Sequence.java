package com.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.Point;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

/**
 * End to end login logout test case
 * Commented all waits and using appium element-wait plugin
 */

public class TestScenarios_AndroidGestures_Sequence {

    @Test(priority = 0, enabled = false)
    public void androidLaunchTest() throws MalformedURLException, InterruptedException {

//        to provide capabilities
        UiAutomator2Options options = new UiAutomator2Options();
//        setPlatformName -> default will take "Android"
//        setAutomationName -> default will take "UIAutomator2"
        options.setDeviceName("android-test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(e->e.findElement(AppiumBy.accessibilityId("open menu")));
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
//        wait.until(e->e.findElement(AppiumBy.accessibilityId("menu item log in")));
        driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
//        wait.until(e->e.findElement(AppiumBy.accessibilityId("Username input field")));
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();

        driver.quit();
    }


    @Test(priority = 0, enabled = false)
    public void longPress() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("android-test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
//        Thread.sleep(3000);
//        driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();
//        driver.findElement(AppiumBy.xpath(".//*[@text='Expandable Lists']")).click();
//        driver.findElement(AppiumBy.xpath(".//*[@text='1. Custom Adapter']")).click();
//        WebElement element = driver.findElement(AppiumBy.xpath(".//*[@text='People Names']"));
////        new Actions(driver).clickAndHold(element).perform();
//        pressLong(driver, element);
//        driver.quit();
    }

    private void pressLong(AndroidDriver driver, WebElement element) {
//      Take the location of an element
        Point location = element.getLocation();
//      Take the size of an element
        Dimension size = element.getSize();

//        Calculate center of an element
        int x = location.getX() + size.getWidth() / 2;
        int y = location.getY() + size.getHeight() / 2;
        Point locationCenter = new Point(x,y);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger_1");
        Sequence sequence = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),locationCenter))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofSeconds(1)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

//      Now we need to perform this sequence
        driver.perform(Collections.singletonList(sequence));
    }

    @Test(priority = 0, enabled = false)
    public void androidLaunchTestAndTabAction() throws MalformedURLException, InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("android-test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        WebElement openmenu = driver.findElement(AppiumBy.accessibilityId("open menu"));
//        performTab(driver, openmenu);
        performDoubleTab(driver,openmenu);
    }

    private void performTab(AndroidDriver driver, WebElement element) {
//      Take the location of an element
        Point location = element.getLocation();
//      Take the size of an element
        Dimension size = element.getSize();

//        Calculate center of an element
        int x = location.getX() + size.getWidth() / 2;
        int y = location.getY() + size.getHeight() / 2;
        Point locationCenter = new Point(x,y);

//      Press the finger, wait for few seconds and take out the finger (tapping the element action)
//      This is a sequence of events, hence we are using Sequence class from interactions package
//      Sequence needs to be input source via we will perform all actions. In this case its a finger.
//      Firstly set the type of pointer input want to use.
//      Then use that pointer to perform sequences
//      addActions ==> move => down (to tap on element) => up (to remove finger from element)
//      Move => How fast you want to move, what is the origin (mobile screen = view
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger_1");
        Sequence sequence = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),locationCenter))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(200)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

//      Now we need to perform this sequence
        driver.perform(Collections.singletonList(sequence));
    }

    private void performDoubleTab(AndroidDriver driver, WebElement element) {
//      Take the location of an element
        Point location = element.getLocation();
//      Take the size of an element
        Dimension size = element.getSize();

//        Calculate center of an element
        int x = location.getX() + size.getWidth() / 2;
        int y = location.getY() + size.getHeight() / 2;
        Point locationCenter = new Point(x,y);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger_1");
        Sequence sequence = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),locationCenter))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(100)))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

//      Now we need to perform this sequence
        driver.perform(Collections.singletonList(sequence));
    }

    /**
     * Zoom action involves 2 fingers to move in opposite direction.
     * Get the center of the element and move both fingers
     * sequence of actions with finger 1 and sequence of actions with finger 2
     * perform and pass both sequences
     * @throws MalformedURLException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void zoom() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item drawing\"]"))
                .click();
        WebElement element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drawing screen\"]"));
        Point centerOfElement = getCenterOfElement(element.getLocation(), element.getSize());


        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

/**
 * Move finger to the center of an element
 * Finger down
 * Wait for few milliseconds
 * Move finger -> how fast, viewport(mobile screen), x , y (x and y should be such a way its moving figure)
 * Up finger
 * Same actions for finger 2, just update x, y such a way it's an opposite movement
 */
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200),
                        PointerInput.Origin.viewport(), centerOfElement.getX() + 300,
                        centerOfElement.getY() - 300))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence sequence2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2, Duration.ofMillis(200)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(200),
                        PointerInput.Origin.viewport(), centerOfElement.getX() - 300,
                        centerOfElement.getY() + 300))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(sequence, sequence2));

        //Assertion
    }
    private Point getCenterOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth() / 2,
                location.getY() + size.getHeight() / 2);
    }

    /**
     * Get the size of the window
     * Starting point (x,y)=Calculate the center of the window by dividing width and height by 2
     * Ending point (x,y)= no change in x axis, calculate 25% of y axis to move from center to 25% of window(from top)
     * Move finger to the center
     * Move finger to vertical up direction -> Y +
     * @throws MalformedURLException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void scroll() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Dimension size = driver.manage().window().getSize();

        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.25);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

       /* PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        int x = centerOfElement.getX();
        System.out.println("X: "+x);
        System.out.println("Y: "+centerOfElement.getY());
        int y = (int) (centerOfElement.getY() + 200);
        System.out.println("Y: "+y);

        Sequence sequence = new Sequence(finger1, 0)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), x, y))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));*/
    }

}
