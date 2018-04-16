package com.tenable.code.challenge.common.util;

import com.tenable.code.challenge.common.model.Kit;
import com.tenable.code.challenge.common.model.Location;

import java.util.Optional;

public class KitMaker {

    public static  Kit kitMaker(String id, String name, String basePrice, String bodyKit, String engine, String fourWheels, String color, String finish, String isDefaultParts,
                         String latitude, String longitude){


        String bPrice = getStringValue(Optional.ofNullable(basePrice));
        String lat = getStringValue(Optional.ofNullable(latitude));
        String lon = getStringValue(Optional.ofNullable(longitude));
        Location location = new Location(Double.parseDouble(lat), Double.parseDouble(lon));
        boolean defValue = getBooleanValue(Optional.ofNullable(isDefaultParts));


        Kit kit =  new Kit(null, id, name, Double.parseDouble(bPrice), bodyKit, engine, fourWheels, color, finish, defValue, location);
        return kit;
    }

    private static String getStringValue(Optional<String> value){
        return value.filter(v -> value.isPresent() && value.get().matches("[0-9]+")).orElse("0");
    }
    private static boolean getBooleanValue(Optional<String> value){
        boolean result = false;
        if(value.isPresent() && value.get().matches("true")){
            result = true;
        }
        return result;
    }
}
