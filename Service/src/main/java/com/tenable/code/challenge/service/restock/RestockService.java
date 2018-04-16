package com.tenable.code.challenge.service.restock;

import com.tenable.code.challenge.model.Kit;

public class RestockService implements IRestock {
    @Override
    public void restock(Kit kit) {
        System.out.println("Kit restock was completed successfully");
    }
}
