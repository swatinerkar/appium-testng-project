package pageObjects.nativeApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ExplicitlyWait;

public class AlertDialogs {

    @AndroidFindBy(accessibility = "OK Cancel dialog with a message")
    private WebElement okCancelDialogWithMsg;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement msgOnOkCancelDialog_txt;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement okOnAlertDialog_btn;
    private AndroidDriver driver;
    public AlertDialogs(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOkCancelDialogWithMessage() {
        okCancelDialogWithMsg.click();
    }

    public void verifyMessageOnDialog(String expectedAlertMsg) {
        ExplicitlyWait.getWait().waitUntilElementVisible(msgOnOkCancelDialog_txt);
        Assert.assertEquals(msgOnOkCancelDialog_txt.getText(), expectedAlertMsg);
    }

    public void clickOkOnAlert() {
        okOnAlertDialog_btn.click();
    }
}
