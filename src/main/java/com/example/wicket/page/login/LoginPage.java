package com.example.wicket.page.login;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Bejelentkezés oldal
 */
public class LoginPage extends WebPage {

    public LoginPage(PageParameters parameters) {
        super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new LoginPanel("loginPanel", false));
    }

    public static void navigate(Component component) {
        component.setResponsePage(LoginPage.class);
    }


}
