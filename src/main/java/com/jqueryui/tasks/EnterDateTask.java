package com.jqueryui.tasks;

import com.jqueryui.ui.CalendarioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static io.ous.jtoml.impl.Token.TokenType.Key;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterDateTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        actor.attemptsTo(
                Switch.toFrame(CalendarioUI.IFRAME_DATEPICKER.resolveFor(actor)),
                Click.on(CalendarioUI.INPUT_DATEPICKER)
        );

        driver.switchTo().frame(CalendarioUI.IFRAME_DATEPICKER.resolveFor(actor));
        new Actions(driver)
                .moveToElement(CalendarioUI.INPUT_DATEPICKER.resolveFor(actor))
                .click()
                .sendKeys("a")
                .perform();

    }

    public static EnterDateTask go() {
        return instrumented(EnterDateTask.class);
    }
}

