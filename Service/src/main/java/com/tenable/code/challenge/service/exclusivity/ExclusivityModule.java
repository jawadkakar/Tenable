package com.tenable.code.challenge.service.exclusivity;

import com.google.inject.AbstractModule;

public class ExclusivityModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IExclusivity.class).to(ExclusivityService.class);
    }
}
