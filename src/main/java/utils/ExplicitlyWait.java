package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.Base;

import java.time.Duration;

public class ExplicitlyWait {
    private final AndroidDriver driver = Base.getDriverObj();
//    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    private final Wait wait = new FluentWait(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofMillis(5000))
        .ignoring(StaleElementReferenceException.class);
    private static ExplicitlyWait explicitlyWaitObj;
    public static ExplicitlyWait getWait(){
        if(explicitlyWaitObj == null)
            explicitlyWaitObj = new ExplicitlyWait();
        return explicitlyWaitObj;
    }

    public void waitUntilElementVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }




}
