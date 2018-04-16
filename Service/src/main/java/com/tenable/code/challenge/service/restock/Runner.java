package com.tenable.code.challenge.service.restock;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Runner {
    public static void main(String[] args) {
        Injector restockInjector = Guice.createInjector(new RestockModule());
        IRestock iRestock = restockInjector.getInstance(IRestock.class);
        //iRestock.restock(new Kit());
    }
}
