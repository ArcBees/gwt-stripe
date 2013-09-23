package com.arcbees.stripe.client;

public class StripeFactory {
    public static Stripe get() {
        if (instance == null) {
            instance = new StripeImpl();
        }

        return instance;
    }

    private static Stripe instance;
}
