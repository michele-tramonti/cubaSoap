# cubaSoap
basic example of integrating spring-ws SOAP server into cuba-platform

This is an example of a working cuba-platform project (only one entity "workOrder"), capable of exposing a SOAP service (http://localhost:8080/app-core/soap/prodInfoService.wsdl) for retrieve workorder data, given a workorder code.
It include also a validation of the payload request and response (made by interceptors).


To integrate spring-ws you have to:
- include dependencies (see gradle)
- using it as usually (start from xsd, generate classes with xjc tool, create endpoint)
- init messageDispatcherServlet manually with cuba method (as stated in cuba-platform documentation (https://doc.cuba-platform.com/manual-7.2/servlet_registration_sample.html)
- write the correct xml configuration of the servlet


The key concept here is that the messageDispatcherServlet bring up its own context, and that context is not aware of the application one;
I don't know why: I thought it should have been a child context of the application context, as it was created through that (see SoapInitializer component)

Anyway: as I cannot access the application context, I cannot use @Inject and so the only easy way to interact with cuba-platform environment is:
1) be in the "core" module (make easy the session auth)
2) using  AppBeans.get  obtain an authenticated session (without really authenticate, as we are in core)
3) using AppBeans.get  obtain a DataManager
4) use DataManager as usually
5) close the auth session

point 2 + point 3 is equal to manually inject DataManager in my context (can be done for every other application context bean).


