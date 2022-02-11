package junit;

import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class Les02TestForm {

    @BeforeAll
    static void openBrowser() {
        baseUrl = "https://demoqa.com";
        browserSize = "1920x1080";
    }

    @Test
    void fillTextForm() throws InterruptedException {
        open("/automation-practice-form");
        $(".practice-form-wrapper > h5").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Steve");
        $("#lastName").setValue("Rogers");
        $("#userEmail").setValue("captainamerica@marvel.com");
        $(byText("Male")).click();//
        $("#userNumber").setValue("8885115489");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1918");
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue("Art").pressEnter();
        $(byText("Sports")).click();
        $("#userEmail").setValue("captainamerica@marvel.com");
        $("#uploadPicture").uploadFile(new File("src/test/resources/capitanamerica.jpg"));
        $("#currentAddress").setValue("Earth-616, New York City");
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Noi").pressEnter();
        $(byText("Submit")).click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("table").shouldHave(text("Steve Rogers"), text("captainamerica@marvel.com"), text("Male"), text("8885115480"), text("04 July,1918"), text("Arts"),
                text("Sports"), text("capitanamerica.jpg"), text("Earth-616, New York City"), text("NCR Noida"));
        $("#closeLargeModal").shouldHave(text("Close")).click();
    }
}



