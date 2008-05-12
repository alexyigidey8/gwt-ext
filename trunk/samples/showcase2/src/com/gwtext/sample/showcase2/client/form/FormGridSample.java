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
 
package com.gwtext.sample.showcase2.client.form;

import com.gwtext.client.core.Function;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.PaddedPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.RowSelectionModel;
import com.gwtext.client.widgets.grid.event.RowSelectionListenerAdapter;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.sample.showcase2.client.SampleGrid;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class FormGridSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/form/FormGridSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final FormPanel formPanel = new FormPanel();
            formPanel.setFrame(true);
            formPanel.setLabelAlign(Position.LEFT);
            formPanel.setPaddings(5);
            formPanel.setWidth(650);

            Panel inner = new Panel();
            inner.setLayout(new ColumnLayout());

            Panel columnOne = new Panel();
            columnOne.setLayout(new FitLayout());

            GridPanel gridPanel = new SampleGrid(false, new int[]{0, 1, 2, 3, 4});
            gridPanel.setHeight(300);
            gridPanel.setTitle("Company Data");

            final RowSelectionModel sm = new RowSelectionModel(true);
            sm.addListener(new RowSelectionListenerAdapter() {
                public void onRowSelect(RowSelectionModel sm, int rowIndex, Record record) {
                    formPanel.getForm().loadRecord(record);
                }
            });
            gridPanel.setSelectionModel(sm);

            //select the first row after a little delay so that the rows are rendered
            gridPanel.doOnRender(new Function() {
                public void execute() {
                    sm.selectFirstRow();
                }
            }, 10);

            columnOne.add(gridPanel);
            inner.add(columnOne, new ColumnLayoutData(0.6));

            FieldSet fieldSet = new FieldSet();
            fieldSet.setLabelWidth(90);
            fieldSet.setTitle("Company Details");
            fieldSet.setAutoHeight(true);
            fieldSet.setBorder(false);

            //the field names msut match the data field values from the Store
            fieldSet.add(new TextField("Name", "company", 120));
            fieldSet.add(new TextField("Price", "price", 120));
            fieldSet.add(new TextField("% Change", "pctChange", 120));
            fieldSet.add(new DateField("Last Updated", "lastChanged", 120));
            inner.add(new PaddedPanel(fieldSet, 0, 10, 0, 0), new ColumnLayoutData(0.4));

            formPanel.add(inner);
            panel.add(formPanel);
        }

        return panel;
    }

    public String getIntro() {
        return "<p>This example edmonstrates the fact that by virtue of inheriting from the <b>Container</b>" +
                " class, a FormPanel can contain any <b>Component</b>. This includes all the subclasses of Panel, " +
                "including the GridPanel</p>" +
                "<p>This example also demonstrates how data from a Store can be bound to a Grid and a Form.</p>";
    }
}