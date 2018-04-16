package com.tenable.code.challenge.service.customization;

import com.tenable.code.challenge.model.Kit;

public class KitCustomizerService implements ICustomization {
    @Override
    public Kit customize(Kit kit) {
       kit.setCustomDescription("This Kit has been customized");
       return kit;
    }
}
