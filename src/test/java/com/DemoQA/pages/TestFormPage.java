package com.DemoQA.pages;

        import com.codeborne.selenide.SelenideElement;

        import static com.codeborne.selenide.Condition.text;
        import static com.codeborne.selenide.Selectors.byText;
        import static com.codeborne.selenide.Selenide.*;
        import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestFormPage {
    //Elements
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapperInput = $("#genterWrapper");

    //Metods
    public void openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
    public void setFirstName(String value){
        firstNameInput.setValue(value);
    }
    public void clearFirstName(String value){
        firstNameInput.clear();
    }
    public void setLastName(String value){
        lastNameInput.setValue(value);
    }
    public void setEmale(String value){
        userEmailInput.setValue(value);
    }
    public void setGender(String value){ genterWrapperInput.$(byText(value)).click();  }
}
