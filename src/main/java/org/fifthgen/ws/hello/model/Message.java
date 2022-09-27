package org.fifthgen.ws.hello.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "message", propOrder = {"messageLine", "any"})
public class Message {

    protected String messageLine;
    @XmlAnyElement
    protected List<Address> any;

    public Message() {
    }

    public Message(String messageLine) {
        this.messageLine = messageLine;
    }

    public String getMessageLine() {
        return messageLine;
    }

    public void setMessageLine(String value) {
        this.messageLine = value;
    }

    public List<Address> getAny() {
        if (any == null) {
            any = new ArrayList<>();
        }

        return this.any;
    }

    public void setAny(List<Address> any) {
        this.any = any;
    }
}
