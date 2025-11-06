package org.example.weatherService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:9080/WeatherService/")
@Path("/api/weather")
public interface WeatherService {
    @GET
    @Path("/today")
    String getWeather();
}
