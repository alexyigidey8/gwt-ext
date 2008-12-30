/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 
package com.gwtext.sample.showcase2.client.grid;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.PagingToolbar;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.ToolTip;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.event.FieldListenerAdapter;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.SampleGrid;
import com.gwtext.sample.showcase2.client.ShowcasePanel;
import com.gwtextux.client.data.PagingMemoryProxy;

public class LocalPagingSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/grid/LocalPagingSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            PagingMemoryProxy proxy = new PagingMemoryProxy(SampleData.getCompanyDataLarge());
            RecordDef recordDef = new RecordDef(
                    new FieldDef[]{
                            new StringFieldDef("company"),
                            new FloatFieldDef("price"),
                            new FloatFieldDef("change"),
                            new FloatFieldDef("pctChange"),
                            new DateFieldDef("lastChanged", "n/j h:ia"),
                            new StringFieldDef("symbol"),
                            new StringFieldDef("industry")
                    }
            );

            ArrayReader reader = new ArrayReader(recordDef);
            final Store store = new Store(proxy, reader, true);


            final GridPanel grid = new SampleGrid();
            grid.setStore(store);
            grid.setWidth(600);
            grid.setHeight(250);
            grid.setTitle("Grid that pages Local / In-Memory data");
            grid.setAutoExpandColumn("pctChange");

            final PagingToolbar pagingToolbar = new PagingToolbar(store);
            pagingToolbar.setPageSize(5);
            pagingToolbar.setDisplayInfo(true);
            pagingToolbar.setDisplayMsg("Displaying companies {0} - {1} of {2}");
            pagingToolbar.setEmptyMsg("No records to display");

            NumberField pageSizeField = new NumberField();
            pageSizeField.setWidth(40);
            pageSizeField.setSelectOnFocus(true);
            pageSizeField.addListener(new FieldListenerAdapter() {
                public void onSpecialKey(Field field, EventObject e) {
                    if (e.getKey() == EventObject.ENTER) {
                        int pageSize = Integer.parseInt(field.getValueAsString());
                        pagingToolbar.setPageSize(pageSize);
                    }
                }
            });

            ToolTip toolTip = new ToolTip("Enter page size");
            toolTip.applyTo(pageSizeField);

            pagingToolbar.addField(pageSizeField);
            grid.setBottomToolbar(pagingToolbar);
            store.load(0, 5);

            panel.add(grid);
        }

        return panel;
    }

    public String getIntro() {
        return "This example demonstrates loading a Grid with local array data and local paging. It also demonstrates how to change " +
                "the page size dymanically. Enter a value in number field on the Paging Toolbar and hit Enter.";
    }
}