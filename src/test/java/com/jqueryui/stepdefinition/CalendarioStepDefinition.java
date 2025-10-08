package com.jqueryui.stepdefinition;



import com.jqueryui.questions.EmptyDateQuestion;
import com.jqueryui.questions.SelectDayQuestion;
import com.jqueryui.questions.SelectNexthMonthDayQuestion;
import com.jqueryui.tasks.ClickCalendarioTask;
import com.jqueryui.tasks.EnterDateTask;
import com.jqueryui.tasks.SelecionarDiaTask;
import com.jqueryui.tasks.SelecionarDiaYMesTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CalendarioStepDefinition {

    @Dado("el usuario da click en el campo de fecha")
    public void elUsuarioDaClickEnElCampoDeFecha() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickCalendarioTask.go()
        );
    }

    @Cuando("el usuario ingresa el mes actual y el dia")
    public void elUsuarioIngresaElMesActualYElDia(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelecionarDiaTask.go(dataTable)
        );
    }

    @Entonces("el usuario deberia ver la fecha seleccionada correctamente")
    public void elUsuarioDeberiaVerLaFechaSeleccionadaCorrectamente() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(SelectDayQuestion.es(), equalTo(true))
        );
    }

    @Cuando("el usuario seleciona  el mes siguiente y el dia")
    public void elUsuarioSelecionaElMesSiguienteYElDia(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelecionarDiaYMesTask.go(dataTable)
        );
    }

    @Entonces("el usuario deberia ver la fecha específica seleccionada")
    public void elUsuarioDeberiaVerLaFechaEspecificaSeleccionada() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(SelectNexthMonthDayQuestion.es(), equalTo(true))
        );
    }

    @Cuando("el usuario intensa ingresar manualmente una fecha")
    public void elUsuarioIntensaIngresarManualmenteUnaFecha() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EnterDateTask.go()
        );
    }

    @Entonces("el usuario deberia ver el campo vacio")
    public void elUsuarioDeberiaVerElCampoVacio() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(EmptyDateQuestion.es(), equalTo(true))
        );
    }
}