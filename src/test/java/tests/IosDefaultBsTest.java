package tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static helpers.GetTimeStampHelper.getTimeStamp;
import static io.qameta.allure.Allure.step;

@Epic("QA.GURU QA automation course")
@Feature("Mobile tests - Android")
@Story("Mobile tests - Android - BrowserStack - Appium")
@Tag("mobile_tests_ios")
class IosDefaultBsTest extends TestBase {
    @Test
    @DisplayName("1. BrowserStack default Android test for default wikipedia app")
    @Description("Open app, select search field, put 'BrowSerStack' string into search field, check number of returned results is more than zero")
    public void defaultBStackTestAndroid () throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        step("iOS set capabilities", ()-> {
            caps.setCapability("device", "iPhone 11 Pro");
            caps.setCapability("os_version", "13");
            caps.setCapability("project", "cm-mobile-testing-ios");
            caps.setCapability("build", "BS default test for iOS");
            caps.setCapability("name", "BStack default iOS Java test " + getTimeStamp());
            caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");
        });

        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

        step("iOS click oin text button", ()-> {
            IOSElement textButton = (IOSElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Button")));
            textButton.click();
        });
        step("Set Value by send keys to Text Input", ()-> {
            IOSElement textInput = (IOSElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
            textInput.sendKeys("hello@browserstack.com");
            textInput.sendKeys("\n");
            Thread.sleep(5000);

        });

        IOSElement textOutput = (IOSElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Output")));

        step("Text output should be the same we entered in the text field", ()-> {
            if(textOutput != null && textOutput.getText().equals("hello@browserstack.com"))
                assert(true);
            else
                assert(false);
        });

        driver.quit();

    }

}

