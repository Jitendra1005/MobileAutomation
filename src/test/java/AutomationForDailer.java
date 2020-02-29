import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AutomationForDailer {
    AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        //for native apps
        cap.setCapability("appPackage","com.google.android.dialer");
        cap.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void test()
    {
        driver.findElement(By.id("com.google.android.dialer:id/one"));
        driver.findElement(By.id("com.google.android.dialer:id/zero"));
        driver.findElement(By.id("com.google.android.dialer:id/zero"));
        driver.findElement(By.id("com.google.android.dialer:id/dialpad_floating_action_button"));
        Assert.assertEquals("10",driver.findElement(By.id("com.google.android.dialer:id/incall_end_call")));
    }
}
