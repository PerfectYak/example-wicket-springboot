package com.example.wicket;

import com.example.wicket.services.LoginService;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppSession extends AuthenticatedWebSession {
    private LoginService loginService = WicketApplication.getBeanFromContext(LoginService.class);

    public AppSession(Request request) {
        super(request);
    }

    private List<String> roles = new ArrayList<>();

    @Override
    public Roles getRoles() {
        return new Roles(roles);
    }

    @Override
    protected boolean authenticate(String email, String pass) {
        if (loginService.login(email, pass)) {
            roles.addAll(Arrays.asList("ADMIN", "USER", "ROLE_1", "ROLE_1"));
            return true;
        }
        return false;
    }
}
