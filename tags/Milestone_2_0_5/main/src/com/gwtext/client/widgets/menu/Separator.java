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

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Adds a separator bar to a menu, used to divide logical groups of menu items.
 *
 * @author Sanjiv Jivan
 */
public class Separator extends BaseItem {
	
    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.menu.Separator();
        @com.gwtext.client.widgets.menu.Separator::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}
	
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.menu.Separator();
    }-*/;

    /**
     * The default CSS class to use for separator items (defaults to "x-menu-sep).
     *
     * @param itemCls the item CSS class
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setItemCls(String itemCls) throws IllegalStateException {
        setAttribute("itemCls", itemCls, true);
    }

    /**
     * The default CSS class to use for separator items (defaults to "x-menu-sep").
     *
     * @return the default CSS class to use for text items
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public String getItemCls() throws IllegalStateException {
        return JavaScriptObjectHelper.getAttribute(config, "itemCls");
    }	
}
