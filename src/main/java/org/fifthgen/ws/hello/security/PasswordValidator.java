package org.fifthgen.ws.hello.security;


import javax.xml.ws.WebServiceContext;

public class PasswordValidator {

    private static final String USER = "admin";
    private static final String PASS = "admin";

    public boolean validate(WebServiceContext ctx) throws InvalidSecurityHeaderException {
        String username = (String) ctx.getMessageContext().get("USERNAME");

        if (username == null) {
            throw new InvalidSecurityHeaderException("Security header is missing or invalid");
        }

        String password = (String) ctx.getMessageContext().get("PASSWORD");

        return username.equals(USER)
                && password.equals(PASS);
    }
}
