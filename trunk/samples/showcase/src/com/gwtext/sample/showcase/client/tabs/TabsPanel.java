/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.sample.showcase.client.tabs;

import com.google.gwt.user.client.ui.*;
import com.gwtext.client.core.Ext;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.TabPanelItem;
import com.gwtext.client.widgets.event.TabPanelItemListenerAdapter;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.*;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.Renderer;
import com.gwtext.sample.showcase.client.SampleData;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class TabsPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "tabs/TabsPanel.java.html";
    }

    public Panel getViewPanel() {

        final TabPanel tp = new TabPanel("tab-1");
        tp.setResizeTabs(true);
        tp.setMinTabWidth(20);

        TabPanelItem tpi = tp.addTab("tpi1", "First Tab", false);

        MemoryProxy proxy = new MemoryProxy(SampleData.getCompanyData());
        ArrayReader reader = new ArrayReader(new RecordDef(
                new FieldDef[]{
                        new StringFieldDef("company"),
                        new FloatFieldDef("price"),
                        new FloatFieldDef("change"),
                        new FloatFieldDef("pctChange"),
                        new DateFieldDef("lastChanged", "n/j h:ia")
                }
        ));

        Store store = new Store(proxy, reader);

        ColumnModel columnModel = new ColumnModel(new com.gwtext.client.widgets.grid.ColumnConfig[]{
                new com.gwtext.client.widgets.grid.ColumnConfig() {
                    {
                        setHeader("Company");
                        setWidth(160);
                        setSortable(true);
                        setLocked(false);
                        setDataIndex("company");
                    }
                },
                new com.gwtext.client.widgets.grid.ColumnConfig() {
                    {
                        setHeader("Price");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("price");
                        setRenderer(new Renderer() {
                            public String render(Object value, Record record, int rowIndex, int colNum) {
                                return "$" + value;
                            }
                        });

                    }
                },
                new com.gwtext.client.widgets.grid.ColumnConfig() {
                    {
                        setId("change");
                        setHeader("Change");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("change");
                    }
                },
                new com.gwtext.client.widgets.grid.ColumnConfig() {
                    {
                        setHeader("% Change");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("pctChange");
                    }
                }
        });

        com.gwtext.client.widgets.grid.Grid grid = new com.gwtext.client.widgets.grid.Grid("grid-example1", "600px", "300px", store, columnModel);
        grid.render();
        store.load();

        Button button = new Button("GWT Button");
        button.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                MessageBox.alert("Button Click", "From GWT events");
            }
        });

        Hyperlink link = new Hyperlink("Add a new Tab", "foo");
        link.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                String id = Ext.generateId();
                TabPanelItem temp = tp.addTab(id, "dyn-" + id, true);
                temp.setContent("Some content for dynamically created tab ... ", true);
            }
        });
        VerticalPanel fp = new VerticalPanel();
        RootPanel.get().add(fp);
        fp.add(link);
        fp.add(grid);
        fp.add(button);
        tpi.setContent(fp);

        TabPanelItem tpi2 = tp.addTab("tpi12", "Some other Tab", true);
        tpi2.addTabPanelItemListener(new TabPanelItemListenerAdapter() {
            public void onActivate(TabPanelItem tab) {
                MessageBox.alert("Tab Activated", "Tab '" + tab.getText() + "' activated.");
            }
        });

        VerticalPanel tpi2Panel = new VerticalPanel();
        tpi2Panel.setSpacing(15);
        Form form = getForm();
        tpi2Panel.add(form);
        tpi2.setContent(tpi2Panel);

        tp.activate(0);

        Panel vp = createPanel();
        vp.add(tp);

        return vp;

    }

    private Form getForm() {
        Form form = new Form(new FormConfig() {
            {
                setWidth(500);
                setHeader("Simple Form");
                setLabelWidth(75);
                setUrl("foobar.php");
                setSurrondWithBox(true);
            }
        });
        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("First Name");
                setName("first");
                setWidth(175);
                setAllowBlank(false);
            }
        }));

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Last Name");
                setName("last");
                setWidth(175);
            }
        }));

        form.add(new DateField(new DateFieldConfig() {
            {
                setDisabledDays(new int[]{0, 4});
                setFieldLabel("Sample Date");
                setValue("05/07/07");
            }
        }));

        form.addButton("Save");
        form.addButton("Cancel");
        form.render();
        return form;
    }
}