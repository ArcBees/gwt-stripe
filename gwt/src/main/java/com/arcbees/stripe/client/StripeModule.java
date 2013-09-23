package com.arcbees.stripe.client;

import javax.inject.Singleton;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;

public class StripeModule extends AbstractGinModule {
    @Provides
    @Singleton
    public Stripe getStripe() {
        return StripeFactory.get();
    }

    @Override
    protected void configure() {
    }
}
