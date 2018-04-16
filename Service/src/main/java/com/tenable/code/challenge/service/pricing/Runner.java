package com.tenable.code.challenge.service.pricing;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tenable.code.challenge.model.Kit;

public class Runner {

    public static void main(String[] args) {
        Injector priceInjector = Guice.createInjector(new PricingModule());
        IPrice price = priceInjector.getInstance(IPrice.class);
        price.changePrice(new Kit());
    }


}
