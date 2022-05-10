package com.example.wicket.panel.autocompleat;


import com.example.wicket.page.BasePage;
import com.example.wicket.panel.list.ListPanel;
import com.example.wicket.services.DataService;
import com.example.wicket.vo.ZipVo;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AutoCompleteTextField;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.string.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 * Page that demos the ajax auto complete text field
 *
 * @author ivaynberg
 */
public class AutoCompletePage extends BasePage {

    private String values;
    private String selected;

    /**
     * Constructor
     */
    public AutoCompletePage() {

    }

    private void visibleResult(AjaxRequestTarget target) {
        Component panel;
        replace(panel = new ListPanel("listPanel", selected).setOutputMarkupId(true));
        target.add(panel);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        Form<Void> form = new Form<>("form");
        add(form);

        add(new EmptyPanel("listPanel").setOutputMarkupId(true));

        final IModel<String> model = new IModel<String>() {
            private String value = null;

            @Override
            public String getObject() {
                return value;
            }

            @Override
            public void setObject(String object) {
                selected = object;
                ZipVo zipVo = DataService.zipSet.get(object);
                if (null != zipVo) {
                    values = String.format("%s - %s", zipVo.getZip(), zipVo.getCity());

                } else {
                    values = "A keresett elem nem található'";
                }
            }

            @Override
            public void detach() {
            }
        };

        final AutoCompleteTextField<String> field = new AutoCompleteTextField<String>("ac", model) {
            @Override
            protected Iterator<String> getChoices(String input) {
                if (Strings.isEmpty(input)) {
                    List<String> emptyList = Collections.emptyList();
                    return emptyList.iterator();
                }

                List<String> result = new ArrayList<>();
                for (String zip : DataService.zipSet.keySet()) {
                    if (zip.startsWith(input)) {
                        result.add(zip);
                    }
                }


                return result.iterator();
            }
        };
        form.add(field);

        final MultiLineLabel label = new MultiLineLabel("selectedValue", new PropertyModel<String>(this,
                "values"));
        label.setOutputMarkupId(true);
        form.add(label);

        field.add(new AjaxFormSubmitBehavior(form, "change") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                target.add(label);
                visibleResult(target);
            }

            @Override
            protected void onError(AjaxRequestTarget target) {
            }
        });
    }
}