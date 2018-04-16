package com.tenable.code.challenge.server.resource;

import com.google.inject.Guice;
import com.google.inject.Injector;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

import com.tenable.code.challenge.common.model.Kit;
import com.tenable.code.challenge.common.model.Location;
import com.tenable.code.challenge.service.customization.CustomizationModule;
import com.tenable.code.challenge.service.customization.ICustomization;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

@Path("/customize")
public class CustomizationResource {
    ObjectMapper mapper = JsonFactory.create();
    Injector custInjector = Guice.createInjector(new CustomizationModule());
    ICustomization customization = custInjector.getInstance(ICustomization.class);

    @GET
    @Path("/kitcustomizer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response customize(@QueryParam("id") String id,
                             @QueryParam("name") String name,
                             @QueryParam("basePrice") String basePrice,
                             @QueryParam("bodyKit") String bodyKit,
                             @QueryParam("engine") String engine,
                             @QueryParam("fourWheels") String fourWheels,
                             @QueryParam("color") String color,
                             @QueryParam("finish") String finish,
                             @QueryParam("isDefaultParts") String isDefaultParts,
                             @QueryParam("latitude") String latitude,
                             @QueryParam("longitude") String longitude
                             ) {
        System.out.println("Hello");
        /** Create a Kit from Rest parameters**/
        Kit kit = kitMaker(id, name, basePrice, bodyKit, engine, fourWheels, color, finish, isDefaultParts, latitude, longitude);
        Kit kitCust = customization.customize(kit);
        String sr = mapper.toJson(kitCust);
        return Response.status(200).entity(sr).build();

    }

    private Kit kitMaker(String id, String name, String basePrice, String bodyKit, String engine, String fourWheels, String color, String finish, String isDefaultParts,
                         String latitude, String longitude){


        String bPrice = getStringValue(Optional.ofNullable(basePrice));
        String lat = getStringValue(Optional.ofNullable(latitude));
        String lon = getStringValue(Optional.ofNullable(longitude));
        Location location = new Location(Double.parseDouble(lat), Double.parseDouble(lon));
        boolean defValue = getBooleanValue(Optional.ofNullable(isDefaultParts));


        Kit kit =  new Kit(null, id, name, Double.parseDouble(bPrice), bodyKit, engine, fourWheels, color, finish, defValue, location);
        return kit;
    }

    private String getStringValue(Optional<String> value){
        return value.filter(v -> value.isPresent() && value.get().matches("[0-9]+")).orElse("0");
    }
    private boolean getBooleanValue(Optional<String> value){
        boolean result = false;
        if(value.isPresent() && value.get().matches("true")){
            result = true;
        }
        return result;
    }
    public static void main(String[] args) {
        Optional<Double> basePriceOptional = Optional.ofNullable(null);
        Double bbPrice = basePriceOptional.filter(bp -> bp.isNaN()).orElse(Double.valueOf("0"));
        System.out.println(bbPrice);
    }
}
