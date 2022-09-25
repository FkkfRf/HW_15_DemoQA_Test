package com.DemoQA.tests;

import com.DemoQA.pages.TestFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestFormPageObjects {
    TestFormPage TestFormPage= new TestFormPage();

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
        TestFormPage.openPage()
                .setFirstName("StudentName")
                .setLastName("StudentLastName")
                .setEmale("User@email.com")
                .setGender("Female")
                .setNumber("8299000001")
                .setBirthDate("29", "May","1975");



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

        TestFormPage.checkResultTableVisible();

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



    @Test
    void fillFormMinimumDataTest(){
        TestFormPage.openPage()
                .setFirstName("StudentName")
                .setLastName("StudentLastName")
                .setEmale("User@email.com")
                .setGender("Female")
                .setNumber("8299000001")
                .setBirthDate("29", "May","1975");

        $("#submit").click();

        TestFormPage.checkResultTableVisible();


        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave((text("StudentName StudentLastName")));
        $(".table-responsive").$(byText("Gender"))
                .parent().shouldHave((text("Female")));
        $(".table-responsive").$(byText("Mobile"))
                .parent().shouldHave((text("8299000001")));

    }
}



