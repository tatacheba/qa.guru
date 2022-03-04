package junit.les06homework;//test commit unit 8.1

import com.codeborne.selenide.Condition;//test commit unit 8.2
import com.codeborne.selenide.logevents.SelenideLogger;//test commit unit 8.3
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class Les06TestViaAllureLambda {

    private static final String URL = "https://github.com";
    private static final String REPOSITORY = "tatacheba/qa.guru";
    private static final int ISSUE_NUMBER = 1;

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open page" + URL, () -> {
                    open(URL);
                }
        );
        step("Search " + REPOSITORY, () -> {
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Open link " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Click Tab-menu Issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });
        step("Check number #" + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).shouldBe(Condition.visible);
        });

    }
}
