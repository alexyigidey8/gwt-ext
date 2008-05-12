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
 
package com.gwtext.sample.showcase2.client.combo;

import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;
import com.gwtextux.client.data.PagingMemoryProxy;

/**
 * ComboBox with paging dropdown.
 */
public class ComboBoxPagingSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/combo/ComboBoxPagingSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            MemoryProxy proxy = new PagingMemoryProxy(SampleData.getCompanyDataLarge());
            RecordDef recordDef = new RecordDef(
                    new FieldDef[]{
                            new StringFieldDef("company"),
                            new FloatFieldDef("price"),
                            new FloatFieldDef("change"),
                            new FloatFieldDef("pctChange"),
                            new DateFieldDef("lastChanged", "n/j h:ia")
                    }
            );

            ArrayReader reader = new ArrayReader(recordDef);
            final Store store = new Store(proxy, reader);
            store.load();

            ComboBox cb = new ComboBox();
            cb.setMinChars(1);
            cb.setFieldLabel("Company");
            cb.setStore(store);
            cb.setDisplayField("company");
            cb.setMode(ComboBox.REMOTE);
            cb.setTriggerAction(ComboBox.ALL);
            cb.setEmptyText("Enter company");
            cb.setLoadingText("Searching...");
            cb.setTypeAhead(true);
            cb.setSelectOnFocus(true);
            cb.setWidth(250);
            cb.setPageSize(10);

            FormPanel form = new FormPanel();
			form.setLabelWidth(70);
			form.setBorder(false);
            form.add(cb);

            panel.add(form);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>In this sample the entries in ComboBox dropdown provide paging capabilities. The page size and display of the entries are fully customizable.</p>" +
                "<p>Data for the CombBox is loaded from a Store which can be populated using local or remote data.</p>";
    }
}