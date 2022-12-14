package com.DemoQA;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        // для каждого теста открываем форму
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1986";
        // держим браузер открытым
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //____убрать рекламу_________________пометка для себя_
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        //________________________________________________

        $("#firstName").setValue("StudentName ");
        $("#lastName").setValue(" StudentLastName");
        $("#userEmail").setValue("User@email.com");

        $("#gender-radio-1").parent().click();
        $("#genterWrapper").$(byText("Female")).click();

        $("#userNumber").setValue("8299000001");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(By.className("react-datepicker__year-select")).selectOption("1975");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month").click();

        $("#uploadPicture").uploadFromClasspath("ForDemoQA.txt");

        $("#subjectsInput").setValue("a").pressEnter().setValue("i").pressEnter().setValue("m").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $(byText("Music")).click();
        $(by("for","hobbies-checkbox-2")).click();

        $("#currentAddress").setValue(" 221b \n Baker St, \n  London, Grate Britain ");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave((text("StudentName StudentLastName")));
        $(".table-responsive").$(byText("Student Email"))
                .parent().shouldHave((text("User@email.com")));
        $(".table-responsive").$(byText("Gender"))
                .parent().shouldHave((text("Female")));
        $(".table-responsive").$(byText("Mobile"))
                .parent().shouldHave((text("8299000001")));
        $(".table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave((text("29 May,1975")));
        $(".table-responsive").$(byText("Subjects"))
                .parent().shouldHave((text("Maths, Hindi, Chemistry")));
        $(".table-responsive").$(byText("Hobbies"))
                .parent().shouldHave((text("Sports, Music, Reading")));
        $(".table-responsive").$(byText("Picture"))
                .parent().shouldHave((text("ForDemoQA.txt")));
        $(".table-responsive").$(byText("Address"))
                .parent().shouldHave((text("221b Baker St, London, Grate Britain")));
        $(".table-responsive").$(byText("State and City"))
                .parent().shouldHave((text("Haryana Karnal")));
    }
}



