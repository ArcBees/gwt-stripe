package com.arcbees.stripe.client;

import com.arcbees.stripe.client.jso.BankAccountResponse;

public interface BankAccountResponseHandler {
    void onBankAccountReceived(int status, BankAccountResponse bankAccountResponse);
}
