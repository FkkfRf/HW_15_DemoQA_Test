package com.DemoQA.tests;

import com.DemoQA.pages.TestFormPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class TestFormPageObjects {
    TestFormPage TestFormPage= new TestFormPage();
    private SelenideElement
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
    static void setUp() {
        // для каждого теста открываем форму
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1986";
        // держим браузер открытым
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void fillFormMinimumDataTest(){
        TestFormPage.openPage()
                .setTextField(firstNameInput , "StudentName")
                .setTextField(lastNameInput , "StudentLastName")
                .setTextField(userEmailInput ,"User@email.com")
                .setCustomControl(genterWrapperInput , "Female")
                .setTextField(userNumberInput ,"8299000001")
                .setSubjectText(subjectInput ,"a")
                .setSubjectText(subjectInput ,"i")
                .setSubjectText(subjectInput ,"m")
                .setCustomControl(hobbiesWrapperInput , "Sports")
                .setCustomControl(hobbiesWrapperInput , "Music")
                .setCustomControl(hobbiesWrapperInput ,"Reading")
                .setSelectedItem(stateItemInput ,"Haryana" )
                .setSelectedItem(cityItemInput, "Karnal" )
                .setBirthDate(birthInput, "29", "May","1975")
                .setUploadFile(fileUploadInput , "ForDemoQA.txt")
                .setTextField(curentAddressInput , " 221b \n Baker St, \n  London, Grate Britain ");

        $("#submit").click();

        TestFormPage.checkResultTableVisible(modalDialogInput, modaleTitleInput)
                .checkResult(modalTitleResponsiveInput , "Student Name","StudentName StudentLastName")
                .checkResult(modalTitleResponsiveInput , "Gender","Female")
                .checkResult(modalTitleResponsiveInput , "Student Email","User@email.com")
                .checkResult(modalTitleResponsiveInput , "Mobile","8299000001")
                .checkResult(modalTitleResponsiveInput , "Date of Birth","29 May,1975")
                .checkResult(modalTitleResponsiveInput , "Subjects" ,"Maths, Hindi, Chemistry")
                .checkResult(modalTitleResponsiveInput , "State and City" , "Haryana Karnal")
                .checkResult(modalTitleResponsiveInput , "Hobbies" , "Sports, Music, Reading")
                .checkResult(modalTitleResponsiveInput , "Picture" , "ForDemoQA.txt")
                .checkResult(modalTitleResponsiveInput , "Address" , "221b Baker St, London, Grate Britain");

    }
}



