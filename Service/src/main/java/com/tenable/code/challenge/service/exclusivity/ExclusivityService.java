package com.tenable.code.challenge.service.exclusivity;


import com.tenable.code.challenge.common.model.Kit;

public class ExclusivityService implements IExclusivity {
    @Override
    public Kit exclusive(Kit kit) {
        kit.setDescription("Exclusive Arrg.");
        return kit;
    }
}
