package com.jqueryui.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class InteractionsTask {

    public static Performable waitForMilliseconds(int milliseconds) {
        Task.where(
                actor -> {
                    try {
                        Thread.sleep(milliseconds);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        return null;
    }
}
