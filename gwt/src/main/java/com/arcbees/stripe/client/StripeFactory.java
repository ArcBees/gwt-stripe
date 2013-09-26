package com.arcbees.stripe.client;

public class StripeFactory {
    public static Stripe get() {
        return new StripeImpl();
    }
}
