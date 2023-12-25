package pageObjects.hybridApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExplicitlyWait;

import java.util.Set;

public class HybridWebPage {

    AndroidDriver driver;

    @FindBy(name = "q")
    private WebElement search_input;

    public HybridWebPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void switchContextToWeb(String webContext){
        driver.context(webContext);
    }

    public void searchWithText(String textToBeEntered) {
        ExplicitlyWait.getWait().waitUntilElementVisible(search_input);
        search_input.sendKeys(textToBeEntered);
        search_input.sendKeys(Keys.ENTER);
    }

    public void pressMobileBackBtn() {
        //        Click on mobile back button
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void switchContextToNative() throws InterruptedException {
//      Switch driver back to NATIVE VIEW
        driver.context("NATIVE_APP");
        Thread.sleep(5000);
    }


    public void printListOfContext() {
//        Run below for loop to get the WEBVIEW context name. Once we get it, pass it to switch driver context.
        Set<String> contextNames = driver.getContextHandles();
//        NATIVE_APP
//        WEBVIEW_com.androidsample.generalstore
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
    }
}
