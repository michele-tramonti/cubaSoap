package com.rdlabsrl.lfm.soap.interceptor.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{" + NotAuthenticatedException.NAMESPACE_URI + "}NOT_AUTHENTICATED",
        faultStringOrReason = "")
public class NotAuthenticatedException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String NAMESPACE_URI = "soap.lfm.rdlabsrl.com";

    public NotAuthenticatedException() {
        super("Not authenticated");
    }
}
