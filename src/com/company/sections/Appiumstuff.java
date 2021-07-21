package com.company.sections;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.WeakHashMap;

public class Appiumstuff {
    public static void setup(WebDriver driver) throws MalformedURLException {
        //OPEN emulator, run appium
        File f = new File("src");
        File fs = new File(f, "ApiDemos-debug.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL 2 API 30");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        AndroidDriver anddriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        //UI automator viewer
        System.out.println(anddriver.getBatteryInfo());
    }
}
