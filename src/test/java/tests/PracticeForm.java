package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void FillFormTest() {
        open("/automation-practice-form");

        // First Name
        $("#firstName").setValue("Nastya");

        // Last Name
        $("#lastName").setValue("Nefedova");

        // Email
        $("#userEmail").setValue("an.nefd@yandex.com");

        // Gender
        $(byText("Female")).click();

        // Mobile
        $("#userNumber").setValue("12345678900");

        // Date of Birth
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2005");
        $$(".react-datepicker__day").findBy(text("12")).click();

        // Subjects
        $("#subjectsInput").setValue("Chemistry");
        $$(".subjects-auto-complete__option").findBy(text("Chemistry")).click();

        // Hobbies
        $("label[for='hobbies-checkbox-1']").click();

        // Picture
        $("#uploadPicture").uploadFromClasspath("Photo.jpg");

        // Current Address
        $("#currentAddress").setValue("Moscow street");

        // State and City
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").pressEnter();

        $("#submit").click();

        // Проверка
        $(".table-responsive").shouldHave(text("Nastya Nefedova"));
        $(".table-responsive").shouldHave(text("an.nefd@yandex.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("12345678900"));
        $(".table-responsive").shouldHave(text("12 May,2005"));
        $(".table-responsive").shouldHave(text("Chemistry"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Photo.jpg"));
        $(".table-responsive").shouldHave(text("Moscow street"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
    }
}
