package com.tenable.code.challenge.server.resource;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tenable.code.challenge.common.model.Kit;
import com.tenable.code.challenge.common.util.KitMaker;
import com.tenable.code.challenge.service.exclusivity.ExclusivityModule;
import com.tenable.code.challenge.service.exclusivity.IExclusivity;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/exclusivity")
public class ExclusivityResource {
    ObjectMapper mapper = JsonFactory.create();
    Injector exclusiveInjector = Guice.createInjector(new ExclusivityModule());
    IExclusivity iExclusivity = exclusiveInjector.getInstance(IExclusivity.class);
    @GET
    @Path("/kitexclusivity")
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
        Kit kitCust = iExclusivity.exclusive(kit);
        String sr = mapper.toJson(kitCust);
        return Response.status(200).entity(sr).build();

    }
}
