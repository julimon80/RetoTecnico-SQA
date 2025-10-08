package com.jqueryui.questions;

import com.jqueryui.ui.CalendarioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class SelectNexthMonthDayQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.switchTo().frame(CalendarioUI.IFRAME_DATEPICKER.resolveFor(actor));

        String valorFecha = CalendarioUI.INPUT_DATEPICKER.resolveFor(actor).getAttribute("value");

        if (valorFecha == null || valorFecha.isEmpty()) {
            return false;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate fechaSeleccionada = LocalDate.parse(valorFecha, formatter);

        int mesSiguiente = LocalDate.now().plusMonths(1).getMonthValue();
        int diaRecordado = actor.recall("dia");

        return fechaSeleccionada.getMonthValue() == mesSiguiente &&
                fechaSeleccionada.getDayOfMonth() == diaRecordado;
    }


    public static SelectNexthMonthDayQuestion es() {
        return new SelectNexthMonthDayQuestion();
    }
}
