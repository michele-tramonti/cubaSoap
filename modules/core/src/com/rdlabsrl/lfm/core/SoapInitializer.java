package com.rdlabsrl.lfm.core;

import com.haulmont.cuba.core.sys.AbstractWebAppContextLoader;
import com.haulmont.cuba.core.sys.servlet.ServletRegistrationManager;
import com.haulmont.cuba.core.sys.servlet.events.ServletContextInitializedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Component
public class SoapInitializer {
    private static final String DISPATCHER_CLASS = "org.springframework.ws.transport.http.MessageDispatcherServlet";
    private static final String DISPATCHER_NAME = "ws-disp";
    private final Logger log = LoggerFactory.getLogger(SoapInitializer.class);

    @Inject
    private ServletRegistrationManager servletRegistrationManager;

    @EventListener
    public void initializeHttpServlet(ServletContextInitializedEvent e) {
        log.info("------------------------ initializeHttpServlet chiamato ---------------------------------");
        Servlet dispatcherServlet = servletRegistrationManager.createServlet(e.getApplicationContext(), DISPATCHER_CLASS);
        ServletContext context = e.getSource();

        context.setInitParameter("contextConfigLocation", "WEB-INF/ws-disp.xml");

        try {
            dispatcherServlet.init(new AbstractWebAppContextLoader.CubaServletConfig(DISPATCHER_NAME, context));
        } catch (ServletException ex) {
            throw new RuntimeException("Failed to init MessageDispatcherServlet");
        }

        context.setInitParameter("transformWsdlLocations","true");

        context.addServlet(DISPATCHER_NAME, dispatcherServlet).addMapping("/soap/*");

        log.info("------------------------ aggiunta la servlet ---------------------------------");
    }

}