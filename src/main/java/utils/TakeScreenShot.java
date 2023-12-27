package utils;

import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import testBase.Base;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot {

    public static String getScreenShotPath(String testCaseName, AndroidDriver driver) throws IOException {
        File sourceFile = driver.getScreenshotAs(OutputType.FILE);
        String destinationFilePath = System.getProperty("user.dir")+"//ExtentReports//ScreenShots//"+testCaseName+"_Screenshot_"+DateUtils.getCurrentDateAndTimeInString()+".png";
        File destinationFile = new File(destinationFilePath);
        FileUtils.copyFile(sourceFile, destinationFile);
        return destinationFilePath;
    }
}
