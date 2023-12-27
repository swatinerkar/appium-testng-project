package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {
    ExtentReporter extentReporter;
    ExtentReports extent;
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        this.test = this.extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        this.test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        this.test.log(Status.FAIL, "Test Failed\n"+result.getThrowable());
        AndroidDriver driver;
        String destinationPath;
        try {
            driver = (AndroidDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            destinationPath = TakeScreenShot.getScreenShotPath(result.getMethod().getMethodName(), driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.test.addScreenCaptureFromPath(destinationPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
         extentReporter = new ExtentReporter();
         this.extent = extentReporter.getReporterObject(context.getName().toUpperCase());

    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        this.extent.flush();
    }
}
