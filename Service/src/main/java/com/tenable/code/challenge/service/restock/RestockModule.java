package com.tenable.code.challenge.service.restock;

import com.google.inject.AbstractModule;

public class RestockModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IRestock.class).to(RestockService.class);
    }
}
