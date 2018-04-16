package com.tenable.code.challenge.service.pricing;

import com.google.inject.AbstractModule;

public class PricingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IPrice.class).to(PricingService.class);
    }
}
