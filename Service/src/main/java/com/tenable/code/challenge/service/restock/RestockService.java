package com.tenable.code.challenge.service.restock;


import com.tenable.code.challenge.common.model.Kit;

public class RestockService implements IRestock {
    @Override
    public Kit restock(Kit kit) {
        kit.setCustomDescription("Kit restock was completed successfully");
        return kit;
    }
}
