package org.fifthgen.ws.hello.security;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static javax.xml.ws.handler.MessageContext.Scope;

public class UsernameTokenHandler implements SOAPHandler<SOAPMessageContext> {

    private static final String WSSE_NS_URI = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
    private static final String WSU_NS_URI = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
    private static final QName USERNAME_TOKEN = new QName(WSSE_NS_URI, "UsernameToken");
    private static final QName USERNAME = new QName(WSSE_NS_URI, "Username");
    private static final QName PASSWORD = new QName(WSSE_NS_URI, "Password");

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if ((outbound != null) && (!outbound)) {
            handleInboundMessage(context);
        }

        return true;
    }

    private void handleInboundMessage(SOAPMessageContext context) {
        String username = null;
        String password = null;

        try {
            SOAPHeader header = context.getMessage().getSOAPHeader();
            Iterator<?> headerElements = header.examineAllHeaderElements();

            while (headerElements.hasNext()) {
                SOAPHeaderElement headerElement = (SOAPHeaderElement) headerElements.next();

                if (headerElement.getElementName().getLocalName().equals("Security")) {
                    Iterator<?> it2 = headerElement.getChildElements();

                    while (it2.hasNext()) {
                        Node soapNode = (Node) it2.next();

                        if (soapNode instanceof SOAPElement) {
                            SOAPElement element = (SOAPElement) soapNode;
                            QName elementName = element.getElementQName();
                            if (USERNAME_TOKEN.equals(elementName)) {
                                username = getFirstChildElementValue(element, USERNAME);
                                password = getFirstChildElementValue(element, PASSWORD);

                                break;
                            }
                        }

                        if (username != null) {
                            break;
                        }
                    }
                }

                context.put("USERNAME", username);
                context.setScope("USERNAME", Scope.APPLICATION);

                context.put("PASSWORD", password);
                context.setScope("PASSWORD", Scope.APPLICATION);
            }
        } catch (Exception e) {
            System.out.println("Error reading SOAP message context: " + e.getLocalizedMessage());
        }
    }

    private String getFirstChildElementValue(SOAPElement soapElement, QName name) {
        String value = null;
        Iterator<?> it = soapElement.getChildElements(name);

        while (it.hasNext()) {
            SOAPElement element = (SOAPElement) it.next();
            value = element.getValue();
        }

        return value;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {
    }

    @Override
    public Set<QName> getHeaders() {
        QName wsseSecHeader = new QName(WSSE_NS_URI, "Security");
        QName wsuSecHeader = new QName(WSU_NS_URI, "Security");

        Set<QName> headers = new HashSet<>();
        headers.add(wsseSecHeader);
        headers.add(wsuSecHeader);

        return headers;
    }
}
