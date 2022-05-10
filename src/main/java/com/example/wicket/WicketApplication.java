package com.example.wicket;

import com.example.wicket.page.login.LoginPage;
import com.example.wicket.page.main.MainPage;
import com.example.wicket.panel.autocompleat.AutoCompletePage;
import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WicketApplication extends WicketBootSecuredWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WicketApplication.class, args);
    }

    @Override
    public Class<? extends WebPage> getHomePage() {
        return MainPage.class;
    }

    @Override
    public void init() {
        super.init();

        getCspSettings().blocking().disabled(); // ez csúnya dolog, nem szabad ilyet csinálni.
        getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
        getMarkupSettings().setDefaultMarkupEncoding("UTF-8");
        mountPage("/login", LoginPage.class);
        mountPage("/autocompleat", AutoCompletePage.class);
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return AppSession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return LoginPage.class;
    }

    // ez fontos mert a @SpringBean csak a page és paneleken működik.
    public static <T> T getBeanFromContext(Class<T> service) {
        return ((WicketBootSecuredWebApplication) WicketApplication.get()).getApplicationContext().getBean(service);
    }
}
