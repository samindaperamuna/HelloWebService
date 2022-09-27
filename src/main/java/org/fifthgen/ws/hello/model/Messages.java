package org.fifthgen.ws.hello.model;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "messages", propOrder = {"message"})
public class Messages {

    protected List<Message> message;
    @XmlAttribute(name = "date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;

    public List<Message> getMessage() {
        if (message == null) {
            message = new ArrayList<>();
        }

        return this.message;
    }

    public XMLGregorianCalendar getDate() {
        return date;
    }

    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }
}
