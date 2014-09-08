/**
 * Copyright 2014 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

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
