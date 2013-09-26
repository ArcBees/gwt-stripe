package com.arcbees.stripe.client;

import com.google.gwt.core.client.Callback;

public interface Stripe {
    void inject(Callback<Void, Exception> callback);

    boolean isInjected();

    void setPublishableKey(String publishableToken);

    void getStripeToken(CreditCard creditCard, ResponseHandler responseHandler);

    boolean validateCardNumber(String cardNumber);

    boolean validateCardExpiry(String month, String year);

    boolean validateCardCvc(String cvc);

    String getCardType(String cardNUmber);
}
