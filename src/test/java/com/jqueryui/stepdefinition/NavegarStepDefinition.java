package com.jqueryui.stepdefinition;


import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;

public class NavegarStepDefinition {


    @Dado("el usuario accede a la web principal de JQuery Datepicker")
    public void elUsuarioAccedeALaPaginaWebDeLaTienda() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Task.where("abre la pagina prinicipal de JQuery Datepicker",
                        actor -> BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).getDriver().get("https://jqueryui.com/datepicker/")
                )
        );
    }

}