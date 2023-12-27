
# Mobile Automation using Appium

Using Appium library to automation mobile applications. Automate 3 types of applications - Native, Hybrid, and Web

This framework is having test cases only for Android.

Applications used for testing

- Hybrid - General Store
- Native - API Demos
- Web - Chrome Browser - https://swatinerkar.wordpress.com/



## Index

- [Purpose](#purpose)
- [Setup Required](#setup_required)
- [Installation](#installation)
- [Tech Stack](#tech_stack)
- [Framework Components](#framework_components)
- [Environment Variables](#environment_variables)
- [Running Tests](#running_tests)
- [Jenkins](#Jenkins)
- [Author](#author)
- [Support](#support)
- [Appendix](#appendix)
## Purpose
#### To demonstates followings:

    1. Automate test scenarios for Native, Hybrid, and Web applciations
    2. Execution of test cases on emulators and real device
    3. Execution of test cases via testng.xml
    4. Execution of test cases via maven
    5. Run time passing values while running test cases with maven
    6. Running test cases over Jenkins
    7. Grouping test cases, and execute them as per group name passed during run time.
    8. Use of testng annotations
    9. Integration of extent report
    10. Integration of testng listeners 
## Setup Required
- Java 11 
- IDE
- Maven
- Android Studio
- Node.js
- Appium Server
- Appium Driver
- Appium Installer
- Appium Inspector
- Setup envirnment variable
    - JAVA_HOME
    - ANDROID_HOME
    - MAVEN_HOME
- Path added for
    - sdk
    - nodejs
    - java
    
## Installation

#### Install Appium Installer with npm

```cmd
  npm install appium-installer -g
  appium-installer
  select option as per the requirement

  verify appium has been installed with appium
  run appium --version

  To install driver
  appium driver install uiautomator2
```

Refer - https://www.npmjs.com/package/appium

#### Appium Inspector

Appium Inspector App (download - https://github.com/appium/appium-inspector/releases)

we can use Inspector appiumpro web version -  https://inspector.appiumpro.com/ 

To use web version make sure to start appium with --allow-cors
    
```appium --allow-cors ```

Add capabilities:
    ```{
			  "platformName": "android",
			  "appium:deviceName": "<name>",
			  "appium:automationName": "UiAutomator2",
			  "appium:app": "<apk file path>"
    }```

#### Android Studio

Download from - https://developer.android.com/studio
## Tech Stack

**Java-Client:** 9.0.0

**Server:** Node

**Maven:** 3.8.5

**Appium Server:** 2.2.3

**UIAutomator2:** 2.34.2

**testNg:** 7.8.0

**Extent Reports:** 5.1.1

**NodeJs:** v20.10.0

**npm:** 10.2.3



## Framework Components
- src/main/java
    - Base class
    - Page Object Model - PageFactory
    - Utils
    
- src/main/resources
    - config.properties
- src/test/java
    - com.test
- src/test/resources
    - .apk files
    - chromedriver.exe
- Report
    - ExtentReport
    - Screenshots

Following is the screenshot of project structure:

![Folder Structure](https://github.com/swatinerkar/appium-testng-project/blob/main/images/Appium_Project_Folder_Structure.png)
## Environment Variables

#### To run this project, you will need to pass these Variables while running maven project

    -Ddevice = Emulator/Real
    -Dgroups = web/hybrid/native
    -DtypaTestApp = web/hybrid/native




## Running Tests

### A] Run Configuration/maven CLI command:

```test -Dgroups=hybrid -Ddevice=Emulator -DtypeTestApp=hybrid```

#### Based of what type of testing want to perform, select appropriate value of variables.

##### -Ddevice = Emulator/Real 
    - select Emulator to execute test cases over Emulator
    - select Read to execute test cases over real mobile device

##### -Dgroups = web/hybrid/native
    - select value to execute all test cases tagged with corresponding group name
    
##### -DtypaTestApp = web/hybrid/native
    - the value you select based of which type of group you have selected. This parameter is used to set pre-requiresits e.g AppiumDriverLocalService, UiAutomator2Options

Here is the screenshot of Run Configuration for reference:

![Maven Run Configuration](https://github.com/swatinerkar/appium-testng-project/blob/main/images/RunConfigurations.png)

### B] Running using testng.xml

You can simply run testng.xml file by right clicking on file and select run

In want to execute only specific test, mark only that as enabled="true" and other as enabled="false". Then run testng.xml file.

### C] Run application on Read Device:
    1. Enable Developer Mode
        * Go to settings -> About device -> Build Number
        * Tap or click on that 7 times. You will get popup, showing developer mode is enabled now

    2. Open Developer Options
        * Go back to settings, and search for developer options
        * Open it and find USB debugging. By default it is disabled. Enable it.
        
    3. Code level
        * setDevice - options.setDeviceName("Android Device");

    4. Connect mobile/device to laptop/computer 
        * You will get a popup, click on 'allow'
        * Select use UBS for File transfer/Android Auto
    5. Check if device is connected
        * Open command prompt
        * Run command:- adb devices
        * You will see your device in the list.
                e.g. List of devices attached
                        c24823  device
    6. Run test case
    7. If you faced error: 'Exception occurred while executing 'delete': java.lang.SecurityException: Permission denial: writing to settings requires:android.permission.WRITE_SECURE_SETTINGS'
        * Go to developer option.
        * Go to last option called --> Disable Permission Monitoring --> enable it.
    8. Re-run test case


   







## Jenkins

### Jenkins Installation:

* Download Jenkins - https://www.jenkins.io/download/
* Install Jenkins
* Go to the folder where war file is present
* Open cmd
* Run: java -jar jenkins.war --httpPort=8080
* Browse to http://localhost:8080 and follow the instructions to complete the installation (it might asks for password, check jenkins.err.logs or jenkins.out.logs to get password)

### Jenkins Configuration

* Refer - https://toolsqa.com/jenkins/jenkins-github-integration/

### Jenkins Build Parameters

* Passing same variables which we are passing while executing test cases via maven.

![Jenkins Build With Parameters](https://github.com/swatinerkar/appium-testng-project/blob/main/images/Jenkins_BuildParameters.png)

* Maven command after building the project

![Maven command after building the project](https://github.com/swatinerkar/appium-testng-project/blob/main/images/After%20Pipeline%20Build_Parameters.png)
## 🚀 About Me

I'm a Software Automation Tester, having 11+ years of experience.

Please have a look on my Portfolio: [@swatinerkar](https://swatinerkar.wordpress.com/)

My LinkedIn Profile: [@swatinerkar](https://www.linkedin.com/in/swatinerkar/)

If you would like to have some guidence, you can book any of my service: [@swatinerkar](https://topmate.io/swati_nerkar)


## Support

For support, email swatinerkar.mentorship@gmail.com


## Appendix

NOTE: 
- To upgrade appium to lastest release run command - npm install --location=global appium@latest
- To see available drivers:- appium driver list
- Userful resources - https://www.npmjs.com/package/appium
- appium gitHub - https://github.com/appium
- Refer git appium repo for all details - https://github.com/appium/appium
- Reference for gestures:- https://appium.github.io/appium.io/docs/en/writing-running-appium/android/android-mobile-gestures/
- Reference for hybrid app:- https://appium.github.io/appium.io/docs/en/writing-running-appium/web/hybrid/
- Reference java-client:- https://appium.github.io/java-client/overview-summary.html
- For appPackage and appActivity, refer:- https://github.com/appium/appium-uiautomator2-driver#mobile-startactivity
- UiAutomation -> UiScrollable:- https://developer.android.com/reference/androidx/test/uiautomator/UiScrollable


