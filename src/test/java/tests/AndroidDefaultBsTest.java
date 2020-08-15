package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;


import static helpers.GetTimeStampHelper.getTimeStamp;
import static io.qameta.allure.Allure.step;

@Epic("QA.GURU QA automation course")
@Feature("Mobile tests")
@Story("Mobile tests - Android - BrowserStack - Appium")
@Tag("mobile_tests_android")
class AndroidDefaultBsTest extends TestBase {
    @Test
    @DisplayName("1. BrowserStack default Android test for default wikipedia app")
    @Description("Open app, select search field, put 'BrowSerStack' string into search field, check number of returned results is more than zero")
    public void defaultBStackTestAndroid () throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        step("Setting Android capabilities", ()-> {
            capabilities.setCapability("device", "Google Pixel 3");
            capabilities.setCapability("os_version", "9.0");
            capabilities.setCapability("project", "cm-mobile-testing-android");
            capabilities.setCapability("build", "BS default test for Android");
            capabilities.setCapability("name", "BStack default Android Java test " + getTimeStamp());
            capabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        });
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);

        step("Click to search field", ()-> {
            AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
            searchElement.click();

        });
        step("Set search field value", ()-> {
            AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
            insertTextElement.sendKeys("BrowserStack");
            Thread.sleep(5000);
        });

        step("Android Step description", ()-> {
            List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
            assert(allProductsName.size() > 0);
        });

        driver.quit();

    }
    
    
    
    
//    void testAndroid() {
//        step("Android Step description", ()-> {
//
//        });
//    }

}

