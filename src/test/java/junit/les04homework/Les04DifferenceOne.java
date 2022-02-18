package junit.les04homework;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class Les04DifferenceOne {

    @Test
    void testDifferenceOne() {
        open("https://yandex.ru/");
        $("div input#text").click();
        $("div input#text").setValue("ikea");
        $("div .search2__button button").click();
        $("div .reviews").shouldHave(Condition.text("Отзывы"));


    }






}
