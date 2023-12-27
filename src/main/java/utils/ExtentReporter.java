package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
    ExtentReports extent;
    public ExtentReports getReporterObject(String testName){
        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//ExtentReports//"+testName+"_ExecutionReport_"+DateUtils.getCurrentDateAndTimeInString()+".html");
        sparkReporter.config().setDocumentTitle("Test Execution Report");
        sparkReporter.config().setReportName("Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);
        extent.attachReporter(sparkReporter);
        return extent;
    }
}
