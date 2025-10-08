package com.jqueryui.tasks;

import com.jqueryui.ui.CalendarioUI;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelecionarDiaYMesTask implements Task {

    private final DataTable data;

    public SelecionarDiaYMesTask(DataTable data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Map<String, String>> values = data.asMaps(String.class, String.class);
        actor.attemptsTo(
                Switch.toFrame(CalendarioUI.IFRAME_DATEPICKER.resolveFor(actor)),
                Click.on(CalendarioUI.A_NEXT_MONTH),
                Switch.toFrame(CalendarioUI.IFRAME_DATEPICKER.resolveFor(actor)),
                Click.on(CalendarioUI.INPUT_DAY.of(String.valueOf(Integer.parseInt(values.get(0).get("dia")))))
        );
        actor.remember("dia", Integer.parseInt(values.get(0).get("dia")));
    }

    public static SelecionarDiaYMesTask go(DataTable data) {
        return instrumented(SelecionarDiaYMesTask.class, data);
    }
}

