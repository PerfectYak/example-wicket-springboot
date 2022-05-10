package com.example.wicket.page.main;

import com.example.wicket.page.BasePage;
import org.apache.wicket.markup.html.panel.EmptyPanel;

public class MainPage extends BasePage {
    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new EmptyPanel("list"));
    }
}
