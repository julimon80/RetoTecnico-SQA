package com.jqueryui.tasks;

import com.jqueryui.ui.CalendarioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickCalendarioTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Switch.toFrame(CalendarioUI.IFRAME_DATEPICKER.resolveFor(actor)),
                Click.on(CalendarioUI.INPUT_DATEPICKER)
        );

    }

    public static ClickCalendarioTask go() {
        return instrumented(ClickCalendarioTask.class);
    }
}

