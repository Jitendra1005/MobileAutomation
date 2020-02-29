package AppiumDay1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AutomateHybridApps {
    AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

        //for Hybrid apps
        cap.setCapability(MobileCapabilityType.APP,"/Users/apple/Downloads/BookMyShow.apk");

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.findElement(By.id("com.bt.bms.lk:id/launcher_tv_for_skip"));
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
        driver.findElement(By.id("com.bt.bms.lk:id/et_search")).sendKeys("Pune");

    }
}
