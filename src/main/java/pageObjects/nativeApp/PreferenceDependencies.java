package pageObjects.nativeApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PreferenceDependencies {

    @AndroidFindBy(id="android:id/checkbox")
    private WebElement wifi_chk;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")
    private WebElement wifiSettings;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement alertTitle_txt;

    @AndroidFindBy(id = "android:id/edit")
    private WebElement alertWifiSettingText_input;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement alertWifiSettingOK_btn;

    protected AndroidDriver driver;
    public PreferenceDependencies(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void checkTheWifiCheckbox() {
        if(wifi_chk.getAttribute("checked").equalsIgnoreCase("false"))
            wifi_chk.click();
    }

    public void clickWifiSettings() {
        wifiSettings.click();
    }

    public void verifyAlertTitle(String expectedTitle) {
        Assert.assertEquals(alertTitle_txt.getText(), expectedTitle);
    }

    public void enterWifiSettings(String textToEnter) {
        alertWifiSettingText_input.sendKeys(textToEnter);
    }

    public void clickOkWifiSettings() {
        alertWifiSettingOK_btn.click();
    }

    public void enterWifiSettingsFromClipBoard() {
        alertWifiSettingText_input.sendKeys(driver.getClipboardText());
    }
}
