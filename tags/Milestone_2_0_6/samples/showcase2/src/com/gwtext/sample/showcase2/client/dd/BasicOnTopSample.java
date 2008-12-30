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
 
package com.gwtext.sample.showcase2.client.dd;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.dd.DD;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class BasicOnTopSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/dd/BasicOnTopSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            HorizontalPanel horizontalPanel = new HorizontalPanel();
            horizontalPanel.setSpacing(15);

            Panel panel1 = new Panel();
            panel1.setTitle("Panel1");
            panel1.setBorder(true);
            panel1.setBodyStyle("background-color:#6D739A");
            panel1.setWidth(200);
            panel1.setHtml(SampleData.getShortBogusMarkup());

            Panel panel2 = new Panel();
            panel2.setTitle("Panel2");
            panel2.setBodyStyle("background-color:#566F4E");
            panel2.setBorder(true);
            panel2.setWidth(200);
            panel2.setHtml(SampleData.getShortBogusMarkup());

            Panel panel3 = new Panel();
            panel3.setTitle("Panel3");
            panel3.setBodyStyle("background-color:#7E5B60");
            panel3.setBorder(true);
            panel3.setWidth(200);
            panel3.setHtml(SampleData.getShortBogusMarkup());

            DD dd1 = new DDOnTop(panel1);
            DD dd2 = new DDOnTop(panel2);
            DD dd3 = new DDOnTop(panel3);

            horizontalPanel.add(panel1);
            horizontalPanel.add(panel2);
            horizontalPanel.add(panel3);

            panel.add(horizontalPanel);
        }

        return panel;
    }

    class DDOnTop extends DD {
        private int origZ = 0;


        DDOnTop(Component component) {
            super(component);
        }

        public void startDrag(int x, int y) {
            int zIndex = DOM.getIntStyleAttribute(this.getEl(), "zIndex");
            if(zIndex != 0) {
                origZ = zIndex;
            }
            DOM.setIntStyleAttribute(this.getEl(), "zIndex", 999);
        }

        public void endDrag(EventObject e) {
            DOM.setIntStyleAttribute(DDOnTop.this.getEl(), "zIndex", origZ);
        }
    }

    protected boolean showEvents() {
        return true;
    }

    public String getIntro() {
        return "<p>This example builds on the basic drag and drop, keeping the dragged element on top of the others by changing its z-index property during the drag.</p>";
    }
}