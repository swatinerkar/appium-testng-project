package testBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.PropertiesReader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;



public class Base {
    protected static AppiumDriverLocalService server;
    public static AndroidDriver driver;
    private UiAutomator2Options options;
    protected Base(){}

    public static AndroidDriver getDriverObj(){
        return driver;
    }


    @BeforeClass(alwaysRun = true)
    @Parameters({"typeTestApp", "device"})
    public void appiumConfigure(String typeTestApp, String device) throws IOException {
//        public void appiumConfigure() throws IOException, InterruptedException {
        PropertiesReader properties = new PropertiesReader();
//        setup capabilities
        options = new UiAutomator2Options();
//        System.out.println("Device: "+device);
//        System.out.println("typeTestApp: "+typeTestApp);

//        String device = System.getProperty("device");                          //either Real Device or Emulator
//        String typeTestApp = System.getProperty("typeTestApp");                    //Hybrid, Nativ, Web
        String ipAddress = properties.getProperties("ipAddress");
        int port = Integer.parseInt(properties.getProperties("port"));
        String plugins = properties.getProperties("plugins");

        switch (typeTestApp.toUpperCase()){
            case "HYBRID" : {
                server = setServer(ipAddress,port);
                options.setApp(System.getProperty("user.dir") + "/src/test/resources/General-Store.apk");
                options.setChromedriverExecutable(System.getProperty("user.dir") + "/src/test/resources/chromedriver_M.exe");
                break;
            }
            case "NATIVE" : {
                server = setServerWithPlugin(ipAddress, port, plugins);
                options.setApp(System.getProperty("user.dir") + "/src/test/resources/ApiDemos-debug.apk");
                break;
            }
            case "WEB" : {
                server = setServer(ipAddress, port);
                options.setChromedriverExecutable(System.getProperty("user.dir") + "/src/test/resources/chromedriver_M.exe");
                options.setCapability("browserName", "Chrome");
                break;
            }
            default:throw new IllegalArgumentException("typeTestApp value is incorrect: "+typeTestApp+"\n Please pass one of these - \n Native \n Hybrid \n Web");
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


        this.server.start();
//        AndroidDriver instance
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver = new AndroidDriver(server.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    private AppiumDriverLocalService setServerWithPlugin(String ipAddress, int port, String plugins) {
        return new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\91758\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress(ipAddress).usingPort(port).withArgument(() -> "--use-plugins", plugins).withTimeout(Duration.ofSeconds(30)).build();
    }

    private AppiumDriverLocalService setServer(String ipAddress, int port) {
       return new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\91758\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress(ipAddress).usingPort(port).withTimeout(Duration.ofSeconds(30)).build();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        server.stop();
    }
}