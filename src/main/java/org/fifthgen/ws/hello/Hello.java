package org.fifthgen.ws.hello;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import org.fifthgen.ws.hello.model.Messages;
import org.fifthgen.ws.hello.model.UserDetails;

@WebService(name = "Hello", targetNamespace = "http://soap.fifthgen.org/")
@XmlSeeAlso({ObjectFactory.class})
public interface Hello {

    @WebMethod
    @WebResult(name = "messages")
    public Messages sayHello(@WebParam(name = "userDetails") UserDetails userDetails);
}
