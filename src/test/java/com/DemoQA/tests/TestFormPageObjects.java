package com.DemoQA.tests;

import com.DemoQA.pages.TestFormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
public class TestFormPageObjects extends TestData{
    TestFormPage TestFormPage= new TestFormPage();
    @Test
    void fillFormMinimumDataTest(){
        TestFormPage.openPage()
                .setTextField(firstNameInput, firstName)
                .setTextField(lastNameInput, lastName)
                .setTextField(userEmailInput, userEmail)
                .setCustomControl(genterWrapperInput, gender)
                .setTextField(userNumberInput, phoneNumber)
                .setBirthDate(birthInput, dayC, monthC, yearC)
                .setSubjectText(subjectInput, subject1)
                .setSubjectText(subjectInput, subject2)
                .setSubjectText(subjectInput, subject3)
                .setCustomControl(hobbiesWrapperInput, hobbies1)
                .setCustomControl(hobbiesWrapperInput, hobbies2)
                .setCustomControl(hobbiesWrapperInput, hobbies3)
                .setSelectedItem(stateItemInput, state)
                .setSelectedItem(cityItemInput, city)
                .setUploadFile(fileUploadInput, fileUpload)
                .setTextField(curentAddressInput, address);

        $("#submit").click();

        TestFormPage.checkResultTableVisible(modalDialogInput, modaleTitleInput)
                .checkResult(modalTitleResponsiveInput , "Student Name",firstName+" "+lastName)
                .checkResult(modalTitleResponsiveInput , "Gender",gender)
                .checkResult(modalTitleResponsiveInput , "Student Email",userEmail)
                .checkResult(modalTitleResponsiveInput , "Mobile",phoneNumber)
                .checkResult(modalTitleResponsiveInput , "Date of Birth",dayC + " " + monthC + "," + yearC)
                .checkResult(modalTitleResponsiveInput , "Subjects" ,subject1)
                .checkResult(modalTitleResponsiveInput , "State and City" , state + " " + city)
                .checkResult(modalTitleResponsiveInput , "Hobbies" , hobbies1 + ", " + hobbies2 + ", " + hobbies3)
                .checkResult(modalTitleResponsiveInput , "Picture" , fileUpload)
                .checkResult(modalTitleResponsiveInput , "Address" , address);

    }
}



