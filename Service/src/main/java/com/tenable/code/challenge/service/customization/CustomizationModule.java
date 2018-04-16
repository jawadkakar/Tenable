package com.tenable.code.challenge.service.customization;

import com.google.inject.AbstractModule;

public class CustomizationModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(ICustomization.class).to(KitCustomizerService.class);
    }
}
