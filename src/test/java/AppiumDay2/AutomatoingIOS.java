package AppiumDay2;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class AutomatoingIOS {
    IOSDriver driver;

    @BeforeTest
    public void setuo()
    {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"IOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.3");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 7");
        capabilities.setCapability(MobileCapabilityType.APP,"");
    }
}
