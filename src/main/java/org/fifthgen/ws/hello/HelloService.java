package org.fifthgen.ws.hello;

import org.fifthgen.ws.hello.model.Message;
import org.fifthgen.ws.hello.model.Messages;
import org.fifthgen.ws.hello.model.UserDetails;
import org.fifthgen.ws.hello.security.InvalidSecurityHeaderException;
import org.fifthgen.ws.hello.security.PasswordValidator;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;

@WebService(portName = "HelloPort", serviceName = "HelloService", targetNamespace = "http://soap.fifthgen.org/", endpointInterface = "org.fifthgen.ws.hello.Hello")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
@HandlerChain(file = "/authentication-handler.xml")
public class HelloService implements Hello {

    @Resource
    private WebServiceContext ctx;

    public HelloService() {
    }

    public Messages sayHello(UserDetails userDetails) {
        Messages messages = new Messages();
        PasswordValidator validator = new PasswordValidator();

        try {
            if (!validator.validate(ctx)) {
                messages.getMessage().add(new Message("Invalid credentials"));

                return messages;
            }
        } catch (InvalidSecurityHeaderException e) {
            messages.getMessage().add(new Message(e.getMessage()));

            return messages;
        }

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
