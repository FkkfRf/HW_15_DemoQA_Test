package com.DemoQA;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
        $(By.name("gender")).selectRadio("Male").click();
        $("#gender-radio-3").click();
        $("#userNumber").setValue("8999000001");
        $("#uploadPicture").uploadFromClasspath("ForDemoQA.txt");
        $("#subjectsInput").setValue("a").pressEnter().setValue("i").pressEnter().setValue("m").pressEnter();
        $("#currentAddress").setValue(" 221b \n Baker St, \n  London, Grate Britain ");
        $("#dateOfBirthInput").click();
        //$("#subjectsInput").selectOption("May");
        $("#submit").click();
    }


}
