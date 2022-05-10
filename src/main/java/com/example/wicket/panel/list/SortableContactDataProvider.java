package com.example.wicket.panel.list;


import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import java.io.Serializable;
import java.util.Iterator;


/**
 * implementation of IDataProvider for contacts that keeps track of sort information
 *
 * @author igor
 */
public abstract class SortableContactDataProvider<T> extends SortableDataProvider<T, String> implements IFilterStateLocator<ContactFilter>, Serializable {
    private ContactFilter contactFilter = new ContactFilter();
    protected Long size;
    private int pageSize = 20;
    private Iterator<T> lastResponse;

    /**
     * constructor
     */


    public SortableContactDataProvider(int pageSize) {
        this();
        this.pageSize = pageSize;
    }

    public SortableContactDataProvider() {
        // set default sort
        setSort("firstName", SortOrder.ASCENDING);
    }

    @Override
    public Iterator<T> iterator(long first, long count) {
        if (null != lastResponse) {
            Iterator<T> result = lastResponse;
            lastResponse = null;
            return result;
        }
        return getData(first, pageSize);
    }

    abstract public Iterator<T> getData(long first, long count);

    @Override
    public long size() {
        if (size == null) {
            lastResponse = getData(0, pageSize);
        }
        return size;
    }

    @Override
    public IModel<T> model(T object) {
        return new DetachableContactModel<T>(object);
    }

    @Override
    public ContactFilter getFilterState() {
        return contactFilter;
    }

    @Override
    public void setFilterState(ContactFilter state) {
        contactFilter = state;
    }
}