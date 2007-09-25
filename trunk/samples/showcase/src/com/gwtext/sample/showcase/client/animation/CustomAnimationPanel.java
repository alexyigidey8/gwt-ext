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
package com.gwtext.sample.showcase.client.animation;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.GenericConfig;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.ButtonConfig;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class CustomAnimationPanel extends ShowcaseExampleVSD {

    public String getDataUrl() {
        return null;
    }

    public String getSourceUrl() {
        return "animation/CustomAnimationPanel.java.html";
    }

    public Panel getViewPanel() {

        HTML demo = new HTML("Demo");
        final ExtElement el = new ExtElement(demo.getElement());
        el.setStyle("background", "#ccc");
        el.setStyle("overflow", "hidden");
        el.setStyle("width", "200px");

        Button button = new Button(new ButtonConfig() {
            {
                setText("Run");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        GenericConfig animArgs = new GenericConfig();

                        GenericConfig widthArgs = new GenericConfig();
                        widthArgs.setProperty("from", 600);
                        widthArgs.setProperty("to", 0);

                        animArgs.setProperty("width", widthArgs);
                        el.animate(animArgs);

                    }
                });
            }
        });
        Panel panel = createPanel();
        panel.add(new HTML("<h1>Basic Animation</h1>"));
        panel.add(new HTML("<p>This demonstrates how to apply a simple animation effect to an HTML Element. Click the button to begin the demo.</p>"));

        panel.add(demo);
        panel.add(button); 

        return panel;
    }
}