package com.DemoQA.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ResultTableComponent checkVisible(){
        $(".modal-dialog").should(appear);
        $(".modal-title").shouldHave(text(TITLE_TEXT));
        return this;
    }
}
