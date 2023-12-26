package testBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;



public class Base {
    protected AppiumDriverLocalService server;
    public static AndroidDriver driver;
    private UiAutomator2Options options;
    protected Base(){}

    public static AndroidDriver getDriverObj(){
        return driver;
    }


    @BeforeClass(alwaysRun = true)
    @Parameters({"typeTestApp", "device"})
    public void appiumConfigure(String typeTestApp, String device) throws MalformedURLException {
//        setup capabilities
        options = new UiAutomator2Options();
        System.out.println("Device: "+device);
        System.out.println("typeTestApp: "+typeTestApp);

//        TODO: Read this data from prop file.
//        String executionType = "EMULATOR";                      //either Real Device or Emulator
//        String typeTestApp = "hybrid";                          //Hybrid, Nativ, Web

        switch (typeTestApp.toUpperCase()){
            case "HYBRID" : {
                server = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\91758\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                        .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(30)).build();
                options.setApp(System.getProperty("user.dir") + "/src/test/resources/General-Store.apk");
                options.setChromedriverExecutable(System.getProperty("user.dir") + "/src/test/resources/chromedriver_M.exe");
                break;
            }
            case "NATIVE" : {
                server = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\91758\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                        .withIPAddress("127.0.0.1").usingPort(4723).withArgument(() -> "--use-plugins", "element-wait,images").withTimeout(Duration.ofSeconds(30)).build();
                options.setApp(System.getProperty("user.dir") + "/src/test/resources/ApiDemos-debug.apk");
                break;
            }
            case "WEB" : {
                server = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\91758\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                        .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(30)).build();
                options.setChromedriverExecutable(System.getProperty("user.dir") + "/src/test/resources/chromedriver_M.exe");
                options.setCapability("browserName", "Chrome");
                break;
            }
        }

        switch (device.toUpperCase()) {
            case "EMULATOR" : {
                options.setDeviceName("Pixel 2 API 28");
//                Set App package and activity so app will directly launch to that activity
//                  options.setAppPackage("io.appium.android.apis");
//                  options.setAppActivity("io.appium.android.apis.preference.PreferenceDependencies");
                break;
            }
            case "REAL DEVICE" : {options.setDeviceName("Android Device"); break;}

        }


        server.start();
//        AndroidDriver instance
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        server.stop();
    }
}