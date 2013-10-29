package com.arcbees.stripe.client.jso;

import com.google.gwt.core.client.JavaScriptObject;

public class BankAccount extends JavaScriptObject {
    protected BankAccount() {
    }

    public final native String getCountry() /*-{
        return this.country;
    }-*/;

    public final native String getBankName() /*-{
        return this.bank_name;
    }-*/;

    public final native String getLast4() /*-{
        return this.last4;
    }-*/;

    public final native boolean getValidated() /*-{
        return this.validated;
    }-*/;

    public final native String getFingerprint() /*-{
        return this.fingerprint;
    }-*/;

    public final native String getObject() /*-{
        return this.object;
    }-*/;
}
