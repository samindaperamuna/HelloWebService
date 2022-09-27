package org.fifthgen.ws.hello.model;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "userDetails", propOrder = {"name", "dateOfBirth", "addresses"})
public class UserDetails {

    protected String name;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfBirth;
    protected List<Address> addresses;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public XMLGregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    public List<Address> getAddresses() {
        if (addresses == null) {
            addresses = new ArrayList<>();
        }

        return this.addresses;
    }
}
