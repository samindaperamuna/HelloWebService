package org.fifthgen.ws.hello;

import jakarta.jws.WebService;
import jakarta.xml.ws.BindingType;
import org.fifthgen.ws.hello.model.Message;
import org.fifthgen.ws.hello.model.Messages;
import org.fifthgen.ws.hello.model.UserDetails;


@WebService(portName = "HelloPort", serviceName = "HelloService", targetNamespace = "http://soap.fifthgen.org/",
        wsdlLocation = "HelloService.wsdl", endpointInterface = "org.fifthgen.ws.hello.Hello")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class HelloService implements Hello {

    public HelloService() {
    }

    public Messages sayHello(UserDetails userDetails) {
        Messages messages = new Messages();
        System.out.println("Request received");

        if (userDetails == null) {
            String msg = "User details is null";
            System.out.println(msg);

            messages.getMessage().add(new Message(msg));
        } else {
            messages.getMessage().add(new Message("Hello " + userDetails.getName() + System.lineSeparator()));

            Message message = new Message("Following addresses will be added:");
            message.setAny(userDetails.getAddresses());
            messages.getMessage().add(message);
        }

        return messages;
    }
}
