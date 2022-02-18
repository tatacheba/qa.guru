package junit.les04homework;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Les04DifferenceSecond {

    @Test
    void testDifferenceSecond() {
        open("https://yandex.ru/");
       $("input#text").click();
        $("input#text").setValue("ikea");
        $(".search2__button").$("button").click();
        $("div").$(".reviews").shouldHave(text("Отзывы"));//failed
        //тк сперва  находит все div и в первом ищет класс .reviews,
        // а в селекторе (div .reviews) сразу ищет div с вложенным классом .reviews
    }
}
