package com.tenable.code.challenge.service.exclusivity;

import com.tenable.code.challenge.model.Kit;

public class ExclusivityService implements IExclusivity {
    @Override
    public Kit exclusive(Kit kit) {
        kit.setCustomDescription("Exclusive Arrg.");
        return kit;
    }
}
