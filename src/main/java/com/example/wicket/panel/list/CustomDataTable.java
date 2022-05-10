package com.example.wicket.panel.list;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackHeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.OddEvenItem;
import org.apache.wicket.model.IModel;

import java.util.List;

public class CustomDataTable<T, S> extends DataTable<T, S> {

    /**
     * Constructor
     *
     * @param id           component id
     * @param iColumns     list of columns
     * @param dataProvider data provider
     * @param rowsPerPage
     */
    public CustomDataTable(String id, List<? extends IColumn<T, S>> iColumns, ISortableDataProvider<T, S> dataProvider, int rowsPerPage) {
        super(id, iColumns, dataProvider, rowsPerPage);
        setOutputMarkupId(true);
        setVersioned(false);
//        addTopToolbar(new BobeNavigationToolbar(this));
        addTopToolbar(new AjaxFallbackHeadersToolbar(this, dataProvider));
//        addBottomToolbar(new NoRecordsToolbar(this));
//        addBottomToolbar(new AjaxFallbackHeadersToolbar(this, dataProvider));
//        addBottomToolbar(new BobeNavigationToolbar(this));

    }


    @Override
    protected Item<T> newRowItem(final String id, final int index, final IModel<T> model) {
        return new OddEvenItem<>(id, index, model);
    }


}
