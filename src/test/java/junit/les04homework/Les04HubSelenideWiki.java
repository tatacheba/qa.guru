package junit.les04homework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
        $(".wiki-pages-box").find(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("JUnit5"), text("@ExtendWith"));
    }

}
