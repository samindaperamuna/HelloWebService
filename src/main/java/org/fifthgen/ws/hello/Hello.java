package org.fifthgen.ws.hello;

import org.fifthgen.ws.hello.model.Messages;
import org.fifthgen.ws.hello.model.UserDetails;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "Hello", targetNamespace = "http://soap.fifthgen.org/")
@XmlSeeAlso({ObjectFactory.class})
public interface Hello {

    @WebMethod
    @WebResult(name = "messages")
    public Messages sayHello(@WebParam(name = "userDetails") UserDetails userDetails);
}
