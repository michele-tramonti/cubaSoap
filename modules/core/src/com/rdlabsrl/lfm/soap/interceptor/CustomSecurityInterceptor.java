package com.rdlabsrl.lfm.soap.interceptor;


import com.rdlabsrl.lfm.soap.interceptor.exceptions.NotAuthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.SoapEndpointInterceptor;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

public class CustomSecurityInterceptor implements SoapEndpointInterceptor {
    private final Logger log = LoggerFactory.getLogger(CustomSecurityInterceptor.class);


    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        log.info("------------------------ CustomSecurityInterceptor handleRequest  ---------------------------------");

        // implementing something similar to a Basic Access authentication (https://en.wikipedia.org/wiki/Basic_access_authentication)

        String username = "Aladdin";
        String password = "open sesame";
        String originalStringa = username+":"+password;
        String encodedStringa = Base64.getEncoder().encodeToString(originalStringa.getBytes());
        //String encodedStringa = "QWxhZGRpbjpvcGVuIHNlc2FtZQ==";
        String genuineAuth = "Basic " + encodedStringa;


        String auth = getHttpHeaderValue("Authorization");

        if(auth == null || !auth.equals(genuineAuth)) {
            throw new NotAuthenticatedException(); // to be a real Basic Access authentication we should return a 401 http error, not a soap fault response
        }

        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        log.info("------------------------ CustomSecurityInterceptor handleResponse  ---------------------------------");
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        log.info("------------------------ CustomSecurityInterceptor handleFault  ---------------------------------");
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        log.info("------------------------ CustomSecurityInterceptor afterCompletion  ---------------------------------");
    }


    @Override
    public boolean understands(SoapHeaderElement header) {
        log.info("------------------------ CustomSecurityInterceptor called understands ---------------------------------");
        return false;
    }

    protected HttpServletRequest getHttpServletRequest() {
        TransportContext ctx = TransportContextHolder.getTransportContext();
        return ( null != ctx ) ? ((HttpServletConnection ) ctx.getConnection()).getHttpServletRequest() : null;
    }

    protected String getHttpHeaderValue( final String headerName ) {
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        return ( null != httpServletRequest ) ? httpServletRequest.getHeader( headerName ) : null;
    }

}
