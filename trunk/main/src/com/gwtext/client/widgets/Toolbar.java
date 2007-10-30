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

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.form.Field;

public class Toolbar extends RequiredElementWidget {

    protected Toolbar() {
    }

    public Toolbar(String id) {
        super(id);
    }

    public Toolbar(ExtElement container) {
        jsObj = create(container);
    }

    public Toolbar(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new $wnd.Ext.Toolbar(id);
    }-*/;

    protected native JavaScriptObject create(ExtElement container) /*-{
        var el = container.@com.gwtext.client.core.JsObject::jsObj;
        return new $wnd.Ext.Toolbar(el);
    }-*/;

    public void addButton(ToolbarButton button) {
        JavaScriptObject addedButtonJS = addButton(jsObj, button.getJsObj(), button.getId());
        button.registerEventHandlers();
        button.setJsObj(addedButtonJS);
        button.setRendered(true);
    }

    public void addButton(ToolbarMenuButton button) {
        JavaScriptObject addedButtonJS = addButton(jsObj, button.getJsObj(), button.getId());
        button.registerEventHandlers();
        button.setJsObj(addedButtonJS);
        button.setRendered(true);
    }

    private native JavaScriptObject addButton(JavaScriptObject toolbar, JavaScriptObject button, String id) /*-{
        var btn = toolbar.addButton(button);
        var btnEl = btn.el.child("button:first");
        //set the button id's now that the buttons have been rendered to the DOM by the toolbar
        if(id != null) {
            btnEl.id = id;
            btnEl.dom.id = id;
        }
        return btn;
    }-*/;

    public native void addElement(String html) /*-{
        var toolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        toolbar.addElement(html);
    }-*/;

    public void addField(Field field) {
        addField(jsObj, field.getJsObj());
    }

    private static native void addField(JavaScriptObject toolbar, JavaScriptObject field)/*-{
        toolbar.addField(field);
    }-*/;

    //http://extjs.com/forum/showthread.php?t=2470
    public native void addFill() /*-{
        var toolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        toolbar.addFill();
    }-*/;

    public native void addItem(ToolbarItem item) /*-{
        var toolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var itemJS = item.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        toolbar.addItem(itemJS);
    }-*/;

    public native Element addSeparator() /*-{
        var toolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var separator = toolbar.addSeparator();
        return separator.getEl();
    }-*/;

    public native Element addSpacer() /*-{
        var toolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var spacer = toolbar.addSpacer();
        return spacer.getEl();
    }-*/;

    public native void addText(String text) /*-{
        var toolbar = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        toolbar.addText(text);
    }-*/;

    public void insertItem(int index, ToolbarItem item) {
        insertButton(jsObj, index, item.getJsObj());
    }

    private native void insertButton(JavaScriptObject toolbar, int index, JavaScriptObject item) /*-{
        toolbar.insertButton(index, item);
    }-*/;

    public void insertButton(int index, ToolbarButton button) {
        insertButton(jsObj, index, button.getJsObj());
    }
}
