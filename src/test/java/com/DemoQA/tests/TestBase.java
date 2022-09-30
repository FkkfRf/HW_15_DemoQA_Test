package com.DemoQA.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;

import static com.DemoQA.utils.RandomUtils.*;
import static com.codeborne.selenide.Selenide.$;

public class TestBase {
    String firstName = generateRandomCharString(7),
            lastName = generateRandomCharString(10),
            gender = "Female",
            phoneNumber = generateRandomNumericString(10),
            userEmail = generateRandomEmail(),
            dayC = "0" + generateRandomNumericString(1),
            monthC = "May",
            yearC = "1975",
            subject1 = "a",
            subject2 = "i",
            subject3 = "m",
            state = "Haryana",
            city = "Karnal",
            fileUpload = "ForDemoQA.txt",
            address = "221b Baker St, London, Grate Britain",
            hobbies1 = "Sports",
            hobbies2 = "Music",
            hobbies3 = "Reading";
    public SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            genterWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userEmailInput = $("#userEmail"),
            birthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            stateItemInput = $("#state"),
            cityItemInput = $("#city"),
            fileUploadInput = $("#uploadPicture"),
            curentAddressInput = $("#currentAddress"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            modalDialogInput = $(".modal-dialog"),
            modaleTitleInput = $(".modal-title"),
            modalTitleResponsiveInput = $(".table-responsive");

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1986";
        Configuration.holdBrowserOpen = true;
    }
}
