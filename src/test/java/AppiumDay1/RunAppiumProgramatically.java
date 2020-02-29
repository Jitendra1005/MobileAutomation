package AppiumDay1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class RunAppiumProgramatically {
    AndroidDriver driver;
    AppiumDriverLocalService appiumDriverLocalService;

    @BeforeTest
    public void setup() throws MalformedURLException {
        appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
        appiumDriverLocalService.start();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability("appPackage","com.android.calculator2");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver=new AndroidDriver(cap);

    }

    @Test
    public void test()
    {
        driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        driver.findElement(By.id("com.android.calculator2:id/op_add"));
        driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        driver.findElement(By.id("com.android.calculator2:id/eq"));
        Assert.assertEquals("10",driver.findElement(By.id("com.android.calculator2:id/result")));
        driver.quit();
    }

}
