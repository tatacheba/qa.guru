package junit.les04homework;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.*;

public class Les04DragDrop {
    @BeforeAll
    static void openBrowser() {
        baseUrl = "https://the-internet.herokuapp.com";
        browserSize = "1920x1080";
    }
    @Test
        void testDragAndDrop(){
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
         }
}
