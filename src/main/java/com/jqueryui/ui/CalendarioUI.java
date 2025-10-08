package com.jqueryui.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CalendarioUI {

    public static final Target IFRAME_DATEPICKER = Target.the("IFRAME DATEPICKER")
            .locatedBy("//iframe[@class=\"demo-frame\"]");

    public static final Target INPUT_DATEPICKER = Target.the("INPUT DATEPICKER")
            .locatedBy("//input[contains(@id,'datepicker')]");

    public static final Target INPUT_DAY = Target.the("INPUT DATEPICKER")
            .locatedBy("//a[contains(@data-date,'{0}')]");

    public static final Target A_NEXT_MONTH = Target.the("A NEXT MONTH")
            .locatedBy("//a[@data-handler='next']");

    public static final Target TXT_NUM_PRODUCTOS = Target.the("TXT NUM PRODUCTOS")
            .locatedBy("//tbody[@id='tbodyid']/tr");

    public static final Target TXT_TOTAL = Target.the("TXT TOTAL")
            .locatedBy("//h3[@id='totalp']");
}
