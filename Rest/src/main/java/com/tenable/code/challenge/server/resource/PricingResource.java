package com.tenable.code.challenge.server.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pricing")
public class PricingResource {

    @GET
    @Path("/kitPricing")
    @Produces(MediaType.APPLICATION_JSON)
    public Response exclusivity(@QueryParam("query") String query,
                                @QueryParam("fromDate") String fromDate,
                                @QueryParam("fromTime") String fromTime,
                                @QueryParam("ToDate") String toDate,
                                @QueryParam("ToTime") String toTime) {

        return Response.status(200).entity("PricingResource").build();

    }
}
