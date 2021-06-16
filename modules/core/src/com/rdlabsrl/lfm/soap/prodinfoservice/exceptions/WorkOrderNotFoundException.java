package com.rdlabsrl.lfm.soap.prodinfoservice.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{" + WorkOrderNotFoundException.NAMESPACE_URI + "}WORKORDER_NOT_FOUND",
        faultStringOrReason = "")
public class WorkOrderNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String NAMESPACE_URI = "prodInfoService.soap.lfm.rdlabsrl.com";

    public WorkOrderNotFoundException(String workorder) {
        super("WorkOrder " + workorder + " not found");
    }
}
