package com.arcbees.stripe.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;

public class StripeImpl implements Stripe {
    private static final String STRIPE_JAVASCRIPT_URL = "https://js.stripe.com/v2/";

    @Override
    public void inject(final Callback<Void, Exception> callback) {
        if (!isInjected()) {
            ScriptInjector.fromUrl(STRIPE_JAVASCRIPT_URL).setWindow(ScriptInjector.TOP_WINDOW).setCallback(new Callback<Void, Exception>() {
                @Override
                public void onFailure(Exception reason) {
                    callback.onFailure(reason);
                }

                @Override
                public void onSuccess(Void result) {
                    callback.onSuccess(result);
                }
            })
                    .inject();
        }
    }

    @Override
    public void getCreditCardToken(CreditCard creditCard, CreditCardResponseHandler creditCardResponseHandler) {
        getCreditCardToken(creditCard.getCreditCardNumber(),
                creditCard.getCvc(),
                creditCard.getExpirationMonth(),
                creditCard.getExpirationYear(),
                creditCard.getName(),
                creditCard.getAddressLine1(),
                creditCard.getAddressLine2(),
                creditCard.getAddressCity(),
                creditCard.getAddressState(),
                creditCard.getAddressZip(),
                creditCard.getAddressCountry(),
                creditCardResponseHandler);
    }

    @Override
    public void getBankAccountToken(BankAccount bankAccount, BankAccountResponseHandler responseHandler) {
        getBankAccountToken(bankAccount.getCountry(),
                bankAccount.getRoutingNumber(),
                bankAccount.getAccountNumber(),
                responseHandler);
    }

    @Override
    public native boolean validateCardNumber(String cardNumber) /*-{
        return $wnd.Stripe.card.validateCardNumber(cardNumber);
    }-*/;

    @Override
    public native boolean validateCardExpiry(String month, String year) /*-{
        return $wnd.Stripe.card.validateExpiry(month, year);
    }-*/;

    @Override
    public native boolean validateCardCvc(String cvc) /*-{
        return $wnd.Stripe.card.validateCVC(cvc);
    }-*/;

    @Override
    public native boolean validateRoutingNumber(String routingNumber, String country) /*-{
        return $wnd.Stripe.bankAccount.validateRoutingNumber(routingNumber, country);
    }-*/;

    @Override
    public native boolean validateAccountNumber(String accountNumber, String country) /*-{
        return $wnd.Stripe.bankAccount.validateAccountNumber(accountNumber, country);
    }-*/;

    @Override
    public native void getCreditCard(String token, CreditCardResponseHandler handler) /*-{
        var callback = function (status, response) {
            handler.@com.arcbees.stripe.client.CreditCardResponseHandler::onCreditCardReceived(ILcom/arcbees/stripe/client/jso/CreditCardResponse;)(status, response);
        }

        return $wnd.Stripe.getToken(token, callback);
    }-*/;

    @Override
    public native void getBankAccount(String token, BankAccountResponseHandler handler) /*-{
        var callback = function (status, response) {
            handler.@com.arcbees.stripe.client.BankAccountResponseHandler::onBankAccountReceived(ILcom/arcbees/stripe/client/jso/BankAccountResponse;)(status, response);
        }

        return $wnd.Stripe.getToken(token, callback);
    }-*/;

    @Override
    public native String getCardType(String cardNumber) /*-{
        return $wnd.Stripe.card.cardType(cardNumber);
    }-*/;

    @Override
    public native boolean isInjected() /*-{
        return typeof $wnd.Stripe !== "undefined";
    }-*/;

    @Override
    public native void setPublishableKey(String publishableKey) /*-{
        $wnd.Stripe.setPublishableKey(publishableKey);
    }-*/;

    private native void getCreditCardToken(String creditCardNumber,
                                           String cvc,
                                           int expiryMonth,
                                           int expiryYear,
                                           String name,
                                           String addressLine1,
                                           String addressLine2,
                                           String addressCity,
                                           String addressState,
                                           String addressZip,
                                           String addressCountry,
                                           CreditCardResponseHandler creditCardResponseHandler) /*-{
        var creditCardInfo = {
            number: creditCardNumber,
            cvc: cvc,
            exp_month: expiryMonth,
            exp_year: expiryYear,
            name: name,
            address_line1: addressLine1,
            address_line2: addressLine2,
            address_city: addressCity,
            address_state: addressState,
            address_zip: addressZip,
            address_country: addressCountry
        };

        var createTokenCallback = function (status, response) {
            creditCardResponseHandler.@com.arcbees.stripe.client.CreditCardResponseHandler::onCreditCardReceived(ILcom/arcbees/stripe/client/jso/CreditCardResponse;)(status, response);
        }

        $wnd.Stripe.card.createToken(creditCardInfo, createTokenCallback);
    }-*/;

    private native void getBankAccountToken(String country,
                                            String routingNumber,
                                            String accountNumber,
                                            BankAccountResponseHandler responseHandler) /*-{
        var bankAccount = {
            country: country,
            routingNumber: routingNumber,
            accountNumber: accountNumber
        };

        var createTokenCallback = function (status, response) {
            responseHandler.@com.arcbees.stripe.client.BankAccountResponseHandler::onBankAccountReceived(ILcom/arcbees/stripe/client/jso/BankAccountResponse;)(status, response);
        }

        $wnd.Stripe.bankAccount.createToken(bankAccount, createTokenCallback);
    }-*/;
}
