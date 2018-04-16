package com.tenable.code.challenge.server.resource;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tenable.code.challenge.common.model.Kit;
import com.tenable.code.challenge.common.util.KitMaker;
import com.tenable.code.challenge.service.pricing.IPrice;
import com.tenable.code.challenge.service.pricing.PricingModule;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pricing")
public class PricingResource {
    ObjectMapper mapper = JsonFactory.create();
    Injector priceInjector = Guice.createInjector(new PricingModule());
    IPrice iPrice = priceInjector.getInstance(IPrice.class);
    @GET
    @Path("/kitpricing")
    @Produces(MediaType.APPLICATION_JSON)
    public Response exclusivity(@QueryParam("id") String id,
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
        /** Create a Kit from Rest parameters**/
        Kit kit = KitMaker.kitMaker(id, name, basePrice, bodyKit, engine, fourWheels, color, finish, isDefaultParts, latitude, longitude);
        Kit kitCust = iPrice.changePrice(kit);
        String sr = mapper.toJson(kitCust);
        return Response.status(200).entity(sr).build();

    }
}
