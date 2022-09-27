package org.fifthgen.ws.hello.client;

import jakarta.xml.ws.*;
import org.fifthgen.ws.hello.Hello;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@WebServiceClient(name = "HelloService", targetNamespace = "http://soap.fifthgen.org/", wsdlLocation = "HelloService.wsdl")
public class HelloServiceClient extends Service {

    private final static URL WSDL_LOCATION;
    private final static WebServiceException EXCEPTION;
    private final static QName SERVICE_NAME = new QName("http://soap.fifthgen.org/", "HelloService");

    static {
        URL url = null;

        WebServiceException e = null;

        try {
            url = new URL("HelloService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }

        WSDL_LOCATION = url;
        EXCEPTION = e;
    }

    public HelloServiceClient() {
        super(getWsdlLocation(), SERVICE_NAME);
    }

    public HelloServiceClient(WebServiceFeature... features) {
        super(getWsdlLocation(), SERVICE_NAME, features);
    }

    public HelloServiceClient(URL wsdlLocation) {
        super(wsdlLocation, SERVICE_NAME);
    }

    public HelloServiceClient(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICE_NAME, features);
    }

    public HelloServiceClient(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloServiceClient(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "HelloPort")
    public Hello getHelloPort() {
        return super.getPort(new QName("http://soap.fifthgen.org/", "HelloPort"), Hello.class);
    }

    @WebEndpoint(name = "HelloPort")
    public Hello getHelloPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.fifthgen.org/", "HelloPort"), Hello.class, features);
    }

    private static URL getWsdlLocation() {
        if (EXCEPTION != null) {
            throw EXCEPTION;
        }

        return WSDL_LOCATION;
    }
}
