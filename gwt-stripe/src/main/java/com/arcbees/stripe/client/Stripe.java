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
