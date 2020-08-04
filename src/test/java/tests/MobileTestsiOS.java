package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Epic("QA.GURU QA automation course")
@Feature("Mobile tests - Android")
@Story("Mobile tests - Android - BrowserStack - Appium")
@Tag("mobile_tests_ios")
class MobileTestsiOS extends TestBase {

    @Test
    @DisplayName("1. ios text")
    @Description("1. ios Description")
    void testIOS() {
        step("iOS step description", ()-> {

        });
    }

}

