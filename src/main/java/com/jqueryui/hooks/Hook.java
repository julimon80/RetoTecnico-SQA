package com.jqueryui.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.jqueryui.utils.Constants.ACTOR;


public class Hook {
    @Before
    public void loginWithCredentials() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR);

    }
}
