/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.wicket.panel.list;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxNavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;

/**
 * Toolbar that displays links used to navigate the pages of the datatable as well as a message
 * about which rows are being displayed and their total number in the data table.
 *
 * @author Igor Vaynberg (ivaynberg)
 */
public class BobeNavigationToolbar extends AjaxNavigationToolbar {

    /**
     * Constructor.
     *
     * @param table data table this toolbar will be attached to
     */
    public BobeNavigationToolbar(DataTable<?, ?> table) {
        super(table);
    }

    protected PagingNavigator newPagingNavigator(final String navigatorId,
                                                 final DataTable<?, ?> table) {
        return new BobePagingNavigator(navigatorId, table);
    }
}
