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

import com.gwtext.client.core.TextAlign;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class LocalXmlGridSample extends ShowcasePanel {

   public String getSourceUrl() {
        return "source/grid/LocalXmlGridSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            
            StringBuffer xml = new StringBuffer();
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            xml.append("<catalog> ");

            xml.append("<plant> ");
            xml.append("<common>Bloodroot</common> ");
            xml.append("<botanical>Caltha palustris</botanical> ");
            xml.append("<zone>4</zone> ");
            xml.append("<light>Mostly Shady</light> ");
            xml.append("<price>2.44</price> ");
            xml.append("<availability>03/15/2006</availability> ");
            xml.append("<indoor>true</indoor> ");
            xml.append("</plant> ");

            xml.append("<plant> ");
            xml.append("<common>Marsh Marigold</common> ");
            xml.append("<botanical>Sanguinaria canadensis</botanical> ");
            xml.append("<zone>1</zone> ");
            xml.append("<light>Mostly Sunny</light> ");
            xml.append("<price>6.45</price> ");
            xml.append("<availability>07/12/2007</availability> ");
            xml.append("<indoor>false</indoor> ");
            xml.append("</plant> ");

            xml.append("</catalog> ");

            XmlReader reader = new XmlReader("plant", new RecordDef(
                    new FieldDef[]{
                            new StringFieldDef("common"),
                            new StringFieldDef("botanical"),
                            new StringFieldDef("light"),
                            new FloatFieldDef("price"),
                            new DateFieldDef("availDate", "availability", "m/d/Y"),
                            new BooleanFieldDef("indoor")
                    }
            ));

            final Store store = new Store(reader);
            store.loadXmlData(xml.toString(), true);

            //setup column model
            ColumnConfig commonCol = new ColumnConfig("Common Name", "common", 120, true, null, "common");
            ColumnConfig lightCol = new ColumnConfig("Light", "light", 130);

            ColumnConfig priceCol = new ColumnConfig("Price", "price", 70, true);
            priceCol.setAlign(TextAlign.RIGHT);
            priceCol.setRenderer(new Renderer() {
                public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                    return "$" + value;
                }
            });
            ColumnConfig availableCol = new ColumnConfig("Available", "availDate", 95, true);

            ColumnConfig indoorCol = new ColumnConfig("Indoor?", "indoor", 55);
            indoorCol.setRenderer(new Renderer() {
                public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                    boolean checked = ((Boolean) value).booleanValue();
                    return "<img class=\"checkbox\" src=\"../ext/2.0.2/resources/images/default/menu/" + (checked ? "checked.gif" : "unchecked.gif") + "\"/>";
                }
            });

            ColumnConfig[] columnConfigs = {
                    commonCol,
                    lightCol,
                    priceCol,
                    availableCol,
                    indoorCol
            };

            ColumnModel columnModel = new ColumnModel(columnConfigs);
            columnModel.setDefaultSortable(true);

            GridPanel grid = new GridPanel();
            grid.setStore(store);
            grid.setColumnModel(columnModel);
            grid.setTitle("Local XML Grid");
            grid.setWidth(500);
            grid.setHeight(350);
            grid.stripeRows(true);
            grid.setFrame(true);
            grid.setAutoExpandColumn("common");
            grid.setIconCls("grid-icon");


            panel.add(grid);
        }
        return panel;
    }

    public String getIntro() {
        return "In this example a Grid is loaded using local XML String data.";
    }
}