package com.arcbees.stripe.client;

import com.arcbees.stripe.client.jso.BankAccountResponse;
import com.arcbees.stripe.client.jso.CreditCardResponse;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Sample implements EntryPoint {
    public void onModuleLoad() {
        verifyStripeIsInjected();

        injectStripeJs();
    }

    void onStripeInjected() {
        display("Stripe.JS injected successfully");

        verifyStripeIsInjected();

        StripeFactory.get().setPublishableKey("pk_test_LFrI356QTfcLFnYOIwbXaGgT");

        CreditCard creditCard = CreditCard.with().creditCardNumber("4242424242424242").cvc("550").expirationMonth(9)
                .expirationYear(2014).name("John Smith").addressLine1("1093 Charleston rd").addressLine2("apt. 3")
                .addressCity("Los Angeles").addressCountry("United States").addressState("CA").addressZip("91257")
                .build();

        StripeFactory.get().getCreditCardToken(creditCard, new CreditCardResponseHandler() {
            @Override
            public void onCreditCardReceived(int status, CreditCardResponse creditCardResponse) {
                displayResponse(status, creditCardResponse);
            }
        });
    }

    private void displayResponse(int status, CreditCardResponse response) {
        displayStatus(status);

        display("Response.id: " + response.getId());
        display("Response.created: " + response.getCreated());
        display("Response.livemode: " + response.getLiveMode());
        display("Response.type: " + response.getType());
        display("Response.object: " + response.getObject());
        display("Response.used: " + response.getUsed());

        display("Response.card.name: " + response.getCard().getName());
        display("Response.card.address_line1: " + response.getCard().getAddressLine1());
        display("Response.card.address_line2: " + response.getCard().getAddressLine2());
        display("Response.card.address_city: " + response.getCard().getAddressCity());
        display("Response.card.address_state: " + response.getCard().getAddressState());
        display("Response.card.address_zip: " + response.getCard().getAddressZip());
        display("Response.card.address_country: " + response.getCard().getAddressCountry());
        display("Response.card.country: " + response.getCard().getCountry());
        display("Response.card.exp_month: " + response.getCard().getExpirationMonth());
        display("Response.card.exp_year: " + response.getCard().getExpirationYear());
        display("Response.card.last4: " + response.getCard().getLast4());
        display("Response.card.fingerprint: " + response.getCard().getFingerprint());
        display("Response.card.object: " + response.getCard().getObject());
        display("Response.card.type: " + response.getCard().getType());

        tryRetrieveCreditCardToken(response.getId());

        testCreditCardValidators();
        testBankAccount();
    }

    private void testCreditCardValidators() {
        validateCardNumber("4242424242424242");
        validateCardNumber("4242-4242-4242-4242");
        validateCardNumber("4242 4242 4242 4242");
        validateCardNumber("4242-1111-1111-1111");
        validateCardNumber("12345678");
        validateCardNumber("mistake");

        validateExpiry("02", "15");
        validateExpiry("02", "2015");
        validateExpiry("02", "10");
        validateExpiry("02", "2020");
        validateExpiry("2", "2020");

        validateCvc("123");
        validateCvc("");

        findCardType("4242-4242-4242-4242");
        findCardType("378282246310005");
        findCardType("1234");
    }

    private void findCardType(String cardNumber) {
        display("Find card type for number " + cardNumber + " : " + StripeFactory.get().getCardType(cardNumber));
    }

    private void validateCvc(String cvc) {
        display("Validating card cvc " + cvc + " : " + StripeFactory.get().validateCardCvc(cvc));
    }

    private void validateExpiry(String month, String year) {
        display("Validating card expiry " + month + "/" + year + " : " +
                StripeFactory.get().validateCardExpiry(month, year));
    }

    private void validateCardNumber(String cardNumber) {
        display("Validating card number " + cardNumber + " : " + StripeFactory.get().validateCardNumber(cardNumber));
    }

    private void verifyStripeIsInjected() {
        display("isInjected: " + StripeFactory.get().isInjected());
    }

    private void injectStripeJs() {
        display("Injecting Stripe.JS ...");

        StripeFactory.get().inject(new Callback<Void, Exception>() {
            @Override
            public void onFailure(Exception reason) {
                display("Failed Injecting Stripe.JS");
            }

            @Override
            public void onSuccess(Void result) {
                onStripeInjected();
            }
        });
    }

    private void testBankAccount() {
        BankAccount bankAccount = BankAccount.with()
                .country("US")
                .routingNumber("111000025")
                .accountNumber("000123456789")
                .build();

        StripeFactory.get().getBankAccountToken(bankAccount, new BankAccountResponseHandler() {
            @Override
            public void onBankAccountReceived(int status, BankAccountResponse bankAccountResponse) {
                displayResponse(status, bankAccountResponse);
            }
        });
    }

    private void displayResponse(int status, BankAccountResponse response) {
        displayStatus(status);

        display("Response.id: " + response.getId());
        display("Response.created: " + response.getCreated());
        display("Response.livemode: " + response.getLiveMode());
        display("Response.type: " + response.getType());
        display("Response.object: " + response.getObject());
        display("Response.used: " + response.getUsed());

        display("Response.bank_account.country: " + response.getBankAccount().getCountry());
        display("Response.bank_account.bank_name: " + response.getBankAccount().getBankName());
        display("Response.bank_account.last4: " + response.getBankAccount().getLast4());
        display("Response.bank_account.validated: " + response.getBankAccount().getValidated());
        display("Response.bank_account.fingerprint: " + response.getBankAccount().getFingerprint());
        display("Response.bank_account.object: " + response.getBankAccount().getObject());

        testBankAccountValidationHelpers();
        tryRetrieveBankAccountToken(response.getId());
    }

    private void tryRetrieveCreditCardToken(final String token) {
        StripeFactory.get().getCreditCard(token, new CreditCardResponseHandler() {
            @Override
            public void onCreditCardReceived(int status, CreditCardResponse creditCard) {
                if (status == 200 && !creditCard.getUsed()) {
                    display("Credit Card Token " + token + " can still be used.");
                } else {
                    display("Credit Card Token " + token + " was invalid, or has already been used.");
                }
            }
        });
    }

    private void tryRetrieveBankAccountToken(final String token) {
        StripeFactory.get().getBankAccount(token, new BankAccountResponseHandler() {
            @Override
            public void onBankAccountReceived(int status, BankAccountResponse bankAccount) {
                if (status == 200 && !bankAccount.getUsed()) {
                    display("Bank Account Token " + token + " can still be used.");
                } else {
                    display("Bank Account Token " + token + " was invalid, or has already been used.");
                }
            }
        });
    }

    private void testBankAccountValidationHelpers() {
        validateRoutingNumber("111000025", "US");
        validateRoutingNumber("11111-111", "CA");
        validateRoutingNumber("990000000", "US");
        validateRoutingNumber("12345", "US");
        validateRoutingNumber("mistake", "CA");

        validateAccountNumber("000123456789", "US");
        validateAccountNumber("mistake", "US");
    }

    private void validateRoutingNumber(String routingNumber, String country) {
        display("Validating routing number " + routingNumber + ", " + country + " : " + StripeFactory.get()
                .validateRoutingNumber(routingNumber, country));
    }

    private void validateAccountNumber(String accountNumber, String country) {
        display("Validating account number " + accountNumber + ", " + country + " : " + StripeFactory.get()
                .validateAccountNumber(accountNumber, country));
    }

    private void display(String message) {
        Label label = new Label(message);

        RootPanel.get().add(label);
    }

    private void displayStatus(int status) {
        display("Status: " + status);
    }
}
