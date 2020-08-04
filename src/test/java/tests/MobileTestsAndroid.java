package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

@Epic("QA.GURU QA automation course")
@Feature("Mobile tests - Android")
@Story("Mobile tests - Android - BrowserStack - Appium")
@Tag("mobile_tests_android")
class MobileTestsAndroid extends TestBase {

    @Test
    @DisplayName("1. Text")
    @Description("1. Description")
    void testAndroid() {
        step("Android Step description", ()-> {

        });
    }

}

