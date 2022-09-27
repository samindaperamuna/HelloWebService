package org.fifthgen.ws.hello.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "address", propOrder = {"addressLine"})
public class Address {

    protected List<String> addressLine;

    public List<String> getAddressLine() {
        if (addressLine == null) {
            addressLine = new ArrayList<>();
        }

        return this.addressLine;
    }
}
