package com.jqueryui.questions;

import com.jqueryui.ui.CalendarioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;


public class EmptyDateQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.switchTo().frame(CalendarioUI.IFRAME_DATEPICKER.resolveFor(actor));

        String valorFecha = CalendarioUI.INPUT_DATEPICKER.resolveFor(actor).getAttribute("value");

        if (valorFecha == null || valorFecha.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public static EmptyDateQuestion es() {
        return new EmptyDateQuestion();
    }
}
