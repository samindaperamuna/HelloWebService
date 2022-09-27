package org.fifthgen.ws.hello;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import org.fifthgen.ws.hello.model.*;

import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName ADDRESS = new QName("http://soap.fifthgen.org/", "address");
    private final static QName USER_DETAILS = new QName("http://soap.fifthgen.org/", "userDetails");

    public ObjectFactory() {
    }

    public Address createAddress() {
        return new Address();
    }

    public UserDetails createUserDetails() {
        return new UserDetails();
    }

    public Messages createMessages() {
        return new Messages();
    }

    public Message createMessage() {
        return new Message();
    }

    @XmlElementDecl(namespace = "http://soap.fifthgen.org/", name = "address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<>(ADDRESS, Address.class, null, value);
    }


    @XmlElementDecl(namespace = "http://soap.fifthgen.org/", name = "userDetails")
    public JAXBElement<UserDetails> createUserDetails(UserDetails value) {
        return new JAXBElement<>(USER_DETAILS, UserDetails.class, null, value);
    }
}
