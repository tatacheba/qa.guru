package junit.les05homework;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class Les05ParameterizedTest {

    @BeforeEach
    void precondition() {
        browserSize = "1920x1080";
        Selenide.open("https://yandex.ru/");
        $(".desk-notif-card__login-new-item_mail").click();
        switchTo().window(1);
        $(".passp-auth-content").shouldBe(visible);
        $("input[data-t='field:input-login']").click();
        $("input[data-t='field:input-login']")
                .setValue("qaguru11Cheba")
                .pressEnter();
        $("input[data-t='field:input-passwd']")
                .setValue("098poilkjmnb!")
                .pressEnter();
        if (!$(".passp-content").isDisplayed()) {// if a block appears add a phone number
            $(".passp-content")
                    .$("div[data-t='phone_skip']")
                    .click();
        }
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @DisplayName("Test send email/positive")
    @CsvSource(value = {
            "qaguru11Cheba@yandex.ru| Test Subject 01 | Test Body 01",
            "qaguru11Cheba@yandex.ru| Test Subject 02 | Test Body 02",
            "qaguru11Cheba@yandex.ru| Test Subject 03 | Test Body 03"
    }, delimiter = '|')

    @ParameterizedTest(name = "Checking the sending of an email {0}")
    void sendEmail(String email, String subjectText, String bodyText) {
        $(".mail-ComposeButton").click();
        $(".ComposePopup-Content").shouldBe(visible);
        $(".composeYabbles").click();
        $(".composeYabbles").setValue(email).pressEnter();
        $(".composeTextField[name='subject']").click();
        $(".composeTextField[name='subject']").setValue(subjectText);
        $("#cke_1_contents div[placeholder='Write something']").click();
        $("#cke_1_contents div[placeholder='Write something']").setValue(bodyText);
        $(".ComposeSendButton button").click();
    }

    static Stream<Arguments> verificationLoginUserTest() {
        return Stream.of(
                Arguments.of("qaguru11Cheba", List.of("Mail", "Disk", "Telemost", "Documents", "More"))
        );
    }

    @DisplayName("User Authorization Check/positive")
    @MethodSource(value = "verificationLoginUserTest")
    @ParameterizedTest(name = "User Authorization Check")
    void verificationLoginUserTest(String loginUser, List<String> headerIcon) {
        $(".user-account__name").shouldBe(text(loginUser));
        headerIcon.stream().forEach((e) -> $(".PSHeader-Center").shouldBe(text(e)));
    }
}
