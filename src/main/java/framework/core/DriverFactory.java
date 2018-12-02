package framework.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    static WebDriver driver;
    public static String driverType;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setupDriver() throws MalformedURLException {
        String browserName = System.getProperty("browser");
        String os = System.getProperty("os.name");
        if (driverType.equals("android")) {
            DesiredCapabilities androidCapabilities = new DesiredCapabilities();
            androidCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            androidCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/WordPress.apk");
            androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
            androidCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
            androidCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wordpress.android.ui.WPLaunchActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities);
            WebDriverWait androidWait = new WebDriverWait(driver, 30);
        } else if (driverType.equals("ios")) {
            DesiredCapabilities iosCapabilities = new DesiredCapabilities();
            iosCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
            iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
            iosCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            iosCapabilities.setCapability(MobileCapabilityType.UDID, "B9072B66-ABFA-47C2-B0F7-55D40EF4D5F5");
            iosCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            iosCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/WordPress.app");
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), iosCapabilities);
            WebDriverWait iOSWait = new WebDriverWait(driver, 30);
        } else if (driverType.equalsIgnoreCase("web"))
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("ie")) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        driver.get("https://www.wordpress.com");
    }
}