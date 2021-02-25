package com.training.micro.clients.error;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class RestClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(final String methodKeyParam,
                            final Response responseParam) {

        if (responseParam.status() != 404) {
            try {
                InputStream asInputStreamLoc = responseParam.body()
                                                            .asInputStream();
                ObjectMapper mapperLoc = new ObjectMapper();
                ErrorObject errorObjectLoc = mapperLoc.readValue(asInputStreamLoc,
                                                                 ErrorObject.class);
                return new RestException(errorObjectLoc);
            } catch (Exception e) {
                return new RestException();
            }
        } else {
            return new RestException();
        }


    }

}
