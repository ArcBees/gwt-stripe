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

package com.arcbees.stripe.client;

import com.arcbees.stripe.client.jso.BankAccountResponse;
import com.arcbees.stripe.client.jso.CreditCardResponse;
import com.google.gwt.core.client.Callback;
import com.google.gwt.junit.client.GWTTestCase;

public class Tests extends GWTTestCase {
    private static final String PUBLISHABLE_KEY = "pk_test_LFrI356QTfcLFnYOIwbXaGgT";

    @Override
    public String getModuleName() {
        return "com.arcbees.stripe.GwtStripe";
    }

    public void testInject() {
        final Stripe stripe = StripeFactory.get();

        stripe.inject(new Callback<Void, Exception>() {
            @Override
            public void onFailure(Exception reason) {
                fail("Could not inject Stripe.js");
            }

            @Override
            public void onSuccess(Void result) {
                assertTrue(stripe.isInjected());
            }
        });
    }

    public void testGetCreditCard() {
        final Stripe stripe = StripeFactory.get();

        stripe.inject(new Callback<Void, Exception>() {
            @Override
            public void onFailure(Exception reason) {
                fail("Could not inject Stripe.js");
            }

            @Override
            public void onSuccess(Void result) {
                stripe.setPublishableKey(PUBLISHABLE_KEY);

                final CreditCard creditCard = new CreditCard.Builder()
                        .creditCardNumber("4242424242424242")
                        .cvc("550")
                        .expirationMonth(9)
                        .expirationYear(2014)
                        .name("John Smith")
                        .addressLine1("1093 Charleston rd")
                        .addressLine2("apt. 3")
                        .addressCity("Los Angeles")
                        .addressCountry("United States")
                        .addressState("CA")
                        .addressZip("91257")
                        .build();

                stripe.getCreditCardToken(creditCard, new CreditCardResponseHandler() {
                    @Override
                    public void onCreditCardReceived(int status, CreditCardResponse response) {
                        assertEquals(200, status);

                        assertNotNull(response.getId());
                        assertTrue(response.getCreated() > 0);

                        assertFalse(response.getLiveMode());

                        assertEquals("card", response.getType());
                        assertEquals("token", response.getObject());
                        assertFalse(response.getUsed());
                        assertEquals("John Smith", response.getCard().getName());
                        assertEquals("1093 Charleston rd", response.getCard().getAddressLine1());
                        assertEquals("apt. 3", response.getCard().getAddressLine2());
                        assertEquals("Los Angeles", response.getCard().getAddressCity());
                        assertEquals("United States", response.getCard().getAddressCountry());
                        assertEquals("CA", response.getCard().getAddressState());
                        assertEquals("91257", response.getCard().getAddressZip());
                        assertEquals("US", response.getCard().getCountry());
                        assertEquals(9, response.getCard().getExpirationMonth());
                        assertEquals(2014, response.getCard().getExpirationYear());
                        assertEquals("4242", response.getCard().getLast4());
                        assertEquals("EZ5rfzYGZgOKLARM", response.getCard().getFingerprint());
                        assertEquals("card", response.getCard().getObject());
                        assertEquals("Visa", response.getCard().getType());
                    }
                });

            }
        });
    }

    public void testCreditCardValidators() {
        final Stripe stripe = StripeFactory.get();
        stripe.inject(new Callback<Void, Exception>() {
            @Override
            public void onFailure(Exception reason) {
                fail("Could not inject Stripe.js");
            }

            @Override
            public void onSuccess(Void result) {
                assertTrue(stripe.validateCardNumber("4242424242424242"));
                assertTrue(stripe.validateCardNumber("4242-4242-4242-4242"));
                assertTrue(stripe.validateCardNumber("4242 4242 4242 4242"));
                assertFalse(stripe.validateCardNumber("4242-1111-1111-1111"));
                assertFalse(stripe.validateCardNumber("12345678"));
                assertFalse(stripe.validateCardNumber("mistake"));

                assertFalse(stripe.validateCardExpiry("02", "15"));
                assertTrue(stripe.validateCardExpiry("02", "2015"));
                assertFalse(stripe.validateCardExpiry("02", "10"));
                assertTrue(stripe.validateCardExpiry("02", "2020"));
                assertTrue(stripe.validateCardExpiry("2", "2020"));

                assertTrue(stripe.validateCardCvc("123"));
                assertFalse(stripe.validateCardCvc(""));

                assertEquals("Visa", stripe.getCardType("4242-4242-4242-4242"));
                assertEquals("American Express", stripe.getCardType("378282246310005"));
                assertEquals("Unknown", stripe.getCardType("1234"));
            }
        });
    }

