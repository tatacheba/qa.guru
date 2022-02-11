package junit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Les02TestForm {

    @BeforeAll
    void openBrowser() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWindow();
    }

    @Test
    void fillTextForm() {
        open("automation-practice-form");
        $("").shouldHave("");

        
    }
}



