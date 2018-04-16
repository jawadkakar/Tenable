package com.tenable.code.challenge.service.customization;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Runner {

 public static void main(String[] argc){
     Injector custInjector = Guice.createInjector(new CustomizationModule());
     ICustomization customization = custInjector.getInstance(ICustomization.class);
     customization.customize();
 }
}
