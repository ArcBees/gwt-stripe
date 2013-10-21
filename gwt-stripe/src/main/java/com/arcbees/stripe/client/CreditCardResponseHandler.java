package com.arcbees.stripe.client;

import com.arcbees.stripe.client.jso.CreditCardResponse;

public interface CreditCardResponseHandler {
    void onCreditCardReceived(int status, CreditCardResponse creditCardResponse);
}
