package AppiumDay1.POM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PF_Calc {
    AndroidDriver driver;
    private static final String packageNAME="com.android.calculator2:id/";

    public PF_Calc(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator((SearchContext) this, Duration.ofSeconds(5)),this);

    }
    @AndroidFindBy(id=packageNAME+"digit_5")
    private MobileElement thisIs5;

    @AndroidFindBy(id = packageNAME+"op_add")
    private MobileElement thisIsPlus;

    @AndroidFindBy(id = packageNAME+"eq")
    private MobileElement thisIsEq;

    @AndroidFindBy(id = packageNAME+"result")
    private MobileElement thisIsResult;

    public AndroidDriver getDriver() {
        return driver;
    }

    public static String getPackageNAME() {
        return packageNAME;
    }

    public MobileElement getThisIs5() {
        return thisIs5;
    }

    public MobileElement getThisIsPlus() {

        return thisIsPlus;
    }
    public MobileElement getThisIsEq() {
        return thisIsEq;
    }

    public MobileElement getThisIsResult() {
        return thisIsResult;
    }
}
