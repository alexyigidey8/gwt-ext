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

package com.gwtext.sample.showcase.client.grid;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.Grid;
import com.gwtext.client.widgets.grid.Renderer;
import com.gwtext.sample.showcase.client.SampleData;

public class Grid1Panel extends Composite {

    private boolean init = false;
    private VerticalPanel vp;

    public Grid1Panel() {
        vp = new VerticalPanel();
        vp.setSpacing(15);
        initWidget(vp);
    }

    protected void onLoad() {
        if (!init) {
            init = true;
            setup();
        }
    }

    private void setup() {
        //create a grid from an array
        MemoryProxy proxy = new MemoryProxy(SampleData.getArrayGridData());
        RecordDef recordDef = new RecordDef(
                new Field[]{
                        new StringField("company"),
                        new FloatField("price"),
                        new FloatField("change"),
                        new FloatField("pctChange"),
                        new DateField("lastChanged", "n/j h:ia")
                }
        );

        //sample record
        Record record = recordDef.createRecord(new Object[]{"3m Co", new Double(71.72), new Double(0.02), new Double(0.03), "9/1 12:00am"});

        ArrayReader reader = new ArrayReader(recordDef);
        Store store = new Store(proxy, reader);
        store.load();

        //edit a couple of rows programatically
        Record rec1 = store.getAt(0);
        rec1.set("company", "i2");

        Record rec5 = store.getAt(4);
        rec5.set("company", "SAP");

        //retreive modified rows
        Record[] modified = store.getModifiedRecords();

        //setup column model
        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                new ColumnConfig() {
                    {
                        setHeader("Company");
                        setWidth(160);
                        setSortable(true);
                        setLocked(false);
                        setDataIndex("company");
                    }
                },
                new ColumnConfig() {
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
                new ColumnConfig() {
                    {
                        setId("change");
                        setHeader("Change");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("change");
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("% Change");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("pctChange");
                    }
                }
        });

        //create and render grid
        Grid grid = new Grid("grid-example1", "600px", "300px", store, columnModel);
        grid.render();

        vp.setWidth("100%");
        vp.setHeight("100%");
        vp.add(grid);
    }
}