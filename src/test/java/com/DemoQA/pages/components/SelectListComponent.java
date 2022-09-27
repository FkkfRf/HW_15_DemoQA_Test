package com.DemoQA.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
public class SelectListComponent {
    public SelectListComponent setSelectedItemOfList(SelenideElement itemSelector , String item){
        itemSelector.click();
        $(byText(item)).click();
        return this;
    }
}
