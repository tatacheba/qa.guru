package junit;

import org.junit.jupiter.api.*;
import pages.RegistrationPages;
import pages.components.CalendarComponent;
import pages.components.PathComponent;

import static com.codeborne.selenide.Configuration.*;

public class Les03OptimizationTestForm {
    RegistrationPages registrationPage = new RegistrationPages();
    CalendarComponent calendarComponent = new CalendarComponent();
    PathComponent pathComponent = new PathComponent();
    String
            openPagesUrl = "/automation-practice-form",
            headerTitleMainPage = "Student Registration Form",
            firstName = "Steve",
            lastName = "Rogers",
            userEmail = "captainamerica@marvel.com",
            gender = "Male",
            userNumber = "8885115480",
            dateBirthday = "19.07.1918",
            subject = "Art",
            hobby = "Sports",
            pathPicture = "src/test/resources/capitanamerica.jpg",
            currentAddress = "Earth-616, New York City",
            state = "NCR",
            city = "Noida",
            headerModalTable = "Thanks for submitting the form";

    @BeforeAll
    static void openBrowser() {
        baseUrl = "https://demoqa.com";
        browserSize = "1920x1080";
    }

    @Test
    void fillTextForm() {
        registrationPage.openPage(openPagesUrl, headerTitleMainPage);
        registrationPage.setFirstNameInput(firstName);
        registrationPage.setLastNameInput(lastName);
        registrationPage.setUserEmailInput(userEmail);
        registrationPage.checkGenderRadioButton(gender);
        registrationPage.setUserNumberInput(userNumber);
        registrationPage.setDateBirthday(dateBirthday);
        registrationPage.selectSubjectInput(subject);
        registrationPage.checkBoxHobbies(hobby);
        registrationPage.setPathUploadPicture(pathPicture);
        registrationPage.setCurrentAddress(currentAddress);
        registrationPage.setStateInput(state);
        registrationPage.setCityInput(city);
        registrationPage.clickButtonSubmit();
        registrationPage.checkModalTable(headerModalTable);
        registrationPage.checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", gender)
                .checkForm("Student Email", userEmail)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", calendarComponent.converterDate(dateBirthday))
                .checkForm("Subjects", subject)
                .checkForm("Hobbies", hobby)
                .checkForm("Picture", pathComponent.converterCheckPath(pathPicture))
                .checkForm("Address", currentAddress)
                .checkForm("State and City", state + " " + city);

    }
}
