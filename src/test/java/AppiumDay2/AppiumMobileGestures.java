package AppiumDay2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AppiumMobileGestures {
    AndroidDriver driver;
    AppiumDriverLocalService appiumDriverLocalService;

    @BeforeTest
    public void setup()
    {
        appiumDriverLocalService= AppiumDriverLocalService.buildDefaultService();
        appiumDriverLocalService.start();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.APP,"/Users/apple/Downloads/com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk");
        driver=new AndroidDriver(cap);
    }

    @Test
    public void execute()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("android:id/button1")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("com.mobeta.android.demodslv:id/activity_desc")).click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.lockDevice();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.unlockDevice();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ((PressesKey)driver).pressKey(new KeyEvent(AndroidKey.CALENDAR));

       // System.out.println(Netwo);

    }

}
