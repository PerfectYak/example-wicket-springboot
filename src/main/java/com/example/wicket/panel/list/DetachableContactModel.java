package com.example.wicket.panel.list;

import org.apache.wicket.model.LoadableDetachableModel;

/**
 * detachable model for an instance of contact
 *
 * @author igor
 */
public class DetachableContactModel<T> extends LoadableDetachableModel<T> {
    private Long counter = 0L;
    private final long id;
    private T user;

    /**
     * @param c
     */
    public DetachableContactModel(T c) {
        synchronized (counter) {
            id = counter++;
        }
        user = c;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).hashCode();
    }

    /**
     * used for dataview with ReuseIfModelsEqualStrategy item reuse strategy
     *
     * @see org.apache.wicket.markup.repeater.ReuseIfModelsEqualStrategy
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof DetachableContactModel) {
            DetachableContactModel other = (DetachableContactModel) obj;
            return other.id == id;
        }
        return false;
    }

    /**
     * @see LoadableDetachableModel#load()
     */
    @Override
    protected T load() {
        // loads contact from the database
        return user;
    }
}