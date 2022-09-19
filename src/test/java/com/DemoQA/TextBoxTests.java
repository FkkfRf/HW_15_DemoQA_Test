package com.DemoQA;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $("[id=firstName]").setValue("Nимя");
        $("[id=lastName]").setValue(" Фамили");
        $("[id=userEmail]").setValue("User@email.com");
        $("[id=userNumber]").setValue("8999000000111");


    }
}
