package com.rdlabsrl.lfm.soap.prodinfoservice;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.security.app.Authentication;
import com.rdlabsrl.lfm.entity.WorkOrderData;
import com.rdlabsrl.lfm.soap.prodinfoservice.exceptions.WorkOrderNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProdInfoServiceEndpoint {
    private static final String NAMESPACE_URI = "prodInfoService.soap.lfm.rdlabsrl.com";
    private final Logger log = LoggerFactory.getLogger(ProdInfoServiceEndpoint.class);

    public ProdInfoServiceEndpoint() {
        log.info("------------------------ init dell'endpoint  ---------------------------------");
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "productionInfoRequest")
    @ResponsePayload
    public ProductionInfoResponse getProductionInfo(@RequestPayload ProductionInfoRequest request) {
        log.info("------------------------ chiamato endpoint  per request ---------------------------------");
        ProductionInfoResponse response = new ProductionInfoResponse();
        WorkOrderData data = null;

        log.info("------------------------ inizio autenticazione ---------------------------------");
        Authentication authentication = AppBeans.get(Authentication.class);
        authentication.begin();
        try {
            DataManager dataManager = AppBeans.get(DataManager.class);
            log.info("------------------------ ottenuto datamanager ---------------------------------");


            data = dataManager.load(WorkOrderData.class).query(
                    "select e from lfm_WorkOrderData e where e.workOrder = :wk"
            )
                    .parameter("wk", request.getWorkOrder())
                    .optional().orElseThrow(() -> new WorkOrderNotFoundException(request.getWorkOrder()));
            log.info("------------------------ ottenuto il dato ---------------------------------");
        } finally {
            authentication.end();
            log.info("------------------------ chiudo autenticazione ---------------------------------");
        }

        if(data == null) throw new WorkOrderNotFoundException(request.getWorkOrder());

        ProdInfo prodInfo = new ProdInfo();
        prodInfo.setWorkOrder(data.getWorkOrder());
        prodInfo.setGtin(data.getGtin());
        prodInfo.setInfo(data.getInfo());
        prodInfo.setMateriale(data.getMateriale());
        prodInfo.setSerType(data.getSerType().getId());

        response.setProdInfo(prodInfo);

        return response;
    }
}