    public void testBankAccount() {
        final Stripe stripe = StripeFactory.get();
        stripe.inject(new Callback<Void, Exception>() {
            @Override
            public void onFailure(Exception reason) {
                fail("Could not inject Stripe.js");
            }

            @Override
            public void onSuccess(Void result) {
                stripe.setPublishableKey(PUBLISHABLE_KEY);

                BankAccount bankAccount = BankAccount.with()
                        .country("US")
                        .routingNumber("111000025")
                        .accountNumber("000123456789")
                        .build();

                stripe.getBankAccountToken(bankAccount, new BankAccountResponseHandler() {
                    @Override
                    public void onBankAccountReceived(int status, BankAccountResponse response) {
                        assertTrue(response.getId().startsWith("tok_"));
                        assertFalse(response.getLiveMode());
                        assertTrue(response.getCreated() > 0);
                        assertEquals("bank_account", response.getType());
                        assertEquals("token", response.getObject());
                        assertFalse(response.getUsed());
                        assertEquals("US", response.getBankAccount().getCountry());
                        assertEquals("BANK OF AMERICA, N.A.", response.getBankAccount().getBankName());
                        assertEquals("6789", response.getBankAccount().getLast4());
                        assertFalse(response.getBankAccount().getValidated());
                        assertEquals("3rzcjlholrBZEDdx", response.getBankAccount().getFingerprint());
                        assertEquals("bank_account", response.getBankAccount().getObject());
                    }
                });
            }
        });
    }

    public void testBankAccountValidationHelpers() {
        final Stripe stripe = StripeFactory.get();
        stripe.inject(new Callback<Void, Exception>() {
            @Override
            public void onFailure(Exception reason) {
                fail("Could not inject Stripe.js");
            }

            @Override
            public void onSuccess(Void result) {
                assertTrue(stripe.validateRoutingNumber("111000025", "US"));
                assertTrue(stripe.validateRoutingNumber("11111-111", "CA"));
                assertTrue(stripe.validateRoutingNumber("990000000", "US"));
                assertFalse(stripe.validateRoutingNumber("12345", "US"));
                assertFalse(stripe.validateRoutingNumber("mistake", "CA"));

                assertTrue(stripe.validateAccountNumber("000123456789", "US"));
                assertFalse(stripe.validateAccountNumber("mistake", "US"));
            }
        });
    }

    public void testRetrieveTokenInformation() {
        final Stripe stripe = StripeFactory.get();

        stripe.inject(new Callback<Void, Exception>() {
            @Override
            public void onFailure(Exception reason) {
                fail("Could not inject Stripe.js");
            }

            @Override
            public void onSuccess(Void result) {
                stripe.setPublishableKey(PUBLISHABLE_KEY);

                final CreditCard creditCard = new CreditCard.Builder()
                        .creditCardNumber("4242424242424242")
                        .cvc("550")
                        .expirationMonth(9)
                        .expirationYear(2014)
                        .build();

                stripe.getCreditCardToken(creditCard, new CreditCardResponseHandler() {
                    @Override
                    public void onCreditCardReceived(int status, CreditCardResponse response) {
                        stripe.getCreditCard(response.getId(), new CreditCardResponseHandler() {
                            @Override
                            public void onCreditCardReceived(int status, CreditCardResponse creditCardResponse) {
                                assertEquals(200, status);
                                assertFalse(creditCardResponse.getUsed());
                            }
                        });
                    }
                });
            }
        });
    }
}
