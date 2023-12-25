package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import testBase.Base;

public class MobileActions {
    AndroidDriver driver = Base.getDriverObj();
    private static MobileActions mobileActions = new MobileActions();
    private MobileActions(){}

    public static MobileActions getMobileActionsObj() {
        return mobileActions;
    }

    public void clickBackOnMobile(int numberOfTimesBack) {
        do {
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            numberOfTimesBack--;
        }while(numberOfTimesBack>0);
    }

    public void changeToLandScapeMode() {
        //        Rotate the screen to landscape mode
        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);
    }

    public void setClipboardText(String clipboardText) {
        driver.setClipboardText(clipboardText);
    }

    public void clickHomeOnMobile() {
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
