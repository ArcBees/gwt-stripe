package com.arcbees.stripe.client.jso;

import com.google.gwt.core.client.JavaScriptObject;

public class Card extends JavaScriptObject {
    protected Card() {
    }

    public final native String getName() /*-{
        return this.name;
    }-*/;

    public final native String getAddressLine1() /*-{
        return this.address_line1;
    }-*/;

    public final native String getAddressLine2() /*-{
        return this.address_line2;
    }-*/;

    public final native String getAddressCity() /*-{
        return this.address_city;
    }-*/;

    public final native String getAddressState() /*-{
        return this.address_state;
    }-*/;

    public final native String getAddressZip() /*-{
        return this.address_zip;
    }-*/;

    public final native String getAddressCountry() /*-{
        return this.address_country;
    }-*/;

    public final native String getCountry() /*-{
        return this.country;
    }-*/;

    public final native int getExpirationMonth() /*-{
        return this.exp_month;
    }-*/;

    public final native int getExpirationYear() /*-{
        return this.exp_year;
    }-*/;

    public final native String getLast4() /*-{
        return this.last4;
    }-*/;

    public final native String getFingerprint() /*-{
        return this.fingerprint;
    }-*/;

    public final native String getObject() /*-{
        return this.object;
    }-*/;

    public final native String getType() /*-{
        return this.type;
    }-*/;
}
