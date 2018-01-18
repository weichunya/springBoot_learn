package com.example.controller.webservice;

import com.example.model.GetCountryRequest;
import com.example.model.GetCountryResponse;
import com.example.service.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by 01444966 on 2018/1/17.
 */
@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://www.yourcompany.com/webservice";

    @Autowired
    private CountryRepository countryRepository;

    /*@Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }*/

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}
