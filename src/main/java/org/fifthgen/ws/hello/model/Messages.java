package org.fifthgen.ws.hello.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "messages", propOrder = {"message"})
public class Messages {

    protected List<Message> message;
    @XmlAttribute(name = "date")
    @XmlSchemaType(name = "dateTime")
    protected Calendar date;

    public List<Message> getMessage() {
        if (message == null) {
            message = new ArrayList<>();
        }

        return this.message;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar value) {
        this.date = value;
    }
}
