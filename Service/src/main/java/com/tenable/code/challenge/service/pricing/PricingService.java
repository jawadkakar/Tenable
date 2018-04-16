package com.tenable.code.challenge.service.pricing;

import com.tenable.code.challenge.model.Kit;

public class PricingService implements IPrice{
    @Override
    public boolean changePrice(Kit kit) {
        boolean result = false;
        System.out.println("Kit price was changed successfully");
        return result;
    }
}
