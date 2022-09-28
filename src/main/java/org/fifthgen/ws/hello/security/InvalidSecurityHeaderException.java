package org.fifthgen.ws.hello.security;

public class InvalidSecurityHeaderException extends Exception {

    public InvalidSecurityHeaderException(String msg) {
        super(msg);
    }
}
