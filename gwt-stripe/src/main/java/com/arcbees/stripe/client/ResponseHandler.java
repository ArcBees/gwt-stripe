package com.arcbees.stripe.client;

import com.arcbees.stripe.client.jso.Response;

public interface ResponseHandler {
    void onTokenReceived(int status, Response response);
}
