package com.DemoQA.pages;

        import com.DemoQA.pages.components.CalendarComponent;
        import com.DemoQA.pages.components.ResultsModal;
        import com.DemoQA.pages.components.SelectListComponent;
        import com.DemoQA.pages.components.UploadFileComponent;
        import com.codeborne.selenide.SelenideElement;

        import static com.codeborne.selenide.Condition.text;
        import static com.codeborne.selenide.Selectors.byText;
        import static com.codeborne.selenide.Selenide.*;
        import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestFormPage {
    //______Elements
    private CalendarComponent calendarComponent = new CalendarComponent();
    private SelectListComponent selectListComponent = new SelectListComponent();
    private UploadFileComponent uploadFileComponent = new UploadFileComponent();
    private ResultsModal resultsModal = new ResultsModal();
    private final static String TITLE_TEXT = "Student Registration Form";

    //______Metods
    public TestFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;        // вместо new TestFormPage();
    }
    public TestFormPage setTextField(SelenideElement textFieldSelector , String value){
        textFieldSelector.setValue(value);
        return this;
    }
    public TestFormPage clearTextField(SelenideElement textFieldSelector , String value){
        textFieldSelector.clear();
        return this;
    }
    public TestFormPage setSubjectText(SelenideElement subjectTextSelector , String value){
        subjectTextSelector.setValue(value).pressEnter();
        return this;
    }
    public TestFormPage setCustomControl(SelenideElement wrapperSelector , String value){
        wrapperSelector.$(byText(value)).click();
        return this;
    }
    public TestFormPage setSelectedItem(SelenideElement itemSelector , String item){
        selectListComponent.setSelectedItemOfList(itemSelector, item);
        return this;
    }
    public TestFormPage setBirthDate(SelenideElement dateSelector, String day, String month, String year){
        dateSelector.clear();
        calendarComponent.setDate(dateSelector, day, month, year);
        return this;
    }
    public TestFormPage  setUploadFile(SelenideElement filePathSelector , String uploadPath){
        filePathSelector.clear();
        uploadFileComponent.setPathToUploadFile(filePathSelector, uploadPath);
        return this;
    }
    public TestFormPage checkResultTableVisible(SelenideElement modalDialog, SelenideElement modalTitle){
        resultsModal.checkVisible(modalDialog, modalTitle);
        return this;
    }
    public TestFormPage checkResult(SelenideElement titleResponsive , String key, String value){
        resultsModal.checkResult(titleResponsive , key, value);
        return this;
    }
}
