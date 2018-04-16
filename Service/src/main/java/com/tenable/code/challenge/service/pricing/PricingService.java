package com.tenable.code.challenge.service.pricing;


import com.tenable.code.challenge.common.model.Kit;

public class PricingService implements IPrice{
    @Override
    public Kit changePrice(Kit kit) {
        kit.setCustomDescription("Kit price was changed successfully");
        return kit;
    }
}
