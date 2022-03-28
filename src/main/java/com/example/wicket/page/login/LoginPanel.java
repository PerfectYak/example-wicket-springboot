package com.example.wicket.page.login;

import org.apache.wicket.authroles.authentication.panel.SignInPanel;

public class LoginPanel extends SignInPanel {
    public LoginPanel(String id) {
        super(id);
    }

    public LoginPanel(String id, boolean includeRememberMe) {
        super(id, includeRememberMe);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
    }
}
