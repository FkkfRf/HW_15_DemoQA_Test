package com.DemoQA.pages;

        import com.DemoQA.pages.components.CalendarComponent;
        import com.DemoQA.pages.components.ResultTableComponent;
        import com.codeborne.selenide.SelenideElement;

        import static com.codeborne.selenide.Condition.text;
        import static com.codeborne.selenide.Selectors.byText;
        import static com.codeborne.selenide.Selenide.*;
        import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestFormPage {
    //______Elements
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();
    private final static String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genterWrapperInput = $("#genterWrapper");

    //______Metods
    public TestFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;        // вместо new TestFormPage();
    }
    public TestFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public TestFormPage clearFirstName(String value){
        firstNameInput.clear();
        return this;
    }
    public TestFormPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public TestFormPage setEmale(String value){
        userEmailInput.setValue(value);
        return this;
    }
    public TestFormPage setGender(String value){
        genterWrapperInput.$(byText(value)).click();
        return this;
    }
    public TestFormPage setNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }
    public TestFormPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day,month,year);
        return this;
    }
    public TestFormPage checkResultTableVisible(){
        resultTableComponent.checkVisible();
        return this;
    }
}
