package com.krysov.tests;

import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase{

    @Test
    @Owner("Alex Krysov")
    void selenideSearchTest(){
        step("Open github.com", () ->
        open("https://github.com"));
        step("Open Selenide project", () -> {
        $(".header-search-input").setValue("selenide").pressEnter();
        $(linkText("selenide/selenide")).click();
        });
        step("Click on Wiki", () ->
        $("#wiki-tab").click());
        step("Pages has Soft assertions", () ->
        $("#wiki-content").$(new ByText("Soft assertions")).shouldHave(text("Soft assertions")));
        step("Open Soft assertions", () ->
        $("#wiki-content").$(new ByText("Soft assertions")).click());
        step("Check JUnit5 example", () ->
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class")));
    }
}
