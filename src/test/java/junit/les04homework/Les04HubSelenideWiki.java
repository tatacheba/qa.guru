package junit.les04homework;

import org.junit.jupiter.api.*;
import pages.RegistrationPages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Les04HubSelenideWiki {

    @BeforeAll
    static void openBrowser() {
        baseUrl = "https://github.com/";
        browserSize = "1920x1080";
    }

    @Test
    void testHubSelenideWiki() {
        open("selenide/selenide");
        $(byText("Wiki")).click();
        $(".Box-row button").click();
        $(byText("Pages")).find(byText("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $(".markdown-body")
                .shouldHave(text("JUnit5"))
                .findElement(byText("@ExtendWith"));

    }

}
