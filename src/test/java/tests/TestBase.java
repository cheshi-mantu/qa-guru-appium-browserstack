package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import static helpers.Environment.*;
import static helpers.LoadCredentialsHelper.getCredentialsFromJson;

public class TestBase {
    public static String userName;
    public static String accessKey;
    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        if (bsUserName != null) {
            userName = bsUserName;
        } else {
            userName = getCredentialsFromJson("browser_stack.secret", "bs_user_name");
        }

        if (bsAccessKey != null) {
            accessKey = bsAccessKey;
        } else {
            accessKey = getCredentialsFromJson("browser_stack.secret", "bs_access_key");
        }

    }


}