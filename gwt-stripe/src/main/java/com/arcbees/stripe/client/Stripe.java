package com.arcbees.stripe.client;

import com.google.gwt.core.client.Callback;

public interface Stripe {
    void inject(Callback<Void, Exception> callback);

    boolean isInjected();

    void setPublishableKey(String publishableToken);

    void getCreditCardToken(CreditCard creditCard, CreditCardResponseHandler creditCardResponseHandler);

    void getBankAccountToken(BankAccount bankAccount, BankAccountResponseHandler responseHandler);

    boolean validateCardNumber(String cardNumber);

    boolean validateCardExpiry(String month, String year);

    boolean validateCardCvc(String cvc);

    String getCardType(String cardNUmber);

    boolean validateRoutingNumber(String routingNumber, String country);

    boolean validateAccountNumber(String accountNumber, String country);

    void getCreditCard(String token, CreditCardResponseHandler creditCardResponseHandler);

    void getBankAccount(String token, BankAccountResponseHandler bankAccountResponseHandler);
}
