package org.fifthgen.ws.hello.security;

import com.sun.xml.wss.impl.callback.PasswordValidationCallback;

import static com.sun.xml.wss.impl.callback.PasswordValidationCallback.PlainTextPasswordRequest;
import static com.sun.xml.wss.impl.callback.PasswordValidationCallback.Request;

public class PasswordValidator implements PasswordValidationCallback.PasswordValidator {

    private static final String USER = "admin";
    private static final String PASS = "admin";

    @Override
    public boolean validate(Request request) {
        PlainTextPasswordRequest plainTextPasswordRequest = (PlainTextPasswordRequest) request;

        return plainTextPasswordRequest.getUsername().equals(USER)
                && plainTextPasswordRequest.getPassword().equals(PASS);
    }
}
