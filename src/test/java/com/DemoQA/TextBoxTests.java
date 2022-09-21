package com.DemoQA;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
        $("#firstName").setValue("Nимя");
        $("#lastName").setValue(" Фамили");
        $("#userEmail").setValue("User@email.com");
        $(byText("Male")).click();
        $(byText("Female")).click();
        $(byText("Other")).click();
        $("#userNumber").setValue("8299000001");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(By.className("react-datepicker__year-select")).selectOption("1975");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month").click();
        $("#uploadPicture").uploadFromClasspath("ForDemoQA.txt");
        $("#subjectsInput").setValue("a").pressEnter().setValue("i").pressEnter().setValue("m").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $(byText("Reading")).click();
        $("#currentAddress").setValue(" 221b \n Baker St, \n  London, Grate Britain ");
        $("#stateCity-wrapper").click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Karnal")).click();
        $(byText("Submit")).click();
    }
}
