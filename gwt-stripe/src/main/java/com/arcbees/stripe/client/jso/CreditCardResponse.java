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

public class CreditCardResponse extends JavaScriptObject {
    protected CreditCardResponse() {
    }

    public final native String getId() /*-{
        return this.id;
    }-*/;

    public final native int getCreated() /*-{
        return this.created;
    }-*/;

    public final native boolean getLiveMode() /*-{
        return this.livemode;
    }-*/;

    public final native String getType() /*-{
        return this.type;
    }-*/;

    public final native String getObject() /*-{
        return this.object;
    }-*/;

    public final native boolean getUsed() /*-{
        return this.used;
    }-*/;

    public final native Card getCard() /*-{
        return this.card;
    }-*/;
}
