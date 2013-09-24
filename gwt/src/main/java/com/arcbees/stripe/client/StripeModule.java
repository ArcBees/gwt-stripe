package com.arcbees.stripe.client;

import com.google.gwt.inject.client.AbstractGinModule;

public class StripeModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(Stripe.class).to(StripeImpl.class);
    }
}
