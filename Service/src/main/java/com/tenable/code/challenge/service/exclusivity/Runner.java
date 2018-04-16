package com.tenable.code.challenge.service.exclusivity;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Runner {

    public static void main(String args[]){
        Injector exclusiveInjector = Guice.createInjector(new ExclusivityModule());
        IExclusivity iExclusivity = exclusiveInjector.getInstance(IExclusivity.class);
        iExclusivity.exclusive();

    }
}
